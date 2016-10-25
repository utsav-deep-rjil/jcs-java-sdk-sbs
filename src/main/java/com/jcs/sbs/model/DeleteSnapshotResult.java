package com.jcs.sbs.model;

import java.io.Serializable;

public class DeleteSnapshotResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = -5670232468998211566L;

    @Override
    public String toString() {
        return this.getXml();
    }

    @Override
    public DeleteSnapshotResult clone() {
        try {
            return (DeleteSnapshotResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}