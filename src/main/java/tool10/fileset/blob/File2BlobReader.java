package tool10.fileset.blob;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class File2BlobReader {

	public File2BlobReader(String fileName, int blockSize) {
		super();
		this.fileName = fileName;
		this.blockSize = blockSize;
	}
	
	private String fileName; 
	private int blockSize;
	private int blockIdx = 0;
	private long sumBytes = 0;
	
	private FileInputStream fis;
	private BufferedInputStream bis; 
	
	public boolean initializeReader()	{
		if ((blockSize < 1024*1024) || (blockSize>64*1024*1024)) blockSize = 64*1024*1024;
    	
        File myFile = new File(fileName);
        long fileSize = myFile.length();
        		
        int cntBlock = (int) (fileSize / blockSize) + 1;
        if (fileSize > (cntBlock * blockSize)) {cntBlock++;}
        
        //System.out.println("readFileBlocks : blockSize="+blockSize+"   ,fileSize="+fileSize+"   ,cntBlock="+cntBlock);
        
        try	{
        	fis = new FileInputStream(myFile);
        	bis = new BufferedInputStream(fis); 
        	return(true);
        } catch (IOException e)	{
        	return(false);
        } catch (Exception e)	{
        	return(false);
        }
	}
	public boolean closeAll()	{
		closeAll();
		initializeReader();
        return(true);
	}
	public boolean rewind()	{
        try	{
        	blockIdx = 0;
        	sumBytes = 0;
        	bis.close();
        	fis.close();
        	return(true);
        } catch (IOException e)	{
        	return(false);
        } catch (Exception e)	{
        	return(false);
        }
	}
	public byte[] getNextBytes()	{

		byte[] byteArray = new byte[blockSize];
        // Create a byte array buffer
        byte[] buffer = new byte[blockSize]; // Read 5 bytes at a time
        int bytesRead;
        try	{
	        // Read chunks of bytes into the buffer
	        if ((bytesRead = bis.read(buffer)) != -1) {
	        	if (bytesRead>0)	{
	        		byteArray = new byte[bytesRead];
	            	System.arraycopy(buffer, 0, byteArray, 0, bytesRead);
	            	blockIdx++;
	            	sumBytes += bytesRead;
	            	return(byteArray);
	        	}
	        }	
        } catch (IOException e)	{
        	return(null);
        } catch (Exception e)	{
        	return(null);
        }
		return(null);
	}
	public byte[] getBytesByBlockNumber(int blockNumber)	{
		//maybe needed in fututre
		/*	
	    long sumBytes = 0;
	        
	    byte[][] fileByteArray = new byte[cntBlock][];
        // Create a byte array buffer
        byte[] buffer = new byte[blockSize]; // Read 5 bytes at a time
        int bytesRead;

        // Read chunks of bytes into the buffer
        while ((bytesRead = in.read(buffer)) != -1) {
        	if (bytesRead>0)	{
        		fileByteArray[bufIdx] = new byte[bytesRead];
            	System.arraycopy(buffer, 0, fileByteArray[bufIdx], 0, bytesRead);
            	bufIdx++;
            	sumBytes += bytesRead;
        	}
            	//fileByteArray[bufIdx++] = buffer;
            	//System.out.println("readFileBlocks  reading bytesRead="+bytesRead); 
            	
            	// Convert bytes to string and print
            	//System.out.p
            	///
       	*/
		return null;
	}
	private static final int maxSmallFileSize = 64*1024*1024; 
    public static byte[] readSmallFileBytes(String fileName) {
    	try {
	        File myFile = new File(fileName);
	        if ((myFile==null) || (!myFile.exists())) return(null); 
	        Path myPath = myFile.toPath();
	        if (myPath==null) return(null);
	        long fileSize = myFile.length();
	        if (fileSize==0) return (null);
	        if (fileSize > maxSmallFileSize) return (null);
	
	        byte[] fileBytes = Files.readAllBytes(myPath);
	        return(fileBytes);
    	} catch (IOException e)	{
    		return(null);
    	} catch (Exception e)	{
    		return(null);
    	}
    }
    public static byte[] readRegularFileBytes(String fileName) {
    	//for the moment use the same reader as the small ones
    	return(readSmallFileBytes(fileName));
    }
    public static byte[][] readFileBlocks(String fileName, int blockSize) throws IOException {

    	if ((blockSize < 1024*1024) || (blockSize>64*1024*1024)) blockSize = 64*1024*1024;
    	
        File myFile = new File(fileName);
        long fileSize = myFile.length();
        		
        int cntBlock = (int) (fileSize / blockSize) + 1;
        if (fileSize > (cntBlock * blockSize)) {cntBlock++;}
        
        //System.out.println("readFileBlocks : blockSize="+blockSize+"   ,fileSize="+fileSize+"   ,cntBlock="+cntBlock);
        
        byte[][] fileByteArray = new byte[cntBlock][];
        
        int bufIdx = 0;
        long sumBytes = 0;
        
        try( BufferedInputStream in = new BufferedInputStream(new FileInputStream( myFile ) ) )  {
            
            // Create a byte array buffer
            byte[] buffer = new byte[blockSize]; // Read 5 bytes at a time
            int bytesRead;

            // Read chunks of bytes into the buffer
            while ((bytesRead = in.read(buffer)) != -1) {
            	if (bytesRead>0)	{
            		fileByteArray[bufIdx] = new byte[bytesRead];
	            	System.arraycopy(buffer, 0, fileByteArray[bufIdx], 0, bytesRead);
	            	bufIdx++;
	            	sumBytes += bytesRead;
            	}
            	//fileByteArray[bufIdx++] = buffer;
            	//System.out.println("readFileBlocks  reading bytesRead="+bytesRead); 
            	
            	// Convert bytes to string and print
            	//System.out.print(new String(buffer, 0, bytesRead));
            }
        }     
        //System.out.println("readFileBlocks : sumBytesRead="+sumBytes+"   ,fileSize="+fileSize+"   ,cntBlock="+cntBlock);
        return(fileByteArray);
    }
    
	public static byte[][] getFileBytesArray(String fileName, int blockSize)	{
		try {
			byte[][] fileBytesArray = readFileBlocks(fileName, blockSize);
			return(fileBytesArray);
		} catch (IOException e)	{
		}
		return(null);
	}
	
	//GETTERS AND SETTERS
	public String getFileName() {
		return fileName;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public static int getMaxsmallfilesize() {
		return maxSmallFileSize;
	}
	public int getBlockIdx() {
		return blockIdx;
	}
	public long getSumBytes() {
		return sumBytes;
	}
	
}
