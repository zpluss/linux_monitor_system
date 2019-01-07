package com.ihzsr.monitor.jar.service;


import com.ihzsr.monitor.jar.domain.Disk;

public interface DiskService
{
    Disk getDiskInfo() throws Exception;
}
