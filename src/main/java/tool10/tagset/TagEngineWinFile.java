package tool10.tagset;

import java.sql.Connection;

import tool10.f10.NodeF10;

public class TagEngineWinFile {

	public static NodeTagEngine createTagEngineWinFile(Connection conn,NodeTagSet tagSet, String tagEngineType, String tagEngineName)	{
		NodeTagEngine tagEngine = TagEngineCommon.createTagEngine(conn, tagSet, tagEngineType, tagEngineName, "winFile", tagEngineName+"_DESC");
		return(tagEngine);
	}
	private static void createTagForOneTagFile(NodeF10 f10,NodeTagFile tagFile,NodeTagEngine tagEngine)	{
		if (tagFile==null) return;
		String filename = tagFile.getSourceAbsolutePath();
		NodeTaggerWinFile winFileTag = new NodeTaggerWinFile(tagFile.getTagFileId());
		TaggerWinFile.getWinFileTags(winFileTag,filename);
		long displayCnt = 1l;
		for (String key : winFileTag.getMapAttribute().keySet())	{
			String val = winFileTag.getMapAttribute().get(key);
			TagEngineCommon.createTag(f10,winFileTag.getTagFileId(),key,val, displayCnt++);
		}
	}
	public static void runTagEngineWinFile(NodeF10 f10,NodeTagEngine tagEngine)	{
		System.out.println("runTagEngineWinFile tagSet = "+f10.getTagSet() +" ,tagEngine="+tagEngine);
		if ((f10.getTagSet()==null) || (tagEngine==null)) return;
		
		for (NodeTagFile tagFile : f10.getTagSet().getListTagFile())	{
			//System.out.println("runTagEngineWinFile tagFile = "+tagFile.getSourceAbsolutePath());
			createTagForOneTagFile(f10, tagFile, tagEngine);
		}
	}
}
