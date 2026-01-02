package tool10.bookset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import tool10.f10.NodeF10;
import tool10.sql.JLite;
import tool10.util.StrUtil;


public class MakeBookSetTanzil {

	private static final String[] surayArray = new String[] {
			"1 - Al-Fatiha (The opener)","2 - Al-Baqarah (The cow)","3 - Al-Imran (Family of Imran)","4 - An-Nisa (The Women)",
			"5 - Al-Ma'idah (The Table Spread)","6 - Al-Anam (The Cattle)","7 - Al-A'raf (The Heights)","8 - Al-Anfal (The Spoils of War)",
			"9 - At-Taubah (The Repentance)","10 - Yunus (Jonah)","11 - Hud (Hud)","12 - Yusuf (Joseph)",
			"13 - Ar-Ra'd (Thunder)","14 - Ibrahim (Abraham)","15 - Al-Hijr (The Stoneland)","16 - An-Nahl (The Bee)",
			"17 - Al-Isra (The Night Journey)","18 - Al-Kahf (The Cave)","19 - Maryam (Mary)","20 - Ta-Ha (Ta-Ha)",
			"21 - Al-Anbiya (The Prophets)","22 - Al-Hajj (The Pilgrimage)","23 - Al-Mu'minun (The Believers)","24 - An-Nur (The Light)",
			"25 - Al-Furqan (The Criterion)","26 - Ash-Shu'ara (The Poets)","27 - An-Naml (The Ants)","28 - Al-Qasas (The Story)",
			"29 - Al-Ankabut (Spider)","30 - Ar-Rum (The Romans)","31 - Luqman (Luqman)","32 - As-Sajdah (Prostration)",
			"33 - Al-Ahzab (The Confederates)","34 - Saba (Sheba)","35 - Fatir (The Originator)","36 - Ya-Sin (Ya Sin)",
			"37 - As-Saffat (Those Who Set the Ranks)","38 - Sad (The letter Saad)","39 - Az-Zumar (The Troops)","40 - Ghafir (The Forgiver)",
			"41 - Fussilat (Explained in Detail)","42 - Ash-Shura (The Consultation)","43 - Az-Zukhruf (The Ornaments of Gold)","44 - Ad-Dukhan (The Smoke)",
			"45 - Al-Jathiyah (The Crouching)","46 - Al-Ahqaf (The Wind Curved Sandhill)","47 - Muhammad (Muhammad)","48 - Al-Fath (The Victory)",
			"49 - Al-Hujurat (The Private Chambers)","50 - Qaf (Qaf)","51 - Adh-Dhariyat (The Scatterers)","52 - At-Tur (The Mountain)",
			"53 - An-Najm (The Star)","54 - Al-Qamar (The Moon)","55 - Ar-Rahman (The Beneficent)","56 - Al-Waqi'ah (The Inevitable)",
			"57 - Al-Hadid (The Iron)","58 - Al-Mujadila (The Pleading Women)","59 - Al-Hashr (The Exile)","60 - Al-Mumtahanah (She That is to be Examined)",
			"61 - As-Saff (The Ranks)","62 - Al-Jumu'ah (Congregation Prayer)","63 - Al-Munafiqun (The Hypocrites)","64 - At-Taghabun (Mutual Disposession)",
			"65 - At-Talaq (The Divorce)","66 - At-Tahrim (The Prohibition)","67 - Al-Mulk (The Sovereignty)","68 - Al-Qalam (The Pen)",
			"69 - Al-Haqqah (The Reality)","70 - Al-Ma'arij (The Ascending Stairways)","71 - Nuh (Noah)","72 - Al-Jinn (The Jinn)",
			"73 - Al-Muzzammil (The Enshrouded One)","74 - Al-Muddaththir (The Cloaked One)","75 - Al-Qiyamah (The Resurrection)","76 - Al-Insan (The Man)",
			"77 - Al-Mursalat (The Emissaries)","78 - An-Naba (The Tidings)","79 - An-Nazi'at (Those who drag forth)","80 - Abasa (He Frowned)",
			"81 - At-Takwir (The Overthrowing)","82 - Al-Infitar (The Cleaving)","83 - Al-Mutaffifin (The Defrauding)","84 - Al-Inshiqaq (The Sundering)",
			"85 - Al-Buruj (The Mansions of the Stars)","86 - At-Tariq (The Nightcommer)","87 - Al-Ala (The Most High)","88 - Al-Ghashiyah (The Overwhelming)",
			"89 - Al-Fajr (The Dawn)","90 - Al-Balad (The City)","91 - Ash-Shams (The Sun)","92 - Al-Lail (The Night)",
			"93 - Ad-Duha (The Morning Brightness)","94 - Ash-Sharh (The Expansion)","95 - At-Tin (The Fig)","96 - Al-Alaq (The Blood Clot)",
			"97 - Al-Qadr (The Power)","98 - Al-Bayyina (The Evidence)","99 - Az-Zalzalah (The Earthquake)","100 - Al-Adiyat (The Courser)",
			"101 - Al-Qari'ah (The Calamity)","102 - At-Takathur (Vying for increase)","103 - Al-Asr (The Declining Day)","104 - Al-Humazah (The Slanderer)",
			"105 - Al-Fil (The Elephant)","106 - Quraysh (Quraish)","107 - Al-Ma'un (The Small Kindness)","108 - Al-Kawthar (The Abundance)",
			"109 - Al-Kafirun (The Disbelievers)","110 - An-Nasr (The Divine Support)","111 - Al-Masad (The Palm Fiber)","112 - Al-Ikhlas (The Sincerity)",
			"113 - Al-Falaq (The Daybreak)","114 - An-Nas (The Mankind)"};
	
