package com.ihzsr.monitor.jar.service;


import com.ihzsr.monitor.jar.domain.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface AsyncService
{
    CompletableFuture<Cpu> doGetCpu() throws Exception;

    CompletableFuture<Disk> doGetDisk() throws Exception;

    CompletableFuture<Memory> doGetMemory() throws Exception;

    CompletableFuture<Procezz> doGetProcezz() throws Exception;

    CompletableFuture<Systmm> doGetSystmm() throws Exception;
    
    Map<String, Object> doAsyncHttpGet() throws Exception;
}
