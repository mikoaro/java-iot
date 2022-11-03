package com.clearblade.cloud.iot.v1;

public class GetDeviceRequest {
	
	private final String deviceName;

	private GetDeviceRequest(Builder builder) {
		this.deviceName = builder.deviceName;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private String deviceName;

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

		// build method to deal with outer class
		// to return outer instance
		public GetDeviceRequest build() {
			return new GetDeviceRequest(this);
		}
	}

	@Override
	public String toString() {
		return "deviceName = " + this.deviceName;
	}


}
