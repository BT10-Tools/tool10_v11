package tool10.fileset;

import java.sql.Connection;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateFileSetTables {
	
	public static int createTable(Connection conn,String tableName)	{
		String sqlStr = CreateFileSetTableSql.getCreateTableSqlStr(conn,tableName);
		if (sqlStr==null) return(-1);
		int cntUpdated = SqlUtil.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static void createFileSetIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "FS_FILEBLOB", "fileId", false);
		SqlUtil.createIndex(conn, "FS_FILEGROUPMEMBER", "fileId", false);
		SqlUtil.createIndex(conn, "FS_STAT", "entityId", true);
	}
	public static void createBlobIndexes(Connection conn)	{
		///SqlUtil.createIndex(conn, "FS_FILEBLOB", "fileId", false);
	}
	public static void createIndexes(Conn10 conn10)	{
		if ("fsDb".equals(conn10.getTableManager().getManagerName()))	{
			createFileSetIndexes(conn10.getConn());
		} else if ("blobDb".equals(conn10.getTableManager().getManagerName()))	{
			createBlobIndexes(conn10.getConn());
		}	
	}
	public static int createFileSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		if (tblList==null)	{	System.out.println("CreateFileSetTables createFileSetTables tblList is null"); return(-1);}
		if (tblList.length==0)	{	System.out.println("CreateFileSetTables createFileSetTables tblList is empty"); return(-1);}
		
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createIndexes(conn10);
		return(1); //cntUpdated);
	}
	
}