	/*
	public static ArrayList<String> loadWordsFromFileToStringList(String fileName) {
		ArrayList<String> wrdList = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(fileName);
		    BufferedReader br = new BufferedReader(fr);
		    String str = null;
		 
		    int cnt = 0;
		    while ((str = br.readLine()) != null) {
		        System.out.println(str);
		    	//if (str==null) continue;
				if (str.isEmpty() || str.isBlank()) continue;
				wrdList.add(str);
				//if (cnt++ > 100) break;
		    }
		    br.close();
		    fr.close();
		} catch (IOException ex) {
		    System.err.println(ex);
		}
		return(wrdList);
	}
	public static void createAyetListAndMap(Connection connT,String tableName, String sureNo, ArrayList<Long> ayetNoList, HashMap<Long,String> ayetMap)	{
		String query = 	"SELECT ayet,txt FROM "+tableName+" WHERE sure = "+sureNo+ " ORDER BY sure, ayet";
		try	{  
			PreparedStatement ps = connT.prepareStatement(query);
		    //ps.setLong(1, regJob.getRegistryJobId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long ayetNo = rs.getLong("ayet");
		    	String txt = rs.getString("txt");
		    	ayetNoList.add(ayetNo);
		    	ayetMap.put(ayetNo,txt);
		    }
		    System.out.println("createAyetListAndMap: ayetNoList.size() = " + ayetNoList.size());
		    System.out.println("createAyetListAndMap: ayetMap.size() = " + ayetMap.size());
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
	}
	public static ArrayList<Long> getSureNoList(Connection connT,String tableName)	{
		ArrayList<Long> sureNoList = new ArrayList<Long>();
		String query = 	"SELECT sure FROM "+tableName+" GROUP BY sure ORDER BY sure";
		try	{  
			PreparedStatement ps = connT.prepareStatement(query);
		    //ps.setLong(1, regJob.getRegistryJobId()); 
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
		    	Long sureNo = rs.getLong("sure");
		    	sureNoList.add(sureNo);
		    }
		    System.out.println("getChapterList: sureNoList.size() = " + sureNoList.size());
		    rs.close();
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(sureNoList);	
	}
	public static ArrayList<String> getSentenceListByTokenizer(String str) {
	    ArrayList<String> tokens = new ArrayList<>();
	    if (str.contains("i.e.")) {
	    	str.replace("i.e.", "##ie##");
	    }
	    StringTokenizer tokenizer = new StringTokenizer(str, ".");
	    while (tokenizer.hasMoreElements()) {
	        tokens.add(tokenizer.nextToken());
	    }
	    if (tokens.size()<=0) {
	    	tokens.add(str);
	    }
	    for (int i=0; i<tokens.size(); i++)	{
	    	if (tokens.get(i).contains("##ie##")) {tokens.get(i).replace("##ie##","i.e."); }
	    }
	    return(tokens);
	}
	public static ArrayList<String> getTokenListByTokenizer(String str) {
	    ArrayList<String> tokens = new ArrayList<>();
	    if (str.contains("i.e.")) {
	    	str.replace("i.e.", "##ie##");
	    }
	    StringTokenizer tokenizer = new StringTokenizer(str, " ");
	    while (tokenizer.hasMoreElements()) {
	        tokens.add(tokenizer.nextToken());
	    }
	    if (tokens.size()<=0) {
	    	tokens.add(str);
	    }
	    for (int i=0; i<tokens.size(); i++)	{
	    	if (tokens.get(i).contains("##ie##")) {tokens.get(i).replace("##ie##","i.e."); }
	    }
	    return(tokens);
	}
	private static ArrayList<String> getCleanTokenList(ArrayList<String> tokenList)	{
		ArrayList<String> cleanTokenList = new ArrayList<String>();  
		for (int i=0; i<tokenList.size(); i++)	{
			String token = tokenList.get(i).toLowerCase();
			String token2 = token.replaceAll("[^\\s\\p{L}0-9]", "");  	//replaceAll("\\p{Punct}", "");
			cleanTokenList.add(token2);
		}
		return(cleanTokenList);
	}
	public static void createLibraryToken(Connection conn,Connection connT, NodeBookSet library, NodeBook book, NodeSentence sentence) {	
		//ArrayList<Long> sentenceNoList = new ArrayList<Long>();
		//HashMap<Long,String> sentenceMap = new HashMap<Long,String>();
		ArrayList<String> tokenList = getTokenListByTokenizer(sentence.getSentenceStr());
		ArrayList<String> cleanTokenList = getCleanTokenList(tokenList);
		
		//createSentenceListAndMap(connT, book.getBookName(), chapter.getChapterName(), sentenceNoList, sentenceMap);
		StringBuilder sb = new StringBuilder();
		int cntTkn = 0;
		for (int i=0; i<cleanTokenList.size(); i++)	{
			String token = cleanTokenList.get(i);
			if (token==null) continue;
			if (token.length()==0) continue;
			Long sameTokenId = null;
			if (library.getMapStr2Token().get(token)!=null)	{ 
				sameTokenId = library.getMapStr2Token().get(token).getTokenId();
				sb.append("{"+sameTokenId.longValue()+"} ");
			} else {
				Long tokenId  = JLite.getNextId(conn, "LIB_TOKEN"); 
				ZonedDateTime creationDate = ZonedDateTime.now();
				
				//public NodeToken(Long tokenId, Long dictId, Long wordId, String tokenStr, String tokenDescription, Long tokenLength,
				//Long cntInLibrary, Double frequencyLibrary, ZonedDateTime creationDate) {
				NodeToken ent = new NodeToken(tokenId,null,null,token,null,(long) token.length(), 
						null, null, creationDate);
				library.getListToken().add(ent);
				library.getMapId2Token().put(ent.getTokenId(), ent);
				library.getMapStr2Token().put(token,ent);
				cntTkn++;
				sb.append("{"+ent.getTokenId().longValue()+"} ");
			}	
		}
		sentence.setSentenceHolder(sb.toString());
	}
	public static void createLibrarySentence(Connection conn,Connection connT, NodeBookSet library, NodeBook book, NodeParagraph paragraph) {	
		//ArrayList<Long> sentenceNoList = new ArrayList<Long>();
		//HashMap<Long,String> sentenceMap = new HashMap<Long,String>();
		ArrayList<String> tokenList = getSentenceListByTokenizer(paragraph.getParagraphStr());
		
		//createSentenceListAndMap(connT, book.getBookName(), chapter.getChapterName(), sentenceNoList, sentenceMap);
		int cntSentence = 0;
		for (String token : tokenList)	{
			Long sentenceId  = JLite.getNextId(conn, "LIB_SENTENCE"); 
			String sentenceStr = token;
			ZonedDateTime creationDate = ZonedDateTime.now();
			Long sameSentenceId = null;
			if (library.getMapStr2Sentence().get(sentenceStr)!=null)	{ sameSentenceId = library.getMapStr2Sentence().get(sentenceStr).getSentenceId(); }
			//public NodeSentence(Long sentenceId, Long paragraphId, Long languageId, Long sameSentenceId, String sentenceName, String sentenceType,
			//String sentenceDescription, String sentenceStr, String sentenceHolder, String authorName, String sourceName, Long displayOrder,
			//Long pageNumber, Long lineNumber, Long wordNumber, ZonedDateTime creationDate) {
			NodeSentence sentence = new NodeSentence(sentenceId,paragraph.getParagraphId(), null, sameSentenceId,Integer.toString(cntSentence), "ayet_sentence",
					null, sentenceStr, null, null,"Tanzil",
					(long) cntSentence, null, null, null, creationDate);
			library.getListSentence().add(sentence);
			library.getMapId2Sentence().put(sentence.getSentenceId(), sentence);
			if (sameSentenceId == null) {
				library.getMapStr2Sentence().put(sentenceStr,sentence); 			
			}
			createLibraryToken(conn,connT, library, book, sentence);
			cntSentence++;
		}	
	}
	public static void createLibraryParagraph(Connection conn,Connection connT, NodeBookSet library, NodeBook book, NodeChapter chapter) {	
		ArrayList<Long> ayetNoList = new ArrayList<Long>();
		HashMap<Long,String> ayetMap = new HashMap<Long,String>();
		
		createAyetListAndMap(connT, book.getBookName(), chapter.getChapterName(), ayetNoList, ayetMap);
		int cntParagraph = 0;
		for (Long ayetNo : ayetNoList)	{
			Long paragraphId  = JLite.getNextId(conn, "LIB_PARAGRAPH"); 
			String paragraphStr = ayetMap.get(ayetNo);
			ZonedDateTime creationDate = ZonedDateTime.now();
			Long sameParagraphId = null;
			if (library.getMapStr2Paragraph().get(paragraphStr)!=null)	{ sameParagraphId = library.getMapStr2Paragraph().get(paragraphStr).getParagraphId(); }
			//public NodeParagraph(Long paragraphId, Long chapterId, Long languageId, Long sameParagraphId, String paragraphName, String paragraphType,
			//String paragraphDescription, String paragraphStr,String authorName, String sourceName, Long displayOrder, Long pageNumber,
			//Long lineNumber, Long wordNumber, ZonedDateTime creationDate) {
			NodeParagraph paragraph = new NodeParagraph(paragraphId,chapter.getChapterId(), null, sameParagraphId,ayetNo.toString(), "ayet",
					null, paragraphStr, null, "Tanzil",
					(long) cntParagraph, null, null, null, creationDate);
			library.getListParagraph().add(paragraph);
			library.getMapId2Paragraph().put(paragraph.getParagraphId(), paragraph);
			if (sameParagraphId == null) {
				library.getMapStr2Paragraph().put(paragraphStr,paragraph); 			
			}
			createLibrarySentence(conn,connT, library, book, paragraph);
			cntParagraph++;
		}
	}
	
	*/

