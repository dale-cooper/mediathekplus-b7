package de.br.multimedia.mediathekplus.b7.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingDeliveryService;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;
import de.br.multimedia.mediathekplus.b7.service.rest.RecordingDeliveryRestService;

public class RecordingDeliveryRestServiceClient implements RecordingDeliveryService {

	private final Client restClient;
	private final String recordingsUri;
	private final String updateRecordingStatusUri;
	private final String recordingIdParam;

	public RecordingDeliveryRestServiceClient(final String baseUri) {
		this.restClient = Client.create();
		this.recordingsUri = baseUri + "/" + RecordingDeliveryRestService.PATH_RECORDINGS + "/" + RecordingDeliveryRestService.SUBPATH_RECORDING_FEED;
		this.updateRecordingStatusUri = baseUri + "/" + RecordingDeliveryRestService.PATH_RECORDINGS + "/" + RecordingDeliveryRestService.SUBPATH_UPDATE_RECORDING_STATUS;
		this.recordingIdParam = "{" + RecordingDeliveryRestService.PATH_PARAM_RECORDING_ID + "}";
	}

	@Override
	public RecordingFeed getRecordings(RecordingFilterEnum filter) {

		WebResource resource = restClient.resource(recordingsUri);

		if (filter != null) {
			resource = resource.queryParam(RecordingDeliveryRestService.QUERY_PARAM_STATUS_FILTER, filter.toString());
		}
		return resource.get(RecordingFeed.class);
	}

	@Override
	public void updateRecordingStatus(long recordingId, boolean delivered) {
		restClient.resource(updateRecordingStatusUri.replace(recordingIdParam, Long.toString(recordingId)))
				.queryParam(RecordingDeliveryRestService.QUERY_PARAM_DELIVERED, Boolean.toString(delivered)).put();
	}


}
