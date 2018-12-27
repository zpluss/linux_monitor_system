package com.hzsr.ssm.mweb.activemq.service;

import com.hzsr.ssm.mweb.monitor.domain.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

@Service
@Configuration
public class MessageProducerServiceImpl implements MessageProducerService
{
    @Resource
    private JmsTemplate jmsTemplate;
    
    @Resource
    private Queue queue;
    
    @Resource
    private Disk disk;
    
    @Resource
    private Memory memory;        
    
    @Resource
    private Cpu cpu;
     
    @Resource
    private Procezz procezz;
    
    @Resource
    private Systmm systmm;
    
    @Value("${company.code}")
    private String companyCode;
    
    private Map<String,Object> map=new HashMap<>();

    @Override
    public void sendMessage()
    {
        map.put("Company_Code",companyCode);
        map.put("Disk",disk.toString());
        map.put("Memory",memory.toString());
        map.put("Cpu",cpu.toString());
        map.put("Process",procezz.getProcezzList());
        map.put("System",systmm.toString());
        this.jmsTemplate.convertAndSend(this.queue,map);
    }
}