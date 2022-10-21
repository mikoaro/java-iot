package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Constants;

import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class DeviceManagerClient {
	Constants constants = null;
	/**
	 * Initialise the Constants object 
	 * This method will set details like project, location, registry, device 
	 */
	public void init() {
		constants = new Constants();
	}		 
	
	/**
	 * SendCommandToDevice method
	 * @param name
	 * @param binaryData
	 */
	 public void sendCommandToDevice(DeviceName name, String binaryData) {
		 init();
		 SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder()
					 													.setName(name) 
					 													.setBinaryData(binaryData)
					 													.build();
		 SendCommandToDeviceResponse response = this.sendCommandToDevice(request);
		 //response.processRequest();
		}

	 /**
	  * Print the response for sendCommandToDevice
	  * @param request
	  * @return
	  */
	 public SendCommandToDeviceResponse sendCommandToDevice(SendCommandToDeviceRequest request) {
		 SendCommandToDeviceResponse response = SendCommandToDeviceResponse.Builder.newBuilder()
																		   .setSendCommandToDeviceRequest(request)
																		   .build();
		 return response;
	 }

}
