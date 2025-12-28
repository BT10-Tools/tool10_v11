package tool10.fileset.transform;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import tool10.f10.NodeF10;
import tool10.fileset.MakeFileSet;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;


public class UnzipFileSet {

	private static String[] archiveExtensionArray = new String[] {"zip","rar","7z","jar"};
	private static HashSet<String> archiveExtensionSet = new  HashSet<String>();
	private static Random rnd; 
	static {
		for (String ext : archiveExtensionArray)	{
			archiveExtensionSet.add(ext);
		}
		rnd = new Random();
	}
	
	private static NodeArchive createOneArchiveFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, NodeFile nodeFile)	{
		Long archiveId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
		String extensionType = null; 
		Long originalFileSize = nodeFile.getFileSize();
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, 
		//String extensionType, Long originalFileSize, ZonedDateTime creationDate) {
		NodeArchive nodeArchive = new NodeArchive(archiveId, outputFileSet.getFileSetId(), nodeFile.getFileId(), fileSet.getFileSetId(), 
				extensionType,originalFileSize, creationDate);
		outputFileSet.getListArchive().add(nodeArchive);
		outputFileSet.getMapId2Archive().put(nodeArchive.getArchiveId(),nodeArchive);
		return(nodeArchive);
	}
	private static boolean isArchiveFile(String fileNameAbsolute, String extensionName)	{
		if (extensionName==null) return(false);
		//if  (ZipUtil.isValidZipFile(fileNameAbsolute)) return(true);
		
		boolean archiveFile = false;
		archiveFile = archiveExtensionSet.contains(extensionName);
		return(archiveFile);
	}
	private static ArrayList<NodeFile> getArchiveFileList(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapArchiveFile)	{
		 ArrayList<NodeFile> archiveFileList = new ArrayList<NodeFile>(); 
		 for (NodeFile nodeFile : fileSet.getListFile())	{
			 if (mapArchiveFile.contains(nodeFile)) continue;  //this file already checked
			 mapArchiveFile.add(nodeFile);
			 if (!isArchiveFile(nodeFile.getFileNameAbsolute(), nodeFile.getExtensionName())) continue; //nm0
			 archiveFileList.add(nodeFile);
			 System.out.println("UnzipFileSet getArchiveFileList added file for unzipping:"+nodeFile.getFileNameAbsolute());
		 }
		 System.out.println("UnzipFileSet getArchiveFileList number of archive files added archiveFileList.size():"+archiveFileList.size());
		 return (archiveFileList);
	}
	private static void unzipAllFiles(NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> archiveFileList, NodeFileSet outputFileSet, String tmpDirName)	{
		for (NodeFile nodeFile: archiveFileList)	{
			NodeArchive nodeArchive = createOneArchiveFile(f10, fileSet, outputFileSet, nodeFile);
			String fileTmpDirName = tmpDirName + "\\z" + Long.toString(nodeFile.getFileId()) + "_" + rnd.nextInt(1000*1000,10000*1000-1);
			char[] password = null;
			
			UnzipFile.unzipOneArchiveFile(f10, fileSet, outputFileSet, nodeArchive, nodeFile, fileTmpDirName, password);			
		}
	}
	private static String tmpDirName = "C:\\tmp\\similarity\\05_Unzip";
	
	private static void unzipOneFileSet(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapArchiveFile)	{
		ArrayList<NodeFile> archiveFileList = getArchiveFileList(f10, fileSet, mapArchiveFile);  
		if (archiveFileList.size()<=0)	{
			System.out.println("UnzipFileSet unzipOneFileSet no archive files in fileSet ["+fileSet.getFileSetName()+"], returning"); 
		} 
		NodeFileSet outputFileSet = MakeFileSet.createOneFileSet(f10.getConn10(), f10.getCliParams().getOutputFileSetName(), null, fileSet.getFileSetId()); 
		f10.setOutputFileSet(outputFileSet);
		
		unzipAllFiles(f10, fileSet,archiveFileList, outputFileSet, tmpDirName);
	}
	private static void recursivelyUnzipFileSet(NodeF10 f10, NodeFileSet outputFileSet, HashSet<NodeFile> mapArchiveFile)	{
		if (outputFileSet==null) return;	
		ArrayList<NodeFile> archiveFileList = getArchiveFileList(f10, outputFileSet, mapArchiveFile);  
		if (archiveFileList.size()==0) return;
		System.out.println("UnzipFileSet recursivelyUnzipFileSet archiveFileList.size():"+archiveFileList.size()); 
		unzipAllFiles(f10, outputFileSet,archiveFileList, outputFileSet, tmpDirName);
		
		//recursively call, when archiveFileList.size()==0 it will return back   
		recursivelyUnzipFileSet(f10, f10.getOutputFileSet(), mapArchiveFile);
	}
	public static void unzipFileSet(NodeF10 f10, NodeFileSet fileSet)	{
		System.out.println("UnzipFileSet unzipFileSet unzipping archive files in the fileSet");
		
		HashSet<NodeFile> mapArchiveFile = new HashSet<NodeFile>();
		unzipOneFileSet(f10, fileSet, mapArchiveFile)	;
		
		recursivelyUnzipFileSet(f10, f10.getOutputFileSet(), mapArchiveFile);
	}
}
