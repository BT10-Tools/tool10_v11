package tool10.util;

import java.io.File;
import java.util.ArrayList;

//import org.apache.commons.io.FilenameUtils;

public class TraverseFiles {

	public static String getFileExtension(String filename) {
	    if (filename == null) {
	        return null;
	    }
	    int dotIndex = filename.lastIndexOf(".");
	    if (dotIndex >= 0) {
	        return filename.substring(dotIndex + 1);
	    }
	    return "";
	}
	public static String  getFilenameWithoutExtension(String filename) {
	    if (filename == null) {
	        return null;
	    }
	    String fileExtension = getFileExtension(filename);
	    if ((fileExtension == null) || (fileExtension.isEmpty())) {
	        return filename;
	    }
	    int dotIndex = filename.lastIndexOf(fileExtension);
	    if (dotIndex >= 1) {
	        return filename.substring(0,dotIndex-1);
	    }
	    return filename;
	}
	public static int traverseFiles(ArrayList<String> filenameList,String[] extArray, File folder) {
		int maxNumberOfFiles = 256*1024;
		int cntNumberOfFiles = 0; 
		return(traverseFiles(filenameList,extArray,folder,maxNumberOfFiles,cntNumberOfFiles)); 
	}
	public static int traverseFiles(ArrayList<String> filenameList,String[] extArray, File folder, int maxNumberOfFiles) {
		int cntNumberOfFiles = 0;
		return(traverseFiles(filenameList,extArray,folder,maxNumberOfFiles,cntNumberOfFiles));
	}
	public static int traverseFiles(ArrayList<String> filenameList,String[] extArray, File folder, int maxNumberOfFiles, int cntNumberOfFiles) {
		if (folder==null) return(0);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                    	filenameList.add(file.getAbsolutePath());
                    	cntNumberOfFiles++;
                        traverseFiles(filenameList,extArray,file,maxNumberOfFiles,cntNumberOfFiles); // Recursive call for subdirectories
                    } else {
                        //System.out.println("File: " + file.getAbsolutePath());
                    	//String ext = FilenameUtils.getExtension(file);
                    	String ext = getFileExtension(file.getAbsolutePath());
                    	boolean found=false;
                    	for (int i=0; ((i<extArray.length) && (!found)); i++)	{
                    		if (extArray[i].equals(ext)) {	found = true; }
                    	}
                    	filenameList.add(file.getAbsolutePath());
                    	cntNumberOfFiles++;
                    }
                    if (cntNumberOfFiles>maxNumberOfFiles) return(cntNumberOfFiles);
                }
            }
        }
        return(cntNumberOfFiles);
	}
}
