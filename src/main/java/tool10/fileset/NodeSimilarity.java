package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeSimilarity implements Serializable {
	
	public NodeSimilarity(Long similarityId, Long fileSetId, Long entityId1, Long entityId2, String similarityType, String similarityKey,
			Double sim00, Double sim01, Double sim02, Double sim03, Double sim04, Double sim05, Double sim06,
			Double sim07, Double sim08, Double sim09, Double sim10, Double sim11, Double sim12, Double sim13,
			Double sim14, Double sim15, Double sim16, Double sim17, Double sim18, Double sim19, String alg00,
			String alg01, String alg02, String alg03, String alg04, String alg05, String alg06, String alg07,
			String alg08, String alg09, String alg10, String alg11, String alg12, String alg13, String alg14,
			String alg15, String alg16, String alg17, String alg18, String alg19, ZonedDateTime creationDate,
			ZonedDateTime modificationDate) {
		super();
		this.similarityId = similarityId;
		this.fileSetId = fileSetId;
		this.entityId1 = entityId1;
		this.entityId2 = entityId2;
		this.similarityType = similarityType;
		this.similarityKey = similarityKey;
		this.sim00 = sim00;
		this.sim01 = sim01;
		this.sim02 = sim02;
		this.sim03 = sim03;
		this.sim04 = sim04;
		this.sim05 = sim05;
		this.sim06 = sim06;
		this.sim07 = sim07;
		this.sim08 = sim08;
		this.sim09 = sim09;
		this.sim10 = sim10;
		this.sim11 = sim11;
		this.sim12 = sim12;
		this.sim13 = sim13;
		this.sim14 = sim14;
		this.sim15 = sim15;
		this.sim16 = sim16;
		this.sim17 = sim17;
		this.sim18 = sim18;
		this.sim19 = sim19;
		this.alg00 = alg00;
		this.alg01 = alg01;
		this.alg02 = alg02;
		this.alg03 = alg03;
		this.alg04 = alg04;
		this.alg05 = alg05;
		this.alg06 = alg06;
		this.alg07 = alg07;
		this.alg08 = alg08;
		this.alg09 = alg09;
		this.alg10 = alg10;
		this.alg11 = alg11;
		this.alg12 = alg12;
		this.alg13 = alg13;
		this.alg14 = alg14;
		this.alg15 = alg15;
		this.alg16 = alg16;
		this.alg17 = alg17;
		this.alg18 = alg18;
		this.alg19 = alg19;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long similarityId;
	private Long fileSetId;
	private Long entityId1;
	private Long entityId2;
	private String similarityType;
	private String similarityKey;	
	private Double sim00;
	private Double sim01;
	private Double sim02;
	private Double sim03;
	private Double sim04;
	private Double sim05;
	private Double sim06;
	private Double sim07;
	private Double sim08;
	private Double sim09;
	private Double sim10;
	private Double sim11;
	private Double sim12;
	private Double sim13;
	private Double sim14;
	private Double sim15;
	private Double sim16;
	private Double sim17;
	private Double sim18;
	private Double sim19;
	
	private String alg00;
	private String alg01;
	private String alg02;
	private String alg03;
	private String alg04;
	private String alg05;
	private String alg06;
	private String alg07;
	private String alg08;
	private String alg09;
	private String alg10;
	private String alg11;
	private String alg12;
	private String alg13;
	private String alg14;
	private String alg15;
	private String alg16;
	private String alg17;
	private String alg18;
	private String alg19;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	public Double getSimValue(int i)	{
		if (i==0) { return(sim00);}
		else if (i==1) { return(sim01);}
		else if (i==2) { return(sim02);}
		else if (i==3) { return(sim03);}
		else if (i==4) { return(sim04);}
		else if (i==5) { return(sim05);}
		else if (i==6) { return(sim06);}
		else if (i==7) { return(sim07);}
		else if (i==8) { return(sim08);}
		else if (i==9) { return(sim09);}
		else if (i==10) { return(sim10);}
		else if (i==11) { return(sim11);}
		else if (i==12) { return(sim12);}
		else if (i==13) { return(sim13);}
		else if (i==14) { return(sim14);}
		else if (i==15) { return(sim15);}
		else if (i==16) { return(sim16);}
		else if (i==17) { return(sim17);}
		else if (i==18) { return(sim18);}
		else if (i==19) { return(sim19);}
		return(null);
	}
	public String getAlgValue(int i)	{
		if (i==0) { return(alg00);}
		else if (i==1) { return(alg01);}
		else if (i==2) { return(alg02);}
		else if (i==3) { return(alg03);}
		else if (i==4) { return(alg04);}
		else if (i==5) { return(alg05);}
		else if (i==6) { return(alg06);}
		else if (i==7) { return(alg07);}
		else if (i==8) { return(alg08);}
		else if (i==9) { return(alg09);}
		else if (i==10) { return(alg10);}
		else if (i==11) { return(alg11);}
		else if (i==12) { return(alg12);}
		else if (i==13) { return(alg13);}
		else if (i==14) { return(alg14);}
		else if (i==15) { return(alg15);}
		else if (i==16) { return(alg16);}
		else if (i==17) { return(alg17);}
		else if (i==18) { return(alg18);}
		else if (i==19) { return(alg19);}
		return(null);
	}
	public void setSimValue(int i, Double dd)	{
		if (i==0) { sim00 = dd;}
		else if (i==1) { sim01 = dd;}
		else if (i==2) { sim02 = dd;}
		else if (i==3) { sim03 = dd;}
		else if (i==4) { sim04 = dd;}
		else if (i==5) { sim05 = dd;}
		else if (i==6) { sim06 = dd;}
		else if (i==7) { sim07 = dd;}
		else if (i==8) { sim08 = dd;}
		else if (i==9) { sim09 = dd;}
		else if (i==10) { sim10 = dd;}
		else if (i==11) { sim11 = dd;}
		else if (i==12) { sim12 = dd;}
		else if (i==13) { sim13 = dd;}
		else if (i==14) { sim14 = dd;}
		else if (i==15) { sim15 = dd;}
		else if (i==16) { sim16 = dd;}
		else if (i==17) { sim17 = dd;}
		else if (i==18) { sim18 = dd;}
		else if (i==19) { sim19 = dd;}
	}
	public void setAlgValue(int i, String ss)	{
		if (i==0) { alg00 = ss;}
		else if (i==1) { alg01 = ss;}
		else if (i==2) { alg02 = ss;}
		else if (i==3) { alg03 = ss;}
		else if (i==4) { alg04 = ss;}
		else if (i==5) { alg05 = ss;}
		else if (i==6) { alg06 = ss;}
		else if (i==7) { alg07 = ss;}
		else if (i==8) { alg08 = ss;}
		else if (i==9) { alg09 = ss;}
		else if (i==10) { alg10 = ss;}
		else if (i==11) { alg11 = ss;}
		else if (i==12) { alg12 = ss;}
		else if (i==13) { alg13 = ss;}
		else if (i==14) { alg14 = ss;}
		else if (i==15) { alg15 = ss;}
		else if (i==16) { alg16 = ss;}
		else if (i==17) { alg17 = ss;}
		else if (i==18) { alg18 = ss;}
		else if (i==19) { alg19 = ss;}
	}
	//GETTERS AND SETTERS	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getSimilarityId() {
		return similarityId;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
	public Long getEntityId1() {
		return entityId1;
	}
	public Long getEntityId2() {
		return entityId2;
	}
	public String getSimilarityType() {
		return similarityType;
	}
	public Double getSim00() {
		return sim00;
	}
	public Double getSim01() {
		return sim01;
	}
	public Double getSim02() {
		return sim02;
	}
	public Double getSim03() {
		return sim03;
	}
	public Double getSim04() {
		return sim04;
	}
	public Double getSim05() {
		return sim05;
	}
	public Double getSim06() {
		return sim06;
	}
	public Double getSim07() {
		return sim07;
	}
	public Double getSim08() {
		return sim08;
	}
	public Double getSim09() {
		return sim09;
	}
	public Double getSim10() {
		return sim10;
	}
	public Double getSim11() {
		return sim11;
	}
	public Double getSim12() {
		return sim12;
	}
	public Double getSim13() {
		return sim13;
	}
	public Double getSim14() {
		return sim14;
	}
	public Double getSim15() {
		return sim15;
	}
	public Double getSim16() {
		return sim16;
	}
	public Double getSim17() {
		return sim17;
	}
	public Double getSim18() {
		return sim18;
	}
	public Double getSim19() {
		return sim19;
	}
	public String getAlg00() {
		return alg00;
	}
	public String getAlg01() {
		return alg01;
	}
	public String getAlg02() {
		return alg02;
	}
	public String getAlg03() {
		return alg03;
	}
	public String getAlg04() {
		return alg04;
	}
	public String getAlg05() {
		return alg05;
	}
	public String getAlg06() {
		return alg06;
	}
	public String getAlg07() {
		return alg07;
	}
	public String getAlg08() {
		return alg08;
	}
	public String getAlg09() {
		return alg09;
	}
	public String getAlg10() {
		return alg10;
	}
	public String getAlg11() {
		return alg11;
	}
	public String getAlg12() {
		return alg12;
	}
	public String getAlg13() {
		return alg13;
	}
	public String getAlg14() {
		return alg14;
	}
	public String getAlg15() {
		return alg15;
	}
	public String getAlg16() {
		return alg16;
	}
	public String getAlg17() {
		return alg17;
	}
	public String getAlg18() {
		return alg18;
	}
	public String getAlg19() {
		return alg19;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public String getSimilarityKey() {
		return similarityKey;
	}
	public void setSimilarityKey(String similarityKey) {
		this.similarityKey = similarityKey;
	}
	
		
	
}
