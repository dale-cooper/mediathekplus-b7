package de.br.multimedia.mediathekplus.b7.service.rest.mock;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.UUID;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

import de.br.multimedia.mediathekplus.b7.client.RecordingDeliveryRestServiceClient;
import de.br.multimedia.mediathekplus.b7.model.RecordedFile;
import de.br.multimedia.mediathekplus.b7.model.RecordedFilesFeed;
import de.br.multimedia.mediathekplus.b7.model.Recording;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;

public class MockedRecordingDeliveryServiceTest {

	private final String serverUrl = "http://localhost:4434";
	private SelectorThread server;

	@BeforeClass
	public void startServer() throws Exception {
		server = GrizzlyServerFactory.create(serverUrl);
	}

	@AfterClass
	public void stopServer() throws Exception {
		server.stopEndpoint();
	}

	@Test
	public void exerciseDeliveryOfOneRecoding() throws Exception {

		final RecordingDeliveryRestServiceClient client = new RecordingDeliveryRestServiceClient(serverUrl);

		RecordingFeed feed = client.getRecordings(RecordingFilterEnum.UNDELIVERED);

		final Recording firstRecording = feed.getRecordings().get(0);
		final long id = firstRecording.getRecordingId();

		final String filename = UUID.randomUUID().toString() + "_";
		final RecordedFilesFeed filesFeed = createFeedWithUpdatedFiles(firstRecording, filename);

		client.moveRecordedFiles(id, filesFeed);
		feed = client.getRecordings(RecordingFilterEnum.UNDELIVERED);
		assertFilesChanged(feed, id, filename);

		client.updateRecordingStatus(id, true);

		feed = client.getRecordings(RecordingFilterEnum.UNDELIVERED);
		Recording changed = findRecording(feed, id);
		assertThat("recoding is still present in UNDELIVERED recordings list", changed, is(nullValue()));

		feed = client.getRecordings(RecordingFilterEnum.DELIVERED);
		changed = findRecording(feed, id);
		assertThat("recoding is not present in DELIVERED recordings list", changed, is(not(nullValue())));

	}

	private void assertFilesChanged(RecordingFeed feed, long id, String filename) {
		Recording changed = findRecording(feed, id);
		assertThat("recoding is not present", changed, is(not(nullValue())));
		for (RecordedFile file : changed.getFiles()) {
			assertThat("filename was not changed", file.getPath(), containsString(filename));
		}
	}

	private Recording findRecording(RecordingFeed feed, long id) {
		for (Recording recording : feed.getRecordings()) {
			if (recording.getRecordingId() == id)
				return recording;
		}
		return null;
	}

	private RecordedFilesFeed createFeedWithUpdatedFiles(Recording firstRecording, String filename) {
		List<RecordedFile> recordedFiles = firstRecording.getFiles();
		for (RecordedFile recordedFile : recordedFiles) {
			recordedFile.setPath(recordedFile.getPath().replace("filename_", filename));
		}

		RecordedFilesFeed filesFeed = new RecordedFilesFeed();
		filesFeed.setFiles(recordedFiles);
		return filesFeed;
	}
}
