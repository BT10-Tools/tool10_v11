package tool10.fileset;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;

/**
 * The main program for File10.  
 * It processes the arguments and runs File10 operations.  
 * @author nhaney
 *
 */
public class MainFileSet {  
	
	public static void writeFileSetTables (Conn10 conn10, NodeFileSet fileSet)	{
		CreateFileSetTables.createFileSetTables(conn10);
		//conn10.getTableManager().initializeAllTables();
		//conn10.getTableManager().clearAllTables();
		WriteFsTablesToDb.writeFileSetTables(conn10.getConn(), fileSet);
	}
	
	public static NodeFileSet createFileSet (NodeF10 f10)	{
		NodeFileSet fileSet = MakeFileSet.makeFileSet(f10); 
		if (fileSet!=null)	{
			PrintFileSet.printAllListsAndMaps(fileSet);
		}
		return(fileSet);
	}
	public static NodeFileSet readFileSet (Conn10 conn10, long fileSetId)	{
		NodeFileSet fileSet = null; 
		
		//conn10.getTableManager().checkAllTables();
		
		fileSet = ReadFsTablesFromDb.readFileSetTables(conn10.getConn(), fileSetId);
		return(fileSet);	
	}
		
}
