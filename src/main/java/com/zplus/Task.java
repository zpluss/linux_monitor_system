package com.zplus;

import com.zplus.activemq.service.MessageProducerService;
import com.zplus.monitor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task
{
    private final DiskService diskService;
    
    private final CpuService cpuService;
    
    private final MemoryService memoryService;
    
    private final ProcezzService procezzService;
    
    private final MessageProducerService messageProducerService;
    
    private final SystmmService systmmService;
    
    @Autowired
    public Task(DiskService diskService, CpuService cpuService, 
                MemoryService memoryService, ProcezzService procezzService, 
                MessageProducerService messageProducerService,SystmmService systmmService)
    {
        this.diskService = diskService;
        this.cpuService = cpuService;
        this.memoryService = memoryService;
        this.procezzService = procezzService;
        this.messageProducerService = messageProducerService;
        this.systmmService=systmmService;
    }

    @Scheduled(fixedRate = 2000)
    public void startTask() throws Exception
    {
        diskService.getDiskInfo();
        memoryService.getMemoryInfo();
        cpuService.getCpuInfo();
        procezzService.getProcessInfo();
        systmmService.getSystemInfo();
        this.messageProducerService.sendMessage();
    }
}
