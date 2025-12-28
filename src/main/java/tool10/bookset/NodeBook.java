package tool10.bookset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeBook implements Serializable {

	public NodeBook(Long bookId, Long bookSetId, Long languageId, Long secondLanguageId, String bookName,
			String bookType, String bookDesc, String isbn, String authorName, String sourceName,
			Long displayOrder, Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.bookId = bookId;
		this.bookSetId = bookSetId;
		this.languageId = languageId;
		this.secondLanguageId = secondLanguageId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.bookDesc = bookDesc;
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

	public NodeBook(Long bookId, Long bookSetId, Long displayOrder, ZonedDateTime creationDate) {
		super();
		this.bookId = bookId;
		this.bookSetId = bookSetId;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.listChapter = new ArrayList<NodeChapter>();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long bookId;
	private Long bookSetId;
	private Long languageId;
	private Long secondLanguageId;
	private String bookName;
	private String bookType;
	private String bookDesc;
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

	public Long getBookId() {
		return bookId;
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
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
	public Long getBookSetId() {
		return bookSetId;
	}
}
