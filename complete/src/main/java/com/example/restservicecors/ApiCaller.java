package com.example.restservicecors;

import org.springframework.web.util.UriComponentsBuilder;
import java.net.URL;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiCaller {
	public static String apiJson(String baseCurrency) {
		String jsonResponse = null;
		try {
			String url = UriComponentsBuilder
				.fromUriString("https://api.currencyapi.com/v3/latest")
				.queryParam("apikey", "23c26c20-7484-11ec-b401-3fb2378995d2")
				.queryParam("base_currency", baseCurrency)
				.build().toString();
		    URL urlForGetRequest = new URL(url);
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();

		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = in.readLine()) != null) {
		            response.append(readLine);
		        }
		        in.close();
		        jsonResponse = response.toString();
		    } else {
		        throw new Exception("Error in API Call");
		    }
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return jsonResponse;
	}
	
	public static ApiResponse apiResponse(String baseCurrency) {
		String json = apiJson(baseCurrency);
		ObjectMapper om = new ObjectMapper();
		ApiResponse response = null;
		try {
			response = om.readValue(json, ApiResponse.class);
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return response;
	}
}
