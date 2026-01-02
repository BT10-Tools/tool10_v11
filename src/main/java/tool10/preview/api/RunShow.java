package tool10.preview.api;

import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.f10.Tool10;
import tool10.fileset.nodes.NodeFileSet;

public class RunShow {

	public static void main(String[] args) {
		
		NodeF10 f10 = Tool10.getF10();
		String outType = "html";
		
		NodeShow show = new NodeShow(f10, outType);
		
		String allPackagesStr = ShowForm.getAllPackagesFileSet(f10.getFileSet(),outType);
		String allClassesStr = ShowForm.getAllClassesFileSet(f10.getFileSet(),outType);
		show.setAllPackagesStr(allPackagesStr);
		show.setAllClassesStr(allClassesStr);
		
		HashSet<String> nodeSet = new HashSet<String>();
		nodeSet.add("fileSet"); nodeSet.add("fileX"); 
		String str = ShowForm.getAllShowString4FileSet(f10.getFileSet(),outType,nodeSet);
		
		System.out.println(str);
		//runFileSet(args);
		//tagSet, imageSet, docSet, winRegistry,        		
	}
	
}
