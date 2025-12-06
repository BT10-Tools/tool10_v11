package tool10.fileset;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Properties;

import tool10.sql.Conn10;

public class MakeFileSetProperty {

	private static Map<String,String> getSystemEnv() {
		 
        Map<String,String> mapSystemEnv = System.getenv();
  
        for (Map.Entry<String, String> entry : mapSystemEnv.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return(mapSystemEnv);
    }
	private static Properties getSystemProperties() {
        Properties properties = System.getProperties();
  
        // Java 8
        properties.forEach((k, v) -> System.out.println(k + ":" + v));

        // Classic way to loop a map
        //for (Map.Entry<Object, Object> entry : properties.entrySet()) {
        //    System.out.println(entry.getKey() + " : " + entry.getValue());
        //}

        // No good, output is truncated, long lines end with ...
        //properties.list(System.out);
        
        return(properties);
    }
	private static NodeProperty createOneProperty(Conn10 conn10, NodeFileSet fileSet, Long entityId, Long displayOrder, String mapName,
			String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
			Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT)	{
		NodeProperty newProperty = null;
		//public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
		//String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
		//Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try {
			Long propertyId = conn10.getNextId(-1); //"BSC_BASIC");;
			ZonedDateTime creationDate = ZonedDateTime.now();
			ZonedDateTime modificationDate = null;
			newProperty = new NodeProperty(propertyId, fileSet.getFileSetId(), entityId, displayOrder, mapName, entityName, propertyKey, propertyValue, 
								valueString, valueLong,valueDouble, valueBinary, valueZDT,creationDate,modificationDate); 
			fileSet.getListProperty().add(newProperty);
			fileSet.getMapId2Property().put(newProperty.getPropertyId(),newProperty);
		} catch (Exception e)	{
		}
		return(newProperty);
	}
	private static void createPropertySystemEnv(Conn10 conn10, NodeFileSet fileSet, Long hostId) {
		Map<String,String> mapSystemEnv = System.getenv();
		Long displayOrder = 0l;
		String mapName = "SystemEnv";
		String entityName = "host";
	    for (Map.Entry<String, String> entry : mapSystemEnv.entrySet()) {
	        	createOneProperty(conn10, fileSet, hostId, displayOrder++, mapName,
	        			entityName, entry.getKey(), entry.getValue(), null,null,null,null,null);
	        	
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	    }
	}
	private static void createPropertySystemProperties(Conn10 conn10, NodeFileSet fileSet, Long hostId) {
        Properties properties = System.getProperties();
        
        Long displayOrder = 0l;
		String mapName = "SystemProperties";
		String entityName = "host";
	    for (Map.Entry<Object, Object> entry : properties.entrySet()) {
	    	createOneProperty(conn10, fileSet, hostId, displayOrder++, mapName,
        			entityName, (String) entry.getKey(), (String) entry.getValue(), null,null,null,null,null);
	    	
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // No good, output is truncated, long lines end with ...
        //properties.list(System.out);
    }

	public static void makeProperty(Conn10 conn10, NodeFileSet fileSet, Long hostId)	{
		createPropertySystemEnv(conn10, fileSet, hostId);
		createPropertySystemProperties(conn10, fileSet, hostId);
		
		
	}
	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");

        getSystemProperties();
        System.out.println("****************************************************************Selamun Aleyküm");
        getSystemEnv();
        
	}    
}
