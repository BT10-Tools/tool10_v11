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
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

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
	public static boolean deleteDirectoryRecursively(String dirName)	{
		if (!checkDirectoryExists(dirName)) return(false);
	    try {
		    File directoryToBeDeleted = new File(dirName);
	    	File[] allContents = directoryToBeDeleted.listFiles();
	        if (allContents != null) {
	            for (File file : allContents) {
	            	deleteDirectoryRecursively(file.getAbsolutePath());
	            }
	        }
	        return directoryToBeDeleted.delete();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return(false);
	    }
	}    
	public static boolean checkDirectoryExists(String dirName)	{
		try {
			File checkedDirectory = new File(dirName);
			if (!checkedDirectory.exists()) return(false); //no such file/directory/path exists  
			if (!checkedDirectory.isDirectory()) return(false); //not a directory 
			boolean exists = checkedDirectory.exists();
			return(exists);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static boolean checkDirectoryExistsAndEmpty(String dirName)	{
		try {
			if (!checkDirectoryExists(dirName)) return(false);
			File checkedDirectory = new File(dirName);
			Stream<Path> entries = Files.list(checkedDirectory.toPath()); 
			boolean isEmpty = !entries.findFirst().isPresent();   
			entries.close();
			return(isEmpty);
		} catch (Exception e)	{
			return(false);
		}
	}
/*	public static long getCountFilesRecursivelyInDirectory(String dirName)	{
		try {
			File currentFile = new File(dirName);
			//if (currentFile==null) return (-1);
			if (!currentFile.exists()) return (-1);
			
			long currentFileNumber = getCountFilesRecursivelyInDirectory(currentFile);
			return(currentFileNumber);
		} catch (Exception e)	{
			return(-1);
		}
	}	
	public static long getCountFilesRecursivelyInDirectory(File currentFile)	{
		if (!currentFile.exists()) return (-1);
		try {		
			File[] filesOrNull = currentFile.listFiles();
			// Is this a file already?
			long currentFileNumber = currentFile.isFile() ? 1 : 0;
			if (filesOrNull == null) { // no sub directories found
			    return currentFileNumber; // stop condition #1
			}
			return currentFileNumber + 
				Arrays.stream(filesOrNull)
			  		.mapToLong(currentFile::filesInside) // <-- recursion call here
			  		.sum();
		} catch (Exception e)	{
			return(-1l);
		}
	}		
	private static long filesInside(File it) {
	    if (it.isFile()) {
	        return 1; // stop condition #2
	    } else if (it.isDirectory()) {
	        return getCountFilesRecursivelyInDirectory(it.getAbsolutePath()); // <-- recursion to caller
	    } else {
	        return 0; // stop condition #3
	    }
	}
*/	
	public static long getCountFilesRecursivelyInDirectory(String path)	{
		Path dir = Path.of(path);
		try (Stream<Path> stream = Files.walk(dir)) {
		    return stream.parallel()
		      .map(getFileOrEmpty())
		      .flatMap(Optional::stream)
		      .filter(it -> !it.isDirectory())
		      .count();
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	}
	public static long getCountDirectoriesRecursivelyInDirectory(String path)	{
		Path dir = Path.of(path);
		try (Stream<Path> stream = Files.walk(dir)) {
		    return stream.parallel()
		      .map(getFileOrEmpty())
		      .flatMap(Optional::stream)
		      .filter(it -> !it.isFile())
		      .count();
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	}
	private static Function<Path, Optional<File>> getFileOrEmpty() {
	    return it -> {
	        try {
	            return Optional.of(it.toFile());
	        } catch (UnsupportedOperationException e) {
	            // You may print or log the exception here;
	            return Optional.empty();
	        }
	    };
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
	    	return(-1);
		    // handle exception
		}
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
