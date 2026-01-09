package tool10.blobset;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.bookset.MakeBookSetTables;
import tool10.bookset.MakeBookSetTanzil;
import tool10.bookset.NodeBook;
import tool10.bookset.NodeBookBlob;
import tool10.bookset.NodeBookFile;
import tool10.bookset.NodeBookSet;
import tool10.f10.NodeF10;
import tool10.fileset.CreateFileSetTables;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeHash;
import tool10.sql.Conn10;

public class MakeBlob {
	
	private static void printBlobSummary(NodeF10 f10, HashMap<NodeFile,Integer> mapNodeFile2BinNumber, 
			HashSet<NodeFile> setNodeFileBig, HashSet<NodeFile> setNodeFileRegular)	{
		long sumBlobSize = 0l; 
		long sumCompressedSize = 0l;
		for (NodeBlob blob : f10.getBlobSet().getListBlob())	{
			sumBlobSize += blob.getBlobSize();   
			sumCompressedSize += blob.getCompressedSize();
		}
		System.out.println("MakeFileSetBlob printBlobSummary f10.getFileSet().getListBlob().size():"+f10.getBlobSet().getListBlob().size() + 
				" ,sumBlobSize:"+sumBlobSize + " ,sumCompressedSize:"+sumCompressedSize);
		for (NodeFile smallFile : mapNodeFile2BinNumber.keySet())	{
			
		}
		System.out.println("MakeFileSetBlob printBlobSummary setNodeFileBig.size():"+setNodeFileBig.size()); 
		System.out.println("MakeFileSetBlob printBlobSummary setNodeFileRegular.size():"+setNodeFileRegular.size()); 
		
		//HashSet<NodeFile> setNodeFileBig 
		//HashSet<NodeFile> setNodeFileRegular 
	}
	public static void createFileBlobsXXX(NodeF10 f10)	{
	/*	if (!"yes".equals(f10.getCliParams().getBlob()))	{
			return;
		}
	*/	
		//create a set of already written file blobs , for not to compute them again
		HashSet<NodeFile> setCacheFile = new HashSet<>();
		for (NodeFileBlob fileBlob : f10.getFileSet().getListFileBlob())	{
			if (fileBlob.getFileId()==null) continue;
			NodeFile nodeFile = f10.getFileSet().getMapId2File().get(fileBlob.getFileId());
			setCacheFile.add(nodeFile);
		}
		
		MakeFileSetBlobDatabase.createBlobDatabase(f10);
		
		int blockSize = 96*1024*1024;
		int binSize = blockSize; 
		int minFileSizeForPacking = (4*binSize / 5); 
		int minBigFileSize = 64*1024*1024;
		
		HashMap<NodeFile,Integer> mapNodeFile2BinNumber = MakeBlobSmallFile.createFileBlobsSmall(f10, blockSize, binSize, minFileSizeForPacking, setCacheFile);
		HashSet<NodeFile> setNodeFileBig = MakeBlobBigAndRegular.createFileBlobsBig(f10,blockSize, minBigFileSize, setCacheFile);
		HashSet<NodeFile> setNodeFileRegular = MakeBlobBigAndRegular.createFileBlobsRegular(f10,blockSize, mapNodeFile2BinNumber, setNodeFileBig, setCacheFile);
		
		printBlobSummary(f10, mapNodeFile2BinNumber, setNodeFileBig, setNodeFileRegular); 
	}
	//**************************
	private static HashSet<NodeBlobEntity> getCacheBlobEntity(NodeF10 f10)	{
		//create a set of already written file blobs , for not to compute them again
		HashSet<NodeBlobEntity> setCacheBlobEntity = new HashSet<>();
		for (NodeBlobEntity blobEntity : f10.getBlobSet().getListBlobEntity())	{
			if (blobEntity.getBlobId()==null) continue;
			NodeBlobEntity nodeBlobEntity = f10.getBlobSet().getMapId2BlobEntity().get(blobEntity.getBlobEntityId());
			setCacheBlobEntity.add(nodeBlobEntity);
		}
		return(setCacheBlobEntity);
	}
	public static void createBlobs(NodeF10 f10)	{
		/*	if (!"yes".equals(f10.getCliParams().getBlob()))	{
				return;
			}
		*/	
		//create a set of already written file blobs , for not to compute them again
		HashSet<NodeBlobEntity> setCacheBlobEntity = getCacheBlobEntity(f10); 
		
		MakeFileSetBlobDatabase.createBlobDatabase(f10);
		
		int blockSize = 96*1024*1024;
		int binSize = blockSize; 
		int minFileSizeForPacking = (4*binSize / 5); 
		int minBigFileSize = 64*1024*1024;
		
		HashMap<NodeBlobEntity,Integer> mapNodeFile2BinNumber = MakeBlobSmallFile.createFileBlobsSmall(f10, blockSize, binSize, minFileSizeForPacking, setCacheBlobEntity);
		HashSet<NodeBlobEntity> setNodeFileBig = MakeBlobBigAndRegular.createFileBlobsBig(f10,blockSize, minBigFileSize, setCacheBlobEntity);
		HashSet<NodeBlobEntity> setNodeFileRegular = MakeBlobBigAndRegular.createFileBlobsRegular(f10,blockSize, mapNodeFile2BinNumber, setNodeFileBig, setCacheBlobEntity);
		
		printBlobSummary(f10, mapNodeFile2BinNumber, setNodeFileBig, setNodeFileRegular); 
	}
	public static int createBlobEntitiesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Blob)	{
		//public static NodeBlobEntity createOneBlobEntity(NodeF10 f10, Long blobId, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)	{
		int cntCreated = 0;
		for (NodeFile nodeFile : fileList4Blob)	{
			NodeBlobEntity blobEntity = MakeBlobSetTables.createOneBlobEntity(f10, null, nodeFile.getFileId(), nodeFile.getFileSize(),null,null,null);
			if (blobEntity!=null) {
				cntCreated++;
			} 
		}
		System.out.println("MakeBlobSet createBlobEntitiesFromFileList f10.getBlobSet().getListBlobEntity().size():"+f10.getBlobSet().getListBlobEntity().size() + 
				"    ,cntCreated:"+cntCreated);
		return(cntCreated);
	}
	public static ArrayList<NodeFile> getFileList4BlobFromFileSet(NodeF10 f10)	{
		
		ArrayList<NodeFile> fileList4Blob = new ArrayList<NodeFile>(); 
		String[] extArray = new String[] {"png","jpg"};
		int cnt = 0; 
		for (NodeFile nodeFile : f10.getFileSet().getListFile())	{
			if ("yes".equals(nodeFile.getIsDirectory())) continue;
			String symLink = (nodeFile.getRefFileProp()==null) ? null : nodeFile.getRefFileProp().getIsSymbolicLink();
			if ("yes".equals(symLink)) continue;
			//other filters can come here like wildcards
			
			//if (!"pdf".equals(nodeFile.getExtensionName())) continue; 
			//if (cnt++ > 10) break; //for test purpose, only process 100 files
			
			if (!nodeFile.getFileName().startsWith("tr.")) continue; 
			
			fileList4Blob.add(nodeFile);
		}
		System.out.println("MakeBlobSet getFileList4BlobFromFileSet fileList4Blob.size() = "+fileList4Blob.size());
		return(fileList4Blob);
	}	
	public static NodeBlobSet makeBlobSetFromFileSet(NodeF10 f10)	{
		NodeBlobSet blobSet = null;
		String blobSetName = f10.getCliParams().getBlobSetName();
		String sourceDir = null;
		blobSet = MakeBlobSetTables.createOneBlobSet(f10, f10.getFileSet().getFileSetId(),blobSetName,sourceDir);
		f10.setBlobSet(blobSet);
		System.out.println("MakeBlobSet makeBlobSetFromFileSet blobSet = "+blobSet);
		
		ArrayList<NodeFile> fileList4Blob = getFileList4BlobFromFileSet(f10);
		createBlobEntitiesFromFileList(f10, fileList4Blob);
		
		createBlobs(f10);
				
		//ReadBookTablesFromDb.postProcessBookSet(tagSet);
		
	//	printAllListsAndMaps(blobSet);
		
		return(blobSet);
	}
}
