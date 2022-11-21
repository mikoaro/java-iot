package com.clearblade.cloud.iot.v1.deletedevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class AsyncDeleteDevice {
	static Logger log = Logger.getLogger(AsyncDeleteDevice.class.getName());
	
	public static void main(String[] args) {
		asyncDeleteDevice();
	}

	public static void asyncDeleteDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String deviceName = "AsyncDeviceTest2";
		DeleteDeviceRequest request = DeleteDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		DeleteDeviceResponse response = deviceManagerClient.deleteDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncDeleteDevice Method worked successfully :: {0} ",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "AsyncDeleteDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "AsyncDeleteDevice Method execution failed");
		}
	}

}
