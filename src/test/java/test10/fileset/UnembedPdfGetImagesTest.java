package test10.fileset;

import tool10.fileset.transform.UnembedPdfGetImages;

public class UnembedPdfGetImagesTest {

	private static void testGetImageFileList()	{
		String fileName = "C:\\nh\\09_DocSimilarity\\99_Unclassified\\master_Nguyen_Khoa_2024.pdf";
		String tmpDirectoryName = "C:\\tmp\\similarity\\tmppdf2";
		String outputFilenameTemplate = tmpDirectoryName+"\\master_Nguyen_Khoa_2024_imgfile";
		int[] pageArray = null; //new int[] {0,1,2,3};
		String formatName = "PNG"; //JPEG";
		String extensionName = "png";
		long dpi=600; //72; 
		UnembedPdfGetImages.getImageFileList(fileName, outputFilenameTemplate, tmpDirectoryName, formatName, extensionName);
	}
	public static void main(String args[]) {
		testGetImageFileList();
	}
}