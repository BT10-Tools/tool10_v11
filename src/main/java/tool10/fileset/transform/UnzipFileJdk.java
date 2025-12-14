package tool10.fileset.transform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;

public class UnzipFileJdk {
	
	private static File newFile(File destinationDir, String zipEntryName) {
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
	public static ArrayList<ZipEntry> getZipEntryListFromStream(ZipInputStream zis) {
		ArrayList<ZipEntry> zipEntryList = new ArrayList<ZipEntry>(); 
		try { 
	        ZipEntry zipEntry = zis.getNextEntry();
	        while (zipEntry != null) {
	        	zipEntryList.add(zipEntry);
	            zipEntry = zis.getNextEntry();
	        }
		} catch (IOException e)	{
			System.out.println("UnzipFile getZipEntryListFromStream IOException e: " + e.getStackTrace());
			return(zipEntryList);
		}
		return(zipEntryList);
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
    public static void unzipOneArchive(NodeF10 f10, NodeFileSet outputFileSet, NodeArchive nodeArchive, 
    		String tmpDirName, NodeFile nodeFile) { //, String fileZip, String destDirName) {
    	try { 
	        //String fileZip = "src/main/resources/unzipTest/compressed.zip";
	        File destDir = new File(tmpDirName); //"src/main/resources/unzipTest");
	
	        byte[] buffer = new byte[1024*1024];
	        FileInputStream fis4List = new FileInputStream(nodeFile.getFileNameAbsolute());
	        ZipInputStream zis4List = new ZipInputStream(fis4List);
	        ArrayList<ZipEntry> zipEntryList = getZipEntryListFromStream(zis4List); 
	        System.out.println("-----------------------------------------------------------------------------------");
	        System.out.println("UnzipFile unzipOneArchive size of the zipEntry zipEntryList.size():" + zipEntryList.size());
	        
	        zis4List.closeEntry();
	        zis4List.close();
	        fis4List.close();
	        
	        FileInputStream fis = new FileInputStream(nodeFile.getFileNameAbsolute());
	        ZipInputStream zis = new ZipInputStream(fis);
	        unzipOneFileFromStream(f10, outputFileSet, nodeArchive,	nodeFile, 
	        		zis, buffer, destDir);
	        zis.closeEntry();
	        zis.close();
	        fis.close();
    	} catch (IOException e)	{
    		System.out.println("UnzipFile unzipOneArchive IOException e: " + e.getStackTrace());
    	}
    }
    
	
}
