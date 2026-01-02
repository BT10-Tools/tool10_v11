package tool10.bookset;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeBookSet implements Serializable {

	public NodeBookSet(Long bookSetId, Long fileSetId, String bookSetName, String bookSetDesc, String sourceDesc,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.bookSetId = bookSetId;
		this.fileSetId = fileSetId;
		this.bookSetName = bookSetName;
		this.bookSetDesc = bookSetDesc;
		this.sourceDesc = sourceDesc;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		initializeListsAndMaps();
	}
	private void initializeListsAndMaps()	{ 
		this.listBookFile = new ArrayList<NodeBookFile>();
		this.listBookImage = new ArrayList<NodeBookImage>();
		this.listBookBlob = new ArrayList<NodeBookBlob>();
		this.listLanguage = new ArrayList<NodeLanguage>();
		this.listBook = new ArrayList<NodeBook>();
		this.listChapter = new ArrayList<NodeChapter>();
		this.listSection = new ArrayList<NodeSection>();
		this.listParagraph = new ArrayList<NodeParagraph>();
		this.listSentence = new ArrayList<NodeSentence>();
		this.listToken = new ArrayList<NodeToken>();
		
		this.mapId2BookFile = new HashMap<Long, NodeBookFile>();
		this.mapId2BookImage = new HashMap<Long, NodeBookImage>();
		this.mapId2BookBlob = new HashMap<Long, NodeBookBlob>();
		this.mapId2Language = new HashMap<Long, NodeLanguage>();
		this.mapId2Book = new HashMap<Long, NodeBook>();
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
	private Long bookSetId;
	private Long fileSetId;
	private String bookSetName;
	private String bookSetDesc;
	private String sourceDesc;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	private ArrayList<NodeBookFile> listBookFile;
	private ArrayList<NodeBookImage> listBookImage;
	private ArrayList<NodeBookBlob> listBookBlob;
	private ArrayList<NodeLanguage> listLanguage;
	private ArrayList<NodeBook> listBook;
	private ArrayList<NodeChapter> listChapter;
	private ArrayList<NodeSection> listSection;
	private ArrayList<NodeParagraph> listParagraph;
	private ArrayList<NodeSentence> listSentence;
	private ArrayList<NodeToken> listToken;
	
	private HashMap<Long,NodeBookFile> mapId2BookFile;
	private HashMap<Long,NodeBookImage> mapId2BookImage;
	private HashMap<Long,NodeBookBlob> mapId2BookBlob;
	private HashMap<Long,NodeLanguage> mapId2Language;
	private HashMap<Long,NodeBook> mapId2Book;
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
		return bookSetId;
	}
	public void setLibraryId(Long libraryId) {
		this.bookSetId = libraryId;
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
	public ArrayList<NodeBook> getListBook() {
		return listBook;
	}
	public void setListBook(ArrayList<NodeBook> listBook) {
		this.listBook = listBook;
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
	public HashMap<Long, NodeBook> getMapId2Book() {
		return mapId2Book;
	}
	public void setMapId2Book(HashMap<Long, NodeBook> mapId2Book) {
		this.mapId2Book = mapId2Book;
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
	public Long getBookSetId() {
		return bookSetId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public String getBookSetName() {
		return bookSetName;
	}
	public String getBookSetDesc() {
		return bookSetDesc;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public ArrayList<NodeBookFile> getListBookFile() {
		return listBookFile;
	}
	public ArrayList<NodeBookBlob> getListBookBlob() {
		return listBookBlob;
	}
	public HashMap<Long, NodeBookFile> getMapId2BookFile() {
		return mapId2BookFile;
	}
	public HashMap<Long, NodeBookBlob> getMapId2BookBlob() {
		return mapId2BookBlob;
	}
	public ArrayList<NodeBookImage> getListBookImage() {
		return listBookImage;
	}
	public HashMap<Long, NodeBookImage> getMapId2BookImage() {
		return mapId2BookImage;
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
