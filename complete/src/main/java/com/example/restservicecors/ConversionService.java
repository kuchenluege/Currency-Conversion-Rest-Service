package com.example.restservicecors;

import java.util.HashMap;

public class ConversionService {
	public static String convertCurrency(String cur1, double val1, String cur2) {
		ApiResponse response = ApiCaller.apiResponse(cur1);
		HashMap<String, Double> rateMap = response.getData();
		double val2 = val1 * rateMap.get(cur2);
		return String.format("%.2f", val2);
	}
}
