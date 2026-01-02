package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeImage implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeImage(Long imageId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, String imageName, String imageType, String imageSize,
			Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.imageId = imageId;
		this.mediaSetId = mediaSetId;
		this.mediaFileId = mediaFileId;
		this.sourceMediaId = sourceMediaId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageSize = imageSize;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.pixelNum = pixelNum;
		this.creationDate = creationDate;
	    this.modificationDate = modificationDate;
	}
	private Long imageId;
	private Long mediaSetId;
	private Long mediaFileId;
	private Long sourceMediaId;
	private String imageName;
	private String imageType;
	private String imageSize;
	private Long sizeX;
	private Long sizeY;
	private Long pixelNum;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeMediaFile mediaFile;
	private NodeMediaBlob mediaBlob;
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public Long getSourceMediaId() {
		return sourceMediaId;
	}
	public void setSourceMediaId(Long sourceMediaId) {
		this.sourceMediaId = sourceMediaId;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getImageSize() {
		return imageSize;
	}
	public void setImageSize(String imageSize) {
		this.imageSize = imageSize;
	}
	public Long getSizeX() {
		return sizeX;
	}
	public void setSizeX(Long sizeX) {
		this.sizeX = sizeX;
	}
	public Long getSizeY() {
		return sizeY;
	}
	public void setSizeY(Long sizeY) {
		this.sizeY = sizeY;
	}
	public Long getPixelNum() {
		return pixelNum;
	}
	public void setPixelNum(Long pixelNum) {
		this.pixelNum = pixelNum;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Long getMediaFileId() {
		return mediaFileId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public NodeMediaFile getMediaFile() {
		return mediaFile;
	}
	public void setMediaFile(NodeMediaFile mediaFile) {
		this.mediaFile = mediaFile;
	}
	public NodeMediaBlob getMediaBlob() {
		return mediaBlob;
	}
	public void setMediaBlob(NodeMediaBlob mediaBlob) {
		this.mediaBlob = mediaBlob;
	}
}
