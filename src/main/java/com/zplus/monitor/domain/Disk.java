package com.zplus.monitor.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class Disk implements Serializable
{
    private static final long serialVersionUID = 3152943094575723035L;
    private String diskCapacity;
    private String diskUsage;
    private String diskUsageRate;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"diskCapacity\":\"").append(diskCapacity).append('\"');
        sb.append(",\"diskUsage\":\"").append(diskUsage).append('\"');
        sb.append(",\"diskUsageRate\":\"").append(diskUsageRate).append('\"');
        sb.append('}');
        return sb.toString();
    }

    /*public String toString()
    {
        return "{" + "diskCapacity=" + diskCapacity 
                + ", diskUsage=" + diskUsage 
                + ", diskUsageRate=" + diskUsageRate  + "}";
        //return "diskCapacity:"+diskCapacity+",diskUsage:"+diskUsage+",diskUsageRate:"+diskUsageRate;
        *//*JSONObject jsonInfo = new JSONObject();
        try {
            jsonInfo.put("diskCapacity", this.diskCapacity);
            jsonInfo.put("diskUsage", this.diskUsage);
            jsonInfo.put("diskUsageRate", this.diskUsageRate);
            
        } catch (JSONException e) {}
        return jsonInfo.toString();*//*
    }*/

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
