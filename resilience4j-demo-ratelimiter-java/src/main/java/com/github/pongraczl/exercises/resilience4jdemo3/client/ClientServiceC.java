package com.github.pongraczl.exercises.resilience4jdemo3.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pongraczl.exercises.resilience4jdemo3.GeneralService;

@Service
public class ClientServiceC implements GeneralService {

	private static final int REPEAT = 20;

	@Autowired
	private ClientServiceB clientServiceB;

	public String getResult(String title, int repetitionTimeInMillis) {
		List<String> results = new ArrayList<>();

		for (int i = 0; i < REPEAT; i++) {
			results.add(title + "-" + i + ": " + getResultFromServiceB(repetitionTimeInMillis));
		}

		return String.format("Originally waiting for %d responses. %s:<br>%s<br>--- END ---",
				REPEAT,
				GeneralService.super.getResult(),
				results.stream().collect(Collectors.joining("<br>")));
	}

	private String getResultFromServiceB(int repetitionTimeInMillis) {
		String result = clientServiceB.getResult();
		try {
			Thread.sleep(repetitionTimeInMillis);
		} catch (InterruptedException e) {
		}
		return result;
	}
}
