package de.br.multimedia.mediathekplus.b7.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RecordedFilesFeed {

	@XmlElement(name = "file")
	List<RecordedFile> files;

	public List<RecordedFile> getFiles() {
		return files;
	}

	public void setFiles(List<RecordedFile> files) {
		this.files = files;
	}
}
