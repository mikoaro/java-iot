package com.clearblade.cloud.iot.v1.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

class DeviceManagerClientTest {

	private DeviceManagerClient client;
	private Constants constants;
	static Logger log = Logger.getLogger(DeviceManagerClientTest.class.getName());
	
	void init() {
		client = new DeviceManagerClient();
		constants = new Constants();
	}

	@Test
	void testSendCommandToDeviceDeviceNameByteStringString() {
		init();
		int expectedResponse = 200;
		String msg = "";

		DeviceName name = DeviceName.of(constants.getProject(), constants.getLocation(), constants.getRegistry(),
				constants.getDeviceName());
		ByteString binaryData = new ByteString("");

		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(binaryData).setSubFolder(null).build();
		SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(request);
		if (actualResponse != null) {
			actualResponse.processRequest();
			if(actualResponse.getHttpStatusCode() == expectedResponse) {
				msg = "SendCommandToDeviceTest successfully executed";
				log.log(Level.INFO, msg);
			}else {
				msg = "SendCommandToDeviceTest execution failed";
				log.log(Level.WARNING, msg);
				fail(msg);
			}
		} else {
			msg = "SendCommandToDeviceTest execution failed";
			log.log(Level.SEVERE,msg);
			fail(msg);
		}
	}

	@Test
	void testSendCommandToDeviceDeviceNameByteStringStringFail() {
		init();
		int expectedResponse = 200;
		String msg ="";
		DeviceName name = DeviceName.of("","","","");
		ByteString binaryData = new ByteString("");

		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(binaryData).setSubFolder(null).build();
		SendCommandToDeviceResponse actualResponse = client.sendCommandToDevice(request);
		if (actualResponse != null) {
			actualResponse.processRequest();
			if(actualResponse.getHttpStatusCode() != expectedResponse) {
				msg = "SendCommandToDeviceTest Failure Case is Successful";
				log.log(Level.INFO, msg);
			}else {
				msg = "SendCommandToDeviceTest Failure case testing is failed";
				log.log(Level.WARNING,msg);
			}
		}else {
			msg = "SendCommandToDeviceTest Failure case testing is failed";
			log.log(Level.SEVERE, msg);
			fail(msg);
		}
	}

}
