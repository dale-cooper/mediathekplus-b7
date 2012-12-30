package de.br.multimedia.mediathekplus.b7.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import de.br.multimedia.mediathekplus.b7.model.RecordedFilesFeed;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;
import de.br.multimedia.mediathekplus.b7.service.RecordingDeliveryService;
import de.br.multimedia.mediathekplus.b7.service.RecordingFilterEnum;

@Path(RecordingDeliveryService.PATH_RECORDINGS)
@Produces({ "application/xml", "application/json" })
public abstract class RecordingDeliveryRestService implements RecordingDeliveryService {

	@GET
	public abstract RecordingFeed getRecordings(
			@QueryParam(RecordingDeliveryService.QUERY_PARAM_STATUS_FILTER) final RecordingFilterEnum statusFilter);

	@PUT
	@Path(RecordingDeliveryService.SUBPATH_MOVE_RECORDED_FILES)
	public abstract void moveRecordedFiles(
			@PathParam(RecordingDeliveryService.PATH_PARAM_RECORDING_ID) final long recordingId,
			final RecordedFilesFeed filesToMove);

	@PUT
	@Path(RecordingDeliveryService.SUBPATH_UPDATE_RECORDING_STATUS)
	public abstract void updateRecordingStatus(
			@PathParam(RecordingDeliveryService.PATH_PARAM_RECORDING_ID) final long recordingId,
			@QueryParam(RecordingDeliveryService.QUERY_PARAM_DELIVERED) final boolean delivered);


}