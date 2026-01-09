package tool10.fileset;

import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;

public class MakeFileSet {

	public static NodeFileSet createOneFileSet(Conn10 conn10,String fileSetName, String fileSetURL,  Long sourceId)	{
		NodeFileSet fileSet = null;
		Long fileSetId = conn10.getNextId(-1); //"BSC_BASIC");
		
		String fileSetDesc = fileSetName+"_Desc";
		String ownerName = null;
		Long displayOrder = 1l;
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeFileSet(Long fileSetId, Long sourceId, String fileSetName, String fileSetDesc, String fileSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		fileSet = new NodeFileSet(fileSetId, sourceId, fileSetName, fileSetDesc, fileSetURL, ownerName, displayOrder, creationDate, null);
		
		return(fileSet);
	}	
	public static NodeFileSet makeFileSet(NodeF10 f10)	{
		NodeFileSet fileSet = null;
		
		//String rootFileName = "C:\\app\\sqlite\\ImageDatasets\\IMFDB_final";
		String rootDirName1 = f10.getCliParams().getDir(); // "C:\\nh\\01_DOC20241204_Silk\\02_Kopyalar"; //C:\nh\01_DOC20241204_Silk\02_Kopyalar
		System.out.println("MakeFileSet makeFileSet rootDirName:"+rootDirName1);
		String rootFileName1 = f10.getCliParams().getFile(); // "C:\\nh\\01_DOC20241204_Silk\\02_Kopyalar"; //C:\nh\01_DOC20241204_Silk\02_Kopyalar
		System.out.println("MakeFileSet makeFileSet rootFileName:"+rootFileName1);
		
		String fileSetName = f10.getCliParams().getFileSetName(); 
		if ((fileSetName==null) || (fileSetName.isEmpty())) { fileSetName = "fileSet01";}  
		String fileSetURL = "fileSetURL01";  
		
		int sizeDir = (f10.getCliParams().getDir()==null)  ? 0 : 1;
		int sizeFile = (f10.getCliParams().getFile()==null) ? 0 : 1;
		int sizeDirArray  = (f10.getCliParams().getDirArray()==null)  ? 0 : f10.getCliParams().getDirArray().length;
		int sizeFileArray = (f10.getCliParams().getFileArray()==null) ? 0 : f10.getCliParams().getFileArray().length;
		
		String[] rootDirectoryNameArray = new String[sizeDir  + sizeDirArray]; 
		String[] rootFileNameArray  	= new String[sizeFile + sizeFileArray];
		int i=0;
		int j=0;
		for (i=0; i<sizeDirArray;  i++) {rootDirectoryNameArray [i] = f10.getCliParams().getDirArray()[i];}
		for (j=0; j<sizeFileArray; j++) {rootFileNameArray      [j] = f10.getCliParams().getFileArray()[j];}
		if (sizeDir>0)  { rootDirectoryNameArray [i] = f10.getCliParams().getDir();}
		if (sizeFile>0) { rootDirectoryNameArray [j] = f10.getCliParams().getFile();}
		
		//String rootFileName = "C:\\nh\\03_Downloaded";
		Long sourceId = null;
		fileSet = createOneFileSet(f10.getConn10(),fileSetName, fileSetURL, sourceId);
		if (fileSet==null)	{
			System.out.println("MakeFileSet makeFileSet fileSet is null");
			return(null);
		}
		f10.setFileSet(fileSet);
		
		MakeFileSetHost.makeFileSystemHost(f10); //f10.getConn10()); //, fileSet,	f10.getCliParams().getHost(), f10.getCliParams().getFileSystem(), f10.getCliParams().getFileStore());  //host's, fileSystem's and FileStore's
	
		if ((rootDirectoryNameArray.length==0) && (rootFileNameArray.length==0)) {
			System.out.println("MakeFileSet makeFileSet no file or directory to traverse");
		} else {
			for (String rootDirName : rootDirectoryNameArray)	{
				MakeFileSetFile.createFilesForRootDirectory(f10, fileSet, rootDirName);
			}
			for (String rootFileName : rootFileNameArray)	{
				MakeFileSetFile.createFilesForRootFile(f10, fileSet, rootFileName);
			}
			
		}
		//MakeFileSetProperty.makeProperty(conn10, fileSet, -1l); // hostId
		return(fileSet);
	}
}
