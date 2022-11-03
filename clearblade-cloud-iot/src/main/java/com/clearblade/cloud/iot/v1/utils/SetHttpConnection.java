package com.clearblade.cloud.iot.v1.utils;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SetHttpConnection {
	public HttpsURLConnection con;
	
	public SetHttpConnection() {
	}
	
	public HttpsURLConnection getConnection(URL url) {
		try {
			con = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}
}
