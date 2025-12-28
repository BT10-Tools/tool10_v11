package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.fileset.nodes.NodeBinary;

public class NodeEmbedded implements Serializable {


	public NodeEmbedded(Long embeddedId, Long tagFileId, Long tagSetId, String embeddingType,
			String tmpFileAbsolutePath, String tmpFileName, Long embeddedSize, Long displayOrder,NodeBinary embeddedBinary,
			byte[] embeddedBytes, Long crc64, ZonedDateTime creationDate) {
		super();
		this.embeddedId = embeddedId;
		this.tagFileId = tagFileId;
		this.tagSetId = tagSetId;
		this.embeddingType = embeddingType;
		this.tmpFileAbsolutePath = tmpFileAbsolutePath;
		this.tmpFileName = tmpFileName;
		this.embeddedSize = embeddedSize;
		this.displayOrder = displayOrder;
		this.creationDate = creationDate;
		this.embeddedBinary = embeddedBinary;
		this.embeddedBytes = (embeddedBinary!=null) ? embeddedBinary.getByteArray() : null; 
		this.crc64 = crc64;
		this.listTag = new ArrayList<NodeTag>();
	}

	private static final long serialVersionUID = 1L;
	
	private Long embeddedId;
	private Long tagFileId;
	private Long tagSetId;
	private String embeddingType;
	private String tmpFileAbsolutePath;
	private String tmpFileName;
	private Long embeddedSize;
	private Long displayOrder;
	private byte[] embeddedBytes;
	private Long crc64;
	private ZonedDateTime creationDate;
	
	private NodeBinary embeddedBinary;  
	private ArrayList<NodeTag> listTag;

	public Long getEmbeddedId() {
		return embeddedId;
	}

	public void setEmbeddedId(Long embeddedId) {
		this.embeddedId = embeddedId;
	}

	public Long getTagFileId() {
		return tagFileId;
	}

	public void setTagFileId(Long tagFileId) {
		this.tagFileId = tagFileId;
	}

	public Long getTagSetId() {
		return tagSetId;
	}

	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}

	public String getEmbeddingType() {
		return embeddingType;
	}

	public void setEmbeddingType(String embeddingType) {
		this.embeddingType = embeddingType;
	}

	public String getTmpFileAbsolutePath() {
		return tmpFileAbsolutePath;
	}

	public void setTmpFileAbsolutePath(String tmpFileAbsolutePath) {
		this.tmpFileAbsolutePath = tmpFileAbsolutePath;
	}

	public Long getEmbeddedSize() {
		return embeddedSize;
	}

	public void setEmbeddedSize(Long embeddedSize) {
		this.embeddedSize = embeddedSize;
	}

	public Long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<NodeTag> getListTag() {
		return listTag;
	}

	public void setListTag(ArrayList<NodeTag> listTag) {
		this.listTag = listTag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTmpFileName() {
		return tmpFileName;
	}

	public void setTmpFileName(String tmpFileName) {
		this.tmpFileName = tmpFileName;
	}

	public NodeBinary getEmbeddedBinary() {
		return embeddedBinary;
	}

	public void setEmbeddedBinary(NodeBinary embeddedBinary) {
		this.embeddedBinary = embeddedBinary;
	}

	public Long getCrc64() {
		return crc64;
	}

	public void setCrc64(Long crc64) {
		this.crc64 = crc64;
	}

	public byte[] getEmbeddedBytes() {
		return embeddedBytes;
	}

	public void setEmbeddedBytes(byte[] embeddedBytes) {
		this.embeddedBytes = embeddedBytes;
	}

	
}
