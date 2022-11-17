package com.clearblade.cloud.iot.v1.createdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class AsyncCreateDevice {
	static Logger log = Logger.getLogger(AsyncCreateDevice.class.getName());

	public static void main(String[] args) {
		asyncCreateDevice();
	}

	public static void asyncCreateDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String registryName = "Rashmi_Registry_Test";
		RegistryName registryNm = RegistryName.newBuilder().setRegistry(registryName).build();
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(registryNm)
				.setDevice(Device.newBuilder().setId("AsyncDeviceTest2").setName("AsyncDeviceTest2").setNumId(11112).build())
				.setDeviceNumIds(new String[]{"133,134"}).setSubfolder("784").build();
		CreateDeviceResponse response = deviceManagerClient.createDevice(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncCreateDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.INFO, "AsyncCreateDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "AsyncCreateDevice Method execution failed");
		}
	}
}
