package tool10.blobset;

import java.sql.Connection;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import tool10.f10.NodeF10;
import tool10.fileset.WriteFsTablesToDb;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;
import tool10.sql.Conn10;

public class MakeBlobSetTables {

	/*
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
	*/
	public static NodeHash createOneHash(NodeF10 f10,Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
			String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256)	{
		NodeHash newHash = null;
		//public NodeHash(Long hashId, Long fileSetId, Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long hashId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
		/*	Long fileSize = null; 
			Long crc64 = null;
			Long crc32 = null;
			Long adler32 = null;
			String blake3 = null;
			String md5 = null;
			String sha1 = null; 
			String sha256 = null;
			String sha384 = null; 
			String sha512 = null; 
			String sha3256 = null;
			String keccak256 = null;  */
			String hashFieldDesc = null;
			String hashStr01 = null; String hashStr02 = null; String hashStr03 = null; String hashStr04 = null; String hashStr05 = null; 
			Long hashLong01 = null; Long hashLong02 = null; Long hashLong03 = null;	Long hashLong04 = null; Long hashLong05 = null; 
			ZonedDateTime creationDate = ZonedDateTime.now();;
			ZonedDateTime modificationDate = null;
			
			newHash = new NodeHash(hashId,f10.getFileSet().getFileSetId(),fileSize,crc64,crc32,adler32,blake3,md5,
					sha1,sha256,sha384,sha512,sha3256,keccak256,
					hashFieldDesc,hashStr01,hashStr02,hashStr03,hashStr04,hashStr05,
					hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,
					creationDate, modificationDate);
			f10.getFileSet().getListHash().add(newHash);
			f10.getFileSet().getMapId2Hash().put(newHash.getHashId(),newHash);
			f10.getFileSet().getMapCrc2NodeHash().put(crc32, newHash);
		} catch (Exception e)	{
			
		}
		return(newHash);
	}
	public static NodeBlobHash createOneBlobHash(NodeF10 f10, Long blobId, Long blobEntityId, Long fileSize, 
			Long crc64, Long crc32, Long adler32, String blake3, String md5,
			String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256)	{
		NodeBlobHash newBlobHash = null;
		//public NodeBlobHash(Long blobHashId, Long blobId, Long blobEntityId, Long blobSetId, Long blobSize, Long crc64, 
		//Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long blobHashId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			Long blobSize  = fileSize;
		/*	Long fileSize = null; 
			Long crc64 = null;
			Long crc32 = null;
			Long adler32 = null;
			String blake3 = null;
			String md5 = null;
			String sha1 = null; 
			String sha256 = null;
			String sha384 = null; 
			String sha512 = null; 
			String sha3256 = null;
			String keccak256 = null;  */
			String hashFieldDesc = null;
			String hashStr01 = null; String hashStr02 = null; String hashStr03 = null; String hashStr04 = null; String hashStr05 = null; 
			Long hashLong01 = null; Long hashLong02 = null; Long hashLong03 = null;	Long hashLong04 = null; Long hashLong05 = null; 
			ZonedDateTime creationDate = ZonedDateTime.now();;
			ZonedDateTime modificationDate = null;
			
			newBlobHash = new NodeBlobHash(blobHashId,blobId,blobEntityId,f10.getBlobSet().getBlobSetId(),blobSize,crc64,crc32,adler32,blake3,md5,
					sha1,sha256,sha384,sha512,sha3256,keccak256,
					hashFieldDesc,hashStr01,hashStr02,hashStr03,hashStr04,hashStr05,
					hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,
					creationDate, modificationDate);
			f10.getBlobSet().getListBlobHash().add(newBlobHash);
			f10.getBlobSet().getMapId2BlobHash().put(newBlobHash.getBlobHashId(),newBlobHash);
			f10.getBlobSet().getMapCrc2NodeBlobHash().put(crc32, newBlobHash);
			return(newBlobHash);
		} catch (Exception e)	{
			return(null);
		}
	}
	public static NodeBlob createOneBlob(NodeF10 f10, Long blobEntityId, Long fileSize, String blobType, Long cntPart,Long partNumber,
			byte[] blobBytes, Long hashId)	{
		//public NodeBlob(Long blobId, Long sourceId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//		Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//		Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//		Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//		Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//public NodeBlob(Long blobId, Long blobEntityId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//		Long blobSize, Long fileSize, byte[] blobBytes, Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
		Long blobId = f10.getConnBlob().getNextId(-1); //"BSC_BASIC");
		Long blobSize = (blobBytes == null) ? null : (long) blobBytes.length;
		Long firstPartBlobId = null;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null; 
		
		NodeBlob blob = new NodeBlob(blobId, blobEntityId, f10.getFileSet().getFileSetId(), firstPartBlobId, partNumber, cntPart, blobType,
						blobSize,fileSize,blobBytes,hashId,creationDate,modificationDate);
		f10.getBlobSet().getListBlob().add(blob);
		f10.getBlobSet().getMapId2Blob().put(blob.getBlobId(),blob);
		return(blob);

	}	
	public static NodeFileBlob createOneFileBlob(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)	{
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, String blobType,
		//		Long blobSize, Long fileSize, byte[] fileBytes, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
		try {
			Long fileBlobId = f10.getConn10().getNextId(-1); //"BSC_BASIC");;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeFileBlob fileBlob = new NodeFileBlob(fileBlobId, fileId, f10.getFileSet().getFileSetId(), blobType,
							blobSize,fileSize,null,hashId,creationDate,modificationDate);
			f10.getFileSet().getListFileBlob().add(fileBlob);
			f10.getFileSet().getMapId2FileBlob().put(fileBlob.getFileBlobId(),fileBlob);
			
			return(fileBlob);
		} catch (Exception e)	{
			
		}
		return(null);
	}
	public static NodeBlobEntity createOneBlobEntity(NodeF10 f10, Long blobId, Long fileId, Long fileSize, Long blobSize, 
			String blobType, Long hashId, String entityName)	{
		//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
		//Long sourceSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType,
		//		Long blobSize, Long sourceSize, Long hashId, String entityName,	ZonedDateTime creationDate, ZonedDateTime modificationDate) {
			
		try {
			Long blobEntityId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			Long entityId = fileId;
			Long sourceSize = fileSize;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null; 
			
			NodeBlobEntity blobEntity = new NodeBlobEntity(blobEntityId, entityId, blobId, f10.getBlobSet().getBlobSetId(), blobType,
							blobSize,sourceSize,hashId,entityName,creationDate,modificationDate);
			f10.getBlobSet().getListBlobEntity().add(blobEntity);
			f10.getBlobSet().getMapId2BlobEntity().put(blobEntity.getBlobEntityId(),blobEntity);	
			return(blobEntity);
		} catch (Exception e)	{
			
		}
		return(null);
	}
	public static NodeBlobSet createOneBlobSet(NodeF10 f10,Long fileSetId,String blobSetName,String sourceDir)	{
		NodeBlobSet blobSet = null;
		Long blobSetId = f10.getConnBlob().getNextId(-1); //"BLOB_BLOBSET");
		
		String blobSetDesc = blobSetName+"_DESC";
		String blobSetURL = null;
		String ownerName = null;
		Long displayOrder = 1l;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		blobSet = new NodeBlobSet(blobSetId,fileSetId,blobSetName,blobSetDesc,blobSetURL,ownerName,displayOrder,creationDate,modificationDate);
		return(blobSet);
	}
	public static int writeFileBlobList2Db(Connection conn, ArrayList<NodeFileBlob> tmpListFileBlob)	{ 
		if ((tmpListFileBlob==null) || (tmpListFileBlob.isEmpty()))	return(0); 	
		int cntWritten = WriteFsTablesToDb.writeTableFileBlob(conn,tmpListFileBlob);
		return(cntWritten);
	}	
	public static int writeFileBlob2Db(Connection conn, NodeFileBlob fileBlob)	{ 
		if (fileBlob==null)	return(0); 	
		ArrayList<NodeFileBlob> tmpListFileBlob = new ArrayList<>();
		tmpListFileBlob.add(fileBlob);
		int cntWritten = WriteFsTablesToDb.writeTableFileBlob(conn,tmpListFileBlob);
		return(cntWritten);
	}	
	public static int writeBlobEntity2Db(Connection conn, NodeBlobEntity blobEntity)	{ 
		if (blobEntity==null)	return(0); 	
		ArrayList<NodeBlobEntity> tmpListBlobEntity = new ArrayList<>();
		tmpListBlobEntity.add(blobEntity);
		int cntWritten = WriteBlobTablesToDb.writeTableBlobEntity(conn,tmpListBlobEntity);
		return(cntWritten);
	}
	public static int writeBlob2Db(Connection conn, NodeBlob nodeBlob)	{ 
		if (nodeBlob==null)	return(0); 	
		ArrayList<NodeBlob> tmpListBlob = new ArrayList<>();
		tmpListBlob.add(nodeBlob);
		//String blobTableName = ""; 
		//String blobDbAttachmentName = "";
		//int cntWritten = WriteBlobTablesToDb.writeTableBlob(conn,blobTableName,blobDbAttachmentName,tmpListBlob);
		int cntWritten = WriteBlobTablesToDb.writeTableBlob(conn,tmpListBlob);
		nodeBlob.setCompressedBytes(null);
		nodeBlob.setBlobBytes(null);
		nodeBlob.setEncryptedBytes(null);
		return(cntWritten);
	}	
}
