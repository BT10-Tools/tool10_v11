package tool10.f10;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import tool10.blobset.NodeBlobSet;
import tool10.bookset.NodeBookSet;
import tool10.fileset.nodes.NodeFileSet;
import tool10.mediaset.NodeMediaSet;
import tool10.simset.NodeSimSet;
import tool10.sql.Conn10;
import tool10.tagset.NodeTagSet;
import tool10.util.TimeUtil;

public class NodeF10 {

	public NodeF10() {
		super();
		listConnBlob = new ArrayList<Conn10>();
		
	}
	private String args0;
	private CliParameter cliParams;
	private Conn10 conn10;  
	private Conn10 connBlob; //current blob database name, the first db assigned as default 
	private ArrayList<Conn10> listConnBlob;	
	private Conn10 connTag; //current tag database name, the first db assigned as default 
	private Conn10 connMedia; //current media database name, the first db assigned as default 
	private Conn10 connBook; //current book database name, the first db assigned as default 
	private Conn10 connSim; //current sim database name, the first db assigned as default 
	private PropConfig propConfig; 
	private NodeFileSet fileSet; 
	private NodeFileSet outputFileSet;
	private NodeBlobSet blobSet; 
	private NodeTagSet tagSet; 
	private NodeMediaSet mediaSet; 
	private NodeBookSet bookSet; 
	private NodeSimSet simSet; 
	private ZonedDateTime startTime;  
	private ZonedDateTime currentTime; 
	private ZonedDateTime endTime;
	
	private ArrayList<NodeFileSet> listFileSet;
	private ArrayList<NodeBlobSet> listBlobSet;
	private ArrayList<NodeTagSet> listTagSet;
	private ArrayList<NodeMediaSet> listMediaSet;
	private ArrayList<NodeBookSet> listBookSet;
	private ArrayList<NodeSimSet> listSimSet;
	
	public void updateCurrentTime()	{
		this.currentTime = ZonedDateTime.now();
	}
	public long getElapsedTimeInMillis()	{
		if (currentTime==null) updateCurrentTime();
		long runTimeInMillis = TimeUtil.diffInMillisZDT(startTime, currentTime);
		return(runTimeInMillis);
	}
	public void startAll(Logger logger)	{
		this.startTime = ZonedDateTime.now();
		String msg = "Tool10 Execution Start Time:"+startTime;
		System.out.println(msg); logger.info(msg);	
	}
	public void endAll(Logger logger)	{
		if (endTime==null) {this.endTime = ZonedDateTime.now();}
		long runTimeInMillis = TimeUtil.diffInMillisZDT(startTime, endTime);
		String msg = "Tool10 Start Time:"+startTime+" ,End Time:"+endTime + ", run time in milliseconds:"+runTimeInMillis;
		System.out.println(msg); logger.info(msg);
	}
	public String getString()	{
		return(
		"String[] args:"+args0+"\n"+
		"CliParameter cliParams:"+cliParams+"\n"+
		"Conn10 conn10:"+conn10+"\n"+   
		"Conn10 connBlob:"+connBlob+"\n"+ 
		"ArrayList<Conn10> listConnBlob:"+listConnBlob+"\n"+	
		"Conn10 connTag:"+connTag+"\n"+ 
		"Conn10 connMedia:"+connMedia+"\n"+ 
		"Conn10 connBook:"+connBook +"\n"+
		"Conn10 connSim:"+connSim +"\n"+
		"PropConfig propConfig:"+propConfig+"\n"+ 
		"NodeFileSet fileSet:"+fileSet +"\n"+
		"NodeFileSet outputFileSet:"+outputFileSet +"\n"+
		"NodeTagSet tagSet:"+tagSet +"\n"+
		"NodeMediaSet mediaSet:"+mediaSet+"\n"+ 
		"NodeBookSet bookSet"+bookSet+"\n"+
		"NodeSimSet simSet:"+simSet +"\n"+
		"ZonedDateTime startTime:"+startTime+"\n"+  
		"ZonedDateTime currentTime:"+startTime +"\n"+
		"ZonedDateTime endTime:"+endTime+"\n");
		
	}
	public void printString()	{
		System.out.println(getString());
	}
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
	public NodeMediaSet getMediaSet() {
		return mediaSet;
	}
	public void setMediaSet(NodeMediaSet mediaSet) {
		this.mediaSet = mediaSet;
	}
	public Conn10 getConnMedia() {
		return connMedia;
	}
	public void setConnMedia(Conn10 connMedia) {
		this.connMedia = connMedia;
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
	public NodeSimSet getSimSet() {
		return simSet;
	}
	public void setSimSet(NodeSimSet simSet) {
		this.simSet = simSet;
	}
	public Conn10 getConnSim() {
		return connSim;
	}
	public void setConnSim(Conn10 connSim) {
		this.connSim = connSim;
	}
	public String getArgs0() {
		return args0;
	}
	public void setArgs0(String args0) {
		this.args0 = args0;
	}
	public NodeBlobSet getBlobSet() {
		return blobSet;
	}
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	public ZonedDateTime getCurrentTime() {
		return currentTime;
	}
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	public ArrayList<NodeFileSet> getListFileSet() {
		return listFileSet;
	}
	public ArrayList<NodeBlobSet> getListBlobSet() {
		return listBlobSet;
	}
	public ArrayList<NodeTagSet> getListTagSet() {
		return listTagSet;
	}
	public ArrayList<NodeMediaSet> getListMediaSet() {
		return listMediaSet;
	}
	public ArrayList<NodeBookSet> getListBookSet() {
		return listBookSet;
	}
	public ArrayList<NodeSimSet> getListSimSet() {
		return listSimSet;
	}
	public void setBlobSet(NodeBlobSet blobSet) {
		this.blobSet = blobSet;
	}
	
}
