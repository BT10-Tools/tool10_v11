package tool10.sql;

import tool10.bookset.CreateBookSetTables;
import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;

public class DbManager {

	public static Conn10 createBookDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getBookDbName();
		String connectionName = "bookDb";
		String dbType = f10.getCliParams().getBookDbType();
		Conn10 connBook = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			System.out.println("RunBook createBookDatabase dbFileName:"+dbFileName+" ,f10.getConn10().getDbFileName():"+f10.getConn10().getDbFileName());	
			connBook = new Conn10(connectionName, f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			System.out.println("RunBook createBookDatabase dbFileName:"+dbFileName+" ,dbType"+dbType);	
			connBook = new Conn10(connectionName, dbType, dbFileName);
		}
		//connBook = f10.getConn10();
		if (connBook==null)	{
			System.out.println("RunBook createBookDatabase connBook is null");	
			return(null);
		}
		f10.setConnBook(connBook);	
		CreateBookSetTables.createBookSetTables(connBook);
		System.out.println("RunBook createBookDatabase connBook:"+connBook);
		System.out.println("RunBook createBookDatabase f10.getConn10():"+f10.getConn10());
		return(connBook);
	}
	public static void createMediaDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getMediaDbName();
		String connectionName = "mediaDb";
		String dbType = f10.getCliParams().getMediaDbType();
		Conn10 connMedia = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			connMedia = new Conn10(connectionName, f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			connMedia = new Conn10(connectionName, dbType, dbFileName);
		}
		f10.setConnMedia(connMedia);	
		CreateFileSetTables.createFileSetTables(connMedia);
	}
	
	public static void createTagDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getTagDbName();
		String connectionName = "tagDb";
		String dbType = f10.getCliParams().getTagDbType();
		Conn10 connTagDb = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			connTagDb = new Conn10(f10.getConn10().getConnectionName(), f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			connTagDb = new Conn10(connectionName, dbType, dbFileName);
		}
		f10.setConnTag(connTagDb);	
		CreateFileSetTables.createFileSetTables(connTagDb);
	}
}
