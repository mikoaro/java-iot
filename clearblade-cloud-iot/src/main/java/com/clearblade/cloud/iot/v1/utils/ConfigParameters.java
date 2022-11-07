package com.clearblade.cloud.iot.v1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParameters {
	// Fields used to set values from properties file
	private String endPoint;
	private String systemKey;
	private String token;
	private String baseURL;
	private String devicesURLExtension;

	// Fields used to fetch values from Properties file
	Properties properties;
	InputStream input;

	public ConfigParameters() {
		properties = null;
		input = null;
		setValues();
	}

	/**
	 * Method used to read values form config.properties file and setting in field
	 * setters
	 */
	public void getConfigurations() {
		// Read inputs from properties file
		properties = new Properties();
		input = getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Method used to set values in Constants setter method
	 */
	public void setValues() {
		//get Configurations uploaded from config.properties file
		getConfigurations();
		this.setEndPoint(properties.getProperty("endPoint"));
		this.setSystemKey(properties.getProperty("systemKey"));
		this.setToken(properties.getProperty("token"));
		this.setBaseURL(properties.getProperty("baseURL"));
		this.setDevicesURLExtension(properties.getProperty("devicesURLExtension"));
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getSystemKey() {
		return systemKey;
	}

	public void setSystemKey(String systemKey) {
		this.systemKey = systemKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getDevicesURLExtension() {
		return devicesURLExtension;
	}

	public void setDevicesURLExtension(String devicesURLExtension) {
		this.devicesURLExtension = devicesURLExtension;
	}

}
