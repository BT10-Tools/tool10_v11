package tool10.sql;

import java.sql.Connection;

import tool10.fileset.CreateFileSetTables;

public class TableManager {

	public TableManager(Connection conn,String managerName) {
		super();
		this.conn = conn;
		this.managerName = managerName;
		this.tableList = getTableList(managerName);
	}

	private String managerName;
	private String[] tableList; 
	private Connection conn;
	
	public void checkAllTables()	{
		for (String tblName : tableList)	{
			if (1==SqlUtil.checkTable (conn,tblName)) 	{
				System.out.println(tblName+" table exists");
			} else {
				System.out.println(tblName+" table does not exist");
			}
		}
	}
	public void dropAllTables()	{
		for (String tblName : tableList)	{
			if (1==SqlUtil.dropTable (conn,tblName)) 		{
				System.out.println(tblName+" table dropped");
			} else {
				System.out.println(tblName+" table does not exist");
			}
		}		
	}
	public int deleteAllTables()	{
		int cntUpdated = -1;
		for (String tblName : tableList)	{
			System.out.println(SqlUtil.deleteTable (conn,tblName) + " rows deleted from table "+tblName);
		}		
		return(cntUpdated);
	}
	public int truncateAllTables()	{
		int cntUpdated = -1;
		for (String tblName : tableList)	{
			System.out.println(SqlUtil.deleteTable (conn,tblName) + " rows deleted from table "+tblName);
		}		
		return(cntUpdated);
	}
	public String initializeAllTables()	{
		dropAllTables();
		createAllTables();
		deleteAllTables();
		checkAllTables();
		return("ok");
	}
	public String clearAllTables()	{
		deleteAllTables();
		checkAllTables();
		return("ok");
	}
	public int createAllTables()	{
		int cntUpdated = -1;
		
		for (String tblName : tableList)	{
			if ("fsDb".equals(managerName))			{	CreateFileSetTables.createTable(conn, tblName); } 
		}		
		return(cntUpdated);
	}
	public static final String[] getTableList(String managerName)	{
		String tblList[] = null;
		if ("fsDb".equals(managerName))			{
			tblList = new String[] {"REG_ENTITYID","FS_FILESET","FS_FILESYSTEM","FS_FILESTORE","FS_FILE","FS_FILEBLOB","FS_FILEBLOBSMALL",
									"FS_FILEGROUP","FS_FILEGROUPMEMBER","FS_HASH","FS_HOST","FS_PROPERTY","FS_QUERY","FS_SIMILARITY","FS_STAT",
									"FS_ARCHIVE","FS_CONTAINER", "FS_TRANSFORM"}; }
		return(tblList);
	}

	//******* GETTERS AND SETTERS 
	public String getManagerName() {
		return managerName;
	}
	public String[] getTableList() {
		return tableList;
	}
	
}
