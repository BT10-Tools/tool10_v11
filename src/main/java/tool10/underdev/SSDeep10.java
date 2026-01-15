package tool10.underdev;

import net.k_pan.ssdeep4j.FuzzyComparator;
import net.k_pan.ssdeep4j.FuzzyHasher;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class SSDeep10 {

	private static final String dirName = "C:\\tmp\\similarity\\ssdeep"; 
	private static final String[] fileNameList2 = new String[] { 
	"031.010.20401.pdf",	"174-176+Changes+in+the+Silk+Industry+in+Uzbekistan+in+the+Years+of+Independence+(1991-2021) - Copy.pdf",
	"174-176+Changes+in+the+Silk+Industry+in+Uzbekistan+in+the+Years+of+Independence+(1991-2021).pdf",
	"18BZO5EL-U2.pdf",	"18BZO65S-U2.pdf",	"19 TASAR-SERICULTURE---A-POTENTIAL-AGRO-BASED-ENTERPRISE-FOR-SUSTAINABLE-SOCIO--ECONOMIC-DEVELOPMENT.pdf",
	"1986-4 - Copy.pdf",	"1986-4.pdf",	"25_233.pdf",	"28-4-262-267_0.pdf",
	"31-2-133-136_0.pdf",	"371FDD3616208036592 - Copy.pdf",	"371FDD3616208036592.pdf",	"514ed1b1e4ea688b301bc39d58dde5b85a3f - Copy.pdf",
	"514ed1b1e4ea688b301bc39d58dde5b85a3f.pdf",	"61-68 - Copy.pdf",	"dirlist.txt",	"res.txt",
	"res2.txt",	"SERICULTURE PDF - Copy.pdf",	"SERICULTURE PDF.pdf",	"ST_ESCAP_888-EN.pdf",	"tr.ates - Copy.txt",	"tr.ates.txt",	"tr.bulac.txt",	"tr.diyanet.txt",
	"tr.golpinarli.txt",	"tr.ozturk.txt",	"tr.transliteration.txt",	"tr.vakfi.txt",	"tr.yazir.txt",	"tr.yildirim.txt",	"tr.yuksel.txt"};
	
	private static final String[] fileNameList = new String[] {	"tr.ates.txt" ,"tr.bulac.txt","tr.diyanet.txt",
			"tr.golpinarli.txt",	"tr.ozturk.txt",	"tr.transliteration.txt",	"tr.vakfi.txt",	"tr.yazir.txt",	"tr.yildirim.txt",	"tr.yuksel.txt"};
			
	public static String getSSsdeepHash4File(String fileName) {
		try {
			Path filePath = Paths.get(fileName);
            String hash = FuzzyHasher.hash(filePath);
            //System.out.println("Fuzzy Hash: " + hash);
            return(hash);
        } catch (IOException e) {
            e.printStackTrace();
            return(null);
        }
    }
	public static String getSSsdeepHash4ByteArray(byte[] bytes) {
		 try {
			 String hash = FuzzyHasher.hash(bytes);
	         //System.out.println("Fuzzy Hash: " + hash); // Fuzzy Hash: 3:a6/E:asE
	         return(hash);
		 } catch (IOException e) {
			 e.printStackTrace();
			 return(null);
	     }
	}
	public static int compareTwoSsdeepHash(String hash1, String hash2) {
		 int score = FuzzyComparator.compare(hash1, hash2);
		 return(score);
	}
	//*******************************************************
	private static String[][] tokenizeFile(String fileName)	{
		try {
			Path path = Paths.get(fileName);

		    BufferedReader reader = Files.newBufferedReader(path);
		    String all = reader.readAllAsString(); //.readLine();
		    reader.close();
		    
		    List<String> lines = new ArrayList<>();
		    StringTokenizer tokenizer = new StringTokenizer(all, "\n");
		    while (tokenizer.hasMoreElements()) {
		        lines.add(tokenizer.nextToken());
		    }
		    //System.out.println("all.length():"+all.length()+"  ,lines"+lines.size());
		    String[][] tknFile = new String[114][]; 
		    HashSet<Integer> sureSet = new HashSet<>();
		    ArrayList<String> ayetList = new ArrayList<>(); 
		    
		    for (String oneLine : lines)	{
		    	if (oneLine.isEmpty()) continue;
		    	if (oneLine.startsWith("#")) continue;
		    	
		    	List<String> part3 = new ArrayList<>();
			    StringTokenizer tokenizer2 = new StringTokenizer(oneLine, "|");
			    String[] parts = new String[3];
			    if (tokenizer2.hasMoreElements()) { parts[0] = tokenizer2.nextToken(); }
			    if (tokenizer2.hasMoreElements()) { parts[1] = tokenizer2.nextToken(); }
			    if (tokenizer2.hasMoreElements()) { parts[2] = tokenizer2.nextToken(); }
			    int sureNo = Integer.parseInt(parts[0]);
			    int ayetNo = Integer.parseInt(parts[1]);
			    String ayet = parts[2];
			    
			    if (!sureSet.contains(sureNo))	{
			    	//System.out.println("sureNo"+sureNo+" ,ayetList.size():"+ayetList.size());
			    	sureSet.add(sureNo);
			    	if (!ayetList.isEmpty())	{
			    		tknFile[sureNo-1] = new String[ayetList.size()]; 
			    		for (int j=0; j<ayetList.size(); j++) { tknFile[sureNo-1][j] = ayetList.get(j);}
			    		//System.out.println("sureNo"+sureNo+" ,ayetList.size():"+ayetList.size()+"  ,tknFile[sureNo-1].length:"+tknFile[sureNo-1].length);
			    	}	
			    	ayetList.clear();
			    }	
			    ayetList.add(ayet);
		    }	
		    return(tknFile);

		} catch (IOException e)	{
			return(null);
		}	
	}
	private static void printList(ArrayList<String[][]> list)	{
		int a = 0;
		for (String listStr[][] : list)	{
			if (listStr==null) continue;
			for (int j=0; j<listStr.length; j++)	{
				if (listStr[j]==null) continue;
				for (int k=0; k<listStr[j].length; k++)	{
					if (listStr[j][k]==null) continue;
					System.out.println("[a,i,j] ["+a+","+j+","+k+"]"+listStr[j][k]);
				}	
			}	
			a++;
		}
	}
	public static void createHashListFromMealList(ArrayList<String[][]> mealList, ArrayList<String[][]> hashList)	{
		int a = 0;
		for (String mealStr[][] : mealList)	{
			if (mealStr==null) continue;
			String[][] hashArr = new String[mealStr.length][];
			for (int j=0; j<mealStr.length; j++)	{
				if (mealStr[j]==null) continue;
				hashArr[j] = new String[mealStr[j].length];
				//System.out.println("[a,j] ["+a+","+j+"]  hashArr[j].length:"+hashArr[j].length);
				for (int k=0; k<mealStr[j].length; k++)	{
					if (mealStr[j][k]==null) continue;
					hashArr[j][k] = getSSsdeepHash4ByteArray (mealStr[j][k].getBytes());
					//System.out.println("[a,i,j] ["+a+","+j+","+k+"]"+hashArr[j][k]);
				}	
			}
			hashList.add(hashArr);
			a++;
		}
	}
	public static void computeTwoHashArray(String[][] hashArr1, String[][] hashArr2, 
			String[][] mealArr1, String[][] mealArr2)	{
		long cntCompare =  0; 
		long sumScore =  0; 
		int cntScore =  0; 
		for (int a=0; a<hashArr1.length; a++)	{
		if (hashArr1[a]==null) continue;	
		for (int b=0; b<hashArr1[a].length; b++)	{
			for (int i=a; i<hashArr2.length; i++)	{
			if (hashArr2[i]==null) continue;	
			for (int j=0; j<hashArr2[i].length; j++)	{
				if ((a==i) && (j<=b)) continue;
				int score = compareTwoSsdeepHash(hashArr1[a][b], hashArr2[i][j]);
				if ((score<100) && (score>5))	{
					System.out.println("[a,b] -- [i,j]"+"["+a+","+b+"] -- ["+i+","+j+"] ,score:"+score+" \n    {" + mealArr1[a][b]+"}\n    {" + mealArr2[i][j]+"}\n");
					cntScore++;	
					sumScore += score;
				}
				cntCompare++;
			}
			}
			if (cntScore > 64*1024) return;
			//if (cntCompare > 1024l*1024*1024) return;
		}
		}
		System.out.println("cntCompare:" + cntCompare + "  ,cntScore" + cntScore + "  , avgScore:"+1.0d*sumScore/cntScore); 
	}
	public static void computeTwoHashArrayOrdered(String[][] hashArr1, String[][] hashArr2, 
			String[][] mealArr1, String[][] mealArr2)	{
		long cntCompare =  0; 
		long sumScore =  0; 
		int cntScore =  0; 
		for (int a=0; a<hashArr1.length; a++)	{
			if (hashArr1[a]==null) continue;
			if (hashArr2[a]==null) continue;
			for (int j=0; j<hashArr1[a].length; j++)	{
				if (hashArr1[a][j]==null) continue;
				if (hashArr2[a][j]==null) continue;
				
				int score = compareTwoSsdeepHash(hashArr1[a][j], hashArr2[a][j]);
				if ((score<100) && (score>20))	{
				//	System.out.println("[a,j] -- [a,j]"+"["+a+","+j+"] -- ["+a+","+j+"] ,score:"+score+" \n    {" + mealArr1[a][j]+"}\n    {" + mealArr2[a][j]+"}\n");
					cntScore++;	
					sumScore += score;
				}
				cntCompare++;
			}
			if (cntScore > 64*1024) return;
			//if (cntCompare > 1024l*1024*1024) return;
		}
		System.out.println("cntCompare:" + cntCompare + "  ,cntScore" + cntScore + "  , avgScore:"+1.0d*sumScore/cntScore); 
	}
	public static void simMeal()	{
		HashMap<String,String> mapFile2Hash = new HashMap<>();
		
		ArrayList<String[][]> mealList = new ArrayList<String[][]>();
		ArrayList<String[][]> hashList = new ArrayList<String[][]>();
		
		for (String fName : fileNameList)	{
			String fileName = dirName+"\\"+fName;
			mealList.add(tokenizeFile(fileName));
		}
		// print meal 
	//	printList(mealList);
		
		createHashListFromMealList(mealList, hashList);
		
		// print hashStr 
	//	printList(hashList);
		
	/*	for (int i=0; i<hashList.size(); i++)	{
			String[][] hashArr1 = hashList.get(i);
			String[][] mealArr1 = mealList.get(i);
			for (int j=0; j<hashList.size(); j++)	{
				String[][] hashArr2 = hashList.get(j);
				String[][] mealArr2 = mealList.get(j);
				computeTwoHashArray(hashArr1, hashArr2,mealArr1,mealArr2);
			}
		}
	*/	
		for (int i=0; i<hashList.size()-1; i++)	{
			for (int j=i+1; j<hashList.size(); j++)	{
				computeTwoHashArrayOrdered(hashList.get(i), hashList.get(j),mealList.get(i),mealList.get(j));		
			}
		}
		
	}
	public static void test1() {
		
		HashMap<String,String> mapFile2Hash = new HashMap<>();
		
		for (String fName : fileNameList)	{
			String fileName = dirName+"\\"+fName;
			String fileHash = getSSsdeepHash4File(fileName);
			mapFile2Hash.put(fileName, fileHash);
			
			System.out.println("SSDeep hash for fileName:" + fileName + "  ,fileHash" + fileHash); 
		}
		for (String fName1 : mapFile2Hash.keySet())	{
			String hash1 = mapFile2Hash.get(fName1);
			for (String fName2 : mapFile2Hash.keySet())	{
				String hash2 = mapFile2Hash.get(fName2);
				int score = compareTwoSsdeepHash(hash1, hash2);
				if (score>0)	{
					System.out.println("fileName:"+fName1+"   ,fileName2:"+fName2+"  score: " + score);
				}
			}
		}
		byte[] bytes = "Hello, world!".getBytes();
		String byteHashStr = getSSsdeepHash4ByteArray(bytes); 
		System.out.println("SSDeep hash for byte array bytes :" + bytes + "  ,byteHashStr" + byteHashStr);
		
		String hash1 = "3:a62AVpAFVEpFZgMFMEFZL:aELAFurNFME3";
		String hash2 = "3:a62AVpAFVEjDgMFMEFZL:aELAFuXFME3";

		int score = compareTwoSsdeepHash(hash1, hash2);
		System.out.println("Similarity Score: " + score); // Similarity Score: 20
	 }
	public static void main(String[] args) {
		//test1();
		simMeal();
	}	

}
