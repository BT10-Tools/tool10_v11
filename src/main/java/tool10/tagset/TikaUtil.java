package tool10.tagset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.ocr.TesseractOCRConfig;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
//import org.apache.tika.langdetect.optimaize.OptimaizeLangDetector;
//import org.apache.tika.language.detect.LanguageDetector;
//import org.apache.tika.language.detect.LanguageResult;

public class TikaUtil {

	static final int writeLimit = 10*1000*1000;
    public static void printMetadata(Metadata metadata)	{
    	//getting the list of all meta data elements 
    	try {	
    		String[] metadataNames = metadata.names();
	
    		for(String name : metadataNames) {		        
    			System.out.println(name + "::: " + metadata.get(name));
    		}
    	} catch (Exception e)	{
			e.printStackTrace();
		}  
    }
    public static HashMap<String,String> getMapMetadata(String fileName) {
    	Metadata metadata = null;
    	HashMap<String,String> mapMetadata = new HashMap<String,String>();
    	try {	
    	      //Assume that boy.jpg is in your current directory
    	      File file = new File(fileName); //"boy.jpg");

    	      TesseractOCRConfig config = new TesseractOCRConfig();
    	      config.setSkipOcr(true);
    	      ParseContext context = new ParseContext();
    	      context.set(TesseractOCRConfig.class, config);
    	        
    	      //Parser method parameters
    	      Parser parser = new AutoDetectParser();
    	      BodyContentHandler handler = new BodyContentHandler(writeLimit);
    	      metadata = new Metadata();
    	      FileInputStream inputstream = new FileInputStream(file);
    	      
    	      parser.parse(inputstream, handler, metadata, context);
    	      //System.out.println(handler.toString());
    	      
    	      inputstream.close();
    	      
    	      if (metadata!=null)	{
    	    		String[] metadataNames = metadata.names();
    	  	      	for(String name : metadataNames) {		        
    	  	      		mapMetadata.put(name,metadata.get(name));
    	  	      	}
    	      }
    	} catch (IOException e)	{
    	} catch (TikaException e)	{
    	} catch (SAXException e) {
			//e.printStackTrace();
		} catch (Exception e)	{
			//e.printStackTrace();
		}
    	return(mapMetadata);
	}
    public static String getContent(String fileName) {
    	String contentStr = null;
    	
    	try {	
    	      //Assume that boy.jpg is in your current directory
    	      File file = new File(fileName); //"boy.jpg");

    	      //Parser method parameters
    	      Parser parser = new AutoDetectParser();
    	      BodyContentHandler handler = new BodyContentHandler(writeLimit);
    	      Metadata metadata = new Metadata();
    	      FileInputStream inputstream = new FileInputStream(file);
    	      ParseContext context = new ParseContext();
    	      
    	      parser.parse(inputstream, handler, metadata, context);
    	      contentStr = handler.toString();

    	} catch (IOException e)	{
    	} catch (TikaException e)	{
    	} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e)	{
			e.printStackTrace();
		}
    	return(contentStr);
	}
    
    public static String getTikaLanguageDetection(String txt) {
    	String language =null;
    	/*
	    LanguageDetector detector = new OptimaizeLangDetector().loadModels();
	    LanguageResult result = detector.detect(txt);
	    language = result.getLanguage();
	    */
	    return(language);
    }
    
	public static TikaConfig getTikaConfig() {
	    try {
	    	TikaConfig tika = new TikaConfig();
	    	System.out.println("TikaUtil getTikaConfig TikaConfig tika: " + tika.toString());
	   	} catch (IOException e)	{	
			e.printStackTrace();
			return(null);
		} catch (TikaException e)	{
			e.printStackTrace();
			return(null);
		} catch (Exception e)	{
			e.printStackTrace();
			return(null);
		}
	    return(null);
    }
   
    @SuppressWarnings("deprecation")
	public static String getTikaMimeType(String fileName, TikaConfig tika) {
    	String mimetype =null;
    	File f = new File (fileName);
	    try {
	    	if (tika==null) {tika = new TikaConfig();}
	    	Metadata metadata = new Metadata();
	    	if (metadata==null) return(null);
	    	
	    	TikaInputStream tis = TikaInputStream.get(f, metadata); 
	    	if (tis==null) return(null);
	    	
	    	//TikaInputStream sets the TikaCoreProperties.RESOURCE_NAME_KEY
	    	//when initialized with a file or path
	    	mimetype = tika.getDetector().detect(tis, metadata).toString();
	    	tis.close();
	    	
	    	if ("application/octet-stream".equals(mimetype)) return("not detected");   
	    	if (mimetype==null) return(null);
	    	
	    	System.out.println("File " + f + " is " + mimetype);
	    	System.out.println("mimetype of the given file : " + mimetype);
	    } catch (FileNotFoundException e)	{  
	    	return(null);
	   	} catch (IOException e)	{	
			e.printStackTrace();
			return(null);
		} catch (TikaException e)	{
			e.printStackTrace();
			return(null);
		} catch (Exception e)	{
			e.printStackTrace();
			return(null);
		}
	    return(mimetype);
    }
    public static List<String> getExtensionListForMimeType(String mimeTypeStr)	{
    	//JODD UTIL, SimpleMagiccan also be used for mime extensions
    	List<String> detectedExtensions = null;
    	//List<String> expectedExtensions = Arrays.asList(".jpg", ".jpeg", ".jpe", ".jif", ".jfif", ".jfi");
		try {
			MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
			if (allTypes==null) return(null);
		    
			MimeType type = allTypes.forName(mimeTypeStr); //"image/jpeg");
		    if (type==null) return(null);
			
		    //String primaryExtension = type.getExtension();
		    //assertEquals(".jpg", primaryExtension);
		    detectedExtensions = type.getExtensions();
		    //assertThat(detectedExtensions).containsExactlyElementsOf(expectedExtensions);
		} catch (MimeTypeException e) {
			e.printStackTrace();
			return(null);
		} catch (Exception e)	{
			e.printStackTrace();
			return(null);
		}
	    return(detectedExtensions);
    }
    public static String getPrimaryExtensionForMimeType(String mimeTypeStr)	{
    	String primaryExtension = null;
    	//List<String> expectedExtensions = Arrays.asList(".jpg", ".jpeg", ".jpe", ".jif", ".jfif", ".jfi");
		try {
			MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
			if (allTypes==null) return(null);
			
		    MimeType type = allTypes.forName(mimeTypeStr); //"image/jpeg");
		    if (type==null) return(null);
		    
			primaryExtension = type.getExtension();
		    //assertEquals(".jpg", primaryExtension);
		} catch (MimeTypeException e) {
			e.printStackTrace();
			return(null);
		} catch (Exception e)	{
			e.printStackTrace();
			return(null);
		}
	    return(primaryExtension);
    }
    /**
     * Print the supported Tika Metadata models and their fields.
     */
    public static void printMetadataModelAndFields() {
    /*	try {	
            TikaCLI.main(new String[]{"--list-met-models"});
        } catch (Exception e)	{
        	
        }
    */    
    }
    
}
