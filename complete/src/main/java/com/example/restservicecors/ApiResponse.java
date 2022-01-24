package com.example.restservicecors;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;

public class ApiResponse {
	
	public class Query {
		@JsonProperty("apikey")
	    private String apiKey;
		@JsonProperty("timestamp")
	    private int timestamp;
		@JsonProperty("base_currency")
	    private String baseCurrency;
		
		public String getApiKey() {
			return apiKey;
		}
		public int getTimestamp() {
			return timestamp;
		}
		public String getBaseCurrency() {
			return baseCurrency;
		}
	}
	
	@JsonProperty("query")
	private Query query;
	private HashMap<String, Double> data;
	
	public Query getQuery() {
		return query;
	}
	@JsonAnyGetter
	public HashMap<String, Double> getData() {
		return data;
	}
	public void setData(HashMap<String, Double> data) {
		this.data = data;
	}
	@JsonAnySetter
	public void putData(String key, Double value) {
		if (data == null) data = new HashMap<String, Double>();
        data.put(key, value);
	}
}
