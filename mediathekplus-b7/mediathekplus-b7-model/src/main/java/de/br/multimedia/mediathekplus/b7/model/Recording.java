	package de.br.multimedia.mediathekplus.b7.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "recordingId", "externalId", "channelId",
		"broadcastSeriesLabel", "title", 
		"broadcastStartDate", "broadcastEndDate", "recordingStartDate",
		"recordingEndDate", "trimmingChangedDate", "trimmingChangedByUser",
		"delivered", "files" })
public class Recording {

	@XmlAttribute(required = true)
	private long recordingId;
	@XmlAttribute(required = true)
	private String externalId;
	@XmlAttribute(required = true)
	private int partNumber;
	@XmlAttribute(required = true)
	private boolean delivered;
	private String broadcastSeriesLabel;
	private String channelId;
	@XmlElement(required = true)
	private String title;  
	private Date broadcastStartDate;
	private Date broadcastEndDate;
	private Date recordingStartDate;
	private Date recordingEndDate;
	private Date trimmingChangedDate;
	private String trimmingChangedByUser;

	@XmlElementWrapper(name = "files")
	@XmlElement(name = "file")
	private List<RecordedFile> files;

	public long getRecordingId() {
		return recordingId;
	}

	public void setRecordingId(long recordingId) {
		this.recordingId = recordingId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Date getBroadcastStartDate() {
		return broadcastStartDate;
	}

	public void setBroadcastStartDate(Date broadcastStartDate) {
		this.broadcastStartDate = broadcastStartDate;
	}

	public Date getBroadcastEndDate() {
		return broadcastEndDate;
	}

	public void setBroadcastEndDate(Date broadcastEndDate) {
		this.broadcastEndDate = broadcastEndDate;
	}

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

	public List<RecordedFile> getFiles() {
		return files;
	}

	public void setFiles(List<RecordedFile> files) {
		this.files = files;
	}

	public String getTrimmingChangedByUser() {
		return trimmingChangedByUser;
	}

	public void setTrimmingChangedByUser(String trimmingChangedByUser) {
		this.trimmingChangedByUser = trimmingChangedByUser;
	}

	public Date getTrimmingChangedDate() {
		return trimmingChangedDate;
	}

	public void setTrimmingChangedDate(Date trimmingChangedDate) {
		this.trimmingChangedDate = trimmingChangedDate;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public String getBroadcastSeriesLabel() {
		return broadcastSeriesLabel;
	}

	public void setBroadcastSeriesLabel(String broadcastSeriesLabel) {
		this.broadcastSeriesLabel = broadcastSeriesLabel;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
