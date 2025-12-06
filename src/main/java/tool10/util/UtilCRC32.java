package tool10.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.zip.Adler32;
import java.util.zip.CRC32;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import jakarta.xml.bind.DatatypeConverter;

public class UtilCRC32 {

	public static CRC32 getCRC32() {
        return(new CRC32());
	}    
	public static long getBytesCRC32(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return(crc32.getValue());
	}
	public static long getBytesCRC32(CRC32 crc32,byte[] bytes) {
        if (crc32==null) {crc32 = new CRC32();}
        crc32.update(bytes);
        return(crc32.getValue());
	}
	public static long getBytesAdler32(byte[] bytes) {
        Adler32 adler32 = new Adler32();
        adler32.update(bytes);
        return(adler32.getValue()); 
	}
	public static String getBytesMd5(byte[] bytes) {
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(bytes);
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesSHA1(byte[] bytes) {
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesSHA256(byte[] bytes) {
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesSHA384(byte[] bytes) {
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-384");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesSHA512(byte[] bytes) {
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesSHA3_256(byte[] bytes) {
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA3-256");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	public static String getBytesKeccak256(byte[] bytes) {
		try {
			Security.addProvider(new BouncyCastleProvider());
		    MessageDigest digest = MessageDigest.getInstance("Keccak-256");
			byte[] encodedhash = digest.digest(bytes);
			String myHash = bytesToHex(encodedhash);
		    return(myHash);    
		} catch (NoSuchAlgorithmException e)	{
		}
		return(null);
	}
	
	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}
