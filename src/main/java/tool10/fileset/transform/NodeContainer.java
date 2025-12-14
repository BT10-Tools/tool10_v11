package tool10.fileset.transform;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.fileset.nodes.NodeFile;

public class NodeContainer implements Serializable {

	public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
			String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
			Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.containerId = containerId;
		this.fileSetId = fileSetId;
		this.containerFileId = containerFileId;
		this.containerFileSetId = containerFileSetId;
		this.containerType = containerType;
		this.extensionType = extensionType;
		this.algorithmName = algorithmName;
		this.containerRemark = containerRemark;
		this.cntFile = cntFile;
		this.originalFileSize = originalFileSize;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();
	}
	
	private void initializeListsAndMaps()	{ 
		this.listFile = new ArrayList<NodeFile>();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Long containerId;
	private Long fileSetId;
	private Long containerFileId;
	private Long containerFileSetId;
	private String containerType; //recursive, file, directory
	private String extensionType; //zip, rar, 7z
	private String algorithmName; 
	private String containerRemark;
	
	private Long cntFile;
	private Long originalFileSize;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listFile;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getContainerId() {
		return containerId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getContainerFileId() {
		return containerFileId;
	}
	public Long getContainerFileSetId() {
		return containerFileSetId;
	}
	public String getContainerType() {
		return containerType;
	}
	public String getExtensionType() {
		return extensionType;
	}
	public String getAlgorithmName() {
		return algorithmName;
	}
	public String getContainerRemark() {
		return containerRemark;
	}
	public Long getCntFile() {
		return cntFile;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public ArrayList<NodeFile> getListFile() {
		return listFile;
	}

	public Long getOriginalFileSize() {
		return originalFileSize;
	}
	
}
