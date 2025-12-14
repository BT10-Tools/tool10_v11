package tool10.fileset.transform;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class ZipUtil {

	// methods from https://github.com/srikanth-lingala/zip4j/tree/master
	public static boolean isValidZipFile(String fileName)	{
		//Check if a zip file is valid, by Zi4J
		//Note: This will only check for the validity of the headers and not the validity of each entry in the zip file.
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			boolean isValid = zipFile.isValidZipFile();
			zipFile.close();
			return (isValid);
		} catch (Exception e)	{
			return(false);
		}
	}	
	public static String getZipFileComment(String fileName)	{
		//Get comment of a zip file
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			String comment = zipFile.getComment();
			zipFile.close();
			return (comment);
		} catch (Exception e)	{
			return(null);
		}
	}
	public static Charset getZipFileCharset(String fileName)	{
		//Get charset of a zip file
		//Returns user defined charset that was set by setCharset() method. 
		//If no charset was explicitly defined (by calling setCharset()), this method returns the default charset which zip4j uses, which is utf-8.
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			Charset charset = zipFile.getCharset();
			zipFile.close();
			return (charset);
		} catch (Exception e)	{
			return(null);
		}
	}
	public static boolean isPasswordProtected(String fileName)	{
		//Check if a zip file is password protected
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			boolean isEncrypted = zipFile.isEncrypted();
			zipFile.close();
			return (isEncrypted);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static boolean isSplitArchive(String fileName)	{
		//Check if a zip file is a split zip file
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			boolean isSplitArchive = zipFile.isSplitArchive();
			zipFile.close();
			return (isSplitArchive);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static boolean isUseUtf8CharsetForPasswords(String fileName)	{
		//no comment
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			boolean isUseUtf8CharsetForPasswords = zipFile.isUseUtf8CharsetForPasswords();
			zipFile.close();
			return (isUseUtf8CharsetForPasswords);
		} catch (Exception e)	{
			return(false);
		}
	}
	public static List<FileHeader> getFileHeaderList(String fileName)	{
		//Returns the list of file headers in the zip file. Returns an empty list if the zip file does not exist.
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			List<FileHeader> fileHeaderList = zipFile.getFileHeaders();
			zipFile.close();
			return (fileHeaderList);
		} catch (ZipException e)	{
			return(null);
		} catch (Exception e)	{
			return(null);
		}
	}
	public static boolean mergeSplitFiles(String fileName, String mergedFileName)	{
		//Merging split zip files into a single zip
		//this feature will merge a zip file which is split across several files into a single zip file:
		try {
			ZipFile zipFile = new ZipFile(fileName); 
			zipFile.mergeSplitFiles(new File(mergedFileName)); //"merged_zip_file.zip"));
			zipFile.close();
			return (true);
		} catch (Exception e)	{
			return(false);
		}
	}
	/*
	ZipParameters zipParameters = new ZipParameters();
	
	Remove a file/entry from a zip file
	new ZipFile("filename.zip").removeFile("fileNameInZipToRemove");  
	new ZipFile("filename.zip").removeFile("root-folder/folder1/fileNameInZipToRemove");
	If fileNameInZipToRemove represents a folder all the files and folders 
	under this folder will be removed as well (this is valid since v2.5.0 of Zip4j. All prior versions remove just the single entry even if it is a folder).
	
	Since v2.5.0 of Zip4j, it is possible to remove multiple files and folders from a zip file. You can now pass in a list as shown in the code below:
	ZipFile zipFile = new ZipFile("someZip.zip");
	List<String> filesToRemove = Arrays.asList("file1.txt", "file2.txt", "some-folder/", "some-new-folder-1/somefile.pdf");

	zipFile.removeFiles(filesToRemove);
 	
 	
 	Rename entries in the zip file
	There are three ways to rename an entry in a zip file with Zip4j. One way is to pass in a file header and the new file name:
	
	ZipFile zipFile = new ZipFile("sample.zip");
	FileHeader fileHeader = zipFile.getFileHeader("entry-to-be-changed.pdf");
	zipFile.renameFile(fileHeader, "new-file-name.pdf");
	Second way is to pass in just the file name to be changed (instead of the file header), and the new file name.
	
	new ZipFile("filename.zip").renameFile("entry-to-be-changed.pdf", "new-file-name.pdf");
	It is also possible to change multiple file names at once. In this case you have to use a map, with the key of the entry in the map being the entry to be changed, and the value of the map being the new file name:
	
	Map<String, String> fileNamesMap = new HashMap<>();
	fileNamesMap.put("firstFile.txt", "newFileFirst.txt");
	fileNamesMap.put("secondFile.pdf", "newSecondFile.pdf");
	fileNamesMap.put("some-folder/thirdFile.bin", "some-folder/newThirdFile.bin");
	new ZipFile("filename.zip").renameFiles(fileNamesMap);

	List all files in a zip
	List<FileHeader> fileHeaders = new ZipFile("zipfile.zip").getFileHeaders();
	fileHeaders.stream().forEach(fileHeader -> System.out.println(fileHeader.getFileName()));
	 	
	 */
	 
	
}
