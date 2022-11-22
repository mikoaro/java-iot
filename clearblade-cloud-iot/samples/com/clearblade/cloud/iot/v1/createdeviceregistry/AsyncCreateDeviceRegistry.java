package com.clearblade.cloud.iot.v1.createdeviceregistry;

import com.clearblade.cloud.iot.v1.DeviceManagerAsyncClient;
import com.clearblade.cloud.iot.v1.utils.DeviceRegistry;
import com.clearblade.cloud.iot.v1.utils.LocationName;

public class AsyncCreateDeviceRegistry {
    public static void main(String[] args) {
        asyncCreateDeviceRegistry();
    }

    public static void asyncCreateDeviceRegistry() {
        DeviceManagerAsyncClient deviceManagerClient = new DeviceManagerAsyncClient();
        CreateDeviceRegistryRequest request = CreateDeviceRegistryRequest.Builder.newBuilder()
                .setParent(LocationName.of("ingressdevelopmentenv", "us-central1").toString())
                .setDeviceRegistry(
                        DeviceRegistry.newBuilder().setId("testCreate_reg3").build())
                .build();
        DeviceRegistry response = deviceManagerClient.createDeviceRegistry(request);
        System.out.println(response.toBuilder().getId());

    }

}
