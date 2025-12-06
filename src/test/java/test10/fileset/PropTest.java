package test10.fileset;

import tool10.fileset.PropConfig;

public class PropTest {

	public static void main(String[] args) {
		PropTest prop = new PropTest();
		
		String fileName = "config.properties";
		PropConfig.writeProp(fileName);
		PropConfig.readProp(fileName);
		
		PropConfig.printAll(prop.getClass(),fileName);
	}
}
