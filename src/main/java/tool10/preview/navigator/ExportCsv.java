package tool10.preview.navigator;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.nodes.NodeQuery;
import tool10.util.FileUtil;

public class ExportCsv {

	private static String[] getHeaderArray(String tableName)	{
		String[] headers = null;
		if ("NodeFile".equals(tableName))	{ 
			headers = new String[] {"fileId","fileSetId","fileSystemId","fileStoreId","parentFileId","rootFileId","fileTypeId","sourceId","languageId","languageId2","fileSize",
			"hashCode","hashId","fileType","linkType","linkedId","depth","depthFromRoot","fileName","fileNameRelative","fileNameAbsolute","fileNameCanonical",
			"dirNameRelative","dirNameAbsolute","encryptedNameRelative","encryptedNameAbsolute","nameHashId","fileURI","fileURL","extensionName",
			"nameWithoutExtension","fileNameAbsoluteLength","ownerName","canExecute","canRead","canWrite","isExists","isDirectory","isFile",
			"isSymbolicLink","isHidden","isOther","isRegularFile","probeContentType","freeSpace","totalSpace","usableSpace","compressedFileSize",
			"compressionGainRatio","compressionGainBytes","encoding","charsetStr","lastModified","fileCreationDate","fileModificationDate",
			"fileLastAccessTime","creationDate","modificationDate","listSiblingFile"}; 
		} else if ("NodeFileBlob".equals(tableName))	{ 
			headers = new String[] {"fileBlobId","fileId","fileSetId","partNumber","cntPart","blobType","blobSize","fileSize","compressionType","compressedFileSize","compressionGainRatio",
			"compressionGainBytes","compressedByteHashId","sandByteLengthHead","sandByteLengthTail","encryptionBlobKey","encryptionType",
			"encryptedFileSize","encrytedByteHashId","fileBytes","hashId","creationDate","modificationDate"}; 
		} else if ("NodeFileStore".equals(tableName))	{ 
			headers = new String[] {"fileStoreId","fileSetId","fileSystemId","rootFileId","displayOrder","blockSize","totalSpace","unallocatedSpace","usableSpace","usedSpace",
			"hashCode","rootDirectoryName","isReadOnly","nameStr","toString","typeStr","creationDate","modificationDate","fileStore","listFile"	}; 
		} else if ("NodeFileSystem".equals(tableName))	{ 
			headers = new String[] {"fileSystemId","fileSetId","hostId","rootFileId","displayOrder","systemName","providerName","providerHashCode","isDefault","isOpen",
			"isReadOnly","creationDate","modificationDate","realFileSystem","listFileStore"}; 
		} else if ("NodeHash".equals(tableName))	{ 
			headers = new String[] {"hashId","fileSetId","fileSize","crc64","crc32","adler32","blake3","md5","sha1","sha256","sha384","sha512","sha3256","keccak256","hashFieldDesc","hashStr01",
			"hashStr02","hashStr03","hashStr04","hashStr05","hashLong01","hashLong02","hashLong03","hashLong04","hashLong05","creationDate","modificationDate"}; 
		} else if ("NodeHost".equals(tableName))	{ 
			headers = new String[] {"hostId","fileSetId","hostName","hostIP","domainName","creationDate","modificationDate"}; 
		} else if ("NodeProperty".equals(tableName))	{ 
			headers = new String[] {"propertyId","fileSetId","entityId","displayOrder","mapName","entityName","propertyKey","propertyValue","valueString","valueLong","valueDouble",
			"valueBinary","valueZDT","creationDate","modificationDate"}; 
		} else if ("NodeQuery".equals(tableName))	{ 
			headers = new String[] {"queryId","fileSetId","entityId","cntExecution","sqlString","firstExecutionDate","lastExecutionDate","creationDate","modificationDate"}; 
		} else if ("NodeFileSet".equals(tableName))	{ 
			headers = new String[] {"fileSetId","sourceId","fileSetName","fileSetDesc","fileSetURL","ownerName","displayOrder","creationDate","modificationDate","listAcl",
			"listAclEntry","listDirectory","listFile","listFileBlob","listFileBlobSmall","listFileSystem","listFileStore","listHash","listHost",
			"listProperty","listPathGroup","listPathGroupMember","listQuery","listStat","mapId2Acl","mapId2AclEntry","mapId2Directory",
			"mapId2File","mapId2FileBlob","mapId2FileBlobSmall","mapId2FileSystem","mapId2FileStore","mapId2Hash","mapId2Host","mapId2Property",
			"mapId2PathGroup","mapId2PathGroupMember","mapId2Query","mapId2Stat","listRoots","mapAbsoluteFileName2File",
			"mapRawFileSystem2FileSystem","mapRawFileStore2FileStore","mapCrc2NodeHash"}; 
		}
		return(headers);
	}
	private static void csvPrint(NodeFileSet fileSet, CSVPrinter csvPrinter, String tableName) { 
		try { 
		if ("NodeFile".equals(tableName))	{ 
			for (NodeFile ent : fileSet.getListFile()) { 
				csvPrinter.printRecord(ent.getFileId(),ent.getFileSetId(),ent.getFileSystemId(),ent.getFileStoreId(),ent.getParentFileId(),ent.getRootFileId(),ent.getFileTypeId(),ent.getSourceId(),ent.getLanguageId(),ent.getLanguageId2(),ent.getFileSize(),
					ent.getHashCode(),ent.getHashId(),ent.getFileType(),ent.getLinkType(),ent.getLinkedId(),ent.getDepth(),ent.getDepthFromRoot(),ent.getFileName(),ent.getFileNameRelative(),ent.getFileNameAbsolute(),ent.getFileNameCanonical(),
					ent.getDirNameRelative(),ent.getDirNameAbsolute(),ent.getEncryptedNameRelative(),ent.getEncryptedNameAbsolute(),ent.getNameHashId(),ent.getFileURI(),ent.getFileURL(),ent.getExtensionName(),
					ent.getNameWithoutExtension(),ent.getFileNameAbsoluteLength(),ent.getOwnerName(),ent.getCanExecute(),ent.getCanRead(),ent.getCanWrite(),ent.getIsExists(),ent.getIsDirectory(),ent.getIsFile(),
					ent.getIsSymbolicLink(),ent.getIsHidden(),ent.getIsOther(),ent.getIsRegularFile(),ent.getProbeContentType(),ent.getFreeSpace(),ent.getTotalSpace(),ent.getUsableSpace(),ent.getCompressedFileSize(),
					ent.getCompressionGainRatio(),ent.getCompressionGainBytes(),ent.getEncoding(),ent.getCharsetStr(),ent.getLastModified(),ent.getFileCreationDate(),ent.getFileModificationDate(),
					ent.getFileLastAccessTime(),ent.getCreationDate(),ent.getModificationDate()); 
			} 
		} else if ("NodeFileBlob".equals(tableName))	{ 
			for (NodeFileBlob ent : fileSet.getListFileBlob()) { 
				csvPrinter.printRecord(ent.getFileBlobId(),ent.getFileId(),ent.getBlobId(),ent.getFileSetId(),ent.getBlobType(),ent.getBlobSize(),ent.getFileSize(),ent.getHashId(),ent.getBlobDbName(),ent.getBlobDbAttachmentName(),ent.getBlobTableName(),
					ent.getBigPartNumber(),ent.getBigCntPart(),ent.getSmallByteIndexStart(),ent.getSmallByteIndexEnd(),ent.getCreationDate(),ent.getModificationDate()); 
			} 
		} else if ("NodeFileStore".equals(tableName))	{ 
			for (NodeFileStore ent : fileSet.getListFileStore()) { 
				csvPrinter.printRecord(ent.getFileStoreId(),ent.getFileSetId(),ent.getFileSystemId(),ent.getRootFileId(),ent.getDisplayOrder(),ent.getBlockSize(),ent.getTotalSpace(),ent.getUnallocatedSpace(),ent.getUsableSpace(),ent.getUsedSpace(),
					ent.getHashCode(),ent.getRootDirectoryName(),ent.getIsReadOnly(),ent.getNameStr(),ent.getToString(),ent.getTypeStr(),ent.getCreationDate(),ent.getModificationDate()
					); 
			} 
		} else if ("NodeFileSystem".equals(tableName))	{ 
			for (NodeFileSystem ent : fileSet.getListFileSystem()) { 
				csvPrinter.printRecord(ent.getFileSystemId(),ent.getFileSetId(),ent.getHostId(),ent.getRootFileId(),ent.getDisplayOrder(),ent.getSystemName(),ent.getProviderName(),ent.getProviderHashCode(),ent.getIsDefault(),ent.getIsOpen(),
					ent.getIsReadOnly(),ent.getCreationDate(),ent.getModificationDate(),ent.getRealFileSystem(),ent.getListFileStore()); 
			} 
		} else if ("NodeHash".equals(tableName))	{ 
			for (NodeHash ent : fileSet.getListHash()) { 
				csvPrinter.printRecord(ent.getHashId(),ent.getFileSetId(),ent.getFileSize(),ent.getCrc64(),ent.getCrc32(),ent.getAdler32(),ent.getBlake3(),ent.getMd5(),ent.getSha1(),ent.getSha256(),ent.getSha384(),ent.getSha512(),ent.getSha3256(),ent.getKeccak256(),ent.getHashFieldDesc(),ent.getHashStr01(),
					ent.getHashStr02(),ent.getHashStr03(),ent.getHashStr04(),ent.getHashStr05(),ent.getHashLong01(),ent.getHashLong02(),ent.getHashLong03(),ent.getHashLong04(),ent.getHashLong05(),ent.getCreationDate(),ent.getModificationDate()
					); 
			} 
		} else if ("NodeHost".equals(tableName))	{ 
			for (NodeHost ent : fileSet.getListHost()) { 
				csvPrinter.printRecord(ent.getHostId(),ent.getFileSetId(),ent.getHostName(),ent.getHostIP(),ent.getDomainName(),ent.getCreationDate(),ent.getModificationDate()); 
			} 
		} else if ("NodeProperty".equals(tableName))	{ 
			for (NodeProperty ent : fileSet.getListProperty()) { 
				csvPrinter.printRecord(ent.getPropertyId(),ent.getFileSetId(),ent.getEntityId(),ent.getDisplayOrder(),ent.getMapName(),ent.getEntityName(),ent.getPropertyKey(),ent.getPropertyValue(),ent.getValueString(),ent.getValueLong(),ent.getValueDouble(),
					ent.getValueBinary(),ent.getValueZDT(),ent.getCreationDate(),ent.getModificationDate()); 
			} 
		} else if ("NodeQuery".equals(tableName))	{ 
			for (NodeQuery ent : fileSet.getListQuery()) { 
				csvPrinter.printRecord(ent.getQueryId(),ent.getFileSetId(),ent.getEntityId(),ent.getCntExecution(),ent.getSqlString(),ent.getFirstExecutionDate(),ent.getLastExecutionDate(),ent.getCreationDate(),ent.getModificationDate()
					); 
			} 
		} else if ("NodeFileSet".equals(tableName))	{ 
			NodeFileSet ent = fileSet; 
				csvPrinter.printRecord(ent.getFileSetId(),ent.getSourceId(),ent.getFileSetName(),ent.getFileSetDesc(),ent.getFileSetURL(),ent.getOwnerName(),ent.getDisplayOrder(),ent.getCreationDate(),ent.getModificationDate()); 
		
		}
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}

	 private static String exportOneCSVTable(NodeFileSet fileSet, String className) {
		 try {
			String[] headers = getHeaderArray(className);
			final StringWriter sw = new StringWriter();
		    CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
		            .setHeader(headers) 
		            .setQuoteMode(QuoteMode.NON_NUMERIC)
		            .build();
		    CSVPrinter csvPrinter = new CSVPrinter(sw, csvFormat);
		    
		    csvPrint(fileSet, csvPrinter, className);
		  
		    csvPrinter.close();
		    return(sw.toString());
		 } catch (IOException e) {
			 e.printStackTrace();
	         return(null);   
	     }		 
	 }	 
	 private static void exportAllCSVTable(NodeFileSet fileSet, String dirName) {
		String[] classList = new String[] {"NodeFile","NodeFileBlob","NodeFileStore","NodeFileSystem","NodeHash","NodeHost",
		"NodeProperty","NodeQuery","NodeFileSet"};  
		for (String className : classList)	{
			String txt = exportOneCSVTable(fileSet,className); 
			String fileName = dirName + "\\" + className + ".csv"; 
			FileUtil.bufferedWriter(fileName, txt);
		} 
	 }
	 public static void extractFileSetCSV(NodeF10 f10)	{
		 String dirName = "C:\\tmp\\similarity\\03_Exports";
		 ///String csvFile = "C:\\tmp\\similarity\\03_Exports\\file.csv";
		 //String csvHost = "C:\\tmp\\similarity\\03_Exports\\host.csv";
		 ///exportCSVFile(fileSet.getListFile(), csvFile) ;
		 
		 exportAllCSVTable(f10.getFileSet(), dirName);
		 
		 //String fSet = exportCSVHost(fileSet.getListHost(),fileSet);
		 
	 }
}
