package de.br.multimedia.mediathekplus.b7.service;

import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;

public interface RecordingDeliveryService {
	
	
	
	/**
	 * Generates a list of all existing recordings.
	 * @param filter by delivery status
	 * @return list of recordings
	 */
	public RecordingFeed getRecordings(RecordingFilterEnum filter);
	
	/**
	 * Updates the delivery status of a recording.
	 * @param recordingId identifies the recording to update
	 * @param delivered delivery status. true for delivered and false for undelivered
	 */
	public void updateRecordingStatus(long recordingId, boolean delivered);
	
}
