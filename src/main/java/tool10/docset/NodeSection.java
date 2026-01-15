package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeSection implements Serializable {


	public NodeSection(Long sectionId, Long chapterId, Long docId, Long languageId, Long sameSectionId, String sectionName,
			String sectionType, String sectionDesc, String sectionStr, String authorName, String sourceName, Long displayOrder, 
			Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		super();
		this.sectionId = sectionId;
		this.chapterId = chapterId;
		this.docId = docId;
		this.languageId = languageId;
		this.sameSectionId = sameSectionId;
		this.sectionName = sectionName;
		this.sectionType = sectionType;
		this.sectionDesc = sectionDesc;
		this.sectionStr = sectionStr;
		this.authorName = authorName;
		this.sourceName = sourceName;
		this.displayOrder = displayOrder;
		this.pageNumber = pageNumber;
		this.lineNumber = lineNumber;
		this.wordNumber = wordNumber;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listParagraph = new ArrayList<NodeParagraph>();
	}	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sectionId;
	private Long chapterId;
	private Long docId;
	private Long languageId;
	private Long sameSectionId;
	private String sectionName;
	private String sectionType;
	private String sectionDesc;
	private String sectionStr;
	private String authorName;
	private String sourceName;
	private Long displayOrder;
	private Long pageNumber;
	private Long lineNumber;
	private Long wordNumber;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeParagraph> listParagraph;

	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public Long getChapterId() {
		return chapterId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public Long getSameSectionId() {
		return sameSectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public String getSectionType() {
		return sectionType;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public String getSectionStr() {
		return sectionStr;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public Long getLineNumber() {
		return lineNumber;
	}

	public Long getWordNumber() {
		return wordNumber;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public ArrayList<NodeParagraph> getListParagraph() {
		return listParagraph;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public void setSameSectionId(Long sameSectionId) {
		this.sameSectionId = sameSectionId;
	}

	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public void setWordNumber(Long wordNumber) {
		this.wordNumber = wordNumber;
	}

	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Long getDocId() {
		return docId;
	}

	
}
