package com.clearblade.cloud.iot.v1;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayRequest;
import com.clearblade.cloud.iot.v1.binddevicetogateway.BindDeviceToGatewayResponse;
import com.clearblade.cloud.iot.v1.createdevice.CreateDeviceRequest;
import com.clearblade.cloud.iot.v1.createdeviceregistry.CreateDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.createdeviceregistry.CreateDeviceRegistryResponse;
import com.clearblade.cloud.iot.v1.deletedevice.DeleteDeviceRequest;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListRequest;
import com.clearblade.cloud.iot.v1.deviceslist.DevicesListResponse;
import com.clearblade.cloud.iot.v1.devicestateslist.ListDeviceStatesRequest;
import com.clearblade.cloud.iot.v1.devicestateslist.ListDeviceStatesResponse;
import com.clearblade.cloud.iot.v1.getdevice.GetDeviceRequest;
import com.clearblade.cloud.iot.v1.getdeviceregistry.GetDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig.ModifyCloudToDeviceConfigRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceResponse;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayRequest;
import com.clearblade.cloud.iot.v1.unbinddevicefromgateway.UnbindDeviceFromGatewayResponse;
import com.clearblade.cloud.iot.v1.updatedevice.UpdateDeviceRequest;
import com.clearblade.cloud.iot.v1.updatedeviceregistry.UpdateDeviceRegistryRequest;
import com.clearblade.cloud.iot.v1.updatedeviceregistry.UpdateDeviceRegistryResponse;
import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.DeviceConfig;
import com.clearblade.cloud.iot.v1.utils.DeviceRegistry;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class DeviceManagerClient {

	static Logger log = Logger.getLogger(DeviceManagerClient.class.getName());

	
	/**
	 * Calling getDevice api 
	 * @param request
	 * @return Device object
	 */
	
	  public Device getDevice(GetDeviceRequest request) {
		  ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		  return cbManager.getDevice(request);
	  }

	/**
	 * Calling createDevice api 
	 * @param request
	 * @return Device object
	 */		
	  public Device createDevice(CreateDeviceRequest request) {
		  ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		  return cbManager.createDevice(request);
	  }

	/**
	 * Calling bindDeviceToGateway api
	 * @param request
	 * @return
	 */
	public BindDeviceToGatewayResponse bindDeviceToGateway(BindDeviceToGatewayRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.bindDeviceToGateway(request);
	}

	/**
	 * Calling unbindDeviceFromGateway api
	 * @param request
	 * @return
	 */
	public UnbindDeviceFromGatewayResponse unbindDeviceFromGateway(UnbindDeviceFromGatewayRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.unbindDeviceFromGateway(request);
	}

	/**
	 * Calling deleteDevice api
	 * @param request
	 */
	public void deleteDevice(DeleteDeviceRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		cbManager.deleteDevice(request);		
	}

	/**
	 * Calling updateDevice api 
	 * @param request
	 * @return Device object
	 */		
	  public Device updateDevice(UpdateDeviceRequest request) {
		  ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		  return cbManager.updateDevice(request);
	  }

	public SendCommandToDeviceResponse sendCommandToDevice(SendCommandToDeviceRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.sendCommandToDevice(request);

	}

	public DevicesListResponse listDevices(DevicesListRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.listDevices(request);

	}

	public DeviceConfig modifyCloudToDeviceConfig(ModifyCloudToDeviceConfigRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.modifyCloudToDeviceConfig(request);
	}

	public ListDeviceStatesResponse listDeviceStates(ListDeviceStatesRequest request) {
		ClearBladeDeviceManager cbManager = new ClearBladeDeviceManager();
		return cbManager.listDeviceStates(request);

	}

	//Registry Apis
	/**
	 * Calling getDeviceRegistry api 
	 * @param request
	 * @return DeviceRegistry object
	 */
	  public DeviceRegistry getDeviceRegistry(GetDeviceRegistryRequest request) {
		  ClearBladeRegistryManager cbManager = new ClearBladeRegistryManager();
		  return cbManager.getRegistry(request);
	  }


}
