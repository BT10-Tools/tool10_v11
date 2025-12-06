package tool10.work;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WorkWithNIO {
	
	public static void fileAndPath() {
        
        //java.nio.file.
        
		try {	
	        Path path = Paths.get("C:\\nh\\arabalar\\arabalar.pdf");
	        
	        File fileFromPath = path.toFile();
	        
	        printFileInfo(fileFromPath);
	        //path.
	        Path pathFromFile = fileFromPath.toPath();
	        
	        // java.io API
	        String pathStr = fileFromPath.getPath();
	        String absolutePathStr = fileFromPath.getAbsolutePath();
	        String canonicalPathStr = fileFromPath.getCanonicalPath();
	
	        // java.nio API
	        Path absolutePath = path.toAbsolutePath();
	        Path canonicalPath = path.toRealPath().normalize();
	        
	        URI fileUri = fileFromPath.toURI();
	        URI pathUri = path.toUri();
	        
	        FileStore fs = java.nio.file.Files.getFileStore(pathFromFile); 
	        printFileStoreInfo(fs);	
	          
	        getFileStoreList4Host();
	        System.out.println("pathStr:"+pathStr);
	        System.out.println("absolutePathStr:"+absolutePathStr);
	        System.out.println("canonicalPathStr:"+canonicalPathStr);
	        System.out.println("fileUri:"+fileUri);
		} catch (Exception e)	{
			
		}
	        
	}
	public static void printFileInfo(File file)	{
		try {	
			String pathStr = file.getPath();
		    String absolutePathStr = file.getAbsolutePath();
		    String canonicalPathStr = file.getCanonicalPath();
		    URI fileUri = file.toURI();
		    String canExecute = Boolean.toString(file.canExecute());
		    String canRead = Boolean.toString(file.canRead());
		    String canWrite = Boolean.toString(file.canWrite());
		    String exists = Boolean.toString(file.exists());
		    
		    file.getAbsolutePath();
		    long freeSpace = file.getFreeSpace();
		    long totalSpace = file.getTotalSpace();
		    long usableSpace = file.getUsableSpace();
		    long length = file.length();
		    long hashCode = file.hashCode();
		    String fileName = file.getName(); 
		    String toStringStr = file.toString();
		    String isDirectory = Boolean.toString(file.isDirectory());
		    String isFile = Boolean.toString(file.isFile());
		    String isHidden = Boolean.toString(file.isHidden());
		    long lastModified = file.lastModified();
		    
		    System.out.println("pathStr:"+pathStr);
	        System.out.println("absolutePathStr:"+absolutePathStr);
	        System.out.println("canonicalPathStr:"+canonicalPathStr);
	        System.out.println("fileUri:"+fileUri);
	        System.out.println("canExecute:"+canExecute);
	        System.out.println("canRead:"+canRead);
	        System.out.println("canWrite:"+canWrite);
	        System.out.println("exists:"+exists);
	        System.out.println("freeSpace:"+freeSpace);
	        System.out.println("totalSpace:"+totalSpace);
	        System.out.println("usableSpace:"+usableSpace);
	        System.out.println("length:"+length);
	        System.out.println("hashCode:"+hashCode);
	        System.out.println("fileName:"+fileName);
	        System.out.println("toStringStr:"+toStringStr);
	        System.out.println("isDirectory:"+isDirectory);
	        System.out.println("isFile:"+isFile);
	        System.out.println("isHidden:"+isHidden);
	        System.out.println("lastModified:"+lastModified);
	      
	        Path pathFromFile = file.toPath();
		    URI pathUri = pathFromFile.toUri();
		    
		    
		    System.out.println("//******* PATH *************");
		    System.out.println("pathUri:"+pathUri);
		    
		    FileSystem fileSystem = pathFromFile.getFileSystem();
		    printFileStoreInfo(fileSystem);
	       //System.out.println("FS: ntfsCompression:"+ntfsCompression);
		} catch (Exception e)	{
			
		}
	}
	public static void printFileStoreInfo(FileSystem fileSystem)	{
		//fileSystem.
	}
	public static void printFileStoreInfo(FileStore fs)	{
		try {	
		 	long blockSize = fs.getBlockSize();
	        long totalSpace = fs.getTotalSpace();
	        long unallocatedSpace = fs.getUnallocatedSpace();
	        long usableSpace = fs.getUsableSpace();
	        long usedSpace = (totalSpace - unallocatedSpace);
	        long hashCode = fs.hashCode();
	        boolean isReadOnly = fs.isReadOnly();
	        String nameStr = fs.name();
	        //long blockSize = fs.supportsFileAttributeView(canonicalPathStr); 
	        String toString = fs.toString();
	        String typeStr = fs.type();
	        //long blockSize = fs.getAttribute(toString);
	        //boolean compression = (Boolean)fs.getAttribute("zfs:compression");
	        //boolean ntfsCompression = (Boolean)fs.getAttribute("ntfs:compression");
	      
	        System.out.println("FS: blockSize:"+blockSize);
	        System.out.println("FS: totalSpace:"+totalSpace);
	        System.out.println("FS: unallocatedSpace:"+unallocatedSpace);
	        System.out.println("FS: usableSpace:"+usableSpace);
	        System.out.println("FS: usedSpace:"+usedSpace);
	        System.out.println("FS: hashCode:"+hashCode);
	        System.out.println("FS: isReadOnly:"+isReadOnly);
	        System.out.println("FS: nameStr:"+nameStr);
	        System.out.println("FS: toString:"+toString);
	        System.out.println("FS: typeStr:"+typeStr);
	        //System.out.println("FS: ntfsCompression:"+ntfsCompression);
		} catch (Exception e)	{
			
		}
	}
	
	public static ArrayList<FileStore> getFileStoreList4Host() {
		ArrayList<FileStore> fsList = new ArrayList<FileStore>();
        try {
        	System.out.format("%-20s %12s %12s %12s\n", "Filesystem", "kbytes", "used", "avail");
            // Iterate over all root directories
            for (Path root : FileSystems.getDefault().getRootDirectories()) {
            	FileStore fileStore = Files.getFileStore(root);
                fsList.add(fileStore);
                System.out.println("Root Directory: " + root);
                printFileStoreInfo(fileStore);	
                System.out.println("***");
                //System.out.format("%-20s %12d %12d %12d\n", s, total, used, avail);
            }
        } catch (IOException e) {
            System.err.println("Error accessing file stores: " + e.getMessage());
        }
        return(fsList);
	}
	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");
        
        fileAndPath();
                
	}

}
