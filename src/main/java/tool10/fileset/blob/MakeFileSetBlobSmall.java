package tool10.fileset.blob;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedMap;
import java.util.TreeMap;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeBlob;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;

public class MakeFileSetBlobSmall {

	private static byte[] processOneBin(NodeF10 f10, ArrayList<NodeFileBlob> listBlobSmallForBin, 
			SortedMap<Integer,ArrayList<NodeFile>> mapBin2NodeFileList, SortedMap<Integer,Long> mapBin2TotalSize, 
			String blobType, int binNumber, int blockSize)	{
		
		ArrayList<NodeFile> listFile = mapBin2NodeFileList.get(binNumber);
		if (listFile.size()==0) return(null);
		
		int byteIndexStart = 0; 
		int byteIndexEnd = 0;
	
		byte[] binBytes = new byte[(int) (3*mapBin2TotalSize.get(binNumber) / 2)];
		ByteBuffer binBuffer = ByteBuffer.wrap(binBytes);
		listBlobSmallForBin.clear();  //new list for every bin
		//for each of the nodeFile in the bin
		for (NodeFile nodeFile : listFile)	{
			byte[] fileBytesArray = File2BlobReader.readSmallFileBytes(nodeFile.getFileNameAbsolute());
	
			if ((fileBytesArray==null) || (fileBytesArray.length==0) || (fileBytesArray.length>blockSize)) continue; //it is a big file ???
			
			System.out.println("createAllFileBlobSmall nodeFile.getFileNameAbsolute()=\""+nodeFile.getFileNameAbsolute()+"\" ,fileBytesArray.length="+fileBytesArray.length);
					
			if (byteIndexEnd==0)	{
				byteIndexStart = 0;  
				byteIndexEnd  = fileBytesArray.length - 1;
			} else {
				byteIndexStart = byteIndexEnd + 1;  
				byteIndexEnd  += fileBytesArray.length;
			}
			binBuffer.put(fileBytesArray);
			
			NodeHash hash = MakeFileSetHash.createOneHashForSmallFile(f10, nodeFile.getFileSize(), fileBytesArray);
			Long hashId = hash.getHashId();
			nodeFile.setHashId(hashId);
			
			//public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)
			NodeFileBlob fileBlob = MakeFileBlobAndBlob.createOneFileBlob(f10,nodeFile.getFileId(),nodeFile.getFileSize(),null,blobType,hashId);
			fileBlob.setSmallByteIndexStart((long) byteIndexStart);
			fileBlob.setSmallByteIndexEnd((long) byteIndexEnd);
			
			///NodeFileBlobSmall fileBlobSmall = createOneFileBlobSmall(f10, nodeFile, fileBlobId, (long) byteIndexStart, (long) byteIndexEnd, hashId);
			listBlobSmallForBin.add(fileBlob);
		}
		binBytes = binBuffer.array();
		byte[] copiedBytes = new byte[byteIndexEnd+1];
	
		System.arraycopy(binBytes, 0, copiedBytes, 0, byteIndexEnd+1);
	
		System.out.println("createAllFileBlobSmall binBytes.length="+binBytes.length+" ,listBlobSmallForBin.size()="+listBlobSmallForBin.size()+" ,copiedBytes.length="+ copiedBytes.length);
		System.out.println("createAllFileBlobSmall byteIndexStart="+byteIndexStart+" ,byteIndexEnd="+byteIndexEnd);
		binBytes = null;
		
		return(copiedBytes);
	}	
	private static void createAllFileBlobSmall(NodeF10 f10, HashMap<NodeFile,Integer> mapNodeFile2BinNumber, int blockSize)	{
		//transpose the map 
		SortedMap<Integer,ArrayList<NodeFile>> mapBin2NodeFileList = new TreeMap<>();
		SortedMap<Integer,Long> mapBin2TotalSize = new TreeMap<>();
		int maxBinNumber = 0;  
		long cntBytes = 0; 
		for (NodeFile nodeFile : mapNodeFile2BinNumber.keySet())	{
			int binNumber = mapNodeFile2BinNumber.get(nodeFile);
			if (mapBin2NodeFileList.get(binNumber)==null) { mapBin2NodeFileList.put(binNumber,new ArrayList<NodeFile>());}
			mapBin2NodeFileList.get(binNumber).add(nodeFile);
			if (mapBin2TotalSize.get(binNumber)==null) { mapBin2TotalSize.put(binNumber,0l);}
			if (binNumber > maxBinNumber) maxBinNumber = binNumber;
			mapBin2TotalSize.put(binNumber,mapBin2TotalSize.get(binNumber) + nodeFile.getFileSize());
			cntBytes += nodeFile.getFileSize();
		}
		System.out.println("createAllFileBlobSmall maxBinNumber="+maxBinNumber+" ,cntBytes="+cntBytes+
				" , mapBin2NodeFileList.size()="+mapBin2NodeFileList.size()+" ,mapBin2TotalSize.size()="+mapBin2TotalSize.size());
		//byte[][] binBytes = new byte[maxBinNumber][];
		String blobType = "smallfile";
		ArrayList<NodeFileBlob> listBlobSmallForBin = new ArrayList<>(); 
		try {
			for (int binNumber : mapBin2NodeFileList.keySet())	{
				if ((mapBin2NodeFileList.get(binNumber)==null) || (mapBin2NodeFileList.get(binNumber).isEmpty())) continue; 
				byte[] copiedBytes = processOneBin(f10, listBlobSmallForBin,mapBin2NodeFileList, mapBin2TotalSize, blobType, binNumber, blockSize);
		
				NodeHash hashMergedBytes = MakeFileSetHash.createOneHashForSmallFile(f10, (long) copiedBytes.length, copiedBytes);
				Long hashIdMergedBytes = hashMergedBytes.getHashId();
				
				//public static NodeBlob createOneBlob(NodeF10 f10, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes, Long hashId)	{
				NodeBlob blob = MakeFileBlobAndBlob.createOneBlob(f10,null,null,blobType,null,null,copiedBytes, hashIdMergedBytes); 
				for (NodeFileBlob fileBlob : listBlobSmallForBin)	{
					fileBlob.setBlobId(blob.getBlobId());
				}
				copiedBytes = null;
						
				int cntWritten2DbFileBlob = MakeFileBlobAndBlob.writeFileBlobList2Db (f10.getConn10().getConn(), listBlobSmallForBin);
				int cntWritten2DbBlob = MakeFileBlobAndBlob.writeBlob2Db (f10.getConnBlob().getConn(), blob);
			} //for
		} catch(Exception e) {
			
		}
	}
	public static HashMap<NodeFile,Integer> createFileBlobsSmall(NodeF10 f10, int blockSize, 
			int binSize, int minFileSizeForPacking, HashSet<NodeFile> setCacheFile)	{
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = MakeSmallFilePacking.createBinPacking(f10.getFileSet(),blockSize,binSize,minFileSizeForPacking, setCacheFile);
		
		createAllFileBlobSmall(f10,mapNodeFile2BinNumber, blockSize);
		
		return(mapNodeFile2BinNumber);
	}
}
