package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeAudio implements Serializable  {

	public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long videoId,
			Long rootAudioId, Long nextAudioId, Long previousAudioId, Long defaultSubtitleId, Long lyricsId,
			String audioName, String audioDesc, String audioGroupName, String audioType, 
			String contentType, String artistName, String albumName, String songName, Long audioSize, Long durationMs,
			Double bitRateBPS, Double dataRateBPS, Double sampleRateKHZ, Long cntChannel, Long cntSection,
			String audioQuality, String audioCompression, String audioFormat, String audioEncoding,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.audioId = audioId;
		this.mediaSetId = mediaSetId;
		this.mediaFileId = mediaFileId;
		this.sourceMediaId = sourceMediaId;
		this.videoId = videoId;
		this.rootAudioId = rootAudioId;
		this.nextAudioId = nextAudioId;
		this.previousAudioId = previousAudioId;
		this.defaultSubtitleId = defaultSubtitleId;
		this.lyricsId = lyricsId;
		this.audioName = audioName;
		this.audioDesc = audioDesc;
		this.audioGroupName = audioGroupName;
		this.audioType = audioType;
		this.contentType = contentType;
		this.artistName = artistName;
		this.albumName = albumName;
		this.songName = songName;
		this.audioSize = audioSize;
		this.durationMs = durationMs;
		this.bitRateBPS = bitRateBPS;
		this.dataRateBPS = dataRateBPS;
		this.sampleRateKHZ = sampleRateKHZ;
		this.cntChannel = cntChannel;
		this.cntSection = cntSection;
		this.audioQuality = audioQuality;
		this.audioCompression = audioCompression;
		this.audioFormat = audioFormat;
		this.audioEncoding = audioEncoding;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long videoId,
			String audioName, String audioDesc, String audioGroupName, String audioType, 
			String contentType, Long audioSize, Long durationMs, ZonedDateTime creationDate) {
		super();
		this.audioId = audioId;
		this.mediaSetId = mediaSetId;
		this.mediaFileId = mediaFileId;
		this.sourceMediaId = sourceMediaId;
		this.videoId = videoId;
		this.audioName = audioName;
		this.audioDesc = audioDesc;
		this.audioGroupName = audioGroupName;
		this.audioType = audioType;
		this.contentType = contentType;
		this.audioSize = audioSize;
		this.durationMs = durationMs;
		this.creationDate = creationDate;
	}
	private Long audioId;
	private Long mediaSetId;
	private Long mediaFileId;
	private Long sourceMediaId;
	private Long videoId;
	private Long rootAudioId; 
	private Long nextAudioId; 
	private Long previousAudioId; 
	private Long defaultSubtitleId;
	private Long lyricsId;
	private String audioName;
	private String audioDesc;
	private String audioGroupName;
	private String audioType;
	private String contentType;
	private String artistName;
	private String albumName;
	private String songName;
	private Long audioSize;
	private Long durationMs;
	private Double bitRateBPS;
	private Double dataRateBPS;
	private Double sampleRateKHZ;
	private Long cntChannel;
	private Long cntSection;
	private String audioQuality;
	private String audioCompression;
	private String audioFormat;
	private String audioEncoding;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private NodeMediaFile imageFile;
	private NodeMediaBlob audioBlob;

	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getAudioId() {
		return audioId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public Long getMediaFileId() {
		return mediaFileId;
	}
	public Long getSourceMediaId() {
		return sourceMediaId;
	}
	public Long getVideoId() {
		return videoId;
	}
	public Long getRootAudioId() {
		return rootAudioId;
	}
	public Long getNextAudioId() {
		return nextAudioId;
	}
	public Long getPreviousAudioId() {
		return previousAudioId;
	}
	public Long getDefaultSubtitleId() {
		return defaultSubtitleId;
	}
	public Long getLyricsId() {
		return lyricsId;
	}
	public String getAudioName() {
		return audioName;
	}
	public String getAudioDesc() {
		return audioDesc;
	}
	public String getAudioGroupName() {
		return audioGroupName;
	}
	public String getAudioType() {
		return audioType;
	}
	public Long getAudioSize() {
		return audioSize;
	}
	public String getContentType() {
		return contentType;
	}
	public String getArtistName() {
		return artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public String getSongName() {
		return songName;
	}
	public Long getDurationMs() {
		return durationMs;
	}
	public Double getBitRateBPS() {
		return bitRateBPS;
	}
	public Double getDataRateBPS() {
		return dataRateBPS;
	}
	public Double getSampleRateKHZ() {
		return sampleRateKHZ;
	}
	public Long getCntChannel() {
		return cntChannel;
	}
	public Long getCntSection() {
		return cntSection;
	}
	public String getAudioQuality() {
		return audioQuality;
	}
	public String getAudioCompression() {
		return audioCompression;
	}
	public String getAudioFormat() {
		return audioFormat;
	}
	public String getAudioEncoding() {
		return audioEncoding;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public NodeMediaFile getImageFile() {
		return imageFile;
	}
	public NodeMediaBlob getAudioBlob() {
		return audioBlob;
	}
	public void setAudioId(Long audioId) {
		this.audioId = audioId;
	}
	public void setMediaSetId(Long mediaSetId) {
		this.mediaSetId = mediaSetId;
	}
	public void setMediaFileId(Long mediaFileId) {
		this.mediaFileId = mediaFileId;
	}
	public void setSourceMediaId(Long sourceMediaId) {
		this.sourceMediaId = sourceMediaId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	public void setRootAudioId(Long rootAudioId) {
		this.rootAudioId = rootAudioId;
	}
	public void setNextAudioId(Long nextAudioId) {
		this.nextAudioId = nextAudioId;
	}
	public void setPreviousAudioId(Long previousAudioId) {
		this.previousAudioId = previousAudioId;
	}
	public void setDefaultSubtitleId(Long defaultSubtitleId) {
		this.defaultSubtitleId = defaultSubtitleId;
	}
	public void setLyricsId(Long lyricsId) {
		this.lyricsId = lyricsId;
	}
	public void setAudioName(String audioName) {
		this.audioName = audioName;
	}
	public void setAudioDesc(String audioDesc) {
		this.audioDesc = audioDesc;
	}
	public void setAudioGroupName(String audioGroupName) {
		this.audioGroupName = audioGroupName;
	}
	public void setAudioType(String audioType) {
		this.audioType = audioType;
	}
	public void setAudioSize(Long audioSize) {
		this.audioSize = audioSize;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public void setDurationMs(Long durationMs) {
		this.durationMs = durationMs;
	}
	public void setBitRateBPS(Double bitRateBPS) {
		this.bitRateBPS = bitRateBPS;
	}
	public void setDataRateBPS(Double dataRateBPS) {
		this.dataRateBPS = dataRateBPS;
	}
	public void setSampleRateKHZ(Double sampleRateKHZ) {
		this.sampleRateKHZ = sampleRateKHZ;
	}
	public void setCntChannel(Long cntChannel) {
		this.cntChannel = cntChannel;
	}
	public void setCntSection(Long cntSection) {
		this.cntSection = cntSection;
	}
	public void setAudioQuality(String audioQuality) {
		this.audioQuality = audioQuality;
	}
	public void setAudioCompression(String audioCompression) {
		this.audioCompression = audioCompression;
	}
	public void setAudioFormat(String audioFormat) {
		this.audioFormat = audioFormat;
	}
	public void setAudioEncoding(String audioEncoding) {
		this.audioEncoding = audioEncoding;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public void setImageFile(NodeMediaFile imageFile) {
		this.imageFile = imageFile;
	}
	public void setAudioBlob(NodeMediaBlob audioBlob) {
		this.audioBlob = audioBlob;
	}
	
}
