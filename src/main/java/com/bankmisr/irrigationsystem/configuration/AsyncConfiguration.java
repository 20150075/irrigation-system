package com.bankmisr.irrigationsystem.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {
	@Value("${poolSize}")
	private int poolSize;
	@Value("${maxPoolSize}")
	private int maxPoolSize;
	@Value("${queueCapacity}")
	private int queueCapacity;
	private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfiguration.class);

	@Bean(name = "taskExecutor")
	public Executor taskExecutor() {
		LOGGER.debug("Creating Async Task Executor");
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(poolSize);
		executor.setMaxPoolSize(maxPoolSize);
		executor.setQueueCapacity(queueCapacity);
		executor.setThreadNamePrefix("PlotThread-");
		executor.initialize();
		return executor;
	}

}
