package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeStat implements Serializable {

	public NodeStat(Long statId, Long fileSetId, Long entityId, String entityIdType, String statType,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.statId = statId;
		this.fileSetId = fileSetId;
		this.entityId = entityId;
		this.entityIdType = entityIdType;
		this.statType = statType;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//stat can be for file, group, corpus, fileType, fileTemplate, lineTemplate, lineGroup
	//stat can be partially for line, token, tokenType
	private Long statId;
	private Long fileSetId;
	private Long entityId;
	private String entityIdType;
	private String statType;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
/*
	private long __depth=-1;
	private long __cntDirectory=-1;
	private long __cntFile=-1;
	private long __sumFileSize=-1;
	private long __avgFileSize=-1;
	private long __sumCrc=-1;
	private long __treeCntDirectory=-1;
	private long __treeCntFile=-1;
	private long __treeSumFileSize=-1;
	private long __treeSumCrc=-1;
	private long __treeMaxDepth=-1;
	private long __treeMaxPathLength=-1;
	private long __treeMaxFileNameLength=-1;
	private long __treeMaxFileSize=-1;
	private long __treeAvgFileSize=-1;
	private FileTime __firstCreationDate=null;
	private FileTime __lastCreationDate=null;
	private FileTime __lastModificationDate=null;
	private FileTime __firstModificationDate=null;
	
	private Long fileTxtGroupId;
	private Long sourceId;
	private Long languageId;
	private Long languageId2;
	private Long fileSize;
	private Long cntDistinctLanguageId;
	private Long cntDistinctEncoding;
	
	private Long cntFile;
	private Long cntLine;
	private Long cntDistinctLine;
	private Long cntEmptyLine;
	private Long minCntLinePerFile;
	private Long maxCntLinePerFile;

	private Long cntCharacter;
	private Long cntDistinctCharacter;
	private Long cntColumn;
	private Long avgColumn;
	
	private Long cntPhrase;
	private Long cntDistinctPhrase;
	private Long cntToken;
	private Long cntDistinctToken;
	private Long minLineLength;
	private Long maxLineLength;
	private Long sumLineLength;
	private Double avgLineLength;
	private Long crc64;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
*/		
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getStatId() {
		return statId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getEntityId() {
		return entityId;
	}
	public String getEntityIdType() {
		return entityIdType;
	}
	public String getStatType() {
		return statType;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	
}
