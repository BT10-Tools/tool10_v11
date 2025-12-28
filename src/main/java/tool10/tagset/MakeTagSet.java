package tool10.tagset;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;

public class MakeTagSet {

	public static void createOneTagFileFromFile(NodeF10 f10,NodeFile nodeFile)	{
		
		Long tagFileTypeId = null; //createOneTagFileType(f10,nodeFile.getFileNameAbsolute(), tikaConfig);
		
		Long tagFileId = f10.getConnTag().getNextId(-1); //"TAG_TAGFILE"
		Long tagSetId = f10.getTagSet().getTagSetId();
    	Long sourceId = nodeFile.getFileId(); 
        String sourceAbsolutePath = nodeFile.getFileNameAbsolute();
        String sourceDirName = nodeFile.getDirNameAbsolute(); 
        String sourceFileName = nodeFile.getFileName();
		//String sourceFileName = shortFilename;
        String sourceExtensionName = nodeFile.getExtensionName();
        Long sourceFileSize =null; 
		
		ZonedDateTime sourceFileCreationDate = nodeFile.getCreationDate();
		ZonedDateTime sourceFileModificationDate = null; 
	    ZonedDateTime creationDate = ZonedDateTime.now();	
	    NodeTagFile tagFile = new NodeTagFile(tagFileId,tagSetId,tagFileTypeId,sourceId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
	    		sourceFileSize,sourceFileCreationDate,sourceFileModificationDate, creationDate);
	    f10.getTagSet().getListTagFile().add(tagFile);
	    f10.getTagSet().getMapId2TagFile().put(tagFile.getTagFileId(),tagFile);  
	    
	}
	public static void createTagFilesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Tag)	{
		for (NodeFile nodeFile : fileList4Tag)	{
			createOneTagFileFromFile(f10,nodeFile);
		}
	}
	public static ArrayList<NodeFile> getFileList4TagsFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Tag = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			if (cnt++ > 100) break; //for test purpose, only process 100 files
			
			fileList4Tag.add(nodeFile);
		}
		System.out.println("MakeTagSet getFileList4TagsFromFileSet 	fileList4Tag.size() = "+fileList4Tag.size());
		return(fileList4Tag);
	}
	private static NodeTagSet createOneTagSet(Conn10 connTag,Long fileSetId, String tagSetName,String sourceDir)	{
		NodeTagSet tagSet = null;
		Long tagSetId = connTag.getNextId(-1); //"TAG_TAGSET");
		String tagSetDescription = tagSetName+"_DESC"; 
		String sourceURL = sourceDir;
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeTagSet(Long tagSetId, Long fileSetId, String tagSetName, String tagSetDescription, String sourceName, String sourceURL,ZonedDateTime creationDate) {
		tagSet = new NodeTagSet(tagSetId,fileSetId,tagSetName,tagSetDescription, sourceDir, sourceURL,creationDate);
		return(tagSet);
	}
	
	public static NodeTagSet makeTagSetFromFileSet(NodeF10 f10)	{
		NodeTagSet tagSet = null;
		String tagSetName = f10.getCliParams().getTagSetName();
		String sourceDir = null;
		tagSet = createOneTagSet(f10.getConnTag(), f10.getFileSet().getFileSetId(),tagSetName,sourceDir);
		f10.setTagSet(tagSet);
		System.out.println("sqlite tagSet = "+tagSet);
		
		ArrayList<NodeFile> fileList4Tag = getFileList4TagsFromFileSet(f10);
		createTagFilesFromFileList(f10, fileList4Tag);
		
	///	TikaConfig tikaConfig = TikaUtil.getTikaConfig();
	///	MakeTagSetProcess.processTagFiles(f10, tikaConfig);
		
		//ReadTagTablesFromDb.postProcessImageSet(tagSet);
		
		System.out.println("makeTagSetFromSource: tagSet.getListTag().size() = " + tagSet.getListTag().size());
		System.out.println("makeTagSetFromSource: tagSet.getListTagFile().size() = " + tagSet.getListTagFile().size());
		System.out.println("makeTagSetFromSource: tagSet.getListTagFileType().size() = " + tagSet.getListTagFileType().size());
		
		return(tagSet);
	}
}
