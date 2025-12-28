package tool10.tagset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class NodeTagFile implements Serializable {


	public NodeTagFile(Long tagFileId, Long tagSetId, Long tagFileTypeId, Long sourceId, String sourceAbsolutePath,
			String sourceDirName, String sourceFileName, String sourceExtensionName, Long sourceFileSize,
			ZonedDateTime sourceFileCreationDate, ZonedDateTime sourceFileModificationDate, ZonedDateTime creationDate) {
		super();
		this.tagFileId = tagFileId;
		this.tagSetId = tagSetId;
		this.tagFileTypeId = tagFileTypeId;
		this.sourceId = sourceId;
		this.sourceAbsolutePath = sourceAbsolutePath;
		this.sourceDirName = sourceDirName;
		this.sourceFileName = sourceFileName;
		this.sourceExtensionName = sourceExtensionName;
		this.sourceFileSize = sourceFileSize;
		this.sourceFileCreationDate = sourceFileCreationDate;
		this.sourceFileModificationDate = sourceFileModificationDate;
		this.creationDate = creationDate;
		this.listTag = new ArrayList<NodeTag>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tagFileId;
	private Long tagSetId;
	private Long tagFileTypeId;
	private Long sourceId;
	private String sourceAbsolutePath;
	private String sourceDirName;
	private String sourceFileName;
	private String sourceExtensionName;
	private Long sourceFileSize;
	private ZonedDateTime sourceFileCreationDate;
	private ZonedDateTime sourceFileModificationDate;
	private ZonedDateTime creationDate;
	
	private ArrayList<NodeTag> listTag;

	public Long getTagFileId() {
		return tagFileId;
	}

	public void setTagFileId(Long tagFileId) {
		this.tagFileId = tagFileId;
	}

	public Long getTagSetId() {
		return tagSetId;
	}

	public void setTagSetId(Long tagSetId) {
		this.tagSetId = tagSetId;
	}

	public Long getTagFileTypeId() {
		return tagFileTypeId;
	}

	public void setTagFileTypeId(Long tagFileTypeId) {
		this.tagFileTypeId = tagFileTypeId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceAbsolutePath() {
		return sourceAbsolutePath;
	}

	public void setSourceAbsolutePath(String sourceAbsolutePath) {
		this.sourceAbsolutePath = sourceAbsolutePath;
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

	public ZonedDateTime getSourceFileModificationDate() {
		return sourceFileModificationDate;
	}

	public void setSourceFileModificationDate(ZonedDateTime sourceFileModificationDate) {
		this.sourceFileModificationDate = sourceFileModificationDate;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public ArrayList<NodeTag> getListTag() {
		return listTag;
	}

	public void setListTag(ArrayList<NodeTag> listTag) {
		this.listTag = listTag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	}
