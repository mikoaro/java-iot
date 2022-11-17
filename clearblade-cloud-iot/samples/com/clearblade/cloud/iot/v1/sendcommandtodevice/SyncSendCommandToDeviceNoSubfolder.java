package com.clearblade.cloud.iot.v1.sendcommandtodevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;

public class SyncSendCommandToDeviceNoSubfolder {
	static Logger log = Logger.getLogger(SyncSendCommandToDeviceNoSubfolder.class.getName());	
	public static void main(String[] args) {
		syncSendCommandToDeviceNoSubfolder();
	}

	public static void syncSendCommandToDeviceNoSubfolder() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String name = "Rashmi_Device_Test";
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryDataByte(ByteString.EMPTY).build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "SyncSendCommandToDeviceNoSubfolder Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "SyncSendCommandToDeviceNoSubfolder Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "SyncSendCommandToDeviceNoSubfolder Method execution failed");
		}
	}

}
