package tool10.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NextIdGenerator {
	
	public NextIdGenerator(String nextIdGeneratorName, Connection conn) {
		super();
		this.nextIdGeneratorName = nextIdGeneratorName;
		this.conn = conn;
		createEntityIdTableIfNotExists(conn);
		createNewIdList();
	}
	private String nextIdGeneratorName;
	private Connection conn;
	private static final int LISTSIZE = 100000; 
	private long[] idList;
	private long[] tableIdList;
	private int idx;
	private long idBase;
	
	public synchronized long getNextId(long tableId)	{
		if (idx>=LISTSIZE)	{
			writeIdList();
			createNewIdList();
		}
		long id = idList[this.idx];
		this.tableIdList[idx] = tableId;
		idx++;
		return(id);
	}
	private void createNewIdList()	{
		this.idBase = LISTSIZE * getNextIdBase(conn,"any");
		idList = new long[LISTSIZE];
		this.tableIdList = new long[LISTSIZE];
		for (int i=0; i<idList.length; i++)	{
			idList[i] = idBase + i;
			tableIdList[i] = -1;
		}
		this.idx = 0;
	}
	private void writeIdList()	{
		//yeni id listesinin veritabanına yazım işini yapar
	}
	private static synchronized long getNextIdBase(Connection connection,String tableName)	{
		long nextId = -1;
	    try	{  
	    	 String sqlStr = "INSERT INTO REG_ENTITYID (tableName) VALUES ('"+tableName+"')";
	    	 //String sqlStr = "INSERT INTO SIM_ENTITYID (tableName) VALUES ('"+tableName+"')";
	    	 
	    	 int cntInserted = SqlUtil.executeUpdate(connection,sqlStr);
	    	 
	    	 if (cntInserted<=0) return(-1);
	    	 
	    	 Statement statement = connection.createStatement();
	    	 statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    	
	    	 ResultSet rs = statement.executeQuery("select last_insert_rowid() AS ENTITYID");
	         if (rs.next())	{
	        	 nextId = rs.getLong("ENTITYID");
	        	 //System.out.println("nextId = " + nextId);
	        	 return(nextId);
	         } else {
	        	 System.out.println("nextId could not be read nextId:" + nextId);
	        	 return(-1);
	         }
	    } catch(SQLException e)	{
	      e.printStackTrace(System.err);
	    }
	    return(nextId);
	}
	private static void createEntityIdTableIfNotExists(Connection conn)	{
		String sqlStr="CREATE TABLE IF NOT EXISTS REG_ENTITYID (EntityId INTEGER PRIMARY KEY AUTOINCREMENT, tableName TEXT) ";
		SqlUtil.executeUpdate(conn, sqlStr);
	}	
	public String getNextIdGeneratorName() {
		return nextIdGeneratorName;
	}
	
}
