package com.clearblade.cloud.iot.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.clearblade.cloud.iot.v1.auth.AdminAccess;
import com.clearblade.cloud.iot.v1.auth.SystemAccess;
import com.clearblade.cloud.iot.v1.getregistrycredentials.GetRegistryCredentialsRequest;
import com.clearblade.cloud.iot.v1.getregistrycredentials.GetRegistryCredentialsResponse;
import com.clearblade.cloud.iot.v1.sendcommandtodevice.SendCommandToDeviceRequest;
import com.clearblade.cloud.iot.v1.utils.AuthParams;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.SetHttpConnection;

public class ProcessRequest {

	static Logger log = Logger.getLogger(ProcessRequest.class.getName());
	URL obj;
	HttpsURLConnection con;
	String responseMessage;
	JSONObject bodyJSONObj;
	JSONObject requestJSONObj;
	int responseCode;
	ConfigParameters configParameters;
	SetHttpConnection setCon;
	String emptyStr;
	SystemAccess systemAccess;
	AuthParams authParams;

	
	public void getRegistryCredentials() {

		String msg = "";
		
		GetRegistryCredentialsRequest request = GetRegistryCredentialsRequest.Builder.newBuilder().build();
		GetRegistryCredentialsResponse response = GetRegistryCredentialsResponse.Builder.newBuilder().setGetRegistryCredentialsRequest(request).build();
		
		if (response != null) {
			log.log(Level.INFO,"Request is processed for {0}",request);
			JSONObject requestParams = new JSONObject();
			JSONObject bodyParams = new JSONObject();
			if(request.getBodyParams()!= null) {
				bodyParams = (JSONObject) request.getBodyParams().clone();
			}	
			try {
				responseMessage = processRequestGetRegistryCredential(Constants.GET_REGISTRY_CREDENTIALS, requestParams, bodyParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setHttpStatusResponse(responseMessage);
			if (responseMessage.equals("OK")) {
				response.setHttpStatusCode(200);
				msg = "Request processed for GetRegistryCredentialsRequest method";
				
				log.log(Level.INFO, msg);
			} else {
				response.setHttpStatusCode(0);
				msg = "Request for GetRegistryCredentialsRequest failed \n" .concat(responseMessage);
				log.log(Level.SEVERE, msg);
			}
			if (response.getHttpStatusResponse().equals("OK")) {
				msg = "AsyncGetRegistryCredentials Method worked successfully :: " + response.getHttpStatusResponse();
				log.log(Level.INFO, msg);
			} else {
				msg = "AsyncGetRegistryCredentials Method execution failed :: " + response.getHttpStatusResponse();
				log.log(Level.SEVERE, msg);
			}
		} else {
			msg = "AsyncGetRegistryCredentials Method execution failed";
			log.log(Level.SEVERE, msg);
		}
	}
	
	// Empty Constructor
	public ProcessRequest() {
		
		emptyStr = "";
		configParameters = new ConfigParameters();
		obj = null;
		con = null;
		setCon = null;
		responseCode = 0;
		responseMessage = null;
		systemAccess = new SystemAccess();
		AdminAccess adminAccess = new AdminAccess();
		if(adminAccess.getAuthParams() == null) {
			authParams =adminAccess.getSystemCredentials();
		}else {
			authParams = adminAccess.getAuthParams();
		}
		this.setAuthParams(authParams);
		if(systemAccess.getApiBaseURL() == null) {
			getRegistryCredentials();
		}
	}

	/**
	 * Method used to getRegistryCredentials and 
	 * set user system access
	 * @param methodName
	 * @param requestParams
	 * @param bodyParams
	 * @return String value of response object
	 */
	public String processRequestGetRegistryCredential(String methodName, JSONObject requestParams, JSONObject bodyParams) {
		String finalURL = emptyStr;
		try {
			if (bodyParams != null && bodyParams.size() > 0) {
				this.setBodyJSONObj(bodyParams);
			}
			finalURL = generateURL(methodName, requestParams);
			obj = new URL(finalURL);
			setCon = new SetHttpConnection();
			con = setCon.getConnection(obj);
			responseMessage = setConnectionMethods(con, methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	/**
	 * Method used to get process the request when inputString and connection object
	 * are inputs ResponseCode - integer value is sent as return value
	 * @param methodName
	 * @return String - response message
	 */
	public String processRequestForMethod(String methodName, JSONObject requestParams, JSONObject bodyParams) {
		try {
			if (bodyParams != null && bodyParams.size() > 0) {
				this.setBodyJSONObj(bodyParams);
			}
			String finalURL = generateURL(methodName, requestParams);
			log.log(Level.INFO,finalURL);
			obj = new URL(finalURL);
			setCon = new SetHttpConnection();
			con = setCon.getConnection(obj);
			responseMessage = setConnectionMethods(con, methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	/**
	 * Set connection methods
	 * @param con
	 * @returning response message
	 */
	public String setConnectionMethods(HttpsURLConnection con, String methodName) {

		if (con != null) {
			if (methodName.equals(Constants.GET_REGISTRY_CREDENTIALS)) {
				con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, authParams.getAdminToken());
			}else {
				con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, systemAccess.getUserSystemToken());
			}
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);

			String methodType = setMethodType(methodName);
			try {
				con.setRequestMethod(methodType);
				if (methodName.equals(Constants.DEVICE_PATCH)) {
					con.setRequestProperty("X-HTTP-Method-Override", Constants.HTTP_REQUEST_METHOD_TYPE_PATCH);
				}
			} catch (ProtocolException e) {
				e.printStackTrace();
			}

			// SetOutput to connection
			con.setDoOutput(true);

			// Get responseCode from Connection
			if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE)
					|| methodName.equals(Constants.DEVICE_SET_STATES)
					|| methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG)
					|| methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY)
					|| methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY)) {
				responseMessage = getResponseForPostMethod(con);
			} else if (methodName.equals(Constants.DELETE_DEVICE)) {
				responseMessage = getResponseForDeleteDevice(con);
			} else if (methodName.equals(Constants.GET_DEVICE) || methodName.equals(Constants.DEVICES_LIST)
					|| methodName.equals(Constants.DEVICE_STATES_LIST) || methodName.equals(Constants.DEVICE_GET_CONFIG)
					|| methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST)) {
				responseMessage = getResponseForGetRequest(con);
			} else if (methodName.equals(Constants.DEVICE_PATCH)) {
				responseMessage = getResponseForPostMethod(con);
			} else if (methodName.equals(Constants.GET_REGISTRY_CREDENTIALS)) {
				responseMessage = getResponseForRegsitryCredentialsMethod(con);
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
				if (in != null) {
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
			byte[] input = js.toString().getBytes(Constants.UTF8);
			os.write(input, 0, input.length);
			os.flush();
			responseCode = con.getResponseCode();
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
			if (responseCode != 200) {
				responseMessage = response.toString();
			} else if (responseCode == 200) {
				responseMessage = "OK";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return responseMessage;
	}

	public String getResponseForRegsitryCredentialsMethod(HttpsURLConnection con) {
		StringBuilder response = new StringBuilder();
		try (OutputStream os = con.getOutputStream()) {
			JSONObject js = this.getBodyJSONObj();
			byte[] input = js.toString().getBytes(Constants.UTF8);
			os.write(input, 0, input.length);
			os.flush();
			responseCode = con.getResponseCode();
			BufferedReader in = null;
			if (con.getErrorStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else if (con.getInputStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			JSONObject responseJSONObject = new JSONObject();
			JSONParser responseParser = new JSONParser();
			String inputLine;
			if (in != null) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				responseMessage = response.toString();
			}
			if (responseCode == 200) {
				try {
					if(responseMessage != null && responseMessage.length() > 0) {
						Object responseObj = responseParser.parse(responseMessage);
						if(responseObj != null) {
							responseJSONObject = (JSONObject) responseObj;
							systemAccess.setUserSystemKey(responseJSONObject.get(Constants.USER_SYSTEM_KEY).toString());
							systemAccess.setUserSystemToken(responseJSONObject.get(Constants.USER_TOKEN).toString());
							systemAccess.setApiBaseURL(responseJSONObject.get(Constants.API_BASE_URL).toString());
							this.setSystemAccess(systemAccess);
						}
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
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
			if (responseCode != 200) {
				responseMessage = response.toString();
			} else if (responseCode == 200) {
				responseMessage = "OK";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	public String asyncCallSendCommandToDevice(SendCommandToDeviceRequest request) throws InterruptedException {
		this.setBodyJSONObj(request.bodyParams);
		this.setRequestJSONObj(request.requestParams);
		Future<Object> future = getObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseMessage;
	}

	public Future<Object> getObjectAsync() {
		return CompletableFuture.supplyAsync(this::doHttpCall);
	}

	public Object doHttpCall() {
		StringBuilder response = new StringBuilder();
		try {

			// Generate URL for this api call
			String finalURL = generateURL(Constants.SEND_COMMAND_TO_DEVICE, this.getRequestJSONObj());

			obj = new URL(finalURL);
			setCon = new SetHttpConnection();
			con = setCon.getConnection(obj); // Calling setConnectionMethod
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, systemAccess.getUserSystemToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);

			String methodType = Constants.HTTP_REQUEST_METHOD_TYPE_POST;
			con.setRequestMethod(methodType);

			// SetOutput to connection 
			con.setDoOutput(true);

			OutputStream os = con.getOutputStream();
			JSONObject js = this.getBodyJSONObj();
			byte[] input = js.toString().getBytes(Constants.UTF8);
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

	public String generateURL(String methodName, JSONObject requestParams) {

		String finalURL = emptyStr;
		

		// Global Call
		if (requestParams.size() == 0) {
			if (methodName.equals(Constants.GET_REGISTRY_CREDENTIALS)) {
				String partialURL = authParams.getBaseURL()
											  .concat(configParameters.getGetSystemCredentialsExtension())
											  .concat(authParams.getAdminSystemKey())
											  .concat("/" + methodName);
				finalURL = finalURL.concat(partialURL);
			}
		}else {

				// Regional Call
				String urlPartial = this.getSystemAccess().getApiBaseURL()
														  .concat(configParameters.getEndpointPort())
														  .concat(configParameters.getBaseURL())
														  .concat(this.getSystemAccess().getUserSystemKey());
		
				String urlDevicesPartial = urlPartial.concat(configParameters.getDevicesURLExtension());
				String urlDevicesStatesPartial = urlPartial.concat(configParameters.getDevicesStatesURLExtension());
				String urlCloudiotdevicesPartial = urlPartial.concat(configParameters.getCloudiotdevicesURLExtension());
				String urlCloudiotURLPartial = urlPartial.concat(configParameters.getCloudiotURLExtension());


				if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG)) {
					
					String name = requestParams.get("name").toString();
					finalURL = urlDevicesPartial.concat(Constants.NAME + name + "&method=" + methodName);
					
				} else if (methodName.equals(Constants.CREATE_DEVICE)) {
					
					String deviceNumIds = requestParams.get("deviceNumIds").toString();
					String subfolder = requestParams.get("subfolder").toString();
					finalURL = urlDevicesPartial.concat("?deviceNumIds=" + deviceNumIds + "&subfolder=" + subfolder);
				
				} else if (methodName.equals(Constants.DELETE_DEVICE) || methodName.equals(Constants.GET_DEVICE)) {
				
					String name = requestParams.get("name").toString();
					finalURL = urlDevicesPartial.concat(Constants.NAME + name);
				
				} else if (methodName.equals(Constants.DEVICES_LIST)) {
				
					String parent = requestParams.get("parent").toString();
					finalURL = urlDevicesPartial.concat("?parent=" + parent);
				
				} else if (methodName.equals(Constants.DEVICE_STATES_LIST)) {
				
					String name = requestParams.get("name").toString();
					String numStates = requestParams.get("numStates").toString();
					finalURL = urlDevicesStatesPartial.concat(Constants.NAME + name + "&numStates=" + Integer.parseInt(numStates));
				
				} else if (methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST)) {
				
					String name = requestParams.get("name").toString();
					String numVersions = requestParams.get("numVersions").toString();
					finalURL = urlCloudiotdevicesPartial.concat(Constants.NAME + name + "&numVersions=" + numVersions);
				
				} else if (methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY) || methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY)) {
					
					String method = requestParams.get("method").toString();
					String parent = requestParams.get("parent").toString();
					finalURL = urlCloudiotURLPartial.concat("?method=" + method + "&parent=" + parent);
				
				} else if (methodName.equals(Constants.DEVICE_PATCH)) {
				
					String name = requestParams.get("name").toString();
					String updateMask = requestParams.get("updateMask").toString();
					finalURL = urlDevicesPartial.concat(Constants.NAME + name + "&updateMask=" + updateMask);
				}
		}
		
		return finalURL;
	}

	/**
	 * Method used to set method type on connection depending upon method name
	 * @param methodName
	 * @return methodType to be set for e.g. post, patch, delete etc
	 */
	public String setMethodType(String methodName) {
		String methodType = emptyStr;
		
		if ((methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE))
																 || methodName.equals(Constants.DEVICE_SET_STATES)
																 || methodName.equals(Constants.MODIFY_CLOUD_TO_DEVICE_CONFIG)
																 || methodName.equals(Constants.BIND_DEVICE_TO_GATEWAY)
																 || methodName.equals(Constants.UNBIND_DEVICE_FROM_GATEWAY)
																 || methodName.equals(Constants.GET_REGISTRY_CREDENTIALS)) {
			
			methodType = Constants.HTTP_REQUEST_METHOD_TYPE_POST;
			
		} else if (methodName.equals(Constants.DELETE_DEVICE)) {
			
			methodType = Constants.HTTP_REQUEST_METHOD_TYPE_DELETE;
			
		} else if ((methodName.equals(Constants.GET_DEVICE)) || methodName.equals(Constants.DEVICES_LIST)
															 || methodName.equals(Constants.DEVICE_STATES_LIST) 
															 || methodName.equals(Constants.DEVICE_GET_CONFIG)
															 || methodName.equals(Constants.DEVICE_CONFIG_VERSIONS_LIST)) {
			
			methodType = Constants.HTTP_REQUEST_METHOD_TYPE_GET;
			
		} else if (methodName.equals(Constants.DEVICE_PATCH)) {
			
			methodType = Constants.HTTP_REQUEST_METHOD_TYPE_POST;
			
		} 

		return methodType;
		
	}
	
	public JSONObject getBodyJSONObj() {
		return bodyJSONObj;
	}

	public void setBodyJSONObj(JSONObject bodyJSONObj) {
		this.bodyJSONObj = bodyJSONObj;
	}

	public JSONObject getRequestJSONObj() {
		return requestJSONObj;
	}

	public void setRequestJSONObj(JSONObject requestJSONObj) {
		this.requestJSONObj = requestJSONObj;
	}

	public SystemAccess getSystemAccess() {
		return systemAccess;
	}

	public void setSystemAccess(SystemAccess systemAccess) {
		this.systemAccess = systemAccess;
	}

	public AuthParams getAuthParams() {
		return authParams;
	}

	public void setAuthParams(AuthParams authParams) {
		this.authParams = authParams;
	}
}