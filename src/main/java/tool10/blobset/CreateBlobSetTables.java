package tool10.blobset;

import java.sql.Connection;

import tool10.sql.Conn10;
import tool10.sql.SqlUtil;

public class CreateBlobSetTables {
	
	public static int createTable(Connection conn,String tableName)	{
		String sqlStr = CreateBlobSetTableSql.getCreateTableSqlStr(conn,tableName);
		if (sqlStr==null) return(-1);
		int cntUpdated = SqlUtil.executeUpdate(conn,sqlStr);
		return(cntUpdated);
	}
	public static void createBlobIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "BLOB_BLOBENTITY", "sourceId", false);
		SqlUtil.createIndex(conn, "BLOB_BLOBENTITY", "blobId", false);
		SqlUtil.createIndex(conn, "BLOB_BLOBHASH", "blobId", false);
		SqlUtil.createIndex(conn, "BLOB_BLOBHASH", "blobEntityId", false);
	}
	public static void createIndexes(Conn10 conn10)	{
		if ("blobDb".equals(conn10.getTableManager().getManagerName()))	{
			createBlobIndexes(conn10.getConn());
		}	
	}
	public static int createBlobSetTables(Conn10 conn10)	{
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