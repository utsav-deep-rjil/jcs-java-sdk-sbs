package com.jcs.sbs.model;
import java.util.Date;


public class Snapshot {
	private String volumeId;

    private Integer size;

    private String snapshotId;

    private Date startTime;
    
    private String status;
    
    private Boolean encrypted;
    
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
    public Snapshot withVolumeId(String volumeId) {
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
    public Snapshot withSize(Integer size) {
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
    public Snapshot withSnapshotId(String snapshotId) {
        setSnapshotId(snapshotId);
        return this;
    }

    

    /**
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    
    /**
     * @return
     */
    public Date getStartTime() {
        return this.startTime;
    }

    

    /**
     * @param startTime
     * @return
     */
    public Snapshot withStartTime(Date startTime) {
        setStartTime(startTime);
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
	public Snapshot withStatus(String status) {
        setStatus(status);
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
        if (other.getSnapshotId() != null
                && other.getSnapshotId().equals(this.getSnapshotId()) == false)
            return false;
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

        hashCode = prime * hashCode
                + ((getSnapshotId() == null) ? 0 : getSnapshotId().hashCode());
        hashCode = prime * hashCode
                + ((getVolumeId() == null) ? 0 : getVolumeId().hashCode());
        hashCode = prime * hashCode
                + ((getSize() == null) ? 0 : getSize().hashCode());
        hashCode = prime * hashCode
                + ((getEncrypted() == null) ? 0 : getEncrypted().hashCode());
        
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
