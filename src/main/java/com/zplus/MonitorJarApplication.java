package com.ihzsr.monitor.jar;

import com.ihzsr.monitor.jar.utils.Init;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class MonitorJarApplication implements CommandLineRunner
{
    @Value("${message.use.tool}")
    private String tool;

    public static void main( String[] args )
    {
        SpringApplication springApplication = new SpringApplication(MonitorJarApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        String path=System.getProperty("user.dir");
        File file=new File(path+"/config/application-config.properties");
        if(!file.exists())
        {
            System.out.println("正在创建配置文件......");
            Init.createProperties(file);
            System.out.println("配置文件已创建，要修改配置文件请重启");
            System.exit(0);
        }
    }
}