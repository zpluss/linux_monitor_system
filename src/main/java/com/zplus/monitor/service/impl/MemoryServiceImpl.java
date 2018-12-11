package com.zplus.monitor.service.impl;

import com.sun.management.OperatingSystemMXBean;
import com.zplus.monitor.domain.Memory;
import com.zplus.monitor.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;

@Service
public class MemoryServiceImpl implements MemoryService
{
    private final Memory memory;

    @Autowired
    public MemoryServiceImpl(Memory memory)
    {
        this.memory = memory;
    }

    @Override
    public Memory getMemoryInfo() throws Exception
    {
        double kb=1024;
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        // 操作系统
        String osName = System.getProperty("os.name");
        // 总的物理内存
        long memoryCapacity = osmxb.getTotalPhysicalMemorySize() ;
        // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
        // 已使用的物理内存
        long memoryUsage = (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize());
        //内存使用率
        double memoryUsageRate= (double)memoryUsage/memoryCapacity;
        
        memory.setMemoryCapacity(memoryCapacity/1024.0/1024.0/1024.0+"");
        memory.setMemoryUsage(memoryUsage/1024.0/1024.0/1024.0+"");
        memory.setMemoryUsageRate(memoryUsageRate+"");
        return memory;
    }
}