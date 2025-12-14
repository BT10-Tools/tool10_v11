package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NodeFile implements Serializable {

	public NodeFile(Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId, Long parentFileId, Long rootFileId, Long fileTypeId,
			Long sourceId, Long languageId, Long languageId2, Long fileSize, Long hashCode, Long hashId,
			String fileType, String linkType, Long linkedId, String fileStatus, Long depth, Long depthFromRoot, String fileName, String fileNameRelative, String fileNameAbsolute,
			String fileNameCanonical, String dirNameRelative, String dirNameAbsolute, String altName1, String altName2, String altName3,
			String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId, 
			String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
			Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite,
			String isExists, String isDirectory, String isFile, String isSymbolicLink, String isHidden, String isReadOnly, 
			String isArchive, String isSystem, String isOther,
			String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
			Long compressionGainBytes,String encoding, String charsetStr,Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
			ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.fileSystemId = fileSystemId;
		this.fileStoreId = fileStoreId;
		this.parentFileId = parentFileId;
		this.rootFileId = rootFileId;
		this.fileTypeId = fileTypeId;
		this.sourceId = sourceId;
		this.languageId = languageId;
		this.languageId2 = languageId2;
		this.fileSize = fileSize;
		this.hashCode = hashCode;
		this.hashId = hashId;
		this.fileType = fileType;
		this.linkType = linkType;
		this.linkedId = linkedId;
		this.fileStatus = fileStatus;
		this.depth = depth;
		this.depthFromRoot = depthFromRoot;
		this.fileName = fileName;
		this.fileNameRelative = fileNameRelative;
		this.fileNameAbsolute = fileNameAbsolute;
		this.fileNameCanonical = fileNameCanonical;
		this.dirNameRelative = dirNameRelative;  
		this.dirNameAbsolute = dirNameAbsolute; 
		this.altName1 = altName1;
		this.altName2 = altName2;
		this.altName3 = altName3;
		this.encryptedNameRelative = encryptedNameRelative;  //the encrypted string for name relative. sand,compress, encrypt
		this.encryptedNameAbsolute = encryptedNameAbsolute;  //the encrypted string for name relative
		this.nameHashId = nameHashId; 
		
		this.fileURI = fileURI;
		this.fileURL = fileURL;
		this.extensionName = extensionName;
		this.nameWithoutExtension = nameWithoutExtension;
		this.fileNameAbsoluteLength = fileNameAbsoluteLength;
		this.ownerName = ownerName;
		this.canExecute = canExecute;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.isExists = isExists;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.isSymbolicLink = isSymbolicLink;
		this.isHidden = isHidden;
		this.isReadOnly = isReadOnly;
		this.isArchive = isArchive;
		this.isSystem = isSystem;
		this.isOther = isOther;
		this.isRegularFile = isRegularFile;
		this.probeContentType = probeContentType;;
		this.freeSpace = freeSpace;
		this.totalSpace = totalSpace;
		this.usableSpace = usableSpace;
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.encoding = encoding;
		this.charsetStr = charsetStr;
		this.lastModified = lastModified;
		this.fileCreationDate = fileCreationDate;
		this.fileModificationDate = fileModificationDate;
		this.fileLastAccessTime = fileLastAccessTime;
		this.fileRemark = fileRemark;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();	
	}

	public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long fileSize, String fileStatus, String fileName, 
			String fileNameAbsolute, String isDirectory, String isFile,
			String fileRemark,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.parentFileId = parentFileId;
		this.fileSize = fileSize;
		this.fileStatus = fileStatus;
		this.fileName = fileName;
		this.fileNameAbsolute = fileNameAbsolute;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.fileRemark = fileRemark;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();		
	}
	private void initializeListsAndMaps()	{ 
		this.listSiblingFile = new ArrayList<NodeFile>();
		this.listFileBlobRegular = new ArrayList<NodeFileBlob>(); 
		this.listFileBlobBig = new ArrayList<NodeFileBlob>(); 
		this.listFileBlobSmall = new ArrayList<NodeFileBlobSmall>(); 
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Long fileId;
	private Long fileSetId;
	private Long fileSystemId;
	private Long fileStoreId;
	private Long parentFileId;
	private Long rootFileId;
	private Long fileTypeId;
	private Long sourceId;
	private Long languageId;
	private Long languageId2;
	private Long fileSize;  //file.length();
	private Long hashCode;
	private Long hashId;
	private String fileType; //file, directory, link
	private String linkType; //softlink, hardlink
	private Long linkedId;
	//There are two types of symbolic links: soft links, which redirect to the location where files are stored, 
	//and hard links, which make it appear as though the file or folder exists at the location of the symbolic link
	
	private String fileStatus;
	private Long depth;
	private Long depthFromRoot;
	    
	private String fileName;
	private String fileNameRelative;  //the name relative to the given input directory name
	private String fileNameAbsolute;
	private String fileNameCanonical;
	private String dirNameRelative;  
	private String dirNameAbsolute;
	private String altName1;
	private String altName2;
	private String altName3;
	private String encryptedNameRelative;  //the encrypted string for name relative. sand,compress, encrypt
	private String encryptedNameAbsolute;  //the encrypted string for name relative
	private Long nameHashId; 

	private String fileURI;
	private String fileURL;
	private String extensionName;
	private String nameWithoutExtension;
	private Long fileNameAbsoluteLength;
	private String ownerName;	
	
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
	
	private Long freeSpace;
	private Long totalSpace;
	private Long usableSpace;
	private Long compressedFileSize;
	private Double compressionGainRatio; 
	private Long compressionGainBytes;  
    
	private String encoding;
	private String charsetStr; //Charset.forName("ISO-8859-1");
	private Long lastModified; // = file.lastModified();
	private ZonedDateTime fileCreationDate;
	private ZonedDateTime fileModificationDate;
	private ZonedDateTime fileLastAccessTime;
	private String fileRemark;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listSiblingFile;
	private ArrayList<NodeFileBlob> listFileBlobRegular;
	private ArrayList<NodeFileBlob> listFileBlobBig;
	private ArrayList<NodeFileBlobSmall> listFileBlobSmall;

	public String getFileBlobSizeType()	{
		if (listFileBlobRegular.size()>0) return("regular");
		else if (listFileBlobSmall.size()>0) return("small");
		else if (listFileBlobBig.size()>0) return("big");
		return(null);
	}
	// Sort NodeFile's by fileName
	class SortByFileName implements Comparator<NodeFile> {
		@Override
		public int compare(NodeFile a, NodeFile b) {
		    if      ((a.fileName==null) || (b.fileName==null)) return(0);
		    else if ((a.fileName!=null) || (b.fileName==null)) return(1);
		    else if ((a.fileName==null) || (b.fileName!=null)) return(-1);
		    else {
		    	int result = (a.fileName.compareTo(b.fileName));
		    	if ((result==-1) || (result==1)) return(result);
		    	if (result==0)	{
		    		if 		(a.fileId.longValue()>b.fileId.longValue()) return(-1);
		    		else if (a.fileId.longValue()>b.fileId.longValue()) return(1);
		    		else return(0);
		    	}	
		    }
		    return(0);
		}
	}
	public void sortListSiblingFile()	{
		if (listSiblingFile==null) return;
		if (listSiblingFile.size()<2) return;
		Comparator<NodeFile> myComparator = new SortByFileName();		
		Collections.sort(listSiblingFile, myComparator);
	}
	public void updateFields(Long fileSystemId, Long fileStoreId,Long fileTypeId, Long sourceId, Long languageId, Long languageId2, Long hashCode, Long hashId,
			String fileType, String linkType, Long linkedId, Long depth, Long depthFromRoot, String fileNameRelative, String fileNameCanonical,
			String dirNameRelative, String dirNameAbsolute, String altName1, String altName2, String altName3,
			String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId, 
			String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
			Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite, String isExists, String isHidden, String isReadOnly, 
			String isArchive,String isSystem, String isSymbolicLink,String isOther,
			String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
			Long compressionGainBytes,String encoding, String charsetStr,
			Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,	ZonedDateTime fileLastAccessTime) {
		
		this.fileSystemId = fileSystemId;
		this.fileStoreId = fileStoreId;
		this.fileTypeId = fileTypeId;
		this.sourceId = sourceId;
		this.languageId = languageId;
		this.languageId2 = languageId2;
		this.hashCode = hashCode;
		this.hashId = hashId;
		this.fileType = fileType;
		this.linkType = linkType;
		this.linkedId = linkedId;
		this.depth = depth;
		this.depthFromRoot = depthFromRoot;
		this.fileNameRelative = fileNameRelative;
		this.fileNameCanonical = fileNameCanonical;
		this.dirNameRelative = dirNameRelative;  
		this.dirNameAbsolute = dirNameAbsolute; 
		this.altName1 = altName1;
		this.altName2 = altName2;
		this.altName3 = altName3;
		this.encryptedNameRelative = encryptedNameRelative;  //the encrypted string for name relative. sand,compress, encrypt
		this.encryptedNameAbsolute = encryptedNameAbsolute;  //the encrypted string for name relative
		this.nameHashId = nameHashId; 
		
		this.fileURI = fileURI;
		this.fileURL = fileURL;
		this.extensionName = extensionName;
		this.nameWithoutExtension = nameWithoutExtension;
		this.fileNameAbsoluteLength = fileNameAbsoluteLength;
		this.ownerName = ownerName;
		this.canExecute = canExecute;
		this.canRead = canRead;
		this.canWrite = canWrite;
		this.isExists = isExists;
		this.isHidden = isHidden;
		this.isReadOnly = isReadOnly;
		this.isArchive = isArchive;
		this.isSystem = isSystem;
		this.isSymbolicLink = isSymbolicLink;
		this.isOther = isOther;
		this.isRegularFile = isRegularFile;
		this.probeContentType = probeContentType;;
		this.freeSpace = freeSpace;
		this.totalSpace = totalSpace;
		this.usableSpace = usableSpace;
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.encoding = encoding;
		this.charsetStr = charsetStr;
		this.lastModified = lastModified;
		this.fileCreationDate = fileCreationDate;
		this.fileModificationDate = fileModificationDate;
		this.fileLastAccessTime = fileLastAccessTime;
	}	
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getFileId() {
		return fileId;
	}

	public Long getFileSetId() {
		return fileSetId;
	}

	public Long getFileStoreId() {
		return fileStoreId;
	}

	public Long getParentFileId() {
		return parentFileId;
	}

	public Long getRootFileId() {
		return rootFileId;
	}

	public Long getFileTypeId() {
		return fileTypeId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public Long getLanguageId2() {
		return languageId2;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public Long getHashCode() {
		return hashCode;
	}

	public Long getHashId() {
		return hashId;
	}

	public String getFileType() {
		return fileType;
	}

	public Long getDepth() {
		return depth;
	}

	public Long getDepthFromRoot() {
		return depthFromRoot;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileNameAbsolute() {
		return fileNameAbsolute;
	}

	public String getFileNameCanonical() {
		return fileNameCanonical;
	}

	public String getFileURI() {
		return fileURI;
	}

	public String getFileURL() {
		return fileURL;
	}

	public String getExtensionName() {
		return extensionName;
	}

	public String getNameWithoutExtension() {
		return nameWithoutExtension;
	}

	public Long getFileNameAbsoluteLength() {
		return fileNameAbsoluteLength;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getCanExecute() {
		return canExecute;
	}

	public String getCanRead() {
		return canRead;
	}

	public String getCanWrite() {
		return canWrite;
	}

	public String getIsExists() {
		return isExists;
	}

	public String getIsDirectory() {
		return isDirectory;
	}

	public String getIsFile() {
		return isFile;
	}

	public String getIsSymbolicLink() {
		return isSymbolicLink;
	}

	public String getIsHidden() {
		return isHidden;
	}

	public String getIsOther() {
		return isOther;
	}

	public String getIsRegularFile() {
		return isRegularFile;
	}

	public Long getFreeSpace() {
		return freeSpace;
	}

	public Long getTotalSpace() {
		return totalSpace;
	}

	public Long getUsableSpace() {
		return usableSpace;
	}

	public String getEncoding() {
		return encoding;
	}

	public String getCharsetStr() {
		return charsetStr;
	}

	public Long getLastModified() {
		return lastModified;
	}

	public ZonedDateTime getFileCreationDate() {
		return fileCreationDate;
	}

	public ZonedDateTime getFileModificationDate() {
		return fileModificationDate;
	}

	public ZonedDateTime getFileLastAccessTime() {
		return fileLastAccessTime;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public ArrayList<NodeFile> getListSiblingFile() {
		return listSiblingFile;
	}

	public String getLinkType() {
		return linkType;
	}

	public Long getLinkedId() {
		return linkedId;
	}

	public Long getCompressedFileSize() {
		return compressedFileSize;
	}

	public Double getCompressionGainRatio() {
		return compressionGainRatio;
	}

	public Long getCompressionGainBytes() {
		return compressionGainBytes;
	}

	public String getProbeContentType() {
		return probeContentType;
	}

	public void setHashId(Long hashId) {
		this.hashId = hashId;
	}
	public String getFileNameRelative() {
		return fileNameRelative;
	}
	public void setParentFileId(Long parentFileId) {
		this.parentFileId = parentFileId;
	}
	public Long getFileSystemId() {
		return fileSystemId;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public void setDepthFromRoot(Long depthFromRoot) {
		this.depthFromRoot = depthFromRoot;
	}
	public String getDirNameRelative() {
		return dirNameRelative;
	}
	public String getDirNameAbsolute() {
		return dirNameAbsolute;
	}
	public String getEncryptedNameRelative() {
		return encryptedNameRelative;
	}
	public String getEncryptedNameAbsolute() {
		return encryptedNameAbsolute;
	}
	public Long getNameHashId() {
		return nameHashId;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getFileRemark() {
		return fileRemark;
	}

	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}

	public ArrayList<NodeFileBlobSmall> getListFileBlobSmall() {
		return listFileBlobSmall;
	}

	public ArrayList<NodeFileBlob> getListFileBlobRegular() {
		return listFileBlobRegular;
	}

	public ArrayList<NodeFileBlob> getListFileBlobBig() {
		return listFileBlobBig;
	}

	public String getAltName1() {
		return altName1;
	}

	public void setAltName1(String altName1) {
		this.altName1 = altName1;
	}

	public String getAltName2() {
		return altName2;
	}

	public void setAltName2(String altName2) {
		this.altName2 = altName2;
	}

	public String getAltName3() {
		return altName3;
	}

	public void setAltName3(String altName3) {
		this.altName3 = altName3;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public void setIsReadOnly(String isReadOnly) {
		this.isReadOnly = isReadOnly;
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
	
	


	
	
}
