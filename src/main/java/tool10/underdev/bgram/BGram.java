package tool10.underdev.bgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import tool10.fileset.nodes.NodeBinary;

public class BGram {

	public BGram(long bGramId, Long fileId, Long sourceId, String bGramName, String bGramDesc, String bGramStatus,
			String bGramType, long cntBytes, long cntBGram) {
		super();
		BGramId = bGramId;
		this.fileId = fileId;
		this.sourceId = sourceId;
		BGramName = bGramName;
		BGramDesc = bGramDesc;
		BGramStatus = bGramStatus;
		BGramType = bGramType;
		this.cntBytes = cntBytes;
		this.cntBGram = cntBGram;
		
		initializeListsAndMaps();
	}

	private void initializeListsAndMaps()	{ 
		this.b1 = new long[2];  
		this.b4 = new long[16];
		this.b8 = new long[256];
		this.w16 = new long[256*256];
		this.w32 = new TreeMap<>();
		this.w64 = new TreeMap<>();
		this.b512 = new TreeMap<>();
		this.b1Norm = new double[2];
		this.b4Norm = new double[16];
		this.b8Norm = new double[256];
		this.w16Norm = new double[256*256];
		this.w32Norm = new TreeMap<>();
		this.w64Norm = new TreeMap<>();
		this.b512Norm = new TreeMap<>();
		for (int i=0; i < b1.length; i++) b1[i] = 0l;
		for (int i=0; i < b4.length; i++) b4[i] = 0l;
		for (int i=0; i < b8.length; i++) b8[i] = 0l;
		for (int i=0; i < w16.length; i++) w16[i] = 0l;
		for (int i=0; i < b1Norm.length; i++) b1Norm[i] = 0.0d;
		for (int i=0; i < b4Norm.length; i++) b4Norm[i] = 0.0d;
		for (int i=0; i < b8Norm.length; i++) b8Norm[i] = 0.0d;
		for (int i=0; i < w16Norm.length; i++) w16Norm[i] = 0.0d;
			
		this.listBGram = new ArrayList<BGram>();
		
		this.mapW32Crc2NodeBinaryList = new HashMap<Long,ArrayList<NodeBinary>>(); 
		this.mapW64Crc2NodeBinaryList = new HashMap<Long,ArrayList<NodeBinary>>() ;
	}
	public void clearListsAndMaps()	{ 
		for (int i=0; i < b1.length; i++) b1[i] = 0l;
		for (int i=0; i < b4.length; i++) b4[i] = 0l;
		for (int i=0; i < b8.length; i++) b8[i] = 0l;
		for (int i=0; i < w16.length; i++) w16[i] = 0l;
		for (int i=0; i < b1Norm.length; i++) b1Norm[i] = 0.0d;
		for (int i=0; i < b4Norm.length; i++) b4Norm[i] = 0.0d;
		for (int i=0; i < b8Norm.length; i++) b8Norm[i] = 0.0d;
		for (int i=0; i < w16Norm.length; i++) w16Norm[i] = 0.0d;
		
		this.w32.clear();
		this.w64.clear();
		this.b512.clear();
		this.w32Norm.clear();
		this.w64Norm.clear();
		this.b512Norm.clear();
		
		this.listBGram.clear(); 
		
		this.mapW32Crc2NodeBinaryList.clear();  
		this.mapW64Crc2NodeBinaryList.clear(); 
	}
	private long BGramId;
	private Long fileId;
	private Long sourceId;
	private String BGramName;
	private String BGramDesc;
	private String BGramStatus;  //new, updated, normalized, final etc.

	private String BGramType;  //basic, composite
	private long cntBytes; 
	private long cntBGram; 
	
	private static final int cntTopW32 = 1024*1024;
	private static final int cntTopW64 = 1024*1024;
	private static final int cntTop512 = 16*1024;
	
	//windowed or block 
	private long[] b1;  //1 bit counter, 2 elements, one bit
	private long[] b4;  //4 bit counter, 16 elements, half byte
	private long[] b8;  //8 bit counter, 256 elements, one byte 
	private long[] w16;  //16 bit counter, 256*256 elements, double byte 
	private SortedMap<NodeBinary,Long> w32;  //32 bit counter, 2**32 elements, only the top N, where possible  
	private SortedMap<NodeBinary,Long> w64;  //64 bit counter, 2**64 elements, only the top N, where possible  
	private SortedMap<NodeBinary,Long> b512;  //64 bit counter, 2**64 elements, only the top N, where possible  
	
