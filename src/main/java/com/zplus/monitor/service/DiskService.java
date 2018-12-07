package com.zplus.monitor.service;


import com.zplus.monitor.domain.Disk;

public interface DiskService
{
    Disk getDiskInfo() throws Exception;
}
