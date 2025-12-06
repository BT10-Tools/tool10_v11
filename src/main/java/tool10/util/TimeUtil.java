package tool10.util;

import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

	public static ZonedDateTime FileTime2ZDT(FileTime fTime)	{
		if (fTime==null) return(null);
		ZonedDateTime zdt = fTime.toInstant().atZone(ZoneId.systemDefault());
		return(zdt);
	}
	public static FileTime ZDT2FileTime(ZonedDateTime zdt)	{
		if (zdt==null) return(null);
		FileTime fileTime = FileTime.from(zdt.toInstant()); 
		return(fileTime);
	}
	public static String getTimeYYYYMMDDHH24MISS(LocalDateTime dt)	{
		if (dt==null) return(null);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return(myFormatObj.format(dt));
	}	
}
