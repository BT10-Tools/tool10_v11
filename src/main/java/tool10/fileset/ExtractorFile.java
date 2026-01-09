package tool10.fileset;

import tool10.blobset.FileSetBlobGetter;
import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.FileUtil;

public class ExtractorFile {

	private static boolean setFileAttributes(NodeFile nodeFile, String fileName) {
		return(false);
	}
	private static String getNewFileName(NodeFile nodeFile, String targetDirName) {
		//String parentDirName = ((nodeFile.getDirNameRelative()==null) || (nodeFile.getDirNameRelative().isEmpty())) ? "" : "\\"+nodeFile.getDirNameRelative();
		//String parentDirName = ((nodeFile.getDirNameRelative()==null) || (nodeFile.getDirNameRelative().isEmpty())) ? "" : "\\"+nodeFile.getDirNameRelative();
		if ((nodeFile.getRefFileName()==null) || (nodeFile.getRefFileName().getFileNameRelative()==null)) return (null); 
		String fileName = targetDirName + "\\" + nodeFile.getRefFileName().getFileNameRelative();
		//targetDirName + parentDirName + "\\"+nodeFile.getFileName();
		//System.out.println("ExtractorFile getNewFileName  fileName: "+fileName);
		return(fileName);
	}
	private static String createOneFile(NodeFileSet fileSet, NodeFile nodeFile, String targetDirName) {
		if (!"true".equals(nodeFile.getIsFile())) return(null);
		String fileName = getNewFileName(nodeFile, targetDirName); 
		String writeStatus = FileSetBlobGetter.writeBlob2File(fileSet,nodeFile,fileName);
		if ("ok".equals(writeStatus)) {
			System.out.println("ExtractorFile exportOneFile created file: "+fileName);
			setFileAttributes(nodeFile,fileName);
			return(fileName);
		} else {return(null);}
	}
	private static String createOneDirectory(NodeFileSet fileSet, NodeFile nodeFile, String targetDirName) {
		System.out.println("ExtractorFile createOneDirectory processing directory: "+nodeFile.getFileNameAbsolute());
		if (!"true".equals(nodeFile.getIsDirectory())) return(null);
		String dirName = getNewFileName(nodeFile, targetDirName);
		if (dirName==null) return(null);
		System.out.println("ExtractorFile createOneDirectory processing dirName: "+dirName);
		boolean created = FileUtil.createNestedDirectory(dirName);
		if (created) {
			System.out.println("ExtractorFile exportOneDirectory created directory: "+dirName);
			return(dirName);
		} else {return(null);}
		
	}
	private static void extractAllFiles(NodeF10 f10) {
		//first create the directories 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			System.out.println("ExtractorFile extractAllFiles processing directory: "+nodeFile.getFileNameAbsolute());
			if (!"true".equals(nodeFile.getIsDirectory())) continue;
			createOneDirectory(f10.getFileSet(), nodeFile, f10.getCliParams().getDir());
		} 
		//then create the files 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			System.out.println("ExtractorFile extractAllFiles processing file: "+nodeFile.getFileNameAbsolute());
			if (!"true".equals(nodeFile.getIsFile())) continue;
			createOneFile(f10.getFileSet(), nodeFile, f10.getCliParams().getDir());
		} 
	}
	public static void extractFileSetFile(NodeF10 f10)	{
		System.out.println("ExtractorFile extractFileSetFile fileSetId: "+f10.getFileSet().getFileSetId()+" , number of files/directories:"+f10.getFileSet().getListFile().size());
		extractAllFiles(f10);		 
	}
}
