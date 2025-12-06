package tool10.sql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import tool10.util.FileUtil;


public class JLite {
	public static Connection getConnection(String dbFileName)	{
	    // NOTE: Connection and Statement are AutoCloseable.
	    //       Don't forget to close them both in order to avoid leaks.
		Connection connection = null;
	    try	{  
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:"+dbFileName); //sample.db");
	      executeUpdate(connection,"pragma journal_mode=wal");
	      executeUpdate(connection,"pragma synchronous = normal");
	      executeUpdate(connection,"pragma journal_size_limit = 6144000");
	      
	      System.out.println("connection = " + connection);
	      executeVacuum(connection, dbFileName);
	    } catch(SQLException e)	{
	      // if the error message is "out of memory",
	      // it probably means no database file is found
	      e.printStackTrace(System.err);
	    }
	    return(connection);
	}
	public static int closeConnection(Connection connection)	{
		int cntUpdated = -1;
	    try	{  
	    	connection.close();
	    	System.out.println("connection closed");
	    	return(1);
	    } catch(SQLException e)	{
	      e.printStackTrace(System.err);
	    }
	    return(cntUpdated);
	}
	public static String executeVacuum(Connection connection, String dbFileName)	{
		String msg = "ok";
		System.out.println("Before Vacuum, database file size: "+FileUtil.getFileSize(dbFileName));
		executeUpdate(connection,"VACUUM");
		System.out.println("After  Vacuum, database file size: "+FileUtil.getFileSize(dbFileName));
		return(msg);
	}
	public static String getDatabaseSizeStr(Connection connection)	{
		int cntRead = 0;
		//the SQL is wrong, it must be corrected
		String query = 	
		"SELECT SUM(pgsize) AS \"TotalSize\"  "+
		"FROM (SELECT name, (pgcnt * 4096) AS pgsize FROM ( "+
	    "    SELECT type,name,(pgs * pgsz) AS pgcnt "+
	    "    FROM (SELECT name, ((1 + ((length(sql) + 1) / 1024)) / 1024) AS pgs FROM sqlite_master),  "+
	    "    (SELECT page_count AS pgsz FROM pragma_page_count())) "+
	    "WHERE type='table')";
		
		//public NodeTableUDF(Long tableUDFId, Long basicId, Long displayOrder, String generatedFieldStr,String nonnullFieldStr, ZonedDateTime creationDate) {
		long totalSize = -1;
		try	{  
			PreparedStatement ps = connection.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	totalSize = rs.getLong("TotalSize");
		        cntRead++;
		    }
		    System.out.println("getDatabaseSizeStr: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return("database Total size:"+totalSize);
	}	
	public static int executeUpdate(Connection connection,String cmd)	{
		int cntUpdated = -1;
	    try	{  
	    	Statement statement = connection.createStatement();
	    	statement.setQueryTimeout(30);  // set timeout to 30 sec.

	    	//cmd = "drop table if exists person"
	    	//cmd = "create table person (id integer, name string)");
	    	//cmd = "insert into person values(1, 'leo')";
	        //cmd = "insert into person values(2, 'yui')";
	        
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
	public static long getNextId(Connection connection,String tableName)	{
		long nextId = -1;
	    try	{  
	    	 String sqlStr = "INSERT INTO REG_ENTITYID (tableName) VALUES ('"+tableName+"')";
	    	 //String sqlStr = "INSERT INTO SIM_ENTITYID (tableName) VALUES ('"+tableName+"')";
	    	 
	    	 int cntInserted = executeUpdate(connection,sqlStr);
	    	 
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
	
	
}