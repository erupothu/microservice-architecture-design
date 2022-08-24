package com.example.aws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {
    private int poolSize = 100;

    @Bean(name = "threadPoolQueue")
    public ThreadPoolTaskExecutor threadPoolBillGenerationQueue() {
        ThreadPoolTaskExecutor executor = new   ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(poolSize);
        executor.setQueueCapacity(0);
        executor.setRejectedExecutionHandler(new BlockingTaskSubmissionPolicy(1000));
        return executor;
    }
}
