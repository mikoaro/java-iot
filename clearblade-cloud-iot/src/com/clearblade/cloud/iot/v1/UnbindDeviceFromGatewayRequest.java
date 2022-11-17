package com.clearblade.cloud.iot.v1;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.Constants;

public class UnbindDeviceFromGatewayRequest {
	private final String parent;
	private final String gateway;
	private final String device;
	JSONObject requestParams;
	JSONObject bodyParams;

	private UnbindDeviceFromGatewayRequest(Builder builder) {
		this.parent = builder.parent;
		this.gateway = builder.gateway;
		this.device = builder.device;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private String parent;
		private String gateway;
		private String device;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setParent(String parent) {
			this.parent = parent;
			return this;
		}
		
		public Builder setGateway(String gateway) {
			this.gateway = gateway;
			return this;
		}

		public Builder setDevice(String device) {
			this.device = device;
			return this;
		}
		
		// build method to deal with outer class
		// to return outer instance
		public UnbindDeviceFromGatewayRequest build() {
			return new UnbindDeviceFromGatewayRequest(this);
		}
	}

	public JSONObject getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(JSONObject requestParams) {
		this.requestParams = requestParams;
	}
	
	public JSONObject getBodyParams() {
		return bodyParams;
	}

	public void setBodyParams(JSONObject bodyParams) {
		this.bodyParams = bodyParams;
	}
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		requestParams = new JSONObject();
		bodyParams = new JSONObject();
		String method = Constants.UNBIND_DEVICE_FROM_GATEWAY;
		requestParams.put("method", method);
		requestParams.put("parent", this.parent);
		
		bodyParams.put("gatewayId", this.gateway);
		bodyParams.put("deviceId", this.device);
		
		this.setRequestParams(requestParams);
		this.setBodyParams(bodyParams);
		
		return "parent=" + this.parent + ",gateway=" + this.gateway+", device= "+this.device;
	}

}
