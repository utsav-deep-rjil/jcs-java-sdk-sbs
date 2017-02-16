package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

/**
 * Model class for a <b>volume</b>. It contains all the fields that will be
 * present in each volume item of XML response of describe volumes API.
 */
public class Volume implements Serializable, Cloneable {

    private static final long serialVersionUID = -2799552718629746851L;

    private String volumeId;

    private Integer size;

    private String volumeType;

    private String snapshotId;

    private Boolean encrypted;

    private Date createTime;

    private String status;

    private List<Attachment> attachmentSet;

    /**
     * Default constructor for Volume object.
     */
    public Volume() {
    }

    /**
     * Sets the volumeId in Volume object, which is returned by describe volumes
     * or create volume API.
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
     * Sets the volumeId in Volume object, which is returned by describe volumes
     * or create volume API, and then returns the modified Volume object.
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
     * Sets the size of the volume (in GB) in Volume object.
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
     * Sets the size of the volume (in GB) in Volume object and returns the
     * modified Volume object.
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
     * If the Volume gets created from snapshot, this method can be used to set
     * the snapshotId of that snapshot.
     * 
     * @param snapshotId
     *            The ID of snapshot from which the volume gets created (if
     *            volume gets created from snapshot).
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * If volume gets created from a snapshot, it returns the Id of that
     * snapshot.
     * 
     * @return The ID of snapshot from which the volume gets created (if volume
     *         is created from snapshot).
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * If the Volume gets created from snapshot, this method can be also be used
     * to set the snapshotId of that snapshot. It also returns the modified
     * Volume object.
     * 
     * @param snapshotId
     *            The ID of snapshot from which the volume gets created (if
     *            volume gets created from snapshot).
     * @return Modified Volume object.
     */
    public Volume withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    /**
     * Sets the date and time at which the volume gets created.
     * 
     * @param createTime
     *            Date and time at which the volume gets created.
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * Returns Date object containing date and time at which the volume was
     * created.
     * 
     * @return Date and time at which the volume gets created.
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * Sets the date and time at which the volume gets created and returns the
     * modified Volume object.
     * 
     * @param createTime
     *            Date and time at which the volume gets created.
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
     * Sets <tt>encrypted</tt> field in Volume object as returned by the
     * describe volume or create volume API.
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
     * Sets <tt>encrypted</tt> field in Volume object as returned by the
     * describe volume or create volume API and then returns the modified Volume
     * object.
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
     * Sets the current status of volume in Volume object.
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
     * Sets the current status of volume in Volume object and returns the
     * modified Volume object.
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
     * @return A string value representing the type of volume. Possible values
     *         are <tt>standard (or HDD)</tt> and <tt>ms1 (or SSD)</tt>.
     */
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * Sets volumeType in Volume object. Possible values are
     * <tt>standard (or HDD)</tt> and <tt>ms1 (or SSD)</tt>.
     * 
     * @param volumeType
     *            An enum value representing the type of volume.
     */
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * Sets volumeType in Volume object and returns the modified object.
     * Possible values are <tt>standard (or HDD)</tt> and <tt>ms1 (or SSD)</tt>.
     * 
     * @param volumeType
     *            An enum value representing the type of volume.
     * @return Modified Volume object.
     */
    public Volume withVolumeType(String volumeType) {
        setVolumeType(volumeType);
        return this;
    }

    /**
     * Returns a list of {@link com.jcs.sbs.model.Attachment Attachment}
     * objects, which indicates the list of devices attached to this volume.
     * 
     * @return List of {@link com.jcs.sbs.model.Attachment Attachment} objects.
     */
    public List<Attachment> getAttachmentSet() {
        return attachmentSet;
    }

    /**
     * Sets the list of {@link com.jcs.sbs.model.Attachment Attachment} objects
     * in Volume object.
     * 
     * @param attachmentSet
     *            List of {@link com.jcs.sbs.model.Attachment Attachment}
     *            objects.
     */
    public void setAttachmentSet(List<Attachment> attachmentSet) {
        this.attachmentSet = attachmentSet;
    }

    /**
     * Sets the list of {@link com.jcs.sbs.model.Attachment Attachment} objects
     * in Volume object and returns the modified object.
     * 
     * @param attachmentSet
     *            List of {@link com.jcs.sbs.model.Attachment Attachment}
     *            objects.
     * @return Modified Volume object.
     */
    public Volume withAttachmentSet(List<Attachment> attachmentSet) {
        setAttachmentSet(attachmentSet);
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
        result = prime * result + ((attachmentSet == null) ? 0 : attachmentSet.hashCode());
        result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
        result = prime * result + ((encrypted == null) ? 0 : encrypted.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
        result = prime * result + ((snapshotId == null) ? 0 : snapshotId.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((volumeId == null) ? 0 : volumeId.hashCode());
        result = prime * result + ((volumeType == null) ? 0 : volumeType.hashCode());
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
        Volume other = (Volume) obj;
        if (attachmentSet == null) {
            if (other.attachmentSet != null)
                return false;
        } else if (!attachmentSet.equals(other.attachmentSet))
            return false;
        if (createTime == null) {
            if (other.createTime != null)
                return false;
        } else if (!createTime.equals(other.createTime))
            return false;
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
        if (volumeType != other.volumeType)
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