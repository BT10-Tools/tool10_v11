package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class NodeDocBlob implements Serializable  {

	public NodeDocBlob(Long docBlobId, Long docId, Long fileBlobId, String docType, String blobType, Long docSize,
			byte[] docBytes, List<String> docLines, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.docBlobId = docBlobId;
		this.docId = docId;
		this.fileBlobId = fileBlobId;
		this.docType = docType;
		this.blobType = blobType;
		this.docSize = docSize;
		this.docBytes = docBytes;
		this.docLines = docLines;
		this.crc64 = crc64;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	private static final long serialVersionUID = 1L;
	
	private Long docBlobId;
	private Long docId;
	private Long fileBlobId;
	private String docType;
	private String blobType;
	private Long docSize;
	private byte[] docBytes;  //file bytes 
	private List<String> docLines;  //file bytes 
	private Long crc64;	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
		
	public Long getCrc64() {
		return crc64;
	}
	public void setCrc64(Long crc64) {
		this.crc64 = crc64;
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
	public String getBlobType() {
		return blobType;
	}
	public void setBlobType(String blobType) {
		this.blobType = blobType;
	}
	public Long getFileBlobId() {
		return fileBlobId;
	}
	public void setFileBlobId(Long fileBlobId) {
		this.fileBlobId = fileBlobId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Long getDocBlobId() {
		return docBlobId;
	}
	public void setDocBlobId(Long docBlobId) {
		this.docBlobId = docBlobId;
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Long getDocSize() {
		return docSize;
	}
	public void setDocSize(Long docSize) {
		this.docSize = docSize;
	}
	public byte[] getDocBytes() {
		return docBytes;
	}
	public void setDocBytes(byte[] docBytes) {
		this.docBytes = docBytes;
	}
	public List<String> getDocLines() {
		return docLines;
	}
	public void setDocLines(List<String> docLines) {
		this.docLines = docLines;
	}

	
}
