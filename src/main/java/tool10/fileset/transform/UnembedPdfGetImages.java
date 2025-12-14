package tool10.fileset.transform;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
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

public class UnembedPdfGetImages {
	
	static final String TMPPDFDIRECTORYNAME = "C:\\tmp\\similarity\\tmppdf";
	static final int rndBase = 10000000;
	
	private static void getImageFilesFromResources2(PDResources resources, ArrayList<String> fileList, 
			String outputFilenameTemplate, String formatName, String extensionName, int pageNum, Integer imageNum) {
		if (resources==null) return;
		List<RenderedImage> images = new ArrayList<RenderedImage>();
		try {
		    for (COSName xObjectName : resources.getXObjectNames()) {
		        PDXObject xObject = resources.getXObject(xObjectName);
		
		        if (xObject instanceof PDFormXObject) {
		        	PDResources resourcesInternal = ((PDFormXObject) xObject).getResources();
		        	if (resourcesInternal!=null)	{
		        		getImageFilesFromResources2(resourcesInternal, fileList, outputFilenameTemplate, formatName, extensionName, pageNum, imageNum);
		        	}
		        } else if (xObject instanceof PDImageXObject) {
		        	RenderedImage renderedImage = ((PDImageXObject) xObject).getImage(); 
		            images.add(((PDImageXObject) xObject).getImage());
		            
		            String tmpFileName = getFileName(outputFilenameTemplate, extensionName, pageNum, imageNum) ;
		            
		            ImageIO.write(renderedImage, formatName, new File(tmpFileName)); //"C:/PdfBox_Examples/myimage.jpg"));
		            
		            fileList.add(tmpFileName);
		            imageNum = imageNum.intValue()+1;
		            renderedImage = null;
		        }		       
		    }
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	private static void getImageFilesFromPDF2(PDDocument document, ArrayList<String> fileList, 
			String outputFilenameTemplate, String formatName, String extensionName) {
        int pageNum=0;
        Integer imageNum=0;
	    for (PDPage page : document.getPages()) {
	    	if (page.getResources()!=null)	{
	    		getImageFilesFromResources2(page.getResources(), fileList, outputFilenameTemplate, formatName, extensionName, pageNum, imageNum);
	    	}
	    	pageNum++;
	    }
	}
	private static String getFileName(String outputFilenameTemplate, String extensionName, int pageNum, int imageNum)	{
		//renderedImage.
		//Writing the image to a file
		String cntStr =  "p" + StrUtil.padLeft(Integer.toString(pageNum) ,5-Integer.toString(pageNum).length(),"0")+
						"_i" + StrUtil.padLeft(Integer.toString(imageNum),6-Integer.toString(imageNum).length(),"0");
		String rndStr = Integer.toString(rnd.nextInt(rndBase, 10*rndBase));
		String tmpFileName = outputFilenameTemplate+cntStr+"_rnd"+rndStr+"."+extensionName;
		return(tmpFileName);
	}
	public static ArrayList<String> getImageFileList2(String fileName, String outputFilenameTemplate, String tmpDirectoryName, String formatName, String extensionName) {
		ArrayList<String> fileList = new ArrayList<String>();
		//formatName: JPEG
		try {
			//Loading an existing PDF document
			PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(fileName)); //"yourfile.pdf"));
			getImageFilesFromPDF2(document, fileList, outputFilenameTemplate, formatName, extensionName);
			System.out.println("UnembedPdfGetImages getImageFileList2 fileList.size() :"+fileList.size());

			//Closing the document
			document.close();
		} catch (IOException e) {
            e.printStackTrace(); 
        }
		return(fileList);
	}	
	//****************************
	private static List<RenderedImage> getImagesFromResources3(PDResources resources) {
		if (resources==null) return(null);
		List<RenderedImage> images = new ArrayList<RenderedImage>();
		try {
		    for (COSName xObjectName : resources.getXObjectNames()) {
		        PDXObject xObject = resources.getXObject(xObjectName);
		
		        if (xObject instanceof PDFormXObject) {
		        	List<RenderedImage> images2 = getImagesFromResources3(((PDFormXObject) xObject).getResources());
		            if (images2!=null) {
		            	images.addAll(images2);
		            }
		        } else if (xObject instanceof PDImageXObject) {
		            images.add(((PDImageXObject) xObject).getImage());
		        }
		    }
		} catch (IOException e) {
            e.printStackTrace();
        }
	    return images;
	}
	private static List<RenderedImage> getImagesFromPDF3(PDDocument document) {
        List<RenderedImage> images = new ArrayList<RenderedImage>();
	    for (PDPage page : document.getPages()) {
	    	if (page.getResources()!=null)	{
	    		List<RenderedImage> imageList = getImagesFromResources3(page.getResources());
	    		if (imageList!=null) {images.addAll(imageList);}
	    	}
	    }
        return images;
	}
	public static ArrayList<String> getImageFileList3(String fileName, String outputFilenameTemplate, String tmpDirectoryName, String formatName, String extensionName) {
		ArrayList<String> fileList = new ArrayList<String>();
		//formatName: JPEG
		try {
			//Loading an existing PDF document
			PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(fileName)); //"yourfile.pdf"));
			
			List<RenderedImage> images = getImagesFromPDF3(document);
			int cntRenderedImage = 0;
			for (RenderedImage renderedImage : images)	{
				//renderedImage.
				//Writing the image to a file
				String cntStr = (cntRenderedImage<10) ? ("00"+Integer.toString(cntRenderedImage)) : ("0"+Integer.toString(cntRenderedImage));
				String rndStr = Integer.toString(rnd.nextInt(rndBase, 10*rndBase));
				String tmpFileName = outputFilenameTemplate+cntStr+"_rnd"+rndStr+"."+extensionName;
				
				ImageIO.write(renderedImage, formatName, new File(tmpFileName)); //"C:/PdfBox_Examples/myimage.jpg"));
				fileList.add(tmpFileName);
				cntRenderedImage++;
				//renderedImage..flush();
			}
			System.out.println("UnembedPdfGetImages getImageFileList cntRenderedImage :"+cntRenderedImage);
	       
			//Closing the document
			document.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
		return(fileList);
	}
	
	private static Random rnd = new Random();
	
	//***************************
	public static ArrayList<String> getImageFileList(String fileName, String outputFilenameTemplate, String tmpDirectoryName, String formatName, String extensionName) {
		ArrayList<String> fileList = new ArrayList<String>();
		try {
			PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(fileName)); //"yourfile.pdf"));
			if (document==null) return(null);
			
			for (PDPage page : document.getPages()) {
	
		        PDResources pdResources = page.getResources();
		        if (pdResources==null) continue;
		        
		        int cntRenderedImage = 0;
		        for (COSName c : pdResources.getXObjectNames()) {
		            PDXObject o = pdResources.getXObject(c);
		            if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
		            	
		            	String cntStr = (cntRenderedImage<10) ? ("00"+Integer.toString(cntRenderedImage)) : ("0"+Integer.toString(cntRenderedImage));
						String rndStr = Integer.toString(rnd.nextInt(rndBase, 10*rndBase));
						String tmpFileName = outputFilenameTemplate+cntStr+"_rnd"+rndStr+"."+extensionName;
						
		                File file = new File(tmpFileName);
		                ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) o).getImage(), extensionName, file);
		                cntRenderedImage++;
		            }
		        }
			}
		} catch (IOException e) {
            e.printStackTrace();
        }   
		return(fileList);
	}
	        
}