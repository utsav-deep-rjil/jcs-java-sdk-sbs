package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Request class for delete volume operation.
 */
public class DeleteVolumeRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = 8724912824318843928L;

    private String volumeId;

    /**
     * Default constructor for DeleteVolumeRequest object.
     */
    public DeleteVolumeRequest() {
    }

    /**
     * Creates an object of DeleteVolumeRequest with given volumeId.
     * 
     * @param volumeId
     *            ID of the volume to delete.
     */
    public DeleteVolumeRequest(String volumeId) {
        setVolumeId(volumeId);
    }

    /**
     * Sets the given volumeId in DeleteVolumeRequest.
     * 
     * @param volumeId
     *            ID of the volume to delete.
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    /**
     * Fetches the ID(if set) of the volume to delete.
     * 
     * @return ID of the volume to delete.
     */
    public String getVolumeId() {
        return this.volumeId;
    }

    /**
     * Sets the ID of the volume to delete and returns the
     * modified object of DeleteVolumeRequest
     * 
     * @param volumeId
     *            ID of the volume to delete.
     * @return Modified object of DeleteVolumeRequest
     */
    public DeleteVolumeRequest withVolumeId(String volumeId) {
        setVolumeId(volumeId);
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
        result = prime * result + ((volumeId == null) ? 0 : volumeId.hashCode());
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
        DeleteVolumeRequest other = (DeleteVolumeRequest) obj;
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
    public DeleteVolumeRequest clone() {
        try {
            return (DeleteVolumeRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
    
}