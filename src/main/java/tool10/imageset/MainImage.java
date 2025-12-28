package tool10.imageset;

import java.sql.Connection;

import tool10.sql.JLite;

public class MainImage {
	//TO BE DELETED
/*	public static Connection getImageSetConn()	{ 
		//String dbFileName = "C:\\app\\sqlite\\similarity\\stajImageSetIMFDB_final01.db"; //C:\app\sqlite\ImageDatasets\IMFDB_final\AamairKhan\3Idiots\images
		String dbFileName = "C:\\app\\sqlite\\similarity\\stajImageSetIconsLtd01.db"; //C:\app\sqlite\ImageDatasets\IMFDB_final\AamairKhan\3Idiots\images
		Connection conn = JLite.getConnection(dbFileName);
		System.out.println("sqlite conn = "+conn);
		return(conn);
	}		
    public static NodeImageSet getImageSet(Connection conn)	{ 
			
		CreateImageSetTables.dropImageSetTables(conn);
		CreateImageSetTables.createImageSetTables(conn);
		
		CreateImageSetTables.checkImageSetTables(conn);
		//CreateImageSetTables.dropImageSetTables(conn);
		//CreateImageSetTables.checkImageSetTables(conn);
		CreateImageSetTables.deleteImageSetTables(conn);
		
		String imageSetName = "IMDB_final";
		//String sourceDir = "C:\\app\\sqlite\\ImageDatasets\\IMFDB_final\\AamairKhan"; //\\3Idiots"; //\\images";
		String sourceDir = "C:\\app\\sqlite\\ImageDatasets\\colored_icons_final_ltd";
		//String sourceDir = "C:\\app\\sqlite\\ImageDatasets\\IMFDB_final";
		
		NodeImageSet dict = MakeImageSet.makeImageSetFromSource(conn,imageSetName,sourceDir); 
		return (dict);
	}	
    public static NodeImageSet readImageSet(Connection conn,long imageSetId)	{
    	NodeImageSet readImageSet = ReadImageTablesFromDb.readImageSetTables(conn, imageSetId);
    	return(readImageSet);
    }
	public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Connection conn = getImageSetConn();
        
		NodeImageSet imageSet = getImageSet(conn); 
		WriteImageTablesToDb.writeImageSetTables(conn, imageSet);
	
		long imageSetId = 1; //imageSet.getImageSetId();
		NodeImageSet readImageSet = readImageSet(conn, imageSetId);
		
		//printAllDifferences(readImageSet);
		
		JLite.closeConnection(conn); 
    }
    
    */
}
