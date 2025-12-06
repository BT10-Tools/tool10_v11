package tool10.sql;

import java.sql.Connection;

public class Conn10 {

	public Conn10(String connectionName, String dbType, String dbFileName) {
		super();
		this.connectionName = connectionName;
		this.dbType = dbType; //sqlite
		this.dbFileName = dbFileName;
		this.readOnly = "no";
		this.inMemory = "no";
		initialize();
	}
	public Conn10(String connectionName, String dbType, String dbFileName, String readOnly, String inMemory) {
		super();
		this.connectionName = connectionName;
		this.dbType = dbType;
		this.dbFileName = dbFileName;
		this.readOnly = readOnly;
		this.inMemory = inMemory;
		initialize();
	}
	private void initialize()	{
		createConnection();
		this.nextIdGenerator = new NextIdGenerator("any", this.conn);
		this.tableManager = new TableManager(this.conn,connectionName);
	}

	private String connectionName;
	private String dbType;
	private String dbFileName;  //file based db's like sqlite, "C:\\app\\sqlite\\similarity\\stringSimilarityCache01.db";
	private String readOnly;
	private String inMemory;
	
	private Connection conn;
	private NextIdGenerator nextIdGenerator;
	private TableManager tableManager;
	
	private void createConnection()	{
		//String dbFileName = "C:\\app\\sqlite\\similarity\\stringSimilarityCache01.db";
		this.conn = JLite.getConnection(dbFileName);
	}
	public void closeConnection()	{
		JLite.closeConnection(conn);
	}
	public long getNextId(long tableId)	{
		return(nextIdGenerator.getNextId(tableId));
	}
	public long getNextId(String tableName)	{
		long tableId = getTableIdFromName(tableName); 
		return(nextIdGenerator.getNextId(tableId));
	}
	public long getTableIdFromName(String tableName)	{
		long tableId = -1; //there will be cash mechanism from tableName to the table ID
		return(tableId);
	}
 	
 	//********** getters and setters
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public NextIdGenerator getNextIdGenerator() {
		return nextIdGenerator;
	}
	public TableManager getTableManager() {
		return tableManager;
	}
	public String getDbFileName() {
		return dbFileName;
	}
	public String getReadOnly() {
		return readOnly;
	}
	public String getInMemory() {
		return inMemory;
	}	
	
}
