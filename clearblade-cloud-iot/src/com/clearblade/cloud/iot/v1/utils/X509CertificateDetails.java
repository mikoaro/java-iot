package com.clearblade.cloud.iot.v1.utils;

import java.sql.Timestamp;

public class X509CertificateDetails {

	private String issuer;
	private String subject;
	private Timestamp startTime;
	private Timestamp expiryTime;
	private String signatureAlgorithm;
	private String publicKeyType;
	
	
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Timestamp expiryTime) {
		this.expiryTime = expiryTime;
	}
	public String getSignatureAlgorithm() {
		return signatureAlgorithm;
	}
	public void setSignatureAlgorithm(String signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}
	public String getPublicKeyType() {
		return publicKeyType;
	}
	public void setPublicKeyType(String publicKeyType) {
		this.publicKeyType = publicKeyType;
	}
	
	@Override
	public String toString() {
		return 	"Issuer= "+this.issuer+",Subject="+this.subject+",startTime="+this.startTime+",expiryTime="+this.expiryTime+",signatureAlgorithm="+this.signatureAlgorithm+",publicKeyType="+this.publicKeyType;
	}
	
}
