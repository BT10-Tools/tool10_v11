package tool10.mediaset;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.DbManager;

public class RunMedia {
		
	public static void runImage4FileSet(NodeF10 f10, NodeMediaSet mediaSet, NodeFileSet fileSet)	{
		
		System.out.println("RunMedia runImage4FileSet creating images for files in the fileSet");
		
		ReadMediaSetTablesFromDb.postProcessMediaSet(f10.getMediaSet());
		
		MakeImageAndBlob.createImageAndBlob(f10);
		
	//	long imageSetId = 1; //imageSet.getImageSetId();
	//	NodeImageSet readImageSet = readImageSet(conn, imageSetId);	
	}
	public static void runVideo4FileSet(NodeF10 f10, NodeMediaSet mediaSet, NodeFileSet fileSet)	{
		System.out.println("RunMedia runVideo4FileSet creating videos for files in the fileSet");
		
		MakeVideoAndBlob.createVideoAndBlob(f10);
		
		//NodeMediaSet mediaSet = MakeMediaSet.makeMediaSetFromFileSet(f10);
	}
	
	public static void runAudio4FileSet(NodeF10 f10, NodeMediaSet mediaSet, NodeFileSet fileSet)	{
		System.out.println("RunMedia runAudio4FileSet creating audios for files in the fileSet");
		
		MakeVideoAndBlob.createVideoAndBlob(f10);
	}
	
	
	public static void runMedia4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		String mediaType = f10.getCliParams().getMediaType();
		if (mediaType==null) return;
		if ((!"image".equals(mediaType)) && (!"video".equals(mediaType)) && (!"audio".equals(mediaType))) return;
		
		DbManager.createMediaDatabase(f10);
		
		System.out.println("RunMedia runVideo4FileSet creating "+mediaType+"'s for files in the fileSet");
		NodeMediaSet mediaSet = MakeMediaSet.makeMediaSetFromFileSet(f10, mediaType);
		
		if ("image".equals(mediaType))	{
			runImage4FileSet(f10, mediaSet, fileSet);
		} else if ("video".equals(mediaType))	{
			runVideo4FileSet(f10, mediaSet, fileSet);
		} else if ("audio".equals(mediaType))	{
			runAudio4FileSet(f10, mediaSet, fileSet);
		}
		if  (mediaSet==null) return;
		WriteMediaSetTablesToDb.writeMediaSetTables(f10.getConnMedia().getConn(), mediaSet);
	}
}
