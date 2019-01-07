package com.ihzsr.monitor.jar.service.impl;


import com.ihzsr.monitor.jar.domain.*;
import com.ihzsr.monitor.jar.service.*;
import com.ihzsr.monitor.jar.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Service
public class AsyncServiceImpl implements AsyncService
{

    private final DiskService diskService;

    private final CpuService cpuService;

    private final MemoryService memoryService;

    private final ProcezzService procezzService;

    private final SystmmService systmmService;

    //添加自定义线程池
    private final Executor executor;
    
    //读取properties中配置的url list
    @Value("${web.server.urlList}")
    private List<String> urlList=new ArrayList<>();

    @Autowired
    public AsyncServiceImpl(DiskService diskService, CpuService cpuService,
                            MemoryService memoryService, ProcezzService procezzService, 
                            SystmmService systmmService, 
                            @Qualifier(value = "getAsyncExecutor") Executor executor)
    {
        this.diskService = diskService;
        this.cpuService = cpuService;
        this.memoryService = memoryService;
        this.procezzService = procezzService;
        this.systmmService=systmmService;
        this.executor = executor;
    }
    
    @Override
    @Async
    public CompletableFuture<Cpu> doGetCpu() throws Exception
    {
        return CompletableFuture.completedFuture(cpuService.getCpuInfo());
    }

    @Override
    @Async
    public CompletableFuture<Disk> doGetDisk() throws Exception
    {
        return CompletableFuture.completedFuture(diskService.getDiskInfo());
    }

    @Override
    @Async
    public CompletableFuture<Memory> doGetMemory() throws Exception
    {
        return CompletableFuture.completedFuture(memoryService.getMemoryInfo());
    }

    @Override
    @Async
    public CompletableFuture<Procezz> doGetProcezz() throws Exception
    {
        return CompletableFuture.completedFuture(procezzService.getProcessInfo());
    }

    @Override
    @Async
    public CompletableFuture<Systmm> doGetSystmm() throws Exception
    {
        return CompletableFuture.completedFuture(systmmService.getSystemInfo());
    }
    
    @Override
    public Map<String, Object> doAsyncHttpGet() throws Exception
    {
        List<?> list=urlList.stream().map(a -> CompletableFuture.supplyAsync(() -> {
            Map<String,Object> map=new HashMap<>();
            map.put(a, HttpClientUtils.doGet(a));
            return map;
        },executor)).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());

        Map<String,Object> map=new HashMap<>();
        for(Object m:list)
            map.putAll((Map<? extends String, ?>) m);
        return map;
    }
}