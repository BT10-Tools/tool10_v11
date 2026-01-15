package tool10.mediaset;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Map;

import tool10.f10.NodeF10;
import tool10.mediaset.alg.NodeVideoProp;
import tool10.mediaset.alg.VideoProp;

public class MakeVideoProp {

	private static void addMp(ArrayList<NodeMediaProp> mpList, NodeF10 f10, Long mediaId, String mpType, String e, String pkg,  
			String propKey, String propValue, Long displayOrder, Long valueLong,
			Double valueDouble, Boolean valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,String[] valueStringArray, String valueType)	{
		
		String boolStr = (valueBoolean==null) ? null : Boolean.toString(valueBoolean); 
		if ("long".equals(valueType))	{
			mpList.add(MakeMediaSet.createOneMediaProp(f10,mediaId,mpType,e,pkg,propKey,Long.toString(valueLong),displayOrder,valueLong,
				valueDouble, boolStr, valueZDT, valueBytes,valueStringArray));
		} else if ("double".equals(valueType))	{
			mpList.add(MakeMediaSet.createOneMediaProp(f10,mediaId,mpType,e,pkg,propKey,Double.toString(valueDouble),displayOrder,valueLong,
					valueDouble, boolStr, valueZDT, valueBytes,valueStringArray));
		} else if ("boolean".equals(valueType))	{
			mpList.add(MakeMediaSet.createOneMediaProp(f10,mediaId,mpType,e,pkg,propKey,Boolean.toString(valueBoolean),displayOrder,valueLong,
					valueDouble, boolStr, valueZDT, valueBytes,valueStringArray));
		} else if ("string".equals(valueType))	{
			mpList.add(MakeMediaSet.createOneMediaProp(f10,mediaId,mpType,e,pkg,propKey,propValue,displayOrder,valueLong,
					valueDouble,  boolStr, valueZDT, valueBytes,valueStringArray));
		}
	}
	private static void addMaps2MpList(ArrayList<NodeMediaProp> mpList, NodeF10 f10, Long mediaId, String mpType, String e, String pkg,  
			NodeVideoProp videoProp)	{
		
		long idx = 0;
		if (videoProp.getOptions()!=null)	{  //entry.getKey()+"','" + entry.getValue()
			idx=0;
			for (Map.Entry<String, String> entry : videoProp.getOptions().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_options",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}
		if (videoProp.getVideoOptions()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, String> entry : videoProp.getVideoOptions().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_videoOptions",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}
		if (videoProp.getAudioOptions()!=null)	{
			idx = 0;
			for (Map.Entry<String, String> entry : videoProp.getAudioOptions().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_audioOptions",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}	
		if (videoProp.getMetadata()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, String> entry : videoProp.getMetadata().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_metadata",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}	
		if (videoProp.getVideoMetadata()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, String> entry : videoProp.getVideoMetadata().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_videoMetadata",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}	
		if (videoProp.getAudioMetadata()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, String> entry : videoProp.getAudioMetadata().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_audioMetadata",entry.getKey(),entry.getValue(),idx++,null,null,null,null,null,null,"string");
			}
		}	
		if (videoProp.getVideoSideData()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, java.nio.Buffer> entry : videoProp.getVideoSideData().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_videoSideData",entry.getKey(),entry.getValue().toString(),idx++,null,null,null,null,null,null,"string");
			}
		}	
		if (videoProp.getAudioSideData()!=null)	{
			idx = 0;
	    	for (Map.Entry<String, java.nio.Buffer> entry : videoProp.getAudioSideData().entrySet()) { 
				addMp(mpList,f10,mediaId,mpType,e,"ffmpeg_audioSideData",entry.getKey(),entry.getValue().toString(),idx++,null,null,null,null,null,null,"string");
			}
		}
		//Map<String, String> options = videoProp.getOptions();
		//Map<String, String> videoOptions = videoProp.getVideoOptions();
		//Map<String, String> audioOptions= videoProp.getAudioOptions();
		//Map<String, String> metadata = videoProp.getMetadata(); 
		//Map<String, String> videoMetadata = videoProp.getVideoMetadata();
		//Map<String, String> audioMetadata = videoProp.getAudioMetadata();
		//Map<String, java.nio.Buffer> videoSideData = videoProp.getVideoSideData();
		//Map<String, java.nio.Buffer> audioSideData = videoProp.getAudioSideData();
		
	}
	private static void processOneMediaPropFromVideoProp(NodeF10 f10, NodeVideo video, NodeVideoProp videoProp)	{
		
		String videoPropName = "test";
		Long mediaId = video.getVideoId();
		String mpType = "javacv_ffmpeg"; //mediaPropType
		String e = "javacv"; //engineName 
		String pkg = "ffmpeg"; //propKeyGroup
		long idx = 0;
		ArrayList<NodeMediaProp> mpList = new ArrayList<NodeMediaProp>();
		
		addMp(mpList,f10,mediaId,mpType,e,pkg,"videoStream",null,idx++,(long) videoProp.getVideoStream(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioStream",null,idx++,(long) videoProp.getAudioStream(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"videoDisposition",null,idx++,(long) videoProp.getVideoDisposition(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioDisposition",null,idx++,(long) videoProp.getAudioDisposition(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"imageWidth",null,idx++,(long) videoProp.getImageWidth(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"imageHeight",null,idx++,(long) videoProp.getImageHeight(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioChannels",null,idx++,(long) videoProp.getAudioChannels(),null,null,null,null,null,"long");  
		addMp(mpList,f10,mediaId,mpType,e,pkg,"pixelFormat",null,idx++,(long) videoProp.getPixelFormat(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"videoCodec",null,idx++,(long) videoProp.getVideoCodec(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"videoBitrate",null,idx++,(long) videoProp.getVideoBitrate(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"imageScalingFlags",null,idx++,(long) videoProp.getImageScalingFlags(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"sampleFormat",null,idx++,(long) videoProp.getSampleFormat(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioCodec",null,idx++,(long) videoProp.getAudioCodec(),null,null,null,null,null,"long");  
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioBitrate",null,idx++,(long) videoProp.getAudioBitrate(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"sampleRate",null,idx++,(long) videoProp.getSampleRate(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"bpp ",null,idx++,(long) videoProp.getBitsPerPixel(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"timeout",null,idx++,(long) videoProp.getTimeout(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"numBuffers",null,idx++,(long) videoProp.getNumBuffers(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"frameNumber",null,idx++,(long) videoProp.getFrameNumber(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"maxDelay",null,idx++,(long) videoProp.getMaxDelay(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"lengthInFrames",null,idx++,(long) videoProp.getLengthInFrames(),null,null,null,null,null,"long");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"sensorPattern",null,idx++,(long) videoProp.getSensorPattern(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"timestamp",null,idx++,(long) videoProp.getTimestamp(),null,null,null,null,null,"long"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"startTime",null,idx++,(long) videoProp.getStartTime(),null,null,null,null,null,"long");
				
		addMp(mpList,f10,mediaId,mpType,e,pkg,"aspectRatio",null,idx++,null,videoProp.getAspectRatio(),null,null,null,null,"double");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"frameRate",null,idx++,null,videoProp.getFrameRate(),null,null,null,null,"double");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"gamma",null,idx++,null,videoProp.getGamma(),null,null,null,null,"double");
		
		addMp(mpList,f10,mediaId,mpType,e,pkg,"triggerMode",null,idx++,null,null,videoProp.isTriggerMode(),null,null,null,"boolean"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"deinterlace",null,idx++,null,null,videoProp.isDeinterlace(),null,null,null,"boolean");
		
		addMp(mpList,f10,mediaId,mpType,e,pkg,"format",videoProp.getFormat(),idx++,null,null,null,null,null,null,"string"); 
		addMp(mpList,f10,mediaId,mpType,e,pkg,"videoCodecName",videoProp.getVideoCodecName(),idx++,null,null,null,null,null,null,"string");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"audioCodecName",videoProp.getAudioCodecName(),idx++,null,null,null,null,null,null,"string");
		
		addMp(mpList,f10,mediaId,mpType,e,pkg,"imageMode",videoProp.getImageMode().toString(),idx++,null,null,null,null,null,null,"string");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"sampleMode",videoProp.getSampleMode().toString(),idx++,null,null,null,null,null,null,"string");
		addMp(mpList,f10,mediaId,mpType,e,pkg,"charset",videoProp.getCharset().displayName(),idx++,null,null,null,null,null,null,"string");
		
		addMaps2MpList(mpList,f10,mediaId,mpType,e,pkg,videoProp);
		        
		//public static NodeMediaProp createOneMediaProp(NodeF10 f10, Long mediaId, String mediaPropType,
		//	String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
		//	Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,String[] valueStringArray);
	}
	public static void processOneVideo(NodeF10 f10, NodeVideo video)	{
		String videoFileName = video.getRefMediaFile().getSourceAbsolutePath();  
		NodeVideoProp videoProp = VideoProp.getVideoProp(video.getVideoId(),videoFileName);
		String videoPropStr = videoProp.getPrintString();
		
		//System.out.println("\n"+"*".repeat(80)+"\n"+videoFileName+"\n"+videoPropStr);	
		//public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, Long rootVideoId,
		//		Long nextVideoId, Long previousVideoId, Long defaultSubtitleId, String videoName, String videoDesc,
		//		String videoGroupName, String videoType, String colorModel, Long videoSize, Long sizeX, Long sizeY,
		//		Long pixelNum, Double aspectRatio, Long durationMs, Double fps, Double dataRateBPS, Long cntFrame,
		//		Long cntSection, String videoQuality, String videoCompression, String videoFormat, String videoEncoding,
		//		ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		//public NodeVideo(Long videoId, Long mediaSetId, Long mediaFileId, Long sourceMediaId, String videoName, String videoDesc,
		//		String videoGroupName, String videoType, Long videoSize, ZonedDateTime creationDate) {
		
		String colorModel = videoProp.getImageMode().toString(); 
		Long sizeX = (long) videoProp.getImageWidth(); 
		Long sizeY = (long) videoProp.getImageHeight();
		Long pixelNum = ((sizeX==null) || (sizeY==null)) ? null : sizeX *  sizeY; 
		Double aspectRatio = videoProp.getAspectRatio(); 
		Long durationMs = null; 
		Double fps = videoProp.getFrameRate(); 
		Double dataRateBPS = null; 
		Long cntFrame = (long) videoProp.getLengthInFrames();
		Long cntSection = null; 
		String videoQuality = null; 
		String videoCompression = null; 
		String videoFormat = videoProp.getFormat();
		String videoEncoding = videoProp.getVideoCodecName();
		
		video.updateFields01(colorModel,sizeX,sizeY,pixelNum,aspectRatio,durationMs,   
				fps,dataRateBPS,cntFrame,cntSection,videoQuality,videoCompression,videoFormat,videoEncoding);
		
		processOneMediaPropFromVideoProp(f10, video, videoProp);
	}		
}
