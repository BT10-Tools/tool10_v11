package tool10.simset;

public class GetByMapSimSet {

	public static void updateAllMapsFileSet(NodeSimSet simSet)	{
		for (NodeSimilarity sim : simSet.getListSimilarity())	{
			if (sim.getSimilarityKey()!=null)	{
				simSet.getMapKey2Similarity().put(sim.getSimilarityKey(),sim);
			}
		}
	}
}
