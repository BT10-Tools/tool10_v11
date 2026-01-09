package tool10.preview.navigator;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.text.StringEscapeUtils;

public class ShowFormCommon {

	
	
	public static String escapeStr (String str)	{
		String escaped = StringEscapeUtils.escapeHtml4(str);
		return(escaped);
	}
	public static String htmlize01(String fieldName, String fieldValueStr)	{
		return("<tr><td><label for='"+fieldName+"'> "+fieldName+"</label></td><td><input type='text' id='"+
				fieldName+"' readonly defaultValue='"+fieldValueStr+"'></td><tr>"); 
	}
	public static String showLong(String outType, String fieldName, Long val)	{
		return(showLong(outType,fieldName,val,null));
	}
	public static String showLong(String outType, String fieldName, Long val, String gotoAnchor)	{
		String anchorStr = (gotoAnchor!=null) ? "&nbsp;&nbsp;<a href='#"+gotoAnchor+"'>go</a>" : "";
		return(htmlize01(fieldName+"(Long):",(val==null) ? "null" : escapeStr(val.toString()) + anchorStr));
	}
	public static String showDouble(String outType, String fieldName, Double val)	{
		return(htmlize01(fieldName+"(Double):",escapeStr((val==null) ? "null" : val.toString())));
	}
	public static String showString(String outType, String fieldName, String val)	{
		return(htmlize01(fieldName+"(String):","'"+escapeStr(val)+"'"));
	}
	public static String showZDT(String outType, String fieldName, ZonedDateTime val)	{
		return(htmlize01(fieldName+"(ZonedDateTime):", ((val==null) ? "null" : escapeStr(val.toString()))));
	}
	private static final int showBytesHeadLength = 10;
	private static final int showBytesTailLength = 6;
	private static final String showBytesMidlle = " ..... ";
	private static final String showBytesFormat = "signedInt"; //hex
	
	public static String showBytes(String outType, String fieldName, byte[] bytes)	{
		String byteArrayStr = null;   
		if (bytes==null) {byteArrayStr = "null";}
		else if (bytes.length==0) {
			byteArrayStr = "[]";
		} else if ((bytes.length<=showBytesHeadLength) || (bytes.length<=showBytesTailLength))	{
			byteArrayStr = Arrays.toString(bytes);
		} else if (bytes.length>=0) {
			int headLengthToShow = (showBytesHeadLength >= bytes.length) ? showBytesHeadLength : bytes.length;  
			int tailBeginningIndexToShow = ((showBytesHeadLength+showBytesTailLength) >= bytes.length) ? (bytes.length-showBytesTailLength) : bytes.length;
			int middleBeginningIndexToShow = -1;
			int middleEndingIndexToShow = -1;
			byte[] head = Arrays.copyOfRange(bytes, 0, headLengthToShow);
			byte[] tail = Arrays.copyOfRange(bytes, tailBeginningIndexToShow, bytes.length);
			byte[] middle = null;
			if ((head!=null) && (head.length>0)) {byteArrayStr = Arrays.toString(head).replace("[", "").replace("]", "");}
			if (bytes.length < (head.length + tail.length))		{byteArrayStr = byteArrayStr + showBytesMidlle; }
			if ((tail!=null) && (tail.length>0)) {byteArrayStr = byteArrayStr + Arrays.toString(tail).replace("[", "").replace("]", "");}
			byteArrayStr = "[]";
		}
		
		return(fieldName+"(bytes) length:"+bytes.length+" ,");
	}
	public static String showList(String outType, String className, String fieldName, Object arrList)	{
		return(className+","+fieldName+","+arrList.toString());
	}
	public static String showMap(String outType, String keyClassName, String valueClassName, String fieldName, Object mapObj)	{
		return(keyClassName+","+valueClassName+","+fieldName+","+mapObj.toString());
	}
	public static String showClass(String classNameLong, String classNameShort)	{
		return("A Java Reflection based data will be returned for Class LongName :"+classNameLong+" , Class ShortName:"+classNameShort);
	}
	public static String showPackage(String packageNameLong, String packageNameShort)	{
		return("A Java Reflection based data will be returned for Package LongName :"+packageNameLong+" ,Package ShortName:"+packageNameShort);
	}
	private static final String nl = "\n";
	//private static final String outType = "text";
	
	private static final String[] headerArray = new String[] {"Field Name (Field Type)","Field Value"};
	private static final String tableStyle="style='border:1px solid black;'"; 
	public static String tableize(ArrayList<String> fieldLineArray, String anchorStr, String tableCaption)	{
		StringBuilder sb = new StringBuilder();
		sb.append("<table "+tableStyle+">"+nl);
		sb.append("<section id='"+anchorStr+"'></section>"+nl);
		sb.append("<caption>"+tableCaption+"</caption>"+nl);
		sb.append("<tr><th>"+headerArray[0]+"</th><th>"+headerArray[1]+"</th></tr>"+nl);
		for (String ss : fieldLineArray)	{
			sb.append(ss);
		}
		sb.append("</table>"+nl);
		return(sb.toString());
	}		
	
}
