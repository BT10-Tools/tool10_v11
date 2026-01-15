package tool10.mediaset.alg;

import org.bytedeco.javacv.FrameGrabber.ImageMode;
import org.bytedeco.javacv.FrameGrabber.SampleMode;

import java.nio.charset.Charset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class NodeVideoProp {

    public NodeVideoProp(Long videoPropId,Long videoId, Long videoSetId, String videoPropName, Long videoStream, Long audioStream, Long videoDisposition,
			Long audioDisposition, String format, String videoCodecName, String audioCodecName, Long imageWidth,
			Long imageHeight, Long audioChannels, ImageMode imageMode, Long sensorPattern, Long pixelFormat,
			Long videoCodec, Long videoBitrate, Long imageScalingFlags, Double aspectRatio, Double frameRate,
			SampleMode sampleMode, Long sampleFormat, Long audioCodec, Long audioBitrate, Long sampleRate,
			Boolean triggerMode, Long bpp, Long timeout, Long numBuffers, Double gamma, Boolean deinterlace,
			Charset charset, Long frameNumber, Long timestamp, Long maxDelay, Long startTime, Long lengthInFrames, 
			ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		super();
		this.videoPropId = videoPropId;
		this.videoId = videoId;
		this.videoSetId = videoSetId;
		this.videoPropName = videoPropName;
		this.videoStream = videoStream;
		this.audioStream = audioStream;
		this.videoDisposition = videoDisposition;
		this.audioDisposition = audioDisposition;
		this.format = format;
		this.videoCodecName = videoCodecName;
		this.audioCodecName = audioCodecName;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.audioChannels = audioChannels;
		this.imageMode = imageMode;
		this.sensorPattern = sensorPattern;
		this.pixelFormat = pixelFormat;
		this.videoCodec = videoCodec;
		this.videoBitrate = videoBitrate;
		this.imageScalingFlags = imageScalingFlags;
		this.aspectRatio = aspectRatio;
		this.frameRate = frameRate;
		this.sampleMode = sampleMode;
		this.sampleFormat = sampleFormat;
		this.audioCodec = audioCodec;
		this.audioBitrate = audioBitrate;
		this.sampleRate = sampleRate;
		this.triggerMode = triggerMode;
		this.bpp = bpp;
		this.timeout = timeout;
		this.numBuffers = numBuffers;
		this.gamma = gamma;
		this.deinterlace = deinterlace;
		this.charset = charset;
		this.frameNumber = frameNumber;
		this.timestamp = timestamp;
		this.maxDelay = maxDelay;
		this.startTime = startTime;
		this.lengthInFrames = lengthInFrames;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
    public void updateMaps(Map<String, String> options, Map<String, String> videoOptions,
			Map<String, String> audioOptions, Map<String, String> metadata, Map<String, String> videoMetadata,
			Map<String, String> audioMetadata, Map<String, java.nio.Buffer> videoSideData, Map<String, java.nio.Buffer> audioSideData) {
		this.options = options;
		this.videoOptions = videoOptions;
		this.audioOptions = audioOptions;
		this.metadata = metadata;
		this.videoMetadata = videoMetadata;
		this.audioMetadata = audioMetadata;
		this.videoSideData = videoSideData;
		this.audioSideData = audioSideData;
	}
	private static final String[] classArr = new String[] {"DC1394", "FlyCapture", "FlyCapture2", "OpenKinect", "OpenKinect2", 
    		"RealSense", "RealSense2", "PS3Eye", "VideoInput", "OpenCV", "FFmpeg", "IPCamera" };

    //private static enum enumImageMode {COLOR, GRAY, RAW };
    //private static enum SampleMode {SHORT, FLOAT, RAW};

    public static final Long SENSOR_PATTERN_RGGB = 0l;
    public static final Long SENSOR_PATTERN_GBRG = (1L << 32);
    public static final Long SENSOR_PATTERN_GRBG = 1l; 
    public static final Long SENSOR_PATTERN_BGGR = (1L << 32) | 1;

    private Long videoPropId;
    private Long videoId;
    private Long videoSetId;
    private String videoPropName;
    
    private Long videoStream;
    private Long audioStream;
    private Long videoDisposition;
    private Long audioDisposition;
    private String format;
    private String videoCodecName;
    private String audioCodecName;
    private Long imageWidth;
    private Long imageHeight;
    private Long audioChannels;
    private ImageMode imageMode = ImageMode.COLOR;
    private Long sensorPattern;
    private Long pixelFormat;
    private Long videoCodec;
    private Long videoBitrate; 
    private Long imageScalingFlags;
    private double aspectRatio;
    private double frameRate;
    private SampleMode sampleMode = SampleMode.SHORT;
    private Long sampleFormat;  
    private Long audioCodec; 
    private Long audioBitrate;
    private Long sampleRate;
    private Boolean triggerMode;
    private Long bpp;
    private Long timeout;
    private Long numBuffers;
    private Double gamma;
    private boolean deinterlace = false;
    private Charset charset = Charset.defaultCharset();
    private Map<String, String> options = new HashMap<String, String>();
    private Map<String, String> videoOptions = new HashMap<String, String>();
    private Map<String, String> audioOptions = new HashMap<String, String>();
    private Map<String, String> metadata = new HashMap<String, String>();
    private Map<String, String> videoMetadata = new HashMap<String, String>();
    private Map<String, String> audioMetadata = new HashMap<String, String>();
    private Map<String, java.nio.Buffer> videoSideData = new HashMap<>();
    private Map<String, java.nio.Buffer> audioSideData = new HashMap<>();
    private Long frameNumber;
    private Long timestamp;
    private Long maxDelay;
    private Long startTime;
    private Long lengthInFrames;
    
    private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
    
	public String getPrintString()	{
    	StringBuilder sb = new StringBuilder();
    	sb.append(
    		"videoId :" + videoId + "\n" +
    		"videoStream :" + videoStream + "\n" +
            "audioStream :" + audioStream  + "\n" +
	        "videoDisposition :" + videoDisposition  + "\n" +
	        "audioDisposition :" + audioDisposition + "\n" +
	        "format :'" + format + "'\n" +
	        "videoCodecName :'" + videoCodecName + "'\n" +
	        "audioCodecName :'" + audioCodecName + "'\n" +
	        "imageWidth :" + imageWidth + "\n" +
	        "imageHeight :" + imageHeight + "\n" +
	        "audioChannels :" + audioChannels + "\n" +
	        "imageMode :'" + imageMode + "'\n" +
	        "sensorPattern :" + sensorPattern + "\n" +
	        "pixelFormat :" + pixelFormat + "\n" +
	        "videoCodec :" + videoCodec + "\n" +
	        "videoBitrate :" + videoBitrate + "\n" +
	        "imageScalingFlags :" + imageScalingFlags + "\n" +
	        "aspectRatio :" + aspectRatio + "\n" +
	        "frameRate :" + frameRate + "\n" +
	        "sampleMode :" + sampleMode + "\n" +
	        "sampleFormat :" + sampleFormat + "\n" +
	        "audioCodec :" + audioCodec + "\n" +
	        "audioBitrate :" + audioBitrate + "\n" +
	        "sampleRate :" + sampleRate + "\n" +
	        "triggerMode :" + triggerMode + "\n" +
	        "bpp :" + bpp + "\n" +
	        "timeout :" + timeout + "\n" +
	        "numBuffers :" + numBuffers + "\n" +
	        "gamma :" + gamma + "\n" +
	        "deinterlace :" + deinterlace + "\n" +
	        "charset :" + charset + "\n" +
	        "frameNumber :" + frameNumber + "\n" +
	        "timestamp :" + timestamp + "\n" +
	        "maxDelay :" + maxDelay + "\n" +
	        "startTime :" + startTime + "\n" +
	        "lengthInFrames :" + lengthInFrames + "\n");
    	int i=0;
    	if (options!=null)	{ 
    		sb.append("\nmap:options [size="+options.size()+"]: "); i=0;
    		for (Map.Entry<String, String> entry : options.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}
    	if (videoOptions!=null)	{
	    	sb.append("\nmap:videoOptions [size="+videoOptions.size()+"]:"); i=0;
	    	for (Map.Entry<String, String> entry : videoOptions.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}
    	if (audioOptions!=null)	{
    		sb.append("\nmap:audioOptions [size="+audioOptions.size()+"]:" ); i=0;
	    	for (Map.Entry<String, String> entry : audioOptions.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}	
    	if (metadata!=null)	{
	    	sb.append("\nmap:metadata [size="+metadata.size()+"]:"); i=0;
	    	for (Map.Entry<String, String> entry : metadata.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}	
    	if (videoMetadata!=null)	{
	    	sb.append("\nmap:videoMetadata [size="+videoMetadata.size()+"]:"); i=0;
	    	for (Map.Entry<String, String> entry : videoMetadata.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}	
    	if (audioMetadata!=null)	{
	    	sb.append("\nmap:audioMetadata [size="+audioMetadata.size()+"]:"); i=0;
	    	for (Map.Entry<String, String> entry : audioMetadata.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}	
    	if (videoSideData!=null)	{
	    	sb.append("\nmap:videoSideData [size="+videoSideData.size()+"]:"); i=0;
	    	for (Map.Entry<String, java.nio.Buffer> entry : videoSideData.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}	
    	if (audioSideData!=null)	{
	    	sb.append("\nmap:audioSideData [size="+audioSideData.size()+"]:"); i=0;
	    	for (Map.Entry<String, java.nio.Buffer> entry : audioSideData.entrySet()) { sb.append ("['"+entry.getKey()+"','" + entry.getValue()+"'],"); if ((++i % 50)==0) sb.append("\n");}
    	}
	    sb.append("\n");
    	return(sb.toString());
    }
    public Long getVideoStream() {
        return videoStream;
    }
    public Long getAudioStream() {
        return audioStream;
    }
    public Long getVideoDisposition() {
        return videoDisposition;
    }
    public Long getAudioDisposition() {
        return audioDisposition;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getVideoCodecName() {
        return videoCodecName;
    }
    public void setVideoCodecName(String videoCodecName) {
        this.videoCodecName = videoCodecName;
    }

    public String getAudioCodecName() {
        return audioCodecName;
    }
    public void setAudioCodecName(String audioCodecName) {
        this.audioCodecName = audioCodecName;
    }

    public Long getImageWidth() {
        return imageWidth;
    }
    public void setImageWidth(Long imageWidth) {
        this.imageWidth = imageWidth;
    }

    public Long getImageHeight() {
        return imageHeight;
    }
    public void setImageHeight(Long imageHeight) {
        this.imageHeight = imageHeight;
    }

    public Long getAudioChannels() {
        return audioChannels;
    }
    public void setAudioChannels(Long audioChannels) {
        this.audioChannels = audioChannels;
    }

    public ImageMode getImageMode() {
        return imageMode;
    }
    public void setImageMode(ImageMode imageMode) {
        this.imageMode = imageMode;
    }

    public Long getSensorPattern() {
        return sensorPattern;
    }
    public void setSensorPattern(Long sensorPattern) {
        this.sensorPattern = sensorPattern;
    }

    public Long getPixelFormat() {
        return pixelFormat;
    }
    public void setPixelFormat(Long pixelFormat) {
        this.pixelFormat = pixelFormat;
    }

    public Long getVideoCodec() {
        return videoCodec;
    }
    public void setVideoCodec(Long videoCodec) {
        this.videoCodec = videoCodec;
    }

    public Long getVideoBitrate() {
        return videoBitrate;
    }
    public void setVideoBitrate(Long videoBitrate) {
        this.videoBitrate = videoBitrate;
    }

    public Long getImageScalingFlags() {
        return imageScalingFlags;
    }
    public void setImageScalingFlags(Long imageScalingFlags) {
        this.imageScalingFlags = imageScalingFlags;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }
    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public double getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(double frameRate) {
        this.frameRate = frameRate;
    }

    public Long getAudioCodec() {
        return audioCodec;
    }
    public void setAudioCodec(Long audioCodec) {
        this.audioCodec = audioCodec;
    }

    public Long getAudioBitrate() {
        return audioBitrate;
    }
    public void setAudioBitrate(Long audioBitrate) {
        this.audioBitrate = audioBitrate;
    }

    public Long getSampleFormat() {
        return sampleFormat;
    }
    public void setSampleFormat(Long sampleFormat) {
        this.sampleFormat = sampleFormat;
    }

    public Long getSampleRate() {
        return sampleRate;
    }
    public void setSampleRate(Long sampleRate) {
        this.sampleRate = sampleRate;
    }

    public boolean isTriggerMode() {
        return triggerMode;
    }
    public void setTriggerMode(boolean triggerMode) {
        this.triggerMode = triggerMode;
    }

    public Long getBitsPerPixel() {
        return bpp;
    }
    public void setBitsPerPixel(Long bitsPerPixel) {
        this.bpp = bitsPerPixel;
    }

    public Long getTimeout() {
        return timeout;
    }
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Long getNumBuffers() {
        return numBuffers;
    }
    public void setNumBuffers(Long numBuffers) {
        this.numBuffers = numBuffers;
    }

    public double getGamma() {
        return gamma;
    }
    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    public boolean isDeinterlace() {
        return deinterlace;
    }
    public void setDeinterlace(boolean deinterlace) {
        this.deinterlace = deinterlace;
    }

    public Charset getCharset() {
        return charset;
    }
    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public Map<String, String> getOptions() {
        return options;
    }
    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public Map<String, String> getVideoOptions() {
        return videoOptions;
    }
    public void setVideoOptions(Map<String, String> options) {
        this.videoOptions = options;
    }

    public Map<String, String> getAudioOptions() {
        return audioOptions;
    }
    public void setAudioOptions(Map<String, String> options) {
        this.audioOptions = options;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public Map<String, String> getVideoMetadata() {
        return videoMetadata;
    }
    public void setVideoMetadata(Map<String, String> metadata) {
        this.videoMetadata = metadata;
    }

    public Map<String, String> getAudioMetadata() {
        return audioMetadata;
    }
    public void setAudioMetadata(Map<String, String> metadata) {
        this.audioMetadata = metadata;
    }

    public String getOption(String key) {
        return options.get(key);
    }
    public void setOption(String key, String value) {
        options.put(key, value);
    }

    public String getVideoOption(String key) {
        return videoOptions.get(key);
    }
    public void setVideoOption(String key, String value) {
        videoOptions.put(key, value);
    }

    public String getAudioOption(String key) {
        return audioOptions.get(key);
    }
    public void setAudioOption(String key, String value) {
        audioOptions.put(key, value);
    }

    public String getMetadata(String key) {
        return metadata.get(key);
    }
    public void setMetadata(String key, String value) {
        metadata.put(key, value);
    }

    public String getVideoMetadata(String key) {
        return videoMetadata.get(key);
    }
    public void setVideoMetadata(String key, String value) {
        videoMetadata.put(key, value);
    }

    public String getAudioMetadata(String key) {
        return audioMetadata.get(key);
    }
    public void setAudioMetadata(String key, String value) {
        audioMetadata.put(key, value);
    }
    public Long getFrameNumber() {
        return frameNumber;
    }
    public void setFrameNumber(Long frameNumber) {
        this.frameNumber = frameNumber;
    }

    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp)  {
        this.timestamp = timestamp;
    }

    public Long getMaxDelay() {
        return maxDelay;
    }
    public void setMaxDelay(Long maxDelay) {
        this.maxDelay = maxDelay;
    }

    public int getLengthInFrames() {
        return 0;
    }
    public Long getLengthInTime() {
        return 0l;
    }
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public void setLengthInFrames(Long lengthInFrames) {
		this.lengthInFrames = lengthInFrames;
	}
	public Map<String, java.nio.Buffer> getVideoSideData() {
		return videoSideData;
	}
	public void setVideoSideData(Map<String, java.nio.Buffer> videoSideData) {
		this.videoSideData = videoSideData;
	}
	public Map<String, java.nio.Buffer> getAudioSideData() {
		return audioSideData;
	}
	public void setAudioSideData(Map<String, java.nio.Buffer> audioSideData) {
		this.audioSideData = audioSideData;
	}
	public SampleMode getSampleMode() {
		return sampleMode;
	}
	public void setSampleMode(SampleMode sampleMode) {
		this.sampleMode = sampleMode;
	}
	public String getVideoPropName() {
		return videoPropName;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public Long getVideoPropId() {
		return videoPropId;
	}
	public Long getVideoSetId() {
		return videoSetId;
	}

    
}
