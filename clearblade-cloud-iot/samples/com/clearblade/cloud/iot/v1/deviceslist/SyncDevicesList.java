package com.clearblade.cloud.iot.v1.deviceslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncDevicesList {
	static Logger log = Logger.getLogger(SyncDevicesList.class.getName());

	public static void main(String[] args){
		syncDevicesList();
	}

	public static void syncDevicesList(){
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		RegistryName parent = RegistryName.of("ingressdevelopmentenv","us-central1","Rashmi_Registry_Test");
		DevicesListRequest request = DevicesListRequest.Builder.newBuilder().setParent(parent).build();
		DevicesListResponse response = deviceManagerClient.devicesList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncDevicesList Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "SyncDevicesList Method execution failed :: {0}", response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "SyncDevicesList Method execution failed");
		}
		
	}

}
