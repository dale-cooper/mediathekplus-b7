package de.br.multimedia.mediathekplus.b7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	@XmlAttribute
	private GeoprotectionTypeEnum geoprotection;
	@XmlAttribute
	private boolean deliverRecording;
	@XmlAttribute
	private boolean liveStreaming;
	@XmlAttribute
	private String externalId;

	public Order() {
	}

	public Order(String externalId, boolean liveStreaming, boolean deliverRecording, GeoprotectionTypeEnum geoprotection) {
		this.externalId = externalId;
		this.liveStreaming = liveStreaming;
		this.deliverRecording = deliverRecording;
		this.geoprotection = geoprotection;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public boolean isLiveStreaming() {
		return liveStreaming;
	}

	public void setLiveStreaming(boolean liveStreaming) {
		this.liveStreaming = liveStreaming;
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
}
