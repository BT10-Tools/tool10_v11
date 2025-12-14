package tool10.fileset.nodes;

import java.io.Serializable;
import java.nio.file.FileSystem;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeFileSystem implements Serializable {

	//Java’s Files.getFileStore() method provides a way to retrieve the FileStore associated with a given file or directory. 
	//A FileStore represents a storage pool, device, or partition, and can be used to obtain details about disk space, 
	//type of storage, and other system-specific storage attributes.
	
	public NodeFileSystem(Long fileSystemId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder,
			String systemName, String providerName, Long providerHashCode, String isDefault, String isOpen, String isReadOnly,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileSystemId = fileSystemId;
		this.fileSetId = fileSetId;
		this.hostId = hostId;
		this.rootFileId = rootFileId;
		this.displayOrder = displayOrder;
		this.systemName = systemName;
		this.providerName = providerName;
		this.providerHashCode = providerHashCode;
		this.isDefault = isDefault;
		this.isOpen = isOpen;
		this.isReadOnly = isReadOnly;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listFileStore = new ArrayList<NodeFileStore>();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fileSystemId;
	private Long fileSetId;
	private Long hostId;
	private Long rootFileId;
	private Long displayOrder;
	private String systemName;
	private String providerName;
	private Long providerHashCode;
	private String isDefault;
    private String isOpen;
    private String isReadOnly;
    
    private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private FileSystem realFileSystem;
    
    //fs.supportsFileAttributeView(canonicalPathStr); 
     // fs.getAttribute(toString);
    //boolean compression = (Boolean)fs.getAttribute("zfs:compression");
    //boolean ntfsCompression = (Boolean)fs.getAttribute("ntfs:compression");
	
	private ArrayList<NodeFileStore> listFileStore;

	//GETTERS AND SETTERS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getFileSystemId() {
		return fileSystemId;
	}

	public Long getFileSetId() {
		return fileSetId;
	}

	public Long getHostId() {
		return hostId;
	}

	public Long getRootFileId() {
		return rootFileId;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getProviderName() {
		return providerName;
	}

	public Long getProviderHashCode() {
		return providerHashCode;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public String getIsReadOnly() {
		return isReadOnly;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public FileSystem getRealFileSystem() {
		return realFileSystem;
	}

	public ArrayList<NodeFileStore> getListFileStore() {
		return listFileStore;
	}

	public void setRealFileSystem(FileSystem realFileSystem) {
		this.realFileSystem = realFileSystem;
	}

	public String getIsDefault() {
		return isDefault;
	}

	
	

	
}
