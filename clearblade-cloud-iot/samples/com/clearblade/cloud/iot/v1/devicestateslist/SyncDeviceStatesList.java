package com.clearblade.cloud.iot.v1.devicestateslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncDeviceStatesList {
	static Logger log = Logger.getLogger(SyncDeviceStatesList.class.getName());

	public static void main(String[] args) {
		syncDeviceStatesList();
	}

	public static void syncDeviceStatesList() {
		String name = "Rashmi_Device_Test";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();

		DeviceStatesListRequest request = DeviceStatesListRequest.Builder.newBuilder().setName(name).setNumStates(1643330779).build();
		DeviceStatesListResponse response = deviceManagerClient.deviceStatesList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncDeviceStatesList Method worked successfully ::{0} ",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "SyncDeviceStatesList Method execution failed :: {0}", response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "SyncDeviceStatesList Method execution failed");
		}
	}

}
