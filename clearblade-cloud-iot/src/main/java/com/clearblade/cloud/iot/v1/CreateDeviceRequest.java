package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Device;

public class CreateDeviceRequest {
	private final String parent;
	private final Device device;

	private CreateDeviceRequest(Builder builder) {
		this.parent = builder.parent;
		this.device = builder.device;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private String parent;
		private Device device;

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

		public Builder setDevice(Device device) {
			this.device = device;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public CreateDeviceRequest build() {
			return new CreateDeviceRequest(this);
		}
	}

	@Override
	public String toString() {
		return "parent = " + this.parent + ", device = " + this.device.toString();
	}
}
