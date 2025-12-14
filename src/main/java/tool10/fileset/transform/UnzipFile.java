package tool10.fileset.transform;

import tool10.fileset.MakeFileSetFile;
import tool10.fileset.nodes.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.FileUtil;

public class UnzipFile {
	
	public static void unzipOneArchiveFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, 
			NodeArchive nodeArchive, NodeFile nodeFile, String fileTmpDirName, char[] password)	{
		
		//NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> archiveFileList, NodeFileSet outputFileSet, String fileTmpDirName
		
		String pkgName = "zip4j"; //"jdk", "apache"
		if ("jdk".equals(pkgName)) {
			UnzipFileJdk.unzipOneArchive(f10, outputFileSet, nodeArchive, fileTmpDirName, nodeFile);	
		} else if ("apache".equals(pkgName)) {
			UnzipFileApache.unzipOneArchiveApache(f10, outputFileSet, nodeArchive, fileTmpDirName, nodeFile);
		} else if ("zip4j".equals(pkgName)) {
			UnzipFileZip4J.extractAll(nodeFile.getFileNameAbsolute(), fileTmpDirName, password);
		}
		
		if ((FileUtil.getCountFilesRecursivelyInDirectory(fileTmpDirName)==0) && 
			(FileUtil.getCountDirectoriesRecursivelyInDirectory(fileTmpDirName)==1))	{  //if only one directory created in tmp directory
			FileUtil.deleteDirectoryRecursively(fileTmpDirName);
		} else {	
			MakeFileSetFile.createFilesForRootDirectory(f10, outputFileSet, fileTmpDirName);
			System.out.println("UnzipFileSet unzipAllFiles unzipping file nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute() + 
				", outputFileSet.getListFile().size():"+outputFileSet.getListFile().size());
		}
	}
	
}
