package tool10.blobset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.bookset.MakeBookSetTables;
import tool10.bookset.NodeBookSet;
import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;
import tool10.sql.Conn10;

public class MakeBlobBigAndRegular {
	
	public static HashSet<NodeFile> createFileBlobsBig(NodeF10 f10, int blockSize, int minBigFileSize, HashSet<NodeFile> setCacheFile)	{
		HashSet<NodeFile> setNodeFileBig = new HashSet<NodeFile>();
		ArrayList<NodeBlob> listNodeBlobBig = new ArrayList<>();
		String blobType="bigfile";
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (setCacheFile.contains(nodeFile)) continue;
			if (nodeFile.getFileSize() < minBigFileSize) continue;
			
			File2BlobReader blobReader = new File2BlobReader(nodeFile.getFileNameAbsolute(), blockSize);
			byte[] fileBytesPart = blobReader.getNextBytes(); 
			if (fileBytesPart==null) continue;
		
			long partNumber = 0; 
			while (fileBytesPart!=null)	{

				Long blobSize = (long) fileBytesPart.length;
				NodeHash hash = MakeFileSetHash.createOneHashForBigFile(f10, nodeFile.getFileSize(), fileBytesPart);
				Long hashId = hash.getHashId();
				
				//public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)
				NodeFileBlob fileBlob = MakeBlobSetTables.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobSize,blobType,hashId);
				
				//public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber,  Long hashId)	{
				NodeBlob blob = MakeBlobSetTables.createOneBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,null,partNumber,hashId);
				listNodeBlobBig.add(blob);
				MakeFileBlobAndBlob.updateOneBlobBytes(f10, blob, fileBytesPart);
				
				int cntWritten2DbFileBlob = MakeBlobSetTables.writeFileBlob2Db (f10.getConn10().getConn(), fileBlob);
				int cntWritten2DbBlob = MakeBlobSetTables.writeBlob2Db (f10.getConnBlob().getConn(), blob);
				
				fileBytesPart = blobReader.getNextBytes();
				if (fileBytesPart!=null) partNumber++;
			}
			blobReader.closeAll();
			setNodeFileBig.add(nodeFile);
		}
		for (NodeBlob blob : listNodeBlobBig)	{
			blob.setCntPart((long) listNodeBlobBig.size());
		}
		return(setNodeFileBig);
	}
	public static HashSet<NodeFile> createFileBlobsRegular(NodeF10 f10, int blockSize, 
			HashMap<NodeFile,Integer> mapNodeFile2BinNumber, HashSet<NodeFile> setNodeFileBig, HashSet<NodeFile> setCacheFile)	{
		HashSet<NodeFile> setNodeFileRegular = new HashSet<NodeFile>(); 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (mapNodeFile2BinNumber.get(nodeFile) != null) continue;
			if (setNodeFileBig.contains(nodeFile)) continue;
			if (setCacheFile.contains(nodeFile)) continue;
			
			byte[] fileBytesRegular = File2BlobReader.readRegularFileBytes(nodeFile.getFileNameAbsolute());
			
			if (fileBytesRegular==null) continue;
			String blobType="regularfile";
			Long blobSize = (long) fileBytesRegular.length;
			
			NodeHash hash = MakeFileSetHash.createOneHashForRegularFile(f10, nodeFile.getFileSize(), fileBytesRegular);
			Long hashId = hash.getHashId();
			nodeFile.setHashId(hashId);
			
			//public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)
			NodeFileBlob fileBlob = MakeBlobSetTables.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobSize,blobType,hashId);
			
			//public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber,  Long hashId)	{
			NodeBlob blob = MakeBlobSetTables.createOneBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,1l,0l,hashId);
			MakeFileBlobAndBlob.updateOneBlobBytes(f10, blob, fileBytesRegular);
			
			int cntWritten2DbFileBlob = MakeBlobSetTables.writeFileBlob2Db (f10.getConn10().getConn(), fileBlob);
			int cntWritten2DbBlob = MakeBlobSetTables.writeBlob2Db (f10.getConnBlob().getConn(), blob);
		}
		return(setNodeFileRegular);
	}
}
