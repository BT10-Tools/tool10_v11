package tool10.blobset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import tool10.misc.binpacking.AbstractBinPacking;
import tool10.misc.binpacking.FirstFitDecreasing;

public class MakeSmallFilePacking {

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

 	//puts the NodeFiles into the optimum number of bins 
	public static HashMap<NodeBlobEntity,Integer> createBinPacking(NodeBlobSet blobSet, int blockSize, int binSize, 
			int minFileSizeForPacking, HashSet<NodeBlobEntity> setCacheBlobEntity)	{
		ArrayList<Integer> listSize4Binning = new ArrayList<Integer>();
		//map from fileSize to the ArrayList of files whose filesize equal to that  
		HashMap<Long,ArrayList<NodeBlobEntity>> mapSize2NodeBlobEntity = new HashMap<Long,ArrayList<NodeBlobEntity>>(); 
		for (NodeBlobEntity nodeBlobEntity : blobSet.getListBlobEntity())	{
			if (setCacheBlobEntity.contains(nodeBlobEntity)) continue; //it is written 
			if (nodeBlobEntity.getSourceSize()==null) continue;
			if (nodeBlobEntity.getSourceSize().longValue()==0) continue;
			if (nodeBlobEntity.getSourceSize().longValue() > minFileSizeForPacking) continue;
			
			listSize4Binning.add(nodeBlobEntity.getSourceSize().intValue());
			if (mapSize2NodeBlobEntity.get(nodeBlobEntity.getSourceSize()) == null) {
				mapSize2NodeBlobEntity.put(nodeBlobEntity.getSourceSize(), new ArrayList<NodeBlobEntity>());
			}
			mapSize2NodeBlobEntity.get(nodeBlobEntity.getSourceSize()).add(nodeBlobEntity); 
		}
		//List<Integer> in = Arrays.asList(10, 3, 2, 3, 10, 1, 6, 7, 8);
		List<Integer> in = listSize4Binning;
		FirstFitDecreasing ffd = new FirstFitDecreasing(in, binSize);
		HashMap<Integer,ArrayList<Integer>> binsMapList = runBinPacking(ffd, "first fit decreasing");
		HashMap<NodeBlobEntity,Integer> mapNodeBlobEntity2BinNumber = new HashMap<NodeBlobEntity,Integer>();
		for (int binNumber : binsMapList.keySet())	{
			System.out.print("BinNumber="+binNumber+" [");
			ArrayList<Integer> itemList = binsMapList.get(binNumber);
			if (itemList==null) continue;
			int cntUpdatedBlobEntity4BinNumber = 0; 
			for (int itemSize : itemList)	{
				if (mapSize2NodeBlobEntity.get((long) itemSize)==null) continue;
				if (mapSize2NodeBlobEntity.get((long) itemSize).size()==0) continue;
				NodeBlobEntity nodeBlobEntity = mapSize2NodeBlobEntity.get((long) itemSize).get(0);
				if (nodeBlobEntity==null) continue;
				mapNodeBlobEntity2BinNumber.put(nodeBlobEntity, binNumber);
				//remove one element from ArrayList with the filesize  
				mapSize2NodeBlobEntity.get((long) itemSize).remove(0);
				System.out.print(nodeBlobEntity.getBlobSize()+",");
				cntUpdatedBlobEntity4BinNumber++;
			}
			System.out.println("] cntUpdatedBlobEntity4BinNumber="+cntUpdatedBlobEntity4BinNumber);
		}
		 return(mapNodeBlobEntity2BinNumber);
        
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
}
