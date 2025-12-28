package tool10.fileset.blob;


import java.sql.Connection;

import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.sql.Conn10;
import tool10.sql.JLite;
import tool10.util.StrUtil;

public class MakeFileSetBlobDatabase {
	
	public static void createAttachment(NodeF10 f10, Connection connection)	{
		String attachmentName = "";
		String dbFileName = "";
		JLite.createAttachment(connection, attachmentName, dbFileName); //Connection connection, String attachmentName, String dbFileName)
	}
	public static boolean checkBlobDbSizeThreshold(NodeF10 f10)	{
		if (f10.getConnBlob().getBlobSizeToWrite() <= f10.getConnBlob().getBlobDbSize()) return(false);
		createBlobDatabaseNext(f10);
		return(true);
	}
	private static void createBlobDatabase(NodeF10 f10, String dbFileName )	{
		String connectionName = "blobDb";
		String dbType = f10.getCliParams().getBlobDbType();
		Conn10 connBlobDb = null; 
		if ((dbFileName==null) || (f10.getConn10().getDbFileName().equals(dbFileName)))	{
			connBlobDb = new Conn10(f10.getConn10().getConnectionName(), f10.getConn10().getDbType(), f10.getConn10().getDbFileName());;
		} else {
			connBlobDb = new Conn10(connectionName, dbType, dbFileName);
		}
		f10.setConnBlob(connBlobDb);	
		f10.getListConnBlob().add(connBlobDb);
		long blobDbSize = StrUtil.parseStr2Int(f10.getCliParams().getBlobDbSize());
		f10.getConnBlob().setBlobDbSize(blobDbSize);		
		CreateFileSetTables.createFileSetTables(connBlobDb);
	}
	public static void createBlobDatabaseNext(NodeF10 f10)	{
		int dbIdx = f10.getListConnBlob().size(); 
		String dbIdxStr = Integer.toString(dbIdx);  
		dbIdxStr = StrUtil.padLeft(dbIdxStr, 3, "0");
		String dbFileName = f10.getCliParams().getBlobDbName().replaceAll(".db", dbIdxStr + ".db");
		
		createBlobDatabase(f10,dbFileName);
	}
	public static void createBlobDatabase(NodeF10 f10)	{
		String dbFileName = f10.getCliParams().getBlobDbName();
		createBlobDatabase(f10,dbFileName);
	}

}
