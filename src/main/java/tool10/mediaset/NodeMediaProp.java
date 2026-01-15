package tool10.mediaset;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class NodeMediaProp implements Serializable {

	public NodeMediaProp(Long mediaPropId, Long mediaId, Long mediaSetId, String mediaPropType,
			String engineName, String propKeyGroup, String propKey, String propValue, Long displayOrder, Long valueLong,
			Double valueDouble, String valueBoolean, ZonedDateTime valueZDT, byte[] valueBytes,
			String[] valueStringArray, ZonedDateTime creationDate, ZonedDateTime modificationDate) {
		super();
		this.mediaPropId = mediaPropId;
		this.mediaId = mediaId;
		this.mediaSetId = mediaSetId;
		this.mediaPropType = mediaPropType;
		this.engineName = engineName;
		this.propKeyGroup = propKeyGroup;
		this.propKey = propKey;
		this.propValue = propValue;
		this.displayOrder = displayOrder;
		this.valueLong = valueLong;
		this.valueDouble = valueDouble;
		this.valueBoolean = valueBoolean;
		this.valueZDT = valueZDT;
		this.valueBytes = valueBytes;
		this.valueStringArray = valueStringArray;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long mediaPropId;
	private Long mediaId;  //imageId, videoId, audioId
	private Long mediaSetId;
	private String mediaPropType;
	private String engineName;
	private String propKeyGroup;
	private String propKey;
	private String propValue;
	private Long displayOrder;
	private Long valueLong;
	private Double valueDouble;
	private String valueBoolean;
	private ZonedDateTime valueZDT;
	private byte[] valueBytes;
	private String[] valueStringArray;
	
	private ZonedDateTime creationDate;
	private ZonedDateTime modificationDate;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getMediaPropId() {
		return mediaPropId;
	}
	public Long getMediaId() {
		return mediaId;
	}
	public Long getMediaSetId() {
		return mediaSetId;
	}
	public String getMediaPropType() {
		return mediaPropType;
	}
	public String getEngineName() {
		return engineName;
	}
	public String getPropKeyGroup() {
		return propKeyGroup;
	}
	public String getPropKey() {
		return propKey;
	}
	public String getPropValue() {
		return propValue;
	}
	public Long getDisplayOrder() {
		return displayOrder;
	}
	public Long getValueLong() {
		return valueLong;
	}
	public Double getValueDouble() {
		return valueDouble;
	}
	public String getValueBoolean() {
		return valueBoolean;
	}
	public ZonedDateTime getValueZDT() {
		return valueZDT;
	}
	public byte[] getValueBytes() {
		return valueBytes;
	}
	public String[] getValueStringArray() {
		return valueStringArray;
	}
	public ZonedDateTime getCreationDate() {
		return creationDate;
	}
	public ZonedDateTime getModificationDate() {
		return modificationDate;
	}
	
}
