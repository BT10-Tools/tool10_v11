package tool10.tagset;

import java.sql.Connection;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateTagSetTables {
	
	private static String getCreateTableSqlStr(Connection conn,String tableName)	{
		String sqlStr = null; 
		//INTEGER, TEXT, REAL, BLOB
		if ("TAG_TAGSET".equals(tableName))	{
			//public NodeTagSet(Long tagSetId, Long fileSetId, String tagSetName, String tagSetDescription, String sourceName, String sourceURL,ZonedDateTime creationDate) {
			String fieldStr = "tagSetId INTEGER, fileSetId INTEGER, tagSetName TEXT,tagSetDescription TEXT,sourceName TEXT,sourceURL TEXT,creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAG".equals(tableName))	{
			//public NodeTag(Long tagId, Long tagFileId, Long tagTypeId, Long tagStrId, Long displayOrder, String keyName,
			//String valueStr, Long valueLength, Long valueLong, Double valueDouble, String valueBoolean,ZonedDateTime valueZDT, ZonedDateTime creationDate) {
			String fieldStr = 	"tagId INTEGER, tagFileId INTEGER, tagTypeId INTEGER, tagStrId INTEGER, displayOrder INTEGER, keyName TEXT, valueStr TEXT, valueLength INTEGER, valueLong INTEGER,"
					+ "			valueDouble REAL, valueBoolean TEXT, valueZDT TEXT, creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAGTYPE".equals(tableName))	{
			//public NodeTagType(Long tagTypeId, Long tagFileTypeId, Long tagSetId, String tagTypeName, String tagTypeDesc,
			//String tagVariableDataType, Long displayOrder, ZonedDateTime creationDate) {
			String fieldStr = 	"tagTypeId INTEGER, tagFileTypeId INTEGER,tagSetId INTEGER,tagTypeName TEXT, tagTypeDesc TEXT, SourceFileName TEXT,tagVariableDataType TEXT,displayOrder INTEGER, creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAGFILE".equals(tableName))	{
			//public NodeTagFile(Long tagFileId, Long tagSetId, Long tagFileTypeId, Long sourceId, String sourceAbsolutePath,
			//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
			//ZonedDateTime sourceFileCreationDate, ZonedDateTime sourceFileModificationDate, ZonedDateTime creationDate) {
			String fieldStr = 	"tagFileId INTEGER, tagSetId INTEGER,tagFileTypeId INTEGER, sourceId INTEGER, sourceAbsolutePath TEXT, sourceDirName TEXT, SourceFileName TEXT,sourceExtensionName TEXT,"+
								"sourceFileSize INTEGER,sourceFileCreationDate TEXT, sourceFileModificationDate TEXT, creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAGFILETYPE".equals(tableName))	{
			//public NodeTagFileType(Long tagFileTypeId, Long tagSetId, String tagFileTypeName, String tagFileTypeDesc,
			//String primaryExtension, String detectedExtensionListString, Long displayOrder, ZonedDateTime creationDate) {
			String fieldStr = 	"tagFileTypeId INTEGER, tagSetId INTEGER,tagFileTypeName TEXT, tagFileTypeDesc TEXT, SourceFileName TEXT,primaryExtension TEXT,"+
								"detectedExtensionListString TEXT, displayOrder INTEGER, creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAGSTR".equals(tableName))	{
			//public NodeTagStr(Long tagStrId, Long tagSetId, Long tagTypeId, String tagType, String strType, Long strLength, String tagStr,
			//Long crc64, ZonedDateTime creationDate) {
			String fieldStr = 	"tagStrId INTEGER,tagSetId INTEGER,tagTypeId INTEGER,tagType TEXT,strType TEXT,strLength INTEGER,tagStr TEXT, crc64  INTEGER,creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_TAGENGINE".equals(tableName))	{
			//public NodeTagEngine(Long tagEngineId, Long tagSetId, String tagEngineType, String tagEngineName, String tagEngineShortName, String tagEngineDesc,
			//Long displayOrder, ZonedDateTime creationDate) {
			String fieldStr = 	"tagEngineId INTEGER,tagSetId INTEGER,tagEngineType TEXT, tagEngineName TEXT,tagEngineShortName TEXT,tagEngineDesc TEXT, displayOrder INTEGER,creationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("TAG_EMBEDDED".equals(tableName))	{
			//public NodeEmbedded(Long embeddedId, Long tagFileId, Long tagSetId, String embeddingType,
			//String tmpFileAbsolutePath, String tmpFileName, Long embeddedSize, Long displayOrder,NodeBinary embeddedBinary,	Long crc64, ZonedDateTime creationDate) {
			String fieldStr = 	"embeddedId INTEGER,tagFileId INTEGER,tagSetId INTEGER,embeddingType TEXT,tmpFileAbsolutePath TEXT ,tmpFileName TEXT,"+
					 			"embeddedSize INTEGER,displayOrder INTEGER,embeddedBytes BLOB,crc64 INTEGER,creationDate TEXT ";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		}  else if ("REG_ENTITYID".equals(tableName))	{
			String fieldStr = "EntityId INTEGER PRIMARY KEY AUTOINCREMENT, tableName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} 		 	
		return(sqlStr);
	}
	public static int createTable(Connection conn,String tableName)	{
		String sqlStr = getCreateTableSqlStr(conn,tableName);
		if (sqlStr==null) return(-1);
		int cntUpdated = SqlUtil.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static void createTagSetIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "TAG_TAG", "tagFileId", false);
	}
	public static int createTagSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createTagSetIndexes(conn10.getConn());
		return(cntUpdated);
	}
	
}