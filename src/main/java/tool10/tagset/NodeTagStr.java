package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeTagStr implements Serializable  {

	public NodeTagStr(Long tagStrId, Long tagSetId, Long tagTypeId, String tagType, String strType, Long strLength, String tagStr,
			Long crc64, ZonedDateTime creationDate) {
		super();
		this.tagStrId = tagStrId;
		this.tagSetId = tagSetId;
		this.tagTypeId = tagTypeId;
		this.tagType = tagType;
		this.strType = strType;
		this.strLength = strLength;
		this.tagStr = tagStr;
		this.crc64 = crc64;
		this.creationDate = creationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagStrId;
	private Long tagSetId;
	private Long tagTypeId;
	private String tagType;
	private String strType;
	private Long strLength;
	private String tagStr;
	private Long crc64;	
	private ZonedDateTime creationDate;
	
	public Long getTagStrId() {
		return tagStrId;
	}
	public void setTagStrId(Long tagStrId) {
		this.tagStrId = tagStrId;
	}
	public Long getTagTypeId() {
		return tagTypeId;
	}
	public void setTagTypeId(Long tagTypeId) {
		this.tagTypeId = tagTypeId;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getStrType() {
		return strType;
	}
	public void setStrType(String strType) {
		this.strType = strType;
	}
	public Long getStrLength() {
		return strLength;
	}
	public void setStrLength(Long strLength) {
		this.strLength = strLength;
	}
	public String getTagStr() {
		return tagStr;
	}
	public void setTagStr(String tagStr) {
		this.tagStr = tagStr;
	}
	public Long getCrc64() {
		return crc64;
	}
	public void setCrc64(Long crc64) {
		this.crc64 = crc64;
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
	public Long getTagSetId() {
		return tagSetId;
	}
	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}
	
			
}
