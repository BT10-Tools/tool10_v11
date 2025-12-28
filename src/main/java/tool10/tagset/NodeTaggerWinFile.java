package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeTaggerWinFile implements Serializable {


	public NodeTaggerWinFile(Long tagFileId) {
		super();
		this.tagFileId = tagFileId;
		this.mapAttribute = new HashMap<String, String>();
	}

	public NodeTaggerWinFile(Long tagFileId, String fileType, Long fileSize, Long fileSizeOnDisk, Long filenameLength,
			Long dirFileCount, Long dirDirectoryCount, Long dirTreeFileCount, Long dirTreeDirectoryCount, Long dirSize,
			Long dirSizeOnDisk, Long dirTreeSize, Long dirTreeSizeOnDisk, String isRegularFile, String isDirectory,
			String isLink, String isOther, String isReadable, String isWritable, String isExecutable, String isSystemFile,
			String isArchiveFile, String isHidden, String isReadOnly, String isCompressed, String isEncrypted,
			String isContentIndexed, String isReadyForArchive, String isPreviousVersions, String owner,
			ZonedDateTime creationTime, ZonedDateTime lastModifiedTime, ZonedDateTime lastAccessTime) {
		super();
		this.tagFileId = tagFileId;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.fileSizeOnDisk = fileSizeOnDisk;
		this.filenameLength = filenameLength;
		this.dirFileCount = dirFileCount;
		this.dirDirectoryCount = dirDirectoryCount;
		this.dirTreeFileCount = dirTreeFileCount;
		this.dirTreeDirectoryCount = dirTreeDirectoryCount;
		this.dirSize = dirSize;
		this.dirSizeOnDisk = dirSizeOnDisk;
		this.dirTreeSize = dirTreeSize;
		this.dirTreeSizeOnDisk = dirTreeSizeOnDisk;
		this.isRegularFile = isRegularFile;
		this.isDirectory = isDirectory;
		this.isLink = isLink;
		this.isOther = isOther;
		this.isReadable = isReadable;
		this.isWritable = isWritable;
		this.isExecutable = isExecutable;
		this.isSystemFile = isSystemFile;
		this.isArchiveFile = isArchiveFile;
		this.isHidden = isHidden;
		this.isReadOnly = isReadOnly;
		this.isCompressed = isCompressed;
		this.isEncrypted = isEncrypted;
		this.isContentIndexed = isContentIndexed;
		this.isReadyForArchive = isReadyForArchive;
		this.isPreviousVersions = isPreviousVersions;
		this.owner = owner;
		this.creationTime = creationTime;
		this.lastModifiedTime = lastModifiedTime;
		this.lastAccessTime = lastAccessTime;
		this.mapAttribute = new HashMap<String, String>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagFileId;
	private String fileType; //file, directory, link, 
	private Long fileSize;
	private Long fileSizeOnDisk;
	private Long filenameLength;
	private Long dirFileCount; 
	private Long dirDirectoryCount; 
	private Long dirTreeFileCount; 
	private Long dirTreeDirectoryCount; 
	private Long dirSize; 
	private Long dirSizeOnDisk; 
	private Long dirTreeSize; 
	private Long dirTreeSizeOnDisk; 
	
	//boolean values
	private String isRegularFile;
	private String isDirectory;
	private String isLink;
	private String isOther;
	
	private String isReadable;
	private String isWritable;
	private String isExecutable;
	private String isSystemFile;
	private String isArchiveFile;
	
	private String isHidden;
	private String isReadOnly;
	private String isCompressed;
	private String isEncrypted;
	private String isContentIndexed;
	private String isReadyForArchive;
	private String isPreviousVersions;
	
	//String values 
	private String owner;
	
	//sharing 
	//permissions
	//POSIX attributes

	//time values
	private ZonedDateTime creationTime;
	private ZonedDateTime lastModifiedTime;
	private ZonedDateTime lastAccessTime;
	
	private HashMap<String,String> mapAttribute;

	public Long getTagFileId() {
		return tagFileId;
	}

	public void setTagFileId(Long tagFileId) {
		this.tagFileId = tagFileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
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

	public Long getFilenameLength() {
		return filenameLength;
	}

	public void setFilenameLength(Long filenameLength) {
		this.filenameLength = filenameLength;
	}

	public Long getDirFileCount() {
		return dirFileCount;
	}

	public void setDirFileCount(Long dirFileCount) {
		this.dirFileCount = dirFileCount;
	}

	public Long getDirDirectoryCount() {
		return dirDirectoryCount;
	}

	public void setDirDirectoryCount(Long dirDirectoryCount) {
		this.dirDirectoryCount = dirDirectoryCount;
	}

	public Long getDirTreeFileCount() {
		return dirTreeFileCount;
	}

	public void setDirTreeFileCount(Long dirTreeFileCount) {
		this.dirTreeFileCount = dirTreeFileCount;
	}

	public Long getDirTreeDirectoryCount() {
		return dirTreeDirectoryCount;
	}

	public void setDirTreeDirectoryCount(Long dirTreeDirectoryCount) {
		this.dirTreeDirectoryCount = dirTreeDirectoryCount;
	}

	public Long getDirSize() {
		return dirSize;
	}

	public void setDirSize(Long dirSize) {
		this.dirSize = dirSize;
	}

	public Long getDirSizeOnDisk() {
		return dirSizeOnDisk;
	}

	public void setDirSizeOnDisk(Long dirSizeOnDisk) {
		this.dirSizeOnDisk = dirSizeOnDisk;
	}

	public Long getDirTreeSize() {
		return dirTreeSize;
	}

	public void setDirTreeSize(Long dirTreeSize) {
		this.dirTreeSize = dirTreeSize;
	}

	public Long getDirTreeSizeOnDisk() {
		return dirTreeSizeOnDisk;
	}

	public void setDirTreeSizeOnDisk(Long dirTreeSizeOnDisk) {
		this.dirTreeSizeOnDisk = dirTreeSizeOnDisk;
	}

	public String getIsRegularFile() {
		return isRegularFile;
	}

	public void setIsRegularFile(String isRegularFile) {
		this.isRegularFile = isRegularFile;
	}

	public String getIsDirectory() {
		return isDirectory;
	}

	public void setIsDirectory(String isDirectory) {
		this.isDirectory = isDirectory;
	}

	public String getIsLink() {
		return isLink;
	}

	public void setIsLink(String isLink) {
		this.isLink = isLink;
	}

	public String getIsReadable() {
		return isReadable;
	}

	public void setIsReadable(String isReadable) {
		this.isReadable = isReadable;
	}

	public String getIsWritable() {
		return isWritable;
	}

	public void setIsWritable(String isWritable) {
		this.isWritable = isWritable;
	}

	public String getIsExecutable() {
		return isExecutable;
	}

	public void setIsExecutable(String isExecutable) {
		this.isExecutable = isExecutable;
	}

	public String getIsSystemFile() {
		return isSystemFile;
	}

	public void setIsSystemFile(String isSystemFile) {
		this.isSystemFile = isSystemFile;
	}

	public String getIsArchiveFile() {
		return isArchiveFile;
	}

	public void setIsArchiveFile(String isArchiveFile) {
		this.isArchiveFile = isArchiveFile;
	}

	public String getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
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

	public String getIsContentIndexed() {
		return isContentIndexed;
	}

	public void setIsContentIndexed(String isContentIndexed) {
		this.isContentIndexed = isContentIndexed;
	}

	public String getIsReadyForArchive() {
		return isReadyForArchive;
	}

	public void setIsReadyForArchive(String isReadyForArchive) {
		this.isReadyForArchive = isReadyForArchive;
	}

	public String getIsPreviousVersions() {
		return isPreviousVersions;
	}

	public void setIsPreviousVersions(String isPreviousVersions) {
		this.isPreviousVersions = isPreviousVersions;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public ZonedDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(ZonedDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public ZonedDateTime getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(ZonedDateTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public ZonedDateTime getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(ZonedDateTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public HashMap<String, String> getMapAttribute() {
		return mapAttribute;
	}

	public void setMapAttribute(HashMap<String, String> mapAttribute) {
		this.mapAttribute = mapAttribute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIsOther() {
		return isOther;
	}

	public void setIsOther(String isOther) {
		this.isOther = isOther;
	}



}
