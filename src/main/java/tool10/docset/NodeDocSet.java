package tool10.docset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeDocSet implements Serializable {

	public NodeDocSet(Long docSetId, Long fileSetId, String docSetName, String docSetDesc, String sourceDesc,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.docSetId = docSetId;
		this.fileSetId = fileSetId;
		this.docSetName = docSetName;
		this.docSetDesc = docSetDesc;
		this.sourceDesc = sourceDesc;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();
	}
	private void initializeListsAndMaps()	{ 
		this.listDocFile = new ArrayList<NodeDocFile>();
		this.listDocImage = new ArrayList<NodeDocImage>();
		this.listDocBlob = new ArrayList<NodeDocBlob>();
		this.listLanguage = new ArrayList<NodeLanguage>();
		this.listDoc = new ArrayList<NodeDoc>();
		this.listChapter = new ArrayList<NodeChapter>();
		this.listSection = new ArrayList<NodeSection>();
		this.listParagraph = new ArrayList<NodeParagraph>();
		this.listSentence = new ArrayList<NodeSentence>();
		this.listToken = new ArrayList<NodeToken>();
		
		this.mapId2DocFile = new HashMap<Long, NodeDocFile>();
		this.mapId2DocImage = new HashMap<Long, NodeDocImage>();
		this.mapId2DocBlob = new HashMap<Long, NodeDocBlob>();
		this.mapId2Language = new HashMap<Long, NodeLanguage>();
		this.mapId2Doc = new HashMap<Long, NodeDoc>();
		this.mapId2Chapter = new HashMap<Long, NodeChapter>();
		this.mapId2Section = new HashMap<Long, NodeSection>();
		this.mapId2Paragraph = new HashMap<Long, NodeParagraph>();
		this.mapId2Sentence = new HashMap<Long, NodeSentence>();
		this.mapId2Token = new HashMap<Long, NodeToken>();
		
		this.mapStr2Section = new HashMap<String,NodeSection>();
		this.mapStr2Paragraph = new HashMap<String,NodeParagraph>();
		this.mapStr2Sentence = new HashMap<String,NodeSentence>();
		this.mapStr2Token = new HashMap<String,NodeToken>();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long docSetId;
	private Long fileSetId;
	private String docSetName;
	private String docSetDesc;
	private String sourceDesc;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeDocFile> listDocFile;
	private ArrayList<NodeDocImage> listDocImage;
	private ArrayList<NodeDocBlob> listDocBlob;
	private ArrayList<NodeLanguage> listLanguage;
	private ArrayList<NodeDoc> listDoc;
	private ArrayList<NodeChapter> listChapter;
	private ArrayList<NodeSection> listSection;
	private ArrayList<NodeParagraph> listParagraph;
	private ArrayList<NodeSentence> listSentence;
	private ArrayList<NodeToken> listToken;
	
	private HashMap<Long,NodeDocFile> mapId2DocFile;
	private HashMap<Long,NodeDocImage> mapId2DocImage;
	private HashMap<Long,NodeDocBlob> mapId2DocBlob;
	private HashMap<Long,NodeLanguage> mapId2Language;
	private HashMap<Long,NodeDoc> mapId2Doc;
	private HashMap<Long,NodeChapter> mapId2Chapter;
	private HashMap<Long,NodeSection> mapId2Section;
	private HashMap<Long,NodeParagraph> mapId2Paragraph;
	private HashMap<Long,NodeSentence> mapId2Sentence;
	private HashMap<Long,NodeToken> mapId2Token;
	
	private HashMap<String,NodeSection> mapStr2Section;
	private HashMap<String,NodeParagraph> mapStr2Paragraph;
	private HashMap<String,NodeSentence> mapStr2Sentence;
	private HashMap<String,NodeToken> mapStr2Token;
	
	public Long getLibraryId() {
		return docSetId;
	}
	public void setLibraryId(Long libraryId) {
		this.docSetId = libraryId;
	}
	public String getSourceDesc() {
		return sourceDesc;
	}
	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ArrayList<NodeLanguage> getListLanguage() {
		return listLanguage;
	}
	public void setListLanguage(ArrayList<NodeLanguage> listLanguage) {
		this.listLanguage = listLanguage;
	}
	public ArrayList<NodeDoc> getListDoc() {
		return listDoc;
	}
	public void setListDoc(ArrayList<NodeDoc> listDoc) {
		this.listDoc = listDoc;
	}
	public ArrayList<NodeChapter> getListChapter() {
		return listChapter;
	}
	public void setListChapter(ArrayList<NodeChapter> listChapter) {
		this.listChapter = listChapter;
	}
	public ArrayList<NodeParagraph> getListParagraph() {
		return listParagraph;
	}
	public void setListParagraph(ArrayList<NodeParagraph> listParagraph) {
		this.listParagraph = listParagraph;
	}
	public ArrayList<NodeSentence> getListSentence() {
		return listSentence;
	}
	public void setListSentence(ArrayList<NodeSentence> listSentence) {
		this.listSentence = listSentence;
	}
	public ArrayList<NodeToken> getListToken() {
		return listToken;
	}
	public void setListToken(ArrayList<NodeToken> listToken) {
		this.listToken = listToken;
	}
	public HashMap<Long, NodeLanguage> getMapId2Language() {
		return mapId2Language;
	}
	public void setMapId2Language(HashMap<Long, NodeLanguage> mapId2Language) {
		this.mapId2Language = mapId2Language;
	}
	public HashMap<Long, NodeDoc> getMapId2Doc() {
		return mapId2Doc;
	}
	public void setMapId2Doc(HashMap<Long, NodeDoc> mapId2Doc) {
		this.mapId2Doc = mapId2Doc;
	}
	public HashMap<Long, NodeChapter> getMapId2Chapter() {
		return mapId2Chapter;
	}
	public void setMapId2Chapter(HashMap<Long, NodeChapter> mapId2Chapter) {
		this.mapId2Chapter = mapId2Chapter;
	}
	public HashMap<Long, NodeParagraph> getMapId2Paragraph() {
		return mapId2Paragraph;
	}
	public void setMapId2Paragraph(HashMap<Long, NodeParagraph> mapId2Paragraph) {
		this.mapId2Paragraph = mapId2Paragraph;
	}
	public HashMap<Long, NodeSentence> getMapId2Sentence() {
		return mapId2Sentence;
	}
	public void setMapId2Sentence(HashMap<Long, NodeSentence> mapId2Sentence) {
		this.mapId2Sentence = mapId2Sentence;
	}
	public HashMap<Long, NodeToken> getMapId2Token() {
		return mapId2Token;
	}
	public void setMapId2Token(HashMap<Long, NodeToken> mapId2Token) {
		this.mapId2Token = mapId2Token;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HashMap<String, NodeToken> getMapStr2Token() {
		return mapStr2Token;
	}
	public void setMapStr2Token(HashMap<String, NodeToken> mapStr2Token) {
		this.mapStr2Token = mapStr2Token;
	}
	public HashMap<String, NodeParagraph> getMapStr2Paragraph() {
		return mapStr2Paragraph;
	}
	public void setMapStr2Paragraph(HashMap<String, NodeParagraph> mapStr2Paragraph) {
		this.mapStr2Paragraph = mapStr2Paragraph;
	}
	public HashMap<String, NodeSentence> getMapStr2Sentence() {
		return mapStr2Sentence;
	}
	public void setMapStr2Sentence(HashMap<String, NodeSentence> mapStr2Sentence) {
		this.mapStr2Sentence = mapStr2Sentence;
	}
	public Long getDocSetId() {
		return docSetId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public String getDocSetName() {
		return docSetName;
	}
	public String getDocSetDesc() {
		return docSetDesc;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public ArrayList<NodeDocFile> getListDocFile() {
		return listDocFile;
	}
	public ArrayList<NodeDocBlob> getListDocBlob() {
		return listDocBlob;
	}
	public HashMap<Long, NodeDocFile> getMapId2DocFile() {
		return mapId2DocFile;
	}
	public HashMap<Long, NodeDocBlob> getMapId2DocBlob() {
		return mapId2DocBlob;
	}
	public ArrayList<NodeDocImage> getListDocImage() {
		return listDocImage;
	}
	public HashMap<Long, NodeDocImage> getMapId2DocImage() {
		return mapId2DocImage;
	}
	public ArrayList<NodeSection> getListSection() {
		return listSection;
	}
	public HashMap<Long, NodeSection> getMapId2Section() {
		return mapId2Section;
	}
	public HashMap<String, NodeSection> getMapStr2Section() {
		return mapStr2Section;
	}
	
	
}
