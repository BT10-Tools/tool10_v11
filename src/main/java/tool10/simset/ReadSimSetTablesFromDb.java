package tool10.simset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ReadSimSetTablesFromDb {

	public static int readTableEntityType(Connection conn, NodeSimSet simSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT entityTypeId,simSetId,entityTypeName,entityTypeDesc,dbName,tableName,fieldName,fieldType,creationDate,modificationDate"+
			 " FROM SIM_ENTITYTYPE WHERE simSetId = ? ORDER BY entityTypeId"; 
		//public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
		//String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) 
		//entityTypeId,simSetId,entityTypeName,entityTypeDesc,dbName,tableName,fieldName,fieldType
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, simSet.getSimSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long entityTypeId = rs.getLong("entityTypeId");	if (rs.wasNull()) {entityTypeId = null;}
				Long simSetId = rs.getLong("simSetId");	if (rs.wasNull()) {simSetId = null;}
				String entityTypeName = rs.getString("entityTypeName");
				String entityTypeDesc = rs.getString("entityTypeDesc");
				String dbName = rs.getString("dbName");
				String tableName = rs.getString("tableName");
				String fieldName = rs.getString("fieldName");
				String fieldType = rs.getString("fieldType");
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeEntityType newEntityType = new NodeEntityType(
						entityTypeId,simSetId,entityTypeName,entityTypeDesc,dbName,tableName,fieldName,fieldType,creationDate,modificationDate);
				simSet.getListEntityType().add(newEntityType); 
				simSet.getMapId2EntityType().put(newEntityType.getEntityTypeId(),newEntityType); 
				cntRead++; 
			}
			System.out.println("readTableEntityType: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableEntity(Connection conn, NodeSimSet simSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT entityId,entityTypeId,simSetId,sourceId,valueStr,valueLong,valueDouble,valueBLOB,creationDate,modificationDate"+
			 " FROM SIM_ENTITY WHERE simSetId = ? ORDER BY entityId"; 
		//public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
		//Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) { 
		//entityId,entityTypeId,simSetId,sourceId,valueStr,valueLong,valueDouble,valueBLOB,
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, simSet.getSimSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long entityId = rs.getLong("entityId");	if (rs.wasNull()) {entityId = null;}
				Long entityTypeId = rs.getLong("entityTypeId");	if (rs.wasNull()) {entityTypeId = null;}
				Long simSetId = rs.getLong("simSetId");	if (rs.wasNull()) {simSetId = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				String valueStr = rs.getString("valueStr");
				Long valueLong = rs.getLong("valueLong");	if (rs.wasNull()) {valueLong = null;}
				Double valueDouble = rs.getDouble("valueDouble");	if (rs.wasNull()) {valueDouble = null;}
				byte[] valueBLOB = rs.getBytes("valueBLOB");	if (rs.wasNull()) {valueBLOB = null;}
				
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeEntity newEntity = new NodeEntity(entityId,entityTypeId,simSetId,sourceId,valueStr,valueLong,valueDouble,valueBLOB,creationDate,modificationDate);
				simSet.getListEntity().add(newEntity); 
				simSet.getMapId2Entity().put(newEntity.getEntityId(),newEntity); 
				cntRead++; 
			}
			System.out.println("readTableEntity: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static int readTableSimilarity(Connection conn, NodeSimSet simSet)	{ 
		int cntRead = 0; 
		String query = 	" SELECT "+
				"similarityId,simSetId,entityId1,entityId2,similarityType,similarityKey,sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,"+
				" sim10,sim11,sim12,sim13,sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,alg08,alg09,alg10,"+
				" alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate"+
			 " FROM SIM_SIMILARITY WHERE simSetId = ? ORDER BY similarityId"; 
		//public NodeSimilarity(Long similarityId, Long simSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
		//Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
		//Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
		//Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
		//String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
		//String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
		//String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
		//ZonedDateTime modificationDate) {

		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, simSet.getSimSetId());
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) { 
				Long similarityId = rs.getLong("similarityId");	if (rs.wasNull()) {similarityId = null;}
				Long simSetId = rs.getLong("simSetId");	if (rs.wasNull()) {simSetId = null;}
				Long entityId1 = rs.getLong("entityId1");	if (rs.wasNull()) {entityId1 = null;}
				Long entityId2 = rs.getLong("entityId2");	if (rs.wasNull()) {entityId2 = null;}
				String similarityType = rs.getString("similarityType");
				String similarityKey = rs.getString("similarityKey");
				Double sim00 = rs.getDouble("sim00");	if (rs.wasNull()) {sim00 = null;}
				Double sim01 = rs.getDouble("sim01");	if (rs.wasNull()) {sim01 = null;}
				Double sim02 = rs.getDouble("sim02");	if (rs.wasNull()) {sim02 = null;}
				Double sim03 = rs.getDouble("sim03");	if (rs.wasNull()) {sim03 = null;}
				Double sim04 = rs.getDouble("sim04");	if (rs.wasNull()) {sim04 = null;}
				Double sim05 = rs.getDouble("sim05");	if (rs.wasNull()) {sim05 = null;}
				Double sim06 = rs.getDouble("sim06");	if (rs.wasNull()) {sim06 = null;}
				Double sim07 = rs.getDouble("sim07");	if (rs.wasNull()) {sim07 = null;}
				Double sim08 = rs.getDouble("sim08");	if (rs.wasNull()) {sim08 = null;}
				Double sim09 = rs.getDouble("sim09");	if (rs.wasNull()) {sim09 = null;}
				Double sim10 = rs.getDouble("sim10");	if (rs.wasNull()) {sim10 = null;}
				Double sim11 = rs.getDouble("sim11");	if (rs.wasNull()) {sim11 = null;}
				Double sim12 = rs.getDouble("sim12");	if (rs.wasNull()) {sim12 = null;}
				Double sim13 = rs.getDouble("sim13");	if (rs.wasNull()) {sim13 = null;}
				Double sim14 = rs.getDouble("sim14");	if (rs.wasNull()) {sim14 = null;}
				Double sim15 = rs.getDouble("sim15");	if (rs.wasNull()) {sim15 = null;}
				Double sim16 = rs.getDouble("sim16");	if (rs.wasNull()) {sim16 = null;}
				Double sim17 = rs.getDouble("sim17");	if (rs.wasNull()) {sim17 = null;}
				Double sim18 = rs.getDouble("sim18");	if (rs.wasNull()) {sim18 = null;}
				Double sim19 = rs.getDouble("sim19");	if (rs.wasNull()) {sim19 = null;}
				String alg00 = rs.getString("alg00");
				String alg01 = rs.getString("alg01");
				String alg02 = rs.getString("alg02");
				String alg03 = rs.getString("alg03");
				String alg04 = rs.getString("alg04");
				String alg05 = rs.getString("alg05");
				String alg06 = rs.getString("alg06");
				String alg07 = rs.getString("alg07");
				String alg08 = rs.getString("alg08");
				String alg09 = rs.getString("alg09");
				String alg10 = rs.getString("alg10");
				String alg11 = rs.getString("alg11");
				String alg12 = rs.getString("alg12");
				String alg13 = rs.getString("alg13");
				String alg14 = rs.getString("alg14");
				String alg15 = rs.getString("alg15");
				String alg16 = rs.getString("alg16");
				String alg17 = rs.getString("alg17");
				String alg18 = rs.getString("alg18");
				String alg19 = rs.getString("alg19");
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null); 
				NodeSimilarity newSimilarity = new NodeSimilarity(
						similarityId,simSetId,entityId1,entityId2,similarityType,similarityKey,sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,
						sim10,sim11,sim12,sim13,sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,alg08,alg09,alg10,
						alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate);
				simSet.getListSimilarity().add(newSimilarity); 
				simSet.getMapId2Similarity().put(newSimilarity.getSimilarityId(),newSimilarity); 
				cntRead++; 
			}
			System.out.println("readTableSimilarity: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(cntRead); 
	} 
	public static NodeSimSet readTableSimSet(Connection conn, long simSetId)	{ 
		int cntRead = 0; 
		NodeSimSet newSimSet = null;
		String query = 	" SELECT simSetId,sourceId,simSetName,simSetDesc,sourceName,ownerName,displayOrder,creationDate,modificationDate"+
				" FROM SIM_SIMSET WHERE simSetId = ? ORDER BY simSetId"; 
		//public NodeSimSet(Long simSetId, Long sourceId, String simSetName, String simSetDesc, String sourceName, String ownerName,
		//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, simSetId);
			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) { 
				Long simSetId2 = rs.getLong("simSetId");	if (rs.wasNull()) {simSetId2 = null;}
				Long sourceId = rs.getLong("sourceId");	if (rs.wasNull()) {sourceId = null;}
				String simSetName = rs.getString("simSetName");
				String simSetDesc = rs.getString("simSetDesc");
				String sourceName = rs.getString("sourceName");
				String ownerName = rs.getString("ownerName");
				Long displayOrder = rs.getLong("displayOrder");	if (rs.wasNull()) {displayOrder = null;}
				String creationDateStr = rs.getString("creationDate");
				ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null); 
				String modificationDateStr = rs.getString("modificationDate");
				ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);
				
				newSimSet = new NodeSimSet(simSetId,sourceId,simSetName,simSetDesc,sourceName,ownerName,displayOrder,creationDate,modificationDate);
				cntRead++; 
			}
			System.out.println("readTableSimSet: cntRead = " + cntRead); 
			rs.close(); 
			ps.close(); 
		} catch(SQLException e)	{ 
			e.printStackTrace(System.err); 
		} 
		return(newSimSet); 
	} 
	//*****************************
	public static NodeSimSet readSimSet(Connection conn, long simSetId) {
		NodeSimSet simSet = readTableSimSet(conn, simSetId);
		if (simSet==null) return (null);
		int cntReadEntityType = readTableEntityType(conn,simSet);
		int cntReadEntity = readTableEntity(conn,simSet);
		int cntReadSimilarity = readTableSimilarity(conn,simSet);
				
		postProcessSimSet(simSet);
		
		int cntRead = cntReadEntityType + cntReadEntity + cntReadSimilarity + 1;
	    System.out.println("readSimSet: total record read = " + cntRead);
		return(simSet);
	}	
	private static void postProcessSimSet(NodeSimSet simSet)	{
		//GetByMapSimSet.updateAllMapsSimSet(simSet);
	}
	public static NodeSimSet readSimSetTables(Connection conn, long simSetId)	{ 

		NodeSimSet simSet = readSimSet(conn,simSetId); 
		if (simSet!=null)	{ 
			//MakeSimSet.printAllListsAndMaps(simSet); 
		} else { 
			System.out.println("readSimSetTables: simSet is null"); 
		}	
		return (simSet); 
	}
	
}