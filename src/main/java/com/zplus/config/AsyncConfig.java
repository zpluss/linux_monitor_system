package com.ihzsr.monitor.jar.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootConfiguration
public class AsyncConfig implements AsyncConfigurer
{
    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    @Override
    @Bean
    public Executor getAsyncExecutor()
    {
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(2*corePoolSize+1);
        taskExecutor.setQueueCapacity(200);
        taskExecutor.setKeepAliveSeconds(300);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler()
    {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    //重要
    //能正确打印配置文件中的集合
    @Bean public ConversionService conversionService() {
        return new DefaultConversionService();
    }
}
