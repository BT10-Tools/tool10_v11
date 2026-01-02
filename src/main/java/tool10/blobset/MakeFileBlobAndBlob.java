package tool10.blobset;

import java.sql.Connection;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.WriteFsTablesToDb;
import tool10.fileset.nodes.NodeFileBlob;

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
	public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)	{
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, String blobType,
		//		Long blobSize, Long fileSize, byte[] fileBytes, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
		try {
			Long fileBlobId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeFileBlob fileBlob = new NodeFileBlob(fileBlobId, fileId, f10.getFileSet().getFileSetId(), blobType,
							blobSize,fileSize,null,hashId,creationDate,modificationDate);
			f10.getFileSet().getListFileBlob().add(fileBlob);
			f10.getFileSet().getMapId2FileBlob().put(fileBlob.getFileBlobId(),fileBlob);
			
			return(fileBlob);
		} catch (Exception e)	{
			
		}
		return(null);
	}
	
	public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes, Long hashId)	{
		//public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, Long fileSize, byte[] blobBytes, Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long blobId = f10.getConnBlob().getNextId(-1); //"BSC_BASIC");
			Long sourceId = fileId;
			Long blobSize = (long) blobBytes.length;
			Long firstPartBlobId = null;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeBlob blob = new NodeBlob(blobId, sourceId, f10.getFileSet().getFileSetId(), firstPartBlobId, partNumber, cntPart, blobType,
							blobSize,fileSize,null,hashId,creationDate,modificationDate);
			f10.getFileSet().getListBlob().add(blob);
			f10.getFileSet().getMapId2Blob().put(blob.getBlobId(),blob);
			
			if ("yes".equals(f10.getCliParams().getBlobOriginal())) {
				blob.setBlobBytes(blobBytes);
				if ((blobBytes!=null) && (blobBytes.length>0)) { f10.getConnBlob().add2BlobSizeToWrite(blobBytes.length); }
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
			
			return(blob);
		} catch (Exception e)	{
		
		}
		return(null);
	}
	public static int writeFileBlobList2Db(Connection conn, ArrayList<NodeFileBlob> tmpListFileBlob)	{ 
		if ((tmpListFileBlob==null) || (tmpListFileBlob.isEmpty()))	return(0); 	
		int cntWritten = WriteFsTablesToDb.writeTableFileBlob(conn,tmpListFileBlob);
		return(cntWritten);
	}	
	public static int writeFileBlob2Db(Connection conn, NodeFileBlob fileBlob)	{ 
		if (fileBlob==null)	return(0); 	
		ArrayList<NodeFileBlob> tmpListFileBlob = new ArrayList<>();
		tmpListFileBlob.add(fileBlob);
		int cntWritten = WriteFsTablesToDb.writeTableFileBlob(conn,tmpListFileBlob);
		return(cntWritten);
	}	
	public static int writeBlob2Db(Connection conn, NodeBlob nodeBlob)	{ 
		if (nodeBlob==null)	return(0); 	
		ArrayList<NodeBlob> tmpListBlob = new ArrayList<>();
		tmpListBlob.add(nodeBlob);
		String blobTableName = ""; 
		String blobDbAttachmentName = "";
		int cntWritten = WriteFsTablesToDb.writeTableBlob(conn,blobTableName,blobDbAttachmentName,tmpListBlob);
		nodeBlob.setCompressedBytes(null);
		nodeBlob.setBlobBytes(null);
		nodeBlob.setEncryptedBytes(null);
		return(cntWritten);
	}	
}
