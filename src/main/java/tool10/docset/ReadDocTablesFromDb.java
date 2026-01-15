package tool10.docset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ReadDocTablesFromDb {
	
	public static int readDocSetTableDocBlob(Connection conn,NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT docBlobId,docId,fileBlobId,docType,blobType,docSize,docBytes,crc64,creationDate,modificationDate "+
					    "FROM DOC_DOCBLOB WHERE docId in (SELECT docId FROM DOC_DOC WHERE docSetId= ?) "+
					    "ORDER BY docId, docBlobId";
		//public NodeDocBlob(Long docBlobId, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
		//byte[] docBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long docBlobId = rs.getLong("docBlobId");  	if (rs.wasNull()) {docBlobId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
		    	Long fileBlobId = rs.getLong("fileBlobId");  	if (rs.wasNull()) {fileBlobId = null;}
		    	String docType = rs.getString("docType");
		        String blobType = rs.getString("blobType");
		    	Long docSize = rs.getLong("docSize");  	if (rs.wasNull()) {docSize = null;}
		    	byte[] docBytes= rs.getBytes("docBytes");  	if (rs.wasNull()) {docBytes = null;}
		    	Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
		    	String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeDocBlob imageBlob = new NodeDocBlob(docBlobId,docId,fileBlobId,docType,blobType,docSize,docBytes,null,crc64,creationDate,modificationDate);
			    docSet.getListDocBlob().add(imageBlob);
			    docSet.getMapId2DocBlob().put(imageBlob.getDocBlobId(),imageBlob);  
			    cntRead++;
		    }
		    System.out.println("readDocSetTableDocBlob: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableDocFile(Connection conn,NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT docFileId,docId,fileId,docSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"	sourceFileSize,sourceFileCreationDate,creationDate,modificationDate "+
					    "FROM DOC_DOCFILE WHERE docSetId= ? ORDER BY docSetId, docFileId";
		//public NodeDocFile(Long docFileId, Long docId, Long fileId, Long docSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long docFileId = rs.getLong("docFileId");  	if (rs.wasNull()) {docFileId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
		    	Long fileId = rs.getLong("fileId");  	if (rs.wasNull()) {fileId = null;}
		    	Long docSetId = rs.getLong("docSetId");  	if (rs.wasNull()) {docSetId = null;}
		    	
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
			    NodeDocFile docFile = new NodeDocFile(docFileId,docId,fileId,docSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
							sourceFileSize,sourceFileCreationDate,creationDate,modificationDate);
			    docSet.getListDocFile().add(docFile);
			    docSet.getMapId2DocFile().put(docFile.getDocFileId(),docFile);  
			    cntRead++;
		    }
		    System.out.println("readDocSetTableDocFile: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableDocImage(Connection conn,NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	" SELECT docImageId,docId,docSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,pageNum,locX,locY,sizeX,\r\n" +
						" sizeY,imageCaption,creationDate,modificationDate "+
					    "FROM DOC_DOCIMAGE WHERE docSetId= ? ORDER BY docSetId, docImageId";
		//public NodeDocImage(Long docImageId, Long docId, Long docSetId, Long imageId, Long imageSetId,
		//String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
		//Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {				
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long docImageId = rs.getLong("docImageId");  	if (rs.wasNull()) {docImageId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
		    	Long docSetId = rs.getLong("docSetId");  	if (rs.wasNull()) {docSetId = null;}
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
			    NodeDocImage docImage = new NodeDocImage(docImageId,docId,docSetId,imageId,imageSetId,imageAbsolutePath,displayOrder,
			    		pageNum,locX,locY,sizeX,sizeY,imageCaption,creationDate,modificationDate);
			    docSet.getListDocImage().add(docImage);
			    docSet.getMapId2DocImage().put(docImage.getDocImageId(),docImage);  
			    cntRead++;
		    }
		    System.out.println("readDocSetTableDocImage: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableToken(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT tokenId,dictId,wordId,tokenStr,tokenDesc,tokenLength,cntInDocSet,frequencyDocSet,creationDate,modificationDate "+
						"FROM DOC_TOKEN ORDER BY tokenId";
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInDocSet, Double frequencyDocSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ///ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long tokenId = rs.getLong("tokenId");
		    	Long dictId = rs.getLong("dictId");  	if (rs.wasNull()) {dictId = null;}
		    	Long wordId = rs.getLong("wordId");  	if (rs.wasNull()) {wordId = null;}
		    	String tokenStr = rs.getString("tokenStr");  
		    	String tokenDescription = rs.getString("tokenDescr");  
		    	Long tokenLength = rs.getLong("tokenLength");  	if (rs.wasNull()) {tokenLength = null;}
		    	Long cntInDocSet = rs.getLong("cntInDocSet");  	if (rs.wasNull()) {cntInDocSet = null;}
		    	Double frequencyDocSet = rs.getDouble("frequencyDocSet");  	if (rs.wasNull()) {frequencyDocSet = null;}
		        String creationdateStr = rs.getString("creationDate");  
		        String modificationDateStr = rs.getString("modificationDate");  
		        ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);
		        ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeToken token = new NodeToken(tokenId,dictId,wordId,tokenStr,tokenDescription,tokenLength,cntInDocSet,frequencyDocSet,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        docSet.getListToken().add(token);
		        docSet.getMapId2Token().put(token.getTokenId(),token);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableToken: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
			e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableSentence(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	" SELECT sentenceId,paragraphId,docId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder, "+
				 		" 	authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						" FROM DOC_SENTENCE WHERE docId in (select docId from DOC_DOC WHERE docSetId = ? ) "+
				 		" ORDER BY paragraphId,sentenceId";
		//public NodeSentence(Long sentenceId, Long paragraphId, Long docId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDescription,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long sentenceId = rs.getLong("sentenceId");
		    	Long paragraphId = rs.getLong("paragraphId");  	if (rs.wasNull()) {paragraphId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
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
			    
		        NodeSentence sentence = new NodeSentence(sentenceId,paragraphId,docId,languageId,sameSentenceId,sentenceName,sentenceType,sentenceDesc,sentenceStr,sentenceHolder,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        docSet.getListSentence().add(sentence);
		        docSet.getMapId2Sentence().put(sentence.getSentenceId(),sentence);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableSentence: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
			e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableParagraph(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT paragraphId,sectionId,docId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM DOC_PARAGRAPH WHERE docId in (select docId from DOC_DOC WHERE docSetId = ? ) "+
				 		"ORDER BY sectionId,paragraphId";
		//public NodeParagraph(Long paragraphId, Long sectionId, Long docId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long paragraphId = rs.getLong("paragraphId");
		    	Long sectionId = rs.getLong("sectionId");  	if (rs.wasNull()) {sectionId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
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
			    
		        NodeParagraph paragraph = new NodeParagraph(paragraphId,sectionId,docId,languageId,sameParagraphId,paragraphName,paragraphType,paragraphDesc,paragraphStr,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        docSet.getListParagraph().add(paragraph);
		        docSet.getMapId2Paragraph().put(paragraph.getParagraphId(),paragraph);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableParagraph: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableSection(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT sectionId,chapterId,docId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM DOC_SECTION WHERE docId in (select docId from DOC_DOC WHERE docSetId = ? ) "+
				 		"ORDER BY chapterId,sectionId";
		//public NodeSection(Long sectionId, Long chapterId, Long docId, Long languageId, Long sameSectionId, String sectionName,
		//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long sectionId = rs.getLong("sectionId");
		    	Long chapterId = rs.getLong("chapterId");  	if (rs.wasNull()) {chapterId = null;}
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
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
			    
		        NodeSection section = new NodeSection(sectionId,chapterId,docId,languageId,sameSectionId,sectionName,sectionType,sectionDesc,sectionStr,  
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        docSet.getListSection().add(section);
		        docSet.getMapId2Section().put(section.getSectionId(),section);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableSection: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableChapter(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	" SELECT chapterId,docId,languageId,chapterName,chapterType,chapterDesc, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate, modificationDate "+
						" FROM DOC_CHAPTER WHERE docId in (select docId from DOC_DOC WHERE docSetId = ? ) ORDER BY docId,chapterId";
		//public NodeChapter(Long chapterId, Long docId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long chapterId = rs.getLong("chapterId");
		    	Long docId = rs.getLong("docId");  	if (rs.wasNull()) {docId = null;}
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
			    
		        NodeChapter chapter = new NodeChapter(chapterId,docId,languageId,chapterName,chapterType,chapterDesc, 
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        docSet.getListChapter().add(chapter);
		        docSet.getMapId2Chapter().put(chapter.getChapterId(),chapter);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableChapter: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableDoc(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = 	"SELECT docId,docSetId,languageId,secondLanguageId,docName,docType,docDesc,isbn, "+
				 		" authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate "+
						"FROM DOC_DOC WHERE docSetId = ? ORDER BY docSetId,docId";
		//public NodeDoc(Long docId, Long docSetId, Long languageId, Long secondLanguageId, String docName,
		//String docType, String docDesc, String isbn, String authorName, String sourceName,
		//Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long docId = rs.getLong("docId");
		    	Long docSetId = rs.getLong("docSetId");  	if (rs.wasNull()) {docSetId = null;}
		    	Long languageId = rs.getLong("languageId");  	if (rs.wasNull()) {languageId = null;}
		    	Long secondLanguageId = rs.getLong("secondLanguageId");  	if (rs.wasNull()) {secondLanguageId = null;}
		    	String docName = rs.getString("docName");  
		    	String docType = rs.getString("docType");  
		    	String docDesc = rs.getString("docDesc");  
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
			    
		        NodeDoc doc = new NodeDoc(docId,docSetId,languageId,secondLanguageId,docName,docType,docDesc,isbn, 
		        		authorName,sourceName,displayOrder,pageNumber,lineNumber,wordNumber,creationDate,modificationDate);
		        //System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		        docSet.getListDoc().add(doc);
		        docSet.getMapId2Doc().put(doc.getDocId(),doc);
		        cntRead++;
		    }
		    System.out.println("readDocSetTableDoc: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readDocSetTableLanguage(Connection conn, NodeDocSet docSet)	{
		int cntRead = 0;
		String query = "SELECT languageId,languageName,shortName,alhabetName FROM DOC_LANGUAGE"; //IBRARY WHERE docSetId= ? ORDER BY docSetId";
		//public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName)
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    //ps.setLong(1, docSet.getDocSetId()); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long languageId = rs.getLong("languageId");
		        String languageName = rs.getString("languageName");
		        String shortName = rs.getString("shortName");
		        String alhabetName = rs.getString("alhabetName");
		        //String creationdateStr = rs.getString("creationDate");
			    //ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    NodeLanguage language = new NodeLanguage(languageId,languageName,shortName,alhabetName);
			    docSet.getListLanguage().add(language);
		        docSet.getMapId2Language().put(language.getLanguageId(),language);        
		    }
		    System.out.println("readDocSetTableLanguage: docSet = " + docSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static NodeDocSet readDocSetTableDocSet(Connection conn,long docSetId)	{
		NodeDocSet docSet = null;
		String query = 	"SELECT docSetId,fileSetId,docSetName,docSetDesc,sourceDesc,creationDate,modificationDate "+
						"FROM DOC_DOCSET WHERE docSetId= ? ORDER BY docSetId";
		//public NodeDocSet(Long docSetId, Long fileSetId, String docSetName, String docSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, docSetId); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long graphId2 = rs.getLong("docSetId");
		        Long fileSetId = rs.getLong("fileSetId");  	if (rs.wasNull()) {fileSetId = null;}
		        
		        String docSetName = rs.getString("docSetName");
		        String docSetDesc = rs.getString("docSetDesc");
		        String sourceDesc = rs.getString("sourceDesc");
		        String creationdateStr = rs.getString("creationDate");
			    ZonedDateTime creationDate = ((creationdateStr!=null) ? ZonedDateTime.parse(creationdateStr) : null);	
			    String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    docSet = new NodeDocSet(docSetId,fileSetId,docSetName,docSetDesc,sourceDesc,creationDate,modificationDate);
		    }
		    System.out.println("readDocSetTableDocSet: docSet = " + docSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(docSet);
	}
	public static NodeDocSet readDocSet(Connection conn, long docSetId) {
		NodeDocSet docSet = readDocSetTableDocSet(conn, docSetId);
		if (docSet==null) return (null);
		int cntReadDocFile = readDocSetTableDocFile(conn,docSet);
		int cntReadDocImage = readDocSetTableDocImage(conn,docSet);
		int cntReadDocBlob = readDocSetTableDocBlob(conn,docSet);
		int cntReadDoc = readDocSetTableDoc(conn,docSet);
		int cntReadLanguage = readDocSetTableLanguage(conn,docSet);
		int cntReadChapter = readDocSetTableChapter(conn,docSet);
		int cntReadSection = readDocSetTableSection(conn,docSet);
		int cntReadParagraph = readDocSetTableParagraph(conn,docSet);
		int cntReadSentence = readDocSetTableSentence(conn,docSet);
		int cntReadToken = readDocSetTableToken(conn,docSet);
		
		postProcessDocSet(docSet);
		
		int cntRead = cntReadDocFile + cntReadDocImage + cntReadDocBlob + cntReadDoc + cntReadLanguage + cntReadChapter + 
				cntReadSection + cntReadParagraph + cntReadSentence + cntReadToken + 1;
	    System.out.println("readDocSet: total recordS read = " + cntRead);
		return(docSet);
	}	
	private static void postProcessDocSet(NodeDocSet docSet)	{
		//private HashMap<String,NodeParagraph> mapStr2Paragraph;
		//private HashMap<String,NodeSentence> mapStr2Sentence;
		//private HashMap<String,NodeToken> mapStr2Token;
		for (NodeParagraph paragraph : docSet.getListParagraph())	{	docSet.getMapStr2Paragraph().put(paragraph.getParagraphStr(), paragraph); }
		for (NodeSentence sentence : docSet.getListSentence())		{	docSet.getMapStr2Sentence().put(sentence.getSentenceStr(), sentence); }
		for (NodeToken token : docSet.getListToken())				{	docSet.getMapStr2Token().put(token.getTokenStr(), token); }		
	}
	public static NodeDocSet readDocSetTables(Connection conn, long docSetId)	{
		
		NodeDocSet docSet = readDocSet(conn,docSetId);
		if (docSet!=null)	{
			System.out.println("docSet.getListDocFile().size() = "+docSet.getListDocFile().size());
			System.out.println("docSet.getListDocImage().size() = "+docSet.getListDocImage().size());
			System.out.println("docSet.getListDocBlob().size() = "+docSet.getListDocBlob().size());
			System.out.println("docSet.getListLanguage().size() = "+docSet.getListLanguage().size());
			System.out.println("docSet.getListDoc().size() = "+docSet.getListDoc().size());
			System.out.println("docSet.getListChapter().size() = "+docSet.getListChapter().size());
			System.out.println("docSet.getListSection().size() = "+docSet.getListSection().size());
			System.out.println("docSet.getListParagraph().size() = "+docSet.getListParagraph().size());
			System.out.println("docSet.getListSentence().size() = "+docSet.getListSentence().size());
			System.out.println("docSet.getListToken().size() = "+docSet.getListToken().size());
			
			System.out.println("docSet.getMapId2DocFile().size() = "+docSet.getMapId2DocFile().size());
			System.out.println("docSet.getMapId2DocImage().size() = "+docSet.getMapId2DocImage().size());
			System.out.println("docSet.getMapId2DocBlob().size() = "+docSet.getMapId2DocBlob().size());
			System.out.println("docSet.getMapId2Language().size() = "+docSet.getMapId2Language().size());
			System.out.println("docSet.getMapId2Doc().size() = "+docSet.getMapId2Doc().size());
			System.out.println("docSet.getMapId2Chapter().size() = "+docSet.getMapId2Chapter().size());
			System.out.println("docSet.getMapId2Section().size() = "+docSet.getMapId2Section().size());
			System.out.println("docSet.getMapId2Paragraph().size() = "+docSet.getMapId2Paragraph().size());
			System.out.println("docSet.getMapId2Sentence().size() = "+docSet.getMapId2Sentence().size());
			System.out.println("docSet.getMapId2Token().size() = "+docSet.getMapId2Token().size());
			
			System.out.println("docSet.getMapStr2Paragraph().size() = "+docSet.getMapStr2Paragraph().size());
			System.out.println("docSet.getMapStr2Sentence().size() = "+docSet.getMapStr2Sentence().size());
			System.out.println("docSet.getMapStr2Token().size() = "+docSet.getMapStr2Token().size());
			
		} else {
			System.out.println("readDocSetTables: docSet is null");
		}
		return (docSet);
	}
	
}