package tool10.tagset;

import java.time.ZonedDateTime;
import java.util.List;
import org.apache.tika.config.TikaConfig;

import tool10.f10.NodeF10;

/*
import sim10.basictypes.NodeBinary;
import sim10.pdf.PDFGetImageCorpus;
import sim10.pdf.PDFGetImages;
import sim10.sql.JLite;
import sim10.util.FileUtil;
import sim10.util.TikaUtil;
import sim10.util.TraverseFiles;
*/

public class MakeTagSetProcess {

	/*private static void createTagFileEmbedded(Connection conn,NodeTagSet tagSet, NodeTagFile tagFile) 	{
		String longFileName = tagFile.getSourceAbsolutePath();
		NodeEmbedded embedded = null;
		
		String tmpDirectoryName = PDFGetImages.getTmppdfdirectoryname(); // "C:\\tmp\\similarity\\tmppdf";
		String formatName = "PNG"; //JPEG";
		String extensionName = "png";
		ArrayList<String> fileNameList = new ArrayList<String>();
		fileNameList.add(longFileName);
		HashMap<String,HashMap<String,NodeBinary>> corpusMap = PDFGetImageCorpus.getImageFileCorpus(fileNameList, tmpDirectoryName, formatName, extensionName);
		
		HashMap<String,NodeBinary> embeddedMap = corpusMap.get(longFileName); 
		for (String embeddedStr : embeddedMap.keySet())	{
			NodeBinary bin = embeddedMap.get(embeddedStr);
			Long embeddedId  = JLite.getNextId(conn, "TAG_EMBEDDED");
			Long tagFileId = tagFile.getTagFileId();
			Long tagSetId = tagSet.getTagSetId();
			String embeddingType = "pdf/image";
			String tmpFileAbsolutePath = embeddedStr; 
			String tmpFileName = embeddedStr;
			Long embeddedSize = bin.getByteLength();
			Long crc64 = bin.getCrc64();
			//byte[] embeddedBytes = bin.getByteArray();
			byte[] embeddedBytes = new byte[100]; 
			for (int i=0; i<100; i++) {embeddedBytes[i] = bin.getByteArray()[i];}
			Long displayOrder = null; 
			ZonedDateTime creationDate = ZonedDateTime.now();	
			//public NodeEmbedded(Long embeddedId, Long tagFileId, Long tagSetId, String embeddingType,
			//String tmpFileAbsolutePath, String tmpFileName, Long embeddedSize, Long displayOrder,NodeBinary embeddedBinary,
			//byte[] embeddedBytes, Long crc64, ZonedDateTime creationDate)
			embedded = new NodeEmbedded(embeddedId,tagFileId,tagSetId, embeddingType,
							tmpFileAbsolutePath,tmpFileName,embeddedSize,displayOrder,bin,embeddedBytes,crc64,creationDate);
			tagSet.getListEmbedded().add(embedded);
			tagSet.getMapId2Embedded().put(embedded.getEmbeddedId(),embedded);
		}
	}
	public static void createOneTagFileFromFile(Connection conn,NodeTagSet tagSet, String longFileName, String shortFilename)	{
		File file = new File(longFileName);
		if ((file==null) || (!file.exists())) return;
		
		Long tagFileTypeId = createOneTagFileType(conn,tagSet,longFileName);
		
		Long tagFileId = JLite.getNextId(conn, "TAG_TAGFILE");
		Long tagSetId = tagSet.getTagSetId();
    	Long sourceId = null; 
        String sourceAbsolutePath = longFileName;
        String sourceDirName = (file!=null) ? file.getParent() : null; 
        String sourceFileName = (file!=null) ? file.getName() : null;
		//String sourceFileName = shortFilename;
        String sourceExtensionName = (file!=null) ? (TraverseFiles.getFileExtension(file.getAbsolutePath())) : null;
        Long sourceFileSize =null; 
		
    	LocalDateTime localDateTime = FileUtil.getFileCreationDate(sourceAbsolutePath);
		ZonedDateTime sourceFileCreationDate = (localDateTime!=null) ? localDateTime.atZone(ZoneId.of("Europe/Istanbul")) : null;
		ZonedDateTime sourceFileModificationDate = null; 
	    ZonedDateTime creationDate = ZonedDateTime.now();	
	    NodeTagFile tagFile = new NodeTagFile(tagFileId,tagSetId,tagFileTypeId,sourceId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
	    		sourceFileSize,sourceFileCreationDate,sourceFileModificationDate, creationDate);
	    tagSet.getListTagFile().add(tagFile);
	    tagSet.getMapId2TagFile().put(tagFile.getTagFileId(),tagFile);  
	    
	    createTagFileEmbedded(conn,tagSet,tagFile);
	}
	public static void createTagFilesFromSourceDirectory(Connection conn,NodeTagSet tagSet)	{
	
		ArrayList<String> filenameList = new ArrayList<String>(); 
		File folder = new File(tagSet.getSourceURL());
		String[] extArray = new String[] {"png","jpg"};
		
		TraverseFiles.traverseFiles(filenameList, extArray, folder);
		System.out.println("createTagFilesFromSourceDirectory: filenameList.size() = " + filenameList.size()+" in folder "+folder.getAbsolutePath());
		
		for (String filename : filenameList)	{
			String tagFileName = FileUtil.getShortFilename(filename);
			createOneTagFileFromFile(conn,tagSet,filename,tagFileName);
		}
	} */
	private static Long createOneTagFileType(NodeF10 f10, String tikaMimeType, String primaryExtension, 
			String detectedExtensionListString)	{
		
		//public NodeTagFileType(Long tagFileTypeId, Long tagSetId, String tagFileTypeName, String tagFileTypeDesc,
		//		String primaryExtension, String detectedExtensionListString, Long displayOrder, ZonedDateTime creationDate) {
		Long tagFileTypeId = f10.getConnTag().getNextId(-1); //"TAG_TAGFILETYPE");
		
		Long tagSetId = f10.getTagSet().getTagSetId();
        String tagFileTypeName = tikaMimeType;
        String tagFileTypeDesc = tagFileTypeName+"_desc";
        Long displayOrder = (long) f10.getTagSet().getListTagFileType().size()+1;
	    ZonedDateTime creationDate = ZonedDateTime.now();	
	    NodeTagFileType tagFileType = new NodeTagFileType(tagFileTypeId,tagSetId,tagFileTypeName,tagFileTypeDesc,
	    				primaryExtension,detectedExtensionListString, displayOrder, creationDate);
	    f10.getTagSet().getListTagFileType().add(tagFileType);
	    f10.getTagSet().getMapId2TagFileType().put(tagFileType.getTagFileTypeId(),tagFileType);
	    
	    f10.getTagSet().getMapFileType2TagFileType().put(tikaMimeType,tagFileType);
	    return(tagFileTypeId);
	}
	
