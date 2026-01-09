package tool10.underdev.bgram;

import java.sql.Connection;
import java.sql.SQLException;

import tool10.sql.JLite;
import tool10.sql.SqlUtil;

public class BGramDb {

	public static Connection createBGramDb()	{
		String w32DbName = "C:\\app\\sqlite\\similarity\\bGramW32.db";
		Connection w32Db = JLite.getConnection(w32DbName);
		return(w32Db);
	}
	public static void createBGramTables(Connection conn)	{
		String fieldStr = 	"entryId INTEGER PRIMARY KEY, bGRamType TEXT, crc32 INTEGER, cnt INTEGER, blobVal BLOB, creationDate TEXT, modificationDate TEXT";
		
		String tableName = "b1";
		String sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "b1", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "b4";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "b4", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "b8";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "b8", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "b512";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "b512", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "w16";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "w16", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "w32";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "w32", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
		tableName = "w64";
		sqlStr="CREATE TABLE IF NOT EXISTS "+tableName+" ("+fieldStr.toUpperCase()+") ";
		JLite.executeUpdate(conn, sqlStr);
		SqlUtil.createIndex(conn, "w64", "crc32", false); JLite.executeUpdate(conn, sqlStr);
		
	}
	public static void createAll()	{
		Connection w32Db = createBGramDb();
		createBGramTables(w32Db);
		JLite.closeConnection(w32Db);	
	}
	public static void main(String[] args) {

		createAll();
	}
}
