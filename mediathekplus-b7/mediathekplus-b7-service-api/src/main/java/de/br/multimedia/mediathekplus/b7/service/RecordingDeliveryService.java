package de.br.multimedia.mediathekplus.b7.service;

import de.br.multimedia.mediathekplus.b7.model.RecordedFilesFeed;
import de.br.multimedia.mediathekplus.b7.model.RecordingFeed;

public interface RecordingDeliveryService {
	
	
	public static final String QUERY_PARAM_DELIVERED = "delivered";
	public static final String QUERY_PARAM_STATUS_FILTER = "statusFilter";
	public static final String PATH_PARAM_RECORDING_ID = "recordingId";
	public static final String PATH_RECORDINGS = "recordings";
	public static final String SUBPATH_UPDATE_RECORDING_STATUS = "{recordingId}/status";
	public static final String SUBPATH_MOVE_RECORDED_FILES = "{recordingId}/files";

	
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
	
	/**
	 * Moves the recorded files of a recording to a different location
	 * @param recordingId identifies the recording
	 * @param filesToMove list of files to move
	 */
	public void moveRecordedFiles(long recordingId, RecordedFilesFeed filesToMove);
}
