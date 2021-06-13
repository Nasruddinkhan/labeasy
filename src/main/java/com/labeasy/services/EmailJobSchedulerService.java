package com.labeasy.services;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.dto.ScheduleEmailResponseDto;
import com.labeasy.job.EmailJob;

@Component
public class EmailJobSchedulerService {
	private static final Logger logger = LoggerFactory.getLogger(EmailJobSchedulerService.class);

    @Autowired
    private Scheduler scheduler;

    
    public ScheduleEmailResponseDto scheduleEmail(ScheduleEmailDto scheduleEmailRequest) {
        try {
            ZonedDateTime dateTime = ZonedDateTime.of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());
            if(dateTime.isBefore(ZonedDateTime.now())) {
                ScheduleEmailResponseDto scheduleEmailResponse = new ScheduleEmailResponseDto(false,
                        "dateTime must be after current time");
                return scheduleEmailResponse;
            }

            JobDetail jobDetail = buildJobDetail(scheduleEmailRequest);
            Trigger trigger = buildJobTrigger(jobDetail, dateTime);
            scheduler.scheduleJob(jobDetail, trigger);

            ScheduleEmailResponseDto scheduleEmailResponse = new ScheduleEmailResponseDto(true,
                    jobDetail.getKey().getName(), jobDetail.getKey().getGroup(), "Email Scheduled Successfully!");
            return scheduleEmailResponse;
        } catch (SchedulerException ex) {
            logger.error("Error scheduling email", ex);

            ScheduleEmailResponseDto scheduleEmailResponse = new ScheduleEmailResponseDto(false,
                    "Error scheduling email. Please try later!");
            return scheduleEmailResponse;
        }
    }

    private JobDetail buildJobDetail(ScheduleEmailDto scheduleEmailRequest) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("email", scheduleEmailRequest.getEmail());
        jobDataMap.put("subject", scheduleEmailRequest.getSubject());
        jobDataMap.put("body", scheduleEmailRequest.getBody());
        jobDataMap.put("template", scheduleEmailRequest.getTemplateName());

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(UUID.randomUUID().toString(), "email-jobs")
                .withDescription("Send Email Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
