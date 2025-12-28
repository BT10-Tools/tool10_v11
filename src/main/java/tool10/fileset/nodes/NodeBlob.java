package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeBlob implements Serializable  {

	public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
			Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
			Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
			Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.blobId = blobId;
		this.sourceId = sourceId;
		this.fileSetId = fileSetId;
		this.firstPartBlobId = firstPartBlobId;
		this.partNumber = partNumber;
		this.cntPart = cntPart;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.compressionType = compressionType;
		this.compressedSize = compressedSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.compressedByteHashId = compressedByteHashId;
		this.encryptionBlobKey = encryptionBlobKey;
		this.sandByteLengthHead = sandByteLengthHead;
		this.sandByteLengthTail = sandByteLengthTail;
		this.encryptionType = encryptionType;
		this.encryptedSize = encryptedSize;
		this.encrytedByteHashId = encrytedByteHashId;
		this.blobBytes = blobBytes;
		this.compressedBytes = compressedBytes;
		this.encryptedBytes = encryptedBytes;
		this.blobHashId = blobHashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
			Long blobSize, Long fileSize, byte[] blobBytes, Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.blobId = blobId;
		this.sourceId = sourceId;
		this.fileSetId = fileSetId;
		this.firstPartBlobId = firstPartBlobId;
		this.partNumber = partNumber;
		this.cntPart = cntPart;
		this.blobType = blobType;
		this.blobSize = blobSize;
		this.blobBytes = blobBytes;
		this.blobHashId = blobHashId;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long blobId;
	private Long sourceId;
	private Long fileSetId;
	private Long firstPartBlobId;
	private Long partNumber;
	private Long cntPart;
	private String blobType; 
	private Long blobSize;
	private Long blobHashId;	
	private String compressionType;
	private Long compressedSize;
	private Double compressionGainRatio; 
	private Long compressionGainBytes; 
	private Long compressedByteHashId;
	private Long sandByteLengthHead;
	private Long sandByteLengthTail;
	private String encryptionBlobKey;
	private String encryptionType;
	private Long encryptedSize;
	private Long encrytedByteHashId;
	private byte[] blobBytes;
	private byte[] compressedBytes;
	private byte[] encryptedBytes;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public void setCompressionFields(String compressionType, Long compressedSize, Double compressionGainRatio,
			Long compressionGainBytes, Long compressedByteHashId, byte[] compressedBytes) {
		this.compressionType = compressionType;
		this.compressedSize = compressedSize;
		this.compressionGainRatio = compressionGainRatio; 
		this.compressionGainBytes = compressionGainBytes;
		this.compressedByteHashId = compressedByteHashId;
		this.compressedBytes = compressedBytes;
	}	
	public void setEncryptionFields(Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
			Long encryptedSize, Long encrytedByteHashId, byte[] encryptedBytes) {
		this.encryptionBlobKey = encryptionBlobKey;
		this.sandByteLengthHead = sandByteLengthHead;
		this.sandByteLengthTail = sandByteLengthTail;
		this.encryptionType = encryptionType;
		this.encryptedSize = encryptedSize;
		this.encrytedByteHashId = encrytedByteHashId;
		this.encryptedBytes = encryptedBytes;
	}	
	//GETTERS AND SETTERS
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getBlobId() {
		return blobId;
	}
	public Long getSourceId() {
		return sourceId;
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
	public byte[] getBlobBytes() {
		return blobBytes;
	}
	public Long getBlobHashId() {
		return blobHashId;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
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
	public Long getCompressedSize() {
		return compressedSize;
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
	public Long getEncryptedSize() {
		return encryptedSize;
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
	public void setBlobBytes(byte[] blobBytes) {
		this.blobBytes = blobBytes;
	}
	public Long getFirstPartBlobId() {
		return firstPartBlobId;
	}
	public void setCntPart(Long cntPart) {
		this.cntPart = cntPart;
	}
	
}
