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

import com.labeasy.services.TaskService;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledFixedRate implements SchedulingConfigurer {

	private final TaskService taskService; 
	
	@Autowired
	public ScheduledFixedRate(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@Scheduled(cron = "30 * * * * *")
	public void scheduleFixedRateTaskAsync() throws InterruptedException {
		System.out.println("start");
		taskService.generateInvoice(); //change to facade design pattern
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
