package de.br.multimedia.mediathekplus.b7.service.rest.mock;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

import de.br.multimedia.mediathekplus.b7.client.RecordingDeliveryRestServiceClient;
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

		client.updateRecordingStatus(id, true);

		feed = client.getRecordings(RecordingFilterEnum.UNDELIVERED);
		Recording changed = findRecording(feed, id);
		assertThat("recoding is still present in UNDELIVERED recordings list", changed, is(nullValue()));

		feed = client.getRecordings(RecordingFilterEnum.DELIVERED);
		changed = findRecording(feed, id);
		assertThat("recoding is not present in DELIVERED recordings list", changed, is(not(nullValue())));
		
		changed = client.getRecording(id);
		assertThat("recoding is not DELIVERED", changed.isDelivered(), is(true));

	}


	private Recording findRecording(RecordingFeed feed, long id) {
		for (Recording recording : feed.getRecordings()) {
			if (recording.getRecordingId() == id)
				return recording;
		}
		return null;
	}

}
