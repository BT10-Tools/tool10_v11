package tool10.imageset;

import tool10.f10.NodeF10;

public class ProcessImageSet {

	public static void updateImageBlobBytes(NodeImageBlob imageBlob, byte[] imageBytes)	{
		if ((imageBytes==null) || (imageBytes.length==0)) return;
		imageBlob.setImageBytes(imageBytes);
	}
	private static void UpdateSizeXYOneImage(NodeF10 f10, NodeImage image)	{
		if (image.getImageFile()==null) return;
		Long sizeX = 0l; 
		Long sizeY = 0l;
		int[] sizeXY = ImageEngineJava.getImageSizeXY(image.getImageFile().getSourceAbsolutePath());
		if ((sizeXY!=null) && (sizeXY.length>1))	{
			sizeX = (long) sizeXY[0]; 
			sizeY = (long) sizeXY[1];
		}
		Long pixelNum = ((sizeX!=null) && (sizeY!=null)) ? (sizeX.longValue() * sizeY.longValue()) : -1l;  
		image.setSizeX(sizeX);
		image.setSizeY(sizeY);
		image.setPixelNum(pixelNum);	
	}
	
	public static void processImageSet(NodeF10 f10)	{
		for (NodeImage image : f10.getImageSet().getListImage())	{
			UpdateSizeXYOneImage(f10, image);
		}
		for (NodeImageBlob imageBlob : f10.getImageSet().getListImageBlob())	{
			byte[] imageBytes = null; // FileUtil.getBytes(filename);
			updateImageBlobBytes(imageBlob, imageBytes);
		}
	}	
	
}
