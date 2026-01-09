package tool10.fileset;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.ZonedDateTime;
import java.util.HashMap;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHost;
import tool10.util.TimeUtil;

public class MakeFileSetFileProp {

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
	private static void updateOneFileFieldsProp1(NodeF10 f10, NodeFileProp newFileProp, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
						
			String linkType = null; //softlink, hardlink
			Long linkedId = null;
		
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
				
			Long compressedFileSize = null;
			Double compressionGainRatio = null; 
			Long compressionGainBytes = null;  
			
			String isDirectory = null;
			String isFile = null;
			Long signatureId = null; 
			Long fileSizeOnDisk = null;
			String fileSizeClass = null; 
			Long hashCode = null;
			String fileType = null;
			String computerName = null; 
			
			Long lastModified = file.lastModified(); // = file.lastModified() = null;
			ZonedDateTime fileCreationDate = getFileZDT(file.toPath(),"creationTime");
			ZonedDateTime fileModificationDate = getFileZDT(file.toPath(),"lastModifiedTime");;
			ZonedDateTime fileLastAccessTime = getFileZDT(file.toPath(),"lastAccessTime");;
				
			//public void updateFields(Long signatureId,Long fileSizeOnDisk,String fileSizeClass,Long hashCode,String fileType,
			//		String linkType,Long linkedId,String ownerName,String computerName,
			//		String canExecute,String canRead,String canWrite,String isExists,String isDirectory,String isFile,
			//		String isSymbolicLink,String isHidden,String isArchive,String isSystem,String isReadOnly,
			//		String isOther,String isRegularFile,String probeContentType, 
			//		Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes,
			// 		Long lastModified, ZonedDateTime fileCreationDate,ZonedDateTime fileModificationDate,ZonedDateTime fileLastAccessTime)		{
			newFileProp.updateFields(signatureId,fileSizeOnDisk,fileSizeClass,hashCode,fileType,
					linkType,linkedId,ownerName,computerName,
					canExecute,canRead,canWrite,isExists,isDirectory,isFile,
					isSymbolicLink,isHidden,isArchive,isSystem,isReadOnly,
					isOther,isRegularFile,probeContentType,
					compressedFileSize,compressionGainRatio,compressionGainBytes,
					lastModified,fileCreationDate,fileModificationDate,fileLastAccessTime);	
					
		} catch(Exception e)	{
			
		}
	}
	private static void updateOneFileFieldsProp2(NodeF10 f10, NodeFileProp newFileProp, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
			String isCompresssed = null; 
			String isEncrypted = null;
			String isIndexed = null; 
			String isContentIndexed = null; 
			String isBlocked = null; 
			String isSystemFile = null; 
			String isAppFile = null;
			String isCompanyFile = null; 
			String isUserFile = null; 
			String isExecutable = null; 
			String isTextFile = null; 
			String isXMLFile = null;
			String isConfigFile = null; 
			String isBinaryFile = null; 
			String isImmutable = null; 
			String isInUserPath = null; 
			String isInSystemPath = null;
			String isShareable = null; 
			String isShared = null; 
			String hasPreviousVersions = null; 
			String uxPermission = null; 
			String uxInfo = null; 
			Long duration = null;
			Long contentLanguageId = null; 
			Long contentLanguageId2 = null; 
			String contentEncoding = null; 
			String contentCharsetStr = null;
			String iconName = null; 
			String origin = null; 
			String copyrightInfo = null; 
			String licenseInfo = null; 
			String assetInfo = null; 
			String dlpInfo = null;
			String fileRemark  = null;
			
			/*	String isCompresssed, String isEncrypted,
			String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
			String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
			String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
			String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo, Long duration,
			Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
			String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
			String fileRemark);	*/
			
			newFileProp.updateFields2(isCompresssed,isEncrypted,isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,
				isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,
				isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,duration,
				contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,
				iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,fileRemark);
			
		} catch(Exception e)	{
			
		}
	}
	//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
	//		String propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
	//		Long hashCode, String fileType, String linkType, Long linkedId, String ownerName, String computerName,
	//		String canExecute, String canRead, String canWrite, String isExists, String isDirectory, String isFile,
	//		String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
	//		String isOther, String isRegularFile, String probeContentType, String isCompresssed, String isEncrypted,
	//		String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
	//		String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
	//		String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
	//		String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
	//		Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
	//		Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
	//		String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
	//		Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
	//		ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,
	//		ZonedDateTime modificationDate) {
	
	public static NodeFileProp createOneFileProp(NodeF10 f10, NodeFileSet fileSet, NodeFile nodeFile, File file, Long parentFileId, Long rootFileId, 
			Long depth, Long depthFromRoot)	{
		NodeFileProp newFileProp = null;
		if ((file==null) || (!file.exists())) {return(null);}
		
		try {
			Long fileSetId = fileSet.getFileSetId();
			Long fileSystemId = getFileSystemId(f10,file);
			Long fileStoreId = getFileStoreId(f10,file,fileSystemId);
			String propertyType = "type1";
			
			//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, 
			//		Long fileStoreId, String propertyType, Long fileSize, ZonedDateTime creationDate) {
			newFileProp = new NodeFileProp(null, nodeFile.getFileId(), fileSetId, fileSystemId, fileStoreId, propertyType,
					nodeFile.getFileSize(), ZonedDateTime.now());
			
			updateOneFileFieldsProp1(f10, newFileProp, nodeFile, file, parentFileId, rootFileId);
			updateOneFileFieldsProp2(f10, newFileProp, nodeFile, file, parentFileId, rootFileId);
			String checkNewFilePropResult = FileFilter.checkNewFileProp(f10, file, nodeFile, newFileProp);
			
			if (!"ok".equals(checkNewFilePropResult)) {
				String fileStatus = "filtered";
				String fileRemark = "propfilecheck="+checkNewFilePropResult;
				//create another new file, discard all the fields calculated ??
				return(null);
			}
			Long filePropId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			newFileProp.setFilePropId(filePropId);
			newFileProp.setRefFile(nodeFile);
			nodeFile.setRefFileProp(newFileProp);
			fileSet.getListFileProp().add(newFileProp);
			fileSet.getMapId2FileProp().put(newFileProp.getFileId(),newFileProp);			
		} catch(Exception e)	{
			
		}
		return(newFileProp);
	}
}
