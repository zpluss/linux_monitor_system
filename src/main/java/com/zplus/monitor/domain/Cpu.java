package com.zplus.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Cpu implements Serializable
{

    private static final long serialVersionUID = 3843927512655788412L;
    private String cpuModel;
    private String cpuNumber;
    private String cpuCoreNumber;
    private String cpuUsageRate;
    
    public String getCpuModel()
    {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel)
    {
        this.cpuModel = cpuModel;
    }

    public String getCpuNumber()
    {
        return cpuNumber;
    }

    public void setCpuNumber(String cpuNumber)
    {
        this.cpuNumber = cpuNumber;
    }

    public String getCpuCoreNumber()
    {
        return cpuCoreNumber;
    }

    public void setCpuCoreNumber(String cpuCoreNumber)
    {
        this.cpuCoreNumber = cpuCoreNumber;
    }

    public String getCpuUsageRate()
    {
        return cpuUsageRate;
    }

    public void setCpuUsageRate(String cpuUsageRate)
    {
        this.cpuUsageRate = cpuUsageRate;
    }

    /*@Override
    public String toString()
    {
        return "{" + "'cpuModel':'" + cpuModel +'\''  
                + ", 'cpuNumber':'" + cpuNumber +'\''
                + ", cpuCoreNumber=" + cpuCoreNumber +'\''
                + ", cpuUsageRate=" + cpuUsageRate  + "}";
    }*/

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"cpuModel\":\"").append(cpuModel).append('\"');
        sb.append(",\"cpuNumber\":\"").append(cpuNumber).append('\"');
        sb.append(",\"cpuCoreNumber\":\"").append(cpuCoreNumber).append('\"');
        sb.append(",\"cpuUsageRate\":\"").append(cpuUsageRate).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
