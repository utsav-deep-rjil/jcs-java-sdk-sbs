package com.jcs.sbs.model;

import java.io.Serializable;

/**
 * Result class for delete volume operation.
 */
public class DeleteVolumeResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = 5052351717850702143L;

    @Override
    public String toString() {
        return this.getXml();
    }

    @Override
    public DeleteVolumeResult clone() {
        try {
            return (DeleteVolumeResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}