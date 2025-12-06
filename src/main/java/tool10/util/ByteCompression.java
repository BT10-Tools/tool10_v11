package tool10.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

public class ByteCompression {

	public static byte[] compressByType(String compressionType, final byte[] bytes) {
		try {
			if ("gzip".equals(compressionType)) 		{return(compressByGZip(bytes));}
			else if ("deflate".equals(compressionType)) {return(compressByDeflate(bytes));}
			else return(null);
		} catch (IOException e)	{
			
			return(null);
		}
	}
	public static byte[] decompressByType(String compressionType, final byte[] bytes) {
		try {
			if ("gzip".equals(compressionType)) 		{return(decompressByGZip(bytes));}
			else if ("deflate".equals(compressionType)) {return(decompressByDeflate(bytes));}
			else return(null);
		}  catch (IOException e)	{
			return(null);
		}  catch (DataFormatException e)	{
			return(null);
		}
	}
	//**************************************************************
	private static byte[] compressByGZip(final byte[] bytes) throws IOException {
		if (bytes == null || bytes.length == 0) {
			return new byte[0];
		}
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try (final GZIPOutputStream gzip = new GZIPOutputStream(out)) {
			gzip.write(bytes);
		}
		return out.toByteArray();
	}

	private static byte[] decompressByGZip(final byte[] bytes) throws IOException,DataFormatException {
		if (bytes == null || bytes.length == 0) {
			return new byte[0];
		}
		try (final GZIPInputStream ungzip = new GZIPInputStream(new ByteArrayInputStream(bytes))) {
			final ByteArrayOutputStream out = new ByteArrayOutputStream();
			final byte[] data = new byte[8192];
			int nRead;
			while ((nRead = ungzip.read(data)) != -1) {
				out.write(data, 0, nRead);
			}
			return out.toByteArray();
		}
	}
	//**************************************************************
	private static byte[] compressByDeflate(byte[] input)  throws IOException {
		byte[] resultBytes = null; 
		
	    Deflater deflater = new Deflater();
	    deflater.setInput(input);
	    deflater.setLevel(9); //setLevel() method to get better compression results. 
	    //We can pass values from 0 to 9, corresponding to the range from no compression to best compression:
	    deflater.finish();

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];

	    while (!deflater.finished()) {
	        int compressedSize = deflater.deflate(buffer);
	        outputStream.write(buffer, 0, compressedSize);
	    }
	    deflater.close();
	    resultBytes = new byte[outputStream.toByteArray().length]; 
	    System.arraycopy(resultBytes, 0, outputStream.toByteArray(), 0, outputStream.toByteArray().length);
	    
	    outputStream.close();
		return (resultBytes);
	}
	private static byte[] decompressByDeflate(byte[] input) throws  IOException,DataFormatException {
		byte[] resultBytes = null; 
	    Inflater inflater = new Inflater();
	    inflater.setInput(input);

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    byte[] buffer = new byte[1024];

	    while (!inflater.finished()) {
	        int decompressedSize = inflater.inflate(buffer);
	        outputStream.write(buffer, 0, decompressedSize);
	    }
	    inflater.close();
	    resultBytes = new byte[outputStream.toByteArray().length]; 
	    System.arraycopy(resultBytes, 0, outputStream.toByteArray(), 0, outputStream.toByteArray().length);
	    outputStream.close();
	    
	    return (resultBytes);
	}
	
}
