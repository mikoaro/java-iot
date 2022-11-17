package com.clearblade.cloud.iot.v1.devicesetstates;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.DeviceSetStatesRequest;
import com.clearblade.cloud.iot.v1.DeviceSetStatesResponse;
import com.clearblade.cloud.iot.v1.utils.ByteString;

public class AsyncDeviceSetStates {
	static Logger log = Logger.getLogger(AsyncDeviceSetStates.class.getName());

	public static void main(String[] args) {
		asyncDeviceSetStates();
	}

	public static void asyncDeviceSetStates() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String msg = "";
		String registryName = "Rashmi_Registry_Test";
		String deviceName = "Rashmi_Device_Test";
		DeviceSetStatesRequest request = DeviceSetStatesRequest.Builder.newBuilder().setDeviceName(registryName+"/"+deviceName).setBinaryDataByte(ByteString.EMPTY).build();
		DeviceSetStatesResponse response = deviceManagerClient.deviceSetStates(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncDeviceSetStates Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "AsyncDeviceSetStates Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "AsyncDeviceSetStates Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
