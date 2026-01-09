package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Comparator;

public class NodeFileName implements Serializable {

	public NodeFileName(Long fileNameId, Long fileId, Long fileSetId, Long fileNameTypeId, Long nameLanguageId,
			Long nameLanguageId2, Long nameHashId, Long depth, Long depthFromRoot, String fileName,
			String fileNameRelative, String fileNameAbsolute, String fileNameCanonical, String fileURI, String fileURL,
			String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
			Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
			String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
			String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
			String sortedLettersUnique, String compressedName, String encryptedNameRelative, String encryptedNameAbsolute, String isNameValid,
			String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
			String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
			String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
			String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
			String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
			Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
			Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
			Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
			Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
			String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileNameId = fileNameId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.fileNameTypeId = fileNameTypeId;
		this.nameLanguageId = nameLanguageId;
		this.nameLanguageId2 = nameLanguageId2;
		this.nameHashId = nameHashId;
		this.depth = depth;
		this.depthFromRoot = depthFromRoot;
		this.fileName = fileName;
		this.fileNameRelative = fileNameRelative;
		this.fileNameAbsolute = fileNameAbsolute;
		this.fileNameCanonical = fileNameCanonical;
		this.fileURI = fileURI;
		this.fileURL = fileURL;
		this.extensionName = extensionName;
		this.nameWithoutExtension = nameWithoutExtension;
		this.dirNameRelative = dirNameRelative;
		this.dirNameAbsolute = dirNameAbsolute;
		this.fileNameLength = fileNameLength;
		this.fileNameAbsoluteLength = fileNameAbsoluteLength;
		this.compressedNameSize = compressedNameSize;
		this.fileName83 = fileName83;
		this.altName1 = altName1;
		this.altName2 = altName2;
		this.altName3 = altName3;
		this.altNameFromTag = altNameFromTag;
		this.altNameFromContent = altNameFromContent;
		this.onlyAsciiLetter = onlyAsciiLetter;
		this.onlyDigit = onlyDigit;
		this.onlyUTFLetter = onlyUTFLetter;
		this.sortedLetters = sortedLetters;
		this.sortedLettersUnique = sortedLettersUnique;
		this.compressedName = compressedName;
		this.encryptedNameRelative = encryptedNameRelative;
		this.encryptedNameAbsolute = encryptedNameAbsolute;
		this.isNameValid = isNameValid;
		this.validityRemark = validityRemark;
		this.isNameCorrect = isNameCorrect;
		this.correctedName = correctedName;
		this.correctnessRemark = correctnessRemark;
		this.goodnessLevel = goodnessLevel;
		this.goodnessRemark = goodnessRemark;
		this.goodNameSuggested = goodNameSuggested;
		this.isHumanGiven = isHumanGiven;
		this.isGenerated = isGenerated;
		this.isHumanUnderstandable = isHumanUnderstandable;
		this.nameEncoding = nameEncoding;
		this.nameCharsetStr = nameCharsetStr;
		this.nameRemark = nameRemark;
		this.strEntityType = strEntityType;
		this.strEntityStr = strEntityStr;
		this.strEntityId = strEntityId;
		this.strEntityType2 = strEntityType2;
		this.strEntityStr2 = strEntityStr2;
		this.strEntityId2 = strEntityId2;
		this.cntLetter = cntLetter;
		this.cntLetterUnique = cntLetterUnique;
		this.cntAsciiLetter = cntAsciiLetter;
		this.cntAsciiLetterUppercase = cntAsciiLetterUppercase;
		this.cntAsciiLetterLowercase = cntAsciiLetterLowercase;
		this.cntAsciiUnprintable = cntAsciiUnprintable;
		this.cntNonAscii = cntNonAscii;
		this.cntUTFLetter = cntUTFLetter;
		this.cntUTFLetterByte1 = cntUTFLetterByte1;
		this.cntUTFLetterByte2 = cntUTFLetterByte2;
		this.cntUTFLetterByte3 = cntUTFLetterByte3;
		this.cntUTFLetterByte4 = cntUTFLetterByte4;
		this.cntEmoji = cntEmoji;
		this.cntDigit = cntDigit;
		this.cntDigitUnique = cntDigitUnique;
		this.cntSpace = cntSpace;
		this.cntUnderscore = cntUnderscore;
		this.cntDash = cntDash;
		this.parsedNum = parsedNum;
		this.parsedZDT = parsedZDT;
		this.tokenizedName = tokenizedName;
		this.arrayToken = arrayToken;
		this.arrayLetter = arrayLetter;
		this.arrayLetterCnt = arrayLetterCnt;
		this.arrayTokenId = arrayTokenId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	public void updateFields(Long nameLanguageId, Long nameLanguageId2,
			String fileNameRelative, String fileNameCanonical, String fileURI, String fileURL,
			String extensionName, String nameWithoutExtension, String dirNameRelative, String dirNameAbsolute,
			Long fileNameLength, Long fileNameAbsoluteLength, Long compressedNameSize, String fileName83,
			String altName1, String altName2, String altName3, String altNameFromTag, String altNameFromContent,
			String compressedName, String encryptedNameRelative, String encryptedNameAbsolute)	{
		this.nameLanguageId = nameLanguageId;
		this.nameLanguageId2 = nameLanguageId2;
		this.fileNameRelative = fileNameRelative;
		this.fileNameCanonical = fileNameCanonical;
		this.fileURI = fileURI;
		this.fileURL = fileURL;
		this.extensionName = extensionName;
		this.nameWithoutExtension = nameWithoutExtension;
		this.dirNameRelative = dirNameRelative;
		this.dirNameAbsolute = dirNameAbsolute;
		this.fileNameLength = fileNameLength;
		this.fileNameAbsoluteLength = fileNameAbsoluteLength;
		this.compressedNameSize = compressedNameSize;
		this.fileName83 = fileName83;
		this.altName1 = altName1;
		this.altName2 = altName2;
		this.altName3 = altName3;
		this.altNameFromTag = altNameFromTag;
		this.altNameFromContent = altNameFromContent;
		this.compressedName = compressedName;
		this.encryptedNameRelative = encryptedNameRelative;
		this.encryptedNameAbsolute = encryptedNameAbsolute;
		
	}
	public void updateFields2(Long nameHashId,String onlyAsciiLetter, String onlyDigit, String onlyUTFLetter, String sortedLetters,
			String sortedLettersUnique, String isNameValid,
			String validityRemark, String isNameCorrect, String correctedName, String correctnessRemark,
			String goodnessLevel, String goodnessRemark, String goodNameSuggested, String isHumanGiven,
			String isGenerated, String isHumanUnderstandable, String nameEncoding, String nameCharsetStr,
			String nameRemark, String strEntityType, String strEntityStr, Long strEntityId, String strEntityType2,
			String strEntityStr2, Long strEntityId2, Long cntLetter, Long cntLetterUnique, Long cntAsciiLetter,
			
			Long cntAsciiLetterUppercase, Long cntAsciiLetterLowercase, Long cntAsciiUnprintable, Long cntNonAscii,
			Long cntUTFLetter, Long cntUTFLetterByte1, Long cntUTFLetterByte2, Long cntUTFLetterByte3,
			Long cntUTFLetterByte4, Long cntEmoji, Long cntDigit, Long cntDigitUnique, Long cntSpace,
			Long cntUnderscore, Long cntDash, Long parsedNum, ZonedDateTime parsedZDT, String tokenizedName,
			String[] arrayToken, String[] arrayLetter, Long[] arrayLetterCnt, Long[] arrayTokenId)	{
		
		this.nameHashId = nameHashId;
		this.onlyAsciiLetter = onlyAsciiLetter;
		this.onlyDigit = onlyDigit;
		this.onlyUTFLetter = onlyUTFLetter;
		this.sortedLetters = sortedLetters;
		this.sortedLettersUnique = sortedLettersUnique;
		this.isNameValid = isNameValid;
		this.validityRemark = validityRemark;
		this.isNameCorrect = isNameCorrect;
		this.correctedName = correctedName;
		this.correctnessRemark = correctnessRemark;
		this.goodnessLevel = goodnessLevel;
		this.goodnessRemark = goodnessRemark;
		this.goodNameSuggested = goodNameSuggested;
		this.isHumanGiven = isHumanGiven;
		this.isGenerated = isGenerated;
		this.isHumanUnderstandable = isHumanUnderstandable;
		this.nameEncoding = nameEncoding;
		this.nameCharsetStr = nameCharsetStr;
		this.nameRemark = nameRemark;
		this.strEntityType = strEntityType;
		this.strEntityStr = strEntityStr;
		this.strEntityId = strEntityId;
		this.strEntityType2 = strEntityType2;
		this.strEntityStr2 = strEntityStr2;
		this.strEntityId2 = strEntityId2;
		this.cntLetter = cntLetter;
		this.cntLetterUnique = cntLetterUnique;
		this.cntAsciiLetter = cntAsciiLetter;
		this.cntAsciiLetterUppercase = cntAsciiLetterUppercase;
		this.cntAsciiLetterLowercase = cntAsciiLetterLowercase;
		this.cntAsciiUnprintable = cntAsciiUnprintable;
		this.cntNonAscii = cntNonAscii;
		this.cntUTFLetter = cntUTFLetter;
		this.cntUTFLetterByte1 = cntUTFLetterByte1;
		this.cntUTFLetterByte2 = cntUTFLetterByte2;
		this.cntUTFLetterByte3 = cntUTFLetterByte3;
		this.cntUTFLetterByte4 = cntUTFLetterByte4;
		this.cntEmoji = cntEmoji;
		this.cntDigit = cntDigit;
		this.cntDigitUnique = cntDigitUnique;
		this.cntSpace = cntSpace;
		this.cntUnderscore = cntUnderscore;
		this.cntDash = cntDash;
		this.parsedNum = parsedNum;
		this.parsedZDT = parsedZDT;
		this.tokenizedName = tokenizedName;
		this.arrayToken = arrayToken;
		this.arrayLetter = arrayLetter;
		this.arrayLetterCnt = arrayLetterCnt;
		this.arrayTokenId = arrayTokenId;
	}		
	
	public NodeFileName(Long fileNameId,Long fileId, Long fileSetId, Long fileNameTypeId, Long depth, Long depthFromRoot, 
			String fileName, String fileNameAbsolute,ZonedDateTime creationDate) {
		super();
		this.fileNameId = fileNameId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.fileNameTypeId = fileNameTypeId;
		this.depth = depth;
		this.depthFromRoot = depthFromRoot;
		this.fileName = fileName;
		this.fileNameAbsolute = fileNameAbsolute;
		this.creationDate = creationDate;
	}	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Long fileNameId;
	private Long fileId;
	private Long fileSetId;
	private Long fileNameTypeId;
	private Long nameLanguageId;
	private Long nameLanguageId2;
	private Long nameHashId;
	private Long depth;
	private Long depthFromRoot;
	    
	private String fileName;
	private String fileNameRelative;  //the name relative to the given input directory name
	private String fileNameAbsolute;
	private String fileNameCanonical;
	private String fileURI;
	private String fileURL;
	private String extensionName;
	private String nameWithoutExtension;
	private String dirNameRelative;  
	private String dirNameAbsolute;
	private Long fileNameLength;
	private Long fileNameAbsoluteLength;
	private Long compressedNameSize;
    
	private String fileName83;
	private String altName1;
	private String altName2;
	private String altName3;
	private String altNameFromTag;
	private String altNameFromContent;
	private String onlyAsciiLetter;
	private String onlyDigit;
	private String onlyUTFLetter;
	private String sortedLetters;
	private String sortedLettersUnique;
	private String compressedName;  //the compressed string for name
	private String encryptedNameRelative;  //the encrypted string for name relative. sand,compress, encrypt
	private String encryptedNameAbsolute;  //the encrypted string for name relative
	private String isNameValid; //yes, no
	private String validityRemark;
	private String isNameCorrect; //yes, no
	private String correctedName;
	private String correctnessRemark;
	private String goodnessLevel; //yes, no
	private String goodnessRemark;
	private String goodNameSuggested; 
	private String isHumanGiven; //yes, no
	private String isGenerated; //yes, no
	private String isHumanUnderstandable; //yes, no
	
	private String nameEncoding;
	private String nameCharsetStr; //Charset.forName("ISO-8859-1");
	private String nameRemark;

	//Entity types DateTime,Location,Person,Company,Event,Book,Paper,Media,URL,Device,;
	private String strEntityType;
	private String strEntityStr;
	private Long strEntityId;
	private String strEntityType2;
	private String strEntityStr2;
	private Long strEntityId2;
	
	private Long cntLetter;
	private Long cntLetterUnique;
	private Long cntAsciiLetter;
	private Long cntAsciiLetterUppercase;
	private Long cntAsciiLetterLowercase;
	private Long cntAsciiUnprintable;
	private Long cntNonAscii;
	private Long cntUTFLetter;
	private Long cntUTFLetterByte1;
	private Long cntUTFLetterByte2;
	private Long cntUTFLetterByte3;
	private Long cntUTFLetterByte4;
	private Long cntEmoji;
	private Long cntDigit;
	private Long cntDigitUnique;
	private Long cntSpace;
	private Long cntUnderscore;
	private Long cntDash;
	
	private Long parsedNum;
	private ZonedDateTime parsedZDT;

	private String tokenizedName;
	private String[] arrayToken;
	private String[] arrayLetter;
	private Long[] arrayLetterCnt;
	private Long[] arrayTokenId;
	  
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeFile refFile;
	
	// Sort NodeFile's by fileName
	class SortByFileName implements Comparator<NodeFileName> {
		@Override
		public int compare(NodeFileName a, NodeFileName b) {
		    if      ((a.fileName==null) || (b.fileName==null)) return(0);
		    else if ((a.fileName!=null) || (b.fileName==null)) return(1);
		    else if ((a.fileName==null) || (b.fileName!=null)) return(-1);
		    else {
		    	int result = (a.fileName.compareTo(b.fileName));
		    	if ((result==-1) || (result==1)) return(result);
		    	if (result==0)	{
		    		if 		(a.fileId.longValue()>b.fileId.longValue()) return(-1);
		    		else if (a.fileId.longValue()>b.fileId.longValue()) return(1);
		    		else return(0);
		    	}	
		    }
		    return(0);
		}
	}
	//GETTERS AND SETTERS

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileNameId() {
		return fileNameId;
	}
	public Long getFileId() {
		return fileId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getFileNameTypeId() {
		return fileNameTypeId;
	}
	public Long getNameLanguageId() {
		return nameLanguageId;
	}
	public Long getNameLanguageId2() {
		return nameLanguageId2;
	}
	public Long getNameHashId() {
		return nameHashId;
	}
	public Long getDepth() {
		return depth;
	}
	public Long getDepthFromRoot() {
		return depthFromRoot;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileNameRelative() {
		return fileNameRelative;
	}
	public String getFileNameAbsolute() {
		return fileNameAbsolute;
	}
	public String getFileNameCanonical() {
		return fileNameCanonical;
	}
	public String getFileURI() {
		return fileURI;
	}
	public String getFileURL() {
		return fileURL;
	}
	public String getExtensionName() {
		return extensionName;
	}
	public String getNameWithoutExtension() {
		return nameWithoutExtension;
	}
	public String getDirNameRelative() {
		return dirNameRelative;
	}
	public String getDirNameAbsolute() {
		return dirNameAbsolute;
	}
	public Long getFileNameLength() {
		return fileNameLength;
	}
	public Long getFileNameAbsoluteLength() {
		return fileNameAbsoluteLength;
	}
	public Long getCompressedNameSize() {
		return compressedNameSize;
	}
	public String getFileName83() {
		return fileName83;
	}
	public String getAltName1() {
		return altName1;
	}
	public String getAltName2() {
		return altName2;
	}
	public String getAltName3() {
		return altName3;
	}
	public String getAltNameFromTag() {
		return altNameFromTag;
	}
	public String getAltNameFromContent() {
		return altNameFromContent;
	}
	public String getOnlyAsciiLetter() {
		return onlyAsciiLetter;
	}
	public String getOnlyDigit() {
		return onlyDigit;
	}
	public String getOnlyUTFLetter() {
		return onlyUTFLetter;
	}
	public String getSortedLetters() {
		return sortedLetters;
	}
	public String getSortedLettersUnique() {
		return sortedLettersUnique;
	}
	public String getEncryptedNameRelative() {
		return encryptedNameRelative;
	}
	public String getEncryptedNameAbsolute() {
		return encryptedNameAbsolute;
	}
	public String getIsNameValid() {
		return isNameValid;
	}
	public String getValidityRemark() {
		return validityRemark;
	}
	public String getIsNameCorrect() {
		return isNameCorrect;
	}
	public String getCorrectedName() {
		return correctedName;
	}
	public String getCorrectnessRemark() {
		return correctnessRemark;
	}
	public String getGoodnessLevel() {
		return goodnessLevel;
	}
	public String getGoodnessRemark() {
		return goodnessRemark;
	}
	public String getGoodNameSuggested() {
		return goodNameSuggested;
	}
	public String getIsHumanGiven() {
		return isHumanGiven;
	}
	public String getIsGenerated() {
		return isGenerated;
	}
	public String getIsHumanUnderstandable() {
		return isHumanUnderstandable;
	}
	public String getNameEncoding() {
		return nameEncoding;
	}
	public String getNameCharsetStr() {
		return nameCharsetStr;
	}
	public String getNameRemark() {
		return nameRemark;
	}
	public String getStrEntityType() {
		return strEntityType;
	}
	public String getStrEntityStr() {
		return strEntityStr;
	}
	public Long getStrEntityId() {
		return strEntityId;
	}
	public String getStrEntityType2() {
		return strEntityType2;
	}
	public String getStrEntityStr2() {
		return strEntityStr2;
	}
	public Long getStrEntityId2() {
		return strEntityId2;
	}
	public Long getCntLetter() {
		return cntLetter;
	}
	public Long getCntLetterUnique() {
		return cntLetterUnique;
	}
	public Long getCntAsciiLetter() {
		return cntAsciiLetter;
	}
	public Long getCntAsciiLetterUppercase() {
		return cntAsciiLetterUppercase;
	}
	public Long getCntAsciiLetterLowercase() {
		return cntAsciiLetterLowercase;
	}
	public Long getCntAsciiUnprintable() {
		return cntAsciiUnprintable;
	}
	public Long getCntNonAscii() {
		return cntNonAscii;
	}
	public Long getCntUTFLetter() {
		return cntUTFLetter;
	}
	public Long getCntUTFLetterByte1() {
		return cntUTFLetterByte1;
	}
	public Long getCntUTFLetterByte2() {
		return cntUTFLetterByte2;
	}
	public Long getCntUTFLetterByte3() {
		return cntUTFLetterByte3;
	}
	public Long getCntUTFLetterByte4() {
		return cntUTFLetterByte4;
	}
	public Long getCntEmoji() {
		return cntEmoji;
	}
	public Long getCntDigit() {
		return cntDigit;
	}
	public Long getCntDigitUnique() {
		return cntDigitUnique;
	}
	public Long getCntSpace() {
		return cntSpace;
	}
	public Long getCntUnderscore() {
		return cntUnderscore;
	}
	public Long getCntDash() {
		return cntDash;
	}
	public Long getParsedNum() {
		return parsedNum;
	}
	public ZonedDateTime getParsedZDT() {
		return parsedZDT;
	}
	public String getTokenizedName() {
		return tokenizedName;
	}
	public String[] getArrayToken() {
		return arrayToken;
	}
	public String[] getArrayLetter() {
		return arrayLetter;
	}
	public Long[] getArrayLetterCnt() {
		return arrayLetterCnt;
	}
	public Long[] getArrayTokenId() {
		return arrayTokenId;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setFileNameTypeId(Long fileNameTypeId) {
		this.fileNameTypeId = fileNameTypeId;
	}
	public void setNameLanguageId(Long nameLanguageId) {
		this.nameLanguageId = nameLanguageId;
	}
	public void setNameLanguageId2(Long nameLanguageId2) {
		this.nameLanguageId2 = nameLanguageId2;
	}
	public void setNameHashId(Long nameHashId) {
		this.nameHashId = nameHashId;
	}
	public void setFileNameRelative(String fileNameRelative) {
		this.fileNameRelative = fileNameRelative;
	}
	public void setFileNameCanonical(String fileNameCanonical) {
		this.fileNameCanonical = fileNameCanonical;
	}
	public void setFileURI(String fileURI) {
		this.fileURI = fileURI;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}
	public void setNameWithoutExtension(String nameWithoutExtension) {
		this.nameWithoutExtension = nameWithoutExtension;
	}
	public void setDirNameRelative(String dirNameRelative) {
		this.dirNameRelative = dirNameRelative;
	}
	public void setDirNameAbsolute(String dirNameAbsolute) {
		this.dirNameAbsolute = dirNameAbsolute;
	}
	public void setFileNameLength(Long fileNameLength) {
		this.fileNameLength = fileNameLength;
	}
	public void setFileNameAbsoluteLength(Long fileNameAbsoluteLength) {
		this.fileNameAbsoluteLength = fileNameAbsoluteLength;
	}
	public void setCompressedNameSize(Long compressedNameSize) {
		this.compressedNameSize = compressedNameSize;
	}
	public void setFileName83(String fileName83) {
		this.fileName83 = fileName83;
	}
	public void setAltName1(String altName1) {
		this.altName1 = altName1;
	}
	public void setAltName2(String altName2) {
		this.altName2 = altName2;
	}
	public void setAltName3(String altName3) {
		this.altName3 = altName3;
	}
	public void setAltNameFromTag(String altNameFromTag) {
		this.altNameFromTag = altNameFromTag;
	}
	public void setAltNameFromContent(String altNameFromContent) {
		this.altNameFromContent = altNameFromContent;
	}
	public void setOnlyAsciiLetter(String onlyAsciiLetter) {
		this.onlyAsciiLetter = onlyAsciiLetter;
	}
	public void setOnlyDigit(String onlyDigit) {
		this.onlyDigit = onlyDigit;
	}
	public void setOnlyUTFLetter(String onlyUTFLetter) {
		this.onlyUTFLetter = onlyUTFLetter;
	}
	public void setSortedLetters(String sortedLetters) {
		this.sortedLetters = sortedLetters;
	}
	public void setSortedLettersUnique(String sortedLettersUnique) {
		this.sortedLettersUnique = sortedLettersUnique;
	}
	public void setEncryptedNameRelative(String encryptedNameRelative) {
		this.encryptedNameRelative = encryptedNameRelative;
	}
	public void setEncryptedNameAbsolute(String encryptedNameAbsolute) {
		this.encryptedNameAbsolute = encryptedNameAbsolute;
	}
	public void setIsNameValid(String isNameValid) {
		this.isNameValid = isNameValid;
	}
	public void setValidityRemark(String validityRemark) {
		this.validityRemark = validityRemark;
	}
	public void setIsNameCorrect(String isNameCorrect) {
		this.isNameCorrect = isNameCorrect;
	}
	public void setCorrectedName(String correctedName) {
		this.correctedName = correctedName;
	}
	public void setCorrectnessRemark(String correctnessRemark) {
		this.correctnessRemark = correctnessRemark;
	}
	public void setGoodnessLevel(String goodnessLevel) {
		this.goodnessLevel = goodnessLevel;
	}
	public void setGoodnessRemark(String goodnessRemark) {
		this.goodnessRemark = goodnessRemark;
	}
	public void setGoodNameSuggested(String goodNameSuggested) {
		this.goodNameSuggested = goodNameSuggested;
	}
	public void setIsHumanGiven(String isHumanGiven) {
		this.isHumanGiven = isHumanGiven;
	}
	public void setIsGenerated(String isGenerated) {
		this.isGenerated = isGenerated;
	}
	public void setIsHumanUnderstandable(String isHumanUnderstandable) {
		this.isHumanUnderstandable = isHumanUnderstandable;
	}
	public void setNameEncoding(String nameEncoding) {
		this.nameEncoding = nameEncoding;
	}
	public void setNameCharsetStr(String nameCharsetStr) {
		this.nameCharsetStr = nameCharsetStr;
	}
	public void setNameRemark(String nameRemark) {
		this.nameRemark = nameRemark;
	}
	public void setStrEntityType(String strEntityType) {
		this.strEntityType = strEntityType;
	}
	public void setStrEntityStr(String strEntityStr) {
		this.strEntityStr = strEntityStr;
	}
	public void setStrEntityId(Long strEntityId) {
		this.strEntityId = strEntityId;
	}
	public void setStrEntityType2(String strEntityType2) {
		this.strEntityType2 = strEntityType2;
	}
	public void setStrEntityStr2(String strEntityStr2) {
		this.strEntityStr2 = strEntityStr2;
	}
	public void setStrEntityId2(Long strEntityId2) {
		this.strEntityId2 = strEntityId2;
	}
	public void setCntLetter(Long cntLetter) {
		this.cntLetter = cntLetter;
	}
	public void setCntLetterUnique(Long cntLetterUnique) {
		this.cntLetterUnique = cntLetterUnique;
	}
	public void setCntAsciiLetter(Long cntAsciiLetter) {
		this.cntAsciiLetter = cntAsciiLetter;
	}
	public void setCntAsciiLetterUppercase(Long cntAsciiLetterUppercase) {
		this.cntAsciiLetterUppercase = cntAsciiLetterUppercase;
	}
	public void setCntAsciiLetterLowercase(Long cntAsciiLetterLowercase) {
		this.cntAsciiLetterLowercase = cntAsciiLetterLowercase;
	}
	public void setCntAsciiUnprintable(Long cntAsciiUnprintable) {
		this.cntAsciiUnprintable = cntAsciiUnprintable;
	}
	public void setCntNonAscii(Long cntNonAscii) {
		this.cntNonAscii = cntNonAscii;
	}
	public void setCntUTFLetter(Long cntUTFLetter) {
		this.cntUTFLetter = cntUTFLetter;
	}
	public void setCntUTFLetterByte1(Long cntUTFLetterByte1) {
		this.cntUTFLetterByte1 = cntUTFLetterByte1;
	}
	public void setCntUTFLetterByte2(Long cntUTFLetterByte2) {
		this.cntUTFLetterByte2 = cntUTFLetterByte2;
	}
	public void setCntUTFLetterByte3(Long cntUTFLetterByte3) {
		this.cntUTFLetterByte3 = cntUTFLetterByte3;
	}
	public void setCntUTFLetterByte4(Long cntUTFLetterByte4) {
		this.cntUTFLetterByte4 = cntUTFLetterByte4;
	}
	public void setCntEmoji(Long cntEmoji) {
		this.cntEmoji = cntEmoji;
	}
	public void setCntDigit(Long cntDigit) {
		this.cntDigit = cntDigit;
	}
	public void setCntDigitUnique(Long cntDigitUnique) {
		this.cntDigitUnique = cntDigitUnique;
	}
	public void setCntSpace(Long cntSpace) {
		this.cntSpace = cntSpace;
	}
	public void setCntUnderscore(Long cntUnderscore) {
		this.cntUnderscore = cntUnderscore;
	}
	public void setCntDash(Long cntDash) {
		this.cntDash = cntDash;
	}
	public void setParsedNum(Long parsedNum) {
		this.parsedNum = parsedNum;
	}
	public void setParsedZDT(ZonedDateTime parsedZDT) {
		this.parsedZDT = parsedZDT;
	}
	public void setTokenizedName(String tokenizedName) {
		this.tokenizedName = tokenizedName;
	}
	public void setArrayToken(String[] arrayToken) {
		this.arrayToken = arrayToken;
	}
	public void setArrayLetter(String[] arrayLetter) {
		this.arrayLetter = arrayLetter;
	}
	public void setArrayLetterCnt(Long[] arrayLetterCnt) {
		this.arrayLetterCnt = arrayLetterCnt;
	}
	public void setArrayTokenId(Long[] arrayTokenId) {
		this.arrayTokenId = arrayTokenId;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public NodeFile getRefFile() {
		return refFile;
	}
	public void setRefFile(NodeFile refFile) {
		this.refFile = refFile;
	}
	public String getCompressedName() {
		return compressedName;
	}
	public void setCompressedName(String compressedName) {
		this.compressedName = compressedName;
	}
	public void setFileNameId(Long fileNameId) {
		this.fileNameId = fileNameId;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public void setDepthFromRoot(Long depthFromRoot) {
		this.depthFromRoot = depthFromRoot;
	}
		
	
	
}
