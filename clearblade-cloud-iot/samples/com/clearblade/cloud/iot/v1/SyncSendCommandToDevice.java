package com.clearblade.cloud.iot.v1;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncSendCommandToDevice {

	static Logger log = Logger.getLogger(SyncSendCommandToDevice.class.getName());	
	public static void main(String[] args) {
		syncSendCommandToDevice();
	}

	public static void syncSendCommandToDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		Constants constants = new Constants();
		String msg = "";
		com.clearblade.cloud.iot.v1.utils.DeviceName name = DeviceName.of(constants.getProject(), constants.getLocation(),
				constants.getRegistry(), constants.getDeviceName());
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(new ByteString("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl")).setSubFolder("subfolder153561774").build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest();
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncSendCommandToDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "SyncSendCommandToDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "SyncSendCommandToDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}
}
