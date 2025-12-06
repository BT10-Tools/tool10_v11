package tool10.fileset;

import java.nio.ByteBuffer;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import tool10.misc.binpacking.AbstractBinPacking;
import tool10.misc.binpacking.BinPackingBruteforce;
import tool10.misc.binpacking.FirstFitDecreasing;
import tool10.sql.Conn10;
import tool10.util.ByteCompression;
import tool10.util.ByteEncryption;

public class MakeFileSetBlobSmall {


	public static void main2(String[] args) {
        List<Integer> in = Arrays.asList(10, 3, 2, 3, 10, 1, 6, 7, 8);

        BinPackingBruteforce bf = new BinPackingBruteforce(in, 12);
        runBinPacking(bf, "brute force");

        FirstFitDecreasing ffd = new FirstFitDecreasing(in, 12);
        runBinPacking(ffd, "first fit decreasing");
    }

    private static HashMap<Integer,ArrayList<Integer>> runBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        HashMap<Integer,ArrayList<Integer>> binsMapList = algo.getBestBins(); 
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");

        System.out.println("\n\n");
        
        return(binsMapList);
    }

 	private static void createOneFileBlobSmall(Conn10 conn10,NodeFileSet fileSet, NodeFile nodeFile)	{
		//public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
		//Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long fileBlobSmallId = conn10.getNextId(-1); //"BSC_BASIC");;
			Long fileBlobId = null; 
			Long fileId = null;
			Long fileSetId = null;
			Long byteIndexStart = null;
			Long byteIndexEnd = null;
			Long hashId = null;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeFileBlobSmall fileBlobSmall = new NodeFileBlobSmall(fileBlobSmallId,fileBlobId,fileId,fileSetId,byteIndexStart,byteIndexEnd,
					hashId,creationDate,modificationDate);
			fileSet.getListFileBlobSmall().add(fileBlobSmall);
			fileSet.getMapId2FileBlobSmall().put(fileBlobSmall.getFileBlobSmallId(),fileBlobSmall);
		} catch (Exception e)	{
		}
	}
 	//puts the NodeFiles into the optimum number of bins 
	public static HashMap<NodeFile,Integer> createBinPacking(NodeFileSet fileSet, int blockSize, int binSize, int minFileSizeForPacking)	{
		ArrayList<Integer> listSize4Binning = new ArrayList<Integer>();
		//map from fileSize to the ArrayList of files whose filesize equal to that  
		HashMap<Long,ArrayList<NodeFile>> mapSize2NodeFile = new HashMap<Long,ArrayList<NodeFile>>(); 
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (nodeFile.getFileSize()==null) continue;
			if (nodeFile.getFileSize().longValue() > minFileSizeForPacking) continue;
			
			listSize4Binning.add(nodeFile.getFileSize().intValue());
			if (mapSize2NodeFile.get(nodeFile.getFileSize()) == null) {
				mapSize2NodeFile.put(nodeFile.getFileSize(), new ArrayList<NodeFile>());
			}
			mapSize2NodeFile.get(nodeFile.getFileSize()).add(nodeFile); 
		}
		//List<Integer> in = Arrays.asList(10, 3, 2, 3, 10, 1, 6, 7, 8);
		List<Integer> in = listSize4Binning;
		FirstFitDecreasing ffd = new FirstFitDecreasing(in, binSize);
		HashMap<Integer,ArrayList<Integer>> binsMapList = runBinPacking(ffd, "first fit decreasing");
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = new HashMap<NodeFile,Integer>();
		for (int binNumber : binsMapList.keySet())	{
			System.out.print("BinNumber="+binNumber+" [");
			ArrayList<Integer> itemList = binsMapList.get(binNumber);
			if (itemList==null) continue;
			int cntUpdatedFile4BinNumber = 0; 
			for (int itemSize : itemList)	{
				if (mapSize2NodeFile.get((long) itemSize)==null) continue;
				if (mapSize2NodeFile.get((long) itemSize).size()==0) continue;
				NodeFile nodeFile = mapSize2NodeFile.get((long) itemSize).get(0);
				if (nodeFile==null) continue;
				mapNodeFile2BinNumber.put(nodeFile, binNumber);
				//remove one element from ArrayList with the filesize  
				mapSize2NodeFile.get((long) itemSize).remove(0);
				System.out.print(nodeFile.getFileSize()+",");
				cntUpdatedFile4BinNumber++;
			}
			System.out.println("] cntUpdatedFile4BinNumber="+cntUpdatedFile4BinNumber);
		}
		 return(mapNodeFile2BinNumber);
        
	/*	
			mapFilesize2Id
			byte[][] fileBytesArray = getFileBytesArray(nodeFile.getFileNameAbsolute(), blockSize);
			if (fileBytesArray==null) continue;
			long cntPart = fileBytesArray.length;
			long partNumber = 0; 
			for (byte[] fileBytes : fileBytesArray)	{
				createOneFileBlob(conn10,fileSet,nodeFile,cntPart,partNumber,fileBytes);
				partNumber++;
			}
		}
	*/	
	}
	private static NodeFileBlobSmall createOneFileBlobSmall(NodeF10 f10, NodeFile nodeFile, 
			Long fileBlobId, Long byteIndexStart, Long byteIndexEnd, Long hashId)	{
		//public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
		//Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long fileBlobSmallId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeFileBlobSmall fileBlobSmall = new NodeFileBlobSmall(fileBlobSmallId,fileBlobId,nodeFile.getFileId(),f10.getFileSet().getFileSetId(),
					byteIndexStart,byteIndexEnd,hashId,creationDate,modificationDate);
			
			f10.getFileSet().getListFileBlobSmall().add(fileBlobSmall);
			f10.getFileSet().getMapId2FileBlobSmall().put(fileBlobSmall.getFileBlobId(),fileBlobSmall);
			return(fileBlobSmall);
		} catch (Exception e)	{
			
		}
		return(null);
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
		try {
			for (int binNumber : mapBin2NodeFileList.keySet())	{
				ArrayList<NodeFile> listFile = mapBin2NodeFileList.get(binNumber);
				if (listFile.size()==0) continue;
				int byteIndexStart = 0; 
				int byteIndexEnd = 0;
				
				byte[] binBytes = new byte[(int) (3*mapBin2TotalSize.get(binNumber) / 2)];
				ByteBuffer binBuffer = ByteBuffer.wrap(binBytes);
				ArrayList<NodeFileBlobSmall> listBlobSmallForBin = new ArrayList<NodeFileBlobSmall>(); 
				//for each of the nodeFile in the bin
				for (NodeFile nodeFile : listFile)	{
					byte[] fileBytesArray = MakeFileSetBlob.readSmallFileBytes(nodeFile.getFileNameAbsolute());
	
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
					Long fileBlobId = null;
					
					NodeHash hash = MakeFileSetHash.createOneHashForSmallFile(f10, nodeFile.getFileSize(), fileBytesArray);
					Long hashId = hash.getHashId();
					nodeFile.setHashId(hashId);
					
					NodeFileBlobSmall fileBlobSmall = createOneFileBlobSmall(f10, nodeFile, fileBlobId, (long) byteIndexStart, (long) byteIndexEnd, hashId);
					listBlobSmallForBin.add(fileBlobSmall);
				}
				binBytes = binBuffer.array();
				byte[] copiedBytes = new byte[byteIndexEnd+1];

				System.arraycopy(binBytes, 0, copiedBytes, 0, byteIndexEnd+1);
				
				System.out.println("createAllFileBlobSmall binBytes.length="+binBytes.length+" ,listBlobSmallForBin.size()="+listBlobSmallForBin.size()+" ,copiedBytes.length="+ copiedBytes.length);
				System.out.println("createAllFileBlobSmall byteIndexStart="+byteIndexStart+" ,byteIndexEnd="+byteIndexEnd);
				
				NodeHash hashMergedBytes = MakeFileSetHash.createOneHashForSmallFile(f10, (long) copiedBytes.length, copiedBytes);
				Long hashIdMergedBytes = hashMergedBytes.getHashId();
				
				String blobType="smallfile";
				//createOneFileBlob(Conn10 conn10,NodeFileSet fileSet, Long fileId, Long fileSize, String blobType, Long cntPart,Long partNumber, byte[] blobBytes)
				NodeFileBlob fileBlob = MakeFileSetBlob.createOneFileBlob(f10,null,null,blobType,null,null,copiedBytes, hashIdMergedBytes);
				for (NodeFileBlobSmall fileBlobSmall : listBlobSmallForBin)	{
					fileBlobSmall.setFileBlobId(fileBlob.getFileBlobId());
				}
				listBlobSmallForBin.clear();
				binBytes = null;
				copiedBytes = null;
			}
		} catch(Exception e) {
			
		}
	}
	public static HashMap<NodeFile,Integer> createFileBlobsSmall(NodeF10 f10, int blockSize, 
			int binSize, int minFileSizeForPacking)	{
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = createBinPacking(f10.getFileSet(),blockSize,binSize,minFileSizeForPacking);
		
		createAllFileBlobSmall(f10,mapNodeFile2BinNumber, blockSize);
		
		return(mapNodeFile2BinNumber);
	}
}
