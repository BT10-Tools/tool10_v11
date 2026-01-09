package tool10.preview.navigator;

import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.f10.Tool10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.mediaset.NodeMediaSet;
import tool10.simset.NodeSimSet;
import tool10.tagset.NodeTagSet;
import tool10.blobset.NodeBlobSet;
import tool10.bookset.NodeBookSet;
import tool10.util.FileUtil;

public class RunShow {

	private static final String[] classesFileSet= new String[] {"fileSet","file","fileName","fileProp","fileBlob","fileStore",
			"fileSystem","hash","host","archive","container","transform"}; 	

	public static void runFileSet(NodeF10 f10, NodeFileSet fileSet, NodeShow show, String outType,  String showFileNamePrefix) {
		
		String allPackagesStr = ShowFormFileSet.getAllPackagesFileSet(fileSet,outType);
		String allClassesStr = ShowFormFileSet.getAllClassesFileSet(fileSet,outType);
		show.setAllPackagesStr(allPackagesStr);
		show.setAllClassesStr(allClassesStr);
		
		HashSet<String> nodeSet = new HashSet<String>();
		for (String classNameStr : classesFileSet)	{ 	nodeSet.add(classNameStr);	} 	

		HashMap<String,String> mapShowForm = ShowFormFileSet.getAllShowString4FileSet(show, fileSet,outType,nodeSet,showFileNamePrefix);
		HashMap<String,String> mapShowList = ShowListFileSet.getAllListString4FileSet(show, fileSet,outType,nodeSet,showFileNamePrefix);
		//query, stat will come
		
		for (String fileName : mapShowForm.keySet())	{FileUtil.bufferedWriter(fileName,mapShowForm.get(fileName));	}
		for (String fileName : mapShowList.keySet())	{FileUtil.bufferedWriter(fileName,mapShowList.get(fileName));	}
			
	}
	public static void runBlobSet(NodeF10 f10, NodeBlobSet blobSet, NodeShow show, String outType,  String showFileNamePrefix) {
	}
	public static void runSimSet(NodeF10 f10, NodeSimSet simSet, NodeShow show, String outType,  String showFileNamePrefix) {
	}
	public static void runTagSet(NodeF10 f10, NodeTagSet tagSet, NodeShow show, String outType,  String showFileNamePrefix) {
	}
	public static void runMediaSet(NodeF10 f10, NodeMediaSet mediaSet, NodeShow show, String outType,  String showFileNamePrefix) {
	}
	public static void runBookSet(NodeF10 f10, NodeBookSet bookSet, NodeShow show, String outType,  String showFileNamePrefix) {
	}
	
	public static void runShow(NodeF10 f10, String outType) {
		NodeShow show = new NodeShow(f10, outType);

		String showFileNamePrefix = "C:\\tmp\\similarity\\13_Show\\show";
		
		for (NodeFileSet fileSet : 		f10.getListFileSet())	{runFileSet(f10,fileSet,show,outType,showFileNamePrefix+"\\fileSet"+fileSet.getFileSetId()+"\\");}
		for (NodeBlobSet blobSet : 		f10.getListBlobSet())	{runBlobSet(f10,blobSet,show,outType,showFileNamePrefix+"\\blobSet"+blobSet.getBlobSetId()+"\\");}
		for (NodeTagSet tagSet : 		f10.getListTagSet())	{runTagSet(f10,tagSet,show,outType,showFileNamePrefix+"\\tagSet"+tagSet.getTagSetId()+"\\");}
		for (NodeMediaSet mediaSet : 	f10.getListMediaSet())	{runMediaSet(f10,mediaSet,show,outType,showFileNamePrefix+"\\mediaSet"+mediaSet.getMediaSetId()+"\\");}
		for (NodeBookSet bookSet : 		f10.getListBookSet())	{runBookSet(f10,bookSet,show,outType,showFileNamePrefix+"\\bookSet"+bookSet.getBookSetId()+"\\");}
			
		//runFileSet(args);
		//tagSet, imageSet, docSet, winRegistry,        		
	}
	public static void main(String[] args) {
		NodeF10 f10 = Tool10.getF10();
		String outType = "html";
		runShow(f10,outType);
	}
	
}
