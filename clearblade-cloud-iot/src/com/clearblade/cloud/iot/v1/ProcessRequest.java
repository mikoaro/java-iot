package com.clearblade.cloud.iot.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;

import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.SetHttpConnection;

public class ProcessRequest {

	URL obj;
	HttpsURLConnection con;
	String responseMessage;
	JSONObject bodyJSONObj;
	int responseCode;
	ConfigParameters configParameters;
	SetHttpConnection setCon;
	String emptyStr;

	// Empty Constructor
	public ProcessRequest() {
		emptyStr = "";
		configParameters = new ConfigParameters();
		obj = null;
		con = null;
		setCon = null;
		responseCode = 0;
		responseMessage = null;
	}

	/**
	 * Method used to get process the request when inputString and connection object
	 * are inputs ResponseCode - integer value is sent as return value
	 * 
	 * @param methodName
	 * @return String - response message
	 */
	public String processRequestForMethod(String methodName, JSONObject requestParams, JSONObject bodyParams) {

		String finalURL = emptyStr;
		String name;
		String deviceNumIds;
		String subfolder;
		String parent;
		String numStates;
		String method;
		String localVersion;
		String numVersions;
		

		// Setting partial URL
		String urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint())
				.concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey())
				.concat(configParameters.getDevicesURLExtension());

		if (bodyParams != null && bodyParams.size() > 0) {
			this.setBodyJSONObj(bodyParams);
		}
		if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) && requestParams != null && requestParams.size() > 0) {
			name = requestParams.get("name").toString();
			finalURL = urlPartial.concat("?name=" + name + "&method=" + methodName);
		} else if (methodName.equals(Constants.CREATE_DEVICE) && requestParams != null && requestParams.size() > 0) {
			deviceNumIds = requestParams.get("deviceNumIds").toString();
			subfolder = requestParams.get("subfolder").toString();
			finalURL = urlPartial.concat("?deviceNumIds=" + deviceNumIds + "&subfolder=" + subfolder);
		} else if (((methodName.equals(Constants.DELETE_DEVICE)) || (methodName.equals(Constants.GET_DEVICE)))
				&& (requestParams != null && requestParams.size() > 0)) {
			name = requestParams.get("name").toString();
			finalURL = urlPartial.concat("?name=" + name);
		} else if (methodName.equals(Constants.DEVICES_LIST) && (requestParams != null && requestParams.size() > 0)) {
			parent = requestParams.get("parent").toString();
			finalURL = urlPartial.concat("?parent=" + parent);
		}else if (methodName.equals(Constants.DEVICE_STATES_LIST) && (requestParams != null && requestParams.size() > 0)) {			
			urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint())
			.concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey())
			.concat(configParameters.getDevicesStatesURLExtension());
			name = requestParams.get("name").toString();
			numStates = requestParams.get("numStates").toString();
			finalURL = urlPartial.concat("?name=" + name+"&numStates="+Integer.parseInt(numStates));
		}else if (methodName.equals(Constants.DEVICE_SET_STATES) && requestParams != null && requestParams.size() > 0) {
			urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint())
					.concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey())
					.concat(configParameters.getCloudiotdevicesURLExtension());
		    name = requestParams.get("name").toString();
		    method = requestParams.get("method").toString();
			finalURL = urlPartial.concat("?name=" + name + "&method=" + method);
		} else if (methodName.equals(Constants.DEVICE_GET_CONFIG) && requestParams != null && requestParams.size() > 0) {
			urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint())
					.concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey())
					.concat(configParameters.getCloudiotdevicesURLExtension());
		    name = requestParams.get("name").toString();
		    localVersion = requestParams.get("localVersion").toString();
			finalURL = urlPartial.concat("?name=" + name + "&localVersion=" + localVersion);
		}else if (methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG) && requestParams != null && requestParams.size() > 0) {
			name = requestParams.get("name").toString();
			method = requestParams.get("method").toString();
			finalURL = urlPartial.concat("?name=" + name + "&method=" + method);
		} else if (methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST) && requestParams != null && requestParams.size() > 0) {
			urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint()).concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey()).concat(configParameters.getCloudiotdevicesURLExtension());
		    name = requestParams.get("name").toString();
		    numVersions = requestParams.get("numVersions").toString();
			finalURL = urlPartial.concat("?name=" + name + "&numVersions=" + numVersions);
		} else if (methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY) && requestParams != null && requestParams.size() > 0) {
				urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint()).concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey()).concat(configParameters.getCloudiotURLExtension());
				method = requestParams.get("method").toString();
				parent = requestParams.get("parent").toString();
				finalURL = urlPartial.concat("?method=" + method + "&parent=" + parent);
		} else if (methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY) && requestParams != null && requestParams.size() > 0) {
			urlPartial = Constants.HTTPS_URL_PREFIX.concat(configParameters.getEndPoint()).concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey()).concat(configParameters.getCloudiotURLExtension());
			method = requestParams.get("method").toString();
			parent = requestParams.get("parent").toString();
			finalURL = urlPartial.concat("?method=" + method + "&parent=" + parent);
		}	 

		try {
			obj = new URL(finalURL);
			setCon = new SetHttpConnection();
			con = setCon.getConnection(obj);
			// Calling setConnectionMethod
			responseMessage = setConnectionMethods(con, methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	/**
	 * Set connection methods
	 * 
	 * @param con
	 * @returning response message
	 */
	public String setConnectionMethods(HttpsURLConnection con, String methodName) {

		if (con != null) {
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, configParameters.getToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);

			String methodType = "";
			if ((methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE)) || (methodName.equals(Constants.DEVICE_SET_STATES)) || methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG)|| methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY) || (methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY))) {
				methodType = Constants.HTTP_REQUEST_METHOD_TYPE_POST;
			} else if (methodName.equals(Constants.DELETE_DEVICE)) {
				methodType = Constants.HTTP_REQUEST_METHOD_TYPE_DELETE;
			} else if ((methodName.equals(Constants.GET_DEVICE)) || (methodName.equals(Constants.DEVICES_LIST)) || (methodName.equals(Constants.DEVICE_STATES_LIST)) || (methodName.equals(Constants.DEVICE_GET_CONFIG))|| (methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST))) {
				methodType = Constants.HTTP_REQUEST_METHOD_TYPE_GET;
			}
			try {
				con.setRequestMethod(methodType);
			} catch (ProtocolException e) {
				e.printStackTrace();
			}

			// SetOutput to connection
			con.setDoOutput(true);

			// Get responseCode from Connection
			if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE) || methodName.equals(Constants.DEVICE_SET_STATES) || methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG) || methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY) || methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY)) {
				responseMessage = getResponseForPostMethod(con);
			} else if (methodName.equals(Constants.DELETE_DEVICE)) {
				responseMessage = getResponseForDeleteDevice(con);
			} else if (methodName.equals(Constants.GET_DEVICE) || methodName.equals(Constants.DEVICES_LIST) || methodName.equals(Constants.DEVICE_STATES_LIST) || methodName.equals(Constants.DEVICE_GET_CONFIG) || methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST)) {
				responseMessage = getResponseForGetRequest(con);
			}
		}
		return responseMessage;
	}

	/**
	 * Method used to get Response when inputString and connection object are inputs
	 * ResponseMessage - String value is sent as return value
	 * 
	 * @param con
	 * @param inputString
	 * @return responseMessage
	 */
	public String getResponseForGetRequest(HttpsURLConnection con) {
		StringBuilder response = new StringBuilder();
		InputStream inStr = null;
		BufferedReader in = null;
		try {
			responseCode = con.getResponseCode();
			if (responseCode != 200) {
				if (con.getErrorStream() != null) {
					inStr = con.getErrorStream();
				} else if (con.getInputStream() != null) {
					inStr = con.getInputStream();
				}
				in = new BufferedReader(new InputStreamReader(inStr));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				responseMessage = response.toString();
			} else if (responseCode == 200) {

				String splitResponse = "";
				String inputLine = "";
				if (con.getInputStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
				if(in != null) {
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
						splitResponse = splitResponse.concat(inputLine);
					}
					System.out.println(splitResponse);
					in.close();
				}
				responseMessage = "OK";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	public String getResponseForPostMethod(HttpsURLConnection con) {
		StringBuilder response = new StringBuilder();
		try (OutputStream os = con.getOutputStream()) {
			JSONObject js = this.getBodyJSONObj();
			byte[] input = js.toString().getBytes("utf-8");
			os.write(input, 0, input.length);
			os.flush();
			responseCode = con.getResponseCode();
			if (responseCode != 200) {
				BufferedReader in = null;
				if (con.getErrorStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				} else if (con.getInputStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
				String inputLine;
				if (in != null) {
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
				}
				responseMessage = response.toString();
			} else if (responseCode == 200) {
				responseMessage = "OK";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return responseMessage;
	}

	public String getResponseForDeleteDevice(HttpsURLConnection con) {
		StringBuilder response = new StringBuilder();
		try {
			responseCode = con.getResponseCode();
			if (responseCode != 200) {
				BufferedReader in = null;
				if (con.getErrorStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				} else if (con.getInputStream() != null) {
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				}
				String inputLine;
				if (in != null) {
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
				}
				responseMessage = response.toString();
			} else if (responseCode == 200) {
				responseMessage = "OK";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	public JSONObject getBodyJSONObj() {
		return bodyJSONObj;
	}

	public void setBodyJSONObj(JSONObject bodyJSONObj) {
		this.bodyJSONObj = bodyJSONObj;
	}

}