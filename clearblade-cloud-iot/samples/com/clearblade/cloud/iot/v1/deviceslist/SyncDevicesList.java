package com.clearblade.cloud.iot.v1.deviceslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.DevicesListRequest;
import com.clearblade.cloud.iot.v1.DevicesListResponse;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncDevicesList {
	static Logger log = Logger.getLogger(SyncDevicesList.class.getName());

	public static void main(String[] args){
		syncDevicesList();
	}

	public static void syncDevicesList(){
		String msg = "";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		ConfigParameters configParams = new ConfigParameters();
		RegistryName parent = RegistryName.of(configParams.getProject(), configParams.getLocation(), configParams.getRegistry());
		DevicesListRequest request = DevicesListRequest.Builder.newBuilder().setParent(parent).build();
		DevicesListResponse response = deviceManagerClient.devicesList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncDevicesList Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "SyncDevicesList Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "SyncDevicesList Method execution failed";
			log.log(Level.SEVERE, msg);
		}
		
	}

}
