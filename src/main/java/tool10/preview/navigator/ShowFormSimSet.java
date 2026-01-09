package tool10.preview.navigator;

import java.util.ArrayList;
import java.util.HashSet;

import tool10.simset.NodeEntity;
import tool10.simset.NodeEntityType;
import tool10.simset.NodeSimSet;
import tool10.simset.NodeSimilarity;

public class ShowFormSimSet {

	private static final String nl = "\n";
	
	public static String getShowString(NodeShow show,String outType, NodeSimSet ent)	{
		
		ArrayList<String> fieldLineArray = new ArrayList<String>();  
		fieldLineArray.add(ShowFormCommon.showLong(outType,"simSetId",ent.getSimSetId())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceId",ent.getSourceId())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"simSetName",ent.getSimSetName())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"blobSetDesc",ent.getSimSetDesc())+nl); 
		fieldLineArray.add(ShowFormCommon.showString(outType,"ownerName",ent.getOwnerName())+nl); 
		fieldLineArray.add(ShowFormCommon.showLong(outType,"displayOrder",ent.getDisplayOrder())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl); 
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl); 
				
		//public NodeSimSet(Long simSetId, Long sourceId, String simSetName, String simSetDesc, String ownerName,
		//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeSimilarity","listSimilarity",ent.getListSimilarity())+nl);
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeEntity","listEntity",ent.getListEntity())+nl); 
		fieldLineArray.add(ShowFormCommon.showList(outType,"NodeEntityType","listEntityType",ent.getListEntityType())+nl);
		
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlob","mapId2Similarity",ent.getMapId2Similarity())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobEntity","mapId2Entity",ent.getMapId2Entity())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"Long","NodeBlobHash","mapId2EntityType",ent.getMapId2EntityType())+nl);
		
		fieldLineArray.add(ShowFormCommon.showMap(outType,"String","NodeEntityType","mapEntityName2EntityType",ent.getMapEntityName2EntityType())+nl);
		fieldLineArray.add(ShowFormCommon.showMap(outType,"String","NodeSimilarity","mapKey2Similarity",ent.getMapKey2Similarity())+nl);
		
	/*		private ArrayList<NodeEntityType> listEntityType;
			private ArrayList<NodeEntity> listEntity;
			private ArrayList<NodeSimilarity> listSimilarity;
			
			private HashMap<Long,NodeEntityType> mapId2EntityType;
			private HashMap<Long,NodeEntity> mapId2Entity;
			private HashMap<Long,NodeSimilarity> mapId2Similarity;
			private HashMap<String,NodeEntityType> mapEntityName2EntityType;
			private HashMap<String,NodeSimilarity> mapKey2Similarity;
	*/	
		String anchorStr = "form_simSet"+ent.getSimSetId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(simSet["+ent.getSimSetId()+",'"+ent.getSimSetName()+"'])");
		return(ss);
	}	
	
	public static String getShowString(NodeShow show,String outType,NodeEntity ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityId",ent.getEntityId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityTypeId",ent.getEntityTypeId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"simSetId",ent.getSimSetId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"sourceId",ent.getSourceId())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"valueStr",ent.getValueStr())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"valueLong",ent.getValueLong())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"valueDouble",ent.getValueDouble())+nl);  
		fieldLineArray.add(ShowFormCommon.showBytes(outType,"valueBLOB",ent.getValueBLOB())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
		//Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		String anchorStr = "form_entity"+ent.getEntityId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(entity["+ent.getEntityId()+",'"+ent.getEntityId()+"'])");
		return(ss);
	}	
	public static String getShowString(NodeShow show,String outType,NodeEntityType ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityTypeId",ent.getEntityTypeId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"simSetId",ent.getSimSetId())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"entityTypeName",ent.getEntityTypeName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"entityTypeDesc",ent.getEntityTypeDesc())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"dbName",ent.getDbName())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"fieldType",ent.getFieldType())+nl);
		
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
		//String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		String anchorStr = "form_entityType"+ent.getEntityTypeId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(entityType["+ent.getEntityTypeId()+",'"+ent.getEntityTypeId()+"'])");
		return(ss);
	}
	public static String getShowString(NodeShow show,String outType,NodeSimilarity ent)	{
		ArrayList<String> fieldLineArray = new ArrayList<String>();
		
		fieldLineArray.add(ShowFormCommon.showLong(outType,"similarityId",ent.getSimilarityId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"simSetId",ent.getSimSetId())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityId1",ent.getEntityId1())+nl);
		fieldLineArray.add(ShowFormCommon.showLong(outType,"entityId2",ent.getEntityId2())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"similarityType",ent.getSimilarityType())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"similarityKey",ent.getSimilarityKey())+nl);
		
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim00",ent.getSim00())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim01",ent.getSim01())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim02",ent.getSim02())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim03",ent.getSim03())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim04",ent.getSim04())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim05",ent.getSim05())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim06",ent.getSim06())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim07",ent.getSim07())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim08",ent.getSim08())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim09",ent.getSim09())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim10",ent.getSim10())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim11",ent.getSim11())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim12",ent.getSim12())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim13",ent.getSim13())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim14",ent.getSim14())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim15",ent.getSim15())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim16",ent.getSim16())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim17",ent.getSim17())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim18",ent.getSim18())+nl);
		fieldLineArray.add(ShowFormCommon.showDouble(outType,"sim19",ent.getSim19())+nl);
		
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg00",ent.getAlg00())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg01",ent.getAlg01())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg02",ent.getAlg02())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg03",ent.getAlg03())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg04",ent.getAlg04())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg05",ent.getAlg05())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg06",ent.getAlg06())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg07",ent.getAlg07())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg08",ent.getAlg08())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg09",ent.getAlg09())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg10",ent.getAlg10())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg11",ent.getAlg11())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg12",ent.getAlg12())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg13",ent.getAlg13())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg14",ent.getAlg14())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg15",ent.getAlg15())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg16",ent.getAlg16())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg17",ent.getAlg17())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg18",ent.getAlg18())+nl);
		fieldLineArray.add(ShowFormCommon.showString(outType,"alg19",ent.getAlg19())+nl);
	
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"creationDate",ent.getCreationDate())+nl);
		fieldLineArray.add(ShowFormCommon.showZDT(outType,"modificationDate",ent.getModificationDate())+nl);
		
		//public NodeSimilarity(Long similarityId, Long simSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
		//		Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
		//		Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
		//		Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
		//		String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
		//		String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
		//		String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
		//		ZonedDateTime modificationDate) {
		
		String anchorStr = "form_similarity"+ent.getSimilarityId(); 
		String ss = ShowFormCommon.tableize(fieldLineArray,anchorStr,"(similarity["+ent.getSimilarityId()+",'"+ent.getSimilarityId()+"'])");
		return(ss);
	}	
	public static String getAllClassesBlobSet(NodeSimSet simSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showClass("tool10.simset.nodes.NodeSimSet","NodeSimSet"));
		sb.append(ShowFormCommon.showClass("tool10.simset.nodes.NodeEntity","NodeEntity"));
		sb.append(ShowFormCommon.showClass("tool10.simset.nodes.NodeEntityType","NodeEntityType"));
		sb.append(ShowFormCommon.showClass("tool10.simset.nodes.NodeSimilarity","NodeSimilarity"));
			
		return(sb.toString());
	}
	public static String getAllPackagesSimSet(NodeSimSet simSet,String outType)	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(ShowFormCommon.showPackage("tool10.simset","simset"));
		return(sb.toString());
	}
	public static void createAllAnchorsFormSimSet(NodeShow show, NodeSimSet simSet,HashSet<String> nodeSet)	{
		
		ArrayList<String> listAnchor = new ArrayList<>(); 
		if (nodeSet.contains("simSet")) 	{String ss = "form_simSet"+simSet.getSimSetId(); listAnchor.add(ss); }
		
		if (nodeSet.contains("entityType")) 		{
			for (NodeEntityType ent : simSet.getListEntityType())	{	String ss = "form_entityType"+ent.getEntityTypeId(); listAnchor.add(ss); }}
		if (nodeSet.contains("simEntity")) 		{
			for (NodeEntity ent : simSet.getListEntity())	{	String ss = "form_entity"+ent.getEntityId(); listAnchor.add(ss); }}
		if (nodeSet.contains("similarity")) 		{
			for (NodeSimilarity ent : simSet.getListSimilarity())	{	String ss = "form_similarity"+ent.getSimilarityId(); listAnchor.add(ss); }}
		
		for (String anchStr : listAnchor) {show.getMapAnchor().put(anchStr, anchStr); }
		System.out.println("ShowForm createAllAnchorsFormSimSet show.getMapAnchor().size():"+show.getMapAnchor().size()); 
	}	
	public static String getAllShowString4SimSet(NodeShow show, NodeSimSet simSet,String outType,HashSet<String> nodeSet)	{
		
		createAllAnchorsFormSimSet(show, simSet, nodeSet);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html><br>\n<body><br>\n<form action=''>"+nl);
		if (nodeSet.contains("simSet")) 	{sb.append(getShowString(show,outType,simSet));}
		if (nodeSet.contains("entityType")) 		{for (NodeEntityType entityType : simSet.getListEntityType())	{	sb.append(getShowString(show,outType,entityType)); }}
		if (nodeSet.contains("entity")) {for (NodeEntity entity : simSet.getListEntity())	{	sb.append(getShowString(show,outType,entity)); }}
		if (nodeSet.contains("similarity")) 	{for (NodeSimilarity similarity : simSet.getListSimilarity())	{	sb.append(getShowString(show,outType,similarity)); }}
		
		sb.append("</form></body></html>"+nl);
		return(sb.toString());
	}	
	
}
