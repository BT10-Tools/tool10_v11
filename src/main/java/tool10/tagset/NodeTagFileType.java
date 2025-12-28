package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeTagFileType implements Serializable {

	public NodeTagFileType(Long tagFileTypeId, Long tagSetId, String tagFileTypeName, String tagFileTypeDesc,
			String primaryExtension, String detectedExtensionListString, Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.tagFileTypeId = tagFileTypeId;
		this.tagSetId = tagSetId;
		this.tagFileTypeName = tagFileTypeName;
		this.tagFileTypeDesc = tagFileTypeDesc;
		this.primaryExtension = primaryExtension;
		this.detectedExtensionListString = detectedExtensionListString;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagFileTypeId;
	private Long tagSetId;
	private String tagFileTypeName;
	private String tagFileTypeDesc;
	private String primaryExtension;
	private String detectedExtensionListString;
	
	private Long displayOrder;
	private ZonedDateTime creationDate;
	
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
	public String getTagFileTypeName() {
		return tagFileTypeName;
	}
	public void setTagFileTypeName(String tagFileTypeName) {
		this.tagFileTypeName = tagFileTypeName;
	}
	public String getTagFileTypeDesc() {
		return tagFileTypeDesc;
	}
	public void setTagFileTypeDesc(String tagFileTypeDesc) {
		this.tagFileTypeDesc = tagFileTypeDesc;
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
	public String getPrimaryExtension() {
		return primaryExtension;
	}
	public void setPrimaryExtension(String primaryExtension) {
		this.primaryExtension = primaryExtension;
	}
	public String getDetectedExtensionListString() {
		return detectedExtensionListString;
	}
	public void setDetectedExtensionListString(String detectedExtensionListString) {
		this.detectedExtensionListString = detectedExtensionListString;
	}
	
}
