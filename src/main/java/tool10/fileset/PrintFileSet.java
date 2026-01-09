package tool10.fileset;

import tool10.fileset.nodes.NodeFileSet;

public class PrintFileSet {
	
	public static String getString4ListsAndMaps(NodeFileSet fileSet)	{
		StringBuilder sb = new StringBuilder();
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFile().size() = " + fileSet.getListFile().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFileName().size() = " + fileSet.getListFileName().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFileProp().size() = " + fileSet.getListFileProp().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFileBlob().size() = " + fileSet.getListFileBlob().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFileSystem().size() = " + fileSet.getListFileSystem().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListFileStore().size() = " + fileSet.getListFileStore().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListHash().size() = " + fileSet.getListHash().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListHost().size() = " + fileSet.getListHost().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListProperty().size() = " + fileSet.getListProperty().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListStat().size() = " + fileSet.getListStat().size()+"\n");
							
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2File().size() = " + fileSet.getMapId2File().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2FileName().size() = " + fileSet.getMapId2FileName().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2FileProp().size() = " + fileSet.getMapId2FileProp().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2FileBlob().size() = " + fileSet.getMapId2FileBlob().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2FileSystem().size() = " + fileSet.getMapId2FileSystem().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2FileStore().size() = " + fileSet.getMapId2FileStore().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2Hash().size() = " + fileSet.getMapId2Hash().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2Host().size() = " + fileSet.getMapId2Host().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2Property().size() = " + fileSet.getMapId2Property().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2Query().size() = " + fileSet.getMapId2Query().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapId2Stat().size() = " + fileSet.getMapId2Stat().size()+"\n");
									
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getListRoots().size() = " + fileSet.getListRoots().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapAbsoluteFileName2File().size() = " + fileSet.getMapAbsoluteFileName2File().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapRawFileSystem2FileSystem().size() = " + fileSet.getMapRawFileSystem2FileSystem().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapRawFileStore2FileStore().size() = " + fileSet.getMapRawFileStore2FileStore().size()+"\n");
		sb.append("MakeFileSet printAllListsAndMaps fileSet.getMapCrc2NodeHash().size() = " + fileSet.getMapCrc2NodeHash().size()+"\n");
		return(sb.toString());
	}
	public static void printAllListsAndMaps(NodeFileSet fileSet)	{	
		System.out.println(getString4ListsAndMaps(fileSet));
	}
}
