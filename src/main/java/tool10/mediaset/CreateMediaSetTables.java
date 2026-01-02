package tool10.mediaset;

import java.sql.Connection;
import java.time.ZonedDateTime;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateMediaSetTables {

	private static String getCreateTableSqlStr(Connection conn,String tableName)	{
		String sqlStr = null; 
		//"IMG_IMAGESET","IMG_IMAGE","IMG_IMAGEFILE","IMG_IMAGEBLOB" 
		if ("IMG_MEDIASET".equals(tableName))	{
			//public NodeMediaSet(Long mediaSetId, Long fileSetId, String mediaSetName, String mediaSetDesc, String sourceName,
			//String sourceURL, Long cntMedia, Long sumMediaSize, Double avgMediaSize, Long sourceFileSize,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"mediaSetId INTEGER, fileSetId INTEGER,mediaSetName TEXT,mediaSetDescr TEXT,sourceName TEXT, "+
								"sourceURL TEXT,cntMedia INTEGER,sumMediaSize INTEGER,avgMediaSize REAL,sourceFileSize INTEGER,"+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_IMAGE".equals(tableName))	{
			//public NodeImage(Long imageId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, String imageName, String imageType, String imageSize,
			//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"imageId INTEGER,mediaSetId INTEGER,mediaFileId INTEGER, sourceMediaId INTEGER,imageName TEXT,imageType TEXT,imageSize INTEGER,"+
								"sizeX INTEGER, sizeY INTEGER, pixelNum INTEGER, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_MEDIAFILE".equals(tableName))	{
			//public NodeMediaFile(Long mediaFileId, Long mediaId, Long fileId, Long mediaSetId, String mediaFileType, String sourceAbsolutePath, String sourceDirName, 
			//String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"mediaFileId INTEGER, mediaId INTEGER,fileId INTEGER, mediaSetId INTEGER,mediaFileType INTEGER, sourceAbsolutePath TEXT, sourceDirName TEXT, "+
								"sourceFileName TEXT,sourceExtensionName TEXT, sourceFileSize INTEGER,sourceFileCreationDate TEXT, "+
								"creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_MEDIABLOB".equals(tableName))	{
			//public NodeMediaBlob(Long mediaBlobId, Long mediaId, Long mediaSetId, Long fileBlobId, String mediaType, String blobType, Long mediaSize, 
			//byte[] mediaBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"mediaBlobId INTEGER,mediaId INTEGER,mediaSetId INTEGER, fileBlobId INTEGER, mediaType TEXT,blobType TEXT,mediaSize INTEGER, "+
								"mediaBytes BLOB,crc64  INTEGER,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_VIDEO".equals(tableName))	{
			//public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long rootVideoId,
			//Long nextVideoId, Long previousVideoId, Long defaultSubtitleId, String videoName, String videoDesc,
			//String videoGroupName, String videoType, String colorModel, Long videoSize, Long sizeX, Long sizeY,
			//Long pixelNum, Double aspectRatio, Long durationMs, Double fps, Double dataRateBPS, Long cntFrame,
			//Long cntSection, String videoQuality, String videoCompression, String videoFormat, String videoEncoding,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"videoId INTEGER, mediaSetId INTEGER, mediaFileId INTEGER, sourceMediaId INTEGER, rootVideoId INTEGER,\r\n"
					+ "			nextVideoId INTEGER, previousVideoId INTEGER, defaultSubtitleId INTEGER, videoName TEXT, videoDesc TEXT,\r\n"
					+ "			videoGroupName TEXT, videoType TEXT, colorModel TEXT, videoSize INTEGER, sizeX INTEGER, sizeY INTEGER,\r\n"
					+ "			pixelNum INTEGER, aspectRatio REAL, durationMs INTEGER, fps REAL, dataRateBPS REAL, cntFrame INTEGER,\r\n"
					+ "			cntSection INTEGER, videoQuality TEXT, videoCompression TEXT, videoFormat TEXT, videoEncoding TEXT,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("IMG_FRAME".equals(tableName))	{
			//public NodeFrame(Long frameId, Long videoId, Long mediaSetId, Long imageId, Long firstFrameId, Long nextFrameId,
			//Long previousFrameId, String frameName, String frameDesc, String frameGroupName, String frameType,
			//String sectionName, Long frameSize, Long numFrame, Long cntFrame, Long startMs, Long endMs,
			//Long durationMs, Double similarityRatioPrevious, Double similarityRatioNext, Long subtitleLineNum,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"frameId INTEGER, videoId INTEGER, mediaSetId INTEGER, imageId INTEGER, firstFrameId INTEGER, nextFrameId INTEGER,\r\n"
					+ "			previousFrameId INTEGER, frameName TEXT, frameDesc TEXT, frameGroupName TEXT,  frameType TEXT, sectionName TEXT, frameSize INTEGER, numFrame INTEGER, \r\n"
					+ "			cntFrame INTEGER, startMs INTEGER, endMs INTEGER,durationMs INTEGER, similarityRatioPrevious REAL, \r\n"
					+ "			similarityRatioNext REAL, subtitleLineNum INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";	
		} else if ("IMG_AUDIO".equals(tableName))	{
			//public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long videoId,
			//Long rootAudioId, Long nextAudioId, Long previousAudioId, Long defaultSubtitleId, Long lyricsId,
			//String audioName, String audioDesc, String audioGroupName, String audioType, 
			//String contentType, String artistName, String albumName, String songName, Long audioSize, Long durationMs,
			//Double bitRateBPS, Double dataRateBPS, Double sampleRateKHZ, Long cntChannel, Long cntSection,
			//String audioQuality, String audioCompression, String audioFormat, String audioEncoding,	ZonedDateTime creationDate, ZonedDateTime modificationDate) {
				
			String fieldStr = 	"audioId INTEGER, mediaSetId INTEGER, mediaFileId INTEGER, sourceMediaId INTEGER, videoId INTEGER,\r\n"
					+ "		rootAudioId INTEGER, nextAudioId INTEGER, previousAudioId INTEGER, defaultSubtitleId INTEGER, lyricsId INTEGER,\r\n"
					+ "		audioName TEXT, audioDesc TEXT, audioGroupName TEXT, audioType TEXT, \r\n"
					+ "		contentType TEXT, artistName TEXT, albumName TEXT, songName TEXT, audioSize TEXT, durationMs INTEGER,\r\n"
					+ "		bitRateBPS REAL, dataRateBPS REAL, sampleRateKHZ REAL, cntChannel INTEGER, cntSection INTEGER,\r\n"
					+ "		audioQuality TEXT, audioCompression TEXT, audioFormat TEXT, audioEncoding TEXT,creationDate TEXT, modificationDate TEXT";
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