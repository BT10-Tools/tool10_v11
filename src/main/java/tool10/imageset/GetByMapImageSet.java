package tool10.imageset;


public class GetByMapImageSet {

	public static void updateAllMapsImageSet(NodeImageSet imageSet)	{
		for (NodeImageFile imageFile : imageSet.getListImageFile())		{
			imageSet.getMapPath2ImageFile().put(imageFile.getSourceAbsolutePath(), imageFile);
		}
	}

}
