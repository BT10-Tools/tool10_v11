package tool10.work;

import java.io.Serializable;
import java.util.ArrayList;

public class NodeAcl  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeAcl(long nodeAclId,long pathId, String ownerName, long ownerHashCode, long hashCode) {
		super();
		this.nodeAclId = nodeAclId;
		this.pathId = pathId;
		this.ownerName = ownerName;
		this.ownerHashCode = ownerHashCode;
		this.hashCode = hashCode;
		this.listAclEntry = new ArrayList<NodeAclEntry>();
	}
	private long nodeAclId;
	private long pathId;
	private String ownerName;
	private long ownerHashCode;
	private long hashCode;
	private ArrayList<NodeAclEntry> listAclEntry;
	
	public long getNodeAclId() {
		return nodeAclId;
	}
	public void setNodeAclId(long nodeAclId) {
		this.nodeAclId = nodeAclId;
	}
	public long getPathId() {
		return pathId;
	}
	public void setPathId(long pathId) {
		this.pathId = pathId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerHashCode() {
		return ownerHashCode;
	}
	public void setOwnerHashCode(long ownerHashCode) {
		this.ownerHashCode = ownerHashCode;
	}
	public long getHashCode() {
		return hashCode;
	}
	public void setHashCode(long hashCode) {
		this.hashCode = hashCode;
	}
	public ArrayList<NodeAclEntry> getListAclEntry() {
		return listAclEntry;
	}
	public void setListAclEntry(ArrayList<NodeAclEntry> listAclEntry) {
		this.listAclEntry = listAclEntry;
	}
	
}
