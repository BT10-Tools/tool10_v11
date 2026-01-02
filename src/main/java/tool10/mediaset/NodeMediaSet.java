package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeMediaSet  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeMediaSet(Long mediaSetId, Long fileSetId, String mediaSetName, String mediaSetDesc, String sourceName,
			String sourceURL, Long cntMedia, Long sumMediaSize, Double avgMediaSize, Long sourceFileSize,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.mediaSetId = mediaSetId;
		this.fileSetId = fileSetId;
		this.mediaSetName = mediaSetName;
		this.mediaSetDesc = mediaSetDesc;
		this.sourceName = sourceName;
		this.sourceURL = sourceURL;
		this.cntMedia = cntMedia;
		this.sumMediaSize = sumMediaSize;
		this.avgMediaSize = avgMediaSize;
		this.sourceFileSize = sourceFileSize;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		
		initializeListsAndMaps();
	}
	private void initializeListsAndMaps()	{ 
		this.listImage = new  ArrayList<NodeImage>();
		this.listMediaFile = new  ArrayList<NodeMediaFile>();
		this.listMediaBlob = new  ArrayList<NodeMediaBlob>();
		this.listVideo = new  ArrayList<NodeVideo>();
		this.listFrame = new  ArrayList<NodeFrame>();
		this.listAudio = new  ArrayList<NodeAudio>();
		
		this.mapId2Image = new HashMap<Long,NodeImage>();
		this.mapId2MediaFile = new HashMap<Long,NodeMediaFile>();
		this.mapId2MediaBlob =  new HashMap<Long,NodeMediaBlob>();
		this.mapId2Video = new HashMap<Long,NodeVideo>();
		this.mapId2Frame = new HashMap<Long,NodeFrame>();
		this.mapId2Audio = new HashMap<Long,NodeAudio>();
		
		this.mapPath2MediaFile = new HashMap<String,NodeMediaFile>();
	}
	private Long mediaSetId;
	private Long fileSetId;
	private String mediaSetName;
	private String mediaSetDesc;
	private String sourceName;
	private String sourceURL;
	private Long cntMedia;
	private Long sumMediaSize;
	private Double avgMediaSize;
	private Long sourceFileSize;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeImage> listImage;
	private ArrayList<NodeMediaFile> listMediaFile;
	private ArrayList<NodeMediaBlob> listMediaBlob;
	private ArrayList<NodeVideo> listVideo;
	private ArrayList<NodeFrame> listFrame;
	private ArrayList<NodeAudio> listAudio;
	
	private HashMap<Long,NodeImage> mapId2Image;
	private HashMap<Long,NodeMediaFile> mapId2MediaFile;
	private HashMap<Long,NodeMediaBlob> mapId2MediaBlob;
	private HashMap<Long,NodeVideo> mapId2Video;
	private HashMap<Long,NodeFrame> mapId2Frame;
	private HashMap<Long,NodeAudio> mapId2Audio;
	
	private HashMap<String,NodeMediaFile> mapPath2MediaFile;
	
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public void setMediaSetId(Long mediaSetId) {
		this.mediaSetId = mediaSetId;
	}
	public String getMediaSetName() {
		return mediaSetName;
	}
	public void setMediaSetName(String mediaSetName) {
		this.mediaSetName = mediaSetName;
	}
	public String getMediaSetDesc() {
		return mediaSetDesc;
	}
	public void setMediaSetDesc(String mediaSetDesc) {
		this.mediaSetDesc = mediaSetDesc;
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
	public Long getCntMedia() {
		return cntMedia;
	}
	public void setCntMedia(Long cntMedia) {
		this.cntMedia = cntMedia;
	}
	public Long getSumMediaSize() {
		return sumMediaSize;
	}
	public void setSumMediaSize(Long sumMediaSize) {
		this.sumMediaSize = sumMediaSize;
	}
	public Double getAvgMediaSize() {
		return avgMediaSize;
	}
	public void setAvgMediaSize(Double avgMediaSize) {
		this.avgMediaSize = avgMediaSize;
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
	public ArrayList<NodeMediaFile> getListMediaFile() {
		return listMediaFile;
	}
	public void setListMediaFile(ArrayList<NodeMediaFile> listMediaFile) {
		this.listMediaFile = listMediaFile;
	}
	public ArrayList<NodeMediaBlob> getListMediaBlob() {
		return listMediaBlob;
	}
	public void setListMediaBlob(ArrayList<NodeMediaBlob> listMediaBlob) {
		this.listMediaBlob = listMediaBlob;
	}
	public HashMap<Long, NodeImage> getMapId2Image() {
		return mapId2Image;
	}
	public void setMapId2Image(HashMap<Long, NodeImage> mapId2Image) {
		this.mapId2Image = mapId2Image;
	}
	public HashMap<Long, NodeMediaFile> getMapId2MediaFile() {
		return mapId2MediaFile;
	}
	public void setMapId2MediaFile(HashMap<Long, NodeMediaFile> mapId2MediaFile) {
		this.mapId2MediaFile = mapId2MediaFile;
	}
	public HashMap<Long, NodeMediaBlob> getMapId2MediaBlob() {
		return mapId2MediaBlob;
	}
	public void setMapId2MediaBlob(HashMap<Long, NodeMediaBlob> mapId2MediaBlob) {
		this.mapId2MediaBlob = mapId2MediaBlob;
	}
	public HashMap<String, NodeMediaFile> getMapPath2MediaFile() {
		return mapPath2MediaFile;
	}
	public void setMapPath2MediaFile(HashMap<String, NodeMediaFile> mapPath2MediaFile) {
		this.mapPath2MediaFile = mapPath2MediaFile;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<NodeVideo> getListVideo() {
		return listVideo;
	}
	public ArrayList<NodeFrame> getListFrame() {
		return listFrame;
	}
	public ArrayList<NodeAudio> getListAudio() {
		return listAudio;
	}
	public HashMap<Long, NodeVideo> getMapId2Video() {
		return mapId2Video;
	}
	public HashMap<Long, NodeFrame> getMapId2Frame() {
		return mapId2Frame;
	}
	public HashMap<Long, NodeAudio> getMapId2Audio() {
		return mapId2Audio;
	}
	
	
}
