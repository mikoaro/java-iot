package com.clearblade.cloud.iot.v1.binddevicetogateway;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.BindDeviceToGatewayRequest;
import com.clearblade.cloud.iot.v1.BindDeviceToGatewayResponse;
import com.clearblade.cloud.iot.v1.DeviceManagerClient;

public class SyncBindDeviceToGateway {
	static Logger log = Logger.getLogger(SyncBindDeviceToGateway.class.getName());

	public static void main(String[] args) {
		syncBindDeviceToGateway();
	}

	public static void syncBindDeviceToGateway() {
		String msg = "";
		DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
		String parent = "Rashmi_Device_Test";
		String gateway = "Rashmi_Gateway_Test";
		String device = "Rashmi_Device_Test";
				
		BindDeviceToGatewayRequest request = BindDeviceToGatewayRequest.Builder.newBuilder().setParent(parent).setGateway(gateway).setDevice(device).build();
		BindDeviceToGatewayResponse response = deviceManagerClient.bindDeviceToGateway(request);
		
		if (response != null) {
			response.processRequest(request);
			if(response.getHttpStatusResponse().equals("OK")) {
				msg = "SyncBindDeviceToGateway Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			}else {
				msg = "SyncBindDeviceToGateway Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		}else {
			msg = "SyncBindDeviceToGateway Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	
	}
}
