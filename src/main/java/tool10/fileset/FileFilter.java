package tool10.fileset;

import java.io.File;

import tool10.f10.NodeF10;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileName;
import tool10.fileset.nodes.NodeFileProp;

public class FileFilter {

	public static String checkFileSize(NodeF10 f10, File file, Long fileSize)	{
		String checkSize = "ok";
		return(checkSize);
	}
	public static String checkFileName(NodeF10 f10, File file, String fileName, String fileNameAbsolute)	{
		String checkName = "ok";
		return(checkName);
	}
	public static String checkNewFileProp(NodeF10 f10, File file, NodeFile newFile, NodeFileProp newFileProp)	{
		//Burada bir fileIn PROP özellikleri kullanılarak oluşturulan filterler olacak 
		//newFile memory'de oluşturulan bir sqlite veritabanına yazılabilir. Ve burada SQL query'si çalıştırılabilir.   
		//veya Java scripti veya başka scriptler veya Java class'ları çağrılabilir
		String checkWhole = "ok";
		return(checkWhole);
	}
	public static String checkNewFileName(NodeF10 f10, File file, NodeFile newFile, NodeFileName newFileName)	{
		//Burada bir fileIn NAME özellikleri kullanılarak oluşturulan filterler olacak 
		//newFile memory'de oluşturulan bir sqlite veritabanına yazılabilir. Ve burada SQL query'si çalıştırılabilir.   
		//veya Java scripti veya başka scriptler veya Java class'ları çağrılabilir
		String checkWhole = "ok";
		return(checkWhole);
	}
	public static String checkWholeNewFile(NodeF10 f10, File file, NodeFile newFile)	{
		//Burada bir fileIn başka özellikleri ve bütün özellikleri kullanılarak oluşturulan filterler olacak 
		//newFile memory'de oluşturulan bir sqlite veritabanına yazılabilir. Ve burada SQL query'si çalıştırılabilir.   
		//veya Java scripti veya başka scriptler veya Java class'ları çağrılabilir
		String checkWhole = "ok";
		return(checkWhole);
	}
	public static boolean postCheckFile(NodeF10 f10, File file, NodeFile newFile)	{
		//Burada bir fileIn başka özellikleri ve bütün özellikleri kullanılarak oluşturulan filterler olacak
		//Bu bir post check stat tabloları vs de kullanılarak analitik filterler oluşturulabilecek (en büyük 10 dosya gibi)
		//newFile ve diğer tablolar memory'de oluşturulan bir sqlite veritabanına yazılabilir. Ve burada SQL query'si çalıştırılabilir.   
		//veya Java scripti veya başka scriptler veya Java class'ları da çağrılabilir
		boolean checkPost = true;
		return(checkPost);
	}
	public static boolean finalCheckFile(NodeF10 f10, File file, NodeFile newFile)	{
		//Burada bir fileIn başka özellikleri ve bütün özellikleri kullanılarak oluşturulan filterler olacak
		//Bu bir post check stat tabloları vs de kullanılarak analitik filterler oluşturulabilecek (en büyük 10 dosya gibi)
		//newFile ve diğer tablolar memory'de oluşturulan bir sqlite veritabanına yazılabilir. Ve burada SQL query'si çalıştırılabilir.   
		//veya Java scripti veya başka scriptler veya Java class'ları da çağrılabilir
		boolean checkFinal = true;
		return(checkFinal);
	}
}
