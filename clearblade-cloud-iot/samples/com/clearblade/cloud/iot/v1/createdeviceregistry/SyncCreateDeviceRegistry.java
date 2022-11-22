package com.clearblade.cloud.iot.v1.createdeviceregistry;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.DeviceRegistry;
import com.clearblade.cloud.iot.v1.utils.LocationName;

public class SyncCreateDeviceRegistry {

    public static void main(String[] args) {
        syncCreateDeviceRegistry();
    }

    public static void syncCreateDeviceRegistry() {
        DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
        CreateDeviceRegistryRequest request = CreateDeviceRegistryRequest.Builder.newBuilder()
                .setParent(LocationName.of("ingressdevelopmentenv", "us-central1").toString())
                .setDeviceRegistry(
                        DeviceRegistry.newBuilder().setId("testCreate_reg5").build())
                .build();
        DeviceRegistry response = deviceManagerClient.createDeviceRegistry(request);
        System.out.println(response.toBuilder().getId());

    }
}
