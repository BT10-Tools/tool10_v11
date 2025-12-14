package tool10.fileset;

import tool10.fileset.nodes.NodeF10;

public class ExportFileSet {
	
	public static void exportFileSet(NodeF10 f10)	{
		System.out.println("ExportFileSet exportFileSet exporting CSV ");
		ExportCsv.extractFileSetCSV(f10)	;
	}
}
