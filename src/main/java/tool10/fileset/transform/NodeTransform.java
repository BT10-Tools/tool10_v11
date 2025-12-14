package tool10.fileset.transform;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.fileset.nodes.NodeFile;

public class NodeTransform implements Serializable {
	
	public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
			Long transformedFileId, String transformType, String extensionType, String algorithmName,
			String transformRemark, String tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.transformId = transformId;
		this.fileSetId = fileSetId;
		this.transformFileId = transformFileId;
		this.transformFileSetId = transformFileSetId;
		this.transformedFileId = transformedFileId;
		this.transformType = transformType;
		this.extensionType = extensionType;
		this.algorithmName = algorithmName;
		this.transformRemark = transformRemark;
		this.tmpFileName = tmpFileName;
		this.cntFile = cntFile;
		this.originalFileSize = originalFileSize;
		this.transformedFileSize = transformedFileSize;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		
		initializeListsAndMaps();
	}

	private void initializeListsAndMaps()	{ 
		this.listFile = new ArrayList<NodeFile>();
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private Long transformId;
	private Long fileSetId;
	private Long transformFileId;
	private Long transformFileSetId;
	private Long transformedFileId;  //there is only file most of the time
	private String transformType; //recursive, file, directory
	private String extensionType; //zip, rar, 7z
	private String algorithmName; 
	private String transformRemark;
	private String tmpFileName;
	
	private Long cntFile; 
	private Long originalFileSize;
	private Long transformedFileSize;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeFile> listFile;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getTransformId() {
		return transformId;
	}

	public Long getFileSetId() {
		return fileSetId;
	}

	public Long getTransformFileId() {
		return transformFileId;
	}

	public Long getTransformFileSetId() {
		return transformFileSetId;
	}

	public Long getTransformedFileId() {
		return transformedFileId;
	}

	public String getTransformType() {
		return transformType;
	}

	public String getExtensionType() {
		return extensionType;
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public String getTransformRemark() {
		return transformRemark;
	}

	public Long getCntFile() {
		return cntFile;
	}

	public Long getOriginalFileSize() {
		return originalFileSize;
	}

	public Long getTransformedFileSize() {
		return transformedFileSize;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}

	public ArrayList<NodeFile> getListFile() {
		return listFile;
	}

	public void setTransformRemark(String transformRemark) {
		this.transformRemark = transformRemark;
	}

	public void setCntFile(Long cntFile) {
		this.cntFile = cntFile;
	}

	public void setTransformedFileSize(Long transformedFileSize) {
		this.transformedFileSize = transformedFileSize;
	}

	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getTmpFileName() {
		return tmpFileName;
	}

	public void setTmpFileName(String tmpFileName) {
		this.tmpFileName = tmpFileName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setTransformedFileId(Long transformedFileId) {
		this.transformedFileId = transformedFileId;
	}
		
}
