package com.clearblade.cloud.iot.v1.devicestateslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerAsyncClient;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.DeviceName;
import com.clearblade.cloud.iot.v1.utils.DeviceState;

public class AsyncDeviceStatesList {

	static Logger log = Logger.getLogger(AsyncDeviceStatesList.class.getName());

	public static void main(String[] args) {
		asyncDeviceStatesList();
	}

	public static void asyncDeviceStatesList() {
		DeviceManagerAsyncClient deviceManagerClient = new DeviceManagerAsyncClient();

		ListDeviceStatesRequest request = ListDeviceStatesRequest.Builder.newBuilder().setName(DeviceName
				.of("ingressdevelopmentenv", "us-central1", "Rashmi_Registry_Test", "Rashmi_Device_Test")
				.toString()).setNumStates(1643330779).build();
		ListDeviceStatesResponse response = deviceManagerClient.listDeviceStates(request);

		for (DeviceState element : response.getDeviceStatesList()) {
			System.out.println(element.toString());
		}
	}

}
