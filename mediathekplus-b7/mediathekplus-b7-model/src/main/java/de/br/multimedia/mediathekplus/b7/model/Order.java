package de.br.multimedia.mediathekplus.b7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	@XmlAttribute
	private String title;
	@XmlAttribute(required=true)
	private GeoprotectionTypeEnum geoprotection;
	@XmlAttribute
	private boolean deliverRecording;
	@XmlAttribute(required=true)
	private String vpsLabel;
	@XmlAttribute(required=true)
	private String channelId;
	@XmlAttribute(required=true)
	private String broadcastScheduleSystemId;

	
	public Order() {
	}

	public Order(String broadcastScheduleSystemId, boolean deliverRecording, GeoprotectionTypeEnum geoprotection) {
		this.broadcastScheduleSystemId = broadcastScheduleSystemId;
		this.deliverRecording = deliverRecording;
		this.geoprotection = geoprotection;
	}


	public boolean isDeliverRecording() {
		return deliverRecording;
	}

	public void setDeliverRecording(boolean deliverRecording) {
		this.deliverRecording = deliverRecording;
	}

	public GeoprotectionTypeEnum getGeoprotection() {
		return geoprotection;
	}

	public void setGeoprotection(GeoprotectionTypeEnum geoprotection) {
		this.geoprotection = geoprotection;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVpsLabel() {
		return vpsLabel;
	}

	public void setVpsLabel(String vpsLabel) {
		this.vpsLabel = vpsLabel;
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
}
