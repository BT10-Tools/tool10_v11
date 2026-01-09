package tool10.blobset;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFileSet;
import tool10.mediaset.NodeMediaSet;
import tool10.sql.Conn10;
import tool10.sql.DbManager;

public class RunBlob {
	
	public static void runBlob4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunBlob runBook4FileSet creating books for files in the fileSet");
		
		Conn10 connBlob = DbManager.createBookDatabase(f10);
		if (connBlob==null)	return;
	
		NodeBlobSet blobSet = MakeBlob.makeBlobSetFromFileSet(f10);
			
		WriteBlobTablesToDb.writeBlobSetTables(f10.getConnBook().getConn(), blobSet);
		
	/*	ReadBookTablesFromDb.postProcessBookSet(f10.getBookSet());
		
		MakeBookSetTables.createBook(f10);
		
		WriteBookTablesToDb.writeBookSetTables(f10.getConnImage().getConn(), bookSet);
		
	//	long bookSetId = 1; //bookSet.getBookSetId();
	//	NodeBookSet readBookSet = readBookSet(conn, bookSetId);
	*/	
			
	}
	public static void runBlob4MediaSet(NodeF10 f10, NodeMediaSet mediaSet)	{
	}
}
