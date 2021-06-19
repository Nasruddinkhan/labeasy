package com.labeasy.utils;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.velocity.VelocityContext;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.job.EmailJob;

public interface CommonUtils {

	public static final int MAX_FAILED_ATTEMPTS = 3;
	public static final long LOCK_TIME_DURATION = 24 * 60 * 60 * 1000; // 24 hours
	public static final String SQL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	static Function<String, List<String>> removeFirstLastElementOnstring = str -> Arrays
			.asList(str.substring(1, str.length() - 1).split(",")).stream().map(String::trim)
			.collect(Collectors.toList());

	public static <T, U> List<U> transformGenricList(List<T> list, Function<T, U> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}

	public static LocalDate transformTheDateFormat(String date, DateTimeFormatter format,
			BiFunction<String, DateTimeFormatter, LocalDate> biFunction) {
		return biFunction.apply(date, format);
	}

	static Function<ScheduleEmailDto, JobDetail> buildJobDetail = (scheduleEmailRequest) -> {
		JobDataMap jobDataMap = new JobDataMap();
		jobDataMap.put("email", scheduleEmailRequest.getEmail());
		jobDataMap.put("subject", scheduleEmailRequest.getSubject());
		jobDataMap.put("body", scheduleEmailRequest.getBody());
		jobDataMap.put("template", scheduleEmailRequest.getTemplateName());
		return JobBuilder.newJob(EmailJob.class).withIdentity(UUID.randomUUID().toString(), "email-jobs")
				.withDescription("Send Email Job").usingJobData(jobDataMap).storeDurably().build();
	};
	
	static  BiFunction<JobDetail,ZonedDateTime,Trigger> buildJobTrigger = (JobDetail jobDetail, ZonedDateTime startAt) ->{
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    };
    
    static Function<Map<String, Object>, VelocityContext>  contextFunction =(Map<String, Object> model) -> {
		VelocityContext context = new VelocityContext();
		model.forEach((k, v) ->context.put(k, v));
		return context;
	};
}
