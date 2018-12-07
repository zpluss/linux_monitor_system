package com.zplus.monitor.service;

import com.zplus.monitor.domain.Memory;

public interface MemoryService
{
    Memory getMemoryInfo() throws Exception;
}
