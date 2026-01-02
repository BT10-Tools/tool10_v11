package tool10.imageset.sim; 

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import tool10.mediaset.ImageEngineJava;
import tool10.mediaset.NodeMediaFile;
import tool10.mediaset.NodeMediaSet;

public class ImageSimRGBDistance {
	
    private static void printAllDifferences(NodeMediaSet imageSet)	{
		for (int i=0; i<imageSet.getListImageFile().size(); i++)	{
			String fileStr1 = imageSet.getListImageFile().get(i).getSourceAbsolutePath();
			//System.out.println("printAllDifferences "+fileStr1);
			for (int j=i+1; j<imageSet.getListImageFile().size(); j++)	{
				String fileStr2 = imageSet.getListImageFile().get(j).getSourceAbsolutePath();
				//System.out.println("printAllDifferences 		"+fileStr2);
				double diff = SimpleImageColorDistance2.getTwoImageRGBDifference(fileStr1, fileStr2, -1);
				if (diff>0)	{
					System.out.println("\""+fileStr1+"\"  , \""+fileStr2+"\" ,"+diff);
				}
			}		
		}
	}
    private static ArrayList<String> printAllDifferencesWithMap(NodeMediaSet imageSet, HashMap<String,ArrayList<String>> wh2FilenameArray)	{
    	int maximumLinksPerNode = 5;
    	int maximumLinks = 1*500;
    	int maximumCntPerWhrLinks = 350;
    	double maxDiff = 0.1d;
    	
    	int cntLinks=0;
    	ArrayList<BufferedImage> bufImgList = new ArrayList<BufferedImage>();
    	ArrayList<String> pairStringList = new ArrayList<String>();
 		for (String whStr : wh2FilenameArray.keySet())	{
 			ArrayList<String> lst = wh2FilenameArray.get(whStr);
 			System.out.println("whStr:"+whStr + " ,lst.size():"+lst.size());
 			if (lst.size()<2) continue; 
 			
 			//to count the number of links per entity, to control maximumLinksPerNode 
 			int[] cntLink = new int[lst.size()];
 			for (int i=0; i<lst.size(); i++)	{cntLink[i] = 0;}
 			
 			for (BufferedImage bi : bufImgList)	{if (bi!=null) bi.flush();}
 			bufImgList.clear();
 			long sumBiSize=0;
 			long maxBiSize= 1000*1000*200l;
 			int cntPerWhrLinks = 0;
 			for (int i=0; ((i<lst.size()) && (i<maximumCntPerWhrLinks+1)); i++)	{
 				if (sumBiSize < maxBiSize)	{
	 				BufferedImage bi = ImageEngineJava.getBufferedImageFromFile(lst.get(i)); 
	 				bufImgList.add(bi);
	 				sumBiSize += bi.getHeight() * bi.getWidth() * 4;
 				} else {
 					bufImgList.add(null);
 					//System.out.print("n");
 				}
 				if ((i % 100)==1) System.out.print("&");
 			}
 			System.out.println();
 			for (int i=0; ((i<lst.size()-1) && (i<maximumCntPerWhrLinks-1)); i++)	{
 				String fileStr1 = lst.get(i);
	 			//System.out.println("printAllDifferences "+fileStr1);
	 			for (int j=i+1; ((j<lst.size()) && (j<maximumCntPerWhrLinks)); j++)	{
	 				String fileStr2 = lst.get(j);
	 				//System.out.println("printAllDifferences 		"+fileStr2);
	 				double diff = -1;
	 				if ((bufImgList.get(i)==null) || (bufImgList.get(j)==null)) {
	 					diff = SimpleImageColorDistance2.getTwoImageRGBDifference(fileStr1, fileStr2,maxDiff);
	 				} else {
	 					diff = SimpleImageColorDistance2.getTwoImageRGBDifferenceWithBufferedImage(bufImgList.get(i), bufImgList.get(j),maxDiff);
	 				}	
	 				if ((diff>0) && (diff < 0.1) && (cntLink[i]<maximumLinksPerNode) && (cntLink[j]<maximumLinksPerNode))	{
	 					System.out.println("		\""+fileStr1+"\"  , \""+fileStr2+"\" ,"+diff+"  size:,"+pairStringList.size());
	 					NodeMediaFile if1 = imageSet.getMapPath2ImageFile().get(fileStr1);
	 					NodeMediaFile if2 = imageSet.getMapPath2ImageFile().get(fileStr2);
	 					if ((if1!=null) && (if2!=null) && (if1.getImageId()!=null) && (if2.getImageId()!=null))	{
	 						pairStringList.add(if1.getImageId()+","+if2.getImageId()+","+diff+"\n");
	 						cntLink[i]++;
	 						cntLink[j]++;
	 						cntLinks++;
	 					}
	 				}
	 				if (cntLink[j]>maximumLinksPerNode) continue;
	 				if (cntLink[i]>maximumLinksPerNode) break;
	 				if (cntLinks>maximumLinks) {return(pairStringList);}
	 			}	
	 			if (cntLink[i]>maximumLinksPerNode) continue;
 			}
 		}
 		return(pairStringList);
 	}
    private static void getAllWidthHeight(NodeMediaSet imageSet, HashMap<String,String> mapFilename2Wh)	{
    	int cnt=0;
		for (int i=0; i<imageSet.getListImageFile().size(); i++)	{
			String fileStr1 = imageSet.getListImageFile().get(i).getSourceAbsolutePath();
			int[] wh = SimpleImageColorDistance2.getImageWidthHeigth(fileStr1);
			if ((wh!=null) && (wh.length>=2))	{
				mapFilename2Wh.put(fileStr1, wh[0]+"-"+wh[1]);
			}		
			if ((cnt++ % 1000)==1) System.out.print(".");
		}
		System.out.println("\ngetAllWidthHeight mapFilename2Wh.size():"+mapFilename2Wh.size());
	}
    private static void getWh2FilenameArray(HashMap<String,String> mapFilename2Wh, HashMap<String,ArrayList<String>> wh2FilenameArray)	{
    	int cnt=0;
		for (String key : mapFilename2Wh.keySet())	{
			String whStr = mapFilename2Wh.get(key);
			
			if (wh2FilenameArray.get(whStr)==null)	{wh2FilenameArray.put(whStr,new ArrayList<String>());}
			ArrayList<String> lst = wh2FilenameArray.get(whStr);
			lst.add(key);
			if ((cnt++ % 1000)==1) System.out.print("*");
		}
		System.out.println("\ngetWh2FilenameArray wh2FilenameArray.size():"+wh2FilenameArray.size());
    }
	public static ArrayList<String> rgbDistancePairs(NodeMediaSet readImageSet) {
		
		ArrayList<String> pairStringList = null;
		
		HashMap<String,String> mapFilename2Wh = new HashMap<String,String>();
		getAllWidthHeight(readImageSet,mapFilename2Wh);
		 
		HashMap<String,ArrayList<String>> wh2FilenameArray = new HashMap<String,ArrayList<String>>();
		getWh2FilenameArray(mapFilename2Wh, wh2FilenameArray);
		
		pairStringList = printAllDifferencesWithMap(readImageSet,wh2FilenameArray);
		
		//printAllDifferences(readImageSet);
		
		return(pairStringList); 
    }
}
