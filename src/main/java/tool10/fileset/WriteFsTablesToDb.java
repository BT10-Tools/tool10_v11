package tool10.fileset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.ZonedDateTime;

import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileBlobSmall;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeProperty;
import tool10.fileset.nodes.NodeSimilarity;
import tool10.fileset.transform.NodeArchive;
import tool10.fileset.transform.NodeContainer;
import tool10.fileset.transform.NodeTransform;

public class WriteFsTablesToDb {

/*
	public static int writeTableDistance(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_DISTANCE(distanceId,corpusId,sourceId,entityId1,entityId2,distanceType,distance,similarity,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ? )";
		//public NodeDistance(Long distanceId, Long corpusId, Long sourceId, Long entityId1, Long entityId2,
		//String distanceType, Double distance, Double similarity, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeDistance ent : corpus.getRef().getListDistance())	{
			    int cnt=1;
			    if (ent.getDistanceId()!=null) {ps.setLong(cnt++, ent.getDistanceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getEntityId1()!=null) {ps.setLong(cnt++, ent.getEntityId1());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getEntityId2()!=null) {ps.setLong(cnt++, ent.getEntityId2());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getDistanceType());
			    if (ent.getDistance()!=null) {ps.setDouble(cnt++, ent.getDistance());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSimilarity()!=null) {ps.setDouble(cnt++, ent.getSimilarity());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableDistance: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTokenType(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_TOKENTYPE (tokenTypeId,corpusId,tokenTypeName,tokenTypeDesc,displayOrder,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeTokenType(Long tokenTypeId, Long corpusId, String tokenTypeName, String tokenTypeDesc, Long displayOrder,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTokenType ent : corpus.getRef().getListTokenType())	{
			    int cnt=1;
			    if (ent.getTokenTypeId()!=null) {ps.setLong(cnt++, ent.getTokenTypeId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getTokenTypeName());
			    ps.setString(cnt++, ent.getTokenTypeDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTokenType: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableToken(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_TOKEN(tokenId, tokenTypeId,corpusId,tokenLength, tokenName,tokenDesc,tokenStr,valueLong,valueDouble,valueDate,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ? )";
		//public NodeToken(Long tokenId, Long tokenTypeId, Long corpusId, Long tokenLength, String tokenName, String tokenDesc, String tokenStr,
		//Long valueLong, Double valueDouble, ZonedDateTime valueDate, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeToken ent : corpus.getRef().getListToken())	{
			    int cnt=1;
			    if (ent.getTokenId()!=null) {ps.setLong(cnt++, ent.getTokenId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getTokenTypeId()!=null) {ps.setLong(cnt++, ent.getTokenTypeId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getTokenLength()!=null) {ps.setLong(cnt++, ent.getTokenLength());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getTokenName());
			    ps.setString(cnt++, ent.getTokenDesc());
			    ps.setString(cnt++, ent.getTokenStr());
			    if (ent.getValueLong()!=null) {ps.setLong(cnt++, ent.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDouble()!=null) {ps.setDouble(cnt++, ent.getValueDouble());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDate()!=null) {ps.setString(cnt++, ent.getValueDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableToken: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableStat(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_STAT("+
			"statId,entityId,statType,fileTxtGroupId,sourceId,languageId,languageId2,fileSize,cntDistinctLanguageId,cntDistinctEncoding,"+
			"cntFile,cntLine,cntDistinctLine,cntEmptyLine,minCntLinePerFile,maxCntLinePerFile,cntCharacter,cntDistinctCharacter,cntColumn,avgColumn,"+
			"cntPhrase,cntDistinctPhrase,cntToken,cntDistinctToken,minLineLength,maxLineLength,sumLineLength,avgLineLength,crc64,creationDate,modificationDate"+
			"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,  ? )";
		//public NodeStat(Long statId, Long entityId, String statType, Long fileTxtGroupId, Long sourceId, Long languageId,
		//Long languageId2, Long fileSize, Long cntDistinctLanguageId, Long cntDistinctEncoding,
		//Long cntFile, Long cntLine, Long cntDistinctLine, Long cntEmptyLine, Long minCntLinePerFile,
		//Long maxCntLinePerFile, Long cntCharacter, Long cntDistinctCharacter, Long cntColumn, Long avgColumn,
		//Long cntPhrase, Long cntDistinctPhrase, Long cntToken, Long cntDistinctToken, Long minLineLength,
		//Long maxLineLength, Long sumLineLength, Double avgLineLength, Long crc64, ZonedDateTime creationDate,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeStat ent : corpus.getRef().getListStat())	{
			    int cnt=1;
			    if (ent.getStatId()!=null) {ps.setLong(cnt++, ent.getStatId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getStatType());			    
			    if (ent.getFileTxtGroupId()!=null) {ps.setLong(cnt++, ent.getFileTxtGroupId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId2()!=null) {ps.setLong(cnt++, ent.getLanguageId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctLanguageId()!=null) {ps.setLong(cnt++, ent.getCntDistinctLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctEncoding()!=null) {ps.setLong(cnt++, ent.getCntDistinctEncoding());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntLine()!=null) {ps.setLong(cnt++, ent.getCntLine());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctLine()!=null) {ps.setLong(cnt++, ent.getCntDistinctLine());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntEmptyLine()!=null) {ps.setLong(cnt++, ent.getCntEmptyLine());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMinCntLinePerFile()!=null) {ps.setLong(cnt++, ent.getMinCntLinePerFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMaxCntLinePerFile()!=null) {ps.setLong(cnt++, ent.getMaxCntLinePerFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntCharacter()!=null) {ps.setLong(cnt++, ent.getCntCharacter());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctCharacter()!=null) {ps.setLong(cnt++, ent.getCntDistinctCharacter());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntColumn()!=null) {ps.setLong(cnt++, ent.getCntColumn());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAvgColumn()!=null) {ps.setLong(cnt++, ent.getAvgColumn());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntPhrase()!=null) {ps.setLong(cnt++, ent.getCntPhrase());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctPhrase()!=null) {ps.setLong(cnt++, ent.getCntDistinctPhrase());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntToken()!=null) {ps.setLong(cnt++, ent.getCntToken());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDistinctToken()!=null) {ps.setLong(cnt++, ent.getCntDistinctToken());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMinLineLength()!=null) {ps.setLong(cnt++, ent.getMinLineLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getMaxLineLength()!=null) {ps.setLong(cnt++, ent.getMaxLineLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSumLineLength()!=null) {ps.setLong(cnt++, ent.getSumLineLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAvgLineLength()!=null) {ps.setLong(cnt++, ent.getAvgLineLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableStat: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableRef(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_REF(refId, entityId, corpusId, entityType, refName, refDesc, creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeRef(Long refId, Long entityId, Long corpusId, String entityType, String refName, String refDesc,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeRef ent : corpus.getRef().getListRef())	{
			    int cnt=1;
			    if (ent.getRefId()!=null) {ps.setLong(cnt++, ent.getRefId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getEntityType());
			    ps.setString(cnt++, ent.getRefName());
			    ps.setString(cnt++, ent.getRefDesc());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableRef: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTablePhrase(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_PHRASE(phraseId, phraseTypeId, corpusId, phraseLength, phraseName, phraseDesc, phraseStr,"+
						"isMultiLine, isIgnoreCase, isAbbreviation,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?)";
		//public NodePhrase(Long phraseId, Long phraseTypeId, Long corpusId, Long phraseLength, String phraseName, String phraseDesc, String phraseStr,
		//String isMultiLine, String isIgnoreCase, String isAbbreviation, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodePhrase ent : corpus.getRef().getListPhrase())	{
			    int cnt=1;
			    if (ent.getPhraseId()!=null) {ps.setLong(cnt++, ent.getPhraseId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPhraseTypeId()!=null) {ps.setLong(cnt++, ent.getPhraseTypeId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getPhraseLength()!=null) {ps.setLong(cnt++, ent.getPhraseLength());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getPhraseName());
			    ps.setString(cnt++, ent.getPhraseDesc());
			    ps.setString(cnt++, ent.getPhraseStr());
			    ps.setString(cnt++, ent.getIsMultiLine());
			    ps.setString(cnt++, ent.getIsIgnoreCase());
			    ps.setString(cnt++, ent.getIsAbbreviation());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTablePhrase: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableLineTemplate(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_LINETEMPLATE (lineTemplateId,corpusId,lineTemplateName,lineTemplateDesc,displayOrder,"+
						"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeLineTemplate(Long lineTemplateId, Long corpusId, String lineTemplateName, String lineTemplateDesc, Long displayOrder,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeLineTemplate ent : corpus.getRef().getListLineTemplate())	{
			    int cnt=1;
			    if (ent.getLineTemplateId()!=null) {ps.setLong(cnt++, ent.getLineTemplateId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getLineTemplateName());
			    ps.setString(cnt++, ent.getLineTemplateDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableLineTemplate: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableLineGroup(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_LINEGROUP (lineGroupId,corpusId,higherLineGroupId,lineGroupName,lineGroupDesc,displayOrder,"+
						"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeLineGroup(Long lineGroupId, Long corpusId, Long higherLineGroupId, String lineGroupName,
		//String lineGroupDesc, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeLineGroup ent : corpus.getRef().getListLineGroup())	{
			    int cnt=1;
			    if (ent.getLineGroupId()!=null) {ps.setLong(cnt++, ent.getLineGroupId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getHigherLineGroupId()!=null) {ps.setLong(cnt++, ent.getHigherLineGroupId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getLineGroupName());
			    ps.setString(cnt++, ent.getLineGroupDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableLineGroup: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableLine(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_LINE (lineId,fileId,lineTemplateId,lineGroupId,referenceLineId,lineNumber,lineLength,"+
						"lineStr,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeLine(Long lineId, Long fileId, Long lineTemplateId, Long lineGroupId, Long referenceLineId, Long lineNumber,
		//Long lineLength, String lineStr,ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeLine ent : corpus.getRef().getListLine())	{
			    int cnt=1;
			    if (ent.getLineId()!=null) {ps.setLong(cnt++, ent.getLineId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineTemplateId()!=null) {ps.setLong(cnt++, ent.getLineTemplateId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getReferenceLineId()!=null) {ps.setLong(cnt++, ent.getReferenceLineId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineNumber()!=null) {ps.setLong(cnt++, ent.getLineNumber());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getLineLength()!=null) {ps.setLong(cnt++, ent.getLineLength());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getLineStr());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableLine: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileType(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_FILETYPE (fileTypeId,corpusId,fileTemplateId,fileTypeName,fileTypeDesc,displayOrder,"+
						"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeFileType(Long fileTypeId, Long corpusId, Long fileTemplateId, String fileTypeName, String fileTypeDesc,
		//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileType ent : corpus.getRef().getListFileType())	{
			    int cnt=1;
			    if (ent.getFileTypeId()!=null) {ps.setLong(cnt++, ent.getFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileTemplateId()!=null) {ps.setLong(cnt++, ent.getFileTemplateId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getFileTypeName());
			    ps.setString(cnt++, ent.getFileTypeDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileType: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileTemplate(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_FILETEMPLATE (fileTemplateId,corpusId,fileTemplateName,fileTemplateDesc,displayOrder,"+
						"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileTemplate(Long fileTemplateId, Long corpusId, String fileTemplateName, String fileTemplateDesc,
		//Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileTemplate ent : corpus.getRef().getListFileTemplate())	{
			    int cnt=1;
			    if (ent.getFileTemplateId()!=null) {ps.setLong(cnt++, ent.getFileTemplateId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    ps.setString(cnt++, ent.getFileTemplateName());
			    ps.setString(cnt++, ent.getFileTemplateDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileTemplate: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileGroup(Connection conn,NodeFileSet corpus)	{
		int cntInserted = 0;
		String query =  "INSERT INTO TXT_FILEGROUP (fileGroupId,corpusId,sourceId,higherFileGroupId,fileGroupName,fileGroupDesc,displayOrder,"+
						"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?)";
		//public NodeFileGroup(Long fileGroupId, Long corpusId, Long sourceId, Long higherFileGroupId, String fileGroupName,
		//String fileGroupDesc, Long displayOrder, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileGroup ent : corpus.getRef().getListFileGroup())	{
			    int cnt=1;
			    if (ent.getFileGroupId()!=null) {ps.setLong(cnt++, ent.getFileGroupId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getCorpusId()!=null) {ps.setLong(cnt++, ent.getCorpusId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 			    
			    if (ent.getHigherFileGroupId()!=null) {ps.setLong(cnt++, ent.getHigherFileGroupId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileGroupName());
			    ps.setString(cnt++, ent.getFileGroupDesc());
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileGroup: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
*/	
	public static int writeTableContainer(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_CONTAINER(containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName,\r\n" +
						" containerRemark, cntFile, originalFileSize,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?)";
		//public NodeContainer(Long containerId, Long fileSetId, Long containerFileId, Long containerFileSetId,
		//String containerType, String extensionType, String algorithmName, String containerRemark, Long cntFile,
		//Long originalFileSize, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//containerId, fileSetId, containerFileId, containerFileSetId, containerType,extensionType, algorithmName, 
		//containerRemark, cntFile, originalFileSize
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeContainer ent : fileSet.getListContainer())	{
			    int cnt=1;
			    if (ent.getContainerId()!=null) {ps.setLong(cnt++, ent.getContainerId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContainerFileId()!=null) {ps.setLong(cnt++, ent.getContainerFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getContainerFileSetId()!=null) {ps.setLong(cnt++, ent.getContainerFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getContainerType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getContainerRemark());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableContainer: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableTransform(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_TRANSFORM(transformId, fileSetId, transformFileId, transformFileSetId, transformedFileId, transformType, extensionType, algorithmName,\r\n" +
				 		" transformRemark, tmpFileName, cntFile, originalFileSize, transformedFileSize, creationDate, modificationDate) "+
						" VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeTransform(Long transformId, Long fileSetId, Long transformFileId, Long transformFileSetId,
		//Long transformedFileId, String transformType, String extensionType, String algorithmName,
		//String transformRemark, tmpFileName, Long cntFile, Long originalFileSize, Long transformedFileSize,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
				
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeTransform ent : fileSet.getListTransform())	{
			    int cnt=1;
			    if (ent.getTransformId()!=null) {ps.setLong(cnt++, ent.getTransformId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformFileId()!=null) {ps.setLong(cnt++, ent.getTransformFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformFileSetId()!=null) {ps.setLong(cnt++, ent.getTransformFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformedFileId()!=null) {ps.setLong(cnt++, ent.getTransformedFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getTransformType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getTransformRemark());
			    ps.setString(cnt++, ent.getTmpFileName());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTransformedFileSize()!=null) {ps.setLong(cnt++, ent.getTransformedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableTransform: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableArchive(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_ARCHIVE(archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, \r\n"
				+ "		multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,\r\n"
				+ "		unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  ?, ?)";
		//public NodeArchive(Long archiveId, Long fileSetId, Long archiveFileId, Long archiveFileSetId, String archiveType,
		//String extensionType, String algorithmName, String multipleFileArchive, String archiveRemark, Long cntFile,
		//Long cntArchive, Long cntDirectory, Long cntFileTree, Long cntDirectoryTree, Long originalFileSize,
		//Long unzippedFileSize, Double unzipGainRatio, Long unzippedGainBytes, ZonedDateTime archiveCreationDate,
		//ZonedDateTime archiveModificationDate, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		//archiveId, fileSetId, archiveFileId, archiveFileSetId, archiveType,extensionType, algorithmName, 
		//multipleFileArchive, archiveRemark, cntFile, cntArchive, cntDirectory, cntFileTree, cntDirectoryTree, originalFileSize,
		//unzippedFileSize, unzipGainRatio, unzippedGainBytes, archiveCreationDate,archiveModificationDate
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeArchive ent : fileSet.getListArchive())	{
			    int cnt=1;
			    if (ent.getArchiveId()!=null) {ps.setLong(cnt++, ent.getArchiveId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveFileId()!=null) {ps.setLong(cnt++, ent.getArchiveFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveFileSetId()!=null) {ps.setLong(cnt++, ent.getArchiveFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getArchiveType());
			    ps.setString(cnt++, ent.getExtensionType());
			    ps.setString(cnt++, ent.getAlgorithmName());
			    ps.setString(cnt++, ent.getMultipleFileArchive());
			    ps.setString(cnt++, ent.getArchiveRemark());
			    if (ent.getCntFile()!=null) {ps.setLong(cnt++, ent.getCntFile());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntArchive()!=null) {ps.setLong(cnt++, ent.getCntArchive());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDirectory()!=null) {ps.setLong(cnt++, ent.getCntDirectory());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntFileTree()!=null) {ps.setLong(cnt++, ent.getCntFileTree());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntDirectoryTree()!=null) {ps.setLong(cnt++, ent.getCntDirectoryTree());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getOriginalFileSize()!=null) {ps.setLong(cnt++, ent.getOriginalFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnzippedFileSize()!=null) {ps.setLong(cnt++, ent.getUnzippedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnzipGainRatio()!=null) {ps.setDouble(cnt++, ent.getUnzipGainRatio());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getUnzippedGainBytes()!=null) {ps.setLong(cnt++, ent.getUnzippedGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getArchiveCreationDate()!=null) {ps.setString(cnt++, ent.getArchiveCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getArchiveModificationDate()!=null) {ps.setString(cnt++, ent.getArchiveModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableArchive: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableHash(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_HASH(hashId,fileSetId,fileSize,crc64,crc32,adler32,blake3,md5,\r\n"
				+ "		sha1,sha256,sha384,sha512,sha3256,keccak256,hashFieldDesc,hashStr01,hashStr02,hashStr03,hashStr04,\r\n"
				+ "		hashStr05,hashLong01,hashLong02,hashLong03,hashLong04,hashLong05,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  "+
				                "?, ?, ?, ?, ?,    ?, ?)";
		//public NodeHash(Long hashId, Long fileSetId, Long fileSize, Long crc64, Long crc32, Long adler32, String blake3, String md5,
		//String sha1,String sha256,String sha384,String sha512,String sha3256,String keccak256,
		//String hashFieldDesc, String hashStr01, String hashStr02, String hashStr03, String hashStr04,
		//String hashStr05, Long hashLong01, Long hashLong02, Long hashLong03, Long hashLong04, Long hashLong05,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeHash ent : fileSet.getListHash())	{
			    int cnt=1;
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc64()!=null) {ps.setLong(cnt++, ent.getCrc64());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCrc32()!=null) {ps.setLong(cnt++, ent.getCrc32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getAdler32()!=null) {ps.setLong(cnt++, ent.getAdler32());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlake3());
			    ps.setString(cnt++, ent.getMd5());
			    ps.setString(cnt++, ent.getSha1());
			    ps.setString(cnt++, ent.getSha256());
			    ps.setString(cnt++, ent.getSha384());
			    ps.setString(cnt++, ent.getSha512());
			    ps.setString(cnt++, ent.getSha3256());
			    ps.setString(cnt++, ent.getKeccak256());
			    ps.setString(cnt++, ent.getHashFieldDesc());
			    ps.setString(cnt++, ent.getHashStr01());
			    ps.setString(cnt++, ent.getHashStr02());
			    ps.setString(cnt++, ent.getHashStr03());
			    ps.setString(cnt++, ent.getHashStr04());
			    ps.setString(cnt++, ent.getHashStr05());
			    if (ent.getHashLong01()!=null) {ps.setLong(cnt++, ent.getHashLong01());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong02()!=null) {ps.setLong(cnt++, ent.getHashLong02());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong03()!=null) {ps.setLong(cnt++, ent.getHashLong03());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong04()!=null) {ps.setLong(cnt++, ent.getHashLong04());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashLong05()!=null) {ps.setLong(cnt++, ent.getHashLong05());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableHash: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableSimilarity(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_SIMILARITY(similarityId,fileSetId,entityId1,entityId2,similarityType,similarityKey,\r\n"
				+ "		sim00,sim01,sim02,sim03,sim04,sim05,sim06,sim07,sim08,sim09,sim10,sim11,sim12,sim13,\r\n"
				+ "		sim14,sim15,sim16,sim17,sim18,sim19,alg00,alg01,alg02,alg03,alg04,alg05,alg06,alg07,\r\n"
				+ "		alg08,alg09,alg10,alg11,alg12,alg13,alg14,\r\n"
				+ "		alg15,alg16,alg17,alg18,alg19,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  "+
				                "?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,  ?, ?, ?)";
		//public NodeSimilarity(Long similarityId, Long fileSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
		//Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
		//Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
		//Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
		//String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
		//String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
		//String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,ZonedDateTime modificationDate) {
		
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeSimilarity ent : fileSet.getListSimilarity())	{
			    int cnt=1;
			    if (ent.getSimilarityId()!=null) {ps.setLong(cnt++, ent.getSimilarityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId1()!=null) {ps.setLong(cnt++, ent.getEntityId1());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId2()!=null) {ps.setLong(cnt++, ent.getEntityId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSimilarityType());
			    ps.setString(cnt++, ent.getSimilarityKey());
			    if (ent.getSim00()!=null) {ps.setDouble(cnt++, ent.getSim00());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim01()!=null) {ps.setDouble(cnt++, ent.getSim01());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim02()!=null) {ps.setDouble(cnt++, ent.getSim02());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim03()!=null) {ps.setDouble(cnt++, ent.getSim03());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim04()!=null) {ps.setDouble(cnt++, ent.getSim04());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim05()!=null) {ps.setDouble(cnt++, ent.getSim05());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim06()!=null) {ps.setDouble(cnt++, ent.getSim06());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim07()!=null) {ps.setDouble(cnt++, ent.getSim07());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim08()!=null) {ps.setDouble(cnt++, ent.getSim08());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim09()!=null) {ps.setDouble(cnt++, ent.getSim09());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim10()!=null) {ps.setDouble(cnt++, ent.getSim10());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim11()!=null) {ps.setDouble(cnt++, ent.getSim11());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim12()!=null) {ps.setDouble(cnt++, ent.getSim12());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim13()!=null) {ps.setDouble(cnt++, ent.getSim13());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim14()!=null) {ps.setDouble(cnt++, ent.getSim14());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim15()!=null) {ps.setDouble(cnt++, ent.getSim15());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim16()!=null) {ps.setDouble(cnt++, ent.getSim16());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim17()!=null) {ps.setDouble(cnt++, ent.getSim17());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim18()!=null) {ps.setDouble(cnt++, ent.getSim18());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getSim19()!=null) {ps.setDouble(cnt++, ent.getSim19());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    ps.setString(cnt++, ent.getAlg00());
			    ps.setString(cnt++, ent.getAlg01());
			    ps.setString(cnt++, ent.getAlg02());
			    ps.setString(cnt++, ent.getAlg03());
			    ps.setString(cnt++, ent.getAlg04());
			    ps.setString(cnt++, ent.getAlg05());
			    ps.setString(cnt++, ent.getAlg06());
			    ps.setString(cnt++, ent.getAlg07());
			    ps.setString(cnt++, ent.getAlg08());
			    ps.setString(cnt++, ent.getAlg09());
			    ps.setString(cnt++, ent.getAlg10());
			    ps.setString(cnt++, ent.getAlg11());
			    ps.setString(cnt++, ent.getAlg12());
			    ps.setString(cnt++, ent.getAlg13());
			    ps.setString(cnt++, ent.getAlg14());
			    ps.setString(cnt++, ent.getAlg15());
			    ps.setString(cnt++, ent.getAlg16());
			    ps.setString(cnt++, ent.getAlg17());
			    ps.setString(cnt++, ent.getAlg18());
			    ps.setString(cnt++, ent.getAlg19());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableSimilarity: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableProperty(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_PROPERTY (propertyId, fileSetId, entityId, displayOrder, mapName, entityName, propertyKey, propertyValue, \r\n"
				+ "			valueString, valueLong,valueDouble, valueBinary, valueZDT,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeProperty(Long propertyId, Long fileSetId, Long entityId, Long displayOrder, String mapName,
		//String entityName, String propertyKey, String propertyValue, String valueString, Long valueLong,
		//Double valueDouble, NodeBinary valueBinary, ZonedDateTime valueZDT, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeProperty ent : fileSet.getListProperty())	{
			    int cnt=1;
			    if (ent.getPropertyId()!=null) {ps.setLong(cnt++, ent.getPropertyId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEntityId()!=null) {ps.setLong(cnt++, ent.getEntityId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getMapName());
			    ps.setString(cnt++, ent.getEntityName());
			    ps.setString(cnt++, ent.getPropertyKey());
			    ps.setString(cnt++, ent.getPropertyValue());
			    ps.setString(cnt++, ent.getValueString());
			    if (ent.getValueLong()!=null) {ps.setLong(cnt++, ent.getValueLong());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getValueDouble()!=null) {ps.setDouble(cnt++, ent.getValueDouble());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getValueBinary()!=null) {ps.setBytes(cnt++, ent.getValueBinary().getByteArray());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getValueZDT()!=null) {ps.setString(cnt++, ent.getValueZDT().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableProperty: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileBlobSmall(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEBLOBSMALL (fileBlobSmallId,fileBlobId,fileId,fileSetId,byteIndexStart,byteIndexEnd,hashId,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?)";
		//public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
		//Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileBlobSmall ent : fileSet.getListFileBlobSmall())	{
			    int cnt=1;
			    if (ent.getFileBlobSmallId()!=null) {ps.setLong(cnt++, ent.getFileBlobSmallId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getByteIndexStart()!=null) {ps.setLong(cnt++, ent.getByteIndexStart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getByteIndexEnd()!=null) {ps.setLong(cnt++, ent.getByteIndexEnd());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileBlobSmall: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileBlob(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEBLOB (fileBlobId,fileId,fileSetId,partNumber,cntPart,blobType,blobSize,fileSize,compressionType,compressedFileSize,\r\n"+
						"compressionGainRatio,compressionGainBytes,compressedByteHashId, \r\n" +
				 		"sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType,encryptedFileSize,encrytedByteHashId,fileBytes,compressedBytes,encryptedBytes, \r\n"+
				 		"hashId,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long fileSetId, Long partNumber, Long cntPart, String blobType,
		//		Long blobSize, Long fileSize, String compressionType, Long compressedFileSize, Double compressionGainRatio,
		//		Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//		Long encryptedFileSize, Long encrytedByteHashId,byte[] fileBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//		Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileBlob ent : fileSet.getListFileBlob())	{
			    int cnt=1;
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPartNumber()!=null) {ps.setLong(cnt++, ent.getPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntPart()!=null) {ps.setLong(cnt++, ent.getCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getCompressionType());
			    if (ent.getCompressedFileSize()!=null) {ps.setLong(cnt++, ent.getCompressedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainRatio()!=null) {ps.setDouble(cnt++, ent.getCompressionGainRatio());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainBytes()!=null) {ps.setLong(cnt++, ent.getCompressionGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressedByteHashId()!=null) {ps.setLong(cnt++, ent.getCompressedByteHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getSandByteLengthHead()!=null) {ps.setLong(cnt++, ent.getSandByteLengthHead()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSandByteLengthTail()!=null) {ps.setLong(cnt++, ent.getSandByteLengthTail()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEncryptionBlobKey());
			    ps.setString(cnt++, ent.getEncryptionType());
			    if (ent.getEncryptedFileSize()!=null) {ps.setLong(cnt++, ent.getEncryptedFileSize()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEncrytedByteHashId()!=null) {ps.setLong(cnt++, ent.getEncrytedByteHashId()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getFileBytes()!=null) 		{ps.setBytes(cnt++, ent.getFileBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCompressedBytes()!=null) {ps.setBytes(cnt++, ent.getCompressedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getEncryptedBytes()!=null) 	{ps.setBytes(cnt++, ent.getEncryptedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    
			    //compressedBytes,encyptedBytes
			    
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileSystem(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILESYSTEM(fileSystemId, fileSetId, hostId, rootFileId, displayOrder, systemName, providerName, providerHashCode, "+
						"isOpen, isReadOnly, creationDate, modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileSystem(Long fileSystemId, Long fileSetId, Long hostId, Long rootFileId, Long displayOrder,
		//String systemName, String providerName, Long providerHashCode, String isOpen, String isReadOnly,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileSystem ent : fileSet.getListFileSystem())	{
			    int cnt=1;
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getHostId()!=null) {ps.setLong(cnt++, ent.getHostId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getSystemName());
			    ps.setString(cnt++, ent.getProviderName());
			    if (ent.getProviderHashCode()!=null) {ps.setLong(cnt++, ent.getProviderHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getIsOpen());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileSystem: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}	
	public static int writeTableFileStore(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILESTORE (fileStoreId,fileSetId,fileSystemId,rootFileId,displayOrder,blockSize,totalSpace,unallocatedSpace,usableSpace,usedSpace,hashCode, "+
						"rootDirectoryName,isReadOnly,nameStr,toString,typeStr,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?)";
		//public NodeFileStore(Long fileStoreId, Long fileSetId, Long fileSystemId, Long rootFileId, Long displayOrder, Long blockSize,
		//Long totalSpace, Long unallocatedSpace, Long usableSpace, Long usedSpace, Long hashCode,
		//String rootDirectoryName, String isReadOnly, String nameStr, String toString, String typeStr,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileStore ent : fileSet.getListFileStore())	{
			    int cnt=1;
			    if (ent.getFileStoreId()!=null) {ps.setLong(cnt++, ent.getFileStoreId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDisplayOrder()!=null) {ps.setLong(cnt++, ent.getDisplayOrder());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlockSize()!=null) {ps.setLong(cnt++, ent.getBlockSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTotalSpace()!=null) {ps.setLong(cnt++, ent.getTotalSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUnallocatedSpace()!=null) {ps.setLong(cnt++, ent.getUnallocatedSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUsableSpace()!=null) {ps.setLong(cnt++, ent.getUsableSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUsedSpace()!=null) {ps.setLong(cnt++, ent.getUsedSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashCode()!=null) {ps.setLong(cnt++, ent.getHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getRootDirectoryName());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    ps.setString(cnt++, ent.getNameStr());
			    ps.setString(cnt++, ent.getToString());
			    ps.setString(cnt++, ent.getTypeStr());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFileStore: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFile(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILE (fileId,fileSetId,fileSystemId,fileStoreId,parentFileId,rootFileId,fileTypeId,sourceId,languageId,languageId2,fileSize,hashCode,hashId, "+
				"fileType,linkType,linkedId,fileStatus,depth,depthFromRoot,fileName,fileNameRelative,fileNameAbsolute,fileNameCanonical,"+
				"dirNameRelative,dirNameAbsolute,altName1,altName2,altName3,encryptedNameRelative,encryptedNameAbsolute,nameHashId,fileURI,fileURL,extensionName,nameWithoutExtension, "+
				"fileNameAbsoluteLength,ownerName,canExecute,canRead,canWrite,isExists,isDirectory,isFile,isSymbolicLink,isHidden,isReadOnly,isArchive,isSystem,isOther,  "+
				"isRegularFile,probeContentType,freeSpace,totalSpace,usableSpace,compressedFileSize,compressionGainRatio,"+
				"compressionGainBytes,encoding,charsetStr,lastModified,fileCreationDate,fileModificationDate,fileRemark,creationDate,modificationDate) "+
				"VALUES( ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,"+
				        "?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?)";
		//public NodeFile(Long fileId, Long fileSetId, Long fileSystemId, Long fileStoreId, Long parentFileId, Long rootFileId, Long fileTypeId,
				//Long sourceId, Long languageId, Long languageId2, Long fileSize, Long hashCode, Long hashId,
				//String fileType, String linkType, Long linkedId, String fileStatus, Long depth, Long depthFromRoot, String fileName, String fileNameRelative, String fileNameAbsolute,
				//String fileNameCanonical, String dirNameRelative, String dirNameAbsolute, String altName1,String altName2,String altName3,
				//String encryptedNameRelative, String encryptedNameAbsolute, Long nameHashId, 
				//String fileURI, String fileURL, String extensionName, String nameWithoutExtension,
				//Long fileNameAbsoluteLength, String ownerName, String canExecute, String canRead, String canWrite,
				//String isExists, String isDirectory, String isFile, String isSymbolicLink, String isHidden, String isReadOnly, String isArhive, String isSystem, String isOther,
				//String isRegularFile, String probeContentType, Long freeSpace, Long totalSpace, Long usableSpace, Long compressedFileSize, Double compressionGainRatio,
				//Long compressionGainBytes,String encoding, String charsetStr,Long lastModified, ZonedDateTime fileCreationDate, ZonedDateTime fileModificationDate,
				//ZonedDateTime fileLastAccessTime, String fileRemark, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFile ent : fileSet.getListFile())	{
			    int cnt=1;
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getFileSystemId()!=null) {ps.setLong(cnt++, ent.getFileSystemId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileStoreId()!=null) {ps.setLong(cnt++, ent.getFileStoreId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getParentFileId()!=null) {ps.setLong(cnt++, ent.getParentFileId());} else {ps.setNull(cnt++,Types.INTEGER);} 
			    if (ent.getRootFileId()!=null) {ps.setLong(cnt++, ent.getRootFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileTypeId()!=null) {ps.setLong(cnt++, ent.getFileTypeId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId()!=null) {ps.setLong(cnt++, ent.getLanguageId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getLanguageId2()!=null) {ps.setLong(cnt++, ent.getLanguageId2());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashCode()!=null) {ps.setLong(cnt++, ent.getHashCode());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileType());
			    ps.setString(cnt++, ent.getLinkType());
			    if (ent.getLinkedId()!=null) {ps.setLong(cnt++, ent.getLinkedId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileStatus());
			    if (ent.getDepth()!=null) {ps.setLong(cnt++, ent.getDepth());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getDepthFromRoot()!=null) {ps.setLong(cnt++, ent.getDepthFromRoot());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileName());
			    ps.setString(cnt++, ent.getFileNameRelative());
			    ps.setString(cnt++, ent.getFileNameAbsolute());
			    ps.setString(cnt++, ent.getFileNameCanonical());
			    ps.setString(cnt++, ent.getDirNameRelative());
			    ps.setString(cnt++, ent.getDirNameAbsolute());
			    ps.setString(cnt++, ent.getAltName1());
			    ps.setString(cnt++, ent.getAltName2());
			    ps.setString(cnt++, ent.getAltName3());
			    ps.setString(cnt++, ent.getEncryptedNameRelative());
			    ps.setString(cnt++, ent.getEncryptedNameAbsolute());
			    if (ent.getNameHashId()!=null) {ps.setLong(cnt++, ent.getNameHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getFileURI());
			    ps.setString(cnt++, ent.getFileURL());
			    ps.setString(cnt++, ent.getExtensionName());
			    ps.setString(cnt++, ent.getNameWithoutExtension());
			    if (ent.getFileNameAbsoluteLength()!=null) {ps.setLong(cnt++, ent.getFileNameAbsoluteLength());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getOwnerName());
			    ps.setString(cnt++, ent.getCanExecute());
			    ps.setString(cnt++, ent.getCanRead());
			    ps.setString(cnt++, ent.getCanWrite());
			    ps.setString(cnt++, ent.getIsExists());
			    ps.setString(cnt++, ent.getIsDirectory());
			    ps.setString(cnt++, ent.getIsFile());
			    ps.setString(cnt++, ent.getIsSymbolicLink());
			    ps.setString(cnt++, ent.getIsHidden());
			    ps.setString(cnt++, ent.getIsOther());
			    ps.setString(cnt++, ent.getIsReadOnly());
			    ps.setString(cnt++, ent.getIsArchive());
			    ps.setString(cnt++, ent.getIsSystem());
			    ps.setString(cnt++, ent.getIsRegularFile());
			    ps.setString(cnt++, ent.getProbeContentType());
			    if (ent.getFreeSpace()!=null) {ps.setLong(cnt++, ent.getFreeSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getTotalSpace()!=null) {ps.setLong(cnt++, ent.getTotalSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getUsableSpace()!=null) {ps.setLong(cnt++, ent.getUsableSpace());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressedFileSize()!=null) {ps.setLong(cnt++, ent.getCompressedFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainRatio()!=null) {ps.setDouble(cnt++, ent.getCompressionGainRatio());} else {ps.setNull(cnt++,Types.DOUBLE);}
			    if (ent.getCompressionGainBytes()!=null) {ps.setLong(cnt++, ent.getCompressionGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEncoding());
			    ps.setString(cnt++, ent.getCharsetStr());
			    if (ent.getLastModified()!=null) {ps.setLong(cnt++, ent.getLastModified());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileCreationDate()!=null) {ps.setString(cnt++, ent.getFileCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getFileModificationDate()!=null) {ps.setString(cnt++, ent.getFileModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    ps.setString(cnt++, ent.getFileRemark());
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    System.out.println("writeTableFile: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}

	public static int writeTableFileSet(Connection conn,NodeFileSet fileSet)	{
		int cntInserted = 0;
		String query = "INSERT INTO FS_FILESET (fileSetId,sourceId,fileSetName,fileSetDesc,fileSetURL,ownerName,creationDate,modificationDate) VALUES ( ?, ?, ?, ?, ?,   ?, ?, ?)";
		//String fieldStr = "fileSetId INTEGER,sourceId INTEGER,fileSetName TEXT,fileSetDesc TEXT,fileSetURL TEXT,ownerName TEXT, creationDate TEXT, modificationDate TEXT";
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    int cnt=1;
		    if (fileSet.getFileSetId()!=null) {ps.setLong(cnt++, fileSet.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    if (fileSet.getSourceId()!=null) {ps.setLong(cnt++, fileSet.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);} 
		    ps.setString(cnt++, fileSet.getFileSetName());
		    ps.setString(cnt++, fileSet.getFileSetDesc());
		    ps.setString(cnt++, fileSet.getFileSetURL());
		    ps.setString(cnt++, fileSet.getOwnerName());
		    if (fileSet.getCreationDate()!=null) 	{ps.setString(cnt++, fileSet.getCreationDate().toString()); } 		else {ps.setNull(cnt++,Types.VARCHAR);}
		    if (fileSet.getModificationDate()!=null) {ps.setString(cnt++, fileSet.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
		    cntInserted += ps.executeUpdate();
		    System.out.println("writeTableFileSet: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeFileSet(Connection conn,  NodeFileSet fileSet)	{
		int ctInsertedCorpus = writeTableFileSet(conn,fileSet);
		int ctInsertedFile = writeTableFile(conn,fileSet);
		int ctInsertedFileSystem = writeTableFileSystem(conn,fileSet);
		int ctInsertedFileStore = writeTableFileStore(conn,fileSet);
		int ctInsertedFileBlob = writeTableFileBlob(conn,fileSet); 
		int ctInsertedFileBlobSmall = writeTableFileBlobSmall(conn,fileSet); 
		int ctInsertedProperty = writeTableProperty(conn,fileSet); 
		int ctInsertedSimilarity = writeTableSimilarity(conn,fileSet); 
		int ctInsertedHash = writeTableHash(conn,fileSet);
		int ctInsertedArchive = writeTableArchive(conn,fileSet);
		int ctInsertedContainer = writeTableContainer(conn,fileSet);
		int ctInsertedTransform = writeTableTransform(conn,fileSet);
	/*		
		int ctInsertedFileGroup = writeTableFileGroup(conn,corpus);
		int ctInsertedFileType = writeTableFileType(conn,corpus);
		int ctInsertedLine = writeTableLine(conn,corpus);
		
		int ctInsertedStat = writeTableStat(conn, corpus);
		int ctInsertedToken = writeTableToken(conn, corpus);
		int ctInsertedTokenType = writeTableTokenType(conn, corpus);
		int ctInsertedDistance = writeTableDistance(conn, corpus);
	*/	
		int cntInserted = ctInsertedCorpus + ctInsertedFile + ctInsertedFileSystem + ctInsertedFileStore + ctInsertedFileBlob + ctInsertedFileBlobSmall + 
				ctInsertedProperty + ctInsertedSimilarity + ctInsertedHash + ctInsertedArchive + ctInsertedContainer + ctInsertedTransform; //+ ctInsertedToken + 
		return(cntInserted);
	}	
	public static int writeSimilarity(Connection conn,  NodeFileSet fileSet)	{
		int ctInsertedSimilarity = writeTableSimilarity(conn,fileSet); 
		int cntInserted = ctInsertedSimilarity;
		return(cntInserted);
	}	
	public static void writeFileSetTables(Connection conn, NodeFileSet fileSet)	{
		writeFileSet(conn,fileSet);
	}
	
}