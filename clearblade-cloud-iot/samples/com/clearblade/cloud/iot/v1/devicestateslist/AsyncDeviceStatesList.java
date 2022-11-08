package com.clearblade.cloud.iot.v1.devicestateslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.DeviceStatesListRequest;
import com.clearblade.cloud.iot.v1.DeviceStatesListResponse;

public class AsyncDeviceStatesList {

	static Logger log = Logger.getLogger(AsyncDeviceStatesList.class.getName());

	public static void main(String[] args) {
		asyncDeviceStatesList();
	}

	public static void asyncDeviceStatesList() {
		String msg = "";
		String name = "Rashmi_Device_Test";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();

		DeviceStatesListRequest request = DeviceStatesListRequest.Builder.newBuilder().setName(name).setNumStates(1643330779).build();
		DeviceStatesListResponse response = deviceManagerClient.deviceStatesList(request);
		if (response != null) {
			response.processRequest(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncDeviceStatesList Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncDeviceStatesList Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncDeviceStatesList Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
