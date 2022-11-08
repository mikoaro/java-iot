package com.clearblade.cloud.iot.v1.utils;

public class DeviceState {
	private final ByteString binaryData;
	
	public DeviceState(Builder builder) {
		binaryData = builder.getBinaryData();
	}
	
	public ByteString getBinaryData() {
		return binaryData;
	}
	
	public static Builder newBuilder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static class Builder {
		private ByteString binaryData;

		protected Builder() {
		}

		public ByteString getBinaryData() {
			return binaryData;
		}

		public Builder setBinaryData(ByteString binaryData) {
			this.binaryData = binaryData;
			return this;
		}
		private Builder(DeviceState deviceState) {
			this.binaryData = deviceState.binaryData;
		}

		public DeviceState build() {
			return new DeviceState(this);
		}
	}

}
