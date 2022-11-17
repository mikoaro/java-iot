package com.clearblade.cloud.iot.v1;

import org.json.simple.JSONObject;

public class GetDeviceConfigRequest {
	
	private final String deviceName;
	private final String localVersion;
	JSONObject requestParams = new JSONObject();

	private GetDeviceConfigRequest(Builder builder) {
		this.deviceName = builder.deviceName;
		this.localVersion = builder.localVersion;
	}
	
	// Static class Builder
	public static class Builder {

		/// instance fields
		private String deviceName;
		private String localVersion;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setDeviceName(String deviceName) {
			this.deviceName = deviceName;
			return this;
		}
		public Builder setLocalVersion(String localVersion) {
			this.localVersion = localVersion;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public GetDeviceConfigRequest build() {
			return new GetDeviceConfigRequest(this);
		}
	}

	@Override
	public String toString() {
		requestParams = new JSONObject();
		requestParams.put("name", this.deviceName);
		requestParams.put("localVersion", this.localVersion);
		this.setRequestParams(requestParams);
		return "name="+this.deviceName+"localVersion="+this.localVersion;
	}

	public JSONObject getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(JSONObject requestParams) {
		this.requestParams = requestParams;
	}


}
