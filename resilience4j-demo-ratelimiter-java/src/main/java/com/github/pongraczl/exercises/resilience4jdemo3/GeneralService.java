package com.github.pongraczl.exercises.resilience4jdemo3;

public interface GeneralService {

	public default String getResult() {
		return String.format("Result of %s", this.getClass().getSimpleName());
	}
}