	private static ArrayList<String> getTokens(List<String> sentenceStringList)	{
		if (sentenceStringList==null) return(null);
		ArrayList<String> tokenList = new ArrayList<String>();
		for (String strN : sentenceStringList)	{
			String str = strN.replaceAll("[^\\s\\p{L}0-9]", "");  	//replaceAll("\\p{Punct}", "");
			int idx1 = str.indexOf(" ");
			if (idx1>=0) {
				StringTokenizer tokenizer = new StringTokenizer(str, " ");
			    while (tokenizer.hasMoreElements()) {
			    	tokenList.add(tokenizer.nextToken());
			    }
			} else {
				tokenList.add(str);
			}
		}	
		return(tokenList);
	}
	public static HashMap<NodeToken,ArrayList<String>> createTokens(NodeF10 f10, NodeSentence sentence, ArrayList<String> sentenceStringList) {
		
		HashMap<NodeToken,ArrayList<String>> mapToken2StringList = new HashMap<>();
		if ((sentenceStringList==null) || (sentenceStringList.isEmpty())) return(null);
		
		ArrayList<String> tokenStringList = getTokens(sentenceStringList);
		int displayOrder = 0;
		ArrayList<String> tokenList = new ArrayList<String>();
		for (String tokenStr : tokenStringList)	{

			NodeToken token = f10.getBookSet().getMapStr2Token().get(tokenStr);
			if (token==null)	{
				//public static NodeToken createOneToken(NodeF10 f10, Long dictId, Long wordId, String tokenStr, String tokenDesc, Long tokenLength)	{
				token = MakeBookSetTables.createOneToken(f10, null, null, tokenStr, tokenStr+"_desc", (long) tokenStr.length());
			}
			tokenList.add(tokenStr);
			mapToken2StringList.put(token,tokenList);
			sentence.getListToken().add(token);
			displayOrder++;
		}
		
		return(mapToken2StringList);
	}
	private static String getSentenceHolderString(NodeSentence sentence, ArrayList<String> sentenceStringList)	{
		
		StringBuilder sb = new StringBuilder();
		for (String sentenceStr : sentenceStringList)	{
			String stcStr = sentenceStr;
			for (NodeToken token : sentence.getListToken())	{
				stcStr = stcStr.replace(token.getTokenStr(), "{#"+token.getTokenId()+"#}");
			}
			sb.append(stcStr);
		}
		return(sb.toString());
	}
	private static ArrayList<String> getSentences(List<String> paragraphStringList)	{
		if (paragraphStringList==null) return(null);
		ArrayList<String> sentenceList = new ArrayList<String>();
		for (String str : paragraphStringList)	{
			int idx1 = str.indexOf(".");
			if (idx1>=0) {
				StringTokenizer tokenizer = new StringTokenizer(str, ".");
			    while (tokenizer.hasMoreElements()) {
			    	sentenceList.add(tokenizer.nextToken());
			    }
			} else {
				sentenceList.add(str);
			}
		}	
		return(sentenceList);
	}	
	public static HashMap<NodeSentence,ArrayList<String>> createSentences(NodeF10 f10, NodeBook book, NodeChapter chapter, NodeParagraph paragraph,
			ArrayList<String> paragraphStringList) {
		HashMap<NodeSentence,ArrayList<String>> mapSentence2StringList = new HashMap<>();
		if ((paragraphStringList==null) || (paragraphStringList.isEmpty())) return(null);
		ArrayList<String> sentenceStringList = getSentences(paragraphStringList);
		
		int displayOrder = 0;
		for (String sentenceStr : sentenceStringList)	{

			String sentenceName=("OtherLines".equals(chapter.getChapterName())) ? "OtherSentence"+displayOrder : "AyatSentence"+displayOrder ; 
			String sentenceType="ayatsentence";
			String sentenceDesc="Tanzil_book["+book.getBookName()+"].chapter["+chapter.getChapterName() + "].paragraph[" + paragraph.getParagraphName()+"]" +
					"sentence["+sentenceName+"]";
			//public static NodeSentence createOneSentence(NodeF10 f10, Long paragraphId, Long displayOrder, 
			//		String sentenceName, String sentenceType, String sentenceDesc, String sentenceStr)	{
			NodeSentence newSentence = MakeBookSetTables.createOneSentence(f10, paragraph.getParagraphId(), book.getBookId(), (long) displayOrder, 
					sentenceName, sentenceType, sentenceDesc, sentenceStr);
			
			ArrayList<String> sntcList = new ArrayList<String>();
			sntcList.add(sentenceStr);
			mapSentence2StringList.put(newSentence,sntcList);
			displayOrder++;
		}
		return(mapSentence2StringList);
	}
	public static HashMap<NodeParagraph,ArrayList<String>> createParagraphs(NodeF10 f10, NodeBook book, NodeChapter chapter, NodeSection section,
			ArrayList<String> sectionStringList) {
		HashMap<NodeParagraph,ArrayList<String>> mapParagraph2StringList = new HashMap<>();
		if ((sectionStringList==null) || (sectionStringList.isEmpty())) return(null);
		int displayOrder = 0;
		for (String str : sectionStringList)	{

			String paragraphName=("OtherLines".equals(chapter.getChapterName())) ? "OtherLine"+displayOrder : "Ayat"+displayOrder ; 
			String paragraphType="ayat";
			String paragraphDesc="Tanzil_book["+book.getBookName()+"].chapter["+chapter.getChapterName() +"].section["+section.getSectionName() + "].paragraph[" + paragraphName+"]";
			//public static NodeParagraph createOneParagraph(NodeF10 f10, Long chapterId, Long displayOrder, 
			//		String paragraphName, String paragraphType, String paragraphDesc)	{
			NodeParagraph newParagraph = MakeBookSetTables.createOneParagraph(f10, section.getSectionId(), book.getBookId(), (long) displayOrder, paragraphName, paragraphType, paragraphDesc);
			
			ArrayList<String> prfList = new ArrayList<String>();
			prfList.add(str);
			mapParagraph2StringList.put(newParagraph,prfList);
			displayOrder++;
		}
		return(mapParagraph2StringList);
	}
	public static HashMap<NodeSection,ArrayList<String>> createSections(NodeF10 f10, NodeBook book, NodeChapter chapter,
			ArrayList<String> chapterStringList) {
		HashMap<NodeSection,ArrayList<String>> mapSection2StringList = new HashMap<>();
		if ((chapterStringList==null) || (chapterStringList.isEmpty())) return(null);
		int displayOrder = 0;
		for (String str : chapterStringList)	{

			String sectionName=("OtherLines".equals(chapter.getChapterName())) ? "OtherLine"+displayOrder : "Ayat"+displayOrder ; 
			String sectionType="ayat";
			String sectionDesc="Tanzil_book["+book.getBookName()+"].chapter["+chapter.getChapterName() + "].section[" + sectionName+"]";
			//public static NodeSection createOneSection(NodeF10 f10, Long chapterId, Long bookId, Long displayOrder, 
			//String sectionName, String sectionType, String sectionDesc)	{
			NodeSection newSection = MakeBookSetTables.createOneSection(f10, chapter.getChapterId(), book.getBookId(), (long) displayOrder, sectionName, sectionType, sectionDesc);
			
			ArrayList<String> sctList = new ArrayList<String>();
			sctList.add(str);
			mapSection2StringList.put(newSection,sctList);
			displayOrder++;
		}
		return(mapSection2StringList);
	}
	private static ArrayList<ArrayList<String>> getChapters(List<String> bookLineList)	{
		ArrayList<ArrayList<String>> chapterList = new ArrayList<ArrayList<String>>();
		if (bookLineList==null) return(null);
		System.out.println("MakeBookSetTanzil getChapters bookLineList.size():"+bookLineList.size());
		SortedMap<Integer,ArrayList<String>> mapSurahNo2StringBuilder = new TreeMap<>();
		int cntInsertedLines = 0;
		ArrayList<String> sbOthers = new ArrayList<String>(); 
		for (String lineStr : bookLineList)	{
			int idx1 = lineStr.indexOf("|");
			if (idx1<0) {
				sbOthers.add(lineStr); 
				continue;
			}
			int idx2 = lineStr.lastIndexOf("|");
			
			String stra = lineStr.substring(0,idx1);
			String strb = lineStr.substring(idx1+1,idx2);
			String strc = lineStr.substring(idx2+1,lineStr.length());
			System.out.println("stra:"+stra+"  ,strb:"+strb+"  ,strc:"+strc);	
			String[] str3 = new String[] {stra, strb,strc}; //lineStr.split("|");
			//for (String ss : str3) System.out.println("str3.length:"+str3.length+" ,ss:" +ss + " ,lineStr:"+lineStr+ " ,idx1:"+idx1+" ,idx2:"+idx2);
			if (str3.length<3) continue;
			if ((str3[0]==null) || (str3[1]==null) || (str3[2]==null)) continue;
			if ((str3[0].length()==0) || (str3[1].length()==0) || (str3[2].length()==0)) continue;
			int surahIdx = StrUtil.parseStr2Int(str3[0]);
			if ((surahIdx<=0) || (surahIdx>114)) continue;
			int ayahIdx = StrUtil.parseStr2Int(str3[1]);
			if ((ayahIdx<=0) || (ayahIdx>300)) continue;
			if (mapSurahNo2StringBuilder.get(surahIdx)==null) { mapSurahNo2StringBuilder.put(surahIdx, new ArrayList<String>());}
			mapSurahNo2StringBuilder.get(surahIdx).add(str3[2]); //System.lineSeparator());
			cntInsertedLines++;
		}
		System.out.println("MakeBookSetTanzil getChapters mapSurahNo2StringBuilder.size():"+mapSurahNo2StringBuilder.size() + "  ,cntInsertedLines:"+cntInsertedLines);
		
		for (Integer key : mapSurahNo2StringBuilder.keySet())	{
			ArrayList<String> strList = mapSurahNo2StringBuilder.get(key);
			if (strList==null) continue;
			chapterList.add(strList);
		}
		chapterList.add(sbOthers);  //add the others as the last chapter
		
 		System.out.println("MakeBookSetTanzil getChapters chapterList.size():"+chapterList.size());
		return(chapterList);
	}
	public static HashMap<NodeChapter,ArrayList<String>> createChapters(NodeF10 f10, NodeBook book, NodeBookBlob bookBlob) {
		HashMap<NodeChapter,ArrayList<String>> mapChapter2StringList = new HashMap<>();
		if ((bookBlob.getBookBytes()==null) || (bookBlob.getBookBytes().length==0)) return(null);
		
		ArrayList<ArrayList<String>> chapterList = getChapters(bookBlob.getBookLines());
		if ((chapterList==null) || (chapterList.isEmpty())) return(null);
		int displayOrder = 0;
		for (ArrayList<String> strList : chapterList)	{

			String chapterName=(displayOrder<surayArray.length) ? surayArray[displayOrder] : "OtherLines"; 
			String chapterType="surah";
			String chapterDesc="Tanzil_"+chapterName;
			NodeChapter newChapter = MakeBookSetTables.createOneChapter(f10, book.getBookId(), (long) displayOrder, chapterName, chapterType, chapterDesc);
			
			mapChapter2StringList.put(newChapter,strList);
			displayOrder++;
		}
		return(mapChapter2StringList);
	}
	public static void processBook(NodeF10 f10, NodeBook book, NodeBookBlob bookBlob)	{
		HashMap<NodeChapter,ArrayList<String>> mapChapter2StringList = createChapters(f10,book,bookBlob);
		
		for (NodeChapter chapter : mapChapter2StringList.keySet())	{
			ArrayList<String> chapterStringList = mapChapter2StringList.get(chapter); 
			
			HashMap<NodeSection,ArrayList<String>> mapSection2StringList = createSections(f10,book, chapter,chapterStringList);
			System.out.println("MakeBookSetTanzil processBook mapSSection2StringList.size():"+mapSection2StringList.size());
			for (NodeSection section : mapSection2StringList.keySet())	{
				ArrayList<String> sectionStringList = mapSection2StringList.get(section); 

				SECTION KISMI DÜZELTİLECEK , TEST EDİLECEK
				HashMap<NodeParagraph,ArrayList<String>> mapParagraph2StringList = createParagraphs(f10,book, chapter, section, sectionStringList);
				System.out.println("MakeBookSetTanzil processBook mapParagraph2StringList.size():"+mapParagraph2StringList.size());
				for (NodeParagraph paragraph : mapParagraph2StringList.keySet())	{
					ArrayList<String> paragraphStringList = mapParagraph2StringList.get(paragraph);
					HashMap<NodeSentence,ArrayList<String>> mapSentence2StringList = createSentences(f10,book, chapter, paragraph, paragraphStringList);
					System.out.println("MakeBookSetTanzil processBook mapSentence2StringList.size():"+mapSentence2StringList.size());
					
					for (NodeSentence sentence : mapSentence2StringList.keySet())	{
						ArrayList<String> sentenceStringList = mapSentence2StringList.get(sentence);
						createTokens(f10, sentence, sentenceStringList);
						String sentenceHolder = getSentenceHolderString(sentence, sentenceStringList);
						sentence.setSentenceHolder(sentenceHolder);
					} //for sentence
				} //for paragraph
			} //for section 
		} //for chapter
		
	}
}
