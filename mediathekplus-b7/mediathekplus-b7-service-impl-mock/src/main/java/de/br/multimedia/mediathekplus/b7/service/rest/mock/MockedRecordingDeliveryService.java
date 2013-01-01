package de.br.multimedia.mediathekplus.b7.service.rest.mock;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.br.multimedia.mediathekplus.b7.model.RecordedFilesFeed;
import de.br.multimedia.mediathekplus.b7.model.Recording;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;
import de.br.multimedia.mediathekplus.b7.service.rest.RecordingDeliveryRestService;

@Path("recordings")
public class MockedRecordingDeliveryService extends RecordingDeliveryRestService {

	private static final Logger log = LoggerFactory.getLogger(MockedRecordingDeliveryService.class);

	private static final Map<Long, Recording> recordings = new Hashtable<Long, Recording>();

	static {
		final List<Recording> list = new RecordingTestDataBuilder().build();

		for (final Recording recording : list) {
			recordings.put(recording.getRecordingId(), recording);
		}
	}

	public RecordingFeed getRecordings(final RecordingFilterEnum statusFilter) {

		log.info("recordings with status filter {} requested", statusFilter);

		RecordingFeed feed = new RecordingFeed();

		List<Recording> list = new ArrayList<Recording>();
		if (statusFilter != null && !RecordingFilterEnum.ALL.equals(statusFilter))
			filterRecordings(statusFilter, list);
		else
			list.addAll(recordings.values());

		feed.setRecordings(list);
		return feed;
	}

	private void filterRecordings(final RecordingFilterEnum filter, final List<Recording> list) {
		for (Recording recording : recordings.values()) {
			final RecordingFilterEnum state = recording.isDelivered() ? RecordingFilterEnum.DELIVERED : RecordingFilterEnum.UNDELIVERED;
			if (state.equals(filter))
				list.add(recording);
		}
	}

	public void updateRecordingStatus(final long recordingId, final boolean delivered) {
		log.info("update status of id {} with status {}", recordingId, delivered);
		Recording recording = recordings.get(recordingId);
		if (recording != null)
			recording.setDelivered(delivered);
		else
			throwRecordingNotFoundException(recordingId);
	}

	private void throwRecordingNotFoundException(long recordingId) {
		throw new WebApplicationException(new Exception("The recording with the id " + recordingId + " does not exist."), Status.NOT_FOUND);
	}

	public void moveRecordedFiles(final long recordingId, final RecordedFilesFeed filesToMove) {
		log.info("update files of id {} with files {}", recordingId, filesToMove);
		Recording recording = recordings.get(recordingId);
		if (recording != null)
			recording.setFiles(filesToMove.getFiles());
		else
			throwRecordingNotFoundException(recordingId);

	}

}
