package tool10.fileset;

import tool10.sql.Conn10;

/**
 * The main program for File10.  
 * It processes the arguments and runs File10 operations.  
 * @author nhaney
 *
 */
public class MainFileSet {  
	
	private static void writeFileSetTables (Conn10 conn10, NodeFileSet fileSet)	{
		CreateFileSetTables.createFileSetTables(conn10);
		//conn10.getTableManager().initializeAllTables();
		//conn10.getTableManager().clearAllTables();
		WriteFsTablesToDb.writeFileSetTables(conn10.getConn(), fileSet);
	}
	
	private static NodeFileSet createFileSet (NodeF10 f10)	{
		NodeFileSet fileSet = MakeFileSet.makeFileSet(f10); 
		if (fileSet!=null)	{
			MakeFileSetBlob.createFileBlobs(f10);
			MakeFileSet.printAllListsAndMaps(fileSet);
		}
		return(fileSet);
	}
	private static NodeFileSet readFileSet (Conn10 conn10, long fileSetId)	{
		NodeFileSet fileSet = null; 
		
		//conn10.getTableManager().checkAllTables();
		
		fileSet = ReadFsTablesFromDb.readFileSetTables(conn10.getConn(), fileSetId);
		return(fileSet);	
	}
	private static Conn10 getConn10 (NodeF10 f10)	{
		Conn10 conn10 = new Conn10("fsDb",f10.getCliParams().getDbType(),f10.getCliParams().getDbName(), 
				f10.getCliParams().getDbReadOnly(), f10.getCliParams().getDbMem()); //"sqlite","C:\\app\\sqlite\\similarity\\fileSet01.db");
		//System.out.println("sqlite conn = "+conn10.getConn());  
		f10.setConn10(conn10);
		if (conn10.getConn()==null)	{
			f10.println("Database connection is null dbName:"+f10.getCliParams().getDbName());
		}
		return(conn10);	
	}
	public static void runLoad(NodeF10 f10) {
		if (f10==null) return;
        //System.out.println("Selamun Aleyküm");
        
        Conn10 conn10 = getConn10(f10); 
        
		NodeFileSet fileSet = createFileSet (f10);
		f10.setFileSet(fileSet);
		if (fileSet==null) return;
		
		writeFileSetTables (conn10,fileSet);
		conn10.closeConnection();  
	}
	public static void runSimilarity(NodeF10 f10) {
		
		f10.println("MainFileSet runSimilarity");
		
		NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        fileSet.getListSimilarity().clear();
        fileSet.getMapId2Similarity().clear();
        fileSet.getMapKey2Similarity().clear();
        
        MakeFileSetSimilarity.makeSimilarity(f10);
	    WriteFsTablesToDb.writeSimilarity(f10.getConn10().getConn(), fileSet);
    
		f10.getConn10().closeConnection();
		
    }
	private static NodeFileSet getReadFileSet(NodeF10 f10) {
		if (f10==null) return(null);
	    //System.out.println("Selamun Aleyküm");
	    
	    Conn10 conn10 = getConn10(f10);
	    String fileSetName = f10.getCliParams().getFileSetName(); 
	    Long fileSetId = ReadFsTablesFromDb.getFileSetIdByName(conn10.getConn(), fileSetName);
	    if (fileSetId==null) return(null);
	    NodeFileSet fileSet = readFileSet (conn10, fileSetId);
	    return(fileSet);
	}
	public static void runExtract(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        ExtractorFile.extractFileSetFile(f10);
        f10.getConn10().closeConnection();
	}
	public static void runExport(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        ExportFileSet.exportFileSet(f10);
        f10.getConn10().closeConnection();
	}
	public static void runF10(NodeF10 f10, String[] args0)	{
		PropConfig propConfig = new PropConfig();
	    f10.setPropConfig(propConfig);
	    
	    CliParameter cliParam = CliFileSetInitialize.initializeParameters(args0);
	    if (cliParam==null) return;
	    String parseAndValidateStatus = CliFileSetParseAndValidate.parseAndValidateCommandLineArguments(cliParam); 
	    f10.setCliParams(cliParam);
	    if (!"ok".equals(parseAndValidateStatus))	{
	    	f10.println("MainFileSet runF10 parseAndValidateStatus:"+parseAndValidateStatus);
	    	return;
	    }
		String action = f10.getCliParams().getAction();  //manage, extract, similarity
		f10.println("MainFileSet runF10 action:"+action);
		if (action==null) return;
		
		if ("load".equals(action))	{runLoad(f10);}
		else if ("extract".equals(action))	{runExtract(f10);}
		else if ("export".equals(action))	{runExport(f10);}
		else if ("similarity".equals(action))	{runSimilarity(f10);}
		else if ("help".equals(action))	{CliFileSetPrint.printHelp(f10.getCliParams().getCommandLine(), f10.getCliParams().getOpt()); }
		else if ("credits".equals(action))	{CliFileSetPrint.printCredits();}
	}
	
}
