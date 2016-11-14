package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.Gson;

/**
 * Request class for describe snapshots operation.
 */
public class DescribeSnapshotsRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = -8253751214720562856L;

    private List<String> snapshotIds = new ArrayList<String>();

    private String nextToken;

    private Integer maxResults;

    private Boolean detail;

    /**
     * Default constructor for DescribeSnapshotsRequest object.
     */
    public DescribeSnapshotsRequest() {
    }

    /**
     * Creates an object of DescribeSnapshotsRequest with given list of snapshot
     * IDs.
     * 
     * @param snapshotsIds
     *            Optional field. These are the IDs of the snapshots that is to
     *            be described.
     */
    public DescribeSnapshotsRequest(List<String> snapshotsIds) {
        setSnapshotIds(snapshotIds);
    }

    /**
     * Returns the IDs of the snapshots that is to be described.
     * 
     * @return List of snapshotIds
     */
    public List<String> getSnapshotIds() {
        return snapshotIds;
    }

    /**
     * Sets the list of snapshot IDs that are to be described. To describe all
     * the snapshots, there is no need to set snapshotIds
     * 
     * @param snapshotIds
     *            The IDs of the snapshot that are to be described.
     */
    public void setSnapshotIds(Collection<String> snapshotIds) {
        /*
         * If snapshotIds is null then reset this.snapshotIds to new ArrayList,
         * otherwise this.snapshotIds may contain older values.
         * 
         * Trying to set null value means trying to clear previously set snapshotIds.
         */
        if (snapshotIds == null) {
            this.snapshotIds = new ArrayList<String>();
            return;
        }

        this.snapshotIds = new ArrayList<String>(snapshotIds);
    }

    /**
     * Sets the list of snapshot IDs, in DescribeSnapshotsRequest object, that
     * are to be described and returns the modified DescribeSnapshotsRequest
     * object.
     * 
     * @param snapshotIds
     *            List of comma separated snapshot IDs that are to be described.
     *            It accepts variable number of arguments (each of type string)
     * @return Modified DescribeSnapshotsRequest object.
     */
    public DescribeSnapshotsRequest withSnapshotIds(String... snapshotIds) {
        List<String> newSnapshotIds = new ArrayList<String>();
        for (String snapshotId : snapshotIds) {
            if (null != snapshotId) {
                newSnapshotIds.add(snapshotId);
            }
        }
        this.snapshotIds = newSnapshotIds;
        return this;
    }

    /**
     * Sets the list of snapshot IDs, in DescribeSnapshotsRequest object, that
     * are to be described and returns the modified DescribeSnapshotsRequest
     * object.
     * 
     * @param snapshotIds
     *            Collection of snapshot IDs that are to be described.
     * @return Modified DescribeSnapshotsRequest object.
     */
    public DescribeSnapshotsRequest withSnapshotIds(Collection<String> snapshotIds) {
        setSnapshotIds(snapshotIds);
        return this;
    }

    /**
     * If the describeSnapshots() method was called with a MaxResults option,
     * all items would not have been returned. So, the previous call of
     * describeSnapshots() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeSnapshots() will return the next set of items after this Id
     * and the new value of 'nextToken'
     * 
     * This method sets the given ID of last snapshot in the list of snapshots
     * in DescribeSnapshotResult object of previous call of describeSnapshots()
     * method.
     * 
     * @param nextToken
     *            The ID of last snapshot that was returned by the
     *            describeSnapshot() method
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * If the describeSnapshots() method was called with a MaxResults option,
     * all items would not have been returned. So, the previous call of
     * describeSnapshots() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeSnapshots() will return the next set of items after this Id
     * and the new value of 'nextToken'
     * 
     * 
     * @return The value of the nextToken (i.e., the ID of last snapshot
     *         obtained from previous call of describeSnapshots() method) if it
     *         is set.
     */
    public String getNextToken() {
        return this.nextToken;
    }

    /**
     * If the describeSnapshots() method was called with a MaxResults option,
     * all items would not have been returned. So, the previous call of
     * describeSnapshots() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeSnapshots() will return the next set of items after this Id
     * and the new value of 'nextToken'
     * 
     * This method sets the given ID of last snapshot obtained from previous
     * call of describeSnapshots() method and then returns the modified
     * DescribeSnapshotsRequest object.
     * 
     * @param nextToken
     *            The ID of last snapshot that was returned by the
     *            describeSnapshots() method
     * @return The modified DescribeSnapshotsRequest object
     */
    public DescribeSnapshotsRequest withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * It sets, in DescribeSnapshotsRequest object, the number of items to be
     * fetched from describeSnapshots() method.
     * 
     * @param maxResults
     *            The maximum number of items (snapshots) to be fetched.
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Returns maximum number of items (snapshots) to be fetched.
     * 
     * @return maxResults value if it is set.
     */
    public Integer getMaxResults() {
        return this.maxResults;
    }

    /**
     * It sets, in DescribeSnapshotsRequest object, the number of items to be
     * fetched from describeSnapshots() method and then returns the modified
     * DescribeSnapshotsRequest object.
     * 
     * @param maxResults
     *            The maximum number of items (snapshots) to be fetched.
     * @return The modified DescribeSnapshotsRequest object with 'maxResults'
     *         set to given value.
     */
    public DescribeSnapshotsRequest withMaxResults(Integer maxResults) {
        setMaxResults(maxResults);
        return this;
    }

    /**
     * Returns a boolean value that tells if details will be shown or not.
     * 
     * @return Value of 'detail' field of DescribeSnapshotsRequest object. If
     *         true, the describeSnapshot() method will describe the snapshots
     *         in detail.
     */
    public Boolean getDetail() {
        return detail;
    }

    /**
     * Set true/false to get result with/without details respectively.
     * 
     * @param detail
     *            Sets the value of 'detail' field of DescribeSnapshotsRequest
     *            object. If it is set true, then the describeSnapshot() method
     *            will describe the snapshots in detail.
     */
    public void setDetail(Boolean detail) {
        this.detail = detail;
    }

    /**
     * Set true/false to get result with/without details respectively. It also
     * returns the modified DescribeSnapshotsRequest object.
     * 
     * @param detail
     *            Sets the value of 'detail' field of DescribeSnapshotsRequest
     *            object. If it is set true, then the describeSnapshot() method
     *            will describe the snapshots in detail.
     * @return Modified DescribeSnapshotsRequest object.
     */
    public DescribeSnapshotsRequest withDetail(Boolean detail) {
        setDetail(detail);
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + ((maxResults == null) ? 0 : maxResults.hashCode());
        result = prime * result + ((nextToken == null) ? 0 : nextToken.hashCode());
        result = prime * result + ((snapshotIds == null) ? 0 : snapshotIds.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DescribeSnapshotsRequest other = (DescribeSnapshotsRequest) obj;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (maxResults == null) {
            if (other.maxResults != null)
                return false;
        } else if (!maxResults.equals(other.maxResults))
            return false;
        if (nextToken == null) {
            if (other.nextToken != null)
                return false;
        } else if (!nextToken.equals(other.nextToken))
            return false;
        if (snapshotIds == null) {
            if (other.snapshotIds != null)
                return false;
        } else if (!snapshotIds.equals(other.snapshotIds))
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DescribeSnapshotsRequest clone() {
        try {
            return (DescribeSnapshotsRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}