package de.br.multimedia.mediathekplus.b7.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import de.br.multimedia.mediathekplus.b7.model.RecordedFilesFeed;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingDeliveryService;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;

public class RecordingDeliveryRestServiceClient implements RecordingDeliveryService {

	private final Client restClient;
	private final String recordingsUri;
	private final String updateRecordingStatusUri;
	private final String moveRecordedFilesUri;
	private final String recordingIdParam;

	public RecordingDeliveryRestServiceClient(final String baseUri) {
		this.restClient = Client.create();
		this.recordingsUri = baseUri + "/" + RecordingDeliveryService.PATH_RECORDINGS;
		this.updateRecordingStatusUri = baseUri + "/" + RecordingDeliveryService.PATH_RECORDINGS + "/" + RecordingDeliveryService.SUBPATH_UPDATE_RECORDING_STATUS;
		this.moveRecordedFilesUri = baseUri + "/" + RecordingDeliveryService.PATH_RECORDINGS + "/" + RecordingDeliveryService.SUBPATH_MOVE_RECORDED_FILES;
		this.recordingIdParam = "{" + RecordingDeliveryService.PATH_PARAM_RECORDING_ID + "}";
	}

	@Override
	public RecordingFeed getRecordings(RecordingFilterEnum filter) {

		WebResource resource = restClient.resource(recordingsUri);

		if (filter != null) {
			resource = resource.queryParam(RecordingDeliveryService.QUERY_PARAM_STATUS_FILTER, filter.toString());
		}
		return resource.get(RecordingFeed.class);
	}

	@Override
	public void updateRecordingStatus(long recordingId, boolean delivered) {
		restClient.resource(updateRecordingStatusUri.replace(recordingIdParam, Long.toString(recordingId)))
				.queryParam(RecordingDeliveryService.QUERY_PARAM_DELIVERED, Boolean.toString(delivered)).put();
	}

	@Override
	public void moveRecordedFiles(long recordingId, RecordedFilesFeed filesToMove) {
		restClient.resource(moveRecordedFilesUri.replace(recordingIdParam, Long.toString(recordingId))).put(filesToMove);
	}

}
