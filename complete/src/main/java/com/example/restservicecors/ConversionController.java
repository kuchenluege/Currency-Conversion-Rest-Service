package com.example.restservicecors;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/convert")
	public ConversionResult convert(@RequestParam String cur1, @RequestParam double val1, @RequestParam String cur2) {
		System.out.println("==== get result ====");
		return new ConversionResult(counter.incrementAndGet(), ConversionService.convertCurrency(cur1, val1, cur2));
	}
}
