package tool10.tagset;

import java.util.HashMap;

public class TaggerTikaTag {


	public static void getTikaTags(NodeTaggerTikaTag tikaTag,String fileName)	{
		HashMap<String,String> mapMetadata = TikaUtil.getMapMetadata(fileName);
		tikaTag.setMapAttribute(mapMetadata);
		try {
			
		/*	
		    // setting the path
			Path path = FileSystems.getDefault().getPath(fileName);
			
			
			BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
			BasicFileAttributes attribute = view.readAttributes();
			
			if (Files.isReadable(path)) {winFileTag.setIsReadable("yes"); winFileTag.getMapAttribute().put("isReadable", "yes");}
			if (Files.isWritable(path)) {winFileTag.setIsWritable("yes"); winFileTag.getMapAttribute().put("isWritable", "yes");}
			if (Files.isExecutable(path)) {winFileTag.setIsExecutable("yes"); winFileTag.getMapAttribute().put("isExecutable", "yes");}
			
			winFileTag.setCreationTime(TimeUtil.FileTime2ZDT(attribute.creationTime())); 			winFileTag.getMapAttribute().put("creationTime", winFileTag.getCreationTime().toString());
			winFileTag.setLastAccessTime(TimeUtil.FileTime2ZDT(attribute.lastAccessTime()));			winFileTag.getMapAttribute().put("lastAccessTime", winFileTag.getLastAccessTime().toString());
			winFileTag.setLastModifiedTime(TimeUtil.FileTime2ZDT(attribute.lastModifiedTime()));		winFileTag.getMapAttribute().put("lastModifiedTime", winFileTag.getLastModifiedTime().toString());
			
			winFileTag.setFileSize(attribute.size());
			
			if (attribute.isRegularFile()) 	{ winFileTag.setIsRegularFile("yes");	winFileTag.getMapAttribute().put("isRegularFile", "yes");}
			if (attribute.isDirectory()) 	{ winFileTag.setIsDirectory("yes");		winFileTag.getMapAttribute().put("isDirectory", "yes");}
			if (attribute.isSymbolicLink()) { winFileTag.setIsLink("yes");			winFileTag.getMapAttribute().put("isSymbolicLink", "yes");}
			if (attribute.isOther()) 		{ winFileTag.setIsOther("yes");			winFileTag.getMapAttribute().put("isOther", "yes");}
			
			 System.out.println("getWinFileTags: winFileTag.getMapAttribute().size() = " + winFileTag.getMapAttribute().size());
		*/	 
			//diğerleri de gelecek 
		} catch (Exception e)	{
			
		}
	}
}
