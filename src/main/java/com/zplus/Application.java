package com.hzsr.ssm.mweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner
{
    @Autowired
    private Task task;
    
    public static void main( String[] args )
    {
        SpringApplication springApplication = new SpringApplication(Application.class);
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
            Init.createProperties(file);
            System.out.println("配置文件已创建，要修改配置文件请重启");
        }
        else 
            task.startTask();
    }
}