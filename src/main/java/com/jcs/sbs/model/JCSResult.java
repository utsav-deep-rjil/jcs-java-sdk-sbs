package com.jcs.sbs.model;

public class JCSResult {
    private String requestId;
    private String xml;

    /**
     * @return
     */
    public String getRequestId() {
        return this.requestId;
    }

    /**
     * @param requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return
     */
    public String getXml() {
        return this.xml;
    }

    /**
     * @param xml
     */
    public void setXml(String xml) {
        this.xml = xml;
    }
}
