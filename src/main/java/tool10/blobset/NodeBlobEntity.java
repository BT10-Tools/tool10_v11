package tool10.blobset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeBlobEntity implements Serializable  {

	public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
			Long sourceSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
			Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.blobEntityId = blobEntityId;
		this.entityId = entityId;
		this.blobId = blobId;
		this.blobSetId = blobSetId;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.sourceSize = sourceSize;
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
	public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType,
			Long blobSize, Long sourceSize, byte[] fileBytes, Long hashId, 
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.blobEntityId = blobEntityId;
		this.entityId = entityId;
		this.blobId = blobId;
		this.blobSetId = blobSetId;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.sourceSize = sourceSize;
		this.hashId = hashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long blobEntityId;
	private Long entityId;  //fileId, mediaId, bookId etc. 
	private Long blobId;
	private Long blobSetId;
	private String blobType;  //regular, big, small
	private Long blobSize;
	private Long sourceSize;
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
		
	public void setFieldsBig(Long blobId,String blobDbName, String blobDbAttachmentName, String blobTableName,
			Long bigPartNumber, Long bigCntPart) {	
		this.blobDbName = blobDbName;
		this.blobDbAttachmentName = blobDbAttachmentName;
		this.blobTableName = blobTableName; 
		this.bigPartNumber = bigPartNumber; 
		this.bigCntPart = bigCntPart;
	}	
	public void setFieldsSmall(Long blobId,String blobDbName, String blobDbAttachmentName, String blobTableName,		
			Long smallByteIndexStart, Long smallByteIndexEnd) {	
		this.blobId = blobId;
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
	public Long getBlobEntityId() {
		return blobEntityId;
	}
	public Long getEntityId() {
		return entityId;
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
	public Long getSourceSize() {
		return sourceSize;
	}
	public void setSourceSize(Long sourceSize) {
		this.sourceSize = sourceSize;
	}
	public Long getBlobSetId() {
		return blobSetId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Long getBlobId() {
		return blobId;
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
	public void setBlobId(Long blobId) {
		this.blobId = blobId;
	}
	
	
	
	
	
}
