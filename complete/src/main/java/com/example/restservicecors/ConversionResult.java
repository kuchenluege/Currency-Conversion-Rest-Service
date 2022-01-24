package com.example.restservicecors;

public class ConversionResult {

	private final long id;
	private final String result;

	public ConversionResult() {
		this.id = -1;
		this.result = "";
	}

	public ConversionResult(long id, String result) {
		this.id = id;
		this.result = result;
	}

	public long getId() {
		return id;
	}
	
	public String getResult() {
		return result;
	}
}