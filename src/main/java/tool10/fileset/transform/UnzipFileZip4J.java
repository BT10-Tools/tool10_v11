package tool10.fileset.transform;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.io.IOUtils;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;
import tool10.fileset.nodes.NodeFile;

public class UnzipFileZip4J {
	
	public static boolean extractAll(String fileName, String tmpDirName, char[] password)	{
		//Extracting all files from a zip
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			zipFile.extractAll(tmpDirName); //"/destination_directory");
			zipFile.close();
			return (true);
		} catch (Exception e)	{
			return(false);
		}
	}
	
	public void extractWithZipInputStream(File zipFile, char[] password) throws IOException {
	    LocalFileHeader localFileHeader;
	    int readLen;
	    byte[] readBuffer = new byte[4096];
	     
	    InputStream inputStream = new FileInputStream(zipFile);
	    try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password)) {
	      while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
	        File extractedFile = new File(localFileHeader.getFileName());
	        try (OutputStream outputStream = new FileOutputStream(extractedFile)) {
	          while ((readLen = zipInputStream.read(readBuffer)) != -1) {
	            outputStream.write(readBuffer, 0, readLen);
	          }
	        }
	      }
	    }
	  }
	
	public void extractWithZipInputStreamOrg(File zipFile, char[] password) throws IOException {
		    LocalFileHeader localFileHeader;
		    int readLen;
		    byte[] readBuffer = new byte[4096];

		    InputStream inputStream = new FileInputStream(zipFile);
		    try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password)) {
		      while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
		        File extractedFile = new File(localFileHeader.getFileName());
		        try (OutputStream outputStream = new FileOutputStream(extractedFile)) {
		          while ((readLen = zipInputStream.read(readBuffer)) != -1) {
		            outputStream.write(readBuffer, 0, readLen);
		          }
		        }
		      }
		    }
		  }
	 
	public static ArrayList<ArchiveEntry> getZip4JEntryListFromStream(String tmpDirName, NodeFile nodeFile, char[] password) {
		ArrayList<ArchiveEntry> archiveEntryList = new ArrayList<ArchiveEntry>(); 
		try { 
	        Path archivePath = Paths.get(nodeFile.getFileNameAbsolute());
	        InputStream input = Files.newInputStream(archivePath);
	        BufferedInputStream bis = new BufferedInputStream(input); 
	        ArchiveInputStream<?> archive = new ArchiveStreamFactory().createArchiveInputStream(bis);
	        ArchiveEntry entry;
	        while ((entry = archive.getNextEntry()) != null) {
	            System.out.println("UnzipFile unzipOneArchive zipEntry entry.getName():" + entry.getName() + ", entry.getSize():"+entry.getSize());
	            archiveEntryList.add(entry);
	        }
	        bis.close();
	        input.close();
	        archive.close();
    	} catch (IOException e)	{
    		System.out.println("UnzipFileApache getApacheEntryListFromStream IOException e: " + e.getStackTrace());
			return(archiveEntryList);
    	}
		System.out.println("UnzipFile getApacheEntryListFromStream archiveEntryList.size():"+archiveEntryList.size());
		return(archiveEntryList);
	}
	static {
		System.setProperty("file.encoding",    "UTF-8");
		System.setProperty("sun.jnu.encoding", "UTF-8");
	}
/*	
    public static void unzipOneArchiveZip4j(NodeF10 f10, NodeFileSet outputFileSet, NodeArchive nodeArchive, 
    		String tmpDirName, NodeFile nodeFile, char[] password) { 
    	
    	ArrayList<ArchiveEntry> archiveEntryList = getZip4JEntryListFromStream(tmpDirName, nodeFile, password);
    	
    	try { 
	        File destDir = new File(tmpDirName); 
	        Path destPath = destDir.toPath();
	        
	        byte[] buffer = new byte[64*1024];
	        Path archivePath = Paths.get(nodeFile.getFileNameAbsolute());
	        InputStream inputStream = Files.newInputStream(archivePath);
	        ZipInputStream zis = new ZipInputStream(inputStream, password); 
	        LocalFileHeader localFileHeader;
        	Path outPath;
        	File outFile;
        	
        	public void extractWithZipInputStream(File zipFile, char[] password) throws IOException {
        	    LocalFileHeader localFileHeader;
        	    int readLen;
        	    byte[] readBuffer = new byte[4096];
        	     
        	    InputStream inputStream = new FileInputStream(zipFile);
        	    try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password)) {
        	      while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
        	    	  localFileHeader.
        	        File extractedFile = new File(localFileHeader.getFileName());
        	        try (OutputStream outputStream = new FileOutputStream(extractedFile)) {
        	          while ((readLen = zipInputStream.read(readBuffer)) != -1) {
        	            outputStream.write(readBuffer, 0, readLen);
        	          }
        	        }
        	      }
        	    }
        	  }
        	
	        while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
	            String fileName = localFileHeader.getFileName();
	            File extractedFile = new File(fileName);
	            		
	            System.out.println("*** UnzipFileApache unzipOneArchiveApache procecssing fileName:" + fileName);
	            if (!localFileHeader..archive.canReadEntryData(entry)) {
	            	System.out.println("UnzipFile unzipOneArchive cannmot read entry entry.getName():" + entry.getName());
		            continue;
		        }
	            try {
	            	outPath = destPath.resolve(fileName);
	            	outFile = outPath.toFile();
	            } catch(Exception e)	{
	            	System.out.println("UnzipFileApache unzipOneArchiveApache Path IOException e: " + e.getStackTrace());
	            	continue;
	            }	
		        if (entry.isDirectory()) {
		            if (!outFile.isDirectory() && !outFile.mkdirs()) {
		            	System.out.println("UnzipFile unzipOneArchive failed to create directory outFile:" + outFile);
		            	continue;
		            }
		        } else {
		            File parent = outFile.getParentFile();
		            if (!parent.isDirectory() && !parent.mkdirs()) {
		                System.out.println("UnzipFile unzipOneArchive failed to create parent directory parent.getAbsolutePath():" + parent.getAbsolutePath());
		                continue;
		            }
		            //Files.createDirectories(outPath.getParent());
		            System.out.println("UnzipFile unzipOneArchive zipEntry entry.getName():" + entry.getName() + ", entry.getSize():"+entry.getSize() + ", file:"+outPath);
			        try {
		            	OutputStream os = Files.newOutputStream(outPath); 
		            	IOUtils.copy(archive, os);
		            	os.close();
		            } catch(Exception e)	{
		            	continue;
		            }	
	        	}
	        }
	        bis.close();
	        input.close();
	        archive.close();
    	} catch (IOException e)	{
    		System.out.println("UnzipFile unzipOneArchive IOException e: " + e.getStackTrace());
    	}
    }
	*/
}
