package com.jcs.sbs.model;

import java.io.Serializable;

public enum VolumeType implements Serializable {
    standard("HDD"), SSD("SSD");
    private final String volumeType;

    private VolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    /**
     * @param volumeTypeString
     *            Its the string from which enum value is to be created.
     * @return an element of VolumeType enum value corresponding to the
     *         'volumeTypeString'
     * @throws IllegalArgumentException
     *             If 'volumeTypeString' doesn't matches with any of the valid
     *             VolumeType enum value
     */
    public static VolumeType fromValue(String volumeTypeString) throws IllegalArgumentException {
        for (VolumeType volumeType : VolumeType.values()) {
            if (volumeType.toString().equals(volumeTypeString))
                return volumeType;
        }

        throw new IllegalArgumentException("Cannot create enum from " + volumeTypeString + " value!");
    }

}
