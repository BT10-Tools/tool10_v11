package tool10.simset;

import tool10.docset.MakeDocSet;
import tool10.docset.NodeDocSet;
import tool10.docset.WriteDocSetTablesToDb;
import tool10.f10.NodeF10;
import tool10.f10.RunF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;
import tool10.sql.DbManager;

public class RunSim {
	
	public static void runSim4FileSet(NodeF10 f10, NodeFileSet fileSet)	{
		
		System.out.println("RunBook runSim4FileSet creating books for files in the fileSet");
		
		Conn10 connBook = DbManager.createBookDatabase(f10);
		if (connBook==null)	return;
	
		NodeDocSet bookSet = MakeDocSet.makeBookSetFromFileSet(f10);
		
		WriteDocSetTablesToDb.writeBookSetTables(f10.getConnBook().getConn(), bookSet);
		
	/*	ReadBookTablesFromDb.postProcessBookSet(f10.getBookSet());
		
		MakeBookSetTables.createBook(f10);
		
		WriteBookTablesToDb.writeBookSetTables(f10.getConnImage().getConn(), bookSet);
		
	//	long bookSetId = 1; //bookSet.getBookSetId();
	//	NodeBookSet readBookSet = readBookSet(conn, bookSetId);
	*/	
			
	}
	public static void runSimSet(NodeF10 f10)	{
		
		f10.println("MainFileSet runSimilarity");
		
		NodeFileSet fileSet = RunF10.getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
   /*     fileSet.getListSimilarity().clear();
        fileSet.getMapId2Similarity().clear();
        fileSet.getMapKey2Similarity().clear();
        
        MakeFileSetSimilarity.makeSimilarity(f10);
	    WriteFsTablesToDb.writeSimilarity(f10.getConn10().getConn(), fileSet);
    */
	    RunSim.runSimSet(f10);  	
        if (f10.getOutputFileSet()!=null)	{
        	//write tag files 
        	//writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
		f10.getConn10().closeConnection();
	}
}
