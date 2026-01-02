package tool10.fileset;

import java.sql.Connection;
import java.time.ZonedDateTime;

public class CreateFileSetTableSql {
	
	public static String getCreateTableSqlStr(Connection conn,String tableName)	{
		//"FS_FILESET","FS_FILE","FS_FILEBLOB","FS_FILEBLOBSMALL","FS_FILEGROUP","FS_FILEGROUPMEMBER",
		//"FS_FILESYSTEM","FS_FILESTORE","FS_HASH","FS_HOST","FS_PROPERTY","FS_QUERY","FS_SIMILARITY","FS_STAT","REG_ENTITYID"
		
		String sqlStr = null; 
		if ("FS_FILESET".equals(tableName))	{
			//public NodeFileSet(Long fileSetId, Long sourceId, String fileSetName, String fileSetDesc, String fileSetURL,
			//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileSetId INTEGER PRIMARY KEY,sourceId INTEGER,fileSetName TEXT,fileSetDesc TEXT,fileSetURL TEXT,ownerName TEXT, "+
								"displayOrder INTEGER, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILE".equals(tableName))	{
			//public NodeFile(Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId, Long parentFileId, Long rootFileId, Long fileTypeId,
			//Long sourceId, Long languageId, Long languageId2, Long fileSize, Long hashCode, Long hashId,
			//String fileType, String linkType, Long linkedId, String fileRemark, Long depth, Long depthFromRoot, String fileName, String fileNameRelative, String fileNameAbsolute,
			//String fileNameCanonical, String dirNameRelative, String dirNameAbsolute, String altName1, String altName2, String altName3,
			//String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId ,
			//String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
			//Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite,
			//String isExists, String isDirectory, String isFile, String isSymbolicLink, String isHidden, String isReadOnly,String isOther,
			//String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
			//Long compressionGainBytes, String encoding, String charsetStr,Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
			//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	
					"fileId INTEGER PRIMARY KEY, fileSetId INTEGER, fileSystemId INTEGER, fileStoreId INTEGER, parentFileId INTEGER, rootFileId INTEGER, fileTypeId INTEGER, "+
					"sourceId INTEGER, languageId INTEGER, languageId2 INTEGER, fileSize INTEGER, hashCode INTEGER, hashId INTEGER, "+
					"fileType TEXT, linkType TEXT, linkedId INTEGER, fileStatus TEXT, depth INTEGER, depthFromRoot INTEGER, fileName TEXT, fileNameRelative TEXT, fileNameAbsolute TEXT, "+
					"fileNameCanonical TEXT, dirNameRelative TEXT, dirNameAbsolute TEXT, altName1 TEXT, altName2 TEXT, altName3 TEXT, "+
					"encryptedNameRelative TEXT, encryptedNameAbsolute TEXT, nameHashId INTEGER, "+
					"fileURI TEXT, fileURL TEXT, extensionName TEXT, nameWithoutExtension TEXT, "+
					"fileNameAbsoluteLength INTEGER, ownerName TEXT, canExecute TEXT, canRead TEXT, canWrite TEXT, "+
					"isExists TEXT, isDirectory TEXT, isFile TEXT, isSymbolicLink TEXT, isHidden TEXT, isReadOnly TEXT, isArchive TEXT, isSystem TEXT, isOther TEXT, "+
					"isRegularFile TEXT, probeContentType TEXT, freeSpace INTEGER, totalSpace INTEGER, usableSpace INTEGER, compressedFileSize INTEGER, compressionGainRatio REAL,"+
					"compressionGainBytes INTEGER, encoding TEXT, charsetStr TEXT, "+
					"lastModified INTEGER, fileCreationDate TEXT, fileModificationDate TEXT, fileLastAccessTime TEXT, fileRemark TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_BLOB".equals(tableName))	{
			//public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
			//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
			//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
			//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
			String fieldStr = 	"blobId INTEGER PRIMARY KEY, sourceId INTEGER, fileSetId INTEGER, firstPartBlobId INTEGER, partNumber INTEGER, cntPart INTEGER, blobType TEXT,"+
								"blobSize INTEGER, compressionType TEXT, compressedSize INTEGER, compressionGainRatio REAL, "+
								"compressionGainBytes INTEGER, compressedByteHashId INTEGER, sandByteLengthHead INTEGER, "+ 
								"sandByteLengthTail INTEGER, encryptionBlobKey TEXT, encryptionType TEXT, encryptedSize INTEGER, encrytedByteHashId INTEGER, "+
								"blobBytes BLOB, compressedBytes BLOB, encryptedBytes BLOB, blobHashId INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEBLOB".equals(tableName))	{
			//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
			//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
			//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileBlobId INTEGER PRIMARY KEY, fileId INTEGER, blobId INTEGER, fileSetId INTEGER, blobType TEXT, blobSize INTEGER, "+
								"fileSize INTEGER, hashId INTEGER, blobDbName TEXT, blobDbAttachmentName TEXT, blobTableName TEXT, "+
								"bigPartNumber INTEGER, bigCntPart INTEGER, smallByteIndexStart INTEGER,smallByteIndexEnd INTEGER, "+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEBLOBOLD".equals(tableName))	{
			//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
			//		Long blobSize, Long fileSize, String compressionType, Long compressedFileSize, Double compressionGainRatio,
			//		Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			//		Long encryptedFileSize, Long encrytedByteHashId,byte[] fileBytes, byte[] compressedBytes, byte[] encyptedBytes, 
			//		Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileBlobId INTEGER PRIMARY KEY, fileId INTEGER, fileSetId INTEGER, partNumber INTEGER, cntPart INTEGER, blobType TEXT,"+
								"blobSize INTEGER, fileSize INTEGER, compressionType TEXT, compressedFileSize INTEGER, compressionGainRatio REAL, "+
								"compressionGainBytes INTEGER, compressedByteHashId INTEGER, sandByteLengthHead INTEGER, "+ 
								"sandByteLengthTail INTEGER, encryptionBlobKey TEXT, encryptionType TEXT, encryptedFileSize INTEGER, encrytedByteHashId INTEGER, "+
								"fileBytes BLOB, compressedBytes BLOB, encryptedBytes BLOB, hashId INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEBLOBSMALLold".equals(tableName))	{
			//public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
			//Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileBlobSmallId INTEGER PRIMARY KEY,fileBlobId INTEGER,fileId INTEGER,fileSetId INTEGER,byteIndexStart INTEGER, "+
								"byteIndexEnd INTEGER,hashId INTEGER,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEGROUP".equals(tableName))	{
			//public NodeFileGroup(Long fileGroupId, Long fileSetId, Long sourceId, Long higherFileGroupId, String fileGroupName,
			//String fileGroupDesc, Long displayOrder, Long cntMember, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileGroupId INTEGER PRIMARY KEY,fileSetId INTEGER, sourceId INTEGER, higherFileGroupId INTEGER, fileGroupName TEXT, "+
								"fileGroupDesc TEXT, displayOrder INTEGER, cntMember INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEGROUPMEMBER".equals(tableName))	{
			//public NodeFileGroupMember(Long fileGroupMemberId, Long fileGroupId, Long fileSetId, Long fileId, Long displayOrder,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileGroupMemberId INTEGER PRIMARY KEY, fileGroupId INTEGER,fileSetId INTEGER, fileId INTEGER, displayOrder INTEGER, "+
								"cntMember INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILESYSTEM".equals(tableName))	{
			//public NodeFileSystem(Long fileSystemId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder,
			//String systemName, String providerName, Long providerHashCode, String isDefault, String isOpen, String isReadOnly,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileSystemId INTEGER PRIMARY KEY, fileSetId INTEGER, hostId INTEGER, rootFileId INTEGER, displayOrder INTEGER,\r\n"
					+ "			systemName TEXT, providerName TEXT, providerHashCode INTEGER, isDefault TEXT, isOpen TEXT, isReadOnly TEXT,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILESTORE".equals(tableName))	{
			//public NodeFileStore(Long fileStoreId, Long fileSetId, Long fileSystemId, Long rootFileId, Long displayOrder, Long blockSize,
			//Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
			//String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"fileStoreId INTEGER PRIMARY KEY, fileSetId INTEGER, fileSystemId INTEGER, rootFileId INTEGER, displayOrder INTEGER, blockSize INTEGER, "+
								"totalSpace INTEGER, unallocatedSpace INTEGER, usableSpace INTEGER, usedSpace INTEGER, hashCode INTEGER, "+
								"rootDirectoryName TEXT, isReadOnly TEXT, nameStr TEXT, toString TEXT, typeStr TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_HASH".equals(tableName))	{
			//public NodeHash(Long hashId, Long fileSetId, Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
			//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
			//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
			//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"hashId INTEGER PRIMARY KEY,fileSetId INTEGER, fileSize INTEGER, crc64 INTEGER, crc32 INTEGER, adler32 INTEGER, blake3 TEXT, md5 TEXT, "+
								"sha1 TEXT,sha256 TEXT,sha384 TEXT,sha512 TEXT,sha3256 TEXT,keccak256 TEXT, "+
								"hashFieldDesc TEXT, hashStr01 TEXT, hashStr02 TEXT, hashStr03 TEXT, hashStr04 TEXT, "+
								"hashStr05 TEXT, hashLong01 INTEGER, hashLong02 INTEGER, hashLong03 INTEGER, hashLong04 INTEGER, hashLong05 INTEGER, "+
								"creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_HOST".equals(tableName))	{
			//public NodeHost(Long hostId, Long fileSetId, String hostName, String hostIP, String domainName,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"hostId INTEGER PRIMARY KEY, fileSetId INTEGER, hostName TEXT, hostIP TEXT, domainName TEXT, "+
								"creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_PROPERTY".equals(tableName))	{
			//public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
			//String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
			//Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"propertyId INTEGER PRIMARY KEY, fileSetId INTEGER, entityId INTEGER, displayOrder INTEGER, mapName TEXT, entityName TEXT, propertyKey TEXT, propertyValue TEXT,"+
								"valueString TEXT, valueLong INTEGER, valueDouble REAL, valueBinary REAL, valueZDT TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_QUERY".equals(tableName))	{
			//public NodeQuery(Long queryId, Long fileSetId, Long entityId, Long cntExecution, String sqlString,
			//ZonedDateTime firstExecutionDate, ZonedDateTime lastExecutionDate, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
			String fieldStr = 	"queryId INTEGER PRIMARY KEY,fileSetId INTEGER, entityId INTEGER, cntExecution INTEGER, sqlString TEXT, "+
								"firstExecutionDate TEXT, lastExecutionDate TEXT, INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_STAT".equals(tableName))	{
			//public NodeStat(Long statId, Long fileSetId, Long entityId, String entityIdType, String statType,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"statId INTEGER,fileSetId INTEGER, entityId INTEGER, entityIdType TEXT, statType TEXT, "+
								"creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";

		} else if ("XXX_STAT".equals(tableName))	{
			//it will be removed, may help in writing the FS_STAT 
			//public NodeStat(Long statId, Long entityId, String statType, Long fileTxtGroupId, Long sourceId, Long languageId,
			//Long languageId2, Long fileSize, Long cntDistinctLanguageId, Long cntDistinctEncoding,
			//Long cntFile, Long cntLine, Long cntDistinctLine, Long cntEmptyLine, Long minCntLinePerFile,
			//Long maxCntLinePerFile, Long cntCharacter, Long cntDistinctCharacter, Long cntColumn, Long avgColumn,
			//Long cntPhrase, Long cntDistinctPhrase, Long cntToken, Long cntDistinctToken, Double minLineLength,
			//Double maxLineLength, Double sumLineLength, Double avgLineLength, Long crc64, ZonedDateTime creationDate,
			//ZonedDateTime modificationDate) {
			String fieldStr = 	"statId INTEGER PRIMARY KEY, entityId INTEGER, statType TEXT, fileTxtGroupId INTEGER, sourceId INTEGER, languageId INTEGER,"+
								"languageId2 INTEGER, fileSize INTEGER, cntDistinctLanguageId INTEGER, cntDistinctEncoding INTEGER,"+
								"cntFile INTEGER, cntLine INTEGER, cntDistinctLine INTEGER, cntEmptyLine INTEGER, minCntLinePerFile INTEGER,"+
								"maxCntLinePerFile INTEGER, cntCharacter INTEGER, cntDistinctCharacter INTEGER, cntColumn INTEGER, avgColumn INTEGER,"+
								"cntPhrase INTEGER, cntDistinctPhrase INTEGER, cntToken INTEGER, cntDistinctToken INTEGER, minLineLength INTEGER,"+
								"maxLineLength INTEGER, sumLineLength INTEGER, avgLineLength REAL, crc64 INTEGER,"+
								"creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_ARCHIVE".equals(tableName))	{
			//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
			//String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
			//Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
			//Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
			//ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	
					"archiveId INTEGER PRIMARY KEY, fileSetId INTEGER, archiveFileId INTEGER, archiveFileSetId INTEGER,archiveType TEXT, "+
					"extensionType TEXT, algorithmName TEXT, multipleFileArchive TEXT, archiveRemark TEXT, cntFile INTEGER, "+
					"cntArchive INTEGER, cntDirectory, cntFileTree INTEGER, cntDirectoryTree INTEGER, originalFileSize INTEGER, "+
					"unzippedFileSize INTEGER, unzipGainRatio REAL,unzippedGainBytes INTEGER, archiveCreationDate TEXT, "+
					"archiveModificationDate TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";					
		} else if ("FS_CONTAINER".equals(tableName))	{
			//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
			//String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
			//Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	
					"containerId INTEGER PRIMARY KEY, fileSetId INTEGER, containerFileId INTEGER, containerFileSetId INTEGER," + 
					"containerType TEXT, extensionType TEXT, algorithmName TEXT, containerRemark TEXT, cntFile INTEGER, "+
					"originalFileSize INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";					
		} else if ("FS_TRANSFORM".equals(tableName))	{
			//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
			//Long transformedFileId, String transformType, String extensionType, String algorithmName,
			//String transformRemark, String tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	
					"transformId INTEGER PRIMARY KEY, fileSetId INTEGER, transformFileId INTEGER, transformFileSetId INTEGER," + 
					"transformedFileId INTEGER, transformType TEXT, extensionType TEXT, algorithmName TEXT, transformRemark TEXT, tmpFileName TEXT, "+
					"cntFile INTEGER, originalFileSize INTEGER, transformedFileSize INTEGER, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";					
		}  else if ("REG_ENTITYID".equals(tableName))	{
			String fieldStr = "EntityId INTEGER PRIMARY KEY AUTOINCREMENT, tableName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} 		 	
		return(sqlStr);
	}
}