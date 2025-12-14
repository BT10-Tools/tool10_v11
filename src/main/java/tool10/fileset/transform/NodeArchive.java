package tool10.fileset.transform;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.fileset.nodes.NodeFile;

public class NodeArchive implements Serializable {

	public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
			String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
			Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
			Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
			ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.archiveId = archiveId;
		this.fileSetId = fileSetId;
		this.archiveFileId = archiveFileId;
		this.archiveFileSetId = archiveFileSetId;
		this.archiveType = archiveType;
		this.extensionType = extensionType;
		this.algorithmName = algorithmName;
		this.multipleFileArchive = multipleFileArchive;
		this.archiveRemark = archiveRemark;
		this.cntFile = cntFile;
		this.cntArchive = cntArchive;
		this.cntDirectory = cntDirectory;
		this.cntFileTree = cntFileTree;
		this.cntDirectoryTree = cntDirectoryTree;
		this.originalFileSize = originalFileSize;
		this.unzippedFileSize = unzippedFileSize;
		this.unzipGainRatio = unzipGainRatio;
		this.unzippedGainBytes = unzippedGainBytes;
		this.archiveCreationDate = archiveCreationDate;
		this.archiveModificationDate = archiveModificationDate;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();
	}
	public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, 
			String extensionType, Long originalFileSize, ZonedDateTime creationDate) {
		super();
		this.archiveId = archiveId;
		this.fileSetId = fileSetId;
		this.archiveFileId = archiveFileId;
		this.archiveFileSetId = archiveFileSetId;
		this.extensionType = extensionType;
		this.originalFileSize = originalFileSize;
		this.creationDate = creationDate;
		initializeListsAndMaps();
	}
	private void initializeListsAndMaps()	{ 
		this.listFile = new ArrayList<NodeFile>();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Long archiveId;
	private Long fileSetId;
	private Long archiveFileId;
	private Long archiveFileSetId;
	private String archiveType; //recursive, file, directory
	private String extensionType; //zip, rar, 7z
	private String algorithmName; 
	private String multipleFileArchive; 
	private String archiveRemark;
	
	private Long cntFile;
	private Long cntArchive;
	private Long cntDirectory;
	private Long cntFileTree;
	private Long cntDirectoryTree;
	private Long originalFileSize;
	private Long unzippedFileSize;
	private Double unzipGainRatio; 
	private Long unzippedGainBytes;  
    
	private ZonedDateTime archiveCreationDate;
	private ZonedDateTime archiveModificationDate;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listFile;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getArchiveId() {
		return archiveId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getArchiveFileId() {
		return archiveFileId;
	}
	public Long getArchiveFileSetId() {
		return archiveFileSetId;
	}
	public String getArchiveType() {
		return archiveType;
	}
	public String getExtensionType() {
		return extensionType;
	}
	public String getAlgorithmName() {
		return algorithmName;
	}
	public String getMultipleFileArchive() {
		return multipleFileArchive;
	}
	public String getArchiveRemark() {
		return archiveRemark;
	}
	public Long getCntFile() {
		return cntFile;
	}
	public Long getCntArchive() {
		return cntArchive;
	}
	public Long getCntDirectory() {
		return cntDirectory;
	}
	public Long getCntFileTree() {
		return cntFileTree;
	}
	public Long getCntDirectoryTree() {
		return cntDirectoryTree;
	}
	public Long getOriginalFileSize() {
		return originalFileSize;
	}
	public Long getUnzippedFileSize() {
		return unzippedFileSize;
	}
	public Double getUnzipGainRatio() {
		return unzipGainRatio;
	}
	public Long getUnzippedGainBytes() {
		return unzippedGainBytes;
	}
	public ZonedDateTime getArchiveCreationDate() {
		return archiveCreationDate;
	}
	public ZonedDateTime getArchiveModificationDate() {
		return archiveModificationDate;
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

}
