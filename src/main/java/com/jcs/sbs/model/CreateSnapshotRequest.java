package com.jcs.sbs.model;

import java.io.Serializable;

/**
 * Request class for create snapshot operation.
 */
public class CreateSnapshotRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = 6961306238384964459L;

    private String volumeId;

    /**
     * Default constructor for CreateSnapshotRequest object.
     */
    public CreateSnapshotRequest() {
    }

    /**
     * Creates CreateSnapshotRequest object from volume Id
     * 
     * @param volumeId
     *            Id of the volume from which snapshot is to be created
     */
    public CreateSnapshotRequest(String volumeId) {
        setVolumeId(volumeId);
    }

    /**
     * Sets the id of the volume from which snapshot is to be created
     * 
     * @param VolumeId
     *            ID of the volume from which snapshot is to be created
     */
    public void setVolumeId(String VolumeId) {
        this.volumeId = VolumeId;
    }

    /**
     * Returns the id of the volume from which snapshot is to be created
     * 
     * @return The volume Id from which snapshot is to be created
     */
    public String getVolumeId() {
        return this.volumeId;
    }

    /**
     * Assigns given volumeId to the create snapshot request object and returns
     * the modified object of CreateSnapshotRequest.
     * 
     * @param volumeId
     *            ID of the volume from which snapshot is to be created
     * @return Modified CreateSnapshotRequest object.
     */
    public CreateSnapshotRequest withVolumeId(String volumeId) {
        setVolumeId(volumeId);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getVolumeId() != null)
            sb.append("SnapshotId: " + getVolumeId() + ",");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateSnapshotRequest == false)
            return false;
        CreateSnapshotRequest other = (CreateSnapshotRequest) obj;
        if (other.getVolumeId() == null ^ this.getVolumeId() == null)
            return false;
        if (other.getVolumeId() != null && other.getVolumeId().equals(this.getVolumeId()) == false)
            return false;
        return true;
    }

}