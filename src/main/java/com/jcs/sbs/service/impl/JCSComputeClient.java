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
import com.jcs.sbs.common.JCSHttpClient;
import com.jcs.sbs.common.PropertiesReader;
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
import com.jcs.sbs.model.VolumeType;
import com.jcs.sbs.service.JCSCompute;

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
     */

    public JCSComputeClient() {
        this(new DefaultJCSCredentialsProviderChain());
    }

    /**
     * Constructs a new client to invoke service methods on JCS Client using the
     * specified JCS account credentials. All service calls made using this new
     * client object are blocking, and will not return until the service call
     * completes. Parameters: jcsCredentials - The JCS credentials (access key
     * ID and secret key) to use when authenticating with JCS services.
     */

    public JCSComputeClient(JCSCredentials jcsCredentials) {
        this.jcsCredentialsProvider = new StaticCredentialsProvider(jcsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on JCS Client using the
     * specified JCS account credentials provider. All service calls made using
     * this new client object are blocking, and will not return until the
     * service call completes. Parameters: jcsCredentialsProvider- The JCS
     * credentials provider which will provide credentials to authenticate
     * requests with JCS services.
     */

    public JCSComputeClient(JCSCredentialsProvider jcsCredentialsProvider) {
        this.jcsCredentialsProvider = jcsCredentialsProvider;
        init();
    }

    /**
     * Initializes the end-points of the APIs with the BASE_URL as in
     * config.properties file
     */
    private void init() {
        this.setEndpoint(PropertiesReader.getProperty("BASE_URL"));
    }

    /**
     * Creates an SBS volume that can be attached to an instance in the same
     * Availability Zone. The volume is created in the regional endpoint that
     * you send the HTTP request to. You can create a new empty volume or
     * restore a volume from an SBS snapshot. Specified by: createVolume in
     * interface JCSCompute
     * 
     * @param createVolumeRequest
     *            Contains the parameters for CreateVolume.
     * @return Result of the CreateVolume operation returned by the service.
     */

    @Override
    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Action", "CreateVolume");
        if (createVolumeRequest.getSize() != null) {
            params.put("Size", createVolumeRequest.getSize().toString());
        }
        if (createVolumeRequest.getSnapshotId() != null) {
            params.put("SnapshotId", createVolumeRequest.getSnapshotId());
        }
        if (createVolumeRequest.getEncrypted() != null && !createVolumeRequest.getEncrypted()) {
            params.put("Encrypted", "0");
        }
        if (createVolumeRequest.getVolumeType() != null && createVolumeRequest.getVolumeType() != VolumeType.standard) {
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
                        .withVolumeType(VolumeType.fromValue(createVolumeResponse.getVolumeType()))
                        .withStatus(createVolumeResponse.getStatus());

                EntityUtils.consume(entity);
                CreateVolumeResult createVolumeResult = new CreateVolumeResult().withVolume(volume);
                createVolumeResult.setRequestId(createVolumeResponse.getRequestId());
                createVolumeResult.setXml(content);
                return createVolumeResult;

            } else {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);
                System.out.println(content);
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
     * Specified by: deleteVolume in interface JCSCompute
     * 
     * @param deleteVolumeRequest
     *            Contains the parameters for DeleteVolume.
     * @return Result of the DeleteVolume operation returned by the service.
     */

    @Override
    public DeleteVolumeResult deleteVolume(DeleteVolumeRequest deleteVolumeRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
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
     *            Contains the parameters for DescribeVolumes.
     * @return Result of the DescribeVolumes operation returned by the service.
     */

    @Override
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
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
                    volumes.add(new Volume().withSize(item.getSize()).withVolumeId(item.getVolumeId())
                            .withCreateTime(item.getCreateTime()).withSnapshotId(item.getSnapshotId())
                            .withStatus(item.getStatus()).withEncryption(item.isEncrypted())
                            .withVolumeType(VolumeType.fromValue(item.getVolumeType())));
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
     *            Contains the parameters for CreateSnapshot.
     * @return Result of the CreateSnapshot operation returned by the service.
     */

    @Override
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
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
     *            - Contains the parameters for DeleteSnapshot.
     * @return Result of the DeleteSnapshot operation returned by the service.
     */

    @Override
    public DeleteSnapshotResult deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
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
     *            - Contains the parameters for DescribeSnapshots.
     * @return Result of the DescribeSnapshots operation returned by the
     *         service.
     */

    @Override
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest)
            throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException, ClientProtocolException,
            IOException, JAXBException, HttpException {
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
            if (response.getStatusLine().getStatusCode() == 200) {
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
