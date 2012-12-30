package de.br.multimedia.mediathekplus.b7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "type", "path" })
public class RecordedFile {

	private RecordedFileTypeEnum type;
	private String path;

	public RecordedFile() {
	}

	public RecordedFile(RecordedFileTypeEnum type, String path) {
		this.type = type;
		this.path = path;
	}

	public RecordedFileTypeEnum getType() {
		return type;
	}

	public void setType(RecordedFileTypeEnum type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
