package tool10.fileset.transform;

import java.util.ArrayList;

public class Bin2HexTransform {

	
	private static String[] getByte2Hex (byte[] bytes, int bytesInWords, int cntWordsInLine, int cntLinesInBlock, 
			boolean showAsciiPart, boolean showSpaceBetweenWords, boolean showByteCounter)	{
		ArrayList<String> lineList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder(); 
		int cntWords = 0;
		for (int i=0; i<bytes.length; i++)	{
			int n = bytes[i];
			sb.append(Integer.toHexString(n));
			if ((i % bytesInWords) == 0) sb.append(" ");
			if ((cntWords % cntWordsInLine) == 0) sb.append("\n");
			
			//DAHA BİTMEDİ
		}
		return((String[]) lineList.toArray());		
	}
	private static void runTest()	{
		int num = 1235761;
		String hexa = Integer.toHexString(num); 
		System.out.println("HexaDecimal Value is : " + hexa);
		System.out.println("Binary Value is : " + Integer.toBinaryString(num));
		System.out.println("Octal Value is : " + Integer.toOctalString(num));
		
		String testString = 
		"The BufferedImage constructor also requires an imageType parameter. This is not to be confused with the image file format"+
		" (e.g., PNG or JPEG); the image type dictates the color space of the new BufferedImage. The class itself provides static int "+
		"members for supported values such as BufferedImage.TYPE_INT_RGB and BufferedImage.TYPE_BYTE_GRAY for color and gray images, "+
		"respectively. In our case, we’ll use the same type as the source image since we’re only changing the scale.";
		
		int bytesInWords = 2; 
		int cntWordsInLine = 10; 
		int cntLinesInBlock = 10; //after every lines, put a lines with spaces
		boolean showAsciiPart = true; 
		boolean showSpaceBetweenWords = true;
		boolean showByteCounter = true; 
		
		String[] testLine = getByte2Hex (testString.getBytes(), bytesInWords, cntWordsInLine, cntLinesInBlock, 
				showAsciiPart, showSpaceBetweenWords, showByteCounter);
		System.out.println(testLine);
		
	}
	public static void main(String[] args) {
		runTest();
		
	}
}
