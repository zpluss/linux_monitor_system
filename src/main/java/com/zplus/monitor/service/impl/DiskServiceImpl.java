package com.zplus.monitor.service.impl;

import com.zplus.monitor.domain.Disk;
import com.zplus.monitor.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class DiskServiceImpl implements DiskService
{
    private final Disk disk;

    @Autowired
    public DiskServiceImpl(Disk disk)
    {
        this.disk = disk;
    }

    @Override
    public Disk getDiskInfo() throws Exception
    {
        /*disk.setDiskCapacity("4G");
        disk.setDiskUsage("2G");
        disk.setDiskUsageRate("30%");*/
        try
        {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("df -hl");// df -hl 查看硬盘空间
            try (BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream())))
            {
                String str;
                String[] strArray = null;
                int line = 0;
                while ((str = in.readLine()) != null)
                {
                    if (++line != 2)
                        continue;
                    strArray = str.split("\\s+");
                }
                if(strArray!=null)
                {
                    disk.setDiskCapacity(strArray[1]);
                    disk.setDiskUsage(strArray[2]);
                    disk.setDiskUsageRate(strArray[4]);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                p.destroy();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return disk;
    }
}
