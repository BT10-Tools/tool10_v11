package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeQuery  implements Serializable {

	public NodeQuery(Long queryId, Long fileSetId, Long entityId, Long cntExecution, String sqlString,
			ZonedDateTime firstExecutionDate, ZonedDateTime lastExecutionDate, ZonedDateTime creationDate,
			ZonedDateTime modificationDate) {
		super();
		this.queryId = queryId;
		this.fileSetId = fileSetId;
		this.entityId = entityId;
		this.cntExecution = cntExecution;
		this.sqlString = sqlString;
		this.firstExecutionDate = firstExecutionDate;
		this.lastExecutionDate = lastExecutionDate;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long queryId;
	private Long fileSetId;
	private Long entityId;
	private Long cntExecution;
	private String sqlString;
	private ZonedDateTime firstExecutionDate;
	private ZonedDateTime lastExecutionDate;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getQueryId() {
		return queryId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getEntityId() {
		return entityId;
	}
	public Long getCntExecution() {
		return cntExecution;
	}
	public String getSqlString() {
		return sqlString;
	}
	public ZonedDateTime getFirstExecutionDate() {
		return firstExecutionDate;
	}
	public ZonedDateTime getLastExecutionDate() {
		return lastExecutionDate;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	
	
	
}
