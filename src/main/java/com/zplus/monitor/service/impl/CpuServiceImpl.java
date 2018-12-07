package com.zplus.monitor.service.impl;

import com.zplus.monitor.domain.Cpu;
import com.zplus.monitor.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CpuServiceImpl implements CpuService
{
    private final Cpu cpu;

    @Autowired
    public CpuServiceImpl(Cpu cpu)
    {
        this.cpu = cpu;
    }

    @Override
    public Cpu getCpuInfo() throws Exception
    {
        Map<String,String> map=new HashMap<>();
        Runtime rt = Runtime.getRuntime();
        String str,t;
        Process p;
        List<String> strArray = new ArrayList<>();
        BufferedReader br;
        File file;
        StringTokenizer tokenizer;
        
        file=new File("/proc/cpuinfo");
        br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((str = br.readLine()) != null )
        {
            tokenizer = new StringTokenizer(str,":\n");
            if (!tokenizer.hasMoreTokens())
                continue;
            str = tokenizer.nextToken().trim();
            if (str.equalsIgnoreCase("model name"))
            {
                t = tokenizer.nextToken().trim();
                cpu.setCpuModel(t);
                continue;
            }
            if(str.equalsIgnoreCase("cpu cores"))
            {
                cpu.setCpuCoreNumber(tokenizer.nextToken().trim());
                break;
            }
        }
        
        cpu.setCpuNumber(rt.availableProcessors()+"");
        

        //String str;
        p = rt.exec("top -b -n 1");// 调用系统的“top"命令
        try
        {
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((str = br.readLine()) != null )
            {
                tokenizer = new StringTokenizer(str);
                while(tokenizer.hasMoreTokens())
                {
                    str=tokenizer.nextToken();
                    if(str.equalsIgnoreCase("ni,"))
                    {
                        cpu.setCpuUsageRate(100.0-Double.parseDouble(tokenizer.nextToken())+"");
                        break;
                    }
                }
            }
        }catch (Exception e)
        {
            
        }
        
        
        return cpu;
    }
}
