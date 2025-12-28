package tool10.tagset;

import java.sql.Connection;

import tool10.f10.NodeF10;

public class TagEngineTikaTag {


	public static NodeTagEngine createTagEngineTikaTag(Connection conn,NodeTagSet tagSet,String tagEngineType, String tagEngineName)	{
		NodeTagEngine tagEngine = TagEngineCommon.createTagEngine(conn, tagSet, tagEngineType, tagEngineName, "tikaTag", tagEngineName+"_DESC");
		return(tagEngine);
	}
	//********************************
	private static void createTagForOneTagFile(NodeF10 f10,NodeTagFile tagFile,NodeTagEngine tagEngine)	{
		if (tagFile==null) return;
		String filename = tagFile.getSourceAbsolutePath();
		NodeTaggerTikaTag tikaTag = new NodeTaggerTikaTag(tagFile.getTagFileId());
		
		TaggerTikaTag.getTikaTags(tikaTag,filename);
		long displayCnt = 1l;
		for (String key : tikaTag.getMapAttribute().keySet())	{
			String val = tikaTag.getMapAttribute().get(key);
			TagEngineCommon.createTag(f10,tikaTag.getTagFileId(),key,val, displayCnt++);
		}
	}
	public static void runTagEngineTikaTag(NodeF10 f10,NodeTagEngine tagEngine)	{
		System.out.println("TagEngineTikaTag runTagEngineTikaTag tagSet = "+f10.getTagSet() +" ,tagEngine="+tagEngine);
		if ((f10.getTagSet()==null) || (tagEngine==null)) return;
		
		for (NodeTagFile tagFile : f10.getTagSet().getListTagFile())	{
			//System.out.println("runTagEngineTikaTag tagFile = "+tagFile.getSourceAbsolutePath());
			createTagForOneTagFile(f10, tagFile, tagEngine);
		}
	}
}
