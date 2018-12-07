package com.zplus.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class Procezz implements Serializable
{
    private static final long serialVersionUID = -268070216270352135L;
    //ps -N au top -b -n 1
    private String procezzUSER;
    private String procezzPID;
    private String procezzCPU;
    private String procezzMEM;
    private String procezzRSS;
    private String procezzSTARTED;
    private String procezzTIME;
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"procezzUSER\":\"").append(procezzUSER).append('\"');
        sb.append(",\"procezzPID\":\"").append(procezzPID).append('\"');
        sb.append(",\"procezzCPU\":\"").append(procezzCPU).append('\"');
        sb.append(",\"procezzMEM\":\"").append(procezzMEM).append('\"');
        sb.append(",\"procezzRSS\":\"").append(procezzRSS).append('\"');
        sb.append(",\"procezzSTARTED\":\"").append(procezzSTARTED).append('\"');
        sb.append(",\"procezzTIME\":\"").append(procezzTIME).append('\"');
        sb.append(",\"procezzCOMMAND\":\"").append(procezzCOMMAND).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /*@Override
    public String toString()
    {
        return "{" + "procezzUSER=" + procezzUSER  
                + ", procezzPID=" + procezzPID  
                + ", procezzCPU=" + procezzCPU
                + ", procezzMEM=" + procezzMEM 
                + ", procezzRSS=" + procezzRSS 
                + ", procezzSTARTED=" + procezzSTARTED 
                + ", procezzTIME=" + procezzTIME 
                + ", procezzCOMMAND=" + procezzCOMMAND + "}";
    }*/
}
