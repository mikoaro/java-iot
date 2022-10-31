package com.clearblade.cloud.iot.v1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.SetHttpConnection;

public class ProcessRequest {

	Constants constants;
	URL obj;
	HttpsURLConnection con;
	int responseCode;
	String inputString;

	// Empty Constructor
	public ProcessRequest() {
		constants = new Constants();
		obj = null;
		con = null;
		responseCode = 0;
		inputString = null;
	}

	/**
	 * Method used to get process the request when inputString and connection object
	 * are inputs ResponseCode - integer value is sent as return value
	 * 
	 * @param methodName
	 * @return int - response code
	 */
	public int processRequestForMethod(String methodName) {
		// https://iot-sandbox.clearblade.com:443/api/v/4/webhook/execute/fedbc9b40cde90befbd9b2dfde9d01/cloudiot_devices?name=Rashmi_Device_Test&method=sendCommandToDevice
		if (methodName.equals("sendCommandToDevice")) {

			String name = constants.getDeviceName();
			String params = "?name=" + name + "&method=" + methodName;

			try {
				obj = new URL(
						constants.getHttpURLBegin() + constants.getEndPoint() + constants.getSendCommandPathPart1()
								+ constants.getSystemKey() + constants.getSendCommandPathPart2() + params);
				con = SetHttpConnection.getConnection(obj);
				// Calling setConnectionMethod
				responseCode = setConnectionMethods(con, methodName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (methodName.equals("createDevice")) {
			// https://iot-sandbox.clearblade.com/api/v/4/webhook/execute/fedbc9b40cde90befbd9b2dfde9d01/cloudiot_devices?deviceNumIds=124,666&subfolder=775
			String deviceNumIds = constants.getNumIds();
			String subfolder = constants.getSubFolder();
			String params = "?deviceNumIds=" + deviceNumIds + "&subfolder=" + subfolder;

			try {
				obj = new URL(
						constants.getHttpURLBegin() + constants.getEndPoint() + constants.getCreateDevicePathPart1()
								+ constants.getSystemKey() + constants.getCreateDevicePathPart2() + params);
				con = SetHttpConnection.getConnection(obj);
				// Calling setConnectionMethod
				responseCode = setConnectionMethods(con, methodName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseCode;
	}
	/**
	 * Set connection methods
	 * @param con
	 * @returning response code
	 */
	public int setConnectionMethods(HttpsURLConnection con,String methodName) {
		if (con != null) {
			try {
				con.setRequestMethod(constants.getHttpRequestMethodType());
			} catch (ProtocolException e) {
				e.printStackTrace();
			}
			con.setRequestProperty(constants.getHttpRequestPropertyTokenKey(), constants.getToken());
			con.setRequestProperty(constants.getHttpRequestPropertyContentTypeKey(),
					constants.getHttpRequestPropertyContentTypeOrAcceptValue());
			con.addRequestProperty(constants.getHttpRequestPropertyAcceptKey(),
					constants.getHttpRequestPropertyContentTypeOrAcceptValue());	
			if(methodName.equals("sendCommandToDevice")){
				inputString = constants.getJsonInputString();
			}else if (methodName.equals("createDevice")) {
				inputString = constants.getCreateDeviceInputString();			
			}
			// SetOutput to connection
			con.setDoOutput(true);
			// Get responseCode from Connection
			responseCode = getResponse(con, inputString);
		} else {
			responseCode = 0;
		}
		return responseCode;
	}

	/**
	 * Method used to get Response when inputString and connection object are inputs
	 * ResponseCode - integer value is sent as return value
	 * 
	 * @param con
	 * @param inputString
	 * @return responseCode
	 */
	public int getResponse(HttpsURLConnection con, String inputString) {
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = inputString.getBytes(StandardCharsets.UTF_8);
			os.write(input, 0, input.length);
			responseCode = con.getResponseCode();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return responseCode;
	}
}
