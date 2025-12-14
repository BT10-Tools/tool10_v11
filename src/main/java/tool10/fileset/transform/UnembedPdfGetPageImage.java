package tool10.fileset.transform;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class UnembedPdfGetPageImage {

	public static void getRenderedImageFileList(String fileName, String outputFilenameTemplate, String tmpDirectoryName, String formatName, String extensionName, int[] pageArray, long dpi) {

		//formatName: JPEG
		
		if (dpi<72) {dpi = 72;} 
		if (dpi>2400) {dpi=2400;}
		try {
			//Loading an existing PDF document
			PDDocument document = Loader.loadPDF(new RandomAccessReadBufferedFile(fileName)); //"yourfile.pdf"));
			
			//Instantiating the PDFRenderer class
			PDFRenderer renderer = new PDFRenderer(document);
	
			int cntPage = document.getNumberOfPages();
			ArrayList<Integer> pageList = new ArrayList<Integer>(); 
			if ((pageArray==null) || (pageArray.length==0) || (pageArray[0]<0))	{
				for (int i=0; i<cntPage; i++) pageList.add(i);
			} else {
				for (int i=0; i<pageArray.length; i++) {
					if ((pageArray[i]>=0) && (pageArray[i]<cntPage)) { pageList.add(pageArray[i]);}
				}
			}
			int cntRenderedPage = 0;
			for (int pageNum : pageList)	{
				//Rendering an image from the PDF document
				//BufferedImage image = renderer.renderImage(pageNum);
				BufferedImage image = renderer.renderImageWithDPI(pageNum, dpi);
	
				//Writing the image to a file
				ImageIO.write(image, formatName, new File(outputFilenameTemplate+pageNum+"."+extensionName)); //"C:/PdfBox_Examples/myimage.jpg"));
				cntRenderedPage++;
				image.flush();
			}
			
			System.out.println("Number of Page Images created :"+cntRenderedPage);
	       
			//Closing the document
			document.close();
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void main(String args[]) {
		String fileName = "C:\\nh\\09_DocSimilarity\\99_Unclassified\\master_Nguyen_Khoa_2024.pdf";
		String outputFilenameTemplate = "C:\\tmp\\similarity\\master_Nguyen_Khoa_2024_img";
		String tmpDirectoryName = "C:\\tmp\\similarity";
		int[] pageArray = null; //new int[] {0,1,2,3};
		String formatName = "PNG"; //JPEG";
		String extensionName = "png";
		long dpi=600; //72; 
		getRenderedImageFileList(fileName, outputFilenameTemplate, tmpDirectoryName, formatName, extensionName, pageArray, dpi);
	}	
}