package tool10.f10;

import java.util.HashMap;

public class CliRun {
	
	public static String[] getArgs0()	{
		HashMap<String,String[]> maps = new HashMap<String,String[]>();
		
		String[] args1 = new String[] {"-help"}; 
		String[] args2 = new String[] {"-credits"};
		String[] args3 = new String[] {"",
				"-load",
				//"-dbtype","sqlite",
				//"-dbreadonly","no",
				//"-dbmem","no",
				"-filesetname","fileSet02",
				"-dbaction","renewdb",
				"-host", "yes",
				"-filesystem", "yes",
				"-filestore", "yes",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				//"-dir","C:\\tmp\\similarity\\04_Kopyalar"
				//"-dir","C:\\nhDoc\\11_Chess\\CHESS LITERATURE 3\\SERIOUS TRAINING"  
				//"-dir","C:\\tmp\\similarity\\05_Unzip",
				//"-dir","C:\\tmp\\similarity\\06_Unembed\\01_Org",
				//"-dir","C:\\tmp\\similarity\\07_Transform\\01_Org"
				"-dir","C:\\tmp\\similarity\\11_Book"
				};
		
		String[] args3b = new String[] {"",
				"-loadblob",
				//"-dbtype","sqlite",
				//"-dbreadonly","no",
				//"-dbmem","no",
				"-filesetname","fileSet02",
				"-outputfilesetname","fileSet02Blob",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-blobdbname","C:\\app\\sqlite\\similarity\\fileSet02Blob.db",  //this is optional, default and preferred is current db  
				"-blobdbaction","renewdb",
				"-blob", "n",
				"-bloboriginal", "yes",
				"-blobcompressed", "yes",
				"-blobencrypted", "yes",
				"-compression", "yes",
				"-compressiontype","gzip",
			//	"-compressionlevel", "5",
				"-encryption", "yes",
				"-hash", "yes",
				"-hashtype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				
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
				"-tag",
				"-tagengine","tikatag",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-tagsetname","fileSet02_Tag",
			//	"-tagdbname","C:\\app\\sqlite\\similarity\\fileSet02Tag.db",  //this is optional, default and preferred is current db  
			//	"-tagdbaction","renewdb",
				"-tempdir","C:\\tmp\\similarity\\09_Tag"
				};
		
		String[] args9 = new String[] {"",
				"-image",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-imagesetname","fileSet02_Image",
			//	"-imagedbname","C:\\app\\sqlite\\similarity\\fileSet02Image.db",  //this is optional, default and preferred is current db  
			//	"-imagedbaction","renewdb",
				"-tempdir","C:\\tmp\\similarity\\10_Image"
				};
	
		String[] args10 = new String[] {"",
				"-book",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02",
				"-booksetname","fileSet02_Book",
				"-bookdbname","C:\\app\\sqlite\\similarity\\fileSet02Book.db",  //this is optional, default and preferred is current db  
				"-bookdbaction","renewdb",
				"-tempdir","C:\\tmp\\similarity\\11_Book"
				};
		
		String[] args99 = new String[] {"",
				"-similarity",
				"-similaritytype","all",
				"-dbname","C:\\app\\sqlite\\similarity\\fileSet02.db",
				"-filesetname","fileSet02"
				};
	
		return(args10);
	}
	public static CliParameter processFileSetCli(NodeF10 f10, String[] args0)	{
		
		//String[] args0 = args3;
		CliParameter cliParam = CliInitialize.initializeParameters(args0);
		String parseAndValidateStatus = CliParseAndValidate.parseAndValidateCommandLineArguments(cliParam);  //args
		//CliFileSetParser.showCommandLine(cliParam);
		
		f10.setCliParams(cliParam);
		return(cliParam);
	}
	/*
	TO BE DELETED
	public static void main( String[] args ) {
		NodeF10 f10 = new NodeF10();
       
		String[] args0 = getArgs0();
        MainFileSet.runF10(f10, args0);
	}
	*/
}
