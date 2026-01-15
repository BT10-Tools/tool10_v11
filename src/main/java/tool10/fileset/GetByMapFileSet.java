package tool10.fileset;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;
import tool10.fileset.nodes.NodeFileSet;

public class GetByMapFileSet {

	public static void updateAllMapsFileSet(NodeFileSet fileSet)	{
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
		for (NodeFileName fileName: fileSet.getListFileName())	{
			if (fileName.getFileId()!=null)	{
				NodeFile file = fileSet.getMapId2File().get(fileName.getFileId());
				fileName.setRefFile(file);
				file.setRefFileName(fileName);
			}
		}
		for (NodeFileProp fileProp: fileSet.getListFileProp())	{
			if (fileProp.getFileId()!=null)	{
				NodeFile file = fileSet.getMapId2File().get(fileProp.getFileId());
				fileProp.setRefFile(file);
				file.setRefFileProp(fileProp);
			}
		}
		for (NodeFileBlob fileBlob : fileSet.getListFileBlob())	{
			if (fileBlob.getFileId()!=null)	{
				fileSet.getMapFileId2FileBlob().put(fileBlob.getFileId(),fileBlob);
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
	public static Long getFileBlobId4FileId(NodeF10 f10, Long fileId)	{
		//returns the fileBlobId for the file
		if (fileId==null) return(null);
		if ((f10.getFileSet()==null))  return(null);
		NodeFileBlob nodeFileBlob = f10.getFileSet().getMapFileId2FileBlob().get(fileId);
		if (nodeFileBlob==null) return (null);
		return(nodeFileBlob.getFileBlobId());
	}
}
