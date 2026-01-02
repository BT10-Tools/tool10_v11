package tool10.simset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class WriteSimSetTablesToDb {

	public static int writeTableEntityType(Connection conn,NodeSimSet simSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO SIM_ENTITYTYPE(entityTypeId,simSetId,entityTypeName,entityTypeDesc,dbName,tableName,fieldName,fieldType,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeEntityType(Long entityTypeId, Long simSetId,String entityTypeName, String entityTypeDesc, String dbName,
		//String tableName, String fieldName, String fieldType, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		//entityTypeId,simSetId,entityTypeName,entityTypeDesc,dbName,tableName,fieldName,fieldType
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeEntityType ent : simSet.getListEntityType())	{
			    int cnt=1;
			    if (ent.getEntityTypeId()!=null) {ps.setLong(cnt++, ent.getEntityTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSimSetId()!=null) {ps.setLong(cnt++, ent.getSimSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEntityTypeName());
			    ps.setString(cnt++, ent.getEntityTypeDesc());
			    ps.setString(cnt++, ent.getDbName());
			    ps.setString(cnt++, ent.getTableName());
			    ps.setString(cnt++, ent.getFieldName());
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableEntityType: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableEntity(Connection conn,NodeSimSet simSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO SIM_ENTITY(entityId,entityTypeId,simSetId,sourceId,valueStr,valueLong,valueDouble,valueBLOB,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?)";
		//public NodeEntity(Long entityId, Long entityTypeId, Long simSetId, Long sourceId, String valueStr, Long valueLong,
		//Double valueDouble, byte[] valueBLOB, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeEntity ent : simSet.getListEntity())	{
			    int cnt=1;
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityTypeId()!=null) {ps.setLong(cnt++, ent.getEntityTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSimSetId()!=null) {ps.setLong(cnt++, ent.getSimSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getValueStr());
			    if (ent.getValueLong()!=null) {ps.setLong(cnt++, ent.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDouble()!=null) {ps.setDouble(cnt++, ent.getValueDouble());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getValueBLOB()!=null) {ps.setBytes(cnt++, ent.getValueBLOB());} else {ps.setNull(cnt++,Types.BLOB);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableEntity: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableSimilarity(Connection conn,NodeSimSet simSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO SIM_SIMILARITY(similarityId,simSetId,entityId1,entityId2,similarityType,similarityKey,\r\n"
				+ "		sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,sim10,sim11,sim12,sim13,\r\n"
				+ "		sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,\r\n"
				+ "		alg08,alg09,alg10,alg11,alg12,alg13,alg14,\r\n"
				+ "		alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  "+
				                "?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  ?, ?, ?)";
		////public NodeSimilarity(Long similarityId, Long simSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
		//Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
		//Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
		//Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
		//String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
		//String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
		//String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
		//ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSimilarity ent : simSet.getListSimilarity())	{
			    int cnt=1;
			    if (ent.getSimilarityId()!=null) {ps.setLong(cnt++, ent.getSimilarityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSimSetId()!=null) {ps.setLong(cnt++, ent.getSimSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId1()!=null) {ps.setLong(cnt++, ent.getEntityId1());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId2()!=null) {ps.setLong(cnt++, ent.getEntityId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSimilarityType());
			    ps.setString(cnt++, ent.getSimilarityKey());
			    if (ent.getSim00()!=null) {ps.setDouble(cnt++, ent.getSim00());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim01()!=null) {ps.setDouble(cnt++, ent.getSim01());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim02()!=null) {ps.setDouble(cnt++, ent.getSim02());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim03()!=null) {ps.setDouble(cnt++, ent.getSim03());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim04()!=null) {ps.setDouble(cnt++, ent.getSim04());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim05()!=null) {ps.setDouble(cnt++, ent.getSim05());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim06()!=null) {ps.setDouble(cnt++, ent.getSim06());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim07()!=null) {ps.setDouble(cnt++, ent.getSim07());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim08()!=null) {ps.setDouble(cnt++, ent.getSim08());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim09()!=null) {ps.setDouble(cnt++, ent.getSim09());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim10()!=null) {ps.setDouble(cnt++, ent.getSim10());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim11()!=null) {ps.setDouble(cnt++, ent.getSim11());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim12()!=null) {ps.setDouble(cnt++, ent.getSim12());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim13()!=null) {ps.setDouble(cnt++, ent.getSim13());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim14()!=null) {ps.setDouble(cnt++, ent.getSim14());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim15()!=null) {ps.setDouble(cnt++, ent.getSim15());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim16()!=null) {ps.setDouble(cnt++, ent.getSim16());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim17()!=null) {ps.setDouble(cnt++, ent.getSim17());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim18()!=null) {ps.setDouble(cnt++, ent.getSim18());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim19()!=null) {ps.setDouble(cnt++, ent.getSim19());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    ps.setString(cnt++, ent.getAlg00());
			    ps.setString(cnt++, ent.getAlg01());
			    ps.setString(cnt++, ent.getAlg02());
			    ps.setString(cnt++, ent.getAlg03());
			    ps.setString(cnt++, ent.getAlg04());
			    ps.setString(cnt++, ent.getAlg05());
			    ps.setString(cnt++, ent.getAlg06());
			    ps.setString(cnt++, ent.getAlg07());
			    ps.setString(cnt++, ent.getAlg08());
			    ps.setString(cnt++, ent.getAlg09());
			    ps.setString(cnt++, ent.getAlg10());
			    ps.setString(cnt++, ent.getAlg11());
			    ps.setString(cnt++, ent.getAlg12());
			    ps.setString(cnt++, ent.getAlg13());
			    ps.setString(cnt++, ent.getAlg14());
			    ps.setString(cnt++, ent.getAlg15());
			    ps.setString(cnt++, ent.getAlg16());
			    ps.setString(cnt++, ent.getAlg17());
			    ps.setString(cnt++, ent.getAlg18());
			    ps.setString(cnt++, ent.getAlg19());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableSimilarity: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}

	public static int writeTableSimSet(Connection conn,NodeSimSet simSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO SIM_SIMSET (simSetId,sourceId,simSetName,simSetDesc,ownerName,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?)";
		//String fieldStr = "simSetId INTEGER,sourceId INTEGER,simSetName TEXT,simSetDesc TEXT,ownerName TEXT, creationDate TEXT, modificationDate TEXT";
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (simSet.getSimSetId()!=null) {ps.setLong(cnt++, simSet.getSimSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    if (simSet.getSourceId()!=null) {ps.setLong(cnt++, simSet.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    ps.setString(cnt++, simSet.getSimSetName());
		    ps.setString(cnt++, simSet.getSimSetDesc());
		    ps.setString(cnt++, simSet.getOwnerName());
		    if (simSet.getCreationDate()!=null) 	{ps.setString(cnt++, simSet.getCreationDate().toString()); } 		else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (simSet.getModificationDate()!=null) {ps.setString(cnt++, simSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableSimSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeSimSet(Connection conn,  NodeSimSet simSet)	{
		
		int cntInsertedSimSet = writeTableSimSet(conn,simSet);
		int cntInsertedEntityType = writeTableEntityType(conn,simSet);
		int cntInsertedEntity = writeTableEntity(conn,simSet);
		int cntInsertedSimilarity = writeTableSimilarity(conn,simSet); 
		int cntInserted = cntInsertedSimSet + cntInsertedEntityType + cntInsertedEntity + cntInsertedSimilarity ; 
		return(cntInserted);
	}	
	public static int writeSimilarity(Connection conn,  NodeSimSet simSet)	{
		int ctInsertedSimilarity = writeTableSimilarity(conn,simSet); 
		int cntInserted = ctInsertedSimilarity;
		return(cntInserted);
	}	
	public static void writeSimSetTables(Connection conn, NodeSimSet simSet)	{
		writeSimSet(conn,simSet);
	}
	
}