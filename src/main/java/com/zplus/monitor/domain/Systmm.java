package com.zplus.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Systmm implements Serializable
{
    private static final long serialVersionUID = 787312026175736398L;
    private String ipAddress;     //ifconfig -a
    private String serverRuntime; //uptime
    private String serverVersion; //cat /etc/redhat-release
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"ipAddress\":\"").append(ipAddress).append('\"');
        sb.append(",\"serverRuntime\":\"").append(serverRuntime).append('\"');
        sb.append(",\"serverVersion\":\"").append(serverVersion).append('\"');
        sb.append(",\"loadAverage\":\"").append(loadAverage).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /*@Override
    public String toString()
    {
        return "{" + "ipAddress=" + ipAddress  
                + ", serverRuntime=" + serverRuntime 
                + ", serverVersion=" + serverVersion 
                + ", loadAverage=" + loadAverage + "}";
    }*/
}
