package com.ihzsr.monitor.jar.service.impl;

import com.ihzsr.monitor.jar.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.Map;

@Service
@Configuration
public class MessageProducerServiceImpl implements MessageProducerService
{
    @Resource
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("ServerQueue")
    private Queue serverQueue;

    @Qualifier("WebQueue")
    @Autowired
    private Queue webQueue;

    @Override
    public void sendServerMessage(Map<String,Object> map)
    {
        this.jmsTemplate.convertAndSend(this.serverQueue,map);
    }

    @Override
    public void sendWebMessage(Map<String,Object> map)
    {
        this.jmsTemplate.convertAndSend(this.webQueue,map);
    }
}