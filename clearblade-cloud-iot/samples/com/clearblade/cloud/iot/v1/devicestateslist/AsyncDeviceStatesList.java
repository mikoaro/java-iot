package com.clearblade.cloud.iot.v1.devicestateslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class AsyncDeviceStatesList {

	static Logger log = Logger.getLogger(AsyncDeviceStatesList.class.getName());

	public static void main(String[] args) {
		asyncDeviceStatesList();
	}

	public static void asyncDeviceStatesList() {
		String name = "Rashmi_Device_Test";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();

		DeviceStatesListRequest request = DeviceStatesListRequest.Builder.newBuilder().setName(name).setNumStates(1643330779).build();
		DeviceStatesListResponse response = deviceManagerClient.deviceStatesList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncDeviceStatesList Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "AsyncDeviceStatesList Method execution failed :: {0} ",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "AsyncDeviceStatesList Method execution failed");
		}
	}

}
