package com.clearblade.cloud.iot.v1.getdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class AsyncGetDevice {
	static Logger log = Logger.getLogger(AsyncGetDevice.class.getName());

	public static void main(String[] args) {
		asyncGetDevice();
	}

	public static void asyncGetDevice() {
		String msg = "";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String deviceName = "myOldDevice";
		GetDeviceRequest request = GetDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		GetDeviceResponse response = deviceManagerClient.getDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncGetDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "AsyncGetDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "AsyncGetDevice Method execution failed");
		}
	}

}
