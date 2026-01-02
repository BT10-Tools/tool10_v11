package tool10.mediaset;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.DbManager;

public class RunImage {
		
	public static void runImage4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunImage runImage4FileSet creating images for files in the fileSet");
		
		DbManager.createMediaDatabase(f10);
	
		NodeMediaSet mediaSet = MakeImageSet.makeMediaSetFromFileSet(f10);
		ReadMediaSetTablesFromDb.postProcessMediaSet(f10.getMediaSet());
		
		MakeMediaSetImageAndBlob.createImageAndBlob(f10);
		
		WriteMediaSetTablesToDb.writeMediaSetTables(f10.getConnMedia().getConn(), mediaSet);
		
	//	long imageSetId = 1; //imageSet.getImageSetId();
	//	NodeImageSet readImageSet = readImageSet(conn, imageSetId);
		
			
	}
}
