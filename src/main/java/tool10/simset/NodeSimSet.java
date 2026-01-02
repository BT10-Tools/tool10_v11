package tool10.simset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeSimSet implements Serializable {

	
	public NodeSimSet(Long simSetId, Long sourceId, String simSetName, String simSetDesc, String sourceName, String ownerName,
			Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.simSetId = simSetId;
		this.sourceId = sourceId;
		this.simSetName = simSetName;
		this.simSetDesc = simSetDesc;
		this.sourceName = sourceName;
		this.ownerName = ownerName;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void initializeListsAndMaps()	{ 
		this.listEntityType = new ArrayList<NodeEntityType>();
		this.listEntity = new ArrayList<NodeEntity>();
		this.listSimilarity = new ArrayList<NodeSimilarity>();
		
		this.mapId2EntityType = new HashMap<Long, NodeEntityType>();
		this.mapId2Entity = new HashMap<Long, NodeEntity>();
		this.mapId2Similarity = new HashMap<Long, NodeSimilarity>();
		this.mapEntityName2EntityType = new HashMap<String,NodeEntityType>();
		this.mapKey2Similarity = new HashMap<String,NodeSimilarity>();
	}
	public void flushAllListsAndMaps()	{
		this.listEntityType.clear();
		this.listEntity.clear();
		this.listSimilarity.clear();
		
		this.mapId2EntityType.clear();
		this.mapId2Entity.clear();
		this.mapId2Similarity.clear();
		this.mapEntityName2EntityType.clear();
		this.mapKey2Similarity.clear();
	}
	private Long simSetId;
	private Long sourceId;  //reference to file set etc 
	private String simSetName;
	private String simSetDesc;
	private String sourceName;
	private String ownerName;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeEntityType> listEntityType;
	private ArrayList<NodeEntity> listEntity;
	private ArrayList<NodeSimilarity> listSimilarity;
	
	private HashMap<Long,NodeEntityType> mapId2EntityType;
	private HashMap<Long,NodeEntity> mapId2Entity;
	private HashMap<Long,NodeSimilarity> mapId2Similarity;
	private HashMap<String,NodeEntityType> mapEntityName2EntityType;
	private HashMap<String,NodeSimilarity> mapKey2Similarity;
	
	//GETTERS AND SETTERS

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getSimSetId() {
		return simSetId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public String getSimSetName() {
		return simSetName;
	}
	public String getSimSetDesc() {
		return simSetDesc;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public ArrayList<NodeSimilarity> getListSimilarity() {
		return listSimilarity;
	}
	public HashMap<Long, NodeSimilarity> getMapId2Similarity() {
		return mapId2Similarity;
	}
	public HashMap<String, NodeSimilarity> getMapKey2Similarity() {
		return mapKey2Similarity;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public ArrayList<NodeEntityType> getListEntityType() {
		return listEntityType;
	}
	public ArrayList<NodeEntity> getListEntity() {
		return listEntity;
	}
	public HashMap<Long, NodeEntityType> getMapId2EntityType() {
		return mapId2EntityType;
	}
	public HashMap<Long, NodeEntity> getMapId2Entity() {
		return mapId2Entity;
	}
	public HashMap<String, NodeEntityType> getMapEntityName2EntityType() {
		return mapEntityName2EntityType;
	}
		
}
