package com.ihzsr.monitor.jar.utils;

import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
public class Init
{
    public static void createProperties(File file) throws IOException
    {
        File parentFile=file.getParentFile();
        if(!parentFile.exists())
            parentFile.mkdir();
        file.createNewFile();

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
        bos.write("\n#修改配置文件后请重启应用\n".getBytes());
        bos.write(("\n#activemq.broker.url:Activemq服务器url\n" +
                "#activemq.user:Activemq服务器管理用户名\n"+"#activemq.password:Activemq服务器管理密码\n").getBytes());
        bos.write("activemq.broker.url=tcp://test4.ihzsr.cn:61616\n".getBytes());
        bos.write("activemq.user=admin\n".getBytes());
        bos.write("activemq.password=admin\n".getBytes());
        bos.write("\n#monitor.*.schedule:定时任务的频率，cron表达式\n".getBytes());
        bos.write("monitor.server.schedule=2/2 * * * * ?\n".getBytes());
        bos.write("monitor.web.schedule=2 0/2 * * * ?\n".getBytes());
        bos.write("\n#company.code:公司代码\n".getBytes());
        bos.write("company.code=HZSR01\n".getBytes());
        bos.write("\n#message.use.tool:使用redis或activeMQ\n".getBytes());
        bos.write("message.use.tool=activeMQ\n".getBytes());
        bos.write("\n#需要监控的web应用的接口,用逗号隔开，换行在每行的最后添加一个反斜杠 \\,除了最后一行\n".getBytes());
        bos.write("web.server.urlList=http://srsm.ihzsr.cn/sql/message1,\\\nhttp://srsm.ihzsr.cn/sql/message2\n".getBytes());
        bos.close();
    }
}