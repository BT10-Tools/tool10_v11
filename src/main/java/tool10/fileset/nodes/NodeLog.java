package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeLog implements Serializable {

	public NodeLog(Long logId, Long fileSetId, String logLevel, String clazz, String logText, String exceptionText,
			String jobRunId, String createdBy, String modifiedBy, ZonedDateTime logDate, ZonedDateTime creationDate,
			ZonedDateTime modificationDate) {
		super();
		this.logId = logId;
		this.fileSetId = fileSetId;
		this.logLevel = logLevel;
		this.clazz = clazz;
		this.logText = logText;
		this.exceptionText = exceptionText;
		this.jobRunId = jobRunId;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.logDate = logDate;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long logId;
	private Long fileSetId;
	private String logLevel;
	private String clazz;
	private String logText;
	private String exceptionText;
	private String jobRunId;
	private String createdBy;
	private String modifiedBy;
	private ZonedDateTime logDate;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	
	/*
	  CREATE TABLE public.logs (
		 id bigserial NOT NULL,
		 log_date_time timestamp NULL,
		 "level" varchar(255) NULL,
		 clazz varchar(255) NULL,
		 log text NULL,
		 "exception" text NULL,
		 job_run_id varchar(255) NULL,
		 created_by varchar(50) NOT NULL DEFAULT 'system'::character varying,
		 created_date timestamp NOT NULL DEFAULT now(),
		 last_modified_by varchar(50) NULL,
		 last_modified_date timestamp NULL,
		 CONSTRAINT log_pkey PRIMARY KEY (id)
		);
	 
	 CREATE TABLE logs
		( id        BIGINT PRIMARY KEY,
		    level     VARCHAR,
		    marker    VARCHAR,
		    logger    VARCHAR,
		    message   VARCHAR,
		    timestamp TIMESTAMP,
		    mdc       VARCHAR,
		    ndc       VARCHAR
		);

-- Creating the 'logs' table
CREATE TABLE logs (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Unique identifier for each log entry
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Time the log entry was created
    loglevel VARCHAR(10),  -- Severity level of the log (e.g., INFO, WARN, ERROR)
    message TEXT,  -- Log message content
    exception TEXT,  -- Optional field to store exception details, if any
    thread VARCHAR(255)  -- Thread name that generated the log entry
);

-- Index on the timestamp column
CREATE INDEX idx_timestamp ON logs (timestamp);

	 */
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getLogId() {
		return logId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public String getLogLevel() {
		return logLevel;
	}
	public String getClazz() {
		return clazz;
	}
	public String getLogText() {
		return logText;
	}
	public String getExceptionText() {
		return exceptionText;
	}
	public String getJobRunId() {
		return jobRunId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public ZonedDateTime getLogDate() {
		return logDate;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	
}
