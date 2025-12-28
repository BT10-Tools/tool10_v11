package tool10.imageset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class WriteImageTablesToDb {
	
	public static int writeTableImageBlob(Connection conn,NodeImageSet imageSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO IMG_IMAGEBLOB (imageBlobId,imageId,fileBlobId,imageType,blobType,imageSize,imageBytes,crc64,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//String fieldStr = 	"imageBlobId INTEGER,imageId INTEGER,fileBlobId INTEGER, imageType TEXT,blobType TEXT,imageSize INTEGER,imageBytes BLOB,crc64  INTEGER,creationDate TEXT";
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeImageBlob ent : imageSet.getListImageBlob())	{
			    int cnt=1;
			    if (ent.getImageBlobId()!=null) {ps.setLong(cnt++, ent.getImageBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getImageType());
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getImageSize()!=null) {ps.setLong(cnt++, ent.getImageSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageBytes()!=null) {ps.setBytes(cnt++, ent.getImageBytes()); } 	else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableImageBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableImageFile(Connection conn,NodeImageSet imageSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO IMG_IMAGEFILE (imageFileId,imageId,fileId,imageSetId,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"sourceFileSize,sourceFileCreationDate,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//fieldStr = 	"imageFileId INTEGER, imageId INTEGER,fileId INTEGER, imageSetId INTEGER,sourceAbsolutePath TEXT, sourceDirName, SourceFileName,sourceExtensionName,
		//sourceFileSize INTEGER,sourceFileCreationDate TEXT, creationDate TEXT";
		//sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,sourceFileSize,sourceFileCreationDate
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeImageFile ent : imageSet.getListImageFile())	{
			    int cnt=1;
			    if (ent.getImageFileId()!=null) {ps.setLong(cnt++, ent.getImageFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageSetId()!=null) {ps.setLong(cnt++, ent.getImageSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSourceAbsolutePath());
			    ps.setString(cnt++, ent.getSourceDirName());
			    ps.setString(cnt++, ent.getSourceFileName());
			    ps.setString(cnt++, ent.getSourceExtensionName());
			    if (ent.getSourceFileSize()!=null) {ps.setLong(cnt++, ent.getSourceFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceFileCreationDate()!=null) {ps.setString(cnt++, ent.getSourceFileCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableImageFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableImage(Connection conn,NodeImageSet imageSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO IMG_IMAGE (imageId,imageSetId,imageFileId,sourceImageId,imageName,imageType,imageSizeType,sizeX, sizeY,pixelNum,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//String fieldStr = 	"imageId INTEGER,imageSetId INTEGER,imageFileId INTEGER,sourceImageId INTEGER,imageName TEXT, imageType TEXT,imageSizeType INTEGER,sizeX INTEGER, sizeY INTEGER, 
		//pixelNum INTEGER, creationDate TEXT";
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeImage ent : imageSet.getListImage())	{
			    int cnt=1;
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageSetId()!=null) {ps.setLong(cnt++, ent.getImageSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageFileId()!=null) {ps.setLong(cnt++, ent.getImageFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceImageId()!=null) {ps.setLong(cnt++, ent.getSourceImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getImageName());
			    ps.setString(cnt++, ent.getImageType());
			    ps.setString(cnt++, ent.getImageSizeType());
			    if (ent.getSizeX()!=null) {ps.setLong(cnt++, ent.getSizeX());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSizeY()!=null) {ps.setLong(cnt++, ent.getSizeY());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPixelNum()!=null) {ps.setLong(cnt++, ent.getPixelNum());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableImage: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableImageSet(Connection conn,NodeImageSet imageSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO IMG_IMAGESET (imageSetId,fileSetId,imageSetName,imageSetDesc,sourceName,sourceURL,cntImage,sumImageSize,avgImageSize,"+
					   "sourceFileSize,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?, ?)";
		//public NodeImageSet(Long imageSetId, Long fileSetId, String imageSetName, String imageSetDesc, String sourceName,
		//String sourceURL, Long cntImage, Long sumImageSize, Double avgImageSize, Long sourceFileSize,	ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (imageSet.getImageSetId()!=null) {ps.setLong(cnt++, imageSet.getImageSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (imageSet.getFileSetId()!=null) {ps.setLong(cnt++, imageSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    ps.setString(cnt++, imageSet.getImageSetName());
		    ps.setString(cnt++, imageSet.getImageSetDesc());
		    ps.setString(cnt++, imageSet.getSourceName());
		    ps.setString(cnt++, imageSet.getSourceURL());
		    if (imageSet.getCntImage()!=null) {ps.setLong(cnt++, imageSet.getCntImage());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (imageSet.getSumImageSize()!=null) {ps.setLong(cnt++, imageSet.getSumImageSize());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (imageSet.getAvgImageSize()!=null) {ps.setDouble(cnt++, imageSet.getAvgImageSize());} else {ps.setNull(cnt++,Types.DOUBLE);}
		    if (imageSet.getSourceFileSize()!=null) {ps.setLong(cnt++, imageSet.getSourceFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (imageSet.getCreationDate()!=null) {ps.setString(cnt++, imageSet.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (imageSet.getModificationDate()!=null) {ps.setString(cnt++, imageSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableImageSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeImageSet(Connection conn,  NodeImageSet imageSet)	{
		int cntInsertedImageSet = writeTableImageSet(conn,imageSet);
		int cntInsertedImage = writeTableImage(conn,imageSet);
		int cntInsertedImageFile = writeTableImageFile(conn,imageSet);
		int cntInsertedImageBlob = writeTableImageBlob(conn,imageSet);
		
		int cntInserted = cntInsertedImageSet + cntInsertedImage + cntInsertedImageFile + cntInsertedImageBlob;
		return(cntInserted);
	}	
	public static void writeImageSetTables(Connection conn, NodeImageSet imageSet)	{
		writeImageSet(conn,imageSet);
	}
	
}