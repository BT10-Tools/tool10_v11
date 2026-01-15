package tool10.mediaset.alg;

import java.io.File;

public class VideoSplitterTest {

	// Example Input Validation (can be integrated into the main methods)
	public static void validateInputs(String inputPath, String outputPrefix, int segmentDuration) throws IllegalArgumentException {
	    File inputFile = new File(inputPath);
	    if (!inputFile.exists() || !inputFile.canRead()) {
	        throw new IllegalArgumentException("Input file does not exist or cannot be read: " + inputPath);
	    }

	    File outputDir = new File(outputPrefix).getParentFile();
	    if (outputDir != null) { // If outputPrefix includes a path
	        if (!outputDir.exists()) {
	            if (!outputDir.mkdirs()) {
	                // Consider if this is a fatal error for your application
	                System.err.println("Warning: Could not create output directory: " + outputDir.getAbsolutePath());
	            }
	        }
	        if (!outputDir.isDirectory()) {
	             throw new IllegalArgumentException("Output path's parent is not a directory: " + outputDir);
	        }
	        if (!outputDir.canWrite()) {
	             throw new IllegalArgumentException("Cannot write to output directory: " + outputDir);
	        }
	    }

	    if (segmentDuration <= 0) {
	        throw new IllegalArgumentException("Segment duration must be positive.");
	    }
	}
	public static void main(String[] args) {
		try {
			// Example usage: Ensure input.mp4 exists and output directory is writable
			String fileName ="C:\\tmp\\similarity\\10_Media\\01_video\\Sibel Can - Lale Devri.mp4";
			String outputPrefix="C:\\tmp\\similarity\\10_Media\\01_video\\out\\sibel";
			int segmentDuration= 60;
			
			//VideoSplitterSinglethreaded.splitVideo(fileName,outputPrefix, segmentDuration); //"input.mp4", "output/segment"
      
			VideoSplitterMultithreaded.splitVideoMultithreaded(fileName, outputPrefix, segmentDuration);
			System.out.println("Video splitting completed successfully.");
			
		} catch (IllegalArgumentException e)	{
			System.err.println("Arguments not correct: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Video splitting failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
