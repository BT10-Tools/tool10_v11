package tool10.mediaset;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeMediaBlob implements Serializable  {


	public NodeMediaBlob(Long mediaBlobId, Long mediaId, Long mediaSetId, Long fileBlobId, String mediaType, String blobType, Long mediaSize, 
			byte[] mediaBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.mediaBlobId = mediaBlobId;
		this.mediaId = mediaId;
		this.mediaSetId = mediaSetId;
		this.fileBlobId = fileBlobId;
		this.mediaType = mediaType;
		this.blobType = blobType;
		this.mediaSize = mediaSize;
		this.mediaBytes = mediaBytes;
		this.crc64 = crc64;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	//String fieldStr = "registryBlobId INTEGER,entryType TEXT,entryDataLength INTEGER,entryData BLOB,crc64 INTEGER";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long mediaBlobId;
	private Long mediaId; //imageId, videoId, audioId etc. 
	private Long mediaSetId;
	private Long fileBlobId;
	private String mediaType;
	private String blobType;
	private Long mediaSize;
	private byte[] mediaBytes;  //file bytes 
	private Long crc64;	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private transient BufferedImage buffImg;   //buffered images, too big  
	private transient Image img; //image 
	
	public Long getMediaBlobId() {
		return mediaBlobId;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public Long getMediaSize() {
		return mediaSize;
	}
	public void setMediaSize(Long mediaSize) {
		this.mediaSize = mediaSize;
	}
	public byte[] getMediaBytes() {
		return mediaBytes;
	}
	public void setMediaBytes(byte[] mediaBytes) {
		this.mediaBytes = mediaBytes;
	}
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
	public Long getMediaId() {
		return mediaId;
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
	public BufferedImage getBuffImg() {
		return buffImg;
	}
	public void setBuffImg(BufferedImage buffImg) {
		this.buffImg = buffImg;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	
}
