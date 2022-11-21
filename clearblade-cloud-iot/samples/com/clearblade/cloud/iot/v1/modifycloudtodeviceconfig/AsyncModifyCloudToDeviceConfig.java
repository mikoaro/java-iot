package com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerAsyncClient;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class AsyncModifyCloudToDeviceConfig {
	static Logger log = Logger.getLogger(AsyncModifyCloudToDeviceConfig.class.getName());

	public static void main(String[] args) {
		asyncModifyCloudToDeviceConfig();
	}

	public static void asyncModifyCloudToDeviceConfig() {
		DeviceManagerAsyncClient deviceManagerClient = new DeviceManagerAsyncClient();
		ModifyCloudToDeviceConfigRequest request = ModifyCloudToDeviceConfigRequest.Builder.newBuilder()
				.setName(DeviceName
						.of("ingressdevelopmentenv", "us-central1", "MandarTest1", "mandar_device")
						.toString())
				.setBinaryData(new ByteString("WWV0QW5vdGhlck1lc3NhZ2U=")).setVersionToUpdate("3").build();
		DeviceConfig response = deviceManagerClient.modifyCloudToDeviceConfig(request);
		System.out.println(response.toString());
	}
}
