package com.clearblade.cloud.iot.v1.getdevice;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.utils.Device;

public class GetDeviceResponse {
	
	static Logger log = Logger.getLogger(GetDeviceResponse.class.getName());
	
	private final GetDeviceRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;
	private Device device;

	protected GetDeviceResponse(Builder builder) {
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
		private GetDeviceRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setGetDeviceRequest(GetDeviceRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public GetDeviceResponse build() {
			return new GetDeviceResponse(this);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public GetDeviceRequest getRequest() {
		return request;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
