package com.clearblade.cloud.iot.v1;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncCreateDevice {
	static Logger log = Logger.getLogger(SyncCreateDevice.class.getName());

	public static void main(String[] args) {
		syncCreateDevice();
	}

	public static void syncCreateDevice() {

		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		Constants constants = new Constants();
		String msg = "";
		RegistryName registryName = RegistryName.of(constants.getProject(), constants.getLocation(),
				constants.getRegistry());
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(registryName.toString())
				.setDevice(Device.newBuilder().build()).build();
		CreateDeviceResponse response = deviceManagerClient.createDevice(request);
		if (response != null) {			
			response.processRequest();
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncCreateDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "SyncCreateDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "SyncCreateDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}
}
