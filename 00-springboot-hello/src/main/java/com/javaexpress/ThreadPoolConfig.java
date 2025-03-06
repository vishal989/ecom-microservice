package com.javaexpress;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadPoolConfig {
	
    @Bean
    Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1); // Small thread pool
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(0); // Small queue to force exhaustion
        executor.setThreadNamePrefix("CustomExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); // Force rejection
        executor.initialize();
        return executor;
    }
}

