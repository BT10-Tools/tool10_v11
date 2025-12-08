package tool10.misc.autogen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tool10.util.FileUtil;

public class LOC {

	public static long countLine(String fileName) {
		long lines = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while (reader.readLine() != null) lines++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	public static Set<String> listFilesUsingDirectoryStream(String dir) {
		Set<String> fileSet = new HashSet<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
			for (Path path : stream) {
				if (!Files.isDirectory(path)) {
					fileSet.add(path.getFileName().toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileSet;
	}
	public static Set<String> listFilesUsingFileWalk(String dir, int depth) {
	    try (Stream<Path> stream = Files.walk(Paths.get(dir), depth)) {
	        return stream
	          .filter(file -> !Files.isDirectory(file))
	          .map(Path::getFileName)
	          .map(Path::toString)
	          .collect(Collectors.toSet());
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    return(null);
	}
	public static void mapFile2Parent(String dirName, SortedMap<String,String> fileMap) {
		System.out.println("mapFile2Parent processing dirName:"+dirName+"    fileMap.size():"+ fileMap.size());
		File directoryPath = new File(dirName);
		if (fileMap.get(directoryPath.getAbsolutePath())==null) {
			fileMap.put(directoryPath.getAbsolutePath().toString(),directoryPath.getParent().toString());
		}
		
		//List of all files and directories
	    File filesList[] = directoryPath.listFiles();
	    //System.out.println("List of files and directories in the specified directory:");
	    for(File file : filesList) {
	    	System.out.println("	mapFile2Parent processing dirName:"+dirName+"    file.getAbsoluteFile().toString():"+ file.getAbsoluteFile().toString());
			fileMap.put(file.getAbsolutePath().toString(),directoryPath.getAbsolutePath().toString());
			
			if (file.isDirectory())	{
				//mapFile2Parent(path.getFileName().toString(), fileMap);
				mapFile2Parent(file.getAbsolutePath().toString(), fileMap);	
			}
		}
	}
	public static boolean isDirectory(String dirName)	{
		Path path = Paths.get(dirName);
		if (Files.isDirectory(path)) return (true); 
		return(false);
	}
	private static void updateParentValuesUpToRoot(String fileName,SortedMap<String,String> fileMap,
			HashMap<String,Long> file2CntMap,	HashMap<String,Long> file2LocMap,HashMap<String,Long> file2SizeMap)	{
		
		System.out.println("	updateParentValuesUpToRoot processing fileName:"+fileName);
		if (fileMap.get(fileName)==null) return;
		
		long cnt = file2CntMap.get(fileName)!=null ? file2CntMap.get(fileName).longValue() : 0;
		long loc = file2LocMap.get(fileName)!=null ?  file2LocMap.get(fileName).longValue() : 0;
		long fileSize = file2SizeMap.get(fileName)!=null ?  file2SizeMap.get(fileName).longValue() : 0;
		
		String parentFileName = fileMap.get(fileName);
		if (file2CntMap.get(parentFileName)==null)	{file2CntMap.put(parentFileName,(long) 0);} 
		if (file2LocMap.get(parentFileName)==null)	{file2LocMap.put(parentFileName,(long) 0);}
		if (file2SizeMap.get(parentFileName)==null)	{file2SizeMap.put(parentFileName,(long) 0);}
		
		file2CntMap.put(parentFileName, file2CntMap.get(parentFileName) + cnt);
		file2LocMap.put(parentFileName, file2LocMap.get(parentFileName) + loc);
		file2SizeMap.put(parentFileName, file2SizeMap.get(parentFileName) + fileSize);
		
		//updateParentValuesUpToRoot(parentFileName, fileMap, file2CntMap,	file2LocMap, file2SizeMap);
	}
	private static void dirWc (String dirName)	{
		int depth = 1000;
		//Set<String> fileSet = listFilesUsingFileWalk(dirName,depth);
		SortedMap<String,String> fileMap = new TreeMap<String,String>();
		mapFile2Parent(dirName, fileMap);
		
		System.out.println("dirName:"+dirName+"    fileMap.size():"+ fileMap.size());
		HashMap<String,Long> file2CntMap = new HashMap<String,Long>(); 
		HashMap<String,Long> file2LocMap = new HashMap<String,Long>(); 
		HashMap<String,Long> file2SizeMap = new HashMap<String,Long>();
		
		for (String fileName : fileMap.keySet())	{
			if (!fileName.endsWith(".java")) continue;
			if (!isDirectory(fileName))	{
				long loc = countLine(fileName);
				long fileSize = FileUtil.getFileSize(fileName);
				file2CntMap.put(fileName, (long) 1);
				file2LocMap.put(fileName, loc);
				file2SizeMap.put(fileName, fileSize);
				System.out.println("fileName:"+fileName+"    wc:"+ loc+"	,fileSize:"+fileSize);
			}
		}
		for (String fileName : fileMap.keySet())	{
			if (!isDirectory(fileName))	{
				updateParentValuesUpToRoot(fileName, fileMap, file2CntMap,	file2LocMap, file2SizeMap);
			}
		}
		for (String fileName : fileMap.keySet())	{
			if (isDirectory(fileName))	{
				updateParentValuesUpToRoot(fileName, fileMap, file2CntMap,	file2LocMap, file2SizeMap);
			}
		}
		for (String fileName : fileMap.keySet())	{
			if (isDirectory(fileName))	{
				long cnt = file2CntMap.get(fileName);
				long loc = file2LocMap.get(fileName);
				long fileSize = file2SizeMap.get(fileName);
				System.out.println("fileName:"+fileName+"    cnt:"+ cnt+"    loc:"+ loc+"	,fileSize:"+fileSize);
			}
		}	
		//System.out.println("fileName:"+fileName+"    wc:"+ countLineBufferedReader(fileName));
	}
	public static void main(String[] args) {
        System.out.println("Hello World!");
        //String dirName = "C:\\Users\\nursa\\eclipse-workspace-20250914\\sim10_v10\\src\\main\\java\\sim10";
        String dirName = "C:\\Users\\nursa\\eclipse-workspace-20250914\\tool10_v10\\src";
        	
        
        dirWc (dirName);
	}     
}
