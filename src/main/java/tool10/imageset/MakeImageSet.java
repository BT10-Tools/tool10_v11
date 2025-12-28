package tool10.imageset;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;

public class MakeImageSet {

	public static void createOneImageFileFromFile(NodeF10 f10,NodeFile nodeFile)	{
		Long imageFileId = f10.getConnImage().getNextId(-1); //"IMG_IMAGEFILE"
		Long imageId = null; 
        String sourceAbsolutePath = nodeFile.getFileNameAbsolute();
        String sourceDirName = nodeFile.getDirNameAbsolute(); 
        String sourceFileName = nodeFile.getFileName();
		//String sourceFileName = shortFilename;
        String sourceExtensionName = nodeFile.getExtensionName(); 
        Long sourceFileSize =null; 
		
		ZonedDateTime sourceFileCreationDate = nodeFile.getFileCreationDate();
		ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeImageFile(Long imageFileId, Long imageId, Long fileId, Long imageSetId, String sourceAbsolutePath, String sourceDirName, String sourceFileName,
  		//String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,ZonedDateTime creationDate) {
  		NodeImageFile imageFile = new NodeImageFile(imageFileId, imageId, nodeFile.getFileId(), f10.getImageSet().getImageSetId(), sourceAbsolutePath, 
  				sourceDirName,sourceFileName,sourceExtensionName,sourceFileSize,sourceFileCreationDate, creationDate,modificationDate);  		
  		f10.getImageSet().getListImageFile().add(imageFile);
	    f10.getImageSet().getMapId2ImageFile().put(imageFile.getImageFileId(),imageFile);  		
	}
	public static void createImageFilesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Image)	{
		for (NodeFile nodeFile : fileList4Image)	{
			createOneImageFileFromFile(f10,nodeFile);
		}
	}
	public static ArrayList<NodeFile> getFileList4ImageFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Image = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			if (cnt++ > 100) break; //for test purpose, only process 100 files
			
			fileList4Image.add(nodeFile);
		}
		System.out.println("MakeImageSet getFileList4ImageFromFileSet 	fileList4Image.size() = "+fileList4Image.size());
		return(fileList4Image);
	}
	private static NodeImageSet createOneImageSet(Conn10 connImage,Long fileSetId,String imageSetName,String sourceDir)	{
		NodeImageSet imageSet = null;
		Long imageSetId = connImage.getNextId(-1); //"IMG_IMAGESET");
		
		String imageSetDescription = imageSetName+"_DESC"; 
		String sourceName = sourceDir;
		String sourceURL = sourceDir;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeImageSet(Long imageSetId, Long fileSetId, String imageSetName, String imageSetDescription, String sourceName,
		//String sourceURL, Long cntImage, Long sumImageSize, Double avgImageSize, Long sourceFileSize,ZonedDateTime creationDate) {
		imageSet = new NodeImageSet(imageSetId,fileSetId,imageSetName,imageSetDescription, sourceName, sourceURL, null,null,null,null,creationDate,modificationDate);
		return(imageSet);
	}
	public static void printAllListsAndMaps(NodeImageSet imageSet)	{
		System.out.println("printAllListsAndMaps: imageSet.getListImage().size() = " + imageSet.getListImage().size());
		System.out.println("printAllListsAndMaps: imageSet.getListImageFile().size() = " + imageSet.getListImageFile().size());

		System.out.println("printAllListsAndMaps: imageSet.getListImage().size() = " + imageSet.getListImage().size());
		System.out.println("printAllListsAndMaps: imageSet.getListImageFile().size() = " + imageSet.getListImageFile().size());
		System.out.println("printAllListsAndMaps: imageSet.getListImageBlob().size() = " + imageSet.getListImageBlob().size());

	}
	public static NodeImageSet makeImageSetFromFileSet(NodeF10 f10)	{
		NodeImageSet imageSet = null;
		String imageSetName = f10.getCliParams().getImageSetName();
		String sourceDir = null;
		imageSet = createOneImageSet(f10.getConnImage(), f10.getFileSet().getFileSetId(),imageSetName,sourceDir);
		f10.setImageSet(imageSet);
		System.out.println("MakeImageSet makeImageSetFromFileSet imageSet = "+imageSet);
		
		ArrayList<NodeFile> fileList4Image = getFileList4ImageFromFileSet(f10);
		createImageFilesFromFileList(f10, fileList4Image);
				
		//ReadTagTablesFromDb.postProcessImageSet(tagSet);
		
		printAllListsAndMaps(imageSet);
		
		return(imageSet);
	}
	
}
