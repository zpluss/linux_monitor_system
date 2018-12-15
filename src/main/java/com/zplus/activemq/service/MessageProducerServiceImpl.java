package com.zplus.activemq.service;

import com.zplus.monitor.domain.*;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.*;

@Service
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
    
    private Map<String,Object> map=new HashMap<>();

    @Override
    public void sendMessage()
    {
        map.put("Disk",disk.toString());
        map.put("Memory",memory.toString());
        map.put("Cpu",cpu.toString());
        map.put("Process",procezz.getProcezzList());
        map.put("System",systmm.toString());
        this.jmsTemplate.convertAndSend(this.queue,map);
    }
}