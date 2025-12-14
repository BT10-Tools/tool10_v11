package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeProperty implements Serializable {

	public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
			String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
			Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.propertyId = propertyId;
		this.fileSetId = fileSetId;
		this.entityId = entityId;
		this.displayOrder = displayOrder;
		this.mapName = mapName;
		this.entityName = entityName;
		this.propertyKey = propertyKey;
		this.propertyValue = propertyValue;
		this.valueString = valueString;
		this.valueLong = valueLong;
		this.valueDouble = valueDouble;
		this.valueBinary = valueBinary;
		this.valueZDT = valueZDT;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long propertyId;
	private Long fileSetId;
	private Long entityId;
	private Long displayOrder;
	private String mapName;
	private String entityName;
	private String propertyKey;
	private String propertyValue;
	private String valueString; //maybe with some changes
	private Long valueLong;
	private Double valueDouble;
	private NodeBinary valueBinary;
	private ZonedDateTime valueZDT;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getEntityId() {
		return entityId;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public String getMapName() {
		return mapName;
	}
	public String getEntityName() {
		return entityName;
	}
	public String getPropertyKey() {
		return propertyKey;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public String getValueString() {
		return valueString;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public ZonedDateTime getValueZDT() {
		return valueZDT;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public NodeBinary getValueBinary() {
		return valueBinary;
	}
	public void setValueBinary(NodeBinary valueBinary) {
		this.valueBinary = valueBinary;
	}
	
	
}
