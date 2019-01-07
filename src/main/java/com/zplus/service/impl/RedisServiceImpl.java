package com.ihzsr.monitor.jar.service.impl;

import com.ihzsr.monitor.jar.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService
{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    
    @Value("${company.code}")
    private String companyCode;

    @Override
    public <K, V> void save(Map<K, V> map)
    {
        redisTemplate.opsForValue().set(companyCode,map,60*5,TimeUnit.SECONDS);
    }
}