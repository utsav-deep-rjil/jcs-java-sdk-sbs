package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.Date;

public class Volume implements Serializable, Cloneable {

    private static final long serialVersionUID = -2799552718629746851L;

    private String volumeId;

    private Integer size;

    private VolumeType volumeType = VolumeType.standard;

    private String snapshotId;

    private Boolean encrypted = true;

    private Date createTime;

    private String status;

    /**
     * Default constructor for Volume object.
     */
    public Volume() {
    }

    /**
     * This method sets the volumeId in Volume object, which is returned by
     * describe volumes or create volume API.
     * 
     * @param volumeId
     *            Unique ID for volumes, which is returned by describe volumes
     *            or create volume API.
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    /**
     * Returns ID of the volume.
     * 
     * @return Unique ID for volumes, which is returned by describe volumes or
     *         create volume API.
     */
    public String getVolumeId() {
        return this.volumeId;
    }

    /**
     * This method sets the volumeId in Volume object, which is returned by
     * describe volumes or create volume API, and then returns the modified
     * Volume object.
     * 
     * @param volumeId
     *            Unique ID for volumes, which is returned by describe volumes
     *            or create volume API.
     * @return Modified Volume object.
     */
    public Volume withVolumeId(String volumeId) {
        setVolumeId(volumeId);
        return this;
    }

    /**
     * This method sets the size of the volume (in GB) in Volume object.
     * 
     * @param size
     *            The size of the volume (in GB)
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Returns size of the volume.
     * 
     * @return The size of the volume (in GB) as returned by describe volume
     *         API.
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * This method sets the size of the volume (in GB) in Volume object and
     * returns the modified Volume object.
     * 
     * @param size
     *            The size of the volume (in GB)
     * @return Modified Volume object.
     */
    public Volume withSize(Integer size) {
        setSize(size);
        return this;
    }

    /**
     * If the Volume was created from snapshot, this method can be used to set
     * the snapshotId of that snapshot.
     * 
     * @param snapshotId
     *            The ID of snapshot from which the volume is created (if volume
     *            is created from snapshot).
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * If volume was created from a snapshot, it returns the Id of that snapshot.
     * 
     * @return The ID of snapshot from which the volume is created (if volume is
     *         created from snapshot).
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * If the Volume was created from snapshot, this method can be also be used
     * to set the snapshotId of that snapshot. It also returns the modified
     * Volume object.
     * 
     * @param snapshotId
     *            The ID of snapshot from which the volume is created (if volume
     *            is created from snapshot).
     * @return Modified Volume object.
     */
    public Volume withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    /**
     * Sets the date and time at which the volume was created.
     * 
     * @param createTime
     *            Date and time at which the volume was created.
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Returns Date object containing date and time at which the volume was created.
     * 
     * @return Date and time at which the volume was created.
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Sets the date and time at which the volume was created and returns the
     * modified Volume object.
     * 
     * @param createTime
     *            Date and time at which the volume was created.
     * @return Modified Volume object.
     */
    public Volume withCreateTime(java.util.Date createTime) {
        setCreateTime(createTime);
        return this;
    }

    /**
     * Specifies whether the volume is encrypted or not encrypted. Returns the
     * value true if the volume is encrypted. Returns the value false if the
     * volume is not encrypted.
     * 
     * @return Boolean value. <br>
     *         <tt>true</tt> if the volume is encrypted, <tt>false</tt>
     *         otherwise.
     */
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * This method is used to set <tt>encrypted</tt> field in Volume object as
     * returned by the describe volume or create volume API.
     * 
     * @param encrypted
     *            Boolean value. <br>
     *            <tt>true</tt> if the volume is encrypted, <tt>false</tt>
     *            otherwise.
     */
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * This method is used to set <tt>encrypted</tt> field in Volume object as
     * returned by the describe volume or create volume API and then returns the
     * modified Volume object.
     * 
     * @param encrypted
     *            Boolean value. <br>
     *            <tt>true</tt> if the volume is encrypted, <tt>false</tt>
     *            otherwise.
     * @return Modified Volume object.
     */
    public Volume withEncryption(Boolean encrypted) {
        setEncrypted(encrypted);
        return this;
    }

    /**
     * Returns the current status of the volume.
     * 
     * @return Current status of volume as returned by describe volume or create
     *         volume API. Possible values are: creating and available.
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the current status of volume in Volume object.
     * 
     * @param status
     *            Current status of volume as returned by describe volume or
     *            create volume API. Possible values are: creating and
     *            available.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method sets the current status of volume in Volume object and
     * returns the modified Volume object.
     * 
     * @param status
     *            Current status of volume as returned by describe volume or
     *            create volume API. Possible values are: creating and
     *            available.
     * @return Modified Volume object.
     */
    public Volume withStatus(String status) {
        setStatus(status);
        return this;
    }

    /**
     * @return An enum value representing the type of volume. Possible values
     *         are <tt>standard (or HDD)</tt> and <tt>SSD</tt>.
     */
    public VolumeType getVolumeType() {
        return volumeType;
    }

    /**
     * This method sets VolumeType in Volume object. Possible values are
     * <tt>standard (or HDD)</tt> and <tt>SSD</tt>.
     * 
     * @param volumeType
     *            An enum value representing the type of volume.
     */
    public void setVolumeType(VolumeType volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * This method sets VolumeType in Volume object and returns the modified
     * object. Possible values are <tt>standard (or HDD)</tt> and <tt>SSD</tt>.
     * 
     * @param volumeType
     *            An enum value representing the type of volume.
     * @return Modified Volume object.
     */
    public Volume withVolumeType(VolumeType volumeType) {
        setVolumeType(volumeType);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getVolumeId() != null)
            sb.append("VolumeId: " + getVolumeId() + ",");
        if (getSize() != null)
            sb.append("Size: " + getSize() + ",");
        if (getSnapshotId() != null)
            sb.append("SnapshotId: " + getSnapshotId() + ",");
        if (getEncrypted() != null)
            sb.append("Encrypted: " + getEncrypted() + ",");
        if (getVolumeType() != null)
            sb.append("VolumeType: " + getVolumeType() + ",");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof Volume == false)
            return false;
        Volume other = (Volume) obj;
        if (other.getVolumeId() == null ^ this.getVolumeId() == null)
            return false;
        if (other.getVolumeId() != null && other.getVolumeId().equals(this.getVolumeId()) == false)
            return false;
        if (other.getSize() == null ^ this.getSize() == null)
            return false;
        if (other.getSize() != null && other.getSize().equals(this.getSize()) == false)
            return false;
        if (other.getSnapshotId() == null ^ this.getSnapshotId() == null)
            return false;
        if (other.getSnapshotId() != null && other.getSnapshotId().equals(this.getSnapshotId()) == false)
            return false;
        if (other.getEncrypted() == null ^ this.getEncrypted() == null)
            return false;
        if (other.getEncrypted() ^ this.getEncrypted())
            return false;

        if (other.getVolumeType() == null ^ this.getVolumeType() == null)
            return false;

        if (other.getVolumeType() != this.getVolumeType())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getVolumeId() == null) ? 0 : getVolumeId().hashCode());
        hashCode = prime * hashCode + ((getSize() == null) ? 0 : getSize().hashCode());
        hashCode = prime * hashCode + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        hashCode = prime * hashCode + ((getEncrypted() == null) ? 0 : getEncrypted().hashCode());
        hashCode = prime * hashCode + ((getVolumeType() == null) ? 0 : getVolumeType().hashCode());

        return hashCode;
    }

    @Override
    public Volume clone() {
        try {
            return (Volume) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }

}