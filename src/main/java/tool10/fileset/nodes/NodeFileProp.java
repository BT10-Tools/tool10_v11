package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeFileProp implements Serializable {

	public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
			String propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
			Long hashCode, String fileType, String linkType, Long linkedId, String ownerName, String computerName,
			String canExecute, String canRead, String canWrite, String isExists, String isDirectory, String isFile,
			String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
			String isOther, String isRegularFile, String probeContentType, String isCompressed, String isEncrypted,
			String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
			String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
			String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
			String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
			Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
			Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
			String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
			Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
			ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,
			ZonedDateTime modificationDate) {
		super();
		this.filePropId = filePropId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.fileSystemId = fileSystemId;
		this.fileStoreId = fileStoreId;
		this.propertyType = propertyType;
		this.signatureId = signatureId;
		this.fileSize = fileSize;
		this.fileSizeOnDisk = fileSizeOnDisk;
		this.fileSizeClass = fileSizeClass;
		this.hashCode = hashCode;
		this.fileType = fileType;
		this.linkType = linkType;
		this.linkedId = linkedId;
		this.ownerName = ownerName;
		this.computerName = computerName;
		this.canExecute = canExecute;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.isExists = isExists;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.isSymbolicLink = isSymbolicLink;
		this.isHidden = isHidden;
		this.isArchive = isArchive;
		this.isSystem = isSystem;
		this.isReadOnly = isReadOnly;
		this.isOther = isOther;
		this.isRegularFile = isRegularFile;
		this.probeContentType = probeContentType;
		this.isCompressed = isCompressed;
		this.isEncrypted = isEncrypted;
		this.isIndexed = isIndexed;
		this.isContentIndexed = isContentIndexed;
		this.isBlocked = isBlocked;
		this.isSystemFile = isSystemFile;
		this.isAppFile = isAppFile;
		this.isCompanyFile = isCompanyFile;
		this.isUserFile = isUserFile;
		this.isExecutable = isExecutable;
		this.isTextFile = isTextFile;
		this.isXMLFile = isXMLFile;
		this.isConfigFile = isConfigFile;
		this.isBinaryFile = isBinaryFile;
		this.isImmutable = isImmutable;
		this.isInUserPath = isInUserPath;
		this.isInSystemPath = isInSystemPath;
		this.isShareable = isShareable;
		this.isShared = isShared;
		this.hasPreviousVersions = hasPreviousVersions;
		this.uxPermission = uxPermission;
		this.uxInfo = uxInfo;
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio;
		this.compressionGainBytes = compressionGainBytes;
		this.duration = duration;
		this.contentLanguageId = contentLanguageId;
		this.contentLanguageId2 = contentLanguageId2;
		this.contentEncoding = contentEncoding;
		this.contentCharsetStr = contentCharsetStr;
		this.iconName = iconName;
		this.origin = origin;
		this.copyrightInfo = copyrightInfo;
		this.licenseInfo = licenseInfo;
		this.assetInfo = assetInfo;
		this.dlpInfo = dlpInfo;
		this.lastModified = lastModified;
		this.fileCreationDate = fileCreationDate;
		this.fileModificationDate = fileModificationDate;
		this.fileLastAccessTime = fileLastAccessTime;
		this.fileRemark = fileRemark;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listSystemVariablesLinkedToFile = null; 
		this.listRegistryEntries = null; 
	}
	public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, 
			Long fileStoreId, String propertyType, Long fileSize, ZonedDateTime creationDate) {
		super();
		this.filePropId = filePropId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.fileSystemId =  fileSystemId; 
		this.fileStoreId = fileStoreId; 
		this.propertyType= propertyType;
		this.fileSize = fileSize;
		this.creationDate = creationDate;
	}

	public void updateFields(Long signatureId,Long fileSizeOnDisk,String fileSizeClass,Long hashCode,String fileType,
			String linkType,Long linkedId,String ownerName,String computerName,
			String canExecute,String canRead,String canWrite,String isExists,String isDirectory,String isFile,
			String isSymbolicLink,String isHidden,String isArchive,String isSystem,String isReadOnly,
			String isOther,String isRegularFile,String probeContentType, 
			Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes,
			Long lastModified, ZonedDateTime fileCreationDate,ZonedDateTime fileModificationDate,ZonedDateTime fileLastAccessTime)		{
		this.signatureId = signatureId;
		this.fileSizeOnDisk = fileSizeOnDisk;
		this.fileSizeClass = fileSizeClass;
		this.hashCode = hashCode;
		this.fileType = fileType;
		this.linkType = linkType;
		this.linkedId = linkedId;
		this.ownerName = ownerName;
		this.computerName = computerName;
		this.canExecute = canExecute;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.isExists = isExists;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.isSymbolicLink = isSymbolicLink;
		this.isHidden = isHidden;
		this.isArchive = isArchive;
		this.isSystem = isSystem;
		this.isReadOnly = isReadOnly;
		this.isOther = isOther;
		this.isRegularFile = isRegularFile;
		this.probeContentType = probeContentType;	
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio;
		this.compressionGainBytes = compressionGainBytes;
		this.lastModified = lastModified;
		this.fileCreationDate = fileCreationDate;
		this.fileModificationDate = fileModificationDate;
		this.fileLastAccessTime = fileLastAccessTime;
	}
	public void updateFields2(String isCompressed, String isEncrypted,
			String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
			String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
			String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
			String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo, Long duration,
			Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
			String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,String fileRemark)		{
		this.isCompressed = isCompressed;
		this.isEncrypted = isEncrypted;
		this.isIndexed = isIndexed;
		this.isContentIndexed = isContentIndexed;
		this.isBlocked = isBlocked;
		this.isSystemFile = isSystemFile;
		this.isAppFile = isAppFile;
		this.isCompanyFile = isCompanyFile;
		this.isUserFile = isUserFile;
		this.isExecutable = isExecutable;
		this.isTextFile = isTextFile;
		this.isXMLFile = isXMLFile;
		this.isConfigFile = isConfigFile;
		this.isBinaryFile = isBinaryFile;
		this.isImmutable = isImmutable;
		this.isInUserPath = isInUserPath;
		this.isInSystemPath = isInSystemPath;
		this.isShareable = isShareable;
		this.isShared = isShared;
		this.hasPreviousVersions = hasPreviousVersions;
		this.uxPermission = uxPermission;
		this.uxInfo = uxInfo;
		this.duration = duration;
		this.contentLanguageId = contentLanguageId;
		this.contentLanguageId2 = contentLanguageId2;
		this.contentEncoding = contentEncoding;
		this.contentCharsetStr = contentCharsetStr;
		this.iconName = iconName;
		this.origin = origin;
		this.copyrightInfo = copyrightInfo;
		this.licenseInfo = licenseInfo;
		this.assetInfo = assetInfo;
		this.dlpInfo = dlpInfo;
		this.fileRemark = fileRemark; 
	}
	
	private static final long serialVersionUID = 1L;	
	
	private Long filePropId;
	private Long fileId;
	private Long fileSetId;
	private Long fileSystemId;
	private Long fileStoreId;
	private String propertyType;
	private Long signatureId;
	
	private Long fileSize;  //file.length();
	private Long fileSizeOnDisk;  //file.length();
	private String fileSizeClass; //small, big, huge
	private Long hashCode;
	private String fileType; //file, directory, link
	private String linkType; //softlink, hardlink
	private Long linkedId;
		    
	private String ownerName;	
	private String computerName;	
	
	private String canExecute;
	private String canRead;
	private String canWrite;
	private String isExists;
	private String isDirectory;
	private String isFile;
	private String isSymbolicLink;
	private String isHidden;	  
	private String isArchive; 
	private String isSystem;
	
	private String isReadOnly;	    
	private String isOther;
	private String isRegularFile;
	private String probeContentType;//the MIME type of a file	
	private String isCompressed;	    
	private String isEncrypted;
	private String isIndexed;
	private String isContentIndexed;
	private String isBlocked;
	private String isSystemFile;
	private String isAppFile;	
	private String isCompanyFile;
	private String isUserFile;
	private String isExecutable;
	private String isTextFile;
	private String isXMLFile;
	private String isConfigFile;
	private String isBinaryFile;
	private String isImmutable;
	private String isInUserPath;
	private String isInSystemPath;
	private String isShareable;
	private String isShared;
	private String hasPreviousVersions;
	
	private String uxPermission;
	private String uxInfo;
	
	private Long compressedFileSize;
	private Double compressionGainRatio; 
	private Long compressionGainBytes;  
	private Long duration;  
    
	private Long contentLanguageId;
	private Long contentLanguageId2;
	private String contentEncoding;
	private String contentCharsetStr; //Charset.forName("ISO-8859-1");
	private String iconName; //Charset.forName("ISO-8859-1");
	private String origin;
	private String copyrightInfo;
	private String licenseInfo;
	private String assetInfo;
	private String dlpInfo;
	
	private Long lastModified; // = file.lastModified();
	private ZonedDateTime fileCreationDate;
	private ZonedDateTime fileModificationDate;
	private ZonedDateTime fileLastAccessTime;
	private String fileRemark;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private String[] listSystemVariablesLinkedToFile;
	private String[] listRegistryEntries;	
	private NodeFile refFile;
	
	//GETTERS AND SETTERS
	
	
	public Long getFilePropId() {
		return filePropId;
	}
	public Long getFileId() {
		return fileId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getFileSystemId() {
		return fileSystemId;
	}
	public void setFileSystemId(Long fileSystemId) {
		this.fileSystemId = fileSystemId;
	}
	public Long getFileStoreId() {
		return fileStoreId;
	}
	public void setFileStoreId(Long fileStoreId) {
		this.fileStoreId = fileStoreId;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Long getSignatureId() {
		return signatureId;
	}
	public void setSignatureId(Long signatureId) {
		this.signatureId = signatureId;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getFileSizeOnDisk() {
		return fileSizeOnDisk;
	}
	public void setFileSizeOnDisk(Long fileSizeOnDisk) {
		this.fileSizeOnDisk = fileSizeOnDisk;
	}
	public String getFileSizeClass() {
		return fileSizeClass;
	}
	public void setFileSizeClass(String fileSizeClass) {
		this.fileSizeClass = fileSizeClass;
	}
	public Long getHashCode() {
		return hashCode;
	}
	public void setHashCode(Long hashCode) {
		this.hashCode = hashCode;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public Long getLinkedId() {
		return linkedId;
	}
	public void setLinkedId(Long linkedId) {
		this.linkedId = linkedId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getCanExecute() {
		return canExecute;
	}
	public void setCanExecute(String canExecute) {
		this.canExecute = canExecute;
	}
	public String getCanRead() {
		return canRead;
	}
	public void setCanRead(String canRead) {
		this.canRead = canRead;
	}
	public String getCanWrite() {
		return canWrite;
	}
	public void setCanWrite(String canWrite) {
		this.canWrite = canWrite;
	}
	public String getIsExists() {
		return isExists;
	}
	public void setIsExists(String isExists) {
		this.isExists = isExists;
	}
	public String getIsDirectory() {
		return isDirectory;
	}
	public void setIsDirectory(String isDirectory) {
		this.isDirectory = isDirectory;
	}
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	public String getIsSymbolicLink() {
		return isSymbolicLink;
	}
	public void setIsSymbolicLink(String isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}
	public String getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}
	public String getIsArchive() {
		return isArchive;
	}
	public void setIsArchive(String isArchive) {
		this.isArchive = isArchive;
	}
	public String getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}
	public String getIsReadOnly() {
		return isReadOnly;
	}
	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	public String getIsOther() {
		return isOther;
	}
	public void setIsOther(String isOther) {
		this.isOther = isOther;
	}
	public String getIsRegularFile() {
		return isRegularFile;
	}
	public void setIsRegularFile(String isRegularFile) {
		this.isRegularFile = isRegularFile;
	}
	public String getProbeContentType() {
		return probeContentType;
	}
	public void setProbeContentType(String probeContentType) {
		this.probeContentType = probeContentType;
	}
	public String getIsCompressed() {
		return isCompressed;
	}
	public void setIsCompressed(String isCompressed) {
		this.isCompressed = isCompressed;
	}
	public String getIsEncrypted() {
		return isEncrypted;
	}
	public void setIsEncrypted(String isEncrypted) {
		this.isEncrypted = isEncrypted;
	}
	public String getIsIndexed() {
		return isIndexed;
	}
	public void setIsIndexed(String isIndexed) {
		this.isIndexed = isIndexed;
	}
	public String getIsContentIndexed() {
		return isContentIndexed;
	}
	public void setIsContentIndexed(String isContentIndexed) {
		this.isContentIndexed = isContentIndexed;
	}
	public String getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}
	public String getIsSystemFile() {
		return isSystemFile;
	}
	public void setIsSystemFile(String isSystemFile) {
		this.isSystemFile = isSystemFile;
	}
	public String getIsAppFile() {
		return isAppFile;
	}
	public void setIsAppFile(String isAppFile) {
		this.isAppFile = isAppFile;
	}
	public String getIsCompanyFile() {
		return isCompanyFile;
	}
	public void setIsCompanyFile(String isCompanyFile) {
		this.isCompanyFile = isCompanyFile;
	}
	public String getIsUserFile() {
		return isUserFile;
	}
	public void setIsUserFile(String isUserFile) {
		this.isUserFile = isUserFile;
	}
	public String getIsExecutable() {
		return isExecutable;
	}
	public void setIsExecutable(String isExecutable) {
		this.isExecutable = isExecutable;
	}
	public String getIsTextFile() {
		return isTextFile;
	}
	public void setIsTextFile(String isTextFile) {
		this.isTextFile = isTextFile;
	}
	public String getIsXMLFile() {
		return isXMLFile;
	}
	public void setIsXMLFile(String isXMLFile) {
		this.isXMLFile = isXMLFile;
	}
	public String getIsConfigFile() {
		return isConfigFile;
	}
	public void setIsConfigFile(String isConfigFile) {
		this.isConfigFile = isConfigFile;
	}
	public String getIsBinaryFile() {
		return isBinaryFile;
	}
	public void setIsBinaryFile(String isBinaryFile) {
		this.isBinaryFile = isBinaryFile;
	}
	public String getIsImmutable() {
		return isImmutable;
	}
	public void setIsImmutable(String isImmutable) {
		this.isImmutable = isImmutable;
	}
	public String getIsInUserPath() {
		return isInUserPath;
	}
	public void setIsInUserPath(String isInUserPath) {
		this.isInUserPath = isInUserPath;
	}
	public String getIsInSystemPath() {
		return isInSystemPath;
	}
	public void setIsInSystemPath(String isInSystemPath) {
		this.isInSystemPath = isInSystemPath;
	}
	public String getIsShareable() {
		return isShareable;
	}
	public void setIsShareable(String isShareable) {
		this.isShareable = isShareable;
	}
	public String getIsShared() {
		return isShared;
	}
	public void setIsShared(String isShared) {
		this.isShared = isShared;
	}
	public String getHasPreviousVersions() {
		return hasPreviousVersions;
	}
	public void setHasPreviousVersions(String hasPreviousVersions) {
		this.hasPreviousVersions = hasPreviousVersions;
	}
	public String getUxPermission() {
		return uxPermission;
	}
	public void setUxPermission(String uxPermission) {
		this.uxPermission = uxPermission;
	}
	public String getUxInfo() {
		return uxInfo;
	}
	public void setUxInfo(String uxInfo) {
		this.uxInfo = uxInfo;
	}
	public Long getCompressedFileSize() {
		return compressedFileSize;
	}
	public void setCompressedFileSize(Long compressedFileSize) {
		this.compressedFileSize = compressedFileSize;
	}
	public Double getCompressionGainRatio() {
		return compressionGainRatio;
	}
	public void setCompressionGainRatio(Double compressionGainRatio) {
		this.compressionGainRatio = compressionGainRatio;
	}
	public Long getCompressionGainBytes() {
		return compressionGainBytes;
	}
	public void setCompressionGainBytes(Long compressionGainBytes) {
		this.compressionGainBytes = compressionGainBytes;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public Long getContentLanguageId() {
		return contentLanguageId;
	}
	public void setContentLanguageId(Long contentLanguageId) {
		this.contentLanguageId = contentLanguageId;
	}
	public Long getContentLanguageId2() {
		return contentLanguageId2;
	}
	public void setContentLanguageId2(Long contentLanguageId2) {
		this.contentLanguageId2 = contentLanguageId2;
	}
	public String getContentEncoding() {
		return contentEncoding;
	}
	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}
	public String getContentCharsetStr() {
		return contentCharsetStr;
	}
	public void setContentCharsetStr(String contentCharsetStr) {
		this.contentCharsetStr = contentCharsetStr;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCopyrightInfo() {
		return copyrightInfo;
	}
	public void setCopyrightInfo(String copyrightInfo) {
		this.copyrightInfo = copyrightInfo;
	}
	public String getLicenseInfo() {
		return licenseInfo;
	}
	public void setLicenseInfo(String licenseInfo) {
		this.licenseInfo = licenseInfo;
	}
	public String getAssetInfo() {
		return assetInfo;
	}
	public void setAssetInfo(String assetInfo) {
		this.assetInfo = assetInfo;
	}
	public String getDlpInfo() {
		return dlpInfo;
	}
	public void setDlpInfo(String dlpInfo) {
		this.dlpInfo = dlpInfo;
	}
	public Long getLastModified() {
		return lastModified;
	}
	public void setLastModified(Long lastModified) {
		this.lastModified = lastModified;
	}
	public ZonedDateTime getFileCreationDate() {
		return fileCreationDate;
	}
	public void setFileCreationDate(ZonedDateTime fileCreationDate) {
		this.fileCreationDate = fileCreationDate;
	}
	public ZonedDateTime getFileModificationDate() {
		return fileModificationDate;
	}
	public void setFileModificationDate(ZonedDateTime fileModificationDate) {
		this.fileModificationDate = fileModificationDate;
	}
	public ZonedDateTime getFileLastAccessTime() {
		return fileLastAccessTime;
	}
	public void setFileLastAccessTime(ZonedDateTime fileLastAccessTime) {
		this.fileLastAccessTime = fileLastAccessTime;
	}
	public String getFileRemark() {
		return fileRemark;
	}
	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String[] getListSystemVariablesLinkedToFile() {
		return listSystemVariablesLinkedToFile;
	}
	public void setListSystemVariablesLinkedToFile(String[] listSystemVariablesLinkedToFile) {
		this.listSystemVariablesLinkedToFile = listSystemVariablesLinkedToFile;
	}
	public String[] getListRegistryEntries() {
		return listRegistryEntries;
	}
	public void setListRegistryEntries(String[] listRegistryEntries) {
		this.listRegistryEntries = listRegistryEntries;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NodeFile getRefFile() {
		return refFile;
	}
	public void setRefFile(NodeFile refFile) {
		this.refFile = refFile;
	}
	public void setFilePropId(Long filePropId) {
		this.filePropId = filePropId;
	}
		
	
}
