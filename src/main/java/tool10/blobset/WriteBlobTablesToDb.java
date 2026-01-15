package tool10.blobset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class WriteBlobTablesToDb {

	public static int writeTableBlobHash(Connection conn,NodeBlobSet blobSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BLOB_BLOBHASH(blobHashId,blobId,blobEntityId,blobSetId,blobSize,crc64,crc32,adler32,blake3,md5,\r\n"
				+ "		sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,hashStr02,hashStr03,hashStr04,\r\n"
				+ "		hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  "+
				                "?, ?, ?, ?, ?,    ?, ?, ?, ?)";
		//public NodeBlobHash(Long blobHashId, Long blobId, Long blobEntityId, Long blobSetId, Long blobSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBlobHash ent : blobSet.getListBlobHash())	{
			    int cnt=1;
			    if (ent.getBlobHashId()!=null) {ps.setLong(cnt++, ent.getBlobHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobId()!=null) {ps.setLong(cnt++, ent.getBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobEntityId()!=null) {ps.setLong(cnt++, ent.getBlobEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobSetId()!=null) {ps.setLong(cnt++, ent.getBlobSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc32()!=null) {ps.setLong(cnt++, ent.getCrc32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAdler32()!=null) {ps.setLong(cnt++, ent.getAdler32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlake3());
			    ps.setString(cnt++, ent.getMd5());
			    ps.setString(cnt++, ent.getSha1());
			    ps.setString(cnt++, ent.getSha256());
			    ps.setString(cnt++, ent.getSha384());
			    ps.setString(cnt++, ent.getSha512());
			    ps.setString(cnt++, ent.getSha3256());
			    ps.setString(cnt++, ent.getKeccak256());
			    ps.setString(cnt++, ent.getHashFieldDesc());
			    ps.setString(cnt++, ent.getHashStr01());
			    ps.setString(cnt++, ent.getHashStr02());
			    ps.setString(cnt++, ent.getHashStr03());
			    ps.setString(cnt++, ent.getHashStr04());
			    ps.setString(cnt++, ent.getHashStr05());
			    if (ent.getHashLong01()!=null) {ps.setLong(cnt++, ent.getHashLong01());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong02()!=null) {ps.setLong(cnt++, ent.getHashLong02());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong03()!=null) {ps.setLong(cnt++, ent.getHashLong03());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong04()!=null) {ps.setLong(cnt++, ent.getHashLong04());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong05()!=null) {ps.setLong(cnt++, ent.getHashLong05());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableBlobHash: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBlobEntity(Connection conn, ArrayList<NodeBlobEntity> listBlobEntity)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BLOB_BLOBENTITY (blobEntityId,entityId,blobId,blobSetId, blobType, blobSize, \r\n"+
						"sourceSize, hashId, entityName, blobDbName, blobDbAttachmentName, blobTableName, \r\n" +
				 		"bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, \r\n"+
				 		"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
		//Long sourceSize, Long hashId, String entityName, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBlobEntity ent : listBlobEntity)	{
			    int cnt=1;
			    if (ent.getBlobEntityId()!=null) {ps.setLong(cnt++, ent.getBlobEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobId()!=null) {ps.setLong(cnt++, ent.getBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobSetId()!=null) {ps.setLong(cnt++, ent.getBlobSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceSize()!=null) {ps.setLong(cnt++, ent.getSourceSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEntityName());
			    ps.setString(cnt++, ent.getBlobDbName());
			    ps.setString(cnt++, ent.getBlobDbAttachmentName());
			    ps.setString(cnt++, ent.getBlobTableName());
			    
			    if (ent.getBigPartNumber()!=null) {ps.setLong(cnt++, ent.getBigPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBigCntPart()!=null) {ps.setDouble(cnt++, ent.getBigCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexStart()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexStart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexEnd()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexEnd());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableBlobEntity: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBlob(Connection conn, ArrayList<NodeBlob> listBlob)	{ //String blobTableName2, String blobDbAttachmentName2,
		int cntInserted = 0;
		String query =  "INSERT INTO BLOB_BLOB (blobId,blobEntityId,blobSetId,firstPartBlobId,partNumber,cntPart,blobType,"+
						"blobSize,compressionType,compressedSize,compressionGainRatio,\r\n"+
						"compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType, "+
						"encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes, \r\n"+
				 		"blobHashId,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeBlob(Long blobId, Long blobEntityId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBlob ent : listBlob)	{
			    int cnt=1;
			    if (ent.getBlobId()!=null) {ps.setLong(cnt++, ent.getBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobEntityId()!=null) {ps.setLong(cnt++, ent.getBlobEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobSetId()!=null) {ps.setLong(cnt++, ent.getBlobSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFirstPartBlobId()!=null) {ps.setLong(cnt++, ent.getFirstPartBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPartNumber()!=null) {ps.setLong(cnt++, ent.getPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntPart()!=null) {ps.setLong(cnt++, ent.getCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getCompressionType());
			    if (ent.getCompressedSize()!=null) {ps.setLong(cnt++, ent.getCompressedSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainRatio()!=null) {ps.setDouble(cnt++, ent.getCompressionGainRatio());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainBytes()!=null) {ps.setLong(cnt++, ent.getCompressionGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressedByteHashId()!=null) {ps.setLong(cnt++, ent.getCompressedByteHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getSandByteLengthHead()!=null) {ps.setLong(cnt++, ent.getSandByteLengthHead()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSandByteLengthTail()!=null) {ps.setLong(cnt++, ent.getSandByteLengthTail()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEncryptionBlobKey());
			    ps.setString(cnt++, ent.getEncryptionType());
			    if (ent.getEncryptedSize()!=null) {ps.setLong(cnt++, ent.getEncryptedSize()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEncrytedByteHashId()!=null) {ps.setLong(cnt++, ent.getEncrytedByteHashId()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getBlobBytes()!=null) 		{ps.setBytes(cnt++, ent.getBlobBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCompressedBytes()!=null) {ps.setBytes(cnt++, ent.getCompressedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getEncryptedBytes()!=null) 	{ps.setBytes(cnt++, ent.getEncryptedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    
			    //compressedBytes,encyptedBytes
			    
			    if (ent.getBlobHashId()!=null) {ps.setLong(cnt++, ent.getBlobHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableBlobSet(Connection conn,NodeBlobSet blobSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO BLOB_BLOBSET (blobSetId,sourceId,blobSetName,blobSetDesc,blobSetURL,ownerName,displayOrder,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?, ?, ?)";
		//public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (blobSet.getBlobSetId()!=null) {ps.setLong(cnt++, blobSet.getBlobSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    if (blobSet.getSourceId()!=null) {ps.setLong(cnt++, blobSet.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    ps.setString(cnt++, blobSet.getBlobSetName());
		    ps.setString(cnt++, blobSet.getBlobSetDesc());
		    ps.setString(cnt++, blobSet.getBlobSetURL());
		    ps.setString(cnt++, blobSet.getOwnerName());
		    if (blobSet.getDisplayOrder()!=null) {ps.setLong(cnt++, blobSet.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    if (blobSet.getCreationDate()!=null) 	{ps.setString(cnt++, blobSet.getCreationDate().toString()); } 		else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (blobSet.getModificationDate()!=null) {ps.setString(cnt++, blobSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableBlobSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeBlobSet(Connection conn,  NodeBlobSet blobSet)	{
		int cntInsertedBlobSet = writeTableBlobSet(conn,blobSet);
		int cntInsertedBlob = writeTableBlob(conn,blobSet.getListBlob());
		int cntInsertedBlobEntity = writeTableBlobEntity(conn,blobSet.getListBlobEntity());
		int cntInsertedBlobHash = writeTableBlobHash(conn,blobSet);
		
		int cntInserted = cntInsertedBlobSet + cntInsertedBlob + cntInsertedBlobEntity + cntInsertedBlobHash;  
		return(cntInserted);
	}	
	public static void writeBlobSetTables(Connection conn, NodeBlobSet blobSet)	{
		writeBlobSet(conn,blobSet);
	}
	
}