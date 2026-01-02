package tool10.mediaset;

import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.GetByMapFileSet;

public class MakeMediaSetImageAndBlob {

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
	public static NodeMediaBlob createOneMediaBlobFromImage(NodeF10 f10, NodeImage image, Long fileBlobId)	{
		Long mediaId = image.getImageId();
		String mediaType = "image";  
		String blobType = "imagebytes"; 
		byte[] mediaBytes = null; // FileUtil.getBytes(filename);

		NodeMediaBlob mediaBlob = createOneMediaBlob(f10, mediaId, mediaType, blobType, mediaBytes, fileBlobId);
		image.setMediaBlob(mediaBlob);
		return(mediaBlob);		
	}	
	public static NodeImage createOneImageFromFile(NodeF10 f10, NodeMediaFile mediaFile)	{ 
		Long imageId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGE"
		String imageName = mediaFile.getSourceFileName();
		Long sizeX = 0l; 
		Long sizeY = 0l;
		int[] sizeXY = ImageEngineJava.getImageSizeXY(mediaFile.getSourceAbsolutePath());
		if ((sizeXY!=null) && (sizeXY.length>1))	{
			sizeX = (long) sizeXY[0]; 
			sizeY = (long) sizeXY[1];
		}
		Long pixelNum = ((sizeX!=null) && (sizeY!=null)) ? (sizeX.longValue() * sizeY.longValue()) : -1l;  
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeImage(Long imageId, Long imageSetId, Long sourceImageId, String imageName, String imageType, String imageSizeType,
		//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate) {
		NodeImage image = new NodeImage(imageId, mediaFile.getMediaSetId(), mediaFile.getMediaFileId(), null, imageName, null, null, sizeX, sizeY, pixelNum, creationDate, modificationDate);
		f10.getMediaSet().getListImage().add(image);
		f10.getMediaSet().getMapId2Image().put(image.getImageId(), image);
		image.setMediaFile(mediaFile);
		return(image);
	}
	public static void createImageAndBlob(NodeF10 f10)	{
		for (NodeMediaFile mediaFile : f10.getMediaSet().getListMediaFile())	{
			Long fileBlobId = GetByMapFileSet.getFileBlobId4ImageFile(f10,mediaFile.getFileId()); 
			NodeImage image = createOneImageFromFile(f10, mediaFile);
			NodeMediaBlob mediaBlob = createOneMediaBlobFromImage(f10,image, fileBlobId);
		}
	}	
	
}
