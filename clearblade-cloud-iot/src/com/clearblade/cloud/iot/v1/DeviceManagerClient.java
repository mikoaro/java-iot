package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayRequest;
import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayResponse;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceResponse;
import com.clearblade.cloud.iot.v1.deletedevice.DeleteDeviceRequest;
import com.clearblade.cloud.iot.v1.deletedevice.DeleteDeviceResponse;
import com.clearblade.cloud.iot.v1.deviceconfigversionslist.DeviceConfigVersionsListRequest;
import com.clearblade.cloud.iot.v1.deviceconfigversionslist.DeviceConfigVersionsListResponse;
import com.clearblade.cloud.iot.v1.devicepatch.DevicePatchRequest;
import com.clearblade.cloud.iot.v1.devicepatch.DevicePatchResponse;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListRequest;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListResponse;
import com.clearblade.cloud.iot.v1.devicestateslist.DeviceStatesListRequest;
import com.clearblade.cloud.iot.v1.devicestateslist.DeviceStatesListResponse;
import com.clearblade.cloud.iot.v1.getdevice.GetDeviceRequest;
import com.clearblade.cloud.iot.v1.getdevice.GetDeviceResponse;
import com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig.ModifyCloudToDeviceConfigRequest;
import com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig.ModifyCloudToDeviceConfigResponse;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayRequest;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayResponse;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceName;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class DeviceManagerClient {


	/**
	 * Print the response for sendCommandToDevice
	 * 
	 * @param request
	 * @return Response object
	 */
	public SendCommandToDeviceResponse sendCommandToDeviceAsync(SendCommandToDeviceRequest request) {
		return (SendCommandToDeviceResponse.Builder.newBuilder().setSendCommandToDeviceRequest(request).build());
	}
	
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
	 * ModifyCloudToDeviceConfig method
	 * 
	 * @param device object
	 * @param versionToUpdate
	 * @param binaryData
	 */
	public void modifyCloudToDeviceConfig(Device device, com.clearblade.cloud.iot.v1.utils.ByteString binaryData, String versionToUpdate) {
		ModifyCloudToDeviceConfigRequest request = ModifyCloudToDeviceConfigRequest.Builder.newBuilder().setDevice(device)
																						   .setBinaryData(binaryData).setVersionToUpdate(versionToUpdate).build();
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

	/**
	 * bindDeviceToGateway method
	 * @param parent
	 * @param gatewayId
	 * @param deviceId
	 */
	public void bindDeviceToGateway(String parent, String gatewayId, String deviceId) {
		BindDeviceToGatewayRequest request = BindDeviceToGatewayRequest.Builder.newBuilder().setParent(parent).setGateway(gatewayId).setDevice(deviceId).build();
		BindDeviceToGatewayResponse response = this.bindDeviceToGateway(request);
		response.processRequest(request);
	}
	/**
	 * Print the response for bindDeviceToGateway
	 * 
	 * @param request
	 * @return Response object
	 */
	public BindDeviceToGatewayResponse bindDeviceToGateway(BindDeviceToGatewayRequest request) {
		return (BindDeviceToGatewayResponse.Builder.newBuilder().setBindDeviceToGatewayRequest(request).build());
	}

	/**
	 * unbindDeviceFromGateway method
	 * @param parent
	 * @param gatewayId
	 * @param deviceId
	 */
	public void unbindDeviceFromGateway(String parent, String gatewayId, String deviceId) {
		UnbindDeviceFromGatewayRequest request = UnbindDeviceFromGatewayRequest.Builder.newBuilder().setParent(parent).setGateway(gatewayId).setDevice(deviceId).build();
		UnbindDeviceFromGatewayResponse response = this.unbindDeviceFromGateway(request);
		response.processRequest(request);
	}
	/**
	 * Print the response for unbindDeviceFromGateway
	 * @param request
	 * @return Response object
	 */
	public UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(UnbindDeviceFromGatewayRequest request) {
		return (UnbindDeviceFromGatewayResponse.Builder.newBuilder().setUnbindDeviceFromGatewayRequest(request).build());
	}

	/**
	 * devicePatch method
	 * @param name
	 * @param updateMask
	 * @param device object - id, name, logLevel, blocked
	 */
	public void devicePatch(String name, String updateMask, Device device) {
		DevicePatchRequest request = DevicePatchRequest.Builder.newBuilder().setName(name).setUpdateMask(updateMask).setDevice(device).build();
		DevicePatchResponse response = this.devicePatch(request);
		response.processRequest(request);
	}
	/**
	 * Print the response for devicePatch
	 * @param request
	 * @return Response object
	 */
	public DevicePatchResponse devicePatch(DevicePatchRequest request) {
		return (DevicePatchResponse.Builder.newBuilder().setDevicePatchRequest(request).build());
	}
}

