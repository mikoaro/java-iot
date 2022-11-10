package com.clearblade.cloud.iot.v1.devicesconfigversionslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceConfigVersionsListRequest;
import com.clearblade.cloud.iot.v1.DeviceConfigVersionsListResponse;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class AsyncDevicesConfigVersionsList {

	static Logger log = Logger.getLogger(AsyncDevicesConfigVersionsList.class.getName());

	public static void main(String[] args) {
		asyncDevicesConfigVersionsList();
	}

	public static void asyncDevicesConfigVersionsList() {
		String msg = "";
		String name = "Rashmi_Device_Test";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();

		DeviceConfigVersionsListRequest request = DeviceConfigVersionsListRequest.Builder.newBuilder().setName(name).setNumVersions("2").build();
		DeviceConfigVersionsListResponse response = deviceManagerClient.deviceConfigVersionsList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncDevicesConfigVersionsList Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncDevicesConfigVersionsList Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncDevicesConfigVersionsList Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
