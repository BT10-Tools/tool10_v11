package tool10.fileset;

import java.io.File;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.util.TraverseFiles;

public class MakeFileSetFileFields {

/*
	private static NodeFileType createFileType(Conn10 conn10,NodeFileSet corpus, String fileTypeName, String fileTypeDesc, String groupName)	{		
		Long modelTypeId = conn10.getNextId(-1); //"BSC_BASIC");
		ZonedDateTime creationDate = ZonedDateTime.now();
		//public NodeModelType(Long modelTypeId, Long aiId, String modelTypeName, String modelTypeDesc, String groupName,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		NodeModelType modelType = new NodeModelType(modelTypeId,ai.getAiId(), modelTypeName, modelTypeDesc, groupName, creationDate, null);
		ai.getListModelType().add(modelType);
		ai.getMapId2ModelType().put(modelType.getModelTypeId(),modelType);
		return(modelType);
		
		return(null);
	}
*/

	public static void updateOneFileFields(NodeF10 f10, NodeFile newFile, File file, Long parentFileId, Long rootFileId)	{
		try {
			Long fileTypeId = null;
			Long sourceId = null;
			Long hashCode = (long) file.hashCode();;
			Long hashId = null;
	
			String fileType = (file.isDirectory() ? "dir" : (file.isFile() ? "file" : "other")) ; //file, directory, link
			String linkType = null; //softlink, hardlink
			Long linkedId = null;
			String extensionName = TraverseFiles.getFileExtension(newFile.getFileName());
			
			//public void updateFields(Long fileTypeId, Long sourceId, Long hashCode, Long hashId,
			//		String fileType, String linkType, Long linkedId, String extensionName) {
			newFile.updateFields(fileTypeId,sourceId,hashCode,hashId,fileType,linkType,linkedId,extensionName);
			
		} catch(Exception e)	{
			
		}
	}

}
