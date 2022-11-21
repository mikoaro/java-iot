package com.clearblade.cloud.iot.v1.createdevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.ProcessRequest;

public class CreateDeviceResponse {

	static Logger log = Logger.getLogger(CreateDeviceResponse.class.getName());
	private final CreateDeviceRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected CreateDeviceResponse(Builder builder) {
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
		private CreateDeviceRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setCreateDeviceRequest(CreateDeviceRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public CreateDeviceResponse build() {
			return new CreateDeviceResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * CreateDevice
	 */
	public void processRequest(CreateDeviceRequest request) {
		String msg = "";
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		ProcessRequest processRequest = new ProcessRequest();
		if(request != null) {
			String logMsg = "Sending request to device :: "+request.toString();
			log.log(Level.INFO,logMsg);
			requestParams = (JSONObject) request.requestParams.clone();
			bodyParams = (JSONObject) request.bodyParams.clone();
		}		
		String responseMessage = processRequest.processRequestForMethod("createDevice",requestParams,bodyParams);
		this.setHttpStatusResponse(responseMessage);		
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for CreateDevice method";
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for CreateDevice failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public CreateDeviceRequest getRequest() {
		return request;
	}

}
