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
			//public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileTypeId, Long sourceId,
			//		Long fileSize, Long hashCode, Long hashId, String fileType, Long linkedId, String fileStatus,
			//		String fileName, String fileNameAbsolute, String extensionName, String isDirectory, String isFile,
			//		String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	
					" fileId INTEGER PRIMARY KEY, fileSetId INTEGER, parentFileId INTEGER, rootFileId INTEGER, fileTypeId INTEGER, sourceId INTEGER, "+
					" fileSize INTEGER, hashCode INTEGER, hashId INTEGER, "+
					" fileType TEXT, linkedId INTEGER, fileStatus TEXT, fileName TEXT, fileNameAbsolute TEXT, extensionName TEXT, "+
					" isDirectory TEXT, isFile TEXT, fileRemark TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILENAME".equals(tableName))	{
			//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
			//Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
			//String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
			//String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
			//Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
			//String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
			//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
			//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
			//String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
			//String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
			//String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
			//String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
			//String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
			//Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
			//Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
			//Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
			//Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
			//String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
					
			String fieldStr = 	
			"fileNameId INTEGER PRIMARY KEY, fileId INTEGER, fileSetId INTEGER, fileNameTypeId INTEGER, nameLanguageId INTEGER, \r\n"+
			"nameLanguageId2 INTEGER, nameHashId INTEGER, depth INTEGER, depthFromRoot INTEGER, fileName TEXT, \r\n"+
			"fileNameRelative TEXT, fileNameAbsolute TEXT, fileNameCanonical TEXT, fileURI TEXT, fileURL TEXT, \r\n"+
			"extensionName TEXT, nameWithoutExtension TEXT, dirNameRelative TEXT, dirNameAbsolute TEXT, \n"+
			"fileNameLength INTEGER, fileNameAbsoluteLength INTEGER, compressedNameSize INTEGER, fileName83 TEXT,\n"+
			"altName1 TEXT, altName2 TEXT, altName3 TEXT, altNameFromTag TEXT, altNameFromContent TEXT,\n"+
			"onlyAsciiLetter TEXT, onlyDigit TEXT, onlyUTFLetter TEXT, sortedLetters TEXT,\n"+
			"sortedLettersUnique TEXT, compressedName TEXT, encryptedNameRelative TEXT, encryptedNameAbsolute TEXT, isNameValid TEXT,\n"+
			"validityRemark TEXT, isNameCorrect TEXT, correctedName TEXT, correctnessRemark TEXT,\n"+
			"goodnessLevel TEXT, goodnessRemark TEXT, goodNameSuggested TEXT, isHumanGiven TEXT,\n"+
			"isGenerated TEXT, isHumanUnderstandable TEXT, nameEncoding TEXT, nameCharsetStr TEXT,\n"+
			"nameRemark TEXT, strEntityType TEXT, strEntityStr TEXT, strEntityId INTEGER, strEntityType2 TEXT,\n"+
			"strEntityStr2 TEXT, strEntityId2 INTEGER, cntLetter INTEGER, cntLetterUnique INTEGER, cntAsciiLetter INTEGER,\n"+
			"cntAsciiLetterUppercase INTEGER, cntAsciiLetterLowercase INTEGER, cntAsciiUnprintable INTEGER, cntNonAscii INTEGER,\n"+
			"cntUTFLetter INTEGER, cntUTFLetterByte1 INTEGER, cntUTFLetterByte2 INTEGER, cntUTFLetterByte3 INTEGER, \n"+ 
			"cntUTFLetterByte4 INTEGER, cntEmoji INTEGER, cntDigit INTEGER, cntDigitUnique INTEGER, cntSpace INTEGER, \n"+
			"cntUnderscore INTEGER, cntDash INTEGER, parsedNum INTEGER, parsedZDT TEXT, tokenizedName TEXT, \n"+
			"arrayToken BLOB,arrayLetter BLOB,arrayLetterCnt BLOB,arrayTokenId BLOB, creationDate TEXT,modificationDate TEXT \n";			
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("FS_FILEPROP".equals(tableName))	{
			//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
			//String propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
			//Long hashCode, String fileType, String linkType, Long linkedId, String ownerName, String computerName,
			//String canExecute, String canRead, String canWrite, String isExists, String isDirectory, String isFile,
			//String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
			//String isOther, String isRegularFile, String probeContentType, String isCompressed, String isEncrypted,
			//String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
			//String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
			//String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
			//String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
			//Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
			//Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
			//String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
			//Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
			//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
			String fieldStr = 	
			"filePropId INTEGER PRIMARY KEY, fileId INTEGER, fileSetId INTEGER, fileSystemId INTEGER, fileStoreId INTEGER, \r\n"+
			"propertyType TEXT, signatureId INTEGER, fileSize INTEGER, fileSizeOnDisk INTEGER, fileSizeClass TEXT, \r\n"+
			"hashCode INTEGER, fileType TEXT, linkType TEXT, linkedId INTEGER, ownerName TEXT, computerName TEXT, \r\n"+
			"canExecute TEXT, canRead TEXT, canWrite TEXT, isExists TEXT, isDirectory TEXT, isFile TEXT, \r\n"+
			"isSymbolicLink TEXT, isHidden TEXT, isArchive TEXT, isSystem TEXT, isReadOnly TEXT, \r\n"+
			"isOther TEXT, isRegularFile TEXT, probeContentType TEXT, isCompressed TEXT, isEncrypted TEXT, \r\n"+
			"isIndexed TEXT, isContentIndexed TEXT, isBlocked TEXT, isSystemFile TEXT, isAppFile TEXT, \r\n"+
			"isCompanyFile TEXT, isUserFile TEXT, isExecutable TEXT, isTextFile TEXT, isXMLFile TEXT, \r\n"+
			"isConfigFile TEXT, isBinaryFile TEXT, isImmutable TEXT, isInUserPath TEXT, isInSystemPath TEXT, \r\n"+
			"isShareable TEXT, isShared TEXT, hasPreviousVersions TEXT, uxPermission TEXT, uxInfo TEXT, \r\n"+
			"compressedFileSize INTEGER, compressionGainRatio REAL, compressionGainBytes INTEGER, duration INTEGER, \r\n"+
			"contentLanguageId INTEGER, contentLanguageId2 INTEGER, contentEncoding TEXT, contentCharsetStr TEXT, \r\n"+
			"iconName TEXT, origin TEXT, copyrightInfo TEXT, licenseInfo TEXT, assetInfo TEXT, dlpInfo TEXT, \r\n"+
			"lastModified INTEGER, fileCreationDate TEXT, fileModificationDate TEXT, \r\n"+
			"fileLastAccessTime TEXT, fileRemark TEXT, creationDate TEXT, modificationDate TEXT \r\n";			
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