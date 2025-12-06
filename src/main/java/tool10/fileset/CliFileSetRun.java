package tool10.fileset;

public class CliFileSetRun {
	
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
		
	
		return(args5);
	}
	public static CliParameter processFileSetCli(NodeF10 f10, String[] args0)	{
		
		//String[] args0 = args3;
		CliParameter cliParam = CliFileSetInitialize.initializeParameters(args0);
		String parseAndValidateStatus = CliFileSetParseAndValidate.parseAndValidateCommandLineArguments(cliParam);  //args
		//CliFileSetParser.showCommandLine(cliParam);
		
		f10.setCliParams(cliParam);
		return(cliParam);
	}
	public static void main( String[] args ) {
		NodeF10 f10 = new NodeF10();
       
		String[] args0 = getArgs0();
        MainFileSet.runF10(f10, args0);
	}
}
