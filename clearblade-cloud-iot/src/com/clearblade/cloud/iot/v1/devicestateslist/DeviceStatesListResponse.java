package com.clearblade.cloud.iot.v1.devicestateslist;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.ProcessRequest;
import com.clearblade.cloud.iot.v1.utils.DeviceState;

public class DeviceStatesListResponse {
	
	static Logger log = Logger.getLogger(DeviceStatesListResponse.class.getName());
	
	private final DeviceStatesListRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;
	private List<DeviceState> deviceStatesList;
	
	protected DeviceStatesListResponse(Builder builder) {
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
		private DeviceStatesListRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setDeviceStatesListRequest(DeviceStatesListRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public DeviceStatesListResponse build() {
			return new DeviceStatesListResponse(this);
		}
	}
	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * DevicesList
	 */
	public void processRequest(DeviceStatesListRequest request) {
		String msg = "";
		ProcessRequest processRequest = new ProcessRequest();
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();		
		if(request != null) {
			log.log(Level.INFO,request.toString());
			requestParams = (JSONObject) request.requestParams.clone();
		}
		String responseMessage = processRequest.processRequestForMethod("deviceStatesList", requestParams, bodyParams);
		this.setHttpStatusResponse(responseMessage);
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for DeviceStatesList method";
			
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for DeviceStatesList failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}
	
	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}
	
	public DeviceStatesListRequest getRequest() {
		return request;
	}

	public List<DeviceState> getDeviceStatesList() {
		return deviceStatesList;
	}

	public void setDeviceStatesList(List<DeviceState> deviceStatesList) {
		this.deviceStatesList = deviceStatesList;
	}

}
