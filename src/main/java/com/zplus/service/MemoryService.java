package com.ihzsr.monitor.jar.service;


import com.ihzsr.monitor.jar.domain.Memory;

public interface MemoryService
{
    Memory getMemoryInfo() throws Exception;
}
