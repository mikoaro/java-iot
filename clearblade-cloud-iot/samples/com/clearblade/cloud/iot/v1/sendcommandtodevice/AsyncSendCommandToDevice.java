package com.clearblade.cloud.iot.v1.sendcommandtodevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.utils.ByteString;

public class AsyncSendCommandToDevice {

	static Logger log = Logger.getLogger(AsyncSendCommandToDevice.class.getName());

	public static void main(String[] args) {
		asyncSendCommandToDevice();
	}

	public static void asyncSendCommandToDevice() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String name = "AsyncDeviceTest1";
		
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryDataByte(ByteString.EMPTY).setSubfolder("subfolder1").build();
		
		SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDeviceAsync(request);		
		if (response != null) {
			response.processRequestAsync(request);
			if (response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncSendCommandToDevice Method worked successfully :: {0}",response.getHttpStatusResponse());
			} else {
				log.log(Level.SEVERE, "AsyncSendCommandToDevice Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		} else {
			log.log(Level.SEVERE, "AsyncSendCommandToDevice Method execution failed");
		}

	}
}
