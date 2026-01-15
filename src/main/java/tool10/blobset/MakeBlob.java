package tool10.blobset;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.sql.Conn10;

public class MakeBlob {
	
	private static void printBlobSummary(NodeF10 f10, HashMap<NodeBlobEntity,Integer> mapBlobEntity2BinNumber, 
			HashSet<NodeBlobEntity> setBlobEntityBig, HashSet<NodeBlobEntity> setBlobEntityRegular)	{
		long sumBlobSize = 0l; 
		long sumCompressedSize = 0l;
		for (NodeBlob blob : f10.getBlobSet().getListBlob())	{
			sumBlobSize += blob.getBlobSize();   
			sumCompressedSize += blob.getCompressedSize();
		}
		System.out.println("MakeBlob printBlobSummary f10.getFileSet().getListBlob().size():"+f10.getBlobSet().getListBlob().size() + 
				" ,sumBlobSize:"+sumBlobSize + " ,sumCompressedSize:"+sumCompressedSize);
		
		for (NodeBlobEntity blobEntity : mapBlobEntity2BinNumber.keySet())	{
			
		}
		System.out.println("MakeBlob printBlobSummary setBlobEntityBig.size():"+setBlobEntityBig.size()); 
		System.out.println("MakeBlob printBlobSummary setBlobEntityRegular.size():"+setBlobEntityRegular.size()); 
		
		//HashSet<NodeFile> setNodeFileBig 
		//HashSet<NodeFile> setNodeFileRegular 
	}
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
		
	//	MakeFileSetBlobDatabase.createBlobDatabase(f10);
		
		int blockSize = 96*1024*1024;
		int binSize = blockSize; 
		int minFileSizeForPacking = (4*binSize / 5); 
		int minBigFileSize = 64*1024*1024;
		
		HashMap<NodeBlobEntity,Integer> mapBlobEntity2BinNumber = MakeBlobSmallFile.createBlobEntitySmall(f10, blockSize, binSize, minFileSizeForPacking, setCacheBlobEntity);
		HashSet<NodeBlobEntity> setBlobEntityBig = MakeBlobBigAndRegular.createBlobEntityBig(f10,blockSize, minBigFileSize, setCacheBlobEntity);
		HashSet<NodeBlobEntity> setBlobEntityRegular = MakeBlobBigAndRegular.createBlobEntityRegular(f10,blockSize, mapBlobEntity2BinNumber, setBlobEntityBig, setCacheBlobEntity);
		
		printBlobSummary(f10, mapBlobEntity2BinNumber, setBlobEntityBig, setBlobEntityRegular); 
	}
	public static int createBlobEntitiesFromFileList(NodeF10 f10, ArrayList<NodeFile> fileList4Blob)	{
		//public static NodeBlobEntity createOneBlobEntity(NodeF10 f10, Long blobId, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId, String entityName)	{
		int cntCreated = 0;
		for (NodeFile nodeFile : fileList4Blob)	{
			NodeBlobEntity blobEntity = MakeBlobSetTables.createOneBlobEntity(f10, null, nodeFile.getFileId(), nodeFile.getFileSize(),null,"file",null,nodeFile.getFileNameAbsolute() );
			if (blobEntity!=null) {
				cntCreated++;
			} 
		}
		System.out.println("MakeBlobSet createBlobEntitiesFromFileList f10.getBlobSet().getListBlobEntity().size():"+f10.getBlobSet().getListBlobEntity().size() + 
				"    ,cntCreated:"+cntCreated);
		return(cntCreated);
	}
	public static int createFileBlobFromBlobEntities(NodeF10 f10)	{
		//public static NodeFileBlob createOneFileBlobs(NodeF10 f10, Long fileId, Long fileSize, Long blobSize, String blobType, Long hashId)	{
		int cntCreated = 0;
		for (NodeBlobEntity blobEntity : f10.getBlobSet().getListBlobEntity())	{
			NodeFileBlob fileBlob = MakeBlobSetTables.createOneFileBlob(f10, null, blobEntity.getEntityId(), blobEntity.getSourceSize(),"file",null);
			blobEntity.setRefFileBlob(fileBlob);
			if (fileBlob!=null) {
				fileBlob.setRefBlobEntity(blobEntity);
				cntCreated++;
			} 
		}
		System.out.println("MakeBlobSet createFileBlobFromBlobEntities f10.getFileSet().getListFileBlob().size():"+f10.getFileSet().getListFileBlob().size() + 
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
		createFileBlobFromBlobEntities(f10);
		
		createBlobs(f10);
				
		//ReadBookTablesFromDb.postProcessBookSet(tagSet);
		
	//	printAllListsAndMaps(blobSet);
		
		return(blobSet);
	}
}
