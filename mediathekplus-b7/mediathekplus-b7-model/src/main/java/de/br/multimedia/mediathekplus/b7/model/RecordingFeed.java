package de.br.multimedia.mediathekplus.b7.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contains a list of recordings ready for delivery. 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class RecordingFeed {

	@XmlAttribute(required=true)
	private Date lastModified;
	
	@XmlElement(name = "recording")
	private List<Recording> recordings;


	public List<Recording> getRecordings() {
		return recordings;
	}

	public void setRecordings(List<Recording> recordings) {
		this.recordings = recordings;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}
