package tool10.blobset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;
import tool10.sql.Conn10;

public class MakeFileSetBlob {
	
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
				NodeFileBlob fileBlob = MakeFileBlobAndBlob.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobSize,blobType,hashId);
				
				//public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes, Long hashId)	{
				NodeBlob blob = MakeFileBlobAndBlob.createOneBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,null,partNumber,fileBytesPart, hashId);
				listNodeBlobBig.add(blob);
				
				int cntWritten2DbFileBlob = MakeFileBlobAndBlob.writeFileBlob2Db (f10.getConn10().getConn(), fileBlob);
				int cntWritten2DbBlob = MakeFileBlobAndBlob.writeBlob2Db (f10.getConnBlob().getConn(), blob);
				
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
			NodeFileBlob fileBlob = MakeFileBlobAndBlob.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobSize,blobType,hashId);
			
			//public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes, Long hashId)	{
			NodeBlob blob = MakeFileBlobAndBlob.createOneBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),blobType,1l,0l,fileBytesRegular, hashId);
			
			int cntWritten2DbFileBlob = MakeFileBlobAndBlob.writeFileBlob2Db (f10.getConn10().getConn(), fileBlob);
			int cntWritten2DbBlob = MakeFileBlobAndBlob.writeBlob2Db (f10.getConnBlob().getConn(), blob);
		}
		return(setNodeFileRegular);
	}
	
	private static void printBlobSummary(NodeF10 f10, HashMap<NodeFile,Integer> mapNodeFile2BinNumber, 
			HashSet<NodeFile> setNodeFileBig, HashSet<NodeFile> setNodeFileRegular)	{
		long sumBlobSize = 0l; 
		long sumCompressedSize = 0l;
		for (NodeBlob blob : f10.getFileSet().getListBlob())	{
			sumBlobSize += blob.getBlobSize();   
			sumCompressedSize += blob.getCompressedSize();
		}
		System.out.println("MakeFileSetBlob printBlobSummary f10.getFileSet().getListBlob().size():"+f10.getFileSet().getListBlob().size() + 
				" ,sumBlobSize:"+sumBlobSize + " ,sumCompressedSize:"+sumCompressedSize);
		for (NodeFile smallFile : mapNodeFile2BinNumber.keySet())	{
			
		}
		System.out.println("MakeFileSetBlob printBlobSummary setNodeFileBig.size():"+setNodeFileBig.size()); 
		System.out.println("MakeFileSetBlob printBlobSummary setNodeFileRegular.size():"+setNodeFileRegular.size()); 
		
		//HashSet<NodeFile> setNodeFileBig 
		//HashSet<NodeFile> setNodeFileRegular 
	}
	public static void createFileBlobs(NodeF10 f10)	{
	/*	if (!"yes".equals(f10.getCliParams().getBlob()))	{
			return;
		}
	*/	
		//create a set of already written file blobs , for not to compute them again
		HashSet<NodeFile> setCacheFile = new HashSet<>();
		for (NodeFileBlob fileBlob : f10.getFileSet().getListFileBlob())	{
			if (fileBlob.getFileId()==null) continue;
			NodeFile nodeFile = f10.getFileSet().getMapId2File().get(fileBlob.getFileId());
			setCacheFile.add(nodeFile);
		}
		
		MakeFileSetBlobDatabase.createBlobDatabase(f10);
		
		int blockSize = 96*1024*1024;
		int binSize = blockSize; 
		int minFileSizeForPacking = (4*binSize / 5); 
		int minBigFileSize = 64*1024*1024;
		
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = MakeFileSetBlobSmall.createFileBlobsSmall(f10, blockSize, binSize, minFileSizeForPacking, setCacheFile);
		HashSet<NodeFile> setNodeFileBig = createFileBlobsBig(f10,blockSize, minBigFileSize, setCacheFile);
		HashSet<NodeFile> setNodeFileRegular = createFileBlobsRegular(f10,blockSize, mapNodeFile2BinNumber, setNodeFileBig, setCacheFile);
		
		printBlobSummary(f10, mapNodeFile2BinNumber, setNodeFileBig, setNodeFileRegular); 
	}
}
