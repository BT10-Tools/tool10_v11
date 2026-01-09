package tool10.f10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropConfig {

	public PropConfig() {
		super();
		String fileName = "config.properties";
		this.properties = getProp(fileName);
	}
	private final java.util.Properties properties;
	
	//******
	public static Properties getProp(String fileName) {
		try (InputStream input = new FileInputStream(fileName)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
           
            // get the property value and print it out
         //   System.out.println(prop.getProperty("db.url"));
         //   System.out.println(prop.getProperty("db.user"));
         //   System.out.println(prop.getProperty("db.password"));
            
            return(prop);
        } catch (IOException ex) {
            ex.printStackTrace();
            return(null);
        }
	}
	
	public static void writeProp(String fileName) {

        try (OutputStream output = new FileOutputStream(fileName)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "file10");
            prop.setProperty("db.password", "password");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
	public static void readProp(String fileName) {
		try (InputStream input = new FileInputStream(fileName)) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
           
            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	public static void printAll(@SuppressWarnings("rawtypes") Class clazz, String filename) {
        try (InputStream input = clazz.getClassLoader().getResourceAsStream(filename)) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }
            prop.load(input);

            // Java 8 , print key and values
            prop.forEach((key, value) -> System.out.println("Key : " + key + ", Value : " + value));

            // Java 8 Get all keys
            prop.keySet().forEach(x -> System.out.println(x));

            Set<Object> objects = prop.keySet();
            /*
            Enumeration e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }
            */
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
	//GETTERS AND SETTERS
	public java.util.Properties getProperties() {
		return properties;
	}
	
}
