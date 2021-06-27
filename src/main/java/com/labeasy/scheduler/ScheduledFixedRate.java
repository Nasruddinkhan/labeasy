package com.labeasy.scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.labeasy.services.EmailTaskService;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledFixedRate implements SchedulingConfigurer {

	private final EmailTaskService emailTaskService; 
	
	@Autowired
	public ScheduledFixedRate(EmailTaskService emailTaskService) {
		super();
		this.emailTaskService = emailTaskService;
	}

	@Scheduled(cron = "30 * * * * *")
	public void scheduleFixedRateTaskAsync() throws InterruptedException {
		System.out.println("start");
		emailTaskService.startSendEmail(); //change to facade design pattern
		System.out.println("end "  + LocalDateTime.now());
		
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		System.out.println("ScheduledFixedRate.taskExecutor()");
		return Executors.newScheduledThreadPool(5);
	}
}
