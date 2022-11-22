package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.createdeviceregistry.CreateDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.deletedeviceregistry.DeleteDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.getdeviceregistry.GetDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.updatedeviceregistry.UpdateDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.DeviceRegistry;

public class ClearBladeRegistryManager {
	ConfigParameters configParameters = new ConfigParameters();
	

	public DeviceRegistry getRegistry(GetDeviceRegistryRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] responseArray = syncClient.get(configParameters.getCloudiotURLExtension(), request.toString(),false);
		int responseCode = Integer.parseInt(responseArray[0]);
		if(responseCode == 200) {
			DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
			deviceRegistry.loadFromString(responseArray[2]);
			return deviceRegistry;
		}
		return null;
	}

	public DeviceRegistry asyncGetDeviceRegistry(GetDeviceRegistryRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] responseArray = asyncClient.asyncGetRegistry(configParameters.getCloudiotURLExtension(),
					request.toString());
			int responseCode = Integer.parseInt(responseArray[0]);
			if(responseCode == 200) {
				DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
				deviceRegistry.loadFromString(responseArray[2]);
				return deviceRegistry;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DeviceRegistry createDeviceRegistry(CreateDeviceRegistryRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] bodyParams = request.getBodyAndParams();
		System.out.println(bodyParams[0]);
		System.out.println(bodyParams[1]);

		String[] responseArray = syncClient.post(configParameters.getCloudiotURLExtension(), bodyParams[0],
				bodyParams[1], true);
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
			deviceRegistry.loadFromString(responseArray[2]);
			return deviceRegistry;
		}
		return null;
	}

	public DeviceRegistry asyncCreateDeviceRegistry(CreateDeviceRegistryRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] bodyParams = request.getBodyAndParams();
			System.out.println(bodyParams[0]);
			System.out.println(bodyParams[1]);

			String[] responseArray = asyncClient.asyncCreateDeviceRegistry(configParameters.getCloudiotURLExtension(),
					bodyParams[0],
					bodyParams[1], true);
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
				deviceRegistry.loadFromString(responseArray[2]);
				return deviceRegistry;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public DeviceRegistry updateDeviceRegistry(UpdateDeviceRegistryRequest request) {
		SyncClient syncClient = new SyncClient();
		String[] bodyParams = request.getBodyAndParams();
		System.out.println(bodyParams[0]);
		System.out.println(bodyParams[1]);

		String[] responseArray = syncClient.update(configParameters.getCloudiotURLExtension(), bodyParams[0],
				bodyParams[1]);
		int responseCode = Integer.parseInt(responseArray[0]);
		if (responseCode == 200) {
			DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
			deviceRegistry.loadFromString(responseArray[2]);
			return deviceRegistry;
		}else {
			System.out.println("Registry doesn't get updated::"+responseArray[2]);
		}
		return null;
	}

	public DeviceRegistry asyncUpdateDeviceRegistry(UpdateDeviceRegistryRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String[] bodyParams = request.getBodyAndParams();
			System.out.println(bodyParams[0]);
			System.out.println(bodyParams[1]);
	
			String[] responseArray = asyncClient.asyncUpdateDeviceRegistry(configParameters.getCloudiotURLExtension(), bodyParams[0],
					bodyParams[1]);
			int responseCode = Integer.parseInt(responseArray[0]);
			if (responseCode == 200) {
				DeviceRegistry deviceRegistry = DeviceRegistry.newBuilder().build();
				deviceRegistry.loadFromString(responseArray[2]);
				return deviceRegistry;
			}else {
				System.out.println("Registry doesn't get updated::"+responseArray[2]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void deleteDeviceRegistry(DeleteDeviceRegistryRequest request) {
		SyncClient syncClient = new SyncClient();
		String bodyParams = request.getParams();
		System.out.println(bodyParams);

		String[] responseArray = syncClient.delete(configParameters.getCloudiotURLExtension(), bodyParams, true);
		System.out.println(
				"Response for delete is " + responseArray[0] + "::" + responseArray[1] + "::" + responseArray[2]);
	}

	public void asyncDeleteDeviceRegistry(DeleteDeviceRegistryRequest request) {
		try {
			AsyncClient asyncClient = new AsyncClient();
			String bodyParams = request.getParams();
			System.out.println(bodyParams);
	
			String[] responseArray = asyncClient.asyncDeleteDeviceRegistry(configParameters.getCloudiotURLExtension(), bodyParams,
					"", true);
			System.out.println(
					"Response for delete is " + responseArray[0] + "::" + responseArray[1] + "::" + responseArray[2]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
