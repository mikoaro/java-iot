package com.clearblade.cloud.iot.v1.createdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

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
		String registryName = "Rashmi_Registry_Test";
		RegistryName registryNm = RegistryName.newBuilder().setRegistry(registryName).build();
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(registryNm)
				.setDevice(Device.newBuilder().setId("SyncDeviceTest2").setName("SyncDeviceTest2").setNumId(49998).build())
				.setDeviceNumIds(new String[]{"226,556"}).setSubfolder("758").build();
		CreateDeviceResponse response = deviceManagerClient.createDevice(request);
		if (response != null) {			
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncCreateDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.INFO, "SyncCreateDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "SyncCreateDevice Method execution failed");
		}
	}
}
