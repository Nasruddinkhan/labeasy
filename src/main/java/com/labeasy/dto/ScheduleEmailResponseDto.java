package com.labeasy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
public class ScheduleEmailResponseDto {
	private boolean success;
	private String jobId;
	private String jobGroup;
	private String message;

	public ScheduleEmailResponseDto(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ScheduleEmailResponseDto(boolean success, String jobId, String jobGroup, String message) {
		this.success = success;
		this.jobId = jobId;
		this.jobGroup = jobGroup;
		this.message = message;
	}

}
