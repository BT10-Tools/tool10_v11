package tool10.fileset.transform;

import java.util.ArrayList;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.FileUtil;

public class TransformFile {
	
	public static void transformOneFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, 
			NodeTransform nodeTransform, NodeFile nodeFile, String fileTmpDirName)	{
		
		//NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> archiveFileList, NodeFileSet outputFileSet, String fileTmpDirName
		
		FileUtil.createNestedDirectory(fileTmpDirName);
		System.out.println("TransformFile transformAllFiles transforming file nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute() + 
				", outputFileSet.getListFile().size():"+outputFileSet.getListFile().size());
		
		System.gc();
		
		String pkgName = "transformImagesJava"; //"transformImagesJava,transformImagesOther
		if ("transformImagesJava".equals(pkgName)) {
	
			String formatName = "png"; //JPEG";
			String extensionName = "png";
			String outputFilenameTemplate = fileTmpDirName+"\\F"+nodeFile.getFileId();
			
			ArrayList<String> fileList = TransformImagesJava.getTransformFileList(nodeFile.getFileNameAbsolute(), outputFilenameTemplate, fileTmpDirName, formatName, extensionName);
			if ((fileList!=null) && (fileList.size()>0) && (fileList.get(0)!=null))	{
				
				long fSize = FileUtil.getFileSize(fileList.get(0));
				nodeTransform.setTransformedFileSize(fSize);
				nodeTransform.setTmpFileName(fileList.get(0));
				nodeTransform.setCntFile((long) fileList.size());
				nodeTransform.setAlgorithmName(pkgName);
			}

		} else if ("transformImagesOther".equals(pkgName)) {
			//UnzipFileApache.unzipOneArchiveApache(f10, outputFileSet, nodeArchive, fileTmpDirName, nodeFile);
		} 
	}
	public static void cleanTemporaryDirectories( String fileSetTmpDirName)	{
		//it will be written  
		/*
		if ((FileUtil.getCountFilesRecursivelyInDirectory(fileTmpDirName)==0) && 
			(FileUtil.getCountDirectoriesRecursivelyInDirectory(fileTmpDirName)==1))	{  //if only one directory created in tmp directory
			FileUtil.deleteDirectoryRecursively(fileTmpDirName);
		} 	
		*/
	}
	
}
