package com.clearblade.cloud.iot.v1.devicesconfigversionslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceConfigVersionsListRequest;
import com.clearblade.cloud.iot.v1.DeviceConfigVersionsListResponse;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncDevicesConfigVersionsList {

	static Logger log = Logger.getLogger(SyncDevicesConfigVersionsList.class.getName());

	public static void main(String[] args) {
		syncDevicesConfigVersionsList();
	}

	public static void syncDevicesConfigVersionsList() {
		String msg = "";
		String name = "Rashmi_Device_Test";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();

		DeviceConfigVersionsListRequest request = DeviceConfigVersionsListRequest.Builder.newBuilder().setName(name).setNumVersions("2").build();
		DeviceConfigVersionsListResponse response = deviceManagerClient.deviceConfigVersionsList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncDevicesConfigVersionsList Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "SyncDevicesConfigVersionsList Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "SyncDevicesConfigVersionsList Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
