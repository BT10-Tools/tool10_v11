package test10.util;

import java.nio.charset.Charset;

import tool10.fileset.blob.ByteEncryption;

public class ByteEncryptionTest {

	public static void testEncryption()	{
		System.out.println("testEncryption: ");
		
		Charset charset = Charset.forName("UTF-8");
		System.out.println("testEncryption:2");
		
		String inputString = "Baeldung helps developers explore the Java ecosystem and simply be better engineers. "
		  + "We publish to-the-point guides and courses, with a strong focus on building web applications, Spring, "
		  + "Spring Security, and RESTful APIs";
	
		
		String encryptionKey = "12345";
		    
		try {
			byte[] input = charset.encode(inputString).array(); //inputString.getBytes();
			System.out.println("testEncryption:3");
			
			byte[] encryptedData = ByteEncryption.encryptByType("shuffle10", encryptionKey, input);
			System.out.println("testEncryption:4");
			byte[] decryptedData = ByteEncryption.decryptByType("shuffle10", encryptionKey, encryptedData);
			System.out.println("testEncryption:5");
		    String decryptedStr = new String(decryptedData, charset);
			    
			System.out.println("Original: " + input.length + " bytes");
			System.out.println("Encrypted: " + encryptedData.length + " bytes");
			System.out.println("Decrypted: " + decryptedData.length + " bytes");
			System.out.println("decryptedStr: " + decryptedStr);
			
			if (input.length == decryptedData.length)	{
				System.out.print("ENCRYPTION TAMAM");
			}
		} catch (Exception e)	{
			
		}
	}	

	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");
        testEncryption();     
	}    
}
