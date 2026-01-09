package tool10.underdev.navigator;

import java.util.HashMap;
import java.util.HashSet;

import tool10.fileset.nodes.NodeFileSet;

public class ShowListFileSet {

	public static HashMap<String,String> getAllListString4FileSet(NodeShow show, NodeFileSet fileSet,String outType,
			HashSet<String> nodeSet, String showFileNamePrefix)	{
		
		String fileName = showFileNamePrefix + "01" + ".html";
		HashMap<String,String> mapString = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		mapString.put(fileName,sb.toString());
		return(mapString);
	}	
}
