package tool10.fileset;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodePair;
import tool10.fileset.nodes.NodeSimilarity;
import tool10.sql.SqlUtil;

public class MakeFileSetSimilarity {
	
	private static Double getSim(ArrayList<Double> simList, int idxField)	{
		return((simList.size()>idxField) ? simList.get(idxField) : null);
	}
	private static String getAlg(ArrayList<String> algList, int idxField)	{
		return((algList.size()>idxField) ? algList.get(idxField) : null);
	}
	private static int updateSim(NodeSimilarity nodeSim,ArrayList<Double> simList, int idxField)	{
		if ((idxField<0) || (simList.size()==0)) return(0);
		if (idxField >= simList.size()) return(0);
		if (simList.get(idxField)==null) return(0);
		nodeSim.setSimValue(idxField,simList.get(idxField));
		return(0);
	}
	private static int updateAlg(NodeSimilarity nodeSim,ArrayList<String> algList, int idxField)	{
		if ((idxField<0) || (algList.size()==0)) return(0);
		if (idxField >= algList.size()) return(0);
		if (algList.get(idxField)==null) return(0);
		nodeSim.setAlgValue(idxField,algList.get(idxField));
		return(0);
	}
	private static NodeSimilarity createOneSimilarity(NodeF10 f10, Long entityId1, Long entityId2, String similarityType, String similarityKey,
			ArrayList<Double> simList, ArrayList<String> algList)	{
		NodeSimilarity newSimilarity = null;
		//public NodeSimilarity(Long similarityId, Long fileSetId, Long entityId1, Long entityId2, String similarityType,
		//Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
		//Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
		//Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
		//String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
		//String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
		//String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
		//ZonedDateTime modificationDate) {
		try {
			int idxField = 0;
			Long similarityId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			Double sim00 = getSim(simList,idxField++);  
			Double sim01 = getSim(simList,idxField++); 
			Double sim02 = getSim(simList,idxField++); 
			Double sim03 = getSim(simList,idxField++); 
			Double sim04 = getSim(simList,idxField++); 
			Double sim05 = getSim(simList,idxField++); Double sim06 = getSim(simList,idxField++); Double sim07 = getSim(simList,idxField++); 
			Double sim08 = getSim(simList,idxField++); Double sim09 = getSim(simList,idxField++); Double sim10 = getSim(simList,idxField++);
			Double sim11 = getSim(simList,idxField++); Double sim12 = getSim(simList,idxField++); Double sim13 = getSim(simList,idxField++); 
			Double sim14 = getSim(simList,idxField++); Double sim15 = getSim(simList,idxField++); Double sim16 = getSim(simList,idxField++); 
			Double sim17 = getSim(simList,idxField++); Double sim18 = getSim(simList,idxField++); Double sim19 = getSim(simList,idxField++);
			
			idxField = 0;		
			String alg00 = getAlg(algList,idxField++);
			String alg01 = getAlg(algList,idxField++);
			String alg02 = getAlg(algList,idxField++);
			String alg03 = getAlg(algList,idxField++);
			String alg04 = getAlg(algList,idxField++);
			String alg05 = getAlg(algList,idxField++); String alg06 = getAlg(algList,idxField++); String alg07 = getAlg(algList,idxField++);
			String alg08 = getAlg(algList,idxField++); String alg09 = getAlg(algList,idxField++); String alg10 = getAlg(algList,idxField++);
			String alg11 = getAlg(algList,idxField++); String alg12 = getAlg(algList,idxField++); String alg13 = getAlg(algList,idxField++);
			String alg14 = getAlg(algList,idxField++); String alg15 = getAlg(algList,idxField++); String alg16 = getAlg(algList,idxField++);
			String alg17 = getAlg(algList,idxField++); String alg18 = getAlg(algList,idxField++); String alg19 = getAlg(algList,idxField++);
			
			ZonedDateTime creationDate = ZonedDateTime.now();;
			ZonedDateTime modificationDate = null;
			
			newSimilarity = new NodeSimilarity(similarityId,f10.getFileSet().getFileSetId(),entityId1,entityId2,similarityType,similarityKey,
					sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,sim10,sim11,sim12,sim13,
					sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,
					alg08,alg09,alg10,alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19,
					creationDate, modificationDate);
			f10.getFileSet().getListSimilarity().add(newSimilarity);
			f10.getFileSet().getMapId2Similarity().put(newSimilarity.getSimilarityId(),newSimilarity);
		} catch (Exception e)	{
			
		}
		return(newSimilarity);
	}
	
	private static void updateOneSimilarity(NodeF10 f10, NodeSimilarity nodeSim, NodePair onePair, 
			ArrayList<Double> simList, ArrayList<String> algList)	{
		for (int i=0; i<simList.size(); i++) { updateSim(nodeSim,simList,i); }
		for (int i=0; i<algList.size(); i++) { updateAlg(nodeSim,algList,i); }	
	}

