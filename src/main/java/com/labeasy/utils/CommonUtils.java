package com.labeasy.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface CommonUtils {
	static Function<String, List<String>> removeFirstLastElementOnstring = str -> Arrays
			.asList(str.substring(1, str.length() - 1).split(","));

	public static <T, U> List<U> transformGenricList(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}
}
