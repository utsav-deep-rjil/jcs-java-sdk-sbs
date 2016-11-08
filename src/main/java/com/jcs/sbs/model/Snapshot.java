package com.jcs.sbs.model;

import java.util.Date;

/**
 * Model class for a <b>snapshot</b>. It contains all the fields that will be present in
 * each snapshot item of XML response of describe snapshots API.
 */
public class Snapshot {
    private String volumeId;

    private Integer size;

    private String snapshotId;

    private Date startTime;

    private String status;

    private Boolean encrypted;

    /**
     * Default constructor for Snapshot object.
     */
    public Snapshot() {
    }

    /**
     * This method sets the volumeId in Snapshot object.
     * 
     * @param volumeId
     *            ID of the volume from which the snapshot is created
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    /**
     * Returns volume ID from which snapshot is to be created.
     * 
     * @return ID of the volume from which the snapshot is created
     */
    public String getVolumeId() {
        return this.volumeId;
    }

    /**
     * This method sets the volumeId in Snapshot object and returns the modified
     * Snapshot object.
     * 
     * @param volumeId
     *            ID of the volume from which the snapshot is created
     * @return Modified Snapshot object.
     */
    public Snapshot withVolumeId(String volumeId) {
        setVolumeId(volumeId);
        return this;
    }

    /**
     * This method sets the size of volume from which snapshot is created.
     * 
     * @param size
     *            Size of the volume from which snapshot is created.
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return Size of the volume from which snapshot is created.
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * This method sets the size of volume from which snapshot is created and
     * returns the modified Snapshot object.
     * 
     * @param size
     *            Size of the volume from which snapshot is created.
     * @return Modified Snapshot object.
     */
    public Snapshot withSize(Integer size) {
        setSize(size);
        return this;
    }

    /**
     * This method sets the snapshotId, which is unique identifier for any
     * snapshot, in the Snapshot object.
     * 
     * @param snapshotId
     *            The snapshotId returned by create snapshot or describe
     *            snapshot API.
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * Returns ID of the snapshot.
     * 
     * @return The snapshotId returned by create snapshot or describe snapshot
     *         API.
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * This method sets the snapshotId, which is unique identifier for any
     * snapshot, in the Snapshot object and returns the modified Snapshot
     * object.
     * 
     * @param snapshotId
     *            The snapshotId returned by create snapshot or describe
     *            snapshot API.
     * @return Modified Snapshot object.
     */
    public Snapshot withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    /**
     * This method sets the date and time at which snapshot was created in
     * <tt>startTime</tt> field of Snapshot object.
     * 
     * @param startTime
     *            Date and time at which snapshot was created.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Returns Date object containing date and time at which snapshot was
     * created.
     * 
     * @return Date and time at which snapshot was created.
     */
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * This method sets the date and time at which snapshot was created in
     * <tt>startTime</tt> field of Snapshot object and returns the modified
     * Snapshot object.
     * 
     * @param startTime
     *            Date and time at which snapshot was created.
     * @return Modified Snapshot object
     */
    public Snapshot withStartTime(Date startTime) {
        setStartTime(startTime);
        return this;
    }

    /**
     * Returns current status of the snapshot.
     * 
     * @return Current status of snapshot as returned by describe snapshot or
     *         create snapshot API. Possible values are: pending, completed,
     *         error.
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the current status of snapshot in Snapshot object.
     * 
     * @param status
     *            Current status of snapshot as returned by describe snapshot or
     *            create snapshot API. Possible values are: pending, completed,
     *            error.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method sets the current status of snapshot in Snapshot object and
     * returns the modified Snapshot object.
     * 
     * @param status
     *            Current status of snapshot as returned by describe snapshot or
     *            create snapshot API. Possible values are: pending, completed,
     *            error.
     *
     * @return Modified Snapshot object.
     */
    public Snapshot withStatus(String status) {
        setStatus(status);
        return this;
    }

    /**
     * Specifies whether the snapshot is encrypted or not encrypted. Returns the
     * value true if the snapshot is encrypted. Returns the value false if the
     * snapshot is not encrypted.
     * 
     * @return Boolean value. <br>
     *         <tt>true</tt> if the snapshot is encrypted, <tt>false</tt>
     *         otherwise.
     */
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * This method is used to set <tt>encrypted</tt> field in Snapshot object as
     * returned by the describe snapshot or create snapshot API.
     * 
     * @param encrypted
     *            Boolean value. <br>
     *            <tt>true</tt> if the snapshot is encrypted, <tt>false</tt>
     *            otherwise.
     */
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * This method is used to set <tt>encrypted</tt> field in Snapshot object as
     * returned by the describe snapshot or create snapshot API and then returns
     * the modified Snapshot object.
     * 
     * @param encrypted
     *            Boolean value. <br>
     *            <tt>true</tt> if the snapshot is encrypted, <tt>false</tt>
     *            otherwise.
     * @return Modified Snapshot object.
     */
    public Snapshot withEncryption(Boolean encrypted) {
        setEncrypted(encrypted);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSnapshotId() != null)
            sb.append("SnapshotId: " + getSnapshotId() + ",");

        if (getVolumeId() != null)
            sb.append("VolumeId: " + getVolumeId() + ",");
        if (getSize() != null)
            sb.append("Size: " + getSize() + ",");
        if (getEncrypted() != null)
            sb.append("Encrypted: " + getEncrypted() + ",");
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
        if (other.getSnapshotId() == null ^ this.getSnapshotId() == null)
            return false;
        if (other.getSnapshotId() != null && other.getSnapshotId().equals(this.getSnapshotId()) == false)
            return false;
        if (other.getVolumeId() == null ^ this.getVolumeId() == null)
            return false;
        if (other.getVolumeId() != null && other.getVolumeId().equals(this.getVolumeId()) == false)
            return false;
        if (other.getSize() == null ^ this.getSize() == null)
            return false;
        if (other.getSize() != null && other.getSize().equals(this.getSize()) == false)
            return false;
        if (other.getEncrypted() == null ^ this.getEncrypted() == null)
            return false;
        if (other.getEncrypted() ^ this.getEncrypted())
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        hashCode = prime * hashCode + ((getVolumeId() == null) ? 0 : getVolumeId().hashCode());
        hashCode = prime * hashCode + ((getSize() == null) ? 0 : getSize().hashCode());
        hashCode = prime * hashCode + ((getEncrypted() == null) ? 0 : getEncrypted().hashCode());

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
