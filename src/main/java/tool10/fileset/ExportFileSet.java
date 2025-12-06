package tool10.fileset;

public class ExportFileSet {
	
	public static void exportFileSet(NodeF10 f10)	{
		System.out.println("ExportFileSet exportFileSet exporting CSV ");
		ExportCsv.extractFileSetCSV(f10)	;
	}
}
