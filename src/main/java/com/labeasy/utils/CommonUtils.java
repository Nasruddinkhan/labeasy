package com.labeasy.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface CommonUtils {
	public static final int MAX_FAILED_ATTEMPTS = 3;
	public static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
	static Function<String, List<String>> removeFirstLastElementOnstring = str -> Arrays
			.asList(str.substring(1, str.length() - 1).split(",")).stream().map(String::trim).collect(Collectors.toList());

	public static <T, U> List<U> transformGenricList(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}
	
	public static LocalDate transformTheDateFormat( String date, DateTimeFormatter format,BiFunction<String, DateTimeFormatter, LocalDate> biFunction) {
		return biFunction.apply(date, format);
	}
}
