package com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Device;

public class AsyncModifyCloudToDeviceConfig {
	static Logger log = Logger.getLogger(AsyncModifyCloudToDeviceConfig.class.getName());

	public static void main(String[] args) {
		asyncModifyCloudToDeviceConfig();
	}

	public static void asyncModifyCloudToDeviceConfig() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String deviceName = "Rashmi_Device_Test";
		ModifyCloudToDeviceConfigRequest request = ModifyCloudToDeviceConfigRequest.Builder.newBuilder()
				.setDevice(Device.newBuilder().setId(deviceName).setName(deviceName).setNumId(11111).build())
				.setVersionToUpdate("3").setBinaryDataByte(ByteString.EMPTY).build();
		ModifyCloudToDeviceConfigResponse response = deviceManagerClient.modifyCloudToDeviceConfig(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "ModifyCloudToDeviceConfig Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "ModifyCloudToDeviceConfig Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "ModifyCloudToDeviceConfig Method execution failed");
		}
	
	}
}
