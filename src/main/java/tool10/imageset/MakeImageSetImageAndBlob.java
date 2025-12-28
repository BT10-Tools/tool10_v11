package tool10.imageset;

import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.GetByMapFileSet;

public class MakeImageSetImageAndBlob {

	public static NodeImageBlob createOneImageBlobFromImage(NodeF10 f10, NodeImage image, Long fileBlobId)	{
		Long imageBlobId = f10.getConnImage().getNextId(-1); //"IMG_IMAGEBLOB");
		String imageType = null;  
		String blobType = "filebytes"; 
		byte[] imageBytes = null; // FileUtil.getBytes(filename);
		Long imageSize = (imageBytes!=null) ? (long) imageBytes.length : -1;
		Long crc64 = null; 
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		
		//public NodeImageBlob(Long imageBlobId, Long imageId, String imageType, String blobType, Long imageSize, byte[] imageBytes, Long crc64,ZonedDateTime creationDate) {
		NodeImageBlob imageBlob = new NodeImageBlob(imageBlobId, image.getImageId(), fileBlobId, imageType, blobType, imageSize, imageBytes, crc64, creationDate, modificationDate);
		f10.getImageSet().getListImageBlob().add(imageBlob);
		f10.getImageSet().getMapId2ImageBlob().put(imageBlob.getImageBlobId(), imageBlob);
		image.setImageBlob(imageBlob);
		return(imageBlob);		
	}	
	public static NodeImage createOneImageFromFile(NodeF10 f10, NodeImageFile imageFile)	{ 
		Long imageId = f10.getConnImage().getNextId(-1); //"IMG_IMAGE"
		String imageName = imageFile.getSourceFileName();
		Long sizeX = 0l; 
		Long sizeY = 0l;
		int[] sizeXY = ImageEngineJava.getImageSizeXY(imageFile.getSourceAbsolutePath());
		if ((sizeXY!=null) && (sizeXY.length>1))	{
			sizeX = (long) sizeXY[0]; 
			sizeY = (long) sizeXY[1];
		}
		Long pixelNum = ((sizeX!=null) && (sizeY!=null)) ? (sizeX.longValue() * sizeY.longValue()) : -1l;  
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeImage(Long imageId, Long imageSetId, Long sourceImageId, String imageName, String imageType, String imageSizeType,
		//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate) {
		NodeImage image = new NodeImage(imageId, imageFile.getImageSetId(), imageFile.getImageFileId(), null, imageName, null, null, sizeX, sizeY, pixelNum, creationDate, modificationDate);
		f10.getImageSet().getListImage().add(image);
		f10.getImageSet().getMapId2Image().put(image.getImageId(), image);
		image.setImageFile(imageFile);
		return(image);
	}
	public static void createImageAndBlob(NodeF10 f10)	{
		for (NodeImageFile imageFile : f10.getImageSet().getListImageFile())	{
			Long fileBlobId = GetByMapFileSet.getFileBlobId4ImageFile(f10,imageFile.getFileId()); 
			NodeImage image = createOneImageFromFile(f10, imageFile);
			NodeImageBlob imageBlob = createOneImageBlobFromImage(f10,image, fileBlobId);
		}
	}	
	
}
