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
	public static void createIndexes(Connection conn)	{
		SqlUtil.createIndex(conn, "FS_FILEBLOB", "fileId", false);
		SqlUtil.createIndex(conn, "FS_FILEGROUPMEMBER", "fileId", false);
		SqlUtil.createIndex(conn, "FS_STAT", "entityId", true);
	}
	public static int createFileSetTables(Conn10 conn10)	{
		int cntUpdated = -1;
		String[] tblList = conn10.getTableManager().getTableList();
		
		for (String tblName : tblList)	{
			if (1==createTable (conn10.getConn(),tblName)) 	{
				//System.out.println(tblName+" table created");
			}
		}		
		createIndexes(conn10.getConn());
		return(cntUpdated);
	}
	
}