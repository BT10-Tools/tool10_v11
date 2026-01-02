package tool10.bookset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ReadBookTablesFromDb {
	
	public static int readBookSetTableBookBlob(Connection conn,NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT bookBlobId,bookId,fileBlobId,bookType,blobType,bookSize,bookBytes,crc64,creationDate,modificationDate "+
					    "FROM BOOK_BOOKBLOB WHERE bookId in (SELECT bookId FROM BOOK_BOOK WHERE bookSetId= ?) "+
					    "ORDER BY bookId, bookBlobId";
		//public NodeBookBlob(Long bookBlobId, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
		//byte[] bookBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long bookBlobId = rs.getLong("bookBlobId");  	if (rs.wasNull()) {bookBlobId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long fileBlobId = rs.getLong("fileBlobId");  	if (rs.wasNull()) {fileBlobId = null;}
		    	String bookType = rs.getString("bookType");
		        String blobType = rs.getString("blobType");
		    	Long bookSize = rs.getLong("bookSize");  	if (rs.wasNull()) {bookSize = null;}
		    	byte[] bookBytes= rs.getBytes("bookBytes");  	if (rs.wasNull()) {bookBytes = null;}
		    	Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
		    	String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeBookBlob imageBlob = new NodeBookBlob(bookBlobId,bookId,fileBlobId,bookType,blobType,bookSize,bookBytes,null,crc64,creationDate,modificationDate);
			    bookSet.getListBookBlob().add(imageBlob);
			    bookSet.getMapId2BookBlob().put(imageBlob.getBookBlobId(),imageBlob);  
			    cntRead++;
		    }
		    System.out.println("readBookSetTableBookBlob: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableBookFile(Connection conn,NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT bookFileId,bookId,fileId,bookSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"	sourceFileSize,sourceFileCreationDate,creationDate,modificationDate "+
					    "FROM BOOK_BOOKFILE WHERE bookSetId= ? ORDER BY bookSetId, bookFileId";
		//public NodeBookFile(Long bookFileId, Long bookId, Long fileId, Long bookSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long bookFileId = rs.getLong("bookFileId");  	if (rs.wasNull()) {bookFileId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long fileId = rs.getLong("fileId");  	if (rs.wasNull()) {fileId = null;}
		    	Long bookSetId = rs.getLong("bookSetId");  	if (rs.wasNull()) {bookSetId = null;}
		    	
		        String sourceAbsolutePath = rs.getString("sourceAbsolutePath");
		        String sourceDirName = rs.getString("sourceDirName");
		        String sourceFileName = rs.getString("sourceFileName");
		        String sourceExtensionName = rs.getString("sourceExtensionName");
		        Long sourceFileSize = rs.getLong("sourceFileSize");  	if (rs.wasNull()) {sourceFileSize = null;}
		        String sourceFileCreationDateStr = rs.getString("sourceFileCreationDate");
			    ZonedDateTime sourceFileCreationDate = ((sourceFileCreationDateStr!=null) ? ZonedDateTime.parse(sourceFileCreationDateStr) : null);	
			    String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeBookFile bookFile = new NodeBookFile(bookFileId,bookId,fileId,bookSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
							sourceFileSize,sourceFileCreationDate,creationDate,modificationDate);
			    bookSet.getListBookFile().add(bookFile);
			    bookSet.getMapId2BookFile().put(bookFile.getBookFileId(),bookFile);  
			    cntRead++;
		    }
		    System.out.println("readBookSetTableBookFile: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableBookImage(Connection conn,NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	" SELECT bookImageId,bookId,bookSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,pageNum,locX,locY,sizeX,\r\n" +
						" sizeY,imageCaption,creationDate,modificationDate "+
					    "FROM BOOK_BOOKIMAGE WHERE bookSetId= ? ORDER BY bookSetId, bookImageId";
		//public NodeBookImage(Long bookImageId, Long bookId, Long bookSetId, Long imageId, Long imageSetId,
		//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
		//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {				
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long bookImageId = rs.getLong("bookImageId");  	if (rs.wasNull()) {bookImageId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long bookSetId = rs.getLong("bookSetId");  	if (rs.wasNull()) {bookSetId = null;}
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long imageSetId = rs.getLong("imageSetId");  	if (rs.wasNull()) {imageSetId = null;}
		    	
		        String imageAbsolutePath = rs.getString("imageAbsolutePath");
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNum = rs.getLong("pageNum");  	if (rs.wasNull()) {pageNum = null;}
		        Double locX = rs.getDouble("locX");  	if (rs.wasNull()) {locX = null;}
		        Double locY = rs.getDouble("locY");  	if (rs.wasNull()) {locY = null;}
		        Double sizeX = rs.getDouble("sizeX");  	if (rs.wasNull()) {sizeX = null;}
		        Double sizeY = rs.getDouble("sizeY");  	if (rs.wasNull()) {sizeY = null;}
		        
		        String imageCaption = rs.getString("imageCaption");
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeBookImage bookImage = new NodeBookImage(bookImageId,bookId,bookSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,
			    		pageNum,locX,locY,sizeX,sizeY,imageCaption,creationDate,modificationDate);
			    bookSet.getListBookImage().add(bookImage);
			    bookSet.getMapId2BookImage().put(bookImage.getBookImageId(),bookImage);  
			    cntRead++;
		    }
		    System.out.println("readBookSetTableBookImage: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableToken(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT tokenId,dictId,wordId,tokenStr,tokenDesc,tokenLength,cntInBookSet,frequencyBookSet,creationDate,modificationDate "+
						"FROM BOOK_TOKEN ORDER BY tokenId";
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInBookSet, Double frequencyBookSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ///ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tokenId = rs.getLong("tokenId");
		    	Long dictId = rs.getLong("dictId");  	if (rs.wasNull()) {dictId = null;}
		    	Long wordId = rs.getLong("wordId");  	if (rs.wasNull()) {wordId = null;}
		    	String tokenStr = rs.getString("tokenStr");  
		    	String tokenDescription = rs.getString("tokenDescr");  
		    	Long tokenLength = rs.getLong("tokenLength");  	if (rs.wasNull()) {tokenLength = null;}
		    	Long cntInBookSet = rs.getLong("cntInBookSet");  	if (rs.wasNull()) {cntInBookSet = null;}
		    	Double frequencyBookSet = rs.getDouble("frequencyBookSet");  	if (rs.wasNull()) {frequencyBookSet = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeToken token = new NodeToken(tokenId,dictId,wordId,tokenStr,tokenDescription,tokenLength,cntInBookSet,frequencyBookSet,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        bookSet.getListToken().add(token);
		        bookSet.getMapId2Token().put(token.getTokenId(),token);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableToken: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
			e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableSentence(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	" SELECT sentenceId,paragraphId,bookId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder, "+
				 		" 	authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						" FROM BOOK_SENTENCE WHERE bookId in (select bookId from BOOK_BOOK WHERE bookSetId = ? ) "+
				 		" ORDER BY paragraphId,sentenceId";
		//public NodeSentence(Long sentenceId, Long paragraphId, Long bookId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDescription,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long sentenceId = rs.getLong("sentenceId");
		    	Long paragraphId = rs.getLong("paragraphId");  	if (rs.wasNull()) {paragraphId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	Long sameSentenceId = rs.getLong("sameSentenceId");  	if (rs.wasNull()) {sameSentenceId = null;}
		    	String sentenceName = rs.getString("sentenceName");  
		    	String sentenceType = rs.getString("sentenceType");  
		    	String sentenceDesc = rs.getString("sentenceDesc");  
		    	String sentenceStr = rs.getString("sentenceStr");
		    	String sentenceHolder = rs.getString("sentenceHolder");
		    	String authorName = rs.getString("authorName");  
		    	String sourceName = rs.getString("sourceName");  
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNumber = rs.getLong("pageNumber");  	if (rs.wasNull()) {pageNumber = null;}
		        Long lineNumber = rs.getLong("lineNumber");  	if (rs.wasNull()) {lineNumber = null;}
		        Long wordNumber = rs.getLong("wordNumber");  	if (rs.wasNull()) {wordNumber = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    
		        NodeSentence sentence = new NodeSentence(sentenceId,paragraphId,bookId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        bookSet.getListSentence().add(sentence);
		        bookSet.getMapId2Sentence().put(sentence.getSentenceId(),sentence);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableSentence: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
			e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableParagraph(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT paragraphId,sectionId,bookId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM BOOK_PARAGRAPH WHERE bookId in (select bookId from BOOK_BOOK WHERE bookSetId = ? ) "+
				 		"ORDER BY sectionId,paragraphId";
		//public NodeParagraph(Long paragraphId, Long sectionId, Long bookId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long paragraphId = rs.getLong("paragraphId");
		    	Long sectionId = rs.getLong("sectionId");  	if (rs.wasNull()) {sectionId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	Long sameParagraphId = rs.getLong("sameParagraphId");  	if (rs.wasNull()) {sameParagraphId = null;}
		    	String paragraphName = rs.getString("paragraphName");  
		    	String paragraphType = rs.getString("paragraphType");  
		    	String paragraphDesc = rs.getString("paragraphDesc");  
		    	String paragraphStr = rs.getString("paragraphStr");  
		    	String authorName = rs.getString("authorName");  
		    	String sourceName = rs.getString("sourceName");  
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNumber = rs.getLong("pageNumber");  	if (rs.wasNull()) {pageNumber = null;}
		        Long lineNumber = rs.getLong("lineNumber");  	if (rs.wasNull()) {lineNumber = null;}
		        Long wordNumber = rs.getLong("wordNumber");  	if (rs.wasNull()) {wordNumber = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    
		        NodeParagraph paragraph = new NodeParagraph(paragraphId,sectionId,bookId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        bookSet.getListParagraph().add(paragraph);
		        bookSet.getMapId2Paragraph().put(paragraph.getParagraphId(),paragraph);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableParagraph: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableSection(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT sectionId,chapterId,bookId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM BOOK_SECTION WHERE bookId in (select bookId from BOOK_BOOK WHERE bookSetId = ? ) "+
				 		"ORDER BY chapterId,sectionId";
		//public NodeSection(Long sectionId, Long chapterId, Long bookId, Long languageId, Long sameSectionId, String sectionName,
		//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long sectionId = rs.getLong("sectionId");
		    	Long chapterId = rs.getLong("chapterId");  	if (rs.wasNull()) {chapterId = null;}
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	Long sameSectionId = rs.getLong("sameSectionId");  	if (rs.wasNull()) {sameSectionId = null;}
		    	String sectionName = rs.getString("sectionName");  
		    	String sectionType = rs.getString("sectionType");  
		    	String sectionDesc = rs.getString("sectionDesc");  
		    	String sectionStr = rs.getString("sectionStr");  
		    	String authorName = rs.getString("authorName");  
		    	String sourceName = rs.getString("sourceName");  
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNumber = rs.getLong("pageNumber");  	if (rs.wasNull()) {pageNumber = null;}
		        Long lineNumber = rs.getLong("lineNumber");  	if (rs.wasNull()) {lineNumber = null;}
		        Long wordNumber = rs.getLong("wordNumber");  	if (rs.wasNull()) {wordNumber = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    
		        NodeSection section = new NodeSection(sectionId,chapterId,bookId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        bookSet.getListSection().add(section);
		        bookSet.getMapId2Section().put(section.getSectionId(),section);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableSection: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableChapter(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	" SELECT chapterId,bookId,languageId,chapterName,chapterType,chapterDesc, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate, modificationDate "+
						" FROM BOOK_CHAPTER WHERE bookId in (select bookId from BOO_BOOK WHERE bookSetId = ? ) ORDER BY bookId,chapterId";
		//public NodeChapter(Long chapterId, Long bookId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long chapterId = rs.getLong("chapterId");
		    	Long bookId = rs.getLong("bookId");  	if (rs.wasNull()) {bookId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	String chapterName = rs.getString("chapterName");  
		    	String chapterType = rs.getString("chapterType");  
		    	String chapterDesc = rs.getString("chapterDesc");  
		    	String authorName = rs.getString("authorName");  
		    	String sourceName = rs.getString("sourceName");  
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNumber = rs.getLong("pageNumber");  	if (rs.wasNull()) {pageNumber = null;}
		        Long lineNumber = rs.getLong("lineNumber");  	if (rs.wasNull()) {lineNumber = null;}
		        Long wordNumber = rs.getLong("wordNumber");  	if (rs.wasNull()) {wordNumber = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    
		        NodeChapter chapter = new NodeChapter(chapterId,bookId,languageId,chapterName,chapterType,chapterDesc, 
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        bookSet.getListChapter().add(chapter);
		        bookSet.getMapId2Chapter().put(chapter.getChapterId(),chapter);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableChapter: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableBook(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = 	"SELECT bookId,bookSetId,languageId,secondLanguageId,bookName,bookType,bookDesc,isbn, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM BOOK_BOOK WHERE bookSetId = ? ORDER BY bookSetId,bookId";
		//public NodeBook(Long bookId, Long bookSetId, Long languageId, Long secondLanguageId, String bookName,
		//String bookType, String bookDesc, String isbn, String authorName, String sourceName,
		//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long bookId = rs.getLong("bookId");
		    	Long bookSetId = rs.getLong("bookSetId");  	if (rs.wasNull()) {bookSetId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	Long secondLanguageId = rs.getLong("secondLanguageId");  	if (rs.wasNull()) {secondLanguageId = null;}
		    	String bookName = rs.getString("bookName");  
		    	String bookType = rs.getString("bookType");  
		    	String bookDesc = rs.getString("bookDesc");  
		    	String isbn = rs.getString("isbn");  
		    	String authorName = rs.getString("authorName");  
		    	String sourceName = rs.getString("sourceName");  
		    	Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long pageNumber = rs.getLong("pageNumber");  	if (rs.wasNull()) {pageNumber = null;}
		        Long lineNumber = rs.getLong("lineNumber");  	if (rs.wasNull()) {lineNumber = null;}
		        Long wordNumber = rs.getLong("wordNumber");  	if (rs.wasNull()) {wordNumber = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    
		        NodeBook book = new NodeBook(bookId,bookSetId,languageId,secondLanguageId,bookName,bookType,bookDesc,isbn, 
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        bookSet.getListBook().add(book);
		        bookSet.getMapId2Book().put(book.getBookId(),book);
		        cntRead++;
		    }
		    System.out.println("readBookSetTableBook: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readBookSetTableLanguage(Connection conn, NodeBookSet bookSet)	{
		int cntRead = 0;
		String query = "SELECT languageId,languageName,shortName,alhabetName FROM BOOK_LANGUAGE"; //IBRARY WHERE bookSetId= ? ORDER BY bookSetId";
		//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName)
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    //ps.setLong(1, bookSet.getBookSetId()); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long languageId = rs.getLong("languageId");
		        String languageName = rs.getString("languageName");
		        String shortName = rs.getString("shortName");
		        String alhabetName = rs.getString("alhabetName");
		        //String creationdateStr = rs.getString("creationDate");
			    //ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeLanguage language = new NodeLanguage(languageId,languageName,shortName,alhabetName);
			    bookSet.getListLanguage().add(language);
		        bookSet.getMapId2Language().put(language.getLanguageId(),language);        
		    }
		    System.out.println("readBookSetTableLanguage: bookSet = " + bookSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static NodeBookSet readBookSetTableBookSet(Connection conn,long bookSetId)	{
		NodeBookSet bookSet = null;
		String query = 	"SELECT bookSetId,fileSetId,bookSetName,bookSetDesc,sourceDesc,creationDate,modificationDate "+
						"FROM BOOK_BOOKSET WHERE bookSetId= ? ORDER BY bookSetId";
		//public NodeBookSet(Long bookSetId, Long fileSetId, String bookSetName, String bookSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, bookSetId); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long graphId2 = rs.getLong("bookSetId");
		        Long fileSetId = rs.getLong("fileSetId");  	if (rs.wasNull()) {fileSetId = null;}
		        
		        String bookSetName = rs.getString("bookSetName");
		        String bookSetDesc = rs.getString("bookSetDesc");
		        String sourceDesc = rs.getString("sourceDesc");
		        String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    bookSet = new NodeBookSet(bookSetId,fileSetId,bookSetName,bookSetDesc,sourceDesc,creationDate,modificationDate);
		    }
		    System.out.println("readBookSetTableBookSet: bookSet = " + bookSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(bookSet);
	}
	public static NodeBookSet readBookSet(Connection conn, long bookSetId) {
		NodeBookSet bookSet = readBookSetTableBookSet(conn, bookSetId);
		if (bookSet==null) return (null);
		int cntReadBookFile = readBookSetTableBookFile(conn,bookSet);
		int cntReadBookImage = readBookSetTableBookImage(conn,bookSet);
		int cntReadBookBlob = readBookSetTableBookBlob(conn,bookSet);
		int cntReadBook = readBookSetTableBook(conn,bookSet);
		int cntReadLanguage = readBookSetTableLanguage(conn,bookSet);
		int cntReadChapter = readBookSetTableChapter(conn,bookSet);
		int cntReadSection = readBookSetTableSection(conn,bookSet);
		int cntReadParagraph = readBookSetTableParagraph(conn,bookSet);
		int cntReadSentence = readBookSetTableSentence(conn,bookSet);
		int cntReadToken = readBookSetTableToken(conn,bookSet);
		
		postProcessBookSet(bookSet);
		
		int cntRead = cntReadBookFile + cntReadBookImage + cntReadBookBlob + cntReadBook + cntReadLanguage + cntReadChapter + 
				cntReadSection + cntReadParagraph + cntReadSentence + cntReadToken + 1;
	    System.out.println("readBookSet: total recordS read = " + cntRead);
		return(bookSet);
	}	
	private static void postProcessBookSet(NodeBookSet bookSet)	{
		//private HashMap<String,NodeParagraph> mapStr2Paragraph;
		//private HashMap<String,NodeSentence> mapStr2Sentence;
		//private HashMap<String,NodeToken> mapStr2Token;
		for (NodeParagraph paragraph : bookSet.getListParagraph())	{	bookSet.getMapStr2Paragraph().put(paragraph.getParagraphStr(), paragraph); }
		for (NodeSentence sentence : bookSet.getListSentence())		{	bookSet.getMapStr2Sentence().put(sentence.getSentenceStr(), sentence); }
		for (NodeToken token : bookSet.getListToken())				{	bookSet.getMapStr2Token().put(token.getTokenStr(), token); }		
	}
	public static NodeBookSet readBookSetTables(Connection conn, long bookSetId)	{
		
		NodeBookSet bookSet = readBookSet(conn,bookSetId);
		if (bookSet!=null)	{
			System.out.println("bookSet.getListBookFile().size() = "+bookSet.getListBookFile().size());
			System.out.println("bookSet.getListBookImage().size() = "+bookSet.getListBookImage().size());
			System.out.println("bookSet.getListBookBlob().size() = "+bookSet.getListBookBlob().size());
			System.out.println("bookSet.getListLanguage().size() = "+bookSet.getListLanguage().size());
			System.out.println("bookSet.getListBook().size() = "+bookSet.getListBook().size());
			System.out.println("bookSet.getListChapter().size() = "+bookSet.getListChapter().size());
			System.out.println("bookSet.getListSection().size() = "+bookSet.getListSection().size());
			System.out.println("bookSet.getListParagraph().size() = "+bookSet.getListParagraph().size());
			System.out.println("bookSet.getListSentence().size() = "+bookSet.getListSentence().size());
			System.out.println("bookSet.getListToken().size() = "+bookSet.getListToken().size());
			
			System.out.println("bookSet.getMapId2BookFile().size() = "+bookSet.getMapId2BookFile().size());
			System.out.println("bookSet.getMapId2BookImage().size() = "+bookSet.getMapId2BookImage().size());
			System.out.println("bookSet.getMapId2BookBlob().size() = "+bookSet.getMapId2BookBlob().size());
			System.out.println("bookSet.getMapId2Language().size() = "+bookSet.getMapId2Language().size());
			System.out.println("bookSet.getMapId2Book().size() = "+bookSet.getMapId2Book().size());
			System.out.println("bookSet.getMapId2Chapter().size() = "+bookSet.getMapId2Chapter().size());
			System.out.println("bookSet.getMapId2Section().size() = "+bookSet.getMapId2Section().size());
			System.out.println("bookSet.getMapId2Paragraph().size() = "+bookSet.getMapId2Paragraph().size());
			System.out.println("bookSet.getMapId2Sentence().size() = "+bookSet.getMapId2Sentence().size());
			System.out.println("bookSet.getMapId2Token().size() = "+bookSet.getMapId2Token().size());
			
			System.out.println("bookSet.getMapStr2Paragraph().size() = "+bookSet.getMapStr2Paragraph().size());
			System.out.println("bookSet.getMapStr2Sentence().size() = "+bookSet.getMapStr2Sentence().size());
			System.out.println("bookSet.getMapStr2Token().size() = "+bookSet.getMapStr2Token().size());
			
		} else {
			System.out.println("readBookSetTables: bookSet is null");
		}
		return (bookSet);
	}
	
}