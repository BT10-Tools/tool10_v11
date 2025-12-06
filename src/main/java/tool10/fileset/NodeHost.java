package tool10.fileset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeHost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeHost(Long hostId, Long fileSetId, String hostName, String hostIP, String domainName,
			ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.hostId=hostId;
		this.fileSetId = fileSetId;
		this.hostName=hostName;
		this.hostIP=hostIP;
		this.domainName=domainName;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	private Long hostId;
	private Long fileSetId;
	private String hostName=null;
	private String hostIP=null;
	private String domainName=null;
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	//GETTERS AND SETTERS
	public long getHostId() {
		return hostId;
	}
	public void setHostId(long hostId) {
		this.hostId = hostId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostIP() {
		return hostIP;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(ZonedDateTime modificationDate) {
		this.modificationDate = modificationDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDomainName() {
		return domainName;
	}
	public Long getFileSetId() {
		return fileSetId;
	}
}
