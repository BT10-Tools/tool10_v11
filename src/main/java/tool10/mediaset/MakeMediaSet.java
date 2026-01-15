package tool10.mediaset;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;

public class MakeMediaSet {

	public static NodeMediaProp createOneMediaProp(NodeF10 f10, Long mediaId, String mediaPropType,
			String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
			Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,String[] valueStringArray)	{
		
		Long mediaPropId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGEBLOB");
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		
		//public NodeMediaProp(Long mediaPropId, Long mediaId, Long mediaSetId, String mediaPropType,
		//String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
		//Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,
		//String[] valueStringArray, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeMediaProp mediaProp = new NodeMediaProp(mediaPropId, mediaId, f10.getMediaSet().getMediaSetId(), mediaPropType,
				engineName, propKeyGroup, propKey, propValue, displayOrder, valueLong, valueDouble, valueBoolean, valueZDT, 
				valueBytes, valueStringArray, creationDate, modificationDate);
		f10.getMediaSet().getListMediaProp().add(mediaProp);
		f10.getMediaSet().getMapId2MediaProp().put(mediaProp.getMediaPropId(), mediaProp);
		return(mediaProp);		
	}
	public static NodeMediaBlob createOneMediaBlob(NodeF10 f10, Long mediaId, String mediaType, String blobType, byte[] mediaBytes, Long fileBlobId)	{
		Long mediaBlobId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGEBLOB");
		Long mediaSize = (mediaBytes!=null) ? (long) mediaBytes.length : -1;
		Long crc64 = null; 
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		
		//public NodeMediaBlob(Long mediaBlobId, Long mediaId, Long mediaSetId, Long fileBlobId, String mediaType, String blobType, Long mediaSize, 
		//byte[] mediaBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeMediaBlob mediaBlob = new NodeMediaBlob(mediaBlobId, mediaId, f10.getMediaSet().getMediaSetId(), fileBlobId, mediaType, blobType, 
				mediaSize, mediaBytes, crc64, creationDate, modificationDate);
		f10.getMediaSet().getListMediaBlob().add(mediaBlob);
		f10.getMediaSet().getMapId2MediaBlob().put(mediaBlob.getMediaBlobId(), mediaBlob);
		return(mediaBlob);		
	}	
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
	private static String[] extArrayImage = new String[] {"png","jpg"};
	private static String[] extArrayVideo = new String[] {"mp4","mkv","webm"};
	private static String[] extArrayAudio = new String[] {"mp3"};
	
	private static String getMediaType(String extensionName, String fileName)	{
		String mediaType = null;
		//there must be further investigation of the file , here only extensionName is analyzed
		for (String strImage : extArrayImage) { if (strImage.equals(extensionName)) return("image");	}
		for (String strVideo : extArrayVideo) { if (strVideo.equals(extensionName)) return("video");	}
		for (String strAudio : extArrayAudio) { if (strAudio.equals(extensionName)) return("audio");	}
		return(mediaType);
	}
	public static ArrayList<NodeFile> getFileList4MediaFromFileSet(NodeF10 f10,String mediaType)	{
		
		ArrayList<NodeFile> fileList4Media = new ArrayList<NodeFile>(); 
		
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getRefFileProp().getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			if (!"video".equals(getMediaType(nodeFile.getExtensionName(), nodeFile.getFileNameAbsolute()))) continue; 
			if (cnt++ > 100) break; //for test purpose, only process 100 files
			
			fileList4Media.add(nodeFile);
		}
		System.out.println("MakeMediaSet getFileList4MediaFromFileSet fileList4Media.size() = "+fileList4Media.size());
		return(fileList4Media);
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
		System.out.println("printAllListsAndMaps: mediaSet.getListMediaProp().size() = " + mediaSet.getListMediaProp().size());
		System.out.println("printAllListsAndMaps: mediaSet.getListVideo().size() = " + mediaSet.getListVideo().size());
		System.out.println("printAllListsAndMaps: mediaSet.getListAudio().size() = " + mediaSet.getListAudio().size());		
	}
	public static NodeMediaSet makeMediaSetFromFileSet(NodeF10 f10, String mediaType)	{
		NodeMediaSet mediaSet = null;
		String mediaSetName = f10.getCliParams().getMediaSetName();
		String sourceDir = null;
		mediaSet = createOneMediaSet(f10.getConnMedia(), f10.getFileSet().getFileSetId(),mediaSetName,sourceDir);
		f10.setMediaSet(mediaSet);
		System.out.println("MakeMediaSet makeMediaSetFromFileSet mediaSet = "+mediaSet);
		
		ArrayList<NodeFile> fileList4Media = getFileList4MediaFromFileSet(f10, mediaType);
		createMediaFilesFromFileList(f10, fileList4Media);
				
		//ReadTagTablesFromDb.postProcessImageSet(tagSet);
		
		printAllListsAndMaps(mediaSet);
		
		return(mediaSet);
	}
	
}
