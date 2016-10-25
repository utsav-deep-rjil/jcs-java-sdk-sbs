/**
 * 
 */
package com.jcs.sbs.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.jcs.sbs.auth.JCSCredentials;
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
import com.jcs.sbs.service.impl.JCSComputeClient;

public class JCSComputeTest {

    /*
     * static JCSCompute jcs; static DocumentBuilder builder;
     * 
     *//**
       * @throws java.lang.Exception
       *//*
         * private static void init() {
         * 
         * JCSCredentials credentials = new JCSCredentials() {
         * 
         * @Override public String getJCSAccessKey() { return
         * PropertiesReader.getProperty("ACCESS_KEY");
         * 
         * }
         * 
         * @Override public String getJCSSecretKey() { return
         * PropertiesReader.getProperty("SECRET_KEY"); }
         * 
         * };
         * 
         * jcs = new JCSComputeClient(credentials);
         * 
         * // For XML processing :
         * 
         * try { builder =
         * DocumentBuilderFactory.newInstance().newDocumentBuilder(); } catch
         * (Exception e) { e.printStackTrace(); }
         * 
         * }
         * 
         * //Covers describe snapshot test private int getSnapshotsCount() { try
         * { DescribeSnapshotsRequest describeSnapshotsRequest = new
         * DescribeSnapshotsRequest(); DescribeSnapshotsResult
         * describeSnapshotsResult =
         * jcs.describeSnapshots(describeSnapshotsRequest);
         * //System.out.println(describeSnapshotsResult.toString()); Document
         * document = builder.parse(new
         * ByteArrayInputStream(describeSnapshotsResult.toString().getBytes(
         * "UTF8"))); Element root = document.getDocumentElement(); NodeList
         * sublist = root.getElementsByTagName("snapshotSet");
         * assertTrue(sublist.getLength() > 0); Element snapshotSet =
         * (Element)sublist.item(0); int itemsCount =
         * snapshotSet.getElementsByTagName("item").getLength();
         * 
         * NodeList items = snapshotSet.getElementsByTagName("item"); int
         * completedSnapshots = 0; for(int itr = 0; itr < itemsCount; itr++){
         * Element item = (Element)items.item(itr); String status =
         * item.getElementsByTagName("status").item(0).getTextContent();
         * if(status.equals("completed")){ completedSnapshots++; } }
         * System.out.println("Total completed snapshots = " +
         * completedSnapshots); return completedSnapshots;
         * 
         * } catch (Exception e) { e.printStackTrace(); fail(e.toString());
         * return 0; } }
         * 
         * //Covers describe volume test private int getVolumesCount() { try {
         * 
         * DescribeVolumesRequest describeVolumesRequest = new
         * DescribeVolumesRequest(); DescribeVolumesResult describeVolumesResult
         * = jcs.describeVolumes(describeVolumesRequest);
         * System.out.println(describeVolumesResult.toString()); Document
         * document = builder.parse(new
         * ByteArrayInputStream(describeVolumesResult.toString().getBytes("UTF8"
         * ))); Element root = document.getDocumentElement(); NodeList sublist =
         * root.getElementsByTagName("volumeSet");
         * assertTrue(sublist.getLength() > 0); Element volumeSet =
         * (Element)sublist.item(0); int itemsCount =
         * volumeSet.getElementsByTagName("item").getLength();
         * 
         * NodeList items = volumeSet.getElementsByTagName("item"); int
         * availableVolumes = 0; for(int itr = 0; itr < itemsCount; itr++){
         * Element item = (Element)items.item(itr);
         * if(item.getElementsByTagName("status") == null){ continue; } String
         * status =
         * item.getElementsByTagName("status").item(0).getTextContent();
         * if(status.equals("available")){ availableVolumes++; } }
         * System.out.println("Total available volumes = " + availableVolumes);
         * return availableVolumes;
         * 
         * } catch (Exception e) { e.printStackTrace(); fail(e.toString());
         * return 0; } }
         * 
         * private String getVolumeStatus(String volumeId){ try {
         * 
         * DescribeVolumesRequest describeVolumesRequest = new
         * DescribeVolumesRequest(); DescribeVolumesResult describeVolumesResult
         * = jcs.describeVolumes(describeVolumesRequest); Document document =
         * builder.parse(new
         * ByteArrayInputStream(describeVolumesResult.toString().getBytes("UTF8"
         * ))); Element root = document.getDocumentElement(); NodeList sublist =
         * root.getElementsByTagName("volumeSet");
         * assertTrue(sublist.getLength() > 0); Element volumeSet =
         * (Element)sublist.item(0); int itemsCount =
         * volumeSet.getElementsByTagName("item").getLength();
         * 
         * NodeList items = volumeSet.getElementsByTagName("item"); for(int itr
         * = 0; itr < itemsCount; itr++){ Element item =
         * (Element)items.item(itr); String currVolId =
         * item.getElementsByTagName("volumeId").item(0).getTextContent();
         * if(currVolId.equals(volumeId)){
         * System.out.println(item.getElementsByTagName("status").item(0).
         * getTextContent()); return
         * item.getElementsByTagName("status").item(0).getTextContent(); } }
         * return "doesn't exist";
         * 
         * } catch (Exception e) { e.printStackTrace(); fail(e.toString());
         * return "Error"; } } private String getSnapshotStatus(String
         * snapshotId){ try {
         * 
         * DescribeSnapshotsRequest describeSnapshotsRequest = new
         * DescribeSnapshotsRequest(); DescribeSnapshotsResult
         * describeSnapshotsResult =
         * jcs.describeSnapshots(describeSnapshotsRequest); Document document =
         * builder.parse(new
         * ByteArrayInputStream(describeSnapshotsResult.toString().getBytes(
         * "UTF8"))); Element root = document.getDocumentElement(); NodeList
         * sublist = root.getElementsByTagName("snapshotSet");
         * assertTrue(sublist.getLength() > 0); Element snapshotSet =
         * (Element)sublist.item(0);
         * 
         * int itemsCount =
         * snapshotSet.getElementsByTagName("item").getLength();
         * 
         * NodeList items = snapshotSet.getElementsByTagName("item"); for(int
         * itr = 0; itr < itemsCount; itr++){ Element item =
         * (Element)items.item(itr); String currSnapshotId =
         * item.getElementsByTagName("snapshotId").item(0).getTextContent();
         * if(currSnapshotId.equals(snapshotId)){
         * System.out.println(item.getElementsByTagName("status").item(0).
         * getTextContent()); return
         * item.getElementsByTagName("status").item(0).getTextContent(); } }
         * return "doesn't exist";
         * 
         * 
         * } catch (Exception e) { e.printStackTrace(); fail(e.toString());
         * return "Error"; } } private void deleteAllVolumes(){ try {
         * 
         * DescribeVolumesRequest describeVolumesRequest = new
         * DescribeVolumesRequest(); DescribeVolumesResult describeVolumesResult
         * = jcs.describeVolumes(describeVolumesRequest); Document document =
         * builder.parse(new
         * ByteArrayInputStream(describeVolumesResult.toString().getBytes("UTF8"
         * ))); Element root = document.getDocumentElement(); NodeList sublist =
         * root.getElementsByTagName("volumeSet"); Element volumeSet =
         * (Element)sublist.item(0); int itemsCount =
         * volumeSet.getElementsByTagName("item").getLength();
         * 
         * NodeList items = volumeSet.getElementsByTagName("item"); for(int itr
         * = 0; itr < itemsCount; itr++){ Element item =
         * (Element)items.item(itr); String currVolId =
         * item.getElementsByTagName("volumeId").item(0).getTextContent();
         * String status =
         * item.getElementsByTagName("status").item(0).getTextContent();
         * if(!status.equals("available")){ continue; } DeleteVolumeRequest
         * deleteVolumeRequest = new DeleteVolumeRequest()
         * .withVolumeId(currVolId); DeleteVolumeResult deleteVolumeResult =
         * jcs.deleteVolume(deleteVolumeRequest); }
         * 
         * 
         * } catch (Exception e) { e.printStackTrace(); } }
         * 
         * @BeforeClass public static void setUpBeforeClass() throws Exception {
         * 
         * init();
         * 
         * }
         * 
         * 
         * @Test public void createAndDeleteTest() { try { init();
         * //deleteAllVolumes();
         * 
         * //Create empty volume test
         * 
         * int initialVolumeCount = getVolumesCount();
         * 
         * CreateVolumeRequest createVolumeRequest = new
         * CreateVolumeRequest().withSize(10); CreateVolumeResult
         * createVolumeResult = jcs.createVolume(createVolumeRequest);
         * 
         * while(!getVolumeStatus(createVolumeResult.getVolume().getVolumeId()).
         * equals("available")) ;
         * System.out.println(createVolumeResult.toString()); int
         * volumeCountAfterCreation = getVolumesCount();
         * assertThat("create volume test 1",initialVolumeCount + 1,
         * equalTo(volumeCountAfterCreation));
         * 
         * 
         * //create snapshot test
         * 
         * int initialSnapshotCount = getSnapshotsCount();
         * 
         * CreateSnapshotRequest createSnapshotRequest = new
         * CreateSnapshotRequest().withVolumeId(createVolumeResult.getVolume().
         * getVolumeId()); CreateSnapshotResult createSnapshotResult =
         * jcs.createSnapshot(createSnapshotRequest);
         * while(!getSnapshotStatus(createSnapshotResult.getSnapshot().
         * getSnapshotId()).equals("completed")) ;
         * System.out.println(createSnapshotResult.toString()); int
         * snapshotCountAfterCreation = getSnapshotsCount();
         * assertThat("create snapshot test",initialSnapshotCount + 1,
         * equalTo(snapshotCountAfterCreation));
         * 
         * //delete volume test1
         * 
         * DeleteVolumeRequest deleteVolumeRequest = new DeleteVolumeRequest()
         * .withVolumeId(createVolumeResult.getVolume().getVolumeId());
         * DeleteVolumeResult deleteVolumeResult =
         * jcs.deleteVolume(deleteVolumeRequest);
         * System.out.println(deleteVolumeResult.toString()); int
         * finalVolumeCount = getVolumesCount();
         * assertThat("delete volume test 1",volumeCountAfterCreation - 1,
         * equalTo(finalVolumeCount));
         * 
         * //create volume from snapshot test
         * 
         * initialVolumeCount = getVolumesCount();
         * 
         * createVolumeRequest = new
         * CreateVolumeRequest().withSnapshotId(createSnapshotResult.getSnapshot
         * ().getSnapshotId()); createVolumeResult =
         * jcs.createVolume(createVolumeRequest);
         * 
         * System.out.println(createVolumeResult.toString());
         * 
         * while(!getVolumeStatus(createVolumeResult.getVolume().getVolumeId()).
         * equals("available")) ; volumeCountAfterCreation = getVolumesCount();
         * assertThat("create volume test 2",initialVolumeCount + 1,
         * equalTo(volumeCountAfterCreation));
         * assertThat("create volume test 2 (snapshotId)",createVolumeResult.
         * getVolume().getSnapshotId(),equalTo(createSnapshotResult.getSnapshot(
         * ).getSnapshotId()));
         * assertThat("create volume test 2 (size)",createVolumeResult.getVolume
         * ().getSize(),equalTo(createSnapshotResult.getSnapshot().getSize()));
         * 
         * 
         * //delete volume test2
         * 
         * while(!getVolumeStatus(createVolumeResult.getVolume().getVolumeId()).
         * equals("available")) ; deleteVolumeRequest = new
         * DeleteVolumeRequest()
         * .withVolumeId(createVolumeResult.getVolume().getVolumeId());
         * deleteVolumeResult = jcs.deleteVolume(deleteVolumeRequest);
         * System.out.println(deleteVolumeResult.toString());
         * 
         * while(!getVolumeStatus(createVolumeResult.getVolume().getVolumeId()).
         * equals("deleting")) ; finalVolumeCount = getVolumesCount();
         * assertThat("delete volume test 2",volumeCountAfterCreation - 1,
         * equalTo(finalVolumeCount));
         * 
         * //delete snapshot test
         * 
         * DeleteSnapshotRequest deleteSnapshotRequest = new
         * DeleteSnapshotRequest()
         * .withSnapshotId(createSnapshotResult.getSnapshot().getSnapshotId());
         * DeleteSnapshotResult deleteSnapshotResult =
         * jcs.deleteSnapshot(deleteSnapshotRequest);
         * System.out.println(deleteSnapshotResult.toString());
         * 
         * while(getSnapshotStatus(createSnapshotResult.getSnapshot().
         * getSnapshotId()).equals("deleting")) ; int finalSnapshotCount =
         * getSnapshotsCount();
         * assertThat("delete snapshot test",snapshotCountAfterCreation - 1,
         * equalTo(finalSnapshotCount)); } catch (Exception e) {
         * e.printStackTrace(); fail(e.toString()); }
         * 
         * }
         */

}
