package tool10.docset;

import java.time.ZonedDateTime;
import java.util.List;

import tool10.f10.NodeF10;
import tool10.sql.Conn10;

public class MakeDocSetTables {

	public static NodeToken createOneToken(NodeF10 f10, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength)	{
		Long tokenId = f10.getConnDoc().getNextId(-1); //"BOOK_TOKEN"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
		//Long cntInDocSet, Double frequencyDocSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeToken token = new NodeToken(tokenId,dictId,wordId,tokenStr, tokenDesc, tokenLength, null, null, creationDate, null);  		
  		f10.getDocSet().getListToken().add(token);
	    f10.getDocSet().getMapId2Token().put(token.getTokenId(),token);
	    f10.getDocSet().getMapStr2Token().put(tokenStr,token); //mapStr2Token
	    return(token);
	}	
	public static NodeSentence createOneSentence(NodeF10 f10, Long paragraphId, Long docId, Long displayOrder, 
			String sentenceName, String sentenceType, String sentenceDesc, String sentenceStr)	{
		Long sentenceId = f10.getConnDoc().getNextId(-1); //"BOOK_SENTENCE"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeSentence(Long sentenceId, Long paragraphId, Long docId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
		//String sentenceDesc,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeSentence sentence = new NodeSentence(sentenceId,paragraphId, docId, null, null, sentenceName, sentenceType, sentenceDesc, sentenceStr, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getDocSet().getListSentence().add(sentence);
	    f10.getDocSet().getMapId2Sentence().put(sentence.getSentenceId(),sentence);
	    return(sentence);
	}	
	public static NodeParagraph createOneParagraph(NodeF10 f10, Long sectionId, Long docId, Long displayOrder, 
			String paragraphName, String paragraphType, String paragraphDesc)	{
		Long paragraphId = f10.getConnDoc().getNextId(-1); //"BOOK_PARAGRAPH"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeParagraph(Long paragraphId, Long chapterId, Long docId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
		//String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeParagraph paragraph = new NodeParagraph(paragraphId,sectionId, docId, null, null, paragraphName, paragraphType, paragraphDesc, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getDocSet().getListParagraph().add(paragraph);
	    f10.getDocSet().getMapId2Paragraph().put(paragraph.getParagraphId(),paragraph);
	    return(paragraph);
	}
	public static NodeSection createOneSection(NodeF10 f10, Long chapterId, Long docId, Long displayOrder, 
			String sectionName, String sectionType, String sectionDesc)	{
		Long sectionId = f10.getConnDoc().getNextId(-1); //"BOOK_SECTION"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
        //public NodeSection(Long sectionId, Long chapterId, Long docId, Long languageId, Long sameSectionId, String sectionName,
		//String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
		//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
        NodeSection section = new NodeSection(sectionId,chapterId, docId, null, null, sectionName, sectionType, sectionDesc, null, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getDocSet().getListSection().add(section);
	    f10.getDocSet().getMapId2Section().put(section.getSectionId(),section);
	    return(section);
	}
	public static NodeChapter createOneChapter(NodeF10 f10, Long docId, Long displayOrder, 
			String chapterName, String chapterType, String chapterDesc)	{
		Long chapterId = f10.getConnDoc().getNextId(-1); //"BOOK_CHAPTER"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeChapter(Long chapterId, Long docId, Long languageId, String chapterName, String chapterType,
		//String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
		//Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
        NodeChapter chapter = new NodeChapter(chapterId, docId, null, chapterName, chapterType, chapterDesc, null, null, 
        		displayOrder, null, null, null, creationDate, null);  		
  		f10.getDocSet().getListChapter().add(chapter);
	    f10.getDocSet().getMapId2Chapter().put(chapter.getChapterId(),chapter);
	    return(chapter);
	}	
	public static NodeDoc createOneDoc(NodeF10 f10, Long docSetId, Long displayOrder)	{
		Long docId = f10.getConnDoc().getNextId(-1); //"BOOK_BOOK"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		//public NodeDoc(Long docId, Long docSetId, Long displayOrder, ZonedDateTime creationDate) {
  		NodeDoc doc = new NodeDoc(docId, docSetId, displayOrder, creationDate);  		
  		f10.getDocSet().getListDoc().add(doc);
	    f10.getDocSet().getMapId2Doc().put(doc.getDocId(),doc);
	    return(doc);
	}	
	public static NodeDocBlob createOneDocBlob(NodeF10 f10, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
			byte[] docBytes, List<String> docLines, Long crc64)	{
		Long docBlobId = f10.getConnDoc().getNextId(-1); //"IMG_IMAGEFILE"
		
        ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeDocBlob(Long docBlobId, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
		//byte[] docBytes, String[] docLines, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
  		NodeDocBlob docBlob = new NodeDocBlob(docBlobId, docId, fileBlobId, docType, blobType, docSize,
  				docBytes,docLines,crc64,creationDate,modificationDate);  		
  		f10.getDocSet().getListDocBlob().add(docBlob);
	    f10.getDocSet().getMapId2DocBlob().put(docBlob.getDocBlobId(),docBlob);
	    return(docBlob);
	}
	public static NodeDocFile createOneDocFileFromFile(NodeF10 f10, Long docId, Long fileId, String sourceAbsolutePath, String sourceDirName, String sourceFileName, 
	        String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate)	{
		Long docFileId = f10.getConnDoc().getNextId(-1); //"BOOK_BOOKFILE"
        
        ZonedDateTime creationDate = ZonedDateTime.now();	
		ZonedDateTime modificationDate = null;
	    //public NodeDocFile(Long docFileId, Long docId, Long fileId, Long docSetId, String sourceAbsolutePath,
		//String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
		//ZonedDateTime sourceFileCreationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
  		NodeDocFile docFile = new NodeDocFile(docFileId, docId, fileId, f10.getDocSet().getDocSetId(), sourceAbsolutePath, 
  				sourceDirName,sourceFileName,sourceExtensionName,sourceFileSize,sourceFileCreationDate, creationDate,modificationDate);  		
  		f10.getDocSet().getListDocFile().add(docFile);
	    f10.getDocSet().getMapId2DocFile().put(docFile.getDocFileId(),docFile);
	    return(docFile);
	}
	public static NodeDocSet createOneDocSet(NodeF10 f10,Long fileSetId,String docSetName,String sourceDir)	{
		NodeDocSet docSet = null;
		Long docSetId = f10.getConnDoc().getNextId(-1); //"IMG_IMAGESET");
		
		String docSetDesc = docSetName+"_DESC"; 
		String sourceDesc = null;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeDocSet(Long docSetId, Long fileSetId, String docSetName, String docSetDesc, String sourceDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		docSet = new NodeDocSet(docSetId,fileSetId,docSetName,docSetDesc, sourceDesc,creationDate,modificationDate);
		return(docSet);
	}
	
}
