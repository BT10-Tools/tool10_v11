package tool10.work;

import java.io.File;
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
import java.nio.file.attribute.FileStoreAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import tool10.fileset.FileAttribute;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;
import tool10.util.TraverseFiles;

public class WorkFileSetPropertyFile {

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
	private static AclFileAttributeView getAcl(Path path)	{
		try {
			 AclFileAttributeView aclFileAttributes = Files.getFileAttributeView(path, AclFileAttributeView.class);
			   return(aclFileAttributes);	
		} catch (Exception e) {
		}
		return(null);
	}	 
	/*
	public static NodeAcl getNodeAcl4Path(Path path, NodeFs fs,long pathId,java.sql.Connection conSql)	{
		
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
	private static void createOneFileProperties(ArrayList<FileAttribute> fAttrList, NodeFile nodeFile, Path path, File file) {

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
	            
	        DosFileAttributeView attrViewDos = Files.getFileAttributeView(path, DosFileAttributeView.class);
	        DosFileAttributes attrDos = attrViewDos.readAttributes();
	        fAttr = new FileAttribute(nodeFile, idx, "DosFileAttributeView", "isReadOnly",Boolean.toString(attrDos.isReadOnly())); 	fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "DosFileAttributeView", "isHidden",Boolean.toString(attrDos.isHidden())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "DosFileAttributeView", "isArchive",Boolean.toString(attrDos.isArchive())); fAttrList.add(fAttr);
	        fAttr = new FileAttribute(nodeFile, idx, "DosFileAttributeView", "isSystem",Boolean.toString(attrDos.isSystem())); fAttrList.add(fAttr);
		        
	        FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
			UserPrincipal userPrincipal = fileOwnerAttributeView.getOwner();
			fAttr = new FileAttribute(nodeFile, idx, "FileOwnerAttributeView", "userPrincipal.getname",userPrincipal.getName()); fAttrList.add(fAttr);
			fAttr = new FileAttribute(nodeFile, idx, "FileOwnerAttributeView", "userPrincipal.tostring",userPrincipal.toString()); fAttrList.add(fAttr);
			
	/*		UserDefinedFileAttributeView userDefinedFileAttributeView  = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
			List<String> listView = userDefinedFileAttributeView.list();
			userDefinedFileAttributeView.
			
			with the name "user.mimetype". {@snippet lang=java : 
		    UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class); 
			String name = "user.mimetype"; 
			ByteBuffer buf = ByteBuffer.allocate(view.size(name)); 
			view.read(name, buf); 
			buf.flip(); 
			String value = Charset.defaultCharset().decode(buf).toString();
			
			} 
			NodeAcl nodeAcl = FileRights.getNodeAcl4Path(path,fs,pathId,conSql);
			pp.setNodeAcl(nodeAcl);
	*/		
	        Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
	        fAttr = new FileAttribute(nodeFile, idx, "PosixFilePermission", "permissions",permissions.toString()); fAttrList.add(fAttr);
	        
	        for (PosixFilePermission pfp : permissions)	{
	        	//System.out.println("permissions = " + permissions);
	        }
	        
	        
	    } catch (UnsupportedOperationException e) {
		} catch (Exception e)	{
			
		}
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
    private static void createAllFileProperties() {
    	
    	
    	 
    	//public static void traverseFiles(ArrayList<String> filenameList,String[] extArray, File folder) {
    	String rootDirName = "C:\\appdata\\ytdlp"; 
    	Path path = Paths.get(rootDirName); //"C:\\nh\\03_Downloaded"
    	File dir = path.toFile();
 	   if ((dir==null)|| (!dir.exists())) return;
 	   
 	   //processFileStore(path);
 	   
 	    ArrayList<String> fileNameList = new ArrayList<String>();
		String[] extArray = new String[] {"pdf"}; 
		TraverseFiles.traverseFiles(fileNameList, extArray,dir);
		ArrayList<FileAttribute> fAttrList = new ArrayList<FileAttribute>();
		
		for (String fileName : fileNameList)	{
			System.out.println("createAllFileProperties processing "+fileName);
			Path filePath = Paths.get(fileName);
			if (filePath==null) continue;
			File processFile = filePath.toFile();
			if ((processFile==null) || (!processFile.exists())) continue;
			
			createOneFileProperties(fAttrList, null, filePath, processFile);
		}
		
    }		    
	
	public static void main(String[] args) {
		createAllFileProperties();
	}
}
