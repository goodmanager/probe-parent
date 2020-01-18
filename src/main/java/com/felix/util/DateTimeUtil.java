package com.felix.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

import com.felix.util.constant.DateTimeUnit;

public class DateTimeUtil {

	/**
	 * 求结束时间和开始时间的差,单位为 TimeUnit
	 * 
	 * @param startTime
	 * @param endTime
	 * @param timeUnit
	 * @return
	 */
	public static int differWithTimeUnit(Date startTime, Date endTime, DateTimeUnit dateTimeUnit) {
		LocalDateTime startDateTime = new LocalDateTime(startTime.getTime());
		LocalDateTime endDateTime = new LocalDateTime(endTime.getTime());
		return differWithTimeUnit(startDateTime, endDateTime, dateTimeUnit);
	}

	/**
	 * 求结束时间和开始时间的差,单位为 TimeUnit
	 * 
	 * @param startTime
	 * @param endTime
	 * @param timeUnit
	 * @return
	 */
	public static int DifferWithTimeUnit(long startTime, long endTime, DateTimeUnit dateTimeUnit) {
		LocalDateTime startDateTime = new LocalDateTime(startTime);
		LocalDateTime endDateTime = new LocalDateTime(endTime);
		return differWithTimeUnit(startDateTime, endDateTime, dateTimeUnit);
	}

	/**
	 * 获取当前日期所在月的日期列表
	 * 
	 * @param date
	 * @return
	 */
	public static List<Date> getDaysOfMonth(Date date) {
		LocalDate currentDate = new LocalDate(date.getTime());
		return getDaysOfMonth(currentDate);
	}

	/**
	 * 获取当前日期所在月的日期列表
	 * 
	 * @param microsecond
	 * @return
	 */
	public static List<Date> getDaysOfMonth(long microsecond) {
		LocalDate currentDate = new LocalDate(microsecond);
		return getDaysOfMonth(currentDate);
	}

	private static int differWithTimeUnit(LocalDateTime startDateTime, LocalDateTime endDateTime,
			DateTimeUnit dateTimeUnit) {
		TimeUnit timeUnit = dateTimeUnit.getTimeUnit();
		if (timeUnit == TimeUnit.DAYS) {
			return Days.daysBetween(startDateTime, endDateTime).getDays();
		} else if (timeUnit == TimeUnit.MINUTES) {
			return Minutes.minutesBetween(startDateTime, endDateTime).getMinutes();
		} else if (timeUnit == TimeUnit.HOURS) {
			return Hours.hoursBetween(startDateTime, endDateTime).getHours();
		} else if (timeUnit == TimeUnit.SECONDS) {
			return Seconds.secondsBetween(startDateTime, endDateTime).getSeconds();
		} else if (dateTimeUnit == DateTimeUnit.YEARS) {
			return Years.yearsBetween(startDateTime, endDateTime).getYears();
		} else {
			return Months.monthsBetween(startDateTime, endDateTime).getMonths();
		}
	}

	private static List<Date> getDaysOfMonth(LocalDate currentDate) {
		List<Date> daysList = new ArrayList<>();
		int days = currentDate.getDayOfMonth();
		LocalDate localDate = currentDate.dayOfMonth().withMinimumValue();
		for (int i = 0; i < days; i++) {
			daysList.add(localDate.withDayOfMonth(i).toDate());
		}
		return daysList;
	}

}
