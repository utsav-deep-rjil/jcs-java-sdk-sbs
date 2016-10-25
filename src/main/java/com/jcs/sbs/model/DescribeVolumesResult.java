package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeVolumesResult extends JCSResult implements Serializable, Cloneable {

    private static final long serialVersionUID = -3376670842859374348L;

    private List<Volume> volumes;

    private String nextToken;

    /**
     * @return
     */
    public List<Volume> getVolumes() {
        if (volumes == null) {
            volumes = new ArrayList<Volume>();
        }
        return volumes;
    }

    /**
     * @param volumes
     */
    public void setVolumes(Collection<Volume> volumes) {
        if (volumes == null) {
            this.volumes = null;
            return;
        }

        this.volumes = new ArrayList<Volume>(volumes);
    }

    /**
     * @param volumes
     * @return
     */
    public DescribeVolumesResult withVolumes(Volume... volumes) {
        if (this.volumes == null) {
            setVolumes(new ArrayList<Volume>(volumes.length));
        }
        for (Volume ele : volumes) {
            this.volumes.add(ele);
        }
        return this;
    }

    /**
     * @param volumes
     * @return
     */
    public DescribeVolumesResult withVolumes(Collection<Volume> volumes) {
        setVolumes(volumes);
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
    public DescribeVolumesResult withNextToken(String nextToken) {
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

        if (obj instanceof DescribeVolumesResult == false)
            return false;
        DescribeVolumesResult other = (DescribeVolumesResult) obj;
        if (other.getVolumes() == null ^ this.getVolumes() == null)
            return false;
        if (other.getVolumes() != null && other.getVolumes().equals(this.getVolumes()) == false)
            return false;
        if (other.getNextToken() == null ^ this.getNextToken() == null)
            return false;
        if (other.getNextToken() != null && other.getNextToken().equals(this.getNextToken()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getVolumes() == null) ? 0 : getVolumes().hashCode());
        hashCode = prime * hashCode + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        return hashCode;
    }

    @Override
    public DescribeVolumesResult clone() {
        try {
            return (DescribeVolumesResult) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() " + "even though we're Cloneable!", e);
        }
    }
}