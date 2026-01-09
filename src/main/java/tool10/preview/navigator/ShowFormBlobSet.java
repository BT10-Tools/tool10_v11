package tool10.preview.navigator;

import java.util.ArrayList;
import java.util.HashSet;

import tool10.blobset.NodeBlob;
import tool10.blobset.NodeBlobEntity;
import tool10.blobset.NodeBlobHash;
import tool10.blobset.NodeBlobSet;

public class ShowFormBlobSet {

	private static final String nl = "\n";
	
	public static String getShowString(NodeShow show,String outType, NodeBlobSet ent)	{
		
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSetId",ent.getBlobSetId())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceId",ent.getSourceId())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobSetName",ent.getBlobSetName())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobSetDesc",ent.getBlobSetDesc())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobSetURL",ent.getBlobSetURL())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"ownerName",ent.getOwnerName())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"displayOrder",ent.getDisplayOrder())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl); 
				
		//public NodeBlobSet(Long blobSetId, Long sourceId, String blobSetName, String blobSetDesc, String blobSetURL,
		//String ownerName, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {

		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeBlob","listBlob",ent.getListBlob())+nl);
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeBlobEntity","listBlobEntity",ent.getListBlobEntity())+nl); 
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeBlobHash","listBlobHash",ent.getListBlobHash())+nl);
		
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlob","mapId2Blob",ent.getMapId2Blob())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobEntity","mapId2BlobEntity",ent.getMapId2BlobEntity())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobHash","mapId2BlobHash",ent.getMapId2BlobHash())+nl);
		
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobHash","mapCrc2NodeBlobHash",ent.getMapCrc2NodeBlobHash())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobEntity","mapEntityId2BlobEntity",ent.getMapEntityId2BlobEntity())+nl);
		
	/*	this.listBlob.clear();
		this.listBlobEntity.clear(); 
		this.listBlobHash.clear(); 

		this.mapId2Blob.clear();
		this.mapId2BlobEntity.clear(); 
		this.mapId2BlobHash.clear(); 
		
		this.mapCrc2NodeBlobHash.clear();
		this.mapEntityId2BlobEntity.clear();		
	*/	
		String anchorStr = "form_blobSet"+ent.getBlobSetId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(blobSet["+ent.getBlobSetId()+",'"+ent.getBlobSetName()+"'])");
		return(ss);
	}	
	
	public static String getShowString(NodeShow show,String outType,NodeBlobEntity ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobEntityId",ent.getBlobEntityId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityId",ent.getEntityId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobId",ent.getBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSetId",ent.getBlobSetId())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobType",ent.getBlobType())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSize",ent.getBlobSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceSize",ent.getSourceSize())+nl);  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashId",ent.getHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobDbName",ent.getBlobDbName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobDbAttachmentName",ent.getBlobDbAttachmentName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobTableName",ent.getBlobTableName())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"bigPartNumber",ent.getBigPartNumber())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"bigCntPart",ent.getBigCntPart())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"smallByteIndexStart",ent.getSmallByteIndexStart())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"smallByteIndexEnd",ent.getSmallByteIndexEnd())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeBlobEntity(Long blobEntityId, Long entityId, Long blobId, Long blobSetId, String blobType, Long blobSize,
		//Long sourceSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		String anchorStr = "form_blobEntity"+ent.getBlobEntityId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(blobEntity["+ent.getBlobEntityId()+",'"+ent.getBlobEntityId()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeBlob ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobId",ent.getBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceId",ent.getSourceId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSetId",ent.getBlobSetId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"firstPartBlobId",ent.getFirstPartBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"partNumber",ent.getPartNumber())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"cntPart",ent.getCntPart())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobType",ent.getBlobType())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSize",ent.getBlobSize())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"compressionType",ent.getCompressionType())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressedSize",ent.getCompressedSize())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"compressionGainRatio",ent.getCompressionGainRatio())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressionGainBytes",ent.getCompressionGainBytes())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"compressedByteHashId",ent.getCompressedByteHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sandByteLengthHead",ent.getSandByteLengthHead())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sandByteLengthTail",ent.getSandByteLengthTail())+nl);		
		fieldLineArray.add(ShowFormCommon.showString(outType,"encryptionBlobKey",ent.getEncryptionBlobKey())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"encryptionType",ent.getEncryptionType())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"encryptedSize",ent.getEncryptedSize())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"encrytedByteHashId",ent.getEncrytedByteHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showBytes(outType,"blobBytes",ent.getBlobBytes())+nl);
		fieldLineArray.add(ShowFormCommon.showBytes(outType,"compressedBytes",ent.getCompressedBytes())+nl);
		fieldLineArray.add(ShowFormCommon.showBytes(outType,"encryptedBytes",ent.getEncryptedBytes())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobHashId",ent.getBlobHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeBlob(Long blobId, Long sourceId, Long blobSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {	
		
		String anchorStr = "form_blob"+ent.getBlobId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(blob["+ent.getBlobId()+",'"+ent.getBlobId()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeBlobHash ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobHashId",ent.getBlobHashId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobId",ent.getBlobId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobEntityId",ent.getBlobEntityId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSetId",ent.getBlobSetId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"blobSize",ent.getBlobSize())+nl);
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"crc64",ent.getCrc64())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"crc32",ent.getCrc32())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"adler32",ent.getAdler32())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"blake3",ent.getBlake3())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"md5",ent.getMd5())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha1",ent.getSha1())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha256",ent.getSha256())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha384",ent.getSha384())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha512",ent.getSha512())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"sha3256",ent.getSha3256())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"keccak256",ent.getKeccak256())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashFieldDesc",ent.getHashFieldDesc())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr01",ent.getHashStr01())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr02",ent.getHashStr02())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr03",ent.getHashStr03())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr04",ent.getHashStr04())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"hashStr05",ent.getHashStr05())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong01",ent.getHashLong01())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong02",ent.getHashLong02())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong03",ent.getHashLong03())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong04",ent.getHashLong04())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"hashLong05",ent.getHashLong05())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeBlobHash(Long blobHashId, Long blobId, Long blobEntityId, Long blobSetId, Long blobSize, 
		//Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		String anchorStr = "form_blobHash"+ent.getBlobHashId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(blobHash["+ent.getBlobHashId()+",'"+ent.getBlobHashId()+"'])");
		return(ss);
	}
	public static String getAllClassesBlobSet(NodeBlobSet blobSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showClass("tool10.blobset.nodes.NodeBlobSet","NodeBlobSet"));
		sb.append(ShowFormCommon.showClass("tool10.blobset.nodes.NodeBlobEntity","NodeBlobEntity"));
		sb.append(ShowFormCommon.showClass("tool10.blobset.nodes.NodeBlob","NodeBlob"));
		sb.append(ShowFormCommon.showClass("tool10.blobset.nodes.NodeBlobHash","NodeBlobHash"));
			
		return(sb.toString());
	}
	public static String getAllPackagesBlobSet(NodeBlobSet blobSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showPackage("tool10.blobset","blobset"));
		return(sb.toString());
	}
	public static void createAllAnchorsFormBlobSet(NodeShow show, NodeBlobSet blobSet,HashSet<String> nodeSet)	{
		
		ArrayList<String> listAnchor = new ArrayList<>(); 
		if (nodeSet.contains("blobSet")) 	{String ss = "form_blobSet"+blobSet.getBlobSetId(); listAnchor.add(ss); }
		
		if (nodeSet.contains("blob")) 		{
			for (NodeBlob ent : blobSet.getListBlob())	{	String ss = "form_blob"+ent.getBlobId(); listAnchor.add(ss); }}
		if (nodeSet.contains("blobEntity")) 		{
			for (NodeBlobEntity ent : blobSet.getListBlobEntity())	{	String ss = "form_blobEntity"+ent.getBlobEntityId(); listAnchor.add(ss); }}
		if (nodeSet.contains("blobHash")) 		{
			for (NodeBlobHash ent : blobSet.getListBlobHash())	{	String ss = "form_blobHash"+ent.getBlobHashId(); listAnchor.add(ss); }}
		
		for (String anchStr : listAnchor) {show.getMapAnchor().put(anchStr, anchStr); }
		System.out.println("ShowForm createAllAnchorsFormBlobSet show.getMapAnchor().size():"+show.getMapAnchor().size()); 
	}	
	public static String getAllShowString4BlobSet(NodeShow show, NodeBlobSet blobSet,String outType,HashSet<String> nodeSet)	{
		
		createAllAnchorsFormBlobSet(show, blobSet, nodeSet);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html><br>\n<body><br>\n<form action=''>"+nl);
		if (nodeSet.contains("blobSet")) 	{sb.append(getShowString(show,outType,blobSet));}
		if (nodeSet.contains("blob")) 		{for (NodeBlob blob : blobSet.getListBlob())	{	sb.append(getShowString(show,outType,blob)); }}
		if (nodeSet.contains("blobEntity")) {for (NodeBlobEntity blobEntity : blobSet.getListBlobEntity())	{	sb.append(getShowString(show,outType,blobEntity)); }}
		if (nodeSet.contains("blobHash")) 	{for (NodeBlobHash blobHash : blobSet.getListBlobHash())	{	sb.append(getShowString(show,outType,blobHash)); }}
				
		//NodeFileGroup,NodeFileGrouping,NodeFileGroupMember,NodeLog, NodeProperty, NodeQuery, NodeStat will come in future
		sb.append("</form></body></html>"+nl);
		return(sb.toString());
	}	
	
}
