package com.clearblade.cloud.iot.v1;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.Device;

public class DevicesListResponse {
	
	static Logger log = Logger.getLogger(DevicesListResponse.class.getName());
	
	private final DevicesListRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;
	private List<Device> devicesList;

	protected DevicesListResponse(Builder builder) {
		this.request = builder.request;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getHttpStatusResponse() {
		return httpStatusResponse;
	}

	public void setHttpStatusResponse(String httpStatusResponse) {
		this.httpStatusResponse = httpStatusResponse;
	}
	
	// Static class Builder
	public static class Builder {

		/// instance fields
		private DevicesListRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setDevicesListRequest(DevicesListRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public DevicesListResponse build() {
			return new DevicesListResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * DevicesList
	 */
	@SuppressWarnings("unchecked")
	public void processRequest(DevicesListRequest request) {
		String msg = "";
		ProcessRequest processRequest = new ProcessRequest();
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		if(request != null) {
			requestParams.put("parent", request.toString());
			requestParams.put("fieldMask", "EMPTY");
		}
		String responseMessage = processRequest.processRequestForMethod("devicesList", requestParams, bodyParams);
		this.setHttpStatusResponse(responseMessage);
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for DevicesList method";
			
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for DevicesList failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}
	
	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}
	
	public DevicesListRequest getRequest() {
		return request;
	}

	public List<Device> getDevicesList() {
		return devicesList;
	}

	public void setDevicesList(List<Device> devicesList) {
		this.devicesList = devicesList;
	}
}
