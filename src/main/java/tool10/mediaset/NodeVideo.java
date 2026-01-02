package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeVideo implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long rootVideoId,
			Long nextVideoId, Long previousVideoId, Long defaultSubtitleId, String videoName, String videoDesc,
			String videoGroupName, String videoType, String colorModel, Long videoSize, Long sizeX, Long sizeY,
			Long pixelNum, Double aspectRatio, Long durationMs, Double fps, Double dataRateBPS, Long cntFrame,
			Long cntSection, String videoQuality, String videoCompression, String videoFormat, String videoEncoding,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.videoId = videoId;
		this.mediaSetId = mediaSetId;
		this.mediaFileId = mediaFileId;
		this.sourceMediaId = sourceMediaId;
		this.rootVideoId = rootVideoId;
		this.nextVideoId = nextVideoId;
		this.previousVideoId = previousVideoId;
		this.defaultSubtitleId = defaultSubtitleId;
		this.videoName = videoName;
		this.videoDesc = videoDesc;
		this.videoGroupName = videoGroupName;
		this.videoType = videoType;
		this.colorModel = colorModel;
		this.videoSize = videoSize;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.pixelNum = pixelNum;
		this.aspectRatio = aspectRatio;
		this.durationMs = durationMs;
		this.fps = fps;
		this.dataRateBPS = dataRateBPS;
		this.cntFrame = cntFrame;
		this.cntSection = cntSection;
		this.videoQuality = videoQuality;
		this.videoCompression = videoCompression;
		this.videoFormat = videoFormat;
		this.videoEncoding = videoEncoding;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.listFrame = new ArrayList<NodeFrame>();
	}
	public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, String videoName, String videoDesc,
			String videoGroupName, String videoType, Long videoSize, ZonedDateTime creationDate) {
		super();
		this.videoId = videoId;
		this.mediaSetId = mediaSetId;
		this.mediaFileId = mediaFileId;
		this.sourceMediaId = sourceMediaId;
		this.videoName = videoName;
		this.videoDesc = videoDesc;
		this.videoGroupName = videoGroupName;
		this.videoType = videoType;
		this.videoSize = videoSize;
		
		this.creationDate = creationDate;
		this.listFrame = new ArrayList<NodeFrame>();
	}
	private Long videoId;
	private Long mediaSetId;
	private Long mediaFileId;
	private Long sourceMediaId;
	private Long rootVideoId; 
	private Long nextVideoId; 
	private Long previousVideoId; 
	private Long defaultSubtitleId; 
	private String videoName;
	private String videoDesc;
	private String videoGroupName;
	private String videoType;
	private String colorModel;
	private Long videoSize;
	private Long sizeX;
	private Long sizeY;
	private Long pixelNum;
	private Double aspectRatio;
	private Long durationMs;
	private Double fps;
	private Double dataRateBPS;
	private Long cntFrame;
	private Long cntSection;
	private String videoQuality;
	private String videoCompression;
	private String videoFormat;
	private String videoEncoding;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeMediaFile imageFile;
	private NodeMediaBlob videoBlob;
	
	ArrayList<NodeFrame> listFrame;

	//GETTERS AND SETTERS
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public void setMediaSetId(Long mediaSetId) {
		this.mediaSetId = mediaSetId;
	}
	public Long getMediaFileId() {
		return mediaFileId;
	}
	public void setMediaFileId(Long mediaFileId) {
		this.mediaFileId = mediaFileId;
	}
	public Long getSourceMediaId() {
		return sourceMediaId;
	}
	public void setSourceMediaId(Long sourceMediaId) {
		this.sourceMediaId = sourceMediaId;
	}
	public Long getRootVideoId() {
		return rootVideoId;
	}
	public void setRootVideoId(Long rootVideoId) {
		this.rootVideoId = rootVideoId;
	}
	public Long getNextVideoId() {
		return nextVideoId;
	}
	public void setNextVideoId(Long nextVideoId) {
		this.nextVideoId = nextVideoId;
	}
	public Long getPreviousVideoId() {
		return previousVideoId;
	}
	public void setPreviousVideoId(Long previousVideoId) {
		this.previousVideoId = previousVideoId;
	}
	public Long getDefaultSubtitleId() {
		return defaultSubtitleId;
	}
	public void setDefaultSubtitleId(Long defaultSubtitleId) {
		this.defaultSubtitleId = defaultSubtitleId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoDesc() {
		return videoDesc;
	}
	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}
	public String getVideoGroupName() {
		return videoGroupName;
	}
	public void setVideoGroupName(String videoGroupName) {
		this.videoGroupName = videoGroupName;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public Long getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(Long videoSize) {
		this.videoSize = videoSize;
	}
	public String getColorModel() {
		return colorModel;
	}
	public void setColorModel(String colorModel) {
		this.colorModel = colorModel;
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
	public Double getAspectRatio() {
		return aspectRatio;
	}
	public void setAspectRatio(Double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
	public Long getDurationMs() {
		return durationMs;
	}
	public void setDurationMs(Long durationMs) {
		this.durationMs = durationMs;
	}
	public Double getFps() {
		return fps;
	}
	public void setFps(Double fps) {
		this.fps = fps;
	}
	public Double getDataRateBPS() {
		return dataRateBPS;
	}
	public void setDataRateBPS(Double dataRateBPS) {
		this.dataRateBPS = dataRateBPS;
	}
	public Long getCntFrame() {
		return cntFrame;
	}
	public void setCntFrame(Long cntFrame) {
		this.cntFrame = cntFrame;
	}
	public Long getCntSection() {
		return cntSection;
	}
	public void setCntSection(Long cntSection) {
		this.cntSection = cntSection;
	}
	public String getVideoQuality() {
		return videoQuality;
	}
	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}
	public String getVideoCompression() {
		return videoCompression;
	}
	public void setVideoCompression(String videoCompression) {
		this.videoCompression = videoCompression;
	}
	public String getVideoFormat() {
		return videoFormat;
	}
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}
	public String getVideoEncoding() {
		return videoEncoding;
	}
	public void setVideoEncoding(String videoEncoding) {
		this.videoEncoding = videoEncoding;
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
	public NodeMediaFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(NodeMediaFile imageFile) {
		this.imageFile = imageFile;
	}
	public NodeMediaBlob getVideoBlob() {
		return videoBlob;
	}
	public void setVideoBlob(NodeMediaBlob videoBlob) {
		this.videoBlob = videoBlob;
	}
	public ArrayList<NodeFrame> getListFrame() {
		return listFrame;
	}
	public void setListFrame(ArrayList<NodeFrame> listFrame) {
		this.listFrame = listFrame;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
