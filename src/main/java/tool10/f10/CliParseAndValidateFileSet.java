package tool10.f10;

import org.apache.commons.cli.CommandLine;

import tool10.util.FileUtil;
import tool10.util.StrUtil;

public class CliParseAndValidateFileSet {


	public static String checkCliParametersLoad(CliParameter p, CommandLine cmd) {
		/*
	    options.addOption("dbtype", true, "The name of the database, default is 'sqlite'. ser serialization file. in future pg, oracle, mysql,...");
	    options.addOption("dbaction", true, "The name of the sqlite filename");
	    options.addOption("dbreadonly", true, "yes, no. default no. The database readonly access mode ");
	    options.addOption("dbmem", true, "The database will be in memory");
	    options.addOption("dbname", true, "The name of the database/filename");
		
	    options.addOption("load", false, "Loading directories and files to sqlite database");
	    options.addOption("dir", true, "The source directory name"); //String sourceDirName	= args[0]; 
	    options.addOption("file", true, "The source file name");  
	    options.addOption("host", true, "The flag to load the host information or not, yes or no, default yes");
	    options.addOption("filesystem", true, "The flag to load the filesystem information or not, yes or no, default yes");
	    options.addOption("filestore", true, "The flag to load the filestore information or not, yes or no, default yes");

		options.addOption("filter",true, "filtering Wild Card , eg. *.dbf, *.pdf, *.exe, *john*.* "); //onlyWildCard
	    options.addOption("exclude",true, "exclude Wild Card , eg. *.dbf, *.pdf, *.exe, *john*.* "); //excludeWildcard
	    options.addOption("minchangedate", true, "Minimum file creation and modification time, in YYYYMMDDHH24MISS format eg. 20210512, 20210512120000, 202105, default:None"); //firstTouchDate
		
		options.addOption("minFileSize", true, "Minimum Filesize, eg. 16777216, 8M, 16M, minimum 0, , default:0"); //minFileSize
		options.addOption("maxFileSize", true, "Maximum Filesize, eg. 16777216, 8M, 16M, minimum 0, , default:Infinite"); //maxFileSize
		    
	    options.addOption("log", true, "The log File Name");	//logFileName
	    options.addOption("error", true, "The error File Name");	//errorFileName
			   
	    */
		/*
		
		if (f10.getCliParams().getDbName()==null) {
			System.out.println("Database name is not as expected:"+f10.getCliParams().getDbName());
			return(null);
		}
		*/
	    if (cmd.hasOption("load")) 	{	String str = cmd.getOptionValue("load"); p.setLoad(str);	p.setAction("load"); }
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("dbtype")) 	{	
	    	String str = cmd.getOptionValue("dbtype"); 
	    	p.setDbType(str);	
	    	if (!"sqlite".equals(p.getDbType())) {
	    		System.out.println("Database type is not as expected:"+p.getDbType()+ "  ,set to sqlite");
	    		p.setDbType("sqlite");
	    	}	
		}
	    if (cmd.hasOption("dbaction")) 	{	
	    	String str = cmd.getOptionValue("dbaction"); 
	    	p.setDbAction(str);	
	    	if (str==null) {p.setDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("dbreadonly")) 	{	String str = cmd.getOptionValue("dbreadonly"); p.setDbReadOnly(str);	}
	    if (cmd.hasOption("dbmem")) 		{	String str = cmd.getOptionValue("dbmem"); p.setDbMem(str);	}
	    if (cmd.hasOption("filesetname")) 	{	String str = cmd.getOptionValue("filesetname"); p.setFileSetName(str);	}
		if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
		if (cmd.hasOption("dir")) 	{	
			String str = cmd.getOptionValue("dir"); 
			if (!FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name does not exist, directory name:"+str);
				return(null);
			}
			p.setDir(str);
		}
		if (cmd.hasOption("dirlist")) 	{
			String statusDirList = CliParseAndValidate.processDirList(p,cmd);
			if ("error".equals(statusDirList))	return(null);
		}
	    if (cmd.hasOption("filelist")) 	{	
	    	String statusFileList = CliParseAndValidate.processFileList(p,cmd);
	    	if ("error".equals(statusFileList))	return(null);
	    }
	    
	    if (cmd.hasOption("host")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "host","yes"); 
	    	if (str==null) return(null); 
	    	p.setHost(str);
	    }
	    if (cmd.hasOption("filesystem")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "filesystem","yes"); 
	    	if (str==null) return(null); 
	    	p.setFileSystem(str);
	    }
	    if (cmd.hasOption("filestore")) 	{		 
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "filestore","yes"); 
    		if (str==null) return(null); 
    		p.setFileStore(str);
    	}
	    if (cmd.hasOption("minfilesize")) 	{	
	    	String str = cmd.getOptionValue("minfilesize"); 
	    	int minFileSize = StrUtil.parseStr2Int(str);
	    	if ((minFileSize<0) || (minFileSize>256*1024*1024))	{
	    		System.out.println("The minfilesize is not as expected (values between 0 and 268.435.456 / 256MB, value:"+str);
	    		//return(null);
	    	} else {
	    		p.setMinFileSize(Integer.toString(minFileSize));
	    	}
	    }
	    if (cmd.hasOption("maxfilesize")) 	{	
	    	String str = cmd.getOptionValue("maxfilesize"); 
	    	int maxFileSize = StrUtil.parseStr2Int(str);
	    	if ((maxFileSize<0) || (maxFileSize>256*1024*1024))	{
	    		System.out.println("The maxfilesize is not as expected (values between 0 and 256*1024*1024, value:"+str);
	    		//return(null);
	    	} else {
	    		p.setMaxFileSize(Integer.toString(maxFileSize));
	    	}
	    }
	    
	    //if (cmd.hasOption("filter")) 	{	String str = cmd.getOptionValue("filter"); p.setFilter(str);	}
	    //if (cmd.hasOption("exclude")) 	{	String str = cmd.getOptionValue("exclude"); p.setExclude(str);	}
	    //if (cmd.hasOption("minchangedate")) 	{	String str = cmd.getOptionValue("minchangedate"); p.setMinChangeDate(str);	}
	    //if (cmd.hasOption("minFileSize")) 	{	String str = cmd.getOptionValue("minFileSize"); p.setMinFileSize(str);	}
	    //if (cmd.hasOption("maxFileSize")) 	{	String str = cmd.getOptionValue("maxFileSize"); p.setMaxFileSize(str);	}
	    //if (cmd.hasOption("log")) 	{	String str = cmd.getOptionValue("log"); p.setLog(str);	}
	    //if (cmd.hasOption("error")) 	{	String str = cmd.getOptionValue("error"); p.setError(str);	}
	    
	    String postResult = postProcessingLoad(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("load");
	}
	private static long MB = 1024 * 1024;
	private static long GB = 1024 * 1024 * 1024; 
	 

	private static String postProcessingLoad(CliParameter p, CommandLine cmd) {
		if ("renewdb".equals(p.getDbAction()))	{
			FileUtil.deleteFileIfExists(p.getDbName());	
			if (FileUtil.checkFileExists(p.getDbName()))	{
				System.out.println("CliFileSetParseAndValidate postProcessingLoad error the dbfile still exists dbName:"+p.getDbName());	
				return("error");
			}
		}
		if ("newdb".equals(p.getDbAction()))	{
			if (FileUtil.checkFileExists(p.getDbName()))	{
				System.out.println("CliFileSetParseAndValidate postProcessingLoad A file or directory with the given database name exists, database name:"+p.getDbName());
				return("error");
			}
		}
		return("ok");
	}

	public static String checkCliParametersRead(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("read")) 	{	String str = cmd.getOptionValue("read"); p.setRead(str);	p.setAction("read");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("readtype")) 	{	
	    	String str = cmd.getOptionValue("readtype").trim().toLowerCase();  //all, 
	    	if (str==null) return(null); 
	    	if (!"all".equals(str))	{
	    		System.out.println("The read type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setReadType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    String postResult = postProcessingRead(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("read");
	}
	public static String checkCliParametersExtract(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("extract")) 	{	String str = cmd.getOptionValue("extract"); p.setExtract(str);	p.setAction("extract");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("extracttype")) 	{	
	    	String str = cmd.getOptionValue("extracttype").trim().toLowerCase();  //all, dir, flattenedfiles
	    	if (str==null) return(null); 
	    	if ((!"all".equals(str)) && (!"dir".equals(str)))	{
	    		System.out.println("The extract type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setExtractType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("extractdir")) 	{	
			String str = cmd.getOptionValue("extractdir"); 
			if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}
			p.setDir(str);
		}
	    String postResult = postProcessingExtract(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("extract");
	}
	public static String checkCliParametersExport(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("export")) 	{	String str = cmd.getOptionValue("export"); p.setExport(str);	p.setAction("export");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("exporttype")) 	{	
	    	String str = cmd.getOptionValue("exporttype").trim().toLowerCase();  //extract type csv, html, blob
	    	if (str==null) return(null); 
	    	if ((!"csv".equals(str)) && (!"html".equals(str)) && (!"blob".equals(str)))	{
	    		System.out.println("The extract type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setExportType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("exportdir")) 	{	
			String str = cmd.getOptionValue("exportdir"); 
			if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}
			p.setExportDir(str);
		}
	    String postResult = postProcessingExport(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("extract");
	}
	public static String checkCliParametersUnzip(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("unzip")) 	{	String str = cmd.getOptionValue("unzip"); p.setUnzip(str);	p.setAction("unzip");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("unziptype")) 	{	
	    	String str = cmd.getOptionValue("unziptype").trim().toLowerCase();  //recursive, directory, file
	    	if (str==null) return(null); 
	    	if ((!"recursive".equals(str)) && (!"directory".equals(str)) && (!"file".equals(str)))	{
	    		System.out.println("The unzip type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setUnzipType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("outputfilesetname")) 	{	
  			String str = cmd.getOptionValue("outputfilesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("outputfilesetname is not as expected: outputfilesetname "+str);
  				return(null);
  			} 
  			p.setOutputFileSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingUnzip(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("unzip");
	}
	public static String checkCliParametersUnembed(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("unembed")) 	{	String str = cmd.getOptionValue("unembed"); p.setUnembed(str);	p.setAction("unembed");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("unembedtype")) 	{	
	    	String str = cmd.getOptionValue("unembedtype").trim().toLowerCase();  //imagesFromPdf, pdfPagesAsImages
	    	if (str==null) return(null); 
	    	if ((!"imagesfrompdf".equals(str)) && (!"pdfpagesasimages".equals(str)) )	{
	    		System.out.println("The unembed type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setUnzipType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("outputfilesetname")) 	{	
  			String str = cmd.getOptionValue("outputfilesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("outputfilesetname is not as expected: outputfilesetname "+str);
  				return(null);
  			} 
  			p.setOutputFileSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingUnembed(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("unembed");
	}
	public static String checkCliParametersTransform(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("transform")) 	{	String str = cmd.getOptionValue("transform"); p.setTransform(str);	p.setAction("transform");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("transformtype")) 	{	
	    	String str = cmd.getOptionValue("transformtype").trim().toLowerCase();  //jpg2png, png2jpg
	    	if (str==null) return(null); 
	    	if ((!"jpg2png".equals(str)) && (!"png2jpg".equals(str)) )	{
	    		System.out.println("The transform type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setUnzipType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("outputfilesetname")) 	{	
  			String str = cmd.getOptionValue("outputfilesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("outputfilesetname is not as expected: outputfilesetname "+str);
  				return(null);
  			} 
  			p.setOutputFileSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingTransform(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("transform");
	}
	private static String postProcessingRead(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingExtract(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingExport(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingUnzip(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingUnembed(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingTransform(CliParameter p, CommandLine cmd) {
		return("ok");
	}	
}
