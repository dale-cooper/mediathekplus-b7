package de.br.multimedia.mediathekplus.b7.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RecordingCut {

	@XmlAttribute(required=true)
	private Date recordingStartDate;
	@XmlAttribute(required=true)
	private Date recordingEndDate;

	
	public Date getRecordingStartDate() {
		return recordingStartDate;
	}
	public void setRecordingStartDate(Date recordingStartDate) {
		this.recordingStartDate = recordingStartDate;
	}
	public Date getRecordingEndDate() {
		return recordingEndDate;
	}
	public void setRecordingEndDate(Date recordingEndDate) {
		this.recordingEndDate = recordingEndDate;
	}
	
	
}
