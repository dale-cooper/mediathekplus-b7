package de.br.multimedia.mediathekplus.b7.service.rest.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.br.multimedia.mediathekplus.b7.model.Order;
import de.br.multimedia.mediathekplus.b7.model.RecordingOrderFeed;
import de.br.multimedia.mediathekplus.b7.service.rest.OrderPublishingRestService;
import de.br.multimedia.mediathekplus.b7.service.rest.mock.data.OrdersTestDataBuilder;

@Path(OrderPublishingRestService.PATH_ORDERS)
public class MockedOrderPublishingRestService extends OrderPublishingRestService {

	
	private static final Logger log = LoggerFactory.getLogger(MockedOrderPublishingRestService.class);

	private static final List<Order> recordingOrders = new ArrayList<Order>();

	static {
		
		OrdersTestDataBuilder builder = new OrdersTestDataBuilder();
		recordingOrders.addAll(builder.buildRecordingOrders());
	}
	
	@Override
	public RecordingOrderFeed getRecordingOrders() {
		
		log.info("deliver {} recording orders", recordingOrders.size());
		RecordingOrderFeed feed = new RecordingOrderFeed();
		fillFeed(feed, recordingOrders);
		return feed;
	}

	private void fillFeed(RecordingOrderFeed feed, List<Order> orders) {
		Date lastModified = new Date();
		feed.setLastModified(lastModified);
		feed.setOrders(orders);
	}


}
