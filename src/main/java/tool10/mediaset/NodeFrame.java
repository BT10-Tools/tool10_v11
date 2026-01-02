package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeFrame implements Serializable  {

	public NodeFrame(Long frameId, Long videoId, Long mediaSetId, Long imageId, Long firstFrameId, Long nextFrameId,
			Long previousFrameId, String frameName, String frameDesc, String frameGroupName, String frameType,
			String sectionName, Long frameSize, Long numFrame, Long cntFrame, Long startMs, Long endMs,
			Long durationMs, Double similarityRatioPrevious, Double similarityRatioNext, Long subtitleLineNum,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.frameId = frameId;
		this.videoId = videoId;
		this.mediaSetId = mediaSetId;
		this.imageId = imageId;
		this.firstFrameId = firstFrameId;
		this.nextFrameId = nextFrameId;
		this.previousFrameId = previousFrameId;
		this.frameName = frameName;
		this.frameDesc = frameDesc;
		this.frameGroupName = frameGroupName;
		this.frameType = frameType;
		this.sectionName = sectionName;
		this.frameSize = frameSize;
		this.numFrame = numFrame;
		this.cntFrame = cntFrame;
		this.startMs = startMs;
		this.endMs = endMs;
		this.durationMs = durationMs;
		this.similarityRatioPrevious = similarityRatioPrevious;
		this.similarityRatioNext = similarityRatioNext;
		this.subtitleLineNum = subtitleLineNum;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long frameId;
	private Long videoId;
	private Long mediaSetId;
	private Long imageId;
	private Long firstFrameId; 
	private Long nextFrameId; 
	private Long previousFrameId;
	private String frameName;
	private String frameDesc;
	private String frameGroupName;
	private String frameType;
	private String sectionName;
	private Long frameSize;
	private Long numFrame;
	private Long cntFrame;
	private Long startMs;
	private Long endMs;
	private Long durationMs;  //miliseconds
	private Double similarityRatioPrevious;
	private Double similarityRatioNext;
	private Long subtitleLineNum; 
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeImage image;
	private NodeMediaBlob frameBlob;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getFrameId() {
		return frameId;
	}
	public Long getVideoId() {
		return videoId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public Long getImageId() {
		return imageId;
	}
	public Long getFirstFrameId() {
		return firstFrameId;
	}
	public Long getNextFrameId() {
		return nextFrameId;
	}
	public Long getPreviousFrameId() {
		return previousFrameId;
	}
	public String getFrameName() {
		return frameName;
	}
	public String getFrameDesc() {
		return frameDesc;
	}
	public String getFrameGroupName() {
		return frameGroupName;
	}
	public String getFrameType() {
		return frameType;
	}
	public Long getFrameSize() {
		return frameSize;
	}
	public String getSectionName() {
		return sectionName;
	}
	public Long getNumFrame() {
		return numFrame;
	}
	public Long getCntFrame() {
		return cntFrame;
	}
	public Long getStartMs() {
		return startMs;
	}
	public Long getEndMs() {
		return endMs;
	}
	public Long getDurationMs() {
		return durationMs;
	}
	public Double getSimilarityRatioPrevious() {
		return similarityRatioPrevious;
	}
	public Double getSimilarityRatioNext() {
		return similarityRatioNext;
	}
	public Long getSubtitleLineNum() {
		return subtitleLineNum;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public NodeImage getImage() {
		return image;
	}
	public NodeMediaBlob getFrameBlob() {
		return frameBlob;
	}
	public void setMediaSetId(Long mediaSetId) {
		this.mediaSetId = mediaSetId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public void setFirstFrameId(Long firstFrameId) {
		this.firstFrameId = firstFrameId;
	}
	public void setNextFrameId(Long nextFrameId) {
		this.nextFrameId = nextFrameId;
	}
	public void setPreviousFrameId(Long previousFrameId) {
		this.previousFrameId = previousFrameId;
	}
	public void setFrameGroupName(String frameGroupName) {
		this.frameGroupName = frameGroupName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public void setNumFrame(Long numFrame) {
		this.numFrame = numFrame;
	}
	public void setCntFrame(Long cntFrame) {
		this.cntFrame = cntFrame;
	}
	public void setStartMs(Long startMs) {
		this.startMs = startMs;
	}
	public void setEndMs(Long endMs) {
		this.endMs = endMs;
	}
	public void setDurationMs(Long durationMs) {
		this.durationMs = durationMs;
	}
	public void setSimilarityRatioPrevious(Double similarityRatioPrevious) {
		this.similarityRatioPrevious = similarityRatioPrevious;
	}
	public void setSimilarityRatioNext(Double similarityRatioNext) {
		this.similarityRatioNext = similarityRatioNext;
	}
	public void setSubtitleLineNum(Long subtitleLineNum) {
		this.subtitleLineNum = subtitleLineNum;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public void setImage(NodeImage image) {
		this.image = image;
	}
	
}
