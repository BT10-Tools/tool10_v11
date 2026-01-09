package tool10.preview.navigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class ShowFormFileSet {

	private static final String nl = "\n";
	
	public static String getShowString(NodeShow show,String outType, NodeFileSet ent)	{
		
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileSetName",ent.getFileSetName())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileSetDesc",ent.getFileSetDesc())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileSetURL",ent.getFileSetURL())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"ownerName",ent.getOwnerName())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"displayOrder",ent.getDisplayOrder())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl); 
				
	/*	fieldLineArray.add(showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		fieldLineArray.add(showList(outType,"NodeFileBlob","listFileBlob",ent.getListFileBlob())+nl); 
		fieldLineArray.add(showList(outType,"NodeBlob","listBlob",ent.getListBlob())+nl);
		fieldLineArray.add(showList(outType,"NodeFileSystem","listFileSystem",ent.getListFileSystem())+nl);
		fieldLineArray.add(showList(outType,"NodeFileStore","listFileStore",ent.getListFileStore())+nl);
		fieldLineArray.add(showList(outType,"NodeHash","listHash",ent.getListHash())+nl);
		fieldLineArray.add(showList(outType,"NodeHost","listHost",ent.getListHost())+nl);
		fieldLineArray.add(showList(outType,"NodeProperty","listProperty",ent.getListProperty())+nl);
		fieldLineArray.add(showList(outType,"NodeQuery","listQuery",ent.getListQuery())+nl);
		fieldLineArray.add(showList(outType,"NodeStat","listStat",ent.getListStat())+nl);
		fieldLineArray.add(showList(outType,"NodeArchive","listArchive",ent.getListArchive())+nl);
		fieldLineArray.add(showList(outType,"NodeContainer","listContainer",ent.getListContainer())+nl);
		fieldLineArray.add(showList(outType,"NodeTransform","listTransform",ent.getListTransform())+nl);

		fieldLineArray.add(showMap(outType,"Long","NodeFile","mapId2File",ent.getMapId2File())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeFileBlob","mapId2FileBlob",ent.getMapId2FileBlob())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeBlob","mapId2Blob",ent.getMapId2Blob())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeFileSystem","mapId2FileSystem",ent.getMapId2FileSystem())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeFileStore","mapId2FileStore",ent.getMapId2FileStore())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeHash","mapId2Hash",ent.getMapId2Hash())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeHost","mapId2Host",ent.getMapId2Host())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeProperty","mapId2Property",ent.getMapId2Property())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeQuery","mapId2Query",ent.getMapId2Query())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeStat","mapId2Stat",ent.getMapId2Stat())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeArchive","mapId2Archive",ent.getMapId2Archive())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeContainer","mapId2Container",ent.getMapId2Container())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeTransform","mapId2Transform",ent.getMapId2Transform())+nl);
		
		fieldLineArray.add(showList(outType,"NodeFile","listRoots",ent.getListRoots())+nl);
		fieldLineArray.add(showMap(outType,"String","NodeFile","mapAbsoluteFileName2File",ent.getMapAbsoluteFileName2File())+nl);
		fieldLineArray.add(showMap(outType,"FileSystem","NodeFileSystem","mapRawFileSystem2FileSystem",ent.getMapRawFileSystem2FileSystem())+nl);
		fieldLineArray.add(showMap(outType,"FileStore","NodeFileStore","mapRawFileStore2FileStore",ent.getMapRawFileStore2FileStore())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeHash","mapCrc2NodeHash",ent.getMapCrc2NodeHash())+nl);
		fieldLineArray.add(showMap(outType,"Long","NodeFileBlob","mapFileId2FileBlob",ent.getMapFileId2FileBlob())+nl);
	*/	
		String anchorStr = "form_fileSet"+ent.getFileSetId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(fileSet["+ent.getFileSetId()+",'"+ent.getFileSetName()+"'])");
		return(ss);
	}	
	
	public static String getShowString(NodeShow show,String outType,NodeFile ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileId",ent.getFileId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"parentFileId",ent.getParentFileId(),show.getMapAnchor().get("form_file"+ent.getParentFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"rootFileId",ent.getRootFileId(),show.getMapAnchor().get("form_file"+ent.getRootFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileTypeId",ent.getFileTypeId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceId",ent.getSourceId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSize",ent.getFileSize())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashCode",ent.getHashCode())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashId",ent.getFileSetId(),show.getMapAnchor().get("form_hash"+ent.getHashId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileType",ent.getFileType())+nl); //file, directory, link
		fieldLineArray.add(ShowFormCommon.showLong(outType,"linkedId",ent.getLinkedId())+nl);

		//public NodeFile(Long fileId, Long fileSetId, Long parentFileId, Long rootFileId, Long fileTypeId, Long sourceId,
		//		Long fileSize, Long hashCode, Long hashId, String fileType, Long linkedId, String fileStatus,
		//		String fileName, String fileNameAbsolute, String extensionName, String isDirectory, String isFile,
		//		String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileStatus",ent.getFileStatus())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileName",ent.getFileName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileNameAbsolute",ent.getFileNameAbsolute())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"extensionName",ent.getExtensionName())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"isDirectory",ent.getIsDirectory())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isFile",ent.getIsFile())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileRemark",ent.getFileRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
	/*	fieldLineArray.add(showList(outType,"NodeFile","listSiblingFile",ent.getListSiblingFile())+nl);
		fieldLineArray.add(showList(outType,"NodeFileBlob","listFileBlobRegular",ent.getListFileBlobRegular())+nl);
		fieldLineArray.add(showList(outType,"NodeFileBlob","listFileBlobBig",ent.getListFileBlobBig())+nl);
		fieldLineArray.add(showList(outType,"NodeFileBlob","listFileBlobSmall",ent.getListFileBlobSmall())+nl);
	*/	
		String anchorStr = "form_file"+ent.getFileId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(file["+ent.getFileId()+",'"+ent.getFileName()+"'])");
		return(ss);			
	}
	public static String getShowString(NodeShow show,String outType,NodeFileName ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileNameId",ent.getFileNameId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileId",ent.getFileId(),show.getMapAnchor().get("form_file"+ent.getFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileNameTypeId",ent.getFileNameTypeId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"nameLanguageId",ent.getNameLanguageId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"nameLanguageId2",ent.getNameLanguageId2())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"nameHashId",ent.getNameHashId())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"depth",ent.getDepth())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"depthFromRoot",ent.getDepthFromRoot())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileName",ent.getFileName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileNameRelative",ent.getFileNameRelative())+nl);  //the name relative to the given input directory name
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileNameAbsolute",ent.getFileNameAbsolute())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileNameCanonical",ent.getFileNameCanonical())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileURI",ent.getFileURI())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileURL",ent.getFileURL())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"extensionName",ent.getExtensionName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"nameWithoutExtension",ent.getNameWithoutExtension())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"dirNameRelative",ent.getDirNameRelative())+nl);  
		fieldLineArray.add(ShowFormCommon.showString(outType,"dirNameAbsolute",ent.getDirNameAbsolute())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileNameLength",ent.getFileNameLength())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileNameAbsoluteLength",ent.getFileNameAbsoluteLength())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressedNameSize",ent.getCompressedNameSize())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileName83",ent.getFileName83())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"altName1",ent.getAltName1())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"altName2",ent.getAltName2())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"altName3",ent.getAltName3())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"altNameFromTag",ent.getAltNameFromTag())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"altNameFromContent",ent.getAltNameFromContent())+nl);
		
		//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
		//Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
		//String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
		//String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
		//Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
		//String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"onlyAsciiLetter",ent.getOnlyAsciiLetter())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"onlyDigit",ent.getOnlyDigit())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"onlyUTFLetter",ent.getOnlyUTFLetter())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sortedLetters",ent.getSortedLetters())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sortedLettersUnique",ent.getSortedLettersUnique())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"encryptedNameRelative",ent.getEncryptedNameRelative())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"encryptedNameAbsolute",ent.getEncryptedNameAbsolute())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isNameValid",ent.getIsNameValid())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"validityRemark",ent.getValidityRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isNameCorrect",ent.getIsNameCorrect())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"correctedName",ent.getCorrectedName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"correctnessRemark",ent.getCorrectnessRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"goodnessLevel",ent.getGoodnessLevel())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"goodnessRemark",ent.getGoodNameSuggested())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"goodNameSuggested",ent.getGoodNameSuggested())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isHumanGiven",ent.getIsHumanGiven())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isGenerated",ent.getIsGenerated())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isHumanUnderstandable",ent.getIsHumanUnderstandable())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"nameEncoding",ent.getNameEncoding())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"nameCharsetStr",ent.getNameCharsetStr())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"nameRemark",ent.getNameRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"strEntityType",ent.getStrEntityType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"strEntityStr",ent.getStrEntityStr())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"strEntityId",ent.getStrEntityId())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"strEntityType2",ent.getStrEntityType2())+nl);
		
		//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
		//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
		//String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
		//String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
		//String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
		//String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"strEntityStr2",ent.getStrEntityStr2())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"strEntityId2",ent.getStrEntityId2())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntLetter",ent.getCntLetter())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntLetterUnique",ent.getCntLetterUnique())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntAsciiLetter",ent.getCntAsciiLetter())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntAsciiLetterUppercase",ent.getCntAsciiLetterUppercase())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntAsciiLetterLowercase",ent.getCntAsciiLetterLowercase())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntAsciiUnprintable",ent.getCntAsciiUnprintable())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntNonAscii",ent.getCntNonAscii())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUTFLetter",ent.getCntUTFLetter())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUTFLetterByte1",ent.getCntUTFLetterByte1())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUTFLetterByte2",ent.getCntUTFLetterByte2())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUTFLetterByte3",ent.getCntUTFLetterByte3())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUTFLetterByte4",ent.getCntUTFLetterByte4())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntEmoji",ent.getCntEmoji())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntDigit",ent.getCntDigit())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntDigitUnique",ent.getCntDigitUnique())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntSpace",ent.getCntSpace())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntUnderscore",ent.getCntUnderscore())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntDash",ent.getCntDash())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"parsedNum",ent.getParsedNum())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"parsedZDT",ent.getParsedZDT())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"tokenizedName",ent.getTokenizedName())+nl);

		//String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
		//Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
		//Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
		//Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
		//Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
					
		//String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//	fieldLineArray.add(showList(outType,"NodeFile","listSiblingFile",ent.getListSiblingFile())+nl);
		
		String anchorStr = "form_fileName"+ent.getFileNameId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(fileName["+ent.getFileNameId()+",'"+ent.getFileName()+"'])");
		return(ss);			
	}
	public static String getShowString(NodeShow show,String outType,NodeFileProp ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"filePropId",ent.getFilePropId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileId",ent.getFileId(),show.getMapAnchor().get("form_file"+ent.getFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSystemId",ent.getFileSystemId(),show.getMapAnchor().get("form_fileSystem"+ent.getFileSystemId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileStoreId",ent.getFileStoreId(),show.getMapAnchor().get("form_fileStore"+ent.getFileStoreId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"propertyType",ent.getFileType())+nl); //file, directory, link
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"signatureId",ent.getSignatureId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSize",ent.getFileSize())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSizeOnDisk",ent.getFileSizeOnDisk())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashCode",ent.getHashCode())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileType",ent.getFileType())+nl); //file, directory, link
		fieldLineArray.add(ShowFormCommon.showString(outType,"linkType",ent.getLinkType())+nl); //softlink, hardlink
		fieldLineArray.add(ShowFormCommon.showLong(outType,"linkedId",ent.getLinkedId())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"ownerName",ent.getOwnerName())+nl);	
		fieldLineArray.add(ShowFormCommon.showString(outType,"computerName",ent.getComputerName())+nl);	
		//public NodeFileProp(Long filePropId, Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId,
		//String propertyType, Long signatureId, Long fileSize, Long fileSizeOnDisk, String fileSizeClass,
		//Long hashCode, String fileType, String linkType, Long linkedId, String ownerName, String computerName,
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"canExecute",ent.getCanExecute())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"canRead",ent.getCanRead())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"canWrite",ent.getCanWrite())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isExists",ent.getIsExists())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isDirectory",ent.getIsDirectory())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isFile",ent.getIsFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isSymbolicLink",ent.getIsSymbolicLink())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isHidden",ent.getIsHidden())+nl);	  
		fieldLineArray.add(ShowFormCommon.showString(outType,"isArchive",ent.getIsArchive())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"isSystem",ent.getIsSystem())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);	    
		fieldLineArray.add(ShowFormCommon.showString(outType,"isOther",ent.getIsOther())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isRegularFile",ent.getIsRegularFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"probeContentType",ent.getProbeContentType())+nl);	
		fieldLineArray.add(ShowFormCommon.showString(outType,"isCompressed",ent.getIsCompressed())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isEncrypted",ent.getIsEncrypted())+nl);
		//String canExecute, String canRead, String canWrite, String isExists, String isDirectory, String isFile,
		//String isSymbolicLink, String isHidden, String isArchive, String isSystem, String isReadOnly,
		//String isOther, String isRegularFile, String probeContentType, String isCompressed, String isEncrypted,
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"isIndexed",ent.getIsIndexed())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isContentIndexed",ent.getIsContentIndexed())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isBlocked",ent.getIsBlocked())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isSystemFile",ent.getIsSystemFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isAppFile",ent.getIsAppFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isCompanyFile",ent.getIsCompanyFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isUserFile",ent.getIsUserFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isExecutable",ent.getIsExecutable())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isTextFile",ent.getIsTextFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isXMLFile",ent.getIsXMLFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isConfigFile",ent.getIsConfigFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isBinaryFile",ent.getIsBinaryFile())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isImmutable",ent.getIsImmutable())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isInUserPath",ent.getIsInUserPath())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isInSystemPath",ent.getIsInSystemPath())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isShareable",ent.getIsShareable())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isShared",ent.getIsShared())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hasPreviousVersions",ent.getHasPreviousVersions())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"uxPermission",ent.getUxPermission())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"uxInfo",ent.getUxInfo())+nl);
		//String isIndexed, String isContentIndexed, String isBlocked, String isSystemFile, String isAppFile,
		//String isCompanyFile, String isUserFile, String isExecutable, String isTextFile, String isXMLFile,
		//String isConfigFile, String isBinaryFile, String isImmutable, String isInUserPath, String isInSystemPath,
		//String isShareable, String isShared, String hasPreviousVersions, String uxPermission, String uxInfo,
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressedFileSize",ent.getCompressedFileSize())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"compressionGainRatio",ent.getCompressionGainRatio())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressionGainBytes",ent.getCompressionGainBytes())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"duration",ent.getDuration())+nl);   
		fieldLineArray.add(ShowFormCommon.showLong(outType,"contentLanguage",ent.getContentLanguageId())+nl);  	    
		fieldLineArray.add(ShowFormCommon.showLong(outType,"contentLanguageId2",ent.getContentLanguageId2())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"contentEncoding",ent.getContentEncoding())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"contentCharsetStr",ent.getContentCharsetStr())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"iconName",ent.getIconName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"origin",ent.getOrigin())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"copyrightInfo",ent.getCopyrightInfo())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"licenseInfo",ent.getLicenseInfo())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"assetInfo",ent.getAssetInfo())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"dlpInfo",ent.getDlpInfo())+nl);
		//Long compressedFileSize, Double compressionGainRatio, Long compressionGainBytes, Long duration,
		//Long contentLanguageId, Long contentLanguageId2, String contentEncoding, String contentCharsetStr,
		//String iconName, String origin, String copyrightInfo, String licenseInfo, String assetInfo, String dlpInfo,
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"lastModified",ent.getLastModified())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"fileCreationDate",ent.getFileCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"fileModificationDate",ent.getFileModificationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"fileLastAccessTime",ent.getFileLastAccessTime())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fileRemark",ent.getFileRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		//Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
		//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
				
		String anchorStr = "form_fileProp"+ent.getFilePropId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(fileProp["+ent.getFilePropId()+",'"+ent.getFilePropId()+"'])");
		return(ss);			
	}

	public static String getShowString(NodeShow show,String outType,NodeFileBlob ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileBlobId",ent.getFileBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileId",ent.getFileId(),show.getMapAnchor().get("form_file"+ent.getFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobId",ent.getBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobType",ent.getBlobType())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSize",ent.getBlobSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSize",ent.getFileSize())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashId",ent.getFileSetId(),show.getMapAnchor().get("form_hash"+ent.getHashId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobDbName",ent.getBlobDbName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobDbAttachmentName",ent.getBlobDbAttachmentName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobTableName",ent.getBlobTableName())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"bigPartNumber",ent.getBigPartNumber())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"bigCntPart",ent.getBigCntPart())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"smallByteIndexStart",ent.getSmallByteIndexStart())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"smallByteIndexEnd",ent.getSmallByteIndexEnd())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		String anchorStr = "form_fileBlob"+ent.getFileBlobId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(fileBlob["+ent.getFileBlobId()+"])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeFileStore ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileStoreId",ent.getFileStoreId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSystemId",ent.getFileSystemId(),show.getMapAnchor().get("form_fileSystem"+ent.getFileSystemId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"rootFileId",ent.getRootFileId(),show.getMapAnchor().get("form_file"+ent.getRootFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"displayOrder",ent.getDisplayOrder())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blockSize",ent.getBlockSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"totalSpace",ent.getTotalSpace())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"unallocatedSpace",ent.getUnallocatedSpace())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"usableSpace",ent.getUsableSpace())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"usedSpace",ent.getUsedSpace())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashCode",ent.getHashCode())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"rootDirectoryName",ent.getRootDirectoryName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"nameStr",ent.getNameStr())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"toString",ent.getToString())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"typeStr",ent.getTypeStr())+nl);
	    
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_fileStore"+ent.getFileStoreId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(fileStore["+ent.getFileStoreId()+",'"+ent.getNameStr()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeFileSystem ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSystemId",ent.getFileSystemId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hostId",ent.getHostId(),show.getMapAnchor().get("form_host"+ent.getHostId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"rootFileId",ent.getRootFileId(),show.getMapAnchor().get("form_file"+ent.getRootFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"displayOrder",ent.getDisplayOrder())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"systemName",ent.getSystemName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"providerName",ent.getProviderName())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"providerHashCode",ent.getProviderHashCode())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isDefault",ent.getIsDefault())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isOpen",ent.getIsOpen())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
	
		//private FileSystem realFileSystem;
	    
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeFileStore","listFileStore",ent.getListFileStore())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_fileSystem"+ent.getFileSystemId(); 
		String ss =ShowFormCommon.tableize(fieldLineArray,anchorStr,"(fileSystem["+ent.getFileSystemId()+",'"+ent.getSystemName()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeHash ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashId",ent.getHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSize",ent.getFileSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"crc64",ent.getCrc64())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"crc32",ent.getCrc32())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"adler32",ent.getAdler32())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"blake3",ent.getBlake3())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"md5",ent.getMd5())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha1",ent.getSha1())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha256",ent.getSha256())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha384",ent.getSha384())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha512",ent.getSha512())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha3256",ent.getSha3256())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"keccak256",ent.getKeccak256())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashFieldDesc",ent.getHashFieldDesc())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr01",ent.getHashStr01())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr02",ent.getHashStr02())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr03",ent.getHashStr03())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr04",ent.getHashStr04())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr05",ent.getHashStr05())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong01",ent.getHashLong01())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong02",ent.getHashLong02())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong03",ent.getHashLong03())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong04",ent.getHashLong04())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong05",ent.getHashLong05())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_hash"+ent.getHashId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(hash["+ent.getHashId()+"])");
		return(ss);
	}
	public static String getShowString(NodeShow show,String outType,NodeHost ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hostId",ent.getHostId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hostName",ent.getHostName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hostIP",ent.getHostIP())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"domainName",ent.getDomainName())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_host"+ent.getHostId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(host["+ent.getHostId()+",'"+ent.getHostName()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeArchive ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"archiveId",ent.getArchiveId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"archiveFileId",ent.getArchiveFileId(),show.getMapAnchor().get("form_file"+ent.getArchiveFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"archiveFileSetId",ent.getArchiveFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getArchiveFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"archiveType",ent.getArchiveType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"extensionType",ent.getExtensionType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"multipleFileArchive",ent.getMultipleFileArchive())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"archiveRemark",ent.getArchiveRemark())+nl);
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntFile",ent.getCntFile())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntArchive",ent.getCntArchive())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntDirectory",ent.getCntDirectory())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntFileTree",ent.getCntFileTree())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntDirectoryTree",ent.getCntDirectoryTree())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"unzippedFileSize",ent.getUnzippedFileSize())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"unzipGainRatio",ent.getUnzipGainRatio())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"unzippedGainBytes",ent.getUnzippedGainBytes())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"archiveCreationDate",ent.getArchiveCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"archiveModificationDate",ent.getArchiveModificationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_arhive"+ent.getArchiveId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(archive["+ent.getArchiveId()+"])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeContainer ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"containerId",ent.getContainerId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"containerFileId",ent.getContainerFileId(),show.getMapAnchor().get("form_file"+ent.getContainerFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"containerFileSetId",ent.getContainerFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getContainerFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"containerType",ent.getContainerType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"extensionType",ent.getExtensionType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"containerRemark",ent.getContainerRemark())+nl);
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntFile",ent.getCntFile())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//fieldLineArray.add(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_container"+ent.getContainerId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(container["+ent.getContainerId()+"])");
		return(ss);
	}
	public static String getShowString(NodeShow show,String outType,NodeTransform ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"transformId",ent.getTransformId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"fileSetId",ent.getFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"transformFileId",ent.getTransformFileId(),show.getMapAnchor().get("form_file"+ent.getTransformFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"transformFileSetId",ent.getTransformFileSetId(),show.getMapAnchor().get("form_fileSet"+ent.getTransformFileSetId()))+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"transformedFileId",ent.getTransformedFileId(),show.getMapAnchor().get("form_file"+ent.getTransformedFileId()))+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"transformType",ent.getTransformType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"extensionType",ent.getExtensionType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"transformRemark",ent.getTransformRemark())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"tmpFileName",ent.getTmpFileName())+nl);
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntFile",ent.getCntFile())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"transformedFileSize",ent.getTransformedFileSize())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//sb.append(ShowFormCommon.showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		String anchorStr = "form_transform"+ent.getTransformId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr, "(transform["+ent.getTransformId()+"])");
		return(ss);
	}	
	public static String getAllClassesFileSet(NodeFileSet fileSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileSet","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFile","NodeFile"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileName","NodeFileName"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileProp","NodeFileProp"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileBlob","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeBlob","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileStore","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeFileSystem","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeHash","NodeFileSet"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.nodes.NodeHost","NodeFileSet"));
		
		sb.append(ShowFormCommon.showClass("tool10.fileset.transform.NodeArchive","NodeArchive"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.transform.NodeContainer","NodeContainer"));
		sb.append(ShowFormCommon.showClass("tool10.fileset.transform.NodeTransform","NodeTransform"));
		
		return(sb.toString());
	}
	public static String getAllPackagesFileSet(NodeFileSet fileSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showPackage("tool10.fileset.nodes","nodes"));
		sb.append(ShowFormCommon.showPackage("tool10.fileset.transform","transform"));
		
		return(sb.toString());
	}
	public static void createAllAnchorsFormFileSet(NodeShow show, NodeFileSet fileSet,HashSet<String> nodeSet)	{
		
		ArrayList<String> listAnchor = new ArrayList<>(); 
		if (nodeSet.contains("fileSet")) 	{String ss = "form_fileSet"+fileSet.getFileSetId(); listAnchor.add(ss); }
		if (nodeSet.contains("file")) 		{
			for (NodeFile ent : fileSet.getListFile())	{	String ss = "form_file"+ent.getFileId(); listAnchor.add(ss); }}
		if (nodeSet.contains("fileName")) 		{
			for (NodeFileName ent : fileSet.getListFileName())	{	String ss = "form_fileName"+ent.getFileNameId(); listAnchor.add(ss); }}
		if (nodeSet.contains("fileProp")) 		{
			for (NodeFileProp ent : fileSet.getListFileProp())	{	String ss = "form_fileProp"+ent.getFilePropId(); listAnchor.add(ss); }}
		
		if (nodeSet.contains("fileBlob")) 		{
			for (NodeFileBlob ent : fileSet.getListFileBlob())	{	String ss = "form_fileBlob"+ent.getFileBlobId(); listAnchor.add(ss); }}
		if (nodeSet.contains("fileStore")) 		{
			for (NodeFileStore ent : fileSet.getListFileStore())	{	String ss = "form_fileStore"+ent.getFileStoreId(); listAnchor.add(ss); }}
		if (nodeSet.contains("fileSystem")) 		{
			for (NodeFileSystem ent : fileSet.getListFileSystem())	{	String ss = "form_fileSystem"+ent.getFileSystemId(); listAnchor.add(ss); }}
		if (nodeSet.contains("hash")) 		{
			for (NodeHash ent : fileSet.getListHash())	{	String ss = "form_hash"+ent.getHashId(); listAnchor.add(ss); }}
		if (nodeSet.contains("host")) 		{
			for (NodeHost ent : fileSet.getListHost())	{	String ss = "form_host"+ent.getHostId(); listAnchor.add(ss); }}
		
		if (nodeSet.contains("archive")) 		{
			for (NodeArchive ent : fileSet.getListArchive())			{	String ss = "form_archive"+ent.getArchiveId(); listAnchor.add(ss); }}
		if (nodeSet.contains("container")) 		{
			for (NodeContainer ent : fileSet.getListContainer())		{	String ss = "form_container"+ent.getContainerId(); listAnchor.add(ss); }}
		if (nodeSet.contains("transform")) 		{
			for (NodeTransform ent : fileSet.getListTransform())		{	String ss = "form_transform"+ent.getTransformId(); listAnchor.add(ss); }}
		
		for (String anchStr : listAnchor) {show.getMapAnchor().put(anchStr, anchStr); }
		System.out.println("ShowForm createAllAnchorsFormFileSet show.getMapAnchor().size():"+show.getMapAnchor().size());
		//NodeFileGroup,NodeFileGrouping,NodeFileGroupMember,NodeLog, NodeProperty, NodeQuery, NodeStat will come in future 
	}
	public static HashMap<String,String> getAllShowString4FileSet(NodeShow show, NodeFileSet fileSet,String outType,
			HashSet<String> nodeSet, String showFileNamePrefix)	{
		
		String fileName = showFileNamePrefix + "01" + ".html"; 
		createAllAnchorsFormFileSet(show, fileSet, nodeSet);
		
		HashMap<String,String> mapString = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html><br>\n<body><br>\n<form action=''>"+nl);
		if (nodeSet.contains("fileSet")) 	{sb.append(getShowString(show,outType,fileSet));}
		if (nodeSet.contains("file")) 		{for (NodeFile nodeFile : fileSet.getListFile())	{	sb.append(getShowString(show,outType,nodeFile)); }}
		if (nodeSet.contains("fileName")) 	{for (NodeFileName nodeFileName : fileSet.getListFileName())	{	sb.append(getShowString(show,outType,nodeFileName)); }}
		if (nodeSet.contains("fileProp")) 	{for (NodeFileProp nodeFileProp : fileSet.getListFileProp())	{	sb.append(getShowString(show,outType,nodeFileProp)); }}
		
		if (nodeSet.contains("fileBlob")) 		{for (NodeFileBlob fileBlob : fileSet.getListFileBlob())			{	sb.append(getShowString(show,outType,fileBlob)); }}
		if (nodeSet.contains("fileStore")) 		{for (NodeFileStore fileStore : fileSet.getListFileStore())		{	sb.append(getShowString(show,outType,fileStore)); }}
		if (nodeSet.contains("fileSystem")) 		{for (NodeFileSystem fileSystem : fileSet.getListFileSystem())	{	sb.append(getShowString(show,outType,fileSystem)); }}
		if (nodeSet.contains("hash")) 		{for (NodeHash hash : fileSet.getListHash())						{	sb.append(getShowString(show,outType,hash)); }}
		if (nodeSet.contains("host")) 		{for (NodeHost host : fileSet.getListHost())						{	sb.append(getShowString(show,outType,host)); }}
		
		if (nodeSet.contains("archive")) 		{for (NodeArchive archive : fileSet.getListArchive())			{	sb.append(getShowString(show,outType,archive)); }}
		if (nodeSet.contains("container")) 		{for (NodeContainer container : fileSet.getListContainer())		{	sb.append(getShowString(show,outType,container)); }}
		if (nodeSet.contains("transform")) 		{for (NodeTransform transform : fileSet.getListTransform())		{	sb.append(getShowString(show,outType,transform)); }}
				
		//NodeFileGroup,NodeFileGrouping,NodeFileGroupMember,NodeLog, NodeProperty, NodeQuery, NodeStat will come in future
		sb.append("</form></body></html>"+nl);
		
		mapString.put(fileName, sb.toString());
		return(mapString);
	}	
	
}
