package com.hzsr.ssm.mweb;

import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.Properties;

@Configuration
public class Init
{
    public static void createProperties(File file) throws IOException
    {
        File parentFile=file.getParentFile();
        if(!parentFile.exists())
            parentFile.mkdir();
        file.createNewFile();

        Properties properties=new Properties();
        properties.setProperty("activemq.broker.url","tcp://test4.ihzsr.cn:61616");
        properties.setProperty("activemq.user","admin");
        properties.setProperty("activemq.password","admin");
        properties.setProperty("activemq.queue.name","monitor.system.queue");
        properties.setProperty("task.schedule","0/2 * * * * ?");
        properties.setProperty("company.code","HZSR01");
        properties.store(new FileWriter(file),"config");
    }
}