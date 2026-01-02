package tool10.bookset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeSentence implements Serializable {

	public NodeSentence(Long sentenceId, Long paragraphId, Long bookId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
			String sentenceDesc,  String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
			Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.sentenceId = sentenceId;
		this.paragraphId = paragraphId;
		this.bookId = bookId;
		this.languageId = languageId;
		this.sameSentenceId = sameSentenceId;
		this.sentenceName = sentenceName;
		this.sentenceType = sentenceType;
		this.sentenceDesc = sentenceDesc;
		this.sentenceStr = sentenceStr;
		this.sentenceHolder = sentenceHolder;
		this.authorName = authorName;
		this.sourceName = sourceName;
		this.displayOrder = displayOrder;
		this.pageNumber = pageNumber;
		this.lineNumber = lineNumber;
		this.wordNumber = wordNumber;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listToken = new ArrayList<NodeToken>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long sentenceId;
	private Long paragraphId;
	private Long bookId;
	private Long languageId;
	private Long sameSentenceId;
	private String sentenceName;
	private String sentenceType;
	private String sentenceDesc;
	private String sentenceStr;
	private String sentenceHolder;
	private String authorName;
	private String sourceName;
	private Long displayOrder;
	private Long pageNumber;
	private Long lineNumber;
	private Long wordNumber;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;

	private ArrayList<NodeToken> listToken;

	public Long getSentenceId() {
		return sentenceId;
	}

	public void setSentenceId(Long sentenceId) {
		this.sentenceId = sentenceId;
	}

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

	public String getSentenceName() {
		return sentenceName;
	}

	public void setSentenceName(String sentenceName) {
		this.sentenceName = sentenceName;
	}

	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
	}

	public String getSentenceDesc() {
		return sentenceDesc;
	}

	public void setSentenceDesc(String sentenceDesc) {
		this.sentenceDesc = sentenceDesc;
	}

	public String getSentenceHolder() {
		return sentenceHolder;
	}

	public void setSentenceHolder(String sentenceHolder) {
		this.sentenceHolder = sentenceHolder;
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

	public ArrayList<NodeToken> getListToken() {
		return listToken;
	}

	public void setListToken(ArrayList<NodeToken> listToken) {
		this.listToken = listToken;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSentenceStr() {
		return sentenceStr;
	}

	public void setSentenceStr(String sentenceStr) {
		this.sentenceStr = sentenceStr;
	}

	public Long getSameSentenceId() {
		return sameSentenceId;
	}

	public void setSameSentenceId(Long sameSentenceId) {
		this.sameSentenceId = sameSentenceId;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Long getBookId() {
		return bookId;
	}
	
	}
