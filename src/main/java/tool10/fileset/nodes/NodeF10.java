package tool10.fileset.nodes;

import tool10.fileset.CliParameter;
import tool10.fileset.PropConfig;
import tool10.sql.Conn10;

public class NodeF10 {

	public NodeF10() {
		super();
	}
	
	private CliParameter cliParams;
	private Conn10 conn10;  
	private PropConfig propConfig; 
	private NodeFileSet fileSet; 
	private NodeFileSet outputFileSet;
	
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
	
}
