package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Request class for the delete snapshot operation.
 */
public class DeleteSnapshotRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = 5656441961856031597L;

    private String snapshotId;

    /**
     * Default constructor for DeleteSnapshotRequest object.
     */
    public DeleteSnapshotRequest() {
    }

    /**
     * Creates DeleteSnapshotRequest object with given snapshotId.
     * 
     * @param snapshotId
     *            ID of the snapshot to delete.
     */
    public DeleteSnapshotRequest(String snapshotId) {
        setSnapshotId(snapshotId);
    }

    /**
     * Sets the snapshot ID in DeleteSnapshotRequest object
     * 
     * @param snapshotId
     *            ID of the snapshot to delete.
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Returns the ID of the snapshot to delete (if set).
     * 
     * @return ID of the snapshot to delete.
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * Sets the snapshotId in DeleteSnapshotRequest object and
     * returns the modified DeleteSnapshotRequest object
     * 
     * @param snapshotId
     *            ID of the snapshot to delete.
     * @return Modified DeleteSnapshotRequest object
     */
    public DeleteSnapshotRequest withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((snapshotId == null) ? 0 : snapshotId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DeleteSnapshotRequest other = (DeleteSnapshotRequest) obj;
        if (snapshotId == null) {
            if (other.snapshotId != null)
                return false;
        } else if (!snapshotId.equals(other.snapshotId))
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DeleteSnapshotRequest clone() {
        try {
            return (DeleteSnapshotRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
    
}