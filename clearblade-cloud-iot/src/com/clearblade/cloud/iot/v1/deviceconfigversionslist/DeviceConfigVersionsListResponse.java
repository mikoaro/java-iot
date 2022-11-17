package com.clearblade.cloud.iot.v1.deviceconfigversionslist;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.ProcessRequest;
import com.clearblade.cloud.iot.v1.utils.Constants;

public class DeviceConfigVersionsListResponse {

	static Logger log = Logger.getLogger(DeviceConfigVersionsListResponse.class.getName());
	private final DeviceConfigVersionsListRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected DeviceConfigVersionsListResponse(Builder builder) {
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
		private DeviceConfigVersionsListRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setDeviceConfigVersionsListRequest(DeviceConfigVersionsListRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public DeviceConfigVersionsListResponse build() {
			return new DeviceConfigVersionsListResponse(this);
		}
	}
	
	/**
	 * Mehtod used to process the request
	 * Calling processRequestForMethod - deviceConfigVersionsList
	 */
	
	public void processRequest(DeviceConfigVersionsListRequest request) {
		String msg = "";
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		ProcessRequest processRequest = new ProcessRequest();
		
		if(request != null) {
			String logMsg = "Config versions list for device :: "+request.toString();
			log.log(Level.INFO,logMsg);
			requestParams = (JSONObject) request.requestParams.clone();
		}
		
		String responseMessage = processRequest.processRequestForMethod(Constants.DEVICE_CONFIG_VERSIONS_LIST,requestParams,bodyParams);
		this.setHttpStatusResponse(responseMessage);
		if (responseMessage.equals("OK")) {
			msg = "Request processed successfully for DeviceConfigVersionsList method";
			log.log(Level.INFO, msg);
		} else {
			msg = "POST request not worked for DeviceConfigVersionsList Method \n".concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}

	}
	
	public DeviceConfigVersionsListRequest getRequest() {
		return request;
	}
	
	/**
	 * Mehtod used to process the request
	 * Calling processRequestForMethod - DeviceSetStatesRequest
	 */
	
	/*
	 * public String processRequestAsync(SendCommandToDeviceRequest request) {
	 * String msg = ""; JSONObject requestParams = new JSONObject(); JSONObject
	 * bodyParams = new JSONObject(); ProcessRequest processRequest = new
	 * ProcessRequest();
	 * 
	 * if(request != null) { String logMsg =
	 * "Sending request to device :: "+request.toString();
	 * log.log(Level.INFO,logMsg); requestParams = (JSONObject)
	 * request.requestParams.clone(); bodyParams = (JSONObject)
	 * request.bodyParams.clone(); }
	 * 
	 * String responseMessage =
	 * processRequest.asyncCallSendCommandToDevice(request);
	 * this.setHttpStatusResponse(responseMessage); if
	 * (responseMessage.equals("OK")) { msg =
	 * "Request processed successfully for SendCommandToDevice method";
	 * log.log(Level.INFO, msg); } else { msg =
	 * "POST request not worked for sendCommandToDevice Method \n".concat(
	 * responseMessage); log.log(Level.SEVERE, msg); } return responseMessage;
	 * 
	 * }
	 * 
	 * @Override public String toString() { return "Http Status Code :: " +
	 * this.getHttpStatusCode() + " Http Status Response :: " +
	 * this.getHttpStatusResponse(); }
	 * 
	 * public SendCommandToDeviceRequest getRequest() { return request; }
	 */}
