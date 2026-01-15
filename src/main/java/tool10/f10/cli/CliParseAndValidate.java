package tool10.f10.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.ParseException;

import tool10.util.FileUtil;
import tool10.util.StrUtil;

public class CliParseAndValidate {

	public static String processDirList(CliParameter p, CommandLine cmd)	{
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
	public static String processFileList(CliParameter p, CommandLine cmd)	{
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
	public static String getYesNo(CliParameter p, CommandLine cmd, String paramName, String defaultValue)	{
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
	public static boolean checkAttachmentName(String str)	{
		//the attachment name rules will be added 
		return(true);
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
	public static String checkAndUpdateAllCliParameters(CliParameter p, CommandLine cmd) {
		String action =checkCliParametersGeneral(p,cmd);
		if (action!=null) return("ok"); 				
		action = CliParseAndValidateFileSet.checkCliParametersLoad(p,cmd);			if ("load".equals(action)) return("ok"); 		
		action = CliParseAndValidateFileSet.checkCliParametersRead(p,cmd);			if ("read".equals(action)) return("ok"); 	
		action = CliParseAndValidateFileSet.checkCliParametersExtract(p,cmd);		if ("extract".equals(action)) return("ok"); 	
		action = CliParseAndValidateFileSet.checkCliParametersUnzip(p,cmd);			if ("unzip".equals(action)) return("ok"); 		
		action = CliParseAndValidateFileSet.checkCliParametersUnembed(p,cmd);		if ("unembed".equals(action)) return("ok"); 	
		action = CliParseAndValidateFileSet.checkCliParametersTransform(p,cmd);		if ("transform".equals(action)) return("ok");
		
		action = CliParseAndValidateBlob.checkCliParametersLoadBlob(p,cmd);			if ("loadblob".equals(action)) return("ok"); 	
		
		action = CliParseAndValidateOtherSets.checkCliParametersTag(p,cmd);			if ("tag".equals(action)) return("ok"); 	
		action = CliParseAndValidateOtherSets.checkCliParametersMedia(p,cmd);		if ("media".equals(action)) return("ok"); 	
		action = CliParseAndValidateOtherSets.checkCliParametersDoc(p,cmd);			if ("doc".equals(action)) return("ok"); 	
		action = CliParseAndValidateOtherSets.checkCliParametersSimilarity(p,cmd);	if ("similarity".equals(action)) return("ok");
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
