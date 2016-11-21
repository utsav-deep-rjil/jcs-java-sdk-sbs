package com.jcs.sbs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

/**
 * Request class for describe volumes operation.
 */
public class DescribeVolumesRequest extends JCSRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = -710530726380217842L;

    private List<String> volumeIds = new ArrayList<String>();

    private String nextToken;

    private Integer maxResults;

    private Boolean detail;

    /**
     * Default constructor for DescribeVolumesRequest object.
     */
    public DescribeVolumesRequest() {
    }

    /**
     * If the details of all the volumes is not required, one can provide the
     * list of volume IDs that are to be described.
     * 
     * This constructor creates an object of DescribeVolumesRequest and sets the
     * list of volumeIds that are to be described.
     * 
     * @param volumeIds
     *            List of volumeIds that are to be described.
     */
    public DescribeVolumesRequest(List<String> volumeIds) {
        setVolumeIds(volumeIds);
    }

    /**
     * Fetches list of volume IDs if set in DescribeVolumesRequest object,
     * otherwise an empty list.
     * 
     * @return List of volumeIds that are to be described.
     */
    public List<String> getVolumeIds() {
        return volumeIds;
    }

    /**
     * If the details of all the volumes is not required, one can provide the
     * list of volume IDs that are to be described.
     * 
     * This method sets the list of volumeIds, that are to be described, in
     * DescribeVolumeRequest object.
     * 
     * @param volumeIds
     *            List of volumeIds that are to be described.
     */
    public void setVolumeIds(Collection<String> volumeIds) {
        /*
         * If volumeIds is null then reset this.volumeIds to new ArrayList,
         * otherwise this.volumeIds may contain older values.
         * 
         * Trying to set null value means trying to clear previously set
         * volumeIds.
         */
        if (volumeIds == null) {
            this.volumeIds = new ArrayList<String>();
            return;
        }

        this.volumeIds = new ArrayList<String>(volumeIds);
    }

    /**
     * If the details of all the volumes is not required, one can provide the
     * list of volume IDs that are to be described.
     * 
     * This method sets the list of volumeIds (passed as varargs of type String)
     * that are to be described in DescribeVolumesRequest object and returns the
     * modified object.
     * 
     * @param volumeIds
     *            List of volumeIds as comma separated arguments (varargs) that
     *            are to be described.
     * @return Modified DescribeVolumesRequest object.
     */
    public DescribeVolumesRequest withVolumeIds(String... volumeIds) {
        for (String volumeId : volumeIds) {
            this.volumeIds.add(volumeId);
        }
        return this;
    }

    /**
     * If the details of all the volumes is not required, one can provide the
     * list of volume IDs that are to be described.
     * 
     * This method sets the list of volumeIds (passed as collection of String)
     * that are to be described in DescribeVolumesRequest object and returns the
     * modified object.
     * 
     * @param volumeIds
     *            Collection of volumeIds that are to be described.
     * @return Modified DescribeVolumesRequest object.
     */
    public DescribeVolumesRequest withVolumeIds(Collection<String> volumeIds) {
        setVolumeIds(volumeIds);
        return this;
    }

    /**
     * If the describeVolumes() method was called with a MaxResults option, all
     * items would not have been returned. So, the previous call of
     * describeVolumes() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeVolumes() will return the next set of items after this Id and
     * the new value of 'nextToken'
     * 
     * This method sets the given ID of last volume in the list of volumes in
     * DescribeVolumeResult object of previous call of describeVolumes() method.
     * 
     * @param nextToken
     *            The 'nextToken' value returned in response of previous call of
     *            describeVolumes() method. This value is the ID of last
     *            snapshot that was returned by the describeSnapshot() method
     */
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    /**
     * If the describeVolumes() method was called with a MaxResults option, all
     * items would not have been returned. So, the previous call of
     * describeVolumes() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeVolumes() will return the next set of items after this Id and
     * the new value of 'nextToken'
     * 
     * @return The value of nextToken (if it is set earlier).
     */
    public String getNextToken() {
        return this.nextToken;
    }

    /**
     * If the describeVolumes() method was called with a MaxResults option, all
     * items would not have been returned. So, the previous call of
     * describeVolumes() method returns 'nextToken' to get next set of items.
     * This is basically the Id of the last seen item from the previous call.
     * The describeVolumes() will return the next set of items after this Id and
     * the new value of 'nextToken'
     * 
     * This method sets the given ID of last volume in the list of volumes in
     * DescribeVolumeResult object of previous call of describeVolumes() method
     * and then returns the modified DescribeVolumeResult object
     * 
     * @param nextToken
     *            The 'nextToken' value returned in response of previous call of
     *            describeVolumes() method. This value is the ID of last
     *            snapshot that was returned by the describeSnapshot() method
     *
     * @return Modified DescribeVolumeResult object.
     */
    public DescribeVolumesRequest withNextToken(String nextToken) {
        setNextToken(nextToken);
        return this;
    }

    /**
     * Sets the maximum number of items to be returned by describeVolumes()
     * method in the DescribeVolumesRequest object.
     * 
     * @param maxResults
     *            The maximum number of items to be returned by
     *            describeVolumes() method.
     */
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    /**
     * Returns maximum number of items (snapshots) to be fetched.
     * 
     * @return An Integer value representing the maximum number of items to be
     *         returned by describeVolumes() method (if maxResults value is set
     *         in DescribeVolumesRequest object).
     */
    public Integer getMaxResults() {
        return this.maxResults;
    }

    /**
     * Sets the maximum number of items to be returned by describeVolumes()
     * method in the DescribeVolumesRequest object and returns the modified
     * DescribeVolumesRequest object.
     * 
     * @param maxResults
     *            The maximum number of items to be returned by
     *            describeVolumes() method.
     * @return Modified DescribeVolumesRequest object.
     */
    public DescribeVolumesRequest withMaxResults(Integer maxResults) {
        setMaxResults(maxResults);
        return this;
    }

    /**
     * Returns a boolean value that tells if details will be shown or not.
     * 
     * @return Value of 'detail' field of DescribeVolumesRequest object. If
     *         true, the describeVolumes() method will describe the volumes in
     *         detail.
     */
    public Boolean getDetail() {
        return detail;
    }

    /**
     * Set true/false to get result with/without details respectively. It also
     * returns the modified DescribeVolumesRequest object.
     * 
     * @param detail
     *            Sets the value of 'detail' field of DescribeVolumesRequest
     *            object. If it is set true, then the describeVolumes() method
     *            will describe the volumes in detail.
     */
    public void setDetail(Boolean detail) {
        this.detail = detail;
    }

    /**
     * Set true/false to get result with/without details respectively. It also
     * returns the modified DescribeVolumesRequest object.
     * 
     * @param detail
     *            Sets the value of 'detail' field of DescribeVolumesRequest
     *            object. If it is set true, then the describeVolumes() method
     *            will describe the volumes in detail.
     * @return Modified DescribeVolumesRequest object.
     */
    public DescribeVolumesRequest withDetail(Boolean detail) {
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
        result = prime * result + ((volumeIds == null) ? 0 : volumeIds.hashCode());
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
        DescribeVolumesRequest other = (DescribeVolumesRequest) obj;
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
        if (volumeIds == null) {
            if (other.volumeIds != null)
                return false;
        } else if (!volumeIds.equals(other.volumeIds))
            return false;
        return true;
    }

    /**
     * Creates and returns a copy of this object.
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public DescribeVolumesRequest clone() {
        try {
            return (DescribeVolumesRequest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }
}