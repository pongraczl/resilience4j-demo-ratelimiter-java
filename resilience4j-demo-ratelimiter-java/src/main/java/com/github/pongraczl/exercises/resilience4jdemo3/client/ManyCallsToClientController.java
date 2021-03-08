package com.github.pongraczl.exercises.resilience4jdemo3.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyCallsToClientController {

	public static final String PATH_SLOW = "/SlowServiceCallsClientController";
	public static final String PATH_FAST = "/FastServiceCallsClientController";
	public static final String PATH_VERYFAST = "/VeryFastServiceCallsClientController";

	@Autowired
	private ClientServiceC clientServiceC2;
	

	@GetMapping(PATH_SLOW)
	public String getSlow() {
		return clientServiceC2.getResult("SLOW", 201);
	}
	
	@GetMapping(PATH_FAST)
	public String getFast() {
		return clientServiceC2.getResult("FAST", 101);
	}
	
	@GetMapping(PATH_VERYFAST)
	public String getVeryFast() {
		return clientServiceC2.getResult("VERY_FAST", 1);
	}

}
