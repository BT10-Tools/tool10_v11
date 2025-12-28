package tool10.fileset.blob;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;

public class MakeFileSetByteComparison {
	
	private static double getSequentialByteComparison(byte[] bytes1,byte[] bytes2, double minCompValue)	{
		if ((bytes1==null) || (bytes2==null)) return(-1.0d);
		if ((bytes1.length==0) || (bytes2.length==0)) return(-1.0d);
		double sequentialCompValue = -1.0d;
		int cntEqual = 0;
		int cntDifferent = 0;
		int byteLengthMax = (bytes1.length > bytes2.length) ? bytes1.length : bytes2.length;
		int byteLengthMin = (bytes1.length < bytes2.length) ? bytes1.length : bytes2.length;
		int maxCntDifferent = (int) ((1.0d-minCompValue) * byteLengthMax);
		for (int i=0; i<byteLengthMin; i++)	{
			if (bytes1[i]==bytes2[i]) {cntEqual++;} else {cntDifferent++;}
			if (cntDifferent>maxCntDifferent) return(-1);
		} 
		sequentialCompValue = cntEqual / (Math.max(bytes1.length, bytes2.length));
		return(sequentialCompValue);
	}
	private static byte[] getNodeBytes(NodeF10 f10, NodeFile nodeFile, String sizeType, int partNumber)	{
		if ("regular".equals(sizeType)) 	{ return(FileSetBlobGetter.getBlobBytesForFileRegular(f10.getFileSet(), nodeFile));}
		else if ("small".equals(sizeType)) 	{ return(FileSetBlobGetter.getBlobBytesForFileSmall(f10.getFileSet(), nodeFile));}
		else if ("big".equals(sizeType)) 	{ return(FileSetBlobGetter.getBlobBytesForFileBig(f10.getFileSet(), nodeFile, partNumber));}
		return(null);
	}
	public static double calculateByteComparison(NodeF10 f10, NodeFile nodeFile1, NodeFile nodeFile2, double minCompValue)	{
		if (minCompValue<0.0d) minCompValue=0.0d;
		if (minCompValue>1.0d) minCompValue=1.0d;
		double compValue= 0.0d;
		String sizeType1 = nodeFile1.getFileBlobSizeType();  //regular, big, small, null
		String sizeType2 = nodeFile2.getFileBlobSizeType();
		if ((sizeType1==null) || (sizeType2==null)) return(-1d);
		//System.out.println("MakeFileSetSimilarity calculateByteComparison fileName1: "+nodeFile1.getFileName()+" ,fileName2: "+nodeFile2.getFileName()+
		//		"  ,sizeType1:"+sizeType1 + "  ,sizeType2:"+sizeType2);
		if ((("regular".equals(sizeType1)) || ("small".equals(sizeType1))) && 
			(("regular".equals(sizeType2)) || ("small".equals(sizeType2))))	{
			byte[] bytes1 = getNodeBytes(f10,nodeFile1,sizeType1,-1);
			byte[] bytes2 = getNodeBytes(f10,nodeFile2,sizeType2,-1);
			double sequentialCompValue= getSequentialByteComparison(bytes1,bytes2,minCompValue);
			//System.out.println("MakeFileSetSimilarity calculateByteComparison fileName1: "+nodeFile1.getFileName()+" ,fileName2: "+nodeFile2.getFileName()+
			//		" ,bytes1.length:"+bytes1.length+" ,bytes2.length:"+bytes2.length+"  ,sequentialCompValue:"+sequentialCompValue );
			return(sequentialCompValue);
		} else if (("big".equals(sizeType1)) || ("big".equals(sizeType2)))	{ 
			int cntPart1 = nodeFile1.getListFileBlobBig().size();
			int cntPart2 = nodeFile2.getListFileBlobBig().size();
			int cntPartMin = (cntPart1<cntPart2) ? cntPart1 : cntPart2;
			int cntPartMax = (cntPart1>cntPart2) ? cntPart1 : cntPart2;
			double sumSequentialCompValue = 0.0d;
			for (int i=0; i<cntPartMin; i++)	{
				byte[] bytes1 = getNodeBytes(f10,nodeFile1,sizeType1,i);
				byte[] bytes2 = getNodeBytes(f10,nodeFile2,sizeType2,i);
				sumSequentialCompValue += getSequentialByteComparison(bytes1,bytes2,minCompValue / cntPartMax);
			}		
			double sequentialCompValue = sumSequentialCompValue / cntPartMin; // get the average
			return(sequentialCompValue);
		} else {  //if one is big and other is small or regular
			byte[] bytes1=null;
			if (("regular".equals(sizeType1)) || ("small".equals(sizeType1))) {bytes1 = getNodeBytes(f10,nodeFile1,sizeType1,-1);}
			if (("regular".equals(sizeType2)) || ("small".equals(sizeType2))) {bytes1 = getNodeBytes(f10,nodeFile2,sizeType2,-1);}
			if (bytes1==null) return(-1.0d);
			NodeFile nodeFileBig = ("big".equals(sizeType1)) ? nodeFile1 : nodeFile2;  
			int cntPartBig = nodeFileBig.getListFileBlobBig().size();
			if (cntPartBig<=0) return(-1d);
			String sizeTypeBig = nodeFileBig.getFileBlobSizeType();  //regular, big, small, null
			double sumSequentialCompValue = 0.0d;
			for (int i=0; i<cntPartBig; i++)	{
				byte[] bytes2 = getNodeBytes(f10,nodeFileBig,sizeTypeBig,i);
				sumSequentialCompValue += getSequentialByteComparison(bytes1,bytes2,minCompValue / cntPartBig);
			}		
			double sequentialCompValue = sumSequentialCompValue / cntPartBig; // get the average
			return(sequentialCompValue);	
		}
		//return(compValue);
	}
}
