package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeFileBlobSmall implements Serializable  {

	public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
			Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileBlobSmallId = fileBlobSmallId;
		this.fileBlobId = fileBlobId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.byteIndexStart = byteIndexStart;
		this.byteIndexEnd = byteIndexEnd;
		this.hashId = hashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fileBlobSmallId;
	private Long fileBlobId;
	private Long fileId;
	private Long fileSetId;
	private Long byteIndexStart;
	private Long byteIndexEnd;
	private Long hashId;	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileBlobSmallId() {
		return fileBlobSmallId;
	}
	public Long getFileBlobId() {
		return fileBlobId;
	}
	public Long getFileId() {
		return fileId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getByteIndexStart() {
		return byteIndexStart;
	}
	public Long getByteIndexEnd() {
		return byteIndexEnd;
	}
	public Long getHashId() {
		return hashId;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setFileBlobId(Long fileBlobId) {
		this.fileBlobId = fileBlobId;
	}
	
}
