package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
public class NodeTagSet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeTagSet(Long tagSetId, Long fileSetId, String tagSetName, String tagSetDescription, String sourceName, String sourceURL,
			ZonedDateTime creationDate) {
		super();
		this.tagSetId = tagSetId;
		this.fileSetId = fileSetId;
		this.tagSetName = tagSetName;
		this.tagSetDescription = tagSetDescription;
		this.sourceName = sourceName;
		this.sourceURL = sourceURL;
		this.creationDate = creationDate;
		initializeListsAndMaps();
	}
	
	private void initializeListsAndMaps()	{ 
		this.listTag = new ArrayList<NodeTag>();
		this.listTagType = new ArrayList<NodeTagType>();
		this.listTagFile = new ArrayList<NodeTagFile>();
		this.listTagFileType = new ArrayList<NodeTagFileType>();
		this.listTagEngine = new ArrayList<NodeTagEngine>();
		this.listTagStr = new ArrayList<NodeTagStr>();
		this.listEmbedded = new ArrayList<NodeEmbedded>();
		
		this.mapId2Tag = new HashMap<Long,NodeTag>();
		this.mapId2TagType = new HashMap<Long,NodeTagType>();
		this.mapId2TagFile = new HashMap<Long,NodeTagFile>();
		this.mapId2TagFileType = new HashMap<Long,NodeTagFileType>();
		this.mapId2TagEngine = new HashMap<Long,NodeTagEngine>();
		this.mapId2TagStr = new HashMap<Long,NodeTagStr>();
		this.mapId2Embedded = new HashMap<Long,NodeEmbedded>();
		
		this.mapPath2TagFile = new HashMap<String,NodeTagFile>();
		this.mapStr2TagStr = new HashMap<String,NodeTagStr>();
		this.mapFileType2TagFileType = new HashMap<String,NodeTagFileType>();
	}

	private Long tagSetId;
	private Long fileSetId;
	private String tagSetName;
	private String tagSetDescription;
	private String sourceName;
	private String sourceURL;
	private ZonedDateTime creationDate;
	
	private ArrayList<NodeTag> listTag;
	private ArrayList<NodeTagType> listTagType;
	private ArrayList<NodeTagFile> listTagFile;
	private ArrayList<NodeTagFileType> listTagFileType;
	private ArrayList<NodeTagEngine> listTagEngine;
	private ArrayList<NodeTagStr> listTagStr;
	private ArrayList<NodeEmbedded> listEmbedded;
	
	private HashMap<Long,NodeTag> mapId2Tag;
	private HashMap<Long,NodeTagType> mapId2TagType;
	private HashMap<Long,NodeTagFile> mapId2TagFile;
	private HashMap<Long,NodeTagFileType> mapId2TagFileType;
	private HashMap<Long,NodeTagEngine> mapId2TagEngine;
	private HashMap<Long,NodeTagStr> mapId2TagStr;
	private HashMap<Long,NodeEmbedded> mapId2Embedded;
	
	private HashMap<String,NodeTagFile> mapPath2TagFile;
	private HashMap<String,NodeTagStr> mapStr2TagStr;
	private HashMap<String,NodeTagFileType> mapFileType2TagFileType;
	
	//GETTERS AND SETTERS
	public Long getTagSetId() {
		return tagSetId;
	}
	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}

	public String getTagSetName() {
		return tagSetName;
	}

	public void setTagSetName(String tagSetName) {
		this.tagSetName = tagSetName;
	}

	public String getTagSetDescription() {
		return tagSetDescription;
	}

	public void setTagSetDescription(String tagSetDescription) {
		this.tagSetDescription = tagSetDescription;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceURL() {
		return sourceURL;
	}

	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<NodeTag> getListTag() {
		return listTag;
	}

	public void setListTag(ArrayList<NodeTag> listTag) {
		this.listTag = listTag;
	}

	public ArrayList<NodeTagFile> getListTagFile() {
		return listTagFile;
	}

	public void setListTagFile(ArrayList<NodeTagFile> listTagFile) {
		this.listTagFile = listTagFile;
	}

	public ArrayList<NodeTagFileType> getListTagFileType() {
		return listTagFileType;
	}

	public void setListTagFileType(ArrayList<NodeTagFileType> listTagFileType) {
		this.listTagFileType = listTagFileType;
	}

	public ArrayList<NodeTagEngine> getListTagEngine() {
		return listTagEngine;
	}

	public void setListTagEngine(ArrayList<NodeTagEngine> listTagEngine) {
		this.listTagEngine = listTagEngine;
	}

	public HashMap<Long, NodeTag> getMapId2Tag() {
		return mapId2Tag;
	}

	public void setMapId2Tag(HashMap<Long, NodeTag> mapId2Tag) {
		this.mapId2Tag = mapId2Tag;
	}

	public HashMap<Long, NodeTagFile> getMapId2TagFile() {
		return mapId2TagFile;
	}

	public void setMapId2TagFile(HashMap<Long, NodeTagFile> mapId2TagFile) {
		this.mapId2TagFile = mapId2TagFile;
	}

	public HashMap<Long, NodeTagFileType> getMapId2TagFileType() {
		return mapId2TagFileType;
	}

	public void setMapId2TagFileType(HashMap<Long, NodeTagFileType> mapId2TagFileType) {
		this.mapId2TagFileType = mapId2TagFileType;
	}

	public HashMap<Long, NodeTagEngine> getMapId2TagEngine() {
		return mapId2TagEngine;
	}

	public void setMapId2TagEngine(HashMap<Long, NodeTagEngine> mapId2TagEngine) {
		this.mapId2TagEngine = mapId2TagEngine;
	}

	public HashMap<String, NodeTagFile> getMapPath2TagFile() {
		return mapPath2TagFile;
	}

	public void setMapPath2TagFile(HashMap<String, NodeTagFile> mapPath2TagFile) {
		this.mapPath2TagFile = mapPath2TagFile;
	}

	public ArrayList<NodeTagType> getListTagType() {
		return listTagType;
	}

	public void setListTagType(ArrayList<NodeTagType> listTagType) {
		this.listTagType = listTagType;
	}

	public HashMap<Long, NodeTagType> getMapId2TagType() {
		return mapId2TagType;
	}

	public void setMapId2TagType(HashMap<Long, NodeTagType> mapId2TagType) {
		this.mapId2TagType = mapId2TagType;
	}

	public HashMap<Long, NodeTagStr> getMapId2TagStr() {
		return mapId2TagStr;
	}

	public void setMapId2TagStr(HashMap<Long, NodeTagStr> mapId2TagStr) {
		this.mapId2TagStr = mapId2TagStr;
	}

	public ArrayList<NodeTagStr> getListTagStr() {
		return listTagStr;
	}

	public void setListTagStr(ArrayList<NodeTagStr> listTagStr) {
		this.listTagStr = listTagStr;
	}

	public HashMap<String, NodeTagStr> getMapStr2TagStr() {
		return mapStr2TagStr;
	}

	public void setMapStr2TagStr(HashMap<String, NodeTagStr> mapStr2TagStr) {
		this.mapStr2TagStr = mapStr2TagStr;
	}

	public HashMap<String, NodeTagFileType> getMapFileType2TagFileType() {
		return mapFileType2TagFileType;
	}

	public void setMapFileType2TagFileType(HashMap<String, NodeTagFileType> mapFileType2TagFileType) {
		this.mapFileType2TagFileType = mapFileType2TagFileType;
	}

	public ArrayList<NodeEmbedded> getListEmbedded() {
		return listEmbedded;
	}

	public void setListEmbedded(ArrayList<NodeEmbedded> listEmbedded) {
		this.listEmbedded = listEmbedded;
	}

	public HashMap<Long, NodeEmbedded> getMapId2Embedded() {
		return mapId2Embedded;
	}

	public void setMapId2Embedded(HashMap<Long, NodeEmbedded> mapId2Embedded) {
		this.mapId2Embedded = mapId2Embedded;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getFileSetId() {
		return fileSetId;
	}
	
	
	
}
