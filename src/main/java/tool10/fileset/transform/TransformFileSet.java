package tool10.fileset.transform;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import tool10.fileset.MakeFileSet;
import tool10.fileset.MakeFileSetFile;
import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;

public class TransformFileSet {

	private static String[] transformExtensionArray = new String[] {"jpg"}; //,"png"}; //,"mhtml","mp4"};
	private static HashSet<String> transformExtensionSet = new  HashSet<String>();
	private static Random rnd; 
	static {
		for (String ext : transformExtensionArray)	{
			transformExtensionSet.add(ext);
		}
		rnd = new Random();
	}
	
	private static NodeTransform createOneTransformFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, NodeFile nodeFile)	{
		Long transformId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
		Long transformedFileId = null;
		String transformType = null;
		String extensionType = null; 
		String algorithmName = null;
		String transformRemark = null;
		String tmpFileName = null;
		Long cntFile = null;
		Long originalFileSize = nodeFile.getFileSize();
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
		//Long transformedFileId, String transformType, String extensionType, String algorithmName,
		//String transformRemark, Long cntFile, Long originalFileSize, Long transformedFileSize,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeTransform nodeTransform = new NodeTransform(transformId, outputFileSet.getFileSetId(), nodeFile.getFileId(), fileSet.getFileSetId(), 
				transformedFileId,transformType,extensionType,algorithmName,transformRemark,tmpFileName,cntFile, originalFileSize, null, creationDate,null);
		outputFileSet.getListTransform().add(nodeTransform);
		outputFileSet.getMapId2Transform().put(nodeTransform.getTransformId(),nodeTransform);
		return(nodeTransform);
	}
	private static boolean isArchiveFile(String fileNameAbsolute, String extensionName)	{
		if (extensionName==null) return(false);
		//if  (ZipUtil.isValidZipFile(fileNameAbsolute)) return(true);
		
		boolean archiveFile = false;
		archiveFile = transformExtensionSet.contains(extensionName);
		return(archiveFile);
	}
	private static ArrayList<NodeFile> getTransformFileList(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapTransformFile)	{
		 ArrayList<NodeFile> transformFileList = new ArrayList<NodeFile>(); 
		 for (NodeFile nodeFile : fileSet.getListFile())	{
			 if (mapTransformFile.contains(nodeFile)) continue;  //this file already checked
			 mapTransformFile.add(nodeFile);
			 if (!isArchiveFile(nodeFile.getFileNameAbsolute(), nodeFile.getExtensionName())) continue; //nm0
			 transformFileList.add(nodeFile);
			 System.out.println("UnzipFileSet getTransformFileList added file for enembedding:"+nodeFile.getFileNameAbsolute());
		 }
		 System.out.println("UnzipFileSet getTransformFileList number of archive files added getTransformFileList.size():"+transformFileList.size());
		 return (transformFileList);
	}
	private static void transformAllFiles(NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> transformFileList, 
			NodeFileSet outputFileSet, String fileSetTmpDirName)	{
		int cnt = 0;
		for (NodeFile nodeFile: transformFileList)	{
			NodeTransform nodeTransform = createOneTransformFile(f10, fileSet, outputFileSet, nodeFile);
			String fileTmpDirName = fileSetTmpDirName + "\\z" + Long.toString(nodeFile.getFileId()) + "_" + rnd.nextInt(1000*1000,10000*1000-1);
	
			TransformFile.transformOneFile(f10, fileSet, outputFileSet, nodeTransform, nodeFile, fileTmpDirName);
			if ((cnt++) > 20) break;  //for test, only do some
		}
		MakeFileSetFile.createFilesForRootDirectory(f10, outputFileSet, fileSetTmpDirName);
		System.out.println("TransformFileSet transformAllFiles transform filess in fileSet fileSet.getFileSetId():"+fileSet.getFileSetId() + 
			", outputFileSet.getListFile().size():"+outputFileSet.getListFile().size());
		for (NodeTransform nodeTransform : outputFileSet.getListTransform())	{
			if (nodeTransform.getTmpFileName()==null) continue;
			NodeFile nodeFile = outputFileSet.getMapAbsoluteFileName2File().get(nodeTransform.getTmpFileName());
			if (nodeFile==null) continue;
			nodeTransform.setTransformedFileId(nodeFile.getFileId());
		}
	}
	private static String tmpDirName = "C:\\tmp\\similarity\\07_Transform";
	
	private static void transformOneFileSet(NodeF10 f10, NodeFileSet fileSet, HashSet<NodeFile> mapTransformFile)	{
		ArrayList<NodeFile> transformFileList = getTransformFileList(f10, fileSet, mapTransformFile);  
		if (transformFileList.size()<=0)	{
			System.out.println("TransformFileSet transformOneFileSet no transform files in fileSet ["+fileSet.getFileSetName()+"], returning"); 
		} 
		NodeFileSet outputFileSet = MakeFileSet.createOneFileSet(f10.getConn10(), f10.getCliParams().getOutputFileSetName(), null, fileSet.getFileSetId()); 
		f10.setOutputFileSet(outputFileSet);
		
		String fileSetTmpDirName = tmpDirName + File.separator + "FS"+fileSet.getFileSetId()+ "_" + rnd.nextInt(10000,100000-1);; 
		
		transformAllFiles(f10, fileSet,transformFileList, outputFileSet, fileSetTmpDirName);
	}
	private static void recursivelyTransformFileSet(NodeF10 f10, NodeFileSet outputFileSet, HashSet<NodeFile> mapTransformFile)	{
		if (outputFileSet==null) return;	
		ArrayList<NodeFile> transformFileList = getTransformFileList(f10, outputFileSet, mapTransformFile);  
		if (transformFileList.size()==0) return;
		System.out.println("TransformFileSet recursivelyTransformFileSet TransformFileList.size():"+transformFileList.size()); 
		transformAllFiles(f10, outputFileSet,transformFileList, outputFileSet, tmpDirName);
		
		//recursively call, when archiveFileList.size()==0 it will return back   
		recursivelyTransformFileSet(f10, f10.getOutputFileSet(), mapTransformFile);
	}
	public static void transformFileSet(NodeF10 f10, NodeFileSet fileSet)	{
		System.out.println("TransformFileSet transformFileSet transforming files in the fileSet");
		
		HashSet<NodeFile> mapTransformFile = new HashSet<NodeFile>();
		transformOneFileSet(f10, fileSet, mapTransformFile)	;
		
		recursivelyTransformFileSet(f10, f10.getOutputFileSet(), mapTransformFile);
	}
}
