package com.clearblade.cloud.iot.v1.deletedevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.ProcessRequest;

public class DeleteDeviceResponse {

	static Logger log = Logger.getLogger(DeleteDeviceResponse.class.getName());
	private final DeleteDeviceRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected DeleteDeviceResponse(Builder builder) {
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
		private DeleteDeviceRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setDeleteDeviceRequest(DeleteDeviceRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public DeleteDeviceResponse build() {
			return new DeleteDeviceResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * DeleteDevice
	 */
	@SuppressWarnings("unchecked")
	public void processRequest(DeleteDeviceRequest request) {
		String msg = "";

		ProcessRequest processRequest = new ProcessRequest();
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		if(request != null) {
			requestParams.put("name", request.toString());
		}
		String responseMessage = processRequest.processRequestForMethod("deleteDevice", requestParams, bodyParams);
		this.setHttpStatusResponse(responseMessage);
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for DeleteDevice method";
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for DeleteDevice failed \n".concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public DeleteDeviceRequest getRequest() {
		return request;
	}

}
