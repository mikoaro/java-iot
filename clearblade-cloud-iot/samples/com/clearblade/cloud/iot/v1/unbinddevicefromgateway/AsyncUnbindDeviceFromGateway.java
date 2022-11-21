package com.clearblade.cloud.iot.v1.unbinddevicefromgateway;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class AsyncUnbindDeviceFromGateway {
	static Logger log = Logger.getLogger(AsyncUnbindDeviceFromGateway.class.getName());

	public static void main(String[] args) {
		asyncUnbindDeviceFromGateway();
	}

	public static void asyncUnbindDeviceFromGateway() {
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String parent = "Rashmi_Device_Test";
		String gateway = "Rashmi_Gateway_Test";
		String device = "Rashmi_Device_Test";
				
		UnbindDeviceFromGatewayRequest request = UnbindDeviceFromGatewayRequest.Builder.newBuilder().setParent(parent).setGateway(gateway).setDevice(device).build();
		UnbindDeviceFromGatewayResponse response = deviceManagerClient.unbindDeviceFromGateway(request);
		
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				log.log(Level.INFO, "AsyncUnbindDeviceFromGateway Method worked successfully :: {0}",response.getHttpStatusResponse());
			}else {
				log.log(Level.SEVERE, "AsyncUnbindDeviceFromGateway Method execution failed :: {0}",response.getHttpStatusResponse());
			}
		}else {
			log.log(Level.SEVERE, "AsyncUnbindDeviceFromGateway Method execution failed");
		}
	
	}
}
