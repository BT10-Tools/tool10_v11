package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeFileGrouping implements Serializable {

	
	public NodeFileGrouping(Long fileGroupingId, Long fileSetId, Long sourceId, Long mainFileGroupId,
			Long defaultFileGroupId, String fileGroupingName, String fileGroupingDesc, String isGroupsDisjoint,
			Long displayOrder, Long cntGroup, ZonedDateTime creationDate, ZonedDateTime modificationDate,
			ArrayList<Long> listNodeFileGroup) {
		super();
		this.fileGroupingId = fileGroupingId;
		this.fileSetId = fileSetId;
		this.sourceId = sourceId;
		this.mainFileGroupId = mainFileGroupId;
		this.defaultFileGroupId = defaultFileGroupId;
		this.fileGroupingName = fileGroupingName;
		this.fileGroupingDesc = fileGroupingDesc;
		this.isGroupsDisjoint = isGroupsDisjoint;
		this.displayOrder = displayOrder;
		this.cntGroup = cntGroup;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listNodeFileGroup = new ArrayList<Long>();
	}
	
	public NodeFileGrouping(Long fileGroupingId, Long fileSetId, Long sourceId, String fileGroupingName, String fileGroupingDesc, String isGroupsDisjoint,
			Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.fileGroupingId = fileGroupingId;
		this.fileSetId = fileSetId;
		this.sourceId = sourceId;
		this.fileGroupingName = fileGroupingName;
		this.fileGroupingDesc = fileGroupingDesc;
		this.isGroupsDisjoint = isGroupsDisjoint;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
	}
	
	private static final long serialVersionUID = 1L;
	private Long fileGroupingId;
	private Long fileSetId;
	private Long sourceId;  //reference to file set etc
	private Long mainFileGroupId;
	private Long defaultFileGroupId;
	private String fileGroupingName;
	private String fileGroupingDesc;
	private String isGroupsDisjoint;
	private Long displayOrder;
	private Long cntGroup;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<Long> listNodeFileGroup;

	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileGroupingId() {
		return fileGroupingId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public Long getMainFileGroupId() {
		return mainFileGroupId;
	}
	public Long getDefaultFileGroupId() {
		return defaultFileGroupId;
	}
	public String getFileGroupingName() {
		return fileGroupingName;
	}
	public String getFileGroupingDesc() {
		return fileGroupingDesc;
	}
	public String getIsGroupsDisjoint() {
		return isGroupsDisjoint;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public Long getCntGroup() {
		return cntGroup;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public ArrayList<Long> getListNodeFileGroup() {
		return listNodeFileGroup;
	}
	
	
}
