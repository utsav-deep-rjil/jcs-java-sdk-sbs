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
     * @param volumeId
     */
    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }


    /**
     * @return
     */
    public String getVolumeId() {
        return this.volumeId;
    }


    /**
     * @param volumeId
     * @return
     */
    public Volume withVolumeId(String volumeId) {
        setVolumeId(volumeId);
        return this;
    }

    /**
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * @return
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * @param size
     * @return
     */
    public Volume withSize(Integer size) {
        setSize(size);
        return this;
    }

    /**
     * @param snapshotId
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    /**
     * @return
     */
    public String getSnapshotId() {
        return this.snapshotId;
    }

    /**
     * @param snapshotId
     * @return
     */
    public Volume withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * @return
     */
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
     * @param createTime
     * @return
     */
    public Volume withCreateTime(java.util.Date createTime) {
        setCreateTime(createTime);
        return this;
    }
    
    /**
     * @return
     */
    public Boolean getEncrypted() {
		return encrypted;
	}

	/**
	 * @param encrypted
	 */
	public void setEncrypted(Boolean encrypted) {
		this.encrypted = encrypted;
	}

	/**
	 * @param encrypted
	 * @return
	 */
	public Volume withEncryption(Boolean encrypted) {
		setEncrypted(encrypted);
		return this;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @param status
	 * @return
	 */
	public Volume withStatus(String status) {
        setStatus(status);
        return this;
    }
	
	
    
    /**
     * @return
     */
    public VolumeType getVolumeType() {
		return volumeType;
	}


	/**
	 * @param volumeType
	 */
	public void setVolumeType(VolumeType volumeType) {
		this.volumeType = volumeType;
	}
	/**
	 * @param volumeType
	 * @return
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
        if (other.getVolumeId() != null
                && other.getVolumeId().equals(this.getVolumeId()) == false)
            return false;
        if (other.getSize() == null ^ this.getSize() == null)
            return false;
        if (other.getSize() != null
                && other.getSize().equals(this.getSize()) == false)
            return false;
        if (other.getSnapshotId() == null ^ this.getSnapshotId() == null)
            return false;
        if (other.getSnapshotId() != null
                && other.getSnapshotId().equals(this.getSnapshotId()) == false)
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

        hashCode = prime * hashCode
                + ((getVolumeId() == null) ? 0 : getVolumeId().hashCode());
        hashCode = prime * hashCode
                + ((getSize() == null) ? 0 : getSize().hashCode());
        hashCode = prime * hashCode
                + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        hashCode = prime * hashCode
                + ((getEncrypted() == null) ? 0 : getEncrypted().hashCode());
        hashCode = prime * hashCode
                + ((getVolumeType() == null) ? 0 : getVolumeType().hashCode());
        
        return hashCode;
    }

    @Override
    public Volume clone() {
        try {
            return (Volume) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }

}