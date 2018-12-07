package com.zplus.monitor.service;

import com.zplus.monitor.domain.Cpu;

public interface CpuService
{
    Cpu getCpuInfo() throws Exception;
}
