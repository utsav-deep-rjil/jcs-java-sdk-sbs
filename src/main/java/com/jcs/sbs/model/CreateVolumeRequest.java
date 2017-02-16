package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Request class for the create volume operation.
 */
public class CreateVolumeRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = -2272230902337784644L;

    private Integer size;
    private String snapshotId;
    private Boolean encrypted;
    private String volumeType;

    /**
     * Default constructor for CreateVolumeRequest object.
     */
    public CreateVolumeRequest() {
    }

    /**
     * Creates CreateVolumeRequest object with given volume size.
     * 
     * @param size
     *            The size of the volume that gets created
     */
    public CreateVolumeRequest(Integer size) {
        setSize(size);
    }

    /**
     * Creates an object of CreateVolumeRequest if the volume gets created from
     * a snapshot.
     * 
     * @param snapshotId
     *            The ID of the snapshot from which the volume gets created.
     */
    public CreateVolumeRequest(String snapshotId) {
        setSnapshotId(snapshotId);
    }

    /**
     * Sets the size of the volume that gets created. Volume size is a required
     * field for creating a volume if snapshotId is not present.
     * 
     * @param size
     *            The size of the volume that gets created.
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Returns the size of volume that gets created.
     * 
     * @return The integer size of volume that gets created.
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Sets the volume size to the CreateVolumeRequest object and returns the
     * modified object.
     * 
     * @param size
     *            Size of the volume that gets created.
     * @return Modified object of CreateVolumeRequest.
     */
    public CreateVolumeRequest withSize(Integer size) {
        setSize(size);
        return this;
    }

    /**
     * Sets the snapshotId in CreateVolumeRequest if the volume gets created
     * from snapshot.
     * 
     * @param snapshotId
     *            The ID of the snapshot from which volume gets created.
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Returns the Id of snapshot from which volume gets created.
     * 
     * @return The snapshotId if it is set.
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * Sets the snapshotId in CreateVolumeRequest if the volume gets created
     * from snapshot.
     * 
     * @param snapshotId
     *            The ID of the snapshot from which volume gets created.
     * @return Modified object of CreateVolumeRequest.
     */
    public CreateVolumeRequest withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    /**
     * Indicates if the volume that gets created is encrypted or not.
     * 
     * @return Boolean value; true if volume is encrypted after creation, false
     *         otherwise.
     */
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * Used to create encrypted volume. If 'encrypted' is set to true then
     * encrypted volume gets created, otherwise plain-text.
     * 
     * @param encrypted
     *            Boolean value to be set to 'encrypted' variable of the
     *            CreateVolumeRequest object.
     */
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * Used to create encrypted volume.
     * 
     * @return Modified object of CreateVolumeRequest with 'encrypted' set to
     *         true.
     */
    public CreateVolumeRequest withEncryption() {
        setEncrypted(true);
        return this;
    }

    /**
     * Returns the type of the volume that gets created.
     * 
     * @return A string value representing the type of volume gets created.
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * Sets the type of volume, standard(HDD) or ms1(SSD), that gets created. If
     * volumeType is not specified then 'standard' type volume gets created.
     * 
     * @param volumeType
     *            String value representing the volume type.
     */
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * Sets the value of volumeType field in the object of CreateVolumeRequest
     * and returns the modified object.
     * 
     * @param volumeType
     *            String value representing the volume type.
     * @return Modified CreateVolumeRequest object
     */
    public CreateVolumeRequest withVolumeType(String volumeType) {
        setVolumeType(volumeType);
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
    public CreateVolumeRequest clone() {
        try {
            return (CreateVolumeRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((encrypted == null) ? 0 : encrypted.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((snapshotId == null) ? 0 : snapshotId.hashCode());
        result = prime * result + ((volumeType == null) ? 0 : volumeType.hashCode());
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
        CreateVolumeRequest other = (CreateVolumeRequest) obj;
        if (encrypted == null) {
            if (other.encrypted != null)
                return false;
        } else if (!encrypted.equals(other.encrypted))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        if (snapshotId == null) {
            if (other.snapshotId != null)
                return false;
        } else if (!snapshotId.equals(other.snapshotId))
            return false;
        if (volumeType != other.volumeType)
            return false;
        return true;
    }

}