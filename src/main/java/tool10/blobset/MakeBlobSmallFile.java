package tool10.blobset;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;

public class MakeBlobSmallFile {

	private static byte[] processOneBin(NodeF10 f10, ArrayList<NodeBlobEntity> listBlobSmallForBin, 
			SortedMap<Integer,ArrayList<NodeBlobEntity>> mapBin2NodeBlobEntityList, SortedMap<Integer,Long> mapBin2TotalSize, 
			String blobType, int binNumber, int blockSize)	{
		
		//byte[] copiedBytes = processOneBin(f10, listBlobSmallForBin,mapBin2NodeBlobEntityList, mapBin2TotalSize, blobType, binNumber, blockSize);
		ArrayList<NodeBlobEntity> listBlobEntity = mapBin2NodeBlobEntityList.get(binNumber);
		if (listBlobEntity.size()==0) return(null);
		
		int byteIndexStart = 0; 
		int byteIndexEnd = 0;
	
		byte[] binBytes = new byte[(int) (3*mapBin2TotalSize.get(binNumber) / 2)];
		ByteBuffer binBuffer = ByteBuffer.wrap(binBytes);
		listBlobSmallForBin.clear();  //new list for every bin
		//for each of the nodeFile in the bin
		for (NodeBlobEntity blobEntity : listBlobEntity)	{
			byte[] fileBytesArray = File2BlobReader.readSmallFileBytes(blobEntity.getEntityName());
	
			if ((fileBytesArray==null) || (fileBytesArray.length==0)) continue; //strange, it should not be 
			if (fileBytesArray.length>blockSize) continue; //it is a big file ???
			
			System.out.println("MakeBlobSmallFile processOneBin blobEntity.getEntityName():\""+blobEntity.getEntityName()+
					"\" ,fileBytesArray.length="+fileBytesArray.length);
					
			if (byteIndexEnd==0)	{
				byteIndexStart = 0;  
				byteIndexEnd  = fileBytesArray.length - 1;
			} else {
				byteIndexStart = byteIndexEnd + 1;  
				byteIndexEnd  += fileBytesArray.length;
			}
			binBuffer.put(fileBytesArray);
			
			NodeHash hash = MakeFileSetHash.createOneHashForSmallFile(f10, blobEntity.getSourceSize(), fileBytesArray);
			Long hashId = hash.getHashId();
			blobEntity.setHashId(hashId);
			
			//public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)
			//NodeFileBlob fileBlob = MakeBlobSetTables.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),null,blobType,hashId);
			blobEntity.setSmallByteIndexStart((long) byteIndexStart);
			blobEntity.setSmallByteIndexEnd((long) byteIndexEnd);
			blobEntity.getRefFileBlob().setSmallByteIndexStart((long) byteIndexStart);
			blobEntity.getRefFileBlob().setSmallByteIndexEnd((long) byteIndexEnd);
						
			listBlobSmallForBin.add(blobEntity);
		}
		binBytes = binBuffer.array();
		byte[] copiedBytes = new byte[byteIndexEnd+1];
	
		System.arraycopy(binBytes, 0, copiedBytes, 0, byteIndexEnd+1);
	
		System.out.println("MakeBlobSmallFile processOneBin binBytes.length="+binBytes.length+" ,listBlobSmallForBin.size()="+
							listBlobSmallForBin.size()+" ,copiedBytes.length="+ copiedBytes.length);
		System.out.println("MakeBlobSmallFile processOneBin byteIndexStart="+byteIndexStart+" ,byteIndexEnd="+byteIndexEnd);
		binBytes = null;
		
		return(copiedBytes);
	}	
	private static void createAllBlobEntityBlobSmall(NodeF10 f10, HashMap<NodeBlobEntity,Integer> mapNodeBlobEntity2BinNumber, int blockSize)	{
		//transpose the map 
		SortedMap<Integer,ArrayList<NodeBlobEntity>> mapBin2NodeBlobEntityList = new TreeMap<>();
		SortedMap<Integer,Long> mapBin2TotalSize = new TreeMap<>();
		int maxBinNumber = 0;  
		long cntBytes = 0; 
		for (NodeBlobEntity nodeBlobEntity : mapNodeBlobEntity2BinNumber.keySet())	{
			int binNumber = mapNodeBlobEntity2BinNumber.get(nodeBlobEntity);
			if (mapBin2NodeBlobEntityList.get(binNumber)==null) { mapBin2NodeBlobEntityList.put(binNumber,new ArrayList<NodeBlobEntity>());}
			mapBin2NodeBlobEntityList.get(binNumber).add(nodeBlobEntity);
			if (mapBin2TotalSize.get(binNumber)==null) { mapBin2TotalSize.put(binNumber,0l);}
			if (binNumber > maxBinNumber) maxBinNumber = binNumber;
			mapBin2TotalSize.put(binNumber,mapBin2TotalSize.get(binNumber) + nodeBlobEntity.getSourceSize());
			cntBytes += nodeBlobEntity.getSourceSize();
		}
		System.out.println("MakeBlobSmallFile maxBinNumber="+maxBinNumber+" ,cntBytes="+cntBytes+
				" , mapBin2NodeBlobEntityList.size()="+mapBin2NodeBlobEntityList.size()+" ,mapBin2TotalSize.size()="+mapBin2TotalSize.size());
		//byte[][] binBytes = new byte[maxBinNumber][];
		String blobType = "smallfile";
		ArrayList<NodeBlobEntity> listBlobSmallForBin = new ArrayList<>(); 
		try {
			for (int binNumber : mapBin2NodeBlobEntityList.keySet())	{
				if ((mapBin2NodeBlobEntityList.get(binNumber)==null) || (mapBin2NodeBlobEntityList.get(binNumber).isEmpty())) continue; 
				
				//private static byte[] processOneBin(NodeF10 f10, ArrayList<NodeBlobEntity> listBlobSmallForBin, 
				//		SortedMap<Integer,ArrayList<NodeBlobEntity>> mapBin2NodeBlobEntityList, SortedMap<Integer,Long> mapBin2TotalSize, 
				//		String blobType, int binNumber, int blockSize)	{
				byte[] copiedBytes = processOneBin(f10, listBlobSmallForBin,mapBin2NodeBlobEntityList, mapBin2TotalSize, blobType, binNumber, blockSize);
		
				NodeHash hashMergedBytes = MakeFileSetHash.createOneHashForSmallFile(f10, (long) copiedBytes.length, copiedBytes);
				Long hashIdMergedBytes = hashMergedBytes.getHashId();
				
				//public static NodeBlob createOneBlob(NodeF10 f10, Long blobEntityId, Long fileSize, String blobType, Long cntPart,Long partNumber,
				//		byte[] blobBytes, Long hashId)	{
				NodeBlob blob = MakeBlobSetTables.createOneBlob(f10,null,null,blobType,null,null,copiedBytes,hashIdMergedBytes); 
				for (NodeBlobEntity blobEntity : listBlobSmallForBin)	{
					blobEntity.setBlobId(blob.getBlobId());
				}
				copiedBytes = null;
						
				int cntWritten2DbFileBlob = MakeBlobSetTables.writeFileBlobList2Db (f10.getConn10().getConn(), listBlobSmallForBin);
				int cntWritten2DbBlob = MakeBlobSetTables.writeBlob2Db (f10.getConnBlob().getConn(), blob);
			} //for
		} catch(Exception e) {
			
		}
	}
	public static HashMap<NodeBlobEntity,Integer> createFileBlobsSmall(NodeF10 f10, int blockSize, 
			int binSize, int minFileSizeForPacking, HashSet<NodeBlobEntity> setCacheBlobEntity)	{
		HashMap<NodeBlobEntity,Integer> mapNodeBlobEntity2BinNumber = 
				MakeSmallFilePacking.createBinPacking(f10.getBlobSet(),blockSize,binSize,minFileSizeForPacking, setCacheBlobEntity);
		
		createAllBlobEntityBlobSmall(f10,mapNodeBlobEntity2BinNumber, blockSize);
		
		return(mapNodeBlobEntity2BinNumber);
	}
}
