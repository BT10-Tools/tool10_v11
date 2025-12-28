package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeTagType implements Serializable {


	
	public NodeTagType(Long tagTypeId, Long tagFileTypeId, Long tagSetId, String tagTypeName, String tagTypeDesc,
			String tagVariableDataType, Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.tagTypeId = tagTypeId;
		this.tagFileTypeId = tagFileTypeId;
		this.tagSetId = tagSetId;
		this.tagTypeName = tagTypeName;
		this.tagTypeDesc = tagTypeDesc;
		this.tagVariableDataType = tagVariableDataType;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagTypeId;
	private Long tagFileTypeId;
	private Long tagSetId;
	private String tagTypeName;
	private String tagTypeDesc;
	private String tagVariableDataType;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	
	public Long getTagTypeId() {
		return tagTypeId;
	}
	public void setTagTypeId(Long tagTypeId) {
		this.tagTypeId = tagTypeId;
	}
	public Long getTagFileTypeId() {
		return tagFileTypeId;
	}
	public void setTagFileTypeId(Long tagFileTypeId) {
		this.tagFileTypeId = tagFileTypeId;
	}
	public Long getTagSetId() {
		return tagSetId;
	}
	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}
	public String getTagTypeName() {
		return tagTypeName;
	}
	public void setTagTypeName(String tagTypeName) {
		this.tagTypeName = tagTypeName;
	}
	public String getTagTypeDesc() {
		return tagTypeDesc;
	}
	public void setTagTypeDesc(String tagTypeDesc) {
		this.tagTypeDesc = tagTypeDesc;
	}
	public String getTagVariableDataType() {
		return tagVariableDataType;
	}
	public void setTagVariableDataType(String tagVariableDataType) {
		this.tagVariableDataType = tagVariableDataType;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
}
