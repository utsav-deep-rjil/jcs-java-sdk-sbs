package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

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
     *            Id of the volume from which the snapshot gets created
     */
    public CreateSnapshotRequest(String volumeId) {
        setVolumeId(volumeId);
    }

    /**
     * Sets the id of the volume from which the snapshot gets created
     * 
     * @param VolumeId
     *            ID of the volume from which the snapshot gets created
     */
    public void setVolumeId(String VolumeId) {
        this.volumeId = VolumeId;
    }

    /**
     * Returns the id of the volume from which the snapshot gets created
     * 
     * @return The volume Id from which the snapshot gets created
     */
    public String getVolumeId() {
        return this.volumeId;
    }

    /**
     * Assigns given volumeId to the CreateSnapshotRequest object and returns
     * the modified object of CreateSnapshotRequest.
     * 
     * @param volumeId
     *            ID of the volume from which the snapshot gets created
     * @return Modified CreateSnapshotRequest object.
     */
    public CreateSnapshotRequest withVolumeId(String volumeId) {
        setVolumeId(volumeId);
        return this;
    }  
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((volumeId == null) ? 0 : volumeId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreateSnapshotRequest other = (CreateSnapshotRequest) obj;
        if (volumeId == null) {
            if (other.volumeId != null)
                return false;
        } else if (!volumeId.equals(other.volumeId))
            return false;
        return true;
    }


    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public CreateSnapshotRequest clone() {
        try {
            return (CreateSnapshotRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }


}