package com.felix.util.constant;

import java.util.concurrent.TimeUnit;

public enum DateTimeUnit {
	MONTHS, YEARS;

	private TimeUnit timeUnit;

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(TimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

}
