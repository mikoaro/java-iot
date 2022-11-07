package com.clearblade.cloud.iot.v1.utils;

import java.nio.charset.StandardCharsets;

public class ByteString {

	private ByteString binaryData;
	private byte[] binaryDataArray;
	public static final byte[] EMPTY = new byte[0];

	public ByteString(String str) {
		this.setBinaryDataArray(str.getBytes(StandardCharsets.UTF_8));
	}

	public ByteString getBinaryData() {
		return binaryData;
	}

	public void setBinaryData(ByteString binaryData) {
		this.binaryData = binaryData;
	}

	public byte[] getBinaryDataArray() {
		return binaryDataArray;
	}

	public void setBinaryDataArray(byte[] binaryDataArray) {
		this.binaryDataArray = binaryDataArray;
	}

}
