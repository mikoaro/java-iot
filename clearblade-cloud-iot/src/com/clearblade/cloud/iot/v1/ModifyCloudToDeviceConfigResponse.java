package com.clearblade.cloud.iot.v1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.Constants;

public class ModifyCloudToDeviceConfigResponse {

	static Logger log = Logger.getLogger(ModifyCloudToDeviceConfigResponse.class.getName());
	private final ModifyCloudToDeviceConfigRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected ModifyCloudToDeviceConfigResponse(Builder builder) {
		this.request = builder.request;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getHttpStatusResponse() {
		return httpStatusResponse;
	}

	public void setHttpStatusResponse(String httpStatusResponse) {
		this.httpStatusResponse = httpStatusResponse;
	}

	// Static class Builder
	public static class Builder {

		/// instance fields
		private ModifyCloudToDeviceConfigRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setModifyCloudToDeviceConfigRequest(ModifyCloudToDeviceConfigRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public ModifyCloudToDeviceConfigResponse build() {
			return new ModifyCloudToDeviceConfigResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * ModifyCloudToDeviceConfig
	 */
	public void processRequest(ModifyCloudToDeviceConfigRequest request) {
		String msg = "";
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		ProcessRequest processRequest = new ProcessRequest();
		if(request != null) {
			String logMsg = "Modify Cloud To Device Config Request :: "+request.toString();
			log.log(Level.INFO,logMsg);
			requestParams = (JSONObject) request.requestParams.clone();
			bodyParams = (JSONObject) request.bodyParams.clone();
		}		
		String responseMessage = processRequest.processRequestForMethod(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG,requestParams,bodyParams);
		this.setHttpStatusResponse(responseMessage);		
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for MODIFY_CLOUD_TO_DEVICE_CONFIG method";
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for MODIFY_CLOUD_TO_DEVICE_CONFIG failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public ModifyCloudToDeviceConfigRequest getRequest() {
		return request;
	}

}
