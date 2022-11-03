package com.clearblade.cloud.iot.v1.getdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

import com.clearblade.cloud.iot.v1.GetDeviceRequest;
import com.clearblade.cloud.iot.v1.GetDeviceResponse;

public class SyncGetDevice {
	static Logger log = Logger.getLogger(SyncGetDevice.class.getName());

	public static void main(String[] args) {
		syncGetDevice();
	}

	public static void syncGetDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String msg = "";
		String deviceName = "Rashmi_Device_Test";		
		GetDeviceRequest request = GetDeviceRequest.Builder.newBuilder().setDeviceName(deviceName).build();
		GetDeviceResponse response = deviceManagerClient.getDevice(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncGetDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "SyncGetDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "SyncGetDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}


}
