package com.hzsr.ssm.mweb.monitor.service;

import com.hzsr.ssm.mweb.monitor.domain.Memory;

public interface MemoryService
{
    Memory getMemoryInfo() throws Exception;
}
