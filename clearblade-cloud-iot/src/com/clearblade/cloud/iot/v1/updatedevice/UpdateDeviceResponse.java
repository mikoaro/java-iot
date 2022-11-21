package com.clearblade.cloud.iot.v1.updatedevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.ProcessRequest;
import com.clearblade.cloud.iot.v1.utils.Constants;

public class UpdateDeviceResponse {

	static Logger log = Logger.getLogger(UpdateDeviceResponse.class.getName());
	private final UpdateDeviceRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected UpdateDeviceResponse(Builder builder) {
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
		private UpdateDeviceRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setUpdateDeviceRequest(UpdateDeviceRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public UpdateDeviceResponse build() {
			return new UpdateDeviceResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * DevicePatch
	 */
	public void processRequest(UpdateDeviceRequest request) {
		String msg = "";
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		ProcessRequest processRequest = new ProcessRequest();
		if(request != null) {
			String logMsg = "Device Patch Request :: "+request.toString();
			log.log(Level.INFO,logMsg);
			requestParams = (JSONObject) request.requestParams.clone();
			bodyParams = (JSONObject) request.bodyParams.clone();
		}		
		String responseMessage = processRequest.processRequestForMethod(Constants.UPDATE_DEVICE,requestParams,bodyParams);
		this.setHttpStatusResponse(responseMessage);		
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for Device patch method";
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for Device patch failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public UpdateDeviceRequest getRequest() {
		return request;
	}

}
