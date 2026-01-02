package tool10.mediaset;


public class GetByMapMediaSet {

	public static void updateAllMapsMediaSet(NodeMediaSet mediaSet)	{
		for (NodeMediaFile mediaFile : mediaSet.getListMediaFile())		{
			mediaSet.getMapPath2MediaFile().put(mediaFile.getSourceAbsolutePath(), mediaFile);
		}
	}

}
