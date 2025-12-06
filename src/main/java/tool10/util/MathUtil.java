package tool10.util;

public class MathUtil {

	public static Integer parseInteger(String ss) 	{
		Integer i = null;
		try {
			i = Integer.parseInt(ss);
		} catch (NumberFormatException e)	{
			System.out.println("MathUtil.parseInteger NumberFormatException e:"+e.getStackTrace());
		}
		return(i);
	}
	
}
