//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.15 at 02:27:51 PM IST 
//


package xmlParser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="snapshotSet">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="snapshotId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="volumeSize" type="{http://www.w3.org/2001/XMLSchema}Integer"/>
 *                             &lt;element name="volumeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="encrypted" type="{http://www.w3.org/2001/XMLSchema}Boolean"/>
 *                             &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestId",
    "snapshotSet"
})
@XmlRootElement(name = "DescribeSnapshotsResponse")
public class DescribeSnapshotsResponse {

    @XmlElement(required = true)
    protected String requestId;
    @XmlElement(required = true)
    protected DescribeSnapshotsResponse.SnapshotSet snapshotSet;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the snapshotSet property.
     * 
     * @return
     *     possible object is
     *     {@link DescribeSnapshotsResponse.SnapshotSet }
     *     
     */
    public DescribeSnapshotsResponse.SnapshotSet getSnapshotSet() {
        return snapshotSet;
    }

    /**
     * Sets the value of the snapshotSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescribeSnapshotsResponse.SnapshotSet }
     *     
     */
    public void setSnapshotSet(DescribeSnapshotsResponse.SnapshotSet value) {
        this.snapshotSet = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="snapshotId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="volumeSize" type="{http://www.w3.org/2001/XMLSchema}Integer"/>
     *                   &lt;element name="volumeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="encrypted" type="{http://www.w3.org/2001/XMLSchema}Boolean"/>
     *                   &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class SnapshotSet {

        @XmlElement(nillable = true)
        protected List<DescribeSnapshotsResponse.SnapshotSet.Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DescribeSnapshotsResponse.SnapshotSet.Item }
         * 
         * 
         */
        public List<DescribeSnapshotsResponse.SnapshotSet.Item> getItem() {
            if (item == null) {
                item = new ArrayList<DescribeSnapshotsResponse.SnapshotSet.Item>();
            }
            return this.item;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="snapshotId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="volumeSize" type="{http://www.w3.org/2001/XMLSchema}Integer"/>
         *         &lt;element name="volumeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="encrypted" type="{http://www.w3.org/2001/XMLSchema}Boolean"/>
         *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "status",
            "snapshotId",
            "volumeSize",
            "volumeId",
            "encrypted",
            "startTime"
        })
        public static class Item {

            @XmlElement(required = true)
            protected String status;
            @XmlElement(required = true)
            protected String snapshotId;
            protected Integer volumeSize;
            @XmlElement(required = true)
            protected String volumeId;
            protected Boolean encrypted;
            @XmlElement(required = true)
            @XmlSchemaType(name = "dateTime")
            protected Date startTime;

            /**
             * Gets the value of the status property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatus(String value) {
                this.status = value;
            }

            /**
             * Gets the value of the snapshotId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSnapshotId() {
                return snapshotId;
            }

            /**
             * Sets the value of the snapshotId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSnapshotId(String value) {
                this.snapshotId = value;
            }

            /**
             * Gets the value of the volumeSize property.
             * 
             */
            public Integer getVolumeSize() {
                return volumeSize;
            }

            /**
             * Sets the value of the volumeSize property.
             * 
             */
            public void setVolumeSize(Integer value) {
                this.volumeSize = value;
            }

            /**
             * Gets the value of the volumeId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVolumeId() {
                return volumeId;
            }

            /**
             * Sets the value of the volumeId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVolumeId(String value) {
                this.volumeId = value;
            }

            /**
             * Gets the value of the encrypted property.
             * 
             */
            public Boolean isEncrypted() {
                return encrypted;
            }

            /**
             * Sets the value of the encrypted property.
             * 
             */
            public void setEncrypted(Boolean value) {
                this.encrypted = value;
            }

            /**
             * Gets the value of the startTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public Date getStartTime() {
                return startTime;
            }

            /**
             * Sets the value of the startTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setStartTime(Date value) {
                this.startTime = value;
            }

        }

    }

}
