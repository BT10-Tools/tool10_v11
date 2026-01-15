package tool10.docset;

import java.io.Serializable;

public class NodeLanguage implements Serializable {
	
	public NodeLanguage(Long languageId, String languageName, String shortName, String alhabetName) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
		this.shortName = shortName;
		this.alhabetName = alhabetName;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long languageId;
	private String languageName;
	private String shortName;
	private String alhabetName;
	
	public Long getLanguageId() {
		return languageId;
	}
	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getAlhabetName() {
		return alhabetName;
	}
	public void setAlhabetName(String alhabetName) {
		this.alhabetName = alhabetName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
