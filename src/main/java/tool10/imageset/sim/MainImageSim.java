package tool10.imageset.sim; 

import java.sql.Connection;

import tool10.mediaset.NodeMediaSet;
import tool10.mediaset.ReadMediaSetTablesFromDb;
import tool10.sql.JLite;

public class MainImageSim {
	
	public static Connection getImageSetConn()	{ 
		//String dbFileName = "C:\\app\\sqlite\\similarity\\stajImageSetIMFDB_final01.db"; //C:\app\sqlite\ImageDatasets\IMFDB_final\AamairKhan\3Idiots\images
		String dbFileName = "C:\\app\\sqlite\\similarity\\stajImageSetIconsLtd01.db"; //C:\app\sqlite\ImageDatasets\IMFDB_final\AamairKhan\3Idiots\images
		Connection conn = JLite.getConnection(dbFileName);
		System.out.println("sqlite conn = "+conn);
		return(conn);
	}		

	public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection conn = getImageSetConn();
	
		long imageSetId = 1; //imageSet.getImageSetId();
		NodeMediaSet readImageSet = ReadMediaSetTablesFromDb.readImageSetTables(conn, imageSetId);
		
		ImageSimRGBDistance.rgbDistancePairs(readImageSet);
		
		JLite.closeConnection(conn); 
    }
}
