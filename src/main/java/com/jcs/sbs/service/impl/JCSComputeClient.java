package com.jcs.sbs.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;

import com.jcs.sbs.auth.DefaultJCSCredentialsProviderChain;
import com.jcs.sbs.auth.JCSCredentials;
import com.jcs.sbs.auth.JCSCredentialsProvider;
import com.jcs.sbs.auth.StaticCredentialsProvider;
import com.jcs.sbs.common.Constants;
import com.jcs.sbs.common.JCSHttpClient;
import com.jcs.sbs.common.PropertiesReader;
import com.jcs.sbs.exceptions.PropertyNotFoundException;
import com.jcs.sbs.model.Attachment;
import com.jcs.sbs.model.CreateSnapshotRequest;
import com.jcs.sbs.model.CreateSnapshotResult;
import com.jcs.sbs.model.CreateVolumeRequest;
import com.jcs.sbs.model.CreateVolumeResult;
import com.jcs.sbs.model.DeleteSnapshotRequest;
import com.jcs.sbs.model.DeleteSnapshotResult;
import com.jcs.sbs.model.DeleteVolumeRequest;
import com.jcs.sbs.model.DeleteVolumeResult;
import com.jcs.sbs.model.DescribeSnapshotsRequest;
import com.jcs.sbs.model.DescribeSnapshotsResult;
import com.jcs.sbs.model.DescribeVolumesRequest;
import com.jcs.sbs.model.DescribeVolumesResult;
import com.jcs.sbs.model.Snapshot;
import com.jcs.sbs.model.Volume;
import com.jcs.sbs.service.JCSCompute;

import xmlParser.AttachmentSet.AttachmentEO;
import xmlParser.CreateSnapshotResponse;
import xmlParser.CreateVolumeResponse;
import xmlParser.DeleteSnapshotResponse;
import xmlParser.DeleteVolumeResponse;
import xmlParser.DescribeSnapshotsResponse;
import xmlParser.DescribeVolumesResponse;

/**
 * Implements create, describe and delete methods for volumes and snapshots.
 */
@ThreadSafe
public class JCSComputeClient extends JCSHttpClient implements JCSCompute {

    private static final Log log = LogFactory.getLog(JCSComputeClient.class);
    private JCSCredentialsProvider jcsCredentialsProvider;

    /**
     * Constructs a new client to invoke service methods on JCS Client. A
     * credentials provider chain will be used that searches for credentials in
     * this order: <br>
     * Environment Variables - ACCESS_KEY and SECRET_KEY <br>
     * Java System Properties - ACCESS_KEY and SECRET_KEY <br>
     * Properties File (config.properties) - ACCESS_KEY and SECRET_KEY <br>
     * All service calls made using this new client object are blocking, and
     * will not return until the service call completes.
     * 
     * @throws PropertyNotFoundException
     */

    public JCSComputeClient() throws PropertyNotFoundException {
        this(new DefaultJCSCredentialsProviderChain());
    }

    /**
     * Constructs a new client to invoke service methods on JCS Client using the
     * specified JCS account credentials. All service calls made using this new
     * client object are blocking, and will not return until the service call
     * completes.
     * 
     * @param jcsCredentials
     *            The JCS credentials (access key ID and secret key) to use when
     *            authenticating with JCS services.
     * @throws PropertyNotFoundException
     */

