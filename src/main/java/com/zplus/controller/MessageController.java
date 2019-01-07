package com.ihzsr.monitor.jar.controller;

import com.ihzsr.monitor.jar.domain.*;
import com.ihzsr.monitor.jar.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Controller
public class MessageController
{
    @Resource
    private AsyncService asyncService;

    @Resource
    private Disk disk;

    @Resource
    private Memory memory;

    @Resource
    private Cpu cpu;

    @Resource
    private Procezz procezz;

    @Resource
    private Systmm systmm;

    @Value("${company.code}")
    private String companyCode;
    
    @Value("${message.use.tool}")
    private String messageTool;

    @Autowired
    private RedisService redisService;

    @Resource
    private MessageProducerService messageProducerService;

    private Map<String,Object> map;

    @Async
    @Scheduled(cron = "${monitor.server.schedule}")
    public void sendServerToMQ() throws Exception
    {
        CompletableFuture futureCpu=asyncService.doGetCpu();
        CompletableFuture futureDisk=asyncService.doGetDisk();
        CompletableFuture futureMem=asyncService.doGetMemory();
        CompletableFuture futureProcezz=asyncService.doGetProcezz();
        CompletableFuture futureSystmm=asyncService.doGetSystmm();
        CompletableFuture.allOf(futureCpu,futureDisk,futureMem,futureProcezz,futureSystmm).join();

        map=new HashMap<>();
        map.put("Company_Code",companyCode);
        map.put("Disk",disk.toString());
        map.put("Memory",memory.toString());
        map.put("Cpu",cpu.toString());
        map.put("Process",procezz.getProcezzList());
        map.put("System",systmm.toString());
        if(messageTool.equals("redis"))
            redisService.save(map);
        else
            messageProducerService.sendServerMessage(map);
    }

    @Async
    @Scheduled(cron = "${monitor.web.schedule}")
    public void sendWebToMQ() throws Exception
    {
        if(messageTool.equals("redis"))
            redisService.save(map);
        else
            messageProducerService.sendWebMessage(asyncService.doAsyncHttpGet());
    }
}