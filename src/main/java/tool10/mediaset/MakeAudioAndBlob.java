package tool10.mediaset;

import java.time.ZonedDateTime;

import tool10.f10.NodeF10;
import tool10.fileset.GetByMapFileSet;

public class MakeAudioAndBlob {

	public static NodeMediaBlob createOneMediaBlobFromAudio(NodeF10 f10, NodeAudio audio, Long fileBlobId)	{
		Long audioId = audio.getVideoId();
		String mediaType = "audio";  
		String blobType = "audiobytes"; 
		byte[] mediaBytes = null; // FileUtil.getBytes(filename);

		NodeMediaBlob mediaBlob = MakeMediaSet.createOneMediaBlob(f10, audioId, mediaType, blobType, mediaBytes, fileBlobId);
		f10.getMediaSet().getListMediaBlob().add(mediaBlob);
		f10.getMediaSet().getMapId2MediaBlob().put(mediaBlob.getMediaBlobId(), mediaBlob);
		audio.setRefMediaBlob(mediaBlob);
		return(mediaBlob);		
	}	
	public static NodeAudio createOneAudioFromFile(NodeF10 f10, NodeMediaFile mediaFile)	{ 
		Long audioId = f10.getConnMedia().getNextId(-1); //"IMG_IMAGE"
		String audioName = mediaFile.getSourceFileName();
		String audioDesc = null;
		String audioType = mediaFile.getMediaFileType();
		Long audioSize = mediaFile.getSourceFileSize();
		Long durationMs = null;
		ZonedDateTime creationDate = ZonedDateTime.now();
		
		//public NodeAudio(Long audioId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long videoId, String audioName, String audioDesc, 
		//String audioGroupName, String audioType, String contentType, Long audioSize, Long durationMs, ZonedDateTime creationDate) {
		NodeAudio audio = new NodeAudio(audioId, mediaFile.getMediaSetId(), mediaFile.getMediaFileId(), null, null, audioName, audioDesc, 
				null, audioType, null, audioSize, null, creationDate);
		f10.getMediaSet().getListAudio().add(audio);
		f10.getMediaSet().getMapId2Audio().put(audio.getAudioId(), audio);
		audio.setRefMediaFile(mediaFile);
		return(audio);
	}
	public static void createAudioAndBlob(NodeF10 f10)	{
		for (NodeMediaFile mediaFile : f10.getMediaSet().getListMediaFile())	{
			Long audioBlobId = GetByMapFileSet.getFileBlobId4FileId(f10,mediaFile.getFileId()); 
			NodeAudio audio = createOneAudioFromFile(f10, mediaFile);
			NodeMediaBlob mediaBlob = createOneMediaBlobFromAudio(f10,audio, mediaFile.getMediaFileId());
			//MakeAudioProp.processOneAudio(f10, audio);
		}
	}	
	
}
