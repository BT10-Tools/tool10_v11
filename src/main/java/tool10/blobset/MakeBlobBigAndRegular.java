package tool10.blobset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeHash;

public class MakeBlobBigAndRegular {
	
	public static HashSet<NodeBlobEntity> createFileBlobsBig(NodeF10 f10, int blockSize, int minBigFileSize, 
			HashSet<NodeBlobEntity> setCacheBlobEntity)	{
		
		HashSet<NodeBlobEntity> setNodeBlobEntity = new HashSet<NodeBlobEntity>();
		ArrayList<NodeBlob> listNodeBlobBig = new ArrayList<>();
		String blobType="bigfile";
		long totalWritten2DbFileBlob = 0; 
		long totalWritten2DbBlobEntity = 0; 
		long totalBlobSize = 0 ; 
		for (NodeBlobEntity blobEntity : f10.getBlobSet().getListBlobEntity())	{
			if (setCacheBlobEntity.contains(blobEntity)) continue;
			if (blobEntity.getSourceSize() < minBigFileSize) continue;
			
			File2BlobReader blobReader = new File2BlobReader(blobEntity.getEntityName(), blockSize);
			byte[] fileBytesPart = blobReader.getNextBytes(); 
			if (fileBytesPart==null) continue;
		
			long partNumber = 0; 
			int cntWritten2DbBlob = 0;
			long sumBlobSize = 0 ; 
			while (fileBytesPart!=null)	{

				Long blobSize = (long) fileBytesPart.length;
				sumBlobSize += (long) fileBytesPart.length;
				NodeHash hash = MakeFileSetHash.createOneHashForBigFile(f10, blobSize, fileBytesPart);
				Long hashId = hash.getHashId();
			
				//public static NodeBlob createOneBlob(NodeF10 f10, Long blobEntityId, Long fileSize, String blobType, Long cntPart,Long partNumber,
				//byte[] blobBytes, Long hashId)	{
				NodeBlob blob = MakeBlobSetTables.createOneBlob(f10,blobEntity.getBlobEntityId(),blobEntity.getSourceSize(),blobType,null,partNumber,fileBytesPart,hashId);
				listNodeBlobBig.add(blob);
				//MakeFileBlobAndBlob.updateOneBlobBytes(f10, blob, fileBytesPart);
				
				cntWritten2DbBlob += MakeBlobSetTables.writeBlob2Db (f10.getConnBlob().getConn(), blob);
				
				fileBytesPart = blobReader.getNextBytes();
				if (fileBytesPart!=null) partNumber++;
			}
			blobReader.closeAll();
			setNodeBlobEntity.add(blobEntity);
			int cntWritten2DbFileBlob 	= MakeBlobSetTables.writeFileBlob2Db (f10.getConn10().getConn(), blobEntity.getRefFileBlob());
			int cntWritten2DbBlobEntity = MakeBlobSetTables.writeBlobEntity2Db (f10.getConnBlob().getConn(), blobEntity);
			
			System.out.println("MakeBlobBigAndRegular createBlobEntityRegular cntWritten2DbFileBlob:"+cntWritten2DbFileBlob+
					" ,cntWritten2DbBlobEntity:"+cntWritten2DbBlobEntity+"  ,cntWritten2DbBlob:"+cntWritten2DbBlob + " ,sumBlobSize:" + sumBlobSize );
			
			totalWritten2DbFileBlob  += cntWritten2DbFileBlob;
			totalWritten2DbBlobEntity += cntWritten2DbBlobEntity; 
			totalBlobSize += sumBlobSize;
		}
		for (NodeBlob blob : listNodeBlobBig)	{
			blob.setCntPart((long) listNodeBlobBig.size());
		}
		System.out.println("MakeBlobBigAndRegular createBlobEntityRegular totalWritten2DbFileBlob:"+totalWritten2DbFileBlob+
				" ,totalWritten2DbBlobEntity:"+totalWritten2DbBlobEntity+ " ,totalBlobSize:" + totalBlobSize );
		return(setNodeBlobEntity);
	}
	public static HashSet<NodeBlobEntity> createBlobEntityRegular(NodeF10 f10, int blockSize, 
			HashMap<NodeBlobEntity,Integer> mapBlobEntity2BinNumber, 
			HashSet<NodeBlobEntity> setNodeBlobEntityBig, HashSet<NodeBlobEntity> setCacheBlobEntity)	{
		
		HashSet<NodeBlobEntity> setBlobEntityRegular = new HashSet<NodeBlobEntity>(); 
		for (NodeBlobEntity blobEntity : f10.getBlobSet().getListBlobEntity())	{
			if (mapBlobEntity2BinNumber.get(blobEntity) != null) continue;
			if (setNodeBlobEntityBig.contains(blobEntity)) continue;
			if (setCacheBlobEntity.contains(blobEntity)) continue;
			
			byte[] fileBytesRegular = File2BlobReader.readRegularFileBytes(blobEntity.getEntityName()); //entityName = fileNameAbsolute);
			
			if (fileBytesRegular==null) continue;
			String blobType="regularfile";
			Long blobSize = (long) fileBytesRegular.length;
			
			NodeHash hash = MakeFileSetHash.createOneHashForRegularFile(f10, blobSize, fileBytesRegular);
			Long hashId = hash.getHashId();
			blobEntity.setHashId(hashId);
			blobEntity.getRefFileBlob().setHashId(hashId);
			
			//public static NodeBlob createOneBlob(NodeF10 f10, Long blobEntityId, Long fileSize, String blobType, Long cntPart,Long partNumber,
			//byte[] blobBytes, Long hashId)	{
			NodeBlob blob = MakeBlobSetTables.createOneBlob(f10,blobEntity.getBlobEntityId(),blobEntity.getSourceSize(),blobType,1l,0l,fileBytesRegular,hashId);
			//MakeFileBlobAndBlob.updateOneBlobBytes(f10, blob, fileBytesRegular);
			
			int cntWritten2DbFileBlob 	= MakeBlobSetTables.writeFileBlob2Db (f10.getConn10().getConn(), blobEntity.getRefFileBlob());
			int cntWritten2DbBlobEntity = MakeBlobSetTables.writeBlobEntity2Db (f10.getConnBlob().getConn(), blobEntity);
			int cntWritten2DbBlob 		= MakeBlobSetTables.writeBlob2Db (f10.getConnBlob().getConn(), blob);
			System.out.println("MakeBlobBigAndRegular createBlobEntityRegular cntWritten2DbFileBlob:"+cntWritten2DbFileBlob+
					" ,cntWritten2DbBlobEntity:"+cntWritten2DbBlobEntity+"  ,cntWritten2DbBlob:"+cntWritten2DbBlob + " ,blobSize:" + blobSize );
		}
		return(setBlobEntityRegular);
	}
}
