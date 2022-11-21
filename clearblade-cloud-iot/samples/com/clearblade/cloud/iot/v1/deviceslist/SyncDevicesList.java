package com.clearblade.cloud.iot.v1.deviceslist;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.GatewayListOptions;
import com.clearblade.cloud.iot.v1.utils.GatewayType;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncDevicesList {
	static Logger log = Logger.getLogger(SyncDevicesList.class.getName());

	public static void main(String[] args) {
		syncDevicesList();
	}

	public static void syncDevicesList() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		RegistryName parent = RegistryName.of("ingressdevelopmentenv", "us-central1", "MandarTest1");
		DevicesListRequest request = DevicesListRequest.Builder.newBuilder().setParent(parent.toString())
				.setGatewayListOptions(GatewayListOptions.newBuilder().setGatewayType(GatewayType.NON_GATEWAY).build())
				.setPageSize(2)
				.build();
		DevicesListResponse response = deviceManagerClient.listDevices(request);

		for (Device element : response.getDevicesList()) {
			System.out.println(element.toBuilder().getName());

		}
		System.out.println(response.getNextPageToken());
	}

}
