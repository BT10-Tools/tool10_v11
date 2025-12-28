package tool10.imageset;

import java.time.ZonedDateTime;

public class NodeImage {

	public NodeImage(Long imageId, Long imageSetId, Long imageFileId, Long sourceImageId, String imageName, String imageType, String imageSizeType,
			Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.imageId = imageId;
		this.imageSetId = imageSetId;
		this.imageFileId = imageFileId;
		this.sourceImageId = sourceImageId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageSizeType = imageSizeType;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.pixelNum = pixelNum;
		this.creationDate = creationDate;
	    this.modificationDate = modificationDate;
	}
	private Long imageId;
	private Long imageSetId;
	private Long imageFileId;
	private Long sourceImageId;
	private String imageName;
	private String imageType;
	private String imageSizeType;
	private Long sizeX;
	private Long sizeY;
	private Long pixelNum;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeImageFile imageFile;
	private NodeImageBlob imageBlob;
	
	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getImageSetId() {
		return imageSetId;
	}
	public void setImageSetId(Long imageSetId) {
		this.imageSetId = imageSetId;
	}
	public Long getSourceImageId() {
		return sourceImageId;
	}
	public void setSourceImageId(Long sourceImageId) {
		this.sourceImageId = sourceImageId;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getImageSizeType() {
		return imageSizeType;
	}
	public void setImageSizeType(String imageSizeType) {
		this.imageSizeType = imageSizeType;
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
	public Long getImageFileId() {
		return imageFileId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public NodeImageFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(NodeImageFile imageFile) {
		this.imageFile = imageFile;
	}
	public NodeImageBlob getImageBlob() {
		return imageBlob;
	}
	public void setImageBlob(NodeImageBlob imageBlob) {
		this.imageBlob = imageBlob;
	}
}
