package test10.fileset;

import tool10.fileset.transform.UnembedPdfGetPageImage;

public class UnembedPdfGetPageImageTest {

	public static void main(String args[]) {
		String fileName = "C:\\nh\\09_DocSimilarity\\99_Unclassified\\master_Nguyen_Khoa_2024.pdf";
		String outputFilenameTemplate = "C:\\tmp\\similarity\\master_Nguyen_Khoa_2024_img";
		String tmpDirectoryName = "C:\\tmp\\similarity";
		int[] pageArray = null; //new int[] {0,1,2,3};
		String formatName = "PNG"; //JPEG";
		String extensionName = "png";
		long dpi=600; //72; 
		UnembedPdfGetPageImage.getRenderedImageFileList(fileName, outputFilenameTemplate, tmpDirectoryName, formatName, extensionName, pageArray, dpi);
	}	
}