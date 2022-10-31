package com.clearblade.cloud.iot.v1;

import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 * Mehtod used to process the request
	 * Calling processRequestForMethod - CreateDevice
	 */
	public void processRequest() {
		
		ProcessRequest processRequest = new ProcessRequest();
		String msg = "";
		
		int responseCode = processRequest.processRequestForMethod("createDevice");
		this.setHttpStatusCode(responseCode);
		switch(responseCode) {
			case HttpURLConnection.HTTP_BAD_REQUEST:
					this.setHttpStatusResponse("HTTP_BAD_REQUEST");
					break;
			case HttpURLConnection.HTTP_INTERNAL_ERROR:
					this.setHttpStatusResponse("HTTP_INTERNAL_ERROR");
					break;
			default: 
					this.setHttpStatusResponse("HTTP_OK");
					break;
		}
		if (responseCode == HttpURLConnection.HTTP_OK) {
			msg = "Request processed for CreateDevice method.\n HTTP RESPONSE IS :: Status Code : "+this.getHttpStatusCode()+" Status Message : "+this.getHttpStatusResponse();
			log.log(Level.INFO, msg);
		} else {
			msg = "Request is not processed for CreateDevice method.\n HTTP RESPONSE IS :: Status Code : "+this.getHttpStatusCode()+" Status Message : "+this.getHttpStatusResponse();
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
