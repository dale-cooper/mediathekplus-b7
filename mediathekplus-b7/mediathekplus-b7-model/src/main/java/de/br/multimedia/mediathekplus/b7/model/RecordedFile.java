package de.br.multimedia.mediathekplus.b7.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class RecordedFile {

	@XmlAttribute
	private RecordedFileTypeEnum type;
	@XmlAttribute
	private String path;
	@XmlAttribute
	private String md5;

	public RecordedFile() {
	}

	public RecordedFile(RecordedFileTypeEnum type, String path, String md5) {
		this.type = type;
		this.path = path;
		this.md5 = md5;
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

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
