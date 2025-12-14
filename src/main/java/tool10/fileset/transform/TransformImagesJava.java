package tool10.fileset.transform;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import tool10.util.StrUtil;

public class TransformImagesJava {
	
	static final String TMPPDFDIRECTORYNAME = "C:\\tmp\\similarity\\tmppdf";
	static final int rndBase = 10000000;
		
	//****************************
	private static String getFileName(String outputFilenameTemplate, String extensionName, int pageNum, int imageNum)	{
		//renderedImage.
		//Writing the image to a file
		String cntStr =  "p" + StrUtil.padLeft(Integer.toString(pageNum) ,5-Integer.toString(pageNum).length(),"0")+
						"_i" + StrUtil.padLeft(Integer.toString(imageNum),6-Integer.toString(imageNum).length(),"0");
		String rndStr = Integer.toString(rnd.nextInt(rndBase, 10*rndBase));
		String tmpFileName = outputFilenameTemplate+cntStr+"_rnd"+rndStr+"."+extensionName;
		return(tmpFileName);
	}
	
	 // Method to convert image format
    public static boolean convertImg(String inputImgPath, String outputImgPath, String formatType) {
    	//https://www.geeksforgeeks.org/java/java-program-to-convert-png-images-to-jpeg/
    	boolean result = false;
    	try {
	        FileInputStream inputStream = new FileInputStream(inputImgPath);
	        FileOutputStream outputStream = new FileOutputStream(outputImgPath);
	
	        BufferedImage inputImage = ImageIO.read(inputStream);
	
	        // Writing to the output image in specified format
	        result = ImageIO.write(inputImage, formatType, outputStream);
	
	        outputStream.close();
	        inputStream.close();
    	} catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
	private static Random rnd = new Random();
	
	public static ArrayList<String> getTransformFileList(String fileName, String outputFilenameTemplate, String tmpDirectoryName, String formatName, String extensionName) {
		ArrayList<String> fileList = new ArrayList<String>();
		
		int pageNum = 1; 
		int imageNum = 1;
		String tmpFileName = getFileName(outputFilenameTemplate, extensionName, pageNum, imageNum);
		
		boolean result = convertImg(fileName, tmpFileName, formatName);
		if (result)	{
			fileList.add(tmpFileName);
		}
		
		//System.out.println("TransformImagesJava getTransformFileList cntRenderedImage :"+cntRenderedImage);
	    
		return(fileList);
	}
	        
}