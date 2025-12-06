package tool10.misc.binpacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FirstFitDecreasing extends AbstractBinPacking {

    private List<Bin> bins = new ArrayList<Bin>();

    public FirstFitDecreasing(List<Integer> in, int binSize) {
        super(in, binSize);
    }

    @Override
    public int getResult() {
        Collections.sort(in, Collections.reverseOrder()); // sort input by size (big to small)
        bins.add(new Bin(binSize)); // add first bin
        for (Integer currentItem : in) {
            // iterate over bins and try to put the item into the first one it fits into
            boolean putItem = false; // did we put the item in a bin?
            int currentBin = 0;
            while (!putItem) {
                if (currentBin == bins.size()) {
                    // item did not fit in last bin. put it in a new bin
                    Bin newBin = new Bin(binSize);
                    newBin.put(currentItem);
                    bins.add(newBin);
                    putItem = true;
                } else if (bins.get(currentBin).put(currentItem)) {
                    // item fit in bin
                    putItem = true;
                } else {
                    // try next bin
                    currentBin++;
                }
            }
        }
        return bins.size();
    }

    @Override
    public void printBestBins() {
        System.out.println("Bins:");
        if (bins.size() == in.size()) {
            System.out.println("each item is in its own bin");
        } else {
            for (Bin bin : bins) {
                System.out.println(bin.toString());
            }
        }
    }
    //written by Nursal Haney
    // public abstract HashMap<Integer,ArrayList<Integer>> getBestBins(); 
    @Override
    public HashMap<Integer,ArrayList<Integer>> getBestBins() {
    	//for each each bin, the filesize values is returned 
    	//there can be files for the same filesize, so in the ArrayList there can be duplicates   
    	HashMap<Integer,ArrayList<Integer>> binMap = new HashMap<Integer,ArrayList<Integer>>();
    	int binNum = 0;
    	for (Bin bin : bins) {
    		ArrayList<Integer> binItemList = new ArrayList<Integer>();
    		binMap.put(binNum++, binItemList);
            for (Integer item : bin.items)	{
            	binItemList.add(item);
            }
    	}
    	return(binMap);
    }   
   
}
