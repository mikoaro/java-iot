package com.clearblade.cloud.iot.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.SetHttpConnection;

public class ProcessRequest {

	URL obj;
	HttpsURLConnection con;
	String responseMessage;
	int responseCode;
	String jsonInputString;
	String subfolderStr;
	String inputString;
	String deviceId;
	String deviceName;
	String deviceNumId;
	String bodyParams;
	ConfigParameters configParameters;

	// Empty Constructor
	public ProcessRequest() {
		configParameters = new ConfigParameters();
		obj = null;
		con = null;
		responseCode = 0;
		inputString = null;
		responseMessage = null;
		jsonInputString = null;
		subfolderStr = null;
		deviceId = null;
		deviceName = null;
		deviceNumId = null;
	}

	public String setRequestBodyParams(String methodName, String[] requestParamsArray) {
		String requestParams = "";
		String bodyParamsStr = "{";
		if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE)) {
			if (requestParamsArray != null) {
				for (int i = 0; i < requestParamsArray.length; i++) {
					String element = requestParamsArray[i];
					if (element.contains("name") || element.contains("deviceName")) {
						String subStr = element.substring(element.indexOf("=") + 1, element.length()).trim();
						requestParams = requestParams.concat(subStr);
					} else {
						if (element.contains("binaryData") || element.contains("binaryDataByte")) {
							String subStr = element.substring(element.indexOf("=") + 1, element.length()).trim();
							if(subStr.equals("EMPTY")) {
								bodyParamsStr = bodyParamsStr.concat("binaryData:\"\"");	
							}else {
								bodyParamsStr = bodyParamsStr.concat("binaryData:" + subStr);
							}
						}
						if (element.contains(Constants.SUBFOLDER)) {
							subfolderStr = element.substring(element.indexOf("=") + 1, element.length()).trim();
							bodyParamsStr = bodyParamsStr.concat(",subfolder:\"" + subfolderStr+"\"");
						}
					}
				}
				bodyParamsStr = bodyParamsStr.concat("}");
				this.setBodyParams(bodyParamsStr);

			}
		} else if (methodName.equals(Constants.CREATE_DEVICE)) {
			String bodyStr2 = "";
			if (requestParamsArray != null) {
				for (String element : requestParamsArray) {

					if (element.contains("parent")) {
						requestParams = requestParams.concat("112,113");
					}
					if (element.contains("id")) {
						deviceId = element.substring(element.indexOf("=") + 1, element.length()).trim();
						bodyStr2 = bodyStr2.concat("{\"id\":\"" + deviceId+"\"");
					}
					if (element.contains("name")) {
						deviceName = element.substring(element.indexOf("=") + 1, element.length()).trim();
						bodyStr2 = bodyStr2.concat(",\"name\":\"" + deviceName+"\"");
					}
					if (element.contains("numId")) {
						deviceNumId = element.substring(element.indexOf("=") + 1, element.length()).trim();
						bodyStr2 = bodyStr2.concat(",\"numId\":" + deviceNumId);
					}
					if (element.contains("subfolder")) {
						subfolderStr = element.substring(element.indexOf("=") + 1, element.length()).trim();
						if(subfolderStr.equals("EMPTY")) {
							bodyStr2 = bodyStr2.concat(",\"subfolder\":\"\"");
						}else {
							bodyStr2 = bodyStr2.concat(",\"subfolder\":" + subfolderStr);
						}
					}
				}
				bodyStr2 = bodyStr2.concat(", \"credentials\":[]");
				bodyStr2 = bodyStr2.concat(", \"lastErrorStatus\":{}");
				bodyStr2 = bodyStr2.concat(", \"config\":{}");
				bodyStr2 = bodyStr2.concat(", \"state\":{}");
				bodyStr2 = bodyStr2.concat(", \"logLevel\":\"NONE\"");
				bodyStr2 = bodyStr2.concat(", \"metadata\":{}");
				bodyStr2 = bodyStr2.concat(", \"gatewayConfig\":{}");
				bodyStr2 = bodyStr2.concat("}");

				if (bodyStr2 != null) {
					this.setBodyParams(bodyStr2);
				}
			}
		}else if((methodName.equals(Constants.DELETE_DEVICE)) || (methodName.equals(Constants.GET_DEVICE))) {
			if (requestParamsArray != null) {
				int len = requestParamsArray.length;
				if(len == 1) {
					String subStr = requestParamsArray[0].substring(requestParamsArray[0].indexOf("=") + 1, requestParamsArray[0].length()).trim();
					requestParams = requestParams.concat(subStr);
				}
			}
		}
		return requestParams;
	}

	/**
	 * Method used to get process the request when inputString and connection object
	 * are inputs ResponseCode - integer value is sent as return value
	 * 
	 * @param methodName
	 * @return String - response message
	 */
	// https://iot-sandbox.clearblade.com:443/api/v/4/webhook/execute/fedbc9b40cde90befbd9b2dfde9d01/cloudiot_devices?name=Rashmi_Device_Test&method=sendCommandToDevice
	public String processRequestForMethod(String methodName, String[] requestParamsArray) {

		// Setting up request params and body params
		String requestParams = setRequestBodyParams(methodName, requestParamsArray);
		String URLPartial = "";
		// Setting partial URL
		URLPartial = URLPartial.concat(Constants.HTTPS_URL_PREFIX).concat(configParameters.getEndPoint())
				.concat(configParameters.getBaseURL()).concat(configParameters.getSystemKey())
				.concat(configParameters.getDevicesURLExtension());

		String finalURL = "";
		if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE)) {
			finalURL = URLPartial.concat("?name=" + requestParams + "&method=" + methodName);
		} else if (methodName.equals(Constants.CREATE_DEVICE)) {
			finalURL = URLPartial.concat("?deviceNumIds=" + requestParams + "&subfolder=" + subfolderStr);
		}else if((methodName.equals(Constants.DELETE_DEVICE)) || (methodName.equals(Constants.GET_DEVICE))) {
			finalURL = URLPartial.concat("?name=" + requestParams);
		}
		try {
			obj = new URL(finalURL);
			con = SetHttpConnection.getConnection(obj);
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

			if ((methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE))) {

				try {
					con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_POST);
				} catch (ProtocolException e) {
					e.printStackTrace();
				}

				// SetOutput to connection
				con.setDoOutput(true);

				// Get responseCode from Connection
				responseMessage = getResponse(con, this.getBodyParams(),methodName);
			}else if(methodName.equals(Constants.DELETE_DEVICE)) {
				try {
					con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_DELETE);
					// SetOutput to connection
					con.setDoOutput(true);

					// Get responseCode from Connection
					responseMessage = getResponse(con, "",methodName);
				} catch (ProtocolException e) {
					e.printStackTrace();
				}	
			}else if(methodName.equals(Constants.GET_DEVICE)) {
				try {
					con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_GET);
					// SetOutput to connection
					con.setDoOutput(true);
					// Get responseCode from Connection
					responseMessage = getResponse(con, "",methodName);
					if(responseMessage != null) {
						String[] deviceArray = responseMessage.split(",");
						responseMessage = "";
						if(deviceArray.length > 0) {
							responseMessage = "OK";
						}
					}
				} catch (ProtocolException e) {
					e.printStackTrace();
				}
			}
		} else {
			responseMessage = null;
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
	public String getResponse(HttpsURLConnection con, String bodyData, String methodName) {
		StringBuilder response = new StringBuilder();
		if (methodName.equals(Constants.SEND_COMMAND_TO_DEVICE) || methodName.equals(Constants.CREATE_DEVICE)) {
			try (OutputStream os = con.getOutputStream()) {
			byte[] input = bodyData.getBytes("utf-8");
			os.write(input, 0, input.length);
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
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
		}else if (methodName.equals(Constants.DELETE_DEVICE)){
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
		}else if(methodName.equals(Constants.GET_DEVICE)) {
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
					BufferedReader in = null;
					if (con.getInputStream() != null) {
						in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					}
					String inputLine;
					if (in != null) {
						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
					}
					responseMessage = response.toString();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return responseMessage;
	}

	public String getBodyParams() {
		return bodyParams;
	}

	public void setBodyParams(String bodyParams) {
		this.bodyParams = bodyParams;
	}

}
