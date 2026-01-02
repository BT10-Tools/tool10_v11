package tool10.f10;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

public class CliParameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CliParameter()	{
		this.args = null; 
		initialize(); 
	}
	public CliParameter(String[] args, Options options)	{
		this.args = args;
		this.opt = options;
		initialize(); 
	}
	public void initialize()	{
		this.parseAndValidateStatus="no";
		this.dbType = "sqlite"; //not required, default, sqlite. ser serialization wşill come. in future pg, oracle, mysql,...
		this.dbAction = "newdb"; //newdb, newroot, 
		this.dbReadOnly="no"; //yes, no. default no 
		this.dbMem="no"; //yes, n
		this.blobDbType = "sqlite"; //not required, default, sqlite. ser serialization wşill come. in future pg, oracle, mysql,...
		this.blobDbAction = "newdb"; //newdb, newroot, 
		this.blobOriginal = "no";
		this.blobCompressed = "no";
		this.blobEncrypted = "yes";
		this.compression = "yes";
		this.compressionType = "gzip";
		this.compressionLevel = "9";
		this.encryption = "yes";
		this.minFileSize = "0";
		this.maxFileSize = Integer.toString(256*1024*1024); //256MB
		this.hash = "yes";
		this.hashType = "all";
		this.similarityType = "all";
		this.creationDate = ZonedDateTime.now();
	}
	
	private final String[] args;
	private String parseAndValidateStatus;
	private String programName;  //file10, doc10, registry10, sys10 
 	private String action;
	private String help; //", false, "Print the help message.");
	private String credits; //", false, "Print the credits message.");
	
	private String user; //", true, "The user to connect");
	private String password; //", true, "The password for the user.");
    
	private String dbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String dbAction; //newdb, newroot, 
	private String dbReadOnly; //yes, no. default no 
	private String dbMem; //yes, no. create the db in memory, if possible BLOBs also
	private String fileSetName;
	private String dbName;
	private String load;
	private String dir;
	private String[] dirArray;
	private String file;
	private String[] fileArray;
	
	private String loadBlob;
	private String blobDbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String blobDbName;
	private String blobDbAction; //newdb, newroot, 
	private String blobDbSize;
	private String blobDbAttachmentName;
	private String reverseAttachmentName;
	private String blobOriginal;
	private String blobCompressed;
	private String blobEncrypted;
	private String compression;
	private String compressionType;
	private String compressionLevel;
	private String encryption;
	private String encryptionKey;
	private String encryptionAlg;
	private String hash;
	private String hashType;
	
	private String host;
	private String fileSystem;
	private String fileStore;
	
	private String filter;
	private String exclude;
	private String minChangeDate;
	private String minFileSize;
	private String maxFileSize;
	private String log;
	private String error;
	
	private String read;
	private String readType;
	
	private String extract;
	private String extractType;
	private String extractDir;
	
	private String export;
	private String exportType;
	private String exportDir;
	
	private String unzip;
	private String unzipType;
	private String tempDir;
	private String outputFileSetName;
	
	private String unembed;
	private String unembedType;
	
	private String transform;
	private String transformType;
	
	private String tag;
	private String tagEngine;
	private String tagSetName;
	private String tagDbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String tagDbName;
	private String tagDbAction; //newdb, newroot, 
	
	private String media;
	private String mediaSetName;
	private String mediaDbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String mediaDbName;
	private String mediaDbAction; //newdb, newroot, 
	
	private String book;
	private String bookSetName;
	private String bookDbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String bookDbName;
	private String bookDbAction; //newdb, newroot, 
	
	private String similarity;
	private String similarityType;
	private String similarityAlg;
	private String similarityLevel;
	private String setName;
	private String simSetName;
	private String simDbType; //not required, default, sqlite. ser serialization will come. in future pg, oracle, mysql,...
	private String simDbName;
	private String simDbAction; //newdb, newroot,
		
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private Options opt;
	private CommandLine commandLine;
	
		
	public String showStr()	{
		String ss = 
				"parseAndValidateStatus:"+parseAndValidateStatus+",\n"+
				"programName:"+programName+",\n"+
				"help:"+help+",\n"+
				"credits:"+credits+",\n"+
				
				"user:"+user+",\n"+
				"password:"+password+",\n"+
				
				"dbtype:"+dbType+",\n"+
				"dbaction:"+dbAction+",\n"+
				"dbreadonly:"+dbReadOnly+",\n"+
				"dbmem:"+dbMem+",\n"+
				"filesetname:"+fileSetName+",\n"+
				"dbname:"+dbName+",\n"+
				
				"load:"+load+",\n"+ 
				"dir:"+dir+",\n"+
				
				"file:"+file+",\n"+
				"compression:"+compression+",\n"+
				"compressionLevel:"+compressionLevel+",\n"+
				"encryption:"+encryption+",\n"+
				"encryptionKey:"+encryptionKey+",\n"+
				"encryptionAlg:"+encryptionAlg+",\n"+
				
		
				"host:"+host+",\n"+
				"fileSystem:"+fileSystem+",\n"+
				"fileStore:"+fileStore+",\n"+
				
				"filter:"+filter+",\n"+
				"exclude:"+exclude+",\n"+
				"minChangeDate:"+minChangeDate+",\n"+
				"minFileSize:"+minFileSize+",\n"+
				"maxFileSize:"+maxFileSize+",\n"+
				"log:"+log+",\n"+
				"error:"+error+",\n"+
				
				"extract:"+extract+",\n"+
				"extractType:"+extractType+",\n"+
				"extractDir:"+extractDir+",\n"+
		
				"export:"+export+",\n"+
				"exportType:"+exportType+",\n"+
				"exportDir:"+exportDir+",\n"+
				
				"similarity:"+similarity+",\n"+
				"similarityType:"+similarityType+",\n"+
				"similarityAlg:"+similarityAlg+",\n"+
				"similarityLevel:"+similarityLevel+",\n"; 
		return(ss);
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoad() {
		return load;
	}
	public void setLoad(String load) {
		this.load = load;
	}
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public String getCompressionLevel() {
		return compressionLevel;
	}

	public void setCompressionLevel(String compressionLevel) {
		this.compressionLevel = compressionLevel;
	}

	public String getEncryption() {
		return encryption;
	}

	public void setEncryption(String encryption) {
		this.encryption = encryption;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	public String getEncryptionAlg() {
		return encryptionAlg;
	}

	public void setEncryptionAlg(String encryptionAlg) {
		this.encryptionAlg = encryptionAlg;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getFileSystem() {
		return fileSystem;
	}

	public void setFileSystem(String fileSystem) {
		this.fileSystem = fileSystem;
	}

	public String getFileStore() {
		return fileStore;
	}

	public void setFileStore(String fileStore) {
		this.fileStore = fileStore;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getExclude() {
		return exclude;
	}

	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

	public String getMinChangeDate() {
		return minChangeDate;
	}

	public void setMinChangeDate(String minChangeDate) {
		this.minChangeDate = minChangeDate;
	}

	public String getMinFileSize() {
		return minFileSize;
	}

	public void setMinFileSize(String minFileSize) {
		this.minFileSize = minFileSize;
	}

	public String getMaxFileSize() {
		return maxFileSize;
	}

	public void setMaxFileSize(String maxFileSize) {
		this.maxFileSize = maxFileSize;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getExtract() {
		return extract;
	}

	public void setExtract(String extract) {
		this.extract = extract;
	}

	public String getExtractDir() {
		return extractDir;
	}

	public void setExtractDir(String extractDir) {
		this.extractDir = extractDir;
	}

	
	public String getExportDir() {
		return exportDir;
	}

	public void setExportDir(String exportDir) {
		this.exportDir = exportDir;
	}
	
	public String getSimilarity() {
		return similarity;
	}

	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}

	public String getSimilarityAlg() {
		return similarityAlg;
	}

	public void setSimilarityAlg(String similarityAlg) {
		this.similarityAlg = similarityAlg;
	}

	public String getSimilarityLevel() {
		return similarityLevel;
	}

	public void setSimilarityLevel(String similarityLevel) {
		this.similarityLevel = similarityLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getDirArray() {
		return dirArray;
	}

	public void setDirArray(String[] dirArray) {
		this.dirArray = dirArray;
	}

	public String[] getFileArray() {
		return fileArray;
	}

	public void setFileArray(String[] fileArray) {
		this.fileArray = fileArray;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbAction() {
		return dbAction;
	}

	public void setDbAction(String dbAction) {
		this.dbAction = dbAction;
	}

	public String getDbReadOnly() {
		return dbReadOnly;
	}

	public void setDbReadOnly(String dbReadOnly) {
		this.dbReadOnly = dbReadOnly;
	}

	public String getDbMem() {
		return dbMem;
	}

	public void setDbMem(String dbMem) {
		this.dbMem = dbMem;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String[] getArgs() {
		return args;
	}
	public Options getOpt() {
		return opt;
	}
	public void setOpt(Options opt) {
		this.opt = opt;
	}
	public CommandLine getCommandLine() {
		return commandLine;
	}
	public void setCommandLine(CommandLine commandLine) {
		this.commandLine = commandLine;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFileSetName() {
		return fileSetName;
	}
	public void setFileSetName(String fileSetName) {
		this.fileSetName = fileSetName;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getParseAndValidateStatus() {
		return parseAndValidateStatus;
	}
	public void setParseAndValidateStatus(String parseAndValidateStatus) {
		this.parseAndValidateStatus = parseAndValidateStatus;
	}
	public String getCompressionType() {
		return compressionType;
	}
	public void setCompressionType(String compressionType) {
		this.compressionType = compressionType;
	}
	public String getBlobOriginal() {
		return blobOriginal;
	}
	public void setBlobOriginal(String blobOriginal) {
		this.blobOriginal = blobOriginal;
	}
	public String getBlobCompressed() {
		return blobCompressed;
	}
	public void setBlobCompressed(String blobCompressed) {
		this.blobCompressed = blobCompressed;
	}
	public String getBlobEncrypted() {
		return blobEncrypted;
	}
	public void setBlobEncrypted(String blobEncrypted) {
		this.blobEncrypted = blobEncrypted;
	}
	public String getSimilarityType() {
		return similarityType;
	}
	public void setSimilarityType(String similarityType) {
		this.similarityType = similarityType;
	}
	public String getExport() {
		return export;
	}
	public void setExport(String export) {
		this.export = export;
	}
	public String getExportType() {
		return exportType;
	}
	public void setExportType(String exportType) {
		this.exportType = exportType;
	}
	public String getExtractType() {
		return extractType;
	}
	public void setExtractType(String extractType) {
		this.extractType = extractType;
	}
	public String getUnzip() {
		return unzip;
	}
	public void setUnzip(String unzip) {
		this.unzip = unzip;
	}
	public String getUnzipType() {
		return unzipType;
	}
	public void setUnzipType(String unzipType) {
		this.unzipType = unzipType;
	}
	public String getTempDir() {
		return tempDir;
	}
	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}
	public String getOutputFileSetName() {
		return outputFileSetName;
	}
	public void setOutputFileSetName(String outputFileSetName) {
		this.outputFileSetName = outputFileSetName;
	}
	public String getUnembed() {
		return unembed;
	}
	public void setUnembed(String unembed) {
		this.unembed = unembed;
	}
	public String getUnembedType() {
		return unembedType;
	}
	public void setUnembedType(String unembedType) {
		this.unembedType = unembedType;
	}
	public String getTransform() {
		return transform;
	}
	public void setTransform(String transform) {
		this.transform = transform;
	}
	public String getTransformType() {
		return transformType;
	}
	public void setTransformType(String transformType) {
		this.transformType = transformType;
	}
	public String getLoadBlob() {
		return loadBlob;
	}
	public void setLoadBlob(String loadBlob) {
		this.loadBlob = loadBlob;
	}
	public String getBlobDbName() {
		return blobDbName;
	}
	public void setBlobDbName(String blobDbName) {
		this.blobDbName = blobDbName;
	}
	public String getBlobDbSize() {
		return blobDbSize;
	}
	public void setBlobDbSize(String blobDbSize) {
		this.blobDbSize = blobDbSize;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getHashType() {
		return hashType;
	}
	public void setHashType(String hashType) {
		this.hashType = hashType;
	}
	public String getBlobDbType() {
		return blobDbType;
	}
	public void setBlobDbType(String blobDbType) {
		this.blobDbType = blobDbType;
	}
	public String getBlobDbAction() {
		return blobDbAction;
	}
	public void setBlobDbAction(String blobDbAction) {
		this.blobDbAction = blobDbAction;
	}
	public String getBlobDbAttachmentName() {
		return blobDbAttachmentName;
	}
	public void setBlobDbAttachmentName(String blobDbAttachmentName) {
		this.blobDbAttachmentName = blobDbAttachmentName;
	}
	public String getReverseAttachmentName() {
		return reverseAttachmentName;
	}
	public void setReverseAttachmentName(String reverseAttachmentName) {
		this.reverseAttachmentName = reverseAttachmentName;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTagEngine() {
		return tagEngine;
	}
	public void setTagEngine(String tagEngine) {
		this.tagEngine = tagEngine;
	}
	public String getTagDbName() {
		return tagDbName;
	}
	public void setTagDbName(String tagDbName) {
		this.tagDbName = tagDbName;
	}
	public String getTagDbAction() {
		return tagDbAction;
	}
	public void setTagDbAction(String tagDbAction) {
		this.tagDbAction = tagDbAction;
	}
	public String getTagDbType() {
		return tagDbType;
	}
	public void setTagDbType(String tagDbType) {
		this.tagDbType = tagDbType;
	}
	public String getTagSetName() {
		return tagSetName;
	}
	public void setTagSetName(String tagSetName) {
		this.tagSetName = tagSetName;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getBookSetName() {
		return bookSetName;
	}
	public void setBookSetName(String bookSetName) {
		this.bookSetName = bookSetName;
	}
	public String getBookDbType() {
		return bookDbType;
	}
	public void setBookDbType(String bookDbType) {
		this.bookDbType = bookDbType;
	}
	public String getBookDbName() {
		return bookDbName;
	}
	public void setBookDbName(String bookDbName) {
		this.bookDbName = bookDbName;
	}
	public String getBookDbAction() {
		return bookDbAction;
	}
	public void setBookDbAction(String bookDbAction) {
		this.bookDbAction = bookDbAction;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getReadType() {
		return readType;
	}
	public void setReadType(String readType) {
		this.readType = readType;
	}
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getMediaSetName() {
		return mediaSetName;
	}
	public void setMediaSetName(String mediaSetName) {
		this.mediaSetName = mediaSetName;
	}
	public String getMediaDbType() {
		return mediaDbType;
	}
	public void setMediaDbType(String mediaDbType) {
		this.mediaDbType = mediaDbType;
	}
	public String getMediaDbName() {
		return mediaDbName;
	}
	public void setMediaDbName(String mediaDbName) {
		this.mediaDbName = mediaDbName;
	}
	public String getMediaDbAction() {
		return mediaDbAction;
	}
	public void setMediaDbAction(String mediaDbAction) {
		this.mediaDbAction = mediaDbAction;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getSimSetName() {
		return simSetName;
	}
	public void setSimSetName(String simSetName) {
		this.simSetName = simSetName;
	}
	public String getSimDbType() {
		return simDbType;
	}
	public void setSimDbType(String simDbType) {
		this.simDbType = simDbType;
	}
	public String getSimDbName() {
		return simDbName;
	}
	public void setSimDbName(String simDbName) {
		this.simDbName = simDbName;
	}
	public String getSimDbAction() {
		return simDbAction;
	}
	public void setSimDbAction(String simDbAction) {
		this.simDbAction = simDbAction;
	}
	
}
