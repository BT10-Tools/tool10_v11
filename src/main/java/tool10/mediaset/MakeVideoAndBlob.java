package tool10.mediaset;

import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.GetByMapFileSet;

public class MakeVideoAndBlob {

	public static NodeMediaBlob createOneMediaBlobFromVideo(NodeF10 f10, NodeVideo video, Long fileBlobId)	{
		Long videoId = video.getVideoId();
		String mediaType = "video";  
		String blobType = "videobytes"; 
		byte[] mediaBytes = null; // FileUtil.getBytes(filename);

		NodeMediaBlob mediaBlob = MakeMediaSet.createOneMediaBlob(f10, videoId, mediaType, blobType, mediaBytes, fileBlobId);
		f10.getMediaSet().getListMediaBlob().add(mediaBlob);
		f10.getMediaSet().getMapId2MediaBlob().put(mediaBlob.getMediaBlobId(), mediaBlob);
		video.setRefMediaBlob(mediaBlob);
		return(mediaBlob);		
	}	
	public static NodeVideo createOneVideoFromFile(NodeF10 f10, NodeMediaFile mediaFile)	{ 
		Long videoId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGE"
		String videoName = mediaFile.getSourceFileName();
		String videoDesc = null;
		String videoType = mediaFile.getMediaFileType();
		Long videoSize = mediaFile.getSourceFileSize();
		ZonedDateTime creationDate = ZonedDateTime.now();
		
		//	public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, String videoName, String videoDesc,
		//String videoGroupName, String videoType, Long videoSize, ZonedDateTime creationDate) {
		NodeVideo video = new NodeVideo(videoId, mediaFile.getMediaSetId(), mediaFile.getMediaFileId(), null, videoName, videoDesc, 
				null, videoType, videoSize, creationDate);
		f10.getMediaSet().getListVideo().add(video);
		f10.getMediaSet().getMapId2Video().put(video.getVideoId(), video);
		video.setRefMediaFile(mediaFile);
		return(video);
	}
	public static void createVideoAndBlob(NodeF10 f10)	{
		for (NodeMediaFile mediaFile : f10.getMediaSet().getListMediaFile())	{
			Long fileBlobId = GetByMapFileSet.getFileBlobId4FileId(f10,mediaFile.getFileId()); 
			NodeVideo video = createOneVideoFromFile(f10, mediaFile);
			NodeMediaBlob mediaBlob = createOneMediaBlobFromVideo(f10,video, fileBlobId);
			MakeVideoProp.processOneVideo(f10, video);
		}
	}	
	
}
