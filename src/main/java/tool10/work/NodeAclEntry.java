package tool10.work;

import java.util.ArrayList;

public class NodeAclEntry {

	public NodeAclEntry(long nodeAclEntryId, NodeAcl nodeAcl, String entryType, long entryTypeHashCode, 
			long principalHashCode, String principalName) {
		this.nodeAclEntryId = nodeAclEntryId;
		this.nodeAcl = nodeAcl;
		this.entryType = entryType;
		this.entryTypeHashCode = entryTypeHashCode; 
		this.principalHashCode = principalHashCode;
		this.principalName = principalName;
		this.allOrdinal = ",";
		this.allHashCode = ",";
		this.allPerm = ",";
		this.listOrdinal = new ArrayList<Integer>();
		this.listHashCode = new ArrayList<Integer>();
		this.listPerm = new ArrayList<String>();
	}
	private long nodeAclEntryId;
	private String owner;
	private long hashCode;
	private String entryType;
	private long entryTypeHashCode;
	private long principalHashCode;
	private String principalName;
	private String allOrdinal;
	private String allHashCode;
	private String allPerm;
	private ArrayList<Integer> listOrdinal;
	private ArrayList<Integer> listHashCode;
	private ArrayList<String> listPerm;
	private NodeAcl nodeAcl;
	
	public long getNodeAclEntryId() {
		return nodeAclEntryId;
	}
	public void setNodeAclEntryId(long nodeAclEntryId) {
		this.nodeAclEntryId = nodeAclEntryId;
	}
	public NodeAcl getNodeAcl() {
		return nodeAcl;
	}
	public void setNodeAcl(NodeAcl nodeAcl) {
		this.nodeAcl = nodeAcl;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getHashCode() {
		return hashCode;
	}
	public void setHashCode(long hashCode) {
		this.hashCode = hashCode;
	}
	public String getEntryType() {
		return entryType;
	}
	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	public long getEntryTypeHashCode() {
		return entryTypeHashCode;
	}
	public void setEntryTypeHashCode(long entryTypeHashCode) {
		this.entryTypeHashCode = entryTypeHashCode;
	}
	public long getPrincipalHashCode() {
		return principalHashCode;
	}
	public void setPrincipalHashCode(long principalHashCode) {
		this.principalHashCode = principalHashCode;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getAllOrdinal() {
		return allOrdinal;
	}
	public void setAllOrdinal(String allOrdinal) {
		this.allOrdinal = allOrdinal;
	}
	public String getAllHashCode() {
		return allHashCode;
	}
	public void setAllHashCode(String allHashCode) {
		this.allHashCode = allHashCode;
	}
	public String getAllPerm() {
		return allPerm;
	}
	public void setAllPerm(String allPerm) {
		this.allPerm = allPerm;
	}
	public ArrayList<Integer> getListOrdinal() {
		return listOrdinal;
	}
	public void setListOrdinal(ArrayList<Integer> listOrdinal) {
		this.listOrdinal = listOrdinal;
	}
	public ArrayList<Integer> getListHashCode() {
		return listHashCode;
	}
	public void setListHashCode(ArrayList<Integer> listHashCode) {
		this.listHashCode = listHashCode;
	}
	public ArrayList<String> getListPerm() {
		return listPerm;
	}
	public void setListPerm(ArrayList<String> listPerm) {
		this.listPerm = listPerm;
	}

}
