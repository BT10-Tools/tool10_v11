package tool10.fileset;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.TraverseFiles;

public class MakeFileSetFileName {

/*
	private static NodeFileType createFileType(Conn10 conn10,NodeFileSet corpus, String fileTypeName, String fileTypeDesc, String groupName)	{		
		Long modelTypeId = conn10.getNextId(-1); //"BSC_BASIC");
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeModelType(Long modelTypeId, Long aiId, String modelTypeName, String modelTypeDesc, String groupName,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeModelType modelType = new NodeModelType(modelTypeId,ai.getAiId(), modelTypeName, modelTypeDesc, groupName, creationDate, null);
		ai.getListModelType().add(modelType);
		ai.getMapId2ModelType().put(modelType.getModelTypeId(),modelType);
		return(modelType);
		
		return(null);
	}
*/
	private static String getRelativeFileName(NodeFileSet fileSet, File file, Long rootFileId)	{
		if ((rootFileId!=null) && (fileSet.getMapId2File().get(rootFileId)!=null))	{
			NodeFile rootNodeFile = fileSet.getMapId2File().get(rootFileId);
			Path rootPath = Paths.get(rootNodeFile.getFileNameAbsolute()); 
			return(rootPath.relativize(file.toPath()).toString());
		}
		return(null);
		//Path path1 = Paths.get("/home/user/documents");
	    //Path path2 = Paths.get("/home/user/music/song.mp3");  
		// Path relativePath = path1.relativize(path2); //../music/song.mp3
	}
	private static String getDirNameRelative(NodeFileSet fileSet, File file, Long rootFileId)	{
		//String dirNameAbsolute = getDirNameAbsolute(fileSet, file, rootFileId);
		if ((rootFileId!=null) && (fileSet.getMapId2File().get(rootFileId)!=null))	{
			NodeFile rootNodeFile = fileSet.getMapId2File().get(rootFileId);
			Path rootPath = Paths.get(rootNodeFile.getFileNameAbsolute()); 
			if (rootPath==null) return(null);
			return(rootPath.relativize(file.getParentFile().toPath()).toString());
		}
		return(null);
	}
	private static String getDirNameAbsolute(NodeFileSet fileSet, File file, Long rootFileId)	{
		String dirNameAbsolute = (file.getParentFile()!=null) ? file.getParentFile().getAbsolutePath() : null;
		return(dirNameAbsolute);
	}
	private static String getEncryptedNameRelative()	{
		return(null);
	}
	private static String getEncryptedNameAbsolute()	{
		return(null);
	}
	private static void updateOneFileFieldsName1(NodeF10 f10, NodeFileName newFileName, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
			Long nameLanguageId = null;
			Long nameLanguageId2 = null;
			    
			String fileNameRelative = getRelativeFileName(f10.getFileSet(),file,rootFileId);
			String fileNameCanonical = file.getCanonicalPath().toString();
			String fileURI = file.toURI().toString();;
			String fileURL = null;
			String extensionName = TraverseFiles.getFileExtension(newFile.getFileName());
			String nameWithoutExtension = TraverseFiles.getFilenameWithoutExtension(newFile.getFileName());
			String dirNameRelative = getDirNameRelative(f10.getFileSet(), file, rootFileId); 
			String dirNameAbsolute = getDirNameAbsolute(f10.getFileSet(), file, rootFileId); 
			Long fileNameLength = (long) newFile.getFileName().length();
			Long fileNameAbsoluteLength = (long) newFile.getFileNameAbsolute().length();
			 
			String fileName83 = null;
			String altName1 = null;
			String altName2 = null;
			String altName3 = null;
			String altNameFromTag = null; 
			String altNameFromContent = null;
			String compressedName = null;  //the compressed string for name.
			String encryptedNameRelative = getEncryptedNameRelative(); 
			String encryptedNameAbsolute = getEncryptedNameAbsolute(); 
			Long compressedNameSize = null;
						
			newFileName.updateFields(nameLanguageId,nameLanguageId2,fileNameRelative,fileNameCanonical,fileURI,fileURL,
					extensionName,nameWithoutExtension,dirNameRelative,dirNameAbsolute,
					fileNameLength,fileNameAbsoluteLength,compressedNameSize,fileName83,
					altName1,altName2,altName3,altNameFromTag,altNameFromContent,
					compressedName, encryptedNameRelative, encryptedNameAbsolute);	
		} catch(Exception e)	{
			
		}
	}
	private static void updateOneFileFieldsName2(NodeF10 f10, NodeFileName newFileName, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
			Long nameHashId = null; 
			String onlyAsciiLetter = null; 
			String onlyDigit = null; 
			String onlyUTFLetter = null; 
			String sortedLetters = null;
			String sortedLettersUnique = null; 
			String isNameValid = null;
			String validityRemark = null; 
			String isNameCorrect = null; 
			String correctedName = null; 
			String correctnessRemark = null;
			String goodnessLevel = null; 
			String goodnessRemark = null; 
			String goodNameSuggested = null; 
			String isHumanGiven = null;
			String isGenerated = null; 
			String isHumanUnderstandable = null; 
			String nameEncoding = null; 
			String nameCharsetStr = null;
			String nameRemark = null; 
			String strEntityType = null; 
			String strEntityStr = null; 
			Long strEntityId = null; 
			String strEntityType2 = null;
			String strEntityStr2 = null; 
			Long strEntityId2 = null; 
			Long cntLetter = null; 
			Long cntLetterUnique = null; 
			Long cntAsciiLetter = null;
			
			Long cntAsciiLetterUppercase = null; 
			Long cntAsciiLetterLowercase = null; 
			Long cntAsciiUnprintable = null; 
			Long cntNonAscii = null;
			Long cntUTFLetter = null; 
			Long cntUTFLetterByte1 = null; 
			Long cntUTFLetterByte2 = null; 
			Long cntUTFLetterByte3 = null;
			Long cntUTFLetterByte4 = null; 
			Long cntEmoji = null; 
			Long cntDigit = null; 
			Long cntDigitUnique = null; 
			Long cntSpace = null;
			Long cntUnderscore = null; 
			Long cntDash = null; 
			Long parsedNum = null; 
			ZonedDateTime parsedZDT = null; 
			String tokenizedName = null;
			String[] arrayToken = null; 
			String[] arrayLetter = null; 
			Long[] arrayLetterCnt = null; 
			Long[] arrayTokenId = null;
			
			newFileName.updateFields2(nameHashId,onlyAsciiLetter,onlyDigit,onlyUTFLetter,sortedLetters,
				sortedLettersUnique, isNameValid,
				validityRemark, isNameCorrect, correctedName, correctnessRemark,
				goodnessLevel, goodnessRemark, goodNameSuggested, isHumanGiven,
				isGenerated, isHumanUnderstandable, nameEncoding, nameCharsetStr,
				nameRemark, strEntityType, strEntityStr, strEntityId, strEntityType2,
				strEntityStr2, strEntityId2, cntLetter, cntLetterUnique, cntAsciiLetter,
				
				cntAsciiLetterUppercase, cntAsciiLetterLowercase, cntAsciiUnprintable, cntNonAscii,
				cntUTFLetter, cntUTFLetterByte1, cntUTFLetterByte2, cntUTFLetterByte3,
				cntUTFLetterByte4, cntEmoji, cntDigit, cntDigitUnique, cntSpace,
				cntUnderscore, cntDash, parsedNum, parsedZDT, tokenizedName,
				arrayToken,  arrayLetter, arrayLetterCnt, arrayTokenId);
			
		} catch(Exception e)	{
			
		}
	}
	//public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
	//Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
	//String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
	//String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
	//Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
	//String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
	
	//String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
	//String sortedLettersUnique, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
	//String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
	//String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
	//String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
	//String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
	//String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
	
	//Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
	//Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
	//Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
	//Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
	//String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
	//ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
	
	public static NodeFileName createOneFileName(NodeF10 f10, NodeFileSet fileSet, NodeFile nodeFile, File file, Long parentFileId, Long rootFileId, 
			Long depth, Long depthFromRoot)	{
		NodeFileName newFileName = null;
		if ((file==null) || (!file.exists())) {return(null);}
		
		try {
			Long fileSetId = fileSet.getFileSetId();
			String fileName = file.getName();
			String fileNameAbsolute = file.getAbsolutePath();
			if (parentFileId == null) {
				NodeFile parentFile = f10.getFileSet().getMapAbsoluteFileName2File().get(file.getParent());
				if (parentFile!=null)	{ parentFileId = parentFile.getFileId();}
			}			
			//public NodeFileName(Long fileNameId,Long fileId, Long fileSetId, Long fileNameTypeId, Long depth, Long depthFromRoot, 
			//		String fileName, String fileNameAbsolute,ZonedDateTime creationDate) {
			newFileName = new NodeFileName(null, nodeFile.getFileId(), fileSetId, null, depth, depthFromRoot,
					fileName, fileNameAbsolute, ZonedDateTime.now());
			
			updateOneFileFieldsName1(f10, newFileName, nodeFile, file, parentFileId, rootFileId);
			updateOneFileFieldsName2(f10, newFileName, nodeFile, file, parentFileId, rootFileId);
			String checkNewFileNameResult = FileFilter.checkNewFileName(f10, file, nodeFile, newFileName);
			
			if (!"ok".equals(checkNewFileNameResult)) {
				String fileStatus = "filtered";
				String fileRemark = "namefilecheck="+checkNewFileNameResult;
				//create another new file, discard all the fields calculated ??
				return(null);
			}
			Long fileNameId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			newFileName.setFileNameId(fileNameId);
			newFileName.setRefFile(nodeFile);
			nodeFile.setRefFileName(newFileName);
			fileSet.getListFileName().add(newFileName);
			fileSet.getMapId2FileName().put(newFileName.getFileId(),newFileName);			
		} catch(Exception e)	{
			
		}
		return(newFileName);
	}
}
