package tool10.bookset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

public class NodeBookBlob implements Serializable  {

	public NodeBookBlob(Long bookBlobId, Long bookId, Long fileBlobId, String bookType, String blobType, Long bookSize,
			byte[] bookBytes, List<String> bookLines, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.bookBlobId = bookBlobId;
		this.bookId = bookId;
		this.fileBlobId = fileBlobId;
		this.bookType = bookType;
		this.blobType = blobType;
		this.bookSize = bookSize;
		this.bookBytes = bookBytes;
		this.bookLines = bookLines;
		this.crc64 = crc64;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	private static final long serialVersionUID = 1L;
	
	private Long bookBlobId;
	private Long bookId;
	private Long fileBlobId;
	private String bookType;
	private String blobType;
	private Long bookSize;
	private byte[] bookBytes;  //file bytes 
	private List<String> bookLines;  //file bytes 
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
	public Long getBookBlobId() {
		return bookBlobId;
	}
	public void setBookBlobId(Long bookBlobId) {
		this.bookBlobId = bookBlobId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public Long getBookSize() {
		return bookSize;
	}
	public void setBookSize(Long bookSize) {
		this.bookSize = bookSize;
	}
	public byte[] getBookBytes() {
		return bookBytes;
	}
	public void setBookBytes(byte[] bookBytes) {
		this.bookBytes = bookBytes;
	}
	public List<String> getBookLines() {
		return bookLines;
	}
	public void setBookLines(List<String> bookLines) {
		this.bookLines = bookLines;
	}

	
}
