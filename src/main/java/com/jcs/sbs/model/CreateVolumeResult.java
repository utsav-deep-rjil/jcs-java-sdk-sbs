package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Result class for the create volume operation.
 */
public class CreateVolumeResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = 8077929441491924782L;

    private Volume volume;

    /**
     * Default constructor for CreateVolumeResult object.
     */
    public CreateVolumeResult() {
    }

    /**
     * Used internally in {@link com.jcs.sbs.model.JCSComputeClient
     * JCSComputeClient} class. It sets the Volume object in the object of
     * CreateVolumeResult
     * 
     * @param volume
     *            Object of {@link com.jcs.sbs.model.Volume Volume} that is
     *            created from response of the create volume API.
     */
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    /**
     * Returns the object of {@link com.jcs.sbs.model.Volume Volume} that is
     * created.
     * 
     * @return {@link com.jcs.sbs.model.Volume Volume} object that is created
     *         from the response of the create volume API
     */
    public Volume getVolume() {
        return this.volume;
    }

    /**
     * Sets the {@link com.jcs.sbs.model.Volume Volume} object in CreateVolumeResult object and returns the
     * modified CreateVolumeResult object
     * 
     * @param volume
     *            Object of {@link com.jcs.sbs.model.Volume Volume} that is created from response of create
     *            volume API
     * @return Modified CreateVolumeResult object
     */
    public CreateVolumeResult withVolume(Volume volume) {
        setVolume(volume);
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
        result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
        CreateVolumeResult other = (CreateVolumeResult) obj;
        if (volume == null) {
            if (other.volume != null)
                return false;
        } else if (!volume.equals(other.volume))
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public CreateVolumeResult clone() {
        try {
            return (CreateVolumeResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}