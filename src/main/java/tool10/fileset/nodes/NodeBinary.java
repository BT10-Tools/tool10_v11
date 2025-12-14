package tool10.fileset.nodes;

import java.io.Serializable;

import tool10.util.ByteUtil;

public class NodeBinary implements Serializable, Comparable<NodeBinary> {

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
	
	@Override
	public int compareTo(NodeBinary otherNode) {
		return(ByteUtil.compareTwoByteArray(byteArray, otherNode.byteArray));
		/*
		if ((byteArray==null) && (otherNode.byteArray==null)) { return (0); }
		else if ((byteArray==null) 		&& (otherNode.byteArray!=null)) { return (-1); }
		else if ((byteArray!=null) 		&& (otherNode.byteArray==null)) { return (1); }
		else if ((byteArray.length==0) 	&& (otherNode.byteArray.length==0)) 	{ return (0); }
		else if ((byteArray.length==0) 	&& (otherNode.byteArray.length>0)) 	{ return (-1); }
		else if ((byteArray.length>0) 	&& (otherNode.byteArray.length==0)) { return (1); }
		else { //both are not null and not null
			
		}
		return Integer.compare(getRanking(), otherPlayer.getRanking());
		*/
	}
	 

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
