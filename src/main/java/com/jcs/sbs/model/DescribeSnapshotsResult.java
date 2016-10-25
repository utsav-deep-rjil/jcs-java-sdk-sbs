package com.jcs.sbs.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSnapshotsResult extends JCSResult implements Serializable, Cloneable {

	private static final long serialVersionUID = 1559504024117330599L;

	private List<Snapshot> snapshots;
    
    private String nextToken;

    /**
     * @return
     */
    public List<Snapshot> getSnapshots() {
        if (snapshots == null) {
        	snapshots = new ArrayList<Snapshot>();
        }
        return snapshots;
    }

    /**
     * @param snapshots
     */
    public void setSnapshots(Collection<Snapshot> snapshots) {
        if (snapshots == null) {
            this.snapshots = null;
            return;
        }

        this.snapshots = new ArrayList<Snapshot>(
        		snapshots);
    }

    /**
     * @param snapshots
     * @return
     */
    public DescribeSnapshotsResult withSnapshots(Snapshot... snapshots) {
        if (this.snapshots == null) {
            setSnapshots(new ArrayList<Snapshot>(
                    snapshots.length));
        }
        for (Snapshot ele : snapshots) {
            this.snapshots.add(ele);
        }
        return this;
    }

    /**
     * @param snapshots
     * @return
     */
    public DescribeSnapshotsResult withSnapshots(
            Collection<Snapshot> snapshots) {
        setSnapshots(snapshots);
        return this;
    }

    /**
     * @param nextToken
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * @return
     */
    public String getNextToken() {
        return this.nextToken;
    }

    /**
     * @param nextToken
     * @return
     */
    public DescribeSnapshotsResult withNextToken(String nextToken) {
        setNextToken(nextToken);
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

        if (obj instanceof DescribeSnapshotsResult == false)
            return false;
        DescribeSnapshotsResult other = (DescribeSnapshotsResult) obj;
        if (other.getSnapshots() == null ^ this.getSnapshots() == null)
            return false;
        if (other.getSnapshots() != null
                && other.getSnapshots().equals(this.getSnapshots()) == false)
            return false;
        if (other.getNextToken() == null ^ this.getNextToken() == null)
            return false;
        if (other.getNextToken() != null
                && other.getNextToken().equals(this.getNextToken()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getSnapshots() == null) ? 0 : getSnapshots().hashCode());
        hashCode = prime * hashCode
                + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        return hashCode;
    }

    @Override
    public DescribeSnapshotsResult clone() {
        try {
            return (DescribeSnapshotsResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!", e);
        }
    }
}