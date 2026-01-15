package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

import tool10.blobset.NodeBlobEntity;

public class NodeFileBlob implements Serializable  {

	public NodeFileBlob(Long fileBlobId, Long fileId, Long blobEntityId, Long fileSetId, String blobType, Long blobSize,
			Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
			Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileBlobId = fileBlobId;
		this.fileId = fileId;
		this.blobEntityId = blobEntityId;
		this.fileSetId = fileSetId;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.fileSize = fileSize;
		this.hashId = hashId;
		this.blobDbName = blobDbName;
		this.blobDbAttachmentName = blobDbAttachmentName;
		this.blobTableName = blobTableName;
		this.bigPartNumber = bigPartNumber;
		this.bigCntPart = bigCntPart;
		this.smallByteIndexStart = smallByteIndexStart;
		this.smallByteIndexEnd = smallByteIndexEnd;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, String blobType,
			Long blobSize, Long fileSize, byte[] fileBytes, Long hashId, 
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileBlobId = fileBlobId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.fileSize = fileSize;
		this.hashId = hashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fileBlobId;
	private Long fileId;
	private Long blobEntityId;
	private Long fileSetId;
	private String blobType;  //regular, big, small
	private Long blobSize;
	private Long fileSize;
	private Long hashId;	
	
	private String blobDbName;
	private String blobDbAttachmentName;
	private String blobTableName;
	
	private Long bigPartNumber;
	private Long bigCntPart;
	private Long smallByteIndexStart;
	private Long smallByteIndexEnd;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeBlobEntity refBlobEntity;
		
	public void setFieldsBig(String blobDbName, String blobDbAttachmentName, String blobTableName,
			Long bigPartNumber, Long bigCntPart) {	
		this.blobDbName = blobDbName;
		this.blobDbAttachmentName = blobDbAttachmentName;
		this.blobTableName = blobTableName; 
		this.bigPartNumber = bigPartNumber; 
		this.bigCntPart = bigCntPart;
	}	
	public void setFieldsSmall(String blobDbName, String blobDbAttachmentName, String blobTableName,		
			Long smallByteIndexStart, Long smallByteIndexEnd) {	
		this.blobDbName = blobDbName;
		this.blobDbAttachmentName = blobDbAttachmentName;
		this.blobTableName = blobTableName; 
		this.smallByteIndexStart = smallByteIndexStart; 
		this.smallByteIndexEnd = smallByteIndexEnd;
	}
	//GETTERS AND SETTERS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileBlobId() {
		return fileBlobId;
	}
	public Long getFileId() {
		return fileId;
	}
	public String getBlobType() {
		return blobType;
	}
	public Long getBlobSize() {
		return blobSize;
	}
	public Long getHashId() {
		return hashId;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getBlobDbName() {
		return blobDbName;
	}
	public String getBlobDbAttachmentName() {
		return blobDbAttachmentName;
	}
	public String getBlobTableName() {
		return blobTableName;
	}
	public Long getBigPartNumber() {
		return bigPartNumber;
	}
	public Long getBigCntPart() {
		return bigCntPart;
	}
	public Long getSmallByteIndexStart() {
		return smallByteIndexStart;
	}
	public Long getSmallByteIndexEnd() {
		return smallByteIndexEnd;
	}
	public void setSmallByteIndexStart(Long smallByteIndexStart) {
		this.smallByteIndexStart = smallByteIndexStart;
	}
	public void setSmallByteIndexEnd(Long smallByteIndexEnd) {
		this.smallByteIndexEnd = smallByteIndexEnd;
	}
	public NodeBlobEntity getRefBlobEntity() {
		return refBlobEntity;
	}
	public void setRefBlobEntity(NodeBlobEntity refBlobEntity) {
		this.refBlobEntity = refBlobEntity;
	}
	public Long getBlobEntityId() {
		return blobEntityId;
	}
	public void setHashId(Long hashId) {
		this.hashId = hashId;
	}
	
	
	
	
	
}
