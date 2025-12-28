package tool10.imageset;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageEngineJava {

	 // convert Image to BufferedImage
    public static BufferedImage convertToBufferedImage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bi.createGraphics();
        graphics2D.drawImage(img, 0, 0, null);
        graphics2D.dispose();

        return bi;
    }
	public static Image getImageFromFile(String fileName)	{ 
		Image imgA = null;
		try {
	        File fileA = new File(fileName);
	        // Reading file
	        imgA = ImageIO.read(fileA);
	    } catch (IOException e) {
	        System.out.println(e);
	    }
	    return (imgA);
	}
	public static BufferedImage getBufferedImageFromFile(String fileName)	{ 
		BufferedImage imgA = null;
		//Image image  = null;
		try {
	        File fileA = new File(fileName);
	        // Reading file
	        imgA = ImageIO.read(fileA);
	    } catch (IOException e) {
	        //System.out.println(e);
	    }
	    return (imgA);
	}

	public static int[] getImageSizeXY(String fileName)	{
		if (fileName==null) return(null);
		int[] sizeXY = new int[] {0,0};
    	BufferedImage imgA = getBufferedImageFromFile(fileName);
    	if (imgA==null) return(null);
    	
    	// Assigning dimensions to image
    	sizeXY[0] = imgA.getWidth();
    	sizeXY[1] = imgA.getHeight();
    	imgA.flush();
    	return(sizeXY);
    }
	
	//******
	public static BufferedImage deepCopy(BufferedImage bi) {
		//https://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
	    ColorModel cm = bi.getColorModel();
	    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
	    WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
	    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	public static BufferedImage cloneBufferedImage (BufferedImage bufImg)	{
		BufferedImage cloneBuffImg = deepCopy(bufImg);
		//it will be written
		return(cloneBuffImg);
	}
	public static BufferedImage convertBufferedImage2Grayscale(BufferedImage bufImg)	{
		if (bufImg==null) return(null);
        // get image's width and height
        int width = bufImg.getWidth();
        int height = bufImg.getHeight();
        int[] pixels = bufImg.getRGB(0, 0, width, height, null, 0, width);
        
        // convert to grayscale
        for (int i = 0; i < pixels.length; i++) {

        	// Here i denotes the index of array of pixels
            // for modifying the pixel value.
            int p = pixels[i];

            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;

            // calculate average
            int avg = (r + g + b) / 3;

            // replace RGB value with avg
            p = (a << 24) | (avg << 16) | (avg << 8) | avg;

            pixels[i] = p;
        }
        BufferedImage grayImg = cloneBufferedImage(bufImg);
        grayImg.setRGB(0, 0, width, height, pixels, 0, width);
        return(grayImg);
	}
	public static BufferedImage scaleBufferedImage(BufferedImage bufImg, double scaleWH)	{
		return(scaleBufferedImage(bufImg,scaleWH,scaleWH));
	}
	public static BufferedImage scaleBufferedImage(BufferedImage bufImg, double scaleW, double scaleH)	{
		if (bufImg==null) return(null);
		if ((scaleW <0.1d) || (scaleW > 10.0d) || (scaleH <0.1d) || (scaleH > 10.0d)) return (null); 
		//double scaleW = 2.0f, scaleH = 2.0f;
		int w = bufImg.getWidth() * (int) scaleW;
		int h = bufImg.getHeight() * (int) scaleH;
		BufferedImage dstImg = new BufferedImage(w, h, bufImg.getType());
		return(dstImg);		
	}
	public static int writeBufferedImage2File (BufferedImage bufImg, String fileName, String formatName)	{
		if (bufImg==null) return(-1);
        //formatName : "png" etc
        try {
            File file = new File(fileName); //"C:/Users/hp/Desktop/Image Processing in Java/GFG.png");
            ImageIO.write(bufImg, formatName, file);
            return(1);
        } catch (IOException e) {
            System.out.println(e);
            return(-1);
        }
	}
	
}
