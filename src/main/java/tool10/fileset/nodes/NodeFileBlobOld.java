package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeFileBlobOld implements Serializable  {

	public NodeFileBlobOld(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
			Long blobSize, Long fileSize, String compressionType, Long compressedFileSize, Double compressionGainRatio,
			Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			Long encryptedFileSize, Long encrytedByteHashId,byte[] fileBytes, byte[] compressedBytes, byte[] encryptedBytes, 
			Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileBlobId = fileBlobId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.partNumber = partNumber;
		this.cntPart = cntPart;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.fileSize = fileSize;
		this.compressionType = compressionType;
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.compressedByteHashId = compressedByteHashId;
		this.encryptionBlobKey = encryptionBlobKey;
		this.sandByteLengthHead = sandByteLengthHead;
		this.sandByteLengthTail = sandByteLengthTail;
		this.encryptionType = encryptionType;
		this.encryptedFileSize = encryptedFileSize;
		this.encrytedByteHashId = encrytedByteHashId;
		this.fileBytes = fileBytes;
		this.compressedBytes = compressedBytes;
		this.encryptedBytes = encryptedBytes;
		this.hashId = hashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	public NodeFileBlobOld(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
			Long blobSize, Long fileSize, byte[] fileBytes, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.fileBlobId = fileBlobId;
		this.fileId = fileId;
		this.fileSetId = fileSetId;
		this.partNumber = partNumber;
		this.cntPart = cntPart;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.fileSize = fileSize;
		this.fileBytes = fileBytes;
		this.hashId = hashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long fileBlobId;
	private Long fileId;
	private Long fileSetId;
	private Long partNumber;
	private Long cntPart;
	private String blobType;
	private Long blobSize;
	private Long fileSize;
	private String compressionType;
	private Long compressedFileSize;
	private Double compressionGainRatio; 
	private Long compressionGainBytes; 
	private Long compressedByteHashId;
	private Long sandByteLengthHead;
	private Long sandByteLengthTail;
	private String encryptionBlobKey;
	private String encryptionType;
	private Long encryptedFileSize;
	private Long encrytedByteHashId;
	private byte[] fileBytes;
	private byte[] compressedBytes;
	private byte[] encryptedBytes;
	private Long hashId;	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public void setCompressionFields(String compressionType, Long compressedFileSize, Double compressionGainRatio,
			Long compressionGainBytes, Long compressedByteHashId, byte[] compressedBytes) {
		this.compressionType = compressionType;
		this.compressedFileSize = compressedFileSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.compressedByteHashId = compressedByteHashId;
		this.compressedBytes = compressedBytes;
	}	
	public void setEncryptionFields(Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			Long encryptedFileSize, Long encrytedByteHashId, byte[] encryptedBytes) {
		this.encryptionBlobKey = encryptionBlobKey;
		this.sandByteLengthHead = sandByteLengthHead;
		this.sandByteLengthTail = sandByteLengthTail;
		this.encryptionType = encryptionType;
		this.encryptedFileSize = encryptedFileSize;
		this.encrytedByteHashId = encrytedByteHashId;
		this.encryptedBytes = encryptedBytes;
	}	
	//GETTERS AND SETTERS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileBlobId() {
		return fileBlobId;
	}
	public Long getFileId() {
		return fileId;
	}
	public Long getPartNumber() {
		return partNumber;
	}
	public Long getCntPart() {
		return cntPart;
	}
	public String getBlobType() {
		return blobType;
	}
	public Long getBlobSize() {
		return blobSize;
	}
	public byte[] getFileBytes() {
		return fileBytes;
	}
	public Long getHashId() {
		return hashId;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getCompressionType() {
		return compressionType;
	}
	public Long getCompressedFileSize() {
		return compressedFileSize;
	}
	public Long getCompressedByteHashId() {
		return compressedByteHashId;
	}
	public String getEncryptionBlobKey() {
		return encryptionBlobKey;
	}
	public String getEncryptionType() {
		return encryptionType;
	}
	public Long getEncryptedFileSize() {
		return encryptedFileSize;
	}
	public Long getEncrytedByteHashId() {
		return encrytedByteHashId;
	}
	public Long getSandByteLengthHead() {
		return sandByteLengthHead;
	}
	public Long getSandByteLengthTail() {
		return sandByteLengthTail;
	}
	public Double getCompressionGainRatio() {
		return compressionGainRatio;
	}
	public Long getCompressionGainBytes() {
		return compressionGainBytes;
	}
	public byte[] getCompressedBytes() {
		return compressedBytes;
	}
	public void setCompressedBytes(byte[] compressedBytes) {
		this.compressedBytes = compressedBytes;
	}
	public byte[] getEncryptedBytes() {
		return encryptedBytes;
	}
	public void setEncryptedBytes(byte[] encryptedBytes) {
		this.encryptedBytes = encryptedBytes;
	}
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}
	
	
	
	
}
