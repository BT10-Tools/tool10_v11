package tool10.tagset;

import java.sql.Connection;
import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.sql.JLite;

public class TagEngineCommon {

	static final int MINTAGSTRLENGTH = 64;
	static final int MAXTAGSTRLENGTH = 1000*1000;

	public static NodeTagEngine createTagEngine(Connection conn,NodeTagSet tagSet, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc)	{
		NodeTagEngine tagEngine = null;
		
		//public NodeTagEngine(Long tagEngineId, Long tagSetId, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc,Long displayOrder, ZonedDateTime creationDate) {
		
		Long tagEngineId = JLite.getNextId(conn, "TAG_TAGENGINE");
		Long tagSetId = (tagSet==null) ? null : tagSet.getTagSetId();
		Long displayOrder = 1l; 
		ZonedDateTime creationDate = ZonedDateTime.now();
		
	    tagEngine = new NodeTagEngine(tagEngineId,tagSetId,tagEngineType, tagEngineName,tagEngineShortName,tagEngineDesc,displayOrder,creationDate);
	    if (tagSet!=null)	{
	    	tagSet.getListTagEngine().add(tagEngine);
	    	tagSet.getMapId2TagEngine().put(tagEngine.getTagEngineId(),tagEngine);  
	    }
		return(tagEngine);
	}
	private static void createTagStr(NodeF10 f10,NodeTag tag) { //Long tagFileId,String key,String val, Long tagTypeId,String tagType,String strType)	{
		String val = tag.getValueStr();
		if (val==null) return;
		long valLength = val.length();
		if ((valLength<MINTAGSTRLENGTH) || (valLength>MAXTAGSTRLENGTH)) return;
		NodeTagStr tagStr = null;
		if (f10.getTagSet().getMapStr2TagStr().get(val)==null)	{
			//public NodeTagStr(Long tagStrId, Long tagSetId, Long tagTypeId, String tagType, String strType, Long strLength, String tagStr,
			//Long crc64, ZonedDateTime creationDate) {
			Long tagStrId = f10.getConnTag().getNextId(-1); //"TAG_TAGSTR");
	    	Long tagSetId = f10.getTagSet().getTagSetId();
	    	String tagType = null; 
	    	String strType = null;
	    	String tagString = val;
	        Long strLength = valLength;
	        Long crc64 = null;
		    ZonedDateTime creationDate = ZonedDateTime.now(); 	
		    tagStr = new NodeTagStr(tagStrId,tagSetId,tag.getTagTypeId(),tagType, strType,strLength,tagString,crc64,creationDate);
		    f10.getTagSet().getListTagStr().add(tagStr);
		    f10.getTagSet().getMapId2TagStr().put(tagStr.getTagStrId(),tagStr);  
		    f10.getTagSet().getMapStr2TagStr().put(val,tagStr);
		} else {
			tagStr = f10.getTagSet().getMapStr2TagStr().get(val);
		}
		tag.setTagStrId(tagStr.getTagStrId());
	}

	public static void createTag(NodeF10 f10,Long tagFileId,String key,String val, long displayCnt)	{
		//public NodeTag(Long tagId, Long tagFileId, Long tagTypeId, Long tagStrId, Long displayOrder, String keyName,
		//String valueStr, Long valueLength, Long valueLong, Double valueDouble, String valueBoolean,ZonedDateTime valueZDT, ZonedDateTime creationDate) {
		
		Long tagId = f10.getConnTag().getNextId(-1); //"TAG_TAG");
    	Long tagTypeId = null; 
    	Long tagStrId = null; 
    	Long displayOrder = displayCnt; 
        String keyName = key; 
        String valueStr = val;
        Long valueLength = null; 
        Long valueLong = null; 
        Double valueDouble = null; 
        String valueBoolean = null; 
        ZonedDateTime valueZDT = null; 	
	    ZonedDateTime creationDate = ZonedDateTime.now(); 	
	    NodeTag tag = new NodeTag(tagId,tagFileId,tagTypeId,tagStrId,displayOrder,keyName,
	    		valueStr,valueLength,valueLong,valueDouble, valueBoolean,valueZDT, creationDate);
	    f10.getTagSet().getListTag().add(tag);
	    f10.getTagSet().getMapId2Tag().put(tag.getTagId(),tag);  
	    
	    createTagStr(f10, tag); //Long tagFileId,String key,String val, Long tagTypeId,String tagType,String strType)
	}
}
