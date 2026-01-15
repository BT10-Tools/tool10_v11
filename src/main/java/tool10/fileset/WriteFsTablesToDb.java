package tool10.fileset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class WriteFsTablesToDb {

	public static int writeTableContainer(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_CONTAINER(containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,\r\n" +
						" containerRemark, cntFile, originalFileSize,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?)";
		//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
		//String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
		//Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName, 
		//containerRemark, cntFile, originalFileSize
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeContainer ent : fileSet.getListContainer())	{
			    int cnt=1;
			    if (ent.getContainerId()!=null) {ps.setLong(cnt++, ent.getContainerId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContainerFileId()!=null) {ps.setLong(cnt++, ent.getContainerFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContainerFileSetId()!=null) {ps.setLong(cnt++, ent.getContainerFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getContainerType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getContainerRemark());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableContainer: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTransform(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_TRANSFORM(transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,\r\n" +
				 		" transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate) "+
						" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
		//Long transformedFileId, String transformType, String extensionType, String algorithmName,
		//String transformRemark, tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
				
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTransform ent : fileSet.getListTransform())	{
			    int cnt=1;
			    if (ent.getTransformId()!=null) {ps.setLong(cnt++, ent.getTransformId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformFileId()!=null) {ps.setLong(cnt++, ent.getTransformFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformFileSetId()!=null) {ps.setLong(cnt++, ent.getTransformFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformedFileId()!=null) {ps.setLong(cnt++, ent.getTransformedFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getTransformType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getTransformRemark());
			    ps.setString(cnt++, ent.getTmpFileName());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformedFileSize()!=null) {ps.setLong(cnt++, ent.getTransformedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTransform: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableArchive(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_ARCHIVE(archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, \r\n"
				+ "		multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,\r\n"
				+ "		unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  ?, ?)";
		//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
		//String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
		//Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
		//Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
		//ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, 
		//multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,
		//unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeArchive ent : fileSet.getListArchive())	{
			    int cnt=1;
			    if (ent.getArchiveId()!=null) {ps.setLong(cnt++, ent.getArchiveId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveFileId()!=null) {ps.setLong(cnt++, ent.getArchiveFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveFileSetId()!=null) {ps.setLong(cnt++, ent.getArchiveFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getArchiveType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getMultipleFileArchive());
			    ps.setString(cnt++, ent.getArchiveRemark());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntArchive()!=null) {ps.setLong(cnt++, ent.getCntArchive());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDirectory()!=null) {ps.setLong(cnt++, ent.getCntDirectory());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntFileTree()!=null) {ps.setLong(cnt++, ent.getCntFileTree());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDirectoryTree()!=null) {ps.setLong(cnt++, ent.getCntDirectoryTree());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnzippedFileSize()!=null) {ps.setLong(cnt++, ent.getUnzippedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnzipGainRatio()!=null) {ps.setDouble(cnt++, ent.getUnzipGainRatio());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getUnzippedGainBytes()!=null) {ps.setLong(cnt++, ent.getUnzippedGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveCreationDate()!=null) {ps.setString(cnt++, ent.getArchiveCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getArchiveModificationDate()!=null) {ps.setString(cnt++, ent.getArchiveModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableArchive: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableHash(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_HASH(hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,\r\n"
				+ "		sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,hashStr02,hashStr03,hashStr04,\r\n"
				+ "		hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  "+
				                "?, ?, ?, ?, ?,    ?, ?)";
		//public NodeHash(Long hashId, Long fileSetId, Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeHash ent : fileSet.getListHash())	{
			    int cnt=1;
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc32()!=null) {ps.setLong(cnt++, ent.getCrc32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAdler32()!=null) {ps.setLong(cnt++, ent.getAdler32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlake3());
			    ps.setString(cnt++, ent.getMd5());
			    ps.setString(cnt++, ent.getSha1());
			    ps.setString(cnt++, ent.getSha256());
			    ps.setString(cnt++, ent.getSha384());
			    ps.setString(cnt++, ent.getSha512());
			    ps.setString(cnt++, ent.getSha3256());
			    ps.setString(cnt++, ent.getKeccak256());
			    ps.setString(cnt++, ent.getHashFieldDesc());
			    ps.setString(cnt++, ent.getHashStr01());
			    ps.setString(cnt++, ent.getHashStr02());
			    ps.setString(cnt++, ent.getHashStr03());
			    ps.setString(cnt++, ent.getHashStr04());
			    ps.setString(cnt++, ent.getHashStr05());
			    if (ent.getHashLong01()!=null) {ps.setLong(cnt++, ent.getHashLong01());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong02()!=null) {ps.setLong(cnt++, ent.getHashLong02());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong03()!=null) {ps.setLong(cnt++, ent.getHashLong03());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong04()!=null) {ps.setLong(cnt++, ent.getHashLong04());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong05()!=null) {ps.setLong(cnt++, ent.getHashLong05());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableHash: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableProperty(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_PROPERTY (propertyId, fileSetId, entityId, displayOrder, mapName, entityName, propertyKey, propertyValue, \r\n"
				+ "			valueString, valueLong,valueDouble, valueBinary, valueZDT,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
		//String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
		//Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeProperty ent : fileSet.getListProperty())	{
			    int cnt=1;
			    if (ent.getPropertyId()!=null) {ps.setLong(cnt++, ent.getPropertyId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getMapName());
			    ps.setString(cnt++, ent.getEntityName());
			    ps.setString(cnt++, ent.getPropertyKey());
			    ps.setString(cnt++, ent.getPropertyValue());
			    ps.setString(cnt++, ent.getValueString());
			    if (ent.getValueLong()!=null) {ps.setLong(cnt++, ent.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDouble()!=null) {ps.setDouble(cnt++, ent.getValueDouble());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getValueBinary()!=null) {ps.setBytes(cnt++, ent.getValueBinary().getByteArray());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getValueZDT()!=null) {ps.setString(cnt++, ent.getValueZDT().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableProperty: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileBlob(Connection conn, ArrayList<NodeFileBlob> listFileBlob)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEBLOB (fileBlobId,fileId,blobEntityId,fileSetId, blobType, blobSize, \r\n"+
						"fileSize, hashId, blobDbName, blobDbAttachmentName, blobTableName, \r\n" +
				 		"bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, \r\n"+
				 		"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobEntityId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileBlob ent : listFileBlob)	{
			    int cnt=1;
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobEntityId()!=null) {ps.setLong(cnt++, ent.getBlobEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobDbName());
			    ps.setString(cnt++, ent.getBlobDbAttachmentName());
			    ps.setString(cnt++, ent.getBlobTableName());
			    
			    if (ent.getBigPartNumber()!=null) {ps.setLong(cnt++, ent.getBigPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBigCntPart()!=null) {ps.setDouble(cnt++, ent.getBigCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexStart()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexStart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexEnd()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexEnd());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableFileBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileSystem(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILESYSTEM(fileSystemId, fileSetId, hostId, rootFileId, displayOrder, systemName, providerName, providerHashCode, "+
						"isOpen, isReadOnly, creationDate, modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileSystem(Long fileSystemId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder,
		//String systemName, String providerName, Long providerHashCode, String isOpen, String isReadOnly,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileSystem ent : fileSet.getListFileSystem())	{
			    int cnt=1;
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getHostId()!=null) {ps.setLong(cnt++, ent.getHostId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSystemName());
			    ps.setString(cnt++, ent.getProviderName());
			    if (ent.getProviderHashCode()!=null) {ps.setLong(cnt++, ent.getProviderHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getIsOpen());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileSystem: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableFileStore(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILESTORE (fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,hashCode, "+
						"rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeFileStore(Long fileStoreId, Long fileSetId, Long fileSystemId, Long rootFileId, Long displayOrder, Long blockSize,
		//Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
		//String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileStore ent : fileSet.getListFileStore())	{
			    int cnt=1;
			    if (ent.getFileStoreId()!=null) {ps.setLong(cnt++, ent.getFileStoreId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlockSize()!=null) {ps.setLong(cnt++, ent.getBlockSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTotalSpace()!=null) {ps.setLong(cnt++, ent.getTotalSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnallocatedSpace()!=null) {ps.setLong(cnt++, ent.getUnallocatedSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUsableSpace()!=null) {ps.setLong(cnt++, ent.getUsableSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUsedSpace()!=null) {ps.setLong(cnt++, ent.getUsedSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashCode()!=null) {ps.setLong(cnt++, ent.getHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getRootDirectoryName());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    ps.setString(cnt++, ent.getNameStr());
			    ps.setString(cnt++, ent.getToString());
			    ps.setString(cnt++, ent.getTypeStr());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileStore: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFile(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILE (fileId,fileSetId,parentFileId,rootFileId,fileTypeId,sourceId,fileSize,hashCode,hashId, \n"+
				"fileType,linkedId,fileStatus,fileName,fileNameAbsolute,extensionName,isDirectory,isFile,fileRemark,creationDate,modificationDate) \n"+
				"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?) \n";
		//public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileTypeId, Long sourceId,
		//		Long fileSize, Long hashCode, Long hashId, String fileType, Long linkedId, String fileStatus,
		//		String fileName, String fileNameAbsolute, String extensionName, String isDirectory, String isFile,
		//		String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFile ent : fileSet.getListFile())	{
			    int cnt=1;
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getParentFileId()!=null) {ps.setLong(cnt++, ent.getParentFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileTypeId()!=null) {ps.setLong(cnt++, ent.getFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashCode()!=null) {ps.setLong(cnt++, ent.getHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileType());
			    if (ent.getLinkedId()!=null) {ps.setLong(cnt++, ent.getLinkedId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileStatus());
			    ps.setString(cnt++, ent.getFileName());
			    ps.setString(cnt++, ent.getFileNameAbsolute());
			    ps.setString(cnt++, ent.getExtensionName());
			    ps.setString(cnt++, ent.getIsDirectory());
			    ps.setString(cnt++, ent.getIsFile());
			    ps.setString(cnt++, ent.getFileRemark());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileName(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILENAME ("+
			"fileNameId,fileId,fileSetId,fileNameTypeId,nameLanguageId,nameLanguageId2,nameHashId,depth,depthFromRoot,fileName,\r\n"+
			"fileNameRelative,fileNameAbsolute,fileNameCanonical,fileURI,fileURL,extensionName,nameWithoutExtension,dirNameRelative,dirNameAbsolute,\r\n"+
			"fileNameLength,fileNameAbsoluteLength,compressedNameSize,fileName83,altName1,altName2,altName3,altNameFromTag,altNameFromContent,\r\n"+
			"onlyAsciiLetter,onlyDigit,onlyUTFLetter,sortedLetters,sortedLettersUnique,encryptedNameRelative,encryptedNameAbsolute,isNameValid,\r\n"+
			"validityRemark,isNameCorrect,correctedName,correctnessRemark,goodnessLevel,goodnessRemark,goodNameSuggested,isHumanGiven,\r\n"+
			"isGenerated,isHumanUnderstandable,nameEncoding,nameCharsetStr,nameRemark,strEntityType,strEntityStr,strEntityId,strEntityType2,\r\n"+
			"strEntityStr2,strEntityId2,cntLetter,cntLetterUnique,cntAsciiLetter,cntAsciiLetterUppercase,cntAsciiLetterLowercase,cntAsciiUnprintable,cntNonAscii,\r\n"+
			"cntUTFLetter,cntUTFLetterByte1,cntUTFLetterByte2,cntUTFLetterByte3,cntUTFLetterByte4,cntEmoji,cntDigit,cntDigitUnique,cntSpace,\r\n"+
			"cntUnderscore,cntDash,parsedNum,parsedZDT,tokenizedName,\r\n"+
			"arrayToken,arrayLetter,arrayLetterCnt,arrayTokenId,creationDate,modificationDate) \r\n"+
			" VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
					 "?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
					 "?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
					 "?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
		//Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
		//String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
		//String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
		//Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
		//String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
		
		//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
		//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
		//String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
		//String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
		//String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
		//String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
		//String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
		
		//Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
		//Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
		//Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
		//Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
		//String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileName ent : fileSet.getListFileName())	{
			    int cnt=1;
			    if (ent.getFileNameId()!=null) {ps.setLong(cnt++, ent.getFileNameId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileNameTypeId()!=null) {ps.setLong(cnt++, ent.getFileNameTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNameLanguageId()!=null) {ps.setLong(cnt++, ent.getNameLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNameLanguageId2()!=null) {ps.setLong(cnt++, ent.getNameLanguageId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNameHashId()!=null) {ps.setLong(cnt++, ent.getNameHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDepth()!=null) {ps.setLong(cnt++, ent.getDepth());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDepthFromRoot()!=null) {ps.setLong(cnt++, ent.getDepthFromRoot());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileName());
			    
			    ps.setString(cnt++, ent.getFileNameRelative());
			    ps.setString(cnt++, ent.getFileNameAbsolute());
			    ps.setString(cnt++, ent.getFileNameCanonical());
			    ps.setString(cnt++, ent.getFileURI());
			    ps.setString(cnt++, ent.getFileURL());
			    ps.setString(cnt++, ent.getExtensionName());
			    ps.setString(cnt++, ent.getNameWithoutExtension());
			    ps.setString(cnt++, ent.getDirNameRelative());
			    ps.setString(cnt++, ent.getDirNameAbsolute());
			    
			    if (ent.getFileNameLength()!=null) {ps.setLong(cnt++, ent.getFileNameLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileNameAbsoluteLength()!=null) {ps.setLong(cnt++, ent.getFileNameAbsoluteLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressedNameSize()!=null) {ps.setLong(cnt++, ent.getCompressedNameSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileName83());
			    ps.setString(cnt++, ent.getAltName1());
			    ps.setString(cnt++, ent.getAltName2());
			    ps.setString(cnt++, ent.getAltName3());
			    ps.setString(cnt++, ent.getAltNameFromTag());
			    ps.setString(cnt++, ent.getAltNameFromContent());
	    
		//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
		//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
		//String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
		//String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
		//String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
		//String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
		//String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
				    
			    ps.setString(cnt++, ent.getOnlyAsciiLetter());
			    ps.setString(cnt++, ent.getOnlyDigit());
			    ps.setString(cnt++, ent.getOnlyUTFLetter());
			    ps.setString(cnt++, ent.getSortedLetters());
			    ps.setString(cnt++, ent.getSortedLettersUnique());
			    ps.setString(cnt++, ent.getEncryptedNameRelative());
			    ps.setString(cnt++, ent.getEncryptedNameAbsolute());
			    ps.setString(cnt++, ent.getIsNameValid());
			    
			    ps.setString(cnt++, ent.getValidityRemark());
			    ps.setString(cnt++, ent.getIsNameCorrect());
			    ps.setString(cnt++, ent.getCorrectedName());
			    ps.setString(cnt++, ent.getCorrectnessRemark());
			    ps.setString(cnt++, ent.getGoodnessLevel());
			    ps.setString(cnt++, ent.getGoodnessRemark());
			    ps.setString(cnt++, ent.getGoodNameSuggested());
			    ps.setString(cnt++, ent.getIsHumanGiven());

			    ps.setString(cnt++, ent.getIsGenerated());
			    ps.setString(cnt++, ent.getIsHumanUnderstandable());
			    ps.setString(cnt++, ent.getNameEncoding());
			    ps.setString(cnt++, ent.getNameCharsetStr());
			    ps.setString(cnt++, ent.getNameRemark());
			    ps.setString(cnt++, ent.getStrEntityType());
			    ps.setString(cnt++, ent.getStrEntityStr());
			    if (ent.getStrEntityId()!=null) {ps.setLong(cnt++, ent.getStrEntityId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getStrEntityType2());
	    
			    ps.setString(cnt++, ent.getStrEntityStr2());
			    if (ent.getStrEntityId2()!=null) {ps.setLong(cnt++, ent.getStrEntityId2());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntLetter()!=null) {ps.setLong(cnt++, ent.getStrEntityId2());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntLetterUnique()!=null) {ps.setLong(cnt++, ent.getCntLetterUnique());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntAsciiLetter()!=null) {ps.setLong(cnt++, ent.getCntAsciiLetter());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    
	    //Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
		//Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
		//Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
		//Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
		//String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {		    
			    
			    if (ent.getCntAsciiLetterUppercase()!=null) {ps.setLong(cnt++, ent.getCntAsciiLetterUppercase());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntAsciiLetterLowercase()!=null) {ps.setLong(cnt++, ent.getCntAsciiLetterLowercase());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntAsciiUnprintable()!=null) {ps.setLong(cnt++, ent.getCntAsciiUnprintable());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntNonAscii()!=null) {ps.setLong(cnt++, ent.getCntNonAscii());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    
			    if (ent.getCntUTFLetter()!=null) {ps.setLong(cnt++, ent.getCntUTFLetter());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntUTFLetterByte1()!=null) {ps.setLong(cnt++, ent.getCntUTFLetterByte1());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntUTFLetterByte2()!=null) {ps.setLong(cnt++, ent.getCntUTFLetterByte2());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntUTFLetterByte3()!=null) {ps.setLong(cnt++, ent.getCntUTFLetterByte3());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    
			    if (ent.getCntUTFLetterByte4()!=null) {ps.setLong(cnt++, ent.getCntUTFLetterByte4());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntEmoji()!=null) {ps.setLong(cnt++, ent.getCntEmoji());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntDigit()!=null) {ps.setLong(cnt++, ent.getCntDigit());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntDigitUnique()!=null) {ps.setLong(cnt++, ent.getCntDigitUnique());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntSpace()!=null) {ps.setLong(cnt++, ent.getCntSpace());} else {ps.setNull(cnt++,Types.INTEGER);} 
				
			    if (ent.getCntUnderscore()!=null) {ps.setLong(cnt++, ent.getCntUnderscore());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntDash()!=null) {ps.setLong(cnt++, ent.getCntDash());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getParsedNum()!=null) {ps.setLong(cnt++, ent.getParsedNum());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getParsedZDT()!=null) {ps.setString(cnt++, ent.getParsedZDT().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    ps.setString(cnt++, ent.getTokenizedName());
			    
			    if (ent.getArrayToken()!=null) {ps.setBytes(cnt++, null);} else {ps.setNull(cnt++,Types.BLOB);} 
			    if (ent.getArrayLetter()!=null) {ps.setBytes(cnt++, null);} else {ps.setNull(cnt++,Types.BLOB);} 
			    if (ent.getArrayLetterCnt()!=null) {ps.setBytes(cnt++, null);} else {ps.setNull(cnt++,Types.BLOB);} 
			    if (ent.getArrayTokenId()!=null) {ps.setBytes(cnt++, null);} else {ps.setNull(cnt++,Types.BLOB);} 
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileName: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileProp(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEPROP (\r\n"+
		"filePropId,fileId,fileSetId,fileSystemId,fileStoreId,propertyType,signatureId,fileSize,fileSizeOnDisk,fileSizeClass,\r\n"+
		"hashCode,fileType,linkType,linkedId,ownerName,computerName,canExecute,canRead,canWrite,isExists,isDirectory,isFile,\r\n"+
		"isSymbolicLink,isHidden,isArchive,isSystem,isReadOnly,isOther,isRegularFile,probeContentType,isCompressed,isEncrypted,\r\n"+
		"isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,\r\n"+
		"isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,\r\n"+
		"compressedFileSize,compressionGainRatio,compressionGainBytes,duration,contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,\r\n"+
		"iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,lastModified,fileCreationDate,fileModificationDate,\r\n"+
		"fileLastAccessTime,fileRemark,creationDate,modificationDate) \r\n"+
		" VALUES( 	?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
				   "?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
				   "?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ? )";
		//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
		//String propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
		//Long hashCode, String fileType, String linkType, Long linkedId, String ownerName, String computerName,
		//String canExecute, String canRead, String canWrite, String isExists, String isDirectory, String isFile,
		//String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
		//String isOther, String isRegularFile, String probeContentType, String isCompresssed, String isEncrypted,
		//String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
		//String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
		//String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
		//String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
		//Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
		//Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
		//String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
		//Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
		//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		
	/*	"filePropId,fileId,fileSetId,fileSystemId,fileStoreId,filePropertyTypeId,signatureId,fileSize,fileSizeOnDisk,fileSizeClass,\r\n"+
		"hashCode,fileType,linkType,linkedId,ownerName,computerName,canExecute,canRead,canWrite,isExists,isDirectory,isFile,\r\n"+
		"isSymbolicLink,isHidden,isArchive,isSystem,isReadOnly,isOther,isRegularFile,probeContentType,isCompresssed,isEncrypted,\r\n"+
		"isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,\r\n"+
		"isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,\r\n"+
		"compressedFileSize,compressionGainRatio,compressionGainBytes,duration,contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,\r\n"+
		"iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,lastModified,fileCreationDate,fileModificationDate,\r\n"+
		"fileLastAccessTime,fileRemark,creationDate,modificationDate \r\n"+
	*/	
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileProp ent : fileSet.getListFileProp())	{
			    int cnt=1;
			    if (ent.getFilePropId()!=null) {ps.setLong(cnt++, ent.getFilePropId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileStoreId()!=null) {ps.setLong(cnt++, ent.getFileStoreId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getPropertyType());
			    if (ent.getSignatureId()!=null) {ps.setLong(cnt++, ent.getSignatureId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSizeOnDisk()!=null) {ps.setLong(cnt++, ent.getFileSizeOnDisk());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileSizeClass());
				
			    if (ent.getHashCode()!=null) {ps.setLong(cnt++, ent.getHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileType());
			    ps.setString(cnt++, ent.getLinkType());
			    if (ent.getLinkedId()!=null) {ps.setLong(cnt++, ent.getLinkedId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getOwnerName());
			    ps.setString(cnt++, ent.getComputerName());
			    ps.setString(cnt++, ent.getCanExecute());
			    ps.setString(cnt++, ent.getCanRead());
			    ps.setString(cnt++, ent.getCanWrite());
			    ps.setString(cnt++, ent.getIsExists());
			    ps.setString(cnt++, ent.getIsDirectory());
			    ps.setString(cnt++, ent.getIsFile());
			     
			    ps.setString(cnt++, ent.getIsSymbolicLink());
			    ps.setString(cnt++, ent.getIsHidden());
			    ps.setString(cnt++, ent.getIsArchive());
			    ps.setString(cnt++, ent.getIsSystem());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    ps.setString(cnt++, ent.getIsOther());
			    ps.setString(cnt++, ent.getIsRegularFile());
			    ps.setString(cnt++, ent.getProbeContentType());
			    ps.setString(cnt++, ent.getIsCompressed());
			    ps.setString(cnt++, ent.getIsEncrypted());
	
		//"isIndexed,isContentIndexed,isBlocked,isSystemFile,isAppFile,isCompanyFile,isUserFile,isExecutable,isTextFile,isXMLFile,\r\n"+
		//"isConfigFile,isBinaryFile,isImmutable,isInUserPath,isInSystemPath,isShareable,isShared,hasPreviousVersions,uxPermission,uxInfo,\r\n"+
		//"compressedFileSize,compressionGainRatio,compressionGainBytes,duration,contentLanguageId,contentLanguageId2,contentEncoding,contentCharsetStr,\r\n"+
					    
			    ps.setString(cnt++, ent.getIsIndexed());
			    ps.setString(cnt++, ent.getIsContentIndexed());
			    ps.setString(cnt++, ent.getIsBlocked());
			    ps.setString(cnt++, ent.getIsSystemFile());
			    ps.setString(cnt++, ent.getIsAppFile());
			    ps.setString(cnt++, ent.getIsCompanyFile());
			    ps.setString(cnt++, ent.getIsUserFile());
			    ps.setString(cnt++, ent.getIsExecutable());
			    ps.setString(cnt++, ent.getIsTextFile());
			    ps.setString(cnt++, ent.getIsXMLFile());
			    
			    ps.setString(cnt++, ent.getIsConfigFile());
			    ps.setString(cnt++, ent.getIsBinaryFile());
			    ps.setString(cnt++, ent.getIsImmutable());
			    ps.setString(cnt++, ent.getIsInUserPath());
			    ps.setString(cnt++, ent.getIsInSystemPath());
			    ps.setString(cnt++, ent.getIsShareable());
			    ps.setString(cnt++, ent.getIsShared());
			    ps.setString(cnt++, ent.getHasPreviousVersions());
			    ps.setString(cnt++, ent.getUxPermission());
			    ps.setString(cnt++, ent.getUxInfo());
			    
			    if (ent.getCompressedFileSize()!=null) {ps.setLong(cnt++, ent.getCompressedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainRatio()!=null) {ps.setDouble(cnt++, ent.getCompressionGainRatio());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainBytes()!=null) {ps.setLong(cnt++, ent.getCompressionGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDuration()!=null) {ps.setLong(cnt++, ent.getDuration());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContentLanguageId()!=null) {ps.setLong(cnt++, ent.getContentLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContentLanguageId2()!=null) {ps.setLong(cnt++, ent.getContentLanguageId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getContentEncoding());
			    ps.setString(cnt++, ent.getContentCharsetStr());
		
	    //"iconName,origin,copyrightInfo,licenseInfo,assetInfo,dlpInfo,lastModified,fileCreationDate,fileModificationDate,\r\n"+
		//"fileLastAccessTime,fileRemark,creationDate,modificationDate \r\n"+
			    ps.setString(cnt++, ent.getIconName());
			    ps.setString(cnt++, ent.getOrigin());
			    ps.setString(cnt++, ent.getCopyrightInfo());
			    ps.setString(cnt++, ent.getLicenseInfo());
			    ps.setString(cnt++, ent.getAssetInfo());
			    ps.setString(cnt++, ent.getDlpInfo());
			    if (ent.getLastModified()!=null) {ps.setLong(cnt++, ent.getLastModified());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileCreationDate()!=null) {ps.setString(cnt++, ent.getFileCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getFileModificationDate()!=null) {ps.setString(cnt++, ent.getFileModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    
			    if (ent.getFileLastAccessTime()!=null) {ps.setString(cnt++, ent.getFileLastAccessTime().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    ps.setString(cnt++, ent.getFileRemark());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileProperty: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileSet(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO FS_FILESET (fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?, ?)";
		//String fieldStr = "fileSetId INTEGER,sourceId INTEGER,fileSetName TEXT,fileSetDesc TEXT,fileSetURL TEXT,ownerName TEXT, creationDate TEXT, modificationDate TEXT";
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (fileSet.getFileSetId()!=null) {ps.setLong(cnt++, fileSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    if (fileSet.getSourceId()!=null) {ps.setLong(cnt++, fileSet.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    ps.setString(cnt++, fileSet.getFileSetName());
		    ps.setString(cnt++, fileSet.getFileSetDesc());
		    ps.setString(cnt++, fileSet.getFileSetURL());
		    ps.setString(cnt++, fileSet.getOwnerName());
		    if (fileSet.getCreationDate()!=null) 	{ps.setString(cnt++, fileSet.getCreationDate().toString()); } 		else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (fileSet.getModificationDate()!=null) {ps.setString(cnt++, fileSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableFileSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeFileSet(Connection conn,  NodeFileSet fileSet)	{
		int cntInsertedFileSet = writeTableFileSet(conn,fileSet);
		int cntInsertedFile = writeTableFile(conn,fileSet);
		int cntInsertedFileName = writeTableFileName(conn,fileSet);
		int cntInsertedFileProp = writeTableFileProp(conn,fileSet);
		int cntInsertedFileSystem = writeTableFileSystem(conn,fileSet);
		int cntInsertedFileStore = writeTableFileStore(conn,fileSet);
		int cntInsertedFileBlob = writeTableFileBlob(conn,fileSet.getListFileBlob()); 
		int cntInsertedProperty = writeTableProperty(conn,fileSet); 
		int cntInsertedHash = writeTableHash(conn,fileSet);
		int cntInsertedArchive = writeTableArchive(conn,fileSet);
		int cntInsertedContainer = writeTableContainer(conn,fileSet);
		int cntInsertedTransform = writeTableTransform(conn,fileSet);
		
		int cntInserted = cntInsertedFileSet + cntInsertedFile + cntInsertedFileName + cntInsertedFileProp + cntInsertedFileSystem + 
				cntInsertedFileStore + cntInsertedFileBlob + cntInsertedProperty + cntInsertedHash + 
				cntInsertedArchive + cntInsertedContainer + cntInsertedTransform; //+ ctInsertedToken + 
		return(cntInserted);
	}	
	public static int writeBlob(Connection conn,  NodeFileSet fileSet)	{
		int ctInsertedFileBlob = writeTableFileBlob(conn,fileSet.getListFileBlob()); 
		int cntInserted = ctInsertedFileBlob ;
		return(cntInserted);
	}
	public static void writeFileSetTables(Connection conn, NodeFileSet fileSet)	{
		writeFileSet(conn,fileSet);
	}
	
}