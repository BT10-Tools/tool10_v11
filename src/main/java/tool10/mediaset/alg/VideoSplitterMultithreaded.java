package tool10.mediaset.alg;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class VideoSplitterMultithreaded {

  public static void splitVideoMultithreaded(String inputPath, String outputPrefix, int segmentDurationSeconds) throws Exception {
	    // Input validation (similar to the basic splitter)
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
	        }
	    }

	    int totalFrames;
	    double frameRate;
	    int imageWidth, imageHeight, audioChannels, videoCodec, audioCodec, sampleRate, audioBitrate, videoBitrate;

	    // First pass to get essential video properties using try-with-resources
	    try (FFmpegFrameGrabber initialGrabber = new FFmpegFrameGrabber(inputPath)) {
	        initialGrabber.start();
	        totalFrames = initialGrabber.getLengthInFrames();
	        frameRate = initialGrabber.getFrameRate();
	         if (frameRate <= 0) { // Fallback calculation
	            frameRate = (double) totalFrames / (initialGrabber.getLengthInTime() / 1_000_000.0);
	             if (frameRate <= 0) {
	                 throw new RuntimeException("Could not determine frame rate for input video.");
	             }
	         }
	        imageWidth = initialGrabber.getImageWidth();
	        imageHeight = initialGrabber.getImageHeight();
	        audioChannels = initialGrabber.getAudioChannels();
	        videoCodec = initialGrabber.getVideoCodec();
	        audioCodec = initialGrabber.getAudioCodec();
	        sampleRate = initialGrabber.getSampleRate();
	        audioBitrate = initialGrabber.getAudioBitrate();
	        videoBitrate = initialGrabber.getVideoBitrate();
	    }

	    int framesPerSegment = (int) Math.round(frameRate * segmentDurationSeconds);
	     if (framesPerSegment <= 0) {
	          throw new IllegalArgumentException("Calculated frames per segment is zero or negative.");
	      }
	    int totalSegments = (int) Math.ceil((double) totalFrames / framesPerSegment);

	    // Determine optimal thread pool size
	    int numThreads = Math.min(Runtime.getRuntime().availableProcessors(), totalSegments > 0 ? totalSegments : 1);
	    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
	    System.out.println("Using " + numThreads + " threads for " + totalSegments + " segments.");

	    List<Future<?>> futures = new ArrayList<>();

	    try {
	      for (int i = 0; i < totalSegments; i++) {
	        final int segmentIndex = i;
	        final int startFrame = segmentIndex * framesPerSegment;
	        // Calculate the number of frames for this specific segment (last segment might be shorter)
	        final int framesInThisSegment = Math.min(framesPerSegment, totalFrames - startFrame);
	        final double frameRateFinal = frameRate;
	        
	        // Submit a task for each segment
	        Future<?> future = executor.submit(() -> {
	          try {
	            // Pass all necessary parameters to the segment processing method
	            splitSegment(inputPath, outputPrefix, segmentIndex, startFrame, framesInThisSegment,
	            		frameRateFinal, imageWidth, imageHeight, audioChannels, videoCodec, audioCodec,
	                         sampleRate, audioBitrate, videoBitrate);
	          } catch (Exception e) {
	            System.err.println("ERROR: Failed to process segment " + segmentIndex + ": " + e.getMessage());
	            // Wrap exception to be caught later when calling future.get()
	            throw new RuntimeException("Segment processing failed for index " + segmentIndex, e);
	          }
	        });
	        futures.add(future);
	      }

	      // Wait for all tasks to complete and check for errors
	      int failedSegments = 0;
	      for (Future<?> f : futures) {
	          try {
	              f.get(); // Wait for completion and throw exception if the task failed
	          } catch (Exception e) {
	              System.err.println("Caught exception from segment task: " + e.getMessage());
	              failedSegments++;
	              // Optionally, decide to stop all processing if one segment fails critically
	          }
	      }
	      if (failedSegments > 0) {
	          System.err.println(failedSegments + " segment(s) failed to process.");
	          // Optionally throw an exception here to indicate overall failure
	          // throw new RuntimeException(failedSegments + " segment(s) failed.");
	      }

	    } finally {
	      // Properly shut down the executor service
	      executor.shutdown();
	      try {
	        if (!executor.awaitTermination(60, TimeUnit.MINUTES)) { // Wait up to an hour
	          System.err.println("Executor did not terminate in the specified time.");
	          List<Runnable> droppedTasks = executor.shutdownNow();
	          System.err.println("Executor was forcefully shut down. " + droppedTasks.size() + " tasks were not started.");
	        }
	      } catch (InterruptedException ie) {
	        System.err.println("Executor termination interrupted.");
	        executor.shutdownNow();
	        Thread.currentThread().interrupt(); // Preserve interrupt status
	      }
	    }
	     System.out.println("Multithreaded video splitting process finished.");
	  }

	  // Method to process a single segment
	  private static void splitSegment(String inputPath, String outputPrefix, int segmentIndex,
	                                   int startFrame, int framesToProcess, double frameRate,
	                                   int imageWidth, int imageHeight, int audioChannels,
	                                   int videoCodec, int audioCodec, int sampleRate,
	                                   int audioBitrate, int videoBitrate) throws Exception {

	    String segmentFile = String.format("%s_segment_%d.mp4", outputPrefix, segmentIndex);
	    System.out.println("Processing segment " + segmentIndex + " -> " + segmentFile + " (Frames: " + startFrame + " to " + (startFrame + framesToProcess - 1) + ")");

	    // Each thread needs its own grabber and recorder instance
	    // Use try-with-resources for automatic cleanup
	    try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputPath);
	         FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(segmentFile, imageWidth, imageHeight, audioChannels)) {

	      grabber.start();
	      // Seek to the start frame. Note: Seeking might not be perfectly accurate.
	      // For precise splitting, grabbing from the start might be needed, but is slower.
	      try {
	          grabber.setFrameNumber(startFrame);
	      } catch (Exception e) {
	          System.err.println("Warning: Failed to seek to frame " + startFrame + " for segment " + segmentIndex + ". Proceeding by grabbing frames.");
	          // Fallback: Grab frames until startFrame is reached (less efficient)
	          for (int i = 0; i < startFrame; i++) {
	              if (grabber.grab() == null) {
	                  throw new RuntimeException("Reached end of stream before reaching start frame for segment " + segmentIndex);
	              }
	          }
	      }

	      // Configure the recorder
	      recorder.setFormat("mp4");
	      recorder.setFrameRate(frameRate);
	      recorder.setSampleRate(sampleRate);
	      recorder.setVideoCodec(videoCodec);
	      recorder.setAudioCodec(audioCodec);
	      recorder.setVideoBitrate(videoBitrate);
	      recorder.setAudioBitrate(audioBitrate);

	      recorder.start();

	      Frame frame;
	      for (int i = 0; i < framesToProcess; i++) {
	        frame = grabber.grab(); // Grab video or audio frame
	        if (frame == null) {
	          System.err.println("Warning: Reached end of stream unexpectedly while processing segment " + segmentIndex + " at frame " + (startFrame + i));
	          break; // Stop processing this segment if stream ends early
	        }
	        // Record the frame
	        recorder.record(frame);
	      }
	      // Recorder and grabber are closed automatically by try-with-resources
	       System.out.println("Finished processing segment " + segmentIndex);
	    } catch (Exception e) {
	        System.err.println("Error processing segment " + segmentIndex + ": " + e.getMessage());
	        // Attempt to clean up the potentially incomplete/corrupt segment file
	        File failedSegment = new File(segmentFile);
	        if (failedSegment.exists()) {
	            if (failedSegment.delete()) {
	                System.out.println("Cleaned up failed segment file: " + segmentFile);
	            } else {
	                System.err.println("Warning: Failed to delete incomplete segment file: " + segmentFile);
	            }
	        }
	        throw e; // Re-throw the exception to be caught by the executor handling
	    }
	  }
	  
  }
