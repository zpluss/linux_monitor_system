package com.hzsr.ssm.mweb.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class Procezz implements Serializable
{
    private static final long serialVersionUID = -268070216270352135L;
    //ps -N au top -b -n 1
    //进程用户
    private String procezzUSER;
    //进程PID
    private String procezzPID;
    //进程cpu使用率
    private String procezzCPU;
    //进程内存使用率
    private String procezzMEM;
    //进程使用内存大小
    private String procezzRSS;
    //进程开始日期
    private String procezzSTARTED;
    //进程运行时间
    private String procezzTIME;
    //进程位置
    private String procezzCOMMAND;
    
    private List<Object> procezzList;

    public String getProcezzUSER()
    {
        return procezzUSER;
    }

    public void setProcezzUSER(String procezzUSER)
    {
        this.procezzUSER = procezzUSER;
    }

    public String getProcezzPID()
    {
        return procezzPID;
    }

    public void setProcezzPID(String procezzPID)
    {
        this.procezzPID = procezzPID;
    }

    public String getProcezzCPU()
    {
        return procezzCPU;
    }

    public void setProcezzCPU(String procezzCPU)
    {
        this.procezzCPU = procezzCPU;
    }

    public String getProcezzRSS()
    {
        return procezzRSS;
    }

    public void setProcezzRSS(String procezzRSS)
    {
        this.procezzRSS = procezzRSS;
    }

    public String getProcezzSTARTED()
    {
        return procezzSTARTED;
    }

    public void setProcezzSTARTED(String procezzSTARTED)
    {
        this.procezzSTARTED = procezzSTARTED;
    }

    public String getProcezzTIME()
    {
        return procezzTIME;
    }

    public void setProcezzTIME(String procezzTIME)
    {
        this.procezzTIME = procezzTIME;
    }

    public String getProcezzCOMMAND()
    {
        return procezzCOMMAND;
    }

    public void setProcezzCOMMAND(String procezzCOMMAND)
    {
        this.procezzCOMMAND = procezzCOMMAND;
    }

    public String getProcezzMEM()
    {
        return procezzMEM;
    }

    public void setProcezzMEM(String procezzMEM)
    {
        this.procezzMEM = procezzMEM;
    }
    
    public List<Object> getProcezzList()
    {
        return procezzList;
    }

    public void setProcezzList(List<Object> procezzList)
    {
        this.procezzList = procezzList;
    }

    @Override
    public String toString()
    {
        return "{" + "\"procezzUSER\":\"" + procezzUSER + '\"' + ",\"procezzPID\":\"" + procezzPID + '\"' + ",\"procezzCPU\":\"" + procezzCPU + '\"' + ",\"procezzMEM\":\"" + procezzMEM + '\"' + ",\"procezzRSS\":\"" + procezzRSS + '\"' + ",\"procezzSTARTED\":\"" + procezzSTARTED + '\"' + ",\"procezzTIME\":\"" + procezzTIME + '\"' + ",\"procezzCOMMAND\":\"" + procezzCOMMAND + '\"' + '}';
    }
}