    public JCSComputeClient(JCSCredentials jcsCredentials) throws PropertyNotFoundException {
        this.jcsCredentialsProvider = new StaticCredentialsProvider(jcsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on JCS Client using the
     * specified JCS account credentials provider. All service calls made using
     * this new client object are blocking, and will not return until the
     * service call completes.
     * 
     * @param jcsCredentialsProvider
     *            Object of class that implements
     *            {@link com.jcs.sbs.auth.JCSCredentialsProvider
     *            JCSCredentialsProvider} interface (The JCS credentials
     *            provider which will provide credentials to authenticate
     *            requests with JCS services)
     * 
     * @throws PropertyNotFoundException
     */

    public JCSComputeClient(JCSCredentialsProvider jcsCredentialsProvider) throws PropertyNotFoundException {
        this.jcsCredentialsProvider = jcsCredentialsProvider;
        init();
    }

    /**
     * Initializes the end-points of the APIs with the BASE_URL as in
     * config.properties file
     */
    private void init() throws PropertyNotFoundException {
        if (StringUtils.isNotBlank(PropertiesReader.getProperty("BASE_URL"))) {
            this.setEndpoint(PropertiesReader.getProperty("BASE_URL"));
            log.info("Using BASE_URL from " + Constants.PROPERTIES_FILE_NAME);
            return;
        } else {
            log.warn("Unable to read BASE_URL property from " + Constants.PROPERTIES_FILE_NAME);
        }
        if (StringUtils.isNotBlank(System.getenv("BASE_URL"))) {
            this.setEndpoint(System.getenv("BASE_URL"));
            log.info("Using BASE_URL from environment variables");
            return;
        } else {
            log.warn("Unable to read BASE_URL property from environment variables");
        }
        if (StringUtils.isNotBlank(System.getProperty("BASE_URL"))) {
            this.setEndpoint(System.getProperty("BASE_URL"));
            log.info("Using BASE_URL from java system properties");
            return;
        } else {
            log.warn("Unable to read BASE_URL property from Java system properties");
        }
        throw new PropertyNotFoundException("BASE_URL property must be set in " + Constants.PROPERTIES_FILE_NAME
                + ", environment variables or java system properties");
    }

    private List<Attachment> attachmentSetEOtoBO(List<AttachmentEO> attachmentSetEO) {
        if (attachmentSetEO == null || !(attachmentSetEO instanceof List)) {
            return null;
        }
        List<Attachment> attachmentSetBO = new ArrayList<>();
        for (AttachmentEO attachmentEO : attachmentSetEO) {
            Attachment attachment = new Attachment(attachmentEO.getInstanceId(), attachmentEO.getDevice());
            attachmentSetBO.add(attachment);
        }
        return attachmentSetBO;
    }

    /**
     * Creates an volume that can be attached to an instance in the same
     * Availability Zone. The volume is created in the regional endpoint that
     * you send the HTTP request to. You can create a new empty volume or
     * restore a volume from an SBS snapshot. Specified by: createVolume in
     * interface JCSCompute
     * 
     * @param createVolumeRequest
     *            An object of {@link com.jcs.sbs.model.CreateVolumeRequest
     *            CreateVolumeRequest} containing values required in create
     *            volume API
     * @return {@link com.jcs.sbs.model.CreateVolumeResult CreateVolumeResult}
     *         object containing values in response given by create volume API
     * @throws Exception
     */

    @Override
    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException, IllegalArgumentException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CreateVolume");
        if (createVolumeRequest.getSize() != null) {
            if (createVolumeRequest.getSize() < 1) {
                throw new IllegalArgumentException(String.format(
                        "Invalid volume size provided for create volume request: %d (size must be greater than zero).",
                        createVolumeRequest.getSize()));
            }
            params.put("Size", createVolumeRequest.getSize().toString());
        }
        if (createVolumeRequest.getSnapshotId() != null) {
            params.put("SnapshotId", createVolumeRequest.getSnapshotId());
        }
        if (createVolumeRequest.getEncrypted() != null && createVolumeRequest.getEncrypted()) {
            params.put("Encrypted", "1");
        }
        if (StringUtils.isNotBlank(createVolumeRequest.getVolumeType())) {
            params.put("VolumeType", createVolumeRequest.getVolumeType().toString());
        }
        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                createVolumeRequest.getCustomRequestHeaders());
        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(CreateVolumeResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                CreateVolumeResponse createVolumeResponse = (CreateVolumeResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                Volume volume = new Volume().withSize(createVolumeResponse.getSize())
                        .withVolumeId(createVolumeResponse.getVolumeId())
                        .withCreateTime(createVolumeResponse.getCreateTime())
                        .withSnapshotId(createVolumeResponse.getSnapshotId())
                        .withEncryption(createVolumeResponse.isEncrypted())
                        .withVolumeType(createVolumeResponse.getVolumeType())
                        .withStatus(createVolumeResponse.getStatus())
                        .withAttachmentSet(attachmentSetEOtoBO(createVolumeResponse.getAttachmentSet().getItem()));

                EntityUtils.consume(entity);
                CreateVolumeResult createVolumeResult = new CreateVolumeResult().withVolume(volume);
                createVolumeResult.setRequestId(createVolumeResponse.getRequestId());
                createVolumeResult.setXml(content);
                return createVolumeResult;

            } else {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);
                throw new HttpException(content);
            }
        } finally {
            response.close();
        }

    }

    /**
     * Deletes the specified SBS volume. The volume must be in the available
     * state (not attached to an instance). The volume may remain in the
     * deleting state for several minutes.
     * 
     * @param deleteVolumeRequest
     *            An object of {@link com.jcs.sbs.model.DeleteVolumeRequest
     *            DeleteVolumeRequest} containing values required in delete
     *            volume API
     * @return {@link com.jcs.sbs.model.DeleteVolumeResult DeleteVolumeResult}
     *         object containing values in response given by delete volume API
     * @throws Exception
     */

    @Override
    public DeleteVolumeResult deleteVolume(DeleteVolumeRequest deleteVolumeRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "DeleteVolume");
        if (deleteVolumeRequest.getVolumeId() != null) {
            params.put("VolumeId", deleteVolumeRequest.getVolumeId());
        }

        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                deleteVolumeRequest.getCustomRequestHeaders());

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(DeleteVolumeResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                DeleteVolumeResponse deleteVolumeResponse = (DeleteVolumeResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                EntityUtils.consume(entity);
                DeleteVolumeResult deleteVolumeResult = new DeleteVolumeResult();
                deleteVolumeResult.setDeleted(deleteVolumeResponse.isReturn());
                deleteVolumeResult.setRequestId(deleteVolumeResponse.getRequestId());
                deleteVolumeResult.setXml(content);
                return deleteVolumeResult;

            } else
                throw new HttpException(response.getStatusLine().toString());
        } finally {
            response.close();
        }
    }

    /**
     * Describes the specified SBS volumes. If you are describing a long list of
     * volumes, you can paginate the output to make the list more manageable.
     * The MaxResults parameter sets the maximum number of results returned in a
     * single page. If the list of results exceeds your MaxResults value, then
     * that number of results is returned along with a NextToken value that can
     * be passed to a subsequent DescribeVolumes request to retrieve the
     * remaining results. Specified by: describeVolumes in interface JCSCompute
     * 
     * @param describeVolumesRequest
     *            An object of {@link com.jcs.sbs.model.DescribeVolumesRequest
     *            DescribeVolumesRequest} containing values required in describe
     *            volumes API
     * @return {@link com.jcs.sbs.model.DescribeVolumesResult
     *         DescribeVolumesResult} object containing list of
     *         {@link com.jcs.sbs.model.Volume Volume} objects as returned by
     *         describe volume API
     * @throws Exception
     */

    @Override
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "DescribeVolumes");
        if (describeVolumesRequest.getMaxResults() != null) {
            params.put("MaxResults", describeVolumesRequest.getMaxResults().toString());
        }
        if (describeVolumesRequest.getNextToken() != null) {
            params.put("NextToken", describeVolumesRequest.getNextToken());
        }

        if (describeVolumesRequest.getDetail() != null) {
            params.put("Detail", String.valueOf(describeVolumesRequest.getDetail()));
        }
        if (describeVolumesRequest.getVolumeIds() != null) {
            int i = 1;
            for (String volumeId : describeVolumesRequest.getVolumeIds()) {
                params.put("VolumeId." + i, volumeId);
                i++;
            }
        }
        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                describeVolumesRequest.getCustomRequestHeaders());

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(DescribeVolumesResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                DescribeVolumesResponse describeVolumesResponse = (DescribeVolumesResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                List<Volume> volumes = new ArrayList<Volume>();

                for (DescribeVolumesResponse.VolumeSet.Item item : describeVolumesResponse.getVolumeSet().getItem()) {
                    Volume volume = new Volume().withVolumeId(item.getVolumeId()).withStatus(item.getStatus())
                            .withEncryption(item.isEncrypted()).withVolumeType(item.getVolumeType());

                    if (null != item.getAttachmentSet()) {
                        volume.setAttachmentSet(attachmentSetEOtoBO(item.getAttachmentSet().getItem()));
                    }
                    if (null != item.getSize()) {
                        volume.setSize(item.getSize());
                    }
                    if (null != item.getCreateTime()) {
                        volume.setCreateTime(item.getCreateTime());
                    }
                    if (null != item.getSnapshotId()) {
                        volume.setSnapshotId(item.getSnapshotId());
                    }
                    volumes.add(volume);

                }
                EntityUtils.consume(entity);
                DescribeVolumesResult describeVolumesResult = new DescribeVolumesResult().withVolumes(volumes);
                describeVolumesResult.setRequestId(describeVolumesResponse.getRequestId());
                describeVolumesResult.setXml(content);
                return describeVolumesResult;

            } else
                throw new HttpException(response.getStatusLine().toString());
        } finally {
            response.close();
        }
    }

    /**
     * Creates a snapshot of an SBS volume. You can use snapshots for backups,
     * to make copies of SBS volumes, and to save data before shutting down an
     * instance. When a snapshot is created, any Marketplace product codes that
     * are associated with the source volume are propagated to the snapshot. You
     * can take a snapshot of an attached volume that is in use. However,
     * snapshots only capture data that has been written to your SBS volume at
     * the time the snapshot command is issued; this may exclude any data that
     * has been cached by any applications or the operating system. If you can
     * pause any file systems on the volume long enough to take a snapshot, your
     * snapshot should be complete. However, if you cannot pause all file writes
     * to the volume, you should unmount the volume from within the instance,
     * issue the snapshot command, and then remount the volume to ensure a
     * consistent and complete snapshot. You may remount and use your volume
     * while the snapshot status is pending. To create a snapshot for SBS
     * volumes that serve as root devices, you should stop the instance before
     * taking the snapshot. Specified by: createSnapshot in interface JCSCompute
     * 
     * @param createSnapshotRequest
     *            An object of {@link com.jcs.sbs.model.CreateSnapshotRequest
     *            CreateSnapshotRequest} containing values required in create
     *            snapshot API
     * @return {@link com.jcs.sbs.model.CreateSnapshotResult
     *         CreateSnapshotResult} object containing values in response given
     *         by create snapshot API
     * @throws Exception
     */

    @Override
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CreateSnapshot");

        if (createSnapshotRequest.getVolumeId() != null) {
            params.put("VolumeId", createSnapshotRequest.getVolumeId());
        }
        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                createSnapshotRequest.getCustomRequestHeaders());

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(CreateSnapshotResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                CreateSnapshotResponse createSnapshotResponse = (CreateSnapshotResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                Snapshot snapshot = new Snapshot().withSize(createSnapshotResponse.getVolumeSize())
                        .withVolumeId(createSnapshotResponse.getVolumeId())
                        .withStartTime(createSnapshotResponse.getStartTime())
                        .withSnapshotId(createSnapshotResponse.getSnapshotId())
                        .withStatus(createSnapshotResponse.getStatus())
                        .withEncryption(createSnapshotResponse.isEncrypted());

                EntityUtils.consume(entity);
                CreateSnapshotResult createSnapshotResult = new CreateSnapshotResult().withSnapshot(snapshot);
                createSnapshotResult.setRequestId(createSnapshotResponse.getRequestId());
                createSnapshotResult.setXml(content);
                return createSnapshotResult;

            } else
                throw new HttpException(response.getStatusLine().toString());
        } finally {
            response.close();
        }
    }

    /**
     * Deletes the specified snapshot. When you make periodic snapshots of a
     * volume, the snapshots are incremental, and only the blocks on the device
     * that have changed since your last snapshot are saved in the new snapshot.
     * When you delete a snapshot, only the data not needed for any other
     * snapshot is removed. So regardless of which prior snapshots have been
     * deleted, all active snapshots will have access to all the information
     * needed to restore the volume. Specified by: deleteSnapshot in interface
     * JCSCompute
     * 
     * @param deleteSnapshotRequest
     *            An object of {@link com.jcs.sbs.model.DeleteSnapshotRequest
     *            DeleteSnapshotRequest} containing values required in delete
     *            snapshot API
     * @return {@link com.jcs.sbs.model.DeleteSnapshotResult
     *         DeleteSnapshotResult} object containing values in response given
     *         by delete snapshot API
     * @throws Exception
     */

    @Override
    public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "DeleteSnapshot");
        if (deleteSnapshotRequest.getSnapshotId() != null) {
            params.put("SnapshotId", deleteSnapshotRequest.getSnapshotId());
        }

        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                deleteSnapshotRequest.getCustomRequestHeaders());

        try {
            if (response.getStatusLine().getStatusCode() == 200) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(DeleteSnapshotResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                DeleteSnapshotResponse deleteSnapshotResponse = (DeleteSnapshotResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                EntityUtils.consume(entity);
                DeleteSnapshotResult deleteSnapshotResult = new DeleteSnapshotResult();
                deleteSnapshotResult.setDeleted(deleteSnapshotResponse.isReturn());
                deleteSnapshotResult.setRequestId(deleteSnapshotResponse.getRequestId());
                deleteSnapshotResult.setXml(content);
                return deleteSnapshotResult;

            } else
                throw new HttpException(response.getStatusLine().toString());
        } finally {
            response.close();
        }
    }

    /**
     * Describes one or more of the SBS snapshots available to you. The list of
     * snapshots returned can be modified by specifying snapshot IDs. If no
     * options are specified, JCS Compute returns all snapshots. If you specify
     * one or more snapshot IDs, only snapshots that have the specified IDs are
     * returned. If you specify an invalid snapshot ID, an error is returned. If
     * you specify a snapshot ID for which you do not have access, it is not
     * included in the returned results. If you are describing a long list of
     * snapshots, you can paginate the output to make the list more manageable.
     * The MaxResults parameter sets the maximum number of results returned in a
     * single page. If the list of results exceeds your MaxResults value, then
     * that number of results is returned along with a NextToken value that can
     * be passed to a subsequent DescribeSnapshots request to retrieve the
     * remaining results. Specified by: describeSnapshots in interface
     * JCSCompute
     * 
     * @param describeSnapshotsRequest
     *            An object of {@link com.jcs.sbs.model.DescribeSnapshotsRequest
     *            DescribeSnapshotsRequest} containing values required in
     *            describe snapshots API
     * @return {@link com.jcs.sbs.model.DescribeSnapshotsResult
     *         DescribeSnapshotsResult} object containing a list of
     *         {@link com.jcs.sbs.model.Snapshot Snapshot} objects as returned
     *         by describe snapshots API
     * @throws Exception
     */

    @Override
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException, PropertyNotFoundException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "DescribeSnapshots");
        if (describeSnapshotsRequest.getMaxResults() != null) {
            params.put("MaxResults", describeSnapshotsRequest.getMaxResults().toString());
        }
        if (describeSnapshotsRequest.getNextToken() != null) {
            params.put("NextToken", describeSnapshotsRequest.getNextToken());
        }
        if (describeSnapshotsRequest.getSnapshotIds() != null) {
            int i = 1;
            for (String snapshotId : describeSnapshotsRequest.getSnapshotIds()) {
                params.put("SnapshotId." + i, snapshotId);
                i++;
            }
        }
        if (describeSnapshotsRequest.getDetail() != null) {
            params.put("Detail", String.valueOf(describeSnapshotsRequest.getDetail()));
        }
        CloseableHttpResponse response = this.makeRequest(this.jcsCredentialsProvider.getCredentials(), params,
                describeSnapshotsRequest.getCustomRequestHeaders());

        try {
            if (response.getStatusLine().getStatusCode() / 100 == 2) {
                log.debug(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);

                JAXBContext jaxbContext = JAXBContext.newInstance(DescribeSnapshotsResponse.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                DescribeSnapshotsResponse describeSnapshotsResponse = (DescribeSnapshotsResponse) jaxbUnmarshaller
                        .unmarshal(new InputSource(new StringReader(content)));

                List<Snapshot> snapshots = new ArrayList<Snapshot>();

                for (DescribeSnapshotsResponse.SnapshotSet.Item item : describeSnapshotsResponse.getSnapshotSet()
                        .getItem()) {
                    snapshots.add(new Snapshot().withSnapshotId(item.getSnapshotId()).withSize(item.getVolumeSize())
                            .withVolumeId(item.getVolumeId()).withStartTime(item.getStartTime())
                            .withStatus(item.getStatus()).withEncryption(item.isEncrypted()));
                }
                EntityUtils.consume(entity);
                DescribeSnapshotsResult describeSnapshotsResult = new DescribeSnapshotsResult()
                        .withSnapshots(snapshots);
                describeSnapshotsResult.setRequestId(describeSnapshotsResponse.getRequestId());
                describeSnapshotsResult.setXml(content);
                return describeSnapshotsResult;

            } else
                throw new HttpException(response.getStatusLine().toString());
        } finally {
            response.close();
        }
    }

}
