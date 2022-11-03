package com.clearblade.cloud.iot.v1.createdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.CreateDeviceResponse;
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
		String msg = "";
		String registryName = "Rashmi_Registry_Test";
		RegistryName registryNm = RegistryName.newBuilder().setRegistry(registryName).build();
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(registryNm)
				.setDevice(Device.newBuilder().setId("AsyncDeviceTest").setName("AsyncDeviceTest").setNumId(79869).build()).build();
		CreateDeviceResponse response = deviceManagerClient.createDevice(request);
		if (response != null) {			
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncCreateDevice Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "AsyncCreateDevice Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "AsyncCreateDevice Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}
}
