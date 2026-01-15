package tool10.docset;

import java.sql.Connection;
import java.time.ZonedDateTime;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateDocSetTables {
	
	private static String getCreateTableSqlStr(Connection conn,String tableName)	{
		//"DOC_DOCSET","DOC_LANGUAGE","DOC_DOC","DOC_DOCFILE","DOC_DOCBLOB","DOC_CHAPTER",
		//"DOC_PARAGRAPH","BOO_SENTENCE","DOC_TOKEN","REG_ENTITYID"
		String sqlStr = null;
		if ("DOC_DOCSET".equals(tableName))	{
			//public NodeDocSet(Long docSetId, Long fileSetId, String docSetName, String docSetDesc, String sourceDesc,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = "docSetId INTEGER,fileSetId INTEGER, docSetName TEXT,docSetDesc TEXT,sourceDesc TEXT, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_LANGUAGE".equals(tableName))	{
			//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName)
			String fieldStr = 	"languageId INTEGER,languageName TEXT,shortName TEXT, alhabetName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_DOC".equals(tableName))	{
			//public NodeDoc(Long docId, Long docSetId, Long languageId, Long secondLanguageId, String docName,
			//String docType, String docDesc, String isbn, String authorName, String sourceName,
			//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"docId INTEGER,docSetId INTEGER,languageId INTEGER,secondLanguageId INTEGER,docName TEXT,"+
								"docType TEXT,docDesc TEXT,isbn TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_DOCFILE".equals(tableName))	{
			//public NodeDocFile(Long docFileId, Long docId, Long fileId, Long docSetId, String sourceAbsolutePath,
			//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
			//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"docFileId INTEGER,docId INTEGER,fileId INTEGER,docSetId INTEGER,sourceAbsolutePath TEXT, "+
								"sourceDirName TEXT,sourceFileName TEXT,sourceExtensionName TEXT,sourceFileSize INTEGER, "+
								"sourceFileCreationDate TEXT,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_DOCIMAGE".equals(tableName))	{
			//public NodeDocImage(Long docImageId, Long docId, Long docSetId, Long imageId, Long imageSetId,
			//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
			//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"docImageId INTEGER,docId INTEGER,docSetId INTEGER,imageId INTEGER,imageSetId INTEGER, "+
								"imageAbsolutePath TEXT,displayOrder INTEGER,pageNum INTEGER,locX REAL,locY REAL,sizeX REAL, sizeY REAL, "+
								"imageCaption TEXT,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_DOCBLOB".equals(tableName))	{
			//public NodeDocBlob(Long docBlobId, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
			//byte[] docBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"docBlobId INTEGER,docId INTEGER,fileBlobId INTEGER,docType TEXT,blobType TEXT,docSize INTEGER,"+
								"docBytes BLOB,crc64 INTEGER,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_CHAPTER".equals(tableName))	{
			//public NodeChapter(Long chapterId, Long docId, Long languageId, String chapterName, String chapterType,
			//String chapterDescr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			//Long lineNumber, Long wordNumber, ZonedDateTime creationDate) {
			String fieldStr = 	"chapterId INTEGER,docId INTEGER,languageId INTEGER,chapterName TEXT,"+
								"chapterType TEXT,chapterDesc TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_SECTION".equals(tableName))	{
			//public NodeSection(Long sectionId, Long chapterId, Long docId, Long languageId, Long sameSectionId, String sectionName,
			//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
			//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
			String fieldStr = 	"sectionId INTEGER,chapterId INTEGER,docId INTEGER,languageId INTEGER,sameSectionId INTEGER,sectionName TEXT,"+
								"sectionType TEXT,sectionDesc TEXT,sectionStr TEXT,authorName TEXT,sourceName TEXT,displayOrder INTEGER,"+
								"pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_PARAGRAPH".equals(tableName))	{
			//public NodeParagraph(Long paragraphId, Long sectionId, Long docId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
			//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"paragraphId INTEGER,sectionId INTEGER,docId INTEGER,languageId INTEGER,sameParagraphId INTEGER,paragraphName TEXT,"+
								"paragraphType TEXT,paragraphDesc TEXT,paragraphStr TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_SENTENCE".equals(tableName))	{
			//public NodeSentence(Long sentenceId, Long paragraphId, Long docId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
			//String sentenceDescription,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
			//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"sentenceId INTEGER,paragraphId INTEGER,docId INTEGER,languageId INTEGER,sameSentenceId INTEGER,sentenceName TEXT,sentenceType TEXT,"+
								"sentenceDesc TEXT,sentenceStr TEXT, sentenceHolder TEXT,authorName TEXT,sourceName TEXT,displayOrder INTEGER,"+
								"pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("DOC_TOKEN".equals(tableName))	{
			//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
			//Long cntInDocSet, Double frequencyDocSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"tokenId INTEGER,dictId INTEGER,wordId INTEGER,tokenStr TEXT,tokenDesc TEXT,tokenLength INTEGER, "+
								"cntInDocSet INTEGER, frequencyDocSet REAL, creationDate TEXT, modificationDate TEXT";
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
	public static void createDocSetIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "DOC_TOKEN", "tokenStr", false);
		SqlUtil.createIndex(conn, "DOC_DOCFILE", "docId", false);
		SqlUtil.createIndex(conn, "DOC_DOCBLOB", "docId", false);
		SqlUtil.createIndex(conn, "DOC_CHAPTER", "docId", false);
		SqlUtil.createIndex(conn, "DOC_PARAGRAPH", "chapterId", false);
		SqlUtil.createIndex(conn, "DOC_SENTENCE", "paragraphId", false);
	}
	public static int createDocSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createDocSetIndexes(conn10.getConn());
		return(cntUpdated);
	}
	
}