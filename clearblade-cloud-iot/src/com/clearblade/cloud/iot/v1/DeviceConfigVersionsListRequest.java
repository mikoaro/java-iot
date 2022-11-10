package com.clearblade.cloud.iot.v1;

import org.json.simple.JSONObject;

public class DeviceConfigVersionsListRequest {
	private final String name;
	private final String numVersions;
	JSONObject requestParams;

	private DeviceConfigVersionsListRequest(Builder builder) {
		this.name = builder.name;
		this.numVersions = builder.numVersions;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private String name;
		private String numVersions;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNumVersions(String numVersions) {
			this.numVersions = numVersions;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public DeviceConfigVersionsListRequest build() {
			return new DeviceConfigVersionsListRequest(this);
		}

	}

	public JSONObject getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(JSONObject requestParams) {
		this.requestParams = requestParams;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		requestParams = new JSONObject();
		requestParams.put("name", this.name);
		requestParams.put("numVersions", this.numVersions);
		this.setRequestParams(requestParams);
		return "name=" + this.name + ",numVersions=" + this.numVersions;
	}

}
