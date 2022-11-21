package com.clearblade.cloud.iot.v1.utils;

public class RegistryCredential {

	private final PublicKeyCertificate publicKeyCertificate;
	public RegistryCredential() {
		publicKeyCertificate = null;
	}
	private RegistryCredential(Builder builder) {
		publicKeyCertificate = builder.getPublicKeyCertificate();
	}
	
	public static Builder newBuilder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}
	/**
	 * Builder for setting 
	 * RegistryCredential
	 */
	public static class Builder {
		private PublicKeyCertificate publicKeyCertificate;
		
		protected Builder() {
			
		}

		public PublicKeyCertificate getPublicKeyCertificate() {
			return publicKeyCertificate;
		}

		public Builder setPublicKeyCertificate(PublicKeyCertificate publicKeyCertificate) {
			this.publicKeyCertificate = publicKeyCertificate;
			return this;
		}
		
		private Builder(RegistryCredential registryCredential) {
			this.publicKeyCertificate = registryCredential.publicKeyCertificate;
		}
		
		public RegistryCredential build() {
			return new RegistryCredential(this);
		}
	}
		
	@Override
	public String toString() {
		return "PublicKeyCertificate="+this.publicKeyCertificate;
	}
		
		
		
		

}
