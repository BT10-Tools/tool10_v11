package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeToken implements Serializable {

	public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
			Long cntInDocSet, Double frequencyDocSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.tokenId = tokenId;
		this.dictId = dictId;
		this.wordId = wordId;
		this.tokenStr = tokenStr;
		this.tokenDesc = tokenDesc;
		this.tokenLength = tokenLength;
		this.cntInDocSet = cntInDocSet;
		this.frequencyDocSet = frequencyDocSet;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long tokenId;
	private Long dictId;	//to dictionary
	private Long wordId;  	//to word 
	private String tokenStr;
	private String tokenDesc;
	private Long tokenLength;
	private Long cntInDocSet;
	private Double frequencyDocSet;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public Long getTokenId() {
		return tokenId;
	}
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}
	public Long getDictId() {
		return dictId;
	}
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}
	public Long getWordId() {
		return wordId;
	}
	public void setWordId(Long wordId) {
		this.wordId = wordId;
	}
	public String getTokenStr() {
		return tokenStr;
	}
	public void setTokenStr(String tokenStr) {
		this.tokenStr = tokenStr;
	}
	public String getTokenDesc() {
		return tokenDesc;
	}
	public void setTokenDesc(String tokenDesc) {
		this.tokenDesc = tokenDesc;
	}
	public Long getTokenLength() {
		return tokenLength;
	}
	public void setTokenLength(Long tokenLength) {
		this.tokenLength = tokenLength;
	}
	public Long getCntInDocSet() {
		return cntInDocSet;
	}
	public void setCntInDocSet(Long cntInDocSet) {
		this.cntInDocSet = cntInDocSet;
	}
	public Double getFrequencyDocSet() {
		return frequencyDocSet;
	}
	public void setFrequencyDocSet(Double frequencyDocSet) {
		this.frequencyDocSet = frequencyDocSet;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
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
