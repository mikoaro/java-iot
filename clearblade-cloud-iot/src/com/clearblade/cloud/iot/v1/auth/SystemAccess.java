package com.clearblade.cloud.iot.v1.auth;

public class SystemAccess {
	
	private String userSystemKey;
	private String userSystemToken;
	private String apiBaseURL;
	
	public String getUserSystemKey() {
		return userSystemKey;
	}
	public void setUserSystemKey(String userSystemKey) {
		this.userSystemKey = userSystemKey;
	}
	public String getUserSystemToken() {
		return userSystemToken;
	}
	public void setUserSystemToken(String userSystemToken) {
		this.userSystemToken = userSystemToken;
	}
	public String getApiBaseURL() {
		return apiBaseURL;
	}
	public void setApiBaseURL(String apiBaseURL) {
		this.apiBaseURL = apiBaseURL;
	}
}
