package com.clearblade.cloud.iot.v1.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//https://cloud.google.com/iot/docs/reference/cloudiot/rest/v1/projects.locations.registries#DeviceRegistry
public class DeviceRegistry {
	
	private String id;
	private String name;
	private List<EventNotificationConfig> eventNotificationConfigs;
	private StateNotificationConfig stateNotificationConfig;
	private MqttConfig mqttConfig;
	private HttpConfig httpConfig;
	private LogLevel logLevel;
	private List<RegistryCredential> credentials;

	
	public DeviceRegistry() {
		id = "";
		name = "";
		eventNotificationConfigs = new ArrayList<>();
		stateNotificationConfig = null;
		mqttConfig = MqttConfig.newBuilder().build();
		httpConfig = null;
		logLevel = null;
		credentials = new ArrayList<>();
	}
	
	private DeviceRegistry(Builder builder) {
		id = builder.getId();
		name = builder.getName();
		eventNotificationConfigs = builder.getEventNotificationConfigs();
		stateNotificationConfig = builder.getStateNotificationConfig();
		mqttConfig = builder.getMqttConfig();
		httpConfig = builder.getHttpConfig();
		logLevel = builder.getLogLevel();
		credentials = builder.getCredentials();
	}
	

	public static Builder newBuilder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static DeviceRegistry of(String id, String name, List<EventNotificationConfig> eventNotificationConfigs,StateNotificationConfig stateNotificationConfig,MqttConfig mqttConfig,HttpConfig httpConfig,LogLevel logLevel,List<RegistryCredential> credentials) {
		return newBuilder().setId(id).setName(name).setEventNotificationConfigs(eventNotificationConfigs).setStateNotificationConfig(stateNotificationConfig).setMqttConfig(mqttConfig).setHttpConfig(httpConfig).setLogLevel(logLevel).setCredentials(credentials).build();
	}

	public static String format(String id, String name, List<EventNotificationConfig> eventNotificationConfigs,StateNotificationConfig stateNotificationConfig,MqttConfig mqttConfig,HttpConfig httpConfig,LogLevel logLevel,List<RegistryCredential> credentials) {
		return newBuilder().setId(id).setName(name).setEventNotificationConfigs(eventNotificationConfigs).setStateNotificationConfig(stateNotificationConfig).setMqttConfig(mqttConfig).setHttpConfig(httpConfig).setLogLevel(logLevel).setCredentials(credentials).build()
				.toString();
	}

	/**
	 * Builder for setting 
	 * Registry - attributes
	 */
	public static class Builder {
		private String id;
		private String name;
		private List<EventNotificationConfig> eventNotificationConfigs;
		private StateNotificationConfig stateNotificationConfig;
		private MqttConfig mqttConfig;
		private HttpConfig httpConfig;
		private LogLevel logLevel;
		private List<RegistryCredential> credentials;

		
		protected Builder() {
			
		}
		
		public static Builder newBuilder() {
			return newBuilder();
		}
		
		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<EventNotificationConfig> getEventNotificationConfigs() {
			return eventNotificationConfigs;
		}

		public StateNotificationConfig getStateNotificationConfig() {
			return stateNotificationConfig;
		}

		public MqttConfig getMqttConfig() {
			return mqttConfig;
		}

		public HttpConfig getHttpConfig() {
			return httpConfig;
		}

		public LogLevel getLogLevel() {
			return logLevel;
		}

		public List<RegistryCredential> getCredentials() {
			return credentials;
		}

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setEventNotificationConfigs(List<EventNotificationConfig> eventNotificationConfigs) {
			this.eventNotificationConfigs = eventNotificationConfigs;
			return this;
		}
		public Builder setStateNotificationConfig(StateNotificationConfig stateNotificationConfig) {
			this.stateNotificationConfig = stateNotificationConfig;
			return this;
		}

		public Builder setMqttConfig(MqttConfig mqttConfig) {
			this.mqttConfig = mqttConfig;
			return this;
		}
		public Builder setHttpConfig(HttpConfig httpConfig) {
			this.httpConfig = httpConfig;
			return this;
		}
		public Builder setLogLevel(LogLevel logLevel) {
			this.logLevel = logLevel;
			return this;
		}
		public Builder setCredentials(List<RegistryCredential> credentials) {
			this.credentials = credentials;
			return this;
		}


