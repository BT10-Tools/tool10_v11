package tool10.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class FileUtil {

	public static boolean deleteFileIfExists(String fileName)	{
	    // create object of Path
	    Path path = Paths.get(fileName);
	
	    // deleteIfExists File
	    try {
	        return(Files.deleteIfExists(path));
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return(false);
	    }
	}    
	public static boolean checkDirectoryExists(String dirName)	{
		try {
			File checkedDirectory = new File(dirName);
			if (!checkedDirectory.isDirectory()) return(false); //not a directory 
			boolean exists = checkedDirectory.exists();
			return(exists);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static boolean checkFileExists(String dirName)	{
		try {
			File checkedFile = new File(dirName);
			if (!checkedFile.isFile()) return(false); //not a file
			boolean exists = checkedFile.exists();
			return(exists);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static boolean createNestedDirectory(String dirName)	{
		if (dirName==null) return(false);
		if (checkDirectoryExists(dirName)) {return(false);} 
		try {
			File nestedDirectory = new File(dirName);
			nestedDirectory.mkdirs();
			return(checkDirectoryExists(dirName));
		} catch (Exception e)	{
			return(false);
		}
	}
	public static String getShortFilename(String absoluteFilename)	{
		if (absoluteFilename==null) return(null);
		Path path = Paths.get(absoluteFilename);
		if ((!Files.exists(path))) return(null);
		File file = new File(absoluteFilename);
		if ((file==null) || (!file.exists())) return(null);
		return(file.getName());
	}
	public static LocalDateTime getFileCreationDate(String filename)	{
		if (filename==null) return(null);
		Path path = Paths.get(filename);
		if ((!Files.exists(path))) return(null);
		try {
			File file = new File(filename);
			if ((file==null) || (!file.exists())) return(null);
			
		    FileTime creationTime = (FileTime) Files.getAttribute(file.toPath(), "creationTime");
		    if (creationTime==null) return(null);
		    return(creationTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		    
		    //BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		    //FileTime fileTime = attr.creationTime();
		} catch (IOException ex) {
		    // handle exception
		}
		return(null);
	}
	public static long getFileSize(String filename)	{ 
	    long fileSize = -1; 
	    try	{
	    	File file = new File(filename);
	    	fileSize = file.length();
	    	return fileSize;
	    } catch (Exception ex) {
		    // handle exception
		}
	    return fileSize;
	}    
	public static byte[] getBytes(String filename)	{
	    File myFile = new File(filename);
	    if (!myFile.exists()) return(null);
	    byte[] byteArray = new byte[(int) myFile.length()];
	    try	{
	    	FileInputStream inputStream = new FileInputStream(myFile); 
	        inputStream.read(byteArray);
	        inputStream.close();
	    } catch (IOException ex) {
		    // handle exception
		}
	    return(byteArray);
	}    
	public static String[] getLineArrayFromFile(String filename) {
		String[] lineArray = null;
		ArrayList<String> lineList = new ArrayList<String>(); 
	    try	{
	    	File myFile = new File(filename);
		    if (!myFile.exists()) return(lineArray);
		    
		    FileReader fr = new FileReader(filename);
		    BufferedReader br = new BufferedReader(fr);
	    	
	        while (true) {
	        	String line = br.readLine();
	        	if (line==null) break;
	        	lineList.add(line);
	        }
	        br.close();
	        fr.close();
	        lineArray = new String[lineList.size()];
	        for (int i=0; i<lineList.size(); i++)	{
	        	lineArray[i] = lineList.get(i);
	        }
	        return(lineArray);
	    } catch (IOException ex) {
		    // handle exception
		}
	    return(lineArray);
	}    
	public static void bufferedWriter(String fileName, String contentStr) {
		int BUFSIZE = 10*1000*1000;
        try {
        	FileWriter fw = new FileWriter(fileName, false);
        	BufferedWriter writer = new BufferedWriter(fw, BUFSIZE);
            writer.write(contentStr);
            writer.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error in BufferedWriter 1 write"+e);
        }
	}
	public static boolean writeBytesToFile(String fileName, byte[] bytes) {
        try {
        	File myFile = new File(fileName);
		    if (myFile.exists()) return(false);
        	Files.write(myFile.toPath(), bytes);
        	return(myFile.exists());
        } catch (IOException e) {
            System.out.println("FileUtil writeBytesToFile Error in BufferedWriter 1 write"+e);
            return(false);
        }
	}
	public static File appendBytesToFile(String fileName, byte[] bytes) {
        try {
        	File myFile = new File(fileName);
		    if (myFile.exists()) return(null);
        	Files.write(myFile.toPath(), bytes);
        	return(myFile);
        } catch (IOException e) {
            System.out.println("FileUtil writeBytesToFile Error in BufferedWriter 1 write"+e);
            return(null);
        }
	}
	public static boolean appendBytesToFile(File myFile, byte[] bytes) {
        try {
        	Files.write(myFile.toPath(), bytes, StandardOpenOption.APPEND);
        	return(true);
        } catch (IOException e) {
            System.out.println("FileUtil appendBytesToFile Error in BufferedWriter 1 write"+e);
            return(false);
        }
	}
	public static boolean closeFile(File myFile) {
        try {
        	//myFile.close(); //there is no close method
        	return(true);
        } catch (Exception e) {
            System.out.println("FileUtil appendBytesToFile Error in BufferedWriter 1 write"+e);
            return(false);
        }
	}
}
