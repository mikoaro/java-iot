package com.clearblade.cloud.iot.v1.utils;

public class Constants {
	
	private Constants() {}

	public static final String AUTH_ACCESS = "CLEARBLADE_CONFIGURATION";
	public static final String ADMIN_SYSTEM_KEY = "systemKey";
	public static final String ADMIN_TOKEN = "token";
	public static final String BASE_URL = "url";
	public static final String PROJECT_NAME = "project";
	public static final String REGION = "region";
	public static final String REGISTRY ="registry";
	public static final String USER_SYSTEM_KEY = "systemKey";
	public static final String USER_TOKEN = "serviceAccountToken";
	public static final String API_BASE_URL = "url";

	public static final String SEND_COMMAND_TO_DEVICE = "sendCommandToDevice";
	public static final String CREATE_DEVICE = "createDevice";
	public static final String DELETE_DEVICE = "deleteDevice";
	public static final String GET_DEVICE = "getDevice";
	public static final String DEVICES_LIST = "devicesList";
	public static final String DEVICE_STATES_LIST = "deviceStatesList";
	public static final String DEVICE_SET_STATES = "setState";
	public static final String DEVICE_GET_CONFIG = "deviceGetConfig";
	public static final String MODIFY_CLOUD_TO_DEVICE_CONFIG = "modifyCloudToDeviceConfig";
	public static final String DEVICE_CONFIG_VERSIONS_LIST = "deviceConfigVersionsList";
	public static final String BIND_DEVICE_TO_GATEWAY = "bindDeviceToGateway";
	public static final String UNBIND_DEVICE_FROM_GATEWAY = "unbindDeviceFromGateway";
	public static final String UPDATE_DEVICE = "updateDevice";
	public static final String GET_REGISTRY_CREDENTIALS="getRegistryCredentials";
	public static final String GET_DEVICE_REGISTRY = "getDeviceRegistry";
	public static final String UPDATE_DEVICE_REGISTRY = "updateDeviceRegistry";
	public static final String CREATE_DEVICE_REGISTRY = "createDeviceRegistry";
	
	// Constants used for setting up http connection - for common use
	public static final String HTTPS_URL_PREFIX = "https://";
	public static final String HTTP_REQUEST_METHOD_TYPE_POST = "POST";
	public static final String HTTP_REQUEST_METHOD_TYPE_DELETE = "DELETE";
	public static final String HTTP_REQUEST_METHOD_TYPE_GET = "GET";
	public static final String HTTP_REQUEST_METHOD_TYPE_PATCH = "PATCH";
	public static final String HTTP_REQUEST_PROPERTY_TOKEN_KEY = "ClearBlade-UserToken";
	public static final String HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY = "Content-Type";
	public static final String HTTP_REQUEST_PROPERTY_ACCEPT_KEY = "Accept";
	public static final String HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE = "application/json";
	
	//Commonly used String literal
	public static final String SUBFOLDER = "subfolder";
	public static final String NAME = "?name=";
	public static final String PARENT = "?parent=";
	
	public static final String UTF8 = "utf-8";

}
