package tool10.fileset;

import tool10.fileset.nodes.NodeF10;

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
				"-blob", "n",
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
				//"-dir","C:\\tmp\\similarity\\04_Kopyalar"
				//"-dir","C:\\nhDoc\\11_Chess\\CHESS LITERATURE 3"
				//"-dir","C:\\tmp\\similarity\\05_Unzip",
				//"-dir","C:\\tmp\\similarity\\06_Unembed\\01_Org",
				"-dir","C:\\tmp\\similarity\\07_Transform\\01_Org"
				};
	
		String[] args4 = new String[] {"",
				"-extract",
				"-extracttype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-extractdir","C:\\tmp\\similarity\\04_Kopyalar_EXTRACT"
				};
		
		String[] args5 = new String[] {"",
				"-unzip",
				"-unziptype","recursive",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-outputfilesetname","fileSet02_Unzip",
				"-tempdir","C:\\tmp\\similarity\\05_Unzip"
				};
		
		String[] args6 = new String[] {"",
				"-unembed",
				"-unembedtype","imagesFromPdf",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-outputfilesetname","fileSet02_Unembed",
				"-tempdir","C:\\tmp\\similarity\\06_Unembed"
				};
		
		String[] args7 = new String[] {"",
				"-transform",
				"-transformtype","jpg2png",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-outputfilesetname","fileSet02_Transform",
				"-tempdir","C:\\tmp\\similarity\\07_Transform"
				};
		
		String[] args8 = new String[] {"",
				"-similarity",
				"-similaritytype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02"
				};
		
	
		return(args7);
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