	private static final String[] algArray = new String[] {
			"weightedAverage","file2file_bytecomp","file2file_hash","dir2dir_hash",
			"file2file_samename","file2file_similar","dir2dir_samename","dir2dir_similar"};
	
	private static void processSimilarityPairs(NodeF10 f10, HashSet<NodePair> pairSet)	{
		System.out.println("processSimilarityPairs pairSet.size():"+pairSet.size());
		HashMap<String,Integer> idxMap = new HashMap<String,Integer>();
		for (int i=0; i<algArray.length; i++) {idxMap.put(algArray[i],i); }
		
		//puts the pairSet entries in one record for each pair, the scores are pivoted   
		HashMap<String,ArrayList<Double>> simMap = new HashMap<String,ArrayList<Double>>();  //map pairStr to score list
		HashMap<String,ArrayList<String>> algMap = new HashMap<String,ArrayList<String>>();  //map pairStr to algorithm name list
		for (NodePair onePair : pairSet)	{
			//System.out.println("processSimilarityPairs strPair:"+onePair.toString());
			String pairStr = onePair.getPairStr(); 
			if (simMap.get(pairStr)==null)	{
				ArrayList<Double> simList = new ArrayList<Double>(); 
				simList.add(0.0d); 
				simMap.put(pairStr, simList);
				ArrayList<String> algList = new ArrayList<String>(); 
				algList.add(algArray[0]); 
				algMap.put(pairStr, algList);
			}	
			simMap.get(pairStr).add(onePair.getScore());
			algMap.get(pairStr).add(onePair.getAlgName());
		}
		//set the weighted averages, the first entry in the arraylist
		for (String key : simMap.keySet())	{
			ArrayList<Double> simList = simMap.get(key);
			double sumSimilarity = 0.0d;
			int cnt = 0;
			for (int i=1; i<simList.size(); i++)	{
				sumSimilarity += simList.get(i).doubleValue();
				cnt++;
			}
			if (cnt>0)	{simList.set(0,sumSimilarity / cnt);}
		}
		for (NodePair onePair : pairSet)	{
			//System.out.println("processSimilarityPairs strPair:"+onePair.toString());
			NodeFile nodeFile1 = onePair.getNodeFile1();
			NodeFile nodeFile2 = onePair.getNodeFile2();
			String pairStr = onePair.getPairStr(); 
			if (simMap.get(pairStr)==null)	continue; 
			if (algMap.get(pairStr)==null)	continue; 
			ArrayList<Double> simList = simMap.get(pairStr);  
			ArrayList<String> algList = algMap.get(pairStr);
			//String similarityKey = "file2file"+nodeFile1.getFileId() +"_"+ nodeFile2.getFileId() ;
			if (f10.getFileSet().getMapKey2Similarity().get(pairStr)==null)	{
				NodeSimilarity newSim = createOneSimilarity (f10, nodeFile1.getFileId(), nodeFile2.getFileId(), "file2file", pairStr, simList, algList);
				f10.getFileSet().getMapKey2Similarity().put(pairStr, newSim);
			} else {
				//no need anymore
				//NodeSimilarity updateSim = f10.getFileSet().getMapKey2Similarity().get(similarityKey);
				//updateOneSimilarity (f10, updateSim, onePair, simList, algList);
			}
		}
		System.out.println("processSimilarityPairs f10.getFileSet().getListSimilarity().size():"+f10.getFileSet().getListSimilarity().size());
		for (NodeSimilarity sim : f10.getFileSet().getListSimilarity())	{
			//System.out.print(sim.getSimilarityId().longValue()+",");
		}
		System.out.println();
	}
	private static void createSimilarities(NodeF10 f10)	{
		HashSet<NodePair> pairSet = new HashSet<NodePair>(); //file2File_361736_123712 id1, id2 
		
		MakeFileSetSimilarityAlg.createSimilarities(f10, pairSet);
		
		processSimilarityPairs(f10, pairSet);
	}
	private static void truncateSimilarityTable(NodeF10 f10)	{
		int cntDeleted = SqlUtil.deleteTable(f10.getConn10().getConn(),"FS_SIMILARITY");
		if (cntDeleted>0)	{
			System.out.println("MakeFileSetSimilarity truncateSimilarityTable entries deleted from FS_SIMILARITY table, cntDeleted:" + cntDeleted);
		} else {
			System.out.println("MakeFileSetSimilarity truncateSimilarityTable no entries in FS_SIMILARITY table");	
		}
	}
	public static void makeSimilarity(NodeF10 f10)	{
		if (f10.getFileSet()==null) return;
		System.out.println("*********************************************************************************");
		System.out.println("MakeFileSetSimilarity makeSimilarity f10.getFileSet().getListFile().size():"+f10.getFileSet().getListFile().size());
		truncateSimilarityTable(f10);
		createSimilarities(f10);
	}		
}
