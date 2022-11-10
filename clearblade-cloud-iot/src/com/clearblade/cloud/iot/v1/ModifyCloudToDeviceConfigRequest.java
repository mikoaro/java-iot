package com.clearblade.cloud.iot.v1;

import java.util.Arrays;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.Device;

public class ModifyCloudToDeviceConfigRequest {
	
	private final Device device;
	private final String versionToUpdate;
	private final ByteString binaryData;
	private final byte[] binaryDataByte;
	public JSONObject requestParams;
	public JSONObject bodyParams;

	private ModifyCloudToDeviceConfigRequest(Builder builder) {
		this.device = builder.device;
		this.versionToUpdate = builder.versionToUpdate;
		this.binaryData = builder.binaryData;
		this.binaryDataByte = builder.binaryDataByte;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private Device device;
		private String versionToUpdate;
		private ByteString binaryData;
		private byte[] binaryDataByte;
		
		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setDevice(Device device) {
			this.device = device;
			return this;
		}

		public Builder setVersionToUpdate(String versionToUpdate) {
			this.versionToUpdate = versionToUpdate;
			return this;
		}

		public Builder setBinaryData(ByteString binaryData) {
			this.binaryData = binaryData;
			return this;
		}

		public Builder setBinaryDataByte(byte[] binaryDataByte) {
			this.binaryDataByte = binaryDataByte;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public ModifyCloudToDeviceConfigRequest build() {
			return new ModifyCloudToDeviceConfigRequest(this);
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
		
		String dName = "";
		String bData = null;
		String versionToUpdate = "1";
		
		if(this.device != null) {
			dName = this.device.toBuilder().getName();
		}
		if(this.binaryData != null) {
			bData = new String(this.binaryData.getBinaryDataArray());
		}else if(this.binaryDataByte != null) {
			if(this.binaryDataByte.length == 0){
				bData = "EMPTY";
			}else {
				bData = Arrays.toString(this.binaryDataByte);
			}
		}
		if(this.versionToUpdate != null) {
			versionToUpdate = this.versionToUpdate;
		}
		String method = Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG;
		
		requestParams.put("name", dName);
		requestParams.put("method", method);
		bodyParams.put("binaryData", bData);
		bodyParams.put("versionToUpdate", versionToUpdate);
		
		return "name = "+dName+", binaryData = "+bData+", versionToUpdate = "+versionToUpdate;
	}

}
