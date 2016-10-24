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
    
    private Boolean detail;
    
    public DescribeSnapshotsRequest() {
    }

    /**
     * @param snapshotsIds Optional field. These are the IDs of the snapshots that is to be described.
     */
    public DescribeSnapshotsRequest(List<String> snapshotsIds) {
        setSnapshotIds(snapshotIds);
    }


    /**
     * This method returns the IDs of the snapshots that is to be described.
     * @return List of snapshotIds
     */
    public List<String> getSnapshotIds() {
        if (snapshotIds == null) {
            snapshotIds = new ArrayList<String>();
        }
        return snapshotIds;
    }

    /**
     * It sets the list of snapshot IDs that are to be described. To describe all the snapshots, there is no need to set snapshotIds
     * @param snapshotIds The IDs of the snapshot that are to be described.
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
     * This method sets the list of snapshot IDs, in DescribeSnapshotsRequest object, that are to be described
     * and returns the modified DescribeSnapshotsRequest object.
     * 
     * @param snapshotIds List of comma separated snapshot IDs that are to be described. It accepts variable number of arguments (each of type string) 
     * @return Modified DescribeSnapshotsRequest object.
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
     * This method sets the list of snapshot IDs, in DescribeSnapshotsRequest object, that are to be described
     * and returns the modified DescribeSnapshotsRequest object.
     * 
     * @param snapshotIds Collection of snapshot IDs that are to be described.
     * @return Modified DescribeSnapshotsRequest object.
     */
    public DescribeSnapshotsRequest withSnapshotIds(Collection<String> snapshotIds) {
        setSnapshotIds(snapshotIds);
        return this;
    }

	/**
	 * If the describeSnapshot() method was called with a MaxResults option, all items would not have
	 * been returned. To get next set of items, specify the Id of the last seen
	 * item from the previous call. The describeSnapshot() will return the next set of items
	 * after this Id.
	 * 
	 * This method sets the given ID of last snapshot in the list of snapshots in DescribeSnapshotResult object of previous call of describeSnapshot() method.
	 * 
	 * @param nextToken The ID of last snapshot that was returned by the describeSnapshot() method
	 */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
	 * If the describeSnapshot() method was called with a MaxResults option, all items would not have
	 * been returned. To get next set of items, specify the Id of the last seen
	 * item from the previous call. The describeSnapshot() will return the next set of items
	 * after this Id.
	 * 
	 * 
     * @return The value of the nextToken (i.e., the ID of last snapshot obtained from previous call of describeSnapshot() method) if it is set.
     */
    public String getNextToken() {
        return this.nextToken;
    }

    /**
	 * If the describeSnapshot() method was called with a MaxResults option, all items would not have
	 * been returned. To get next set of items, specify the Id of the last seen
	 * item from the previous call. The describeSnapshot() will return the next set of items
	 * after this Id.
	 * 
	 * This method sets the given ID of last snapshot obtained from previous call of describeSnapshot() method and then returns the modified DescribeSnapshotsRequest object.
	 * 
	 * @param nextToken The ID of last snapshot that was returned by the describeSnapshot() method
     * @return The modified DescribeSnapshotsRequest object 
     */
    public DescribeSnapshotsRequest withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * It sets, in DescribeSnapshotsRequest object, the number of items to be fetched from describeSnapshots() method.
     * @param maxResults The maximum number of items (snapshots) to be fetched.
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * @return If maxResults value is set, this method returns maximum number of items (snapshots) to be fetched.
     */
    public Integer getMaxResults() {
        return this.maxResults;
    }

    /**
     * It sets, in DescribeSnapshotsRequest object, the number of items to be fetched from describeSnapshots() method
     * and then returns the modified DescribeSnapshotsRequest object.
     * @param maxResults The maximum number of items (snapshots) to be fetched.
     * @return The modified DescribeSnapshotsRequest object with 'maxResults' set to given value.
     */
    public DescribeSnapshotsRequest withMaxResults(Integer maxResults) {
        setMaxResults(maxResults);
        return this;
    }
    
    /**
     * @return Value of 'detail' field of DescribeSnapshotsRequest object.
     *  If true, the describeSnapshot() method will describe the snapshots in detail.
     */
    public Boolean getDetail() {
		return detail;
	}

	/**
	 * @param detail Sets the value of 'detail' field of DescribeSnapshotsRequest object.
	 * If it is set true, then the describeSnapshot() method will describe the snapshots in detail.
	 */
	public void setDetail(Boolean detail) {
		this.detail = detail;
	}

	/**
	 * @param detail Sets the value of 'detail' field of DescribeSnapshotsRequest object.
	 * If it is set true, then the describeSnapshot() method will describe the snapshots in detail.
	 * @return Modified DescribeSnapshotsRequest object.
	 */
	public DescribeSnapshotsRequest withDetail(Boolean detail) {
        setDetail(detail);
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