package tool10.bookset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class WriteBookSetTablesToDb {

	public static int writeTableBookBlob(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_BOOKBLOB (bookBlobId,bookId,fileBlobId,bookType,blobType,bookSize,bookBytes,crc64,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeBookBlob(Long bookBlobId, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
		//byte[] bookBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBookBlob ent : bookSet.getListBookBlob())	{
			    int cnt=1;
			    if (ent.getBookBlobId()!=null) {ps.setLong(cnt++, ent.getBookBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBookType());
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBookSize()!=null) {ps.setLong(cnt++, ent.getBookSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookBytes()!=null) {ps.setBytes(cnt++, ent.getBookBytes()); } 	else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableBookBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBookFile(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_BOOKFILE (bookFileId,bookId,fileId,bookSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"sourceFileSize,sourceFileCreationDate,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeBookFile(Long bookFileId, Long bookId, Long fileId, Long bookSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBookFile ent : bookSet.getListBookFile())	{
			    int cnt=1;
			    if (ent.getBookFileId()!=null) {ps.setLong(cnt++, ent.getBookFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookSetId()!=null) {ps.setLong(cnt++, ent.getBookSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSourceAbsolutePath());
			    ps.setString(cnt++, ent.getSourceDirName());
			    ps.setString(cnt++, ent.getSourceFileName());
			    ps.setString(cnt++, ent.getSourceExtensionName());
			    if (ent.getSourceFileSize()!=null) {ps.setLong(cnt++, ent.getSourceFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceFileCreationDate()!=null) {ps.setString(cnt++, ent.getSourceFileCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableBookFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBookImage(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_BOOKIMAGE(bookImageId,bookId,bookSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,pageNum,"+
						"locX,locY,sizeX,sizeY,imageCaption,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeBookImage(Long bookImageId, Long bookId, Long bookSetId, Long imageId, Long imageSetId,
		//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
		//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBookImage ent : bookSet.getListBookImage())	{
			    int cnt=1;
			    if (ent.getBookImageId()!=null) {ps.setLong(cnt++, ent.getBookImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookSetId()!=null) {ps.setLong(cnt++, ent.getBookSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageSetId()!=null) {ps.setLong(cnt++, ent.getImageSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getImageAbsolutePath());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPageNum()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLocX()!=null) {ps.setDouble(cnt++, ent.getLocX());} else {ps.setNull(cnt++,Types.DOUBLE);} 
			    if (ent.getLocY()!=null) {ps.setDouble(cnt++, ent.getLocY());} else {ps.setNull(cnt++,Types.DOUBLE);} 
			    if (ent.getSizeX()!=null) {ps.setDouble(cnt++, ent.getSizeX());} else {ps.setNull(cnt++,Types.DOUBLE);} 
			    if (ent.getSizeY()!=null) {ps.setDouble(cnt++, ent.getSizeY());} else {ps.setNull(cnt++,Types.DOUBLE);} 
			    ps.setString(cnt++, ent.getImageCaption());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableBookImage: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableToken(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_TOKEN(tokenId,dictId,wordId,tokenStr,tokenDesc,tokenLength,cntInBookSet,frequencyBookSet,creationDate,modificationDate) "+
						" VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInBookSet, Double frequencyBookSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeToken ent : bookSet.getListToken())	{
			    int cnt=1;
			    if (ent.getTokenId()!=null) {ps.setLong(cnt++, ent.getTokenId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDictId()!=null) {ps.setLong(cnt++, ent.getDictId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getWordId()!=null) {ps.setLong(cnt++, ent.getWordId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getTokenStr());
			    ps.setString(cnt++, ent.getTokenDesc());
			    if (ent.getTokenLength()!=null) {ps.setLong(cnt++, ent.getTokenLength());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntInBookSet()!=null) {ps.setLong(cnt++, ent.getCntInBookSet());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFrequencyBookSet()!=null) {ps.setDouble(cnt++, ent.getFrequencyBookSet());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableToken: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableSentence(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_SENTENCE(sentenceId,paragraphId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate, modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeSentence(Long sentenceId, Long paragraphId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDesc,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSentence ent : bookSet.getListSentence())	{
			    int cnt=1;
			    if (ent.getSentenceId()!=null) {ps.setLong(cnt++, ent.getSentenceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getParagraphId()!=null) {ps.setLong(cnt++, ent.getParagraphId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSameSentenceId()!=null) {ps.setLong(cnt++, ent.getSameSentenceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSentenceName());
			    ps.setString(cnt++, ent.getSentenceType());
			    ps.setString(cnt++, ent.getSentenceDesc());
			    ps.setString(cnt++, ent.getSentenceStr());
			    ps.setString(cnt++, ent.getSentenceHolder());
			    ps.setString(cnt++, ent.getAuthorName());
			    ps.setString(cnt++, ent.getSourceName());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPageNumber()!=null) {ps.setLong(cnt++, ent.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineNumber()!=null) {ps.setLong(cnt++, ent.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getWordNumber()!=null) {ps.setLong(cnt++, ent.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableSentence: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}		
	public static int writeTableParagraph(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_PARAGRAPH(paragraphId,sectionId,bookId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeParagraph(Long paragraphId, Long sectionId, Long bookId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeParagraph ent : bookSet.getListParagraph())	{
			    int cnt=1;
			    if (ent.getParagraphId()!=null) {ps.setLong(cnt++, ent.getParagraphId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSectionId()!=null) {ps.setLong(cnt++, ent.getSectionId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSameParagraphId()!=null) {ps.setLong(cnt++, ent.getSameParagraphId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getParagraphName());
			    ps.setString(cnt++, ent.getParagraphType());
			    ps.setString(cnt++, ent.getParagraphDesc());
			    ps.setString(cnt++, ent.getParagraphStr());
			    ps.setString(cnt++, ent.getAuthorName());
			    ps.setString(cnt++, ent.getSourceName());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPageNumber()!=null) {ps.setLong(cnt++, ent.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineNumber()!=null) {ps.setLong(cnt++, ent.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getWordNumber()!=null) {ps.setLong(cnt++, ent.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableParagraph: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableSection(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_SECTION(sectionId,chapterId,bookId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeSection(Long sectionId, Long chapterId, Long bookId, Long languageId, Long sameSectionId, String sectionName, String sectionType,
		//String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSection ent : bookSet.getListSection())	{
			    int cnt=1;
			    if (ent.getSectionId()!=null) {ps.setLong(cnt++, ent.getSectionId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getChapterId()!=null) {ps.setLong(cnt++, ent.getChapterId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSameSectionId()!=null) {ps.setLong(cnt++, ent.getSameSectionId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSectionName());
			    ps.setString(cnt++, ent.getSectionType());
			    ps.setString(cnt++, ent.getSectionDesc());
			    ps.setString(cnt++, ent.getSectionStr());
			    ps.setString(cnt++, ent.getAuthorName());
			    ps.setString(cnt++, ent.getSourceName());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPageNumber()!=null) {ps.setLong(cnt++, ent.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineNumber()!=null) {ps.setLong(cnt++, ent.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getWordNumber()!=null) {ps.setLong(cnt++, ent.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableSection: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableChapter(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_CHAPTER (chapterId,bookId,languageId,chapterName,chapterType,chapterDesc,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?, 	?, ?, ?, ?)";
		//public NodeChapter(Long chapterId, Long bookId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeChapter ent : bookSet.getListChapter())	{
			    int cnt=1;
			    if (ent.getChapterId()!=null) {ps.setLong(cnt++, ent.getChapterId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBookId()!=null) {ps.setLong(cnt++, ent.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getChapterName());
			    ps.setString(cnt++, ent.getChapterType());
			    ps.setString(cnt++, ent.getChapterDesc());
			    ps.setString(cnt++, ent.getAuthorName());
			    ps.setString(cnt++, ent.getSourceName());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPageNumber()!=null) {ps.setLong(cnt++, ent.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineNumber()!=null) {ps.setLong(cnt++, ent.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getWordNumber()!=null) {ps.setLong(cnt++, ent.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableChapter: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableBook(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_BOOK (bookId,bookSetId,languageId,secondLanguageId,bookName,bookType,bookDesc,isbn,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?, 	?, ?, ?, ?, ?,   ?)";
		//public NodeBook(Long bookId, Long bookSetId, Long languageId, Long secondLanguageId, String bookName,
		//String bookType, String bookDesc, String isbn, String authorName, String sourceName,
		//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBook book : bookSet.getListBook())	{
			    int cnt=1;
			    if (book.getBookId()!=null) {ps.setLong(cnt++, book.getBookId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (book.getBookSetId()!=null) {ps.setLong(cnt++, book.getBookSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (book.getLanguageId()!=null) {ps.setLong(cnt++, book.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (book.getSecondLanguageId()!=null) {ps.setLong(cnt++, book.getSecondLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, book.getBookName());
			    ps.setString(cnt++, book.getBookType());
			    ps.setString(cnt++, book.getBookDesc());
			    ps.setString(cnt++, book.getIsbn());
			    ps.setString(cnt++, book.getAuthorName());
			    ps.setString(cnt++, book.getSourceName());
			    if (book.getDisplayOrder()!=null) {ps.setLong(cnt++, book.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (book.getPageNumber()!=null) {ps.setLong(cnt++, book.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (book.getLineNumber()!=null) {ps.setLong(cnt++, book.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (book.getWordNumber()!=null) {ps.setLong(cnt++, book.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (book.getCreationDate()!=null) {ps.setString(cnt++, book.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (book.getModificationDate()!=null) {ps.setString(cnt++, book.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableBook: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableLanguage(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO BOOK_LANGUAGE (languageId,languageName,shortName,alhabetName) VALUES( ?, ?, ?, ?)";
		//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeLanguage lang : bookSet.getListLanguage())	{
			    int cnt=1;
			    if (lang.getLanguageId()!=null) {ps.setLong(cnt++, lang.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, lang.getLanguageName());
			    ps.setString(cnt++, lang.getShortName());
			    ps.setString(cnt++, lang.getAlhabetName());
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableLanguage: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBookSet(Connection conn,NodeBookSet bookSet)	{
		int cntInserted = 0;
		String query = 	" INSERT INTO BOOK_BOOKSET (bookSetId,fileSetId,bookSetName,bookSetDesc,sourceDesc,creationDate, modificationDate) "+
						" VALUES ( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeBookSet(Long bookSetId, Long fileSetId, String bookSetName, String bookSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (bookSet.getBookSetId()!=null) {ps.setLong(cnt++, bookSet.getBookSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (bookSet.getFileSetId()!=null) {ps.setLong(cnt++, bookSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    ps.setString(cnt++, bookSet.getBookSetName());
		    ps.setString(cnt++, bookSet.getBookSetDesc());
		    ps.setString(cnt++, bookSet.getSourceDesc());
		    if (bookSet.getCreationDate()!=null) {ps.setString(cnt++, bookSet.getCreationDate().toString()); } 			else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (bookSet.getModificationDate()!=null) {ps.setString(cnt++, bookSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableBookSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeBookSet(Connection conn,  NodeBookSet bookSet)	{
		int cntInsertedBookSet = writeTableBookSet(conn,bookSet);
		int cntInsertedLanguage = writeTableLanguage(conn,bookSet);
		int cntInsertedBook = writeTableBook(conn,bookSet);
		int cntInsertedChapter = writeTableChapter(conn,bookSet);
		int cntInsertedSection = writeTableSection(conn,bookSet);
		int cntInsertedParagraph = writeTableParagraph(conn,bookSet);
		int cntInsertedSentence = writeTableSentence(conn,bookSet);
		int cntInsertedToken = writeTableToken(conn,bookSet);
		int cntInsertedBookFile = writeTableBookFile(conn,bookSet);
		int cntInsertedBookImage = writeTableBookImage(conn,bookSet);
		int cntInsertedBookBlob = writeTableBookBlob(conn,bookSet);
		
		int cntInserted = cntInsertedBookSet + cntInsertedLanguage + cntInsertedBook + cntInsertedChapter + cntInsertedSection + cntInsertedParagraph + 
				cntInsertedSentence + cntInsertedToken + cntInsertedBookFile + cntInsertedBookImage + cntInsertedBookBlob;
		return(cntInserted);
	}	
	public static void writeBookSetTables(Connection conn, NodeBookSet bookSet)	{
		writeBookSet(conn,bookSet);
	}
	
}