package com.jcs.sbs.model;

import java.io.Serializable;

/**
 * Request class for delete snapshot operation.
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
     *            ID of the snapshot that is to be deleted
     */
    public DeleteSnapshotRequest(String snapshotId) {
        setSnapshotId(snapshotId);
    }

    /**
     * Sets the snapshot ID in DeleteSnapshotRequest object
     * 
     * @param snapshotId
     *            ID of the snapshot that is to be deleted
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Fetches the snapshot ID that is set.
     * 
     * @return ID of snapshot that is to be deleted
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * Sets the snapshotId in DeleteSnapshotRequest object and
     * returns the modified DeleteSnapshotRequest object
     * 
     * @param snapshotId
     *            ID of the snapshot that is to be deleted
     * @return Modified DeleteSnapshotRequest object
     */
    public DeleteSnapshotRequest withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSnapshotId() != null)
            sb.append("SnapshotId: " + getSnapshotId());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DeleteSnapshotRequest == false)
            return false;
        DeleteSnapshotRequest other = (DeleteSnapshotRequest) obj;
        if (other.getSnapshotId() == null ^ this.getSnapshotId() == null)
            return false;
        if (other.getSnapshotId() != null && other.getSnapshotId().equals(this.getSnapshotId()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        return hashCode;
    }
}