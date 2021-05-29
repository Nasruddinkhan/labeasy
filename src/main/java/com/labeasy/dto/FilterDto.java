package com.labeasy.dto;

import java.util.List;

import com.labeasy.enums.QueryOperator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterDto {
	private String field;
	private QueryOperator operator;
	private String value;
	private List<String> values;
}
