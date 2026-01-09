package tool10.blobset;

public class GetByMapBlobSet {

	public static void updateAllMapsBlobSet(NodeBlobSet blobSet)	{
	/*	for (NodeFileBlobOld fileBlob : fileSet.getListFileBlob())	{
			if (fileBlob.getFileId()!=null)	{
				NodeFile nodeFile = fileSet.getMapId2File().get(fileBlob.getFileId());
				if (nodeFile!=null)	{ 
					if ("bigfile".equals(fileBlob.getBlobType())) 			nodeFile.getListFileBlobBig().add(fileBlob);
					else if ("regularfile".equals(fileBlob.getBlobType())) 	nodeFile.getListFileBlobRegular().add(fileBlob);
				}
			}
		}
		for (NodeFileBlobSmall fileBlobSmall : fileSet.getListFileBlobSmall())	{
			if (fileBlobSmall.getFileId()!=null)	{
				NodeFile nodeFile = fileSet.getMapId2File().get(fileBlobSmall.getFileId());
				if (nodeFile!=null)	{ nodeFile.getListFileBlobSmall().add(fileBlobSmall);}
			}
		}
	*/	
		for (NodeBlobEntity blobEntity : blobSet.getListBlobEntity())	{
			if (blobEntity.getEntityId()!=null)	{
				blobSet.getMapEntityId2BlobEntity().put(blobEntity.getEntityId(),blobEntity);
			}
		}
	/*	int cntAddedField=0;
		for (NodeField statField: ai.getListField())	{
			if (statField.getFieldTypeId()==null) continue;
			NodeFieldType fieldType = ai.getMapId2FieldType().get(statField.getFieldTypeId());
			if (fieldType==null) continue;
			fieldType.getListField().add(statField);
			cntAddedField++;
		}
		System.out.println("postProcessAi: total records added to fieldType.getListField()  cntAddedField = " + cntAddedField);
	*/	
	}
	
}
