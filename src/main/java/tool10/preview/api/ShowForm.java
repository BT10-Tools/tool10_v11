package tool10.preview.api;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.text.StringEscapeUtils;

import tool10.blobset.NodeBlob;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeHost;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class ShowForm {

	public static String escapeStr (String str)	{
		String escaped = StringEscapeUtils.escapeHtml4(str);
		return(escaped);
	}
	public static String showLong(String outType, String fieldName, Long val)	{
		return(fieldName+"(Long):"+escapeStr((val==null) ? "null" : val.toString()) );
	}
	public static String showDouble(String outType, String fieldName, Double val)	{
		return(fieldName+"(Double):"+escapeStr((val==null) ? "null" : val.toString()));
	}
	public static String showString(String outType, String fieldName, String val)	{
		return(fieldName+"(String):'"+escapeStr(val)+"'");
	}
	public static String showZDT(String outType, String fieldName, ZonedDateTime val)	{
		return(fieldName+"(ZonedDateTime):"+((val==null) ? "null" : escapeStr(val.toString())));
	}
	private static final int showBytesHeadLength = 10;
	private static final int showBytesTailLength = 6;
	private static final String showBytesMidlle = " ..... ";
	private static final String showBytesFormat = "signedInt"; //hex
	
	public static String showBytes(String outType, String fieldName, byte[] bytes)	{
		String byteArrayStr = null;   
		if (bytes==null) {byteArrayStr = "null";}
		else if (bytes.length==0) {
			byteArrayStr = "[]";
		} else if ((bytes.length<=showBytesHeadLength) || (bytes.length<=showBytesTailLength))	{
			byteArrayStr = Arrays.toString(bytes);
		} else if (bytes.length>=0) {
			int headLengthToShow = (showBytesHeadLength >= bytes.length) ? showBytesHeadLength : bytes.length;  
			int tailBeginningIndexToShow = ((showBytesHeadLength+showBytesTailLength) >= bytes.length) ? (bytes.length-showBytesTailLength) : bytes.length;
			int middleBeginningIndexToShow = -1;
			int middleEndingIndexToShow = -1;
			byte[] head = Arrays.copyOfRange(bytes, 0, headLengthToShow);
			byte[] tail = Arrays.copyOfRange(bytes, tailBeginningIndexToShow, bytes.length);
			byte[] middle = null;
			if ((head!=null) && (head.length>0)) {byteArrayStr = Arrays.toString(head).replace("[", "").replace("]", "");}
			if (bytes.length < (head.length + tail.length))		{byteArrayStr = byteArrayStr + showBytesMidlle; }
			if ((tail!=null) && (tail.length>0)) {byteArrayStr = byteArrayStr + Arrays.toString(tail).replace("[", "").replace("]", "");}
			byteArrayStr = "[]";
		}
		
		return(fieldName+"(bytes) length:"+bytes.length+" ,");
	}
	public static String showList(String outType, String className, String fieldName, Object arrList)	{
		return(className+","+fieldName+","+arrList.toString());
	}
	public static String showMap(String outType, String keyClassName, String valueClassName, String fieldName, Object mapObj)	{
		return(keyClassName+","+valueClassName+","+fieldName+","+mapObj.toString());
	}
	public static String showClass(String classNameLong, String classNameShort)	{
		return("A Java Reflection based data will be returned for Class LongName :"+classNameLong+" , Class ShortName:"+classNameShort);
	}
	public static String showPackage(String packageNameLong, String packageNameShort)	{
		return("A Java Reflection based data will be returned for Package LongName :"+packageNameLong+" ,Package ShortName:"+packageNameShort);
	}
	private static final String nl = "\n";
	//private static final String outType = "text";
	public static String getShowString(String outType, NodeFileSet ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl); 
		sb.append(showString(outType,"fileSetName",ent.getFileSetName())+nl); 
		sb.append(showString(outType,"fileSetDesc",ent.getFileSetDesc())+nl); 
		sb.append(showString(outType,"fileSetURL",ent.getFileSetURL())+nl); 
		sb.append(showString(outType,"ownerName",ent.getOwnerName())+nl); 
		sb.append(showLong(outType,"displayOrder",ent.getDisplayOrder())+nl); 
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl); 
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl); 
				
		sb.append(showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		sb.append(showList(outType,"NodeFileBlob","listFileBlob",ent.getListFileBlob())+nl); 
		sb.append(showList(outType,"NodeBlob","listBlob",ent.getListBlob())+nl);
		sb.append(showList(outType,"NodeFileSystem","listFileSystem",ent.getListFileSystem())+nl);
		sb.append(showList(outType,"NodeFileStore","listFileStore",ent.getListFileStore())+nl);
		sb.append(showList(outType,"NodeHash","listHash",ent.getListHash())+nl);
		sb.append(showList(outType,"NodeHost","listHost",ent.getListHost())+nl);
		sb.append(showList(outType,"NodeProperty","listProperty",ent.getListProperty())+nl);
		sb.append(showList(outType,"NodeQuery","listQuery",ent.getListQuery())+nl);
		sb.append(showList(outType,"NodeStat","listStat",ent.getListStat())+nl);
		sb.append(showList(outType,"NodeArchive","listArchive",ent.getListArchive())+nl);
		sb.append(showList(outType,"NodeContainer","listContainer",ent.getListContainer())+nl);
		sb.append(showList(outType,"NodeTransform","listTransform",ent.getListTransform())+nl);

		sb.append(showMap(outType,"Long","NodeFile","mapId2File",ent.getMapId2File())+nl);
		sb.append(showMap(outType,"Long","NodeFileBlob","mapId2FileBlob",ent.getMapId2FileBlob())+nl);
		sb.append(showMap(outType,"Long","NodeBlob","mapId2Blob",ent.getMapId2Blob())+nl);
		sb.append(showMap(outType,"Long","NodeFileSystem","mapId2FileSystem",ent.getMapId2FileSystem())+nl);
		sb.append(showMap(outType,"Long","NodeFileStore","mapId2FileStore",ent.getMapId2FileStore())+nl);
		sb.append(showMap(outType,"Long","NodeHash","mapId2Hash",ent.getMapId2Hash())+nl);
		sb.append(showMap(outType,"Long","NodeHost","mapId2Host",ent.getMapId2Host())+nl);
		sb.append(showMap(outType,"Long","NodeProperty","mapId2Property",ent.getMapId2Property())+nl);
		sb.append(showMap(outType,"Long","NodeQuery","mapId2Query",ent.getMapId2Query())+nl);
		sb.append(showMap(outType,"Long","NodeStat","mapId2Stat",ent.getMapId2Stat())+nl);
		sb.append(showMap(outType,"Long","NodeArchive","mapId2Archive",ent.getMapId2Archive())+nl);
		sb.append(showMap(outType,"Long","NodeContainer","mapId2Container",ent.getMapId2Container())+nl);
		sb.append(showMap(outType,"Long","NodeTransform","mapId2Transform",ent.getMapId2Transform())+nl);
		
		sb.append(showList(outType,"NodeFile","listRoots",ent.getListRoots())+nl);
		sb.append(showMap(outType,"String","NodeFile","mapAbsoluteFileName2File",ent.getMapAbsoluteFileName2File())+nl);
		sb.append(showMap(outType,"FileSystem","NodeFileSystem","mapRawFileSystem2FileSystem",ent.getMapRawFileSystem2FileSystem())+nl);
		sb.append(showMap(outType,"FileStore","NodeFileStore","mapRawFileStore2FileStore",ent.getMapRawFileStore2FileStore())+nl);
		sb.append(showMap(outType,"Long","NodeHash","mapCrc2NodeHash",ent.getMapCrc2NodeHash())+nl);
		sb.append(showMap(outType,"Long","NodeFileBlob","mapFileId2FileBlob",ent.getMapFileId2FileBlob())+nl);
		
		return(sb.toString());
	}	
	
	public static String getShowString(String outType,NodeFile ent)	{
		StringBuilder sb = new StringBuilder();
		sb.append(showLong(outType,"fileId",ent.getFileId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"fileSystemId",ent.getFileSystemId())+nl);
		sb.append(showLong(outType,"fileStoreId",ent.getFileStoreId())+nl);
		sb.append(showLong(outType,"parentFileId",ent.getParentFileId())+nl);
		sb.append(showLong(outType,"rootFileId",ent.getRootFileId())+nl);
		sb.append(showLong(outType,"fileTypeId",ent.getFileTypeId())+nl);
		sb.append(showLong(outType,"sourceId",ent.getSourceId())+nl);
		sb.append(showLong(outType,"languageId",ent.getLanguageId())+nl);
		sb.append(showLong(outType,"languageId2",ent.getLanguageId2())+nl);
		sb.append(showLong(outType,"fileSize",ent.getFileSize())+nl);  
		sb.append(showLong(outType,"hashCode",ent.getHashCode())+nl);
		sb.append(showLong(outType,"hashId",ent.getHashId())+nl);
		sb.append(showString(outType,"fileType",ent.getFileType())+nl); //file, directory, link
		sb.append(showString(outType,"linkType",ent.getLinkType())+nl); //softlink, hardlink
		sb.append(showLong(outType,"linkedId",ent.getLinkedId())+nl);

		sb.append(showString(outType,"fileStatus",ent.getFileStatus())+nl);
		sb.append(showLong(outType,"depth",ent.getDepth())+nl);
		sb.append(showLong(outType,"depthFromRoot",ent.getDepthFromRoot())+nl);
		    
		sb.append(showString(outType,"fileName",ent.getFileName())+nl);
		sb.append(showString(outType,"fileNameRelative",ent.getFileNameRelative())+nl);  //the name relative to the given input directory name
		sb.append(showString(outType,"fileNameAbsolute",ent.getFileNameAbsolute())+nl);
		sb.append(showString(outType,"fileNameCanonical",ent.getFileNameCanonical())+nl);
		sb.append(showString(outType,"dirNameRelative",ent.getDirNameRelative())+nl);  
		sb.append(showString(outType,"dirNameAbsolute",ent.getDirNameAbsolute())+nl);
		sb.append(showString(outType,"altName1",ent.getAltName1())+nl);
		sb.append(showString(outType,"altName2",ent.getAltName2())+nl);
		sb.append(showString(outType,"altName3",ent.getAltName3())+nl);
		sb.append(showString(outType,"encryptedNameRelative",ent.getEncryptedNameRelative())+nl);  //the encrypted string for name relative. sand,compress, encrypt
		sb.append(showString(outType,"encryptedNameAbsolute",ent.getEncryptedNameAbsolute())+nl);  //the encrypted string for name relative
		sb.append(showLong(outType,"nameHashId",ent.getNameHashId())+nl); 

		sb.append(showString(outType,"fileURI",ent.getFileURI())+nl);
		sb.append(showString(outType,"fileURL",ent.getFileURL())+nl);
		sb.append(showString(outType,"extensionName",ent.getExtensionName())+nl);
		sb.append(showString(outType,"nameWithoutExtension",ent.getNameWithoutExtension())+nl);
		sb.append(showLong(outType,"fileNameAbsoluteLength",ent.getFileNameAbsoluteLength())+nl);
		sb.append(showString(outType,"ownerName",ent.getOwnerName())+nl);	
		
		sb.append(showString(outType,"canExecute",ent.getCanExecute())+nl);
		sb.append(showString(outType,"canRead",ent.getCanRead())+nl);
		sb.append(showString(outType,"canWrite",ent.getCanWrite())+nl);
		sb.append(showString(outType,"isExists",ent.getIsExists())+nl);
		sb.append(showString(outType,"isDirectory",ent.getIsDirectory())+nl);
		sb.append(showString(outType,"isFile",ent.getIsFile())+nl);
		sb.append(showString(outType,"isSymbolicLink",ent.getIsSymbolicLink())+nl);
		sb.append(showString(outType,"isHidden",ent.getIsHidden())+nl);	  
		sb.append(showString(outType,"isArchive",ent.getIsArchive())+nl); 
		sb.append(showString(outType,"isSystem",ent.getIsSystem())+nl);
		
		sb.append(showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);	    
		sb.append(showString(outType,"isOther",ent.getIsOther())+nl);
		sb.append(showString(outType,"isRegularFile",ent.getIsRegularFile())+nl);
		sb.append(showString(outType,"probeContentType",ent.getProbeContentType())+nl);//the MIME type of a file	
		
		sb.append(showLong(outType,"freeSpace",ent.getFreeSpace())+nl);
		sb.append(showLong(outType,"totalSpace",ent.getTotalSpace())+nl);
		sb.append(showLong(outType,"usableSpace",ent.getUsableSpace())+nl);
		sb.append(showLong(outType,"compressedFileSize",ent.getCompressedFileSize())+nl);
		sb.append(showDouble(outType,"compressionGainRatio",ent.getCompressionGainRatio())+nl); 
		sb.append(showLong(outType,"compressionGainBytes",ent.getCompressionGainBytes())+nl);  
	    
		sb.append(showString(outType,"encoding",ent.getEncoding())+nl);
		sb.append(showString(outType,"charsetStr",ent.getCharsetStr())+nl); 
		sb.append(showLong(outType,"lastModified",ent.getLastModified())+nl); 
		sb.append(showZDT(outType,"fileCreationDate",ent.getFileCreationDate())+nl);
		sb.append(showZDT(outType,"fileModificationDate",ent.getFileModificationDate())+nl);
		sb.append(showZDT(outType,"fileLastAccessTime",ent.getFileLastAccessTime())+nl);
		sb.append(showString(outType,"fileRemark",ent.getFileRemark())+nl);
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		sb.append(showList(outType,"NodeFile","listSiblingFile",ent.getListSiblingFile())+nl);
		sb.append(showList(outType,"NodeFileBlob","listFileBlobRegular",ent.getListFileBlobRegular())+nl);
		sb.append(showList(outType,"NodeFileBlob","listFileBlobBig",ent.getListFileBlobBig())+nl);
		sb.append(showList(outType,"NodeFileBlob","listFileBlobSmall",ent.getListFileBlobSmall())+nl);
			
		return(sb.toString());
	}
	public static String getShowString(String outType,NodeFileBlob ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"fileBlobId",ent.getFileBlobId())+nl);
		sb.append(showLong(outType,"fileId",ent.getFileId())+nl);
		sb.append(showLong(outType,"blobId",ent.getBlobId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showString(outType,"blobType",ent.getBlobType())+nl);
		sb.append(showLong(outType,"blobSize",ent.getBlobSize())+nl);
		sb.append(showLong(outType,"fileSize",ent.getFileSize())+nl);  
		sb.append(showLong(outType,"hashId",ent.getHashId())+nl);
		sb.append(showString(outType,"blobDbName",ent.getBlobDbName())+nl);
		sb.append(showString(outType,"blobDbAttachmentName",ent.getBlobDbAttachmentName())+nl);
		sb.append(showString(outType,"blobTableName",ent.getBlobTableName())+nl);
		sb.append(showLong(outType,"bigPartNumber",ent.getBigPartNumber())+nl);
		sb.append(showLong(outType,"bigCntPart",ent.getBigCntPart())+nl);
		sb.append(showLong(outType,"smallByteIndexStart",ent.getSmallByteIndexStart())+nl);
		sb.append(showLong(outType,"smallByteIndexEnd",ent.getSmallByteIndexEnd())+nl);
		
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeBlob ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"blobId",ent.getBlobId())+nl);
		sb.append(showLong(outType,"sourceId",ent.getSourceId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"firstPartBlobId",ent.getFirstPartBlobId())+nl);
		sb.append(showLong(outType,"partNumber",ent.getPartNumber())+nl);
		sb.append(showLong(outType,"cntPart",ent.getCntPart())+nl);
		sb.append(showString(outType,"blobType",ent.getBlobType())+nl);
		sb.append(showLong(outType,"blobSize",ent.getBlobSize())+nl);
		sb.append(showLong(outType,"blobHashId",ent.getBlobHashId())+nl);
		sb.append(showString(outType,"compressionType",ent.getCompressionType())+nl);
		sb.append(showLong(outType,"compressedSize",ent.getCompressedSize())+nl);
		sb.append(showDouble(outType,"compressionGainRatio",ent.getCompressionGainRatio())+nl);
		sb.append(showLong(outType,"compressionGainBytes",ent.getCompressionGainBytes())+nl);
		sb.append(showLong(outType,"compressedByteHashId",ent.getCompressedByteHashId())+nl);
		sb.append(showLong(outType,"sandByteLengthHead",ent.getSandByteLengthHead())+nl);
		sb.append(showString(outType,"encryptionBlobKey",ent.getEncryptionBlobKey())+nl);
		sb.append(showString(outType,"encryptionType",ent.getEncryptionType())+nl);
		sb.append(showLong(outType,"encryptedSize",ent.getEncryptedSize())+nl);
		sb.append(showLong(outType,"encrytedByteHashId",ent.getEncrytedByteHashId())+nl);
		sb.append(showBytes(outType,"blobBytes",ent.getBlobBytes())+nl);
		sb.append(showBytes(outType,"compressedBytes",ent.getCompressedBytes())+nl);
		sb.append(showBytes(outType,"encryptedBytes",ent.getEncryptedBytes())+nl);
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeFileStore ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"fileStoreId",ent.getFileStoreId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"fileSystemId",ent.getFileSystemId())+nl);
		sb.append(showLong(outType,"rootFileId",ent.getRootFileId())+nl);
		sb.append(showLong(outType,"displayOrder",ent.getDisplayOrder())+nl);
		sb.append(showLong(outType,"blockSize",ent.getBlockSize())+nl);
		sb.append(showLong(outType,"totalSpace",ent.getTotalSpace())+nl);
		sb.append(showLong(outType,"unallocatedSpace",ent.getUnallocatedSpace())+nl);
		sb.append(showLong(outType,"usableSpace",ent.getUsableSpace())+nl);
		sb.append(showLong(outType,"usedSpace",ent.getUsedSpace())+nl);
		sb.append(showLong(outType,"hashCode",ent.getHashCode())+nl);
		
		sb.append(showString(outType,"rootDirectoryName",ent.getRootDirectoryName())+nl);
		sb.append(showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);
		sb.append(showString(outType,"nameStr",ent.getNameStr())+nl);
		sb.append(showString(outType,"toString",ent.getToString())+nl);
		sb.append(showString(outType,"typeStr",ent.getTypeStr())+nl);
	    
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeFileSystem ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"fileSystemId",ent.getFileSystemId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"hostId",ent.getHostId())+nl);
		sb.append(showLong(outType,"rootFileId",ent.getRootFileId())+nl);
		sb.append(showLong(outType,"displayOrder",ent.getDisplayOrder())+nl);
		sb.append(showString(outType,"systemName",ent.getSystemName())+nl);
		sb.append(showString(outType,"providerName",ent.getProviderName())+nl);
		sb.append(showLong(outType,"providerHashCode",ent.getProviderHashCode())+nl);
		sb.append(showString(outType,"isDefault",ent.getIsDefault())+nl);
		sb.append(showString(outType,"isOpen",ent.getIsOpen())+nl);
		sb.append(showString(outType,"isReadOnly",ent.getIsReadOnly())+nl);
		
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
	
		//private FileSystem realFileSystem;
	    
		sb.append(showList(outType,"NodeFileStore","listFileStore",ent.getListFileStore())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeHash ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"hashId",ent.getHashId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"fileSize",ent.getFileSize())+nl);
		sb.append(showLong(outType,"crc64",ent.getCrc64())+nl);
		sb.append(showLong(outType,"crc32",ent.getCrc32())+nl);
		sb.append(showLong(outType,"adler32",ent.getAdler32())+nl);
		
		sb.append(showString(outType,"blake3",ent.getBlake3())+nl);
		sb.append(showString(outType,"md5",ent.getMd5())+nl);
		sb.append(showString(outType,"sha1",ent.getSha1())+nl);
		sb.append(showString(outType,"sha256",ent.getSha256())+nl);
		sb.append(showString(outType,"sha384",ent.getSha384())+nl);
		sb.append(showString(outType,"sha512",ent.getSha512())+nl);
		sb.append(showString(outType,"sha3256",ent.getSha3256())+nl);
		sb.append(showString(outType,"keccak256",ent.getKeccak256())+nl);
		
		sb.append(showString(outType,"hashFieldDesc",ent.getHashFieldDesc())+nl);
		sb.append(showString(outType,"hashStr01",ent.getHashStr01())+nl);
		sb.append(showString(outType,"hashStr02",ent.getHashStr02())+nl);
		sb.append(showString(outType,"hashStr03",ent.getHashStr03())+nl);
		sb.append(showString(outType,"hashStr04",ent.getHashStr04())+nl);
		sb.append(showString(outType,"hashStr05",ent.getHashStr05())+nl);
		sb.append(showLong(outType,"hashLong01",ent.getHashLong01())+nl);
		sb.append(showLong(outType,"hashLong02",ent.getHashLong02())+nl);
		sb.append(showLong(outType,"hashLong03",ent.getHashLong03())+nl);
		sb.append(showLong(outType,"hashLong04",ent.getHashLong04())+nl);
		sb.append(showLong(outType,"hashLong05",ent.getHashLong05())+nl);
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}
	public static String getShowString(String outType,NodeHost ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"hostId",ent.getHostId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showString(outType,"hostName",ent.getHostName())+nl);
		sb.append(showString(outType,"hostIP",ent.getHostIP())+nl);
		sb.append(showString(outType,"domainName",ent.getDomainName())+nl);
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeArchive ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"archiveId",ent.getArchiveId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"archiveFileId",ent.getArchiveFileId())+nl);
		sb.append(showLong(outType,"archiveFileSetId",ent.getArchiveFileSetId())+nl);
		sb.append(showString(outType,"archiveType",ent.getArchiveType())+nl);
		sb.append(showString(outType,"extensionType",ent.getExtensionType())+nl);
		sb.append(showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		sb.append(showString(outType,"multipleFileArchive",ent.getMultipleFileArchive())+nl);
		sb.append(showString(outType,"archiveRemark",ent.getArchiveRemark())+nl);
		
		sb.append(showLong(outType,"cntFile",ent.getCntFile())+nl);
		sb.append(showLong(outType,"cntArchive",ent.getCntArchive())+nl);
		sb.append(showLong(outType,"cntDirectory",ent.getCntDirectory())+nl);
		sb.append(showLong(outType,"cntFileTree",ent.getCntFileTree())+nl);
		sb.append(showLong(outType,"cntDirectoryTree",ent.getCntDirectoryTree())+nl);
		sb.append(showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		sb.append(showLong(outType,"unzippedFileSize",ent.getUnzippedFileSize())+nl);
		sb.append(showDouble(outType,"unzipGainRatio",ent.getUnzipGainRatio())+nl);
		sb.append(showLong(outType,"unzippedGainBytes",ent.getUnzippedGainBytes())+nl);
		
		sb.append(showZDT(outType,"archiveCreationDate",ent.getArchiveCreationDate())+nl);
		sb.append(showZDT(outType,"archiveModificationDate",ent.getArchiveModificationDate())+nl);
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		sb.append(showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getShowString(String outType,NodeContainer ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"containerId",ent.getContainerId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"containerFileId",ent.getContainerFileId())+nl);
		sb.append(showLong(outType,"containerFileSetId",ent.getContainerFileSetId())+nl);
		sb.append(showString(outType,"containerType",ent.getContainerType())+nl);
		sb.append(showString(outType,"extensionType",ent.getExtensionType())+nl);
		sb.append(showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		sb.append(showString(outType,"containerRemark",ent.getContainerRemark())+nl);
		
		sb.append(showLong(outType,"cntFile",ent.getCntFile())+nl);
		sb.append(showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		sb.append(showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}
	public static String getShowString(String outType,NodeTransform ent)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showLong(outType,"transformId",ent.getTransformId())+nl);
		sb.append(showLong(outType,"fileSetId",ent.getFileSetId())+nl);
		sb.append(showLong(outType,"transformFileId",ent.getTransformFileId())+nl);
		sb.append(showLong(outType,"transformFileSetId",ent.getTransformFileSetId())+nl);
		sb.append(showLong(outType,"transformedFileId",ent.getTransformedFileId())+nl);
		sb.append(showString(outType,"transformType",ent.getTransformType())+nl);
		sb.append(showString(outType,"extensionType",ent.getExtensionType())+nl);
		sb.append(showString(outType,"algorithmName",ent.getAlgorithmName())+nl);
		sb.append(showString(outType,"transformRemark",ent.getTransformRemark())+nl);
		sb.append(showString(outType,"tmpFileName",ent.getTmpFileName())+nl);
		
		sb.append(showLong(outType,"cntFile",ent.getCntFile())+nl);
		sb.append(showLong(outType,"originalFileSize",ent.getOriginalFileSize())+nl);
		sb.append(showLong(outType,"transformedFileSize",ent.getTransformedFileSize())+nl);
		
		sb.append(showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		sb.append(showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		sb.append(showList(outType,"NodeFile","listFile",ent.getListFile())+nl);
		
		//sb.append(showLong(outType,"serialVersionUID",ent.getSerialVersionUID())+nl);
		return(sb.toString());
	}	
	public static String getAllClassesFileSet(NodeFileSet fileSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showClass("tool10.fileset.nodes.NodeFileSet","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeFile","NodeFile"));
		sb.append(showClass("tool10.fileset.nodes.NodeFileBlob","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeBlob","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeFileStore","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeFileSystem","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeHash","NodeFileSet"));
		sb.append(showClass("tool10.fileset.nodes.NodeHost","NodeFileSet"));
		
		sb.append(showClass("tool10.fileset.transform.NodeArchive","NodeArchive"));
		sb.append(showClass("tool10.fileset.transform.NodeContainer","NodeContainer"));
		sb.append(showClass("tool10.fileset.transform.NodeTransform","NodeTransform"));
		
		return(sb.toString());
	}
	public static String getAllPackagesFileSet(NodeFileSet fileSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(showPackage("tool10.fileset.nodes","nodes"));
		sb.append(showPackage("tool10.fileset.transform","transform"));
		
		return(sb.toString());
	}
	public static String getAllShowString4FileSet(NodeFileSet fileSet,String outType,HashSet<String> nodeSet)	{
		StringBuilder sb = new StringBuilder();
		
		if (nodeSet.contains("fileSet")) 	{sb.append(getShowString(outType,fileSet));}
		if (nodeSet.contains("file")) 		{for (NodeFile file : fileSet.getListFile())	{	sb.append(getShowString(outType,file)); }}
	/*	for (NodeFileBlob fileBlob : fileSet.getListFileBlob())			{	sb.append(getShowString(outType,fileBlob)); }
		for (NodeBlob blob : fileSet.getListBlob())						{	sb.append(getShowString(outType,blob)); }
		for (NodeFileStore fileStore : fileSet.getListFileStore())		{	sb.append(getShowString(outType,fileStore)); }
		for (NodeFileSystem fileSystem : fileSet.getListFileSystem())	{	sb.append(getShowString(outType,fileSystem)); }
		for (NodeHash hash : fileSet.getListHash())						{	sb.append(getShowString(outType,hash)); }
		for (NodeHost host : fileSet.getListHost())						{	sb.append(getShowString(outType,host)); }
		
		for (NodeArchive archive : fileSet.getListArchive())			{	sb.append(getShowString(outType,archive)); }
		for (NodeContainer container : fileSet.getListContainer())		{	sb.append(getShowString(outType,container)); }
		for (NodeTransform transform : fileSet.getListTransform())		{	sb.append(getShowString(outType,transform)); }
	*/			
		//NodeFileGroup,NodeFileGrouping,NodeFileGroupMember,NodeLog, NodeProperty, NodeQuery, NodeStat will come in future 
		return(sb.toString());
	}
	
}
