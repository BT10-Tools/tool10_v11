package tool10.preview.api;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import tool10.f10.CliRun;
import tool10.f10.NodeF10;
import tool10.f10.RunF10;
import tool10.f10.Tool10;

public class ApiF10 {

	private static final Logger logger =  LogManager.getLogger(Tool10.class);

	public ApiF10() {
		super();
		BasicConfigurator.configure();
		this.f10 = new NodeF10();
		this.args0 = null;
	}
	private NodeF10 f10; 
	private String[] args0;
	
	public ApiF10 start()	{
	    this.f10.startAll(logger);
	    return(this);
	}
	public ApiF10 end()	{
		f10.endAll(logger);
		return(this);
	}
	public String getString()	{
		return(f10.getString());
	}
	public void printString()	{
		this.f10.printString();
	}
	public void printArgs0()	{
		System.out.println(args0);
	}
	public ApiF10 getArgsCLI(String cliArgsParam)	{ 
		//read must be selected, if it is null hardcoded args will ve returned
		this.args0 = CliRun.getArgs0(cliArgsParam); //"read");
		return(this);
	}
	public ApiF10 getArgs(String[] args)	{ 
		//read must be selected, if it is null hardcoded args will ve returned
		this.args0 = args; 
		if ((args==null) || (args.length==0)) {
			System.out.println("ApiF10 args0 is null or empty");
			return(null);
		}
		return(this);
	}
	public ApiF10 run()	{
		if  ((f10==null) || (args0==null) || (args0.length==0)) {
			System.out.println("ApiF10 f10 is null or args0 is null/empty");
			return(null);
		}
		RunF10.runF10(this.f10,this.args0);
		return(this);
	}

	
	//GETTERS AND SETTERS
	public NodeF10 getF10() {
		return f10;
	}
	public void setF10(NodeF10 f10) {
		this.f10 = f10;
	}
	public String[] getArgs0() {
		return args0;
	}
	
}
