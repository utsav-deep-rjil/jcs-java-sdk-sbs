package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeSnapshotsRequest extends JCSRequest implements
        Serializable, Cloneable{

	private static final long serialVersionUID = -8253751214720562856L;

	private List<String> snapshotIds;
 
    private String nextToken;
 
    private Integer maxResults;

    
    public DescribeSnapshotsRequest() {
    }

    /**
     * @param snapshotsIds
     */
    public DescribeSnapshotsRequest(List<String> snapshotsIds) {
        setSnapshotIds(snapshotIds);
    }


    /**
     * @return
     */
    public List<String> getSnapshotIds() {
        if (snapshotIds == null) {
            snapshotIds = new ArrayList<String>();
        }
        return snapshotIds;
    }

    /**
     * @param snapshotIds
     */
    public void setSnapshotIds(Collection<String> snapshotIds) {
        if (snapshotIds == null) {
            this.snapshotIds = null;
            return;
        }

        this.snapshotIds = new ArrayList<String>(
        		snapshotIds);
    }

    /**
     * @param snapshotIds
     * @return
     */
    public DescribeSnapshotsRequest withSnapshotIds(String... snapshotIds) {
        if (this.snapshotIds == null) {
            setSnapshotIds(new ArrayList<String>(
            		snapshotIds.length));
        }
        for (String ele : snapshotIds) {
            this.snapshotIds.add(ele);
        }
        return this;
    }

    /**
     * @param snapshotIds
     * @return
     */
    public DescribeSnapshotsRequest withSnapshotIds(Collection<String> snapshotIds) {
        setSnapshotIds(snapshotIds);
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
    public DescribeSnapshotsRequest withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * @param maxResults
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * @return
     */
    public Integer getMaxResults() {
        return this.maxResults;
    }

    /**
     * @param maxResults
     * @return
     */
    public DescribeSnapshotsRequest withMaxResults(Integer maxResults) {
        setMaxResults(maxResults);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSnapshotIds() != null)
            sb.append("SnapshotIds: " + getSnapshotIds() + ",");
        if (getNextToken() != null)
            sb.append("NextToken: " + getNextToken() + ",");
        if (getMaxResults() != null)
            sb.append("MaxResults: " + getMaxResults());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof DescribeSnapshotsRequest == false)
            return false;
        DescribeSnapshotsRequest other = (DescribeSnapshotsRequest) obj;
        if (other.getSnapshotIds() == null ^ this.getSnapshotIds() == null)
            return false;
        if (other.getSnapshotIds() != null
                && other.getSnapshotIds().equals(this.getSnapshotIds()) == false)
            return false;
        if (other.getNextToken() == null ^ this.getNextToken() == null)
            return false;
        if (other.getNextToken() != null
                && other.getNextToken().equals(this.getNextToken()) == false)
            return false;
        if (other.getMaxResults() == null ^ this.getMaxResults() == null)
            return false;
        if (other.getMaxResults() != null
                && other.getMaxResults().equals(this.getMaxResults()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode
                + ((getSnapshotIds() == null) ? 0 : getSnapshotIds().hashCode());
        hashCode = prime * hashCode
                + ((getNextToken() == null) ? 0 : getNextToken().hashCode());
        hashCode = prime * hashCode
                + ((getMaxResults() == null) ? 0 : getMaxResults().hashCode());
        return hashCode;
    }

    @Override
    public DescribeSnapshotsRequest clone() throws CloneNotSupportedException {
        return (DescribeSnapshotsRequest) super.clone();
    }
}