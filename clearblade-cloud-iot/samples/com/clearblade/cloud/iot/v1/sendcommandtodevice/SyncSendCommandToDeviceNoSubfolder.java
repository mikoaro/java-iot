package com.clearblade.cloud.iot.v1.sendcommandtodevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.utils.ByteString;

public class SyncSendCommandToDeviceNoSubfolder {
	static Logger log = Logger.getLogger(SyncSendCommandToDeviceNoSubfolder.class.getName());	
	public static void main(String[] args) {
		syncSendCommandToDeviceNoSubfolder();
	}

	public static void syncSendCommandToDeviceNoSubfolder() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String msg = "";
		String name = "Rashmi_Device_Test";
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryDataByte(ByteString.EMPTY).build();
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncSendCommandToDeviceNoSubfolder Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "SyncSendCommandToDeviceNoSubfolder Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "SyncSendCommandToDeviceNoSubfolder Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}

}
