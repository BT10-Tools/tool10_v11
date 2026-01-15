package tool10.f10.cli;

import org.apache.commons.cli.CommandLine;

import tool10.util.FileUtil;
import tool10.util.StrUtil;

public class CliParseAndValidateBlob {

	private static long MB = 1024 * 1024;
	private static long GB = 1024 * 1024 * 1024; 
	 
	public static String checkCliParametersLoadBlob(CliParameter p, CommandLine cmd) {
			/*
		
		if (f10.getCliParams().getDbName()==null) {
			System.out.println("Database name is not as expected:"+f10.getCliParams().getDbName());
			return(null);
		}
		*/
	    if (cmd.hasOption("loadblob")) 	{	String str = cmd.getOptionValue("loadblob"); p.setLoadBlob(str);	p.setAction("loadblob"); }
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
	    if (cmd.hasOption("blobdbtype")) 	{	
	    	String str = cmd.getOptionValue("blobdbtype"); 
	    	p.setBlobDbType(str);	
	    	if (!"sqlite".equals(p.getBlobDbType())) {
	    		System.out.println("Blob database type is not as expected:"+p.getBlobDbType()+ "  ,set to sqlite");
	    		p.setDbType("sqlite");
	    	}	
		}
	    if (cmd.hasOption("blobdbaction")) 	{	
	    	String str = cmd.getOptionValue("blobdbaction"); 
	    	p.setBlobDbAction(str);	
	    	if (str==null) {p.setBlobDbAction("newdb");}  //default 
	    	else if ((!"newdb".equals(str)) && (!"renewdb".equals(str)) && (!"newfileset".equals(str)) && (!"appendfile".equals(str)) 
	    			&& (!"usedb".equals(str)))	{
	    		p.setBlobDbAction("newdb"); //newdb, renewdb, newfileset, appendfile, usedb
	    	} else {
	    		p.setBlobDbAction(str);
	    	}	
	    }
	    if (cmd.hasOption("filesetname")) 	{	String str = cmd.getOptionValue("filesetname"); p.setFileSetName(str);	}
	    if (cmd.hasOption("blobsetname")) 	{	
  			String str = cmd.getOptionValue("blobsetname"); 
  			if ((str==null) || (str.isEmpty())) {
  				System.out.println("blobsetname is not as expected: blobsetname "+str);
  				return(null);
  			} 
  			p.setBlobSetName(str);
  		}
		if (cmd.hasOption("dbname")) 	{	
			String str = cmd.getOptionValue("dbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setDbName(str);
		}
		if (cmd.hasOption("blobdbname")) 	{	
			String str = cmd.getOptionValue("blobdbname"); 
			if ((str==null) || (str.isEmpty())) {
				System.out.println("Blob Database name is not as expected: database name"+str);
				return(null);
			} 
			p.setBlobDbName(str);
		}
	 if (cmd.hasOption("blobdbsize")) 	{	
	    	String str = cmd.getOptionValue("blobdbsize"); 
	    	long blobdbsize = StrUtil.parseStr2Int(str);
	    	if ((blobdbsize < 2 * GB) || (blobdbsize > 64 * GB))	{
	    		System.out.println("The blobdbsize is not as expected (values must be between 2GB and 64GB, value:"+str);
	    		long defaultBlobDbSize = 256 * MB; // 16 * GB;
	    		p.setBlobDbSize(Long.toString(defaultBlobDbSize));
	    		//return(null);
	    	} else {
	    		p.setBlobDbSize(Long.toString(blobdbsize));
	    	}
	 }
	 if (cmd.hasOption("blobdbattachmentname")) 	{	
		String str = cmd.getOptionValue("blobdbattachmentname"); 
		if ((str==null) || (str.isEmpty())) {
			if (!CliParseAndValidate.checkAttachmentName(str))	{
				System.out.println("Blob attachment name is not as expected: attachment name"+str);
			}
			return(null);
		} 
		p.setBlobDbAttachmentName(str);
	}
	if (cmd.hasOption("reverseattachmentname")) 	{	
		String str = cmd.getOptionValue("reverseattachmentname"); 
		if ((str==null) || (str.isEmpty())) {
			if (!CliParseAndValidate.checkAttachmentName(str))	{
				System.out.println("Blob reverse attachment name is not as expected: reverse attachment name"+str);
			}
			return(null);
		} 
		p.setReverseAttachmentName(str);
	} 
		if (cmd.hasOption("bloboriginal")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "bloboriginal","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobOriginal(str);
	    }
	    if (cmd.hasOption("blobcompressed")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "blobcompressed","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobCompressed(str);
	    }
	    if (cmd.hasOption("blobencrypted")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "blobencrypted","yes"); 
	    	if (str==null) return(null); 
	    	p.setBlobEncrypted(str);
	    }
	    if (cmd.hasOption("compression")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "compression","yes"); 
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
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "encryption","yes"); 
	    	if (str==null) return(null); 
	    	p.setEncryption(str);
	    }
	    if (cmd.hasOption("encryptionkey")) 	{	String str = cmd.getOptionValue("encryptionkey"); p.setEncryptionKey(str);	}
	    if (cmd.hasOption("encryptionalg")) 	{	String str = cmd.getOptionValue("encryptionalg"); p.setEncryptionAlg(str);	}
	    
	    if (cmd.hasOption("hash")) 	{	
	    	String str = CliParseAndValidate.getYesNo(p,cmd, "hash","yes"); 
	    	if (str==null) return(null); 
	    	p.setHash(str);
    	}
	    if (cmd.hasOption("hashtype")) 	{	
	    	String str = cmd.getOptionValue("hashtype").trim().toLowerCase();  //all, dir, file
	    	if (str==null) return(null); 
	    	if ((!"all".equals(str)) && (!"dir".equals(str)))	{
	    		System.out.println("The hash type is not as expected :"+str);
	    		//return(null);
	    	}
	    	p.setHashType(str);
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
	    
	    String postResult = postProcessingLoadBlob(p,cmd);
	    if (!"ok".equals(postResult)) return(postResult);
	    return("loadblob");
	}
	private static String postProcessingLoadBlob(CliParameter p, CommandLine cmd) {
		if ("renewdb".equals(p.getBlobDbAction()))	{
			FileUtil.deleteFileIfExists(p.getBlobDbName());	
			if (FileUtil.checkFileExists(p.getBlobDbName()))	{
				System.out.println("CliFileSetParseAndValidate postProcessingLoad error the blobdbfile still exists dbName:"+p.getBlobDbName());	
				return("error");
			}
		}
		if ("newdb".equals(p.getBlobDbAction()))	{
			if (FileUtil.checkFileExists(p.getBlobDbName()))	{
				System.out.println("CliFileSetParseAndValidate postProcessingLoad A file or directory with the given Blob database name exists, database name:"+p.getBlobDbName());
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
		/*
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
		*/
		return("ok");
	}
	
}