		private Builder(DeviceRegistry registry) {
			this.id = registry.id;
			this.name = registry.name;
			this.eventNotificationConfigs = registry.eventNotificationConfigs;
			this.stateNotificationConfig = registry.stateNotificationConfig;
			this.mqttConfig = registry.mqttConfig;
			this.httpConfig = registry.httpConfig;
			this.logLevel = registry.logLevel;
			this.credentials = registry.credentials;			
		}

		public DeviceRegistry build() {
			return new DeviceRegistry(this);
		}
	}
	@Override
	public String toString() {
		return ("id="+this.id+",name="+this.name
				 +",eventNotificationConfigs="+this.eventNotificationConfigs
				 +",stateNotificationConfig="+this.stateNotificationConfig
				 +"mqttConfig="+this.mqttConfig.toBuilder().build()
				 +",httpConfig="+this.httpConfig
				 +",logLevel="+this.logLevel
				 +",credentials="+this.credentials);
	}

	public void loadFromString(String inputStr) {
		try {
			JSONParser parser = new JSONParser();
			JSONObject deviceObj = (JSONObject) parser.parse(inputStr);

			if (deviceObj != null && deviceObj.size() > 0) {

				Set deviceSet = deviceObj.keySet();
				Iterator itr = deviceSet.iterator();
				while (itr.hasNext()) {
					String key = (String) itr.next();
					Object value = deviceObj.get(key);
					if (key.equals("id")) {
						this.id = value.toString();
					}
					if (key.equals("name")) {
						this.name = value.toString();
					}
					if (key.equals("credentials")) {
						List<RegistryCredential> credentialList = new ArrayList<>();
						RegistryCredential credentialObj = new RegistryCredential();
						credentialList.add(credentialObj);
						this.credentials = credentialList;
					}
					if(key.equals("eventNotificationConfigs")) {
						JSONArray eventJsonArray = (JSONArray) value;
						List<EventNotificationConfig> eventNotificationCfgs = new ArrayList<>();
						Iterator eventIterator = eventJsonArray.iterator();
						while (eventIterator.hasNext()) {
							JSONObject eventJson = (JSONObject) eventIterator.next();
							EventNotificationConfig eventObj = EventNotificationConfig.newBuilder().setSubfolderMatches((String)eventJson.get("subfolderMatches"))
									.setPubsubTopicName((String)eventJson.get("pubsubTopicName"))
									.build();
							eventNotificationCfgs.add(eventObj);
						}
						this.eventNotificationConfigs = eventNotificationCfgs;						
					}
					if(key.equals("stateNotificationConfig")) {
						JSONObject stateJsonObject = (JSONObject) value;
						StateNotificationConfig stateNotificationCfg = new StateNotificationConfig();
						if (stateJsonObject.containsKey("pubsubTopicName"))
							stateNotificationCfg.setPubsubTopicName((String) stateJsonObject.get("pubsubTopicName"));
						this.stateNotificationConfig = stateNotificationCfg;						
					}
					if(key.equals("mqttConfig")) {
						JSONObject mqttJsonObject = (JSONObject) value;
						MqttConfig mqttCfg = new MqttConfig();
						if (mqttJsonObject.containsKey("mqttEnabledState"))
							mqttCfg.setMqttEnabledState(MqttState.valueOf((String) mqttJsonObject.get("mqttEnabledState")));
						this.mqttConfig = mqttCfg;						
					}
					if(key.equals("httpConfig")) {
						JSONObject httpJsonObject = (JSONObject) value;
						HttpConfig httpCfg = new HttpConfig();
						if (httpJsonObject.containsKey("httpEnabledState"))
							httpCfg.setHttpEnabledState(HttpState.valueOf((String) httpJsonObject.get("httpEnabledState")));
						this.httpConfig = httpCfg;						
					}
					if (key.equals("logLevel")) {
						if (value != null) {
							this.logLevel = LogLevel.valueOf(value.toString());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
				
}
