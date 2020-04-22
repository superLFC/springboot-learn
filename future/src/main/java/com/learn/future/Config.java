package com.learn.future;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class Config {

    @Bean("threadPool")
    public ThreadPoolTaskExecutor getPool() {
        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setCorePoolSize(10);
        poolExecutor.setMaxPoolSize(20);
        poolExecutor.setKeepAliveSeconds(60000);
        poolExecutor.setThreadNamePrefix("custom_threadPool_");
        return poolExecutor;
    }
}
