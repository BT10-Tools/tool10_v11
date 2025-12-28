package tool10.preview;

public class LongByteSequences {

	public LongByteSequences(byte[] b1, byte[] b2, int minSequenceLength, int maxCntSequence) {
		super();
		if ((b1==null) || (b2==null) || (b1.length==0) || (b2.length==0)) return;
		if (minSequenceLength<=0) minSequenceLength = 1;
		if (maxCntSequence<=0) maxCntSequence = 1;
			
		this.b1 = b1;
		this.b2 = b2;
		this.length1 = b1.length;
		this.length2 = b2.length;
		if (this.length1 == this.length2) 		{ compLength = 0; minLength = length1; maxLength = length2;} 
		else if (this.length1 > this.length2) 	{ compLength = 1; minLength = length2; maxLength = length1;}
		else {	compLength = -1; minLength = length1; maxLength = length2;}
		
		this.minSequenceLength = minSequenceLength;
		this.maxCntSequence = maxCntSequence;
	}
	
	public void initialize()	{
		this.longestSequence = longestCommonByte();
	}
	private byte[] b1;
	private byte[] b2;
	private int length1;
	private int length2;
	private int compLength;
	private int minLength;
	private int maxLength;
	
	private int minSequenceLength;
	private int maxCntSequence;
	
	private byte[] longestSequence;
	private int longestSequenceIndex1;
	private int longestSequenceIndex2;
	private int longestSequenceLength;
	private byte[][] longSequenceArray;
	private int[] longSequenceLengthArray;
	private int[] longSequenceIndexArray;
		
	public int compareByteInByte(int minLength)	{
		return (compareByteInByte(b1,b2,minLength));
	}
	public int compareByteInByte(byte[] a, byte[] b, int minLength)	{
		if (minLength<3) return(-1);
		if (minLength>a.length) return(-2);
		if (minLength>b.length) return(-3);
		for (int i=0; i<a.length-minLength; i++)	{
		for (int j=0; j<b.length-minLength; j++)	{
			if ((a[i]!=b[j]) || (a[i+1]!=b[j+1]) || (a[i+2]!=b[j+2])) continue;
			boolean minLengthEqual=true;
			int k=3;
			for (; ((k<minLength) && (i+k<a.length) && (j+k<b.length)); k++)	{
				if (a[i+k]!=b[j+k]) { minLengthEqual=false; break;}
			}
			if (!minLengthEqual) {i=i+k; j=j+k; continue;}
			for (; ((i+k<a.length) && (j+k<b.length)); k++)	{
				if (a[i+k]!=b[j+k]) { break;}
			}
			System.out.println("LongByteSequences compareByteInByte i:"+i+" ,j:"+j+" ,k:"+k);
			i=i+k; j=j+k;
		}	
		}
		return (0);
	}
	public byte[] longestCommonByte() {
    	 
		if (b1 == null || (length1==0) || b2 == null || (length2 == 0))  return null;
		byte[] cb = new byte[minLength];
		int cbIndex = 0;
		
		// java initializes them already with 0
		int[][] num = new int[length1][length2];
		int maxlen = 0;
		int lastSubsBegin = 0;
		 
		for (int i = 0; i < length1; i++) {
		for (int j = 0; j < length2; j++) {
		  if (b1[i] == b2[j]) {
		    if ((i == 0) || (j == 0))
		       num[i][j] = 1;
		    else
		       num[i][j] = 1 + num[i - 1][j - 1];
		 
		    if (num[i][j] > maxlen) {
		      maxlen = num[i][j];
		      // generate substring from str1 => i
		      int thisSubsBegin = i - num[i][j] + 1;
		      if (lastSubsBegin == thisSubsBegin) {
		         //if the current LCS is the same as the last time this block ran
		         cb[cbIndex++] = b1[i];
		      } else {
		         //this block resets the string builder if a different LCS is found
		         lastSubsBegin = thisSubsBegin;
		         cbIndex=0; 
		         for (int k=lastSubsBegin; k <(i + 1); k++) cb[cbIndex++] = b1[k];
		      }
		   }
		}
		}}
		byte[] xb = new byte[cbIndex];
		System.arraycopy(cb, 0, xb, 0, cbIndex);
		return(xb);
	}

	public byte[] getB1() {
		return b1;
	}
	public byte[] getB2() {
		return b2;
	}
	public int getLength1() {
		return length1;
	}
	public int getLength2() {
		return length2;
	}
	public int getMinSequenceLength() {
		return minSequenceLength;
	}
	public int getMaxCntSequence() {
		return maxCntSequence;
	}
	public byte[] getLongestSequence() {
		return longestSequence;
	}
	public int getLongestSequenceLength() {
		return longestSequenceLength;
	}
	public byte[][] getLongSequenceArray() {
		return longSequenceArray;
	}
	public int[] getLongSequenceLengthArray() {
		return longSequenceLengthArray;
	}
	public int[] getLongSequenceIndexArray() {
		return longSequenceIndexArray;
	}

	public int getCompLength() {
		return compLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public int getLongestSequenceIndex1() {
		return longestSequenceIndex1;
	}

	public int getLongestSequenceIndex2() {
		return longestSequenceIndex2;
	}
}
