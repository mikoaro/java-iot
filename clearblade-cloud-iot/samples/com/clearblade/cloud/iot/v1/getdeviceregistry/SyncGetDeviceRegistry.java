package com.clearblade.cloud.iot.v1.getdeviceregistry;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerAsyncClient;
import com.clearblade.cloud.iot.v1.utils.DeviceRegistry;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class SyncGetDeviceRegistry {
	static Logger log = Logger.getLogger(SyncGetDeviceRegistry.class.getName());

	public static void main(String[] args) {
		syncGetDeviceRegistry();
	}

	public static void syncGetDeviceRegistry() {
		DeviceManagerAsyncClient deviceManagerAsyncClient = new DeviceManagerAsyncClient();
		GetDeviceRegistryRequest request = GetDeviceRegistryRequest.Builder.newBuilder()
				.setName(RegistryName.of("ingressdevelopmentenv", "us-central1", "MandarTest1").getRegistryFullName())
		        .build();
		DeviceRegistry response = deviceManagerAsyncClient.getDeviceRegistry(request);
		System.out.println(response.createDeviceJSONObject(""));
	}

}