	private static Long processTagFileType(NodeF10 f10, String longFileName, TikaConfig tikaConfig)	{
		
		String tikaMimeType = TikaUtil.getTikaMimeType(longFileName,tikaConfig); //TikaConfig tika = null
		
		List<String> detectedExtensions = TikaUtil.getExtensionListForMimeType(tikaMimeType);
		if (detectedExtensions==null) return(null);
		
		StringBuilder sb = new StringBuilder();
		for (String ss : detectedExtensions) {sb.append("'"+ss+"',");}
		String detectedExtensionListString = sb.toString();
		String primaryExtension = TikaUtil.getPrimaryExtensionForMimeType(tikaMimeType);

		if (f10.getTagSet().getMapFileType2TagFileType().get(tikaMimeType)==null)	{
			Long tagFileTypeId = createOneTagFileType(f10, tikaMimeType, primaryExtension, detectedExtensionListString);
		    return(tagFileTypeId);
		} else {
			return(f10.getTagSet().getMapFileType2TagFileType().get(tikaMimeType).getTagFileTypeId());
		}
	}
	public static void processTagFiles(NodeF10 f10, TikaConfig tikaConfig)	{
		for (NodeTagFile tagFile : f10.getTagSet().getListTagFile())	{
			
			Long tagFileTypeId = processTagFileType(f10,tagFile.getSourceAbsolutePath(), tikaConfig);
			
			 //createTagFileEmbedded(conn,tagSet,tagFile);
		}
	}	
}
