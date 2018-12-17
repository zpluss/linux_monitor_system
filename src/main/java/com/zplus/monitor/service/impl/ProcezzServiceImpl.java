package com.zplus.monitor.service.impl;

import com.zplus.monitor.domain.Procezz;
import com.zplus.monitor.service.ProcezzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class ProcezzServiceImpl implements ProcezzService
{
    @Resource
    private Procezz procezz;
    
    @Override
    public Procezz getProcessInfo() throws Exception
    {
        String str;
        StringTokenizer tokenizer;
        List<Object> pList=new ArrayList<>();
        int l=0;
        Runtime rt=Runtime.getRuntime();
        Process p= rt.exec("ps -N au");
        try(BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream())))
        {
            while ((str = br.readLine()) != null)
            {
                if (++l == 1)
                    continue;
                else if (l == 12)
                    break;
                tokenizer = new StringTokenizer(str);
                if (!tokenizer.hasMoreTokens())
                    continue;
                str = tokenizer.nextToken();
                for (int i = 1; i <= 11; i++)
                {
                    switch (i)
                    {
                        case 1:
                            procezz.setProcezzUSER(str);
                            break;
                        case 2:
                            procezz.setProcezzPID(str);
                            break;
                        case 3:
                            procezz.setProcezzCPU(str);
                            break;
                        case 4:
                            procezz.setProcezzMEM(str);
                            break;
                        case 6:
                            procezz.setProcezzRSS(str);
                            break;
                        case 9:
                            procezz.setProcezzSTARTED(str);
                            break;
                        case 10:
                            procezz.setProcezzTIME(str);
                            break;
                        case 11:
                            procezz.setProcezzCOMMAND(str);
                            break;
                        default:
                            break;
                    }
                    if (tokenizer.hasMoreTokens())
                        str = tokenizer.nextToken();
                }
                //不能add(procezz)
                pList.add(procezz.toString());
            }
        }
        procezz.setProcezzList(pList);
        return procezz;
    }
}