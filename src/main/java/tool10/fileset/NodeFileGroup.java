package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeFileGroup implements Serializable {

	
	public NodeFileGroup(Long fileGroupId, Long fileSetId, Long sourceId, Long higherFileGroupId, String fileGroupName,
			String fileGroupDesc, Long displayOrder, Long cntMember, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileGroupId = fileGroupId;
		this.sourceId = sourceId;
		this.higherFileGroupId = higherFileGroupId;
		this.fileGroupName = fileGroupName;
		this.fileGroupDesc = fileGroupDesc;
		this.displayOrder = displayOrder;
		this.cntMember = cntMember;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	private static final long serialVersionUID = 1L;
	private Long fileGroupId;
	private Long fileSetId;
	private Long sourceId;  //reference to file set etc
	private Long higherFileGroupId;
	private String fileGroupName;
	private String fileGroupDesc;
	private Long displayOrder;
	private Long cntMember;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
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
	public Long getFileGroupId() {
		return fileGroupId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getHigherFileGroupId() {
		return higherFileGroupId;
	}
	public String getFileGroupName() {
		return fileGroupName;
	}
	public String getFileGroupDesc() {
		return fileGroupDesc;
	}
	public Long getCntMember() {
		return cntMember;
	}
	
	
}
