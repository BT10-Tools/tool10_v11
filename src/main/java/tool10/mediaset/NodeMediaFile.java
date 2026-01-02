package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeMediaFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeMediaFile(Long mediaFileId, Long mediaId, Long fileId, Long mediaSetId, String mediaFileType, String sourceAbsolutePath, String sourceDirName, 
			String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.mediaFileId = mediaFileId;
		this.mediaId = mediaId;
		this.fileId = fileId;
		this.mediaSetId = mediaSetId;
		this.mediaFileType = mediaFileType;
		this.sourceAbsolutePath = sourceAbsolutePath;
		this.sourceDirName = sourceDirName;
		this.sourceFileName = sourceFileName;
		this.sourceExtensionName = sourceExtensionName;
		this.sourceFileSize = sourceFileSize;
		this.sourceFileCreationDate = sourceFileCreationDate;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	
	private Long mediaFileId;
	private Long mediaId;  //imageId, videoId, audioId
	private Long fileId;
	private Long mediaSetId;
	private String mediaFileType;
	private String sourceAbsolutePath;
	private String sourceDirName;
	private String sourceFileName;
	private String sourceExtensionName;
	private Long sourceFileSize;
	private ZonedDateTime sourceFileCreationDate;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public Long getMediaFileId() {
		return mediaFileId;
	}
	public void setMediaFileId(Long mediaFileId) {
		this.mediaFileId = mediaFileId;
	}
	public Long getMediaId() {
		return mediaId;
	}
	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public void setImageSetId(Long mediaSetId) {
		this.mediaSetId = mediaSetId;
	}
	public String getSourceDirName() {
		return sourceDirName;
	}
	public void setSourceDirName(String sourceDirName) {
		this.sourceDirName = sourceDirName;
	}
	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	public String getSourceExtensionName() {
		return sourceExtensionName;
	}
	public void setSourceExtensionName(String sourceExtensionName) {
		this.sourceExtensionName = sourceExtensionName;
	}
	public Long getSourceFileSize() {
		return sourceFileSize;
	}
	public void setSourceFileSize(Long sourceFileSize) {
		this.sourceFileSize = sourceFileSize;
	}
	public ZonedDateTime getSourceFileCreationDate() {
		return sourceFileCreationDate;
	}
	public void setSourceFileCreationDate(ZonedDateTime sourceFileCreationDate) {
		this.sourceFileCreationDate = sourceFileCreationDate;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public String getSourceAbsolutePath() {
		return sourceAbsolutePath;
	}
	public void setSourceAbsolutePath(String sourceAbsolutePath) {
		this.sourceAbsolutePath = sourceAbsolutePath;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getMediaFileType() {
		return mediaFileType;
	}
	public void setMediaFileType(String mediaFileType) {
		this.mediaFileType = mediaFileType;
	}
}
