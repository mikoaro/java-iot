package com.clearblade.cloud.iot.v1.utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Device {
	
	private final String id;
	private final String name;
	private final int numId;
	private final List<Object> credentials;
	private final Timestamp lastHeartbeatTime;
	private final Timestamp lastEventTime;
	private final Timestamp lastStateTime;
	private final Timestamp lastConfigAckTime;
	private final Timestamp lastConfigSendTime;
	private final boolean blocked;
    private final Timestamp	lastErrorTime;
	private final List<String> lastErrorStatus;
	private final List<String> config;
	private final List<String> state;	
	private final int logLevel;
	private final List<String> metadata;
	private final List<String> gatewayConfig;
	
	public Device() {
		id = "";
		name = "";
		numId = 0;
		credentials = new ArrayList<>();
		lastHeartbeatTime = new Timestamp(0);
		lastEventTime = new Timestamp(0);
		lastStateTime = new Timestamp(0);
		lastConfigAckTime = new Timestamp(0);
		lastConfigSendTime = new Timestamp(0);
		blocked = false;
		lastErrorTime = new Timestamp(0);
		lastErrorStatus = new ArrayList<>();
		config = new ArrayList<>();
		state = new ArrayList<>();
		logLevel = 0;
		metadata = new ArrayList<>();
		gatewayConfig = new ArrayList<>();
	}
	
	private Device(Builder builder) {
		id = builder.getId();
		name = builder.getName();
		numId = builder.getNumId();
		credentials = builder.getCredentials();
		lastHeartbeatTime = builder.getLastHeartbeatTime();		
		lastEventTime = builder.getLastEventTime();
		lastStateTime = builder.getLastStateTime();
		lastConfigAckTime = builder.getLastConfigAckTime();
		lastConfigSendTime = builder.getLastConfigSendTime();
		blocked = builder.isBlocked();
		lastErrorTime = builder.getLastErrorTime();
		lastErrorStatus = builder.getLastErrorStatus();
		config = builder.getConfig();
		state = builder.getState();
		logLevel = builder.getLogLevel();
		metadata = builder.getMetadata();
		gatewayConfig = builder.getGatewayConfig();
	}
	

	public static Builder newBuilder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static Device of(String id, String name, int numId, List<Object> credentials, List<String> lastErrorStatus,List<String> config, List<String> state, int logLevel, List<String> metadata, List<String> gatewayConfig) {
		return newBuilder().setId(id).setName(name).setNumId(numId).setCredentials(credentials).setLastErrorStatus(lastErrorStatus).setConfig(config).setState(state).setLogLevel(logLevel).setMetadata(metadata).setGatewayConfig(gatewayConfig).build();
	}

	public static String format(String id, String name, int numId, List<Object> credentials, List<String> lastErrorStatus,List<String> config, List<String> state, int logLevel, List<String> metadata, List<String> gatewayConfig) {
		return newBuilder().setId(id).setName(name).setNumId(numId).setCredentials(credentials).setLastErrorStatus(lastErrorStatus).setConfig(config).setState(state).setLogLevel(logLevel).setMetadata(metadata).setGatewayConfig(gatewayConfig).build()
				.toString();
	}

	/**
	 * Builder for setting 
	 * Device - id, name, credentials and logLevel
	 */
	public static class Builder {
		private String id;
		private String name;
		private int numId;
		private List<Object> credentials;
		private Timestamp lastHeartbeatTime;
		private Timestamp lastEventTime;
		private Timestamp lastStateTime;
		private Timestamp lastConfigAckTime;
		private Timestamp lastConfigSendTime;
		private boolean blocked;
	    private Timestamp	lastErrorTime;
		private List<String> lastErrorStatus;
		private List<String> config;
		private List<String> state;	
		private int logLevel;
		private List<String> metadata;
		private List<String> gatewayConfig;

		
		protected Builder() {
			
		}
		
		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getNumId() {
			return numId;
		}

		public List<Object> getCredentials() {
			return credentials;
		}		
		
		public Timestamp getLastHeartbeatTime() {
			return lastHeartbeatTime;
		}

		public Timestamp getLastEventTime() {
			return lastEventTime;
		}

		public Timestamp getLastStateTime() {
			return lastStateTime;
		}

		public Timestamp getLastConfigAckTime() {
			return lastConfigAckTime;
		}

		public Timestamp getLastConfigSendTime() {
			return lastConfigSendTime;
		}

		public boolean isBlocked() {
			return blocked;
		}

		public Timestamp getLastErrorTime() {
			return lastErrorTime;
		}

		public List<String> getLastErrorStatus() {
			return lastErrorStatus;
		}

		public List<String> getConfig() {
			return config;
		}

		public List<String> getState() {
			return state;
		}

		public List<String> getMetadata() {
			return metadata;
		}

		public List<String> getGatewayConfig() {
			return gatewayConfig;
		}

		public int getLogLevel() {
			return logLevel;
		}
		
		public static Builder newBuilder() {
			return newBuilder();
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNumId(int numId) {
			this.numId = numId;
			return this;
		}
		
		public Builder setCredentials(List<Object> credentials) {
			this.credentials = credentials;
			return this;
		}

		public Builder setLastErrorStatus(List<String> lastErrorStatus) {
			this.lastErrorStatus = lastErrorStatus;
			return this;
		}

		public Builder setConfig(List<String> config) {
			this.config = config;
			return this;
		}

		public Builder setLogLevel(int logLevel) {
			this.logLevel = logLevel;
			return this;
		}

		public Builder setState(List<String> state) {
			this.state = state;
			return this;
		}

		public Builder setMetadata(List<String> metadata) {
			this.metadata = metadata;
			return this;
		}
		
		public Builder setGatewayConfig(List<String> gatewayConfig) {
			this.gatewayConfig = gatewayConfig;
			return this;
		}
		private Builder(Device device) {
			this.id = device.id;
			this.name = device.name;
			this.numId = device.numId;
			this.credentials = device.credentials;
			this.lastHeartbeatTime = device.lastHeartbeatTime;
			this.lastEventTime = device.lastEventTime;
			this.lastStateTime = device.lastStateTime;
			this.lastConfigAckTime = device.lastConfigAckTime;
			this.lastConfigSendTime = device.lastConfigSendTime;
			this.blocked = device.blocked;
		    this.lastErrorTime = device.lastErrorTime;
			this.lastErrorStatus = device.lastErrorStatus;
			this.config = device.config;
			this.state = device.state;
			this.logLevel = device.logLevel;
			this.metadata = device.metadata;
			this.gatewayConfig = device.gatewayConfig;
		}

		public Device build() {
			return new Device(this);
		}
	}
	@Override
	public String toString() {
		String deviceStr ="";
		deviceStr = deviceStr.concat("id="+this.id+",name="+this.name+",numId="+this.numId+",credentials="+this.credentials
									 +",lastHeartbeatTime="+this.lastHeartbeatTime+",lastEventTime="+this.lastEventTime
									 +",lastStateTime="+this.lastStateTime+",lastConfigAckTime="+this.lastConfigAckTime
									 +",lastConfigSendTime="+this.lastConfigSendTime+",blocked="+this.blocked
									 +",lastErrorTime="+this.lastErrorTime
									 + ",lastErrorStatus="+this.lastErrorStatus+",config="+this.config
									 +",state="+this.state+",logLevel="+this.logLevel+",metadata="+this.metadata
									 +",gatewayConfig="+this.gatewayConfig);
		return deviceStr;
	}
}
