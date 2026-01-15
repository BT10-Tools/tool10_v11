package tool10.mediaset.alg;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber.ImageMode;
import org.bytedeco.javacv.FrameGrabber.SampleMode;

import java.io.File;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.Map;

public class VideoProp {

	public static NodeVideoProp getVideoProp(Long videoId, String inputPath) {
		// Basic input validation
		File inputFile = new File(inputPath);
		if (!inputFile.exists() || !inputFile.canRead()) {
			throw new IllegalArgumentException("Input file does not exist or cannot be read: " + inputPath);
		}
		NodeVideoProp  videoProp = null; 
        // Use try-with-resources for automatic resource management
		try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputPath)) {
			grabber.start(); // Open the input video file
			
			int totalFrames;
			double frameRate2;
				 
			// First pass to get essential video properties using try-with-resources
				    
			totalFrames = grabber.getLengthInFrames();
			frameRate2 = grabber.getFrameRate();
			if (frameRate2 <= 0) { // Fallback calculation
				frameRate2 = (double) totalFrames / (grabber.getLengthInTime() / 1_000_000.0);
				if (frameRate2 <= 0) {
					throw new RuntimeException("Could not determine frame rate for input video.");
				}
			}
			
			//public NodeVideoProp(String videoPropName, int videoStream, int audioStream, int videoDisposition,
			//		int audioDisposition, String format, String videoCodecName, String audioCodecName, int imageWidth,
			//		int imageHeight, int audioChannels, ImageMode imageMode, long sensorPattern, int pixelFormat,
			//		int videoCodec, int videoBitrate, int imageScalingFlags, double aspectRatio, double frameRate,
			//		enumSampleMode sampleMode, int sampleFormat, int audioCodec, int audioBitrate, int sampleRate,
			//		boolean triggerMode, int bpp, int timeout, int numBuffers, double gamma, boolean deinterlace,
			//		Charset charset, int frameNumber, long timestamp, int maxDelay, long startTime, int lengthInFrames) 
				
			Long videoPropId = null;
			Long videoSetId = null;
			String videoPropName = "test";
			Long videoStream = (long) grabber.getVideoStream();
			Long audioStream = (long) grabber.getAudioStream();
			Long videoDisposition = (long) grabber.getVideoDisposition();
			Long audioDisposition = (long) grabber.getAudioDisposition();
			String format = grabber.getFormat(); 
			String videoCodecName = grabber.getVideoCodecName();
			String audioCodecName = grabber.getAudioCodecName();
			Long imageWidth = (long) grabber.getImageWidth();
			Long imageHeight = (long) grabber.getImageHeight();
			Long audioChannels = (long) grabber.getAudioChannels();  
			ImageMode imageMode = grabber.getImageMode();
			Long sensorPattern = (long) grabber.getSensorPattern(); 
			Long pixelFormat = (long) grabber.getPixelFormat();
			Long videoCodec = (long) grabber.getVideoCodec(); 
			Long videoBitrate = (long) grabber.getVideoBitrate();
			Long imageScalingFlags = (long) grabber.getImageScalingFlags();
			Double aspectRatio = grabber.getAspectRatio();
			Double frameRate = grabber.getFrameRate();
			SampleMode sampleMode = grabber.getSampleMode(); 
			Long sampleFormat = (long) grabber.getSampleFormat();
			Long audioCodec = (long) grabber.getAudioCodec();  
			Long audioBitrate = (long) grabber.getAudioBitrate(); 
			Long sampleRate = (long) grabber.getSampleRate();
			Boolean triggerMode = grabber.isTriggerMode(); 
			Long bpp  = (long) grabber.getBitsPerPixel(); 
			Long timeout = (long) grabber.getTimeout(); 
			Long numBuffers = (long) grabber.getNumBuffers(); 
			Double gamma = grabber.getGamma();
			Boolean deinterlace = grabber.isDeinterlace();
			Charset charset = grabber.getCharset(); 
			Long frameNumber = (long) grabber.getFrameNumber();
			Long timestamp = (long) grabber.getTimestamp(); 
			Long maxDelay = (long) grabber.getMaxDelay(); 
			Long startTime = -1l; 
			Long lengthInFrames = (long) grabber.getLengthInFrames();
			
			videoProp = new NodeVideoProp(videoPropId,videoSetId,videoId,videoPropName, videoStream, audioStream, videoDisposition,
				audioDisposition, format, videoCodecName, audioCodecName, imageWidth,
				imageHeight, audioChannels, imageMode, sensorPattern, pixelFormat,
				videoCodec, videoBitrate, imageScalingFlags, aspectRatio, frameRate,
				sampleMode, sampleFormat, audioCodec, audioBitrate, sampleRate,
				triggerMode, bpp, timeout, numBuffers, gamma, deinterlace,
				charset, frameNumber, timestamp, maxDelay, startTime, lengthInFrames, ZonedDateTime.now(),null); 
				
			// public void updateMaps(Map<String, String> options, Map<String, String> videoOptions,
			//			Map<String, String> audioOptions, Map<String, String> metadata, Map<String, String> videoMetadata,
			//			Map<String, String> audioMetadata, Map<String, Buffer> videoSideData, Map<String, Buffer> audioSideData) {
			Map<String, String> options = grabber.getOptions();
			Map<String, String> videoOptions = grabber.getVideoOptions();
			Map<String, String> audioOptions= grabber.getAudioOptions();
			Map<String, String> metadata = grabber.getMetadata(); 
			Map<String, String> videoMetadata = grabber.getVideoMetadata();
			Map<String, String> audioMetadata = grabber.getAudioMetadata();
			Map<String, java.nio.Buffer> videoSideData = grabber.getVideoSideData();
			Map<String, java.nio.Buffer> audioSideData = grabber.getAudioSideData();
			
			videoProp.updateMaps(options, videoOptions,  audioOptions, metadata, videoMetadata,
						audioMetadata, videoSideData, audioSideData);
								
		//	System.out.print("imageWidth:"+imageWidth+"  ,imageHeight:"+imageHeight+"  ,audioChannels:"+audioChannels+
		//		"  ,videoCodec:"+videoCodec+"  ,audioCodec:"+audioCodec+"  ,sampleRate:"+sampleRate+"  ,audioBitrate:"+audioBitrate+"\n"+
		//		"  ,videoBitrate:"+videoBitrate+"   ,totalFrames:"+totalFrames+ " ,frameRate:"+frameRate);
			
		} catch	(Exception e)	{
			return(null);
		}
		return(videoProp);
	}
  
	public static void main(String[] args) {
		try {
			String fileName ="C:\\tmp\\similarity\\10_Media\\01_video\\Sibel Can - Lale Devri.mp4";
			
			Long videoId = -1l;
			getVideoProp(videoId,fileName); //"input.mp4", "output/segment"
			System.out.println("Video splitting completed successfully.");
			
		} catch (Exception e) {
			System.err.println("Video splitting failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
