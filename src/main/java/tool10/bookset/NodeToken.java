package tool10.bookset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeToken implements Serializable {

	public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength,
			Long cntInBookSet, Double frequencyBookSet, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.tokenId = tokenId;
		this.dictId = dictId;
		this.wordId = wordId;
		this.tokenStr = tokenStr;
		this.tokenDesc = tokenDesc;
		this.tokenLength = tokenLength;
		this.cntInBookSet = cntInBookSet;
		this.frequencyBookSet = frequencyBookSet;
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
	private Long cntInBookSet;
	private Double frequencyBookSet;
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
	public Long getCntInBookSet() {
		return cntInBookSet;
	}
	public void setCntInBookSet(Long cntInBookSet) {
		this.cntInBookSet = cntInBookSet;
	}
	public Double getFrequencyBookSet() {
		return frequencyBookSet;
	}
	public void setFrequencyBookSet(Double frequencyBookSet) {
		this.frequencyBookSet = frequencyBookSet;
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
