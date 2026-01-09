package tool10.underdev;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class LBSTest {

	private static void runLBS()	{
		//public LongByteSequences(byte[] b1, byte[] b2, int minSequenceLength, int maxCntSequence)
		String s1 = "Many file formats are not intended to be read as text.";
		String s2 = "If such a file is accidentally viewed as a text file, its contents will be unintelligible.";
		String s3 = "However, some file signatures can be recognizable when interpreted as text."; 
		String s4 = "In the table below, the column ISO 8859-1 shows how the file signature";
		String s5 = "appears when interpreted as text in the common ISO 8859-1 encoding,";
		String s6 = "with unprintable characters represented as the control code abbreviation or symbol, ";
		String s7 = "or codepage 1252 character where available, or a box otherwise.";
		
		Charset charset = Charset.defaultCharset();
		String s123 = s1 + s2 +s3;  				byte[] b123 = s123.getBytes(charset); 
		String s124 = s1 + s2 +s4; 					byte[] b124 = s124.getBytes(charset);
		String s145 = s1 + s4 +s5; 					byte[] b145 = s145.getBytes(charset);
		String s12345 = s1 + s2 + s3 + s4 +s5; 		byte[] b12345 = s12345.getBytes(charset);
		String s234 = s2 + s3 +s4; 					byte[] b234 = s234.getBytes(charset);
		String s247 = s2 + s4 +s7; 					byte[] b247 = s247.getBytes(charset);
		String s256 = s2 + s5 +s6;					byte[] b256 = s256.getBytes(charset);	
		String s467 = s4 + s6 +s7;					byte[] b467 = s467.getBytes(charset);
		String s34567 = s3 + s4 + s5 + s6 +s7;		byte[] b34567 = s34567.getBytes(charset);
		String s67 = s6 + s7; 						byte[] b67 = s67.getBytes(charset);
		
		byte[][] bb = new byte[][] {b123,b124,b145,b12345,b234,b247,b256,b467,b34567,b67};
		for (byte[] ss1 : bb)	{
			for (byte[] ss2 : bb)	{
				int minSequenceLength = 5; 
				int maxCntSequence = 10;
				LongByteSequences lbs12 = new LongByteSequences(ss1, ss2, minSequenceLength, maxCntSequence);
				lbs12.initialize();
				String s12 = new String(lbs12.getLongestSequence(), StandardCharsets.UTF_8);
				String p1 = new String(ss1, StandardCharsets.UTF_8);
				String p2 = new String(ss2, StandardCharsets.UTF_8);
				System.out.println("'"+p1+"' | \n'"+ p2 + "' | \n'          " + s12+"'");
			}
		}	
	}
	public static void main(String[] args) {
		runLBS();
	}
}
