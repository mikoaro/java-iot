package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayRequest;
import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayResponse;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.deletedevice.DeleteDeviceRequest;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListRequest;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListResponse;
import com.clearblade.cloud.iot.v1.devicestateslist.ListDeviceStatesRequest;
import com.clearblade.cloud.iot.v1.devicestateslist.ListDeviceStatesResponse;
import com.clearblade.cloud.iot.v1.getdevice.GetDeviceRequest;
import com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig.ModifyCloudToDeviceConfigRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayRequest;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayResponse;
import com.clearblade.cloud.iot.v1.updatedevice.UpdateDeviceRequest;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;

public class ClearBladeDeviceManager {
	ConfigParameters configParameters = new ConfigParameters();
	

	public Device getDevice(GetDeviceRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] responseArray = syncClient.get(configParameters.getDevicesURLExtension(), request.toString());
		int responseCode = Integer.parseInt(responseArray[0]);
		if(responseCode == 200) {
			Device device = Device.newBuilder().build();
			device.loadFromString(responseArray[2]);
			return device;
		}
		return null;
	}

	public Device asyncGetDevice(GetDeviceRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] responseArray = asyncClient.asyncGet(configParameters.getDevicesURLExtension(),
					request.toString());
			int responseCode = Integer.parseInt(responseArray[0]);
			if(responseCode == 200) {
				Device device = Device.newBuilder().build();
				device.loadFromString(responseArray[2]);
				return device;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Device createDevice(CreateDeviceRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] params = request.getParams();
		String reqParams = params[0];
		String body = params[1];
		String[] responseArray = syncClient.post(configParameters.getDevicesURLExtension(), reqParams, body);
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			Device deviceObj = Device.newBuilder().build();
			deviceObj.loadFromString(responseArray[2]);
			return deviceObj;
		}
		return null;
	}

	public Device asyncCreateDevice(CreateDeviceRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] params = request.getParams();
			String reqParams = params[0];
			String body = params[1];
			String[] responseArray = asyncClient.asyncCreate(configParameters.getDevicesURLExtension(), reqParams,
					body);
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				Device deviceObj = Device.newBuilder().build();
				deviceObj.loadFromString(responseArray[2]);
				return deviceObj;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteDevice(DeleteDeviceRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] responseArray = syncClient.delete(configParameters.getDevicesURLExtension(), request.toString());
		System.out.println(
				"Response for delete is " + responseArray[0] + "::" + responseArray[1] + "::" + responseArray[2]);
	}

	public void asyncDeleteDevice(DeleteDeviceRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] responseArray = asyncClient.asyncDelete(configParameters.getDevicesURLExtension(),
					request.toString());
			System.out.println(
					"Response for delete is " + responseArray[0] + "::" + responseArray[1] + "::" + responseArray[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Device updateDevice(UpdateDeviceRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] params = request.getBodyAndParams();
		String reqParams = params[0];
		String body = params[1];
		String[] responseArray = syncClient.patch(configParameters.getDevicesURLExtension(), reqParams, body);
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			Device deviceObj = Device.newBuilder().build();
			deviceObj.loadFromString(responseArray[2]);
			return deviceObj;
		}
		return null;
	}
	public Device asyncUpdateDevice(UpdateDeviceRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] params = request.getBodyAndParams();
			String reqParams = params[0];
			String body = params[1];
			String[] responseArray = asyncClient.asyncUpdate(configParameters.getDevicesURLExtension(), reqParams,
					body);
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				Device deviceObj = Device.newBuilder().build();
				deviceObj.loadFromString(responseArray[2]);
				return deviceObj;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public BindDeviceToGatewayResponse bindDeviceToGateway(BindDeviceToGatewayRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] paramBody = request.getBodyAndParams();
		String[] responseArray = syncClient.post(configParameters.getCloudiotURLExtension(), paramBody[0],
				paramBody[1]);
		BindDeviceToGatewayResponse response = BindDeviceToGatewayResponse.Builder.newBuilder().build();
		response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
		response.setHttpStatusResponse(responseArray[1]);
		return response;
	}

	public BindDeviceToGatewayResponse asyncBindDeviceToGateway(BindDeviceToGatewayRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] paramBody = request.getBodyAndParams();
			String[] responseArray = asyncClient.asyncBindDeviceToGateway(configParameters.getCloudiotURLExtension(),
					paramBody[0], paramBody[1]);
			BindDeviceToGatewayResponse response = BindDeviceToGatewayResponse.Builder.newBuilder().build();
			response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
			response.setHttpStatusResponse(responseArray[1]);
			return response;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(UnbindDeviceFromGatewayRequest request) {
		SyncClient syncClinet = new SyncClient();
		String[] paramBody = request.getBodyAndParams();
		String[] responseArray = syncClinet.post(configParameters.getCloudiotURLExtension(), paramBody[0],
				paramBody[1]);
		UnbindDeviceFromGatewayResponse response = UnbindDeviceFromGatewayResponse.Builder.newBuilder().build();
		response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
		response.setHttpStatusResponse(responseArray[1]);
		return response;
	}

	public UnbindDeviceFromGatewayResponse asyncUnbindDeviceFromGateway(UnbindDeviceFromGatewayRequest request) {
		try {
			AsyncClient asyncClinet = new AsyncClient();
			String[] paramBody = request.getBodyAndParams();
			String[] responseArray = asyncClinet.asyncUnbindDeviceFromGateway(
					configParameters.getCloudiotURLExtension(), paramBody[0], paramBody[1]);
			UnbindDeviceFromGatewayResponse response = UnbindDeviceFromGatewayResponse.Builder.newBuilder().build();
			response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
			response.setHttpStatusResponse(responseArray[1]);
			return response;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public SendCommandToDeviceResponse sendCommandToDevice(SendCommandToDeviceRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] paramBody = request.getBodyAndParams();
		String[] responseArray = syncClient.post(configParameters.getDevicesURLExtension(), paramBody[0],
				paramBody[1]);
		System.out.println(responseArray[2]);
		SendCommandToDeviceResponse response = SendCommandToDeviceResponse.Builder.newBuilder().build();
		response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
		response.setHttpStatusResponse(responseArray[1]);
		return response;
	}

	public SendCommandToDeviceResponse asyncSendCommandToDevice(SendCommandToDeviceRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] paramBody = request.getBodyAndParams();
			String[] responseArray = asyncClient.asyncSendCommandToDevice(configParameters.getDevicesURLExtension(),
					paramBody[0],
					paramBody[1]);
			System.out.println(responseArray[2]);
			SendCommandToDeviceResponse response = SendCommandToDeviceResponse.Builder.newBuilder().build();
			response.setHttpStatusCode(Integer.parseInt(responseArray[0]));
			response.setHttpStatusResponse(responseArray[1]);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DevicesListResponse listDevices(DevicesListRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] responseArray = syncClient.get(configParameters.getDevicesURLExtension(), request.getParamsForList());
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			DevicesListResponse devicesListResponse = DevicesListResponse.Builder.newBuilder()
					.buildResponse(responseArray[2]).build();
			// deviceObj.loadFromString(responseArray[2]);
			return devicesListResponse;
		}
		return null;
	}

	public DevicesListResponse asyncListDevices(DevicesListRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] responseArray = asyncClient.asyncListDevices(configParameters.getDevicesURLExtension(), request.getParamsForList());
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				DevicesListResponse devicesListResponse = DevicesListResponse.Builder.newBuilder()
						.buildResponse(responseArray[2]).build();
				// deviceObj.loadFromString(responseArray[2]);
				return devicesListResponse;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DeviceConfig modifyCloudToDeviceConfig(ModifyCloudToDeviceConfigRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] paramBody = request.getBodyAndParams();
		String[] responseArray = syncClient.post(configParameters.getDevicesURLExtension(), paramBody[0],
				paramBody[1]);
		System.out.println(responseArray[2]);
		DeviceConfig deviceConfig = DeviceConfig.newBuilder().build();
		if (Integer.parseInt(responseArray[0]) == 200)
			deviceConfig.loadFromString(responseArray[2]);
		return deviceConfig;
	}

	public DeviceConfig asyncModifyCloudToDeviceConfig(ModifyCloudToDeviceConfigRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] paramBody = request.getBodyAndParams();
			String[] responseArray = asyncClient.asyncModifyCloudToDeviceConfig(
					configParameters.getDevicesURLExtension(), paramBody[0],
					paramBody[1]);
			System.out.println(responseArray[2]);
			DeviceConfig deviceConfig = DeviceConfig.newBuilder().build();
			if (Integer.parseInt(responseArray[0]) == 200)
				deviceConfig.loadFromString(responseArray[2]);
			return deviceConfig;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ListDeviceStatesResponse listDeviceStates(ListDeviceStatesRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] responseArray = syncClient.get(configParameters.getDevicesStatesURLExtension(),
				request.getParamsForList());
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			ListDeviceStatesResponse listDeviceStatesResponse = ListDeviceStatesResponse.Builder.newBuilder()
					.buildResponse(responseArray[2]).build();
			// deviceObj.loadFromString(responseArray[2]);
			return listDeviceStatesResponse;
		}
		return null;
	}

	public ListDeviceStatesResponse asyncListDeviceStates(ListDeviceStatesRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] responseArray = asyncClient.asyncListDeviceStates(configParameters.getDevicesStatesURLExtension(),
					request.getParamsForList());
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				ListDeviceStatesResponse listDeviceStatesResponse = ListDeviceStatesResponse.Builder.newBuilder()
						.buildResponse(responseArray[2]).build();
				// deviceObj.loadFromString(responseArray[2]);
				return listDeviceStatesResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
