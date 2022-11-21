package com.clearblade.cloud.iot.v1.sendcommandtodevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncSendCommandToDeviceDeviceName {
	static Logger log = Logger.getLogger(SyncSendCommandToDeviceDeviceName.class.getName());	
	public static void main(String[] args) {
		syncSendCommandToDeviceDeviceName();
	}

	public static void syncSendCommandToDeviceDeviceName() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String project = "ingressdevelopmentenv";
		String location = "central1";
		String registry = "Rashmi_Registry_Test";
		String name = "Rashmi_Device_Test";
		DeviceName deviceName = DeviceName.of(project, location, registry, name);
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(deviceName)
				.setBinaryData(new ByteString("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl")).setSubfolder("subfolder1").build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncSendCommandToDeviceDeviceName Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "SyncSendCommandToDeviceDeviceName Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "SyncSendCommandToDeviceDeviceName Method execution failed");
		}
	}

}
