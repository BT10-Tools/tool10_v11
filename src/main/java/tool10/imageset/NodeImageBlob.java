package tool10.imageset;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeImageBlob implements Serializable  {


	public NodeImageBlob(Long imageBlobId, Long imageId, Long fileBlobId, String imageType, String blobType, Long imageSize, 
			byte[] imageBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.imageBlobId = imageBlobId;
		this.imageId = imageId;
		this.fileBlobId = fileBlobId;
		this.imageType = imageType;
		this.blobType = blobType;
		this.imageSize = imageSize;
		this.imageBytes = imageBytes;
		this.crc64 = crc64;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	//String fieldStr = "registryBlobId INTEGER,entryType TEXT,entryDataLength INTEGER,entryData BLOB,crc64 INTEGER";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long imageBlobId;
	private Long imageId;
	private Long fileBlobId;
	private String imageType;
	private String blobType;
	private Long imageSize;
	private byte[] imageBytes;  //file bytes 
	private Long crc64;	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private transient BufferedImage buffImg;   //buffered images, too big  
	private transient Image img; //image 
	
	public Long getImageBlobId() {
		return imageBlobId;
	}
	public void setImageBlobId(Long imageBlobId) {
		this.imageBlobId = imageBlobId;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public Long getImageSize() {
		return imageSize;
	}
	public void setImageSize(Long imageSize) {
		this.imageSize = imageSize;
	}
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
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
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
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
	
}
