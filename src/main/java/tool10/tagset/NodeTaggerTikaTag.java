package tool10.tagset;

import java.io.Serializable;
import java.util.HashMap;

public class NodeTaggerTikaTag implements Serializable {


	public NodeTaggerTikaTag(Long tagFileId) {
		super();
		this.tagFileId = tagFileId;
		this.mapAttribute = new HashMap<String, String>();
	}

	public NodeTaggerTikaTag(Long tagFileId, String fileType) {
		super();
		this.tagFileId = tagFileId;
		this.fileType = fileType;
		this.mapAttribute = new HashMap<String, String>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagFileId;
	private String fileType; //file, directory, link, 
		
	private HashMap<String,String> mapAttribute;

	public Long getTagFileId() {
		return tagFileId;
	}

	public void setTagFileId(Long tagFileId) {
		this.tagFileId = tagFileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public HashMap<String, String> getMapAttribute() {
		return mapAttribute;
	}

	public void setMapAttribute(HashMap<String, String> mapAttribute) {
		this.mapAttribute = mapAttribute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
