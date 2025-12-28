package tool10.fileset.transform;

import tool10.f10.NodeF10;
import tool10.fileset.MakeFileSetFile;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.FileUtil;

public class UnembedFile {
	
	public static void unembedOneContainerFile(NodeF10 f10, NodeFileSet fileSet, NodeFileSet outputFileSet, 
			NodeContainer nodeContainer, NodeFile nodeFile, String fileTmpDirName)	{
		
		//NodeF10 f10, NodeFileSet fileSet, ArrayList<NodeFile> archiveFileList, NodeFileSet outputFileSet, String fileTmpDirName
		
		FileUtil.createNestedDirectory(fileTmpDirName);
		System.out.println("UnzipFileSet unzipAllFiles unzipping file nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute() + 
				", outputFileSet.getListFile().size():"+outputFileSet.getListFile().size());
		
		System.gc();
		
		String pkgName = "imagesFromPdf"; //"imagesFromPdf,pdfPagesAsImages
		if ("imagesFromPdf".equals(pkgName)) {
			/*String fileName = "C:\\nh\\09_DocSimilarity\\99_Unclassified\\master_Nguyen_Khoa_2024.pdf";
			String tmpDirectoryName = "C:\\tmp\\similarity\\tmppdf2";
			String outputFilenameTemplate = tmpDirectoryName+"\\master_Nguyen_Khoa_2024_imgfile";
			int[] pageArray = null; //new int[] {0,1,2,3};
			long dpi=600; //72; 
			*/
			String formatName = "PNG"; //JPEG";
			String extensionName = "png";
			String outputFilenameTemplate = fileTmpDirName+"\\F"+nodeFile.getFileId();
			
			UnembedPdfGetImages.getImageFileList2(nodeFile.getFileNameAbsolute(), outputFilenameTemplate, fileTmpDirName, formatName, extensionName);

		} else if ("pdfPagesAsImages".equals(pkgName)) {
			//UnzipFileApache.unzipOneArchiveApache(f10, outputFileSet, nodeArchive, fileTmpDirName, nodeFile);
		} 
		
		if ((FileUtil.getCountFilesRecursivelyInDirectory(fileTmpDirName)==0) && 
			(FileUtil.getCountDirectoriesRecursivelyInDirectory(fileTmpDirName)==1))	{  //if only one directory created in tmp directory
			FileUtil.deleteDirectoryRecursively(fileTmpDirName);
		} else {	
			MakeFileSetFile.createFilesForRootDirectory(f10, outputFileSet, fileTmpDirName);
			System.out.println("UnembedFile unembedOneContainerFile unembed file nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute() + 
				", outputFileSet.getListFile().size():"+outputFileSet.getListFile().size());
		}
	
	}
	
}
