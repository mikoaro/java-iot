package com.clearblade.cloud.iot.v1.listdeviceconfigversions;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncListDeviceConfigVersions {

	static Logger log = Logger.getLogger(SyncListDeviceConfigVersions.class.getName());

	public static void main(String[] args) {
		syncDevicesConfigVersionsList();
	}

	public static void syncDevicesConfigVersionsList() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		ListDeviceConfigVersionsRequest request = ListDeviceConfigVersionsRequest.Builder.newBuilder().setName(DeviceName
				.of("ingressdevelopmentenv", "us-central1", "Rashmi_Registry_Test", "Rashmi_Device_Test")
				.toString()).setNumVersions(2).build();
		ListDeviceConfigVersionsResponse response = deviceManagerClient.listDeviceConfigVersions(request);
		for (DeviceConfig element : response.getDeviceConfigList()) {
			System.out.println(element.toString());
		}
	}

}
