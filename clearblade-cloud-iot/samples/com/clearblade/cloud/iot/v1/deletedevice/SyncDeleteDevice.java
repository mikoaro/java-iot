package com.clearblade.cloud.iot.v1.deletedevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncDeleteDevice {
	static Logger log = Logger.getLogger(SyncDeleteDevice.class.getName());

	public static void main(String[] args) {
		syncDeleteDevice();
	}

	public static void syncDeleteDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String deviceName = "SyncDeviceTest2";	
		DeleteDeviceRequest request = DeleteDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		DeleteDeviceResponse response = deviceManagerClient.deleteDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncDeleteDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "SyncDeleteDevice Method execution failed :: {0}", response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "SyncDeleteDevice Method execution failed");
		}
	}

}
