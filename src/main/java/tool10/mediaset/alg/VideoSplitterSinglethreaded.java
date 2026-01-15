package tool10.mediaset.alg;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import java.io.File;

public class VideoSplitterSinglethreaded {

		  
  public static void splitVideo(String inputPath, String outputPrefix, int segmentDurationSeconds) throws Exception {
    // Basic input validation
    File inputFile = new File(inputPath);
    if (!inputFile.exists() || !inputFile.canRead()) {
        throw new IllegalArgumentException("Input file does not exist or cannot be read: " + inputPath);
    }
    if (segmentDurationSeconds <= 0) {
        throw new IllegalArgumentException("Segment duration must be positive.");
    }
    File outputDir = new File(outputPrefix).getParentFile();
    if (outputDir != null && !outputDir.exists()) {
        if (!outputDir.mkdirs()) {
            System.err.println("Warning: Could not create output directory: " + outputDir.getAbsolutePath());
            // Decide if this is a critical error
        }
    }

    // Use try-with-resources for automatic resource management
    try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputPath)) {
      grabber.start(); // Open the input video file

      double frameRate = grabber.getFrameRate();
      // Fallback if frame rate is not directly available
      if (frameRate <= 0) {
          frameRate = (double) grabber.getLengthInFrames() / (grabber.getLengthInTime() / 1_000_000.0);
          if (frameRate <= 0) {
              throw new RuntimeException("Could not determine frame rate for input video.");
          }
      }

      int framesPerSegment = (int) Math.round(frameRate * segmentDurationSeconds);
      if (framesPerSegment <= 0) {
          throw new IllegalArgumentException("Calculated frames per segment is zero or negative. Check frame rate and segment duration.");
      }

      int segmentCount = 0;
      int frameCount = 0;
      FFmpegFrameRecorder recorder = null;
      Frame frame;

      try {
        // Grab frames one by one
        while ((frame = grabber.grab()) != null) {
          // Start a new segment recorder if needed
          if (frameCount % framesPerSegment == 0) {
            if (recorder != null) {
              recorder.stop();
              recorder.close(); // Close previous recorder
            }
            String segmentFile = String.format("%s_segment_%d.mp4", outputPrefix, segmentCount++);
            System.out.println("Creating segment: " + segmentFile);

            // Create and configure the recorder for the new segment
            recorder = new FFmpegFrameRecorder(segmentFile,
                grabber.getImageWidth(),
                grabber.getImageHeight(),
                grabber.getAudioChannels());

            // Copy settings from grabber to recorder
            recorder.setFormat("mp4");
            recorder.setFrameRate(frameRate);
            recorder.setSampleRate(grabber.getSampleRate());
            recorder.setVideoCodec(grabber.getVideoCodec());
            recorder.setAudioCodec(grabber.getAudioCodec());
            recorder.setVideoBitrate(grabber.getVideoBitrate());
            recorder.setAudioBitrate(grabber.getAudioBitrate());
            // Add other relevant settings if needed (e.g., pixel format)

            recorder.start();
          }

          // Record the grabbed frame to the current segment
          if (recorder != null) {
            // Important: record() can throw exceptions
            recorder.record(frame);
          }
          frameCount++;
        }
      } finally {
        // Ensure the last recorder is stopped and closed properly
        if (recorder != null) {
          try {
            recorder.stop();
            recorder.close();
          } catch (FFmpegFrameRecorder.Exception e) {
            System.err.println("Error closing the final recorder: " + e.getMessage());
          }
        }
      }
    } // grabber is closed automatically by try-with-resources
  }
}
