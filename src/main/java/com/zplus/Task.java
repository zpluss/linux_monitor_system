package com.hzsr.ssm.mweb;

import com.hzsr.ssm.mweb.activemq.service.MessageProducerService;
import com.hzsr.ssm.mweb.monitor.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Configuration
public class Task
{
    private final MessageProducerService messageProducerService;
    
    private final AsyncServiceImpl asyncService;
    
    @Autowired
    public Task(
                MessageProducerService messageProducerService,AsyncServiceImpl asyncService)
    {
        this.messageProducerService = messageProducerService;
        this.asyncService=asyncService;
    }

    @Scheduled(cron = "${task.schedule}")
    public void startTask() throws Exception
    {
        CompletableFuture futureCpu=asyncService.doGetCpu();
        CompletableFuture futureDisk=asyncService.doGetDisk();
        CompletableFuture futureMem=asyncService.doGetMemory();
        CompletableFuture futureProcezz=asyncService.doGetProcezz();
        CompletableFuture futureSystmm=asyncService.doGetSystmm();
        CompletableFuture.allOf(futureCpu,futureDisk,futureMem,futureProcezz,futureSystmm).join();
        this.messageProducerService.sendMessage();
    }
}