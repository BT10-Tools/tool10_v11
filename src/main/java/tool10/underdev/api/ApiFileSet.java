package tool10.underdev.api;

import tool10.fileset.PrintFileSet;
import tool10.fileset.nodes.NodeFileSet;

public class ApiFileSet {

	//Here the methods executable for the FileSets will come. 
	//The methods can be executed from the JShell  
	
	public ApiFileSet(NodeFileSet fileSet) {
		super();
		this.fileSet = fileSet;
	}
	
	private NodeFileSet fileSet;
	
	public String getString4ListsAndMaps()	{
		return(PrintFileSet.getString4ListsAndMaps(this.fileSet));
	}
	public void printAllListsAndMaps()	{
		PrintFileSet.printAllListsAndMaps(this.fileSet);
	}
	
	//GETTERS AND SETTERS
	public NodeFileSet getFileSet() {
		return fileSet;
	}
}
