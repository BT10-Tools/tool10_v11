package tool10.simset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeEntity implements Serializable  {

	public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
			Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.entityId = entityId;
		this.entityTypeId = entityTypeId;
		this.simSetId = simSetId;
		this.sourceId = sourceId;
		this.valueStr = valueStr;
		this.valueLong = valueLong;
		this.valueDouble = valueDouble;
		this.valueBLOB = valueBLOB;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long entityId;
	private Long entityTypeId;
	private Long simSetId;
	private Long sourceId;
	private String valueStr;
	private Long valueLong;
	private Double valueDouble;
	private byte[] valueBLOB;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public Long getEntityId() {
		return entityId;
	}
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	public Long getEntityTypeId() {
		return entityTypeId;
	}
	public void setEntityTypeId(Long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	public String getValueStr() {
		return valueStr;
	}
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
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
	public byte[] getValueBLOB() {
		return valueBLOB;
	}
	public void setValueBLOB(byte[] valueBLOB) {
		this.valueBLOB = valueBLOB;
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
	public Long getSimSetId() {
		return simSetId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	
			
}
