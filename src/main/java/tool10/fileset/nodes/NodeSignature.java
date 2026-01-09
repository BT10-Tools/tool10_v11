package tool10.fileset.nodes;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeSignature  implements Serializable {

	public NodeSignature(Long signatureId, Long signatureClassId, String signatureName, String signatureDesc,
			byte[] signatureByte, String signatureHex, Long offset, String extension, String[] extensionArray,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.signatureId = signatureId;
		this.signatureClassId = signatureClassId;
		this.signatureName = signatureName;
		this.signatureDesc = signatureDesc;
		this.signatureByte = signatureByte;
		this.signatureHex = signatureHex;
		this.offset = offset;
		this.extension = extension;
		this.extensionArray = extensionArray;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long signatureId;
	private Long signatureClassId;
	private String signatureName;
	private String signatureDesc;
	private byte[] signatureByte;
	private String signatureHex;
	private Long offset;
	private String extension;
	private String[] extensionArray;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getSignatureId() {
		return signatureId;
	}
	public Long getSignatureClassId() {
		return signatureClassId;
	}
	public String getSignatureName() {
		return signatureName;
	}
	public String getSignatureDesc() {
		return signatureDesc;
	}
	public byte[] getSignatureByte() {
		return signatureByte;
	}
	public String getSignatureHex() {
		return signatureHex;
	}
	public Long getOffset() {
		return offset;
	}
	public String getExtension() {
		return extension;
	}
	public String[] getExtensionArray() {
		return extensionArray;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	
	
}
