package tool10.blobset;

import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeHash;
import tool10.sql.Conn10;
import tool10.util.Blake3;
import tool10.util.UtilCRC32;

public class MakeFileSetHash {
	

	public static NodeHash createOneHashForBigFile(NodeF10 f10, Long fileSize, byte[] smallFileBytes)	{
		//it is used the same bigFile method
		//called from MakeFileSetBlob.createFileBlobsBig
		return(createOneHashForSmallFile(f10, fileSize, smallFileBytes));
	}
	public static NodeHash createOneHashForRegularFile(NodeF10 f10, Long fileSize, byte[] smallFileBytes)	{
		//it is used the same smallFile method
		//called from MakeFileSetBlob.createFileBlobsRegular
		return(createOneHashForSmallFile(f10, fileSize, smallFileBytes));
	}
	public static NodeHash createOneHashForSmallFile(NodeF10 f10, Long fileSize, byte[] smallFileBytes)	{
		//called from MakeFileSetBlobSmall.createFileBlobsSmall(conn10, fileSet, 0)
		NodeHash nodeHash = null;
		Long crc32 = UtilCRC32.getBytesCRC32(smallFileBytes);
		NodeHash foundHash = f10.getFileSet().getMapCrc2NodeHash().get(crc32);
		if (foundHash!=null)	{
			if ((fileSize!=null) && (foundHash.getFileSize()!=null) && (fileSize.longValue()==foundHash.getFileSize().longValue()))	{
				String blake3a = Blake3.getBlake3HashForBytes(smallFileBytes);
				if (blake3a.equals(foundHash.getBlake3()))	{
					return(foundHash);
				}
			}
		}
		Long crc64 = null;
		Long adler32 = UtilCRC32.getBytesAdler32(smallFileBytes);
		String blake3 = Blake3.getBlake3HashForBytes(smallFileBytes);
		String md5 = UtilCRC32.getBytesMd5(smallFileBytes);
		String sha1 = UtilCRC32.getBytesSHA1(smallFileBytes);
		String sha256 = UtilCRC32.getBytesSHA256(smallFileBytes);
		String sha384 = UtilCRC32.getBytesSHA384(smallFileBytes);
		String sha512 = UtilCRC32.getBytesSHA512(smallFileBytes);
		String sha3256 = UtilCRC32.getBytesSHA3_256(smallFileBytes);
		String keccak256 = UtilCRC32.getBytesKeccak256(smallFileBytes);
		
		nodeHash = MakeBlobSetTables.createOneHash(f10, fileSize, crc64, crc32, adler32,blake3,md5,
				sha1, sha256, sha384, sha512, sha3256, keccak256);
		return(nodeHash);
	}
	private static void createHashes(NodeF10 f10)	{
		for (NodeFile file : f10.getFileSet().getListFile() )	{
			
			//NodeHash newHash = createOneHashForFile(conn10,fileSet);
		}	
	}
	private static Long getDirHashFromList(ArrayList<Long> hashList)	{
		Long hashValue = null;
		try {
			ByteBuffer buf = ByteBuffer.allocate(Long.BYTES * hashList.size());  //Long.BYTES 8 bytes for long
			for (Long hash : hashList)	{
				long hashVal = hash.longValue();
				byte[] bytes = new byte[Long.BYTES];
				int length = bytes.length;
				for (int i = 0; i < length; i++) {
				    bytes[length - i - 1] = (byte) (hashVal & 0xFF);
				    hashVal >>= 8;
				}
				buf.put(bytes);
			}
			buf.rewind();
			byte[] bufBytes = buf.array();
			hashValue = UtilCRC32.getBytesCRC32(bufBytes);
			return(hashValue);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException caught");
		} catch (ReadOnlyBufferException e) {
			System.out.println(	"ReadOnlyBufferException caught");
		}

		return(hashValue);
	}
	private static Long createOneDirectoryHash(NodeF10 f10, NodeFile nodeFile)	{
		Long dirHash = null;
		ArrayList<Long> hashList = new ArrayList<Long>();
		//first the directories
		for (NodeFile oneDir : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneDir.getIsDirectory())) continue;  //it is not a directory
			Long oneDirHash = createOneDirectoryHash(f10, oneDir);
			hashList.add(oneDirHash);
			//NodeHash newHash = createOneHashForFile(conn10,fileSet);
		}
		//second the files
		for (NodeFile oneFile : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneFile.getIsFile())) continue;  //it is not a file
			Long hashId = oneFile.getHashId();
			if ((hashId==null) || (f10.getFileSet().getMapId2Hash().get(hashId)==null)) continue;
			NodeHash nodeHash = f10.getFileSet().getMapId2Hash().get(hashId);
			if (nodeHash.getCrc32()==null) continue;
			hashList.add(nodeHash.getCrc32());
		}	
		Long hashValue = getDirHashFromList(hashList);
		NodeHash nodeHash = MakeBlobSetTables.createOneHash(f10, -1l, null, hashValue, null,null,null,
				null, null, null, null, null, null);
		nodeFile.setHashId(nodeHash.getHashId());
		hashList.clear();
		return(hashValue);
	}
	private static void createDirectoryHashes(NodeF10 f10)	{
		//assure that all sibling lists are sorted
		for (NodeFile oneDir : f10.getFileSet().getListFile())	{
			if (!"true".equals(oneDir.getIsDirectory())) continue;  //it is not a directory
			oneDir.sortListSiblingFile();
		}	
		for (NodeFile root : f10.getFileSet().getListRoots())	{
			if (!"true".equals(root.getIsDirectory())) continue;  //it is not a directory
			createOneDirectoryHash(f10, root);
			//NodeHash newHash = createOneHashForFile(conn10,fileSet);
		}	
	}
	public static void makeHash(NodeF10 f10)	{
		createHashes(f10);
		createDirectoryHashes(f10);
	}
		
}
