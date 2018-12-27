package com.hzsr.ssm.mweb.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Cpu implements Serializable
{

    private static final long serialVersionUID = 3843927512655788412L;
    //cpu型号
    private String cpuModel;
    //cpu个数
    private String cpuNumber;
    //cpu核数
    private String cpuCoreNumber;
    //cpu使用率
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
    
    @Override
    public String toString()
    {
        return "{" + "\"cpuModel\":\"" + cpuModel + '\"' + ",\"cpuNumber\":\"" + cpuNumber + '\"' + ",\"cpuCoreNumber\":\"" + cpuCoreNumber + '\"' + ",\"cpuUsageRate\":\"" + cpuUsageRate + '\"' + '}';
    }
}
