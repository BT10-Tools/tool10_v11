package tool10.imageset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ReadImageTablesFromDb {
	
	public static int readImageSetTableImageBlob(Connection conn,NodeImageSet imageSet)	{
		int cntRead = 0;
		String query = 	"SELECT imageBlobId,imageId,fileBlobId,imageType,blobType,imageSize,imageBytes,crc64,creationDate,modificationDate "+
					    "FROM IMG_IMAGEBLOB WHERE imageId in (SELECT imageId FROM IMG_IMAGE WHERE imageSetId= ?) "+
					    "ORDER BY imageId, imageBlobId";
		//public NodeImageBlob(Long imageBlobId, Long imageId, String imageType, String blobType, Long imageSize, byte[] imageBytes, Long crc64,
		//ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, imageSet.getImageSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long imageBlobId = rs.getLong("imageBlobId");  	if (rs.wasNull()) {imageBlobId = null;}
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long fileBlobId = rs.getLong("fileBlobId");  	if (rs.wasNull()) {fileBlobId = null;}
		    	String imageType = rs.getString("imageType");
		        String blobType = rs.getString("blobType");
		    	Long imageSize = rs.getLong("imageSize");  	if (rs.wasNull()) {imageSize = null;}
		    	byte[] imageBytes= rs.getBytes("imageBytes");  	if (rs.wasNull()) {imageBytes = null;}
		    	Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
		    	String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeImageBlob imageBlob = new NodeImageBlob(imageBlobId,imageId,fileBlobId,imageType,blobType,imageSize,imageBytes,crc64,creationDate,modificationDate);
			    imageSet.getListImageBlob().add(imageBlob);
			    imageSet.getMapId2ImageBlob().put(imageBlob.getImageBlobId(),imageBlob);  
			    cntRead++;
		    }
		    System.out.println("readImageSetTableImageBlob: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readImageSetTableImageFile(Connection conn,NodeImageSet imageSet)	{
		int cntRead = 0;
		String query = 	"SELECT imageFileId,imageId,fileId,imageSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"	sourceFileSize,sourceFileCreationDate,creationDate,modificationDate "+
					    "FROM IMG_IMAGEFILE WHERE imageSetId= ? ORDER BY imageSetId, imageFileId";
		//public NodeImageFile(Long imageFileId, Long imageId, Long fileId, Long imageSetId, String sourceAbsolutePath, String sourceDirName, String sourceFileName,
		//String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, imageSet.getImageSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long imageFileId = rs.getLong("imageFileId");  	if (rs.wasNull()) {imageFileId = null;}
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long fileId = rs.getLong("fileId");  	if (rs.wasNull()) {fileId = null;}
		    	Long imageSetId = rs.getLong("imageSetId");  	if (rs.wasNull()) {imageSetId = null;}
		    	
		        String sourceAbsolutePath = rs.getString("sourceAbsolutePath");
		        String sourceDirName = rs.getString("sourceDirName");
		        String sourceFileName = rs.getString("sourceFileName");
		        String sourceExtensionName = rs.getString("sourceExtensionName");
		        Long sourceFileSize = rs.getLong("sourceFileSize");  	if (rs.wasNull()) {sourceFileSize = null;}
		        String sourceFileCreationDateStr = rs.getString("sourceFileCreationDate");
			    ZonedDateTime sourceFileCreationDate = ((sourceFileCreationDateStr!=null) ? ZonedDateTime.parse(sourceFileCreationDateStr) : null);	
			    String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeImageFile imageFile = new NodeImageFile(imageFileId,imageId,fileId,imageSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
							sourceFileSize,sourceFileCreationDate,creationDate,modificationDate);
			    imageSet.getListImageFile().add(imageFile);
			    imageSet.getMapId2ImageFile().put(imageFile.getImageFileId(),imageFile);  
			    cntRead++;
		    }
		    System.out.println("readImageSetTableImageFile: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readImageSetTableImage(Connection conn,NodeImageSet imageSet)	{
		int cntRead = 0;
		String query = "SELECT imageId,imageSetId,imageFileId,sourceImageId,imageName,imageType,imageSizeType,sizeX, sizeY,pixelNum,creationDate,modificationDate "+
					   "FROM IMG_IMAGE WHERE imageSetId= ? ORDER BY imageSetId, imageId";
		//public NodeImage(Long imageId, Long imageSetId, Long imageFileId, Long sourceImageId, String imageName, String imageType, String imageSizeType,
		//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, imageSet.getImageSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long imageSetId = rs.getLong("imageSetId");  	if (rs.wasNull()) {imageSetId = null;}
		    	Long imageFileId = rs.getLong("imageFileId");  	if (rs.wasNull()) {imageFileId = null;}
		    	Long sourceImageId = rs.getLong("sourceImageId");  	if (rs.wasNull()) {sourceImageId = null;}
		        String imageName = rs.getString("imageName");
		        String imageType = rs.getString("imageType");
		        String imageSizeType = rs.getString("imageSizeType");
		        Long sizeX = rs.getLong("sizeX");  	if (rs.wasNull()) {sizeX = null;}
		        Long sizeY = rs.getLong("sizeY");  	if (rs.wasNull()) {sizeY = null;}
		        Long pixelNum = rs.getLong("pixelNum");  	if (rs.wasNull()) {pixelNum = null;}
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeImage image = new NodeImage(imageId,imageSetId,imageFileId,sourceImageId,imageName,imageType,imageSizeType,sizeX, sizeY,pixelNum,creationDate,modificationDate);
			    imageSet.getListImage().add(image);
			    imageSet.getMapId2Image().put(image.getImageId(),image);  
			    cntRead++;
		    }
		    System.out.println("readImageSetTableImage: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static NodeImageSet readImageSetTableImageSet(Connection conn,long imageSetId)	{
		NodeImageSet imageSet = null;
		String query = "SELECT imageSetId,fileSetId,imageSetName,imageSetDesc,sourceName,sourceURL,cntImage,sumImageSize,avgImageSize,"+
						"sourceFileSize,creationDate,modificationDate FROM IMG_IMAGESET WHERE imageSetId= ? ORDER BY imageSetId";
		//public NodeImageSet(Long imageSetId, Long fileSetId, String imageSetName, String imageSetDescription, String sourceName,
		//String sourceURL, Long cntImage, Long sumImageSize, Double avgImageSize, Long sourceFileSize,	ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, imageSetId); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long imageSetId2 = rs.getLong("imageSetId");
		        Long fileSetId = rs.getLong("fileSetId");  	if (rs.wasNull()) {fileSetId = null;}
		        String imageSetName = rs.getString("imageSetName");
		        String imageSetDesc = rs.getString("imageSetDesc");
		        String sourceName = rs.getString("sourceName");
		        String sourceURL = rs.getString("sourceURL");
		        Long cntImage = rs.getLong("cntImage");  	if (rs.wasNull()) {cntImage = null;}
		        Long sumImageSize = rs.getLong("sumImageSize");  	if (rs.wasNull()) {sumImageSize = null;}
		        Double avgImageSize = rs.getDouble("avgImageSize");  	if (rs.wasNull()) {avgImageSize = null;}
		        Long sourceFileSize = rs.getLong("sourceFileSize");  	if (rs.wasNull()) {sourceFileSize = null;}
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    imageSet = new NodeImageSet(imageSetId,fileSetId,imageSetName,imageSetDesc,sourceName,sourceURL,cntImage,sumImageSize,avgImageSize,
						sourceFileSize,creationDate,modificationDate);
		    }
		    System.out.println("readImageSetTableImageSet: imageSet = " + imageSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(imageSet);
	}
	public static NodeImageSet readImageSet(Connection conn, long imageSetId) {
		NodeImageSet imageSet = readImageSetTableImageSet(conn, imageSetId);
		if (imageSet==null) return (null);
		int cntReadImage = readImageSetTableImage(conn,imageSet);
		int cntReadImageFile = readImageSetTableImageFile(conn,imageSet);
		int cntReadImageBlob = readImageSetTableImageBlob(conn,imageSet);
		
		postProcessImageSet(imageSet);
		
		int cntRead = cntReadImage + cntReadImageFile + cntReadImageBlob + 1;
	    System.out.println("readImageSetId: total recordS read = " + cntRead);
		return(imageSet);
	}	
	public static void postProcessImageSet(NodeImageSet imageSet)	{
		
		GetByMapImageSet.updateAllMapsImageSet(imageSet);
		
	}
	public static NodeImageSet readImageSetTables(Connection conn, long imageSetId)	{
		
		NodeImageSet imageSet = readImageSet(conn,imageSetId);
		if (imageSet!=null)	{
			
			System.out.println("imageSet.getListImage().size() = "+imageSet.getListImage().size());
			System.out.println("imageSet.getListImageFile().size() = "+imageSet.getListImageFile().size());
			System.out.println("imageSet.getListImageBlob().size() = "+imageSet.getListImageBlob().size());
			
			System.out.println("imageSet.getMapId2Image().size() = "+imageSet.getMapId2Image().size());
			System.out.println("imageSet.getMapId2ImageFile().size() = "+imageSet.getMapId2ImageFile().size());
			System.out.println("imageSet.getMapId2ImageBlob().size() = "+imageSet.getMapId2ImageBlob().size());

		} else {
			System.out.println("readImageSetTables: imageSet is null");
		}
		return (imageSet);
	}
	
}