package tool10.mediaset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;

public class ReadMediaSetTablesFromDb {
	
	public static int readMediaSetTableMediaProp(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = 	"SELECT mediaPropId,mediaId,mediaSetId,mediaPropType,engineName,propKeyGroup,propKey,propValue,\r\n"+
				"displayOrder,valueLong,valueDouble,valueBoolean, valueZDT, valueBytes,valueStringArray,creationDate,modificationDate\r\n"+
				"FROM MED_MEDIAPROP WHERE mediaSetId= ? ORDER BY mediaPropId, mediaMediaId";
		//public NodeMediaProp(Long mediaPropId, Long mediaId, Long mediaSetId, String mediaPropType,
		//		String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
		//		Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,
		//		String[] valueStringArray, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long mediaPropId = rs.getLong("mediaPropId");  	if (rs.wasNull()) {mediaPropId = null;}
		    	Long mediaId = rs.getLong("mediaId");  	if (rs.wasNull()) {mediaId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	String mediaPropType = rs.getString("mediaPropType");
		        String engineName = rs.getString("engineName");
		        String propKeyGroup = rs.getString("propKeyGroup");
		        String propKey = rs.getString("propKey");
		        String propValue = rs.getString("propValue");
		        Long displayOrder = rs.getLong("displayOrder");  	if (rs.wasNull()) {displayOrder = null;}
		        Long valueLong = rs.getLong("valueLong");  	if (rs.wasNull()) {valueLong = null;}
		        Double valueDouble = rs.getDouble("valueDouble");  	if (rs.wasNull()) {valueDouble = null;}
		        String valueBoolean = rs.getString("displayOrder");  	
		        String valueZDTStr = rs.getString("valueZDT");
		        ZonedDateTime valueZDT = ((valueZDTStr!=null) ? ZonedDateTime.parse(valueZDTStr) : null);	
			    byte[] valueBytes= rs.getBytes("valueBytes");  	if (rs.wasNull()) {valueBytes = null;}
			    String[] valueStringArray = rs.getString("valueStringArray").split(",");
			    
			    String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeMediaProp mediaProp = new NodeMediaProp(mediaPropId,mediaId,mediaSetId,mediaPropType,engineName,propKeyGroup,
			    		propKey,propValue,displayOrder,valueLong,valueDouble,valueBoolean, valueZDT, valueBytes,valueStringArray, 
			    		creationDate,modificationDate);
			    mediaSet.getListMediaProp().add(mediaProp);
			    mediaSet.getMapId2MediaProp().put(mediaProp.getMediaPropId(),mediaProp);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableMediaProp: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableMediaBlob(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = 	"SELECT mediaBlobId,mediaId,mediaSetId,fileBlobId,mediaType,blobType,mediaSize,mediaBytes,crc64,creationDate,modificationDate "+
					    "FROM MED_MEDIABLOB WHERE mediaSetId= ? "+
					    "ORDER BY mediaId, mediaBlobId";
		//public NodeMediaBlob(Long mediaBlobId, Long mediaId, Long mediaSetId, Long fileBlobId, String mediaType, String blobType, Long mediaSize, 
		//byte[] mediaBytes, Long crc64, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long mediaBlobId = rs.getLong("mediaBlobId");  	if (rs.wasNull()) {mediaBlobId = null;}
		    	Long mediaId = rs.getLong("mediaId");  	if (rs.wasNull()) {mediaId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	Long fileBlobId = rs.getLong("fileBlobId");  	if (rs.wasNull()) {fileBlobId = null;}
		    	String mediaType = rs.getString("mediaType");
		        String blobType = rs.getString("blobType");
		    	Long mediaSize = rs.getLong("mediaSize");  	if (rs.wasNull()) {mediaSize = null;}
		    	byte[] mediaBytes= rs.getBytes("mediaBytes");  	if (rs.wasNull()) {mediaBytes = null;}
		    	Long crc64 = rs.getLong("crc64");  	if (rs.wasNull()) {crc64 = null;}
		    	String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeMediaBlob mediaBlob = new NodeMediaBlob(mediaBlobId,mediaId,mediaSetId,fileBlobId,mediaType,blobType,mediaSize,mediaBytes,crc64,creationDate,modificationDate);
			    mediaSet.getListMediaBlob().add(mediaBlob);
			    mediaSet.getMapId2MediaBlob().put(mediaBlob.getMediaBlobId(),mediaBlob);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableMediaBlob: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableMediaFile(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = 	"SELECT mediaFileId,mediaId,fileId,mediaSetId,mediaFileType,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,"+
						"	sourceFileSize,sourceFileCreationDate,creationDate,modificationDate "+
					    "FROM MED_MEDIAFILE WHERE mediaSetId= ? ORDER BY mediaSetId, mediaFileId";
		//public NodeMediaFile(Long mediaFileId, Long mediaId, Long fileId, Long mediaSetId, String mediaFileType, String sourceAbsolutePath, String sourceDirName, 
		//String sourceFileName, String sourceExtensionName, Long sourceFileSize, ZonedDateTime sourceFileCreationDate,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long mediaFileId = rs.getLong("mediaFileId");  	if (rs.wasNull()) {mediaFileId = null;}
		    	Long mediaId = rs.getLong("mediaId");  	if (rs.wasNull()) {mediaId = null;}
		    	Long fileId = rs.getLong("fileId");  	if (rs.wasNull()) {fileId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	
		    	String mediaFileType = rs.getString("mediaFileType");
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
			    NodeMediaFile mediaFile = new NodeMediaFile(mediaFileId,mediaId,fileId,mediaSetId,mediaFileType,sourceAbsolutePath,sourceDirName,sourceFileName,sourceExtensionName,
							sourceFileSize,sourceFileCreationDate,creationDate,modificationDate);
			    mediaSet.getListMediaFile().add(mediaFile);
			    mediaSet.getMapId2MediaFile().put(mediaFile.getMediaFileId(),mediaFile);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableMediaFile: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableImage(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = "SELECT imageId,mediaSetId,mediaFileId,sourceImageId,imageName,imageType,imageSize,sizeX, sizeY,pixelNum,creationDate,modificationDate "+
					   "FROM MED_IMAGE WHERE mediaSetId= ? ORDER BY mediaSetId, imageId";
		//public NodeImage(Long imageId, Long mediaSetId, Long mediaFileId, Long sourceImageId, String imageName, String imageType, String imageSize,
		//Long sizeX, Long sizeY, Long pixelNum, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	Long mediaFileId = rs.getLong("mediaFileId");  	if (rs.wasNull()) {mediaFileId = null;}
		    	Long sourceMediaId = rs.getLong("sourceMediaId");  	if (rs.wasNull()) {sourceMediaId = null;}
		        String imageName = rs.getString("imageName");
		        String imageType = rs.getString("imageType");
		        String imageSize = rs.getString("imageSize");
		        Long sizeX = rs.getLong("sizeX");  	if (rs.wasNull()) {sizeX = null;}
		        Long sizeY = rs.getLong("sizeY");  	if (rs.wasNull()) {sizeY = null;}
		        Long pixelNum = rs.getLong("pixelNum");  	if (rs.wasNull()) {pixelNum = null;}
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeImage image = new NodeImage(imageId,mediaSetId,mediaFileId,sourceMediaId,imageName,imageType,imageSize,sizeX, sizeY,pixelNum,creationDate,modificationDate);
			    mediaSet.getListImage().add(image);
			    mediaSet.getMapId2Image().put(image.getImageId(),image);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableImage: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableVideo(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = "SELECT videoId,mediaSetId,mediaFileId,sourceMediaId,rootVideoId,\r\n"
				+ "	nextVideoId,previousVideoId,defaultSubtitleId,videoName,videoDesc,videoGroupName,videoType,colorModel,\r\n"
				+ "	videoSize,sizeX,sizeY,pixelNum,aspectRatio, durationMs,fps,dataRateBPS,cntFrame,\r\n"
				+ "	cntSection,videoQuality,videoCompression,videoFormat,videoEncoding,creationDate,modificationDate "+
				  "FROM MED_VIDEO WHERE mediaSetId= ? ORDER BY mediaSetId, videoId";
		//public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long rootVideoId,
		//Long nextVideoId, Long previousVideoId, Long defaultSubtitleId, String videoName, String videoDesc,
		//String videoGroupName, String videoType, String colorModel, Long videoSize, Long sizeX, Long sizeY,
		//Long pixelNum, Double aspectRatio, Long durationMs, Double fps, Double dataRateBPS, Long cntFrame,
		//Long cntSection, String videoQuality, String videoCompression, String videoFormat, String videoEncoding,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long videoId = rs.getLong("videoId");  	if (rs.wasNull()) {videoId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	Long mediaFileId = rs.getLong("mediaFileId");  	if (rs.wasNull()) {mediaFileId = null;}
		    	Long sourceMediaId = rs.getLong("sourceMediaId");  	if (rs.wasNull()) {sourceMediaId = null;}
		    	Long rootVideoId = rs.getLong("rootVideoId");  	if (rs.wasNull()) {rootVideoId = null;}
		    	Long nextVideoId = rs.getLong("nextVideoId");  	if (rs.wasNull()) {nextVideoId = null;}
		    	Long previousVideoId = rs.getLong("previousVideoId");  	if (rs.wasNull()) {nextVideoId = null;}
		    	Long defaultSubtitleId = rs.getLong("defaultSubtitleId");  	if (rs.wasNull()) {defaultSubtitleId = null;}
		    	
		        String videoName = rs.getString("videoName");
		        String videoDesc = rs.getString("videoDesc");
		        String videoGroupName = rs.getString("videoGroupName");
		        String videoType = rs.getString("videoType");
		        String colorModel = rs.getString("colorModel");
		        
		        Long videoSize = rs.getLong("videoSize");  	if (rs.wasNull()) {videoSize = null;}
		        Long sizeX = rs.getLong("sizeX");  	if (rs.wasNull()) {sizeX = null;}
			    Long sizeY = rs.getLong("sizeY");  	if (rs.wasNull()) {sizeY = null;}
		        Long pixelNum = rs.getLong("pixelNum");  	if (rs.wasNull()) {pixelNum = null;}
		        Double aspectRatio = rs.getDouble("aspectRatio");  	if (rs.wasNull()) {aspectRatio = null;}
		        Long durationMs = rs.getLong("durationMs");  	if (rs.wasNull()) {durationMs = null;}
		        Double fps = rs.getDouble("fps");  	if (rs.wasNull()) {fps = null;}
		        Double dataRateBPS = rs.getDouble("dataRateBPS");  	if (rs.wasNull()) {dataRateBPS = null;}
		        Long cntFrame = rs.getLong("cntFrame");  	if (rs.wasNull()) {cntFrame = null;}
		        Long cntSection = rs.getLong("cntSection");  	if (rs.wasNull()) {cntSection = null;}
		        String videoQuality = rs.getString("videoQuality");
		        String videoCompression = rs.getString("videoCompression");
		        String videoFormat = rs.getString("videoFormat");
		        String videoEncoding = rs.getString("videoEncoding");
		        
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeVideo video = new NodeVideo(videoId,mediaSetId, mediaFileId,sourceMediaId,rootVideoId,
			    		nextVideoId,previousVideoId,defaultSubtitleId,videoName,videoDesc,videoGroupName,videoType,
			    		colorModel,videoSize,sizeX,sizeY,pixelNum,aspectRatio, durationMs,fps,dataRateBPS,cntFrame,
			    		cntSection,videoQuality,videoCompression,videoFormat,videoEncoding,creationDate,modificationDate);
			    mediaSet.getListVideo().add(video);
			    mediaSet.getMapId2Video().put(video.getVideoId(),video);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableVideo: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableFrame(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = "SELECT frameId,videoId,mediaSetId,imageId,firstFrameId,nextFrameId,\r\n"
				+ "		previousFrameId,frameName,frameDesc,frameGroupName,frameType,\r\n"
				+ "		sectionName,frameSize,numFrame,cntFrame,startMs,endMs,\r\n"
				+ "		durationMs,similarityRatioPrevious,similarityRatioNext,subtitleLineNum,creationDate,modificationDate "+
				  "FROM MED_FRAME WHERE mediaSetId= ? ORDER BY mediaSetId, frameId";
		//public NodeFrame(Long frameId, Long videoId, Long mediaSetId, Long imageId, Long firstFrameId, Long nextFrameId,
		//		Long previousFrameId, String frameName, String frameDesc, String frameGroupName, String frameType,
		//		String sectionName, Long frameSize, Long numFrame, Long cntFrame, Long startMs, Long endMs,
		//		Long durationMs, Double similarityRatioPrevious, Double similarityRatioNext, Long subtitleLineNum,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {		
		//public NodeFrame(Long frameId, Long videoId, Long mediaSetId, Long imageId, Long firstFrameId, Long nextFrameId,
		//		Long previousFrameId, String frameName, String frameDesc, String frameGroupName, String frameType,
		//		String sectionName, Long frameSize, Long numFrame, Long cntFrame, Long startMs, Long endMs,
		//		Long durationMs, Double similarityRatioPrevious, Double similarityRatioNext, Long subtitleLineNum,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long frameId = rs.getLong("frameId");  	if (rs.wasNull()) {frameId = null;}
		    	Long videoId = rs.getLong("videoId");  	if (rs.wasNull()) {videoId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	Long imageId = rs.getLong("imageId");  	if (rs.wasNull()) {imageId = null;}
		    	Long firstFrameId = rs.getLong("firstFrameId");  	if (rs.wasNull()) {firstFrameId = null;}
		    	Long nextFrameId = rs.getLong("nextFrameId");  	if (rs.wasNull()) {nextFrameId = null;}
		    	Long previousFrameId = rs.getLong("previousFrameId");  	if (rs.wasNull()) {previousFrameId = null;}
		    	
		        String frameName = rs.getString("frameName");
		        String frameDesc = rs.getString("frameDesc");
		        String frameGroupName = rs.getString("frameGroupName");
		        String frameType = rs.getString("frameType");
		        String sectionName = rs.getString("sectionName");
		        
		        Long frameSize = rs.getLong("frameSize");  	if (rs.wasNull()) {frameSize = null;}
		        Long numFrame = rs.getLong("numFrame");  	if (rs.wasNull()) {numFrame = null;}
		        Long cntFrame = rs.getLong("cntFrame");  	if (rs.wasNull()) {cntFrame = null;}
		        Long startMs = rs.getLong("startMs");  	if (rs.wasNull()) {startMs = null;}
		        Long endMs = rs.getLong("endMs");  	if (rs.wasNull()) {endMs = null;}
		        Long durationMs = rs.getLong("durationMs");  	if (rs.wasNull()) {durationMs = null;}
		        Double similarityRatioPrevious = rs.getDouble("similarityRatioPrevious");  	if (rs.wasNull()) {similarityRatioPrevious = null;}
		        Double similarityRatioNext = rs.getDouble("similarityRatioNext");  	if (rs.wasNull()) {similarityRatioNext = null;}
		        Long subtitleLineNum = rs.getLong("subtitleLineNum");  	if (rs.wasNull()) {subtitleLineNum = null;}
		        
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeFrame frame = new NodeFrame(frameId,videoId,mediaSetId,imageId,firstFrameId,nextFrameId,
			    		previousFrameId,frameName,frameDesc,frameGroupName,frameType,sectionName,frameSize,numFrame,cntFrame,startMs,endMs,
			    		durationMs,similarityRatioPrevious,similarityRatioNext,subtitleLineNum,creationDate,modificationDate);
			    mediaSet.getListFrame().add(frame);
			    mediaSet.getMapId2Frame().put(frame.getFrameId(),frame);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableFrame: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static int readMediaSetTableAudio(Connection conn,NodeMediaSet mediaSet)	{
		int cntRead = 0;
		String query = "SELECT audioId,mediaSetId,mediaFileId,sourceImageId,videoId,\r\n"
				+ "		rootAudioId,nextAudioId,previousAudioId,defaultSubtitleId,lyricsId,audioName,audioDesc,audioGroupName,audioType,\r\n"
				+ "		contentType,artistName,albumName,songName,audioSize,durationMs,bitRateBPS,dataRateBPS,sampleRateKHZ,cntChannel,cntSection,\r\n"
				+ "		audioQuality,audioCompression,audioFormat,audioEncoding,creationDate,modificationDate "+
				  "FROM MED_AUDIO WHERE mediaSetId= ? ORDER BY mediaSetId, audioId";
		//public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceImageId, Long videoId,
		//Long rootAudioId, Long nextAudioId, Long previousAudioId, Long defaultSubtitleId, Long lyricsId,
		//String audioName, String audioDesc, String audioGroupName, String audioType, 
		//String contentType, String artistName, String albumName, String songName, Long audioSize, Long durationMs,
		//Double bitRateBPS, Double dataRateBPS, Double sampleRateKHZ, Long cntChannel, Long cntSection,
		//String audioQuality, String audioCompression, String audioFormat, String audioEncoding,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//audioId,mediaSetId,mediaFileId,sourceImageId,videoId,
		//rootAudioId,nextAudioId,previousAudioId,defaultSubtitleId,lyricsId,audioName,audioDesc,audioGroupName,audioType,
		//contentType,artistName,albumName,songName,audioSize,durationMs,bitRateBPS,dataRateBPS,sampleRateKHZ,cntChannel,cntSection,
		//audioQuality,audioCompression,audioFormat,audioEncoding,
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSet.getMediaSetId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long audioId = rs.getLong("audioId");  	if (rs.wasNull()) {audioId = null;}
		    	Long mediaSetId = rs.getLong("mediaSetId");  	if (rs.wasNull()) {mediaSetId = null;}
		    	Long mediaFileId = rs.getLong("mediaFileId");  	if (rs.wasNull()) {mediaFileId = null;}
		    	Long sourceMediaId = rs.getLong("sourceMediaId");  	if (rs.wasNull()) {sourceMediaId = null;}
		    	Long videoId = rs.getLong("videoId");  	if (rs.wasNull()) {videoId = null;}
		    	Long rootAudioId = rs.getLong("rootAudioId");  	if (rs.wasNull()) {rootAudioId = null;}
		    	Long nextAudioId = rs.getLong("nextAudioId");  	if (rs.wasNull()) {nextAudioId = null;}
		    	Long previousAudioId = rs.getLong("previousAudioId");  	if (rs.wasNull()) {nextAudioId = null;}
		    	Long defaultSubtitleId = rs.getLong("defaultSubtitleId");  	if (rs.wasNull()) {defaultSubtitleId = null;}
		    	Long lyricsId = rs.getLong("lyricsId");  	if (rs.wasNull()) {lyricsId = null;}
		    	
		        String audioName = rs.getString("audioName");
		        String audioDesc = rs.getString("audioDesc");
		        String audioGroupName = rs.getString("audioGroupName");
		        String audioType = rs.getString("audioType");
		        String contentType = rs.getString("contentType");
		        String artistName = rs.getString("artistName");
		        String albumName = rs.getString("albumName");
		        String songName = rs.getString("songName");
		        
		        Long audioSize = rs.getLong("audioSize");  	if (rs.wasNull()) {audioSize = null;}
		        Long durationMs = rs.getLong("durationMs");  	if (rs.wasNull()) {durationMs = null;}
		        Double bitRateBPS = rs.getDouble("bitRateBPS");  	if (rs.wasNull()) {bitRateBPS = null;}
		        Double dataRateBPS = rs.getDouble("dataRateBPS");  	if (rs.wasNull()) {dataRateBPS = null;}
		        Double sampleRateKHZ = rs.getDouble("sampleRateKHZ");  	if (rs.wasNull()) {sampleRateKHZ = null;}
		        Long cntChannel = rs.getLong("cntChannel");  	if (rs.wasNull()) {cntChannel = null;}
			    Long cntSection = rs.getLong("cntSection");  	if (rs.wasNull()) {cntSection = null;}
		        String audioQuality = rs.getString("audioQuality");
		        String audioCompression = rs.getString("audioCompression");
		        String audioFormat = rs.getString("audioFormat");
		        String audioEncoding = rs.getString("audioEncoding");
		        
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    NodeAudio audio = new NodeAudio(audioId,mediaSetId,mediaFileId,sourceMediaId,videoId,
			    		rootAudioId,nextAudioId,previousAudioId,defaultSubtitleId,lyricsId,audioName,audioDesc,audioGroupName,audioType,
			    		contentType,artistName,albumName,songName,audioSize,durationMs,bitRateBPS,dataRateBPS,sampleRateKHZ,cntChannel,cntSection,
			    		audioQuality,audioCompression,audioFormat,audioEncoding,creationDate,modificationDate);
			    mediaSet.getListAudio().add(audio);
			    mediaSet.getMapId2Audio().put(audio.getAudioId(),audio);  
			    cntRead++;
		    }
		    System.out.println("readMediaSetTableAudio: cntRead = " + cntRead);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntRead);
	}
	public static NodeMediaSet readMediaSetTableMediaSet(Connection conn,long mediaSetId)	{
		NodeMediaSet mediaSet = null;
		String query = 	" SELECT mediaSetId,fileSetId,mediaSetName,mediaSetDesc,sourceName,sourceURL,cntMedia,sumMediaSize,avgMediaSize,"+
						" sourceFileSize,creationDate,modificationDate "+
						" FROM MED_MEDIASET WHERE mediaSetId= ? ORDER BY mediaSetId";
		//public NodeMediaSet(Long mediaSetId, Long fileSetId, String mediaSetName, String mediaSetDesc, String sourceName,
		//String sourceURL, Long cntMedia, Long sumMediaSize, Double avgMediaSize, Long sourceFileSize,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    ps.setLong(1, mediaSetId); 
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        Long mediaSetId2 = rs.getLong("mediaSetId");
		        Long fileSetId = rs.getLong("fileSetId");  	if (rs.wasNull()) {fileSetId = null;}
		        String mediaSetName = rs.getString("mediaSetName");
		        String mediaSetDesc = rs.getString("mediaSetDesc");
		        String sourceName = rs.getString("sourceName");
		        String sourceURL = rs.getString("sourceURL");
		        Long cntMedia = rs.getLong("cntMedia");  	if (rs.wasNull()) {cntMedia = null;}
		        Long sumMediaSize = rs.getLong("sumMediaSize");  	if (rs.wasNull()) {sumMediaSize = null;}
		        Double avgMediaSize = rs.getDouble("avgMediaSize");  	if (rs.wasNull()) {avgMediaSize = null;}
		        Long sourceFileSize = rs.getLong("sourceFileSize");  	if (rs.wasNull()) {sourceFileSize = null;}
		        String creationDateStr = rs.getString("creationDate");
		        String modificationDateStr = rs.getString("modificationDate");
			    ZonedDateTime creationDate = ((creationDateStr!=null) ? ZonedDateTime.parse(creationDateStr) : null);	
			    ZonedDateTime modificationDate = ((modificationDateStr!=null) ? ZonedDateTime.parse(modificationDateStr) : null);	
			    mediaSet = new NodeMediaSet(mediaSetId,fileSetId,mediaSetName,mediaSetDesc,sourceName,sourceURL,cntMedia,sumMediaSize,avgMediaSize,
						sourceFileSize,creationDate,modificationDate);
		    }
		    System.out.println("readMediaSetTableMediaSet: mediaSet = " + mediaSet);
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(mediaSet);
	}
	public static NodeMediaSet readMediaSet(Connection conn, long mediaSetId) {
		NodeMediaSet mediaSet = readMediaSetTableMediaSet(conn, mediaSetId);
		if (mediaSet==null) return (null);
		int cntReadImage = readMediaSetTableImage(conn,mediaSet);
		int cntReadMediaFile = readMediaSetTableMediaFile(conn,mediaSet);
		int cntReadMediaBlob = readMediaSetTableMediaBlob(conn,mediaSet);
		int cntReadMediaProp = readMediaSetTableMediaProp(conn,mediaSet);
		int cntReadVideo = readMediaSetTableVideo(conn,mediaSet);
		int cntReadFrame = readMediaSetTableFrame(conn,mediaSet);
		int cntReadAudio = readMediaSetTableAudio(conn,mediaSet);
		
		postProcessMediaSet(mediaSet);
		
		int cntRead = cntReadImage + cntReadMediaFile + cntReadMediaBlob + cntReadMediaProp + cntReadVideo + cntReadFrame + cntReadAudio + 1;
	    System.out.println("readMediaSetId: total recordS read = " + cntRead);
		return(mediaSet);
	}	
	public static void postProcessMediaSet(NodeMediaSet mediaSet)	{
		
		GetByMapMediaSet.updateAllMapsMediaSet(mediaSet);
		
	}
	public static NodeMediaSet readMediaSetTables(Connection conn, long mediaSetId)	{
		
		NodeMediaSet mediaSet = readMediaSet(conn,mediaSetId);
		if (mediaSet!=null)	{
			
			System.out.println("mediaSet.getListImage().size() = "+mediaSet.getListImage().size());
			System.out.println("mediaSet.getListImageFile().size() = "+mediaSet.getListMediaFile().size());
			System.out.println("mediaSet.getListImageBlob().size() = "+mediaSet.getListMediaBlob().size());
			
			System.out.println("mediaSet.getMapId2Image().size() = "+mediaSet.getMapId2Image().size());
			System.out.println("mediaSet.getMapId2ImageFile().size() = "+mediaSet.getMapId2MediaFile().size());
			System.out.println("mediaSet.getMapId2ImageBlob().size() = "+mediaSet.getMapId2MediaBlob().size());

		} else {
			System.out.println("readMediaSetTables: mediaSet is null");
		}
		return (mediaSet);
	}
	
}