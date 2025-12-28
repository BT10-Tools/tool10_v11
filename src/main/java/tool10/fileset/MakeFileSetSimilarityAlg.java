package tool10.fileset;

import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.fileset.blob.MakeFileSetByteComparison;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodePair;

public class MakeFileSetSimilarityAlg {
	
	private static final double minCompValue = 0.6d; 

	public static void findFileSimilarityPairsByByteComparison(NodeF10 f10, HashSet<NodePair> pairSet)	{
		if (f10.getFileSet().getListFile()==null) return;
		HashMap<Long,Integer> mapHashId2Count = new HashMap<Long,Integer>();
		for (NodeFile nodeFile1 : f10.getFileSet().getListFile())	{
			if (nodeFile1.getHashId()==null) continue;
			if (!"true".equals(nodeFile1.getIsFile())) continue;
			long fSize1 = nodeFile1.getFileSize();
			//System.out.println("MakeFileSetSimilarity findFileSimilarityPairsByByteComparison fileName1: "+nodeFile1.getFileName());
			for (NodeFile nodeFile2 : f10.getFileSet().getListFile())	{
				if (nodeFile2.getHashId()==null) continue;
				if (!"true".equals(nodeFile2.getIsFile())) continue;
				if (nodeFile2.getFileId().longValue()<=nodeFile1.getFileId().longValue()) continue;
					long fSize2 = nodeFile2.getFileSize();
				if ((Math.abs(fSize1-fSize2)>1024) && 
					(((1.0d * fSize1 / fSize2) > 2.0d) || (1.0d * fSize2 / fSize1) > 2.0d)) continue;
				double byteComp = MakeFileSetByteComparison.calculateByteComparison(f10, nodeFile1, nodeFile2, minCompValue);
				//System.out.println("MakeFileSetSimilarity findFileSimilarityPairsByByteComparison fileName2: "+nodeFile2.getFileName()+
				//		"  ,byteComp:"+byteComp);
				if (byteComp>minCompValue)	{
					pairSet.add(new NodePair(nodeFile1, nodeFile2, "file2file_bytecomp",byteComp));
				}
			}
		}
	}
	private static void findFileSimilarityPairsByHashId(NodeF10 f10, HashSet<NodePair> pairSet)	{
		if (f10.getFileSet().getListFile()==null) return;
		HashMap<Long,Integer> mapHashId2Count = new HashMap<Long,Integer>();
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (nodeFile.getHashId()==null) continue;
			if (!"true".equals(nodeFile.getIsFile())) continue;
			if (mapHashId2Count.get(nodeFile.getHashId())==null)	{mapHashId2Count.put(nodeFile.getHashId(),1);}
			int cnt = mapHashId2Count.get(nodeFile.getHashId());
			mapHashId2Count.put(nodeFile.getHashId(),cnt + 1);
		}
		for (NodeFile nodeFile1 : f10.getFileSet().getListFile())	{
			if (nodeFile1.getHashId()==null) continue;
			if (!"true".equals(nodeFile1.getIsFile())) continue;
			if (mapHashId2Count.get(nodeFile1.getHashId())==null) continue;
			int cnt1  = mapHashId2Count.get(nodeFile1.getHashId()).intValue(); 	
			if ((cnt1<2) || (cnt1>10)) continue; //more than 10, too many comparisons n^2 
			for (NodeFile nodeFile2 : f10.getFileSet().getListFile())	{
				if (nodeFile2.getFileId().longValue()<=nodeFile1.getFileId().longValue()) continue;
				if (nodeFile2.getHashId()==null) continue;
				if (nodeFile2.getHashId().longValue()!=nodeFile1.getHashId().longValue()) continue;
				pairSet.add(new NodePair(nodeFile1, nodeFile2, "file2file_hash",1.0d));
			}	
		}
	}
	private static void findDirectorySimilarityPairsByHashId(NodeF10 f10, HashSet<NodePair> pairSet)	{
		if (f10.getFileSet().getListFile()==null) return;
		HashMap<Long,Integer> mapHashId2Count = new HashMap<Long,Integer>();
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if (nodeFile.getHashId()==null) continue;
			if (!"true".equals(nodeFile.getIsDirectory())) continue;
			if (mapHashId2Count.get(nodeFile.getHashId())==null)	{mapHashId2Count.put(nodeFile.getHashId(),1);}
			int cnt = mapHashId2Count.get(nodeFile.getHashId());
			mapHashId2Count.put(nodeFile.getHashId(),cnt + 1);
		}
		for (NodeFile nodeFile1 : f10.getFileSet().getListFile())	{
			if (nodeFile1.getHashId()==null) continue;
			if (!"true".equals(nodeFile1.getIsDirectory())) continue;
			if (mapHashId2Count.get(nodeFile1.getHashId())==null) continue;
			int cnt1  = mapHashId2Count.get(nodeFile1.getHashId()); 	
			if ((cnt1<2) || (cnt1>10)) continue; //more than 10, too many comparisons n^2 
			for (NodeFile nodeFile2 : f10.getFileSet().getListFile())	{
				if (nodeFile2.getFileId().longValue()<=nodeFile1.getFileId().longValue()) continue;
				if (nodeFile2.getHashId()==null) continue;
				if (nodeFile2.getHashId().longValue()!=nodeFile1.getHashId().longValue()) continue;
				pairSet.add(new NodePair(nodeFile1, nodeFile2, "dir2dir_hash",1.0d));
			}	
		}
	}
	
	private static double fileNameSimilarityScore(String filenameStr1,String filenameStr2) {
		double similarityScore = 0.0d; 
		return(similarityScore);
	}
	private static final double minFileNameSmilarityScore = 0.8d;
	
	private static void findFileSimilarityPairsByFileName(NodeF10 f10, HashSet<NodePair> pairSet)	{
		if (f10.getFileSet().getListFile()==null) return;
		for (NodeFile nodeFile1 : f10.getFileSet().getListFile())	{
			if (!"true".equals(nodeFile1.getIsFile())) continue;
			if (nodeFile1.getFileName()==null) continue;
			for (NodeFile nodeFile2 : f10.getFileSet().getListFile())	{
				if (!"true".equals(nodeFile2.getIsFile())) continue;
				if (nodeFile2.getFileId().longValue()<=nodeFile1.getFileId().longValue()) continue;
				if (nodeFile2.getFileName()==null) continue;
				if (nodeFile2.getFileName().equals(nodeFile1.getFileName()))	{
					pairSet.add(new NodePair(nodeFile1, nodeFile2, "file2file_samename",1.0d));
				} else {
					double simValue = fileNameSimilarityScore(nodeFile2.getFileName(),nodeFile1.getFileName());
					if (simValue > minFileNameSmilarityScore) {
						pairSet.add(new NodePair(nodeFile1, nodeFile2, "file2file_similar",simValue));
					}	
				}
			}	
		}
	}
	private static void findDirectorySimilarityPairsByFileName(NodeF10 f10, HashSet<NodePair> pairSet)	{
		if (f10.getFileSet().getListFile()==null) return;
		for (NodeFile nodeFile1 : f10.getFileSet().getListFile())	{
			if (nodeFile1.getFileName()==null) continue;
			if (!"true".equals(nodeFile1.getIsDirectory())) continue;
			for (NodeFile nodeFile2 : f10.getFileSet().getListFile())	{
				if (!"true".equals(nodeFile2.getIsDirectory())) continue;
				if (nodeFile2.getFileId().longValue()<=nodeFile1.getFileId().longValue()) continue;
				if (nodeFile2.getFileName()==null) continue;
				if (nodeFile2.getFileName().equals(nodeFile1.getFileName()))	{
					pairSet.add(new NodePair(nodeFile1, nodeFile2, "dir2dir_samename",1.0d));
				} else {
					double simValue = fileNameSimilarityScore(nodeFile2.getFileName(),nodeFile1.getFileName());
					if (simValue > minFileNameSmilarityScore) {
						pairSet.add(new NodePair(nodeFile1, nodeFile2, "dir2dir_similar",simValue));
					}	
				}
			}	
		}
	}
	private static final String[] algArray = new String[] {
			"weightedAverage","file2file_bytecomp","file2file_hash","dir2dir_hash",
			"file2file_samename","file2file_similar","dir2dir_samename","dir2dir_similar"};
	
	public static void createSimilarities(NodeF10 f10, HashSet<NodePair> pairSet)	{
		findFileSimilarityPairsByHashId(f10, pairSet);
		findFileSimilarityPairsByFileName(f10, pairSet);
		findFileSimilarityPairsByByteComparison(f10, pairSet);
		
		findDirectorySimilarityPairsByHashId(f10, pairSet);
		findDirectorySimilarityPairsByFileName(f10, pairSet);
		
		//5-10 other similarity algorithms will be added
		
	}
}
