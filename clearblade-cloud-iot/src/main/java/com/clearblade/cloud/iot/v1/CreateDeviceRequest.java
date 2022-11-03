package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.Device;
import com.clearblade.cloud.iot.v1.utils.RegistryName;

public class CreateDeviceRequest {
	private final RegistryName parent;
	private final Device device;
	private final String subfolder;
	private String deviceId;
	private String deviceName;
	private int deviceNumId;

	private CreateDeviceRequest(Builder builder) {
		this.parent = builder.parent;
		this.device = builder.device;
		this.subfolder = builder.subfolder;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private RegistryName parent;
		private Device device;
		private String subfolder;

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

	@Override
	public String toString() {
		String str = "";
		if(parent != null) {
			str = str.concat("parent ="+parent.getRegistry());
		}
		if(device != null) {
			this.setDeviceId(this.device.toBuilder().getId());
			this.setDeviceName(this.device.toBuilder().getName());
			this.setDeviceNumId(this.device.toBuilder().getNumId());
			str = str.concat(",id="+this.getDeviceId()+",name="+this.getDeviceName()+",numId="+this.getDeviceNumId());
		}else {
			str = str.concat(",device =EMPTY");
		}
		if(subfolder != null) {
			str = str.concat(",subfolder ="+subfolder);
		}else {
			str = str.concat(",subfolder =EMPTY");
		}
		return str;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public int getDeviceNumId() {
		return deviceNumId;
	}

	public void setDeviceNumId(int deviceNumId) {
		this.deviceNumId = deviceNumId;
	}
}
