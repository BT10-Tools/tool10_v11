package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class FileAttribute implements Serializable {

	public FileAttribute(NodeFile nodeFile, int idx, String attrGroup, String attrName, String attrValue,
			Long valueLong, Double valueDouble, ZonedDateTime valueZDT) {
		super();
		this.nodeFile = nodeFile;
		this.idx = idx;
		this.attrGroup = attrGroup;
		this.attrName = attrName;
		this.attrValue = attrValue;
		this.valueLong = valueLong;
		this.valueDouble = valueDouble;
		this.valueZDT = valueZDT;
	}
	public FileAttribute(NodeFile nodeFile, int idx, String attrGroup, String attrName, String attrValue) {
		super();
		this.nodeFile = nodeFile;
		this.idx = idx;
		this.attrGroup = attrGroup;
		this.attrName = attrName;
		this.attrValue = attrValue;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NodeFile nodeFile;
	private int idx;
    private String attrGroup;
    private String attrName;
    private String attrValue;
    private Long valueLong;
    private Double valueDouble;
    private ZonedDateTime valueZDT;
    
    
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getAttrGroup() {
		return attrGroup;
	}
	public void setAttrGroup(String attrGroup) {
		this.attrGroup = attrGroup;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrValue() {
		return attrValue;
	}
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public void setValueLong(Long valueLong) {
		this.valueLong = valueLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public void setValueDouble(Double valueDouble) {
		this.valueDouble = valueDouble;
	}
	public ZonedDateTime getValueZDT() {
		return valueZDT;
	}
	public void setValueZDT(ZonedDateTime valueZDT) {
		this.valueZDT = valueZDT;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NodeFile getNodeFile() {
		return nodeFile;
	}
	public void setNodeFile(NodeFile nodeFile) {
		this.nodeFile = nodeFile;
	}
    
}
