package com.clearblade.cloud.iot.v1.sendcommandtodevice;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;

public class SyncSendCommandToDevice {

	static Logger log = Logger.getLogger(SyncSendCommandToDevice.class.getName());	
	public static void main(String[] args) {
		syncSendCommandToDevice();
	}

	public static void syncSendCommandToDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String name = "SyncDeviceTest1";
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryData(new ByteString("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl")).setSubfolder("subfolder1").build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncSendCommandToDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "SyncSendCommandToDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "SyncSendCommandToDevice Method execution failed");
		}
	}
}
