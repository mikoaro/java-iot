package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceName;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class DeviceManagerClient {

	/**
	 * SendCommandToDevice method
	 * 
	 * @param name
	 * @param binaryData
	 */
	public void sendCommandToDevice(DeviceName name, com.clearblade.cloud.iot.v1.utils.ByteString binaryData,
			String subfolder) {
		SendCommandToDeviceRequest request = SendCommandToDeviceRequest.Builder.newBuilder().setName(name)
				.setBinaryData(binaryData).setSubfolder(subfolder).build();
		this.sendCommandToDevice(request);
		SendCommandToDeviceResponse response = this.sendCommandToDevice(request);
		response.processRequest(request);
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
	 * Method used to call createDevice api call
	 * 
	 * @param parent
	 * @param device
	 * @return Device object
	 */
	public void createDevice(RegistryName parent, Device device) {
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder()
				.setParent(parent == null ? null : parent).setDevice(device).build();
		CreateDeviceResponse response = this.createDevice(request);
		response.processRequest(request);
	}

	/**
	 * Method used to call deleteDevice api
	 * 
	 * @param request
	 * @return Response Object
	 */
	public CreateDeviceResponse createDevice(CreateDeviceRequest request) {
		return (CreateDeviceResponse.Builder.newBuilder().setCreateDeviceRequest(request).build());
	}

	public final void deleteDevice(DeviceName name) {
		DeleteDeviceRequest request = DeleteDeviceRequest.Builder.newBuilder().setDeviceName(name == null ? null : name.toString())
				.build();
		deleteDevice(request);
	}

	/**
	 * Print the response for deleteDevice
	 * 
	 * @param request
	 * @return Response object
	 */
	public DeleteDeviceResponse deleteDevice(DeleteDeviceRequest request) {
		return (DeleteDeviceResponse.Builder.newBuilder().setDeleteDeviceRequest(request).build());
	}

	/**
	 * Method used to call getDevice api
	 * @param name
	 * @return Device object
	 */
	public void getDevice(DeviceName name) {
		    GetDeviceRequest request = GetDeviceRequest.Builder.newBuilder().setDeviceName(name == null ? null : name.toString()).build();
		    getDevice(request);
	}

	/**
	 * Print the response for getDevice
	 * 
	 * @param request
	 * @return Response object
	 */
	public GetDeviceResponse getDevice(GetDeviceRequest request) {
		return (GetDeviceResponse.Builder.newBuilder().setGetDeviceRequest(request).build());
	}
	
}
