package com.clearblade.cloud.iot.v1.devicesconfigversionslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.deviceconfigversionslist.DeviceConfigVersionsListRequest;
import com.clearblade.cloud.iot.v1.deviceconfigversionslist.DeviceConfigVersionsListResponse;

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
				log.log(Level.INFO, "AsyncDevicesConfigVersionsList Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "AsyncDevicesConfigVersionsList Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "AsyncDevicesConfigVersionsList Method execution failed");
		}
	}

}
