package com.jcs.sbs.model;
import java.io.Serializable;

/**
 *Result class for create snapshot operation 
 *
 */
public class CreateSnapshotResult extends JCSResult implements Serializable, Cloneable {

	private static final long serialVersionUID = -2051402111070113334L;
	
	private Snapshot snapshot;

    public CreateSnapshotResult(){
    	
    }
    

    /**
     * This method is used internally in JCSComputeClient class to set the snapshot object
     * 
     * @param snapshot - The object of the snapshot that is created
     */
    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }

    

    /**
     * @return The object of the snapshot that is created
     */
    public Snapshot getSnapshot() {
        return this.snapshot;
    }

    

    /**
     * This method adds the snapshot object, passed as the argument, in the object of CreateSnapshotResult object returns the modified object
     * 
     * @param snapshot The snapshot object that is to be added in CreateSnapshotResult object
     * @return Modified object of CreateSnapshotResult
     */
    public CreateSnapshotResult withSnapshot(Snapshot snapshot) {
        setSnapshot(snapshot);
        return this;
    }

    
    @Override
    public String toString() {
    	return this.getXml();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof CreateSnapshotResult == false)
            return false;
        CreateSnapshotResult other = (CreateSnapshotResult) obj;
        if (other.getSnapshot() == null ^ this.getSnapshot() == null)
            return false;
        if (other.getSnapshot() != null
                && other.getSnapshot().equals(this.getSnapshot()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getSnapshot() == null) ? 0 : getSnapshot().hashCode());
        return hashCode;
    }

    @Override
    public CreateSnapshotResult clone() {
        try {
            return (CreateSnapshotResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}