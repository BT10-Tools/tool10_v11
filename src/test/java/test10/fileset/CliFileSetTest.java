package test10.fileset;

import tool10.f10.CliInitialize;
import tool10.f10.CliParseAndValidate;
import tool10.f10.CliParameter;
import tool10.f10.NodeF10;
import tool10.fileset.MainFileSet;

public class CliFileSetTest {
	
	public static String[] getArgs0()	{
		String[] args1 = new String[] {"-help"}; 
		String[] args2 = new String[] {"-credits"};
		String[] args3 = new String[] {"",
				"-load",
				//"-dbtype","sqlite",
				//"-dbreadonly","no",
				//"-dbmem","no",
				"-filesetname","fileSet02",
				"-dbaction","renewdb",
				"-blob", "y",
				"-bloboriginal", "yes",
				"-blobcompressed", "yes",
				"-blobencrypted", "yes",
				"-compression", "yes",
				"-compressiontype","gzip",
			//	"-compressionlevel", "5",
				"-encryption", "yes",
				"-host", "yes",
				"-filesystem", "yes",
				"-filestore", "yes",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-dir","C:\\tmp\\similarity\\04_Kopyalar"
				};
	
		String[] args4 = new String[] {"",
				"-extract",
				"-extracttype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-extractdir","C:\\tmp\\similarity\\04_Kopyalar_EXTRACT"
				};
		
		String[] args5 = new String[] {"",
				"-similarity",
				"-similaritytype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02"
				};
		
		String[] args6 = new String[] {
				"-sourceDirName","\"C:\\Dell\"",
				"-targetDirName","c_dell",
				"-jobPrefixName","job_dell",
				"-crcCacheFileName","\"C:\\app\\trdw\\crcCache01.dat\"",
				"-localCacheFileName","\"C:\\app\\trdw\\localCache01.dat\"",
				"-torque","forced64"};
	
		return(args5);
	}
	public static CliParameter processFileSetCli(NodeF10 f10, String[] args0)	{
		
		//String[] args0 = args3;
		CliParameter cliParam = CliInitialize.initializeParameters(args0);
		String parseAndValidateStatus = CliParseAndValidate.parseAndValidateCommandLineArguments(cliParam);  //args
		//CliFileSetParser.showCommandLine(cliParam);
		
		f10.setCliParams(cliParam);
		return(cliParam);
	}
	
}
