package tool10.fileset;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHost;
import tool10.sql.Conn10;

public class MakeFileSetHost {

	/**
     * This method to return the local host IP address
     * @return the IP address
     */
    public static String getLocalHostIPAddress() {
        String localhostIP = null;
        try {
            localhostIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return localhostIP;
    }
	/**
     * This method to get the local host name.
     * @return the local host name.
     */
    public static String getLocalHostName() {
        String localhostMName = null;
        try {
            localhostMName = InetAddress.getLocalHost().getHostName();
            //localhostMName = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localhostMName;
    }
	/**
     * This method to get the local host name.
     * @return the local host name.
     */
    public static String getLocalHostCanonicalName() {
        String localhostCanonicalName = null;
        try {
            localhostCanonicalName = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return localhostCanonicalName;
    }
	private static NodeHost createOneHost(NodeF10 f10, String hostName, String hostIP, String domainName)	{
		NodeHost newHost = null;
		//public NodeHost(Long hostId, Long fileSetId, String hostName, String hostIP, String domainName,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long hostId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			//String hostName, String hostIP, String domainName,
			
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null;
			
			newHost = new NodeHost(hostId, f10.getFileSet().getFileSetId(), hostName, hostIP, domainName,
					creationDate, modificationDate);
			f10.getFileSet().getListHost().add(newHost);
			f10.getFileSet().getMapId2Host().put(newHost.getHostId(),newHost);
		} catch (Exception e)	{
			
		}
		return(newHost);
	}
	private static NodeHost createLocalHost(NodeF10 f10)	{
		NodeHost newHost = null;
		try {
			String hostName = getLocalHostName(); 
			String hostNameCanonical = getLocalHostCanonicalName(); 
			String hostIP = getLocalHostIPAddress(); 
			String domainName = null;
			newHost = createOneHost(f10, hostName, hostIP, domainName);
		} catch (Exception e)	{
			
		}
		return(newHost);
	}
	//****************************
	public static NodeFileSystem createOneFileSystem(NodeF10 f10, FileSystem fileSystem, long hostId)	{
		NodeFileSystem newFileSystem = null;
		if (fileSystem==null) return(null);
		
		//public NodeFileSystem(Long fileSystemId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder,
		//String systemName, String providerName, Long providerHashCode, String isDefault, String isOpen, String isReadOnly,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long fileSystemId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			Long rootFileId = null; 
			Long displayOrder = null;
			String systemName = fileSystem.toString();
			String providerName = fileSystem.provider().toString();
			Long providerHashCode = (long) fileSystem.provider().hashCode();
			String isDefault = null;
			String isOpen = Boolean.toString(fileSystem.isOpen());
			String isReadOnly = Boolean.toString(fileSystem.isReadOnly());

			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null;
			
			newFileSystem = new NodeFileSystem(fileSystemId, f10.getFileSet().getFileSetId(), hostId, rootFileId, displayOrder, 
					systemName, providerName, providerHashCode, isDefault, isOpen, isReadOnly, creationDate, modificationDate);
			f10.getFileSet().getListFileSystem().add(newFileSystem);
			f10.getFileSet().getMapId2FileSystem().put(newFileSystem.getFileSystemId(),newFileSystem);
			f10.getFileSet().getMapRawFileSystem2FileSystem().put(fileSystem, newFileSystem);
		} catch (Exception e)	{
			
		}
		return(newFileSystem);
	}
	private static void createFileSystems(NodeF10 f10, Long hostId)	{
		try {
			FileSystem fileSystem = FileSystems.getDefault();
			NodeFileSystem newFileSystem = createOneFileSystem(f10, fileSystem, hostId);
		} catch (Exception e)	{
			
		}
	}
	//****************************
	private static NodeFileStore createOneFileStore(NodeF10 f10, File file, Long hostId)	{
		NodeFileStore newFileStore = null;
		
		//public NodeFs(Long fsId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder, Long blockSize,
		//		Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
		//		String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			if ((file==null) || (!file.exists())) {return(null);}
			Path pathFromFile = file.toPath();
			FileStore fs = java.nio.file.Files.getFileStore(pathFromFile);
		} catch (Exception e)	{
		}
		return(newFileStore);
	}		
	public static NodeFileStore createOneFileStore(NodeF10 f10, FileStore fileStore, Long fileSystemId)	{
		NodeFileStore newFileStore = null;
		if (fileStore==null) return(null);
		
		//public NodeFileStore(Long fileStoreId, Long fileSetId, Long fileSystemId, Long rootFileId, Long displayOrder, Long blockSize,
		//		Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
		//		String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long fileStoreId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
		 	Long blockSize = fileStore.getBlockSize();
	        Long totalSpace = fileStore.getTotalSpace();
	        Long unallocatedSpace = fileStore.getUnallocatedSpace();
	        Long usableSpace = fileStore.getUsableSpace();
	        Long usedSpace = (totalSpace - unallocatedSpace);
	        Long hashCode = (long) fileStore.hashCode();
	        String isReadOnly = Boolean.toString(fileStore.isReadOnly());
	        String nameStr = fileStore.name();
	        //long blockSize = fs.supportsFileAttributeView(canonicalPathStr); 
	        String toString = fileStore.toString();
	        String typeStr = fileStore.type();
	        //long blockSize = fs.getAttribute(toString);
	        //boolean compression = (Boolean)fs.getAttribute("zfs:compression");
	        //boolean ntfsCompression = (Boolean)fs.getAttribute("ntfs:compression");
	        
	        Long rootFileId = null; 
	        Long displayOrder = null; 
			String rootDirectoryName = null; 
			
			ZonedDateTime creationDate = ZonedDateTime.now();;
			ZonedDateTime modificationDate = null;
			
	        newFileStore = new NodeFileStore(fileStoreId, f10.getFileSet().getFileSetId(), fileSystemId, rootFileId, displayOrder, blockSize,
					totalSpace, unallocatedSpace, usableSpace, usedSpace, hashCode,rootDirectoryName, isReadOnly, nameStr, toString, typeStr,
					creationDate, modificationDate);
	        f10.getFileSet().getListFileStore().add(newFileStore);
	        f10.getFileSet().getMapId2FileStore().put(newFileStore.getFileStoreId(),newFileStore);
	        f10.getFileSet().getMapRawFileStore2FileStore().put(fileStore, newFileStore);
		} catch (Exception e)	{
			
		}
		return(newFileStore);
	}
	private static void createFileStores(NodeF10 f10, Long hostId)	{
		try {
			for (FileSystem rawFileSystem : f10.getFileSet().getMapRawFileSystem2FileSystem().keySet())	{
				NodeFileSystem fileSystem = f10.getFileSet().getMapRawFileSystem2FileSystem().get(rawFileSystem);
				for (FileStore rawFileStore : rawFileSystem.getFileStores()) {
		             System.out.println(rawFileStore.toString());
		             NodeFileStore fileStore = createOneFileStore(f10, rawFileStore, fileSystem.getFileSystemId());
		         }
			}
		} catch (Exception e)	{
		}
	}
	public static void makeFileSystemHost(NodeF10 f10)	{
		Long hostId = null;  
		if ("yes".equals(f10.getCliParams().getHost())) 		{	
			NodeHost host = createLocalHost(f10);		
			hostId = (host==null) ? null : host.getHostId(); 
		}
		if ("yes".equals(f10.getCliParams().getFileSystem())) 	{	
			createFileSystems(f10, hostId);	
		}	
		if ("yes".equals(f10.getCliParams().getFileStore())) 	{ 	
			createFileStores(f10, hostId);	
		}
	}
		
}
