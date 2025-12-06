package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeFileGroupMember implements Serializable {

	public NodeFileGroupMember(Long fileGroupMemberId, Long fileGroupId, Long fileSetId, Long fileId, Long displayOrder,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileGroupMemberId = fileGroupMemberId;
		this.fileGroupId = fileGroupId;
		this.fileSetId = fileSetId;
		this.fileId = fileId;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	private static final long serialVersionUID = 1L;
	
	private Long fileGroupMemberId;
	private Long fileGroupId;
	private Long fileSetId;
	private Long fileId;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileGroupMemberId() {
		return fileGroupMemberId;
	}
	public Long getFileGroupId() {
		return fileGroupId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getFileId() {
		return fileId;
	}
	
}
