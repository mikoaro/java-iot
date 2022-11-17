package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.ByteString;
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

	/**
	 * Method used to call devicesList api
	 * @param parent
	 * @return Device object
	 */
	public void devicesList(RegistryName parent) {
		    DevicesListRequest request = DevicesListRequest.Builder.newBuilder().setParent(parent).build();
		    devicesList(request);
	}

	/**
	 * Print the response for deviceList
	 * 
	 * @param request
	 * @return Response object
	 */
	public DevicesListResponse devicesList(DevicesListRequest request) {
		return (DevicesListResponse.Builder.newBuilder().setDevicesListRequest(request).build());
	}

	/**
	 * Method used to call deviceStatesList api
	 * @param parent
	 * @return Device object
	 */
	public void deviceStatesList(String name, int numStates) {
			DeviceStatesListRequest request = DeviceStatesListRequest.Builder.newBuilder().setName(name).setNumStates(numStates).build();
		    deviceStatesList(request);
	}

	/**
	 * Print the response for deviceStatesList
	 * 
	 * @param request
	 * @return Response object
	 */
	public DeviceStatesListResponse deviceStatesList(DeviceStatesListRequest request) {
		return (DeviceStatesListResponse.Builder.newBuilder().setDeviceStatesListRequest(request).build());
	}

	/**
	 * DeviceSetStates method
	 * 
	 * @param name, method
	 * @param binaryData
	 */
	public void devicesSetStates(String name, ByteString binaryData) {
		DeviceSetStatesRequest request = DeviceSetStatesRequest.Builder.newBuilder().setDeviceName(name)
				.setBinaryData(binaryData).build();
		this.deviceSetStates(request);
		DeviceSetStatesResponse response = this.deviceSetStates(request);
		response.processRequest(request);
	}
	/**
	 * Print the response for DeviceSetStatesRequest
	 * 
	 * @param request
	 * @return Response object
	 */
	public DeviceSetStatesResponse deviceSetStates(DeviceSetStatesRequest request) {
		return (DeviceSetStatesResponse.Builder.newBuilder().setDeviceSetStatesRequest(request).build());
	}

	/**
	 * Method used to call getDeviceConfig api
	 * @param name
	 * @return Device Config - binary Data and version
	 */
	public void getDeviceConfig(DeviceName name,String localVersion) {
		    GetDeviceConfigRequest request = GetDeviceConfigRequest.Builder.newBuilder().setDeviceName(name == null ? null : name.toString()).setLocalVersion(localVersion).build();
		    getDeviceConfig(request);
	}

	/**
	 * Print the response for getDeviceConfig
	 * 
	 * @param request
	 * @return Response object
	 */
	public GetDeviceConfigResponse getDeviceConfig(GetDeviceConfigRequest request) {
		return (GetDeviceConfigResponse.Builder.newBuilder().setGetDeviceConfigRequest(request).build());
	}

	/**
	 * ModifyCloudToDeviceConfig method
	 * 
	 * @param device object
	 * @param versionToUpdate
	 * @param binaryData
	 */
	public void modifyCloudToDeviceConfig(Device device, com.clearblade.cloud.iot.v1.utils.ByteString binaryData, String versionToUpdate) {
		ModifyCloudToDeviceConfigRequest request = ModifyCloudToDeviceConfigRequest.Builder.newBuilder().setDevice(device)
																						   .setBinaryData(binaryData).setVersionToUpdate(versionToUpdate).build();
		this.modifyCloudToDeviceConfig(request);
		ModifyCloudToDeviceConfigResponse response = this.modifyCloudToDeviceConfig(request);
		response.processRequest(request);
	}
	/**
	 * Print the response for ModifyCloudToDeviceConfig
	 * 
	 * @param request
	 * @return Response object
	 */
	public ModifyCloudToDeviceConfigResponse modifyCloudToDeviceConfig(ModifyCloudToDeviceConfigRequest request) {
		return (ModifyCloudToDeviceConfigResponse.Builder.newBuilder().setModifyCloudToDeviceConfigRequest(request).build());
	}


	/**
	 * Method used to call DeviceConfigVersionsList api
	 * @param name and numVersions
	 */
	public void deviceConfigVersionsList(String name, String numVersions) {
		DeviceConfigVersionsListRequest request = DeviceConfigVersionsListRequest.Builder.newBuilder().setName(name).setNumVersions(numVersions).build();
		deviceConfigVersionsList(request);
	}

	/**
	 * Print the response for deviceConfigVersionsList
	 *  
	 * @param request
	 * @return Response object
	 */
	public DeviceConfigVersionsListResponse deviceConfigVersionsList(DeviceConfigVersionsListRequest request) {
		return (DeviceConfigVersionsListResponse.Builder.newBuilder().setDeviceConfigVersionsListRequest(request).build());
	}


}

