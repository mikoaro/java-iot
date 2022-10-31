package com.clearblade.cloud.iot.v1.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {

	//Fields used to set values from properties file
	private String endPoint;
	private String systemKey;
	private String token;
	private String project;
	private String location;
	private String registry;
	private String deviceName;
	
	//Fields used to set key- values related to httpconnection - for common use
	private String httpRequestMethodType;
	private String httpRequestPropertyTokenKey;
	private String httpRequestPropertyContentTypeKey;
	private String httpRequestPropertyAcceptKey;
	private String httpRequestPropertyContentTypeOrAcceptValue;
	
	private String httpURLBegin;
	
	//Fields used to set values related for sendCommandToDevice method
	private String sendCommandMethodName;
	private String sendCommandPathPart1;
	private String sendCommandPathPart2;
	private String jsonInputString;
	
	
	//Fields used to fetch values from Properties file
	Properties properties;
	InputStream input;

	public Constants() {
		properties = null;
		input = null;
		setValues();
	}
	
	/**
	 * Method used to read values form config.properties file and setting in 
	 * field setters
	 */
	public void getConfigurations() {
		// Read inputs from properties file
		properties = new Properties();
		input = getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			properties.load(input);
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(input != null) {
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
		
		getConfigurations();
		
		this.setEndPoint(properties.getProperty("endPoint"));
		this.setSystemKey(properties.getProperty("systemKey"));
		this.setToken(properties.getProperty("token"));
		this.setProject(properties.getProperty("project"));
		this.setLocation(properties.getProperty("location"));
		this.setRegistry(properties.getProperty("registry"));
		this.setDeviceName(properties.getProperty("deviceName"));
		
		this.setHttpRequestMethodType(properties.getProperty("httpRequestMethodType"));
		this.setHttpRequestPropertyTokenKey(properties.getProperty("httpRequestPropertyTokenKey"));
		this.setHttpRequestPropertyContentTypeKey(properties.getProperty("httpRequestPropertyContentTypeKey"));
		this.setHttpRequestPropertyAcceptKey(properties.getProperty("httpRequestPropertyAcceptKey"));
		this.setHttpRequestPropertyContentTypeOrAcceptValue(properties.getProperty("httpRequestPropertyContentTypeOrAcceptValue"));
		
		this.setHttpURLBegin(properties.getProperty("httpURLBegin"));
		
		this.setSendCommandMethodName(properties.getProperty("sendCommandMethodName"));
		this.setSendCommandPathPart1(properties.getProperty("sendCommandPathPart1"));
		this.setSendCommandPathPart2(properties.getProperty("sendCommandPathPart2"));

		this.setJsonInputString(properties.getProperty("jsonInputString"));
		
		
	}
	
	public String getJsonInputString() {
		return jsonInputString;
	}

	public void setJsonInputString(String jsonInputString) {
		this.jsonInputString = jsonInputString;
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

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getHttpRequestMethodType() {
		return httpRequestMethodType;
	}

	public void setHttpRequestMethodType(String httpRequestMethodType) {
		this.httpRequestMethodType = httpRequestMethodType;
	}

	public String getHttpRequestPropertyTokenKey() {
		return httpRequestPropertyTokenKey;
	}

	public void setHttpRequestPropertyTokenKey(String httpRequestPropertyTokenKey) {
		this.httpRequestPropertyTokenKey = httpRequestPropertyTokenKey;
	}

	public String getHttpRequestPropertyContentTypeKey() {
		return httpRequestPropertyContentTypeKey;
	}

	public void setHttpRequestPropertyContentTypeKey(String httpRequestPropertyContentTypeKey) {
		this.httpRequestPropertyContentTypeKey = httpRequestPropertyContentTypeKey;
	}

	public String getHttpRequestPropertyAcceptKey() {
		return httpRequestPropertyAcceptKey;
	}

	public void setHttpRequestPropertyAcceptKey(String httpRequestPropertyAcceptKey) {
		this.httpRequestPropertyAcceptKey = httpRequestPropertyAcceptKey;
	}

	public String getHttpRequestPropertyContentTypeOrAcceptValue() {
		return httpRequestPropertyContentTypeOrAcceptValue;
	}

	public void setHttpRequestPropertyContentTypeOrAcceptValue(String httpRequestPropertyContentTypeOrAcceptValue) {
		this.httpRequestPropertyContentTypeOrAcceptValue = httpRequestPropertyContentTypeOrAcceptValue;
	}	

	public String getHttpURLBegin() {
		return httpURLBegin;
	}

	public void setHttpURLBegin(String httpURLBegin) {
		this.httpURLBegin = httpURLBegin;
	}

	public String getSendCommandMethodName() {
		return sendCommandMethodName;
	}

	public void setSendCommandMethodName(String sendCommandMethodName) {
		this.sendCommandMethodName = sendCommandMethodName;
	}

	public String getSendCommandPathPart1() {
		return sendCommandPathPart1;
	}

	public void setSendCommandPathPart1(String sendCommandPathPart1) {
		this.sendCommandPathPart1 = sendCommandPathPart1;
	}

	public String getSendCommandPathPart2() {
		return sendCommandPathPart2;
	}

	public void setSendCommandPathPart2(String sendCommandPathPart2) {
		this.sendCommandPathPart2 = sendCommandPathPart2;
	}

}
