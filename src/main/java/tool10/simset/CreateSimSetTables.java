package tool10.simset;

import java.sql.Connection;

import tool10.fileset.CreateFileSetTableSql;
import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateSimSetTables {
	
	public static int createTable(Connection conn,String tableName)	{
		String sqlStr = CreateFileSetTableSql.getCreateTableSqlStr(conn,tableName);
		if (sqlStr==null) return(-1);
		int cntUpdated = SqlUtil.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static void createSimSetIndexes(Connection conn)	{
		//SqlUtil.createIndex(conn, "FS_FILEBLOB", "fileId", false);	
	}
	public static void createIndexes(Conn10 conn10)	{
		if ("simDb".equals(conn10.getTableManager().getManagerName()))	{
			createSimSetIndexes(conn10.getConn());
		} 
	}
	public static int createSimSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		if (tblList==null)		{	System.out.println("CreateSimSetTables createSimSetTables tblList is null"); return(-1);}
		if (tblList.length==0)	{	System.out.println("CreateSimSetTables createSimSetTables tblList is empty"); return(-1);}
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createIndexes(conn10);
		return(1); //cntUpdated);
	}
	
}