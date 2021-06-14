package com.labeasy.services;

import static com.labeasy.utils.CommonUtils.buildJobDetail;
import static com.labeasy.utils.CommonUtils.buildJobTrigger;

import java.time.ZonedDateTime;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.labeasy.dto.ScheduleEmailDto;
import com.labeasy.dto.ScheduleEmailResponseDto;

@Component
public class EmailJobSchedulerService {
	private static final Logger logger = LoggerFactory.getLogger(EmailJobSchedulerService.class);
    private final Scheduler scheduler;
    @Autowired
    public EmailJobSchedulerService(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}
	public ScheduleEmailResponseDto scheduleEmail(ScheduleEmailDto scheduleEmailRequest) {
        try {
            ZonedDateTime dateTime = ZonedDateTime.of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());
            if(dateTime.isBefore(ZonedDateTime.now())) {
                ScheduleEmailResponseDto scheduleEmailResponse = new ScheduleEmailResponseDto(false,
                        "dateTime must be after current time");
                return scheduleEmailResponse;
            }
            JobDetail jobDetail =  buildJobDetail.apply(scheduleEmailRequest);
            Trigger trigger = buildJobTrigger.apply(jobDetail, dateTime);
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
    
}
