package com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.DocFlavor.BYTE_ARRAY;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncModifyCloudToDeviceConfig {
	static Logger log = Logger.getLogger(SyncModifyCloudToDeviceConfig.class.getName());

	public static void main(String[] args) {
		syncModifyCloudToDeviceConfig();
	}

	public static void syncModifyCloudToDeviceConfig() {

		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		ModifyCloudToDeviceConfigRequest request = ModifyCloudToDeviceConfigRequest.Builder.newBuilder()
				.setName(DeviceName
						.of("ingressdevelopmentenv", "us-central1", "MandarTest1", "mandar_device")
						.toString())
				.setBinaryData(new ByteString("bmV3TWVzc2FnZUZvckNvbmZpZw==")).setVersionToUpdate("2").build();
		DeviceConfig response = deviceManagerClient.modifyCloudToDeviceConfig(request);
		System.out.println(response.toString());
	}
}
