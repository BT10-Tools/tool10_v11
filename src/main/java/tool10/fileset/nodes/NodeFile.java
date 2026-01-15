package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NodeFile implements Serializable {

	public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileTypeId, Long sourceId,
			Long fileSize, Long hashCode, Long hashId, String fileType, Long linkedId, String fileStatus,
			String fileName, String fileNameAbsolute, String extensionName, String isDirectory, String isFile,
			String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.parentFileId = parentFileId;
		this.rootFileId = rootFileId;
		this.fileTypeId = fileTypeId;
		this.sourceId = sourceId;
		this.fileSize = fileSize;
		this.hashCode = hashCode;
		this.hashId = hashId;
		this.fileType = fileType;
		this.linkedId = linkedId;
		this.fileStatus = fileStatus;
		this.fileName = fileName;
		this.fileNameAbsolute = fileNameAbsolute;
		this.extensionName = extensionName;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.fileRemark = fileRemark;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileSize, String fileStatus, String fileName, 
			String fileNameAbsolute, String isDirectory, String isFile,
			String fileRemark,ZonedDateTime creationDate) {
		super();
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.parentFileId = parentFileId;
		this.rootFileId = rootFileId;
		this.fileSize = fileSize;
		this.fileStatus = fileStatus;
		this.fileName = fileName;
		this.fileNameAbsolute = fileNameAbsolute;
		this.isDirectory = isDirectory;
		this.isFile = isFile;
		this.fileRemark = fileRemark;
		this.creationDate = creationDate;
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
	private Long parentFileId;
	private Long rootFileId;
	private Long fileTypeId;
	private Long sourceId;
	private Long fileSize;  //file.length();
	private Long hashCode;
	private Long hashId;
	private String fileType; //file, directory, link
	private Long linkedId;	
	private String fileStatus;
	    
	private String fileName;
	private String fileNameAbsolute;
	private String extensionName;
	private String isDirectory;
	private String isFile;
	
	private String fileRemark;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listSiblingFile;
	private ArrayList<NodeFileBlob> listFileBlobRegular;
	private ArrayList<NodeFileBlob> listFileBlobBig;
	private ArrayList<NodeFileBlobSmall> listFileBlobSmall;

	private NodeFileName refFileName;
	private NodeFileProp refFileProp;
	
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
	public void updateFields(Long fileTypeId, Long sourceId, Long hashCode, Long hashId,
			String fileType, String linkType, Long linkedId, String extensionName) {
		this.fileTypeId = fileTypeId;
		this.sourceId = sourceId;
		this.hashCode = hashCode;
		this.hashId = hashId;
		this.fileType = fileType;
		this.linkedId = linkedId;
		this.extensionName = extensionName;
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
	public Long getLinkedId() {
		return linkedId;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileNameAbsolute() {
		return fileNameAbsolute;
	}
	public String getExtensionName() {
		return extensionName;
	}
	public String getIsDirectory() {
		return isDirectory;
	}
	public String getIsFile() {
		return isFile;
	}
	public String getFileRemark() {
		return fileRemark;
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
	public ArrayList<NodeFileBlob> getListFileBlobRegular() {
		return listFileBlobRegular;
	}
	public ArrayList<NodeFileBlob> getListFileBlobBig() {
		return listFileBlobBig;
	}
	public ArrayList<NodeFileBlobSmall> getListFileBlobSmall() {
		return listFileBlobSmall;
	}
	public NodeFileName getRefFileName() {
		return refFileName;
	}
	public NodeFileProp getRefFileProp() {
		return refFileProp;
	}
	public void setRootFileId(Long rootFileId) {
		this.rootFileId = rootFileId;
	}
	public void setFileRemark(String fileRemark) {
		this.fileRemark = fileRemark;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public void setRefFileName(NodeFileName refFileName) {
		this.refFileName = refFileName;
	}
	public void setRefFileProp(NodeFileProp refFileProp) {
		this.refFileProp = refFileProp;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public void setParentFileId(Long parentFileId) {
		this.parentFileId = parentFileId;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public void setHashId(Long hashId) {
		this.hashId = hashId;
	}
	
	
}
