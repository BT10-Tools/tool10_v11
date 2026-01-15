package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeDoc implements Serializable {

	public NodeDoc(Long docId, Long docSetId, Long languageId, Long secondLanguageId, String docName,
			String docType, String docDesc, String isbn, String authorName, String sourceName,
			Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.docId = docId;
		this.docSetId = docSetId;
		this.languageId = languageId;
		this.secondLanguageId = secondLanguageId;
		this.docName = docName;
		this.docType = docType;
		this.docDesc = docDesc;
		this.isbn = isbn;
		this.authorName = authorName;
		this.sourceName = sourceName;
		this.displayOrder = displayOrder;
		this.pageNumber = pageNumber;
		this.lineNumber = lineNumber;
		this.wordNumber = wordNumber;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listChapter = new ArrayList<NodeChapter>();
	}

	public NodeDoc(Long docId, Long docSetId, Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.docId = docId;
		this.docSetId = docSetId;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.listChapter = new ArrayList<NodeChapter>();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long docId;
	private Long docSetId;
	private Long languageId;
	private Long secondLanguageId;
	private String docName;
	private String docType;
	private String docDesc;
	private String isbn;
	private String authorName;
	private String sourceName;
	private Long displayOrder;
	private Long pageNumber;
	private Long lineNumber;
	private Long wordNumber;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeChapter> listChapter;

	public Long getDocId() {
		return docId;
	}
	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public Long getSecondLanguageId() {
		return secondLanguageId;
	}

	public void setSecondLanguageId(Long secondLanguageId) {
		this.secondLanguageId = secondLanguageId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocDesc() {
		return docDesc;
	}

	public void setDocDesc(String docDesc) {
		this.docDesc = docDesc;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
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

	public ArrayList<NodeChapter> getListChapter() {
		return listChapter;
	}

	public void setListChapter(ArrayList<NodeChapter> listChapter) {
		this.listChapter = listChapter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Long getDocSetId() {
		return docSetId;
	}
}
