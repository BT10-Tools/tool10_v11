package tool10.tagset;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;

public class NodeTika10 {

	public NodeTika10(TikaConfig tikaConfig, MimeTypes defaultMimeTypes, ParseContext parseContext, 
			Parser autoDetectParser) {
		super();
		this.tikaConfig = tikaConfig;
		this.defaultMimeTypes = defaultMimeTypes;
		this.parseContext = parseContext;
		this.autoDetectParser = autoDetectParser;
	}

	//the constructs required by tika like config, parameters etc. 
	private TikaConfig tikaConfig;
	private MimeTypes defaultMimeTypes; // MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
	private ParseContext parseContext; // ParseContext context = new ParseContext();
	private Parser autoDetectParser; //Parser parser = new AutoDetectParser();
	
	//GETTERS AND SETTERS
	public TikaConfig getTikaConfig() {
		return tikaConfig;
	}
	public MimeTypes getDefaultMimeTypes() {
		return defaultMimeTypes;
	}
	public ParseContext getParseContext() {
		return parseContext;
	}
	public Parser getAutoDetectParser() {
		return autoDetectParser;
	}
	
}
