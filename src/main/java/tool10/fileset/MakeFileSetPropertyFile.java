package tool10.fileset;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import tool10.sql.Conn10;

public class MakeFileSetPropertyFile {

	private static Set<String> getSupportedFileAttributes(FileStore fs) {
		    Set<String> attrs = new HashSet<String>();
		    if (fs.supportsFileAttributeView(AclFileAttributeView.class)) 			{attrs.add("acl");  }
		    if (fs.supportsFileAttributeView(BasicFileAttributeView.class)) 		{attrs.add("basic");}
		    if (fs.supportsFileAttributeView(FileOwnerAttributeView.class)) 		{attrs.add("owner");}
		    if (fs.supportsFileAttributeView(UserDefinedFileAttributeView.class)) 	{attrs.add("user"); }
		    if (fs.supportsFileAttributeView(DosFileAttributeView.class)) 			{attrs.add("dos");  }
		    if (fs.supportsFileAttributeView(PosixFileAttributeView.class)) 		{attrs.add("posix");}
		    if (fs.supportsFileAttributeView(FileAttributeView.class)) 				{attrs.add("file"); }
		    return attrs;
	}
	private static Set<String> getFileStoreSupportedFileAttributes(Path path)	{
		Set<String> attrSet = null; 
		try {
			FileStore fileStore = Files.getFileStore(path);
		 	attrSet = getSupportedFileAttributes(fileStore); 
		 	for (String attr : attrSet)	{System.out.println("supports: "+attr);}
		} catch (Exception e)	{
		}
		return(attrSet);
	}
	private static AclFileAttributeView getAcl(Path path)	{
		try {
			 AclFileAttributeView aclFileAttributes = Files.getFileAttributeView(path, AclFileAttributeView.class);
			   return(aclFileAttributes);	
		} catch (Exception e) {
		}
		return(null);
	}	 
/*	public static NodeAcl getNodeAcl4Path(Path path, NodeFs fs,long pathId,java.sql.Connection conSql)	{
		
		NodeAcl nodeAcl = null;
			
		try {
			 AclFileAttributeView aclFileAttributes = Files.getFileAttributeView(path, AclFileAttributeView.class);
			 long nodeAclId = NewId.getNewId(fs.getIdQueue(),conSql);
			 String ownerName = aclFileAttributes.getOwner().getName();
			 long ownerHashCode = aclFileAttributes.getOwner().hashCode(); 
			 long hashCode = aclFileAttributes.hashCode();
			 nodeAcl = new NodeAcl(nodeAclId,pathId,ownerName, ownerHashCode,hashCode);
			 
			 for (AclEntry aclEntry : aclFileAttributes.getAcl()) {
				 long nodeAclEntryId = NewId.getNewId(fs.getIdQueue(),conSql);
				 String entryType = aclEntry.type().toString();
				 long entryTypeHashCode = aclEntry.type().hashCode();
				 long principalHashCode = aclEntry.principal().hashCode();
				 String principalName = aclEntry.principal().getName();
				 
				 NodeAclEntry nodeAclEntry = new NodeAclEntry(nodeAclEntryId,nodeAcl, entryType, entryTypeHashCode,principalHashCode,principalName);
				   
				 for(AclEntryPermission perm : aclEntry.permissions()){
					 nodeAclEntry.getListPerm().add(perm.toString()); 
					 nodeAclEntry.getListOrdinal().add(perm.ordinal());
					 nodeAclEntry.getListHashCode().add(perm.hashCode());
				   
					 nodeAclEntry.setAllPerm(nodeAclEntry.getAllPerm() + perm.toString()+ ",");
					 nodeAclEntry.setAllOrdinal(nodeAclEntry.getAllOrdinal() + perm.ordinal() + ",");
					 nodeAclEntry.setAllHashCode(nodeAclEntry.getAllHashCode() + perm.hashCode() + ",");
					 //System.out.print(perm.hashCode()+",");
					 // System.out.print(perm.ordinal()+",");
				 }
				 nodeAcl.getListAclEntry().add(nodeAclEntry);
			 }		
			 //return(aclFileAttributes);
			 return(nodeAcl);  
		} catch (Exception e) {
		}
		return(nodeAcl);
	}	  
*/	
	private static void createOneFileProperties(Conn10 conn10, ArrayList<FileAttribute> fAttrList, NodeFile nodeFile, Path path, File file) {

		//public FileAttribute(NodeFileSet fileSet, int idx, String attrGroup, String attrName, String attrValue) {
		
		int idx = 0;
		FileAttribute fAttr;
		try {
	        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "creationTime",attr.creationTime().toString()); 	fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "lastAccessTime",attr.lastAccessTime().toString()); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "lastModifiedTime",attr.lastModifiedTime().toString()); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "size",Long.toString(attr.size())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "isRegularFile",Boolean.toString(attr.isRegularFile())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "isDirectory",Boolean.toString(attr.isDirectory())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "isOther",Boolean.toString(attr.isOther())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "isSymbolicLink",Boolean.toString(attr.isSymbolicLink())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "BasicFileAttributes", "toString",attr.toString()); fAttrList.add(fAttr);
	        
	        FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
			UserPrincipal userPrincipal = fileOwnerAttributeView.getOwner();
			fAttr = new FileAttribute(nodeFile, idx, "FileOwnerAttributeView", "userPrincipal.getname",userPrincipal.getName()); fAttrList.add(fAttr);
			fAttr = new FileAttribute(nodeFile, idx, "FileOwnerAttributeView", "userPrincipal.tostring",userPrincipal.toString()); fAttrList.add(fAttr);
	        
	    } catch (UnsupportedOperationException e) {
		} catch (Exception e)	{
			
		}
    }
    private static void createAllFileProperties(Conn10 conn10, NodeFileSet fileSet) {
    	ArrayList<FileAttribute> fAttrList = new ArrayList<FileAttribute>(); 
        for (NodeFile nodeFile : fileSet.getListFile())		{
        	Path path = Paths.get(nodeFile.getFileNameAbsolute()); //"C:\\nh\\03_Downloaded"
        	File fileFromPath = path.toFile();
    	    if ((fileFromPath==null)|| (!fileFromPath.exists())) continue;
    	    
    	    createOneFileProperties(conn10,fAttrList, nodeFile, path, fileFromPath);
        }	
    }	
    public static HashMap<String,String> getFileAttributeMap(Path path) {
    	//dos.isReadOnly,dos.isHidden,dos.isArchive,dos.isSystem,dos.isRegularFile,dos.isSymbolicLink,dos.isOther
    	HashMap<String,String> attrMap = new HashMap<String,String>();
    	try {
	    	DosFileAttributeView attrViewDos = Files.getFileAttributeView(path, DosFileAttributeView.class);
	    	DosFileAttributes attrDos = attrViewDos.readAttributes();
	    	attrMap.put("dos.isReadOnly",Boolean.toString(attrDos.isReadOnly()));
	    	attrMap.put("dos.isHidden",Boolean.toString(attrDos.isHidden())); 
	    	attrMap.put("dos.isArchive",Boolean.toString(attrDos.isArchive())); 
	    	attrMap.put("dos.isSystem",Boolean.toString(attrDos.isSystem()));
	    	attrMap.put("dos.isRegularFile",Boolean.toString(attrDos.isRegularFile()));
	    	attrMap.put("dos.isSymbolicLink",Boolean.toString(attrDos.isSymbolicLink()));
	    	attrMap.put("dos.isOther",Boolean.toString(attrDos.isOther()));
    	} catch(IOException e)	{
    		
    	}
    	return(attrMap);
    	
    }
    public static HashMap<String,String> getFileAttributeMap(File file) {
    	//dos.isReadOnly,dos.isHidden,dos.isArchive,dos.isSystem,dos.isRegularFile,dos.isSymbolicLink,dos.isOther
    	HashMap<String,String> attrMap = new HashMap<String,String>();
    	try {
	    	attrMap.put("file.canExecute",Boolean.toString(file.canExecute()));
	    	attrMap.put("file.canRead",Boolean.toString(file.canRead()));
	    	attrMap.put("file.canWrite",Boolean.toString(file.canWrite()));
	    	attrMap.put("file.isExists",Boolean.toString(file.exists()));
	    	attrMap.put("file.isHidden",Boolean.toString(file.isHidden()));
	    	attrMap.put("file.isDirectory",Boolean.toString(file.isDirectory()));
	    	attrMap.put("file.isFile",Boolean.toString(file.isFile()));
	    	attrMap.put("file.isAbsolute",Boolean.toString(file.isAbsolute()));
		    	
	    	
    	} catch(Exception e)	{
    		
    	}
    	return(attrMap);
    	
    }
	public static void makePropertyFile(Conn10 conn10, NodeFileSet fileSet, Long hostId)	{
		createAllFileProperties(conn10, fileSet);
	}
}
