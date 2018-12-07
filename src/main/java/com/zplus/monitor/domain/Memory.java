package com.zplus.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Memory implements Serializable
{
    private static final long serialVersionUID = 8933363680362899276L;
    private String memoryCapacity;
    private String memoryUsage;
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"memoryCapacity\":\"").append(memoryCapacity).append('\"');
        sb.append(",\"memoryUsage\":\"").append(memoryUsage).append('\"');
        sb.append(",\"memoryUsageRate\":\"").append(memoryUsageRate).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /*@Override
    public String toString()
    {
        return "{" + "memoryCapacity=" + memoryCapacity 
                + ", memoryUsage=" + memoryUsage + ", memoryUsageRate=" + memoryUsageRate + "}";
    }*/
}
