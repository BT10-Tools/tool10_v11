package tool10.util;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class ByteEncryptionGenerator {

	private static void checkCipherAndDecipherArrays()	{
		System.out.println("checkCipherAndDecipherArrays checks");
		for (int a=0; a<=255; a++) {
			int b = ByteEncryption.getCipherArray()[a]; 
			int a2 = ByteEncryption.getDecipherArray()[b];
			if (a2!=a) {System.out.println("ERROR a!=a2");} 
		}
	}
	private static void generateByteSubstitutionMatrix(SortedMap<Integer,Integer> cipherMap, SortedMap<Integer,Integer> decipherMap)	{
		Random rnd = new Random();
		for (int a=0; a<=255; a++)	{
			System.out.print(a+",");
			if ((a % 16)==0) System.out.println(); 
			boolean found = false;
			while (!found)	{
				int b = rnd.nextInt(256);
				if (decipherMap.get(b)==null)	{
					cipherMap.put(a,b);
					decipherMap.put(b,a);
					found = true;
				}
			}
		}
		System.out.println(); 
		System.out.println("generateByteSubstitutionMatrix cipherMap.size():"+cipherMap.size());
		System.out.println("generateByteSubstitutionMatrix decipherMap.size():"+decipherMap.size());
		
		for (int a : cipherMap.keySet())  {
			System.out.print("("+a+":"+cipherMap.get(a)+"),");
			if ((a % 16)==0) System.out.println(); 
		}
		System.out.println();
		for (int a : cipherMap.keySet())  {
			System.out.print(cipherMap.get(a)+",");
			if ((a % 16)==0) System.out.println(); 
		}
		System.out.println();
		
		for (int a : decipherMap.keySet())  {
			System.out.print("("+a+":"+decipherMap.get(a)+"),");
			if ((a % 16)==0) System.out.println(); 
		}
		System.out.println();
		for (int a : decipherMap.keySet())  {
			System.out.print(decipherMap.get(a)+",");
			if ((a % 16)==0) System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
        System.out.println("Selamun Aleyküm");
        
        SortedMap<Integer,Integer> cipherMap = new TreeMap<>();
        SortedMap<Integer,Integer> decipherMap = new TreeMap<>();
		generateByteSubstitutionMatrix(cipherMap, decipherMap);
		
		checkCipherAndDecipherArrays();
	}    
}
