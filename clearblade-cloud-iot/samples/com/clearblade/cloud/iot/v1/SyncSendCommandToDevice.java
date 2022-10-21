package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SyncSendCommandToDevice {

	  public static void main(String[] args) throws Exception {
	    syncSendCommandToDevice();
	  }

	  public static void syncSendCommandToDevice() throws Exception {
	    DeviceManagerClient deviceManagerClient = new DeviceManagerClient();
	    Constants constants = new Constants();
	    DeviceName name = DeviceName.of(constants.getBuilder().getProject(), constants.getBuilder().getLocation(), constants.getBuilder().getRegistry(), constants.getBuilder().getDevice());
	    SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder
	    															   .newBuilder()
	              													   .setName(name)
	              													   .setBinaryData("c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl")
	              													   .build();
	    SendCommandToDeviceResponse response = deviceManagerClient.sendCommandToDevice(request);
	    response.processRequest();
		 if(response != null) {			 
			 System.out.println("POST Response is :: " + response.toString());
		 }
	  }
	}
