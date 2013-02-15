package de.br.multimedia.mediathekplus.b7.service.rest.mock.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.br.multimedia.mediathekplus.b7.model.RecordedFile;
import de.br.multimedia.mediathekplus.b7.model.RecordedFileTypeEnum;
import de.br.multimedia.mediathekplus.b7.model.Recording;

public class RecordingTestDataBuilder {

	public List<Recording> build() {

		ArrayList<Recording> list = new ArrayList<Recording>();
		list.add(createRecording("first"));
		list.add(createRecording("second"));
		list.add(createRecording("third"));
		list.add(createRecording("fourth"));
		return list;
	}

	private Recording createRecording(String name) {
		Recording recording = new Recording();
		recording.setRecordingId(deriveId(name));
		recording.setExternalId("dmb-" + name);
		recording.setPartNumber(1);
		recording.setChannelId("12345");
		recording.setBroadcastSeriesLabel("Dahoam is Dahoam");
		recording.setTitle(name + " title");
		recording.setTeaserText(name + " teaser text");
		recording.setAuthor(name + " author");
		recording.setBroadcastEndDate(new Date());
		recording.setBroadcastStartDate(new Date());
		recording.setRecordingEndDate(new Date());
		recording.setRecordingStartDate(new Date());
		recording.setTrimmingChangedByUser("trimming-user");
		recording.setTrimmingChangedDate(new Date());
		recording.setFiles(createFiles(name));
		return recording;
	}

	private long deriveId(String name) {
		long id = name.hashCode();
		if (id < 0)
			id = id * -1;
		return id;
	}

	private List<RecordedFile> createFiles(String name) {
		List<RecordedFile> files = new ArrayList<RecordedFile>();
		files.add(new RecordedFile(RecordedFileTypeEnum.PREVIEW, "/path/to/" + name + "/filename_P.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_S_144, "/path/to/" + name + "/filename_0.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_S_216, "/path/to/" + name + "/filename_A.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_M_288, "/path/to/" + name + "/filename_B.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_L_544, "/path/to/" + name + "/filename_C.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_XL_720, "/path/to/" + name + "/filename_X.mp4"));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_XL_1080, "/path/to/" + name + "/filename_HD.mp4"));
		return files;
	}

}
