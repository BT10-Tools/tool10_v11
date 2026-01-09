package tool10.fileset;

import tool10.f10.NodeF10;
import tool10.underdev.navigator.ExportCsv;

public class ExportFileSet {
	
	public static void exportFileSet(NodeF10 f10)	{
		System.out.println("ExportFileSet exportFileSet exporting CSV ");
		ExportCsv.extractFileSetCSV(f10)	;
	}
}
