package tool10.docset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class WriteDocSetTablesToDb {

	public static int writeTableDocBlob(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_DOCBLOB (docBlobId,docId,fileBlobId,docType,blobType,docSize,docBytes,crc64,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeDocBlob(Long docBlobId, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
		//byte[] docBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeDocBlob ent : docSet.getListDocBlob())	{
			    int cnt=1;
			    if (ent.getDocBlobId()!=null) {ps.setLong(cnt++, ent.getDocBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getDocType());
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getDocSize()!=null) {ps.setLong(cnt++, ent.getDocSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocBytes()!=null) {ps.setBytes(cnt++, ent.getDocBytes()); } 	else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableDocBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableDocFile(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_DOCFILE (docFileId,docId,fileId,docSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"sourceFileSize,sourceFileCreationDate,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeDocFile(Long docFileId, Long docId, Long fileId, Long docSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeDocFile ent : docSet.getListDocFile())	{
			    int cnt=1;
			    if (ent.getDocFileId()!=null) {ps.setLong(cnt++, ent.getDocFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocSetId()!=null) {ps.setLong(cnt++, ent.getDocSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
		    System.out.println("writeTableDocFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableDocImage(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_DOCIMAGE(docImageId,docId,docSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,pageNum,"+
						"locX,locY,sizeX,sizeY,imageCaption,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeDocImage(Long docImageId, Long docId, Long docSetId, Long imageId, Long imageSetId,
		//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
		//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeDocImage ent : docSet.getListDocImage())	{
			    int cnt=1;
			    if (ent.getDocImageId()!=null) {ps.setLong(cnt++, ent.getDocImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocSetId()!=null) {ps.setLong(cnt++, ent.getDocSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
		    System.out.println("writeTableDocImage: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableToken(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_TOKEN(tokenId,dictId,wordId,tokenStr,tokenDesc,tokenLength,cntInDocSet,frequencyDocSet,creationDate,modificationDate) "+
						" VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInDocSet, Double frequencyDocSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeToken ent : docSet.getListToken())	{
			    int cnt=1;
			    if (ent.getTokenId()!=null) {ps.setLong(cnt++, ent.getTokenId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDictId()!=null) {ps.setLong(cnt++, ent.getDictId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getWordId()!=null) {ps.setLong(cnt++, ent.getWordId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getTokenStr());
			    ps.setString(cnt++, ent.getTokenDesc());
			    if (ent.getTokenLength()!=null) {ps.setLong(cnt++, ent.getTokenLength());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCntInDocSet()!=null) {ps.setLong(cnt++, ent.getCntInDocSet());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFrequencyDocSet()!=null) {ps.setDouble(cnt++, ent.getFrequencyDocSet());} else {ps.setNull(cnt++,Types.DOUBLE);}
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
	public static int writeTableSentence(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_SENTENCE(sentenceId,paragraphId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate, modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeSentence(Long sentenceId, Long paragraphId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDesc,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSentence ent : docSet.getListSentence())	{
			    int cnt=1;
			    if (ent.getSentenceId()!=null) {ps.setLong(cnt++, ent.getSentenceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getParagraphId()!=null) {ps.setLong(cnt++, ent.getParagraphId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
	public static int writeTableParagraph(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_PARAGRAPH(paragraphId,sectionId,docId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeParagraph(Long paragraphId, Long sectionId, Long docId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeParagraph ent : docSet.getListParagraph())	{
			    int cnt=1;
			    if (ent.getParagraphId()!=null) {ps.setLong(cnt++, ent.getParagraphId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSectionId()!=null) {ps.setLong(cnt++, ent.getSectionId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
	public static int writeTableSection(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_SECTION(sectionId,chapterId,docId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeSection(Long sectionId, Long chapterId, Long docId, Long languageId, Long sameSectionId, String sectionName, String sectionType,
		//String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSection ent : docSet.getListSection())	{
			    int cnt=1;
			    if (ent.getSectionId()!=null) {ps.setLong(cnt++, ent.getSectionId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getChapterId()!=null) {ps.setLong(cnt++, ent.getChapterId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
	public static int writeTableChapter(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_CHAPTER (chapterId,docId,languageId,chapterName,chapterType,chapterDesc,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?, 	?, ?, ?, ?)";
		//public NodeChapter(Long chapterId, Long docId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeChapter ent : docSet.getListChapter())	{
			    int cnt=1;
			    if (ent.getChapterId()!=null) {ps.setLong(cnt++, ent.getChapterId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDocId()!=null) {ps.setLong(cnt++, ent.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
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
	public static int writeTableDoc(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_DOC (docId,docSetId,languageId,secondLanguageId,docName,docType,docDesc,isbn,authorName,sourceName,"+ 
						"displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?, 	?, ?, ?, ?, ?,   ?)";
		//public NodeDoc(Long docId, Long docSetId, Long languageId, Long secondLanguageId, String docName,
		//String docType, String docDesc, String isbn, String authorName, String sourceName,
		//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeDoc doc : docSet.getListDoc())	{
			    int cnt=1;
			    if (doc.getDocId()!=null) {ps.setLong(cnt++, doc.getDocId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (doc.getDocSetId()!=null) {ps.setLong(cnt++, doc.getDocSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (doc.getLanguageId()!=null) {ps.setLong(cnt++, doc.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (doc.getSecondLanguageId()!=null) {ps.setLong(cnt++, doc.getSecondLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, doc.getDocName());
			    ps.setString(cnt++, doc.getDocType());
			    ps.setString(cnt++, doc.getDocDesc());
			    ps.setString(cnt++, doc.getIsbn());
			    ps.setString(cnt++, doc.getAuthorName());
			    ps.setString(cnt++, doc.getSourceName());
			    if (doc.getDisplayOrder()!=null) {ps.setLong(cnt++, doc.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (doc.getPageNumber()!=null) {ps.setLong(cnt++, doc.getPageNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (doc.getLineNumber()!=null) {ps.setLong(cnt++, doc.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (doc.getWordNumber()!=null) {ps.setLong(cnt++, doc.getWordNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (doc.getCreationDate()!=null) {ps.setString(cnt++, doc.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (doc.getModificationDate()!=null) {ps.setString(cnt++, doc.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
				cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableDoc: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableLanguage(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO DOC_LANGUAGE (languageId,languageName,shortName,alhabetName) VALUES( ?, ?, ?, ?)";
		//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeLanguage lang : docSet.getListLanguage())	{
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
	public static int writeTableDocSet(Connection conn,NodeDocSet docSet)	{
		int cntInserted = 0;
		String query = 	" INSERT INTO DOC_DOCSET (docSetId,fileSetId,docSetName,docSetDesc,sourceDesc,creationDate, modificationDate) "+
						" VALUES ( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeDocSet(Long docSetId, Long fileSetId, String docSetName, String docSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (docSet.getDocSetId()!=null) {ps.setLong(cnt++, docSet.getDocSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (docSet.getFileSetId()!=null) {ps.setLong(cnt++, docSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    ps.setString(cnt++, docSet.getDocSetName());
		    ps.setString(cnt++, docSet.getDocSetDesc());
		    ps.setString(cnt++, docSet.getSourceDesc());
		    if (docSet.getCreationDate()!=null) {ps.setString(cnt++, docSet.getCreationDate().toString()); } 			else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (docSet.getModificationDate()!=null) {ps.setString(cnt++, docSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableDocSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeDocSet(Connection conn,  NodeDocSet docSet)	{
		int cntInsertedDocSet = writeTableDocSet(conn,docSet);
		int cntInsertedLanguage = writeTableLanguage(conn,docSet);
		int cntInsertedDoc = writeTableDoc(conn,docSet);
		int cntInsertedChapter = writeTableChapter(conn,docSet);
		int cntInsertedSection = writeTableSection(conn,docSet);
		int cntInsertedParagraph = writeTableParagraph(conn,docSet);
		int cntInsertedSentence = writeTableSentence(conn,docSet);
		int cntInsertedToken = writeTableToken(conn,docSet);
		int cntInsertedDocFile = writeTableDocFile(conn,docSet);
		int cntInsertedDocImage = writeTableDocImage(conn,docSet);
		int cntInsertedDocBlob = writeTableDocBlob(conn,docSet);
		
		int cntInserted = cntInsertedDocSet + cntInsertedLanguage + cntInsertedDoc + cntInsertedChapter + cntInsertedSection + cntInsertedParagraph + 
				cntInsertedSentence + cntInsertedToken + cntInsertedDocFile + cntInsertedDocImage + cntInsertedDocBlob;
		return(cntInserted);
	}	
	public static void writeDocSetTables(Connection conn, NodeDocSet docSet)	{
		writeDocSet(conn,docSet);
	}
	
}