package tool10.mediaset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class WriteMediaSetTablesToDb {
	
	public static int writeTableMediaProp(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_MEDIAPROP(mediaPropId,mediaId,mediaSetId,mediaPropType,engineName,propKeyGroup,propKey,propValue,displayOrder,valueLong,\r\n"
				+ "		valueDouble,valueBoolean, valueZDT, valueBytes,valueStringArray, creationDate,modificationDate) "+
				" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ? )";
		//public NodeMediaProp(Long mediaPropId, Long mediaId, Long mediaSetId, String mediaPropType,
		//		String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
		//		Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,
		//		String[] valueStringArray, ZonedDateTime creationDate, ZonedDateTime modificationDate) 
		//mediaPropId,mediaId,mediaSetId,mediaPropType,engineName,propKeyGroup,propKey,propValue,displayOrder,valueLong,
		//valueDouble,valueBoolean, valueZDT, valueBytes,valueStringArray, creationDate,modificationDate
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeMediaProp ent : mediaSet.getListMediaProp())	{
			    int cnt=1;
			    if (ent.getMediaPropId()!=null) {ps.setLong(cnt++, ent.getMediaPropId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaId()!=null) {ps.setLong(cnt++, ent.getMediaId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getMediaPropType());
			    ps.setString(cnt++, ent.getEngineName());
			    ps.setString(cnt++, ent.getPropKeyGroup());
			    ps.setString(cnt++, ent.getPropKey());
			    ps.setString(cnt++, ent.getPropValue());
			    
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueLong()!=null) {ps.setLong(cnt++, ent.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDouble()!=null) {ps.setDouble(cnt++, ent.getValueDouble());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getValueBoolean());
			    if (ent.getValueZDT()!=null) {ps.setString(cnt++, ent.getValueZDT().toString());} else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getValueBytes()!=null) {ps.setBytes(cnt++, ent.getValueBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getValueStringArray()!=null) {ps.setString(cnt++, ent.getValueStringArray().toString());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableMediaProp: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableVideo(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_VIDEO (videoId,mediaSetId, mediaFileId,sourceMediaId,rootVideoId,\r\n"
				+ "		nextVideoId,previousVideoId,defaultSubtitleId,videoName,videoDesc,videoGroupName,videoType,colorModel,videoSize,sizeX,sizeY,\r\n"
				+ "		pixelNum,aspectRatio, durationMs,fps,dataRateBPS,cntFrame,\r\n"
				+ "		cntSection,videoQuality,videoCompression,videoFormat,videoEncoding,creationDate,modificationDate) "+
				" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ? )";
		//public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long rootVideoId,
		//Long nextVideoId, Long previousVideoId, Long defaultSubtitleId, String videoName, String videoDesc,
		//String videoGroupName, String videoType, String videoSize, String colorModel, Long sizeX, Long sizeY,
		//Long pixelNum, Double aspectRatio, Long durationMs, Double fps, Double dataRateBPS, Long cntFrame,
		//Long cntSection, String videoQuality, String videoCompression, String videoFormat, String videoEncoding,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
	//	videoId,mediaSetId, mediaFileId,sourceMediaId,rootVideoId,
//		nextVideoId,previousVideoId,defaultSubtitleId,videoName,videoDesc,videoGroupName,videoType,videoSize, colorModel,sizeX,sizeY,
	//	pixelNum,aspectRatio, durationMs,fps,dataRateBPS,cntFrame,
	//	cntSection,videoQuality,videoCompression,videoFormat,videoEncoding,
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeVideo ent : mediaSet.getListVideo())	{
			    int cnt=1;
			    if (ent.getVideoId()!=null) {ps.setLong(cnt++, ent.getVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaFileId()!=null) {ps.setLong(cnt++, ent.getMediaFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceMediaId()!=null) {ps.setLong(cnt++, ent.getSourceMediaId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getRootVideoId()!=null) {ps.setLong(cnt++, ent.getRootVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNextVideoId()!=null) {ps.setLong(cnt++, ent.getNextVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPreviousVideoId()!=null) {ps.setLong(cnt++, ent.getPreviousVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDefaultSubtitleId()!=null) {ps.setLong(cnt++, ent.getDefaultSubtitleId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getVideoName());
			    ps.setString(cnt++, ent.getVideoDesc());
			    ps.setString(cnt++, ent.getVideoType());
			    ps.setString(cnt++, ent.getColorModel());
			    if (ent.getVideoSize()!=null) {ps.setLong(cnt++, ent.getVideoSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSizeX()!=null) {ps.setLong(cnt++, ent.getSizeX());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSizeY()!=null) {ps.setLong(cnt++, ent.getSizeY());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPixelNum()!=null) {ps.setLong(cnt++, ent.getPixelNum());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAspectRatio()!=null) {ps.setDouble(cnt++, ent.getAspectRatio());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getDurationMs()!=null) {ps.setLong(cnt++, ent.getDurationMs());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFps()!=null) {ps.setDouble(cnt++, ent.getFps());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getDataRateBPS()!=null) {ps.setDouble(cnt++, ent.getDataRateBPS());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getCntFrame()!=null) {ps.setLong(cnt++, ent.getCntFrame());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntSection()!=null) {ps.setLong(cnt++, ent.getCntSection());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getVideoQuality());
			    ps.setString(cnt++, ent.getVideoCompression());
			    ps.setString(cnt++, ent.getVideoFormat());
			    ps.setString(cnt++, ent.getVideoEncoding());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableVideo: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFrame(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_FRAME (frameId,videoId,mediaSetId,imageId,firstFrameId,nextFrameId,\r\n"
				+ "		previousFrameId,frameName,frameDesc,frameGroupName,frameType,\r\n"
				+ "		sectionName,frameSize,numFrame,cntFrame,startMs,endMs,\r\n"
				+ "		durationMs,similarityRatioPrevious,similarityRatioNext,subtitleLineNum,creationDate,modificationDate) "+
				" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ? )";
		//public NodeFrame(Long frameId, Long videoId, Long mediaSetId, Long imageId, Long firstFrameId, Long nextFrameId,
		//		Long previousFrameId, String frameName, String frameDesc, String frameGroupName, String frameType,
		//		String sectionName, Long frameSize, Long numFrame, Long cntFrame, Long startMs, Long endMs,
		//		Long durationMs, Double similarityRatioPrevious, Double similarityRatioNext, Long subtitleLineNum,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//frameId,videoId,mediaSetId,imageId,firstFrameId,nextFrameId,
		//previousFrameId,frameName,frameDesc,frameGroupName,frameType,
		//sectionName,frameSize,numFrame,cntFrame,startMs,endMs,
		//durationMs,similarityRatioPrevious,similarityRatioNext,subtitleLineNum,
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFrame ent : mediaSet.getListFrame())	{
			    int cnt=1;
			    if (ent.getFrameId()!=null) {ps.setLong(cnt++, ent.getFrameId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getVideoId()!=null) {ps.setLong(cnt++, ent.getVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFirstFrameId()!=null) {ps.setLong(cnt++, ent.getFirstFrameId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNextFrameId()!=null) {ps.setLong(cnt++, ent.getNextFrameId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPreviousFrameId()!=null) {ps.setLong(cnt++, ent.getPreviousFrameId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFrameName());
			    ps.setString(cnt++, ent.getFrameDesc());
			    ps.setString(cnt++, ent.getFrameGroupName());
			    ps.setString(cnt++, ent.getFrameType());
			    ps.setString(cnt++, ent.getSectionName());
			    if (ent.getFrameSize()!=null) {ps.setLong(cnt++, ent.getFrameSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNumFrame()!=null) {ps.setLong(cnt++, ent.getNumFrame());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntFrame()!=null) {ps.setLong(cnt++, ent.getCntFrame());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getStartMs()!=null) {ps.setLong(cnt++, ent.getStartMs());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEndMs()!=null) {ps.setDouble(cnt++, ent.getEndMs());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getDurationMs()!=null) {ps.setLong(cnt++, ent.getDurationMs());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSimilarityRatioPrevious()!=null) {ps.setDouble(cnt++, ent.getSimilarityRatioPrevious());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSimilarityRatioNext()!=null) {ps.setDouble(cnt++, ent.getSimilarityRatioNext());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSubtitleLineNum()!=null) {ps.setLong(cnt++, ent.getSubtitleLineNum());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFrame: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableAudio(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_AUDIO (audioId,mediaSetId,mediaFileId,sourceMediaId,videoId,\r\n"
				+ "		rootAudioId,nextAudioId,previousAudioId,defaultSubtitleId,lyricsId,audioName,audioDesc,audioGroupName,audioType,\r\n"
				+ "		contentType,artistName,albumName,songName,audioSize,durationMs,bitRateBPS,dataRateBPS,sampleRateKHZ,cntChannel,cntSection,\r\n"
				+ "		audioQuality,audioCompression,audioFormat,audioEncoding,creationDate,modificationDate) "+
				" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ? )";
		//public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceImageId, Long videoId,
		//Long rootAudioId, Long nextAudioId, Long previousAudioId, Long defaultSubtitleId, Long lyricsId,
		//String audioName, String audioDesc, String audioGroupName, String audioType, 
		//String contentType, String artistName, String albumName, String songName, Long audioSize, Long durationMs,
		//Double bitRateBPS, Double dataRateBPS, Double sampleRateKHZ, Long cntChannel, Long cntSection,
		//String audioQuality, String audioCompression, String audioFormat, String audioEncoding,
			
		//audioId,mediaSetId,imageFileId,sourceImageId,videoId,
		//rootAudioId,nextAudioId,previousAudioId,defaultSubtitleId,lyricsId,audioName,audioDesc,audioGroupName,audioType,
		//contentType,artistName,albumName,songName,audioSize,durationMs,bitRateBPS,dataRateBPS,sampleRateKHZ,cntChannel,cntSection,
		//audioQuality,audioCompression,audioFormat,audioEncoding,
				
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeAudio ent : mediaSet.getListAudio())	{
			    int cnt=1;
			    if (ent.getAudioId()!=null) {ps.setLong(cnt++, ent.getAudioId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaFileId()!=null) {ps.setLong(cnt++, ent.getMediaFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceMediaId()!=null) {ps.setLong(cnt++, ent.getSourceMediaId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getVideoId()!=null) {ps.setLong(cnt++, ent.getVideoId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getRootAudioId()!=null) {ps.setLong(cnt++, ent.getRootAudioId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getNextAudioId()!=null) {ps.setLong(cnt++, ent.getNextAudioId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPreviousAudioId()!=null) {ps.setLong(cnt++, ent.getPreviousAudioId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDefaultSubtitleId()!=null) {ps.setLong(cnt++, ent.getDefaultSubtitleId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLyricsId()!=null) {ps.setLong(cnt++, ent.getLyricsId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    ps.setString(cnt++, ent.getAudioName());
			    ps.setString(cnt++, ent.getAudioDesc());
			    ps.setString(cnt++, ent.getAudioGroupName());
			    ps.setString(cnt++, ent.getAudioType());
			    ps.setString(cnt++, ent.getContentType());
			    ps.setString(cnt++, ent.getArtistName());
			    ps.setString(cnt++, ent.getAlbumName());
			    ps.setString(cnt++, ent.getSongName());
			    if (ent.getAudioSize()!=null) {ps.setLong(cnt++, ent.getAudioSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDurationMs()!=null) {ps.setLong(cnt++, ent.getDurationMs());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getBitRateBPS()!=null) {ps.setDouble(cnt++, ent.getBitRateBPS());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getDataRateBPS()!=null) {ps.setDouble(cnt++, ent.getDataRateBPS());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSampleRateKHZ()!=null) {ps.setDouble(cnt++, ent.getSampleRateKHZ());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getCntChannel()!=null) {ps.setLong(cnt++, ent.getCntChannel());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntSection()!=null) {ps.setLong(cnt++, ent.getCntSection());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getAudioQuality());
			    ps.setString(cnt++, ent.getAudioCompression());
			    ps.setString(cnt++, ent.getAudioFormat());
			    ps.setString(cnt++, ent.getAudioEncoding());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableAudio: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableMediaBlob(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_MEDIABLOB (mediaBlobId,mediaId,mediaSetId,fileBlobId,mediaType,blobType,mediaSize,mediaBytes,crc64,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?)";
		//public NodeMediaBlob(Long mediaBlobId, Long mediaId, Long mediaSetId, Long fileBlobId, String mediaType, String blobType, Long mediaSize, 
		//byte[] mediaBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
			PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeMediaBlob ent : mediaSet.getListMediaBlob())	{
			    int cnt=1;
			    if (ent.getMediaBlobId()!=null) {ps.setLong(cnt++, ent.getMediaBlobId());} 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaId()!=null) 	{ps.setLong(cnt++, ent.getMediaId());} 		else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) 	{ps.setLong(cnt++, ent.getMediaSetId());} 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileBlobId()!=null) 	{ps.setLong(cnt++, ent.getFileBlobId());} 	else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getMediaType());
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getMediaSize()!=null) {ps.setLong(cnt++, ent.getMediaSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaBytes()!=null) {ps.setBytes(cnt++, ent.getMediaBytes()); } 	else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableMediaBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableMediaFile(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_MEDIAFILE (mediaFileId,mediaId,fileId,mediaSetId,mediaFileType,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"sourceFileSize,sourceFileCreationDate,creationDate,modificationDate) VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeMediaFile(Long mediaFileId, Long mediaId, Long fileId, Long mediaSetId, String mediaFileType, String sourceAbsolutePath, String sourceDirName, 
		//String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeMediaFile ent : mediaSet.getListMediaFile())	{
			    int cnt=1;
			    if (ent.getMediaFileId()!=null) {ps.setLong(cnt++, ent.getMediaFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaId()!=null) {ps.setLong(cnt++, ent.getMediaId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getMediaFileType());
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
		    System.out.println("writeTableMediaFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableImage(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO MED_IMAGE (imageId,mediaSetId,mediaFileId,sourceMediaId,imageName,imageType,imageSize,sizeX, sizeY,pixelNum,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?)";
		//String fieldStr = 	"imageId INTEGER,mediaSetId INTEGER,imageFileId INTEGER,sourceImageId INTEGER,imageName TEXT, imageType TEXT,imageSize INTEGER,sizeX INTEGER, sizeY INTEGER, 
		//pixelNum INTEGER, creationDate TEXT";
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeImage ent : mediaSet.getListImage())	{
			    int cnt=1;
			    if (ent.getImageId()!=null) {ps.setLong(cnt++, ent.getImageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaSetId()!=null) {ps.setLong(cnt++, ent.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMediaFileId()!=null) {ps.setLong(cnt++, ent.getMediaFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceMediaId()!=null) {ps.setLong(cnt++, ent.getSourceMediaId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getImageName());
			    ps.setString(cnt++, ent.getImageType());
			    ps.setString(cnt++, ent.getImageSize());
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
	public static int writeTableMediaSet(Connection conn,NodeMediaSet mediaSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO MED_MEDIASET (mediaSetId,fileSetId,mediaSetName,mediaSetDesc,sourceName,sourceURL,cntMedia,sumMediaSize,avgMediaSize,"+
					   "sourceFileSize,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?)";
		//public NodeImageSet(Long mediaSetId, Long fileSetId, String mediaSetName, String mediaSetDesc, String sourceName,
		//String sourceURL, Long cntMedia, Long sumMediaSize, Double avgMediaSize, Long sourceFileSize,	ZonedDateTime creationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (mediaSet.getMediaSetId()!=null) {ps.setLong(cnt++, mediaSet.getMediaSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (mediaSet.getFileSetId()!=null) {ps.setLong(cnt++, mediaSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
		    ps.setString(cnt++, mediaSet.getMediaSetName());
		    ps.setString(cnt++, mediaSet.getMediaSetDesc());
		    ps.setString(cnt++, mediaSet.getSourceName());
		    ps.setString(cnt++, mediaSet.getSourceURL());
		    if (mediaSet.getCntMedia()!=null) {ps.setLong(cnt++, mediaSet.getCntMedia());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (mediaSet.getSumMediaSize()!=null) {ps.setLong(cnt++, mediaSet.getSumMediaSize());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (mediaSet.getAvgMediaSize()!=null) {ps.setDouble(cnt++, mediaSet.getAvgMediaSize());} else {ps.setNull(cnt++,Types.DOUBLE);}
		    if (mediaSet.getSourceFileSize()!=null) {ps.setLong(cnt++, mediaSet.getSourceFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
		    if (mediaSet.getCreationDate()!=null) {ps.setString(cnt++, mediaSet.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (mediaSet.getModificationDate()!=null) {ps.setString(cnt++, mediaSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableMediaSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeMediaSet(Connection conn,  NodeMediaSet mediaSet)	{
		int cntInsertedMediaSet = writeTableMediaSet(conn,mediaSet);
		int cntInsertedImage = writeTableImage(conn,mediaSet);
		int cntInsertedMediaFile = writeTableMediaFile(conn,mediaSet);
		int cntInsertedMediaBlob = writeTableMediaBlob(conn,mediaSet);
		int cntInsertedMediaProp = writeTableMediaProp(conn,mediaSet);
		int cntInsertedVideo = writeTableVideo(conn,mediaSet);
		int cntInsertedFrame = writeTableFrame(conn,mediaSet);
		int cntInsertedAudio = writeTableAudio(conn,mediaSet);
		
		int cntInserted = cntInsertedMediaSet + cntInsertedImage + cntInsertedMediaFile + cntInsertedMediaBlob + 
				cntInsertedMediaProp +cntInsertedVideo + cntInsertedFrame + cntInsertedAudio;
		return(cntInserted);
	}	
	public static void writeMediaSetTables(Connection conn, NodeMediaSet mediaSet)	{
		writeMediaSet(conn,mediaSet);
	}
	
}