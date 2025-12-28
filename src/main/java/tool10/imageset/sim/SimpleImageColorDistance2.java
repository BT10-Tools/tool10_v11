package tool10.imageset.sim;

//Java Program to Compare Two Images Using OpenCV
//Via printing Difference Percentage

//Importing required classes
import java.awt.image.BufferedImage;

import tool10.imageset.ImageEngineJava;

//Main class
//ImageComparison

public class SimpleImageColorDistance2 {

	public static int[] getImageWidthHeigth(String fileName1)	{
    	BufferedImage imgA = ImageEngineJava.getBufferedImageFromFile(fileName1);
    	
    	if (imgA==null) return(null);
    	
    	// Assigning dimensions to image
    	int width1 = imgA.getWidth();
    	int height1 = imgA.getHeight();
    	int[] wh = new int[] {width1,height1};
    	return(wh);
	}		    
    public static double getTwoImageRGBDifference(String fileName1, String fileName2, double maxDiff)	{
    /*	Image i1 = getImageFromFile(fileName1);
    	Image i2 = getImageFromFile(fileName2);
    	BufferedImage imgA = convertToBufferedImage(i1); //getBufferedImageFromFile(fileName1);
    	BufferedImage imgB = convertToBufferedImage(i2); //getBufferedImageFromFile(fileName2);
    */ 
    	BufferedImage imgA = ImageEngineJava.getBufferedImageFromFile(fileName1);
    	BufferedImage imgB = ImageEngineJava.getBufferedImageFromFile(fileName2);
    	if (imgA==null) return(-3d);
    	if (imgB==null) return(-4d);
    	
    	return(getTwoImageRGBDifferenceWithBufferedImage(imgA,imgB,maxDiff));
    }	
    public static double getTwoImageRGBDifferenceWithBufferedImage(BufferedImage imgA, BufferedImage imgB, double maxDiff)	{	
    	if (imgA==null) return(-3d);
    	if (imgB==null) return(-4d);
    	
    	// Assigning dimensions to image
    	int width1 = imgA.getWidth();
    	int width2 = imgB.getWidth();
    	int height1 = imgA.getHeight();
	    int height2 = imgB.getHeight();

	    // Checking whether the images are of same size or // not
	    if ((width1 != width2) || (height1 != height2)) {return(-1d);}

        // By now, images are of same size
        long difference = 0;
        long maxDiffSum = ((maxDiff>0.0d) && (maxDiff<=1.0d)) ? (long) (3.0d * width1 * height2 * 255 * maxDiff) : 0;  

        // treating images likely 2D matrix
        // Outer loop for rows(height)
        for (int y = 0; y < height1; y++) {
             // Inner loop for columns(width)
             for (int x = 0; x < width1; x++) {
                 int rgbA = imgA.getRGB(x, y);
                 int rgbB = imgB.getRGB(x, y);
                 int redA = (rgbA >> 16) & 0xff;
                 int greenA = (rgbA >> 8) & 0xff;
                 int blueA = (rgbA)&0xff;
                 int redB = (rgbB >> 16) & 0xff;
                 int greenB = (rgbB >> 8) & 0xff;
                 int blueB = (rgbB)&0xff;

                 difference += Math.abs(redA - redB);
                 difference += Math.abs(greenA - greenB);
                 difference += Math.abs(blueA - blueB);
                 if (difference > maxDiffSum) return(-1d); 
             }
         }

         // Total number of red pixels = width * height
         // Total number of blue pixels = width * height
         // Total number of green pixels = width * height
         // So total number of pixels = width * height * 3
         double total_pixels = width1 * height1 * 3.0d;

         // Normalizing the value of different pixels for accuracy
         // Note: Average pixels per color component
         double avg_different_pixels = difference / total_pixels;

         // There are 255 values of pixels in total
         double percentage = (avg_different_pixels / 255.0d);
         return (percentage);
    }
}