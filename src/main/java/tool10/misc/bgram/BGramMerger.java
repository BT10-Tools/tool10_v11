package tool10.misc.bgram;

import java.util.ArrayList;

import tool10.fileset.nodes.NodeBinary;

public class BGramMerger {

	//tamamlanmadı, sürecek
	public static BGram mergeInNewBGram(String mergedBGramName, ArrayList<BGram> listBGram)	{
		//public BGram(long bGramId, Long fileId, Long sourceId, String bGramName, String bGramDesc, String bGramStatus,
		//	String bGramType, long cntBytes, long cntBGram) {
		String bGramName = mergedBGramName; 
		String bGramDesc = null; 
		String bGramStatus = "new";
		String bGramType = "composite";
		
		BGram mergedBGram = new BGram(-1, null, null, bGramName, bGramDesc, bGramStatus, bGramType, 0, 0);
		for (BGram bGram : listBGram)	{
			mergedBGram.setCntBytes(mergedBGram.getCntBytes() + bGram.getCntBytes());
			for (int i = 0; i < mergedBGram.getB1().length; i++) {mergedBGram.getB1()[i] += bGram.getB1()[i];}
			for (int i = 0; i < mergedBGram.getB4().length; i++) {mergedBGram.getB4()[i] += bGram.getB4()[i];}
			for (int i = 0; i < mergedBGram.getB8().length; i++) {mergedBGram.getB8()[i] += bGram.getB8()[i];}
			for (int i = 0; i < mergedBGram.getW16().length; i++) {mergedBGram.getW16()[i] += bGram.getW16()[i];}
			for (NodeBinary nb : bGram.getW32().keySet())	{
				//if (mergedBGram.w)
			}
			mergedBGram.getListBGram().add(bGram);
		}
		return(mergedBGram);
	}
	
}
