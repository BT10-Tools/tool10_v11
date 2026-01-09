package tool10.preview.navigator;

import java.util.HashMap;

import tool10.f10.NodeF10;

public class NodeShow {

	public NodeShow(NodeF10 f10, String outType) {
		super();
		this.f10 = f10;
		this.outType = outType;
		mapAnchor = new HashMap<>();
	}

	private NodeF10 f10;
	private String outType; 
	private String allPackagesStr;
	private String allClassesStr;
	private HashMap<String,String> mapAnchor; 
	

	//GETTERS AND SETTERS
	public NodeF10 getF10() {
		return f10;
	}
	public String getOutType() {
		return outType;
	}
	public String getAllPackagesStr() {
		return allPackagesStr;
	}
	public void setAllPackagesStr(String allPackagesStr) {
		this.allPackagesStr = allPackagesStr;
	}
	public String getAllClassesStr() {
		return allClassesStr;
	}
	public void setAllClassesStr(String allClassesStr) {
		this.allClassesStr = allClassesStr;
	}
	public HashMap<String, String> getMapAnchor() {
		return mapAnchor;
	}
	
}
