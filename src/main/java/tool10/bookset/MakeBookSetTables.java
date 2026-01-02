package tool10.bookset;

import java.time.ZonedDateTime;
import java.util.List;

import tool10.f10.NodeF10;
import tool10.sql.Conn10;

public class MakeBookSetTables {

	public static NodeToken createOneToken(NodeF10 f10, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength)	{
		Long tokenId = f10.getConnBook().getNextId(-1); //"BOOK_TOKEN"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInBookSet, Double frequencyBookSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeToken token = new NodeToken(tokenId,dictId,wordId,tokenStr, tokenDesc, tokenLength, null, null, creationDate, null);  		
  		f10.getBookSet().getListToken().add(token);
	    f10.getBookSet().getMapId2Token().put(token.getTokenId(),token);
	    f10.getBookSet().getMapStr2Token().put(tokenStr,token); //mapStr2Token
	    return(token);
	}	
	public static NodeSentence createOneSentence(NodeF10 f10, Long paragraphId, Long bookId, Long displayOrder, 
			String sentenceName, String sentenceType, String sentenceDesc, String sentenceStr)	{
		Long sentenceId = f10.getConnBook().getNextId(-1); //"BOOK_SENTENCE"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeSentence(Long sentenceId, Long paragraphId, Long bookId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDesc,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeSentence sentence = new NodeSentence(sentenceId,paragraphId, bookId, null, null, sentenceName, sentenceType, sentenceDesc, sentenceStr, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getBookSet().getListSentence().add(sentence);
	    f10.getBookSet().getMapId2Sentence().put(sentence.getSentenceId(),sentence);
	    return(sentence);
	}	
	public static NodeParagraph createOneParagraph(NodeF10 f10, Long sectionId, Long bookId, Long displayOrder, 
			String paragraphName, String paragraphType, String paragraphDesc)	{
		Long paragraphId = f10.getConnBook().getNextId(-1); //"BOOK_PARAGRAPH"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeParagraph(Long paragraphId, Long chapterId, Long bookId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeParagraph paragraph = new NodeParagraph(paragraphId,sectionId, bookId, null, null, paragraphName, paragraphType, paragraphDesc, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getBookSet().getListParagraph().add(paragraph);
	    f10.getBookSet().getMapId2Paragraph().put(paragraph.getParagraphId(),paragraph);
	    return(paragraph);
	}
	public static NodeSection createOneSection(NodeF10 f10, Long chapterId, Long bookId, Long displayOrder, 
			String sectionName, String sectionType, String sectionDesc)	{
		Long sectionId = f10.getConnBook().getNextId(-1); //"BOOK_SECTION"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
        //public NodeSection(Long sectionId, Long chapterId, Long bookId, Long languageId, Long sameSectionId, String sectionName,
		//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
        NodeSection section = new NodeSection(sectionId,chapterId, bookId, null, null, sectionName, sectionType, sectionDesc, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getBookSet().getListSection().add(section);
	    f10.getBookSet().getMapId2Section().put(section.getSectionId(),section);
	    return(section);
	}
	public static NodeChapter createOneChapter(NodeF10 f10, Long bookId, Long displayOrder, 
			String chapterName, String chapterType, String chapterDesc)	{
		Long chapterId = f10.getConnBook().getNextId(-1); //"BOOK_CHAPTER"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeChapter(Long chapterId, Long bookId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeChapter chapter = new NodeChapter(chapterId, bookId, null, chapterName, chapterType, chapterDesc, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getBookSet().getListChapter().add(chapter);
	    f10.getBookSet().getMapId2Chapter().put(chapter.getChapterId(),chapter);
	    return(chapter);
	}	
	public static NodeBook createOneBook(NodeF10 f10, Long bookSetId, Long displayOrder)	{
		Long bookId = f10.getConnBook().getNextId(-1); //"BOOK_BOOK"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeBook(Long bookId, Long bookSetId, Long displayOrder, ZonedDateTime creationDate) {
  		NodeBook book = new NodeBook(bookId, bookSetId, displayOrder, creationDate);  		
  		f10.getBookSet().getListBook().add(book);
	    f10.getBookSet().getMapId2Book().put(book.getBookId(),book);
	    return(book);
	}	
	public static NodeBookBlob createOneBookBlob(NodeF10 f10, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
			byte[] bookBytes, List<String> bookLines, Long crc64)	{
		Long bookBlobId = f10.getConnBook().getNextId(-1); //"IMG_IMAGEFILE"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeBookBlob(Long bookBlobId, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
		//byte[] bookBytes, String[] bookLines, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
  		NodeBookBlob bookBlob = new NodeBookBlob(bookBlobId, bookId, fileBlobId, bookType, blobType, bookSize,
  				bookBytes,bookLines,crc64,creationDate,modificationDate);  		
  		f10.getBookSet().getListBookBlob().add(bookBlob);
	    f10.getBookSet().getMapId2BookBlob().put(bookBlob.getBookBlobId(),bookBlob);
	    return(bookBlob);
	}
	public static NodeBookFile createOneBookFileFromFile(NodeF10 f10, Long bookId, Long fileId, String sourceAbsolutePath, String sourceDirName, String sourceFileName, 
	        String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate)	{
		Long bookFileId = f10.getConnBook().getNextId(-1); //"BOOK_BOOKFILE"
        
        ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeBookFile(Long bookFileId, Long bookId, Long fileId, Long bookSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
  		NodeBookFile bookFile = new NodeBookFile(bookFileId, bookId, fileId, f10.getBookSet().getBookSetId(), sourceAbsolutePath, 
  				sourceDirName,sourceFileName,sourceExtensionName,sourceFileSize,sourceFileCreationDate, creationDate,modificationDate);  		
  		f10.getBookSet().getListBookFile().add(bookFile);
	    f10.getBookSet().getMapId2BookFile().put(bookFile.getBookFileId(),bookFile);
	    return(bookFile);
	}
	public static NodeBookSet createOneBookSet(NodeF10 f10,Long fileSetId,String bookSetName,String sourceDir)	{
		NodeBookSet bookSet = null;
		Long bookSetId = f10.getConnBook().getNextId(-1); //"IMG_IMAGESET");
		
		String bookSetDesc = bookSetName+"_DESC"; 
		String sourceDesc = null;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeBookSet(Long bookSetId, Long fileSetId, String bookSetName, String bookSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		bookSet = new NodeBookSet(bookSetId,fileSetId,bookSetName,bookSetDesc, sourceDesc,creationDate,modificationDate);
		return(bookSet);
	}
	
}
