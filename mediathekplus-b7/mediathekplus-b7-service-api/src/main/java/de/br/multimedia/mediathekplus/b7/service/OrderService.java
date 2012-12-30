package de.br.multimedia.mediathekplus.b7.service;

import de.br.multimedia.mediathekplus.b7.model.LiveStreamingOrderFeed;
import de.br.multimedia.mediathekplus.b7.model.RecordingOrderFeed;

public interface OrderService {
	
	public RecordingOrderFeed getRecordingOrders();
	
	public LiveStreamingOrderFeed getLiveStreamingOrders();
}
