package com.clearblade.cloud.iot.v1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.HttpsURLConnection;

import com.clearblade.cloud.iot.v1.utils.AuthParams;
import com.clearblade.cloud.iot.v1.utils.ConfigParameters;
import com.clearblade.cloud.iot.v1.utils.Constants;
import com.clearblade.cloud.iot.v1.utils.SetHttpConnection;

public class AsyncClient {
	
	private ConfigParameters configParameters = new ConfigParameters();
	private String[] responseArray = new String[3];
	private String apiName;
	private String params;
	private String body;
	
	/**
	 * Method used to generate URL for apicall
	 * @param apiName - path to api
	 * @param params - parameters to be attached to request
	 * @return URL formed and to be used
	 */
	private String generateURL(String apiName, String params) {

		return AuthParams.getApiBaseURL()
				.concat(configParameters.getEndpointPort())
				.concat(configParameters.getBaseURL())
				.concat(AuthParams.getUserSystemKey())
				.concat(apiName)
				.concat("?" + params);
	}

	/**
	 * Method used to Calls HTTP Get request
	 * @param apiName
	 * @param params
	 * @return String[] containing responseCode, responseMessage and response object
	 */
	private Object get() {
		AuthParams.setRegistryCredentials();
		try {
			String finalURL = generateURL(apiName, params);
			System.out.println(finalURL);
			URL obj = new URL(finalURL);
			SetHttpConnection setCon = new SetHttpConnection();
			HttpsURLConnection con = setCon.getConnection(obj);
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, AuthParams.getUserToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_GET);
			StringBuilder response = new StringBuilder();
			responseArray[0] = String.valueOf(con.getResponseCode());
			responseArray[1] = con.getResponseMessage();
			BufferedReader in = null;
			if (con.getErrorStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else if (con.getInputStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			String responseMessage = "";
			if (in != null) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				responseMessage = response.toString();
				responseArray[2] = responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseArray;
	}


	/**
	 * Method used to call HTTP Post request
	 * @param apiName
	 * @param params
	 * @param body
	 * @return String[] containing responseCode, responseMessage and response object
	 */
	public Object post() {
		AuthParams.setRegistryCredentials();

		try {
			String finalURL = generateURL(apiName, params);
			System.out.println(finalURL);
			URL obj = new URL(finalURL);
			SetHttpConnection setCon = new SetHttpConnection();
			HttpsURLConnection con = setCon.getConnection(obj);
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, AuthParams.getUserToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_POST);
			con.setDoOutput(true);
			StringBuilder response = new StringBuilder();
			OutputStream os = con.getOutputStream();
			byte[] input = body.getBytes(Constants.UTF8);
			os.write(input, 0, input.length);
			os.flush();
			responseArray[0] = String.valueOf(con.getResponseCode());
			responseArray[1] = con.getResponseMessage();
			BufferedReader in = null;
			if (con.getErrorStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else if (con.getInputStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			String responseMessage = "";
			if (in != null) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				responseMessage = response.toString();
				responseArray[2] = responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseArray;
	}
	

	/**
	 * Method used to call HTTP delete request
	 * @param apiName
	 * @param params
	 * @return String[] containing responseCode, responseMessage and response object
	 */
	public Object delete() {
		AuthParams.setRegistryCredentials();
		try {
			String finalURL = generateURL(apiName, params);
			System.out.println(finalURL);
			URL obj = new URL(finalURL);
			SetHttpConnection setCon = new SetHttpConnection();
			HttpsURLConnection con = setCon.getConnection(obj);
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, AuthParams.getUserToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_DELETE);
			StringBuilder response = new StringBuilder();
			responseArray[0] = String.valueOf(con.getResponseCode());
			responseArray[1] = con.getResponseMessage();
			BufferedReader in = null;
			if (con.getErrorStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else if (con.getInputStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			String responseMessage = "";
			if (in != null) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				responseMessage = response.toString();
				responseArray[2] = responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseArray;
	}
	
	/**
	 * Method used to call HTTP Patch request
	 * @param apiName
	 * @param params
	 * @param body
	 * @return String[] Object containing responseCode, responseMessage and response object
	 */
	public Object update() {
		AuthParams.setRegistryCredentials();

		try {
			String finalURL = generateURL(apiName, params);
			System.out.println(finalURL);
			URL obj = new URL(finalURL);
			SetHttpConnection setCon = new SetHttpConnection();
			HttpsURLConnection con = setCon.getConnection(obj);
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, AuthParams.getUserToken());
			con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY,
					Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
			con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_POST);
			con.setRequestProperty("X-HTTP-Method-Override", Constants.HTTP_REQUEST_METHOD_TYPE_PATCH);
			con.setDoOutput(true);
			StringBuilder response = new StringBuilder();
			OutputStream os = con.getOutputStream();
			byte[] input = body.getBytes(Constants.UTF8);
			os.write(input, 0, input.length);
			os.flush();
			responseArray[0] = String.valueOf(con.getResponseCode());
			responseArray[1] = con.getResponseMessage();
			BufferedReader in = null;
			if (con.getErrorStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			} else if (con.getInputStream() != null) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			String responseMessage = "";
			if (in != null) {
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				responseMessage = response.toString();
				responseArray[2] = responseMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return responseArray;
	}	
	private Future<Object> getObjectAsync() {
		return CompletableFuture.supplyAsync(this::get);
	}

	public String[] asyncGet(String apiName,String params) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		Future<Object> future = getObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}
	
	private Future<Object> createObjectAsync() {
		return CompletableFuture.supplyAsync(this::post);
	}

	public String[] asyncCreate(String apiName,String params,String body) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = createObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

	private Future<Object> bindDeviceToGatewayObjectAsync() {
		return CompletableFuture.supplyAsync(this::post);
	}

	public String[] asyncBindDeviceToGateway(String apiName,String params,String body) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = bindDeviceToGatewayObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

	private Future<Object> unBindDeviceFromGatewayObjectAsync() {
		return CompletableFuture.supplyAsync(this::post);
	}

	public String[] asyncUnbindDeviceFromGateway(String apiName, String params, String body)
			throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = unBindDeviceFromGatewayObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

	private Future<Object> sendCommandToDeviceAsync() {
		return CompletableFuture.supplyAsync(this::post);
	}

	public String[] asyncSendCommandToDevice(String apiName, String params, String body) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = sendCommandToDeviceAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

	private Future<Object> modifyCloudToDeviceConfigAsync() {
		return CompletableFuture.supplyAsync(this::post);
	}

	public String[] asyncModifyCloudToDeviceConfig(String apiName, String params, String body)
			throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = modifyCloudToDeviceConfigAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

	private Future<Object> listDeviceStatesAsync() {
		return CompletableFuture.supplyAsync(this::get);
	}

	public String[] asyncListDeviceStates(String apiName, String params)
			throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		Future<Object> future = listDeviceStatesAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}
	private Future<Object> deleteObjectAsync() {
		return CompletableFuture.supplyAsync(this::delete);
	}

	public String[] asyncDelete(String apiName,String params) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		Future<Object> future = deleteObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}
	
	private Future<Object> updateObjectAsync() {
		return CompletableFuture.supplyAsync(this::update);
	}

	public String[] asyncUpdate(String apiName,String params,String body) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		this.body = body;
		Future<Object> future = updateObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}
	private Future<Object> listObjectAsync() {
		return CompletableFuture.supplyAsync(this::get);
	}

	public String[] asyncListDevices(String apiName,String params) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		Future<Object> future = listObjectAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}

//Registry Apis
	/**
	 * Method used to generate URL for apicall
	 * @param apiName - path to api
	 * @param params - parameters to be attached to request
	 * @return URL formed and to be used
	 */
	private String generateAdminURL(String apiName, String params) {

		return AuthParams.getBaseURL()
	  					 .concat(configParameters.getBaseURL())
	  					 .concat(AuthParams.getUserSystemKey())
	  					 .concat(apiName)
	  					 .concat("?"+params);
	}
	/**
	 * Method used to Calls HTTP Get request
	 * @param apiName
	 * @param params
	 * @return String[] containing responseCode, responseMessage and response object
	 */
	public Object getRegistry() {
		AuthParams.setRegistryCredentials();
		try {
		String finalURL = generateAdminURL(apiName, params);
		System.out.println(finalURL);
		URL obj = new URL(finalURL);
		SetHttpConnection setCon = new SetHttpConnection();
		HttpsURLConnection con = setCon.getConnection(obj);
		con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_TOKEN_KEY, AuthParams.getUserToken());
		con.setRequestProperty(Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_KEY, Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
		con.addRequestProperty(Constants.HTTP_REQUEST_PROPERTY_ACCEPT_KEY, Constants.HTTP_REQUEST_PROPERTY_CONTENT_TYPE_ACCEPT_VALUE);
		con.setRequestMethod(Constants.HTTP_REQUEST_METHOD_TYPE_GET);
		StringBuilder response = new StringBuilder();
		responseArray[0] = String.valueOf(con.getResponseCode()); 
		responseArray[1] = con.getResponseMessage(); 
		BufferedReader in = null;
		if (con.getErrorStream() != null) {
			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		} else if (con.getInputStream() != null) {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}
		String inputLine;
		String responseMessage = "";
		if (in != null) {
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			responseMessage = response.toString();
			responseArray[2] = responseMessage; 
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseArray;
	}
	
	private Future<Object> getRegistryAsync() {
		return CompletableFuture.supplyAsync(this::getRegistry);
	}

	public String[] asyncGetRegistry(String apiName,String params) throws InterruptedException {
		this.apiName = apiName;
		this.params = params;
		Future<Object> future = getRegistryAsync();
		try {
			future.get(15000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return responseArray;
	}


}
