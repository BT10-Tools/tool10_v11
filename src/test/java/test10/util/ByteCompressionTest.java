package test10.util;

import tool10.blobset.ByteCompression;

public class ByteCompressionTest {

	public static void testByDeflate()	{
		String inputString = "Baeldung helps developers explore the Java ecosystem and simply be better engineers. "
		  + "We publish to-the-point guides and courses, with a strong focus on building web applications, Spring, "
		  + "Spring Security, and RESTful APIs";
		byte[] input = inputString.getBytes();

		try {
			byte[] compressedData = ByteCompression.compressByType("deflate",input);
			
			byte[] decompressedData = ByteCompression.decompressByType("deflate",compressedData);
	
			System.out.println("Original: " + input.length + " bytes");
			System.out.println("Compressed: " + compressedData.length + " bytes");
			System.out.println("Decompressed: " + decompressedData.length + " bytes");
	
			if (input.length == decompressedData.length)	{
				System.out.print("DEFLATOR PATLATMA TAMAM");
			}
		} catch (Exception e)	{
			
		}
	}	
	public static void testByGZip()	{
		String inputString = "Baeldung helps developers explore the Java ecosystem and simply be better engineers. "
		  + "We publish to-the-point guides and courses, with a strong focus on building web applications, Spring, "
		  + "Spring Security, and RESTful APIs";
		byte[] input = inputString.getBytes();

		try {
			byte[] compressedData = ByteCompression.compressByType("gzip",input);
			
			byte[] decompressedData = ByteCompression.decompressByType("gzip",compressedData);
	
			System.out.println("Original: " + input.length + " bytes");
			System.out.println("Compressed: " + compressedData.length + " bytes");
			System.out.println("Decompressed: " + decompressedData.length + " bytes");
	
			if (input.length == decompressedData.length)	{
				System.out.print("GZIP PATLATMA TAMAM");
			}
		} catch (Exception e)	{
			
		}
	}		
	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");
        testByDeflate();
        
        testByGZip();
	}    
}
