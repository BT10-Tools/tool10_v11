package tool10.simset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeEntityType implements Serializable  {

	public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
			String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.entityTypeId = entityTypeId;
		this.simSetId = simSetId;;
		this.entityTypeName = entityTypeName;
		this.entityTypeDesc = entityTypeDesc;
		this.dbName = dbName;
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long entityTypeId;
	private Long simSetId;
	private String entityTypeName;
	private String entityTypeDesc;
	private String dbName;
	private String tableName;
	private String fieldName;
	private String fieldType; //string, integer, double, BLOB, tree, graph
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public Long getEntityTypeId() {
		return entityTypeId;
	}
	public void setEntityTypeId(Long entityTypeId) {
		this.entityTypeId = entityTypeId;
	}
	public String getEntityTypeName() {
		return entityTypeName;
	}
	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}
	public String getEntityTypeDesc() {
		return entityTypeDesc;
	}
	public void setEntityTypeDesc(String entityTypeDesc) {
		this.entityTypeDesc = entityTypeDesc;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
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
	public void setSimSetId(Long simSetId) {
		this.simSetId = simSetId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	} 	
		
}
