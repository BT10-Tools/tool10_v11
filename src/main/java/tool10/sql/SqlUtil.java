package tool10.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

	public static int executeUpdate(Connection connection,String cmd)	{
		int cntUpdated = -1;
		System.out.println("cmd:"+cmd);
	    try	{  
	    	Statement statement = connection.createStatement();
	    	statement.setQueryTimeout(30);  // set timeout to 30 sec.
	        
	    	cntUpdated = statement.executeUpdate(cmd);
	    	//System.out.println("cntUpdated = " + cntUpdated+"	,cmd='"+cmd+"'");
	    	return(cntUpdated);
	    } catch(SQLException e)	{
	      // if the error message is "out of memory",
	      // it probably means no database file is found
	      e.printStackTrace(System.err);
	    }
	    return(cntUpdated);
	}
	public static int dropTable(Connection conn,String tableName)	{
		String sqlStr = "DROP TABLE IF EXISTS "+tableName;
		int cntUpdated = executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int deleteTable(Connection conn,String tableName)	{
		int cntUpdated = -1;
		String sqlStr="DELETE from "+tableName+" ";
		cntUpdated = SqlUtil.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int checkTable(Connection conn,String tableName)	{
		String sqlStr = "SELECT COUNT(*) CNT FROM (SELECT name FROM sqlite_schema WHERE type='table' AND name='"+tableName+"')";
		int cntRead = -1;
	    try	{  
	    	Statement statement = conn.createStatement();
	    	statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    	
	    	ResultSet rs = statement.executeQuery(sqlStr);
	    	cntRead = 0;
	        while(rs.next())	{
	           // read the result set
	           System.out.println("cnt = " + rs.getInt("CNT"));
	           cntRead++;
	        }
	        System.out.println("cntRead = " + cntRead);
	    	return(cntRead);
	    } catch(SQLException e)	{
	      e.printStackTrace(System.err);
	    }
	    return(cntRead);
	}
	public static int createIndex(Connection conn, String tableName, String fieldName, boolean uniqueness)	{
		String indexName = "IDX_"+tableName+"_"+fieldName;
		String unique = (uniqueness ? "UNIQUE" : "");
		String sqlStr = "CREATE "+unique+" INDEX IF NOT EXISTS "+indexName+" ON "+tableName+ "("+fieldName+")";
		int cntUpdated = executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int createIndex(Connection conn, String tableName, String[] fieldNameArray, boolean uniqueness)	{
		if (fieldNameArray.length<=0) return(-1);
		if (fieldNameArray.length==1) {
			return(createIndex(conn, tableName, fieldNameArray[0], uniqueness));
		}
		String s1="";
		String s2="";
		if 		(fieldNameArray.length==2) { s1 = fieldNameArray[0]+"_"+fieldNameArray[1];	s2 = fieldNameArray[0]+","+fieldNameArray[1]+"_"+fieldNameArray[2];}    
		else if	(fieldNameArray.length==3) { s1 = fieldNameArray[0]+"_"+fieldNameArray[1]+"_"+fieldNameArray[2];	s2 = fieldNameArray[0]+","+fieldNameArray[1]+"_"+fieldNameArray[2];}    
			
		String indexName = "IDX_"+tableName+"_"+s1;
		String unique = (uniqueness ? "UNIQUE" : "");
		String sqlStr = "CREATE "+unique+" INDEX IF NOT EXISTS "+indexName+" ON "+tableName+ "("+s2+")";
		int cntUpdated = executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}

}
