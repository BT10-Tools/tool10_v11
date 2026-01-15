package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeParagraph implements Serializable {


	public NodeParagraph(Long paragraphId, Long sectionId, Long docId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
			String paragraphDesc, String paragraphStr, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.paragraphId = paragraphId;
		this.sectionId = sectionId;
		this.docId = docId;
		this.languageId = languageId;
		this.sameParagraphId = sameParagraphId;
		this.paragraphName = paragraphName;
		this.paragraphType = paragraphType;
		this.paragraphDesc = paragraphDesc;
		this.paragraphStr = paragraphStr;
		this.authorName = authorName;
		this.sourceName = sourceName;
		this.displayOrder = displayOrder;
		this.pageNumber = pageNumber;
		this.lineNumber = lineNumber;
		this.wordNumber = wordNumber;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listSentence = new ArrayList<NodeSentence>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long paragraphId;
	private Long sectionId;
	private Long docId;
	private Long languageId;
	private Long sameParagraphId;
	private String paragraphName;
	private String paragraphType;
	private String paragraphDesc;
	private String paragraphStr;
	private String authorName;
	private String sourceName;
	private Long displayOrder;
	private Long pageNumber;
	private Long lineNumber;
	private Long wordNumber;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeSentence> listSentence;

	public Long getParagraphId() {
		return paragraphId;
	}

	public void setParagraphId(Long paragraphId) {
		this.paragraphId = paragraphId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getParagraphName() {
		return paragraphName;
	}

	public void setParagraphName(String paragraphName) {
		this.paragraphName = paragraphName;
	}

	public String getParagraphType() {
		return paragraphType;
	}

	public void setParagraphType(String paragraphType) {
		this.paragraphType = paragraphType;
	}

	public String getParagraphDesc() {
		return paragraphDesc;
	}

	public void setParagraphDesc(String paragraphDesc) {
		this.paragraphDesc = paragraphDesc;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Long lineNumber) {
		this.lineNumber = lineNumber;
	}

	public Long getWordNumber() {
		return wordNumber;
	}

	public void setWordNumber(Long wordNumber) {
		this.wordNumber = wordNumber;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<NodeSentence> getListSentence() {
		return listSentence;
	}

	public void setListSentence(ArrayList<NodeSentence> listSentence) {
		this.listSentence = listSentence;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getParagraphStr() {
		return paragraphStr;
	}

	public void setParagraphStr(String paragraphStr) {
		this.paragraphStr = paragraphStr;
	}

	public Long getSameParagraphId() {
		return sameParagraphId;
	}

	public void setSameParagraphId(Long sameParagraphId) {
		this.sameParagraphId = sameParagraphId;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public Long getDocId() {
		return docId;
	}

}
