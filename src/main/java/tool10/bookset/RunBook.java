package tool10.bookset;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;
import tool10.sql.DbManager;

public class RunBook {
	
	public static void runBook4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunBook runBook4FileSet creating books for files in the fileSet");
		
		Conn10 connBook = DbManager.createBookDatabase(f10);
		if (connBook==null)	return;
	
		NodeBookSet bookSet = MakeBookSet.makeBookSetFromFileSet(f10);
		
		WriteBookSetTablesToDb.writeBookSetTables(f10.getConnBook().getConn(), bookSet);
		
	/*	ReadBookTablesFromDb.postProcessBookSet(f10.getBookSet());
		
		MakeBookSetTables.createBook(f10);
		
		WriteBookTablesToDb.writeBookSetTables(f10.getConnImage().getConn(), bookSet);
		
	//	long bookSetId = 1; //bookSet.getBookSetId();
	//	NodeBookSet readBookSet = readBookSet(conn, bookSetId);
	*/	
			
	}
}
