package com.clearblade.cloud.iot.v1.test;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.clearblade.cloud.iot.v1.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

class DeviceManagerClientTest {

	static Logger log = Logger.getLogger(DeviceManagerClientTest.class.getName());

	@Test
	public void sendCommandToDeviceTest() throws Exception {
		SendCommandToDeviceResponse expectedResponse = SendCommandToDeviceResponse.Builder.newBuilder().build();
		String project = "ingressdevelopmentenv";
		String location = "central1";
		String registry = "Rashmi_Registry_Test";
		String name = "Rashmi_Device_Test";
		DeviceName deviceName = DeviceName.of(project, location, registry, name);
		ByteString binaryData = new ByteString("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl");
		SendCommandToDeviceRequest expectedRequest = SendCommandToDeviceRequest.Builder.newBuilder().setName(deviceName)
				.setBinaryData(binaryData).setSubfolder("subfolder1").build();
		expectedResponse.processRequest(expectedRequest);

		SendCommandToDeviceResponse actualResponse = SendCommandToDeviceResponse.Builder.newBuilder().build();
		DeviceName actualDeviceName = DeviceName.of(project, location, registry, "Rashmi_Device");
		ByteString actualBinaryData = new ByteString("");
		SendCommandToDeviceRequest actualRequest = SendCommandToDeviceRequest.Builder.newBuilder()
				.setName(actualDeviceName).setBinaryData(actualBinaryData).setSubfolder("").build();
		actualResponse.processRequest(actualRequest);

		Assert.assertEquals(expectedResponse, actualResponse);

		Assert.assertEquals(deviceName.toString(), actualDeviceName.toString());
		Assert.assertEquals(binaryData, actualBinaryData);
		Assert.assertTrue((actualResponse.getHttpStatusResponse()).equals(expectedResponse.getHttpStatusResponse()));
	}

}
