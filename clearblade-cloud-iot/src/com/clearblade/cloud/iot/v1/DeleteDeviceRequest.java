package com.clearblade.cloud.iot.v1;

public class DeleteDeviceRequest {
	private final String deviceName;

	private DeleteDeviceRequest(Builder builder) {
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
		public DeleteDeviceRequest build() {
			return new DeleteDeviceRequest(this);
		}
	}

	@Override
	public String toString() {
		return this.deviceName;
	}

}
