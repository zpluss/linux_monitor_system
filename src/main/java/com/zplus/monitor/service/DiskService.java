package com.hzsr.ssm.mweb.monitor.service;


import com.hzsr.ssm.mweb.monitor.domain.Disk;

public interface DiskService
{
    Disk getDiskInfo() throws Exception;
}
