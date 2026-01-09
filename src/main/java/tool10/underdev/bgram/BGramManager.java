package tool10.underdev.bgram;

import java.io.File;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.zip.CRC32;

import tool10.fileset.nodes.NodeBinary;
import tool10.sql.JLite;
import tool10.util.TraverseFiles;
import tool10.util.UtilCRC32;

public class BGramManager {

	private static void keepOnlyTop(Connection conn, String tableName, String bGRamType, SortedMap<NodeBinary,Long> sMap, long topN)	{
	/*	System.out.println("BGramManager keepOnlyTop  tableName:"+tableName+" ,bGRamType:"+bGRamType+"  sMap.size():"+sMap.size());
		
		String sqlStrSelect = "SELECT  Count(*) cntEntry FROM "+tableName+" WHERE cnt>0";
		try {
			PreparedStatement psSelect = conn.prepareStatement(sqlStrSelect);
			ResultSet rsSelect  = psSelect.executeQuery(); 
			long maxEntryId = 0; 
			if (!rsSelect.next()) { 
				maxEntryId = rsSelect.getLong("maxEntryId");
			}
		} catch (SQLException e) {
			System.out.println("SQLExcception e:"+e);
		} */
	}
	static long newId = 1;
	private static void updateOneBGramTable(Connection conn, String tableName, String bGRamType, SortedMap<NodeBinary,Long> sMap)	{
		//tableName w32
		//SortedMap<NodeBinary,Long> sMap = bGram.getW32();
		System.out.println("BGramManager updateOneBGramTable  tableName:"+tableName+" ,bGRamType:"+bGRamType+"  sMap.size():"+sMap.size());
		
		CRC32 crc32 = UtilCRC32.getCRC32();
		//String fieldStr = 	"entryId INTEGER PRIMARY KEY, bGRamType TEXT, crc32 INTEGER, cnt INTEGER, blobVal BLOB, creationDate TEXT, modificationDate TEXT";
		String sqlStrSelect = "SELECT  count(entryId) cntEntry FROM "+tableName+" WHERE crc32 = ? and blobVal = ?";
		String sqlStrUpdate = "UPDATE "+tableName+" SET cnt = cnt + ? WHERE entryId = ? ";
		String sqlStrInsert = "INSERT INTO "+tableName+"(entryId,bGRamType,crc32,cnt,blobVal,creationDate) VALUES (?, ?, ?, ?, ?,   ?)";
		
		int cntInserted = 0;
		int cntUpdated = 0;
		try {
			PreparedStatement psSelect = conn.prepareStatement(sqlStrSelect);
			PreparedStatement psUpdate = conn.prepareStatement(sqlStrUpdate);
			PreparedStatement psInsert = conn.prepareStatement(sqlStrInsert);
			ResultSet rsSelect; 
			for (NodeBinary nodeBin : sMap.keySet())	{
				if (sMap.get(nodeBin)==null) continue;
				long cntW32 = sMap.get(nodeBin);
				long valCrc32 = UtilCRC32.getBytesCRC32(crc32, nodeBin.getByteArray());
				
				//System.out.println("BGramManager updateOneBGramTable  cntW32:"+cntW32+" ,valCrc32:"+valCrc32+
				//		"  nodeBin.getByteArray().length:"+nodeBin.getByteArray().length);
				
				psSelect.setLong(1,valCrc32); 
				psSelect.setBytes(2,nodeBin.getByteArray());
				rsSelect  = psSelect.executeQuery(); 
				long cntEntry = 0; 
				if (rsSelect.next()) { 
					cntEntry = rsSelect.getLong("cntEntry");
				}
				if (cntEntry <= 0)	 {
					//insert
					//System.out.println("BGramManager updateOneBGramTable  insert newId:"+newId+" ,cntW32:"+cntW32); 
					newId++;
					psInsert.setLong(1, newId);	psInsert.setString(2,bGRamType); 				psInsert.setLong(3,valCrc32);
					psInsert.setLong(4,cntW32);		psInsert.setBytes(5,nodeBin.getByteArray());		psInsert.setString(6, LocalDate.now().toString());
					cntInserted += psInsert.executeUpdate();					
				} else {
					//update
					System.out.println("BGramManager updateOneBGramTable update cntEntry:"+cntEntry+" ,cntW32:"+cntW32); 
					psUpdate.setLong(1, cntW32);
					psUpdate.setLong(2, cntEntry);
					cntUpdated += psUpdate.executeUpdate();
				}
			}
			psSelect.close();
			psUpdate.close();
			psInsert.close();
		} catch (SQLException e) {
			System.out.println("SQLExcception e:"+e);
		}
		System.out.println("BGramManager updateOneBGramTable  cntInserted:"+cntInserted);
		System.out.println("BGramManager updateOneBGramTable  cntUpdated:"+cntUpdated);
	}
	private static SortedMap<NodeBinary,Long> getSortedMapFromArray(long[] arrLong)	{
		SortedMap<NodeBinary,Long> sMap = new TreeMap<>();
		//NodeBinary(Long byteLength, Long crc64, byte[] byteArray) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		for (int i=0; i<arrLong.length; i++)	{ 
			buffer.putLong((long)i);
	        byte[] bytes = buffer.array();
	        long valCrc32 = UtilCRC32.getBytesCRC32(bytes);
			NodeBinary nb = new NodeBinary((long)bytes.length,valCrc32,bytes);
			sMap.put(nb, arrLong[i]);
			buffer.clear();
		}
		return(sMap);
	}
	private static void updateBGramTables(Connection conn, BGram bGram)	{
		System.out.println("updateBGramTables      bGram.getW32().size():"+bGram.getW32().size() + "   , bGram.getW64().size():"+bGram.getW64().size());
		System.out.println("updateBGramTables      bGram.getB512().size():"+bGram.getB512().size());
		updateOneBGramTable(conn, "w32", "w32", bGram.getW32());
		updateOneBGramTable(conn, "w64", "w64", bGram.getW64());
		updateOneBGramTable(conn, "b512", "b512", bGram.getB512());
		SortedMap<NodeBinary,Long> sMap1  = getSortedMapFromArray(bGram.getB1()); 	updateOneBGramTable(conn, "b1", "b1", sMap1); 
		SortedMap<NodeBinary,Long> sMap4  = getSortedMapFromArray(bGram.getB4());	updateOneBGramTable(conn, "b4", "b4", sMap4);
		SortedMap<NodeBinary,Long> sMap8  = getSortedMapFromArray(bGram.getB8()); 	updateOneBGramTable(conn, "b8", "b8", sMap8);
		SortedMap<NodeBinary,Long> sMap16 = getSortedMapFromArray(bGram.getW16()); 	updateOneBGramTable(conn, "w16", "w16", sMap16);
		
		System.out.println("updateBGramTables      sMap1.size():"+sMap1.size() + "    , sMap4.size():"+sMap4.size());
		System.out.println("updateBGramTables      sMap8.size():"+sMap8.size() + "   , sMap16.size():"+sMap16.size());
		
		bGram.clearListsAndMaps();
		//keepOnlyTop(conn, "w32", "w32", bGram.getW32(), BGram.getCnttopW32());
		//keepOnlyTop(conn, "w64", "w64", bGram.getW64(), BGram.getCnttopW64());
		//keepOnlyTop(conn, "b512", "b512", bGram.getB512(), BGram.getCnttop512());
		//for others no need for deleting some entries from the table b1,b4, b8, w16 
	}
	private static void runBGram()	{
		Connection w32Db = BGramDb.createBGramDb();
		
		//String dir = "C:\\tmp\\similarity\\07_Transform\\01_Org\\CD2";
		String dir = "C:\\app\\sqlite\\02_TanzilQuran";
		File fileDir = new File(dir);
		//public static int traverseFiles(ArrayList<String> filenameList,String[] extArray, File folder) {
		ArrayList<String> filenameList = new ArrayList<String>();
		String[] extArray = new String[] {};
		
		TraverseFiles.traverseFiles(filenameList, extArray, fileDir);
		int i = 0; 
		for (String fName : filenameList)	{
			System.out.println(fName + "     i:"+i);
			BGram bGram = BGramCreate.createOneBGramFromFile(fName);
			updateBGramTables(w32Db,bGram);
			System.out.println(bGram.getPrintString());
			if (i++ > 10) break;
		}
		JLite.closeConnection(w32Db);
	}
	public static void main(String[] args) {
		runBGram();
	}
}
