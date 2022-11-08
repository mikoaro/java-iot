package com.clearblade.cloud.iot.v1;

import java.util.Collections;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class CreateDeviceRequest {
	private final RegistryName parent;
	private final Device device;
	private final String subfolder;
	private final String[] deviceNumIds;
	public JSONObject requestParams;
	public JSONObject bodyParams;

	private CreateDeviceRequest(Builder builder) {
		this.parent = builder.parent;
		this.device = builder.device;
		this.deviceNumIds = builder.deviceNumIds;
		this.subfolder = builder.subfolder;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private RegistryName parent;
		private Device device;
		private String subfolder;
		private String[] deviceNumIds;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setParent(RegistryName parent) {
			this.parent = parent;
			return this;
		}

		public Builder setDevice(Device device) {
			this.device = device;
			return this;
		}

		public Builder setDeviceNumIds(String[] numIds) {
			this.deviceNumIds = numIds;
			return this;
		}

		public Builder setSubfolder(String subfolder) {
			this.subfolder = subfolder;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public CreateDeviceRequest build() {
			return new CreateDeviceRequest(this);
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
		String emptyStr = "EMPTY";
		
		 // if(this.parent != null) { bodyParams.put("parent",parent.getRegistry()); }
		 
		if (this.device != null) {

			bodyParams.put("id", this.device.toBuilder().getId());
			bodyParams.put("name", this.device.toBuilder().getName());
			bodyParams.put("numId", this.device.toBuilder().getNumId());
			
			bodyParams.put("credentials", Collections.emptyList());
			bodyParams.put("lastErrorStatus", this.device.toBuilder().getLastErrorStatus());
			bodyParams.put("config", this.device.toBuilder().getConfig());
			bodyParams.put("state", this.device.toBuilder().getState());
			bodyParams.put("logLevel", this.device.toBuilder().getLogLevel());
			bodyParams.put("metadata", this.device.toBuilder().getMetadata());
			bodyParams.put("gatewayConfig", this.device.toBuilder().getGatewayConfig());

		} else {
			bodyParams.put("device", emptyStr);
		}

		String numIdStr = "";
		if (this.deviceNumIds != null) {
			for (int i = 0; i < deviceNumIds.length; i++) {
				if (i == 0) {
					numIdStr = numIdStr.concat(deviceNumIds[i]);
				}
				if (i > 0) {
					numIdStr = numIdStr.concat("," + deviceNumIds[i]);
				}
			}
		}
		requestParams.put("deviceNumIds", numIdStr);
		String subfolderStr = "";
		if (this.subfolder != null) {
			subfolderStr = subfolderStr.concat(subfolder);
		} else {
			subfolderStr = subfolderStr.concat(emptyStr);
		}
		requestParams.put("subfolder", subfolderStr);

		this.setBodyParams(bodyParams);
		this.setRequestParams(requestParams);
		if (this.device != null) {
			return this.parent + ", " + this.device.toString();
		} else {
			return emptyStr;
		}
	}

}
