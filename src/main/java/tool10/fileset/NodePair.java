package tool10.fileset;

public class NodePair {

	NodePair(NodeFile nodeFile1, NodeFile nodeFile2, String pairType, double score) 	{
		this.nodeFile1 = nodeFile1;
		this.nodeFile2 = nodeFile2;
		this.pairType = pairType;
		this.score = score;
	}
	private NodeFile nodeFile1;
	private NodeFile nodeFile2;
	private String pairType;
	private double score;
	
	public String toString()	{return("nodeFile1 Id:"+nodeFile1.getFileId()+" ,nodeFile2 Id:"+nodeFile2.getFileId()+" ,pairType:"+pairType +
			" ,score:"+score + "nodeFile1 name:"+nodeFile1.getFileNameAbsolute()+" ,nodeFile2 name:"+nodeFile2.getFileNameAbsolute());}

	//GETTERS AND SETTERS
	public NodeFile getNodeFile1() {
		return(nodeFile1);
	}
	public NodeFile getNodeFile2() {
		return(nodeFile2);
	}
	public String getPairType() {
		return(pairType);
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
}
