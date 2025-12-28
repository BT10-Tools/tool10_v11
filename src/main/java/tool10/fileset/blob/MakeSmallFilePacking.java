package tool10.fileset.blob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
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
	public static HashMap<NodeFile,Integer> createBinPacking(NodeFileSet fileSet, int blockSize, int binSize, int minFileSizeForPacking, HashSet<NodeFile> setCacheFile)	{
		ArrayList<Integer> listSize4Binning = new ArrayList<Integer>();
		//map from fileSize to the ArrayList of files whose filesize equal to that  
		HashMap<Long,ArrayList<NodeFile>> mapSize2NodeFile = new HashMap<Long,ArrayList<NodeFile>>(); 
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (setCacheFile.contains(nodeFile)) continue; //it is wirtten 
			if (nodeFile.getFileSize()==null) continue;
			if (nodeFile.getFileSize().longValue()==0) continue;
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
}
