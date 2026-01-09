package tool10.mediaset;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;

public class MakeImageSet {

	public static void createOneMediaFileFromFile(NodeF10 f10,NodeFile nodeFile)	{
		Long mediaFileId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGEFILE"
		Long mediaId = null; 
		String mediaFileType = nodeFile.getFileType();  
        String sourceAbsolutePath = nodeFile.getFileNameAbsolute();
        String sourceDirName = nodeFile.getRefFileName().getDirNameAbsolute(); 
        String sourceFileName = nodeFile.getFileName();
		//String sourceFileName = shortFilename;
        String sourceExtensionName = nodeFile.getExtensionName(); 
        Long sourceFileSize =null; 
		
		ZonedDateTime sourceFileCreationDate = nodeFile.getRefFileProp().getFileCreationDate();
		ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeMediaFile(Long mediaFileId, Long mediaId, Long fileId, Long mediaSetId, String mediaFileType, String sourceAbsolutePath, String sourceDirName, 
		//String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
  		NodeMediaFile mediaFile = new NodeMediaFile(mediaFileId, mediaId, nodeFile.getFileId(), f10.getMediaSet().getMediaSetId(), mediaFileType, sourceAbsolutePath, 
  				sourceDirName,sourceFileName,sourceExtensionName,sourceFileSize,sourceFileCreationDate, creationDate,modificationDate);  		
  		f10.getMediaSet().getListMediaFile().add(mediaFile);
	    f10.getMediaSet().getMapId2MediaFile().put(mediaFile.getMediaFileId(),mediaFile);  		
	}
	public static void createMediaFilesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Image)	{
		for (NodeFile nodeFile : fileList4Image)	{
			createOneMediaFileFromFile(f10,nodeFile);
		}
	}
	public static ArrayList<NodeFile> getFileList4ImageFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Image = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getRefFileProp().getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			if (cnt++ > 100) break; //for test purpose, only process 100 files
			
			fileList4Image.add(nodeFile);
		}
		System.out.println("MakeImageSet getFileList4ImageFromFileSet 	fileList4Image.size() = "+fileList4Image.size());
		return(fileList4Image);
	}
	private static NodeMediaSet createOneMediaSet(Conn10 connMedia,Long fileSetId,String mediaSetName,String sourceDir)	{
		NodeMediaSet mediaSet = null;
		Long mediaSetId = connMedia.getNextId(-1); //"IMG_IMAGESET");
		
		String mediaSetDesc = mediaSetName+"_DESC"; 
		String sourceName = sourceDir;
		String sourceURL = sourceDir;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeMediaSet(Long mediaSetId, Long fileSetId, String mediaSetName, String mediaSetDesc, String sourceName,
		//String sourceURL, Long cntMedia, Long sumMediaSize, Double avgMediaSize, Long sourceFileSize,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		mediaSet = new NodeMediaSet(mediaSetId,fileSetId,mediaSetName,mediaSetDesc, sourceName, sourceURL, null,null,null,null,creationDate,modificationDate);
		return(mediaSet);
	}
	public static void printAllListsAndMaps(NodeMediaSet mediaSet)	{
		System.out.println("printAllListsAndMaps: mediaSet.getListImage().size() = " + mediaSet.getListImage().size());
		System.out.println("printAllListsAndMaps: mediaSet.getListMediaFile().size() = " + mediaSet.getListMediaFile().size());

		System.out.println("printAllListsAndMaps: mediaSet.getListImage().size() = " + mediaSet.getListImage().size());
		System.out.println("printAllListsAndMaps: mediaSet.getListMediaFile().size() = " + mediaSet.getListMediaFile().size());
		System.out.println("printAllListsAndMaps: mediaSet.getListMediaBlob().size() = " + mediaSet.getListMediaBlob().size());
	}
	public static NodeMediaSet makeMediaSetFromFileSet(NodeF10 f10)	{
		NodeMediaSet mediaSet = null;
		String mediaSetName = f10.getCliParams().getMediaSetName();
		String sourceDir = null;
		mediaSet = createOneMediaSet(f10.getConnMedia(), f10.getFileSet().getFileSetId(),mediaSetName,sourceDir);
		f10.setMediaSet(mediaSet);
		System.out.println("MakeImageSet makeMediaSetFromFileSet mediaSet = "+mediaSet);
		
		ArrayList<NodeFile> fileList4Image = getFileList4ImageFromFileSet(f10);
		createMediaFilesFromFileList(f10, fileList4Image);
				
		//ReadTagTablesFromDb.postProcessImageSet(tagSet);
		
		printAllListsAndMaps(mediaSet);
		
		return(mediaSet);
	}
	
}
