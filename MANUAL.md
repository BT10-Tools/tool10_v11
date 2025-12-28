##How to use File10?


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
			