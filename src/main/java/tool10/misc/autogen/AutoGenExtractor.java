package tool10.misc.autogen;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import tool10.sql.TableManager;
import tool10.util.StrUtil;

public class AutoGenExtractor {
	
   	private static List<Field> getAllFields(String strClassName)	{
	   List<Field> allFields = Arrays.asList(tool10.fileset.NodeSimilarity.class.getDeclaredFields());
	   if 		("NodeFileSet".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileSet.class.getDeclaredFields());}
	   else if  ("NodeFile".equals(strClassName))		{allFields = Arrays.asList(tool10.fileset.NodeFile.class.getDeclaredFields());}
	   else if  ("NodeFileBlob".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileBlob.class.getDeclaredFields());}
	   else if  ("NodeFileBlobSmall".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileBlobSmall.class.getDeclaredFields());}
	   else if  ("NodeFileStore".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileStore.class.getDeclaredFields());}
	   else if  ("NodeFileSystem".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileSystem.class.getDeclaredFields());}
	   else if  ("NodeHash".equals(strClassName))		{allFields = Arrays.asList(tool10.fileset.NodeHash.class.getDeclaredFields());}
	   else if  ("NodeFileBlob".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeFileBlob.class.getDeclaredFields());}
	   else if  ("NodeHost".equals(strClassName))		{allFields = Arrays.asList(tool10.fileset.NodeHost.class.getDeclaredFields());}
	   else if  ("NodeProperty".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeProperty.class.getDeclaredFields());}
	   else if  ("NodeQuery".equals(strClassName))		{allFields = Arrays.asList(tool10.fileset.NodeQuery.class.getDeclaredFields());}
	   else if  ("NodeSimilarity".equals(strClassName))	{allFields = Arrays.asList(tool10.fileset.NodeSimilarity.class.getDeclaredFields());}
  		
	   return(allFields);
   	}
   	private static String getAllFieldStr(List<Field> allFields)	{
   		StringBuilder sb = new StringBuilder();
   		int cntLine = 0;
   		int lineLength = 0;
   		sb.append(tab4);
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
	    	sb.append(field.getName());
	    	if (i < allFields.size()-1) sb.append(","); 
	    	lineLength += field.getName().length();
	    	if (lineLength > 100) {
	    		sb.append("\n"+tab4);
	    		lineLength = 0;
	    	}	
	    	cntLine++;
	    }
   		return(sb.toString());
   	}
   	private static String getConstructorFieldStr(List<Field> allFields, String strClassName)	{
   		//public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
		//String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
		//Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
   		StringBuilder sb = new StringBuilder();
   		
   		int lineLength = 0;
   		sb.append(tab2+"//public "+strClassName+"(");
   		int cntFieldsToBeAdded = 0;
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
   			if 	((field.getType().toString().contains("java.lang.String")) || (field.getType().toString().contains("java.lang.Long")) ||
   				 (field.getType().toString().contains("java.lang.Double")) || (field.getType().toString().contains("java.time.ZonedDateTime"))) { cntFieldsToBeAdded++;} 
   		}
   		int cntAddedField = 0;
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
   			String str = "";
   			if 			(field.getType().toString().contains("java.lang.String"))		{str = "String "+field.getName();  
   			} else if 	(field.getType().toString().contains("java.lang.Long"))			{str = "Long "+field.getName();  
   			} else if 	(field.getType().toString().contains("java.lang.Double"))		{str = "Double "+field.getName(); 
   			} else if 	(field.getType().toString().contains("java.time.ZonedDateTime"))	{str = "ZonedDateTime "+field.getName(); 
			} else {		
   				System.out.println("The field is: " + field.getType().toString());
   			}
   			if (!str.isEmpty())	{
   				sb.append(str);
   				if (cntAddedField < (cntFieldsToBeAdded-1)) sb.append(","); 
   		    	lineLength += str.length();
   		    	if (lineLength > 100) {
   		    		sb.append("\n"+tab2+"//");
   		    		lineLength = 0;
   		    	}	
   		    	cntAddedField++;
	    	}	
	    }
   		sb.append(")\n");
   		return(sb.toString());
   	}	
	private static String getAllFieldStrWithQuote(List<Field> allFields)	{
   		StringBuilder sb = new StringBuilder();
   		int cntLine = 0;
   		int lineLength = 0;
   		sb.append(tab4+"\"");
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
	    	sb.append(field.getName());
	    	if (i < allFields.size()-1) sb.append(","); 
	    	lineLength += field.getName().length();
	    	if (lineLength > 100) {
	    		sb.append("\"+\n"+tab4+"\" ");
	    		lineLength = 0;
	    	}	
	    	cntLine++;
	    }
   		sb.append("\"");
   		return(sb.toString());
   	}	
   	private static String getJdbcGetterFieldStr(List<Field> allFields)	{
   		StringBuilder sb = new StringBuilder();
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
   			if 		(field.getType().toString().contains("java.lang.String"))	{
   				sb.append(tab4+"String "+field.getName()+" = rs.getString(\""+field.getName()+"\");\n"); 
   			} else if (field.getType().toString().contains("java.lang.Long"))		{
   				sb.append(tab4+"Long "+field.getName()+" = rs.getLong(\""+field.getName()+"\");	if (rs.wasNull()) {"+field.getName()+" = null;}\n"); 
   			} else if (field.getType().toString().contains("java.lang.Double"))	{
   				sb.append(tab4+"Double "+field.getName()+" = rs.getDouble(\""+field.getName()+"\");	if (rs.wasNull()) {"+field.getName()+" = null;}\n"); 
   			} else if (field.getType().toString().contains("java.time.ZonedDateTime"))	{
   				sb.append(tab4+"String "+field.getName()+"Str = rs.getString(\""+field.getName()+"\");\n");
   				sb.append(tab4+"ZonedDateTime "+field.getName()+" = (("+field.getName()+"!=null) ? ZonedDateTime.parse("+field.getName()+"Str) : null); \n");
		    } else {		
   				System.out.println("The field is: " + field.getType().toString());
   			}
	    }
   		return(sb.toString());
   	}	
   
   	private static String getReadTablesMethod(String setClassName, String setName, String strClassName, String smallTxt, String initCapStr, String tableName)	{
   		List<Field> allFields = getAllFields(strClassName);
   		
   		String allFieldStr = getAllFieldStr(allFields);
   		String allFieldStrWithQuote = getAllFieldStrWithQuote(allFields);
   		String constructorFieldStr = getConstructorFieldStr(allFields, strClassName); //"//CONSTRUCTOR"; 
   		String jdbcGetterFieldStr = getJdbcGetterFieldStr(allFields);
   		
	    StringBuilder sb = new StringBuilder();

	    sb.append(tab1+"public static int readTable"+initCapStr+"(Connection conn, "+setClassName+" "+setName+")	{ \n"+ 
	    			tab2+"int cntRead = 0; \n"+
	    			tab2+"String query = 	\" SELECT \"+\n");
	    sb.append(allFieldStrWithQuote);
	    sb.append("+\n"+tab3+" \" FROM "+tableName+" ORDER BY "+smallTxt+"Id\"; \n");
	    sb.append(constructorFieldStr+"\n");
		sb.append(tab2+"try	{\n"+
				tab3+"PreparedStatement ps = conn.prepareStatement(query);\n"+ 
				tab3+"//ps.setLong(1, statEngine.getStatEngineId());\n"+
				tab3+"ResultSet rs = ps.executeQuery(); \n"+
				tab3+"while (rs.next()) { \n" );
		sb.append(jdbcGetterFieldStr);
		sb.append(tab4+"Node"+initCapStr+" new"+initCapStr+ " = new Node"+initCapStr+"(\n");
		sb.append(allFieldStr+"\n");
		sb.append(tab4+");\n");
		//System.out.println("readRegistryTableEntry: regEntry = " + regEntry);
		sb.append(tab4+setName+".getList"+initCapStr+"().add(new"+initCapStr+"); \n");
		sb.append(tab4+setName+".getMapId2"+initCapStr+"().put(new"+initCapStr+".get"+initCapStr+"Id(),new"+initCapStr+"); \n");
		sb.append(
			tab4+"cntRead++; \n"+
			tab3+"}\n"+
			tab3+"System.out.println(\"readStatEngineTableStatLong: cntRead = \" + cntRead); \n"+
			tab3+"rs.close(); \n"+
			tab3+"ps.close(); \n"+
			tab2+"} catch(SQLException e)	{ \n"+
			tab3+"e.printStackTrace(System.err); \n"+ 
			tab2+"} \n"+
			tab2+"return(cntRead); \n"+
			tab1+"} \n"
		);	    	
	    return(sb.toString());
   	}
   	private static String getReadTablesBody(String setClassName, String setName, String strClassName, String smallTxt, String initCapStr, String tableName)	{
   		StringBuilder sb = new StringBuilder();
   		String cntLineStr = 
		"	int cntReadStatLong = readStatEngineTableStatLong(conn,corpus);\n"+
		"	int cntReadStatDouble = readStatEngineTableStatDouble(conn,corpus);\n"+
		"	int cntReadStatString = readStatEngineTableStatString(conn,corpus);\n"+
		"	int cntReadStatDate = readStatEngineTableStatDate(conn,corpus); \n"+
		"	int cntReadTableBinary = readStatEngineTableStatBinary(conn,corpus); \n";
   		String sumLineStr = "	int cntRead = cntReadStatLong + cntReadStatDouble + cntReadStatString + cntReadStatDate + cntReadTableBinary + 1; \n";
   		
	   	sb.append(
	   	
		"public static "+setClassName+" read"+initCapStr+"(Connection conn, long statEngineId) {\n"+
		"	"+setClassName+" "+smallTxt+" = readStatEngineTableStatEngine(conn, statEngineId);\n"+
		"	if ("+smallTxt+"==null) return (null);\n"+
		cntLineStr + 
		"\n"+	
		"	postProcess"+initCapStr+"("+smallTxt+");\n"+
		"\n"+	
		sumLineStr + 
		"   System.out.println(\"read"+initCapStr+": total record read = \" + cntRead); \n"+
		"	return("+smallTxt+"); \n"+
		"}\n"+	
		"private static void postProcess"+initCapStr+"("+setClassName+" "+smallTxt+")	{\n"+
		"/*	int cntAddedField=0;\n"+
		"	for (NodeField statField: ai.getListField())	{\n"+
		"		if (statField.getFieldTypeId()==null) continue;\n"+
		"		NodeFieldType fieldType = ai.getMapId2FieldType().get(statField.getFieldTypeId());\n"+
		"		if (fieldType==null) continue;\n"+
		"		fieldType.getListField().add(statField);\n"+
		"		cntAddedField++;\n"+
		"	}\n"+
		"	System.out.println(\"postProcessAi: total records added to fieldType.getListField()  cntAddedField = \" + cntAddedField);\n"+
		"*/	\n"+
   		"}\n"+
		"public static "+setClassName+" read"+initCapStr+"Tables(Connection conn, long "+smallTxt+"Id)	{ \n"+ 
		"\n"+	
		"	"+setClassName+" "+smallTxt+" = read"+initCapStr+"(conn,"+smallTxt+"Id); \n"+
		"	if ("+smallTxt+"!=null)	{ \n"+
		"		MakeFileSet.printAllListsAndMaps("+smallTxt+"); \n"+
		"	} else { \n"+
		"		System.out.println(\"read"+initCapStr+"Tables: "+smallTxt+" is null\"); \n"+
		"	}	\n"+
		"	return ("+smallTxt+"); \n"+
		"}\n");
	   	return(sb.toString());
	}
   	public static void readTables() {
   		
   		String tblList[] = TableManager.getTableList("fsDb");
   		
   		String strClassName = "NodeSimilarity";
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFile","file","File","FS_FILE"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFileBlob","fileBlob","FileBlob","FS_FILEBLOB"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFileBlobSmall","fileBlobSmall","FileBlobSmall","FS_FILEBLOBSMALL"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFileStore","fileStore","FileStore","FS_FILESTORE"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFileSystem","fileSystem","FileSystem","FS_FILESYSTEM"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeHash","hash","Hash","FS_HASH"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeHost","host","Host","FS_HOST"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeProperty","property","Property","FS_PROPERTY"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeQuery","query","Query","FS_QUERY"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeSimilarity","similarity","Similarity","FS_SIMILARITY"));
   		System.out.println(getReadTablesMethod("NodeFileSet","fileSet","NodeFileSet","fileSet","FileSet","FS_FILESET"));
   		
   		System.out.println(getReadTablesBody("NodeFileSet","fileSet","NodeFileSet","fileSet","FileSet","FS_FILESET"));
   	}	
   	
   	//***********************************************
	static final String tab1 ="	";
   	static final String tab2 ="		";
   	static final String tab3 ="			";
   	static final String tab4 ="				";
   	static final String tab5 =tab4+tab1;
	private static String getAllFieldStr3(List<Field> allFields)	{
   		StringBuilder sb = new StringBuilder();
   		int cntLine = 0;
   		int lineLength = 0;
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
	    	sb.append("\""+field.getName()+"\"");
	    	if (i < allFields.size()-1) sb.append(","); 
	    	lineLength += field.getName().length();
	    	if (lineLength > 100) {
	    		sb.append("\n"+tab3);
	    		lineLength = 0;
	    	}	
	    	cntLine++;
	    }
   		return(sb.toString());
   	} 
	
	private static String getHeaderFieldStr(String strClassName, String ifElse)	{
		List<Field> allFields = getAllFields(strClassName);
		String cc = getAllFieldStr3(allFields); // "\"HostId\", \"HostName\"";
		String str =
			tab2 + ifElse + " (\""+strClassName+"\".equals(tableName))	{ \n"+
			tab3 + "headers = new String[] {"+cc+"}; \n";
		return(str);
	}
	private static String getAllHeaderMethod()	{
		String headerFieldStr = 
		 	getHeaderFieldStr("NodeFile","if")+
	   		getHeaderFieldStr("NodeFileBlob","} else if")+
	   		getHeaderFieldStr("NodeFileBlobSmall","} else if")+
	   		getHeaderFieldStr("NodeFileStore","} else if")+
	   		getHeaderFieldStr("NodeFileSystem","} else if")+
	   		getHeaderFieldStr("NodeHash","} else if")+
	   		getHeaderFieldStr("NodeHost","} else if")+
	   		getHeaderFieldStr("NodeProperty","} else if")+
	   		getHeaderFieldStr("NodeQuery","} else if")+
	   		getHeaderFieldStr("NodeSimilarity","} else if")+
	   		getHeaderFieldStr("NodeFileSet","} else if") + 
	   		tab2+"}\n";
	   	 
   		StringBuilder sb = new StringBuilder();

	    sb.append(
	    tab1+ "private static String[] getHeaderArray(String tableName)	{\n"+
    	tab2+ "String[] headers = null;\n" + 
    	headerFieldStr + 
	    tab2+ "return(headers);\n"+
		tab1+"}\n"); 
	    return(sb.toString());
	}
	//ent.getXxx(),ent.getYyyyy(),.....
	private static String getAllFieldStr4(List<Field> allFields)	{
   		StringBuilder sb = new StringBuilder();
   		int cntLine = 0;
   		int lineLength = 0;
   		for (int i=0; i<allFields.size(); i++)	{
   			Field field = allFields.get(i);
   			if ("serialVersionUID".equals(field.getName())) continue;
	    	sb.append("ent.get"+StrUtil.initcap(field.getName())+"()");
	    	if (i < allFields.size()-1) sb.append(","); 
	    	lineLength += field.getName().length();
	    	if (lineLength > 100) {
	    		sb.append("\n"+tab5);
	    		lineLength = 0;
	    	}	
	    	cntLine++;
	    }
   		return(sb.toString());
   	} 
	private static String getPrintRecordStr(String strClassName, String lstName, String ifElse)	{
		List<Field> allFields = getAllFields(strClassName);
		String getterStr = getAllFieldStr4(allFields); // "\"HostId\", \"HostName\"";
		
		String str =
			tab2 + ifElse+" (\""+strClassName+"\".equals(tableName))	{ \n"+
			//tab3 + "headers = getHeaderArray(tableName); \n" +
		   	tab3 + "for ("+strClassName+" ent : fileSet.getList"+lstName+"()) { \n"+
		   	tab4 + "csvPrinter.printRecord("+getterStr+"); \n"+
		   	tab3 + "} \n";
	   return(str);
	}   
	private static String getCSVPrinterMethod()	{
		String ifElseFieldStr = 
			getPrintRecordStr("NodeFile","File","if")+
			getPrintRecordStr("NodeFileBlob","FileBlob","} else if")+
			getPrintRecordStr("NodeFileBlobSmall","FileBlobSmall","} else if")+
			getPrintRecordStr("NodeFileStore","FileStore","} else if")+
			getPrintRecordStr("NodeFileSystem","FileSystem","} else if")+
			getPrintRecordStr("NodeHash","Hash","} else if")+
			getPrintRecordStr("NodeHost","Host","} else if")+
			getPrintRecordStr("NodeProperty","Property","} else if")+
			getPrintRecordStr("NodeQuery","Query","} else if")+
			getPrintRecordStr("NodeSimilarity","Similarity","} else if")+
			getPrintRecordStr("NodeFileSet","FileSet","} else if") + 
	   		tab2+"}\n";
	   	 
   		StringBuilder sb = new StringBuilder();

	    sb.append(
	    tab1+ "private static void csvPrint(NodeFileSet fileSet, CSVPrinter csvPrinter, String tableName) { \n"+
	    tab2+ "try { \n"+
	    ifElseFieldStr +  
		tab2+ "} catch (IOException e) {\n"+
		tab2+ "	 e.printStackTrace();\n"+
		tab2+ "}\n"+	 
		tab1+ "}\n");	 
 		
	    return(sb.toString());
	}
	private static String getExportTableMethod()	{
		String ifElseFieldStr = 
			getPrintRecordStr("NodeFile","File","if")+
			getPrintRecordStr("NodeFileBlob","FileBlob","} else if")+
			getPrintRecordStr("NodeFileBlobSmall","FileBlobSmall","} else if")+
			getPrintRecordStr("NodeFileStore","FileStore","} else if")+
			getPrintRecordStr("NodeFileSystem","FileSystem","} else if")+
			getPrintRecordStr("NodeHash","Hash","} else if")+
			getPrintRecordStr("NodeHost","Host","} else if")+
			getPrintRecordStr("NodeProperty","Property","} else if")+
			getPrintRecordStr("NodeQuery","Query","} else if")+
			getPrintRecordStr("NodeSimilarity","Similarity","} else if")+
			getPrintRecordStr("NodeFileSet","FileSet","} else if") + 
	   		tab2+"}\n";
	   	 
   		StringBuilder sb = new StringBuilder();

	    sb.append(
	    tab1+ "private static String exportCSV() { \n"+
	    tab2+ "try { \n"+
	    tab2+ "final StringWriter sw = new StringWriter(); \n"+
	    tab3+ "CSVFormat csvFormat = CSVFormat.DEFAULT.builder() \n"+
	    tab3+ "       .setHeader(headers) \n"+
	    tab3+ "       .setQuoteMode(QuoteMode.NON_NUMERIC) \n"+
	    tab3+ "      .build(); \n"+
	    tab3+ "CSVPrinter csvPrinter = new CSVPrinter(sw, csvFormat); \n"+
	    ifElseFieldStr +  
		tab3+ "csvPrinter.close();\n"+
		tab3+ "return(sw.toString());\n"+
		tab2+ "} catch (IOException e) {\n"+
		tab2+ "	 e.printStackTrace();\n"+
		tab3+ "    return(null);\n"+   
		tab2+ "}\n"+	 
		tab1+ "}\n");	 
 		
	    return(sb.toString());
	}
	public static void extractorCodes()	{
   		String tblList[] = TableManager.getTableList("fsDb");
   		
   		//System.out.println(getAllHeaderMethod());
   		System.out.println(getCSVPrinterMethod());
   		
   		//System.out.println(getExportTableMethod());
   		
   	}
   	public static void main(String[] args) {	
   		extractorCodes();
   	}

}
