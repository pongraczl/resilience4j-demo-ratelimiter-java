package com.github.pongraczl.exercises.resilience4jdemo3.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.pongraczl.exercises.resilience4jdemo3.GeneralService;
import com.github.pongraczl.exercises.resilience4jdemo3.fakeremote.SimpleRemoteController;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class ClientServiceB implements GeneralService {

	@Value("${server.port}")
	private String serverPort;

	@Override
	@RateLimiter(name = "serviceB", fallbackMethod = "fallBackOnFail")
	public String getResult() {
		RestTemplate restTemplate = new RestTemplate();
		String remoteResult = restTemplate.getForObject(getRemoteServicePath(), String.class);
		String ownResult = GeneralService.super.getResult();
		return ownResult + ": " + remoteResult;
	}

	private String getRemoteServicePath() {
		return "http://localhost:" + serverPort + SimpleRemoteController.PATH;
	}

	@SuppressWarnings("unused")
	private String fallBackOnFail(RequestNotPermitted e) {
		return "(Request not permitted: current thread was not able to acquire permission from RateLimiter)";
	}

	@SuppressWarnings("unused")
	private String fallBackOnFail(Exception e) {
		return "(No valid response)";
	}
}
