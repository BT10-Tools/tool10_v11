package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeHash  implements Serializable {
	
	public NodeHash(Long hashId, Long fileSetId, Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
			String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
			String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
			String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.hashId = hashId;
		this.fileSetId = fileSetId;
		this.fileSize = fileSize;
		this.crc64 = crc64;
		this.crc32 = crc32;
		this.adler32 = adler32;
		this.blake3 = blake3;
		this.md5 = md5;
		this.sha1 = sha1;
		this.sha256 = sha256; 
		this.sha384 = sha384; 
		this.sha512 = sha512; 
		this.sha3256 = sha3256; 
		this.keccak256 = keccak256;
		
		this.hashFieldDesc = hashFieldDesc;
		this.hashStr01 = hashStr01;
		this.hashStr02 = hashStr02;
		this.hashStr03 = hashStr03;
		this.hashStr04 = hashStr04;
		this.hashStr05 = hashStr05;
		this.hashLong01 = hashLong01;
		this.hashLong02 = hashLong02;
		this.hashLong03 = hashLong03;
		this.hashLong04 = hashLong04;
		this.hashLong05 = hashLong05;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	public NodeHash(Long hashId, Long fileSetId, Long fileSize,ZonedDateTime creationDate) {
		super();
		this.hashId = hashId;
		this.fileSetId = fileSetId;
		this.fileSize = fileSize;
		this.creationDate = creationDate;
	}
	private Long hashId;
	private Long fileSetId;
	private Long fileSize;
	private Long crc64;
	private Long crc32;
	private Long adler32;
	private String blake3;
	private String md5;
	private String sha1;
	private String sha256;
	private String sha384;
	private String sha512;
	private String sha3256;
	private String keccak256;
	
	private String hashFieldDesc;
	private String hashStr01;
	private String hashStr02;
	private String hashStr03;
	private String hashStr04;
	private String hashStr05;
	private Long hashLong01;
	private Long hashLong02;
	private Long hashLong03;
	private Long hashLong04;
	private Long hashLong05;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public void setHashValues(Long crc64, Long crc32, String blake3, String md5,ZonedDateTime modificationDate) {
		this.crc64 = crc64;
		this.crc32 = crc32;
		this.blake3 = blake3;
		this.md5 = md5;
		this.modificationDate = modificationDate;
	}
	
	//GETTERS AND SETTERS
	public Long getHashId() {
		return hashId;
	}
	public void setHashId(Long hashId) {
		this.hashId = hashId;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getCrc64() {
		return crc64;
	}
	public void setCrc64(Long crc64) {
		this.crc64 = crc64;
	}
	public Long getCrc32() {
		return crc32;
	}
	public void setCrc32(Long crc32) {
		this.crc32 = crc32;
	}
	public String getBlake3() {
		return blake3;
	}
	public void setBlake3(String blake3) {
		this.blake3 = blake3;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public String getHashFieldDesc() {
		return hashFieldDesc;
	}
	public String getHashStr01() {
		return hashStr01;
	}
	public String getHashStr02() {
		return hashStr02;
	}
	public String getHashStr03() {
		return hashStr03;
	}
	public String getHashStr04() {
		return hashStr04;
	}
	public String getHashStr05() {
		return hashStr05;
	}
	public Long getHashLong01() {
		return hashLong01;
	}
	public Long getHashLong02() {
		return hashLong02;
	}
	public Long getHashLong03() {
		return hashLong03;
	}
	public Long getHashLong04() {
		return hashLong04;
	}
	public Long getHashLong05() {
		return hashLong05;
	}

	public String getSha1() {
		return sha1;
	}

	public String getSha256() {
		return sha256;
	}

	public String getSha384() {
		return sha384;
	}

	public String getSha512() {
		return sha512;
	}

	public String getSha3256() {
		return sha3256;
	}

	public String getKeccak256() {
		return keccak256;
	}

	public Long getAdler32() {
		return adler32;
	}
}
