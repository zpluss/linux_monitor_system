package com.hzsr.ssm.mweb.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Memory implements Serializable
{
    private static final long serialVersionUID = 8933363680362899276L;
    //内存大小
    private String memoryCapacity;
    //内存使用大小
    private String memoryUsage;
    //内存使用率
    private String memoryUsageRate;

    public String getMemoryUsageRate()
    {
        return memoryUsageRate;
    }

    public void setMemoryUsageRate(String memoryUsageRate)
    {
        this.memoryUsageRate = memoryUsageRate;
    }

    public String getMemoryCapacity()
    {
        return memoryCapacity;
    }

    public void setMemoryCapacity(String memoryCapacity)
    {
        this.memoryCapacity = memoryCapacity;
    }

    public String getMemoryUsage()
    {
        return memoryUsage;
    }

    public void setMemoryUsage(String memoryUsage)
    {
        this.memoryUsage = memoryUsage;
    }

    @Override
    public String toString()
    {
        return "{" + "\"memoryCapacity\":\"" + memoryCapacity + '\"' + ",\"memoryUsage\":\"" + memoryUsage + '\"' + ",\"memoryUsageRate\":\"" + memoryUsageRate + '\"' + '}';
    }
}
