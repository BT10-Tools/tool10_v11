package test10.fileset;

import java.util.Arrays;
import java.util.List;

import tool10.misc.binpacking.AbstractBinPacking;
import tool10.misc.binpacking.BinPackingBruteforce;
import tool10.misc.binpacking.FirstFitDecreasing;

public class BinPackingTest {

    public static void main(String[] args) {
        List<Integer> in = Arrays.asList(10, 3, 2, 3, 10, 1, 6, 7, 8);

        BinPackingBruteforce bf = new BinPackingBruteforce(in, 12);
        testBinPacking(bf, "brute force");

        FirstFitDecreasing ffd = new FirstFitDecreasing(in, 12);
        testBinPacking(ffd, "first fit decreasing");
    }

    private static void testBinPacking(AbstractBinPacking algo, String algoName) {
        long startTime;
        long estimatedTime;

        startTime = System.currentTimeMillis();
        System.out.println("needed bins (" + algoName + "): " + algo.getResult());
        algo.printBestBins();
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("in " + estimatedTime + " ms");

        System.out.println("\n\n");
    }

}
