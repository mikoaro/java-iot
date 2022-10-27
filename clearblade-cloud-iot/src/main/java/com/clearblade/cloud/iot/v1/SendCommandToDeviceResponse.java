package com.clearblade.cloud.iot.v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import com.clearblade.cloud.iot.v1.utils.Constants;

public class SendCommandToDeviceResponse {

	private final SendCommandToDeviceRequest request;
	private int httpStatusCode;
	private String httpStatusResponse;
	private Constants constants;

	protected SendCommandToDeviceResponse(Builder builder) {
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
		private SendCommandToDeviceRequest request;

		public static Builder newBuilder() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setSendCommandToDeviceRequest(SendCommandToDeviceRequest request) {
			this.request = request;
			return this;
		}

		// build method to deal with outer class
		// to return outer instance
		public SendCommandToDeviceResponse build() {
			return new SendCommandToDeviceResponse(this);
		}
	}
	
	public void init() {
		constants = new Constants();
	}
	
	public void processRequest() {
		init();
		try {
			String params = "?name=" + constants.getBuilder().getDevice() + "&method=" + constants.getMethodName();
			URL obj = new URL("https://" + constants.getEndPoint() + constants.getPath() + constants.getSystemKey()
					+ "/cloudiot_devices" + params);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("POST");

			String cBTOken = constants.getToken();
			con.setRequestProperty("ClearBlade-UserToken", cBTOken);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Accept", "application/json");

			String jsonInputString = "{\"binaryData\": \"c2VuZEZ1bm55TWVzc2FnZVRvRGV2aWNl\"}";

			con.setDoOutput(true);
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);

				int responseCode = con.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					this.setHttpStatusCode(responseCode);
					this.setHttpStatusResponse("HTTP_OK");
					// success
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuilder response = new StringBuilder();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
				} else {
					System.out.println("POST request not worked");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "Http Status Code :: " + this.getHttpStatusCode() + " Http Status Response :: "
				+ this.getHttpStatusResponse();
	}
}
