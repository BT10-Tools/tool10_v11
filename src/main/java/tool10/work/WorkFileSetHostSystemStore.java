package tool10.work;

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

import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHost;
import tool10.sql.Conn10;

public class WorkFileSetHostSystemStore {

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
	private static NodeHost createOneHost(Conn10 conn10, NodeFileSet fileSet, String hostName, String hostIP, String domainName)	{
		NodeHost newHost = null;
		//public NodeHost(Long hostId, Long fileSetId, String hostName, String hostIP, String domainName,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long hostId = conn10.getNextId(-1); //"BSC_BASIC");;
			//String hostName, String hostIP, String domainName,
			
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null;
			
			newHost = new NodeHost(hostId, fileSet.getFileSetId(), hostName, hostIP, domainName,
					creationDate, modificationDate);
	        fileSet.getListHost().add(newHost);
			fileSet.getMapId2Host().put(newHost.getHostId(),newHost);
		} catch (Exception e)	{
			
		}
		return(newHost);
	}
	private static NodeHost createLocalHost(Conn10 conn10, NodeFileSet fileSet)	{
		NodeHost newHost = null;
		try {
			String hostName = getLocalHostName(); 
			String hostNameCanonical = getLocalHostCanonicalName(); 
			String hostIP = getLocalHostIPAddress(); 
			String domainName = null;
			newHost = createOneHost(conn10, fileSet, hostName, hostIP, domainName);
		} catch (Exception e)	{
			
		}
		return(newHost);
	}
	//****************************
	private static ArrayList<NodeFileStore> getFileStoreList4Host()	{
		ArrayList<NodeFileStore> listFileStore = new ArrayList<NodeFileStore>();
		
		try {
			 FileSystem fileSystem = FileSystems.getDefault();

			 //FileSystems.;
			 //fileSystem.;
			 // Display messages only
	         System.out.println("getFileStoreList4Host: fileSystem.toString()="+fileSystem.toString());
			 System.out.println("getFileStoreList4Host: fileSystem.isOpen()="+fileSystem.isOpen());
			 System.out.println("getFileStoreList4Host: fileSystem.isReadOnly()="+fileSystem.isReadOnly());
			 System.out.println("getFileStoreList4Host: fileSystem.provider().getScheme()="+fileSystem.provider().getScheme());
			 System.out.println("getFileStoreList4Host: fileSystem.provider().hashCode()="+fileSystem.provider().hashCode());
			 System.out.println("getFileStoreList4Host: fileSystem.provider().toString()="+fileSystem.provider().toString());
			 System.out.println("getFileStoreList4Host: fileSystem.provider().toString()="+fileSystem.provider().toString());
			 
	         System.out.println("Underlying file stores of this FileSystem :");
	
	         // Print the Underlying file stores of this
	         // FileSystem using for each loop
	         for (FileStore store : fileSystem.getFileStores()) {
	             System.out.println(store.toString());
	             
	             //store.
	         }
	
	         // Display message only
	         System.out.println("Root directories of this FileSystem :");
	
	         for (Path rootdir : fileSystem.getRootDirectories()) {
	
	             // Print the Root directories of this
	             // FileSystem using standard toString()
	             // method
	             System.out.println(rootdir.toString());
	         }
		} catch (Exception e)	{
			
		}
		return(listFileStore);
	}
	private static ArrayList<NodeFileSystem> getFileSystemList4Host()	{
		ArrayList<NodeFileSystem> listFileSystem = new ArrayList<NodeFileSystem>();
		try {
			FileSystem fileSystem = FileSystems.getDefault();
			//NodeFileSystem createOneFileSystem(Conn10 conn10, NodeFileSet fileSet, FileSystem fileSystem, long hostId)
		} catch (Exception e)	{
			
		}
		return(listFileSystem);
	}
	private static void getFileSystemAndFileStores()	 { 
		NodeFileSet fileSet = null;
		
		ArrayList<NodeFileStore> 	listFileStore 	= getFileStoreList4Host();
		ArrayList<NodeFileSystem> 	listFileSystem 	= getFileSystemList4Host();
				
	}
	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");
        
        //getFileSystemAndFileStores();
        
        System.out.println("----Selamun Aleyküm");
       
        
	}    
	
}
