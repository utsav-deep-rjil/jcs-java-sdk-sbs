package com.jcs.sbs.model;

import java.io.Serializable;

/**
 * Result class for create volume operation.
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
     * Used internally in JCSComputeClient class. It sets the
     * Volume object in the object of CreateVolumeResult
     * 
     * @param volume
     *            Object of Volume that is created from response of create
     *            volume API
     */
    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    /**
     * Returns the object of volume that is created.
     * 
     * @return Volume object that is created from the response of create volume
     *         API
     */
    public Volume getVolume() {
        return this.volume;
    }

    /**
     * Sets the volume object in CreateVolumeResult object and
     * returns the modified CreateVolumeResult object
     * 
     * @param volume
     *            Object of Volume that is created from response of create
     *            volume API
     * @return Modified CreateVolumeResult object
     */
    public CreateVolumeResult withVolume(Volume volume) {
        setVolume(volume);
        return this;
    }

    @Override
    public String toString() {
        return this.getXml();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateVolumeResult == false)
            return false;
        CreateVolumeResult other = (CreateVolumeResult) obj;
        if (other.getVolume() == null ^ this.getVolume() == null)
            return false;
        if (other.getVolume() != null && other.getVolume().equals(this.getVolume()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getVolume() == null) ? 0 : getVolume().hashCode());
        return hashCode;
    }

    @Override
    public CreateVolumeResult clone() {
        try {
            return (CreateVolumeResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}