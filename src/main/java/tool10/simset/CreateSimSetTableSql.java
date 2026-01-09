package tool10.simset;

import java.sql.Connection;
import java.time.ZonedDateTime;

public class CreateSimSetTableSql {
	
	public static String getCreateTableSqlStr(Connection conn,String tableName)	{
		//"FS_FILESET","FS_FILE","FS_FILEBLOB","FS_FILEBLOBSMALL","FS_FILEGROUP","FS_FILEGROUPMEMBER",
		//"FS_FILESYSTEM","FS_FILESTORE","FS_HASH","FS_HOST","FS_PROPERTY","FS_QUERY","FS_SIMILARITY","FS_STAT","REG_ENTITYID"
		
		String sqlStr = null; 
		if ("SIM_SIMSET".equals(tableName))	{
			//public NodeSimSet(Long simSetId, Long sourceId, String simSetName, String simSetDesc, String ownerName,
			//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"simSetId INTEGER PRIMARY KEY,sourceId INTEGER,simSetName TEXT,simSetDesc TEXT,ownerName TEXT, "+
								"displayOrder INTEGER, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("SIM_ENTITYTYPE".equals(tableName))	{
			//public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
			//String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"entityTypeId INTEGER PRIMARY KEY,simSetId INTEGER,entityTypeName TEXT,entityTypeDesc TEXT,dbName TEXT, "+
								"tableName TEXT, fieldName TEXT, fieldType TEXT, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("SIM_ENTITY".equals(tableName))	{
			//public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
			//Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"entityId INTEGER PRIMARY KEY,entityTypeId INTEGER, simSetId INTEGER,sourceId INTEGER,valueStr TEXT, valueLong INTEGER, "+
								"valueDouble REAL, valueBLOB BLOB, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("SIM_SIMILARITY".equals(tableName))	{
			//public NodeSimilarity(Long similarityId, Long simSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
			//		Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
			//		Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
			//		Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
			//		String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
			//		String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
			//		String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
			//		ZonedDateTime modificationDate) {
			
	/*		similarityId , fileSetId , entityId1 , entityId2 , similarityType TEXT,
			sim00 , sim01 , sim02 , sim03 , sim04 , sim05 , sim06 , 
			sim07 , sim08 , sim09 , sim10 , sim11 , sim12 , sim13 ,
			sim14 , sim15 , sim16 , sim17 , sim18 , sim19 , alg00 ,
			alg01 , alg02 , alg03 , alg04 , alg05 , alg06 , alg07 ,
			alg08 , alg09 , alg10 , alg11 , alg12 , alg13 , alg14 ,
			alg15 , alg16 , alg17 , alg18 , alg19 ,
	*/		
			String fieldStr = 	"similarityId INTEGER PRIMARY KEY, simSetId INTEGER, entityId1 INTEGER, entityId2 INTEGER, similarityType TEXT, similarityKey TEXT, \r\n"
					+ "			sim00 REAL, sim01 REAL, sim02 REAL, sim03 REAL, sim04 REAL, sim05 REAL, sim06 REAL, \r\n"
					+ "			sim07 REAL, sim08 REAL, sim09 REAL, sim10 REAL, sim11 REAL, sim12 REAL, sim13 REAL,\r\n"
					+ "			sim14 REAL, sim15 REAL, sim16 REAL, sim17 REAL, sim18 REAL, sim19 REAL, alg00 TEXT,\r\n"
					+ "			alg01 TEXT, alg02 TEXT, alg03 TEXT, alg04 TEXT, alg05 TEXT, alg06 TEXT, alg07 TEXT,\r\n"
					+ "			alg08 TEXT, alg09 TEXT, alg10 TEXT, alg11 TEXT, alg12 TEXT, alg13 TEXT, alg14 TEXT,\r\n"
					+ "			alg15 TEXT, alg16 TEXT, alg17 TEXT, alg18 TEXT, alg19 TEXT, creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("REG_ENTITYID".equals(tableName))	{
			String fieldStr = "EntityId INTEGER PRIMARY KEY AUTOINCREMENT, tableName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} 		 	
		return(sqlStr);
	}
}