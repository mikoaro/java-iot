package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncSendCommandToDevice {

	public static void main(String[] args) {
		syncSendCommandToDevice();
	}

	public static void syncSendCommandToDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		Constants constants = new Constants();
		DeviceName name = DeviceName.of(constants.getBuilder().getProject(), constants.getBuilder().getLocation(),
				constants.getBuilder().getRegistry(), constants.getBuilder().getDevice());
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(new ByteString("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl")).setSubFolder("subfolder153561774").build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest();
			System.out.println("POST Response is :: " + response.toString());
		}
	}
}
