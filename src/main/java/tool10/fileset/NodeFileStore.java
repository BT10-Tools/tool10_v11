package tool10.fileset;

import java.io.Serializable;
import java.nio.file.FileStore;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeFileStore implements Serializable {

	//Java’s Files.getFileStore() method provides a way to retrieve the FileStore associated with a given file or directory. 
	//A FileStore represents a storage pool, device, or partition, and can be used to obtain details about disk space, 
	//type of storage, and other system-specific storage attributes.
	
	public NodeFileStore(Long fileStoreId, Long fileSetId, Long fileSystemId, Long rootFileId, Long displayOrder, Long blockSize,
			Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
			String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileStoreId = fileStoreId;
		this.fileSetId = fileSetId;
		this.fileSystemId = fileSystemId;
		this.rootFileId = rootFileId;
		this.displayOrder = displayOrder;
		this.blockSize = blockSize;
		this.totalSpace = totalSpace;
		this.unallocatedSpace = unallocatedSpace;
		this.usableSpace = usableSpace;
		this.usedSpace = usedSpace;
		this.hashCode = hashCode;
		this.rootDirectoryName = rootDirectoryName;
		this.isReadOnly = isReadOnly;
		this.nameStr = nameStr;
		this.toString = toString;
		this.typeStr = typeStr;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listFile = new ArrayList<NodeFile>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fileStoreId;
	private Long fileSetId;
	private Long fileSystemId;
	private Long rootFileId;
	private Long displayOrder;
	private Long blockSize;
	private Long totalSpace;
	private Long unallocatedSpace;
	private Long usableSpace;
	private Long usedSpace; //usedSpace = (totalSpace - unallocatedSpace);
	private Long hashCode;
	private String rootDirectoryName;
    private String isReadOnly;
    private String nameStr;  
    private String toString; 
    private String typeStr;
    private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
    
	private FileStore fileStore;
	
    //fs.supportsFileAttributeView(canonicalPathStr); 
     // fs.getAttribute(toString);
    //boolean compression = (Boolean)fs.getAttribute("zfs:compression");
    //boolean ntfsCompression = (Boolean)fs.getAttribute("ntfs:compression");
	
	private ArrayList<NodeFile> listFile;

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

	public Long getFileStoreId() {
		return fileStoreId;
	}

	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getRootFileId() {
		return rootFileId;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public Long getBlockSize() {
		return blockSize;
	}
	public Long getTotalSpace() {
		return totalSpace;
	}

	public Long getUnallocatedSpace() {
		return unallocatedSpace;
	}

	public Long getUsableSpace() {
		return usableSpace;
	}

	public Long getUsedSpace() {
		return usedSpace;
	}

	public Long getHashCode() {
		return hashCode;
	}

	public String getRootDirectoryName() {
		return rootDirectoryName;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public String getNameStr() {
		return nameStr;
	}

	public String getToString() {
		return toString;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public ArrayList<NodeFile> getListFile() {
		return listFile;
	}

	public Long getFileSystemId() {
		return fileSystemId;
	}

		


	
}
