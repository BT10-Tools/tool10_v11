package tool10.bookset;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeBlob;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;
import tool10.util.FileUtil;

public class MakeBookSet {

	public static NodeBookBlob createOneBookBlobFromFile(NodeF10 f10, Long bookId, NodeFile nodeFile, NodeBlob fileBlob)	{
		Long fileBlobId = (fileBlob!=null) ? fileBlob.getBlobId()  : null;
		byte[] bookBytes = null;
		List<String> bookLines = null;
		if (fileBlob!=null) {bookBytes = fileBlob.getBlobBytes();	}
		else if (nodeFile.getFileNameAbsolute()!=null)	{
			bookBytes = FileUtil.getBytes(nodeFile.getFileNameAbsolute());	
			bookLines = FileUtil.getLines(nodeFile.getFileNameAbsolute(),Charset.defaultCharset());
			System.out.print("MakeBookSet createOneBookBlobFromFile nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute());
			if (bookBytes!=null) {	System.out.print("   ,bookBytes.length:"+bookBytes.length); }
			if (bookLines!=null) {	System.out.print("   ,bookLines.size():"+bookLines.size()); }
			System.out.println();
		}
		String bookType = null;
		String blobType = null;
		Long bookSize = (bookBytes!=null) ? ((long) bookBytes.length) : null;
		Long crc64 = null;
		NodeBookBlob bookBlob = MakeBookSetTables.createOneBookBlob(f10, bookId, fileBlobId, bookType, blobType, bookSize, bookBytes, bookLines, crc64);
		return(bookBlob);
	}
	public static NodeBookFile createOneBookFileFromFile(NodeF10 f10,NodeFile nodeFile, Long bookId)	{
		Long fileId = nodeFile.getFileId(); 
        String sourceAbsolutePath = nodeFile.getFileNameAbsolute();
        String sourceDirName = nodeFile.getDirNameAbsolute(); 
        String sourceFileName = nodeFile.getFileName();
		//String sourceFileName = shortFilename;
        String sourceExtensionName = nodeFile.getExtensionName(); 
        Long sourceFileSize =null; 
        ZonedDateTime sourceFileCreationDate = nodeFile.getFileCreationDate();

        NodeBookFile bookFile = MakeBookSetTables.createOneBookFileFromFile(f10, bookId, fileId,sourceAbsolutePath, sourceDirName, sourceFileName, 
        		sourceExtensionName, sourceFileSize, sourceFileCreationDate);
        return(bookFile);
	}
	public static void createBookFilesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Book)	{
		long displayOrder=0;
		for (NodeFile nodeFile : fileList4Book)	{
			NodeBook book = MakeBookSetTables.createOneBook(f10, f10.getBookSet().getBookSetId(), displayOrder);
			NodeBookFile bookFile = createOneBookFileFromFile(f10,nodeFile, book.getBookId());
			NodeBlob fileBlob = null; //get the file blob
			NodeBookBlob bookBlob = createOneBookBlobFromFile(f10, book.getBookId(), nodeFile, fileBlob);

			//process chapter, paragraph, sentence and token from the tanzil BLOB
			MakeBookSetTanzil.processBook(f10, book, bookBlob);
			
			displayOrder++;
		}
	}
	public static ArrayList<NodeFile> getFileList4BookFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Book = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			//if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			//if (cnt++ > 10) break; //for test purpose, only process 100 files
			
			if (!nodeFile.getFileName().startsWith("tr.")) continue; 
			
			fileList4Book.add(nodeFile);
		}
		System.out.println("MakeBookSet getFileList4BookFromFileSet 	fileList4Image.size() = "+fileList4Book.size());
		return(fileList4Book);
	}

	public static void printAllListsAndMaps(NodeBookSet bookSet)	{
		
		System.out.println("printAllListsAndMaps: bookSet.getListBookFile().size() = " + bookSet.getListBookFile().size());
		System.out.println("printAllListsAndMaps: bookSet.getListBookBlob().size() = " + bookSet.getListBookBlob().size());
		System.out.println("printAllListsAndMaps: bookSet.getListBook().size() = " + bookSet.getListBook().size());
		System.out.println("printAllListsAndMaps: bookSet.getListChapter().size() = " + bookSet.getListChapter().size());
		System.out.println("printAllListsAndMaps: bookSet.getListParagraph().size() = " + bookSet.getListParagraph().size());
		System.out.println("printAllListsAndMaps: bookSet.getListSentence().size() = " + bookSet.getListSentence().size());
		System.out.println("printAllListsAndMaps: bookSet.getListToken().size() = " + bookSet.getListToken().size());
		System.out.println("printAllListsAndMaps: bookSet.getListLanguage().size() = " + bookSet.getListLanguage().size());
		
		System.out.println("printAllListsAndMaps: bookSet.getMapId2BookFile().size() = " + bookSet.getMapId2BookFile().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2BookBlob().size() = " + bookSet.getMapId2BookBlob().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Book().size() = " + bookSet.getMapId2Book().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Chapter().size() = " + bookSet.getMapId2Chapter().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Paragraph().size() = " + bookSet.getMapId2Paragraph().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Sentence().size() = " + bookSet.getMapId2Sentence().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Token().size() = " + bookSet.getMapId2Token().size());
		System.out.println("printAllListsAndMaps: bookSet.getMapId2Language().size() = " + bookSet.getMapId2Language().size());
		
	}
	public static NodeBookSet makeBookSetFromFileSet(NodeF10 f10)	{
		NodeBookSet bookSet = null;
		String bookSetName = f10.getCliParams().getBookSetName();
		String sourceDir = null;
		bookSet = MakeBookSetTables.createOneBookSet(f10, f10.getFileSet().getFileSetId(),bookSetName,sourceDir);
		f10.setBookSet(bookSet);
		System.out.println("MakeBookSet makeBookSetFromFileSet bookSet = "+bookSet);
		
		ArrayList<NodeFile> fileList4Book = getFileList4BookFromFileSet(f10);
		createBookFilesFromFileList(f10, fileList4Book);
				
		//ReadBookTablesFromDb.postProcessBookSet(tagSet);
		
		printAllListsAndMaps(bookSet);
		
		return(bookSet);
	}
	
}
