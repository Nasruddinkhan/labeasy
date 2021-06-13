package com.labeasy.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ScheduleEmailDto {
	@Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String subject;

    @NotEmpty
    private Map<String, Object> body;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private ZoneId timeZone;
    
    private String templateName;
}
