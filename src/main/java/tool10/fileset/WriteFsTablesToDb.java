package tool10.fileset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import tool10.blobset.NodeBlob;
import tool10.fileset.nodes.NodeFile;
import tool10.fileset.nodes.NodeFileBlob;
import tool10.fileset.nodes.NodeFileBlobSmall;
import tool10.fileset.nodes.NodeFileSet;
import tool10.fileset.nodes.NodeFileStore;
import tool10.fileset.nodes.NodeFileSystem;
import tool10.fileset.nodes.NodeHash;
import tool10.fileset.nodes.NodeProperty;
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
		    //System.out.println("writeTableProperty: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileBlobSmallXXX(Connection conn, ArrayList<NodeFileBlobSmall> listFileBlobSmall)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEBLOBSMALL (fileBlobSmallId,fileBlobId,fileId,fileSetId,byteIndexStart,byteIndexEnd,hashId,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?)";
		//public NodeFileBlobSmall(Long fileBlobSmallId, Long fileBlobId, Long fileId, Long fileSetId, Long byteIndexStart,
		//Long byteIndexEnd, Long hashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileBlobSmall ent : listFileBlobSmall)	{
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
		    //System.out.println("writeTableFileBlobSmall: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableFileBlob(Connection conn, ArrayList<NodeFileBlob> listFileBlob)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_FILEBLOB (fileBlobId,fileId,blobId,fileSetId, blobType, blobSize, \r\n"+
						"fileSize, hashId, blobDbName, blobDbAttachmentName, blobTableName, \r\n" +
				 		"bigPartNumber, bigCntPart, smallByteIndexStart, smallByteIndexEnd, \r\n"+
				 		"creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?)";
		//public NodeFileBlob(Long fileBlobId, Long fileId, Long blobId, Long fileSetId, String blobType, Long blobSize,
		//Long fileSize, Long hashId, String blobDbName, String blobDbAttachmentName, String blobTableName,
		//Long bigPartNumber, Long bigCntPart, Long smallByteIndexStart, Long smallByteIndexEnd,
		//ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeFileBlob ent : listFileBlob)	{
			    int cnt=1;
			    if (ent.getFileBlobId()!=null) {ps.setLong(cnt++, ent.getFileBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileId()!=null) {ps.setLong(cnt++, ent.getFileId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBlobId()!=null) {ps.setLong(cnt++, ent.getBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSize()!=null) {ps.setLong(cnt++, ent.getFileSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getHashId()!=null) {ps.setLong(cnt++, ent.getHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobDbName());
			    ps.setString(cnt++, ent.getBlobDbAttachmentName());
			    ps.setString(cnt++, ent.getBlobTableName());
			    
			    if (ent.getBigPartNumber()!=null) {ps.setLong(cnt++, ent.getBigPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getBigCntPart()!=null) {ps.setDouble(cnt++, ent.getBigCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexStart()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexStart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSmallByteIndexEnd()!=null) {ps.setLong(cnt++, ent.getSmallByteIndexEnd());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableFileBlob: cntInserted = " + cntInserted);
		    ps.close();
		} catch(SQLException e)	{
		      e.printStackTrace(System.err);
		}
		return(cntInserted);
	}
	public static int writeTableBlob(Connection conn, String blobTableName, String blobDbAttachmentName, ArrayList<NodeBlob> listBlob)	{
		int cntInserted = 0;
		String query =  "INSERT INTO FS_BLOB (blobId,sourceId,fileSetId,firstPartBlobId,partNumber,cntPart,blobType,"+
						"blobSize,compressionType,compressedSize,compressionGainRatio,\r\n"+
						"compressionGainBytes,compressedByteHashId,sandByteLengthHead,sandByteLengthTail,encryptionBlobKey,encryptionType, "+
						"encryptedSize,encrytedByteHashId,blobBytes,compressedBytes,encryptedBytes, \r\n"+
				 		"blobHashId,creationDate,modificationDate) "+
						"VALUES( ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,   ?, ?, ?, ?, ?,    ?, ?, ?, ?, ?)";
		//public NodeBlob(Long blobId, Long sourceId, Long fileSetId, Long firstPartBlobId, Long partNumber, Long cntPart, String blobType,
		//Long blobSize, String compressionType, Long compressedSize, Double compressionGainRatio,
		//Long compressionGainBytes, Long compressedByteHashId, Long sandByteLengthHead, Long sandByteLengthTail,String encryptionBlobKey, String encryptionType, 
		//Long encryptedSize, Long encrytedByteHashId,byte[] blobBytes, byte[] compressedBytes, byte[] encryptedBytes, 
		//Long blobHashId, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		try	{  
		    PreparedStatement ps = conn.prepareStatement(query);
		    for (NodeBlob ent : listBlob)	{
			    int cnt=1;
			    if (ent.getBlobId()!=null) {ps.setLong(cnt++, ent.getBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSourceId()!=null) {ps.setLong(cnt++, ent.getSourceId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFileSetId()!=null) {ps.setLong(cnt++, ent.getFileSetId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getFirstPartBlobId()!=null) {ps.setLong(cnt++, ent.getFirstPartBlobId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getPartNumber()!=null) {ps.setLong(cnt++, ent.getPartNumber());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCntPart()!=null) {ps.setLong(cnt++, ent.getCntPart());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getBlobType());
			    if (ent.getBlobSize()!=null) {ps.setLong(cnt++, ent.getBlobSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getCompressionType());
			    if (ent.getCompressedSize()!=null) {ps.setLong(cnt++, ent.getCompressedSize());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainRatio()!=null) {ps.setDouble(cnt++, ent.getCompressionGainRatio());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressionGainBytes()!=null) {ps.setLong(cnt++, ent.getCompressionGainBytes());} else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getCompressedByteHashId()!=null) {ps.setLong(cnt++, ent.getCompressedByteHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getSandByteLengthHead()!=null) {ps.setLong(cnt++, ent.getSandByteLengthHead()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getSandByteLengthTail()!=null) {ps.setLong(cnt++, ent.getSandByteLengthTail()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    ps.setString(cnt++, ent.getEncryptionBlobKey());
			    ps.setString(cnt++, ent.getEncryptionType());
			    if (ent.getEncryptedSize()!=null) {ps.setLong(cnt++, ent.getEncryptedSize()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    if (ent.getEncrytedByteHashId()!=null) {ps.setLong(cnt++, ent.getEncrytedByteHashId()); } 	else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getBlobBytes()!=null) 		{ps.setBytes(cnt++, ent.getBlobBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getCompressedBytes()!=null) {ps.setBytes(cnt++, ent.getCompressedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    if (ent.getEncryptedBytes()!=null) 	{ps.setBytes(cnt++, ent.getEncryptedBytes());} else {ps.setNull(cnt++,Types.BLOB);}
			    
			    //compressedBytes,encyptedBytes
			    
			    if (ent.getBlobHashId()!=null) {ps.setLong(cnt++, ent.getBlobHashId());} else {ps.setNull(cnt++,Types.INTEGER);}
			    
			    if (ent.getCreationDate()!=null) {ps.setString(cnt++, ent.getCreationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    if (ent.getModificationDate()!=null) {ps.setString(cnt++, ent.getModificationDate().toString()); } 	else {ps.setNull(cnt++,Types.VARCHAR);}
			    cntInserted += ps.executeUpdate();
		    }
		    //System.out.println("writeTableBlob: cntInserted = " + cntInserted);
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
		int cntInsertedCorpus = writeTableFileSet(conn,fileSet);
		int cntInsertedFile = writeTableFile(conn,fileSet);
		int cntInsertedFileSystem = writeTableFileSystem(conn,fileSet);
		int cntInsertedFileStore = writeTableFileStore(conn,fileSet);
		int cntInsertedFileBlob = writeTableFileBlob(conn,fileSet.getListFileBlob()); 
		int cntInsertedBlob = writeTableBlob(conn,"","",fileSet.getListBlob()); 
		int cntInsertedProperty = writeTableProperty(conn,fileSet); 
		int cntInsertedHash = writeTableHash(conn,fileSet);
		int cntInsertedArchive = writeTableArchive(conn,fileSet);
		int cntInsertedContainer = writeTableContainer(conn,fileSet);
		int cntInsertedTransform = writeTableTransform(conn,fileSet);
	/*		
		int ctInsertedFileGroup = writeTableFileGroup(conn,corpus);
		int ctInsertedFileType = writeTableFileType(conn,corpus);
		int ctInsertedLine = writeTableLine(conn,corpus);
		
		int ctInsertedStat = writeTableStat(conn, corpus);
		int ctInsertedToken = writeTableToken(conn, corpus);
		int ctInsertedTokenType = writeTableTokenType(conn, corpus);
		int ctInsertedDistance = writeTableDistance(conn, corpus);
	*/	
		int cntInserted = cntInsertedCorpus + cntInsertedFile + cntInsertedFileSystem + cntInsertedFileStore + cntInsertedFileBlob + cntInsertedBlob + 
				cntInsertedProperty + cntInsertedHash + cntInsertedArchive + cntInsertedContainer + cntInsertedTransform; //+ ctInsertedToken + 
		return(cntInserted);
	}	
	public static int writeBlob(Connection conn,  NodeFileSet fileSet)	{
		int ctInsertedFileBlob = writeTableFileBlob(conn,fileSet.getListFileBlob()); 
		int ctInsertedBlob = writeTableBlob(conn,"","",fileSet.getListBlob()); 
		int cntInserted = ctInsertedFileBlob + ctInsertedBlob ;
		return(cntInserted);
	}
	public static void writeFileSetTables(Connection conn, NodeFileSet fileSet)	{
		writeFileSet(conn,fileSet);
	}
	
}