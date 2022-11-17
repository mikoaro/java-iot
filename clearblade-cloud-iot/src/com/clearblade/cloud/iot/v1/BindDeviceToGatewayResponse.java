package com.clearblade.cloud.iot.v1;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.Constants;

public class BindDeviceToGatewayResponse {

	static Logger log = Logger.getLogger(BindDeviceToGatewayResponse.class.getName());
	private final BindDeviceToGatewayRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;

	protected BindDeviceToGatewayResponse(Builder builder) {
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
		private BindDeviceToGatewayRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}
		
		private Builder() {
		}

		// Setter methods
		public Builder setBindDeviceToGatewayRequest(BindDeviceToGatewayRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public BindDeviceToGatewayResponse build() {
			return new BindDeviceToGatewayResponse(this);
		}
	}

	/**
	 * Mehtod used to process the request Calling processRequestForMethod -
	 * BindDeviceToGateway
	 */
	public void processRequest(BindDeviceToGatewayRequest request) {
		String msg = "";
		JSONObject requestParams = new JSONObject();
		JSONObject bodyParams = new JSONObject();
		ProcessRequest processRequest = new ProcessRequest();
		if(request != null) {
			String logMsg = "Bind Device To Gateway Request :: "+request.toString();
			log.log(Level.INFO,logMsg);
			requestParams = (JSONObject) request.requestParams.clone();
			bodyParams = (JSONObject) request.bodyParams.clone();
		}		
		String responseMessage = processRequest.processRequestForMethod(Constants.BIND_DEVICE_TO_GATEWAY,requestParams,bodyParams);
		this.setHttpStatusResponse(responseMessage);		
		if (responseMessage.equals("OK")) {
			this.setHttpStatusCode(200);
			msg = "Request processed for BIND_DEVICE_TO_GATEWAY method";
			log.log(Level.INFO, msg);
		} else {
			this.setHttpStatusCode(0);
			msg = "Request for BIND_DEVICE_TO_GATEWAY failed \n" .concat(responseMessage);
			log.log(Level.SEVERE, msg);
		}
	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}

	public BindDeviceToGatewayRequest getRequest() {
		return request;
	}

}
