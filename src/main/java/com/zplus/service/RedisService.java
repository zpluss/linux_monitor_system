package com.ihzsr.monitor.jar.service;

import java.util.Map;

public interface RedisService
{
    <K,V> void save(Map<K, V> map);
}
