package tool10.f10;

import tool10.blobset.MakeBlob;
import tool10.blobset.RunBlob;
import tool10.bookset.RunBook;
import tool10.fileset.ExportFileSet;
import tool10.fileset.ExtractorFile;
import tool10.fileset.MainFileSet;
import tool10.fileset.PrintFileSet;
import tool10.fileset.ReadFsTablesFromDb;
import tool10.fileset.WriteFsTablesToDb;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.transform.TransformFileSet;
import tool10.fileset.transform.UnembedFileSet;
import tool10.fileset.transform.UnzipFileSet;
import tool10.mediaset.RunImage;
import tool10.simset.RunSim;
import tool10.sql.Conn10;
import tool10.tagset.RunTag;

/**
 * The main program for File10.  
 * It processes the arguments and runs File10 operations.  
 * @author nhaney
 *
 */
public class RunF10 {  
	
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
        Conn10 conn10 = getConn10(f10); 
        
		NodeFileSet fileSet = MainFileSet.createFileSet (f10);
		f10.setFileSet(fileSet);
		if (fileSet==null) return;
		
		MainFileSet.writeFileSetTables (conn10,fileSet);
		conn10.closeConnection();  
	}
	public static void runLoadBlob(NodeF10 f10) {
		if (f10==null) return;
		f10.println("MainFileSet runLoadBlob");
		NodeFileSet fileSet = getReadFileSet(f10);
		if (fileSet==null) return;
		f10.setFileSet(fileSet);
		
		RunBlob.runBlob4FileSet(f10, fileSet);
		if (f10.getOutputFileSet()!=null)	{
			WriteFsTablesToDb.writeBlob(f10.getConn10().getConn(), f10.getOutputFileSet());
			PrintFileSet.printAllListsAndMaps(fileSet);
		}
		
		f10.getConn10().closeConnection();
		if (f10.getConn10()!=f10.getConnBlob()) { f10.getConnBlob().closeConnection(); }
	}
	public static void runSimilarity(NodeF10 f10) {
		RunSim.runSimSet(f10);  	
    }
	public static NodeFileSet getReadFileSet(NodeF10 f10) {
		if (f10==null) return(null);
	    //System.out.println("Selamun Aleyküm");
	    
	    Conn10 conn10 = getConn10(f10);
	    String fileSetName = f10.getCliParams().getFileSetName(); 
	    Long fileSetId = ReadFsTablesFromDb.getFileSetIdByName(conn10.getConn(), fileSetName);
	    if (fileSetId==null) return(null);
	    NodeFileSet fileSet = MainFileSet.readFileSet (conn10, fileSetId);
	    return(fileSet);
	}
	public static void runRead(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);      
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
	public static void runUnzip(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        UnzipFileSet.unzipFileSet(f10,fileSet);
        if (f10.getOutputFileSet()!=null)	{
        	MainFileSet.writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runUnembed(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        UnembedFileSet.unembedFileSet(f10,fileSet);
        if (f10.getOutputFileSet()!=null)	{
        	MainFileSet.writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runTransform(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        TransformFileSet.transformFileSet(f10,fileSet);
        if (f10.getOutputFileSet()!=null)	{
        	MainFileSet.writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runTag(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        RunTag.runTag4FileSet(f10,fileSet); 	
        if (f10.getOutputFileSet()!=null)	{
        	//write tag files 
        	//writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runImage(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        RunImage.runImage4FileSet(f10,fileSet); 	
        if (f10.getOutputFileSet()!=null)	{
        	//write tag files 
        	//writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runBook(NodeF10 f10) {
        NodeFileSet fileSet = getReadFileSet(f10);
        if (fileSet==null) return;
        f10.setFileSet(fileSet);
        RunBook.runBook4FileSet(f10,fileSet); 	
        if (f10.getOutputFileSet()!=null)	{
        	//write tag files 
        	//writeFileSetTables (f10.getConn10(),f10.getOutputFileSet());
        }
        f10.getConn10().closeConnection();
	}
	public static void runF10(NodeF10 f10, String[] args0)	{
		PropConfig propConfig = new PropConfig();
	    f10.setPropConfig(propConfig);
	    
	    CliParameter cliParam = CliInitialize.initializeParameters(args0);
	    if (cliParam==null) return;
	    String parseAndValidateStatus = CliParseAndValidate.parseAndValidateCommandLineArguments(cliParam); 
	    f10.setCliParams(cliParam);
	    if (!"ok".equals(parseAndValidateStatus))	{
	    	f10.println("MainFileSet runF10 parseAndValidateStatus:"+parseAndValidateStatus);
	    	return;
	    }
		String action = f10.getCliParams().getAction();  //manage, extract, similarity
		f10.println("MainFileSet runF10 action:"+action);
		if (action==null) return;
		
		if ("load".equals(action))	{runLoad(f10);}
		else if ("loadblob".equals(action))		{runLoadBlob(f10);}
		else if ("read".equals(action))			{runRead(f10);}
		else if ("extract".equals(action))		{runExtract(f10);}
		else if ("export".equals(action))		{runExport(f10);}
		else if ("unzip".equals(action))		{runUnzip(f10);}
		else if ("unembed".equals(action))		{runUnembed(f10);}
		else if ("transform".equals(action))	{runTransform(f10);}
		else if ("tag".equals(action))			{runTag(f10);}
		else if ("image".equals(action))		{runImage(f10);}
		else if ("book".equals(action))			{runBook(f10);}
		else if ("similarity".equals(action))	{runSimilarity(f10);}
		else if ("help".equals(action))			{CliPrint.printHelp(f10.getCliParams().getCommandLine(), f10.getCliParams().getOpt()); }
		else if ("credits".equals(action))		{CliPrint.printCredits();}
	}
	
}
