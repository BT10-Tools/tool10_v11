package tool10.util;

public class ByteUtil {

	private static int byte2IntUnsigned(byte value)	{
		byte unsignedByte = (byte) (value & 0xFF);
	    return(Byte.toUnsignedInt(unsignedByte));
	}	
	public static int compareTwoByteArray(byte[] b1, byte[] b2)	{
		//it makes a lexicographic sort
		if ((b1==null) && (b2==null)) { return (0); }
		else if ((b1==null) 	&& (b2!=null)) { return (-1); }
		else if ((b1!=null) 	&& (b2==null)) { return (1); }
		else if (b1.equals(b2)) { return (0); }
		else if ((b1.length==0) && (b2.length==0)) 	{ return (0); }
		else if ((b1.length==0) && (b2.length>0)) 	{ return (-1); }
		else if ((b1.length>0) 	&& (b2.length==0)) { return (1); }
		else { //both are not null and not null
			int cmp0 = Integer.compare(byte2IntUnsigned(b1[0]),byte2IntUnsigned(b2[0]));
			if ((cmp0!=0) || (b1.length==1) || (b2.length==1)) return(cmp0);
			int cmp1 = Integer.compare(byte2IntUnsigned(b1[1]),byte2IntUnsigned(b2[1]));
			if ((cmp1!=0) || (b1.length==2) || (b2.length==2)) return(cmp1);
			for (int i=2; ((i<b1.length) && (i<b2.length)); i++)	{
				int cmpI = Integer.compare(byte2IntUnsigned(b1[i]),byte2IntUnsigned(b2[i]));
				if ((cmpI!=0) || (b1.length==i+1) || (b2.length==i+1)) return(cmpI);
			}
			return(0);
		}	
	}
}
