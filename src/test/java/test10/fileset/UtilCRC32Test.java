package test10.fileset;


import java.util.zip.Adler32;
import java.util.zip.CRC32;

public class UtilCRC32Test {
	
	//******************************
	public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        String data = "Hello, CRC32!";
        byte[] bytes = data.getBytes();

        crc32.update(bytes);
        long checksum = crc32.getValue();
        
        System.out.println("CRC32 Checksum: " + checksum);
        
        Adler32 adler32 = new Adler32();
        String dataAdler = "Hello, Adler32!";
        byte[] bytesAdler = dataAdler.getBytes();

        adler32.update(bytesAdler);
        long checksumAdler = adler32.getValue();
        
        System.out.println("Adler32 checksumAdler: " + checksumAdler);

        
    }
}
