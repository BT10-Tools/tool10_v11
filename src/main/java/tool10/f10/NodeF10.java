package tool10.f10;

import java.util.ArrayList;

import tool10.bookset.NodeBookSet;
import tool10.fileset.PropConfig;
import tool10.fileset.nodes.NodeFileSet;
import tool10.imageset.NodeImageSet;
import tool10.sql.Conn10;
import tool10.tagset.NodeTagSet;

public class NodeF10 {

	public NodeF10() {
		super();
		listConnBlob = new ArrayList<Conn10>();
	}
	
	private CliParameter cliParams;
	private Conn10 conn10;  
	private Conn10 connBlob; //current blob database name, the first db assigned as default 
	private ArrayList<Conn10> listConnBlob;	
	private Conn10 connTag; //current tag database name, the first db assigned as default 
	private Conn10 connImage; //current image database name, the first db assigned as default 
	private Conn10 connBook; //current book database name, the first db assigned as default 
	private PropConfig propConfig; 
	private NodeFileSet fileSet; 
	private NodeFileSet outputFileSet;
	private NodeTagSet tagSet; 
	private NodeImageSet imageSet; 
	private NodeBookSet bookSet; 
	
	public void println(String str)	{
		System.out.println(str);
	}
	public void print(String str)	{
		System.out.print(str);
	}
	//log
	
	//getters and setters
	public CliParameter getCliParams() {
		return cliParams;
	}
	public void setCliParams(CliParameter cliParams) {
		this.cliParams = cliParams;
	}
	public Conn10 getConn10() {
		return conn10;
	}
	public void setConn10(Conn10 conn10) {
		this.conn10 = conn10;
	}
	public PropConfig getPropConfig() {
		return propConfig;
	}
	public void setPropConfig(PropConfig propConfig) {
		this.propConfig = propConfig;
	}
	public NodeFileSet getFileSet() {
		return fileSet;
	}
	public void setFileSet(NodeFileSet fileSet) {
		this.fileSet = fileSet;
	}
	public NodeFileSet getOutputFileSet() {
		return outputFileSet;
	}
	public void setOutputFileSet(NodeFileSet outputFileSet) {
		this.outputFileSet = outputFileSet;
	}
	public Conn10 getConnBlob() {
		return connBlob;
	}
	public void setConnBlob(Conn10 connBlob) {
		this.connBlob = connBlob;
	}
	public ArrayList<Conn10> getListConnBlob() {
		return listConnBlob;
	}
	public NodeTagSet getTagSet() {
		return tagSet;
	}
	public void setTagSet(NodeTagSet tagSet) {
		this.tagSet = tagSet;
	}
	public void setListConnBlob(ArrayList<Conn10> listConnBlob) {
		this.listConnBlob = listConnBlob;
	}
	public Conn10 getConnTag() {
		return connTag;
	}
	public void setConnTag(Conn10 connTag) {
		this.connTag = connTag;
	}
	public NodeImageSet getImageSet() {
		return imageSet;
	}
	public void setImageSet(NodeImageSet imageSet) {
		this.imageSet = imageSet;
	}
	public Conn10 getConnImage() {
		return connImage;
	}
	public void setConnImage(Conn10 connImage) {
		this.connImage = connImage;
	}
	public Conn10 getConnBook() {
		return connBook;
	}
	public void setConnBook(Conn10 connBook) {
		this.connBook = connBook;
	}
	public NodeBookSet getBookSet() {
		return bookSet;
	}
	public void setBookSet(NodeBookSet bookSet) {
		this.bookSet = bookSet;
	}
	
}
