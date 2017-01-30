package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Result class for create snapshot operation
 */
public class CreateSnapshotResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = -2051402111070113334L;

    private Snapshot snapshot;


    /**
     * Default constructor for CreateSnapshotResult object.
     */
    public CreateSnapshotResult() {

    }

    /**
     * Used internally in JCSComputeClient class to set the
     * snapshot object
     * 
     * @param snapshot
     *            The object of the snapshot that is created
     */
    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * Returns the object of the snapshot that is created
     * 
     * @return The object of the snapshot that is created
     */
    public Snapshot getSnapshot() {
        return this.snapshot;
    }

    /**
     * Adds the snapshot object, passed as the argument, in the
     * object of CreateSnapshotResult object returns the modified object
     * 
     * @param snapshot
     *            The snapshot object that gets added in
     *            CreateSnapshotResult object
     * @return Modified object of CreateSnapshotResult
     */
    public CreateSnapshotResult withSnapshot(Snapshot snapshot) {
        setSnapshot(snapshot);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public CreateSnapshotResult clone() {
        try {
            return (CreateSnapshotResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((snapshot == null) ? 0 : snapshot.hashCode());
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
        CreateSnapshotResult other = (CreateSnapshotResult) obj;
        if (snapshot == null) {
            if (other.snapshot != null)
                return false;
        } else if (!snapshot.equals(other.snapshot))
            return false;
        return true;
    }
}