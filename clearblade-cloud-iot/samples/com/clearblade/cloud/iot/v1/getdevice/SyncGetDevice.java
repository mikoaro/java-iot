package com.clearblade.cloud.iot.v1.getdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncGetDevice {
	static Logger log = Logger.getLogger(SyncGetDevice.class.getName());

	public static void main(String[] args) {
		syncGetDevice();
	}

	public static void syncGetDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String deviceName = "Rashmi_Device_Test";		
		GetDeviceRequest request = GetDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		GetDeviceResponse response = deviceManagerClient.getDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncGetDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "SyncGetDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "SyncGetDevice Method execution failed");
		}
	}


}
