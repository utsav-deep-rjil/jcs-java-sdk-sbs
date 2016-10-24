package com.jcs.sbs.model;

import java.io.Serializable;

public class CreateVolumeRequest extends JCSRequest implements Serializable, Cloneable {

	private static final long serialVersionUID = -2272230902337784644L;

	private Integer size;
	private String snapshotId;
	private Boolean encrypted;
	private VolumeType volumeType;

	public CreateVolumeRequest() {
	}

	/**
	 * @param size
	 */
	public CreateVolumeRequest(Integer size) {
		setSize(size);
	}

	/**
	 * @param snapshotId
	 */
	public CreateVolumeRequest(String snapshotId) {
		setSnapshotId(snapshotId);
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
	public CreateVolumeRequest withSize(Integer size) {
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
	public CreateVolumeRequest withSnapshotId(String snapshotId) {
		setSnapshotId(snapshotId);
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
	 * @return
	 */
	public CreateVolumeRequest withEncryption() {
		setEncrypted(true);
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
	public CreateVolumeRequest withVolumeType(VolumeType volumeType) {
		setVolumeType(volumeType);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
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

		if (obj instanceof CreateVolumeRequest == false)
			return false;
		CreateVolumeRequest other = (CreateVolumeRequest) obj;
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
		if (other.getEncrypted() ^ this.getEncrypted() == false)
			return false;
		if ((other.getVolumeType() == null ^ this.getVolumeType() == null)
				|| other.getVolumeType() != this.getVolumeType())
			return false;

		return true;
	}

}