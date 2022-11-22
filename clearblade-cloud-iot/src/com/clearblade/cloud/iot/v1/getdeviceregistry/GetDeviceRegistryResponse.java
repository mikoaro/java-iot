package com.clearblade.cloud.iot.v1.getdeviceregistry;

import java.util.logging.Logger;

import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class GetDeviceRegistryResponse {
	
	static Logger log = Logger.getLogger(GetDeviceRegistryResponse.class.getName());
	
	private final GetDeviceRegistryRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;
	private RegistryName registry;
s
	protected GetDeviceRegistryResponse(Builder builder) {
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
		private GetDeviceRegistryRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setGetDeviceRegistryRequest(GetDeviceRegistryRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public GetDeviceRegistryResponse build() {
			return new GetDeviceRegistryResponse(this);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public GetDeviceRegistryRequest getRequest() {
		return request;
	}

	public RegistryName getRegistry() {
		return registry;
	}

	public void setRegistryName(RegistryName registryName) {
		this.registry = registryName;
	}

}
