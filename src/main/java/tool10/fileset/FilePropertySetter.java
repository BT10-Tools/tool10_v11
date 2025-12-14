package tool10.fileset;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.TimeUtil;

public class FilePropertySetter {
	
	private static void setOwner(Path path, String ownerStr)	{
		try {
			FileSystem fileSystem = path.getFileSystem();
		    UserPrincipalLookupService service = fileSystem.getUserPrincipalLookupService();
		    UserPrincipal userPrincipal = service.lookupPrincipalByName(ownerStr);
		    System.out.println("Found UserPrincipal: " + userPrincipal);

		    //changing owner
		    Files.setOwner(path, userPrincipal);
		} catch (Exception e)	{
			
		}
	}
	public static void setFileProperties(NodeFileSet fileSet, NodeFile nodeFile, String fileName)	{
		//lastModifiedTime,isHidden, readOnly, executable, readable, wr,table, owner 
		try {
			
			Path path = Paths.get(fileName);
			File file = path.toFile();
			if (!file.exists()) return;
		
			if (nodeFile.getFileCreationDate()!=null) {
				Files.setAttribute(path, "creationTime", TimeUtil.ZDT2FileTime(nodeFile.getFileCreationDate()));
			}
			if (nodeFile.getFileCreationDate()!=null) {
				Files.setAttribute(path, "creationTime", TimeUtil.ZDT2FileTime(nodeFile.getFileCreationDate()));
			}
			if (nodeFile.getFileModificationDate()!=null) {
				Files.setLastModifiedTime(path, TimeUtil.ZDT2FileTime(nodeFile.getFileModificationDate()));
			}
			
			if ("true".equals(nodeFile.getIsHidden())) {
				Files.setAttribute(path, "dos:hidden", true);
			}
			if ("true".equals(nodeFile.getIsReadOnly())) {
				boolean success = file.setReadOnly();
			}
			if      ("true".equals(nodeFile.getCanExecute())) { boolean success = file.setExecutable(true); }
			else if ("false".equals(nodeFile.getCanExecute())) { boolean success = file.setExecutable(false); }
			if      ("true".equals(nodeFile.getCanRead())) { boolean success = file.setReadable(true); }
			else if ("false".equals(nodeFile.getCanRead())) { boolean success = file.setReadable(false); }
			if      ("true".equals(nodeFile.getCanWrite())) { boolean success = file.setWritable(true); }
			else if ("false".equals(nodeFile.getCanWrite())) { boolean success = file.setWritable(false); }
			
			if (nodeFile.getOwnerName()!=null)	{ setOwner(path, nodeFile.getOwnerName()); }
			    
			
		} catch (Exception e)	{
			
		}
	}
}
