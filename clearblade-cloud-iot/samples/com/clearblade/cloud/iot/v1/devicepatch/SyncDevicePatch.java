package com.clearblade.cloud.iot.v1.devicepatch;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.Device;

public class SyncDevicePatch {
	static Logger log = Logger.getLogger(SyncDevicePatch.class.getName());

	public static void main(String[] args) {
		syncDevicePatch();
	}

	public static void syncDevicePatch() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String name = "Rashmi_Device_Test";
		
		Device device = Device.patch(name,name,"ERROR",true);
		String updateMask = "logLevel";
		
		DevicePatchRequest request = DevicePatchRequest.Builder.newBuilder().setName(name).setDevice(device).setUpdateMask(updateMask).build();
		DevicePatchResponse response = deviceManagerClient.devicePatch(request);
		
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncDevicePatch Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "SyncDevicePatch Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "SyncDevicePatch Method execution failed");
		}
	
	}
}
