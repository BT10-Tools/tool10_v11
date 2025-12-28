package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeTag implements Serializable {

	public NodeTag(Long tagId, Long tagFileId, Long tagTypeId, Long tagStrId, Long displayOrder, String keyName,
			String valueStr, Long valueLength, Long valueLong, Double valueDouble, String valueBoolean,
			ZonedDateTime valueZDT, ZonedDateTime creationDate) {
		super();
		this.tagId = tagId;
		this.tagFileId = tagFileId;
		this.tagTypeId = tagTypeId;
		this.tagStrId = tagStrId;
		this.displayOrder = displayOrder;
		this.keyName = keyName;
		this.valueStr = valueStr;
		this.valueLength = valueLength;
		this.valueLong = valueLong;
		this.valueDouble = valueDouble;
		this.valueBoolean = valueBoolean;
		this.valueZDT = valueZDT;
		this.creationDate = creationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagId;
	private Long tagFileId;
	private Long tagTypeId;
	private Long tagStrId;
	private Long displayOrder;
	private String keyName;
	private String valueStr;
	private Long valueLength;
	private Long valueLong;
	private Double valueDouble;
	private String valueBoolean;
	private ZonedDateTime valueZDT;
	private ZonedDateTime creationDate;
	
	public Long getTagId() {
		return tagId;
	}
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	public Long getTagFileId() {
		return tagFileId;
	}
	public void setTagFileId(Long tagFileId) {
		this.tagFileId = tagFileId;
	}
	public Long getTagTypeId() {
		return tagTypeId;
	}
	public void setTagTypeId(Long tagTypeId) {
		this.tagTypeId = tagTypeId;
	}
	public Long getTagStrId() {
		return tagStrId;
	}
	public void setTagStrId(Long tagStrId) {
		this.tagStrId = tagStrId;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getValueStr() {
		return valueStr;
	}
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
	}
	public Long getValueLength() {
		return valueLength;
	}
	public void setValueLength(Long valueLength) {
		this.valueLength = valueLength;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public void setValueLong(Long valueLong) {
		this.valueLong = valueLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public void setValueDouble(Double valueDouble) {
		this.valueDouble = valueDouble;
	}
	public String getValueBoolean() {
		return valueBoolean;
	}
	public void setValueBoolean(String valueBoolean) {
		this.valueBoolean = valueBoolean;
	}
	public ZonedDateTime getValueZDT() {
		return valueZDT;
	}
	public void setValueZDT(ZonedDateTime valueZDT) {
		this.valueZDT = valueZDT;
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
