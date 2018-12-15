package com.zplus.monitor.service.impl;

import com.zplus.monitor.domain.Cpu;
import com.zplus.monitor.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.StringTokenizer;

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
        Runtime rt = Runtime.getRuntime();
        String str,t;
        Process p=null;
        BufferedReader br=null;
        File file;
        StringTokenizer tokenizer;
        
        //从cpuinfo文件中获取cpu型号和核数
        file=new File("/proc/cpuinfo");
        try
        {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            while ((str = br.readLine()) != null)
            {
                tokenizer = new StringTokenizer(str, ":\n");
                if (!tokenizer.hasMoreTokens())
                    continue;
                str = tokenizer.nextToken().trim();
                if (str.equalsIgnoreCase("model name"))
                {
                    t = tokenizer.nextToken().trim();
                    cpu.setCpuModel(t);
                    continue;
                }
                if (str.equalsIgnoreCase("cpu cores"))
                {
                    cpu.setCpuCoreNumber(tokenizer.nextToken().trim());
                    break;
                }
            }
            
            //命令为退出前打印一次
            p = rt.exec("top -b -n 1");// 调用系统的“top"命令
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int m=0;

            while ((str = br.readLine()) != null&&m==0)
            {
                //把str分割成数组，默认分隔符为 \t\n\r\f，前有一个空格
                tokenizer = new StringTokenizer(str," %,");
                while (tokenizer.hasMoreTokens())
                {
                    str = tokenizer.nextToken();
                    if (str.equalsIgnoreCase("ni")&&++m==1)
                    {
                        cpu.setCpuUsageRate(100.0 - Double.parseDouble(tokenizer.nextToken()) + "");
                        break;
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(br!=null)
                br.close();
        }

        //获取jvm可调用的处理器数量，这里当作cpu个数
        cpu.setCpuNumber(rt.availableProcessors() + "");

        return cpu;
    }
}
