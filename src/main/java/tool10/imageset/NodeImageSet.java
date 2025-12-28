package tool10.imageset;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
public class NodeImageSet {

	public NodeImageSet(Long imageSetId, Long fileSetId, String imageSetName, String imageSetDesc, String sourceName,
			String sourceURL, Long cntImage, Long sumImageSize, Double avgImageSize, Long sourceFileSize,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.imageSetId = imageSetId;
		this.fileSetId = fileSetId;
		this.imageSetName = imageSetName;
		this.imageSetDesc = imageSetDesc;
		this.sourceName = sourceName;
		this.sourceURL = sourceURL;
		this.cntImage = cntImage;
		this.sumImageSize = sumImageSize;
		this.avgImageSize = avgImageSize;
		this.sourceFileSize = sourceFileSize;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		
		this.listImage = new  ArrayList<NodeImage>();
		this.listImageFile = new  ArrayList<NodeImageFile>();
		this.listImageBlob = new  ArrayList<NodeImageBlob>();
		this.mapId2Image = new HashMap<Long,NodeImage>();
		this.mapId2ImageFile = new HashMap<Long,NodeImageFile>();
		this.mapId2ImageBlob =  new HashMap<Long,NodeImageBlob>();
		
		this.mapPath2ImageFile = new HashMap<String,NodeImageFile>();
	}
	private Long imageSetId;
	private Long fileSetId;
	private String imageSetName;
	private String imageSetDesc;
	private String sourceName;
	private String sourceURL;
	private Long cntImage;
	private Long sumImageSize;
	private Double avgImageSize;
	private Long sourceFileSize;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeImage> listImage;
	private ArrayList<NodeImageFile> listImageFile;
	private ArrayList<NodeImageBlob> listImageBlob;
	
	private HashMap<Long,NodeImage> mapId2Image;
	private HashMap<Long,NodeImageFile> mapId2ImageFile;
	private HashMap<Long,NodeImageBlob> mapId2ImageBlob;
	
	private HashMap<String,NodeImageFile> mapPath2ImageFile;
	
	public Long getImageSetId() {
		return imageSetId;
	}
	public void setImageSetId(Long imageSetId) {
		this.imageSetId = imageSetId;
	}
	public String getImageSetName() {
		return imageSetName;
	}
	public void setImageSetName(String imageSetName) {
		this.imageSetName = imageSetName;
	}
	public String getImageSetDesc() {
		return imageSetDesc;
	}
	public void setImageSetDesc(String imageSetDesc) {
		this.imageSetDesc = imageSetDesc;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceURL() {
		return sourceURL;
	}
	public void setSourceURL(String sourceURL) {
		this.sourceURL = sourceURL;
	}
	public Long getCntImage() {
		return cntImage;
	}
	public void setCntImage(Long cntImage) {
		this.cntImage = cntImage;
	}
	public Long getSumImageSize() {
		return sumImageSize;
	}
	public void setSumImageSize(Long sumImageSize) {
		this.sumImageSize = sumImageSize;
	}
	public Double getAvgImageSize() {
		return avgImageSize;
	}
	public void setAvgImageSize(Double avgImageSize) {
		this.avgImageSize = avgImageSize;
	}
	public Long getSourceFileSize() {
		return sourceFileSize;
	}
	public void setSourceFileSize(Long sourceFileSize) {
		this.sourceFileSize = sourceFileSize;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ArrayList<NodeImage> getListImage() {
		return listImage;
	}
	public void setListImage(ArrayList<NodeImage> listImage) {
		this.listImage = listImage;
	}
	public ArrayList<NodeImageFile> getListImageFile() {
		return listImageFile;
	}
	public void setListImageFile(ArrayList<NodeImageFile> listImageFile) {
		this.listImageFile = listImageFile;
	}
	public ArrayList<NodeImageBlob> getListImageBlob() {
		return listImageBlob;
	}
	public void setListImageBlob(ArrayList<NodeImageBlob> listImageBlob) {
		this.listImageBlob = listImageBlob;
	}
	public HashMap<Long, NodeImage> getMapId2Image() {
		return mapId2Image;
	}
	public void setMapId2Image(HashMap<Long, NodeImage> mapId2Image) {
		this.mapId2Image = mapId2Image;
	}
	public HashMap<Long, NodeImageFile> getMapId2ImageFile() {
		return mapId2ImageFile;
	}
	public void setMapId2ImageFile(HashMap<Long, NodeImageFile> mapId2ImageFile) {
		this.mapId2ImageFile = mapId2ImageFile;
	}
	public HashMap<Long, NodeImageBlob> getMapId2ImageBlob() {
		return mapId2ImageBlob;
	}
	public void setMapId2ImageBlob(HashMap<Long, NodeImageBlob> mapId2ImageBlob) {
		this.mapId2ImageBlob = mapId2ImageBlob;
	}
	public HashMap<String, NodeImageFile> getMapPath2ImageFile() {
		return mapPath2ImageFile;
	}
	public void setMapPath2ImageFile(HashMap<String, NodeImageFile> mapPath2ImageFile) {
		this.mapPath2ImageFile = mapPath2ImageFile;
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
	
	
}
