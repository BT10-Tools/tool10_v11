package tool10.simset;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.sql.Conn10;

public class MakeSimSet {

	public static Long getEntityTypeIdByName(NodeF10 f10, String entityTypeName)	{
		Long entityTypeId = null;
		NodeEntityType entityType = f10.getSimSet().getMapEntityName2EntityType().get(entityTypeName); 
		if (entityType!=null) return(entityType.getEntityTypeId());
		return(entityTypeId);
	}
	public static NodeEntityType createOneSimEntityType(NodeF10 f10,String entityTypeName, String entityTypeDesc)	{
		Long entityTypeId = f10.getConnSim().getNextId(-1); //"IMG_IMAGEFILE"
	
		ZonedDateTime creationDate = ZonedDateTime.now();	
	    //public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
		//String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeEntityType simEntityType = new NodeEntityType(entityTypeId, f10.getSimSet().getSimSetId(), entityTypeName, entityTypeDesc, null, null, null, null, creationDate,null);  		
  		f10.getSimSet().getListEntityType().add(simEntityType);
	    f10.getSimSet().getMapId2EntityType().put(simEntityType.getEntityTypeId(),simEntityType);  
	    return(simEntityType);
	}
	private static final String[] entityTypeArray = new String[] {"dir","file","media","book"};
	public static int createSimEntityTypes(NodeF10 f10)	{
		int cntCreated = 0;
		for (String entityTypeStr : entityTypeArray)	{
			if (f10.getSimSet().getMapEntityName2EntityType().get(entityTypeStr)==null)	{
				String entityTypeName = entityTypeStr; 
				String entityTypeDesc = entityTypeStr + "_Desc";
				createOneSimEntityType(f10,entityTypeName, entityTypeDesc);
				cntCreated++;
			}
		}
		return(cntCreated);
	}
	public static void createOneSimEntityFromFile(NodeF10 f10,Long entityTypeId,NodeFile nodeFile)	{
		Long entityId = f10.getConnSim().getNextId(-1); //"IMG_IMAGEFILE"
	
		ZonedDateTime creationDate = ZonedDateTime.now();	
	    //public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
		//Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeEntity simEntity = new NodeEntity(entityId, entityTypeId, f10.getSimSet().getSimSetId(), nodeFile.getFileId(), Long.toString(nodeFile.getFileId()), nodeFile.getFileId(), 
				null, null, creationDate,null);  		
  		f10.getSimSet().getListEntity().add(simEntity);
	    f10.getSimSet().getMapId2Entity().put(simEntity.getEntityId(),simEntity);  		
	}
	public static void createSimEntitiesFromFileList(NodeF10 f10, Long entityTypeId, ArrayList<NodeFile> fileList4Sim)	{
		for (NodeFile nodeFile : fileList4Sim)	{
			createOneSimEntityFromFile(f10,entityTypeId,nodeFile);
		}
	}
	public static ArrayList<NodeFile> getFileList4SimFromFileSet(NodeF10 f10, String fileOrDir)	{
		
		ArrayList<NodeFile> fileList = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			if ("yes".equals(nodeFile.getIsSymbolicLink())) continue;
			//other filters can come here like wildcards
			
			if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			//if (cnt++ > 100) break; //for test purpose, only process 100 files
			
			fileList.add(nodeFile);
		}
		System.out.println("MakeSimSet getFileList4SimFromFileSet 	fileList.size() = "+fileList.size());
		return(fileList);
	}
	private static NodeSimSet createOneSimSet(Conn10 connSim,Long fileSetId,String simSetName,String sourceName)	{
		NodeSimSet simSet = null;
		Long simSetId = connSim.getNextId(-1); //"IMG_IMAGESET");
		
		String simSetDesc = simSetName+"_DESC"; 
		String ownerName = null;
		ZonedDateTime creationDate = ZonedDateTime.now();
		ZonedDateTime modificationDate = null;
		//public NodeSimSet(Long simSetId, Long sourceId, String simSetName, String simSetDesc, String sourceName, String ownerName,
		//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		simSet = new NodeSimSet(simSetId,fileSetId,simSetName,simSetDesc, sourceName, ownerName,null,creationDate,modificationDate);
		return(simSet);
	}
	public static void printAllListsAndMaps(NodeSimSet simSet)	{
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListEntityType().size() = " + simSet.getListEntityType().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListEntity().size() = " + simSet.getListEntity().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getListSimilarity().size() = " + simSet.getListSimilarity().size());
		
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2EntityType().size() = " + simSet.getMapId2EntityType().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2Entity().size() = " + simSet.getMapId2Entity().size());
		System.out.println("MakeFileSet printAllListsAndMaps fileSet.getMapId2Similarity().size() = " + simSet.getMapId2Similarity().size());													
	}
	public static NodeSimSet makeSimSet(NodeF10 f10, String sourceSet)	{
		NodeSimSet simSet = null;
		String simSetName = f10.getCliParams().getSimSetName();
		int cntCreatedEntityType = createSimEntityTypes(f10);
		System.out.println("MakeSimSet makeSimSetFromFileSet cntCreatedEntityType = "+cntCreatedEntityType);
		
		if ("fileSet".equals(sourceSet))	{
			simSet = createOneSimSet(f10.getConnSim(), f10.getFileSet().getFileSetId(),simSetName,f10.getFileSet().getFileSetName());
			f10.setSimSet(simSet);
			System.out.println("MakeSimSet makeSimSetFromFileSet simSet = "+simSet);
			
			ArrayList<NodeFile> fileList4Sim = getFileList4SimFromFileSet(f10,"file");
			Long entityTypeId4File = getEntityTypeIdByName(f10,"file");
			createSimEntitiesFromFileList(f10, entityTypeId4File,fileList4Sim);
			
			ArrayList<NodeFile> dirList4Sim = getFileList4SimFromFileSet(f10,"dir");
			Long entityTypeId4Dir = getEntityTypeIdByName(f10,"dir");
			createSimEntitiesFromFileList(f10, entityTypeId4Dir,dirList4Sim);
			
		} else if ("mediaSet".equals(sourceSet))	{
		} else if ("bookSet".equals(sourceSet))	{
		}
		//ReadTagTablesFromDb.postProcessImageSet(tagSet);
		
		printAllListsAndMaps(simSet);
		
		return(simSet);
	}
	
}
