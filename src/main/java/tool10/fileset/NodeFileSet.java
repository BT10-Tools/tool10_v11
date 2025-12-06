package tool10.fileset;

import java.io.Serializable;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeFileSet implements Serializable {

	public NodeFileSet(Long fileSetId, Long sourceId, String fileSetName, String fileSetDesc, String fileSetURL,
			String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileSetId = fileSetId;
		this.sourceId = sourceId;
		this.fileSetName = fileSetName;
		this.fileSetDesc = fileSetDesc;
		this.fileSetURL = fileSetURL;
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
		this.listFile = new ArrayList<NodeFile>(); 
		this.listFileBlob = new ArrayList<NodeFileBlob>();
		this.listFileBlobSmall = new ArrayList<NodeFileBlobSmall>();
		this.listFileSystem = new ArrayList<NodeFileSystem>(); 
		this.listFileStore = new ArrayList<NodeFileStore>(); 
		this.listHash = new ArrayList<NodeHash>();
		this.listHost = new ArrayList<NodeHost>();
		this.listProperty = new ArrayList<NodeProperty>();
		this.listQuery = new ArrayList<NodeQuery>();
		this.listSimilarity = new ArrayList<NodeSimilarity>();
		this.listStat = new ArrayList<NodeStat>();
		
		this.mapId2File = new HashMap<Long, NodeFile>(); 
		this.mapId2FileBlob = new HashMap<Long, NodeFileBlob>();
		this.mapId2FileBlobSmall = new HashMap<Long, NodeFileBlobSmall>();
		this.mapId2FileSystem = new HashMap<Long, NodeFileSystem>();
		this.mapId2FileStore = new HashMap<Long, NodeFileStore>();
		this.mapId2Hash = new HashMap<Long, NodeHash>();
		this.mapId2Host = new HashMap<Long, NodeHost>(); 
		this.mapId2Property = new HashMap<Long, NodeProperty>(); 
		this.mapId2Query = new HashMap<Long, NodeQuery>();
		this.mapId2Similarity = new HashMap<Long, NodeSimilarity>();
		this.mapId2Stat = new HashMap<Long, NodeStat>();
		
		this.listRoots = new ArrayList<NodeFile>();
		this.mapAbsoluteFileName2File = new HashMap<String,NodeFile>();
		this.mapRawFileSystem2FileSystem = new HashMap<FileSystem,NodeFileSystem>(); 
		this.mapRawFileStore2FileStore = new HashMap<FileStore,NodeFileStore>(); 
		this.mapCrc2NodeHash = new HashMap<Long,NodeHash>();
		this.mapKey2Similarity = new HashMap<String,NodeSimilarity>();
	}
	public void flushAllListsAndMaps()	{
		this.listFile.clear(); 
		this.listFileBlob.clear();
		this.listFileBlobSmall.clear();
		this.listFileSystem.clear(); 
		this.listFileStore.clear(); 
		this.listHash.clear();
		this.listHost.clear(); 
		this.listProperty.clear(); 
		this.listQuery.clear();
		this.listSimilarity.clear();
		this.listStat.clear();
		
		this.mapId2File.clear(); 
		this.mapId2FileBlob.clear();
		this.mapId2FileBlobSmall.clear();
		this.mapId2FileSystem.clear(); 
		this.mapId2FileStore.clear(); 
		this.mapId2Hash.clear();
		this.mapId2Host.clear(); 
		this.mapId2Property.clear(); 
		this.mapId2Query.clear();
		this.mapId2Similarity.clear();
		this.mapId2Stat.clear();
				
		this.listRoots.clear();
		this.mapAbsoluteFileName2File.clear();
		this.mapRawFileSystem2FileSystem.clear(); 
		this.mapRawFileStore2FileStore.clear(); 
		this.mapCrc2NodeHash.clear();
		this.mapKey2Similarity.clear();
	}
	private Long fileSetId;
	private Long sourceId;  //reference to file set etc 
	private String fileSetName;
	private String fileSetDesc;
	private String fileSetURL;
	private String ownerName;
	private Long displayOrder;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listFile;
	private ArrayList<NodeFileBlob> listFileBlob; 
	private ArrayList<NodeFileBlobSmall> listFileBlobSmall;
	private ArrayList<NodeFileSystem> listFileSystem;
	private ArrayList<NodeFileStore> listFileStore;
	private ArrayList<NodeHash> listHash;
	private ArrayList<NodeHost> listHost;
	private ArrayList<NodeProperty> listProperty;
	private ArrayList<NodeQuery> listQuery;
	private ArrayList<NodeSimilarity> listSimilarity;
	private ArrayList<NodeStat> listStat;

	private HashMap<Long,NodeFile> mapId2File;
	private HashMap<Long,NodeFileBlob> mapId2FileBlob;
	private HashMap<Long,NodeFileBlobSmall> mapId2FileBlobSmall;
	private HashMap<Long,NodeFileSystem> mapId2FileSystem;
	private HashMap<Long,NodeFileStore> mapId2FileStore;
	private HashMap<Long,NodeHash> mapId2Hash;
	private HashMap<Long,NodeHost> mapId2Host;
	private HashMap<Long,NodeProperty> mapId2Property;
	private HashMap<Long,NodeQuery> mapId2Query;
	private HashMap<Long,NodeSimilarity> mapId2Similarity;
	private HashMap<Long,NodeStat> mapId2Stat;

	private ArrayList<NodeFile> listRoots;
	private HashMap<String,NodeFile> mapAbsoluteFileName2File;
	private HashMap<FileSystem,NodeFileSystem> mapRawFileSystem2FileSystem;
	private HashMap<FileStore,NodeFileStore> mapRawFileStore2FileStore;
	private HashMap<Long,NodeHash> mapCrc2NodeHash;
	private HashMap<String,NodeSimilarity> mapKey2Similarity;
	
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
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public String getFileSetName() {
		return fileSetName;
	}
	public String getFileSetDesc() {
		return fileSetDesc;
	}
	public String getFileSetURL() {
		return fileSetURL;
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
	public ArrayList<NodeFile> getListFile() {
		return listFile;
	}
	public ArrayList<NodeFileBlob> getListFileBlob() {
		return listFileBlob;
	}
	public ArrayList<NodeFileStore> getListFileStore() {
		return listFileStore;
	}
	public ArrayList<NodeHash> getListHash() {
		return listHash;
	}
	public ArrayList<NodeHost> getListHost() {
		return listHost;
	}
	public ArrayList<NodeQuery> getListQuery() {
		return listQuery;
	}
	public ArrayList<NodeStat> getListStat() {
		return listStat;
	}
	public HashMap<Long, NodeFile> getMapId2File() {
		return mapId2File;
	}
	public HashMap<Long, NodeFileBlob> getMapId2FileBlob() {
		return mapId2FileBlob;
	}
	public HashMap<Long, NodeFileStore> getMapId2FileStore() {
		return mapId2FileStore;
	}
	public HashMap<Long, NodeHash> getMapId2Hash() {
		return mapId2Hash;
	}
	public HashMap<Long, NodeHost> getMapId2Host() {
		return mapId2Host;
	}
	public HashMap<Long, NodeQuery> getMapId2Query() {
		return mapId2Query;
	}
	public HashMap<Long, NodeStat> getMapId2Stat() {
		return mapId2Stat;
	}
	public ArrayList<NodeFileBlobSmall> getListFileBlobSmall() {
		return listFileBlobSmall;
	}
	public HashMap<Long, NodeFileBlobSmall> getMapId2FileBlobSmall() {
		return mapId2FileBlobSmall;
	}
	public HashMap<Long, NodeFileSystem> getMapId2FileSystem() {
		return mapId2FileSystem;
	}
	public ArrayList<NodeFileSystem> getListFileSystem() {
		return listFileSystem;
	}
	public ArrayList<NodeProperty> getListProperty() {
		return listProperty;
	}
	public HashMap<Long, NodeProperty> getMapId2Property() {
		return mapId2Property;
	}
	public HashMap<FileSystem, NodeFileSystem> getMapRawFileSystem2FileSystem() {
		return mapRawFileSystem2FileSystem;
	}
	public HashMap<FileStore, NodeFileStore> getMapRawFileStore2FileStore() {
		return mapRawFileStore2FileStore;
	}
	public ArrayList<NodeSimilarity> getListSimilarity() {
		return listSimilarity;
	}
	public HashMap<Long, NodeSimilarity> getMapId2Similarity() {
		return mapId2Similarity;
	}
	public HashMap<Long, NodeHash> getMapCrc2NodeHash() {
		return mapCrc2NodeHash;
	}
	public ArrayList<NodeFile> getListRoots() {
		return listRoots;
	}
	public HashMap<String, NodeFile> getMapAbsoluteFileName2File() {
		return mapAbsoluteFileName2File;
	}
	public HashMap<String, NodeSimilarity> getMapKey2Similarity() {
		return mapKey2Similarity;
	}
	
	
}
