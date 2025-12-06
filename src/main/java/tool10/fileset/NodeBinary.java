package tool10.fileset;

import java.io.Serializable;

public class NodeBinary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeBinary() {
		super();
		this.byteLength = 0l;
		this.byteArray = null;
	}
	public NodeBinary(Long byteLength, byte[] byteArray) {
		super();
		this.byteLength = byteLength;
		this.byteArray = byteArray;
	}
	
	public NodeBinary(Long byteLength, Long crc64, byte[] byteArray) {
		super();
		this.byteLength = byteLength;
		this.crc64 = crc64;
		this.byteArray = byteArray;
	}
	
	private Long byteLength;
	private Long crc64;
	private byte[] byteArray;

	public byte[] getByteArray() {
		return byteArray;
	}
	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
	public Long getByteLength() {
		return byteLength;
	}
	public void setByteLength(Long byteLength) {
		this.byteLength = byteLength;
	}

	public Long getCrc64() {
		return crc64;
	}

	public void setCrc64(Long crc64) {
		this.crc64 = crc64;
	}
		
}
