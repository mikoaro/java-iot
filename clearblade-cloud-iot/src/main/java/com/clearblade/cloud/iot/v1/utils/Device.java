package com.clearblade.cloud.iot.v1.utils;

import java.util.ArrayList;
import java.util.List;

public class Device {
	
	private final String id;
	private final String name;
	private final List<String> credentials;
	private final int logLevel;
	
	public Device() {
		id = "";
		name = "";
		credentials = new ArrayList<>();
		logLevel = 0;
	}
	
	private Device(Builder builder) {
		id = builder.getId();
		name = builder.getName();
		credentials = builder.getCredentials();
		logLevel = builder.getLogLevel();
	}
	

	public static Builder newBuilder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static Device of(String id, String name, List<String> credentials, int logLevel) {
		return newBuilder().setId(id).setName(name).setCredentials(credentials).setLogLevel(logLevel).build();
	}

	public static String format(String id, String name, List<String> credentials, int logLevel) {
		return newBuilder().setId(id).setName(name).setCredentials(credentials).setLogLevel(logLevel).build()
				.toString();
	}

	/**
	 * Builder for setting 
	 * Device - id, name, credentials and logLevel
	 */
	public static class Builder {
		private String id;
		private String name;
		private List<String> credentials;
		private int logLevel;

		protected Builder() {
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<String> getCredentials() {
			return credentials;
		}

		public int getLogLevel() {
			return logLevel;
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setCredentials(List<String> credentials) {
			this.credentials = credentials;
			return this;
		}

		public Builder setLogLevel(int logLevel) {
			this.logLevel = logLevel;
			return this;
		}

		private Builder(Device device) {
			this.id = device.id;
			this.name = device.name;
			this.credentials = device.credentials;
			this.logLevel = device.logLevel;
		}

		public Device build() {
			return new Device(this);
		}
	}
}
