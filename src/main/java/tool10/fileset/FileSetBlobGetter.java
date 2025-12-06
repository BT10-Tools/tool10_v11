package tool10.fileset;

import java.io.File;

import tool10.util.Blake3;
import tool10.util.ByteCompression;
import tool10.util.ByteEncryption;
import tool10.util.FileUtil;

public class FileSetBlobGetter {
	private static byte[] getFileBlobBytes(NodeFileSet fileSet, NodeFile nodeFile, NodeFileBlob fileBlob) {
		String encrpytionKey = "";
		byte[] decryptedBytes = ByteEncryption.decryptByType(fileBlob.getEncryptionType(), encrpytionKey, fileBlob.getEncryptedBytes());
		if (decryptedBytes==null) return(null);
		if (decryptedBytes.length != fileBlob.getCompressedFileSize()) {
			System.out.println("FileSetBlobGetter getFileBlobBytes file: "+nodeFile.getFileNameAbsolute()+" ,decryptedBytes.length :"+decryptedBytes.length + 
				" ,fileBlob.getCompressedFileSize():"+fileBlob.getCompressedFileSize());
		}
		byte[] decompressedBytes = ByteCompression.decompressByType(fileBlob.getCompressionType(), decryptedBytes);
		boolean hashMatch = false;
		if (fileBlob.getHashId()!= null) {
			NodeHash hash = fileSet.getMapId2Hash().get(fileBlob.getHashId());
			if (hash!=null)	{
				if ((hash.getBlake3()!=null))	{
					String blake3a = Blake3.getBlake3HashForBytes(decompressedBytes);
					hashMatch = hash.getBlake3().equals(blake3a) ? true : false; 
				}
			}
		}
		System.out.println("FileSetBlobGetter getFileBlobBytes file: "+nodeFile.getFileNameAbsolute()+" ,decryptedBytes.length :"+decryptedBytes.length + 
				" ,fileBlob.getCompressedFileSize():"+fileBlob.getCompressedFileSize() +
				" ,hashMatch:"+hashMatch);
		
		return(decompressedBytes);
	}
	public static byte[] getBlobBytesForFileRegular(NodeFileSet fileSet, NodeFile nodeFile) {
		byte[] bytes = nodeFile.getListFileBlobRegular().get(0).getFileBytes();
		if (bytes!=null) {
			if (nodeFile.getFileSize().longValue()!=bytes.length) {
				System.out.println("FileSetBlobGetter writeBlobBytesForFileRegular, different filesize: "+nodeFile.getFileSize().longValue()+" ,bytes length:"+bytes.length);
				return(null);
			}
			System.out.println("FileSetBlobGetter getBlobBytesForFileRegular returning bytes length:"+bytes.length);
			return(bytes);
		}
		return(null);
	}
	private static String writeBlobBytesForFileRegular(NodeFileSet fileSet, NodeFile nodeFile, String fileName) {
		byte[] bytes = getBlobBytesForFileRegular(fileSet,nodeFile);
		if (bytes!=null) {
			System.out.println("FileSetBlobGetter writeBlobBytesForFileRegular creating file: "+fileName+" ,bytes length:"+bytes.length);
			boolean created = FileUtil.writeBytesToFile(fileName, bytes);	
			if (created) return("ok"); else return("nok");
		}
		return("nok");
	}
	public static int getCntPartForFileBig(NodeFileSet fileSet, NodeFile nodeFile, int partNumber) {
		for (NodeFileBlob blobPart: nodeFile.getListFileBlobBig())	{
			if (blobPart.getCntPart()==null) continue;
			if (blobPart.getCntPart().intValue() > 0) return(blobPart.getCntPart().intValue()); 
		}
		return(-1);
	}
	public static byte[] getBlobBytesForFileBig(NodeFileSet fileSet, NodeFile nodeFile, int partNumber) {
		byte[] bytes =  null;
		for (NodeFileBlob blobPart: nodeFile.getListFileBlobBig())	{
			if (blobPart.getPartNumber()==null) continue;
			if (blobPart.getPartNumber().longValue()!=partNumber) continue;
			//else 
			bytes = getFileBlobBytes(fileSet,nodeFile,blobPart);
			if (blobPart.getBlobSize().longValue()!=bytes.length) {
				System.out.println("FileSetBlobGetter writeBlobBytesForFileBig, different filesize: "+blobPart.getBlobSize().longValue()+" ,bytes length:"+bytes.length);
				return(null);
			}
			System.out.println("FileSetBlobGetter getBlobBytesForFileBig returning bytes length:"+bytes.length+
					" ,partNumber:"+blobPart.getPartNumber());
			return(bytes);
		}
		return(null);
	}
	private static String writeBlobBytesForFileBig(NodeFileSet fileSet, NodeFile nodeFile, String fileName) {
		byte[] bytes =  null;
		File appendFile = null;
		boolean created = true;
		for (NodeFileBlob blobPart: nodeFile.getListFileBlobBig())	{
			if (blobPart.getPartNumber()==null) continue;
			int partNumber = blobPart.getPartNumber().intValue();
			bytes = getBlobBytesForFileBig(fileSet,nodeFile,partNumber);
			System.out.println("FileSetBlobGetter writeBlobBytesForFileBig creating file: "+fileName+" ,bytes length:"+bytes.length+
					" ,partNumber:"+blobPart.getPartNumber());
			if (appendFile==null) {
				appendFile = FileUtil.appendBytesToFile(fileName, bytes);
			} else {
				created = FileUtil.appendBytesToFile(appendFile, bytes);
			}
		}
		return("nok");
	}
	public static byte[] getBlobBytesForFileSmall(NodeFileSet fileSet, NodeFile nodeFile) {
		NodeFileBlobSmall blobSmall = nodeFile.getListFileBlobSmall().get(0);
		int indexStart = (int) blobSmall.getByteIndexStart().intValue();
		int indexEnd = (int) blobSmall.getByteIndexEnd().intValue();			
		if ((blobSmall==null) || (indexStart<0) || (indexEnd<=indexStart))  return(null);
		Long blobId = blobSmall.getFileBlobId();
		if (blobId==null) return(null);
		NodeFileBlob fileBlob = fileSet.getMapId2FileBlob().get(blobId);
		if (fileBlob==null) return(null);
	
		byte[] bytes =   fileBlob.getFileBytes();
		if (bytes!=null) {
			if (fileBlob.getBlobSize().longValue()!=bytes.length) {
				System.out.println("FileSetBlobGetter writeBlobBytesForFileSmall, different filesize: "+fileBlob.getBlobSize().longValue()+" ,bytes length:"+bytes.length);
			}
		    byte bytesSmall[] = new byte[indexEnd - indexStart + 1];
	        System.arraycopy(bytes, indexStart, bytesSmall, 0, indexEnd - indexStart + 1);
	        
			System.out.println("FileSetBlobGetter getBlobBytesForFileSmall returning bytesSmall length:"+bytesSmall.length);
			return (bytesSmall);
		}
		return(null);
	}
	private static String writeBlobBytesForFileSmall(NodeFileSet fileSet, NodeFile nodeFile, String fileName) {
		byte[] bytesSmall = getBlobBytesForFileSmall(fileSet, nodeFile); 
		if (bytesSmall!=null) {
			System.out.println("FileSetBlobGetter writeBlobBytesForFileSmall creating file: "+fileName+" ,bytesSmall length:"+bytesSmall.length);
			boolean created = FileUtil.writeBytesToFile(fileName, bytesSmall);
			if (created) return("ok"); else return("nok");
		}
		return("nok");	
	}
	private static String writeBlobBytesForFile(NodeFileSet fileSet, NodeFile nodeFile, String fileName) {
		String blobHandlerType = null;
		if (nodeFile.getListFileBlobRegular().size() > 0) 		{ blobHandlerType = "regularfile";	}
		else if (nodeFile.getListFileBlobBig().size() > 0) 		{ blobHandlerType = "bigfile";		}
		else if (nodeFile.getListFileBlobSmall().size() > 0) 	{ blobHandlerType = "smallfile";	}
		if (blobHandlerType==null) return (null);
		if ("regularfile".equals(blobHandlerType)) {
			return(writeBlobBytesForFileRegular(fileSet,nodeFile, fileName));
		} else if ("bigfile".equals(blobHandlerType)) {
			return (writeBlobBytesForFileBig(fileSet,nodeFile, fileName));
		} else if ("smallfile".equals(blobHandlerType)) {
			return (writeBlobBytesForFileSmall(fileSet,nodeFile, fileName));
		}
		//byte[] bytes =  "testString".getBytes(); 
		//NodeFileBlob fileBlob = fileSet.getM
		return("nok");	
	}
	private static String checkWrittenFile(NodeFile nodeFile, String fileName)	{
		String checkStr = "ok";
		
		long fileSize = FileUtil.getFileSize(fileName);
		if (nodeFile.getFileSize().longValue()!=fileSize)	{
			System.out.println(" ====checkWrittenFile fileSize id different db File Size:"+nodeFile.getFileSize().longValue() +
					" ,written file size:"+fileSize);	
		}
		System.out.println("");
		return(checkStr);
	}
	public static String writeBlob2File(NodeFileSet fileSet, NodeFile nodeFile, String fileName)	{
		String blobExtractStatus = "ok";
		
		blobExtractStatus = FileSetBlobGetter.writeBlobBytesForFile(fileSet,nodeFile, fileName);  
		
		FilePropertySetter.setFileProperties(fileSet,nodeFile,fileName);
		
		String checkStr = checkWrittenFile(nodeFile, fileName);
		if (!"ok".equals(checkStr))	{
			
		}
		
		return(blobExtractStatus);
	}
}
