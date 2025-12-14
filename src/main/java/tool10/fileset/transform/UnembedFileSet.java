package tool10.fileset.transform;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import tool10.fileset.MakeFileSet;
import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.FileUtil;

public class UnembedFileSet {

	private static String[] containerExtensionArray = new String[] {"pdf"}; //,"mhtml","mp4"};
	private static HashSet<String> containerExtensionSet = new  HashSet<String>();
	private static Random rnd; 
	static {
		for (String ext : containerExtensionArray)	{
			containerExtensionSet.add(ext);
		}
		rnd = new Random();
	}
	
	private static NodeContainer createOneContainerFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, NodeFile nodeFile)	{
		Long containerId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
		String containerType = null;
		String extensionType = null; 
		String algorithmName = null;
		String containerRemark = null;
		Long cntFile = null;
		Long originalFileSize = nodeFile.getFileSize();
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
		//		String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
		//		Long originalFileSize,,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeContainer nodeContainer = new NodeContainer(containerId, outputFileSet.getFileSetId(), nodeFile.getFileId(), fileSet.getFileSetId(), 
				containerType,extensionType,algorithmName,containerRemark,cntFile, originalFileSize,creationDate,null);
		outputFileSet.getListContainer().add(nodeContainer);
		outputFileSet.getMapId2Container().put(nodeContainer.getContainerId(),nodeContainer);
		return(nodeContainer);
	}
	private static boolean isArchiveFile(String fileNameAbsolute, String extensionName)	{
		if (extensionName==null) return(false);
		//if  (ZipUtil.isValidZipFile(fileNameAbsolute)) return(true);
		
		boolean archiveFile = false;
		archiveFile = containerExtensionSet.contains(extensionName);
		return(archiveFile);
	}
	private static ArrayList<NodeFile> getContainerFileList(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapContainerFile)	{
		 ArrayList<NodeFile> containerFileList = new ArrayList<NodeFile>(); 
		 for (NodeFile nodeFile : fileSet.getListFile())	{
			 if (mapContainerFile.contains(nodeFile)) continue;  //this file already checked
			 mapContainerFile.add(nodeFile);
			 if (!isArchiveFile(nodeFile.getFileNameAbsolute(), nodeFile.getExtensionName())) continue; //nm0
			 containerFileList.add(nodeFile);
			 System.out.println("UnzipFileSet getContainerFileList added file for enembedding:"+nodeFile.getFileNameAbsolute());
		 }
		 System.out.println("UnzipFileSet getContainerFileList number of archive files added getContainerFileList.size():"+containerFileList.size());
		 return (containerFileList);
	}
	private static void unembedAllFiles(NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> containerFileList, NodeFileSet outputFileSet, String tmpDirName)	{
		for (NodeFile nodeFile: containerFileList)	{
			NodeContainer nodeContainer = createOneContainerFile(f10, fileSet, outputFileSet, nodeFile);
			String fileTmpDirName = tmpDirName + "\\z" + Long.toString(nodeFile.getFileId()) + "_" + rnd.nextInt(1000*1000,10000*1000-1);
	
			UnembedFile.unembedOneContainerFile(f10, fileSet, outputFileSet, nodeContainer, nodeFile, fileTmpDirName);				
			
		}
	}
	private static String tmpDirName = "C:\\tmp\\similarity\\06_Unembed";
	
	private static void unembedOneFileSet(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapContainerFile)	{
		ArrayList<NodeFile> containerFileList = getContainerFileList(f10, fileSet, mapContainerFile);  
		if (containerFileList.size()<=0)	{
			System.out.println("UnzipFileSet enembedOneFileSet no archive files in fileSet ["+fileSet.getFileSetName()+"], returning"); 
		} 
		NodeFileSet outputFileSet = MakeFileSet.createOneFileSet(f10.getConn10(), f10.getCliParams().getOutputFileSetName(), null, fileSet.getFileSetId()); 
		f10.setOutputFileSet(outputFileSet);
		
		unembedAllFiles(f10, fileSet,containerFileList, outputFileSet, tmpDirName);
	}
	private static void recursivelyUnembedFileSet(NodeF10 f10, NodeFileSet outputFileSet, HashSet<NodeFile> mapContainerFile)	{
		if (outputFileSet==null) return;	
		ArrayList<NodeFile> containerFileList = getContainerFileList(f10, outputFileSet, mapContainerFile);  
		if (containerFileList.size()==0) return;
		System.out.println("UnzipFileSet recursivelyUnembedFileSet containerFileList.size():"+containerFileList.size()); 
		unembedAllFiles(f10, outputFileSet,containerFileList, outputFileSet, tmpDirName);
		
		//recursively call, when archiveFileList.size()==0 it will return back   
		recursivelyUnembedFileSet(f10, f10.getOutputFileSet(), mapContainerFile);
	}
	public static void unembedFileSet(NodeF10 f10, NodeFileSet fileSet)	{
		System.out.println("UnembedFileSet unembedFileSet unembedding container files in the fileSet");
		
		HashSet<NodeFile> mapContainerFile = new HashSet<NodeFile>();
		unembedOneFileSet(f10, fileSet, mapContainerFile)	;
		
		recursivelyUnembedFileSet(f10, f10.getOutputFileSet(), mapContainerFile);
	}
}
