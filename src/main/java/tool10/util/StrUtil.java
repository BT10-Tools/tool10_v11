package tool10.util;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class StrUtil {

	public static int parseStr2Int(String str)	{
		int i=0;
		try {
			i = Integer.parseInt(str);
		} catch(Exception e)	{
			return(Integer.MIN_VALUE);
		}
		return(i);
	}
	public static double parseStr2Double(String str)	{
		double d=0;
		try {
			d = Double.parseDouble(str);
		} catch(Exception e)	{
			return(Double.MIN_VALUE);
		}
		return(d);
	}
	public static Date parseStr2Date(String str)	{
		Date dt=null;
		try {
			dt = null; //Date.parse(str);
		} catch(Exception e)	{
			return(null);
		}
		return(dt);
	}
	public static String initcap(String str)	{
		if (str==null) return(null);
		if ((str.isBlank()) || (str.isEmpty())) return(str);
		return(str.substring(0, 1).toUpperCase() + str.substring(1));
	}
	public static String getBase64Str(byte[] bytes)	{
		if (bytes==null) return(null);
		return(Base64.getEncoder().encodeToString(bytes));
	}
	public static byte[] getBase64Bytes(String str)	{
		if (str==null) return(null);
		return(Base64.getDecoder().decode(str));
	}	
	public static String[] getDirAndFileList(String str)	{
		//called from fileSet CliFileSetParseAndValidate
		//like \"'dir1','dir2','dir3' \" 
		
		List<String> tokenList = Arrays.asList(str.split(","));
		if ((tokenList==null) || (tokenList.size()<=0)) return(null);
		String[] pathList = new String[tokenList.size()];
		int i=0;
		for (String token : tokenList)	{
			String tok1 = token.trim().replace("'","");
			if ((tok1==null) || (tok1.isEmpty())) {return(null);}
			pathList[i++] = tok1; 
		}
		return(pathList);
	}
	public static void main(String[] args) {
		String[] tokenList = getDirAndFileList("'dir1'  ,'dir2','dir3'");
		for (String ss : tokenList)	{
			System.out.println(" ss:#"+ss+"#");
		}
	}
}
