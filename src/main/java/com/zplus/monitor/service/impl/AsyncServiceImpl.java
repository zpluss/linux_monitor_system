package com.zplus.monitor.service.impl;

import com.zplus.monitor.domain.*;
import com.zplus.monitor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncServiceImpl
{

    private final DiskService diskService;

    private final CpuService cpuService;

    private final MemoryService memoryService;

    private final ProcezzService procezzService;

    private final SystmmService systmmService;

    @Autowired
    public AsyncServiceImpl(DiskService diskService, CpuService cpuService,
                MemoryService memoryService, ProcezzService procezzService,SystmmService systmmService)
    {
        this.diskService = diskService;
        this.cpuService = cpuService;
        this.memoryService = memoryService;
        this.procezzService = procezzService;
        this.systmmService=systmmService;
    }
    
    @Async
    public CompletableFuture<Cpu> doGetCpu() throws Exception
    {
        return CompletableFuture.completedFuture(cpuService.getCpuInfo());
    }

    @Async
    public CompletableFuture<Disk> doGetDisk() throws Exception
    {
        return CompletableFuture.completedFuture(diskService.getDiskInfo());
    }

    @Async
    public CompletableFuture<Memory> doGetMemory() throws Exception
    {
        return CompletableFuture.completedFuture(memoryService.getMemoryInfo());
    }

    @Async
    public CompletableFuture<Procezz> doGetProcezz() throws Exception
    {
        return CompletableFuture.completedFuture(procezzService.getProcessInfo());
    }

    @Async
    public CompletableFuture<Systmm> doGetSystmm() throws Exception
    {
        return CompletableFuture.completedFuture(systmmService.getSystemInfo());
    }
}