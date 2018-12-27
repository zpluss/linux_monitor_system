package com.hzsr.ssm.mweb.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Systmm implements Serializable
{
    private static final long serialVersionUID = 787312026175736398L;
    //ip地址
    private String ipAddress;     //ifconfig -a
    //系统运行时间
    private String serverRuntime; //uptime
    //系统版本
    private String serverVersion; //cat /etc/redhat-release
    //系统1，5，15分钟平均负载
    private String loadAverage;

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public String getServerRuntime()
    {
        return serverRuntime;
    }

    public void setServerRuntime(String serverRuntime)
    {
        this.serverRuntime = serverRuntime;
    }

    public String getServerVersion()
    {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion)
    {
        this.serverVersion = serverVersion;
    }

    public String getLoadAverage()
    {
        return loadAverage;
    }

    public void setLoadAverage(String loadAverage)
    {
        this.loadAverage = loadAverage;
    }

    @Override
    public String toString()
    {
        return "{" + "\"ipAddress\":\"" + ipAddress + '\"' + ",\"serverRuntime\":\"" + serverRuntime + '\"' + ",\"serverVersion\":\"" + serverVersion + '\"' + ",\"loadAverage\":\"" + loadAverage + '\"' + '}';
    }
}