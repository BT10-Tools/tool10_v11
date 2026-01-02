package tool10.bookset;

import java.sql.Connection;
import java.time.ZonedDateTime;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateBookSetTables {
	
	private static String getCreateTableSqlStr(Connection conn,String tableName)	{
		//"BOOK_BOOKSET","BOOK_LANGUAGE","BOOK_BOOK","BOOK_BOOKFILE","BOOK_BOOKBLOB","BOOK_CHAPTER",
		//"BOOK_PARAGRAPH","BOO_SENTENCE","BOOK_TOKEN","REG_ENTITYID"
		String sqlStr = null;
		if ("BOOK_BOOKSET".equals(tableName))	{
			//public NodeBookSet(Long bookSetId, Long fileSetId, String bookSetName, String bookSetDesc, String sourceDesc,
			//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = "bookSetId INTEGER,fileSetId INTEGER, bookSetName TEXT,bookSetDesc TEXT,sourceDesc TEXT, creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_LANGUAGE".equals(tableName))	{
			//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName)
			String fieldStr = 	"languageId INTEGER,languageName TEXT,shortName TEXT, alhabetName TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_BOOK".equals(tableName))	{
			//public NodeBook(Long bookId, Long bookSetId, Long languageId, Long secondLanguageId, String bookName,
			//String bookType, String bookDesc, String isbn, String authorName, String sourceName,
			//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"bookId INTEGER,bookSetId INTEGER,languageId INTEGER,secondLanguageId INTEGER,bookName TEXT,"+
								"bookType TEXT,bookDesc TEXT,isbn TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_BOOKFILE".equals(tableName))	{
			//public NodeBookFile(Long bookFileId, Long bookId, Long fileId, Long bookSetId, String sourceAbsolutePath,
			//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
			//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"bookFileId INTEGER,bookId INTEGER,fileId INTEGER,bookSetId INTEGER,sourceAbsolutePath TEXT, "+
								"sourceDirName TEXT,sourceFileName TEXT,sourceExtensionName TEXT,sourceFileSize INTEGER, "+
								"sourceFileCreationDate TEXT,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_BOOKIMAGE".equals(tableName))	{
			//public NodeBookImage(Long bookImageId, Long bookId, Long bookSetId, Long imageId, Long imageSetId,
			//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
			//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"bookImageId INTEGER,bookId INTEGER,bookSetId INTEGER,imageId INTEGER,imageSetId INTEGER, "+
								"imageAbsolutePath TEXT,displayOrder INTEGER,pageNum INTEGER,locX REAL,locY REAL,sizeX REAL, sizeY REAL, "+
								"imageCaption TEXT,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_BOOKBLOB".equals(tableName))	{
			//public NodeBookBlob(Long bookBlobId, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
			//byte[] bookBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"bookBlobId INTEGER,bookId INTEGER,fileBlobId INTEGER,bookType TEXT,blobType TEXT,bookSize INTEGER,"+
								"bookBytes BLOB,crc64 INTEGER,creationDate TEXT,modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_CHAPTER".equals(tableName))	{
			//public NodeChapter(Long chapterId, Long bookId, Long languageId, String chapterName, String chapterType,
			//String chapterDescr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			//Long lineNumber, Long wordNumber, ZonedDateTime creationDate) {
			String fieldStr = 	"chapterId INTEGER,bookId INTEGER,languageId INTEGER,chapterName TEXT,"+
								"chapterType TEXT,chapterDesc TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_SECTION".equals(tableName))	{
			//public NodeSection(Long sectionId, Long chapterId, Long bookId, Long languageId, Long sameSectionId, String sectionName,
			//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
			//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
			String fieldStr = 	"sectionId INTEGER,chapterId INTEGER,bookId INTEGER,languageId INTEGER,sameSectionId INTEGER,sectionName TEXT,"+
								"sectionType TEXT,sectionDesc TEXT,sectionStr TEXT,authorName TEXT,sourceName TEXT,displayOrder INTEGER,"+
								"pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_PARAGRAPH".equals(tableName))	{
			//public NodeParagraph(Long paragraphId, Long sectionId, Long bookId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
			//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"paragraphId INTEGER,sectionId INTEGER,bookId INTEGER,languageId INTEGER,sameParagraphId INTEGER,paragraphName TEXT,"+
								"paragraphType TEXT,paragraphDesc TEXT,paragraphStr TEXT,authorName TEXT,sourceName TEXT,"+
								"displayOrder INTEGER,pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_SENTENCE".equals(tableName))	{
			//public NodeSentence(Long sentenceId, Long paragraphId, Long bookId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
			//String sentenceDescription,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
			//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"sentenceId INTEGER,paragraphId INTEGER,bookId INTEGER,languageId INTEGER,sameSentenceId INTEGER,sentenceName TEXT,sentenceType TEXT,"+
								"sentenceDesc TEXT,sentenceStr TEXT, sentenceHolder TEXT,authorName TEXT,sourceName TEXT,displayOrder INTEGER,"+
								"pageNumber INTEGER,lineNumber INTEGER,wordNumber INTEGER,creationDate TEXT, modificationDate TEXT";
			sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		} else if ("BOOK_TOKEN".equals(tableName))	{
			//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
			//Long cntInBookSet, Double frequencyBookSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			String fieldStr = 	"tokenId INTEGER,dictId INTEGER,wordId INTEGER,tokenStr TEXT,tokenDesc TEXT,tokenLength INTEGER, "+
								"cntInBookSet INTEGER, frequencyBookSet REAL, creationDate TEXT, modificationDate TEXT";
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
	public static void createBookSetIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "BOOK_TOKEN", "tokenStr", false);
		SqlUtil.createIndex(conn, "BOOK_BOOKFILE", "bookId", false);
		SqlUtil.createIndex(conn, "BOOK_BOOKBLOB", "bookId", false);
		SqlUtil.createIndex(conn, "BOOK_CHAPTER", "bookId", false);
		SqlUtil.createIndex(conn, "BOOK_PARAGRAPH", "chapterId", false);
		SqlUtil.createIndex(conn, "BOOK_SENTENCE", "paragraphId", false);
	}
	public static int createBookSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createBookSetIndexes(conn10.getConn());
		return(cntUpdated);
	}
	
}