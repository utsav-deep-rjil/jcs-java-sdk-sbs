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
	 * This constructor can be used to create an object of CreateVolumeRequest if the volume is to be created from a snapshot
	 * 
	 * @param snapshotId The ID of the snapshot from which the volume is to be created
	 */
	public CreateVolumeRequest(String snapshotId) {
		setSnapshotId(snapshotId);
	}

	/**
	 * This method sets the size of the volume that is to be created. Volume size is a required field for creating a volume
	 * 
	 * @param size The size of the volume that is to be created
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return The integer size of volume that is to be created
	 */
	public Integer getSize() {
		return this.size;
	}

	/**
	 * This method sets the volume size to the CreateVolumeRequest object and returns the modified object.
	 * @param size Size of the volume that is to be created
	 * @return Modified object of CreateVolumeRequest
	 */
	public CreateVolumeRequest withSize(Integer size) {
		setSize(size);
		return this;
	}

	/**
	 * This method can be used to set the snapshotId in CreateVolumeRequest if the volume is to be created from snapshot
	 * 
	 * @param snapshotId The ID of the snapshot from which volume is to be created
	 */
	public void setSnapshotId(String snapshotId) {
		this.snapshotId = snapshotId;
	}

	/**
	 * @return The snapshotId if it is set
	 */
	public String getSnapshotId() {
		return this.snapshotId;
	}

	/**
	 * This method can be used to set the snapshotId in CreateVolumeRequest if the volume is to be created from snapshot
	 * 
	 * @param snapshotId The ID of the snapshot from which volume is to be created
	 * @return Modified object of CreateVolumeRequest
	 */
	public CreateVolumeRequest withSnapshotId(String snapshotId) {
		setSnapshotId(snapshotId);
		return this;
	}

	/**
	 * This method tells if the volume after creation will be encrypted or not
	 * @return Boolean value; true if volume will be encrypted after encryption 
	 */
	public Boolean getEncrypted() {
		return encrypted;
	}

	/**
	 * This method can be used to create encrypted volume. If 'encrypted' is set to true, the created volume will be encrypted otherwise plain-text
	 * @param encrypted Boolean value to be set to 'encrypted' variable of the CreateVolumeRequest object
	 */
	public void setEncrypted(Boolean encrypted) {
		this.encrypted = encrypted;
	}

	/**
	 * This method can be used to create encrypted volume
	 * @return Modified object of CreateVolumeRequest with 'encrypted' set to true
	 */
	public CreateVolumeRequest withEncryption() {
		setEncrypted(true);
		return this;
	}

	/**
	 * Returns the type of the volume that will be created 
	 * @return an enum value of type VolumeType
	 */
	public VolumeType getVolumeType() {
		return volumeType;
	}

	/**
	 * This method can be used to set the type of volume, standard(HDD) or SSD, that is to be created.
	 * If volumeType is not specified, the created volume will be of type standard.
	 * 
	 * @param volumeType Enum value of type VolumeType. Possible values in the enum are standard(HDD) or SSD(SSD)
	 */
	public void setVolumeType(VolumeType volumeType) {
		this.volumeType = volumeType;
	}

	/**
	 * This method can also be used for setting the volume type before creating the volume.
	 * It sets the value of volumeType field in the object of CreateVolumeRequest and returns the modified object.
	 * 
	 * @param volumeType Enum value of type VolumeType. Possible values in the enum are standard(HDD) or SSD(SSD)
	 * @return Modified CreateVolumeRequest object
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