package com.clearblade.cloud.iot.v1.unbinddevicefromgateway;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerClient;
import com.clearblade.cloud.iot.v1.UnbindDeviceFromGatewayRequest;
import com.clearblade.cloud.iot.v1.UnbindDeviceFromGatewayResponse;

public class SyncUnbindDeviceFromGateway {
	static Logger log = Logger.getLogger(SyncUnbindDeviceFromGateway.class.getName());

	public static void main(String[] args) {
		syncUnbindDeviceFromGateway();
	}

	public static void syncUnbindDeviceFromGateway() {
		String msg = "";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String parent = "Rashmi_Device_Test";
		String gateway = "Rashmi_Gateway_Test";
		String device = "Rashmi_Device_Test";
				
		UnbindDeviceFromGatewayRequest request = UnbindDeviceFromGatewayRequest.Builder.newBuilder().setParent(parent).setGateway(gateway).setDevice(device).build();
		UnbindDeviceFromGatewayResponse response = deviceManagerClient.unbindDeviceFromGateway(request);
		
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncUnbindDeviceFromGateway Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "SyncUnbindDeviceFromGateway Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "SyncUnbindDeviceFromGateway Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	
	}
}
