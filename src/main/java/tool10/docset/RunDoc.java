package tool10.docset;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;
import tool10.sql.DbManager;

public class RunDoc {
	
	public static void runDoc4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunDoc runDoc4FileSet creating doc for files in the fileSet");
		
		Conn10 connDoc = DbManager.createDocDatabase(f10);
		if (connDoc==null)	return;
	
		NodeDocSet docSet = MakeDocSet.makeDocSetFromFileSet(f10);
		
		WriteDocSetTablesToDb.writeDocSetTables(f10.getConnDoc().getConn(), docSet);
		
	/*	ReadDocTablesFromDb.postProcessDocSet(f10.getDocSet());
		
		MakeDocSetTables.createDoc(f10);
		
		WriteDocTablesToDb.writeDocSetTables(f10.getConnImage().getConn(), docSet);
		
	//	long docSetId = 1; //docSet.getDocSetId();
	//	NodeDocSet readDocSet = readDocSet(conn, docSetId);
	*/	
			
	}
}
