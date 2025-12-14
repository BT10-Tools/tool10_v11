package tool10.fileset;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHost;
import tool10.util.TimeUtil;
import tool10.util.TraverseFiles;

public class MakeFileSetFile {

/*
	private static NodeFileType createFileType(Conn10 conn10,NodeFileSet corpus, String fileTypeName, String fileTypeDesc, String groupName)	{		
		Long modelTypeId = conn10.getNextId(-1); //"BSC_BASIC");
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeModelType(Long modelTypeId, Long aiId, String modelTypeName, String modelTypeDesc, String groupName,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeModelType modelType = new NodeModelType(modelTypeId,ai.getAiId(), modelTypeName, modelTypeDesc, groupName, creationDate, null);
		ai.getListModelType().add(modelType);
		ai.getMapId2ModelType().put(modelType.getModelTypeId(),modelType);
		return(modelType);
		
		return(null);
	}
*/
	private static String getRelativeFileName(NodeFileSet fileSet, File file, Long rootFileId)	{
		if ((rootFileId!=null) && (fileSet.getMapId2File().get(rootFileId)!=null))	{
			NodeFile rootNodeFile = fileSet.getMapId2File().get(rootFileId);
			Path rootPath = Paths.get(rootNodeFile.getFileNameAbsolute()); 
			return(rootPath.relativize(file.toPath()).toString());
		}
		return(null);
		//Path path1 = Paths.get("/home/user/documents");
	    //Path path2 = Paths.get("/home/user/music/song.mp3");  
		// Path relativePath = path1.relativize(path2); //../music/song.mp3
	}
	private static Long getFileSystemId(NodeF10 f10,File file)	{
		if (!"yes".equals(f10.getCliParams().getFileSystem())) {return(null);}
		//Long fileSystemId = null;
		FileSystem fileSystem = file.toPath().getFileSystem() ;
		NodeFileSystem nodeFileSystem = f10.getFileSet().getMapRawFileSystem2FileSystem().get(fileSystem);
		if (nodeFileSystem!=null)	{return(nodeFileSystem.getFileSystemId()); }
		NodeHost nodeHost = ((f10.getFileSet().getListHost().size()>0) ? f10.getFileSet().getListHost().get(0) : null);
		long hostId = ((nodeHost!=null) ? (nodeHost.getHostId()) : null); 
		NodeFileSystem newNodeFileSystem = MakeFileSetHost.createOneFileSystem(f10, fileSystem, hostId);		
		return(newNodeFileSystem.getFileSystemId());
	}
	private static Long getFileStoreId(NodeF10 f10,File file, Long fileSystemId )	{
		if (!"yes".equals(f10.getCliParams().getFileStore())) {return(null);}
		//Long fileStoreId = null;
		try {
			// Get the FileStore for the specified path
			FileStore fileStore = Files.getFileStore(file.toPath());
			NodeFileStore nodeFileStore = f10.getFileSet().getMapRawFileStore2FileStore().get(fileStore);
			if (nodeFileStore!=null)	{return(nodeFileStore.getFileStoreId()); }
			NodeFileStore newNodeFileStore = MakeFileSetHost.createOneFileStore(f10, fileStore, fileSystemId);		
			return(newNodeFileStore.getFileStoreId());
		} catch (IOException e)	{
			return(null);
		}
	}
	private static String getDirNameRelative(NodeFileSet fileSet, File file, Long rootFileId)	{
		//String dirNameAbsolute = getDirNameAbsolute(fileSet, file, rootFileId);
		if ((rootFileId!=null) && (fileSet.getMapId2File().get(rootFileId)!=null))	{
			NodeFile rootNodeFile = fileSet.getMapId2File().get(rootFileId);
			Path rootPath = Paths.get(rootNodeFile.getFileNameAbsolute()); 
			if (rootPath==null) return(null);
			return(rootPath.relativize(file.getParentFile().toPath()).toString());
		}
		return(null);
	}
	private static String getDirNameAbsolute(NodeFileSet fileSet, File file, Long rootFileId)	{
		String dirNameAbsolute = (file.getParentFile()!=null) ? file.getParentFile().getAbsolutePath() : null;
		return(dirNameAbsolute);
	}
	private static String getEncryptedNameRelative()	{
		return(null);
	}
	private static String getEncryptedNameAbsolute()	{
		return(null);
	}
	private static ZonedDateTime getFileZDT(Path path, String dateType)	{
		//creationTime, lastAccessTime, lastModifiedTime 
		ZonedDateTime zdt = null;
		FileTime fileTime = null;
		try {
			BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
			if ("creationTime".equals(dateType)) 			{ fileTime = attr.creationTime();	}
			else if ("lastAccessTime".equals(dateType)) 	{ fileTime = attr.lastAccessTime();	}
			else if ("lastModifiedTime".equals(dateType)) 	{ fileTime = attr.lastModifiedTime();	}
			zdt = TimeUtil.FileTime2ZDT(fileTime);
		} catch (IOException e)	{
		} catch (Exception e)	{
		}
		return(zdt);
	}
	private static void updateOneFileFields(NodeF10 f10, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
			//Long rootFileId = fileSet.getRootId();
			Long fileTypeId = null;
			Long sourceId = null;
			Long languageId = null;
			Long languageId2 = null;
			
			Long hashCode = (long) file.hashCode();;
			Long hashId = null;
			String fileType = (file.isDirectory() ? "dir" : (file.isFile() ? "file" : "other")) ; //file, directory, link
			String linkType = null; //softlink, hardlink
			Long linkedId = null;
			//There are two types of symbolic links: soft links, which redirect to the location where files are stored, 
			//and hard links, which make it appear as though the file or folder exists at the location of the symbolic link
			Long depth = null;
			Long depthFromRoot = null;
			    
			String fileNameRelative = getRelativeFileName(f10.getFileSet(),file,rootFileId);
			String fileNameCanonical = file.getCanonicalPath().toString();
			String dirNameRelative = getDirNameRelative(f10.getFileSet(), file, rootFileId); 
			String dirNameAbsolute = getDirNameAbsolute(f10.getFileSet(), file, rootFileId); 
			String altName1 = null;
			String altName2 = null;
			String altName3 = null;
			
			String encryptedNameRelative = getEncryptedNameRelative(); 
			String encryptedNameAbsolute = getEncryptedNameAbsolute(); 
			Long nameHashId = null;
			
			String fileURI = file.toURI().toString();;
			String fileURL = null;
			String extensionName = TraverseFiles.getFileExtension(newFile.getFileName());
			String nameWithoutExtension = TraverseFiles.getFilenameWithoutExtension(newFile.getFileName());
			Long fileNameAbsoluteLength = (long) newFile.getFileNameAbsolute().length();
			String ownerName = null;	
	
			String canExecute = Boolean.toString(file.canExecute());;
			String canRead = Boolean.toString(file.canRead());;
			String canWrite = Boolean.toString(file.canWrite());;
			String isExists = Boolean.toString(file.exists());;
			String isHidden = Boolean.toString(file.isHidden());
			
			HashMap<String,String> attrMap = MakeFileSetPropertyFile.getFileAttributeMap(file.toPath());
			//dos.isReadOnly,dos.isHidden,dos.isArchive,dos.isSystem,dos.isRegularFile,dos.isSymbolicLink,dos.isOther
	    			
			String isReadOnly = attrMap.get("dos.isReadOnly");
			String isArchive = attrMap.get("dos.isArchive");
			String isSystem = attrMap.get("dos.isSystem");
			String isSymbolicLink = attrMap.get("dos.isSymbolicLink");
			String isOther = attrMap.get("dos.isOther");
			String isRegularFile = attrMap.get("dos.isRegularFile");
			
			String probeContentType = Files.probeContentType(file.toPath());	
			
			//public void updateFields(Long fileSystemId, Long fileStoreId,Long fileTypeId, Long sourceId, Long languageId, Long languageId2, Long hashCode, Long hashId,
			//		String fileType, String linkType, Long linkedId, Long depth, Long depthFromRoot, String fileNameRelative, String fileNameCanonical,
			//		String dirNameRelative, String dirNameAbsolute, String altName1, String altName2, String altName3,
			//		String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId, 
			//		String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
			//		Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite, String isExists, String isHidden, String isOther,
			//		String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
			//		Long compressionGainBytes,String encoding, String charsetStr,
			//		Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,	ZonedDateTime fileLastAccessTime) 
				
			Long freeSpace = file.getFreeSpace();
			Long totalSpace = file.getTotalSpace();
			Long usableSpace = file.getUsableSpace();
			Long compressedFileSize = null;
			Double compressionGainRatio = null; 
			Long compressionGainBytes = null;  
			
			String encoding = null;
			String charsetStr = null; //Charset.forName("ISO-8859-1") = null;
			Long lastModified = file.lastModified(); // = file.lastModified() = null;
			ZonedDateTime fileCreationDate = getFileZDT(file.toPath(),"creationTime");
			ZonedDateTime fileModificationDate = getFileZDT(file.toPath(),"lastModifiedTime");;
			ZonedDateTime fileLastAccessTime = getFileZDT(file.toPath(),"lastAccessTime");;
			
			Long fileSystemId = getFileSystemId(f10,file);
			Long fileStoreId = getFileStoreId(f10,file,fileSystemId);
			
			newFile.updateFields(fileSystemId,fileStoreId,fileTypeId,sourceId,languageId,languageId2,hashCode,hashId, 
					fileType,linkType,linkedId,depth,depthFromRoot,fileNameRelative,fileNameCanonical,
					dirNameRelative,dirNameAbsolute,altName1,altName2,altName3,encryptedNameRelative,encryptedNameAbsolute,nameHashId,fileURI,fileURL,extensionName,nameWithoutExtension, 
					fileNameAbsoluteLength,ownerName,canExecute,canRead,canWrite,isExists,isHidden,isReadOnly,isArchive,isSystem,isSymbolicLink,isOther,  
					isRegularFile,probeContentType,freeSpace,totalSpace,usableSpace,compressedFileSize,compressionGainRatio,compressionGainBytes,
					encoding,charsetStr,lastModified,fileCreationDate,fileModificationDate,fileLastAccessTime);
	
		} catch(Exception e)	{
			
		}
	}
	private static NodeFile createOneFile(NodeF10 f10, NodeFileSet fileSet, File file, Long parentFileId, Long rootFileId)	{
		NodeFile newFile = null;
		if ((file==null) || (!file.exists())) {return(null);}
		try {
			Long fileSetId = fileSet.getFileSetId();
			Long fileSize = file.length();  //file.length() = null;
			String fileName = file.getName();
			String fileNameAbsolute = file.getAbsolutePath();
			if (parentFileId == null) {
				NodeFile parentFile = f10.getFileSet().getMapAbsoluteFileName2File().get(file.getParent());
				if (parentFile!=null)	{ parentFileId = parentFile.getFileId();}
			}
			String fileStatus = "ok";
			String fileRemark = null;
			String isDirectory = Boolean.toString(file.isDirectory());
			String isFile = Boolean.toString(file.isFile());
			
			
			String checkFileSizeResult = MakeFileSetFileFilter.checkFileSize(f10, file, fileSize); 
			String checkFileNameResult = MakeFileSetFileFilter.checkFileName(f10, file, fileName, fileNameAbsolute);
			if ((!"ok".equals(checkFileSizeResult)) || (!"ok".equals(checkFileNameResult)))	{
				fileStatus = "filtered";
				fileRemark = "filesizecheck="+checkFileSizeResult+",filenamecheck="+checkFileNameResult;
				//public NodeFile(Long fileId, Long parentFileId, Long fileSize, String fileStatus, String fileName, 
				//	String fileNameAbsolute, String fileRemark,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
				newFile = new NodeFile(null, fileSetId,parentFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now(), null);
			} else {
				newFile = new NodeFile(null, fileSetId, parentFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now(), null);
			
				updateOneFileFields(f10, newFile, file, parentFileId, rootFileId);
			}
			String checkWholeNewFileResult = MakeFileSetFileFilter.checkWholeNewFile(f10, file, newFile);
			
			if (!"ok".equals(checkWholeNewFileResult)) {
				fileStatus = "filtered";
				fileRemark = "wholefilecheck="+checkWholeNewFileResult;
				//create another new file, discrad all the fields calculated
				newFile = new NodeFile(null, fileSetId, parentFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now(), null);
				return(null);
			}
			Long fileId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			newFile.setFileId(fileId);
			fileSet.getListFile().add(newFile);
			fileSet.getMapId2File().put(newFile.getFileId(),newFile);
			fileSet.getMapAbsoluteFileName2File().put(newFile.getFileNameAbsolute(),newFile);
		} catch(Exception e)	{
			
		}
		return(newFile);
	}
	public static void updateParentId(NodeFileSet fileSet)	{
		//update parentFileId
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (nodeFile.getParentFileId() != null) continue;
			Path path = Paths.get(nodeFile.getFileNameAbsolute()); //"C:\\nh\\03_Downloaded"
			Path parentPath = path.getParent();
		    File parentFile = parentPath.toFile();
			NodeFile parentNodeFile = fileSet.getMapAbsoluteFileName2File().get(parentFile.getAbsolutePath());
			if (parentNodeFile==null) continue;
			Long parentFileId = parentNodeFile.getFileId();
			nodeFile.setParentFileId(parentFileId);
		}
	}
	public static int getCountSubstringInMainString(String mainString, String substring) {
        // Step 2: Count occurrences of the substring
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = mainString.indexOf(substring, fromIndex)) != -1) {
            count++;
            fromIndex += substring.length();
        }
        return(count); 
        //System.out.println("The substring '" + substring + "' occurs " + count + " times.");
	}
	public static int getCountCharInMainString(String mainString, char subChar) {
		long count = mainString.chars().filter(ch -> ch == subChar).count();
		//long count2 = mainString.codePoints().filter(ch -> ch == 'e').count();
		return((int) count);
	}
	public static int getDepthOfRoot(HashMap<Long,Long> mapRootFileId2Depth, NodeFile nodeFile)	{
		int depthOfRoot = -1;  
		//burada daha hıslı bir versiyon gellebilir
		//if ((mapRootFileId2Depth==null) || (nodeFile==null)) return(-1); 
		//if (nodeFile.getRootFileId())
		if (mapRootFileId2Depth.get(nodeFile.getRootFileId())==null)	{
			
		}
		return(depthOfRoot);
	}
	public static void updateDepths(NodeFileSet fileSet)	{
		int depthOfRoot = -1;  
		//HashMap<Long,Long> mapRootFileId2Depth = new HashMap<Long,Long>(); 
		String nlStr = "\\";
		char  nlChar = '\\';
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if ((nodeFile.getDepth()!=null) || (nodeFile.getDepthFromRoot()!=null)) continue;
			int depth = -1;
			String fileNameRelative = nodeFile.getFileNameRelative();
			if (fileNameRelative==null)	{ 
				depth = 0; 
			} else if (getCountCharInMainString(fileNameRelative,nlChar)==1)	{ 
				depth = 1;
		    } else {
				depth = getCountCharInMainString(fileNameRelative,nlChar);
			}
			depthOfRoot = getCountCharInMainString(nodeFile.getFileNameAbsolute(),nlChar);
			//depthOfRoot = getDepthOfRoot(mapRootFileId2Depth, nodeFile);
			nodeFile.setDepth((long) (depth+1));
			nodeFile.setDepthFromRoot((long) (depth+depthOfRoot));
		}
	}
	public static long updateDirectoryFilesize(NodeFileSet fileSet, NodeFile nodeFile)	{
		if (!"true".equals(nodeFile.getIsDirectory())) return(0l);  //it is not a directory
		long dirSize = 0l; 
		//first the directories
		for (NodeFile oneDir : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneDir.getIsDirectory())) continue;  //it is not a directory
			dirSize += updateDirectoryFilesize(fileSet, oneDir);
		}
		//second the files
		for (NodeFile oneFile : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneFile.getIsFile())) continue;  //it is not a file
			dirSize += oneFile.getFileSize().longValue();
		}	
		System.out.println("updateDirectoryFilesize nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute()+
				"   ,dirSize:"+dirSize +" ,nodeFile.getListSiblingFile().size():"+nodeFile.getListSiblingFile().size());
		nodeFile.setFileSize(dirSize);
		return(dirSize);
	}
	public static void updateSiblingLists(NodeFileSet fileSet)	{
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (nodeFile.getParentFileId()==null) continue;
			NodeFile nodeParentFile = fileSet.getMapId2File().get(nodeFile.getParentFileId());
			if (nodeParentFile==null) continue;
			nodeParentFile.getListSiblingFile().add(nodeFile);
		}
		//sort all the directory sibling lists
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (!"true".equals(nodeFile.getIsDirectory())) continue;  //it is not a directory
			nodeFile.sortListSiblingFile();
			System.out.println("updateSiblingLists sorting nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute()+
					" ,nodeFile.getListSiblingFile().size():"+nodeFile.getListSiblingFile().size());
		}	
	}
	public static void createFilesForRootFile(NodeF10 f10, NodeFileSet fileSet, String rootFileName)	{
		//will be written
	}
	public static void createFilesForRootDrive(NodeF10 f10, NodeFileSet fileSet, String rootFileName)	{
		//will be written
	}
	public static void createFilesForRootDirectory(NodeF10 f10, NodeFileSet fileSet,  String rootFileName)	{
		System.out.println("MakeFileSetFile createFilesForRootDirectory file processing rootFileName:"+rootFileName );
		
		if (rootFileName==null) return; 
		Path path = Paths.get(rootFileName); //"C:\\nh\\03_Downloaded"
		
	    File rootFile = path.toFile();
	    if ((rootFile==null)|| (!rootFile.exists())) return;
	    
		Long parentFileId = null; 
		Long rootFileId = null;
		NodeFile nodeRoot = createOneFile(f10, fileSet, rootFile, parentFileId, rootFileId);
		fileSet.getListRoots().add(nodeRoot);
		if (!"true".equals(nodeRoot.getIsDirectory())) return; //if the root is  a file just return
		
		ArrayList<String> fileNameList = new ArrayList<String>();
		String[] extArray = new String[] {"pdf"}; 
		int maxNumberOfFiles = 256*1024;
		int cntNumberOfFiles = TraverseFiles.traverseFiles(fileNameList, extArray,rootFile,maxNumberOfFiles);
		if (cntNumberOfFiles > maxNumberOfFiles)	{
			System.out.println("MakeFileSetFile createFilesForRootDirectory file number exceeded maximum cntNumberOfFiles:"+cntNumberOfFiles + 
					", maxNumberOfFiles:"+ maxNumberOfFiles +", fileNameList.size():"+fileNameList.size());
		}
		System.out.println("MakeFileSetFile createFilesForRootDirector rootFileName:"+rootFileName+ " ,cntNumberOfFiles:"+cntNumberOfFiles); 
		for (String fileName : fileNameList)	{
			Path filePath = Paths.get(fileName);
			if (filePath==null) continue;
			File processFile = filePath.toFile();
			if ((processFile==null) || (!processFile.exists())) continue;
			NodeFile addedFile = createOneFile(f10, fileSet, processFile, parentFileId, nodeRoot.getFileId());
			System.out.println("MakeFileSetFile createFilesForRootDirector filePath.toString():"+filePath.toString()+ " ,addedFile:"+addedFile);
		}
		System.out.println("MakeFileSetFile createFilesForRootDirector fileSet.getListFile().size():"+fileSet.getListFile().size());
		
		updateParentId(fileSet);
		updateDepths(fileSet);
		updateSiblingLists(fileSet);
		updateDirectoryFilesize(fileSet, nodeRoot);
	}
}
