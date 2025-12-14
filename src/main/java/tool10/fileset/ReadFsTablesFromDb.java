package tool10.fileset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import tool10.fileset.nodes.NodeBinary;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileBlobSmall;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.nodes.NodeQuery;
import tool10.fileset.nodes.NodeSimilarity;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class ReadFsTablesFromDb {
	
	public static int readTableFile(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileId,fileSetId,fileSystemId,fileStoreId,parentFileId,rootFileId,fileTypeId,sourceId,languageId,languageId2,fileSize,hashCode,"+
				" hashId,fileType,linkType,linkedId,fileStatus,depth,depthFromRoot,fileName,fileNameRelative,fileNameAbsolute,fileNameCanonical,"+
				" dirNameRelative,dirNameAbsolute,altName1,altName2,altName3,encryptedNameRelative,encryptedNameAbsolute,nameHashId,fileURI,fileURL,"+
				" extensionName,nameWithoutExtension,fileNameAbsoluteLength,ownerName,canExecute,canRead,canWrite,isExists,isDirectory,"+
				" isFile,isSymbolicLink,isHidden,isReadOnly,isArchive,isSystem,isOther,isRegularFile,probeContentType,freeSpace,totalSpace,usableSpace,compressedFileSize,"+
				" compressionGainRatio,compressionGainBytes,encoding,charsetStr,lastModified,fileCreationDate,fileModificationDate,"+
				" fileLastAccessTime,fileRemark,creationDate,modificationDate"+
			 " FROM FS_FILE WHERE fileSetId = ? ORDER BY fileId"; 
		//public NodeFile(Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId, Long parentFileId, Long rootFileId, Long fileTypeId,
		//Long sourceId, Long languageId, Long languageId2, Long fileSize, Long hashCode, Long hashId,
		//String fileType, String linkType, Long linkedId, String fileStatus, Long depth, Long depthFromRoot, String fileName, String fileNameRelative, String fileNameAbsolute,
		//String fileNameCanonical, String dirNameRelative, String dirNameAbsolute, String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId, 
		//String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
		//Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite,
		//String isExists, String isDirectory, String isFile, String isSymbolicLink, String isHidden, String isReadOnly, String isArchive, String isSystem, String isOther,
		//String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
		//Long compressionGainBytes,String encoding, String charsetStr,Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
		//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long fileStoreId = rs.getLong("fileStoreId");	if (rs.wasNull()) {fileStoreId = null;}
				Long parentFileId = rs.getLong("parentFileId");	if (rs.wasNull()) {parentFileId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long fileTypeId = rs.getLong("fileTypeId");	if (rs.wasNull()) {fileTypeId = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				Long languageId = rs.getLong("languageId");	if (rs.wasNull()) {languageId = null;}
				Long languageId2 = rs.getLong("languageId2");	if (rs.wasNull()) {languageId2 = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long hashCode = rs.getLong("hashCode");	if (rs.wasNull()) {hashCode = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String fileType = rs.getString("fileType");
				String linkType = rs.getString("linkType");
				Long linkedId = rs.getLong("linkedId");	if (rs.wasNull()) {linkedId = null;}
				String fileStatus = rs.getString("fileStatus");
				Long depth = rs.getLong("depth");	if (rs.wasNull()) {depth = null;}
				Long depthFromRoot = rs.getLong("depthFromRoot");	if (rs.wasNull()) {depthFromRoot = null;}
				String fileName = rs.getString("fileName");
				String fileNameRelative = rs.getString("fileNameRelative");
				String fileNameAbsolute = rs.getString("fileNameAbsolute");
				String fileNameCanonical = rs.getString("fileNameCanonical");
				String dirNameRelative = rs.getString("dirNameRelative");
				String dirNameAbsolute = rs.getString("dirNameAbsolute");
				String altName1 = rs.getString("altName1");
				String altName2 = rs.getString("altName2");
				String altName3 = rs.getString("altName3");
				
				String encryptedNameRelative = rs.getString("encryptedNameRelative");
				String encryptedNameAbsolute = rs.getString("encryptedNameAbsolute");
				Long fileNameAbsoluteLength = rs.getLong("fileNameAbsoluteLength");	if (rs.wasNull()) {fileNameAbsoluteLength = null;}
				String fileURI = rs.getString("fileURI");
				String fileURL = rs.getString("fileURL");
				String extensionName = rs.getString("extensionName");
				String nameWithoutExtension = rs.getString("nameWithoutExtension");
				Long nameHashId = rs.getLong("nameHashId");	if (rs.wasNull()) {nameHashId = null;}
				String ownerName = rs.getString("ownerName");
				String canExecute = rs.getString("canExecute");
				String canRead = rs.getString("canRead");
				String canWrite = rs.getString("canWrite");
				String isExists = rs.getString("isExists");
				String isDirectory = rs.getString("isDirectory");
				String isFile = rs.getString("isFile");
				String isSymbolicLink = rs.getString("isSymbolicLink");
				String isHidden = rs.getString("isHidden");
				String isReadOnly = rs.getString("isReadOnly");
				String isArchive = rs.getString("isArchive");
				String isSystem = rs.getString("isSystem");
				String isOther = rs.getString("isOther");
				String isRegularFile = rs.getString("isRegularFile");
				String probeContentType = rs.getString("probeContentType");
				Long freeSpace = rs.getLong("freeSpace");	if (rs.wasNull()) {freeSpace = null;}
				Long totalSpace = rs.getLong("totalSpace");	if (rs.wasNull()) {totalSpace = null;}
				Long usableSpace = rs.getLong("usableSpace");	if (rs.wasNull()) {usableSpace = null;}
				Long compressedFileSize = rs.getLong("compressedFileSize");	if (rs.wasNull()) {compressedFileSize = null;}
				Double compressionGainRatio = rs.getDouble("compressionGainRatio");	if (rs.wasNull()) {compressionGainRatio = null;}
				Long compressionGainBytes = rs.getLong("compressionGainBytes");	if (rs.wasNull()) {compressionGainBytes = null;}
				String encoding = rs.getString("encoding");
				String charsetStr = rs.getString("charsetStr");
				Long lastModified = rs.getLong("lastModified");	if (rs.wasNull()) {lastModified = null;}
				String fileCreationDateStr = rs.getString("fileCreationDate");
				ZonedDateTime fileCreationDate = ((fileCreationDateStr!=null) ? ZonedDateTime.parse(fileCreationDateStr) : null); 
				String fileModificationDateStr = rs.getString("fileModificationDate");
				ZonedDateTime fileModificationDate = ((fileModificationDateStr!=null) ? ZonedDateTime.parse(fileModificationDateStr) : null); 
				String fileLastAccessTimeStr = rs.getString("fileLastAccessTime");
				ZonedDateTime fileLastAccessTime = ((fileLastAccessTimeStr!=null) ? ZonedDateTime.parse(fileLastAccessTimeStr) : null); 
				String fileRemark = rs.getString("fileRemark");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFile newFile = new NodeFile(
					fileId,fileSetId,fileSystemId,fileStoreId,parentFileId,rootFileId,fileTypeId,
					sourceId,languageId,languageId2,fileSize,hashCode,hashId,
					fileType,linkType,linkedId,fileStatus,depth,depthFromRoot,fileName,fileNameRelative,fileNameAbsolute,
					fileNameCanonical,dirNameRelative,dirNameAbsolute,altName1,altName2,altName3,encryptedNameRelative,encryptedNameAbsolute,nameHashId,
					fileURI,fileURL,extensionName,nameWithoutExtension,
					fileNameAbsoluteLength,ownerName,canExecute,canRead,canWrite,
					isExists,isDirectory,isFile,isSymbolicLink,isHidden,isReadOnly,isArchive,isSystem,isOther,
					isRegularFile,probeContentType,freeSpace,totalSpace,usableSpace,compressedFileSize,compressionGainRatio,
					compressionGainBytes,encoding,charsetStr,lastModified,fileCreationDate,fileModificationDate,
					fileLastAccessTime,fileRemark,creationDate,modificationDate);
				
				fileSet.getListFile().add(newFile); 
				fileSet.getMapId2File().put(newFile.getFileId(),newFile); 
				cntRead++; 
			}
			System.out.println("readTableFile: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileBlob(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileBlobId,fileId,fileSetId,partNumber,cntPart,blobType,blobSize,fileSize,compressionType,compressedFileSize,compressionGainRatio,"+
				" compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,"+
				" encryptedFileSize,encrytedByteHashId,fileBytes,compressedBytes,encryptedBytes,hashId,creationDate,modificationDate"+
				" FROM FS_FILEBLOB WHERE fileSetId = ? ORDER BY fileBlobId"; 
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
		//		Long blobSize, Long fileSize, String compressionType, Long compressedFileSize, Double compressionGainRatio,
		//		Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//		Long encryptedFileSize, Long encrytedByteHashId,byte[] fileBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//		Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileBlobId = rs.getLong("fileBlobId");	if (rs.wasNull()) {fileBlobId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long partNumber = rs.getLong("partNumber");	if (rs.wasNull()) {partNumber = null;}
				Long cntPart = rs.getLong("cntPart");	if (rs.wasNull()) {cntPart = null;}
				String blobType = rs.getString("blobType");
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				String compressionType = rs.getString("compressionType");
				Long compressedFileSize = rs.getLong("compressedFileSize");	if (rs.wasNull()) {compressedFileSize = null;}
				Double compressionGainRatio = rs.getDouble("compressionGainRatio");	if (rs.wasNull()) {compressionGainRatio = null;}
				Long compressionGainBytes = rs.getLong("compressionGainBytes");	if (rs.wasNull()) {compressionGainBytes = null;}
				Long compressedByteHashId = rs.getLong("compressedByteHashId");	if (rs.wasNull()) {compressedByteHashId = null;}
				Long sandByteLengthHead = rs.getLong("sandByteLengthHead");	if (rs.wasNull()) {sandByteLengthHead = null;}
				Long sandByteLengthTail = rs.getLong("sandByteLengthTail");	if (rs.wasNull()) {sandByteLengthTail = null;}
				String encryptionBlobKey = rs.getString("encryptionBlobKey");
				String encryptionType = rs.getString("encryptionType");
				Long encryptedFileSize = rs.getLong("encryptedFileSize");	if (rs.wasNull()) {encryptedFileSize = null;}
				Long encrytedByteHashId = rs.getLong("encrytedByteHashId");	if (rs.wasNull()) {encrytedByteHashId = null;}
				byte[] fileBytes = rs.getBytes("fileBytes");  	if (rs.wasNull()) {fileBytes = null;}
				byte[] compressedBytes = rs.getBytes("compressedBytes");  	if (rs.wasNull()) {fileBytes = null;}
				byte[] encryptedBytes = rs.getBytes("encryptedBytes");  	if (rs.wasNull()) {fileBytes = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileBlob newFileBlob = new NodeFileBlob(
						fileBlobId,fileId,fileSetId,partNumber,cntPart,blobType,blobSize,fileSize,compressionType,compressedFileSize,compressionGainRatio,
						compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,
						encryptedFileSize,encrytedByteHashId,fileBytes,compressedBytes,encryptedBytes,hashId,creationDate,modificationDate);
				fileSet.getListFileBlob().add(newFileBlob); 
				fileSet.getMapId2FileBlob().put(newFileBlob.getFileBlobId(),newFileBlob); 
				cntRead++; 
			}
			System.out.println("readTableFileBlob: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileBlobSmall(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileBlobSmallId,fileBlobId,fileId,fileSetId,byteIndexStart,byteIndexEnd,hashId,creationDate,modificationDate"+
			 " FROM FS_FILEBLOBSMALL WHERE fileSetId = ? ORDER BY fileBlobSmallId"; 
		//public NodeFileBlobSmall(Long fileBlobSmallId,Long fileBlobId,Long fileId,Long fileSetId,Long byteIndexStart,Long byteIndexEnd,Long hashId,
		//ZonedDateTime creationDate,ZonedDateTime modificationDate)

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileBlobSmallId = rs.getLong("fileBlobSmallId");	if (rs.wasNull()) {fileBlobSmallId = null;}
				Long fileBlobId = rs.getLong("fileBlobId");	if (rs.wasNull()) {fileBlobId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long byteIndexStart = rs.getLong("byteIndexStart");	if (rs.wasNull()) {byteIndexStart = null;}
				Long byteIndexEnd = rs.getLong("byteIndexEnd");	if (rs.wasNull()) {byteIndexEnd = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileBlobSmall newFileBlobSmall = new NodeFileBlobSmall(
						fileBlobSmallId,fileBlobId,fileId,fileSetId,byteIndexStart,byteIndexEnd,hashId,creationDate,modificationDate);
				fileSet.getListFileBlobSmall().add(newFileBlobSmall); 
				fileSet.getMapId2FileBlobSmall().put(newFileBlobSmall.getFileBlobSmallId(),newFileBlobSmall); 
				cntRead++; 
			}
			System.out.println("readTableFileBlobSmall: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileStore(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,"+
				" hashCode,rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate"+
			 " FROM FS_FILESTORE WHERE fileSetId = ? ORDER BY fileStoreId"; 
		//public NodeFileStore(Long fileStoreId,Long fileSetId,Long fileSystemId,Long rootFileId,Long displayOrder,Long blockSize,Long totalSpace,
		//Long unallocatedSpace,Long usableSpace,Long usedSpace,Long hashCode,String rootDirectoryName,String isReadOnly,
		//String nameStr,String toString,String typeStr,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileStoreId = rs.getLong("fileStoreId");	if (rs.wasNull()) {fileStoreId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				Long blockSize = rs.getLong("blockSize");	if (rs.wasNull()) {blockSize = null;}
				Long totalSpace = rs.getLong("totalSpace");	if (rs.wasNull()) {totalSpace = null;}
				Long unallocatedSpace = rs.getLong("unallocatedSpace");	if (rs.wasNull()) {unallocatedSpace = null;}
				Long usableSpace = rs.getLong("usableSpace");	if (rs.wasNull()) {usableSpace = null;}
				Long usedSpace = rs.getLong("usedSpace");	if (rs.wasNull()) {usedSpace = null;}
				Long hashCode = rs.getLong("hashCode");	if (rs.wasNull()) {hashCode = null;}
				String rootDirectoryName = rs.getString("rootDirectoryName");
				String isReadOnly = rs.getString("isReadOnly");
				String nameStr = rs.getString("nameStr");
				String toString = rs.getString("toString");
				String typeStr = rs.getString("typeStr");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileStore newFileStore = new NodeFileStore(
						fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,
						hashCode,rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate);
				fileSet.getListFileStore().add(newFileStore); 
				fileSet.getMapId2FileStore().put(newFileStore.getFileStoreId(),newFileStore); 
				cntRead++; 
			}
			System.out.println("readTableFileStore: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableFileSystem(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"fileSystemId,fileSetId,hostId,rootFileId,displayOrder,systemName,providerName,providerHashCode,isDefault,isOpen,"+
				" isReadOnly,creationDate,modificationDate"+
			 " FROM FS_FILESYSTEM WHERE fileSetId = ? ORDER BY fileSystemId"; 
		//public NodeFileSystem(Long fileSystemId,Long fileSetId,Long hostId,Long rootFileId,Long displayOrder,String systemName,String providerName,
		//Long providerHashCode,String isDefault,String isOpen,String isReadOnly,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileSystemId = rs.getLong("fileSystemId");	if (rs.wasNull()) {fileSystemId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long hostId = rs.getLong("hostId");	if (rs.wasNull()) {hostId = null;}
				Long rootFileId = rs.getLong("rootFileId");	if (rs.wasNull()) {rootFileId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String systemName = rs.getString("systemName");
				String providerName = rs.getString("providerName");
				Long providerHashCode = rs.getLong("providerHashCode");	if (rs.wasNull()) {providerHashCode = null;}
				String isDefault = rs.getString("isDefault");
				String isOpen = rs.getString("isOpen");
				String isReadOnly = rs.getString("isReadOnly");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileSystem newFileSystem = new NodeFileSystem(
						fileSystemId,fileSetId,hostId,rootFileId,displayOrder,systemName,providerName,providerHashCode,isDefault,isOpen,
						isReadOnly,creationDate,modificationDate);
				fileSet.getListFileSystem().add(newFileSystem); 
				fileSet.getMapId2FileSystem().put(newFileSystem.getFileSystemId(),newFileSystem); 
				cntRead++; 
			}
			System.out.println("readTableFileSystem: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableHash(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,"+
				" hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate"+
			 " FROM FS_HASH WHERE fileSetId = ? ORDER BY hashId"; 
		//public NodeHash(Long hashId,Long fileSetId,Long fileSize,Long crc64,Long crc32,Long adler32,String blake3,String md5,String sha1,
		//String sha256,String sha384,String sha512,String sha3256,String keccak256,String hashFieldDesc,String hashStr01,
		//String hashStr02,String hashStr03,String hashStr04,String hashStr05,Long hashLong01,Long hashLong02,Long hashLong03,
		//Long hashLong04,Long hashLong05,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long crc64 = rs.getLong("crc64");	if (rs.wasNull()) {crc64 = null;}
				Long crc32 = rs.getLong("crc32");	if (rs.wasNull()) {crc32 = null;}
				Long adler32 = rs.getLong("adler32");	if (rs.wasNull()) {adler32 = null;}
				String blake3 = rs.getString("blake3");
				String md5 = rs.getString("md5");
				String sha1 = rs.getString("sha1");
				String sha256 = rs.getString("sha256");
				String sha384 = rs.getString("sha384");
				String sha512 = rs.getString("sha512");
				String sha3256 = rs.getString("sha3256");
				String keccak256 = rs.getString("keccak256");
				String hashFieldDesc = rs.getString("hashFieldDesc");
				String hashStr01 = rs.getString("hashStr01");
				String hashStr02 = rs.getString("hashStr02");
				String hashStr03 = rs.getString("hashStr03");
				String hashStr04 = rs.getString("hashStr04");
				String hashStr05 = rs.getString("hashStr05");
				Long hashLong01 = rs.getLong("hashLong01");	if (rs.wasNull()) {hashLong01 = null;}
				Long hashLong02 = rs.getLong("hashLong02");	if (rs.wasNull()) {hashLong02 = null;}
				Long hashLong03 = rs.getLong("hashLong03");	if (rs.wasNull()) {hashLong03 = null;}
				Long hashLong04 = rs.getLong("hashLong04");	if (rs.wasNull()) {hashLong04 = null;}
				Long hashLong05 = rs.getLong("hashLong05");	if (rs.wasNull()) {hashLong05 = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeHash newHash = new NodeHash(
						hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,
						hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate);
				fileSet.getListHash().add(newHash); 
				fileSet.getMapId2Hash().put(newHash.getHashId(),newHash); 
				cntRead++; 
			}
			System.out.println("readTableHash: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableHost(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT hostId,fileSetId,hostName,hostIP,domainName,creationDate,modificationDate"+
			 " FROM FS_HOST WHERE fileSetId = ? ORDER BY hostId"; 
		//public NodeHost(Long hostId,Long fileSetId,String hostName,String hostIP,String domainName,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long hostId = rs.getLong("hostId");	if (rs.wasNull()) {hostId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				String hostName = rs.getString("hostName");
				String hostIP = rs.getString("hostIP");
				String domainName = rs.getString("domainName");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeHost newHost = new NodeHost(hostId,fileSetId,hostName,hostIP,domainName,creationDate,modificationDate);
				fileSet.getListHost().add(newHost); 
				fileSet.getMapId2Host().put(newHost.getHostId(),newHost); 
				cntRead++; 
			}
			System.out.println("readTableHost: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableProperty(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT propertyId,fileSetId,entityId,displayOrder,mapName,entityName,propertyKey,propertyValue,valueString,valueLong,valueDouble,"+
				" valueBinary,valueZDT,creationDate,modificationDate"+
			 " FROM FS_PROPERTY WHERE fileSetId = ? ORDER BY propertyId"; 
		//public NodeProperty(Long propertyId,Long fileSetId,Long entityId,Long displayOrder,String mapName,String entityName,String propertyKey,
		//String propertyValue,String valueString,Long valueLong,Double valueDouble,ZonedDateTime valueZDT,ZonedDateTime creationDate,
		//ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long propertyId = rs.getLong("propertyId");	if (rs.wasNull()) {propertyId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String mapName = rs.getString("mapName");
				String entityName = rs.getString("entityName");
				String propertyKey = rs.getString("propertyKey");
				String propertyValue = rs.getString("propertyValue");
				String valueString = rs.getString("valueString");
				Long valueLong = rs.getLong("valueLong");	if (rs.wasNull()) {valueLong = null;}
				Double valueDouble = rs.getDouble("valueDouble");	if (rs.wasNull()) {valueDouble = null;}
				byte[] bytesRead = rs.getBytes("valueBinary");  	if (rs.wasNull()) {bytesRead = null;}
				NodeBinary valueBinary =null; 
				if (bytesRead!=null) { valueBinary = new NodeBinary((long) bytesRead.length, bytesRead); } 
				
				String valueZDTStr = rs.getString("valueZDT");
				ZonedDateTime valueZDT = ((valueZDTStr!=null) ? ZonedDateTime.parse(valueZDTStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeProperty newProperty = new NodeProperty(
						propertyId,fileSetId,entityId,displayOrder,mapName,entityName,propertyKey,propertyValue,valueString,valueLong,valueDouble,
						valueBinary,valueZDT,creationDate,modificationDate);
				fileSet.getListProperty().add(newProperty); 
				fileSet.getMapId2Property().put(newProperty.getPropertyId(),newProperty); 
				cntRead++; 
			}
			System.out.println("readTableProperty: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableQuery(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT queryId,fileSetId,entityId,cntExecution,sqlString,firstExecutionDate,lastExecutionDate,creationDate,modificationDate"+
			 " FROM FS_QUERY WHERE fileSetId = ? ORDER BY queryId"; 
		//public NodeQuery(Long queryId,Long fileSetId,Long entityId,Long cntExecution,String sqlString,ZonedDateTime firstExecutionDate,
		//ZonedDateTime lastExecutionDate,ZonedDateTime creationDate,ZonedDateTime modificationDate)
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long queryId = rs.getLong("queryId");	if (rs.wasNull()) {queryId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long cntExecution = rs.getLong("cntExecution");	if (rs.wasNull()) {cntExecution = null;}
				String sqlString = rs.getString("sqlString");
				String firstExecutionDateStr = rs.getString("firstExecutionDate");
				ZonedDateTime firstExecutionDate = ((firstExecutionDateStr!=null) ? ZonedDateTime.parse(firstExecutionDateStr) : null); 
				String lastExecutionDateStr = rs.getString("lastExecutionDate");
				ZonedDateTime lastExecutionDate = ((lastExecutionDateStr!=null) ? ZonedDateTime.parse(lastExecutionDateStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeQuery newQuery = new NodeQuery(queryId,fileSetId,entityId,cntExecution,sqlString,firstExecutionDate,lastExecutionDate,
						creationDate,modificationDate);
				fileSet.getListQuery().add(newQuery); 
				fileSet.getMapId2Query().put(newQuery.getQueryId(),newQuery); 
				cntRead++; 
			}
			System.out.println("readTableQuery: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableSimilarity(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"similarityId,fileSetId,entityId1,entityId2,similarityType,similarityKey,sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,"+
				" sim10,sim11,sim12,sim13,sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,alg08,alg09,alg10,"+
				" alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate"+
			 " FROM FS_SIMILARITY WHERE fileSetId = ? ORDER BY similarityId"; 
		//public NodeSimilarity(Long similarityId,Long fileSetId,Long entityId1,Long entityId2,String similarityType,Double sim00,Double sim01,
		//Double sim02,Double sim03,Double sim04,Double sim05,Double sim06,Double sim07,Double sim08,Double sim09,Double sim10,
		//Double sim11,Double sim12,Double sim13,Double sim14,Double sim15,Double sim16,Double sim17,Double sim18,Double sim19,
		//String alg00,String alg01,String alg02,String alg03,String alg04,String alg05,String alg06,String alg07,String alg08,
		//String alg09,String alg10,String alg11,String alg12,String alg13,String alg14,String alg15,String alg16,String alg17,
		//String alg18,String alg19,ZonedDateTime creationDate,ZonedDateTime modificationDate)

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long similarityId = rs.getLong("similarityId");	if (rs.wasNull()) {similarityId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long entityId1 = rs.getLong("entityId1");	if (rs.wasNull()) {entityId1 = null;}
				Long entityId2 = rs.getLong("entityId2");	if (rs.wasNull()) {entityId2 = null;}
				String similarityType = rs.getString("similarityType");
				String similarityKey = rs.getString("similarityKey");
				Double sim00 = rs.getDouble("sim00");	if (rs.wasNull()) {sim00 = null;}
				Double sim01 = rs.getDouble("sim01");	if (rs.wasNull()) {sim01 = null;}
				Double sim02 = rs.getDouble("sim02");	if (rs.wasNull()) {sim02 = null;}
				Double sim03 = rs.getDouble("sim03");	if (rs.wasNull()) {sim03 = null;}
				Double sim04 = rs.getDouble("sim04");	if (rs.wasNull()) {sim04 = null;}
				Double sim05 = rs.getDouble("sim05");	if (rs.wasNull()) {sim05 = null;}
				Double sim06 = rs.getDouble("sim06");	if (rs.wasNull()) {sim06 = null;}
				Double sim07 = rs.getDouble("sim07");	if (rs.wasNull()) {sim07 = null;}
				Double sim08 = rs.getDouble("sim08");	if (rs.wasNull()) {sim08 = null;}
				Double sim09 = rs.getDouble("sim09");	if (rs.wasNull()) {sim09 = null;}
				Double sim10 = rs.getDouble("sim10");	if (rs.wasNull()) {sim10 = null;}
				Double sim11 = rs.getDouble("sim11");	if (rs.wasNull()) {sim11 = null;}
				Double sim12 = rs.getDouble("sim12");	if (rs.wasNull()) {sim12 = null;}
				Double sim13 = rs.getDouble("sim13");	if (rs.wasNull()) {sim13 = null;}
				Double sim14 = rs.getDouble("sim14");	if (rs.wasNull()) {sim14 = null;}
				Double sim15 = rs.getDouble("sim15");	if (rs.wasNull()) {sim15 = null;}
				Double sim16 = rs.getDouble("sim16");	if (rs.wasNull()) {sim16 = null;}
				Double sim17 = rs.getDouble("sim17");	if (rs.wasNull()) {sim17 = null;}
				Double sim18 = rs.getDouble("sim18");	if (rs.wasNull()) {sim18 = null;}
				Double sim19 = rs.getDouble("sim19");	if (rs.wasNull()) {sim19 = null;}
				String alg00 = rs.getString("alg00");
				String alg01 = rs.getString("alg01");
				String alg02 = rs.getString("alg02");
				String alg03 = rs.getString("alg03");
				String alg04 = rs.getString("alg04");
				String alg05 = rs.getString("alg05");
				String alg06 = rs.getString("alg06");
				String alg07 = rs.getString("alg07");
				String alg08 = rs.getString("alg08");
				String alg09 = rs.getString("alg09");
				String alg10 = rs.getString("alg10");
				String alg11 = rs.getString("alg11");
				String alg12 = rs.getString("alg12");
				String alg13 = rs.getString("alg13");
				String alg14 = rs.getString("alg14");
				String alg15 = rs.getString("alg15");
				String alg16 = rs.getString("alg16");
				String alg17 = rs.getString("alg17");
				String alg18 = rs.getString("alg18");
				String alg19 = rs.getString("alg19");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeSimilarity newSimilarity = new NodeSimilarity(
						similarityId,fileSetId,entityId1,entityId2,similarityType,similarityKey,sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,
						sim10,sim11,sim12,sim13,sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,alg08,alg09,alg10,
						alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate);
				fileSet.getListSimilarity().add(newSimilarity); 
				fileSet.getMapId2Similarity().put(newSimilarity.getSimilarityId(),newSimilarity); 
				cntRead++; 
			}
			System.out.println("readTableSimilarity: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableArchive(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, \r\n" + 
			" multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,\r\n " + 
			" unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate,creationDate,modificationDate "+
			" FROM FS_ARCHIVE WHERE fileSetId = ? ORDER BY archiveId"; 
		//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
		//String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
		//Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
		//Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
		//ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long archiveId = rs.getLong("archiveId");	if (rs.wasNull()) {archiveId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long archiveFileId = rs.getLong("archiveFileId");	if (rs.wasNull()) {archiveFileId = null;}
				Long archiveFileSetId = rs.getLong("archiveFileSetId");	if (rs.wasNull()) {archiveFileSetId = null;}
				String archiveType = rs.getString("archiveType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String multipleFileArchive = rs.getString("multipleFileArchive");
				String archiveRemark = rs.getString("archiveRemark");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long cntArchive = rs.getLong("cntArchive");	if (rs.wasNull()) {cntArchive = null;}
				Long cntDirectory = rs.getLong("cntDirectory");	if (rs.wasNull()) {cntDirectory = null;}
				Long cntFileTree = rs.getLong("cntFileTree");	if (rs.wasNull()) {cntFileTree = null;}
				Long cntDirectoryTree = rs.getLong("cntDirectoryTree");	if (rs.wasNull()) {cntDirectoryTree = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				Long unzippedFileSize = rs.getLong("unzippedFileSize");	if (rs.wasNull()) {unzippedFileSize = null;}
				Double unzipGainRatio = rs.getDouble("unzipGainRatio");	if (rs.wasNull()) {unzipGainRatio = null;}
				Long unzippedGainBytes = rs.getLong("unzippedGainBytes");	if (rs.wasNull()) {unzippedGainBytes = null;}
				
				String archiveCreationDateStr = rs.getString("archiveCreationDate");
				ZonedDateTime archiveCreationDate = ((archiveCreationDateStr!=null) ? ZonedDateTime.parse(archiveCreationDateStr) : null); 
				String archiveModificationDateStr = rs.getString("archiveModificationDate");
				ZonedDateTime archiveModificationDate = ((archiveModificationDateStr!=null) ? ZonedDateTime.parse(archiveModificationDateStr) : null); 
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeArchive newArchive = new NodeArchive(
						archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName,  
						multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize, 
						unzippedFileSize, unzipGainRatio, unzippedGainBytes, 
						archiveCreationDate,archiveModificationDate,creationDate,modificationDate);
				fileSet.getListArchive().add(newArchive); 
				fileSet.getMapId2Archive().put(newArchive.getArchiveId(),newArchive); 
				cntRead++; 
			}
			System.out.println("readTableArchive: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableContainer(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,\r\n" +
			" containerRemark, cntFile, originalFileSize,creationDate,modificationDate "+
			" FROM FS_CONTAINER WHERE fileSetId = ? ORDER BY containerId"; 
		//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
		//String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
		//Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long containerId = rs.getLong("containerId");	if (rs.wasNull()) {containerId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long containerFileId = rs.getLong("containerFileId");	if (rs.wasNull()) {containerFileId = null;}
				Long containerFileSetId = rs.getLong("containerFileSetId");	if (rs.wasNull()) {containerFileSetId = null;}
				String containerType = rs.getString("containerType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String containerRemark = rs.getString("containerRemark");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeContainer newContainer = new NodeContainer(
						containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,
						containerRemark, cntFile, originalFileSize,creationDate,modificationDate);
				fileSet.getListContainer().add(newContainer); 
				fileSet.getMapId2Container().put(newContainer.getContainerId(),newContainer); 
				cntRead++; 
			}
			System.out.println("readTableContainer: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableTransform(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
			" transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,,\r\n" +
			" transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate,modificationDate "+
			" FROM FS_TRANSFORM WHERE fileSetId = ? ORDER BY transformId"; 
		//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
		//Long transformedFileId, String transformType, String extensionType, String algorithmName,
		//String transformRemark, String tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,
		//transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate
				
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long transformId = rs.getLong("transformId");	if (rs.wasNull()) {transformId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long transformFileId = rs.getLong("transformFileId");	if (rs.wasNull()) {transformFileId = null;}
				Long transformFileSetId = rs.getLong("transformFileSetId");	if (rs.wasNull()) {transformFileSetId = null;}
				Long transformedFileId = rs.getLong("transformedFileId");	if (rs.wasNull()) {transformedFileId = null;}
				String transformType = rs.getString("transformType");
				String extensionType = rs.getString("extensionType");
				String algorithmName = rs.getString("algorithmName");
				String transformRemark = rs.getString("transformRemark");
				String tmpFileName =  rs.getString("tmpFileName");
				Long cntFile = rs.getLong("cntFile");	if (rs.wasNull()) {cntFile = null;}
				Long originalFileSize = rs.getLong("originalFileSize");	if (rs.wasNull()) {originalFileSize = null;}
				Long transformedFileSize = rs.getLong("transformedFileSize");	if (rs.wasNull()) {transformedFileSize = null;}
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeTransform newTransform = new NodeTransform(
						transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,
						transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate);
				fileSet.getListTransform().add(newTransform); 
				fileSet.getMapId2Transform().put(newTransform.getTransformId(),newTransform); 
				cntRead++; 
			}
			System.out.println("readTableTransform: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static NodeFileSet readTableFileSet(Connection conn, long fileSetId)	{ 
		int cntRead = 0; 
		NodeFileSet newFileSet = null;
		String query = 	" SELECT fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,displayOrder,creationDate,modificationDate"+
				" FROM FS_FILESET WHERE fileSetId = ? ORDER BY fileSetId"; 
		//public NodeFileSet(Long fileSetId, Long sourceId, String fileSetName, String fileSetDesc, String fileSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSetId);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				Long fileSetId2 = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId2 = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				String fileSetName = rs.getString("fileSetName");
				String fileSetDesc = rs.getString("fileSetDesc");
				String fileSetURL = rs.getString("fileSetURL");
				String ownerName = rs.getString("ownerName");
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);
				
				newFileSet = new NodeFileSet(
						fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,displayOrder,creationDate,modificationDate);
				cntRead++; 
			}
			System.out.println("readTableFileSet: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(newFileSet); 
	} 
	public static Long getFileSetIdByName(Connection conn, String fileSetName)	{
		Long fileSetId = null;
		String query = 	" SELECT fileSetId FROM FS_FILESET WHERE fileSetName = ? ORDER BY fileSetId"; 
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, fileSetName);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
			}
			System.out.println("getFileSetIdByName: fileSetId = " + fileSetId); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(fileSetId); 	
	}
	//*****************************
	public static NodeFileSet readFileSet(Connection conn, long fileSetId) {
		NodeFileSet fileSet = readTableFileSet(conn, fileSetId);
		if (fileSet==null) return (null);
		int cntReadSimilarity = readTableSimilarity(conn,fileSet);
		int cntReadQuery = readTableQuery(conn,fileSet);
		int cntReadProperty = readTableProperty(conn,fileSet);
		int cntReadHost = readTableHost(conn,fileSet);
		int cntReadHash = readTableHash(conn,fileSet);
		int cntReadFileSystem = readTableFileSystem(conn,fileSet);
		int cntReadFileStore = readTableFileStore(conn,fileSet);
		int cntReadFileBlobSmall = readTableFileBlobSmall(conn,fileSet);
		int cntReadFileBlob = readTableFileBlob(conn,fileSet);
		int cntReadFile = readTableFile(conn,fileSet);
		int cntReadArchive = readTableArchive(conn,fileSet);
		int cntReadContainer = readTableContainer(conn,fileSet);
		int cntReadTransform = readTableTransform(conn,fileSet);
				
		postProcessFileSet(fileSet);
		
		int cntRead = cntReadSimilarity + cntReadQuery + cntReadProperty + cntReadHost + cntReadHash + 
				cntReadFileSystem + cntReadFileStore + cntReadFileBlobSmall + cntReadFileBlob + cntReadFile + 
				cntReadArchive + cntReadContainer + cntReadTransform + 1;
	    System.out.println("readFileSet: total record read = " + cntRead);
		return(fileSet);
	}	
	private static void postProcessFileSet(NodeFileSet fileSet)	{
		for (NodeFileBlob fileBlob : fileSet.getListFileBlob())	{
			if (fileBlob.getFileId()!=null)	{
				NodeFile nodeFile = fileSet.getMapId2File().get(fileBlob.getFileId());
				if (nodeFile!=null)	{ 
					if ("bigfile".equals(fileBlob.getBlobType())) 			nodeFile.getListFileBlobBig().add(fileBlob);
					else if ("regularfile".equals(fileBlob.getBlobType())) 	nodeFile.getListFileBlobRegular().add(fileBlob);
				}
			}
		}
		for (NodeFileBlobSmall fileBlobSmall : fileSet.getListFileBlobSmall())	{
			if (fileBlobSmall.getFileId()!=null)	{
				NodeFile nodeFile = fileSet.getMapId2File().get(fileBlobSmall.getFileId());
				if (nodeFile!=null)	{ nodeFile.getListFileBlobSmall().add(fileBlobSmall);}
			}
		}
		for (NodeSimilarity sim : fileSet.getListSimilarity())	{
			if (sim.getSimilarityKey()!=null)	{
				fileSet.getMapKey2Similarity().put(sim.getSimilarityKey(),sim);
			}
		}
	/*	int cntAddedField=0;
		for (NodeField statField: ai.getListField())	{
			if (statField.getFieldTypeId()==null) continue;
			NodeFieldType fieldType = ai.getMapId2FieldType().get(statField.getFieldTypeId());
			if (fieldType==null) continue;
			fieldType.getListField().add(statField);
			cntAddedField++;
		}
		System.out.println("postProcessAi: total records added to fieldType.getListField()  cntAddedField = " + cntAddedField);
	*/	
	}
	public static NodeFileSet readFileSetTables(Connection conn, long fileSetId)	{ 

		NodeFileSet fileSet = readFileSet(conn,fileSetId); 
		if (fileSet!=null)	{ 
			MakeFileSet.printAllListsAndMaps(fileSet); 
		} else { 
			System.out.println("readFileSetTables: fileSet is null"); 
		}	
		return (fileSet); 
	}
	
}