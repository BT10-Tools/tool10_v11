package tool10.tagset;

import java.sql.Connection;

import tool10.f10.NodeF10;

public class TagEngineTikaContent {


	public static NodeTagEngine createTagEngineTikaContent(Connection conn,NodeTagSet tagSet,String tagEngineType,String tagEngineName)	{
		NodeTagEngine tagEngine = TagEngineCommon.createTagEngine(conn, tagSet, tagEngineType, tagEngineName, "tikaContent", tagEngineName+"_DESC");
		return(tagEngine);
	}	
	private static void createTagForOneTagFile(NodeF10 f10,NodeTagFile tagFile,NodeTagEngine tagEngine)	{
		if (tagFile==null) return;
		String filename = tagFile.getSourceAbsolutePath();
		NodeTaggerTikaContent winTikaContent = new NodeTaggerTikaContent(tagFile.getTagFileId());
		TaggerTikaContent.getTikaContent(winTikaContent,filename);
		long displayCnt = 1l;
		for (String key : winTikaContent.getMapAttribute().keySet())	{
			String val = winTikaContent.getMapAttribute().get(key);
			TagEngineCommon.createTag(f10,winTikaContent.getTagFileId(),key,val, displayCnt++);
		}
	}
	public static void runTagEngineTikaContent(NodeF10 f10,NodeTagEngine tagEngine)	{
		System.out.println("runTagEngineTikaContent tagSet = "+f10.getTagSet() +" ,tagEngine="+tagEngine);
		if ((f10.getTagSet()==null) || (tagEngine==null)) return;
		
		for (NodeTagFile tagFile : f10.getTagSet().getListTagFile())	{
			//System.out.println("runTagEngineTikaContent tagFile = "+tagFile.getSourceAbsolutePath());
			createTagForOneTagFile(f10, tagFile, tagEngine);
		}
	}
}
