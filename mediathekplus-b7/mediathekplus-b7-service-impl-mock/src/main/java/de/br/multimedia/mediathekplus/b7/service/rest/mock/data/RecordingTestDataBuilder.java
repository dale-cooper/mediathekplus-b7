package de.br.multimedia.mediathekplus.b7.service.rest.mock.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import de.br.multimedia.mediathekplus.b7.model.RecordedFile;
import de.br.multimedia.mediathekplus.b7.model.RecordedFileTypeEnum;
import de.br.multimedia.mediathekplus.b7.model.Recording;
import de.br.multimedia.mediathekplus.b7.model.RecordingCut;

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
		recording.setBroadcastScheduleSystemId("dmb-" + name);
		recording.setChannelId("12345");
		recording.setTitle(name + " title");
		recording.setBroadcastEndDate(new Date());
		recording.setBroadcastStartDate(new Date());
		
		RecordingCut cut = new RecordingCut();
		cut.setRecordingEndDate(new Date());
		cut.setRecordingStartDate(new Date());
		recording.getCuts().add(cut );
		
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
		files.add(new RecordedFile(RecordedFileTypeEnum.PREVIEW, "/path/to/" + name + "/filename_P.mp4", DigestUtils.md5Hex("filename_P")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_S_144, "/path/to/" + name + "/filename_0.mp4", DigestUtils.md5Hex("filename_0")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_S_216, "/path/to/" + name + "/filename_A.mp4", DigestUtils.md5Hex("filename_A")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_M_288, "/path/to/" + name + "/filename_B.mp4", DigestUtils.md5Hex("filename_B")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_L_360, "/path/to/" + name + "/filename_E.mp4", DigestUtils.md5Hex("filename_E")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_L_544, "/path/to/" + name + "/filename_C.mp4", DigestUtils.md5Hex("filename_C")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_XL_720, "/path/to/" + name + "/filename_X.mp4", DigestUtils.md5Hex("filename_X")));
		files.add(new RecordedFile(RecordedFileTypeEnum.WEB_XL_1080, "/path/to/" + name + "/filename_HD.mp4", DigestUtils.md5Hex("filename_HD")));
		return files;
	}

}
