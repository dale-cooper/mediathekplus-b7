package de.br.multimedia.mediathekplus.b7.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.br.multimedia.mediathekplus.b7.model.RecordingOrderFeed;
import de.br.multimedia.mediathekplus.b7.service.OrderPublishingService;

@Produces({ "application/xml" })
public abstract class OrderPublishingRestService implements OrderPublishingService {

	public static final String PATH_ORDERS ="orders";
	public static final String SUBPATH_RECORDING_ORDERS ="recordingFeed";
	public static final String SUBPATH_STREAMING_ORDERS ="liveStreamingFeed";
	
	@GET
	@Path(SUBPATH_RECORDING_ORDERS)
	public Response getRecordingOrdersResponse(){
		return createResponseWithLastModified(getRecordingOrders());
	}

	private Response createResponseWithLastModified(RecordingOrderFeed orders) {
		return Response.ok(orders).lastModified(orders.getLastModified()).build();
	}


}
