package com.jcs.sbs.main;

import com.jcs.sbs.auth.DefaultJCSCredentialsProviderChain;
import com.jcs.sbs.auth.JCSCredentials;
import com.jcs.sbs.auth.JCSCredentialsProvider;
import com.jcs.sbs.model.DescribeSnapshotsRequest;
import com.jcs.sbs.model.DescribeSnapshotsResult;
import com.jcs.sbs.model.DescribeVolumesRequest;
import com.jcs.sbs.model.DescribeVolumesResult;
import com.jcs.sbs.service.JCSCompute;
import com.jcs.sbs.service.impl.JCSComputeClient;

/**
 * Class containing main() method. This serves as an example code for using this SDK.
 */
public class JCStry {

    static JCSCompute jcs;
    
    /**
     * Method to initialize JCSCompute object with its implementation class. 
     */
	private static void init(){
		   
		JCSCredentialsProvider credentialsProviders = new DefaultJCSCredentialsProviderChain();
		JCSCredentials credentials = credentialsProviders.getCredentials();
		jcs = new JCSComputeClient(credentials);
		
    }
    
	/**
	 * Main method from where SDK can run (to serve as a demo)
	 * @param args Command line arguments (not required in the method)
	 */
    public static void main(String[] args){

       init();

        
        try {
                        
//            CreateVolumeRequest createVolumeRequest = new CreateVolumeRequest();
//            //createVolumeRequest.setSnapshotId("1613998c-d78a-4504-b474-e175819ca1f9");
//            CreateVolumeResult createVolumeResult = jcs.createVolume(createVolumeRequest);
//            //System.out.println(createVolumeResult.toString());
//            System.out.println(createVolumeResult.getVolume().getVolumeId());
//            System.out.println(createVolumeResult.getVolume().getStatus());
//            System.out.println(createVolumeResult.getVolume().getCreateTime());
//            
//            DeleteVolumeRequest deleteVolumeRequest = new DeleteVolumeRequest().withVolumeId("14b35b92-fe75-4e8d-9eb3-9c268374422e");
//            DeleteVolumeResult deleteVolumeResult = jcs.deleteVolume(deleteVolumeRequest);
//            System.out.println(deleteVolumeResult.toString());
//            
//        	DescribeVolumesRequest describeVolumesRequest = new DescribeVolumesRequest().withVolumeIds("5388580c-5745-486f-b0c8-6ab363fa0a85");
//        	DescribeVolumesResult describeVolumesResult = jcs.describeVolumes(describeVolumesRequest);
//        	System.out.println(describeVolumesResult.toString());
        	
//        	        	
//        	CreateSnapshotRequest createSnapshotRequest = new CreateSnapshotRequest()
//        													.withVolumeId("5388580c-5745-486f-b0c8-6ab363fa0a85");
//        	CreateSnapshotResult createSnapshotResult = jcs.createSnapshot(createSnapshotRequest);
//        	System.out.println(createSnapshotResult.toString());
        	
//        	DeleteSnapshotRequest deleteSnapshotRequest = new DeleteSnapshotRequest().
//        							withSnapshotId("1613998c-d78a-4504-b474-e175819ca1f9");
//        	DeleteSnapshotResult deleteSnapshotResult = jcs.deleteSnapshot(deleteSnapshotRequest);
//        	System.out.println(deleteSnapshotResult.toString());
//      	
        	DescribeSnapshotsRequest describeSnapshotsRequest = new DescribeSnapshotsRequest().withMaxResults(1);
        	DescribeSnapshotsResult describeSnapshotsResult = jcs.describeSnapshots(describeSnapshotsRequest);
        	System.out.println(describeSnapshotsResult.toString());
        	System.out.println(describeSnapshotsResult.getSnapshots());
        	
        	DescribeVolumesRequest describeVolumesRequest = new DescribeVolumesRequest().withMaxResults(1);
        	DescribeVolumesResult describeVolumesResult = jcs.describeVolumes(describeVolumesRequest);
        	System.out.println(describeVolumesResult.toString());
        	System.out.println(describeVolumesResult.getVolumes());
        	
//        	CreateVolumeRequest createVolumeRequest = new CreateVolumeRequest()
//        						.withSize(10)
//        						.withSnapshotId("a247ced0-4e94-40ec-887c-de3bbb0b19d2");
//        	CreateVolumeResult createVolumeResult = jcs.createVolume(createVolumeRequest);
//        	System.out.println(createVolumeResult.getVolume());
        	
//        	DeleteVolumeRequest deleteVolumeRequest = new DeleteVolumeRequest().withVolumeId("df28d289-0436-48e6-9b0f-07ced523ded2");
//        	DeleteVolumeResult  deleteVolumeResult = jcs.deleteVolume(deleteVolumeRequest);
        
        
        } catch (Exception e) {
        	e.printStackTrace();
        
        }      
 
    }
}


