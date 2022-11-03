package com.clearblade.cloud.iot.v1.deletedevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeleteDeviceRequest;
import com.clearblade.cloud.iot.v1.DeleteDeviceResponse;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncDeleteDevice {
	static Logger log = Logger.getLogger(SyncDeleteDevice.class.getName());

	public static void main(String[] args) {
		syncDeleteDevice();
	}

	public static void syncDeleteDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String msg = "";
		String deviceName = "SyncDeviceTest2";		
		DeleteDeviceRequest request = DeleteDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		DeleteDeviceResponse response = deviceManagerClient.deleteDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncDeleteDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncDeleteDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncDeleteDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
