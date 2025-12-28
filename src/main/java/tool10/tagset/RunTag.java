package tool10.tagset;

import java.sql.Connection;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;
import tool10.sql.DbManager;

public class RunTag {
	
	private static NodeTagEngine createTagEngine(Connection conn, NodeTagSet tagSet, String tagEngineType)	{
    	NodeTagEngine tagEngine = null;
    	if ("WinFile".equals(tagEngineType))	{
    		String tagEngineName = "tagEngineWinFile01";
    		tagEngine = TagEngineWinFile.createTagEngineWinFile(conn, tagSet, tagEngineType, tagEngineName);
    	} else if ("LinuxFile".equals(tagEngineType))	{
    	} else if ("TikaTag".equals(tagEngineType))	{
    		String tagEngineName = "tagEngineTikaTag01";
    		tagEngine = TagEngineTikaTag.createTagEngineTikaTag(conn, tagSet, tagEngineType, tagEngineName);
    	} else if ("TikaContent".equals(tagEngineType))	{
    		String tagEngineName = "tagEngineTikaContent01";
    		tagEngine = TagEngineTikaContent.createTagEngineTikaContent(conn, tagSet, tagEngineType, tagEngineName);
    	} else if ("OpenCVImage".equals(tagEngineType))	{
    	} else if ("FfmpegVideo".equals(tagEngineType))	{
    	}
    	System.out.println("createTagEngine: tagEngineType ="+tagEngineType+" , tagEngine.getTagEngineShortName()="+tagEngine.getTagEngineShortName());
		return (tagEngine);
	}	
    private static NodeTagSet createTagSet(NodeF10 f10,  NodeTagEngine[] tagEngineArray)	{
    	
    	NodeTagSet tagSet = MakeTagSet.makeTagSetFromFileSet(f10); 
		for (NodeTagEngine tagEngine : tagEngineArray)	{
			if (tagEngine!=null)	{
				tagEngine.setTagSetId(tagSet.getTagSetId());
				tagSet.getListTagEngine().add(tagEngine);
				tagSet.getMapId2TagEngine().put(tagEngine.getTagEngineId(), tagEngine);
			}
		}
		return (tagSet);
	}	
    public static void  runTagSet(NodeF10 f10, NodeTagSet tagSet, NodeTagEngine[] tagEngineArray)	{
    	if (tagSet==null) return;
		for (NodeTagEngine tagEngine : tagEngineArray)	{
			if (tagEngine!=null)	{
				if ("WinFile".equals(tagEngine.getTagEngineType()))				{TagEngineWinFile.runTagEngineWinFile(f10, tagEngine);}
				//else if ("TikaTag".equals(tagEngine.getTagEngineType()))		{TagEngineTikaTag.runTagEngineTikaTag(f10, tagEngine);}
				else if ("TikaContent".equals(tagEngine.getTagEngineType()))	{TagEngineTikaContent.runTagEngineTikaContent(f10, tagEngine);}			
			}
		}
	}	
    public static NodeTagSet readTagSet(NodeF10 f10,long TagSetId)	{
    	NodeTagSet readTagSet = ReadTagTablesFromDb.readTagSetTables(f10.getConnTag().getConn(), TagSetId);
    	return(readTagSet);
    }
	private static void runTag(NodeF10 f10) {
        
		//OpenCVImage,FfmpegVideo,LinuxFile 
        NodeTagEngine tagEngineWinFile = createTagEngine(f10.getConnTag().getConn(), null, "WinFile"); 
        NodeTagEngine tagEngineTikaTag = createTagEngine(f10.getConnTag().getConn(), null, "TikaTag"); 
        NodeTagEngine tagEngineTikaContent = createTagEngine(f10.getConnTag().getConn(), null, "TikaContent"); 
	    
        //NodeTagEngine[] tagEngineArray = new NodeTagEngine[] {tagEngineWinFile, tagEngineTikaTag, tagEngineTikaContent};
        NodeTagEngine[] tagEngineArray = new NodeTagEngine[] {tagEngineTikaTag};
        
		NodeTagSet tagSet = createTagSet(f10, tagEngineArray); 
		
		runTagSet(f10, tagSet, tagEngineArray);
		
		WriteTagTablesToDb.writeTagSetTables(f10.getConnTag().getConn(), tagSet);
	
		long TagSetId = tagSet.getTagSetId();
		NodeTagSet readTagSet = readTagSet(f10, TagSetId);
		
		f10.getConnTag().closeConnection();
    }
	
	public static void runTag4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunTag runTag4FileSet creating tags for files in the fileSet");
		
		DbManager.createTagDatabase(f10);
		runTag(f10);
			
	}
}
