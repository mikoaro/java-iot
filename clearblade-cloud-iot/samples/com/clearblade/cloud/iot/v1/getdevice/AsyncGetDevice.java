package com.clearblade.cloud.iot.v1.getdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.GetDeviceRequest;
import com.clearblade.cloud.iot.v1.GetDeviceResponse;

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
				msg = "AsyncGetDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncGetDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncGetDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
