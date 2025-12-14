package tool10.fileset;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.HashSet;

import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;
import tool10.util.ByteCompression;
import tool10.util.ByteEncryption;

public class MakeFileSetBlob {

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
	private static final int  minCompressionGainRatio = 10;
	private static final long minCompressionGainBytes = 1024*1024;
	
	public static byte[] setBlobCompressionFields(NodeF10 f10, NodeFileBlob fileBlob, byte[] blobBytes, long blobSize) {
		String compressionType = "no";
		Long compressedFileSize = null; 
		Double compressionGainRatio = null;
		Long compressionGainBytes = null;
		Long compressedByteHashId = null; 
		byte[] compressedBytes = null;
		if ("yes".equals(f10.getCliParams().getCompression()))	{
			compressionType = f10.getCliParams().getCompressionType(); //"gzip", "deflate"
			if (("gzip".equals(compressionType)) || ("deflate".equals(compressionType)))	{
				compressedBytes = ByteCompression.compressByType(compressionType,blobBytes);
			}
			if (compressedBytes!=null)	{
				long gainBytes = (blobSize - compressedBytes.length); 
				int gainRatio  = (int) ((100*gainBytes) / blobSize);
			/*	if ((gainBytes >= minCompressionGainBytes) || (gainRatio >= minCompressionGainRatio))	{
					compressionType="regular";
					compressedByteHashId = null; //from compressedBytes
				} */	
				compressedFileSize = (long) compressedBytes.length;
				int gainRatio5Digits  = (int) ((10000*gainBytes) / blobSize);
				compressionGainRatio = gainRatio5Digits / 10000.d;
				compressionGainBytes = gainBytes;
			}
		}
		//System.out.println("MakeFileSetBlob setBlobCompressionFields  compressionGainBytes="+compressionGainBytes+
		//		", compressionGainRatio="+compressionGainRatio+" ,blobSize="+blobSize+"  ,compressedFileSize="+compressedFileSize); 
		fileBlob.setCompressionFields(compressionType,compressedFileSize,compressionGainRatio,compressionGainBytes,compressedByteHashId,null);
		if ("yes".equals(f10.getCliParams().getBlobCompressed())) {fileBlob.setCompressedBytes(compressedBytes);}
		return(compressedBytes);
	}
	public static byte[] setBlobEncryptionFields(NodeF10 f10, NodeFileBlob fileBlob, byte[] inputBytes) {
		Long sandByteLengthHead = null; 
		Long sandByteLengthTail = null;
		String encryptionBlobKey = null; 
		String encryptionType = "shuffle10";
		String encryptionKey = null; //"12345";
		byte[] encryptedBytes = ByteEncryption.encryptByType(encryptionType, encryptionKey, inputBytes);
		Long encryptedFileSize = (long) encryptedBytes.length;
		Long encrytedByteHashId = null;
		
		//System.out.println("MakeFileSetBlob setBlobEncryptionFields  encryption encryptedBytes.length="+encryptedBytes.length); 
		
		fileBlob.setEncryptionFields(sandByteLengthHead,sandByteLengthTail,
				encryptionBlobKey,encryptionType,encryptedFileSize,encrytedByteHashId,null);
		if ("yes".equals(f10.getCliParams().getBlobEncrypted())) {fileBlob.setEncryptedBytes(encryptedBytes);}
		return(encryptedBytes);
	}
	public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes, Long hashId)	{
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, Long fileSize, String compressionType, Long compressedFileSize, Long compressedByteHashId, 
		//Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedFileSize, Long encrytedByteHashId,byte[] fileBytes, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try {
			Long fileBlobId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			Long blobSize = (long) blobBytes.length;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeFileBlob fileBlob = new NodeFileBlob(fileBlobId, fileId, f10.getFileSet().getFileSetId(), partNumber, cntPart, blobType,
							blobSize,fileSize,null,hashId,creationDate,modificationDate);
			if ("yes".equals(f10.getCliParams().getBlobOriginal())) {fileBlob.setFileBytes(blobBytes);}
			f10.getFileSet().getListFileBlob().add(fileBlob);
			f10.getFileSet().getMapId2FileBlob().put(fileBlob.getFileBlobId(),fileBlob);
			
			byte[] compressedBytes = null;
			if ("yes".equals(f10.getCliParams().getCompression())) {
				compressedBytes = setBlobCompressionFields(f10, fileBlob, blobBytes, blobSize);
			}
			if ("yes".equals(f10.getCliParams().getEncryption())) {
				if (compressedBytes!=null) { setBlobEncryptionFields(f10, fileBlob, compressedBytes);}
				else setBlobEncryptionFields(f10, fileBlob, blobBytes);
			}
			return(fileBlob);
		} catch (Exception e)	{
			
		}
		return(null);
	}
	public static HashSet<NodeFile> createFileBlobsBig(NodeF10 f10, int blockSize, int minBigFileSize)	{
		HashSet<NodeFile> setNodeFileBig = new HashSet<NodeFile>(); 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (nodeFile.getFileSize() < minBigFileSize) continue;
			byte[][] fileBytesArray = getFileBytesArray(nodeFile.getFileNameAbsolute(), blockSize);
			if (fileBytesArray==null) continue;
			long cntPart = fileBytesArray.length;
			long partNumber = 0; 
			for (byte[] fileBytes : fileBytesArray)	{
				String blobType="bigfile";
				NodeHash hash = MakeFileSetHash.createOneHashForBigFile(f10, nodeFile.getFileSize(), fileBytesArray[0]);
				Long hashId = hash.getHashId();
				createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,cntPart,partNumber,fileBytes,hashId);
				partNumber++;
			}
			setNodeFileBig.add(nodeFile);
		}
		return(setNodeFileBig);
	}
	public static void createFileBlobsRegular(NodeF10 f10, int blockSize, 
			HashMap<NodeFile,Integer> mapNodeFile2BinNumber, HashSet<NodeFile> setNodeFileBig)	{
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (mapNodeFile2BinNumber.get(nodeFile) != null) continue;
			if (setNodeFileBig.contains(nodeFile)) continue;
			byte[] fileBytesRegular = readSmallFileBytes(nodeFile.getFileNameAbsolute());
			if (fileBytesRegular==null) continue;
			String blobType="regularfile";
			
			NodeHash hash = MakeFileSetHash.createOneHashForRegularFile(f10, nodeFile.getFileSize(), fileBytesRegular);
			Long hashId = hash.getHashId();
			nodeFile.setHashId(hashId);
			
			createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,null,null,fileBytesRegular, hashId);
		}
	}
	public static void createFileBlobs(NodeF10 f10)	{
		if (!"yes".equals(f10.getCliParams().getBlob()))	{
			return;
		}
		int blockSize = 4*1024*1024;
		int binSize = blockSize; 
		int minFileSizeForPacking = (4*binSize / 5); 
		int minBigFileSize = 8*1024*1024;
		
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = MakeFileSetBlobSmall.createFileBlobsSmall(f10, blockSize, binSize, minFileSizeForPacking);
		HashSet<NodeFile> setNodeFileBig = createFileBlobsBig(f10,blockSize, minBigFileSize);
		createFileBlobsRegular(f10,blockSize, mapNodeFile2BinNumber, setNodeFileBig);
	}
}
