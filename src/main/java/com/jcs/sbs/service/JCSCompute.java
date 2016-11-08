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
     * This method sets the base URL of API calls that will be made.
     * 
     * @param endpoint
     *            The base URL of the API
     */
    public void setEndpoint(String endpoint);

    /**
     * This method creates a volume with specifications given in
     * CreateVolumeRequest object.
     * 
     * @param createVolumeRequest
     *            An object of CreateVolumeRequest containing values required in
     *            create volume API
     * @return Create volume result object containing values in response given
     *         by create volume API
     * @throws Exception
     */
    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest) throws Exception;

    /**
     * Method to delete a particular volume. The state of volume must be
     * 'available'
     * 
     * @param deleteVolumeRequest
     *            An object of DeleteVolumeRequest containing values required in
     *            delete volume API
     * @return Delete volume result object containing values in response given
     *         by delete volume API
     * @throws Exception
     */
    public DeleteVolumeResult deleteVolume(DeleteVolumeRequest deleteVolumeRequest) throws Exception;

    /**
     * Method to return a list of Volumes.
     * 
     * @param describeVolumesRequest
     *            An object of DescribeVolumesRequest containing values required
     *            in describe volumes API
     * @return DescribeVolumesResult object containing list of Volumes as
     *         returned by describe volume API
     * @throws Exception
     */
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest) throws Exception;

    /**
     * Method to create a snapshot from a given volume. The state of volume must
     * be 'available'.
     * 
     * @param createSnapshotRequest
     *            An object of CreateSnapshotRequest containing values required
     *            in create snapshot API
     * @return Create snapshot result object containing values in response given
     *         by create snapshot API
     * @throws Exception
     */
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest) throws Exception;

    /**
     * Method to delete a particular snapshot. The state of snapshot must be
     * 'created'.
     * 
     * @param deleteSnapshotRequest
     *            An object of DeleteSnapshotRequest containing values required
     *            in delete snapshot API
     * @return Delete snapshot result object containing values in response given
     *         by delete snapshot API
     * @throws Exception
     */
    public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) throws Exception;

    /**
     * Method to return a list of snapshots.
     * 
     * @param describeSnapshotsRequest
     *            An object of DescribeSnapshotsRequest containing values
     *            required in describe snapshots API
     * @return DescribeSnapshotsResult object containing a list of Snapshots as
     *         returned by describe snapshots API
     * @throws Exception
     */
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest)
            throws Exception;
}
