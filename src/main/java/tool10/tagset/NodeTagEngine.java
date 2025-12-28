package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeTagEngine implements Serializable {


	public NodeTagEngine(Long tagEngineId, Long tagSetId, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc,
			Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.tagEngineId = tagEngineId;
		this.tagSetId = tagSetId;
		this.tagEngineType = tagEngineType;
		this.tagEngineName = tagEngineName;
		this.tagEngineShortName = tagEngineShortName;
		this.tagEngineDesc = tagEngineDesc;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.applicableFileTypeList = new ArrayList<NodeTagFileType>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagEngineId;
	private Long tagSetId;
	private String tagEngineType;  //tika, opencv, ffmpeg etc
	private String tagEngineName;  //tika, opencv, ffmpeg etc
	private String tagEngineShortName;
	private String tagEngineDesc;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	
	private ArrayList<NodeTagFileType> applicableFileTypeList;

	public Long getTagEngineId() {
		return tagEngineId;
	}

	public void setTagEngineId(Long tagEngineId) {
		this.tagEngineId = tagEngineId;
	}

	public Long getTagSetId() {
		return tagSetId;
	}

	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}

	public String getTagEngineName() {
		return tagEngineName;
	}

	public void setTagEngineName(String tagEngineName) {
		this.tagEngineName = tagEngineName;
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

	public ArrayList<NodeTagFileType> getApplicableFileTypeList() {
		return applicableFileTypeList;
	}

	public void setApplicableFileTypeList(ArrayList<NodeTagFileType> applicableFileTypeList) {
		this.applicableFileTypeList = applicableFileTypeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTagEngineShortName() {
		return tagEngineShortName;
	}

	public void setTagEngineShortName(String tagEngineShortName) {
		this.tagEngineShortName = tagEngineShortName;
	}

	public String getTagEngineDesc() {
		return tagEngineDesc;
	}

	public void setTagEngineDesc(String tagEngineDesc) {
		this.tagEngineDesc = tagEngineDesc;
	}

	public String getTagEngineType() {
		return tagEngineType;
	}

	public void setTagEngineType(String tagEngineType) {
		this.tagEngineType = tagEngineType;
	}
	
}
