package tool10.blobset;

import java.sql.Connection;
import java.time.ZonedDateTime;

public class CreateBlobSetTableSql {
	
	public static String getCreateTableSqlStr(Connection conn,String tableName)	{
		
		String sqlStr = null; 
		if ("BLOB_BLOBSET".equals(tableName))	{
			//public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
			//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"blobSetId INTEGER PRIMARY KEY,sourceId INTEGER,blobSetName TEXT,blobSetDesc TEXT,blobSetURL TEXT,ownerName TEXT, "+
								"displayOrder INTEGER, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BLOB_BLOB".equals(tableName))	{
			//public NodeBlob(Long blobId, Long blobEntityId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
			//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
			//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
			//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"blobId INTEGER PRIMARY KEY, blobEntityId INTEGER, blobSetId INTEGER, firstPartBlobId INTEGER, partNumber INTEGER, cntPart INTEGER, blobType TEXT,"+
								"blobSize INTEGER, compressionType TEXT, compressedSize INTEGER, compressionGainRatio REAL, "+
								"compressionGainBytes INTEGER, compressedByteHashId INTEGER, sandByteLengthHead INTEGER, "+ 
								"sandByteLengthTail INTEGER, encryptionBlobKey TEXT, encryptionType TEXT, encryptedSize INTEGER, encrytedByteHashId INTEGER, "+
								"blobBytes BLOB, compressedBytes BLOB, encryptedBytes BLOB, blobHashId INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BLOB_BLOBENTITY".equals(tableName))	{
			//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
			//Long sourceSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
			//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"blobEntityId INTEGER PRIMARY KEY, entityId INTEGER, blobId INTEGER, blobSetId INTEGER, blobType TEXT, blobSize INTEGER, "+
								"sourceSize INTEGER, hashId INTEGER, blobDbName TEXT, blobDbAttachmentName TEXT, blobTableName TEXT, "+
								"bigPartNumber INTEGER, bigCntPart INTEGER, smallByteIndexStart INTEGER,smallByteIndexEnd INTEGER, "+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BLOB_BLOBHASH".equals(tableName))	{
			//public NodeBlobHash(Long blobHashId, Long blobId, Long blobEntityId, Long blobSetId, Long blobSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
			//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
			//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
			//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"blobHashId INTEGER PRIMARY KEY,blobId INTEGER, blobEntityId INTEGER,blobSetId INTEGER, blobSize INTEGER, crc64 INTEGER, crc32 INTEGER, "+
								"adler32 INTEGER, blake3 TEXT, md5 TEXT, sha1 TEXT,sha256 TEXT,sha384 TEXT,sha512 TEXT,sha3256 TEXT,keccak256 TEXT, "+
								"hashFieldDesc TEXT, hashStr01 TEXT, hashStr02 TEXT, hashStr03 TEXT, hashStr04 TEXT, "+
								"hashStr05 TEXT, hashLong01 INTEGER, hashLong02 INTEGER, hashLong03 INTEGER, hashLong04 INTEGER, hashLong05 INTEGER, "+
								"creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("REG_ENTITYID".equals(tableName))	{
			String fieldStr = "EntityId INTEGER PRIMARY KEY AUTOINCREMENT, tableName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} 		 	
		return(sqlStr);
	}
}