	private double[] b1Norm;  //normalized frequencies, 1 bit counter, 2 elements, one bit
	private double[] b4Norm;  //normalized frequencies,4 bit counter, 16 elements, half byte
	private double[] b8Norm;  //normalized frequencies,8 bit counter, 256 elements, one byte 
	private double[] w16Norm;  //normalized frequencies,16 bit counter, 256*256 elements, one byte 
	private SortedMap<NodeBinary,Double> w32Norm;  //normalized frequencies,32 bit counter, floating windowed, 256*256 elements, one byte 
	private SortedMap<NodeBinary,Double> w64Norm;  //normalized frequencies,64 bit counter, floating windowed, 256*256 elements, one byte 
	private SortedMap<NodeBinary,Double> b512Norm;  //normalized frequencies,16 bit counter, 256*256 elements, one byte 
	
	private HashMap<Long,ArrayList<NodeBinary>> mapW32Crc2NodeBinaryList;
	private HashMap<Long,ArrayList<NodeBinary>> mapW64Crc2NodeBinaryList;
	
	private ArrayList<BGram> listBGram;
	
	public String getPrintString()	{
		String str = "BGramId:"+BGramId+"\nfileId:"+fileId+"\nsourceId:"+sourceId+"\nBGramName:"+BGramName+
			"\nBGramDesc:"+BGramDesc+"\nBGramStatus:"+BGramStatus+"\nBGramType:"+BGramType+"\ncntBytes:"+cntBytes+
			"\ncntBGram:"+cntBGram+"\nb1:"+Arrays.toString(b1)+"\nb4:"+Arrays.toString(b4)+"\nb8:"+Arrays.toString(b8);
		return(str);
	}

	public long getBGramId() {
		return BGramId;
	}

	public Long getFileId() {
		return fileId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public String getBGramName() {
		return BGramName;
	}

	public String getBGramDesc() {
		return BGramDesc;
	}

	public String getBGramStatus() {
		return BGramStatus;
	}

	public String getBGramType() {
		return BGramType;
	}

	public long getCntBytes() {
		return cntBytes;
	}

	public long getCntBGram() {
		return cntBGram;
	}

	public long[] getB1() {
		return b1;
	}

	public long[] getB4() {
		return b4;
	}

	public long[] getB8() {
		return b8;
	}

	public long[] getW16() {
		return w16;
	}

	public SortedMap<NodeBinary, Long> getW32() {
		return w32;
	}

	public SortedMap<NodeBinary, Long> getW64() {
		return w64;
	}

	public SortedMap<NodeBinary, Long> getB512() {
		return b512;
	}

	public double[] getB1Norm() {
		return b1Norm;
	}

	public double[] getB4Norm() {
		return b4Norm;
	}

	public double[] getB8Norm() {
		return b8Norm;
	}

	public double[] getW16Norm() {
		return w16Norm;
	}

	public SortedMap<NodeBinary, Double> getW32Norm() {
		return w32Norm;
	}

	public SortedMap<NodeBinary, Double> getW64Norm() {
		return w64Norm;
	}

	public SortedMap<NodeBinary, Double> getB512Norm() {
		return b512Norm;
	}

	public ArrayList<BGram> getListBGram() {
		return listBGram;
	}

	public static int getCnttopW32() {
		return cntTopW32;
	}

	public static int getCnttopW64() {
		return cntTopW64;
	}

	public static int getCnttop512() {
		return cntTop512;
	}

	public void setCntBytes(long cntBytes) {
		this.cntBytes = cntBytes;
	}

	public HashMap<Long, ArrayList<NodeBinary>> getMapW32Crc2NodeBinaryList() {
		return mapW32Crc2NodeBinaryList;
	}

	public HashMap<Long, ArrayList<NodeBinary>> getMapW64Crc2NodeBinaryList() {
		return mapW64Crc2NodeBinaryList;
	}
	
}
