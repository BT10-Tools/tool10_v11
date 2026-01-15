package tool10.sql;

import tool10.blobset.CreateBlobSetTables;
import tool10.docset.CreateDocSetTables;
import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.mediaset.CreateMediaSetTables;

public class DbManager {

	public static Conn10 createBlobDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getBlobDbName();
		String connectionName = "blobDb";
		String dbType = f10.getCliParams().getBlobDbType();
		Conn10 connBlob = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			System.out.println("DbManager createBlobDatabase dbFileName:"+dbFileName+" ,f10.getConn10().getDbFileName():"+f10.getConn10().getDbFileName());	
			connBlob = new Conn10(connectionName, f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			System.out.println("DbManager createBlobDatabase dbFileName:"+dbFileName+" ,dbType"+dbType);	
			connBlob = new Conn10(connectionName, dbType, dbFileName);
		}
		//connBlob = f10.getConn10();
		if (connBlob==null)	{
			System.out.println("DbManager createBlobDatabase connBlob is null");	
			return(null);
		}
		f10.setConnBlob(connBlob);	
		CreateBlobSetTables.createBlobSetTables(connBlob);
		System.out.println("DbManager createBlobDatabase connBlob:"+connBlob);
		System.out.println("DbManager createBlobDatabase f10.getConn10():"+f10.getConn10());
		return(connBlob);
	}
	public static Conn10 createDocDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getDocDbName();
		String connectionName = "docDb";
		String dbType = f10.getCliParams().getDocDbType();
		Conn10 connDoc = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			System.out.println("DbManager createDocDatabase dbFileName:"+dbFileName+" ,f10.getConn10().getDbFileName():"+f10.getConn10().getDbFileName());	
			connDoc = new Conn10(connectionName, f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			System.out.println("DbManager createDocDatabase dbFileName:"+dbFileName+" ,dbType"+dbType);	
			connDoc = new Conn10(connectionName, dbType, dbFileName);
		}
		//connBook = f10.getConn10();
		if (connDoc==null)	{
			System.out.println("DbManager createDocDatabase connDoc is null");	
			return(null);
		}
		f10.setConnDoc(connDoc);	
		CreateDocSetTables.createDocSetTables(connDoc);
		System.out.println("DbManager createDocDatabase connDoc:"+connDoc);
		System.out.println("DbManager createDocDatabase f10.getConn10():"+f10.getConn10());
		return(connDoc);
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
		CreateMediaSetTables.createMediaSetTables(connMedia);
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
