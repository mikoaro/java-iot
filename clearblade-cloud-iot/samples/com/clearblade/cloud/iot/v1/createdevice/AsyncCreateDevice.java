package com.clearblade.cloud.iot.v1.createdevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.DeviceManagerAsyncClient;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;
import com.clearblade.cloud.iot.v1.utils.GatewayConfig;
import com.clearblade.cloud.iot.v1.utils.GatewayType;
import com.clearblade.cloud.iot.v1.utils.LogLevel;
import com.clearblade.cloud.iot.v1.utils.RegistryName;
import com.clearblade.cloud.iot.v1.utils.Status;

public class AsyncCreateDevice {
	static Logger log = Logger.getLogger(AsyncCreateDevice.class.getName());

	public static void main(String[] args) {
		asyncCreateDevice();
	}

	public static void asyncCreateDevice() {
		DeviceManagerAsyncClient deviceManagerAsyncClient = new DeviceManagerAsyncClient();
		RegistryName parent = RegistryName.of("ingressdevelopmentenv", "us-central1", "Rashmi_Registry_Test");
		GatewayConfig gatewayCfg = new GatewayConfig();
		gatewayCfg.setGatewayType(GatewayType.NON_GATEWAY);
		Device device = Device.newBuilder()
				              .setId("AsyncTest22").setName("AsyncTest22")
				              .setNumId("2315").setBlocked(false)
				              .setGatewayConfig(gatewayCfg)
				              .setLogLevel(LogLevel.ERROR)
				              .setCredentials(new ArrayList<>())
				              .setLastErrorStatus(new Status())
				              .setConfig(new DeviceConfig())
				              .setMetadata(new HashMap<>())
				              .build();
		CreateDeviceRequest request = CreateDeviceRequest.Builder.newBuilder().setParent(parent).setDevice(device).build();
		Device response = deviceManagerAsyncClient.createDevice(request);
		System.out.println(response.toBuilder().getName());
	}
}
