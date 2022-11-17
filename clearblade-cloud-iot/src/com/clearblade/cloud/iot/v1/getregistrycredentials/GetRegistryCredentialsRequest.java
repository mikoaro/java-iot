package com.clearblade.cloud.iot.v1.getregistrycredentials;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.auth.AdminAccess;
import com.clearblade.cloud.iot.v1.utils.AuthParams;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Constants;

public class GetRegistryCredentialsRequest {
	
	JSONObject bodyParams;

	private GetRegistryCredentialsRequest(Builder builder) {
	}
	
	// Static class Builder
	public static class Builder {

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// build method to deal with outer class
		// to return outer instance
		public GetRegistryCredentialsRequest build() {
			return new GetRegistryCredentialsRequest(this);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		
		ConfigParameters configParams = new ConfigParameters();
		AdminAccess adminAccess = new AdminAccess();
		AuthParams authParams = adminAccess.getAuthParams();
		String regionName = configParams.getRegion();
		String projectName = authParams.getProject();
		String registryName = configParams.getRegistry();
		bodyParams = new JSONObject();
		bodyParams.put(Constants.REGION,regionName);
		bodyParams.put(Constants.REGISTRY,registryName);
		bodyParams.put("project", projectName);
		this.setBodyParams(bodyParams);
		return "region="+regionName+"registry="+registryName+"project="+projectName;
	}

	public JSONObject getBodyParams() {
		return bodyParams;
	}

	public void setBodyParams(JSONObject bodyParams) {
		this.bodyParams = bodyParams;
	}


}
