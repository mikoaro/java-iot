package com.clearblade.cloud.iot.v1.devicegetconfig;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.GetDeviceConfigRequest;
import com.clearblade.cloud.iot.v1.GetDeviceConfigResponse;

public class AsyncGetDeviceConfig {
	static Logger log = Logger.getLogger(AsyncGetDeviceConfig.class.getName());

	public static void main(String[] args) {
		asyncGetDeviceConfig();
	}

	public static void asyncGetDeviceConfig() {
		String msg = "";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String registryName = "Rashmi_Registry_Test";
		String deviceName = "Rashmi_Device_Test";
		String localVersion = "1";
		GetDeviceConfigRequest request = GetDeviceConfigRequest.Builder.newBuilder().setDeviceName(registryName + "/" + deviceName).setLocalVersion(localVersion)
				.build();
		GetDeviceConfigResponse response = deviceManagerClient.getDeviceConfig(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncGetDeviceConfig Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncGetDeviceConfig Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncGetDeviceConfig Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
