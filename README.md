**JCSsdk**
=====================

Download or clone this project. One can generate and refer to complete javadocs for this project.
In eclipse javadocs can be generated through *Project->Generate Javadoc..*. After generating javadocs,
click on *index.html* inside *doc* folder of the project.
You can also read the documentation on all major classes in the package under the documentation folder.
The examples folder contains examples on how to use each api.
Some basic examples for using the SDK is given in this README itself.


Before using the SDK:
=====================

CA-CERTIFICATE INSTALLATION:
----------------------------

- 
**Get the ca-certificate for JIO cloud services from JIO Cloud Team and install it**

- For Linux : Place the ca-certificate inside the folder 
*/usr/local/share/ca-certificates/* and then run *update-ca-certificates --fresh* in terminal

- For Mac : 
- For Windows :


- 
**Import ca-certificate in java keytool:**

- For Linux: run in terminal:
> sudo keytool -import -trustcacerts -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit -noprompt -alias "CACERT_NAME" -file /usr/local/share/ca-certificates/"CACERT_Name"
- For Mac:
- For Windows:


Setting up the Project:
-----------------------

The following properties must be set for proper working of this SDK:

- BASE_URL
- ACCESS_KEY
- SECRET_KEY

You can set these properties in any of the following locations:

- Environment Variables
- Java System Properties
- In 
*config.properties* file under *src/main/resources* folder of the project in which this SDK will be used.


Maven Configuration:
--------------------

- Install maven in your system.
- Run in terminal:
> mvn clean install
- Convert (if not already) the java project, in which SDK is to be used, to maven project.
- In pom.xml of your project, add following dependency and then run your project as maven install:

```xml
	<dependency>
		<groupId>com.jcs.sbs</groupId>
		<artifactId>jcs-java-sdk-sbs</artifactId>
		<version>1.0.0</version>
		<scope>compile</scope>
	</dependency>
```
- Now you can use the methods available in the SDK to instantiate JCSCompute and then "describe/create/delete" "snapshots/volumes"


Examples:
---------


**Describe Volume**

Here is the example code that describes a volume:

	public void describeVolumeExample(){
	
		JCSCredentialsProvider credentialsProviders = new DefaultJCSCredentialsProviderChain();
		JCSCredentials credentials = credentialsProviders.getCredentials();
		JCSCompute jcs = new JCSComputeClient(credentials);
		
		try {
			
			DescribeVolumesRequest describeVolumesRequest = new DescribeVolumesRequest();
			DescribeVolumesResult describeVolumesResult = jcs.describeVolumes(describeVolumesRequest);
			System.out.println(describeVolumesResult.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}