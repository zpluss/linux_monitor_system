package com.ihzsr.monitor.jar.service;


import com.ihzsr.monitor.jar.domain.Cpu;

public interface CpuService
{
    Cpu getCpuInfo() throws Exception;
}
