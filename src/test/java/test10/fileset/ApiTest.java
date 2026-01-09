package test10.fileset;

import tool10.underdev.api.ApiF10;

public class ApiTest {

	//to test the APIs like used in the JShell  
	private static void testApi()	{
		var apiF10 = new ApiF10();
		apiF10.start();
		apiF10.printString();
		
		apiF10.getArgsCLI(null); //read
		
		apiF10.run();
		
		apiF10.printString();
		apiF10.end();
	}
	public static void main(String[] args) {
		testApi();
	}
	
}
