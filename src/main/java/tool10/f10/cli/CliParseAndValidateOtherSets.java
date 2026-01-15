package tool10.f10.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.ParseException;

import tool10.util.FileUtil;
import tool10.util.StrUtil;

public class CliParseAndValidateOtherSets {

	private static long MB = 1024 * 1024;
	private static long GB = 1024 * 1024 * 1024; 
	
	public static String checkCliParametersTag(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("tag")) 	{	String str = cmd.getOptionValue("tag"); p.setTag(str);	p.setAction("tag");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("tagengine")) 	{	
	    	String str = cmd.getOptionValue("tagengine").trim().toLowerCase();  //tikatag, wintag, 
	    	if (str==null) return(null); 
	    	if ((!"tikatag".equals(str)) && (!"wintag".equals(str)) )	{
	    		System.out.println("The tag engine is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setTagEngine(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("tagdbname")) 	{	
			String str = cmd.getOptionValue("tagdbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Tag Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setTagDbName(str);
		}
	    if (cmd.hasOption("tagdbaction")) 	{	
	    	String str = cmd.getOptionValue("tagdbaction"); 
	    	p.setTagDbAction(str);	
	    	if (str==null) {p.setTagDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setTagDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setTagDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("tagsetname")) 	{	
  			String str = cmd.getOptionValue("tagsetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("tagsetname is not as expected: tagsetname "+str);
  				return(null);
  			} 
  			p.setTagSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingTag(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("tag");
	}
	public static String checkCliParametersMedia(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("media")) 	{	String str = cmd.getOptionValue("media"); p.setMedia(str);	p.setAction("media");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("mediatype")) 	{	
	    	String str = cmd.getOptionValue("mediatype").trim().toLowerCase();  //image, video, audio
	    	if (str==null) return(null); 
	    	if ((!"image".equals(str)) && (!"video".equals(str)) && (!"audio".equals(str)))	{
	    		System.out.println("The media type (image, video, audio) is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setMediaType(str);
    	}
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("mediadbname")) 	{	
			String str = cmd.getOptionValue("mediadbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Tag Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setMediaDbName(str);
		}
	    if (cmd.hasOption("mediadbaction")) 	{	
	    	String str = cmd.getOptionValue("mediadbaction"); 
	    	p.setMediaDbAction(str);	
	    	if (str==null) {p.setMediaDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setMediaDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setMediaDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("mediasetname")) 	{	
  			String str = cmd.getOptionValue("mediasetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("mediasetname is not as expected: mediasetname "+str);
  				return(null);
  			} 
  			p.setMediaSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingMedia(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("media");
	}
	public static String checkCliParametersDoc(CliParameter p, CommandLine cmd) {	
	    //*****
	    if (cmd.hasOption("doc")) 	{	String str = cmd.getOptionValue("doc"); p.setDoc(str);	p.setAction("doc");	}
	    else {
	    	return (null);
	    }
	    if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
	    if (cmd.hasOption("docdbname")) 	{	
			String str = cmd.getOptionValue("docdbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Tag Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDocDbName(str);
		}
	    if (cmd.hasOption("docdbaction")) 	{	
	    	String str = cmd.getOptionValue("docdbaction"); 
	    	p.setDocDbAction(str);	
	    	if (str==null) {p.setDocDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setDocDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setDocDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("filesetname")) 	{	
  			String str = cmd.getOptionValue("filesetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("filesetname is not as expected: filesetname "+str);
  				return(null);
  			} 
  			p.setFileSetName(str);
  		}
	    if (cmd.hasOption("docsetname")) 	{	
  			String str = cmd.getOptionValue("docsetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("docsetname is not as expected: docsetname "+str);
  				return(null);
  			} 
  			p.setDocSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    String postResult = postProcessingDoc(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("doc");
	}

	private static String postProcessingTag(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingMedia(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingDoc(CliParameter p, CommandLine cmd) {
		return("ok");
	}
	private static String postProcessingSimilarity(CliParameter p, CommandLine cmd) {
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
	    if (cmd.hasOption("similaritytype")) 	{	//all, file, dir, book, image, video, audio 
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
	    if (cmd.hasOption("setname")) 	{	
  			String str = cmd.getOptionValue("setname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("setname is not as expected: setname "+str);
  				return(null);
  			} 
  			p.setSetName(str);
  		}
	    if (cmd.hasOption("simsetname")) 	{	
  			String str = cmd.getOptionValue("simsetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("simsetname is not as expected: simsetname "+str);
  				return(null);
  			} 
  			p.setSimSetName(str);
  		}
	    if (cmd.hasOption("tempdir")) 	{	
			String str = cmd.getOptionValue("tempdir"); 
		/*	if (FileUtil.checkDirectoryExists(str))	{
				System.out.println("A directory with the given name exist, directory name:"+str);
				return(null);
			}*/
			p.setTempDir(str);
		}
	    if (cmd.hasOption("simdbname")) 	{	
			String str = cmd.getOptionValue("simdbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Tag Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setSimDbName(str);
		}
	    if (cmd.hasOption("simdbaction")) 	{	
	    	String str = cmd.getOptionValue("simdbaction"); 
	    	p.setSimDbAction(str);	
	    	if (str==null) {p.setSimDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setSimDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setSimDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("similarityalg")) 	{	String str = cmd.getOptionValue("similarityalg"); p.setSimilarityAlg(str);	}
	    if (cmd.hasOption("similaritylevel")) 	{	String str = cmd.getOptionValue("similaritylevel"); p.setSimilarityLevel(str);	}
	    String postResult = postProcessingSimilarity(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("similarity");
	}
}
