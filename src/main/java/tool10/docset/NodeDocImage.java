package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeDocImage  implements Serializable {
	
	public NodeDocImage(Long docImageId, Long docId, Long docSetId, Long imageId, Long imageSetId,
			String imageAbsolutePath, Long displayOrder, Long pageNum, Double locX, Double locY, Double sizeX,
			Double sizeY, String imageCaption, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.docImageId = docImageId;
		this.docId = docId;
		this.docSetId = docSetId;
		this.imageId = imageId;
		this.imageSetId = imageSetId;
		this.imageAbsolutePath = imageAbsolutePath;
		this.displayOrder = displayOrder;
		this.pageNum = pageNum;
		this.locX = locX;
		this.locY = locY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.imageCaption = imageCaption;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long docImageId;
	private Long docId;
	private Long docSetId;
	private Long imageId;
	private Long imageSetId;
	private String imageAbsolutePath;
	private Long displayOrder;
	private Long pageNum;
	private Double locX;
	private Double locY;
	private Double sizeX;
	private Double sizeY;
	private String imageCaption;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getDocImageId() {
		return docImageId;
	}
	public Long getDocId() {
		return docId;
	}
	public Long getDocSetId() {
		return docSetId;
	}
	public Long getImageId() {
		return imageId;
	}
	public Long getImageSetId() {
		return imageSetId;
	}
	public String getImageAbsolutePath() {
		return imageAbsolutePath;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public Long getPageNum() {
		return pageNum;
	}
	public Double getLocX() {
		return locX;
	}
	public Double getLocY() {
		return locY;
	}
	public Double getSizeX() {
		return sizeX;
	}
	public Double getSizeY() {
		return sizeY;
	}
	public String getImageCaption() {
		return imageCaption;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	
}
