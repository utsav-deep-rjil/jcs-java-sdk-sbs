package com.jcs.sbs.service;

import com.jcs.sbs.model.CreateSnapshotRequest;
import com.jcs.sbs.model.CreateSnapshotResult;
import com.jcs.sbs.model.CreateVolumeRequest;
import com.jcs.sbs.model.CreateVolumeResult;
import com.jcs.sbs.model.DeleteSnapshotRequest;
import com.jcs.sbs.model.DeleteSnapshotResult;
import com.jcs.sbs.model.DeleteVolumeRequest;
import com.jcs.sbs.model.DeleteVolumeResult;
import com.jcs.sbs.model.DescribeSnapshotsRequest;
import com.jcs.sbs.model.DescribeSnapshotsResult;
import com.jcs.sbs.model.DescribeVolumesRequest;
import com.jcs.sbs.model.DescribeVolumesResult;

/**
 * Interface containing methods that provides access to the operations supported
 * by JCS SBS. The supported operations are create, describe and delete on
 * volume and snapshot.
 */
public interface JCSCompute {

    /**
     * Sets the base URL of API calls that will be made.
     * 
     * @param endpoint
     *            The base URL of the API
     */
    public void setEndpoint(String endpoint);

    /**
     * Creates a volume with specifications given in
     * {@link com.jcs.sbs.model.CreateVolumeRequest CreateVolumeRequest} object.
     * 
     * @param createVolumeRequest
     *            An object of {@link com.jcs.sbs.model.CreateVolumeRequest
     *            CreateVolumeRequest} containing values required in create
     *            volume API
     * @return {@link com.jcs.sbs.model.CreateVolumeResult CreateVolumeResult}
     *         object containing values in response given by create volume API
     * @throws Exception
     */
    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest) throws Exception;

    /**
     * Deletes a particular volume. The state of volume must be 'available' or
     * 'error'
     * 
     * @param deleteVolumeRequest
     *            An object of {@link com.jcs.sbs.model.DeleteVolumeRequest
     *            DeleteVolumeRequest} containing values required in delete
     *            volume API
     * @return {@link com.jcs.sbs.model.DeleteVolumeResult DeleteVolumeResult}
     *         object containing values in response given by delete volume API
     * @throws Exception
     */
    public DeleteVolumeResult deleteVolume(DeleteVolumeRequest deleteVolumeRequest) throws Exception;

    /**
     * Describes the volumes according to filters present in
     * {@link com.jcs.sbs.model.DescribeVolumesRequest DescribeVolumesRequest}
     * object.
     * 
     * @param describeVolumesRequest
     *            An object of {@link com.jcs.sbs.model.DescribeVolumesRequest
     *            DescribeVolumesRequest} containing values required in describe
     *            volumes API
     * @return {@link com.jcs.sbs.model.DescribeVolumesResult
     *         DescribeVolumesResult} object containing list of
     *         {@link com.jcs.sbs.model.Volume Volume} objects as returned by
     *         describe volume API
     * @throws Exception
     */
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest) throws Exception;

    /**
     * Creates a snapshot from the volumeId given in
     * {@link com.jcs.sbs.model.CreateSnapshotRequest CreateSnapshotRequest}.
     * The state of volume must be 'available'.
     * 
     * @param createSnapshotRequest
     *            An object of {@link com.jcs.sbs.model.CreateSnapshotRequest
     *            CreateSnapshotRequest} containing values required in create
     *            snapshot API
     * @return {@link com.jcs.sbs.model.CreateSnapshotResult
     *         CreateSnapshotResult} object containing values in response given
     *         by create snapshot API
     * @throws Exception
     */
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws Exception;

    /**
     * Deletes a particular snapshot. The state of snapshot must be 'created' or
     * 'error'
     * 
     * @param deleteSnapshotRequest
     *            An object of {@link com.jcs.sbs.model.DeleteSnapshotRequest
     *            DeleteSnapshotRequest} containing values required in delete
     *            snapshot API
     * @return {@link com.jcs.sbs.model.DeleteSnapshotResult
     *         DeleteSnapshotResult} object containing values in response given
     *         by delete snapshot API
     * @throws Exception
     */
    public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) throws Exception;

    /**
     * Describes the snapshots according to filters present in
     * {@link com.jcs.sbs.model.DescribeSnapshotsRequest
     * DescribeSnapshotsRequest} object.
     * 
     * @param describeSnapshotsRequest
     *            An object of {@link com.jcs.sbs.model.DescribeSnapshotsRequest
     *            DescribeSnapshotsRequest} containing values required in
     *            describe snapshots API
     * @return {@link com.jcs.sbs.model.DescribeSnapshotsResult
     *         DescribeSnapshotsResult} object containing a list of
     *         {@link com.jcs.sbs.model.Snapshot Snapshot} objects as returned
     *         by describe snapshots API
     * @throws Exception
     */
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest)
            throws Exception;
}
