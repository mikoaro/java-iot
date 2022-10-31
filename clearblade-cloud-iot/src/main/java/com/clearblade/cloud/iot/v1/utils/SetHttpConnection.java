package com.clearblade.cloud.iot.v1.utils;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SetHttpConnection {
	private static HttpsURLConnection con;
	
	private SetHttpConnection() {
	}
	
	public static HttpsURLConnection getConnection(URL url) {
		if(SetHttpConnection.con != null) {
			return SetHttpConnection.con;
		}else {
			try {
				con = (HttpsURLConnection) url.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return con;
		}
	}
}
