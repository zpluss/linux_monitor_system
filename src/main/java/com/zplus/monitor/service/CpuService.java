package com.hzsr.ssm.mweb.monitor.service;

import com.hzsr.ssm.mweb.monitor.domain.Cpu;

public interface CpuService
{
    Cpu getCpuInfo() throws Exception;
}
