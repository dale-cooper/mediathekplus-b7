package de.br.multimedia.mediathekplus.b7.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import de.br.multimedia.mediathekplus.b7.model.Recording;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingDeliveryService;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;

@Path(RecordingDeliveryRestService.PATH_RECORDINGS)
@Produces({ "application/xml" })
public abstract class RecordingDeliveryRestService implements RecordingDeliveryService {

	public static final String PATH_RECORDINGS = "recordings";
	public static final String SUBPATH_UPDATE_RECORDING_STATUS = "{recordingId}/status";
	public static final String SUBPATH_GET_RECORDING = "{recordingId}";
	public static final String QUERY_PARAM_DELIVERED = "delivered";
	public static final String QUERY_PARAM_STATUS_FILTER = "statusFilter";
	public static final String PATH_PARAM_RECORDING_ID = "recordingId";


	@GET
	public abstract RecordingFeed getRecordings(
			@QueryParam(QUERY_PARAM_STATUS_FILTER) final RecordingFilterEnum statusFilter);

	@GET
	@Path(SUBPATH_GET_RECORDING)
	public abstract Recording getRecording(@PathParam(PATH_PARAM_RECORDING_ID) long recordingId);


	@PUT
	@Path(SUBPATH_UPDATE_RECORDING_STATUS)
	public abstract void updateRecordingStatus(
			@PathParam(PATH_PARAM_RECORDING_ID) final long recordingId,
			@QueryParam(QUERY_PARAM_DELIVERED) final boolean delivered);


}