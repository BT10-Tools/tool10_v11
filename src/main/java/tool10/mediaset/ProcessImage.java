package tool10.mediaset;

import tool10.f10.NodeF10;

public class ProcessImage {

	public static void updateMediaBlobBytes(NodeMediaBlob mediaBlob, byte[] mediaBytes)	{
		if ((mediaBytes==null) || (mediaBytes.length==0)) return;
		mediaBlob.setMediaBytes(mediaBytes);
	}
	private static void UpdateSizeXYOneImage(NodeF10 f10, NodeImage image)	{
		if (image.getMediaFile()==null) return;
		Long sizeX = 0l; 
		Long sizeY = 0l;
		int[] sizeXY = ImageEngineJava.getImageSizeXY(image.getMediaFile().getSourceAbsolutePath());
		if ((sizeXY!=null) && (sizeXY.length>1))	{
			sizeX = (long) sizeXY[0]; 
			sizeY = (long) sizeXY[1];
		}
		Long pixelNum = ((sizeX!=null) && (sizeY!=null)) ? (sizeX.longValue() * sizeY.longValue()) : -1l;  
		image.setSizeX(sizeX);
		image.setSizeY(sizeY);
		image.setPixelNum(pixelNum);	
	}
	
	public static void processMediaSet(NodeF10 f10)	{
		for (NodeImage image : f10.getMediaSet().getListImage())	{
			UpdateSizeXYOneImage(f10, image);
		}
		for (NodeMediaBlob mediaBlob : f10.getMediaSet().getListMediaBlob())	{
			byte[] mediaBytes = null; // FileUtil.getBytes(filename);
			updateMediaBlobBytes(mediaBlob, mediaBytes);
		}
	}	
	
}
