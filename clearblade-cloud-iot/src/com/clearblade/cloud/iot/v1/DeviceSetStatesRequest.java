package com.clearblade.cloud.iot.v1;

import java.util.Arrays;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.ByteString;

public class DeviceSetStatesRequest {

	private final ByteString binaryData;
	private final byte[] binaryDataByte;
	private final String deviceName;
	private final String method;
	public JSONObject requestParams;
	public JSONObject bodyParams;

	private DeviceSetStatesRequest(Builder builder) {
		this.binaryData = builder.binaryData;
		this.binaryDataByte = builder.binaryDataByte;
		this.deviceName = builder.deviceName;
		this.method = builder.method;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private ByteString binaryData;
		private byte[] binaryDataByte;
		private String deviceName;
		private String method;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setBinaryData(ByteString binaryData) {
			this.binaryData = binaryData;
			return this;
		}

		public Builder setBinaryDataByte(byte[] binaryDataByte) {
			this.binaryDataByte = binaryDataByte;
			return this;
		}
		
		public Builder setDeviceName(String deviceName) {
			this.deviceName = deviceName;
			return this;
		}

		public Builder setMethod(String method) {
			this.method = method;
			return this;
		}
		
		// build method to deal with outer class
		// to return outer instance
		public DeviceSetStatesRequest build() {
			return new DeviceSetStatesRequest(this);
		}
	}	

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		requestParams = new JSONObject();
		bodyParams = new JSONObject();
		
		String dName = "";
		String bData = null;
		String method = "";
		
		if(this.deviceName != null) {
			dName = this.deviceName;
		}
		if(this.method != null) {
			method = this.method;
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
		
		requestParams.put("name", dName);
		requestParams.put("method", method);
		bodyParams.put("binaryData", bData);
		
		return "name = "+dName+", binaryData = "+bData+", method = "+method;
		
	}	
}
