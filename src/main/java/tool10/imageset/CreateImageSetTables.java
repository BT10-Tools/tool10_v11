package tool10.imageset;

import java.sql.Connection;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateImageSetTables {

	private static String getCreateTableSqlStr(Connection conn,String tableName)	{
		String sqlStr = null; 
		//"IMG_IMAGESET","IMG_IMAGE","IMG_IMAGEFILE","IMG_IMAGEBLOB" 
		if ("IMG_IMAGESET".equals(tableName))	{
			//public NodeImageSet(Long imageSetId, Long fileSetId, String imageSetName, String imageSetDescription, String sourceName,
			//String sourceURL, Long cntImage, Long sumImageSize, Double avgImageSize, Long sourceFileSize,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"imageSetId INTEGER, fileSetId INTEGER,imageSetName TEXT,imageSetDescription TEXT,sourceName TEXT, "+
								"sourceURL TEXT,cntImage INTEGER,sumImageSize INTEGER,avgImageSize REAL,sourceFileSize INTEGER,"+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_IMAGE".equals(tableName))	{
			//public NodeImage(Long imageId, Long imageSetId, Long imageFileId, Long sourceImageId, String imageName, String imageType, String imageSizeType,
			//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"imageId INTEGER,imageSetId INTEGER,imageFileId INTEGER, sourceImageId INTEGER,imageName TEXT,imageType TEXT,imageSizeType INTEGER,"+
								"sizeX INTEGER, sizeY INTEGER, pixelNum INTEGER, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_IMAGEFILE".equals(tableName))	{
			//public NodeImageFile(Long imageFileId, Long imageId, Long fileId, Long imageSetId, String sourceAbsolutePath, String sourceDirName, 
			//		String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,
			//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"imageFileId INTEGER, imageId INTEGER,fileId INTEGER, imageSetId INTEGER,sourceAbsolutePath TEXT, sourceDirName TEXT, "+
								"sourceFileName TEXT,sourceExtensionName TEXT, sourceFileSize INTEGER,sourceFileCreationDate TEXT, "+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_IMAGEBLOB".equals(tableName))	{
			//public NodeImageBlob(Long imageBlobId, Long imageId, Long fileBlobId, String imageType, String blobType, Long imageSize, 
			// byte[] imageBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"imageBlobId INTEGER,imageId INTEGER,fileBlobId INTEGER, imageType TEXT,blobType TEXT,imageSize INTEGER, "+
								"imageBytes BLOB,crc64  INTEGER,creationDate TEXT,modificationDate TEXT";
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
	public static void createImageSetIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "IMG_IMAGEBLOB", "imageId", false);
	}
	public static int createImageSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createImageSetIndexes(conn10.getConn());
		return(cntUpdated);
	}	
}