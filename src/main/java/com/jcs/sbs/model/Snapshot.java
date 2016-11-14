package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.Gson;

/**
 * Model class for a <b>snapshot</b>. It contains all the fields that will be present in
 * each snapshot item of XML response of describe snapshots API.
 */
public class Snapshot implements Serializable, Cloneable{
    
    private static final long serialVersionUID = 8659058244550662667L;

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
        return new Gson().toJson(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((encrypted == null) ? 0 : encrypted.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((snapshotId == null) ? 0 : snapshotId.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((volumeId == null) ? 0 : volumeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Snapshot other = (Snapshot) obj;
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
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
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
    public Volume clone() {
        try {
            return (Volume) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

}
