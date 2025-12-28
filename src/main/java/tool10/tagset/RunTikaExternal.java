package tool10.tagset;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RunTikaExternal {

	//https://tika.apache.org/3.2.3/gettingstarted.html
	//java -jar tika-app-3.2.3.jar --config="tika-config.xml" -m "C:\tmp\similarity\samplePDF\30133839528.pdf" > out2.txt
	//java -jar tika-app-3.2.3.jar --config="tika-config.xml" -x "C:\tmp\similarity\samplePDF\30133839528.pdf" > out2.xhtml
	//java -jar tika-app-3.2.3.jar --config="tika-config.xml" -x -i "C:\tmp\similarity\samplePDF" -o "C:\tmp\similarity\samplePDFOut" 
	
	private static String RUNNABLE_JAR_PATH = "tika-app-3.2.3.jar";
	public void runTika() {
	    Process process = null;
	    try {
	    
	        String jarFile = new File(Objects.requireNonNull(getClass().getClassLoader()
	          .getResource(RUNNABLE_JAR_PATH))
	          .toURI()).getAbsolutePath();

	        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarFile, "-m \"C:\\tmp\\similarity\\samplePDF\\30133839528.pdf\"" );
	        processBuilder.redirectErrorStream(true);
	     
		/*    List<String> cmd = new ArrayList<>();
	        cmd.add("-m \"C:\\tmp\\similarity\\samplePDF\\30133839528.pdf\"");
	        processBuilder.command(cmd);
	   */     
	        process = processBuilder.start();
	        try (InputStream inputStream = process.getInputStream()) {
	            byte[] output = inputStream.readAllBytes();
	            System.out.println("Output: " + new String(output));
	        }

	        int exitCode = process.waitFor();
	        System.out.println("Process exited with an unexpected exit code exitCode:"+exitCode);
	    } catch (IOException | InterruptedException | URISyntaxException e) {
	    	System.out.println("Test failed due to exception: " + e.getMessage());
	    	
	    } finally {
	        if (process != null) {
	            process.destroy();
	        }
	    }
	}
	public static void main(String[] args) {
		RunTikaExternal ext = new RunTikaExternal();
		ext.runTika();        		
	}
}
