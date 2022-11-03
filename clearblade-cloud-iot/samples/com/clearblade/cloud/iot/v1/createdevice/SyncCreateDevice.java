package com.clearblade.cloud.iot.v1.createdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.CreateDeviceResponse;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncCreateDevice {
	static Logger log = Logger.getLogger(SyncCreateDevice.class.getName());

	public static void main(String[] args) {
		syncCreateDevice();
	}

	public static void syncCreateDevice() {

		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String msg = "";
		String registryName = "Rashmi_Registry_Test";
		RegistryName registryNm = RegistryName.newBuilder().setRegistry(registryName).build();
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(registryNm)
				.setDevice(Device.newBuilder().setId("SyncDeviceTest2").setName("SyncDeviceTest2").setNumId(79869).build()).build();
		CreateDeviceResponse response = deviceManagerClient.createDevice(request);
		if (response != null) {			
			response.processRequest(request);
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
