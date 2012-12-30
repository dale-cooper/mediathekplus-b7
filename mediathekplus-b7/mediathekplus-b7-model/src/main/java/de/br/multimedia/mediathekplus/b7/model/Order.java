package de.br.multimedia.mediathekplus.b7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "externalId", "liveStreaming", "deliverRecording",
		"geoprotection" })
public class Order {
	
	private String externalId;
	private boolean liveStreaming;
	private boolean deliverRecording;
	private GeoprotectionTypeEnum geoprotection;

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
