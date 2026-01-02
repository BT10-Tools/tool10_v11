package tool10.blobset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeBlobSet implements Serializable {

	public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
			String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.blobSetId = blobSetId;
		this.sourceId = sourceId;
		this.blobSetName = blobSetName;
		this.blobSetDesc = blobSetDesc;
		this.blobSetURL = blobSetURL;
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
		this.listBlob = new ArrayList<NodeBlob>();
		this.listBlobEntity = new ArrayList<NodeBlobEntity>(); 
		this.listBlobHash = new ArrayList<NodeBlobHash>(); 
		
		this.mapId2Blob = new HashMap<Long, NodeBlob>(); 
		this.mapId2BlobEntity = new HashMap<Long, NodeBlobEntity>();
		this.mapId2BlobHash = new HashMap<Long, NodeBlobHash>();
		
		this.mapCrc2NodeBlobHash = new HashMap<Long,NodeBlobHash>();
		this.mapEntityId2BlobEntity = new HashMap<Long, NodeBlobEntity>();
		
	}
	public void flushAllListsAndMaps()	{
		this.listBlob.clear();
		this.listBlobEntity.clear(); 
		this.listBlobHash.clear(); 

		this.mapId2Blob.clear();
		this.mapId2BlobEntity.clear(); 
		this.mapId2BlobHash.clear(); 
		
		this.mapCrc2NodeBlobHash.clear();
		this.mapEntityId2BlobEntity.clear();
	}
	private Long blobSetId;
	private Long sourceId;  //reference to file set etc 
	private String blobSetName;
	private String blobSetDesc;
	private String blobSetURL;
	private String ownerName;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeBlob> listBlob;
	private ArrayList<NodeBlobEntity> listBlobEntity; 
	private ArrayList<NodeBlobHash> listBlobHash;
	
	private HashMap<Long,NodeBlob> mapId2Blob;
	private HashMap<Long,NodeBlobEntity> mapId2BlobEntity;
	private HashMap<Long,NodeBlobHash> mapId2BlobHash;
	
	private HashMap<Long,NodeBlobHash> mapCrc2NodeBlobHash;
	private HashMap<Long,NodeBlobEntity> mapEntityId2BlobEntity;
	//GETTERS AND SETTERS

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getBlobSetId() {
		return blobSetId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public String getBlobSetName() {
		return blobSetName;
	}
	public String getBlobSetDesc() {
		return blobSetDesc;
	}
	public String getBlobSetURL() {
		return blobSetURL;
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
	public ArrayList<NodeBlob> getListBlob() {
		return listBlob;
	}
	public ArrayList<NodeBlobEntity> getListBlobEntity() {
		return listBlobEntity;
	}
	public ArrayList<NodeBlobHash> getListBlobHash() {
		return listBlobHash;
	}
	public HashMap<Long, NodeBlob> getMapId2Blob() {
		return mapId2Blob;
	}
	public HashMap<Long, NodeBlobEntity> getMapId2BlobEntity() {
		return mapId2BlobEntity;
	}
	public HashMap<Long, NodeBlobHash> getMapId2BlobHash() {
		return mapId2BlobHash;
	}
	public HashMap<Long, NodeBlobHash> getMapCrc2NodeBlobHash() {
		return mapCrc2NodeBlobHash;
	}
	public HashMap<Long, NodeBlobEntity> getMapEntityId2BlobEntity() {
		return mapEntityId2BlobEntity;
	}
	
	
}
