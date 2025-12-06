package test10.fileset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tool10.sql.JLite;

public class JLiteTest {

/*	public static FileWriter xxxgetFileWriter(String fileName)	{
		try {
			FileWriter fw = new FileWriter(fileName); //"ABC.txt");
			return(fw);
		} catch(Exception e)	{
			e.printStackTrace(System.err);
		} 	
		return(null);
	}
	public static BufferedWriter xxxgetBufferedWriter(FileWriter fw)	{
		try {
			BufferedWriter bw = new BufferedWriter(fw); 
			return(bw);
		} catch(Exception e)	{
			e.printStackTrace(System.err);
		} 	
		return(null);
	}
	public static void xxxcloseFileWriter(FileWriter fw)	{
		try {
			fw.close();
		} catch(Exception e)	{
			e.printStackTrace(System.err);
		} 	
	}
	public static void xxxcloseBufferedWriter(BufferedWriter bw)	{
		try {
			bw.close();
		} catch(Exception e)	{
			e.printStackTrace(System.err);
		} 	
	}
	public static String zzgetNowStr()	{
		//yyyy-MM-dd HH:mm:ss.SSS
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS"; //"yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateStr = simpleDateFormat.format(new Date());
		return(dateStr);
	}
*/
	public static int executeRead(Connection connection,String cmd)	{
		int cntRead = -1;
	    try	{  
	    	Statement statement = connection.createStatement();
	    	statement.setQueryTimeout(30);  // set timeout to 30 sec.
	    	
	    	 ResultSet rs = statement.executeQuery("select * from person");
	    	 cntRead = 0;
	         while(rs.next())	{
	           // read the result set
	           System.out.println("name = " + rs.getString("name"));
	           System.out.println("id = " + rs.getInt("id"));
	           cntRead++;
	         }
	         System.out.println("cntRead = " + cntRead);
	    	return(cntRead);
	    } catch(SQLException e)	{
	      e.printStackTrace(System.err);
	    }
	    return(cntRead);
	}
	public static int deleteComputeTable(Connection conn,String tableName)	{
		int cntUpdated = -1;
		String sqlStr="DELETE from "+tableName+" ";
		cntUpdated = JLite.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int createComputeTable(Connection conn,String tableName)	{
		int cntUpdated = -1;
		//INTEGER, TEXT, REAL, BLOB
		String fieldStr = "I TEXT, J TEXT, POWIJ TEXT, K TEXT, M TEXT, POWKM TEXT, DIFF TEXT, CREATEDT TEXT";
		String sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr+") ";
		cntUpdated = JLite.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int insertIntoComputeTable(Connection conn,String tableName, 
			String i, String j, String powIJ, String k, String m, String powKM, String diff, String createDt)	{
		int cntUpdated = -1;
		String valueStr = "'"+i+"','"+j+"','"+powIJ+"','"+k+"','"+m+"','"+powKM+"','"+diff+"','"+createDt+"'";
		String sqlStr="INSERT INTO "+tableName+" VALUES ("+valueStr+")";
		//System.out.println("sqlStr = " + sqlStr);
		cntUpdated = JLite.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static int exportComputeTable(Connection conn,String tableName, BufferedWriter bw)	{
		int cntRead = -1;
	    try	{  
	    	Statement statement = conn.createStatement();
	    	//String fieldStr = "I TEXT, J TEXT, POWIJ TEXT, K TEXT, M TEXT, POWKM TEXT, DIFF TEXT, CREATEDT TEXT";
	    	String fieldStr = "I, J, POWIJ, K, M, POWKM, DIFF, CREATEDT";
	    	
	    	 ResultSet rs = statement.executeQuery("select "+fieldStr+" from "+tableName+" order by i,j,k,m");
	    	 cntRead = 0;
	         while(rs.next())	{
	        	 // read the result set
	        	 String ss = rs.getString("I")+","+rs.getString("J")+","+rs.getString("POWIJ")+","+
	        			 rs.getString("K")+","+rs.getString("M")+","+rs.getString("POWKM")+","+
	        			 rs.getString("DIFF")+","+rs.getString("CREATEDT")+",";
	        	 bw.append(ss+"\n");
	        	 cntRead++;
	         }
	         System.out.println("cntRead = " + cntRead);
	    	return(cntRead);
	    } catch(IOException e)	{
		      e.printStackTrace(System.err);
		} catch(SQLException e)	{
	      e.printStackTrace(System.err);
	    }
	    return(cntRead);
	}
	public static void main(String[] args)	{
		 //String dbFileName = "sampleDb";
		 //String dbFileName = "C:\\app\\sqlite\\SampleDb\\chinook.db";
		 String dbFileName = "C:\\app\\sqlite\\SampleDb\\chinook2.db";
		 Connection conn = JLite.getConnection(dbFileName);
		 String tableName = "compute01";
		 //createComputeTable(conn,tableName);
		 for (int i=0; i<1000; i++)	{
			 insertIntoComputeTable(conn,tableName,"i", "j", "powij","k","m","powKM","diff","createDt");
		 }
		//	 FileWriter fw = getFileWriter("C:\\app\\sqlite\\SampleDb\\"+tableName+".csv");
		//	 BufferedWriter bw = getBufferedWriter (fw);
		//	 exportComputeTable(conn,tableName,bw);
		//	 closeBufferedWriter(bw);
		//	 closeFileWriter(fw);
		//	 closeConnection(conn); 
	 }
	public static void main3(String[] args)
	{
	    // NOTE: Connection and Statement are AutoCloseable.
	    //       Don't forget to close them both in order to avoid leaks.
	    try
	    (
	      // create a database connection
	      Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
	      Statement statement = connection.createStatement();
	    )
	    {
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.
	
	      statement.executeUpdate("drop table if exists person");
	      statement.executeUpdate("create table person (id integer, name string)");
	      statement.executeUpdate("insert into person values(1, 'leo')");
	      statement.executeUpdate("insert into person values(2, 'yui')");
	      ResultSet rs = statement.executeQuery("select * from person");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("name = " + rs.getString("name"));
	        System.out.println("id = " + rs.getInt("id"));
	      }
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory",
	      // it probably means no database file is found
	      e.printStackTrace(System.err);
	    }
  }
}