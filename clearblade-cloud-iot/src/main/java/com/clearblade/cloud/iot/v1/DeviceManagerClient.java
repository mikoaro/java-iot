package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceName;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class DeviceManagerClient {
	Constants constants = null;

	public DeviceManagerClient() {
		init();
	}

	/**
	 * Initialise the Constants object This method will set details like project,
	 * location, registry, device
	 */
	public void init() {
		constants = new Constants();
	}

	/**
	 * SendCommandToDevice method
	 * 
	 * @param name
	 * @param binaryData
	 */
	public void sendCommandToDevice(DeviceName name, com.clearblade.cloud.iot.v1.utils.ByteString binaryData,
			String subFolder) {
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(binaryData).setSubFolder(subFolder).build();
		SendCommandToDeviceResponse response = this.sendCommandToDevice(request);
		response.processRequest();
	}

	/**
	 * Print the response for sendCommandToDevice
	 * 
	 * @param request
	 * @return Response object
	 */
	public SendCommandToDeviceResponse sendCommandToDevice(SendCommandToDeviceRequest request) {
		return (SendCommandToDeviceResponse.Builder.newBuilder().setSendCommandToDeviceRequest(request).build());
	}

	/**
	 * Method used to call createDevice apicall
	 * 
	 * @param parent
	 * @param device
	 * @return Device object
	 */
	public void createDevice(RegistryName parent, Device device) {
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder()
				.setParent(parent == null ? null : parent.toString()).setDevice(device).build();
		CreateDeviceResponse response = this.createDevice(request);
		response.processRequest();
	}

	/**
	 * Print the response for createDevice
	 * 
	 * @param request
	 * @return Response Object
	 */
	public CreateDeviceResponse createDevice(CreateDeviceRequest request) {
		return (CreateDeviceResponse.Builder.newBuilder().setCreateDeviceRequest(request).build());
	}

}
