package tool10.fileset;

public class NodePair {

	NodePair(NodeFile nodeFile1, NodeFile nodeFile2, String algName, double score) 	{
		this.nodeFile1 = nodeFile1;
		this.nodeFile2 = nodeFile2;
		this.algName = algName;
		this.score = score;
		this.pairStr = Long.toString(nodeFile1.getFileId())+"_"+Long.toString(nodeFile2.getFileId());
	}
	private NodeFile nodeFile1;
	private NodeFile nodeFile2;
	private String algName;
	private double score;
	private String pairStr;
	
	public String toString()	{return("nodeFile1 Id:"+nodeFile1.getFileId()+" ,nodeFile2 Id:"+nodeFile2.getFileId()+" ,algName:"+algName +
			" ,score:"+score + "nodeFile1 name:"+nodeFile1.getFileNameAbsolute()+" ,nodeFile2 name:"+nodeFile2.getFileNameAbsolute());}

	//GETTERS AND SETTERS
	public NodeFile getNodeFile1() {
		return(nodeFile1);
	}
	public NodeFile getNodeFile2() {
		return(nodeFile2);
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getPairStr() {
		return pairStr;
	}
	public String getAlgName() {
		return algName;
	}
	
}
