package com.clearblade.cloud.iot.v1.modifycloudtodeviceconfig;

import java.util.logging.Logger;

public class ModifyCloudToDeviceConfigResponse {

	static Logger log = Logger.getLogger(ModifyCloudToDeviceConfigResponse.class.getName());
	private final ModifyCloudToDeviceConfigRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected ModifyCloudToDeviceConfigResponse(Builder builder) {
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
		private ModifyCloudToDeviceConfigRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setModifyCloudToDeviceConfigRequest(ModifyCloudToDeviceConfigRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public ModifyCloudToDeviceConfigResponse build() {
			return new ModifyCloudToDeviceConfigResponse(this);
		}
	}


	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public ModifyCloudToDeviceConfigRequest getRequest() {
		return request;
	}

}
