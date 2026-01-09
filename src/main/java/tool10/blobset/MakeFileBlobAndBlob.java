package tool10.blobset;

import tool10.f10.NodeF10;

public class MakeFileBlobAndBlob {
	
	//private static final int  minCompressionGainRatio = 10;
	//private static final long minCompressionGainBytes = 1024*1024;

	private static byte[] setBlobCompressionFields(NodeF10 f10, NodeBlob blob, byte[] blobBytes, long blobSize) {
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
		blob.setCompressionFields(compressionType,compressedFileSize,compressionGainRatio,compressionGainBytes,compressedByteHashId,null);
		if ("yes".equals(f10.getCliParams().getBlobCompressed())) {blob.setCompressedBytes(compressedBytes);}
		return(compressedBytes);
	}
	private static byte[] setBlobEncryptionFields(NodeF10 f10, NodeBlob nodeBlob, byte[] inputBytes) {
		Long sandByteLengthHead = null; 
		Long sandByteLengthTail = null;
		String encryptionBlobKey = null; 
		String encryptionType = "shuffle10";
		String encryptionKey = null; //"12345";
		byte[] encryptedBytes = ByteEncryption.encryptByType(encryptionType, encryptionKey, inputBytes);
		Long encryptedSize = (long) encryptedBytes.length;
		Long encrytedByteHashId = null;
		
		//System.out.println("MakeFileSetBlob setBlobEncryptionFields  encryption encryptedBytes.length="+encryptedBytes.length); 
		
		nodeBlob.setEncryptionFields(sandByteLengthHead,sandByteLengthTail,
				encryptionBlobKey,encryptionType,encryptedSize,encrytedByteHashId,null);
		if ("yes".equals(f10.getCliParams().getBlobEncrypted())) {
			nodeBlob.setEncryptedBytes(encryptedBytes);			
		}
		return(encryptedBytes);
	}
	
	public static void updateOneBlobBytes(NodeF10 f10, NodeBlob blob, byte[] blobBytes)	{
		/*		Long blobId = f10.getConnBlob().getNextId(-1); //"BSC_BASIC");
			Long sourceId = fileId;
			Long blobSize = (long) blobBytes.length;
			Long firstPartBlobId = null;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeBlob blob = new NodeBlob(blobId, sourceId, f10.getFileSet().getFileSetId(), firstPartBlobId, partNumber, cntPart, blobType,
							blobSize,fileSize,null,hashId,creationDate,modificationDate);
			f10.getFileSet().getListBlob().add(blob);
			f10.getFileSet().getMapId2Blob().put(blob.getBlobId(),blob);
	 	*/		
		Long blobSize = (long) blobBytes.length;
		
		if ("yes".equals(f10.getCliParams().getBlobOriginal())) {
			blob.setBlobBytes(blobBytes);
			if ((blob.getBlobBytes()!=null) && (blobBytes.length>0)) { f10.getConnBlob().add2BlobSizeToWrite(blobBytes.length); }
		}
		byte[] compressedBytes = null;
		byte[] encryptedBytes = null;
		if ("yes".equals(f10.getCliParams().getCompression())) {
			compressedBytes = setBlobCompressionFields(f10, blob, blobBytes, blobSize);
			if ((compressedBytes!=null) && (compressedBytes.length>0)) { f10.getConnBlob().add2BlobSizeToWrite(compressedBytes.length); }
		}
		if ("yes".equals(f10.getCliParams().getEncryption())) {
			if (compressedBytes!=null) { 
				encryptedBytes = setBlobEncryptionFields(f10, blob, compressedBytes);
			} else {
				encryptedBytes = setBlobEncryptionFields(f10, blob, blobBytes);
			}
			if ((encryptedBytes!=null) && (encryptedBytes.length>0)) { f10.getConnBlob().add2BlobSizeToWrite(encryptedBytes.length); }
		}
	}
	
}
