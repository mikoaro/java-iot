package com.clearblade.cloud.iot.v1;

import com.clearblade.cloud.iot.v1.utils.DeviceName;

final class SendCommandToDeviceRequest {
		
		private final DeviceName name;
		private final String binaryData;
		
		private SendCommandToDeviceRequest(Builder builder){
		        this.name = builder.name;
		        this.binaryData = builder.binaryData;
		}	

		// Static class Builder
		public static class Builder {

			/// instance fields
			private DeviceName name;
			private String binaryData;

			public static Builder newBuilder()
			{
				return new Builder();
			}

			private Builder() {}

			// Setter methods
			public Builder setName(DeviceName name)
			{
				this.name = name;
				return this;
			}
			public Builder setBinaryData(String binaryData)
			{
				this.binaryData = binaryData;
				return this;
			}

			// build method to deal with outer class
			// to return outer instance
			public SendCommandToDeviceRequest build()
			{
				return new SendCommandToDeviceRequest(this);
			}
		}

		@Override
		public String toString()
		{
			return "name = " + this.name.getDevice() + ", binaryData = " + this.binaryData;
		}
	}

