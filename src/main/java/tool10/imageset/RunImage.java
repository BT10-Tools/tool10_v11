package tool10.imageset;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.DbManager;

public class RunImage {
		
	public static void runImage4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunImage runImage4FileSet creating images for files in the fileSet");
		
		DbManager.createImageDatabase(f10);
	
		NodeImageSet imageSet = MakeImageSet.makeImageSetFromFileSet(f10);
		ReadImageTablesFromDb.postProcessImageSet(f10.getImageSet());
		
		MakeImageSetImageAndBlob.createImageAndBlob(f10);
		
		WriteImageTablesToDb.writeImageSetTables(f10.getConnImage().getConn(), imageSet);
		
	//	long imageSetId = 1; //imageSet.getImageSetId();
	//	NodeImageSet readImageSet = readImageSet(conn, imageSetId);
		
			
	}
}
