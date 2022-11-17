package com.clearblade.cloud.iot.v1.getregistrycredentials;

import java.util.logging.Logger;

public class GetRegistryCredentialsResponse {

	static Logger log = Logger.getLogger(GetRegistryCredentialsResponse.class.getName());

	private final GetRegistryCredentialsRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected GetRegistryCredentialsResponse(Builder builder) {
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
		private GetRegistryCredentialsRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setGetRegistryCredentialsRequest(GetRegistryCredentialsRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public GetRegistryCredentialsResponse build() {
			return new GetRegistryCredentialsResponse(this);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public GetRegistryCredentialsRequest getRequest() {
		return request;
	}

}
