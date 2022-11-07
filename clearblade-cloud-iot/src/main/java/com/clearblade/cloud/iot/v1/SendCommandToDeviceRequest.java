package com.clearblade.cloud.iot.v1;

import java.util.Arrays;

import com.clearblade.cloud.iot.v1.utils.ByteString;
import com.clearblade.cloud.iot.v1.utils.DeviceName;

public class SendCommandToDeviceRequest {

	private final DeviceName name;
	private final ByteString binaryData;
	private final byte[] binaryDataByte;
	private final String subFolder;

	private SendCommandToDeviceRequest(Builder builder) {
		this.name = builder.name;	
		this.binaryData = builder.binaryData;
		this.subFolder = builder.subFolder;
		this.binaryDataByte = builder.binaryDataByte;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private DeviceName name;
		private ByteString binaryData;
		private String subFolder;
		private byte[] binaryDataByte;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setName(DeviceName name) {
			this.name = name;
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
		
		public Builder setSubFolder(String subFolder) {
			this.subFolder = subFolder;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public SendCommandToDeviceRequest build() {
			return new SendCommandToDeviceRequest(this);
		}
	}

	@Override
	public String toString() {
		return "name = " + this.name.getDevice() + ", binaryData = " + this.binaryData+ ", subFolder = "+this.subFolder+ ", binaryDataByte = "+Arrays.toString(this.binaryDataByte);
	}
}
