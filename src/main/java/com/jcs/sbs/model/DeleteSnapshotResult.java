package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Result class for the delete snapshot operation.
 */
public class DeleteSnapshotResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = -5670232468998211566L;

    private boolean deleted;
    
    /**
     * Returns true if the snapshot is deleted, false otherwise.
     * 
     * @return Boolean value, <i>true</i> if the snapshot is deleted, false otherwise.
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets boolean value indicating if snapshot is deleted or not.
     * 
     * @param deleted Boolean value, <i>true</i> if the snapshot is deleted, false otherwise.
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Default constructor for DeleteSnapshotResult object.
     */
    public DeleteSnapshotResult() {
        super();
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (deleted ? 1231 : 1237);
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
        DeleteSnapshotResult other = (DeleteSnapshotResult) obj;
        if (deleted != other.deleted)
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DeleteSnapshotResult clone() {
        try {
            return (DeleteSnapshotResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}