package tool10.blobset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import tool10.blobset.NodeBlob;
import tool10.fileset.nodes.NodeBinary;
import tool10.fileset.nodes.NodeFileSet;

public class ReadBlobTablesFromDb {
	
	public static int readTableBlobEntity(Connection conn, NodeBlobSet blobSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT blobEntityId,entityId,blobId,blobSetId, blobType, blobSize, \r\n" + 
				" sourceSize, hashId, blobDbName, blobDbAttachmentName, blobTableName, \r\n" + 
				" bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, creationDate,modificationDate"+
				" FROM FS_FILEBLOB WHERE blobSetId = ? ORDER BY fileBlobId"; 
		//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
		//Long sourceSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, blobSet.getBlobSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long blobEntityId = rs.getLong("blobEntityId");	if (rs.wasNull()) {blobEntityId = null;}
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long blobSetId = rs.getLong("blobSetId");	if (rs.wasNull()) {blobSetId = null;}
				String blobType = rs.getString("blobType");
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
				Long sourceSize = rs.getLong("sourceSize");	if (rs.wasNull()) {sourceSize = null;}
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
				NodeBlobEntity newBlobEntity = new NodeBlobEntity(
						blobEntityId,entityId,blobId,blobSetId,blobType,blobSize,sourceSize, hashId,blobDbName,blobDbAttachmentName,blobTableName,
						bigPartNumber,bigCntPart,smallByteIndexStart,smallByteIndexEnd,creationDate,modificationDate);
				blobSet.getListBlobEntity().add(newBlobEntity); 
				blobSet.getMapId2BlobEntity().put(newBlobEntity.getBlobEntityId(),newBlobEntity);
				cntRead++; 
			}
			System.out.println("readTableBlobEntity: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	}
	public static int readTableBlob(Connection conn, NodeBlobSet blobSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT blobId,sourceId,blobSetId,firstPartBlobId,partNumber,cntPart,blobType, "+
				" blobSize,compressionType,compressedSize,compressionGainRatio,"+
				" compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,"+
				" encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes,blobHashId,creationDate,modificationDate "+
				" FROM BLOB_BLOB WHERE blobSetId = ? ORDER BY blobId"; 
		//public NodeBlob(Long blobId, Long sourceId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {		 		
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, blobSet.getBlobSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				Long blobSetId = rs.getLong("blobSetId");	if (rs.wasNull()) {blobSetId = null;}
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
						blobId,sourceId,blobSetId,firstPartBlobId,partNumber,cntPart,blobType,
						blobSize,compressionType,compressedSize,compressionGainRatio,
						compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,
						encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes,blobHashId,creationDate,modificationDate);
				blobSet.getListBlob().add(newBlob); 
				blobSet.getMapId2Blob().put(newBlob.getBlobId(),newBlob); 
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
	public static int readTableBlobHash(Connection conn, NodeBlobSet blobSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT blobHashId,blobId,blobEntityId,blobSetId,blobSize,crc64,crc32,adler32,blake3,md5,"+
			" sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,"+
			" hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate"+
			" FROM BLOB_BLOBHASH WHERE blobSetId = ? ORDER BY blobHashId"; 
		//public NodeBlobHash(Long blobHashId, Long blobId, Long blobEntityId, Long blobSetId, Long blobSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {		
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, blobSet.getBlobSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long blobHashId = rs.getLong("blobHashId");	if (rs.wasNull()) {blobHashId = null;}
				Long blobId = rs.getLong("blobId");	if (rs.wasNull()) {blobId = null;}
				Long blobEntityId = rs.getLong("blobEntityId");	if (rs.wasNull()) {blobEntityId = null;}
				Long blobSetId = rs.getLong("blobSetId");	if (rs.wasNull()) {blobSetId = null;}
				Long blobSize = rs.getLong("blobSize");	if (rs.wasNull()) {blobSize = null;}
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
				NodeBlobHash newBlobHash = new NodeBlobHash(
						blobHashId,blobId,blobEntityId,blobSetId,blobSize,crc64,crc32,adler32,blake3,md5,sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,
						hashStr02,hashStr03,hashStr04,hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate);
				blobSet.getListBlobHash().add(newBlobHash); 
				blobSet.getMapId2BlobHash().put(newBlobHash.getBlobHashId(),newBlobHash); 
				cntRead++; 
			}
			System.out.println("readTableBlobHash: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static NodeBlobSet readTableBlobSet(Connection conn, long blobSetId)	{ 
		int cntRead = 0; 
		NodeBlobSet newBlobSet = null;
		String query = 	" SELECT blobSetId,sourceId,blobSetName,blobSetDesc,blobSetURL,ownerName,displayOrder,creationDate,modificationDate"+
				" FROM BLOB_BLOBSET WHERE blobSetId = ? ORDER BY blobSetId"; 
		//public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, blobSetId);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				Long blobSetId2 = rs.getLong("blobSetId");	if (rs.wasNull()) {blobSetId2 = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				String blobSetName = rs.getString("blobSetName");
				String blobSetDesc = rs.getString("blobSetDesc");
				String blobSetURL = rs.getString("blobSetURL");
				String ownerName = rs.getString("ownerName");
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);
				
				newBlobSet = new NodeBlobSet(
						blobSetId,sourceId,blobSetName,blobSetDesc,blobSetURL,ownerName,displayOrder,creationDate,modificationDate);
				cntRead++; 
			}
			System.out.println("readTableBlobSet: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(newBlobSet); 
	} 
	public static Long getBlobSetIdByName(Connection conn, String blobSetName)	{
		Long blobSetId = null;
		String query = 	" SELECT blobSetId FROM BLOB_BLOBSET WHERE blobSetName = ? ORDER BY blobSetId"; 
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, blobSetName);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				blobSetId = rs.getLong("blobSetId");	if (rs.wasNull()) {blobSetId = null;}
			}
			System.out.println("getBlobSetIdByName: blobSetId = " + blobSetId); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(blobSetId); 	
	}
	//*****************************
	public static NodeBlobSet readBlobSet(Connection conn, long blobSetId) {
		NodeBlobSet blobSet = readTableBlobSet(conn, blobSetId);
		if (blobSet==null) return (null);
		int cntReadBlobHash = readTableBlobHash(conn,blobSet);
		int cntReadBlobEntity = readTableBlobEntity(conn,blobSet);
		int cntReadBlob = readTableBlob(conn,blobSet);
				
		postProcessBlobSet(blobSet);
		
		int cntRead = cntReadBlobHash + cntReadBlobEntity + cntReadBlob + 1;
	    System.out.println("readBlobSet: total record read = " + cntRead);
		return(blobSet);
	}	
	private static void postProcessBlobSet(NodeBlobSet blobSet)	{
		GetByMapBlobSet.updateAllMapsBlobSet(blobSet);
	}
	public static void printAllListsAndMaps(NodeBlobSet blobSet)	{
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListBlobEntity().size() = " + blobSet.getListBlobEntity().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListBlob().size() = " + blobSet.getListBlob().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListBlobHash().size() = " + blobSet.getListBlobHash().size());
							
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2BlobEntity().size() = " + blobSet.getMapId2BlobEntity().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2Blob().size() = " + blobSet.getMapId2Blob().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2BlobHash().size() = " + blobSet.getMapId2BlobHash().size());
									
		/*
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListRoots().size() = " + fileSet.getListRoots().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapAbsoluteFileName2File().size() = " + fileSet.getMapAbsoluteFileName2File().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapRawFileSystem2FileSystem().size() = " + fileSet.getMapRawFileSystem2FileSystem().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapRawFileStore2FileStore().size() = " + fileSet.getMapRawFileStore2FileStore().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapCrc2NodeHash().size() = " + fileSet.getMapCrc2NodeHash().size());
		*/				
	}
	public static NodeBlobSet readBlobSetTables(Connection conn, long blobSetId)	{ 

		NodeBlobSet blobSet = readBlobSet(conn,blobSetId); 
		if (blobSet!=null)	{ 
			printAllListsAndMaps(blobSet); 
		} else { 
			System.out.println("readBlobSetTables: readBlobSetTables is null"); 
		}	
		return (blobSet); 
	}
	
}