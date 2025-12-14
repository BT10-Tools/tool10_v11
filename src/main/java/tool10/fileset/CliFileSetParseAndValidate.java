package tool10.fileset;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.ParseException;

import tool10.util.FileUtil;
import tool10.util.StrUtil;

public class CliFileSetParseAndValidate {

	private static String processDirList(CliParameter p, CommandLine cmd)	{
		String str = cmd.getOptionValue("dirlist"); 
		String[] dirList = StrUtil.getDirAndFileList(str);
		if ((dirList==null) || (dirList.length<=0)) return("error");
		for (String dirStr : dirList)	{
			if (!FileUtil.checkDirectoryExists(dirStr))	{
				System.out.println("A directory with the given name does not exist, directory name:"+dirStr);
				return("error");
			}
		}
		p.setDirArray(dirList);
		return("ok");
	}
	private static String processFileList(CliParameter p, CommandLine cmd)	{
		String str = cmd.getOptionValue("filelist"); 
		String[] fileList = StrUtil.getDirAndFileList(str);
		if ((fileList==null) || (fileList.length<=0)) return("error");
		for (String fileStr : fileList)	{
			if (!FileUtil.checkFileExists(fileStr))	{
				System.out.println("A file with the given name does not exist, file name:"+str);
				return("error");
			}
		}
		p.setFileArray(fileList);
		return("ok");
	}
	private static String getYesNo(CliParameter p, CommandLine cmd, String paramName, String defaultValue)	{
		String str = cmd.getOptionValue(paramName); 
		if (str==null) {
			System.out.println("The "+paramName+" flag is null, values yes, y, no, n,   default "+defaultValue+" ");
			return(null);
		}
		String str1 = str.toLowerCase();
		if 		(("yes".equals(str1)) || ("y".equals(str1))) {return("yes");}
		else if (( "no".equals(str1)) || ("n".equals(str1))) {return("no");}
		else {
			System.out.println("The "+paramName+" flag is not as expected (values yes, y, no, n,   default "+defaultValue+")  ,value:"+str1 );
			return(null);
		}
	}
	public static String checkCliParametersGeneral(CliParameter p, CommandLine cmd) {
		/*
		options.addOption("help", false, "Print the help message.");
		options.addOption("credits", false, "Print the credits message.");
	    options.addOption("user", true, "The user to connect to the tool10.");
	    options.addOption("password", true, "The password for the user.");
	   
	    */
		if (cmd.hasOption("help")) 		{ 	String str = cmd.getOptionValue("help"); p.setHelp(str);	p.setAction("help"); return("help");}
		if (cmd.hasOption("credits")) 	{	String str = cmd.getOptionValue("credits"); p.setCredits(str);	p.setAction("credits"); return("credits");}
		if (cmd.hasOption("user")) 		{	String str = cmd.getOptionValue("user"); p.setUser(str);	}
	    if (cmd.hasOption("password")) 	{	String str = cmd.getOptionValue("password"); p.setPassword(str);	}	 
	    return(null);
	}
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
	    options.addOption("blob", true, "The flag to load the file to database as blob, yes or no, default yes");
	    options.addOption("compression", true, "The flag to compress the content of the files as blob, yes or no, default yes");
	    options.addOption("compressionlevel", true, "The level of compression, an integer from 1 to 9, default 9");
	    options.addOption("encryption", true, "The flag to encrypt the content of the files as blob, yes or no, default yes");
	    options.addOption("encryptionkey", true, "The encryption key, required if encryption is yes");
	    options.addOption("encryptionalg", true, "The encryption algorithm, shuffle10 and others, default shufle10");
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
			String statusDirList = processDirList(p,cmd);
			if ("error".equals(statusDirList))	return(null);
		}
	    if (cmd.hasOption("filelist")) 	{	
	    	String statusFileList = processFileList(p,cmd);
	    	if ("error".equals(statusFileList))	return(null);
	    }
	    if (cmd.hasOption("blob")) 	{	
	    	String str = getYesNo(p,cmd, "blob","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlob(str);
	    }
	    if (cmd.hasOption("bloboriginal")) 	{	
	    	String str = getYesNo(p,cmd, "bloboriginal","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobOriginal(str);
	    }
	    if (cmd.hasOption("blobcompressed")) 	{	
	    	String str = getYesNo(p,cmd, "blobcompressed","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobCompressed(str);
	    }
	    if (cmd.hasOption("blobencrypted")) 	{	
	    	String str = getYesNo(p,cmd, "blobencrypted","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobEncrypted(str);
	    }
	    if (cmd.hasOption("compression")) 	{	
	    	String str = getYesNo(p,cmd, "compression","yes"); 
	    	if (str==null) return(null); 
	    	p.setCompression(str);
    	}
	    if (cmd.hasOption("compressiontype")) 	{	
	    	String str = cmd.getOptionValue("compressiontype").trim().toLowerCase();  //gzip, deflate
	    	if (str==null) return(null); 
	    	if ((!"gzip".equals(str)) && (!"deflate".equals(str)))	{
	    		System.out.println("The compression type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setCompressionType(str);
    	}
	    if (cmd.hasOption("compressionlevel")) 	{	
	    	String str = cmd.getOptionValue("compressionlevel"); 
	    	int compressionLevel = StrUtil.parseStr2Int(str);
	    	if ((compressionLevel<1) || (compressionLevel>9))	{
	    		System.out.println("The compression level is not as expected (values are integers between 1-9, value:"+str);
	    		//return(null);
	    	} else {
	    		p.setCompressionLevel(Integer.toString(compressionLevel));
	    	}
	    }
	    if (cmd.hasOption("encryption")) 	{	
	    	String str = getYesNo(p,cmd, "encryption","yes"); 
	    	if (str==null) return(null); 
	    	p.setEncryption(str);
	    }
	    if (cmd.hasOption("encryptionkey")) 	{	String str = cmd.getOptionValue("encryptionkey"); p.setEncryptionKey(str);	}
	    if (cmd.hasOption("encryptionalg")) 	{	String str = cmd.getOptionValue("encryptionalg"); p.setEncryptionAlg(str);	}
	    
	    if (cmd.hasOption("host")) 	{	
	    	String str = getYesNo(p,cmd, "host","yes"); 
	    	if (str==null) return(null); 
	    	p.setHost(str);
	    }
	    if (cmd.hasOption("filesystem")) 	{	
	    	String str = getYesNo(p,cmd, "filesystem","yes"); 
	    	if (str==null) return(null); 
	    	p.setFileSystem(str);
	    }
	    if (cmd.hasOption("filestore")) 	{		 
	    	String str = getYesNo(p,cmd, "filestore","yes"); 
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
		if ((!"yes".equals(p.getCompression())) && (p.getCompressionLevel()!=null)) 	{	
			System.out.println("CliFileSetParseAndValidate postProcessingLoad compression level is entered but compression is not selected");
			return("warning");
		}
		if ("yes".equals(p.getCompression()))	{
			if (p.getCompressionType()==null)	{p.setCompressionType("gzip");}
			if (p.getCompressionLevel()==null)	{p.setCompressionLevel("9");}
		}
		if ("yes".equals(p.getBlobOriginal()))	{
			if (!"yes".equals(p.getBlob())) p.setBlobOriginal("no");
		}
		if ("yes".equals(p.getBlobCompressed()))	{
			if (!"yes".equals(p.getCompression())) p.setBlobCompressed("no");
			if (!"yes".equals(p.getBlob())) p.setBlobCompressed("no");
		}
		if ("yes".equals(p.getBlobEncrypted()))	{
			if (!"yes".equals(p.getEncryption())) p.setBlobEncrypted("no");
			if (!"yes".equals(p.getBlob())) p.setBlobEncrypted("no");
		}
		if ("no".equals(p.getBlobEncrypted()))	{
			if (("yes".equals(p.getEncryption())) && ("yes".equals(p.getBlob()))) {
				p.setBlobEncrypted("yes");
			}
		}
		return("ok");
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
	    if (cmd.hasOption("unzip")) 	{	String str = cmd.getOptionValue("unzip"); p.setExtract(str);	p.setAction("unzip");	}
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
	    if (cmd.hasOption("unembed")) 	{	String str = cmd.getOptionValue("unembed"); p.setExtract(str);	p.setAction("unembed");	}
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
	    if (cmd.hasOption("transform")) 	{	String str = cmd.getOptionValue("transform"); p.setExtract(str);	p.setAction("transform");	}
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
	    String postResult = postProcessingUnembed(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("transform");
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
	public static String checkCliParametersSimilarity(CliParameter p, CommandLine cmd) {	
		/*
	    options.addOption("similarity", false, "Do similarity analysis of files and directories");
	    options.addOption("similarityalg", true, "similarity algorithms, all, duplicates, duplicatefile, duplicatedir, filename. default is all");	   
	    */
	    if (cmd.hasOption("similarity")) 	{	String str = cmd.getOptionValue("similarity"); p.setSimilarity(str);	p.setAction("similarity");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("similaritytype")) 	{	
	    	String str = cmd.getOptionValue("similaritytype"); 
	    	p.setSimilarityType(str);	
	    	if (!"all".equals(p.getSimilarityType())) {
	    		System.out.println("similaritytype type is not as expected:"+p.getSimilarityType()+ "  ,set to all");
	    		p.setSimilarityType("all");
	    	}	
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
	    if (cmd.hasOption("similarityalg")) 	{	String str = cmd.getOptionValue("similarityalg"); p.setSimilarityAlg(str);	}
	    if (cmd.hasOption("similaritylevel")) 	{	String str = cmd.getOptionValue("similaritylevel"); p.setSimilarityLevel(str);	}
	    return("similarity");
	}
	public static String checkAndUpdateAllCliParameters(CliParameter p, CommandLine cmd) {
		String action =checkCliParametersGeneral(p,cmd);
		if (action!=null) return("ok"); 
		action = checkCliParametersLoad(p,cmd);
		if ("load".equals(action)) return("ok"); 
		action = checkCliParametersExtract(p,cmd);
		if ("extract".equals(action)) return("ok"); 
		action = checkCliParametersUnzip(p,cmd);
		if ("unzip".equals(action)) return("ok"); 
		action = checkCliParametersUnembed(p,cmd);
		if ("unembed".equals(action)) return("ok"); 
		action = checkCliParametersTransform(p,cmd);
		if ("transform".equals(action)) return("ok"); 
		action = checkCliParametersSimilarity(p,cmd);
		if ("similarity".equals(action)) return("ok"); 
		return("error");
		
	}
	public static String parseAndValidateCommandLineArguments(CliParameter cliP) {
		if (cliP==null)	{
			System.out.println("CliFileSetParseAndValidate parseAndValidateCommandLineArguments cli Parameters are not as expected");
			cliP.setParseAndValidateStatus("error");
			return("error");
		}
		try {
		    @SuppressWarnings("deprecation")
			CommandLineParser parser = new GnuParser(); //DefaultParser();
		    CommandLine cmd = parser.parse(cliP.getOpt(), cliP.getArgs());
		    if (cmd!=null)	{
		    	System.out.println("CliFileSetParser parseAndValidateCommandLineArguments cmd.getOptions().length:"+cmd.getOptions().length);
		    	cliP.setCommandLine(cmd);
		    	//showHelp(cmd,options);
		    	String parseAndValidateStatus = checkAndUpdateAllCliParameters(cliP,cmd);
		    	cliP.setParseAndValidateStatus(parseAndValidateStatus);
		    	return(parseAndValidateStatus);
		    } else {
		    	System.out.println("CliFileSetParser parseAndValidateCommandLineArguments cmd is null");
		    	cliP.setParseAndValidateStatus("error");
		    	return("error");
		    }
		} catch (ParseException e)	{			
			System.out.println("CliFileSetParser parseAndValidateCommandLineArguments ParseException e:"+e.getStackTrace().toString());
			e.printStackTrace();
			cliP.setParseAndValidateStatus("error");
			return("error");
		}	
		//return(cliP);
	}
}
