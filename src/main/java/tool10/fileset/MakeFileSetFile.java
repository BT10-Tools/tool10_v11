package tool10.fileset;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;
import tool10.util.TraverseFiles;

public class MakeFileSetFile {

	private static NodeFile createOneFile(NodeF10 f10, NodeFileSet fileSet, File file, Long parentFileId, Long rootFileId)	{
		NodeFile newFile = null;
		if ((file==null) || (!file.exists())) {return(null);}
		try {
			Long fileSetId = fileSet.getFileSetId();
			Long fileSize = file.length();  //file.length() = null;
			String fileName = file.getName();
			String fileNameAbsolute = file.getAbsolutePath();
			if (parentFileId == null) {
				NodeFile parentFile = f10.getFileSet().getMapAbsoluteFileName2File().get(file.getParent());
				if (parentFile!=null)	{ parentFileId = parentFile.getFileId();}
			}
			String fileStatus = "ok";
			String fileRemark = null;
			String isDirectory = Boolean.toString(file.isDirectory());
			String isFile = Boolean.toString(file.isFile());
			
			String checkFileSizeResult = FileFilter.checkFileSize(f10, file, fileSize); 
			String checkFileNameResult = FileFilter.checkFileName(f10, file, fileName, fileNameAbsolute);
			if ((!"ok".equals(checkFileSizeResult)) || (!"ok".equals(checkFileNameResult)))	{
				fileStatus = "filtered";
				fileRemark = "filesizecheck="+checkFileSizeResult+",filenamecheck="+checkFileNameResult;
				//public NodeFile(Long fileId, Long parentFileId, Long rootFileId, Long fileSize, String fileStatus, String fileName, 
				//	String fileNameAbsolute, String fileRemark,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
				newFile = new NodeFile(null, fileSetId,parentFileId, rootFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now());
			} else {
				newFile = new NodeFile(null, fileSetId, parentFileId, rootFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now());
			
				MakeFileSetFileFields.updateOneFileFields(f10, newFile, file, parentFileId, rootFileId);
			}
			String checkWholeNewFileResult = FileFilter.checkWholeNewFile(f10, file, newFile);
			
			if (!"ok".equals(checkWholeNewFileResult)) {
				fileStatus = "filtered";
				fileRemark = "wholefilecheck="+checkWholeNewFileResult;
				//create another new file, discrad all the fields calculated
				newFile = new NodeFile(null, fileSetId, parentFileId, rootFileId, fileSize, fileStatus, fileName, 
						fileNameAbsolute, isDirectory, isFile, fileRemark, ZonedDateTime.now());
				return(null);
			}
			Long fileId = f10.getConn10().getNextId(-1); //"BSC_BASIC");
			newFile.setFileId(fileId);
			fileSet.getListFile().add(newFile);
			fileSet.getMapId2File().put(newFile.getFileId(),newFile);
			fileSet.getMapAbsoluteFileName2File().put(newFile.getFileNameAbsolute(),newFile);
			
			NodeFileName nodeRootName = MakeFileSetFileName.createOneFileName(f10, fileSet, newFile, file, parentFileId, rootFileId, parentFileId, rootFileId);
			NodeFileProp nodeRootProp = MakeFileSetFileProp.createOneFileProp(f10, fileSet, newFile, file, parentFileId, rootFileId, parentFileId, rootFileId);
			
		} catch(Exception e)	{
			
		}
		return(newFile);
	}
	public static void updateParentId(NodeFileSet fileSet)	{
		//update parentFileId
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (nodeFile.getParentFileId() != null) continue;
			Path path = Paths.get(nodeFile.getFileNameAbsolute()); //"C:\\nh\\03_Downloaded"
			Path parentPath = path.getParent();
		    File parentFile = parentPath.toFile();
			NodeFile parentNodeFile = fileSet.getMapAbsoluteFileName2File().get(parentFile.getAbsolutePath());
			if (parentNodeFile==null) continue;
			Long parentFileId = parentNodeFile.getFileId();
			nodeFile.setParentFileId(parentFileId);
		}
	}
	public static int getCountSubstringInMainString(String mainString, String substring) {
        // Step 2: Count occurrences of the substring
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = mainString.indexOf(substring, fromIndex)) != -1) {
            count++;
            fromIndex += substring.length();
        }
        return(count); 
        //System.out.println("The substring '" + substring + "' occurs " + count + " times.");
	}
	public static int getCountCharInMainString(String mainString, char subChar) {
		long count = mainString.chars().filter(ch -> ch == subChar).count();
		//long count2 = mainString.codePoints().filter(ch -> ch == 'e').count();
		return((int) count);
	}
	public static int getDepthOfRoot(HashMap<Long,Long> mapRootFileId2Depth, NodeFile nodeFile)	{
		int depthOfRoot = -1;  
		//burada daha hıslı bir versiyon gellebilir
		//if ((mapRootFileId2Depth==null) || (nodeFile==null)) return(-1); 
		//if (nodeFile.getRootFileId())
		if (mapRootFileId2Depth.get(nodeFile.getRootFileId())==null)	{
			
		}
		return(depthOfRoot);
	}
	public static void updateDepths(NodeFileSet fileSet)	{
		int depthOfRoot = -1;  
		//HashMap<Long,Long> mapRootFileId2Depth = new HashMap<Long,Long>(); 
		String nlStr = "\\";
		char  nlChar = '\\';
		for (NodeFileName nodeFileName : fileSet.getListFileName())	{
			if ((nodeFileName.getDepth()!=null) || (nodeFileName.getDepthFromRoot()!=null)) continue;
			int depth = -1;
			String fileNameRelative = nodeFileName.getFileNameRelative();
			if (fileNameRelative==null)	{ 
				depth = 0; 
			} else if (getCountCharInMainString(fileNameRelative,nlChar)==1)	{ 
				depth = 1;
		    } else {
				depth = getCountCharInMainString(fileNameRelative,nlChar);
			}
			depthOfRoot = getCountCharInMainString(nodeFileName.getFileNameAbsolute(),nlChar);
			//depthOfRoot = getDepthOfRoot(mapRootFileId2Depth, nodeFile);
			nodeFileName.setDepth((long) (depth+1));
			nodeFileName.setDepthFromRoot((long) (depth+depthOfRoot));
		}
	}
	public static long updateDirectoryFilesize(NodeFileSet fileSet, NodeFile nodeFile)	{
		if (!"true".equals(nodeFile.getIsDirectory())) return(0l);  //it is not a directory
		long dirSize = 0l; 
		//first the directories
		for (NodeFile oneDir : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneDir.getIsDirectory())) continue;  //it is not a directory
			dirSize += updateDirectoryFilesize(fileSet, oneDir);
		}
		//second the files
		for (NodeFile oneFile : nodeFile.getListSiblingFile())	{
			if (!"true".equals(oneFile.getIsFile())) continue;  //it is not a file
			dirSize += oneFile.getFileSize().longValue();
		}	
		System.out.println("updateDirectoryFilesize nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute()+
				"   ,dirSize:"+dirSize +" ,nodeFile.getListSiblingFile().size():"+nodeFile.getListSiblingFile().size());
		nodeFile.setFileSize(dirSize);
		return(dirSize);
	}
	public static void updateSiblingLists(NodeFileSet fileSet)	{
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (nodeFile.getParentFileId()==null) continue;
			NodeFile nodeParentFile = fileSet.getMapId2File().get(nodeFile.getParentFileId());
			if (nodeParentFile==null) continue;
			nodeParentFile.getListSiblingFile().add(nodeFile);
		}
		//sort all the directory sibling lists
		for (NodeFile nodeFile : fileSet.getListFile())	{
			if (!"true".equals(nodeFile.getIsDirectory())) continue;  //it is not a directory
			nodeFile.sortListSiblingFile();
			System.out.println("updateSiblingLists sorting nodeFile.getFileNameAbsolute():"+nodeFile.getFileNameAbsolute()+
					" ,nodeFile.getListSiblingFile().size():"+nodeFile.getListSiblingFile().size());
		}	
	}
	public static void createFilesForRootFile(NodeF10 f10, NodeFileSet fileSet, String rootFileName)	{
		//will be written
	}
	public static void createFilesForRootDrive(NodeF10 f10, NodeFileSet fileSet, String rootFileName)	{
		//will be written
	}
	public static void createFilesForRootDirectory(NodeF10 f10, NodeFileSet fileSet,  String rootFileName)	{
		System.out.println("MakeFileSetFile createFilesForRootDirectory file processing rootFileName:"+rootFileName );
		
		if (rootFileName==null) return; 
		Path path = Paths.get(rootFileName); //"C:\\nh\\03_Downloaded"
		
	    File rootFile = path.toFile();
	    if ((rootFile==null)|| (!rootFile.exists())) return;
	    
		Long parentFileId = null; 
		Long rootFileId = null;
		NodeFile nodeRoot = createOneFile(f10, fileSet, rootFile, parentFileId, rootFileId);
		fileSet.getListRoots().add(nodeRoot);
		if (!"true".equals(nodeRoot.getIsDirectory())) return; //if the root is  a file just return
			
		ArrayList<String> fileNameList = new ArrayList<String>();
		String[] extArray = new String[] {"pdf"}; 
		int maxNumberOfFiles = 256*1024;
		int cntNumberOfFiles = TraverseFiles.traverseFiles(fileNameList, extArray,rootFile,maxNumberOfFiles);
		if (cntNumberOfFiles > maxNumberOfFiles)	{
			System.out.println("MakeFileSetFile createFilesForRootDirectory file number exceeded maximum cntNumberOfFiles:"+cntNumberOfFiles + 
					", maxNumberOfFiles:"+ maxNumberOfFiles +", fileNameList.size():"+fileNameList.size());
		}
		System.out.println("MakeFileSetFile createFilesForRootDirector rootFileName:"+rootFileName+ " ,cntNumberOfFiles:"+cntNumberOfFiles); 
		for (String fileName : fileNameList)	{
			Path filePath = Paths.get(fileName);
			if (filePath==null) continue;
			File processFile = filePath.toFile();
			if ((processFile==null) || (!processFile.exists())) continue;
			NodeFile addedFile = createOneFile(f10, fileSet, processFile, parentFileId, nodeRoot.getFileId());
			System.out.println("MakeFileSetFile createFilesForRootDirector filePath.toString():"+filePath.toString()+ " ,addedFile:"+addedFile);
		}
		System.out.println("MakeFileSetFile createFilesForRootDirector fileSet.getListFile().size():"+fileSet.getListFile().size());
		
		updateParentId(fileSet);
		updateDepths(fileSet);  //fileName
		updateSiblingLists(fileSet);
		updateDirectoryFilesize(fileSet, nodeRoot);
	}
}
