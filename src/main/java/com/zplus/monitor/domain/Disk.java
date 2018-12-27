package com.hzsr.ssm.mweb.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Disk implements Serializable
{
    private static final long serialVersionUID = 3152943094575723035L;
    //磁盘容量
    private String diskCapacity;
    //磁盘使用大小
    private String diskUsage;
    //磁盘使用率
    private String diskUsageRate;

    @Override
    public String toString()
    {
        return "{" + "\"diskCapacity\":\"" + diskCapacity + '\"' + ",\"diskUsage\":\"" + diskUsage + '\"' + ",\"diskUsageRate\":\"" + diskUsageRate + '\"' + '}';
    }

    public String getDiskCapacity()
    {
        return diskCapacity;
    }

    public void setDiskCapacity(String diskCapacity)
    {
        this.diskCapacity = diskCapacity;
    }

    public String getDiskUsage()
    {
        return diskUsage;
    }

    public void setDiskUsage(String diskUsage)
    {
        this.diskUsage = diskUsage;
    }

    public String getDiskUsageRate()
    {
        return diskUsageRate;
    }

    public void setDiskUsageRate(String diskUsageRate)
    {
        this.diskUsageRate = diskUsageRate;
    }
}
