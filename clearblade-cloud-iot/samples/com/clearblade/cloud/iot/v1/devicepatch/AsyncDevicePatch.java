package com.clearblade.cloud.iot.v1.devicepatch;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.Device;

public class AsyncDevicePatch {
	static Logger log = Logger.getLogger(AsyncDevicePatch.class.getName());

	public static void main(String[] args) {
		asyncDevicePatch();
	}

	public static void asyncDevicePatch() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String name = "Rashmi_Device_Test";
		
		Device device = Device.patch(name,name,"NONE",true);
		String updateMask = "logLevel";
		
		DevicePatchRequest request = DevicePatchRequest.Builder.newBuilder().setName(name).setDevice(device).setUpdateMask(updateMask).build();
		DevicePatchResponse response = deviceManagerClient.devicePatch(request);
		
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncDevicePatch Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "AsyncDevicePatch Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "AsyncDevicePatch Method execution failed");
		}
	
	}
}
