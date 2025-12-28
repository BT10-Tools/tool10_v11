package tool10.tagset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.ZonedDateTime;

public class WriteTagTablesToDb {
	
	public static int writeTableEmbedded(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_EMBEDDED (embeddedId,tagFileId,tagSetId,embeddingType,tmpFileAbsolutePath,tmpFileName,embeddedSize,displayOrder,embeddedBytes,crc64,creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?)";
		//public NodeEmbedded(Long embeddedId, Long tagFileId, Long tagSetId, String embeddingType,
		//String tmpFileAbsolutePath, String tmpFileName, Long embeddedSize, Long displayOrder,NodeBinary embeddedBinary,	byte[] embeddedBytes, Long crc64, ZonedDateTime creationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeEmbedded embedded : tagSet.getListEmbedded())	{
			    int cnt=1;
			    if (embedded.getEmbeddedId()!=null) {ps.setLong(cnt++, embedded.getEmbeddedId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (embedded.getTagFileId()!=null) {ps.setLong(cnt++, embedded.getTagFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (embedded.getTagSetId()!=null) {ps.setLong(cnt++, embedded.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, embedded.getEmbeddingType());
			    ps.setString(cnt++, embedded.getTmpFileAbsolutePath());
			    ps.setString(cnt++, embedded.getTmpFileName());
			    if (embedded.getEmbeddedSize()!=null) {ps.setLong(cnt++, embedded.getEmbeddedSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (embedded.getDisplayOrder()!=null) {ps.setLong(cnt++, embedded.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (embedded.getEmbeddedBytes()!=null) {ps.setBytes(cnt++, embedded.getEmbeddedBytes()); } 	else {ps.setNull(cnt++,Types.BLOB);}
			    if (embedded.getCrc64()!=null) {ps.setLong(cnt++, embedded.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (embedded.getCreationDate()!=null) {ps.setString(cnt++, embedded.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableEmbedded: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagEngine(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAGENGINE (tagEngineId,tagSetId,tagEngineType, tagEngineName,tagEngineShortName,tagEngineDesc,displayOrder,creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?)";
		//public NodeTagEngine(Long tagEngineId, Long tagSetId, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc,Long displayOrder, ZonedDateTime creationDate) { 
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTagEngine tagEngine : tagSet.getListTagEngine())	{
			    int cnt=1;
			    if (tagEngine.getTagEngineId()!=null) {ps.setLong(cnt++, tagEngine.getTagEngineId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagEngine.getTagSetId()!=null) {ps.setLong(cnt++, tagEngine.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tagEngine.getTagEngineType());
			    ps.setString(cnt++, tagEngine.getTagEngineName());
			    ps.setString(cnt++, tagEngine.getTagEngineShortName());
			    ps.setString(cnt++, tagEngine.getTagEngineDesc());
			    if (tagEngine.getDisplayOrder()!=null) {ps.setLong(cnt++, tagEngine.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagEngine.getCreationDate()!=null) {ps.setString(cnt++, tagEngine.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTagEngine: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagStr(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAGSTR (tagStrId,tagTypeId,tagType,strType,strLength,tagStr,crc64,creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?)";
		//public NodeTagStr(Long tagStrId, Long tagTypeId, String tagType, String strType, Long strLength, String tagStr,
		//Long crc64, ZonedDateTime creationDate) {
		//tagStrId,tagTypeId,tagType,strType,strLength,tagStr,crc64, 
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTagStr tagStr : tagSet.getListTagStr())	{
			    int cnt=1;
			    if (tagStr.getTagStrId()!=null) {ps.setLong(cnt++, tagStr.getTagStrId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagStr.getTagTypeId()!=null) {ps.setLong(cnt++, tagStr.getTagTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tagStr.getTagType());
			    ps.setString(cnt++, tagStr.getStrType());
			    if (tagStr.getStrLength()!=null) {ps.setLong(cnt++, tagStr.getStrLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tagStr.getTagStr());
			    if (tagStr.getCrc64()!=null) {ps.setLong(cnt++, tagStr.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagStr.getCreationDate()!=null) {ps.setString(cnt++, tagStr.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTagStr: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagFileType(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAGFILETYPE (tagFileTypeId,tagSetId,tagFileTypeName,tagFileTypeDesc,primaryExtension,detectedExtensionListString,displayOrder,creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?)";
		//public NodeTagFileType(Long tagFileTypeId, Long tagSetId, String tagFileTypeName, String tagFileTypeDesc,
		//String fileExtensionName, Long displayOrder, ZonedDateTime creationDate) {
		//tagFileTypeId,tagSetId,tagFileTypeName,tagFileTypeDesc,fileExtensionName,displayOrder
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTagFileType tagFileType : tagSet.getListTagFileType())	{
			    int cnt=1;
			    if (tagFileType.getTagFileTypeId()!=null) {ps.setLong(cnt++, tagFileType.getTagFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFileType.getTagSetId()!=null) {ps.setLong(cnt++, tagFileType.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tagFileType.getTagFileTypeName());
			    ps.setString(cnt++, tagFileType.getTagFileTypeDesc());
			    ps.setString(cnt++, tagFileType.getPrimaryExtension()); 
			    ps.setString(cnt++, tagFileType.getDetectedExtensionListString()); 
			    if (tagFileType.getDisplayOrder()!=null) {ps.setLong(cnt++, tagFileType.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFileType.getCreationDate()!=null) {ps.setString(cnt++, tagFileType.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTagFileType: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagFile(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAGFILE (tagFileId, tagSetId, tagFileTypeId, sourceId, sourceAbsolutePath,sourceDirName, sourceFileName, sourceExtensionName, "+
						"	sourceFileSize,sourceFileCreationDate, sourceFileModificationDate, creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeTagFile(Long tagFileId, Long tagSetId, Long tagFileTypeId, Long sourceId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime sourceFileModificationDate, ZonedDateTime creationDate) {
		
		//tagFileId, tagSetId, tagFileTypeId, sourceId, sourceAbsolutePath,sourceDirName, sourceFileName, sourceExtensionName, 
		//sourceFileSize,sourceFileCreationDate, sourceFileModificationDate
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTagFile tagFile : tagSet.getListTagFile())	{
			    int cnt=1;
			    if (tagFile.getTagFileId()!=null) {ps.setLong(cnt++, tagFile.getTagFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFile.getTagSetId()!=null) {ps.setLong(cnt++, tagFile.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFile.getTagFileTypeId()!=null) {ps.setLong(cnt++, tagFile.getTagFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFile.getSourceId()!=null) {ps.setLong(cnt++, tagFile.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    ps.setString(cnt++, tagFile.getSourceAbsolutePath());
			    ps.setString(cnt++, tagFile.getSourceDirName());
			    ps.setString(cnt++, tagFile.getSourceFileName());
			    ps.setString(cnt++, tagFile.getSourceExtensionName());
			    
			    if (tagFile.getSourceFileSize()!=null) {ps.setLong(cnt++, tagFile.getSourceFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagFile.getSourceFileCreationDate()!=null) {ps.setString(cnt++, tagFile.getSourceFileCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (tagFile.getSourceFileModificationDate()!=null) {ps.setString(cnt++, tagFile.getSourceFileModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (tagFile.getCreationDate()!=null) {ps.setString(cnt++, tagFile.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTagFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagType(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAGTYPE (tagTypeId, tagFileTypeId, tagSetId,tagTypeName,tagTypeDesc,tagVariableDataType,displayOrder,creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?)";
		//public NodeTagType(Long tagTypeId, Long tagFileTypeId, Long tagSetId, String tagTypeName, String tagTypeDesc,
		//String tagVariableDataType, Long displayOrder, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTagType tagType : tagSet.getListTagType())	{
			    int cnt=1;
			    if (tagType.getTagTypeId()!=null) {ps.setLong(cnt++, tagType.getTagTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagType.getTagFileTypeId()!=null) {ps.setLong(cnt++, tagType.getTagFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagType.getTagSetId()!=null) {ps.setLong(cnt++, tagType.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tagType.getTagTypeName());
			    ps.setString(cnt++, tagType.getTagTypeDesc());
			    ps.setString(cnt++, tagType.getTagVariableDataType());
			    if (tagType.getDisplayOrder()!=null) {ps.setLong(cnt++, tagType.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tagType.getCreationDate()!=null) {ps.setString(cnt++, tagType.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTagType: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTag(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TAG_TAG (tagId, tagFileId, tagTypeId, tagStrId, displayOrder, keyName, valueStr, valueLength, valueLong, "+
						"	valueDouble, valueBoolean, valueZDT, creationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeTag(Long tagId, Long tagFileId, Long tagTypeId, Long tagStrId, Long displayOrder, String keyName,
		//String valueStr, Long valueLength, Long valueLong, Double valueDouble, String valueBoolean,ZonedDateTime valueZDT, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTag tag : tagSet.getListTag())	{
			    int cnt=1;
			    if (tag.getTagId()!=null) {ps.setLong(cnt++, tag.getTagId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getTagFileId()!=null) {ps.setLong(cnt++, tag.getTagFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getTagTypeId()!=null) {ps.setLong(cnt++, tag.getTagTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getTagStrId()!=null) {ps.setLong(cnt++, tag.getTagStrId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getDisplayOrder()!=null) {ps.setLong(cnt++, tag.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, tag.getKeyName());
			    ps.setString(cnt++, tag.getValueStr());
			    if (tag.getValueLength()!=null) {ps.setLong(cnt++, tag.getValueLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getValueLong()!=null) {ps.setLong(cnt++, tag.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (tag.getValueDouble()!=null) {ps.setDouble(cnt++, tag.getValueDouble());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    
			    ps.setString(cnt++, tag.getValueBoolean());
			    if (tag.getValueZDT()!=null) {ps.setString(cnt++, tag.getValueZDT().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (tag.getCreationDate()!=null) {ps.setString(cnt++, tag.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTag: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTagSet(Connection conn,NodeTagSet tagSet)	{
		int cntInserted = 0;
		String query = 	"INSERT INTO TAG_TAGSET (tagSetId, fileSetId, tagSetName,tagSetDescription,sourceName,sourceURL,creationDate) \n"+
						" VALUES ( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeTagSet(Long tagSetId, Long fileSetId, String tagSetName, String tagSetDescription, String sourceName, String sourceURL,ZonedDateTime creationDate) { 
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (tagSet.getTagSetId()!=null) 	{ps.setLong(cnt++, tagSet.getTagSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (tagSet.getFileSetId()!=null) 	{ps.setLong(cnt++, tagSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    ps.setString(cnt++, tagSet.getTagSetName());
		    ps.setString(cnt++, tagSet.getTagSetDescription());
		    ps.setString(cnt++, tagSet.getSourceName());
		    ps.setString(cnt++, tagSet.getSourceURL());
		    if (tagSet.getCreationDate()!=null) {ps.setString(cnt++, tagSet.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableTagSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTagSet(Connection conn,  NodeTagSet tagSet)	{
		int cntInsertedTagSet = writeTableTagSet(conn,tagSet);
		int cntInsertedTag = writeTableTag(conn,tagSet);
		int cntInsertedTagType = writeTableTagType(conn,tagSet);
		int cntInsertedTagFile = writeTableTagFile(conn,tagSet);
		int cntInsertedTagFileType = writeTableTagFileType(conn,tagSet);
		int cntInsertedTagStr = writeTableTagStr(conn,tagSet);
		int cntInsertedTagEngine = writeTableTagEngine(conn,tagSet);
		int cntInsertedEmbedded = writeTableEmbedded(conn,tagSet);
		
		/*System.out.println(deleteTable (conn,"TAG_TAGSET") + " rows deleted from table TAG_TAGSET");
		System.out.println(deleteTable (conn,"TAG_TAG") + " rows deleted from table TAG_TAG");
		System.out.println(deleteTable (conn,"TAG_TAGTYPE") + " rows deleted from table TAG_TAGTYPE");
		System.out.println(deleteTable (conn,"TAG_TAGFILE") + " rows deleted from table TAG_TAGFILE");
		System.out.println(deleteTable (conn,"TAG_TAGFILETYPE") + " rows deleted from table TAG_TAGFILETYPE");
		System.out.println(deleteTable (conn,"TAG_TAGBLOB") + " rows deleted from table TAG_TAGBLOB");
		System.out.println(deleteTable (conn,"TAG_TAGENGINE") + " rows deleted from table TAG_TAGENGINE");
		System.out.println(deleteTable (conn,"JOB_JOB") + " rows deleted from table JOB_JOB");
		System.out.println(deleteTable (conn,"REG_ENTITYID") + " rows deleted from table REG_ENTITYID");
		*/
		
		int cntInserted = cntInsertedTagSet + cntInsertedTag + cntInsertedTagType + cntInsertedTagFile + cntInsertedTagFileType + 
				cntInsertedTagStr + cntInsertedTagEngine + cntInsertedEmbedded ;
		return(cntInserted);
	}	
	public static void writeTagSetTables(Connection conn, NodeTagSet tagSet)	{
		writeTagSet(conn,tagSet);
	}
	
}