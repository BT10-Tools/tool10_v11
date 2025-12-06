package tool10.fileset;

import org.apache.commons.cli.Options;

public class CliFileSetInitialize {

	private static int getOptionsGeneral(Options options) {
		//dir..\java.exe -jar tool10.jar -file10 -help 
		//dir..\java.exe -jar tool10.jar -file10 -credits 
		//dir..\java.exe -jar tool10.jar -file10 -db "c:\\tmp\\sqliteDbName.db" -load -dir "c:\*tmp" 
		
		int cntOptions = options.getOptions().size();
		
		options.addOption("help", false, "Print the help message.");
		options.addOption("credits", false, "Print the credits message.");
	    //options.addOption("user", true, "The user to connect to the tool10.");
	    //options.addOption("password", true, "The password for the user.");
	    
	    return(options.getOptions().size() - cntOptions);
	}
	private static int getOptionsLoad(Options options) {
		
		int cntOptions = options.getOptions().size();
	    
	    options.addOption("dbtype", true, "The name of the database, default is 'sqlite'. ser serialization file. in future pg, oracle, mysql,...");
	    options.addOption("dbaction", true, "The action for the database, newdb, renewdb, newfileset, appendfile, usedb, default is newdb");
	    //options.addOption("dbreadonly", true, "yes, no. default no. The database readonly access mode ");
	    //options.addOption("dbmem", true, "The database will be in memory");
		options.addOption("filesetname", true, "The name of the file set");
		options.addOption("dbname", true, "The name of the database/filename");
		
	    options.addOption("load", false, "Loading directories and files to sqlite database");
	    options.addOption("dir", true, "The source directory name"); //String sourceDirName	= args[0]; 
	    options.addOption("dirlist", true, "The source directory name list, like \"'dir1','dir2','dir3' \" ");
	    options.addOption("file", true, "The source file name");  
	    options.addOption("filelist", true, "The source file name list, like \"'file1.xxx','file2.sss'\" ");  
	    options.addOption("blob", true, "The flag to load the file to database as blob, yes or no, default yes");
	    options.addOption("bloboriginal", true, "The flag to load the original file to database as blob, yes or no, default yes");
	    options.addOption("blobcompressed", true, "The flag to load the comprssed file to database as blob, yes or no, default yes");
	    options.addOption("blobencrypted", true, "The flag to load the enrypted file to database as blob, yes or no, default yes");
	    options.addOption("compression", true, "The flag to compress the content of the files as blob, yes or no, default yes");
	    options.addOption("compressiontype", true, "The algorithm for compression");
		options.addOption("compressionlevel", true, "The level of compression, an integer from 1 to 9, default 9");
	    options.addOption("encryption", true, "The flag to encrypt the content of the files as blob, yes or no, default yes");
	    //options.addOption("encryptionkey", true, "The encryption key, required if encryption is yes");
	    //options.addOption("encryptionalg", true, "The encryption algorithm, shuffle10 and others, default shufle10");
	    options.addOption("host", true, "The flag to load the host information or not, yes or no, default yes");
	    options.addOption("filesystem", true, "The flag to load the filesystem information or not, yes or no, default yes");
	    options.addOption("filestore", true, "The flag to load the filestore information or not, yes or no, default yes");

		//options.addOption("filter",true, "filtering Wild Card , eg. *.dbf, *.pdf, *.exe, *john*.* "); //onlyWildCard
	    //options.addOption("exclude",true, "exclude Wild Card , eg. *.dbf, *.pdf, *.exe, *john*.* "); //excludeWildcard
	    //options.addOption("minchangedate", true, "Minimum file creation and modification time, in YYYYMMDDHH24MISS format eg. 20210512, 20210512120000, 202105, default:None"); //firstTouchDate
		
		//options.addOption("minFileSize", true, "Minimum Filesize, eg. 16777216, 8M, 16M, minimum 0, , default:0"); //minFileSize
		//options.addOption("maxFileSize", true, "Maximum Filesize, eg. 16777216, 8M, 16M, minimum 0, , default:Infinite"); //maxFileSize
		    
	    //options.addOption("log", true, "The log File Name");	//logFileName
	    //options.addOption("error", true, "The error File Name");	//errorFileName
		
		return(options.getOptions().size() - cntOptions);
	}
	private static int getOptionsExtract(Options options) {
		int cntOptions = options.getOptions().size();
	    options.addOption("extract", false, "extracting directories and files from sqlite database");
	    options.addOption("extracttype", true, "extract type all, dir, flattenedfiles");
	    options.addOption("dbname", true, "The name of the database/filename");
	    options.addOption("filesetname", true, "The name of the file set");
		options.addOption("extractdir", true, "The directory name for extracting, default is current directory");
		    
		return(options.getOptions().size() - cntOptions);
	}
	private static int getOptionsExport(Options options) {
		int cntOptions = options.getOptions().size();
	    options.addOption("export", false, "extracting directories and files from sqlite database");
	    options.addOption("exporttype", true, "extract type csv, html, blob");
	    options.addOption("dbname", true, "The name of the database/filename");
	    options.addOption("filesetname", true, "The name of the file set");
		options.addOption("exportdir", true, "The directory name for exports, default is current directory");
		    
		return(options.getOptions().size() - cntOptions);
	}
	private static int getOptionsSimilarity(Options options) {
		int cntOptions = options.getOptions().size();
		//dbname, filesetname
		
		options.addOption("similarity", false, "Do similarity analysis of files and directories");
		options.addOption("similaritytype", false, "The similarity type all, default all");
		//options.addOption("similarityalg", true, "similarity algorithms, all, duplicates, duplicatefile, duplicatedir, filename. default is all");
		    
		return(options.getOptions().size() - cntOptions);
	}
	public static CliParameter initializeParameters(String[] args0) {
		if (args0.length<=0) return(null);
		Options options = new Options();
		getOptionsGeneral(options);
		getOptionsLoad(options);
		getOptionsExtract(options);
		getOptionsExport(options);
		getOptionsSimilarity(options);
		
		System.out.println("CliFileSetParser processParameters options.getOptions().size():"+options.getOptions().size());
		
		CliParameter cliP = new CliParameter(args0,options);
		System.out.println("CliFileSetParser processParameters cliP:"+cliP+"   , cliP.getOpt().getOptions().size():"+cliP.getOpt().getOptions().size());
		
		return(cliP);
	}
	
}
