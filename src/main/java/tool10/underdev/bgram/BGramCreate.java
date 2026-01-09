package tool10.underdev.bgram;


import java.util.ArrayList;

import tool10.fileset.nodes.NodeBinary;
import tool10.util.FileUtil;
import tool10.util.UtilCRC32;

public class BGramCreate {

	private static final byte B1 = (byte) 0b0000_0001;
	private static final byte B2 = (byte) 0b0000_0010;
	private static final byte B3 = (byte) 0b0000_0100;
	private static final byte B4 = (byte) 0b0000_1000;
	private static final byte B5 = (byte) 0b0001_0001;
	private static final byte B6 = (byte) 0b0010_0000;
	private static final byte B7 = (byte) 0b0100_0000;
	private static final byte B8 = (byte) 0b1000_0000;
	private static final byte[] BARRAY = new byte[] {B1,B2,B3,B4,B5,B6,B7,B8};
	
	
	private static int getBitInIndex(int a, int idx)	{
		if ((idx<0) || (idx>7)) return(-1); 
		if ((a & BARRAY[idx]) > 0) return(1);
		return(0);
	}
	private static int byte2IntUnsigned(byte value)	{
		byte unsignedByte = (byte) (value & 0xFF);
	    return(Byte.toUnsignedInt(unsignedByte));
	}
	private static int byte2IntUnsigned16(byte value1, byte value2)	{
		int i1 = byte2IntUnsigned(value1);
		int i2 = byte2IntUnsigned(value2);
		return (256*i1 + i2);
	}
	private static long byte2IntUnsigned32(byte value1, byte value2, byte value3, byte value4)	{
		long i1 = byte2IntUnsigned16(value1,value2);
		long i2 = byte2IntUnsigned16(value3,value4);
		return (256*256*i1 + i2);
	}
	private static long byte2IntUnsigned64(byte value1, byte value2, byte value3, byte value4,
			byte value5, byte value6, byte value7, byte value8)	{
		long i1 = byte2IntUnsigned32(value1,value2,value3,value4);
		long i2 = byte2IntUnsigned32(value3,value4,value3,value4);
		return (256*256*i1 + i2);
	}
	private static NodeBinary getNodeBinaryByte4(byte value1, byte value2, byte value3, byte value4)	{
		byte[] bb = new byte[] {value1,value2,value3,value4};
		long crc32 = UtilCRC32.getBytesCRC32(bb);
		return(new NodeBinary(4l,crc32,bb));
	}
	private static NodeBinary getNodeBinaryByte8(byte value1, byte value2, byte value3, byte value4,
			byte value5, byte value6, byte value7, byte value8)	{
		byte[] bb = new byte[] {value1,value2,value3,value4,value5, value6, value7, value8};
		long crc32 = UtilCRC32.getBytesCRC32(bb);
		return(new NodeBinary(8l,crc32, bb));
	}
	private static NodeBinary getNodeBinaryByte512(byte[] value)	{
		return(new NodeBinary((long) value.length, value));
	}
	private static void processW32(BGram bGram, byte b1, byte b2, byte b3, byte b4)	{
		byte[] byteArr = new byte[] {b1,b2,b3,b4};
		long crc32 = UtilCRC32.getBytesCRC32(byteArr);
		NodeBinary nb32 = getNodeBinaryByte4(b1,b2,b3,b4);
		NodeBinary nbFound = null;
		if (bGram.getMapW32Crc2NodeBinaryList().get(crc32)==null)	{
			ArrayList<NodeBinary> newArr32 = new ArrayList<NodeBinary>();
			newArr32.add(nb32);
			bGram.getMapW32Crc2NodeBinaryList().put(crc32,newArr32);
			bGram.getW32().put(nb32, 1l);
			nbFound = nb32;
		} else { 
			ArrayList<NodeBinary> arr32 = bGram.getMapW32Crc2NodeBinaryList().get(crc32);
			for (NodeBinary nb : arr32)	{
				if ((nb.getByteArray().length>=4) && (nb32.getByteArray().length>=4) && 
					(nb.getByteArray()[0]==nb32.getByteArray()[0]) && (nb.getByteArray()[1]==nb32.getByteArray()[1]) && 
					(nb.getByteArray()[2]==nb32.getByteArray()[2]) && (nb.getByteArray()[3]==nb32.getByteArray()[3])) {
					nbFound = nb;
				}
				if (nbFound!=null) break;
			}
			if (nbFound==null)	{
				System.out.println("processW32 problem nbFound iss null ???? why?"); 
				arr32.add(nb32);
			}	
		}	
		if (nbFound!=null)	{
			if (bGram.getW32().get(nbFound)==null)	{
				bGram.getW32().put(nbFound, 1l);
			} else {
				bGram.getW32().put(nbFound, bGram.getW32().get(nbFound) + 1l);
			}	
		}
	}
	private static void processW64(BGram bGram, byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8)	{
		byte[] byteArr = new byte[] {b1,b2,b3,b4,b5,b6,b7,b8};
		long crc32 = UtilCRC32.getBytesCRC32(byteArr);
		NodeBinary nb64 = getNodeBinaryByte8(b1,b2,b3,b4,b5,b6,b7,b8); 
		NodeBinary nbFound = null;
		if (bGram.getMapW64Crc2NodeBinaryList().get(crc32)==null)	{
			ArrayList<NodeBinary> newArr64 = new ArrayList<NodeBinary>();
			newArr64.add(nb64);
			bGram.getMapW64Crc2NodeBinaryList().put(crc32,newArr64);
			bGram.getW64().put(nb64, 1l);
			nbFound = nb64;
		} else { 
			ArrayList<NodeBinary> arr64 = bGram.getMapW64Crc2NodeBinaryList().get(crc32);
			for (NodeBinary nb : arr64)	{
				if ((nb.getByteArray().length>=8) && (nb64.getByteArray().length>=8) && 
					(nb.getByteArray()[0]==nb64.getByteArray()[0]) && (nb.getByteArray()[1]==nb64.getByteArray()[1]) && 
					(nb.getByteArray()[2]==nb64.getByteArray()[2]) && (nb.getByteArray()[3]==nb64.getByteArray()[3]) && 
					(nb.getByteArray()[4]==nb64.getByteArray()[4]) && (nb.getByteArray()[5]==nb64.getByteArray()[5]) && 
					(nb.getByteArray()[6]==nb64.getByteArray()[6]) && (nb.getByteArray()[7]==nb64.getByteArray()[7]))  {
					nbFound = nb;
				}
				if (nbFound!=null) break;
			}
			if (nbFound==null)	{
				System.out.println("processW64 problem nbFound is null ???? why?");
				arr64.add(nb64);
			}	
		}	
		if (nbFound!=null)	{
			if (bGram.getW64().get(nbFound)==null)	{
				
				bGram.getW64().put(nbFound, 1l);
			} else {
				bGram.getW64().put(nbFound, bGram.getW64().get(nbFound) + 1l);
			}	
		}
	}
	private static boolean updateBGramFromBytes(BGram bGram, byte[] bytes)	{
		System.out.println("updateBGramFromBytes fName:"+bytes.length);
		
		for (int i=0; i < bytes.length; i++)	{
			bGram.getB8()[byte2IntUnsigned(bytes[i])]++;
			if (i < bytes.length - 1) {
				bGram.getW16()[byte2IntUnsigned16(bytes[i],bytes[i+1])]++;}
			if (i < bytes.length - 3) {
				processW32(bGram,bytes[i],bytes[i+1],bytes[i+2],bytes[i+3]);
			}
			if (i < bytes.length - 7) {
				processW64(bGram,bytes[i],bytes[i+1],bytes[i+2],bytes[i+3],bytes[i+4],bytes[i+5],bytes[i+6],bytes[i+7]);
			}
			//512 byte calculations is not windowed, it is as blocks 
			if ((i % 512) == 0) { 
				int copyLength = 512;
				if ((i+512) > bytes.length ) {
					copyLength = bytes.length - i;
				} 
				byte[] copiedArray = new byte[copyLength];

				System.arraycopy(bytes, i, copiedArray, 0, copyLength);
				NodeBinary nb512 = getNodeBinaryByte512(copiedArray);
				if (bGram.getB512().get(nb512)==null) {
					bGram.getB512().put(nb512, 1l);
				} else {
					long cnt = bGram.getB512().get(nb512).longValue(); 
					bGram.getB512().put(nb512, cnt++);
				}
			}
		}	
		for (int i=0; i < bGram.getB8().length; i++)	{
			for (int j=0; j<8; j++) {
				int bitIJ = getBitInIndex(i,j); //return 0 or 1 as integer
				bGram.getB1()[bitIJ] = bGram.getB1()[bitIJ] + bGram.getB8()[i] ;				
			}
			int mod16 = i % 16;
			int div16 = i / 16;
			if (div16>15)	{	System.out.println("updateBGramFromBytes div by 16 is greater than 16, i:"+i); div16=0;}
			bGram.getB4()[mod16] = bGram.getB4()[mod16] + bGram.getB8()[i] ;
			bGram.getB4()[div16] = bGram.getB4()[div16] + bGram.getB8()[i] ;
		}
		return(true);
	}
	public static BGram createOneBGramFromFile(String fileName)	{
		BGram bGram = null;
		//public BGram(long bGramId, Long fileId, Long sourceId, String bGramName, String bGramDesc, String bGramStatus,
		//		String bGramType, long cntBytes, long cntBGram) {
		String bGramName = fileName; 
		String bGramDesc = null; 
		String bGramStatus = "new";
		String bGramType = "file";
		byte[] bytes = FileUtil.getBytes(fileName);
		
		bGram = new BGram(-1, null, null, bGramName, bGramDesc, bGramStatus, bGramType, bytes.length, 0);
		
		if (bytes!=null)	{
			updateBGramFromBytes(bGram, bytes);
		}
		return(bGram);
	}
}
