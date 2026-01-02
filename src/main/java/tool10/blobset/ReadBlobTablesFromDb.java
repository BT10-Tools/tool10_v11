package tool10.blobset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import tool10.blobset.NodeBlob;
import tool10.fileset.nodes.NodeBinary;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileBlobOld;
import tool10.fileset.nodes.NodeFileBlobSmall;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.nodes.NodeQuery;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class ReadBlobTablesFromDb {
	
	public static int readTableFileBlob(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT fileBlobId,fileId,blobId,fileSetId, blobType, blobSize, \r\n" + 
				" fileSize, hashId, blobDbName, blobDbAttachmentName, blobTableName, \r\n" + 
				" bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, creationDate,modificationDate"+
				" FROM FS_FILEBLOB WHERE fileSetId = ? ORDER BY fileBlobId"; 
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long fileBlobId = rs.getLong("fileBlobId");	if (rs.wasNull()) {fileBlobId = null;}
				Long fileId = rs.getLong("fileId");	if (rs.wasNull()) {fileId = null;}
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				String blobType = rs.getString("blobType");
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
				Long fileSize = rs.getLong("fileSize");	if (rs.wasNull()) {fileSize = null;}
				Long hashId = rs.getLong("hashId");	if (rs.wasNull()) {hashId = null;}
				String blobDbName = rs.getString("blobDbName");
				String blobDbAttachmentName = rs.getString("blobDbAttachmentName");
				String blobTableName = rs.getString("blobTableName");
				Long bigPartNumber = rs.getLong("bigPartNumber");	if (rs.wasNull()) {bigPartNumber = null;}
				Long bigCntPart = rs.getLong("bigCntPart");	if (rs.wasNull()) {bigCntPart = null;}
				Long smallByteIndexStart = rs.getLong("smallByteIndexStart");	if (rs.wasNull()) {smallByteIndexStart = null;}
				Long smallByteIndexEnd = rs.getLong("smallByteIndexEnd");	if (rs.wasNull()) {smallByteIndexEnd = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeFileBlob newFileBlob = new NodeFileBlob(
						fileBlobId,fileId,blobId,fileSetId,blobType,blobSize,fileSize, hashId,blobDbName,blobDbAttachmentName,blobTableName,
						bigPartNumber,bigCntPart,smallByteIndexStart,smallByteIndexEnd,creationDate,modificationDate);
				
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
	public static int readTableBlob(Connection conn, NodeFileSet fileSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT blobId,sourceId,fileSetId,firstPartBlobId,partNumber,cntPart,blobType, "+
				" blobSize,compressionType,compressedSize,compressionGainRatio,"+
				" compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,"+
				" encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes,blobHashId,creationDate,modificationDate "+
				" FROM FS_BLOB WHERE fileSetId = ? ORDER BY blobId"; 
		//public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		 		
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, fileSet.getFileSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				Long fileSetId = rs.getLong("fileSetId");	if (rs.wasNull()) {fileSetId = null;}
				Long firstPartBlobId = rs.getLong("firstPartBlobId");	if (rs.wasNull()) {firstPartBlobId = null;}
				Long partNumber = rs.getLong("partNumber");	if (rs.wasNull()) {partNumber = null;}
				Long cntPart = rs.getLong("cntPart");	if (rs.wasNull()) {cntPart = null;}
				String blobType = rs.getString("blobType");
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
				String compressionType = rs.getString("compressionType");
				Long compressedSize = rs.getLong("compressedSize");	if (rs.wasNull()) {compressedSize = null;}
				Double compressionGainRatio = rs.getDouble("compressionGainRatio");	if (rs.wasNull()) {compressionGainRatio = null;}
				Long compressionGainBytes = rs.getLong("compressionGainBytes");	if (rs.wasNull()) {compressionGainBytes = null;}
				Long compressedByteHashId = rs.getLong("compressedByteHashId");	if (rs.wasNull()) {compressedByteHashId = null;}
				Long sandByteLengthHead = rs.getLong("sandByteLengthHead");	if (rs.wasNull()) {sandByteLengthHead = null;}
				Long sandByteLengthTail = rs.getLong("sandByteLengthTail");	if (rs.wasNull()) {sandByteLengthTail = null;}
				String encryptionBlobKey = rs.getString("encryptionBlobKey");
				String encryptionType = rs.getString("encryptionType");
				Long encryptedSize = rs.getLong("encryptedSize");	if (rs.wasNull()) {encryptedSize = null;}
				Long encrytedByteHashId = rs.getLong("encrytedByteHashId");	if (rs.wasNull()) {encrytedByteHashId = null;}
				byte[] blobBytes = rs.getBytes("blobBytes");  	if (rs.wasNull()) {blobBytes = null;}
				byte[] compressedBytes = rs.getBytes("compressedBytes");  	if (rs.wasNull()) {compressedBytes = null;}
				byte[] encryptedBytes = rs.getBytes("encryptedBytes");  	if (rs.wasNull()) {encryptedBytes = null;}
				Long blobHashId = rs.getLong("blobHashId");	if (rs.wasNull()) {blobHashId = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeBlob newBlob = new NodeBlob(
						blobId,sourceId,fileSetId,firstPartBlobId,partNumber,cntPart,blobType,
						blobSize,compressionType,compressedSize,compressionGainRatio,
						compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,
						encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes,blobHashId,creationDate,modificationDate);
				fileSet.getListBlob().add(newBlob); 
				fileSet.getMapId2Blob().put(newBlob.getBlobId(),newBlob); 
				cntRead++; 
			}
			System.out.println("readTableBlob: cntRead = " + cntRead); 
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
		int cntReadQuery = readTableQuery(conn,fileSet);
		int cntReadProperty = readTableProperty(conn,fileSet);
		int cntReadHost = readTableHost(conn,fileSet);
		int cntReadHash = readTableHash(conn,fileSet);
		int cntReadFileSystem = readTableFileSystem(conn,fileSet);
		int cntReadFileStore = readTableFileStore(conn,fileSet);
		int cntReadFileBlob = readTableFileBlob(conn,fileSet);
		int cntReadBlob = readTableBlob(conn,fileSet);
		int cntReadFile = readTableFile(conn,fileSet);
		int cntReadArchive = readTableArchive(conn,fileSet);
		int cntReadContainer = readTableContainer(conn,fileSet);
		int cntReadTransform = readTableTransform(conn,fileSet);
				
		postProcessFileSet(fileSet);
		
		int cntRead = cntReadQuery + cntReadProperty + cntReadHost + cntReadHash + 
				cntReadFileSystem + cntReadFileStore + cntReadFileBlob + cntReadBlob + cntReadFile + 
				cntReadArchive + cntReadContainer + cntReadTransform + 1;
	    System.out.println("readFileSet: total record read = " + cntRead);
		return(fileSet);
	}	
	private static void postProcessFileSet(NodeFileSet fileSet)	{
		GetByMapFileSet.updateAllMapsFileSet(fileSet);
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