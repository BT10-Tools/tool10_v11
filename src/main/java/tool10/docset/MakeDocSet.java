package tool10.docset;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import tool10.blobset.NodeBlob;
import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.util.FileUtil;

public class MakeDocSet {

	public static NodeDocBlob createOneDocBlobFromFile(NodeF10 f10, Long docId, NodeFile nodeFile, NodeBlob fileBlob)	{
		Long fileBlobId = (fileBlob!=null) ? fileBlob.getBlobId()  : null;
		byte[] docBytes = null;
		List<String> docLines = null;
		if (fileBlob!=null) {docBytes = fileBlob.getBlobBytes();	}
		else if (nodeFile.getFileNameAbsolute()!=null)	{
			docBytes = FileUtil.getBytes(nodeFile.getFileNameAbsolute());	
			docLines = FileUtil.getLines(nodeFile.getFileNameAbsolute(),Charset.defaultCharset());
			System.out.print("MakeDocSet createOneDocBlobFromFile nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute());
			if (docBytes!=null) {	System.out.print("   ,docBytes.length:"+docBytes.length); }
			if (docLines!=null) {	System.out.print("   ,docLines.size():"+docLines.size()); }
			System.out.println();
		}
		String docType = null;
		String blobType = null;
		Long docSize = (docBytes!=null) ? ((long) docBytes.length) : null;
		Long crc64 = null;
		NodeDocBlob docBlob = MakeDocSetTables.createOneDocBlob(f10, docId, fileBlobId, docType, blobType, docSize, docBytes, docLines, crc64);
		return(docBlob);
	}
	public static NodeDocFile createOneDocFileFromFile(NodeF10 f10,NodeFile nodeFile, Long docId)	{
		Long fileId = nodeFile.getFileId(); 
        String sourceAbsolutePath = nodeFile.getFileNameAbsolute();
        String sourceDirName = (nodeFile.getRefFileName()==null) ? null : nodeFile.getRefFileName().getDirNameAbsolute(); 
        String sourceFileName = (nodeFile.getRefFileName()==null) ? null : nodeFile.getRefFileName().getFileName();
		//String sourceFileName = shortFilename;
        String sourceExtensionName = nodeFile.getExtensionName(); 
        Long sourceFileSize =null; 
        ZonedDateTime sourceFileCreationDate = (nodeFile.getRefFileProp()==null) ? null : nodeFile.getRefFileProp().getFileCreationDate();

        NodeDocFile docFile = MakeDocSetTables.createOneDocFileFromFile(f10, docId, fileId,sourceAbsolutePath, sourceDirName, sourceFileName, 
        		sourceExtensionName, sourceFileSize, sourceFileCreationDate);
        return(docFile);
	}
	public static void createDocFilesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Doc)	{
		long displayOrder=0;
		for (NodeFile nodeFile : fileList4Doc)	{
			NodeDoc doc = MakeDocSetTables.createOneDoc(f10, f10.getDocSet().getDocSetId(), displayOrder);
			NodeDocFile docFile = createOneDocFileFromFile(f10,nodeFile, doc.getDocId());
			NodeBlob fileBlob = null; //get the file blob
			NodeDocBlob docBlob = createOneDocBlobFromFile(f10, doc.getDocId(), nodeFile, fileBlob);

			//process chapter, paragraph, sentence and token from the tanzil BLOB
			MakeDocSetTanzil.processDoc(f10, doc, docBlob);
			
			displayOrder++;
		}
	}
	public static ArrayList<NodeFile> getFileList4DocFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Doc = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			String symLink = (nodeFile.getRefFileProp()==null) ? null : nodeFile.getRefFileProp().getIsSymbolicLink();
			if ("yes".equals(symLink)) continue;
			//other filters can come here like wildcards
			
			//if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			//if (cnt++ > 10) break; //for test purpose, only process 100 files
			
			if (!nodeFile.getFileName().startsWith("tr.")) continue; 
			
			fileList4Doc.add(nodeFile);
		}
		System.out.println("MakeDocSet getFileList4DocFromFileSet 	fileList4Image.size() = "+fileList4Doc.size());
		return(fileList4Doc);
	}

	public static void printAllListsAndMaps(NodeDocSet docSet)	{
		
		System.out.println("printAllListsAndMaps: docSet.getListDocFile().size() = " + docSet.getListDocFile().size());
		System.out.println("printAllListsAndMaps: docSet.getListDocBlob().size() = " + docSet.getListDocBlob().size());
		System.out.println("printAllListsAndMaps: docSet.getListDoc().size() = " + docSet.getListDoc().size());
		System.out.println("printAllListsAndMaps: docSet.getListChapter().size() = " + docSet.getListChapter().size());
		System.out.println("printAllListsAndMaps: docSet.getListParagraph().size() = " + docSet.getListParagraph().size());
		System.out.println("printAllListsAndMaps: docSet.getListSentence().size() = " + docSet.getListSentence().size());
		System.out.println("printAllListsAndMaps: docSet.getListToken().size() = " + docSet.getListToken().size());
		System.out.println("printAllListsAndMaps: docSet.getListLanguage().size() = " + docSet.getListLanguage().size());
		
		System.out.println("printAllListsAndMaps: docSet.getMapId2DocFile().size() = " + docSet.getMapId2DocFile().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2DocBlob().size() = " + docSet.getMapId2DocBlob().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Doc().size() = " + docSet.getMapId2Doc().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Chapter().size() = " + docSet.getMapId2Chapter().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Paragraph().size() = " + docSet.getMapId2Paragraph().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Sentence().size() = " + docSet.getMapId2Sentence().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Token().size() = " + docSet.getMapId2Token().size());
		System.out.println("printAllListsAndMaps: docSet.getMapId2Language().size() = " + docSet.getMapId2Language().size());
		
	}
	public static NodeDocSet makeDocSetFromFileSet(NodeF10 f10)	{
		NodeDocSet docSet = null;
		String docSetName = f10.getCliParams().getDocSetName();
		String sourceDir = null;
		docSet = MakeDocSetTables.createOneDocSet(f10, f10.getFileSet().getFileSetId(),docSetName,sourceDir);
		f10.setDocSet(docSet);
		System.out.println("MakeDocSet makeDocSetFromFileSet docSet = "+docSet);
		
		ArrayList<NodeFile> fileList4Doc = getFileList4DocFromFileSet(f10);
		createDocFilesFromFileList(f10, fileList4Doc);
				
		//ReadDocTablesFromDb.postProcessDocSet(tagSet);
		
		printAllListsAndMaps(docSet);
		
		return(docSet);
	}
	
}
