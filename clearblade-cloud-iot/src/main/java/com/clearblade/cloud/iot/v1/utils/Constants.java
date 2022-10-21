package com.clearblade.cloud.iot.v1.utils;

public class Constants {

	private String endPoint;
	private String path;
	private String systemKey;
	private String methodName;
	private String token;
	private DeviceName.Builder builder;

	public Constants() {
		this.setEndPoint("iot-sandbox.clearblade.com:443");
		this.setBuilder(DeviceName.newBuilder()
								  .setProject("ingressdevelopmentenv")
								  .setLocation("us-central1")
								  .setRegistry("Rashmi_Registry_Test")
								  .setDevice("Rashmi_Device_Test"));
		this.setPath("/api/v/4/webhook/execute/");
		this.setSystemKey("fedbc9b40cde90befbd9b2dfde9d01"); //Rashmi System Key
		this.setMethodName("sendCommandToDevice");
		this.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI4NmRjYzliNDBjOWVkMmI4YWFmZmMwOWRhMmNkMDEiLCJzaWQiOiJmZTdkNWIyMy1hODg4LTQ2NGUtOGE4MC01ZWM1NTYwOTBjZTIiLCJ1dCI6MiwidHQiOjEsImV4cCI6LTEsImlhdCI6MTY2NTc0MjU5NX0.osrsmcqunC6IMfgLfZis0UlC4s7W4mmKe73mq_SSJ8Q");
	}		 

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSystemKey() {
		return systemKey;
	}

	public void setSystemKey(String systemKey) {
		this.systemKey = systemKey;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public DeviceName.Builder getBuilder() {
		return builder;
	}

	public void setBuilder(DeviceName.Builder builder) {
		this.builder = builder;
	}

}
