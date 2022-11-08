package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class DevicesListRequest {
	
	private final RegistryName parent;
	
	private DevicesListRequest(Builder builder) {
		this.parent = builder.parent;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private RegistryName parent;
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

		// build method to deal with outer class
		// to return outer instance
		public DevicesListRequest build() {
			return new DevicesListRequest(this);
		}
		
	}

	@Override
	public String toString() {
		return this.parent.toString();
	}

}
