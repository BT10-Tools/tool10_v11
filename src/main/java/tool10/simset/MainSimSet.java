package tool10.simset;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.MakeFileSet;
import tool10.fileset.ReadFsTablesFromDb;
import tool10.fileset.WriteFsTablesToDb;
import tool10.fileset.nodes.NodeFileSet;
import tool10.sql.Conn10;

/**
 * The main program for File10.  
 * It processes the arguments and runs File10 operations.  
 * @author nhaney
 *
 */
public class MainSimSet {  
	
	public static void writeSimSetTables (Conn10 conn10, NodeSimSet simSet)	{
		CreateSimSetTables.createSimSetTables(conn10);
		//conn10.getTableManager().initializeAllTables();
		//conn10.getTableManager().clearAllTables();
		WriteSimSetTablesToDb.writeSimSetTables(conn10.getConn(), simSet);
	}
	
	public static NodeSimSet createSimSet (NodeF10 f10)	{
		NodeSimSet simSet = MakeSimSet.makeSimSet(f10,"fileSet"); 
		if (simSet!=null)	{
			MakeSimSet.printAllListsAndMaps(simSet);
		}
		return(simSet);
	}
	public static NodeSimSet readSimSet (Conn10 conn10, long simSetId)	{
		NodeSimSet simSet = null; 
		
		//conn10.getTableManager().checkAllTables();
		
		simSet = ReadSimSetTablesFromDb.readSimSetTables(conn10.getConn(), simSetId);
		return(simSet);	
	}
		
}
