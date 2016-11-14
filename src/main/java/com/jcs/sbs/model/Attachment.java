package com.jcs.sbs.model;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * Model class for info of device to which volume is attached.
 */
public class Attachment implements Serializable, Cloneable {

    private static final long serialVersionUID = 4974108852214823666L;

    private String instanceId;
    private String device;

    /**
     * Default constructor for Attachment object
     */
    public Attachment() {
    }

    /**
     * Parameterized constructor for Attachment object. Used to construct
     * Attachment object with initialized fields.
     * 
     * @param instanceId
     *            Instance ID of the device in which the volume is attached.
     * @param device
     *            Device identifier, with its path, to which this volume is
     *            attached.
     */
    public Attachment(String instanceId, String device) {
        super();
        this.instanceId = instanceId;
        this.device = device;
    }

    /**
     * Returns the instanceId of the device to which the volume is attached.
     * 
     * @return Instance ID of the device in which the volume is attached.
     */
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the instanceId of the device to which the volume is attached.
     * 
     * @param instanceId
     *            Instance ID of the device in which the volume is attached.
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * Returns the device identifier with its path. For example: /dev/vda
     * 
     * @return The device identifier with its path.
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the device identifier with its path. For example: /dev/vda.
     * 
     * @param device
     *            The device identifier with its path. For example: /dev/vda.
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * Returns the string representation of this object. Helpful for debugging
     * purposes.
     */
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * Returns a hash code value for the object.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((device == null) ? 0 : device.hashCode());
        result = prime * result + ((instanceId == null) ? 0 : instanceId.hashCode());
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Attachment other = (Attachment) obj;
        if (device == null) {
            if (other.device != null)
                return false;
        } else if (!device.equals(other.device))
            return false;
        if (instanceId == null) {
            if (other.instanceId != null)
                return false;
        } else if (!instanceId.equals(other.instanceId))
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Attachment clone() {
        try {
            return (Attachment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

}
