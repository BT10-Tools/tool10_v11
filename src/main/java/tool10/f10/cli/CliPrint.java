package tool10.f10.cli;

import java.io.PrintWriter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CliPrint {

	public static String showCommandLine(CliParameter cliP)	{
		if ((cliP==null) || (cliP.getCommandLine()==null) || (cliP.getCommandLine().getOptions()==null))	{
			return(null);
		}
		Options options = cliP.getOpt();
		CommandLine cmd = cliP.getCommandLine();
		
	    StringBuilder sb  = new StringBuilder();
		
	    System.out.println("showCommandLine cmd.getOptions().length:" + cmd.getOptions().length+" , options.getOptions().size():"+options.getOptions().size());
			
		for (int i=0; i<cmd.getOptions().length; i++)	{
			if ((cmd.hasOption(cmd.getOptions()[i].getOpt())) && (cmd.getOptions()[i].getValue()!=null))	{
				sb.append("["+i+"]=(\""+cmd.getOptions()[i].getOpt()+"\",\""+cmd.getOptions()[i].getValue()+"\"),\n");
			}
		}
		String ss = sb.toString();
		System.out.println("showCommandLine ss:" + ss);
		System.out.println("showCommandLine ========================:\n");
		System.out.println("showCommandLine cliP.showStr():\n" + cliP.showStr()+"\n");
		
		return(ss);
	}
	private static void showHelp(CommandLine cmd, Options options) {
		HelpFormatter formatter = new HelpFormatter();
		if (cmd==null) return;
		if (options==null) return;
	    if (cmd.hasOption("help")) {
	    	//formatter.printUsage(options);
	    	 final PrintWriter writer = new PrintWriter(System.out);
		     formatter.printUsage(writer,80,"CLITester", options);
		     writer.flush();
	    } else {
	    	
	    }

	    if (!(cmd.hasOption("url") && cmd.hasOption("mode") && cmd.hasOption("destination"))) {
	        ////printUsage(options);
	    }
	}    
	public static void printHelp(CommandLine cmd, Options options)	{
		System.out.println("Buraya help satırları gelecek");
		CliPrint.showHelp(cmd, options);
		//
	}
	public static void printCredits()	{
		System.out.println("Buraya credits satırları gelecek");
		//
	}
}
