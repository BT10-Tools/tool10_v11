package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeChapter implements Serializable {

	public NodeChapter(Long chapterId, Long docId, Long languageId, String chapterName, String chapterType,
			String chapterDesc, String authorName, String sourceName, Long displayOrder, Long pageNumber,
			Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.chapterId = chapterId;
		this.docId = docId;
		this.languageId = languageId;
		this.chapterName = chapterName;
		this.chapterType = chapterType;
		this.chapterDesc = chapterDesc;
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
	private Long chapterId;
	private Long docId;
	private Long languageId;
	private String chapterName;
	private String chapterType;
	private String chapterDesc;
	private String authorName;
	private String sourceName;
	private Long displayOrder;
	private Long pageNumber;
	private Long lineNumber;
	private Long wordNumber;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeParagraph> listParagraph;

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getChapterType() {
		return chapterType;
	}

	public void setChapterType(String chapterType) {
		this.chapterType = chapterType;
	}

	public String getChapterDesc() {
		return chapterDesc;
	}

	public void setChapterDesc(String chapterDesc) {
		this.chapterDesc = chapterDesc;
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

	public ArrayList<NodeParagraph> getListParagraph() {
		return listParagraph;
	}

	public void setListParagraph(ArrayList<NodeParagraph> listParagraph) {
		this.listParagraph = listParagraph;
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
}
