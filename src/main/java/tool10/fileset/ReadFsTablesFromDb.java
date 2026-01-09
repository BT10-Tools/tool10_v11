package tool10.fileset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import tool10.fileset.nodes.NodeBinary;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.nodes.NodeQuery;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class ReadFsTablesFromDb {
	
	public static int readTableFile(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" fileId,fileSetId,parentFileId,rootFileId,fileTypeId,sourceId,fileSize,hashCode,hashId,fileType,linkedId,fileStatus, \n"+  
			" fileName,fileNameAbsolute,extensionName,isDirectory,isFile,fileRemark,creationDate,modificationDate \n"+
			" FROM FS_FILE WHERE fileSetId = ? ORDER BY fileId"; 
		//public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileTypeId, Long sourceId,
		//		Long fileSize, Long hashCode, Long hashId, String fileType, Long linkedId, String fileStatus,
		//		String fileName, String fileNameAbsolute, String extensionName, String isDirectory, String isFile,
		//		String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long parentFileId = rs.getLong("parentFileId");	if (rs.wasNull()) {parentFileId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long fileTypeId = rs.getLong("fileTypeId");	if (rs.wasNull()) {fileTypeId = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long hashCode = rs.getLong("hashCode");	if (rs.wasNull()) {hashCode = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String fileType = rs.getString("fileType");
				Long linkedId = rs.getLong("linkedId");	if (rs.wasNull()) {linkedId = null;}
				String fileStatus = rs.getString("fileStatus");
				String fileName = rs.getString("fileName");
				String fileNameAbsolute = rs.getString("fileNameAbsolute");
				String extensionName = rs.getString("extensionName");
				String isDirectory = rs.getString("isDirectory");
				String isFile = rs.getString("isFile");
				String fileRemark = rs.getString("fileRemark");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFile newFile = new NodeFile(fileId,fileSetId,parentFileId,rootFileId,fileTypeId,sourceId,
					fileSize,hashCode,hashId,fileType,linkedId,fileStatus,
					fileName,fileNameAbsolute,extensionName,isDirectory,isFile,
					fileRemark,creationDate,modificationDate);
				
				fileSet.getListFile().add(newFile); 
				fileSet.getMapId2File().put(newFile.getFileId(),newFile); 
				cntRead++; 
			}
			System.out.println("readTableFile: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	}
	public static int readTableFileName(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT fileNameId, fileId, fileSetId, fileNameTypeId, nameLanguageId,nameLanguageId2, nameHashId, depth, depthFromRoot, fileName,"+
			"fileNameRelative, fileNameAbsolute, fileNameCanonical, fileURI, fileURL,extensionName, nameWithoutExtension, dirNameRelative, dirNameAbsolute, \r\n"+
			"fileNameLength, fileNameAbsoluteLength, compressedNameSize, fileName83,	altName1, altName2, altName3, altNameFromTag, altNameFromContent, \r\n"+
			"onlyAsciiLetter, onlyDigit, onlyUTFLetter, sortedLetters,sortedLettersUnique,compressedName,encryptedNameRelative, encryptedNameAbsolute, isNameValid, \r\n"+
			"validityRemark, isNameCorrect, correctedName, correctnessRemark,goodnessLevel, goodnessRemark, goodNameSuggested, isHumanGiven, \r\n"+
			"isGenerated, isHumanUnderstandable, nameEncoding, nameCharsetStr,nameRemark, strEntityType, strEntityStr, strEntityId, strEntityType2, \r\n"+
			"strEntityStr2, strEntityId2, cntLetter, cntLetterUnique, cntAsciiLetter,cntAsciiLetterUppercase, cntAsciiLetterLowercase, cntAsciiUnprintable, cntNonAscii, \r\n"+
			"cntUTFLetter, cntUTFLetterByte1, cntUTFLetterByte2, cntUTFLetterByte3,cntUTFLetterByte4, cntEmoji, cntDigit, cntDigitUnique, cntSpace, \r\n"+
			"cntUnderscore, cntDash, parsedNum, parsedZDT, tokenizedName, \r\n"+
			"arrayToken, arrayLetter, arrayLetterCnt, arrayTokenId,creationDate, modificationDate \r\n"+
			" FROM FS_FILENAME WHERE fileSetId = ? ORDER BY fileNameId"; 
		//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
		//Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
		//String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
		//String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
		//Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
		//String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
		//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
		//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
		
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileNameId = rs.getLong("fileNameId");	if (rs.wasNull()) {fileNameId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileNameTypeId = rs.getLong("fileNameTypeId");	if (rs.wasNull()) {fileNameTypeId = null;}
				Long nameLanguageId = rs.getLong("nameLanguageId");	if (rs.wasNull()) {nameLanguageId = null;}
				Long nameLanguageId2 = rs.getLong("nameLanguageId2");	if (rs.wasNull()) {nameLanguageId2 = null;}
				Long nameHashId = rs.getLong("nameHashId");	if (rs.wasNull()) {nameHashId = null;}
				Long depth = rs.getLong("depth");	if (rs.wasNull()) {depth = null;}
				Long depthFromRoot = rs.getLong("depthFromRoot");	if (rs.wasNull()) {depthFromRoot = null;}
				String fileName = rs.getString("fileName");
				
				String fileNameRelative = rs.getString("fileNameRelative");
				String fileNameAbsolute = rs.getString("fileNameAbsolute");
				String fileNameCanonical = rs.getString("fileNameCanonical");
				String fileURI = rs.getString("fileURI");
				String fileURL = rs.getString("fileURL");
				String extensionName = rs.getString("extensionName");
				String nameWithoutExtension = rs.getString("nameWithoutExtension");
				String dirNameRelative = rs.getString("dirNameRelative");
				String dirNameAbsolute = rs.getString("dirNameAbsolute");
				
				Long fileNameLength = rs.getLong("fileNameLength");	if (rs.wasNull()) {fileNameLength = null;}
				Long fileNameAbsoluteLength = rs.getLong("fileNameAbsoluteLength");	if (rs.wasNull()) {fileNameAbsoluteLength = null;}
				Long compressedNameSize = rs.getLong("compressedNameSize");	if (rs.wasNull()) {compressedNameSize = null;}
				String fileName83 = rs.getString("fileName83");
				String altName1 = rs.getString("altName1");
				String altName2 = rs.getString("altName2");
				String altName3 = rs.getString("altName3");
				String altNameFromTag = rs.getString("altNameFromTag");
				String altNameFromContent = rs.getString("altNameFromContent");
				
				String onlyAsciiLetter = rs.getString("onlyAsciiLetter");
				String onlyDigit = rs.getString("onlyDigit");
				String onlyUTFLetter = rs.getString("onlyUTFLetter");
				String sortedLetters = rs.getString("sortedLetters");
				String sortedLettersUnique = rs.getString("sortedLettersUnique");
				String compressedName = rs.getString("compressedName");
				String encryptedNameRelative = rs.getString("encryptedNameRelative");
				String encryptedNameAbsolute = rs.getString("encryptedNameAbsolute");
				String isNameValid = rs.getString("isNameValid");
				
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
				
				String validityRemark = rs.getString("validityRemark");
				String isNameCorrect = rs.getString("isNameCorrect");
				String correctedName = rs.getString("correctedName");
				String correctnessRemark = rs.getString("correctnessRemark");
				String goodnessLevel = rs.getString("goodnessLevel");
				String goodnessRemark = rs.getString("goodnessRemark");
				String goodNameSuggested = rs.getString("goodNameSuggested");
				String isHumanGiven = rs.getString("isHumanGiven");
				
				String isGenerated = rs.getString("isGenerated");
				String isHumanUnderstandable = rs.getString("isHumanUnderstandable");
				String nameEncoding = rs.getString("nameEncoding");
				String nameCharsetStr = rs.getString("nameCharsetStr");
				String nameRemark = rs.getString("nameRemark");
				String strEntityType = rs.getString("strEntityType");
				String strEntityStr = rs.getString("strEntityStr");
				Long strEntityId = rs.getLong("strEntityId");	if (rs.wasNull()) {strEntityId = null;}
				String strEntityType2 = rs.getString("strEntityType2");
				
				String strEntityStr2 = rs.getString("strEntityStr2");
				Long strEntityId2 = rs.getLong("strEntityId2");	if (rs.wasNull()) {strEntityId = null;}
				Long cntLetter = rs.getLong("cntLetter");	if (rs.wasNull()) {cntLetter = null;}
				Long cntLetterUnique = rs.getLong("cntLetterUnique");	if (rs.wasNull()) {cntLetterUnique = null;}
				Long cntAsciiLetter = rs.getLong("cntAsciiLetter");	if (rs.wasNull()) {cntAsciiLetter = null;}
				Long cntAsciiLetterUppercase = rs.getLong("cntAsciiLetterUppercase");	if (rs.wasNull()) {cntAsciiLetterUppercase = null;}
				Long cntAsciiLetterLowercase = rs.getLong("cntAsciiLetterLowercase");	if (rs.wasNull()) {cntAsciiLetterLowercase = null;}
				Long cntAsciiUnprintable = rs.getLong("cntAsciiUnprintable");	if (rs.wasNull()) {cntAsciiUnprintable = null;}
				Long cntNonAscii = rs.getLong("cntNonAscii");	if (rs.wasNull()) {cntNonAscii = null;}
				
				Long cntUTFLetter = rs.getLong("cntUTFLetter");	if (rs.wasNull()) {cntUTFLetter = null;}
				Long cntUTFLetterByte1 = rs.getLong("cntUTFLetterByte1");	if (rs.wasNull()) {cntUTFLetterByte1 = null;}
				Long cntUTFLetterByte2 = rs.getLong("cntUTFLetterByte2");	if (rs.wasNull()) {cntUTFLetterByte2 = null;}
				Long cntUTFLetterByte3 = rs.getLong("cntUTFLetterByte3");	if (rs.wasNull()) {cntUTFLetterByte3 = null;}
				Long cntUTFLetterByte4 = rs.getLong("cntUTFLetterByte4");	if (rs.wasNull()) {cntUTFLetterByte4 = null;}
				Long cntEmoji = rs.getLong("cntEmoji");	if (rs.wasNull()) {cntEmoji = null;}
				Long cntDigit = rs.getLong("cntDigit");	if (rs.wasNull()) {cntDigit = null;}
				Long cntDigitUnique = rs.getLong("cntDigitUnique");	if (rs.wasNull()) {cntDigitUnique = null;}
				Long cntSpace = rs.getLong("cntSpace");	if (rs.wasNull()) {cntSpace = null;}
				
				Long cntUnderscore = rs.getLong("cntUnderscore");	if (rs.wasNull()) {cntUnderscore = null;}
				Long cntDash = rs.getLong("cntDash");	if (rs.wasNull()) {cntDash = null;}
				Long parsedNum = rs.getLong("parsedNum");	if (rs.wasNull()) {parsedNum = null;}
				String parsedZDTStr = rs.getString("parsedZDT");
				ZonedDateTime parsedZDT = ((parsedZDTStr!=null) ? ZonedDateTime.parse(parsedZDTStr) : null); 
				String tokenizedName = rs.getString("tokenizedName");
				
				String[] arrayToken = null; //rs.getString("arrayToken");
				String[] arrayLetter = null; //rs.getString("arrayLetter");
				Long[] arrayLetterCnt = null; //rs.getLong("arrayLetterCnt");	
				Long[] arrayTokenId = null; //rs.getLong("arrayTokenId");	
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				
				//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
				//		Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
				//		String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
				//		String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
				//		Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
				//		String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
				//		String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
				//		String sortedLettersUnique, String compressedName, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
				//		String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
				//		String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
				//		String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
				//		String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
				//		String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
				//		Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
				//		Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
				//		Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
				//		Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
				//		String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
				//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
				NodeFileName newFileName = new NodeFileName(
					fileNameId, fileId, fileSetId, fileNameTypeId, nameLanguageId,nameLanguageId2, nameHashId, depth, depthFromRoot, fileName,
					fileNameRelative, fileNameAbsolute, fileNameCanonical, fileURI, fileURL,extensionName, nameWithoutExtension, dirNameRelative, dirNameAbsolute, 
					fileNameLength, fileNameAbsoluteLength, compressedNameSize, fileName83,	altName1, altName2, altName3, altNameFromTag, altNameFromContent, 
					onlyAsciiLetter, onlyDigit, onlyUTFLetter, sortedLetters,sortedLettersUnique, compressedName, encryptedNameRelative, encryptedNameAbsolute, isNameValid, 
					validityRemark, isNameCorrect, correctedName, correctnessRemark,goodnessLevel, goodnessRemark, goodNameSuggested, isHumanGiven,
					isGenerated, isHumanUnderstandable, nameEncoding, nameCharsetStr,nameRemark, strEntityType, strEntityStr, strEntityId, strEntityType2, 
					strEntityStr2, strEntityId2, cntLetter, cntLetterUnique, cntAsciiLetter,cntAsciiLetterUppercase, cntAsciiLetterLowercase, cntAsciiUnprintable, cntNonAscii, 
					cntUTFLetter, cntUTFLetterByte1, cntUTFLetterByte2, cntUTFLetterByte3,cntUTFLetterByte4, cntEmoji, cntDigit, cntDigitUnique, cntSpace, 
					cntUnderscore, cntDash, parsedNum, parsedZDT, tokenizedName,
					arrayToken, arrayLetter, arrayLetterCnt, arrayTokenId,creationDate, modificationDate);
				
				fileSet.getListFileName().add(newFileName); 
				fileSet.getMapId2FileName().put(newFileName.getFileNameId(),newFileName); 
				cntRead++; 
			}
			System.out.println("readTableFileName: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileProp(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" filePropId,fileId,fileSetId,fileSystemId,fileStoreId,propertyType,signatureId,fileSize,fileSizeOnDisk,fileSizeClass,\r\n"+
			" hashCode,fileType,linkType,linkedId,ownerName,computerName,canExecute,canRead,canWrite,isExists,isDirectory,isFile,\r\n"+
			" isSymbolicLink,isHidden,isArchive,isSystem,isReadOnly,isOther,isRegularFile,probeContentType,isCompressed,isEncrypted,\r\n"+
			" isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,\r\n"+
			" isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,\r\n"+
			" compressedFileSize,compressionGainRatio,compressionGainBytes,duration,contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,\r\n"+
			" iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,lastModified,fileCreationDate,fileModificationDate,\r\n"+
			" fileLastAccessTime,fileRemark,creationDate,modificationDate \r\n"+
			" FROM FS_FILEPROP WHERE fileSetId = ? ORDER BY filePropId"; 
		//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
		//Long propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
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
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long filePropId = rs.getLong("filePropId");	if (rs.wasNull()) {filePropId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long fileStoreId = rs.getLong("fileStoreId");	if (rs.wasNull()) {fileStoreId = null;}
				
				String propertyType = rs.getString("propertyType");
				Long signatureId = rs.getLong("signatureId");	if (rs.wasNull()) {signatureId = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long fileSizeOnDisk = rs.getLong("fileSizeOnDisk");	if (rs.wasNull()) {fileSizeOnDisk = null;}
				String fileSizeClass = rs.getString("fileSizeClass");
				
				Long hashCode = rs.getLong("hashCode");	if (rs.wasNull()) {hashCode = null;}
				String fileType = rs.getString("fileType");
				String linkType = rs.getString("linkType");
				Long linkedId = rs.getLong("linkedId");	if (rs.wasNull()) {linkedId = null;}
				String ownerName = rs.getString("ownerName");
				String computerName = rs.getString("computerName");
				
				String canExecute = rs.getString("canExecute");
				String canRead = rs.getString("canRead");
				String canWrite = rs.getString("canWrite");
				String isExists = rs.getString("isExists");
				String isDirectory = rs.getString("isDirectory");
				String isFile = rs.getString("isFile");
		
		//String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
		//String isOther, String isRegularFile, String probeContentType, String isCompressed, String isEncrypted,
		//String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
		//String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
		//String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
				
				String isSymbolicLink = rs.getString("isSymbolicLink");
				String isHidden = rs.getString("isHidden");
				String isArchive = rs.getString("isArchive");
				String isSystem = rs.getString("isSystem");
				String isReadOnly = rs.getString("isReadOnly");
				
				String isOther = rs.getString("isOther");
				String isRegularFile = rs.getString("isRegularFile");
				String probeContentType = rs.getString("probeContentType");
				String isCompressed = rs.getString("isCompressed");
				String isEncrypted = rs.getString("isEncrypted");
			
				String isIndexed = rs.getString("isIndexed");
				String isContentIndexed = rs.getString("isContentIndexed");
				String isBlocked = rs.getString("isBlocked");
				String isSystemFile = rs.getString("isSystemFile");
				String isAppFile = rs.getString("isAppFile");
			
				String isCompanyFile = rs.getString("isCompanyFile");
				String isUserFile = rs.getString("isUserFile");
				String isExecutable = rs.getString("isExecutable");
				String isTextFile = rs.getString("isTextFile");
				String isXMLFile = rs.getString("isXMLFile");
				
				String isConfigFile = rs.getString("isCompanyFile");
				String isBinaryFile = rs.getString("isBinaryFile");
				String isImmutable = rs.getString("isImmutable");
				String isInUserPath = rs.getString("isInUserPath");
				String isInSystemPath = rs.getString("isInSystemPath");
				
		//String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
		//Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
		//Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
		//String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
		
				String isShareable = rs.getString("isShareable");
				String isShared = rs.getString("isShared");
				String hasPreviousVersions = rs.getString("hasPreviousVersions");
				String uxPermission = rs.getString("uxPermission");
				String uxInfo = rs.getString("uxInfo");
		
				Long compressedFileSize = rs.getLong("compressedFileSize");	if (rs.wasNull()) {compressedFileSize = null;}
				Double compressionGainRatio = rs.getDouble("compressionGainRatio");	if (rs.wasNull()) {compressionGainRatio = null;}
				Long compressionGainBytes = rs.getLong("compressionGainBytes");	if (rs.wasNull()) {compressionGainBytes = null;}
				Long duration = rs.getLong("duration");	if (rs.wasNull()) {duration = null;}
				
				Long contentLanguageId = rs.getLong("contentLanguageId");	if (rs.wasNull()) {contentLanguageId = null;}
				Long contentLanguageId2 = rs.getLong("contentLanguageId2");	if (rs.wasNull()) {contentLanguageId2 = null;}
				String contentEncoding = rs.getString("contentEncoding");
				String contentCharsetStr = rs.getString("contentCharsetStr");
				
				String iconName = rs.getString("iconName");
				String origin = rs.getString("origin");
				String copyrightInfo = rs.getString("copyrightInfo");
				String licenseInfo = rs.getString("licenseInfo");
				String assetInfo = rs.getString("assetInfo");
				String dlpInfo = rs.getString("dlpInfo");
		
		//Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
		//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,ZonedDateTime modificationDate) {	
				
				Long lastModified = rs.getLong("lastModified");	if (rs.wasNull()) {lastModified = null;}
				String fileCreationDateStr = rs.getString("fileCreationDate");
				ZonedDateTime fileCreationDate = ((fileCreationDateStr!=null) ? ZonedDateTime.parse(fileCreationDateStr) : null); 
				String fileModificationDateStr = rs.getString("fileModificationDate");
				ZonedDateTime fileModificationDate = ((fileModificationDateStr!=null) ? ZonedDateTime.parse(fileModificationDateStr) : null); 
				
				String fileLastAccessTimeStr = rs.getString("fileLastAccessTime");
				ZonedDateTime fileLastAccessTime = ((fileLastAccessTimeStr!=null) ? ZonedDateTime.parse(fileLastAccessTimeStr) : null); 
				String fileRemark = rs.getString("fileRemark");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				
				NodeFileProp newFileProp = new NodeFileProp(
					filePropId,fileId,fileSetId,fileSystemId,fileStoreId,propertyType,signatureId,fileSize,fileSizeOnDisk,fileSizeClass,
					hashCode,fileType,linkType,linkedId,ownerName,computerName,canExecute,canRead,canWrite,isExists,isDirectory,isFile,
					isSymbolicLink,isHidden,isArchive,isSystem,isReadOnly,isOther,isRegularFile,probeContentType,isCompressed,isEncrypted,
					isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,
					isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,
					compressedFileSize,compressionGainRatio,compressionGainBytes,duration,contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,
					iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,lastModified,fileCreationDate,fileModificationDate,
					fileLastAccessTime,fileRemark,creationDate,modificationDate);
				
				fileSet.getListFileProp().add(newFileProp); 
				fileSet.getMapId2FileProp().put(newFileProp.getFilePropId(),newFileProp); 
				cntRead++; 
			}
			System.out.println("readTableFileProp: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	}
	public static int readTableFileBlob(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT fileBlobId,fileId,blobId,fileSetId, blobType, blobSize, \r\n" + 
				" fileSize, hashId, blobDbName, blobDbAttachmentName, blobTableName, \r\n" + 
				" bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, creationDate,modificationDate"+
				" FROM FS_FILEBLOB WHERE fileSetId = ? ORDER BY fileBlobId"; 
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileBlobId = rs.getLong("fileBlobId");	if (rs.wasNull()) {fileBlobId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				String blobType = rs.getString("blobType");
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String blobDbName = rs.getString("blobDbName");
				String blobDbAttachmentName = rs.getString("blobDbAttachmentName");
				String blobTableName = rs.getString("blobTableName");
				Long bigPartNumber = rs.getLong("bigPartNumber");	if (rs.wasNull()) {bigPartNumber = null;}
				Long bigCntPart = rs.getLong("bigCntPart");	if (rs.wasNull()) {bigCntPart = null;}
				Long smallByteIndexStart = rs.getLong("smallByteIndexStart");	if (rs.wasNull()) {smallByteIndexStart = null;}
				Long smallByteIndexEnd = rs.getLong("smallByteIndexEnd");	if (rs.wasNull()) {smallByteIndexEnd = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileBlob newFileBlob = new NodeFileBlob(
						fileBlobId,fileId,blobId,fileSetId,blobType,blobSize,fileSize, hashId,blobDbName,blobDbAttachmentName,blobTableName,
						bigPartNumber,bigCntPart,smallByteIndexStart,smallByteIndexEnd,creationDate,modificationDate);
				
				fileSet.getListFileBlob().add(newFileBlob); 
				fileSet.getMapId2FileBlob().put(newFileBlob.getFileBlobId(),newFileBlob);
				cntRead++; 
			}
			System.out.println("readTableFileBlob: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	}
	public static int readTableFileStore(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,"+
				" hashCode,rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate"+
			 " FROM FS_FILESTORE WHERE fileSetId = ? ORDER BY fileStoreId"; 
		//public NodeFileStore(Long fileStoreId,Long fileSetId,Long fileSystemId,Long rootFileId,Long displayOrder,Long blockSize,Long totalSpace,
		//Long unallocatedSpace,Long usableSpace,Long usedSpace,Long hashCode,String rootDirectoryName,String isReadOnly,
		//String nameStr,String toString,String typeStr,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileStoreId = rs.getLong("fileStoreId");	if (rs.wasNull()) {fileStoreId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				Long blockSize = rs.getLong("blockSize");	if (rs.wasNull()) {blockSize = null;}
				Long totalSpace = rs.getLong("totalSpace");	if (rs.wasNull()) {totalSpace = null;}
				Long unallocatedSpace = rs.getLong("unallocatedSpace");	if (rs.wasNull()) {unallocatedSpace = null;}
				Long usableSpace = rs.getLong("usableSpace");	if (rs.wasNull()) {usableSpace = null;}
				Long usedSpace = rs.getLong("usedSpace");	if (rs.wasNull()) {usedSpace = null;}
				Long hashCode = rs.getLong("hashCode");	if (rs.wasNull()) {hashCode = null;}
				String rootDirectoryName = rs.getString("rootDirectoryName");
				String isReadOnly = rs.getString("isReadOnly");
				String nameStr = rs.getString("nameStr");
				String toString = rs.getString("toString");
				String typeStr = rs.getString("typeStr");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileStore newFileStore = new NodeFileStore(
						fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,
						hashCode,rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate);
				fileSet.getListFileStore().add(newFileStore); 
				fileSet.getMapId2FileStore().put(newFileStore.getFileStoreId(),newFileStore); 
				cntRead++; 
			}
			System.out.println("readTableFileStore: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileSystem(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileSystemId,fileSetId,hostId,rootFileId,displayOrder,systemName,providerName,providerHashCode,isDefault,isOpen,"+
				" isReadOnly,creationDate,modificationDate"+
			 " FROM FS_FILESYSTEM WHERE fileSetId = ? ORDER BY fileSystemId"; 
		//public NodeFileSystem(Long fileSystemId,Long fileSetId,Long hostId,Long rootFileId,Long displayOrder,String systemName,String providerName,
		//Long providerHashCode,String isDefault,String isOpen,String isReadOnly,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long hostId = rs.getLong("hostId");	if (rs.wasNull()) {hostId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String systemName = rs.getString("systemName");
				String providerName = rs.getString("providerName");
				Long providerHashCode = rs.getLong("providerHashCode");	if (rs.wasNull()) {providerHashCode = null;}
				String isDefault = rs.getString("isDefault");
				String isOpen = rs.getString("isOpen");
				String isReadOnly = rs.getString("isReadOnly");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileSystem newFileSystem = new NodeFileSystem(
						fileSystemId,fileSetId,hostId,rootFileId,displayOrder,systemName,providerName,providerHashCode,isDefault,isOpen,
						isReadOnly,creationDate,modificationDate);
				fileSet.getListFileSystem().add(newFileSystem); 
				fileSet.getMapId2FileSystem().put(newFileSystem.getFileSystemId(),newFileSystem); 
				cntRead++; 
			}
			System.out.println("readTableFileSystem: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableHash(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,"+
				" hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate"+
			 " FROM FS_HASH WHERE fileSetId = ? ORDER BY hashId"; 
		//public NodeHash(Long hashId,Long fileSetId,Long fileSize,Long crc64,Long crc32,Long adler32,String blake3,String md5,String sha1,
		//String sha256,String sha384,String sha512,String sha3256,String keccak256,String hashFieldDesc,String hashStr01,
		//String hashStr02,String hashStr03,String hashStr04,String hashStr05,Long hashLong01,Long hashLong02,Long hashLong03,
		//Long hashLong04,Long hashLong05,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long crc64 = rs.getLong("crc64");	if (rs.wasNull()) {crc64 = null;}
				Long crc32 = rs.getLong("crc32");	if (rs.wasNull()) {crc32 = null;}
				Long adler32 = rs.getLong("adler32");	if (rs.wasNull()) {adler32 = null;}
				String blake3 = rs.getString("blake3");
				String md5 = rs.getString("md5");
				String sha1 = rs.getString("sha1");
				String sha256 = rs.getString("sha256");
				String sha384 = rs.getString("sha384");
				String sha512 = rs.getString("sha512");
				String sha3256 = rs.getString("sha3256");
				String keccak256 = rs.getString("keccak256");
				String hashFieldDesc = rs.getString("hashFieldDesc");
				String hashStr01 = rs.getString("hashStr01");
				String hashStr02 = rs.getString("hashStr02");
				String hashStr03 = rs.getString("hashStr03");
				String hashStr04 = rs.getString("hashStr04");
				String hashStr05 = rs.getString("hashStr05");
				Long hashLong01 = rs.getLong("hashLong01");	if (rs.wasNull()) {hashLong01 = null;}
				Long hashLong02 = rs.getLong("hashLong02");	if (rs.wasNull()) {hashLong02 = null;}
				Long hashLong03 = rs.getLong("hashLong03");	if (rs.wasNull()) {hashLong03 = null;}
				Long hashLong04 = rs.getLong("hashLong04");	if (rs.wasNull()) {hashLong04 = null;}
				Long hashLong05 = rs.getLong("hashLong05");	if (rs.wasNull()) {hashLong05 = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeHash newHash = new NodeHash(
						hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,
						hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate);
				fileSet.getListHash().add(newHash); 
				fileSet.getMapId2Hash().put(newHash.getHashId(),newHash); 
				cntRead++; 
			}
			System.out.println("readTableHash: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableHost(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT hostId,fileSetId,hostName,hostIP,domainName,creationDate,modificationDate"+
			 " FROM FS_HOST WHERE fileSetId = ? ORDER BY hostId"; 
		//public NodeHost(Long hostId,Long fileSetId,String hostName,String hostIP,String domainName,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long hostId = rs.getLong("hostId");	if (rs.wasNull()) {hostId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				String hostName = rs.getString("hostName");
				String hostIP = rs.getString("hostIP");
				String domainName = rs.getString("domainName");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeHost newHost = new NodeHost(hostId,fileSetId,hostName,hostIP,domainName,creationDate,modificationDate);
				fileSet.getListHost().add(newHost); 
				fileSet.getMapId2Host().put(newHost.getHostId(),newHost); 
				cntRead++; 
			}
			System.out.println("readTableHost: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableProperty(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT propertyId,fileSetId,entityId,displayOrder,mapName,entityName,propertyKey,propertyValue,valueString,valueLong,valueDouble,"+
				" valueBinary,valueZDT,creationDate,modificationDate"+
			 " FROM FS_PROPERTY WHERE fileSetId = ? ORDER BY propertyId"; 
		//public NodeProperty(Long propertyId,Long fileSetId,Long entityId,Long displayOrder,String mapName,String entityName,String propertyKey,
		//String propertyValue,String valueString,Long valueLong,Double valueDouble,ZonedDateTime valueZDT,ZonedDateTime creationDate,
		//ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long propertyId = rs.getLong("propertyId");	if (rs.wasNull()) {propertyId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String mapName = rs.getString("mapName");
				String entityName = rs.getString("entityName");
				String propertyKey = rs.getString("propertyKey");
				String propertyValue = rs.getString("propertyValue");
				String valueString = rs.getString("valueString");
				Long valueLong = rs.getLong("valueLong");	if (rs.wasNull()) {valueLong = null;}
				Double valueDouble = rs.getDouble("valueDouble");	if (rs.wasNull()) {valueDouble = null;}
				byte[] bytesRead = rs.getBytes("valueBinary");  	if (rs.wasNull()) {bytesRead = null;}
				NodeBinary valueBinary =null; 
				if (bytesRead!=null) { valueBinary = new NodeBinary((long) bytesRead.length, bytesRead); } 
				
				String valueZDTStr = rs.getString("valueZDT");
				ZonedDateTime valueZDT = ((valueZDTStr!=null) ? ZonedDateTime.parse(valueZDTStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeProperty newProperty = new NodeProperty(
						propertyId,fileSetId,entityId,displayOrder,mapName,entityName,propertyKey,propertyValue,valueString,valueLong,valueDouble,
						valueBinary,valueZDT,creationDate,modificationDate);
				fileSet.getListProperty().add(newProperty); 
				fileSet.getMapId2Property().put(newProperty.getPropertyId(),newProperty); 
				cntRead++; 
			}
			System.out.println("readTableProperty: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableQuery(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT queryId,fileSetId,entityId,cntExecution,sqlString,firstExecutionDate,lastExecutionDate,creationDate,modificationDate"+
			 " FROM FS_QUERY WHERE fileSetId = ? ORDER BY queryId"; 
		//public NodeQuery(Long queryId,Long fileSetId,Long entityId,Long cntExecution,String sqlString,ZonedDateTime firstExecutionDate,
		//ZonedDateTime lastExecutionDate,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long queryId = rs.getLong("queryId");	if (rs.wasNull()) {queryId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long cntExecution = rs.getLong("cntExecution");	if (rs.wasNull()) {cntExecution = null;}
				String sqlString = rs.getString("sqlString");
				String firstExecutionDateStr = rs.getString("firstExecutionDate");
				ZonedDateTime firstExecutionDate = ((firstExecutionDateStr!=null) ? ZonedDateTime.parse(firstExecutionDateStr) : null); 
				String lastExecutionDateStr = rs.getString("lastExecutionDate");
				ZonedDateTime lastExecutionDate = ((lastExecutionDateStr!=null) ? ZonedDateTime.parse(lastExecutionDateStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeQuery newQuery = new NodeQuery(queryId,fileSetId,entityId,cntExecution,sqlString,firstExecutionDate,lastExecutionDate,
						creationDate,modificationDate);
				fileSet.getListQuery().add(newQuery); 
				fileSet.getMapId2Query().put(newQuery.getQueryId(),newQuery); 
				cntRead++; 
			}
			System.out.println("readTableQuery: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableArchive(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, \r\n" + 
			" multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,\r\n " + 
			" unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate,creationDate,modificationDate "+
			" FROM FS_ARCHIVE WHERE fileSetId = ? ORDER BY archiveId"; 
		//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
		//String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
		//Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
		//Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
		//ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long archiveId = rs.getLong("archiveId");	if (rs.wasNull()) {archiveId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long archiveFileId = rs.getLong("archiveFileId");	if (rs.wasNull()) {archiveFileId = null;}
				Long archiveFileSetId = rs.getLong("archiveFileSetId");	if (rs.wasNull()) {archiveFileSetId = null;}
				String archiveType = rs.getString("archiveType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String multipleFileArchive = rs.getString("multipleFileArchive");
				String archiveRemark = rs.getString("archiveRemark");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long cntArchive = rs.getLong("cntArchive");	if (rs.wasNull()) {cntArchive = null;}
				Long cntDirectory = rs.getLong("cntDirectory");	if (rs.wasNull()) {cntDirectory = null;}
				Long cntFileTree = rs.getLong("cntFileTree");	if (rs.wasNull()) {cntFileTree = null;}
				Long cntDirectoryTree = rs.getLong("cntDirectoryTree");	if (rs.wasNull()) {cntDirectoryTree = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				Long unzippedFileSize = rs.getLong("unzippedFileSize");	if (rs.wasNull()) {unzippedFileSize = null;}
				Double unzipGainRatio = rs.getDouble("unzipGainRatio");	if (rs.wasNull()) {unzipGainRatio = null;}
				Long unzippedGainBytes = rs.getLong("unzippedGainBytes");	if (rs.wasNull()) {unzippedGainBytes = null;}
				
				String archiveCreationDateStr = rs.getString("archiveCreationDate");
				ZonedDateTime archiveCreationDate = ((archiveCreationDateStr!=null) ? ZonedDateTime.parse(archiveCreationDateStr) : null); 
				String archiveModificationDateStr = rs.getString("archiveModificationDate");
				ZonedDateTime archiveModificationDate = ((archiveModificationDateStr!=null) ? ZonedDateTime.parse(archiveModificationDateStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeArchive newArchive = new NodeArchive(
						archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName,  
						multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize, 
						unzippedFileSize, unzipGainRatio, unzippedGainBytes, 
						archiveCreationDate,archiveModificationDate,creationDate,modificationDate);
				fileSet.getListArchive().add(newArchive); 
				fileSet.getMapId2Archive().put(newArchive.getArchiveId(),newArchive); 
				cntRead++; 
			}
			System.out.println("readTableArchive: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableContainer(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,\r\n" +
			" containerRemark, cntFile, originalFileSize,creationDate,modificationDate "+
			" FROM FS_CONTAINER WHERE fileSetId = ? ORDER BY containerId"; 
		//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
		//String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
		//Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long containerId = rs.getLong("containerId");	if (rs.wasNull()) {containerId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long containerFileId = rs.getLong("containerFileId");	if (rs.wasNull()) {containerFileId = null;}
				Long containerFileSetId = rs.getLong("containerFileSetId");	if (rs.wasNull()) {containerFileSetId = null;}
				String containerType = rs.getString("containerType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String containerRemark = rs.getString("containerRemark");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeContainer newContainer = new NodeContainer(
						containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,
						containerRemark, cntFile, originalFileSize,creationDate,modificationDate);
				fileSet.getListContainer().add(newContainer); 
				fileSet.getMapId2Container().put(newContainer.getContainerId(),newContainer); 
				cntRead++; 
			}
			System.out.println("readTableContainer: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableTransform(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,\r\n" +
			" transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate,modificationDate "+
			" FROM FS_TRANSFORM WHERE fileSetId = ? ORDER BY transformId"; 
		//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
		//Long transformedFileId, String transformType, String extensionType, String algorithmName,
		//String transformRemark, String tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,
		//transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate
				
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long transformId = rs.getLong("transformId");	if (rs.wasNull()) {transformId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long transformFileId = rs.getLong("transformFileId");	if (rs.wasNull()) {transformFileId = null;}
				Long transformFileSetId = rs.getLong("transformFileSetId");	if (rs.wasNull()) {transformFileSetId = null;}
				Long transformedFileId = rs.getLong("transformedFileId");	if (rs.wasNull()) {transformedFileId = null;}
				String transformType = rs.getString("transformType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String transformRemark = rs.getString("transformRemark");
				String tmpFileName =  rs.getString("tmpFileName");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				Long transformedFileSize = rs.getLong("transformedFileSize");	if (rs.wasNull()) {transformedFileSize = null;}
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeTransform newTransform = new NodeTransform(
						transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,
						transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate);
				fileSet.getListTransform().add(newTransform); 
				fileSet.getMapId2Transform().put(newTransform.getTransformId(),newTransform); 
				cntRead++; 
			}
			System.out.println("readTableTransform: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static NodeFileSet readTableFileSet(Connection conn, long fileSetId)	{ 
		int cntRead = 0; 
		NodeFileSet newFileSet = null;
		String query = 	" SELECT fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,displayOrder,creationDate,modificationDate"+
				" FROM FS_FILESET WHERE fileSetId = ? ORDER BY fileSetId"; 
		//public NodeFileSet(Long fileSetId, Long sourceId, String fileSetName, String fileSetDesc, String fileSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSetId);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				Long fileSetId2 = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId2 = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				String fileSetName = rs.getString("fileSetName");
				String fileSetDesc = rs.getString("fileSetDesc");
				String fileSetURL = rs.getString("fileSetURL");
				String ownerName = rs.getString("ownerName");
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);
				
				newFileSet = new NodeFileSet(
						fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,displayOrder,creationDate,modificationDate);
				cntRead++; 
			}
			System.out.println("readTableFileSet: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(newFileSet); 
	} 
	public static Long getFileSetIdByName(Connection conn, String fileSetName)	{
		Long fileSetId = null;
		String query = 	" SELECT fileSetId FROM FS_FILESET WHERE fileSetName = ? ORDER BY fileSetId"; 
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, fileSetName);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
			}
			System.out.println("getFileSetIdByName: fileSetId = " + fileSetId); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(fileSetId); 	
	}
	//*****************************
	public static NodeFileSet readFileSet(Connection conn, long fileSetId) {
		NodeFileSet fileSet = readTableFileSet(conn, fileSetId);
		if (fileSet==null) return (null);
		int cntReadQuery = readTableQuery(conn,fileSet);
		int cntReadProperty = readTableProperty(conn,fileSet);
		int cntReadHost = readTableHost(conn,fileSet);
		int cntReadHash = readTableHash(conn,fileSet);
		int cntReadFileSystem = readTableFileSystem(conn,fileSet);
		int cntReadFileStore = readTableFileStore(conn,fileSet);
		int cntReadFileBlob = readTableFileBlob(conn,fileSet);
		int cntReadFile = readTableFile(conn,fileSet);
		int cntReadFileName = readTableFileName(conn,fileSet);
		int cntReadFileProp = readTableFileProp(conn,fileSet);
		int cntReadArchive = readTableArchive(conn,fileSet);
		int cntReadContainer = readTableContainer(conn,fileSet);
		int cntReadTransform = readTableTransform(conn,fileSet);
				
		postProcessFileSet(fileSet);
		
		int cntRead = cntReadQuery + cntReadProperty + cntReadHost + cntReadHash + 
				cntReadFileSystem + cntReadFileStore + cntReadFileBlob + cntReadFile + cntReadFileName + cntReadFileProp + 
				cntReadArchive + cntReadContainer + cntReadTransform + 1;
	    System.out.println("readFileSet: total record read = " + cntRead);
		return(fileSet);
	}	
	private static void postProcessFileSet(NodeFileSet fileSet)	{
		GetByMapFileSet.updateAllMapsFileSet(fileSet);
	}
	public static NodeFileSet readFileSetTables(Connection conn, long fileSetId)	{ 

		NodeFileSet fileSet = readFileSet(conn,fileSetId); 
		if (fileSet!=null)	{ 
			PrintFileSet.printAllListsAndMaps(fileSet); 
		} else { 
			System.out.println("readFileSetTables: fileSet is null"); 
		}	
		return (fileSet); 
	}
	
}