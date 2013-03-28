	package de.br.multimedia.mediathekplus.b7.model;

import java.util.ArrayList;
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
@XmlType(propOrder = { 
		"channelId",
		"title", 
		"broadcastStartDate", 
		"broadcastEndDate",  
		"trimmingChangedDate", 
		"trimmingChangedByUser",
		"renderedFromMultiplePartsAt",
		"geoprotection",
		"files",
		"cuts"})
public class Recording {

	@XmlAttribute(required = true)
	private long recordingId;
	@XmlAttribute(required = true)
	private String broadcastScheduleSystemId;
	@XmlAttribute(required = true)
	private boolean delivered;
	
	private String channelId;
	@XmlElement(required = true)
	private String title;  
	private Date broadcastStartDate;
	private Date broadcastEndDate;
	private Date trimmingChangedDate;
	private String trimmingChangedByUser;
	private Date renderedFromMultiplePartsAt;
	private GeoprotectionTypeEnum geoprotection;

	@XmlElementWrapper(name = "files")
	@XmlElement(name = "file")
	private List<RecordedFile> files = new ArrayList<RecordedFile>();
	
	@XmlElementWrapper(name = "cuts")
	@XmlElement(name = "cut")
	private List<RecordingCut> cuts = new ArrayList<RecordingCut>();

	public long getRecordingId() {
		return recordingId;
	}

	public void setRecordingId(long recordingId) {
		this.recordingId = recordingId;
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


	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getBroadcastScheduleSystemId() {
		return broadcastScheduleSystemId;
	}

	public void setBroadcastScheduleSystemId(String broadcastScheduleSystemId) {
		this.broadcastScheduleSystemId = broadcastScheduleSystemId;
	}

	public Date getRenderedFromMultiplePartsAt() {
		return renderedFromMultiplePartsAt;
	}

	public void setRenderedFromMultiplePartsAt(Date renderedFromMultiplePartsAt) {
		this.renderedFromMultiplePartsAt = renderedFromMultiplePartsAt;
	}

	public GeoprotectionTypeEnum getGeoprotection() {
		return geoprotection;
	}

	public void setGeoprotection(GeoprotectionTypeEnum geoprotection) {
		this.geoprotection = geoprotection;
	}

	public List<RecordingCut> getCuts() {
		return cuts;
	}

	public void setCuts(List<RecordingCut> cuts) {
		this.cuts = cuts;
	}

}
