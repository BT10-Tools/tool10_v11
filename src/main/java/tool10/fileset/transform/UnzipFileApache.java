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

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;

public class UnzipFileApache {
	
/*	private static File newFile(File destinationDir, String zipEntryName) {
		try {
		    File destFile = new File(destinationDir, zipEntryName);
	
		    String destDirPath = destinationDir.getCanonicalPath();
		    String destFilePath = destFile.getCanonicalPath();
	
		    if (!destFilePath.startsWith(destDirPath + File.separator)) {
		        System.out.println("Entry is outside of the target dir: " + zipEntryName);
		    }
		    return destFile;
		} catch (IOException e)	{
			System.out.println("UnzipFile newFile IOException e: " + e.getStackTrace());
			return(null);
    	}
	}
	
	public static void unzipOneFileFromStream(NodeF10 f10, NodeFileSet outputFileSet, NodeArchive nodeArchive, 
	    		NodeFile nodeFile, ZipInputStream zis, byte[] buffer, File destDir) { //, String fileZip, String destDirName) {
    	try { 
	        ZipEntry zipEntry = zis.getNextEntry();
	        while (zipEntry != null) {
	        	if (zipEntry.isDirectory()) {
	        		zis.closeEntry();
		            zipEntry = zis.getNextEntry();
		            continue;
	        	}
	        	 
	            //File newFile = newFile(destDir, zipEntry.getName());
	        	String fileName = zipEntry.getName();
	            File newFile = new File(destDir.getAbsolutePath() + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                
                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                
                zis.closeEntry();
	            zipEntry = zis.getNextEntry();
	        }
    	} catch (IOException e)	{
    		System.out.println("UnzipFile unzipOneFileFromStream IOException e: " + e.getStackTrace());
			return;
    	}
    }
*/    
	public static ArrayList<ArchiveEntry> getApacheEntryListFromStream(String tmpDirName, NodeFile nodeFile) {
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
    public static void unzipOneArchiveApache(NodeF10 f10, NodeFileSet outputFileSet, NodeArchive nodeArchive, 
    		String tmpDirName, NodeFile nodeFile) { //, String fileZip, String destDirName) {
    	
    	ArrayList<ArchiveEntry> archiveEntryList = getApacheEntryListFromStream(tmpDirName, nodeFile);
    	
    	try { 
	        File destDir = new File(tmpDirName); 
	        Path destPath = destDir.toPath();
	        
	        byte[] buffer = new byte[64*1024];
	        Path archivePath = Paths.get(nodeFile.getFileNameAbsolute());
	        InputStream input = Files.newInputStream(archivePath);
	        BufferedInputStream bis = new BufferedInputStream(input); 
	        ArchiveInputStream<?> archive = new ArchiveStreamFactory().createArchiveInputStream(bis);
	        ArchiveEntry entry;
        	Path outPath;
        	File outFile;
        	
	        while ((entry = archive.getNextEntry()) != null) {
	            String fileNameOrg = entry.getName();
	            
	            byte[] bytes = fileNameOrg.getBytes(StandardCharsets.UTF_8);
	            String fileName = new String(bytes, StandardCharsets.UTF_8); //utf8EncodedString
	            
	            System.out.println("*** UnzipFileApache unzipOneArchiveApache procecssing fileName:" + fileName);
	            if (!archive.canReadEntryData(entry)) {
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
		   /*   public static void extractOne(Path archivePath, String fileName, Path destinationDirectory) {
		    try (InputStream input = Files.newInputStream(archivePath); 
		      BufferedInputStream buffer = new BufferedInputStream(input); 
		      ArchiveInputStream<?> archive = new ArchiveStreamFactory()
		        .createArchiveInputStream(buffer)) {
		
		        ArchiveEntry entry;
		        while ((entry = archive.getNextEntry()) != null) {
		            if (entry.getName().equals(fileName)) {
		                Path outFile = destinationDirectory.resolve(fileName);
		                Files.createDirectories(outFile.getParent());
		                try (OutputStream os = Files.newOutputStream(outFile)) {
		                    IOUtils.copy(archive, os);
		                }
		                break;
		            }
		        }
		    }
		}

		final Path file = createSingleEntryArchive(archiverName);

        final InputStream is1 = Files.newInputStream(file);
        final ArchiveInputStream<?> ais1 = factory.createArchiveInputStream(archiverName, is1);
        final ArchiveEntry nextEntry = ais1.getNextEntry();
        assertNotNull(nextEntry);

        final byte[] buff = new byte[10]; // small so multiple reads are needed;
        final long size = nextEntry.getSize();
        if (size != ArchiveEntry.SIZE_UNKNOWN) {
            assertTrue(size > 0, "Size should be > 0, found: " + size);
        }
        
    		File targetDir = ...
    		try (ArchiveInputStream i = ... create the stream for your format, use buffering...) {
    		    ArchiveEntry entry = null;
    		    while ((entry = i.getNextEntry()) != null) {
    		        if (!i.canReadEntryData(entry)) {
    		            // log something?
    		            continue;
    		        }
    		        String name = fileName(targetDir, entry);
    		        File f = new File(name);
    		        if (entry.isDirectory()) {
    		            if (!f.isDirectory() && !f.mkdirs()) {
    		                throw new IOException("failed to create directory " + f);
    		            }
    		        } else {
    		            File parent = f.getParentFile();
    		            if (!parent.isDirectory() && !parent.mkdirs()) {
    		                throw new IOException("failed to create directory " + parent);
    		            }
    		            try (OutputStream o = Files.newOutputStream(f.toPath())) {
    		                IOUtils.copy(i, o);
    		            }
    		        }
    		    }
    		}
	*/
}
