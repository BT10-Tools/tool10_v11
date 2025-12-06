package tool10.util;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteEncryption {

	public static byte[] encryptByType(String encryptionType, String encryptionKey, final byte[] bytes) {
		try {
			if ("shuffle10".equals(encryptionType)) 		{return(encryptByShuffle10(bytes,encryptionKey));}
			else return(null);
		} catch (IOException e)	{
			
			return(null);
		}
	}
	public static byte[] decryptByType(String encryptionType, String encryptionKey, final byte[] bytes) {
		try {
			if ("shuffle10".equals(encryptionType)) 		{return(decryptByShuffle10(bytes,encryptionKey));}
			else return(null);
		}  catch (IOException e)	{
			return(null);
		}
	}
	//**************************************************************
	private static final int[] cipherArray = new int[] {
		201,240,176,60,109,2,100,203,88,9,70,223,18,83,95,207,234,
		164,143,137,114,235,86,20,220,250,144,165,77,175,158,69,155,
		129,54,190,251,48,248,35,111,44,28,193,133,170,34,126,252,
		102,172,115,237,39,51,62,127,123,145,205,21,180,131,188,52,
		208,162,226,13,178,110,41,101,68,171,1,119,241,238,183,168,
		104,185,57,71,244,97,215,254,163,253,218,136,84,142,134,227,
		212,242,139,50,19,6,209,40,27,153,214,152,64,174,221,74,
		125,107,63,106,151,213,194,233,132,148,11,14,12,146,138,135,
		118,243,47,230,224,108,81,217,32,211,249,147,89,179,196,247,
		49,187,87,112,55,140,222,15,91,22,113,232,23,43,169,76,
		177,25,229,130,189,93,46,117,0,3,191,245,246,56,99,75,
		17,154,141,30,33,184,16,206,90,61,236,5,202,85,65,150,
		231,255,225,122,167,7,192,161,121,38,219,197,103,72,228,78,
		24,4,79,239,73,53,116,10,96,128,182,159,45,156,200,160,
		124,31,67,8,199,173,120,29,37,92,26,80,186,216,166,36,
		210,149,181,98,58,157,59,195,82,198,204,94,105,66,42
	};
	private static final int[] decipherArray = new int[] {
		169,75,5,170,210,188,102,198,228,9,216,123,125,68,124,152,183,
		177,12,101,23,60,154,157,209,162,235,105,42,232,180,226,137,
		181,46,39,240,233,202,53,104,71,255,158,41,221,167,131,37,
		145,100,54,64,214,34,149,174,83,245,247,3,186,55,115,109,
		191,254,227,73,31,10,84,206,213,112,176,160,28,208,211,236,
		135,249,13,93,190,22,147,8,141,185,153,234,166,252,14,217,
		86,244,175,6,72,49,205,81,253,116,114,134,4,70,40,148,
		155,20,51,215,168,129,76,231,201,196,57,225,113,47,56,218,
		33,164,62,121,44,95,128,92,19,127,99,150,179,94,18,26,
		58,126,140,122,242,192,117,108,106,178,32,222,246,30,220,224,
		200,66,89,17,27,239,197,80,159,45,74,50,230,110,29,2,
		161,69,142,61,243,219,79,182,82,237,146,63,165,35,171,199,
		43,119,248,143,204,250,229,223,0,189,7,251,59,184,15,65,
		103,241,138,97,118,107,87,238,136,91,203,24,111,151,11,133,
		195,67,96,207,163,132,193,156,120,16,21,187,52,78,212,1,
		77,98,130,85,172,173,144,38,139,25,36,48,90,88,194
	};	

	private static byte[] encryptByShuffle10(final byte[] bytes, String encryptionKey) throws IOException {
		if (bytes == null) return(null);
		if (bytes.length == 0) return(bytes); 
		byte[] encryptedBytes = new byte[bytes.length];
		ByteBuffer buffer;
		
		for (int i=0; i<bytes.length; i++) {
			int a = Byte.toUnsignedInt(bytes[i]);
			int b = (byte) cipherArray[a];
			buffer = ByteBuffer.allocate(4).putInt(b);
			byte unsignedByte = buffer.array()[3];
			encryptedBytes[i] = unsignedByte;
		}
		return encryptedBytes;
	}

	private static byte[] decryptByShuffle10(final byte[] bytes, String encryptionKey) throws IOException {
		if (bytes == null) return(null);
		if (bytes.length == 0) return(bytes); 
		byte[] decryptedBytes = new byte[bytes.length];
		ByteBuffer buffer;
		
		for (int i=0; i<bytes.length; i++) {
			int a = Byte.toUnsignedInt(bytes[i]);
			int b = (byte) decipherArray[a];
			buffer = ByteBuffer.allocate(4).putInt(b);
			byte unsignedByte = buffer.array()[3];
			decryptedBytes[i] = unsignedByte;
		}
		return decryptedBytes;
	}
	//getters and setters
	public static int[] getCipherArray() {
		return cipherArray;
	}
	public static int[] getDecipherArray() {
		return decipherArray;
	}

}
