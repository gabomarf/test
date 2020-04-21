package com.test.test.config;

public final class EndPoint {

	public final static String API = "/api";
	public final static String V1 = "/v1";
	
	public final static String REGION = "/region";
	public final static String COMUNA = "/comuna";
		
	private EndPoint() {
		throw new AssertionError("Error, private construct (not possible init construct)");
	}
}
