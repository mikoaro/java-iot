package com.clearblade.cloud.iot.v1.test;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceResponse;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceName;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

class DeviceManagerClientTest {

	static Logger log = Logger.getLogger(DeviceManagerClientTest.class.getName());
	DeviceManagerClient client = null;
	String project;
	String location;
	String registry;
	String name;
	String bData; 

	public void setUP() {
		project = "ingressdevelopmentenv";
		location = "central1";
		registry = "Rashmi_Registry_Test";
		name = "Rashmi_Device_Test";
		bData = "c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl";
	}

	
	@Test
	public void sendCommandToDeviceTestFail() {
		setUP();
		client = new DeviceManagerClient();

		DeviceName deviceName = DeviceName.of(project, location, registry, name);
		ByteString binaryData = new ByteString(bData);

		SendCommandToDeviceRequest expectedRequest = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryData(binaryData).setSubfolder("").build();

		SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.Builder.newBuilder()
				.setSendCommandToDeviceRequest(expectedRequest).build();

		expectedResponse.setHttpStatusCode(200);
		expectedResponse.setHttpStatusResponse("OK");

		SendCommandToDeviceResponse actualResponse;
		DeviceName actualDeviceName = DeviceName.of(project, location, registry, "Rashmi_Device");
		ByteString actualBinaryData = new ByteString("");
		SendCommandToDeviceRequest actualRequest = SendCommandToDeviceRequest.Builder.newBuilder()
				.setName(actualDeviceName).setBinaryData(actualBinaryData).setSubfolder("").build();
		actualResponse = client.sendCommandToDevice(actualRequest);
		actualResponse.processRequest(actualRequest);

		Assert.assertEquals(deviceName.getDevice(), actualDeviceName.getDevice());
		Assert.assertEquals(binaryData.getBinaryDataArray(), actualBinaryData.getBinaryDataArray());
		Assert.assertTrue((actualResponse.getHttpStatusResponse()).equals(expectedResponse.getHttpStatusResponse()));
	}

	@Test
	public void sendCommandToDeviceTestPass() {
		DeviceName deviceName = DeviceName.of(project, location, registry, name);
		ByteString binaryData = new ByteString(bData);

		SendCommandToDeviceRequest expectedRequest = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryData(binaryData).setSubfolder("").build();

		SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.Builder.newBuilder()
				.setSendCommandToDeviceRequest(expectedRequest).build();

		expectedResponse.setHttpStatusCode(200);
		expectedResponse.setHttpStatusResponse("OK");

		SendCommandToDeviceResponse actualResponse = SendCommandToDeviceResponse.Builder.newBuilder().build();
		DeviceName actualDeviceName = DeviceName.of(project, location, registry, name);
		ByteString actualBinaryData = binaryData;
		SendCommandToDeviceRequest actualRequest = SendCommandToDeviceRequest.Builder.newBuilder()
				.setName(actualDeviceName).setBinaryData(actualBinaryData).setSubfolder("").build();
		actualResponse.processRequest(actualRequest);

		Assert.assertEquals(deviceName.getDevice(), actualDeviceName.getDevice());
		Assert.assertEquals(binaryData.getBinaryDataArray(), actualBinaryData.getBinaryDataArray());
		Assert.assertTrue((actualResponse.getHttpStatusResponse()).equals(expectedResponse.getHttpStatusResponse()));
	}

  @Test	
  public void createDeviceTest() {
	  	setUP();
	    RegistryName expectedParent = RegistryName.of(project, location, "Rashmi_Registry");
	    Device expectedDevice =
	        Device.newBuilder()
	            .setId("id3355")
	            .setName(DeviceName.of(project, location, registry, name).toString())
	            .setNumId(-1034366860)
	            .build();
		CreateDeviceRequest expectedRequest = CreateDeviceRequest.Builder.newBuilder().setParent(expectedParent).setDevice(expectedDevice).build();
		CreateDeviceResponse expectedResponse = client.createDevice(expectedRequest);

	    RegistryName parent = RegistryName.of(project, location, registry);
		
	    Device device = Device.newBuilder().build();
		CreateDeviceRequest actualRequest = CreateDeviceRequest.Builder.newBuilder()
				.setParent(parent).setDevice(device).build();
		CreateDeviceResponse actualResponse = client.createDevice(actualRequest);

	    Assert.assertEquals(expectedResponse.getHttpStatusResponse(), actualResponse.getHttpStatusResponse());

	    Assert.assertEquals(expectedParent.getRegistry(), parent.getRegistry());
	    Assert.assertEquals(expectedDevice, device);
	    Assert.assertTrue(actualResponse.getHttpStatusResponse().equals(expectedResponse.getHttpStatusResponse()));
	  }
	
	
}


