package tool10.tagset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

import tool10.fileset.nodes.NodeBinary;

public class ReadTagTablesFromDb {
	
	public static int readTagSetTableEmbedded(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT embeddedId,tagFileId,tagSetId,embeddingType,tmpFileAbsolutePath,tmpFileName,embeddedSize,displayOrder,"+
				 		"embeddedBytes,crc64,creationDate "+
				 		"FROM TAG_EMBEDDED WHERE tagSetId= ? ORDER BY tagSetId, embeddedId";
		//public NodeEmbedded(Long embeddedId, Long tagFileId, Long tagSetId, String embeddingType,
		//String tmpFileAbsolutePath, String tmpFileName, Long embeddedSize, Long displayOrder,NodeBinary embeddedBinary,
		//byte[] embeddedBytes, Long crc64, ZonedDateTime creationDate)
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long embeddedId = rs.getLong("embeddedId");  	if (rs.wasNull()) {embeddedId = null;}
		    	Long tagFileId = rs.getLong("tagFileId");  	if (rs.wasNull()) {tagFileId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	String embeddingType = rs.getString("embeddingType");
		    	String tmpFileAbsolutePath = rs.getString("tmpFileAbsolutePath");
		        String tmpFileName = rs.getString("tmpFileName");
		        Long embeddedSize = rs.getLong("embeddedSize");  	if (rs.wasNull()) {embeddedSize = null;}
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        byte[] embeddedBytes= rs.getBytes("embeddedBytes");  	if (rs.wasNull()) {embeddedBytes = null;}
			    Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
			    NodeBinary embeddedBinary = new NodeBinary(embeddedSize,crc64, embeddedBytes);
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeEmbedded embedded = new NodeEmbedded(embeddedId,tagFileId,tagSetId,embeddingType,tmpFileAbsolutePath,tmpFileName,embeddedSize,displayOrder,
			    		embeddedBinary,embeddedBytes,crc64,creationDate);
			    tagSet.getListEmbedded().add(embedded);
			    tagSet.getMapId2Embedded().put(embedded.getEmbeddedId(),embedded);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableEmbedded: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTagEngine(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagEngineId,tagSetId,tagEngineType,tagEngineName,tagEngineShortName,tagEngineDesc,displayOrder,creationDate "+
				 		"FROM TAG_TAGENGINE WHERE tagSetId= ? ORDER BY tagSetId, tagEngineId";
		//public NodeTagEngine(Long tagEngineId, Long tagSetId, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc,
		//Long displayOrder, ZonedDateTime creationDate)
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagEngineId = rs.getLong("tagEngineId");  	if (rs.wasNull()) {tagEngineId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	String tagEngineType = rs.getString("tagEngineType");
		    	String tagEngineName = rs.getString("tagEngineName");
		        String tagEngineShortName = rs.getString("tagEngineShortName");
		        String tagEngineDesc = rs.getString("tagEngineDesc");
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTagEngine tagEngine = new NodeTagEngine(tagEngineId,tagSetId, tagEngineType, tagEngineName,tagEngineShortName,tagEngineDesc,displayOrder,creationDate);
			    tagSet.getListTagEngine().add(tagEngine);
			    tagSet.getMapId2TagEngine().put(tagEngine.getTagEngineId(),tagEngine);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTagEngine: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTagStr(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagStrId,tagSetId,tagTypeId,tagType,strType,strLength,tagStr,crc64,creationDate "+
				 		"FROM TAG_TAGSTR WHERE tagSetId= ? ORDER BY tagSetId, tagStrId";
		//public NodeTagStr(Long tagStrId, Long tagSetId, Long tagTypeId, String tagType, String strType, Long strLength, String tagStr,Long crc64, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagStrId = rs.getLong("tagStrId");  	if (rs.wasNull()) {tagStrId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	Long tagTypeId = rs.getLong("tagTypeId");  	if (rs.wasNull()) {tagTypeId = null;}
		    	String tagType = rs.getString("tagType");
		        String strType = rs.getString("strType");
		        Long strLength = rs.getLong("strLength");  	if (rs.wasNull()) {strLength = null;}
		        String tagString = rs.getString("tagStr");
		        Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTagStr tagStr = new NodeTagStr(tagStrId,tagSetId,tagTypeId,tagType,strType,strLength,tagString,crc64,creationDate);
			    tagSet.getListTagStr().add(tagStr);
			    tagSet.getMapId2TagStr().put(tagStr.getTagStrId(),tagStr);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTagStr: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTagFileType(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagFileTypeId,tagSetId,tagFileTypeName,tagFileTypeDesc,primaryExtension,detectedExtensionListString,displayOrder,creationDate "+
				 		"FROM TAG_TAGFILETYPE WHERE tagSetId= ? ORDER BY tagSetId, tagFileTypeId";
		//public NodeTagFileType(Long tagFileTypeId, Long tagSetId, String tagFileTypeName, String tagFileTypeDesc,
		//String fileExtensionName, Long displayOrder, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagFileTypeId = rs.getLong("tagFileTypeId");  	if (rs.wasNull()) {tagFileTypeId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	String tagFileTypeName = rs.getString("tagFileTypeName");
		        String tagFileTypeDesc = rs.getString("tagFileTypeDesc");
		        String primaryExtension = rs.getString("primaryExtension");
		        String detectedExtensionListString  = rs.getString("detectedExtensionListString");
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTagFileType tagFileType = new NodeTagFileType(tagFileTypeId,tagSetId,tagFileTypeName,tagFileTypeDesc,primaryExtension, detectedExtensionListString,displayOrder, creationDate);
			    tagSet.getListTagFileType().add(tagFileType);
			    tagSet.getMapId2TagFileType().put(tagFileType.getTagFileTypeId(),tagFileType);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTagFileType: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTagFile(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagFileId,tagSetId,tagFileTypeId,sourceId,sourceAbsolutePath,sourceDirName,SourceFileName,sourceExtensionName,"+
				 		"  		sourceFileSize,sourceFileCreationDate,sourceFileModificationDate,creationDate "+
				 		"FROM TAG_TAGFILE WHERE tagSetId= ? ORDER BY tagSetId, tagFileId";
		//public NodeTagFile(Long tagFileId, Long tagSetId, Long tagFileTypeId, Long sourceId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime sourceFileModificationDate, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagFileId = rs.getLong("tagFileId");  	if (rs.wasNull()) {tagFileId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	Long tagFileTypeId = rs.getLong("tagFileTypeId");  	if (rs.wasNull()) {tagFileTypeId = null;}
		    	Long sourceId = rs.getLong("sourceId");  	if (rs.wasNull()) {sourceId = null;}
		        String sourceAbsolutePath = rs.getString("sourceAbsolutePath");
		        String sourceDirName = rs.getString("sourceDirName");
		        String SourceFileName = rs.getString("SourceFileName");
		        String sourceExtensionName = rs.getString("sourceExtensionName");
		        Long sourceFileSize = rs.getLong("sourceFileSize");  	if (rs.wasNull()) {sourceFileSize = null;}
		        
		        String sourceFileCreationDateStr = rs.getString("sourceFileCreationDate");
			    ZonedDateTime sourceFileCreationDate = ((sourceFileCreationDateStr!=null) ? ZonedDateTime.parse(sourceFileCreationDateStr) : null);
			    String sourceFileModificationDateStr = rs.getString("sourceFileModificationDate");
			    ZonedDateTime sourceFileModificationDate = ((sourceFileModificationDateStr!=null) ? ZonedDateTime.parse(sourceFileModificationDateStr) : null);
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTagFile tagFile = new NodeTagFile(tagFileId,tagSetId,tagFileTypeId,sourceId,sourceAbsolutePath,sourceDirName,SourceFileName,sourceExtensionName,
			    		sourceFileSize,sourceFileCreationDate,sourceFileModificationDate, creationDate);
			    tagSet.getListTagFile().add(tagFile);
			    tagSet.getMapId2TagFile().put(tagFile.getTagFileId(),tagFile);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTagFile: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTagType(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagTypeId,tagFileTypeId,tagSetId,tagTypeName,tagTypeDesc,tagVariableDataType,displayOrder,creationDate "+
				 		"FROM TAG_TAGTYPE WHERE tagSetId= ? ORDER BY tagSetId, tagTypeId";
		//public NodeTagType(Long tagTypeId, Long tagFileTypeId, Long tagSetId, String tagTypeName, String tagTypeDesc,
		//String tagVariableDataType, Long displayOrder, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagTypeId = rs.getLong("tagTypeId");  	if (rs.wasNull()) {tagTypeId = null;}
		    	Long tagFileTypeId = rs.getLong("tagFileTypeId");  	if (rs.wasNull()) {tagFileTypeId = null;}
		    	Long tagSetId = rs.getLong("tagSetId");  	if (rs.wasNull()) {tagSetId = null;}
		    	String tagTypeName = rs.getString("tagTypeName");
		        String tagTypeDesc = rs.getString("tagTypeDesc");
		        String tagVariableDataType = rs.getString("tagVariableDataType");
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTagType tagType = new NodeTagType(tagTypeId,tagFileTypeId,tagSetId,tagTypeName,tagTypeDesc,tagVariableDataType,displayOrder, creationDate);
			    tagSet.getListTagType().add(tagType);
			    tagSet.getMapId2TagType().put(tagType.getTagTypeId(),tagType);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTagType: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readTagSetTableTag(Connection conn,NodeTagSet tagSet)	{
		int cntRead = 0;
		String query = 	"SELECT tagId,tagFileId,tagTypeId,tagStrId,displayOrder,keyName,"+
				 		"  		valueStr,valueLength,valueLong,valueDouble, valueBoolean,valueZDT, creationDate "+
				 		"FROM TAG_TAG WHERE tagFileId in (SELECT tagFileId FROM TAG_TAGFILE WHERE tagSetId= ?) ORDER BY tagId";
		//public NodeTag(Long tagId, Long tagFileId, Long tagTypeId, Long tagStrId, Long displayOrder, String keyName,
		//String valueStr, Long valueLength, Long valueLong, Double valueDouble, String valueBoolean,ZonedDateTime valueZDT, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSet.getTagSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tagId = rs.getLong("tagId");  	if (rs.wasNull()) {tagId = null;}
		    	Long tagFileId = rs.getLong("tagFileId");  	if (rs.wasNull()) {tagFileId = null;}
		    	Long tagTypeId = rs.getLong("tagTypeId");  	if (rs.wasNull()) {tagTypeId = null;}
		    	Long tagStrId = rs.getLong("tagStrId");  	if (rs.wasNull()) {tagStrId = null;}
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        String keyName = rs.getString("keyName");
		        String valueStr = rs.getString("valueStr");
		        Long valueLength = rs.getLong("valueLength");  	if (rs.wasNull()) {valueLength = null;}
		        Long valueLong = rs.getLong("valueLong");  	if (rs.wasNull()) {valueLong = null;}
		        Double valueDouble = rs.getDouble("valueDouble");  	if (rs.wasNull()) {valueDouble = null;}
		        String valueBoolean = rs.getString("valueBoolean");
		        String valueZDTStr = rs.getString("valueZDT");
			    ZonedDateTime valueZDT = ((valueZDTStr!=null) ? ZonedDateTime.parse(valueZDTStr) : null);	
			    String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeTag tag = new NodeTag(tagId,tagFileId,tagTypeId,tagStrId,displayOrder,keyName,
			    		valueStr,valueLength,valueLong,valueDouble, valueBoolean,valueZDT, creationDate);
			    tagSet.getListTag().add(tag);
			    tagSet.getMapId2Tag().put(tag.getTagId(),tag);  
			    cntRead++;
		    }
		    System.out.println("readTagSetTableTag: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static NodeTagSet readTagSetTableTagSet(Connection conn,long tagSetId)	{
		NodeTagSet tagSet = null;
		String query = 	"SELECT tagSetId,fileSetId,tagSetName,tagSetDescription,sourceName,sourceURL,creationDate \n"+
						"FROM TAG_TAGSET WHERE tagSetId= ? ORDER BY tagSetId";
		//public NodeTagSet(Long tagSetId, Long fileSetId, String tagSetName, String tagSetDescription, String sourceName, String sourceURL,ZonedDateTime creationDate) { 
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, tagSetId); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long tagSetId2 = rs.getLong("tagSetId");
		        Long fileSetId = rs.getLong("fileSetId");
		        String tagSetName = rs.getString("tagSetName");
		        String tagSetDescription = rs.getString("tagSetDescription");
		        String sourceName = rs.getString("sourceName");
		        String sourceURL = rs.getString("sourceURL");
		        String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    tagSet = new NodeTagSet(tagSetId,fileSetId,tagSetName,tagSetDescription,sourceName,sourceURL,creationDate);
		    }
		    System.out.println("readTagSetTableTagSet: tagSet = " + tagSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(tagSet);
	}
	public static NodeTagSet readTagSet(Connection conn, long tagSetId) {
		NodeTagSet tagSet = readTagSetTableTagSet(conn, tagSetId);
		if (tagSet==null) return (null);
		int cntReadTag = readTagSetTableTag(conn,tagSet);
		int cntReadTagType = readTagSetTableTagType(conn,tagSet);
		int cntReadTagFile = readTagSetTableTagFile(conn,tagSet);
		int cntReadTagFileType = readTagSetTableTagFileType(conn,tagSet);
		int cntReadTagStr = readTagSetTableTagStr(conn,tagSet);
		int cntReadTagEngine = readTagSetTableTagEngine(conn,tagSet);
		int cntReadEmbedded = readTagSetTableEmbedded(conn,tagSet);
		
		postProcessTagSet(tagSet);
		
		int cntRead = cntReadTag + cntReadTagType + cntReadTagFile + cntReadTagFileType + cntReadTagStr + cntReadTagEngine + cntReadEmbedded + 1;
	    System.out.println("readTagSet: total recordS read = " + cntRead);
		return(tagSet);
	}	
	public static void postProcessTagSet(NodeTagSet tagSet)	{
		//for (NodeImageFile imageFile : imageSet.getListTagFile())	{	imageSet.getMapPath2ImageFile().put(imageFile.getSourceAbsolutePath(), imageFile); }
		
		//private HashMap<String,NodeParagraph> mapStr2Paragraph;
		//private HashMap<String,NodeSentence> mapStr2Sentence;
		//private HashMap<String,NodeToken> mapStr2Token;
	//	for (NodeParagraph paragraph : library.getListParagraph())	{	library.getMapStr2Paragraph().put(paragraph.getParagraphStr(), paragraph); }
	//	for (NodeSentence sentence : library.getListSentence())		{	library.getMapStr2Sentence().put(sentence.getSentenceStr(), sentence); }
	//	for (NodeToken token : library.getListToken())				{	library.getMapStr2Token().put(token.getTokenStr(), token); }		
	}
	public static NodeTagSet readTagSetTables(Connection conn, long tagSetId)	{
		
		NodeTagSet tagSet = readTagSet(conn,tagSetId);
		if (tagSet!=null)	{
			
			System.out.println("tagSet.getListTag().size() = "+tagSet.getListTag().size());
			System.out.println("tagSet.getListTagType().size() = "+tagSet.getListTagType().size());
			System.out.println("tagSet.getListTagFile().size() = "+tagSet.getListTagFile().size());
			System.out.println("tagSet.getListTagFileType().size() = "+tagSet.getListTagFileType().size());
			System.out.println("tagSet.getListTagStr().size() = "+tagSet.getListTagStr().size());
			System.out.println("tagSet.getListTagEngine().size() = "+tagSet.getListTagEngine().size());
			System.out.println("tagSet.getListEmbedded().size() = "+tagSet.getListEmbedded().size());
			
			System.out.println("tagSet.getMapId2Tag().size() = "+tagSet.getMapId2Tag().size());
			System.out.println("tagSet.getMapId2TagType().size() = "+tagSet.getMapId2TagType().size());
			System.out.println("tagSet.getMapId2TagFile().size() = "+tagSet.getMapId2TagFile().size());
			System.out.println("tagSet.getMapId2TagFileType().size() = "+tagSet.getMapId2TagFileType().size());
			System.out.println("tagSet.getMapId2TagStr().size() = "+tagSet.getMapId2TagStr().size());
			System.out.println("tagSet.getMapId2TagEngine().size() = "+tagSet.getMapId2TagEngine().size());
			System.out.println("tagSet.getMapId2Embedded().size() = "+tagSet.getMapId2Embedded().size());
			
		} else {
			System.out.println("readTagSetTables: tagSet is null");
		}
		return (tagSet);
	}
	
}