package de.br.multimedia.mediathekplus.b7.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "recordingId", "externalId", "title", "teaserText",
		"author", "broadcastStartDate", "broadcastEndDate",
		"recordingStartDate", "recordingEndDate", "trimmingChangedDate",
		"trimmingChangedByUser", "delivered","files" })

public class Recording {
	private long recordingId;
	private String externalId;
	private String title;
	private String teaserText;
	private String author;
	private Date broadcastStartDate;
	private Date broadcastEndDate;
	private Date recordingStartDate;
	private Date recordingEndDate;
	private Date trimmingChangedDate;
	private String trimmingChangedByUser;
	private boolean delivered;

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

	public String getTeaserText() {
		return teaserText;
	}

	public void setTeaserText(String teaserText) {
		this.teaserText = teaserText;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

}
