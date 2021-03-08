package com.github.pongraczl.exercises.resilience4jdemo3.fakeremote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRemoteController {

	public static final String PATH = "/SimpleRemoteController";

	@Autowired
	private SimpleRemoteServiceA simpleRemoteServiceA;

	@GetMapping(PATH)
	public String getResult() {
		return simpleRemoteServiceA.getResult();
	}
}
